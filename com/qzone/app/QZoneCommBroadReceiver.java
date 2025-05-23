package com.qzone.app;

import NS_UNDEAL_COUNT.count_info;
import PUSH_COMM_STRUCT.BinaryPushInfo;
import PUSH_UPDATE_FEEDS.PushUpdateFeeds;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Base64;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.EventSource;
import com.qzone.proxy.feedcomponent.FeedEnvImpl;
import com.qzone.proxy.feedcomponent.service.FeedIncrementalUpdateService;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.Inflater;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneCommBroadReceiver extends BroadcastReceiver {

    /* renamed from: b, reason: collision with root package name */
    private static volatile QZoneCommBroadReceiver f44432b;

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f44433c = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    private AtomicBoolean f44434a = new AtomicBoolean(false);

    QZoneCommBroadReceiver() {
    }

    public static synchronized QZoneCommBroadReceiver b() {
        QZoneCommBroadReceiver qZoneCommBroadReceiver;
        synchronized (QZoneCommBroadReceiver.class) {
            if (f44432b == null) {
                synchronized (f44433c) {
                    if (f44432b == null) {
                        f44432b = new QZoneCommBroadReceiver();
                    }
                }
            }
            qZoneCommBroadReceiver = f44432b;
        }
        return qZoneCommBroadReceiver;
    }

    private void d() {
        com.qzone.adapter.feedcomponent.i H = com.qzone.adapter.feedcomponent.i.H();
        if (H instanceof FeedEnvImpl) {
            ((FeedEnvImpl) H).Z2();
        }
    }

    public void a(Context context) {
        context.unregisterReceiver(this);
        this.f44434a.set(false);
    }

    public void e(Context context) {
        if (this.f44434a.compareAndSet(false, true)) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.qzone.push_feed_update");
            intentFilter.addAction("com.qzone.push_feed_unread");
            intentFilter.addAction("com.qzone.feed_theme_change");
            context.registerReceiver(this, intentFilter);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        byte[] byteArray;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        QZLog.i("QZoneCommBroadReceiver", "FeedUpdate: Qzone Push action:" + action);
        if (action.equals("com.qzone.push_feed_update")) {
            try {
                byte[] byteArrayExtra = intent.getByteArrayExtra("update_feeds_buffer");
                byte[] bArr = null;
                if (byteArrayExtra != null) {
                    BinaryPushInfo binaryPushInfo = (BinaryPushInfo) t5.b.b(BinaryPushInfo.class, byteArrayExtra);
                    long j3 = binaryPushInfo.compressType;
                    if (j3 == 0) {
                        byteArray = binaryPushInfo.pushBuffer;
                    } else if (j3 == 2) {
                        try {
                            Inflater inflater = new Inflater();
                            byte[] bArr2 = binaryPushInfo.pushBuffer;
                            inflater.setInput(bArr2, 0, bArr2.length);
                            byte[] bArr3 = new byte[4096];
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            while (!inflater.finished()) {
                                byteArrayOutputStream.write(bArr3, 0, inflater.inflate(bArr3));
                            }
                            inflater.end();
                            byteArray = byteArrayOutputStream.toByteArray();
                        } catch (Exception e16) {
                            QZLog.e("QZoneCommBroadReceiver", "Push Buf decompresse error!", e16);
                        }
                    }
                    bArr = byteArray;
                } else {
                    Map map = (Map) intent.getSerializableExtra("update_feeds");
                    if (map != null && map.containsKey("updatefeeds")) {
                        bArr = Base64.decode((String) map.get("updatefeeds"), 0);
                    }
                }
                if (bArr != null) {
                    PushUpdateFeeds pushUpdateFeeds = (PushUpdateFeeds) t5.b.b(PushUpdateFeeds.class, bArr);
                    if (pushUpdateFeeds.need_pull) {
                        if (TextUtils.isEmpty(pushUpdateFeeds.ugc_key)) {
                            return;
                        }
                        QZLog.i("QZoneCommBroadReceiver", "FeedUpdate: Qzone Push need_pull:" + pushUpdateFeeds.need_pull + " ugc_key:" + pushUpdateFeeds.ugc_key);
                        EventCenter.getInstance().post(new EventSource("PushDataUpdate"), 3, new Object[]{pushUpdateFeeds.ugc_key});
                        return;
                    }
                    if (pushUpdateFeeds.all_pull) {
                        if (TextUtils.isEmpty(pushUpdateFeeds.ugc_key)) {
                            return;
                        }
                        QZLog.i("QZoneCommBroadReceiver", "FeedUpdate: Qzone Push all_pull:" + pushUpdateFeeds.all_pull + " ugc_key:" + pushUpdateFeeds.ugc_key);
                        EventCenter.getInstance().post(new EventSource("PushDataUpdate"), 5, new Object[]{pushUpdateFeeds.ugc_key});
                        return;
                    }
                    FeedIncrementalUpdateService.d().g(pushUpdateFeeds);
                    return;
                }
                QZLog.e("QZoneCommBroadReceiver", "Push Buf is null!");
                return;
            } catch (Exception e17) {
                QZLog.e("QZoneCommBroadReceiver", "action " + action + " params error.", e17);
                return;
            }
        }
        if (action.equals("com.qzone.push_feed_unread")) {
            try {
                count_info count_infoVar = (count_info) intent.getSerializableExtra("feeds_unread");
                if (count_infoVar != null) {
                    FeedIncrementalUpdateService.d().e(count_infoVar.vecUinList);
                    return;
                }
                return;
            } catch (Throwable th5) {
                QZLog.e("QZoneCommBroadReceiver", "action " + action + " params error.", th5);
                return;
            }
        }
        c(intent);
    }

    private void c(Intent intent) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        intent.getExtras();
        if ("com.qzone.feed_theme_change".equals(action)) {
            long currentTimeMillis = System.currentTimeMillis();
            d();
            QLog.d("QZoneCommBroadReceiver", 1, "qzone handle theme changed cos=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }
}

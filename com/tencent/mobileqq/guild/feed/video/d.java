package com.tencent.mobileqq.guild.feed.video;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.video.RFWPlayer;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes13.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private static volatile d f223988b;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, WeakReference<RFWPlayer>> f223989a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements SDKInitListener {
        a() {
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public void onSDKInited(boolean z16) {
            if (!z16) {
                QLog.e("GuildFeedVideoPlayerManager", 1, "onSDKInited failed");
            }
        }
    }

    d() {
        c();
    }

    public static d a() {
        if (f223988b == null) {
            synchronized (d.class) {
                if (f223988b == null) {
                    f223988b = new d();
                }
            }
        }
        return f223988b;
    }

    private void c() {
        if (!QQVideoPlaySDKManager.isSDKReady()) {
            try {
                QQVideoPlaySDKManager.initSDKAsync(RFWApplication.getApplication(), new a());
            } catch (RuntimeException e16) {
                QLog.e("GuildFeedVideoPlayerManager", 1, e16.getMessage(), e16);
            }
        }
    }

    private void f() {
        synchronized (this) {
            if (this.f223989a.size() > 0) {
                Iterator<String> it = this.f223989a.keySet().iterator();
                while (it.hasNext()) {
                    RFWPlayer rFWPlayer = this.f223989a.remove(it.next()).get();
                    if (rFWPlayer != null) {
                        rFWPlayer.release();
                    }
                }
            }
        }
    }

    public RFWPlayer b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f223989a.containsKey(str)) {
            return this.f223989a.get(str).get();
        }
        QLog.d("GuildFeedVideoPlayerManager", 1, "getPlayer null ");
        return null;
    }

    public RFWPlayer d(String str) {
        RFWPlayer rFWPlayer;
        synchronized (this) {
            rFWPlayer = new RFWPlayer();
            e();
            this.f223989a.put(str, new WeakReference<>(rFWPlayer));
        }
        return rFWPlayer;
    }

    public void e() {
        QLog.d("GuildFeedVideoPlayerManager", 1, "release players:" + this.f223989a.size());
        f();
    }

    public void g(String str) {
        synchronized (this) {
            RFWPlayer b16 = b(str);
            if (b16 == null) {
                QLog.d("GuildFeedVideoPlayerManager", 1, "releasePlayer is null:" + str);
                return;
            }
            QLog.d("GuildFeedVideoPlayerManager", 1, "releasePlayer :" + str);
            this.f223989a.remove(str);
            b16.release();
        }
    }
}

package com.tencent.gdtad.kuikly.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.kuikly.a;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class GdtBaseKuiklyBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f109317a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f109318b = false;

    public GdtBaseKuiklyBroadcastReceiver(Handler handler) {
        this.f109317a = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(Context context, Intent intent) {
        int i3;
        int g16;
        try {
            String a16 = l.a(intent);
            JSONObject b16 = l.b(intent);
            String str = null;
            String optString = AdJSONUtil.optString(AdJSONUtil.optJSONObject(b16, "context"), "page_name", null);
            JSONObject optJSONObject = AdJSONUtil.optJSONObject(b16, QAdVrReport.ElementID.AD_INFO);
            if (AdJSONUtil.isJSONObjectNull(optJSONObject)) {
                QLog.e(e(), 1, "[onReceiveImpl] do nothing, eventName:" + a16 + " eventParams:" + b16);
                return;
            }
            try {
                GdtAd gdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), optJSONObject));
                if (!TextUtils.isEmpty(a16) && !TextUtils.isEmpty(gdtAd.getTraceId())) {
                    if (d() != null) {
                        str = d().getTraceId();
                    }
                    if (!TextUtils.equals(str, gdtAd.getTraceId())) {
                        QLog.i(e(), 1, "[onReceiveImpl] do nothing, not the same ad, pageName:" + optString + " eventName:" + a16);
                        return;
                    }
                    if (TextUtils.equals(a16, "gdt_event_close")) {
                        g16 = f();
                    } else if (TextUtils.equals(a16, "gdt_event_fallback")) {
                        g16 = g();
                    } else {
                        i3 = Integer.MIN_VALUE;
                        if (i3 != 0) {
                            a.l(e(), "[onReceiveImpl] eventName:" + a16, AdMetricID.Kuikly.BroadcastReceiver.ON_RECEIVE_SUCCESS, gdtAd, null, optString, a16);
                            return;
                        }
                        if (i3 != Integer.MIN_VALUE) {
                            a.g(e(), "[onReceiveImpl] error, eventName:" + a16 + " errorCode:" + i3, null, AdMetricID.Kuikly.BroadcastReceiver.ON_RECEIVE_FAILED, gdtAd, null, optString, a16, i3);
                            return;
                        }
                        return;
                    }
                    i3 = g16;
                    if (i3 != 0) {
                    }
                } else {
                    QLog.e(e(), 1, "[onReceiveImpl] do nothing, not valid, pageName:" + optString + " eventName:" + a16);
                }
            } catch (Throwable th5) {
                QLog.e(e(), 1, "[onReceiveImpl]", th5);
            }
        } catch (Throwable th6) {
            QLog.e(e(), 1, "[onReceiveImpl]", th6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(WeakReference<Context> weakReference) {
        Context context;
        if (Looper.myLooper() != ThreadManagerV2.getQQCommonThreadLooper()) {
            QLog.e(e(), 1, "[registerOnCommonThread] error, not on common thread");
            return;
        }
        Context context2 = null;
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        if (context != null) {
            context2 = context.getApplicationContext();
        }
        if (context2 == null) {
            QLog.e(e(), 1, "[registerOnCommonThread] error, appContext is null");
            return;
        }
        if (this.f109318b) {
            return;
        }
        QLog.i(e(), 1, "[registerOnCommonThread]");
        try {
            l.c(context2, this);
            this.f109318b = true;
        } catch (Throwable th5) {
            QLog.e(e(), 1, "[registerOnCommonThread]", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(WeakReference<Context> weakReference) {
        Context context;
        if (Looper.myLooper() != ThreadManagerV2.getQQCommonThreadLooper()) {
            QLog.e(e(), 1, "[unregisterOnCommonThread] error, not on common thread");
            return;
        }
        Context context2 = null;
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        if (context != null) {
            context2 = context.getApplicationContext();
        }
        if (context2 == null) {
            QLog.e(e(), 1, "[unregisterOnCommonThread] error, appContext is null");
            return;
        }
        if (!this.f109318b) {
            return;
        }
        QLog.i(e(), 1, "[unregisterOnCommonThread]");
        try {
            l.f(context2, this);
            this.f109318b = false;
        } catch (Throwable th5) {
            QLog.e(e(), 1, "[unregisterOnCommonThread]", th5);
        }
    }

    protected abstract GdtAd d();

    protected abstract String e();

    protected abstract int f();

    protected abstract int g();

    public void i(final WeakReference<Context> weakReference) {
        QLog.i(e(), 1, "[register]");
        new Handler(ThreadManagerV2.getQQCommonThreadLooper()).post(new Runnable() { // from class: com.tencent.gdtad.kuikly.receiver.GdtBaseKuiklyBroadcastReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                GdtBaseKuiklyBroadcastReceiver.this.j(weakReference);
            }
        });
    }

    public void k(final WeakReference<Context> weakReference) {
        QLog.i(e(), 1, "[unregister]");
        new Handler(ThreadManagerV2.getQQCommonThreadLooper()).post(new Runnable() { // from class: com.tencent.gdtad.kuikly.receiver.GdtBaseKuiklyBroadcastReceiver.2
            @Override // java.lang.Runnable
            public void run() {
                GdtBaseKuiklyBroadcastReceiver.this.l(weakReference);
            }
        });
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        if (this.f109317a == null) {
            h(context, intent);
        } else {
            final WeakReference weakReference = new WeakReference(context);
            this.f109317a.post(new Runnable() { // from class: com.tencent.gdtad.kuikly.receiver.GdtBaseKuiklyBroadcastReceiver.3
                @Override // java.lang.Runnable
                public void run() {
                    GdtBaseKuiklyBroadcastReceiver.this.h((Context) weakReference.get(), intent);
                }
            });
        }
    }
}

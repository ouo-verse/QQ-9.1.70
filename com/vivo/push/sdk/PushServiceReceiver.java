package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.vivo.push.PushClient;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.m;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.u;
import com.vivo.push.util.x;

/* loaded from: classes15.dex */
public class PushServiceReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static HandlerThread f387841a;

    /* renamed from: b, reason: collision with root package name */
    private static Handler f387842b;

    /* renamed from: c, reason: collision with root package name */
    private static a f387843c = new a();

    /* loaded from: classes15.dex */
    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Context f387844a;

        /* renamed from: b, reason: collision with root package name */
        private String f387845b;

        a() {
        }

        static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f387844a = ContextDelegate.getContext(context);
            aVar.f387845b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z16;
            NetworkInfo a16 = x.a(this.f387844a);
            if (a16 != null) {
                z16 = a16.isConnectedOrConnecting();
            } else {
                z16 = false;
            }
            if (!z16) {
                u.d("PushServiceReceiver", this.f387844a.getPackageName() + ": \u65e0\u7f51\u7edc  by " + this.f387845b);
                u.a(this.f387844a, "\u89e6\u53d1\u9759\u6001\u5e7f\u64ad:\u65e0\u7f51\u7edc(" + this.f387845b + "," + this.f387844a.getPackageName() + ")");
                return;
            }
            u.d("PushServiceReceiver", this.f387844a.getPackageName() + ": \u6267\u884c\u5f00\u59cb\u51fa\u53d1\u52a8\u4f5c: " + this.f387845b);
            u.a(this.f387844a, "\u89e6\u53d1\u9759\u6001\u5e7f\u64ad(" + this.f387845b + "," + this.f387844a.getPackageName() + ")");
            m.a().a(this.f387844a);
            if (!ClientConfigManagerImpl.getInstance(this.f387844a).isCancleBroadcastReceiver()) {
                try {
                    PushClient.getInstance(this.f387844a).initialize(com.vivo.push.restructure.a.a().e().l());
                } catch (VivoPushException e16) {
                    e16.printStackTrace();
                    u.a(this.f387844a, " \u521d\u59cb\u5316\u5f02\u5e38 error= " + e16.getMessage());
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Context context2 = ContextDelegate.getContext(context);
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (f387841a == null) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("PushServiceReceiver");
                f387841a = baseHandlerThread;
                baseHandlerThread.start();
                f387842b = new Handler(f387841a.getLooper());
            }
            u.d("PushServiceReceiver", context2.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + f387842b);
            a.a(f387843c, context2, action);
            f387842b.removeCallbacks(f387843c);
            f387842b.postDelayed(f387843c, 2000L);
        }
    }
}

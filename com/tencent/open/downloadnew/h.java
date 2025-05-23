package com.tencent.open.downloadnew;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.assistant.sdk.remote.SDKConst;

/* compiled from: P */
/* loaded from: classes22.dex */
public class h {

    /* renamed from: e, reason: collision with root package name */
    private static volatile h f341524e;

    /* renamed from: b, reason: collision with root package name */
    private boolean f341526b = false;

    /* renamed from: c, reason: collision with root package name */
    private Handler f341527c = new a();

    /* renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f341528d = new b();

    /* renamed from: a, reason: collision with root package name */
    private Context f341525a = com.tencent.open.adapter.a.f().e();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == 100 && message.arg1 == 101) {
                h.this.e();
                com.tencent.open.base.f.a("YybWakeManager", "yyb not alive, startYybByInstrumentation");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            h.this.f341527c.removeMessages(100);
            com.tencent.open.base.f.a("YybWakeManager", "BROADCAST_YYB_ALIVE_CALLBACK received, stop wake yyb");
        }
    }

    h() {
    }

    public static h c() {
        if (f341524e == null) {
            synchronized (h.class) {
                if (f341524e == null) {
                    f341524e = new h();
                }
            }
        }
        return f341524e;
    }

    private void d() {
        try {
            if (this.f341525a == null || this.f341526b) {
                return;
            }
            this.f341525a.registerReceiver(this.f341528d, new IntentFilter("com.tencent.android.qqdownloader.action.CONNECT_PC_STATE"));
            this.f341526b = true;
        } catch (Exception e16) {
            com.tencent.open.base.f.c("TAMST_WAKE", "registerYybReceiver:" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f341525a == null || !d.w()) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("from", this.f341525a.getPackageName());
            bundle.putString("via", "CALL_LIVE_QQ");
            com.tencent.open.base.f.a("YybWakeManager", "\u62c9\u6d3b\u7ed3\u679c=" + com.tencent.open.adapter.a.f().e().startInstrumentation(new ComponentName(SDKConst.SELF_PACKAGENAME, "com.live.watermelon.Instrumentation"), null, bundle));
            d.x();
        } catch (Exception e16) {
            com.tencent.open.base.f.c("TAMST_WAKE", "startYybByInstrumentation:" + e16.getMessage());
        }
    }

    public void f() {
        if (this.f341525a == null) {
            return;
        }
        d();
        Intent intent = new Intent();
        intent.setAction("com.tencent.android.qqdownloader.action.QUERY_CONNECT_STATE");
        intent.putExtra("is_from_mq", true);
        intent.setPackage(SDKConst.SELF_PACKAGENAME);
        this.f341525a.sendBroadcast(intent);
        Message obtain = Message.obtain();
        obtain.what = 100;
        obtain.arg1 = 101;
        this.f341527c.sendMessageDelayed(obtain, 5000L);
        com.tencent.open.base.f.a("YybWakeManager", "tryInstrumentWake");
    }
}

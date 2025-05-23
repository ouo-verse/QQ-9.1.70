package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.av.utils.at;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private VideoAppInterface f73166a;

    /* renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f73167b = new a();

    /* renamed from: c, reason: collision with root package name */
    private boolean f73168c;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "com.tencent.av.EXIT_VIDEO_PROCESS".equals(intent.getAction())) {
                QLog.w("GAudioExitMonitor", 1, "onReceive.EXIT_VIDEO_ACTION, seq[" + at.a(intent) + "]");
                if (com.tencent.av.r.h0() != null) {
                    com.tencent.av.r.h0().p(false, 202, com.tencent.av.n.e().f().f73063p);
                    com.tencent.av.r.h0().j2(202);
                    com.tencent.av.r.h0().x(1011);
                }
            }
        }
    }

    public i(VideoAppInterface videoAppInterface) {
        this.f73166a = videoAppInterface;
    }

    public void a() {
        if (QLog.isColorLevel()) {
            QLog.d("GAudioExitMonitor", 2, "regist QQ Process Exit Receiver1");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.av.EXIT_VIDEO_PROCESS");
        if (this.f73166a.getApplication().registerReceiver(this.f73167b, intentFilter) != null) {
            this.f73168c = true;
        }
    }

    public void b() {
        if (this.f73168c) {
            this.f73166a.getApplication().unregisterReceiver(this.f73167b);
            this.f73168c = false;
        }
    }
}

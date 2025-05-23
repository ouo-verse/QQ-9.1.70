package com.tencent.av.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class PhoneStatusMonitor {

    /* renamed from: a, reason: collision with root package name */
    private Context f76699a;

    /* renamed from: b, reason: collision with root package name */
    private PhoneStateListener f76700b;

    /* renamed from: c, reason: collision with root package name */
    private b f76701c;

    /* renamed from: e, reason: collision with root package name */
    private a f76703e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f76704f;

    /* renamed from: d, reason: collision with root package name */
    private boolean f76702d = false;

    /* renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f76705g = new AtomicBoolean();

    /* renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f76706h = new AtomicBoolean();

    /* renamed from: i, reason: collision with root package name */
    private Runnable f76707i = new Runnable() { // from class: com.tencent.av.utils.PhoneStatusMonitor.4
        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isColorLevel()) {
                QLog.i("PhoneStatusMonitor", 2, "checkEndCallTask, calling[" + PhoneStatusMonitor.this.f76702d + "], tillEnd[" + PhoneStatusMonitor.this.f76706h.get() + "]");
            }
            if (!PhoneStatusMonitor.this.f76702d) {
                PhoneStatusMonitor.this.l();
            } else if (PhoneStatusMonitor.this.f76706h.get()) {
                PhoneStatusMonitor.this.j();
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            if (intent == null) {
                action = null;
            } else {
                action = intent.getAction();
            }
            if (QLog.isColorLevel()) {
                QLog.d("PhoneStatusMonitor", 2, "PhoneStatusReceiver.onReceive, action[" + action + "]");
            }
            PhoneStatusMonitor.this.j();
        }
    }

    /* loaded from: classes3.dex */
    class c extends PhoneStateListener {
        c() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i3, String str) {
            if (QLog.isColorLevel()) {
                QLog.i("PhoneStatusMonitor", 2, "onCallStateChanged, state[" + i3 + "], isCalling[" + PhoneStatusMonitor.this.f76702d + "]");
            }
            if (i3 != 0) {
                if ((i3 == 1 || i3 == 2) && !PhoneStatusMonitor.this.f76702d) {
                    PhoneStatusMonitor.this.p(true);
                }
            } else if (PhoneStatusMonitor.this.f76702d) {
                PhoneStatusMonitor.this.p(false);
            }
            super.onCallStateChanged(i3, str);
        }
    }

    public PhoneStatusMonitor(final Context context, a aVar) {
        this.f76700b = null;
        this.f76701c = null;
        this.f76703e = null;
        this.f76704f = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (QLog.isColorLevel()) {
            QLog.d("PhoneStatusMonitor", 2, "PhoneStatusMonitor Begin");
        }
        this.f76699a = context;
        this.f76703e = aVar;
        try {
            this.f76700b = new c();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PhoneStatusMonitor", 2, "PhoneStatusMonitor e1 = " + e16);
            }
        }
        this.f76701c = new b();
        try {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.utils.PhoneStatusMonitor.1
                @Override // java.lang.Runnable
                public void run() {
                    ad.r(context, PhoneStatusMonitor.this.f76700b, 32);
                }
            }, 16, null, false);
        } catch (Exception e17) {
            QLog.d("PhoneStatusMonitor", 1, "PhoneStatusMonitor e3 = " + e17);
        } catch (IncompatibleClassChangeError e18) {
            QLog.e("PhoneStatusMonitor", 2, "PhoneStatusMonitor e2 = " + e18);
        } catch (InternalError e19) {
            QLog.e("PhoneStatusMonitor", 2, "PhoneStatusMonitor e = " + e19);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PhoneStatusMonitor", 2, "PhoneStatusMonitor, Step1, cost[" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "]");
        }
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        intentFilter.addAction("android.intent.action.PHONE_STATE2");
        intentFilter.addAction("android.intent.action.PHONE_STATE_2");
        intentFilter.addAction("android.intent.action.PHONE_STATE_EXT");
        intentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.utils.PhoneStatusMonitor.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("PhoneStatusMonitor", 2, "PhoneStatusMonitor registerReceiver");
                    }
                    context.registerReceiver(PhoneStatusMonitor.this.f76701c, intentFilter);
                } catch (Throwable th5) {
                    QLog.i("PhoneStatusMonitor", 1, "registerReceiver", th5);
                }
            }
        }, 16, null, false);
        if (QLog.isColorLevel()) {
            QLog.d("PhoneStatusMonitor", 2, "PhoneStatusMonitor End, cost[" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "]");
        }
        this.f76704f = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z16) {
        if (this.f76702d == z16) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PhoneStatusMonitor", 2, "updateCallingState, pre[" + this.f76702d + "], cur[" + z16 + "]");
        }
        this.f76702d = z16;
        a aVar = this.f76703e;
        if (aVar != null) {
            aVar.a(z16);
        }
        if (!this.f76702d) {
            l();
        }
    }

    protected void finalize() throws Throwable {
        try {
            o();
        } finally {
            super.finalize();
        }
    }

    public void j() {
        boolean z16 = this.f76705g.get();
        if (QLog.isColorLevel()) {
            QLog.i("PhoneStatusMonitor", 2, "checkCalling, begin, isCalling[" + this.f76702d + "], isChecking[" + z16 + "]");
        }
        if (z16) {
            return;
        }
        this.f76705g.set(true);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.utils.PhoneStatusMonitor.3
            @Override // java.lang.Runnable
            public void run() {
                boolean h16 = ad.h(PhoneStatusMonitor.this.f76699a);
                if (QLog.isColorLevel()) {
                    QLog.d("PhoneStatusMonitor", 2, "checkCalling, end, pre[" + PhoneStatusMonitor.this.f76702d + "], cur[" + h16 + "]");
                }
                PhoneStatusMonitor.this.p(h16);
                Handler handler = PhoneStatusMonitor.this.f76704f;
                if (handler != null && PhoneStatusMonitor.this.f76706h.get()) {
                    handler.postDelayed(PhoneStatusMonitor.this.f76707i, 10000L);
                }
                PhoneStatusMonitor.this.f76705g.set(false);
            }
        }, 16, null, false);
    }

    public void k() {
        if (QLog.isColorLevel()) {
            QLog.i("PhoneStatusMonitor", 2, "checkEndOfCall, calling[" + this.f76702d + "]");
        }
        if (!this.f76702d) {
            return;
        }
        this.f76706h.set(true);
        j();
    }

    public void l() {
        if (QLog.isColorLevel()) {
            QLog.i("PhoneStatusMonitor", 2, "clearTillEnd, calling[" + this.f76702d + "], tillEnd[" + this.f76706h.get() + "]");
        }
        this.f76706h.set(false);
        Handler handler = this.f76704f;
        if (handler != null) {
            handler.removeCallbacks(this.f76707i);
        }
    }

    public boolean m() {
        return this.f76702d;
    }

    public void n() {
        o();
    }

    public void o() {
        if (this.f76699a != null && this.f76700b != null) {
            l();
            ad.r(this.f76699a, this.f76700b, 0);
            QLog.d("PhoneStatusMonitor", 1, "PhoneStatusMonitor.unregisterReceiver()");
            try {
                this.f76699a.unregisterReceiver(this.f76701c);
            } catch (Throwable th5) {
                QLog.i("PhoneStatusMonitor", 1, "unregisterReceiver", th5);
            }
            this.f76703e = null;
            this.f76701c = null;
            this.f76700b = null;
            this.f76699a = null;
            this.f76704f = null;
        }
    }
}

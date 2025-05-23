package com.tencent.av;

import android.os.Handler;
import android.os.Looper;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

/* loaded from: classes3.dex */
public class VideoProcessExitMonitor {

    /* renamed from: l, reason: collision with root package name */
    private static final Object f72876l = new Object();

    /* renamed from: a, reason: collision with root package name */
    private boolean f72877a;

    /* renamed from: b, reason: collision with root package name */
    private VideoAppInterface f72878b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f72879c = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    private int f72880d = 0;

    /* renamed from: e, reason: collision with root package name */
    private Runnable f72881e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f72882f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f72883g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f72884h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f72885i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f72886j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f72887k;

    public VideoProcessExitMonitor(VideoAppInterface videoAppInterface) {
        boolean z16;
        this.f72878b = videoAppInterface;
        if (com.tencent.av.ui.funchat.record.e.a().f75881m == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f72877a = z16;
        QLog.d("VideoProcessExitMonitor", 1, String.format("VideoProcessExitMonitor mExitProcessEnable=%s", Boolean.valueOf(z16)));
    }

    private void i(int i3) {
        QLog.d("VideoProcessExitMonitor", 1, String.format("checkExitProcess status=%s", Integer.valueOf(i3)));
        if (this.f72880d == 2) {
            j();
        }
    }

    private void j() {
        QLog.d("VideoProcessExitMonitor", 1, "exitProcess");
        long currentTimeMillis = System.currentTimeMillis();
        QLog.flushLog(true);
        this.f72878b.getApplication().otherProcessExit(true);
        QLog.d("VideoProcessExitMonitor", 1, String.format("exitProcess time cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        this.f72878b.F0();
        try {
            LockMethodProxy.sleep(300L);
        } catch (Throwable unused) {
        }
        System.exit(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        synchronized (f72876l) {
            QLog.d("VideoProcessExitMonitor", 1, String.format("receiveMsfSetConnStatusTimeout mCurStatus=%s", Integer.valueOf(this.f72880d)));
            if (this.f72880d == 1) {
                this.f72880d = 2;
            }
            i(this.f72880d);
        }
    }

    private void q(int i3) {
        QLog.d("VideoProcessExitMonitor", 1, String.format("sendSetMsfConnStatusReq status=%s", Integer.valueOf(i3)));
        NewIntent newIntent = new NewIntent(this.f72878b.getApplication(), t.class);
        newIntent.putExtra("reqType", 10);
        newIntent.putExtra("status", i3);
        this.f72878b.startServlet(newIntent);
    }

    private void x(long j3) {
        QLog.d("VideoProcessExitMonitor", 1, String.format("startMsfRespTimeoutCheck timeout=%s", Long.valueOf(j3)));
        Runnable runnable = this.f72881e;
        if (runnable != null) {
            this.f72879c.removeCallbacks(runnable);
            this.f72881e = null;
        }
        Runnable runnable2 = new Runnable() { // from class: com.tencent.av.VideoProcessExitMonitor.2
            @Override // java.lang.Runnable
            public void run() {
                VideoProcessExitMonitor.this.p();
            }
        };
        this.f72881e = runnable2;
        this.f72879c.postDelayed(runnable2, j3);
    }

    public boolean h() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.VideoProcessExitMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("VideoProcessExitMonitor", 1, String.format("canExitProcess mAcceptMultiIncomingCall=%s mSwitch2MultiActive=%s mSwitch2MultiPassive=%s mSwitch2DoubleMeeting=%s mSwitch2OtherTerminal=%s mAllTerminalOffline=%s", Boolean.valueOf(VideoProcessExitMonitor.this.f72882f), Boolean.valueOf(VideoProcessExitMonitor.this.f72883g), Boolean.valueOf(VideoProcessExitMonitor.this.f72884h), Boolean.valueOf(VideoProcessExitMonitor.this.f72885i), Boolean.valueOf(VideoProcessExitMonitor.this.f72886j), Boolean.valueOf(VideoProcessExitMonitor.this.f72887k)));
            }
        }, 16, null, true);
        if (!this.f72882f && !this.f72883g && !this.f72884h && !this.f72885i && !this.f72886j && !this.f72887k) {
            return true;
        }
        return false;
    }

    public boolean k() {
        return this.f72887k;
    }

    public boolean l() {
        return this.f72885i;
    }

    public void m() {
        if (!this.f72877a) {
            return;
        }
        synchronized (f72876l) {
            QLog.d("VideoProcessExitMonitor", 1, String.format("processActive mCurStatus=%s", Integer.valueOf(this.f72880d)));
            if (this.f72880d != 0) {
                q(2);
                this.f72880d = 0;
            }
        }
    }

    public void n(boolean z16) {
        if (!z16 && !this.f72877a) {
            return;
        }
        synchronized (f72876l) {
            QLog.d("VideoProcessExitMonitor", 1, String.format("processDeactive mCurStatus=%s", Integer.valueOf(this.f72880d)));
            if (this.f72880d == 0) {
                q(1);
                x(2000L);
                this.f72880d = 1;
            }
            i(this.f72880d);
        }
    }

    public void o(int i3) {
        synchronized (f72876l) {
            QLog.d("VideoProcessExitMonitor", 1, String.format("receiveMsfSetConnStatusAck mCurStatus=%s status=%s", Integer.valueOf(this.f72880d), Integer.valueOf(i3)));
            Runnable runnable = this.f72881e;
            if (runnable != null) {
                this.f72879c.removeCallbacks(runnable);
                this.f72881e = null;
            }
            if (i3 == 1 && this.f72880d == 1) {
                this.f72880d = 2;
            }
            i(this.f72880d);
        }
    }

    public void r(boolean z16) {
        QLog.d("VideoProcessExitMonitor", 1, String.format("setAcceptMultiIncomingCall acceptMultiIncomingCall=%s", Boolean.valueOf(z16)));
        this.f72882f = z16;
    }

    public void s(boolean z16) {
        QLog.d("VideoProcessExitMonitor", 1, String.format("setAllTerminalOffline allTerminalOffline=%s", Boolean.valueOf(z16)));
        this.f72887k = z16;
    }

    public void t(boolean z16) {
        QLog.d("VideoProcessExitMonitor", 1, String.format("setSwitch2DoubleMeeting switch2DoubleMeeting=%s", Boolean.valueOf(z16)));
        this.f72885i = z16;
    }

    public void u(boolean z16) {
        QLog.d("VideoProcessExitMonitor", 1, String.format("setSwitch2MultiActive switch2MultiActive=%s", Boolean.valueOf(z16)));
        this.f72883g = z16;
    }

    public void v(boolean z16) {
        QLog.d("VideoProcessExitMonitor", 1, String.format("setSwitch2MultiPassive switch2MultiPassive=%s", Boolean.valueOf(z16)));
        this.f72884h = z16;
    }

    public void w(boolean z16) {
        QLog.d("VideoProcessExitMonitor", 1, String.format("setSwitch2OtherTerminal switch2OtherTerminal=%s", Boolean.valueOf(z16)));
        this.f72886j = z16;
    }
}

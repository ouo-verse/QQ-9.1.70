package com.tencent.adelie.av.ui;

import android.os.SystemClock;
import android.widget.TextView;
import com.tencent.adelie.av.qav.AdelieAVController;
import com.tencent.av.utils.ba;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AdelieAVTimerController {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<TextView> f61480a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f61481b = false;

    /* renamed from: c, reason: collision with root package name */
    private TimmerRunnable f61482c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class TimmerRunnable implements Runnable {
        TimmerRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AdelieAVTimerController.this.f61481b) {
                long c16 = AdelieAVTimerController.c();
                final String formatTime = ba.formatTime(c16);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVTimerController.TimmerRunnable.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AdelieAVTimerController.this.f61480a == null || AdelieAVTimerController.this.f61480a.get() == 0) {
                            return;
                        }
                        ((TextView) AdelieAVTimerController.this.f61480a.get()).setText(formatTime);
                    }
                });
                ThreadManagerV2.executeDelay(this, 16, null, false, 1000L);
                ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getAVNotifyCenter().F0(c16);
            }
        }
    }

    public AdelieAVTimerController(TextView textView) {
        this.f61480a = new WeakReference<>(textView);
    }

    public static long c() {
        if (!AdelieAVController.J()) {
            QLog.d("AdelieAVTimmerController", 1, "cancel timer for AVController is null.");
            return 0L;
        }
        up.a E = AdelieAVController.D().E();
        if (E == null) {
            QLog.d("AdelieAVTimmerController", 1, "cancel timer for session is null.");
            return 0L;
        }
        return (SystemClock.elapsedRealtime() - E.f439404w) / 1000;
    }

    public void e() {
        QLog.d("AdelieAVTimmerController", 1, "startTimer " + this.f61481b);
        if (this.f61481b) {
            return;
        }
        this.f61481b = true;
        if (this.f61482c == null) {
            this.f61482c = new TimmerRunnable();
        }
        ThreadManagerV2.excute(this.f61482c, 16, null, false);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVTimerController.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (AdelieAVTimerController.this.f61480a == null || AdelieAVTimerController.this.f61480a.get() == 0) {
                    return;
                }
                ((TextView) AdelieAVTimerController.this.f61480a.get()).setText((CharSequence) null);
            }
        });
    }

    public void f() {
        if (this.f61481b) {
            if (QLog.isColorLevel()) {
                QLog.w("AdelieAVTimmerController", 1, "stopTimer");
            }
            this.f61481b = false;
            TimmerRunnable timmerRunnable = this.f61482c;
            if (timmerRunnable != null) {
                ThreadManagerV2.removeJob(timmerRunnable, 16);
                this.f61482c = null;
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAVTimerController.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (AdelieAVTimerController.this.f61480a == null || AdelieAVTimerController.this.f61480a.get() == 0) {
                        return;
                    }
                    ((TextView) AdelieAVTimerController.this.f61480a.get()).setText((CharSequence) null);
                }
            });
        }
    }

    public void d() {
        this.f61481b = false;
        this.f61482c = null;
        this.f61480a = null;
    }
}

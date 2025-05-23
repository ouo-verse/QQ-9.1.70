package com.tencent.mobileqq.widget;

import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* loaded from: classes20.dex */
public class RefreshProgressRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private volatile long f316160d = -1;

    /* renamed from: e, reason: collision with root package name */
    private volatile long f316161e = -1;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f316162f = false;

    /* renamed from: h, reason: collision with root package name */
    public String f316163h;

    /* renamed from: i, reason: collision with root package name */
    public WeakReference<MessageProgressView> f316164i;

    /* renamed from: m, reason: collision with root package name */
    public int f316165m;

    public RefreshProgressRunnable(MessageProgressView messageProgressView, String str, int i3) {
        this.f316163h = str;
        this.f316164i = new WeakReference<>(messageProgressView);
        this.f316165m = i3;
    }

    public void a(MessageProgressView messageProgressView, int i3) {
        this.f316164i = new WeakReference<>(messageProgressView);
        this.f316165m = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageProgressView messageProgressView = this.f316164i.get();
        if (messageProgressView == null) {
            if (QLog.isColorLevel()) {
                QLog.e("MessageProgressView", 2, "[run] mView == null");
                return;
            }
            return;
        }
        if (this.f316162f) {
            if (QLog.isColorLevel()) {
                QLog.e("MessageProgressView", 2, " stopAnim in isStopped key=" + this.f316163h);
            }
            messageProgressView.q(this.f316163h);
            return;
        }
        if (this.f316160d == -1) {
            this.f316160d = SystemClock.uptimeMillis();
        } else {
            long uptimeMillis = SystemClock.uptimeMillis() - this.f316160d;
            if (uptimeMillis >= 0) {
                int i3 = this.f316165m;
                if (i3 < 100) {
                    long j3 = messageProgressView.f315830i0;
                    if ((uptimeMillis / j3) % 2 == 0) {
                        messageProgressView.f315829i = uptimeMillis % j3;
                    } else {
                        messageProgressView.f315829i = j3 - (uptimeMillis % j3);
                    }
                    messageProgressView.invalidate();
                } else {
                    if (i3 == 100 && this.f316161e == -1) {
                        this.f316161e = SystemClock.uptimeMillis();
                    }
                    long uptimeMillis2 = SystemClock.uptimeMillis() - this.f316161e;
                    long j16 = messageProgressView.U;
                    if (uptimeMillis2 >= j16) {
                        messageProgressView.f315829i = j16;
                        messageProgressView.invalidate();
                        if (QLog.isColorLevel()) {
                            QLog.e("MessageProgressView", 2, " stopAnim in run key=" + this.f316163h + " , mProgress = " + this.f316165m);
                        }
                        messageProgressView.q(this.f316163h);
                        stop();
                        MessageProgressView.a aVar = messageProgressView.E;
                        if (aVar != null) {
                            aVar.a(this.f316163h);
                        }
                    } else {
                        messageProgressView.f315829i = uptimeMillis2 % j16;
                        messageProgressView.invalidate();
                    }
                }
            } else {
                this.f316160d = SystemClock.uptimeMillis();
            }
        }
        if (!this.f316162f) {
            ViewCompat.postOnAnimation(messageProgressView, this);
        }
    }

    public void stop() {
        this.f316162f = true;
        this.f316160d = -1L;
        this.f316161e = -1L;
    }

    public String toString() {
        return "RefreshProgressRunnable{beginTime=" + this.f316160d + ", finishTimeBeginFlag=" + this.f316161e + ", isStopped=" + this.f316162f + ", key='" + this.f316163h + "', mProgress=" + this.f316165m + '}';
    }
}

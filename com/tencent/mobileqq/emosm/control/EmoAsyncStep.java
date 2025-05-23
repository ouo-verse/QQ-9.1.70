package com.tencent.mobileqq.emosm.control;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import kb1.b;

/* compiled from: P */
/* loaded from: classes6.dex */
public class EmoAsyncStep implements Runnable {
    public Object[] E;

    /* renamed from: d, reason: collision with root package name */
    public b f204257d;

    /* renamed from: h, reason: collision with root package name */
    public EmoAutomator f204260h;

    /* renamed from: m, reason: collision with root package name */
    public String f204262m;

    /* renamed from: e, reason: collision with root package name */
    protected volatile int f204258e = 1;

    /* renamed from: f, reason: collision with root package name */
    protected long f204259f = 30000;

    /* renamed from: i, reason: collision with root package name */
    public int f204261i = -1;
    protected int C = 0;
    private Object D = new Object();
    private long F = 0;

    protected int e() {
        if (QLog.isColorLevel()) {
            QLog.e("EmoAutomator", 2, this.f204262m + " EmoAsyncStep.doStep()");
            return 7;
        }
        return 7;
    }

    public void i(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("EmoAutomator", 2, this.f204262m + " setResult " + i3 + ", when " + this.f204258e);
        }
        if (i3 == 6) {
            this.f204260h.f204264e++;
        }
        synchronized (this.D) {
            if (i3 > this.f204258e && i3 != 4) {
                this.f204258e = i3;
            }
            this.D.notifyAll();
        }
    }

    protected boolean j() {
        while (true) {
            synchronized (this.D) {
                if (this.f204258e == 2) {
                    try {
                        this.D.wait(this.f204259f);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("EmoAutomator", 2, this.f204262m + " waitResult " + this.f204258e + " " + this.C);
                }
                if (this.f204258e != 3) {
                    break;
                }
                this.f204258e = 2;
            }
        }
        if (this.f204258e == 2) {
            this.f204258e = 5;
            this.f204260h.f204264e++;
        }
        if (this.f204258e == 6 || this.f204258e == 5) {
            int i3 = this.C;
            this.C = i3 - 1;
            if (i3 > 0) {
                this.f204258e = 1;
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar;
        if (this.f204258e == 1) {
            if (QLog.isColorLevel()) {
                QLog.d("EmoAutomator", 1, this.f204262m + " begin with " + this.f204258e);
            }
            this.F = SystemClock.uptimeMillis();
            try {
                f();
                do {
                    i(e());
                } while (j());
                h();
                if (QLog.isColorLevel()) {
                    QLog.d("EmoAutomator", 1, this.f204262m + " cost: " + (SystemClock.uptimeMillis() - this.F));
                }
                bVar = this.f204257d;
                if (bVar == null) {
                    return;
                }
            } catch (Throwable th5) {
                try {
                    QLog.e("EmoAutomator", 1, "", th5);
                    i(8);
                    if (QLog.isColorLevel()) {
                        QLog.d("EmoAutomator", 1, this.f204262m + " cost: " + (SystemClock.uptimeMillis() - this.F));
                    }
                    bVar = this.f204257d;
                    if (bVar == null) {
                        return;
                    }
                } catch (Throwable th6) {
                    if (QLog.isColorLevel()) {
                        QLog.d("EmoAutomator", 1, this.f204262m + " cost: " + (SystemClock.uptimeMillis() - this.F));
                    }
                    b bVar2 = this.f204257d;
                    if (bVar2 != null) {
                        bVar2.a(this, this.f204258e);
                    }
                    throw th6;
                }
            }
            bVar.a(this, this.f204258e);
        }
    }

    public void f() {
    }

    public void h() {
    }
}

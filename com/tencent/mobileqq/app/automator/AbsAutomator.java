package com.tencent.mobileqq.app.automator;

import android.annotation.TargetApi;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.automator.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.concurrent.AbstractExecutorService;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class AbsAutomator implements b, Runnable {
    static IPatchRedirector $redirector_;
    protected LinearGroup C;
    protected LinkedList<LinearGroup> D;
    protected volatile boolean E;
    protected volatile boolean F;

    /* renamed from: d, reason: collision with root package name */
    protected AbstractExecutorService f195299d;

    /* renamed from: e, reason: collision with root package name */
    protected int f195300e;

    /* renamed from: f, reason: collision with root package name */
    protected b.a f195301f;

    /* renamed from: h, reason: collision with root package name */
    protected int f195302h;

    /* renamed from: i, reason: collision with root package name */
    protected int f195303i;

    /* renamed from: m, reason: collision with root package name */
    protected LinkedList<AsyncStep> f195304m;

    public AbsAutomator(b.a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, i3);
            return;
        }
        this.f195302h = 0;
        this.f195303i = 0;
        this.f195304m = new LinkedList<>();
        this.C = null;
        this.D = new LinkedList<>();
        this.E = false;
        this.F = false;
        this.f195301f = aVar;
        this.f195300e = i3;
    }

    private void e() {
        if (this.f195299d == null) {
            this.f195299d = this.f195301f.a();
        }
    }

    @Override // com.tencent.mobileqq.app.automator.b
    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.f195302h++;
        }
    }

    protected void a(LinearGroup linearGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) linearGroup);
            return;
        }
        this.D.add(linearGroup);
        if (QLog.isColorLevel()) {
            QLog.d(getTag(), 2, "addWaitingMode_Locked " + linearGroup.mName);
        }
    }

    @Override // com.tencent.mobileqq.app.automator.b
    public void a2(AsyncStep asyncStep) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) asyncStep);
            return;
        }
        synchronized (this.f195304m) {
            int i3 = this.f195303i;
            if (i3 < this.f195300e) {
                this.f195303i = i3 + 1;
                e();
                this.f195299d.execute(asyncStep);
            } else {
                this.f195304m.add(asyncStep);
            }
        }
    }

    public LinearGroup f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (LinearGroup) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.C;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.f195302h;
    }

    @Override // com.tencent.mobileqq.app.automator.b
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "IAutomator";
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(getTag(), 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.E = true;
        synchronized (this.f195304m) {
            this.f195304m.clear();
            this.f195303i = 0;
        }
        synchronized (this.D) {
            this.D.clear();
            LinearGroup linearGroup = this.C;
            if (linearGroup != null) {
                linearGroup.setResult(8);
                this.C = null;
            }
        }
    }

    @TargetApi(9)
    public void i(AsyncStep asyncStep) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) asyncStep);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(getTag(), 2, "start " + asyncStep.mName);
        }
        LinearGroup linearGroup = (LinearGroup) asyncStep;
        synchronized (this.D) {
            if (this.C == null) {
                this.C = linearGroup;
                if (QLog.isColorLevel()) {
                    QLog.d(getTag(), 2, "gonna run " + linearGroup.mName);
                }
                e();
                this.f195299d.execute(this);
            } else {
                a(linearGroup);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.automator.b
    public void i2(AsyncStep[] asyncStepArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) asyncStepArr);
            return;
        }
        synchronized (this.f195304m) {
            this.f195303i--;
            if (this.f195304m.size() > 0) {
                if (asyncStepArr != null) {
                    for (AsyncStep asyncStep : asyncStepArr) {
                        if (this.f195304m.remove(asyncStep)) {
                            a2(asyncStep);
                            return;
                        }
                    }
                }
                a2(this.f195304m.poll());
            }
        }
    }

    public void j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            i(S1(this, str));
        }
    }

    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!this.F) {
            synchronized (this.D) {
                if (!this.F) {
                    this.F = true;
                }
            }
        }
        while (true) {
            LinearGroup linearGroup = this.C;
            if (linearGroup != null) {
                linearGroup.run();
            }
            synchronized (this.D) {
                LinearGroup poll = this.D.poll();
                this.C = poll;
                if (poll == null) {
                    return;
                }
            }
        }
    }
}

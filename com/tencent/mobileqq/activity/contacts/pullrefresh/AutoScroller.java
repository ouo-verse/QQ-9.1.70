package com.tencent.mobileqq.activity.contacts.pullrefresh;

import android.widget.Scroller;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AutoScroller implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private CommonRefreshLayout f181682d;

    /* renamed from: e, reason: collision with root package name */
    private Scroller f181683e;

    /* renamed from: f, reason: collision with root package name */
    private a f181684f;

    /* renamed from: h, reason: collision with root package name */
    private int f181685h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f181686i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f181687m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
        void a(float f16);

        void b();
    }

    public AutoScroller(CommonRefreshLayout commonRefreshLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) commonRefreshLayout);
            return;
        }
        this.f181686i = false;
        this.f181687m = false;
        this.f181682d = commonRefreshLayout;
        this.f181683e = new Scroller(commonRefreshLayout.getContext());
    }

    private void g() {
        a aVar;
        this.f181685h = 0;
        this.f181686i = false;
        this.f181682d.removeCallbacks(this);
        if (!this.f181687m && (aVar = this.f181684f) != null) {
            aVar.b();
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f181686i) {
            if (!this.f181683e.isFinished()) {
                this.f181687m = true;
                this.f181683e.forceFinished(true);
            }
            g();
            this.f181687m = false;
        }
    }

    public void f(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f181682d.removeCallbacks(this);
        this.f181685h = 0;
        if (!this.f181683e.isFinished()) {
            this.f181683e.forceFinished(true);
        }
        this.f181683e.startScroll(0, 0, 0, i3, i16);
        this.f181682d.post(this);
        this.f181686i = true;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f181683e.isFinished();
    }

    public void i(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f181684f = aVar;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f181683e.computeScrollOffset() && !this.f181683e.isFinished()) {
            z16 = false;
        } else {
            z16 = true;
        }
        int currY = this.f181683e.getCurrY();
        int i3 = currY - this.f181685h;
        if (z16) {
            g();
            return;
        }
        this.f181685h = currY;
        a aVar = this.f181684f;
        if (aVar != null) {
            aVar.a(i3);
        }
        this.f181682d.post(this);
    }
}

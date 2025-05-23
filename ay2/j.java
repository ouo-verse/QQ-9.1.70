package ay2;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.richframework.thread.RFWThreadManager;

/* compiled from: P */
/* loaded from: classes19.dex */
public class j extends k {

    /* renamed from: j, reason: collision with root package name */
    private View f27338j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f27339k;

    /* renamed from: l, reason: collision with root package name */
    private final Runnable f27340l;

    public j(View view, View view2) {
        super(view2);
        this.f27340l = new Runnable() { // from class: ay2.i
            @Override // java.lang.Runnable
            public final void run() {
                j.this.t();
            }
        };
        this.f27338j = view.findViewById(R.id.f45521s4);
        this.f27339k = false;
        this.f27344d.setIsLandScape(false);
        r();
    }

    private void r() {
        this.f27341a.setVisibility(8);
        this.f27343c.setVisibility(8);
    }

    private void s() {
        View view = this.f27338j;
        if (view != null && view.getVisibility() != 4) {
            this.f27338j.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        this.f27339k = false;
        a();
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        this.f27339k = true;
        x();
    }

    private void v() {
        if (this.f27339k) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.f27340l);
        }
    }

    private void w() {
        View view = this.f27338j;
        if (view != null && view.getVisibility() != 0) {
            this.f27338j.setVisibility(0);
        }
    }

    private void x() {
        this.f27341a.setVisibility(0);
        if (!this.f27349i) {
            this.f27343c.setVisibility(0);
        }
    }

    @Override // ay2.k
    public void d() {
        super.d();
        v();
        r();
        w();
    }

    @Override // ay2.k
    public void e() {
        super.e();
        v();
        x();
        this.f27345e.setVisibility(8);
    }

    @Override // ay2.k
    public void g() {
        super.g();
        v();
        a();
        r();
    }

    @Override // ay2.k
    public void h() {
        super.h();
        v();
        this.f27341a.setVisibility(0);
        this.f27343c.setVisibility(8);
        if (this.f27349i) {
            s();
        }
    }

    @Override // ay2.k
    public void i() {
        super.i();
        v();
        r();
        if (this.f27349i) {
            w();
        }
    }

    @Override // ay2.k
    public void m(boolean z16) {
        super.m(z16);
        if (z16) {
            this.f27341a.setBackgroundResource(0);
        } else {
            this.f27341a.setBackgroundResource(R.drawable.kms);
        }
    }

    public void y() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: ay2.h
            @Override // java.lang.Runnable
            public final void run() {
                j.this.u();
            }
        });
        RFWThreadManager.getUIHandler().postDelayed(this.f27340l, 5000L);
    }
}

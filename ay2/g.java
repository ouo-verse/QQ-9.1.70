package ay2;

import android.view.View;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g extends k {
    public g(View view) {
        super(view);
        this.f27344d.setIsLandScape(true);
    }

    private void p() {
        this.f27341a.setVisibility(0);
        this.f27344d.setVisibility(0);
        this.f27345e.setVisibility(8);
    }

    private void q() {
        cy2.b.e().B();
        this.f27341a.setVisibility(8);
        this.f27344d.setVisibility(0);
        this.f27345e.setVisibility(0);
    }

    @Override // ay2.k
    public void e() {
        super.e();
        p();
    }

    @Override // ay2.k
    public void g() {
        super.g();
        cy2.b.e().y();
    }

    @Override // ay2.k
    public void h() {
        super.h();
        q();
    }

    @Override // ay2.k
    public void i() {
        super.i();
        cy2.b.e().v();
        this.f27341a.setVisibility(0);
        cy2.b.e().y();
    }

    @Override // ay2.k
    public void j(int i3) {
        this.f27341a.setPadding(i3, 0, i3, 0);
        this.f27344d.setPadding(i3, 0, i3, 0);
    }
}

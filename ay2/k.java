package ay2;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.view.QFSTVideoSeekBar;

/* compiled from: P */
/* loaded from: classes19.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    final View f27341a;

    /* renamed from: b, reason: collision with root package name */
    private final View f27342b;

    /* renamed from: c, reason: collision with root package name */
    protected TextView f27343c;

    /* renamed from: d, reason: collision with root package name */
    protected QFSTVideoSeekBar f27344d;

    /* renamed from: e, reason: collision with root package name */
    LinearLayout f27345e;

    /* renamed from: f, reason: collision with root package name */
    private final TextView f27346f;

    /* renamed from: g, reason: collision with root package name */
    private final TextView f27347g;

    /* renamed from: h, reason: collision with root package name */
    private final View f27348h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f27349i;

    public k(View view) {
        this.f27342b = view;
        this.f27341a = view.findViewById(R.id.f56842lp);
        this.f27344d = (QFSTVideoSeekBar) view.findViewById(R.id.vad);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.vac);
        this.f27345e = linearLayout;
        this.f27346f = (TextView) linearLayout.findViewById(R.id.vah);
        this.f27347g = (TextView) this.f27345e.findViewById(R.id.vag);
        this.f27348h = view.findViewById(R.id.f1189375h);
        this.f27343c = (TextView) view.findViewById(R.id.f56832lo);
        this.f27344d.setIsLandScape(true);
    }

    public void a() {
        this.f27344d.m();
    }

    public QFSTVideoSeekBar b() {
        return this.f27344d;
    }

    public void c() {
        this.f27342b.setVisibility(8);
    }

    public void d() {
        this.f27344d.s();
    }

    public void e() {
        this.f27344d.s();
    }

    public void f(int i3, boolean z16) {
        TextView textView = this.f27347g;
        if (textView != null && z16) {
            textView.setText(jy2.h.f411172a.a(i3));
        }
    }

    public void h() {
        this.f27345e.setVisibility(0);
    }

    public void i() {
        this.f27345e.setVisibility(8);
    }

    public void k() {
        this.f27342b.setVisibility(0);
    }

    public void l(String str) {
        this.f27346f.setText(str);
    }

    public void m(boolean z16) {
        this.f27349i = z16;
    }

    public void n(int i3) {
        this.f27344d.setMax(i3);
    }

    public void o(String str) {
        this.f27343c.setText(str);
    }

    public void g() {
    }

    public void j(int i3) {
    }
}

package ax2;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.QAdUIKit.roundlayout.RoundRelativeLayout;
import pw2.n;
import pw2.s;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends c {
    public a(boolean z16) {
        super(z16);
    }

    private void h(RoundRelativeLayout roundRelativeLayout) {
        RelativeLayout.LayoutParams b16 = b(roundRelativeLayout);
        if (b16 == null) {
            b16 = new RelativeLayout.LayoutParams(-1, -1);
        }
        int a16 = a();
        b16.height = a16;
        b16.width = (a16 * 16) / 9;
        b16.topMargin = 0;
        b16.addRule(13);
        roundRelativeLayout.setLayoutParams(b16);
        roundRelativeLayout.setPadding(0, 0, 0, 0);
        n.a("QAdInteractiveImmersiveLayoutHelper", "setVideoRootLayoutParamsFullScreen in QAdInteractiveImmersiveHorizontalLayoutHelper!!!height = " + b16.height + " , width = " + b16.width);
    }

    private void i(RoundRelativeLayout roundRelativeLayout) {
        RelativeLayout.LayoutParams b16 = b(roundRelativeLayout);
        int c16 = (c() * 9) / 16;
        if (b16 == null) {
            b16 = new RelativeLayout.LayoutParams(-1, c16);
        }
        int a16 = s.a(45.0f);
        b16.height = c16 + a16;
        b16.width = -1;
        b16.addRule(13);
        roundRelativeLayout.setLayoutParams(b16);
        roundRelativeLayout.setPadding(0, a16, 0, 0);
        n.a("QAdInteractiveImmersiveLayoutHelper", "setVideoRootLayoutParamsNormal in QAdInteractiveImmersiveHorizontalLayoutHelper!!!height = " + b16.height + " , width = " + b16.width);
    }

    @Override // ax2.c
    public void e(View view) {
        RelativeLayout.LayoutParams b16 = b(view);
        if (this.f27196a) {
            b16.bottomMargin = 0;
        } else {
            b16.bottomMargin = s.a(45.0f);
        }
        view.setLayoutParams(b16);
    }

    @Override // ax2.c
    public void f(View view) {
        if (view == null) {
            return;
        }
        if (this.f27196a) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        RelativeLayout.LayoutParams b16 = b(view);
        if (b16 != null) {
            b16.bottomMargin = -s.a(24.0f);
            view.setLayoutParams(b16);
        }
    }

    @Override // ax2.c
    public void g(RoundRelativeLayout roundRelativeLayout) {
        if (this.f27196a) {
            h(roundRelativeLayout);
        } else {
            i(roundRelativeLayout);
        }
    }
}

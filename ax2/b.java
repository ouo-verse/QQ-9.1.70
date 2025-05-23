package ax2;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.QAdUIKit.roundlayout.RoundRelativeLayout;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends c {
    public b(boolean z16) {
        super(z16);
    }

    private void h(RoundRelativeLayout roundRelativeLayout) {
        RelativeLayout.LayoutParams b16 = b(roundRelativeLayout);
        if (b16 == null) {
            b16 = new RelativeLayout.LayoutParams(-1, -1);
        }
        int a16 = a();
        b16.height = a16;
        b16.width = (a16 * 9) / 16;
        b16.topMargin = 0;
        b16.addRule(13);
        roundRelativeLayout.setLayoutParams(b16);
        n.a("QAdInteractiveImmersiveLayoutHelper", "setVideoRootLayoutParamsFullScreen in QAdInteractiveImmersiveVerticalLayoutHelper!!!height = " + b16.height + "width = " + b16.width);
    }

    private void i(RoundRelativeLayout roundRelativeLayout) {
        RelativeLayout.LayoutParams b16 = b(roundRelativeLayout);
        if (b16 == null) {
            b16 = new RelativeLayout.LayoutParams(-1, -1);
        }
        int c16 = c();
        b16.width = c16;
        b16.height = (c16 * 16) / 9;
        b16.topMargin = 0;
        b16.addRule(13);
        roundRelativeLayout.setLayoutParams(b16);
        n.a("QAdInteractiveImmersiveLayoutHelper", "setVideoRootLayoutParamsNormal in QAdInteractiveImmersiveVerticalLayoutHelper!!!height = " + b16.height + "width = " + b16.width);
    }

    @Override // ax2.c
    public void e(View view) {
        RelativeLayout.LayoutParams b16 = b(view);
        b16.topMargin = 0;
        view.setLayoutParams(b16);
    }

    @Override // ax2.c
    public void f(View view) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
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

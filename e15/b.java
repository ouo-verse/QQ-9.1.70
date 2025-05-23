package e15;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.mobileqq.vip.diy.common.DIYLottieLoader;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b extends f {
    private boolean C;
    private boolean D;
    protected LottieLoader E;
    private String F;

    public b(String str, View view) {
        super(str, view);
        this.C = false;
        this.D = true;
    }

    @Override // e15.f
    public void l() {
        super.l();
        LottieLoader lottieLoader = this.E;
        if (lottieLoader != null) {
            lottieLoader.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e15.f
    public void m() {
        super.m();
        View view = this.f395367e;
        if (!(view instanceof LottieAnimationView)) {
            return;
        }
        if (this.E == null) {
            this.E = u(view.getContext());
        }
        ((LottieAnimationView) this.f395367e).loop(this.C);
        ((LottieAnimationView) this.f395367e).setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (QLog.isColorLevel()) {
            QLog.i("JsonInflateViewModel", 2, " lottie url = " + this.F);
        }
        LottieLoader lottieLoader = this.E;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f395367e;
        String str = this.F;
        lottieLoader.fromNetworkWithCacheBitmap(lottieAnimationView, str, LottieLoader.makeApolloZipPath(str), this.D);
    }

    @Override // e15.f
    public void n() {
        super.n();
        View view = this.f395367e;
        if (view != null && (view instanceof LottieAnimationView)) {
            ((LottieAnimationView) view).pauseAnimation();
        }
    }

    @Override // e15.f
    public void o() {
        super.o();
        View view = this.f395367e;
        if (view != null && (view instanceof LottieAnimationView)) {
            ((LottieAnimationView) view).playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e15.f
    public void q(String str, String str2) {
        super.q(str, str2);
        if (!(this.f395367e instanceof ImageView)) {
            return;
        }
        if ("content".equals(str)) {
            this.F = str2;
            return;
        }
        boolean z16 = false;
        if ("loop".equals(str)) {
            if (Integer.parseInt(str2) == 1) {
                z16 = true;
            }
            this.C = z16;
        } else if (ShortVideoConstants.IS_AUTO_PLAY.equals(str)) {
            if (Integer.parseInt(str2) == 1) {
                z16 = true;
            }
            this.D = z16;
        }
    }

    protected LottieLoader u(Context context) {
        DIYLottieLoader dIYLottieLoader = new DIYLottieLoader(context);
        dIYLottieLoader.setMemoryCacheSize((int) (sy3.b.a() / 2));
        return dIYLottieLoader;
    }
}

package k00;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static final int f411318c = ScreenUtil.dip2px(240.0f);

    /* renamed from: d, reason: collision with root package name */
    private static final int f411319d = ScreenUtil.dip2px(240.0f);

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f411320a;

    /* renamed from: b, reason: collision with root package name */
    private List<View> f411321b = new ArrayList();

    public void c() {
        if (CollectionUtils.isEmpty(this.f411321b) || this.f411320a == null) {
            return;
        }
        for (View view : this.f411321b) {
            if (view instanceof LottieAnimationView) {
                ((LottieAnimationView) view).cancelAnimation();
                this.f411320a.removeView(view);
            }
        }
        this.f411321b.clear();
    }

    public void d(ViewGroup viewGroup, int i3, int i16) {
        this.f411320a = viewGroup;
        LottieAnimationView lottieAnimationView = new LottieAnimationView(this.f411320a.getContext());
        lottieAnimationView.setAnimation("wsdoublelike/data.json");
        lottieAnimationView.setSpeed(2.0f);
        int i17 = f411318c;
        int i18 = f411319d;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i17, i18);
        layoutParams.setMargins(i3 - (i17 / 2), i16 - (i18 / 2), 0, 0);
        this.f411320a.addView(lottieAnimationView, layoutParams);
        this.f411321b.add(lottieAnimationView);
        lottieAnimationView.addAnimatorListener(new a(lottieAnimationView));
        lottieAnimationView.playAnimation();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a extends com.tencent.mobileqq.widget.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f411322d;

        a(LottieAnimationView lottieAnimationView) {
            this.f411322d = lottieAnimationView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f411322d.removeAnimatorListener(this);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.f411320a.removeView(this.f411322d);
            this.f411322d.removeAnimatorListener(this);
            b.this.f411321b.remove(this.f411322d);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}

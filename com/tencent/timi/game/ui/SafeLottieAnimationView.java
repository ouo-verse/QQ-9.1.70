package com.tencent.timi.game.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.q;
import com.tencent.timi.game.utils.w;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class SafeLottieAnimationView extends LottieAnimationView {
    private boolean C;
    boolean D;
    private boolean E;
    private final LottieListener F;

    /* renamed from: m, reason: collision with root package name */
    boolean f380052m;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements LottieListener<LottieComposition> {
        b() {
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(LottieComposition lottieComposition) {
            if (SafeLottieAnimationView.this.E && lottieComposition.hasImages()) {
                for (Map.Entry<String, LottieImageAsset> entry : lottieComposition.getImages().entrySet()) {
                    if (entry.getValue() != null) {
                        entry.getValue().setBitmap(null);
                    }
                }
            }
            SafeLottieAnimationView.this.setComposition(lottieComposition);
            SafeLottieAnimationView.this.D = true;
        }
    }

    public SafeLottieAnimationView(Context context) {
        super(context);
        this.D = false;
        this.E = false;
        this.F = new b();
        init();
    }

    private void init() {
        this.C = true;
    }

    private void q(String str) {
        try {
            q.f(this, "animationName", str);
            q.f(this, "animationResId", 0);
            q.c(this, "clearComposition", null);
            q.c(this, "cancelLoaderTask", null);
        } catch (Throwable th5) {
            l.e("SafeLottieAnimationView", "resetReflect error " + th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i3) {
        if (!this.C) {
            return;
        }
        if (i3 == 0 && this.f380052m) {
            if (!isAnimating()) {
                resumeAnimation();
            }
        } else if (isAnimating()) {
            this.f380052m = true;
            pauseAnimation();
        } else {
            this.f380052m = false;
        }
        super.onVisibilityChanged(view, i3);
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void pauseAnimation() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.pauseAnimation();
        } else {
            w.a(new Runnable() { // from class: com.tencent.timi.game.ui.SafeLottieAnimationView.2
                @Override // java.lang.Runnable
                public void run() {
                    SafeLottieAnimationView.this.pauseAnimation();
                }
            });
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void playAnimation() {
        super.playAnimation();
        this.f380052m = true;
    }

    @Override // android.view.View
    public void setAnimation(Animation animation) {
        super.setAnimation(animation);
    }

    public void setNeedClearImageCache(boolean z16) {
        this.E = z16;
    }

    public void setAnimation(String str, boolean z16) {
        setNeedClearImageCache(z16);
        setAnimation(str);
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void setAnimation(String str) {
        q(str);
        LottieTask<LottieComposition> fromAsset = LottieCompositionFactory.fromAsset(getContext(), str);
        fromAsset.addListener(this.F);
        fromAsset.addFailureListener(new a());
    }

    public SafeLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = false;
        this.E = false;
        this.F = new b();
        init();
    }

    public SafeLottieAnimationView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = false;
        this.E = false;
        this.F = new b();
        init();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements LottieListener<Throwable> {
        a() {
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th5) {
        }
    }
}

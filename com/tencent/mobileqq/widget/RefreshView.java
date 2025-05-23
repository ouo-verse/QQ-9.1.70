package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RefreshView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private LottieDrawable f316166d;

    /* renamed from: e, reason: collision with root package name */
    private String f316167e;

    /* renamed from: f, reason: collision with root package name */
    private String f316168f;

    /* renamed from: h, reason: collision with root package name */
    private String f316169h;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a(c cVar) {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (Math.abs(RefreshView.this.f316166d.getProgress() - 0.5d) < 0.008333334f) {
                RefreshView.this.f316166d.stop();
                RefreshView.this.f316166d.removeAnimatorUpdateListener(this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
    }

    public RefreshView(Context context) {
        super(context);
        this.f316167e = "refresh_lottie/";
        this.f316168f = "refresh.json";
        this.f316169h = "refresh_night.json";
        c();
    }

    public void c() {
        d(null);
    }

    protected void d(b bVar) {
        if (QQTheme.isNowThemeIsNight()) {
            e(this.f316167e + this.f316169h, bVar);
            return;
        }
        e(this.f316167e + this.f316168f, bVar);
    }

    protected void e(String str, b bVar) {
        try {
            LottieComposition.Factory.fromAssetFileName(getContext(), str, new OnCompositionLoadedListener(bVar) { // from class: com.tencent.mobileqq.widget.RefreshView.1
                @Override // com.airbnb.lottie.OnCompositionLoadedListener
                public void onCompositionLoaded(LottieComposition lottieComposition) {
                    if (lottieComposition == null) {
                        QLog.e("RefreshView", 1, "onCompositionLoaded lottieComposition is null");
                        return;
                    }
                    LottieDrawable lottieDrawable = new LottieDrawable();
                    lottieDrawable.setComposition(lottieComposition);
                    lottieDrawable.loop(true);
                    RefreshView.this.f316166d = lottieDrawable;
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.widget.RefreshView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RefreshView refreshView = RefreshView.this;
                            refreshView.setImageDrawable(refreshView.f316166d);
                        }
                    });
                }
            });
        } catch (Exception e16) {
            QLog.e("RefreshView", 1, "loadEllipsisAnimation fail.", e16);
        }
    }

    public boolean f() {
        QLog.d("PortalFragment", 4, "startLoadingAnim, mEllipsisDrawable : " + this.f316166d);
        LottieDrawable lottieDrawable = this.f316166d;
        if (lottieDrawable != null) {
            lottieDrawable.resumeAnimation();
            return true;
        }
        return false;
    }

    public void g(c cVar) {
        LottieDrawable lottieDrawable = this.f316166d;
        if (lottieDrawable == null) {
            return;
        }
        lottieDrawable.addAnimatorUpdateListener(new a(cVar));
    }

    public void setProgress(float f16) {
        LottieDrawable lottieDrawable = this.f316166d;
        if (lottieDrawable == null) {
            return;
        }
        lottieDrawable.setProgress(f16);
    }

    public void setSpeed(float f16) {
        LottieDrawable lottieDrawable = this.f316166d;
        if (lottieDrawable == null) {
            return;
        }
        lottieDrawable.setSpeed(f16);
    }

    public RefreshView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316167e = "refresh_lottie/";
        this.f316168f = "refresh.json";
        this.f316169h = "refresh_night.json";
        c();
    }

    public RefreshView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316167e = "refresh_lottie/";
        this.f316168f = "refresh.json";
        this.f316169h = "refresh_night.json";
        c();
    }
}

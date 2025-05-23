package com.tencent.gdtad.views.adcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtMvSweepLightView extends FrameLayout {
    private static final int ANIMATION_DURATION = 500;
    private static final String TAG = "GdtMvSweepLightView";
    private final Context mContext;
    private View mRootView;
    private ValueAnimator mSweepLightAnimator;
    private ImageView mSweepLightImg;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (GdtMvSweepLightView.this.mSweepLightImg == null) {
                return;
            }
            GdtMvSweepLightView.this.mSweepLightImg.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public GdtMvSweepLightView(@NonNull Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.f168000ed0, (ViewGroup) this, true);
        this.mRootView = inflate;
        if (inflate == null) {
            QLog.e(TAG, 1, "initView fail: rootView is null");
        } else {
            this.mSweepLightImg = (ImageView) inflate.findViewById(R.id.f9106546);
        }
    }

    public void onDestroy() {
        ValueAnimator valueAnimator = this.mSweepLightAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void startSweepLightAnimation() {
        if (this.mRootView != null && this.mSweepLightImg != null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.mRootView.getWidth() + (ViewUtils.dpToPx(75.0f) * 2));
            this.mSweepLightAnimator = ofFloat;
            ofFloat.setDuration(500L);
            this.mSweepLightAnimator.addUpdateListener(new a());
            this.mSweepLightAnimator.start();
        }
    }

    public GdtMvSweepLightView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public GdtMvSweepLightView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mContext = context;
        initView();
    }

    public GdtMvSweepLightView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.mContext = context;
        initView();
    }
}

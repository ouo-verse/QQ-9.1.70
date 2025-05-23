package com.tencent.gdtad.views.adcard;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.image.GdtAdCardImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtMvBottomAdCardView extends FrameLayout {
    private static final int ALPHA_100_PERCENT = 255;
    private static final int ALPHA_10_PERCENT = 25;
    private static final int ALPHA_30_PERCENT = 76;
    private static final float ALPHA_AD_CONTENT = 0.7f;
    public static final int ANIMATION_DISAPPEAR_DURATION = 200;
    private static final int ANIMATION_DURATION = 500;
    private static int BLUE_COLOR = Color.parseColor("#0099FF");
    private static final int DELAY_TIME_2_SECOND = 2000;
    private static final int DELAY_TIME_3_SECOND = 3000;
    private static final int GDT_MV_AD_CARD_STYLE_DEFAULT = 0;
    private static final int GDT_MV_AD_CARD_STYLE_STATIC = 1;
    private static final String NONE_BUTTON_PRE = "\u70b9\u51fb\u5361\u7247";
    private static final String TAG = "GdtMvBottomAdCardView";
    private Button mAdBtn;
    private TextView mAdBtnDesc;
    private GdtAdCardImageView mAdBtnIcon;
    private LinearLayout mAdBtnLayout;
    private View mAdCardBg;
    private int mAdCardStyle;
    private TextView mAdContent;
    private GdtAdCardImageView mAdLogo;
    private TextView mAdTitle;
    private final List<ValueAnimator> mAnimatorList;
    private final Context mContext;
    private boolean mIsAutoPlayAnimation;
    private boolean mIsNoneButtonStyle;
    private boolean mIsVertical;
    private View mRootView;
    private RelativeLayout mTextArea;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (GdtMvBottomAdCardView.this.mAdTitle != null && GdtMvBottomAdCardView.this.mAdContent != null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                GdtMvBottomAdCardView.this.mAdTitle.setTextColor(intValue);
                GdtMvBottomAdCardView.this.mAdContent.setTextColor(intValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (GdtMvBottomAdCardView.this.mAdBtn == null) {
                return;
            }
            GdtMvBottomAdCardView.this.mAdBtn.getBackground().setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (GdtMvBottomAdCardView.this.mAdCardBg == null) {
                return;
            }
            GdtMvBottomAdCardView.this.mAdCardBg.getBackground().setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public GdtMvBottomAdCardView(@NonNull Context context) {
        super(context);
        this.mIsVertical = true;
        this.mIsAutoPlayAnimation = true;
        this.mIsNoneButtonStyle = false;
        this.mAnimatorList = Collections.synchronizedList(new ArrayList());
        this.mContext = context;
    }

    private void destroyAnimators() {
        for (ValueAnimator valueAnimator : this.mAnimatorList) {
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
        this.mAnimatorList.clear();
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void initStyle() {
        Resources resources = this.mRootView.getResources();
        if (resources == null) {
            return;
        }
        QLog.d(TAG, 1, "initStyle: " + this.mAdCardStyle);
        this.mAdTitle.setTextColor(resources.getColor(R.color.f158017al3));
        this.mAdContent.setTextColor(resources.getColor(R.color.f158017al3));
        this.mAdContent.setAlpha(0.7f);
        if (this.mAdCardStyle == 1) {
            this.mAdCardBg.setBackground(resources.getDrawable(R.drawable.jru));
            if (!isNoneButtonStyle()) {
                this.mAdBtn.setBackground(resources.getDrawable(R.drawable.jrv));
                return;
            }
            return;
        }
        this.mAdCardBg.setBackground(resources.getDrawable(R.drawable.jrw));
        this.mAdCardBg.getBackground().setAlpha(25);
        if (!isNoneButtonStyle()) {
            this.mAdBtn.setBackground(resources.getDrawable(R.drawable.jrv));
            this.mAdBtn.getBackground().setAlpha(76);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAdCardViewValid() {
        if (this.mAdCardBg != null && this.mAdLogo != null && ((this.mAdBtn != null || this.mAdBtnLayout != null) && this.mAdTitle != null && this.mAdContent != null)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNoneButtonStyle() {
        return this.mIsNoneButtonStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStyleWithoutTitle() {
        float f16;
        this.mAdLogo.setVisibility(8);
        this.mAdTitle.setVisibility(8);
        this.mAdContent.setTextSize(17.0f);
        this.mAdContent.setAlpha(1.0f);
        this.mAdContent.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        this.mAdContent.getPaint().setStrokeWidth(0.7f);
        if (this.mIsVertical) {
            this.mAdContent.setGravity(1);
        }
        if (this.mAdContent.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
            ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.mAdContent.getLayoutParams())).topMargin = ViewUtils.dpToPx(32.0f);
            this.mAdContent.requestLayout();
        }
        RelativeLayout relativeLayout = this.mTextArea;
        if (relativeLayout != null && (relativeLayout.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mTextArea.getLayoutParams();
            if (this.mIsVertical) {
                f16 = 16.0f;
            } else {
                f16 = 12.0f;
            }
            layoutParams.leftMargin = ViewUtils.dpToPx(f16);
            this.mTextArea.requestLayout();
        }
    }

    public void bindData(final GdtMvAdCardData gdtMvAdCardData) {
        QLog.d(TAG, 1, "bindData");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.gdtad.views.adcard.GdtMvBottomAdCardView.1
            @Override // java.lang.Runnable
            public void run() {
                GdtMvAdCardData gdtMvAdCardData2;
                if (GdtMvBottomAdCardView.this.isAdCardViewValid() && (gdtMvAdCardData2 = gdtMvAdCardData) != null) {
                    if (TextUtils.isEmpty(gdtMvAdCardData2.adIconUrl) && TextUtils.isEmpty(gdtMvAdCardData.adTitle)) {
                        GdtMvBottomAdCardView.this.setStyleWithoutTitle();
                    } else {
                        GdtMvBottomAdCardView.this.mAdTitle.setText(gdtMvAdCardData.adTitle);
                        Drawable urlDrawable = GdtUIUtils.getUrlDrawable(GdtMvBottomAdCardView.this.getResources(), gdtMvAdCardData.adIconUrl);
                        if (urlDrawable != null) {
                            GdtMvBottomAdCardView.this.mAdLogo.setImageDrawable(urlDrawable);
                        }
                    }
                    GdtMvBottomAdCardView.this.mAdContent.setText(gdtMvAdCardData.adContent);
                    if (GdtMvBottomAdCardView.this.isNoneButtonStyle()) {
                        GdtMvBottomAdCardView.this.mAdBtnDesc.setText(GdtMvBottomAdCardView.NONE_BUTTON_PRE + gdtMvAdCardData.adBtnText);
                        if (GdtUIUtils.needUpdateIcon(gdtMvAdCardData.adBtnText)) {
                            GdtMvBottomAdCardView.this.mAdBtnIcon.setImageDrawable(GdtMvBottomAdCardView.this.getResources().getDrawable(R.drawable.mxw));
                            return;
                        }
                        return;
                    }
                    GdtMvBottomAdCardView.this.mAdBtn.setText(gdtMvAdCardData.adBtnText);
                }
            }
        });
    }

    public View getAdBtn() {
        if (isNoneButtonStyle()) {
            return this.mAdBtnLayout;
        }
        return this.mAdBtn;
    }

    public TextView getAdContent() {
        return this.mAdContent;
    }

    public GdtAdCardImageView getAdLogoView() {
        return this.mAdLogo;
    }

    public TextView getAdTitle() {
        return this.mAdTitle;
    }

    public void initView(int i3, boolean z16, boolean z17, boolean z18) {
        this.mAdCardStyle = i3;
        this.mIsVertical = z16;
        this.mIsNoneButtonStyle = z18;
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (this.mIsVertical) {
            if (z17) {
                this.mRootView = from.inflate(R.layout.ecs, (ViewGroup) this, true);
            } else {
                this.mRootView = from.inflate(R.layout.ecq, (ViewGroup) this, true);
            }
        } else {
            this.mRootView = from.inflate(R.layout.eco, (ViewGroup) this, true);
        }
        View view = this.mRootView;
        if (view == null) {
            QLog.e(TAG, 1, "initView fail: rootView is null");
            return;
        }
        this.mAdLogo = (GdtAdCardImageView) view.findViewById(R.id.f163981fi);
        this.mTextArea = (RelativeLayout) this.mRootView.findViewById(R.id.scb);
        this.mAdTitle = (TextView) this.mRootView.findViewById(R.id.f163993fz);
        this.mAdContent = (TextView) this.mRootView.findViewById(R.id.f163968e4);
        this.mAdCardBg = this.mRootView.findViewById(R.id.sb8);
        this.mAdBtn = (Button) this.mRootView.findViewById(R.id.sav);
        this.mAdBtnLayout = (LinearLayout) this.mRootView.findViewById(R.id.saw);
        GdtAdCardImageView gdtAdCardImageView = (GdtAdCardImageView) this.mRootView.findViewById(R.id.f163965sb2);
        this.mAdBtnIcon = gdtAdCardImageView;
        gdtAdCardImageView.setColorFilter(-1);
        this.mAdBtnDesc = (TextView) this.mRootView.findViewById(R.id.sax);
        if (!isNoneButtonStyle()) {
            this.mAdBtnLayout.setVisibility(8);
            this.mAdBtn.setVisibility(0);
        }
        initStyle();
        updateMvAdCardStyleDelay();
    }

    public void onDestroy() {
        QLog.d(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        destroyAnimators();
        clearAnimation();
        View view = this.mAdCardBg;
        if (view != null) {
            view.clearAnimation();
            this.mAdCardBg = null;
        }
        GdtAdCardImageView gdtAdCardImageView = this.mAdLogo;
        if (gdtAdCardImageView != null) {
            gdtAdCardImageView.clearAnimation();
            this.mAdLogo = null;
        }
        TextView textView = this.mAdTitle;
        if (textView != null) {
            textView.clearAnimation();
            this.mAdTitle = null;
        }
        TextView textView2 = this.mAdContent;
        if (textView2 != null) {
            textView2.clearAnimation();
            this.mAdContent = null;
        }
        Button button = this.mAdBtn;
        if (button != null) {
            button.clearAnimation();
            this.mAdBtn = null;
        }
    }

    public void onDisappear() {
        int i3;
        if (!isAdCardViewValid()) {
            return;
        }
        if (this.mIsVertical) {
            i3 = 100;
        } else {
            i3 = 50;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(i3 + 200);
        alphaAnimation.setAnimationListener(new d());
        this.mAdLogo.startAnimation(alphaAnimation);
        this.mAdTitle.startAnimation(alphaAnimation);
        this.mAdContent.startAnimation(alphaAnimation);
        if (!this.mIsVertical) {
            this.mAdCardBg.startAnimation(alphaAnimation);
        }
    }

    public void setAutoPlayAnimation(boolean z16) {
        this.mIsAutoPlayAnimation = z16;
    }

    public void updateMvAdCardStyleDelay() {
        if (this.mAdCardStyle == 1) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.gdtad.views.adcard.GdtMvBottomAdCardView.2
                @Override // java.lang.Runnable
                public void run() {
                    GdtMvBottomAdCardView.this.updateMvAdCardStyleWithoutAnimation();
                }
            }, 3000L);
        } else {
            if (!this.mIsAutoPlayAnimation) {
                return;
            }
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.gdtad.views.adcard.GdtMvBottomAdCardView.3
                @Override // java.lang.Runnable
                public void run() {
                    GdtMvBottomAdCardView.this.updateMvAdCardStyleWithAnimation();
                }
            }, 2000L);
        }
    }

    public void updateMvAdCardStyleWithAnimation() {
        int i3;
        if (isAdCardViewValid() && (i3 = this.mAdCardStyle) != 0 && i3 != 1) {
            QLog.d(TAG, 1, "updateMvAdCardStyleWithAnimation");
            ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), -1, -16777216);
            ofObject.setDuration(500L);
            ofObject.addUpdateListener(new a());
            ofObject.start();
            this.mAnimatorList.add(ofObject);
            if (isNoneButtonStyle()) {
                this.mAdBtnDesc.setTextColor(BLUE_COLOR);
                this.mAdBtnIcon.setColorFilter(BLUE_COLOR);
            } else {
                this.mAdBtn.setBackground(getResources().getDrawable(R.drawable.jrp));
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(76, 255);
            ofInt.setDuration(500L);
            ofInt.addUpdateListener(new b());
            ofInt.start();
            this.mAnimatorList.add(ofInt);
            this.mAdCardBg.setBackground(getResources().getDrawable(R.drawable.jrw));
            ValueAnimator ofInt2 = ValueAnimator.ofInt(25, 255);
            ofInt2.setDuration(500L);
            ofInt2.addUpdateListener(new c());
            ofInt2.start();
            this.mAnimatorList.add(ofInt2);
        }
    }

    public void updateMvAdCardStyleWithoutAnimation() {
        QLog.d(TAG, 1, "updateMvAdCardStyleWithoutAnimation");
        if (!isAdCardViewValid()) {
            return;
        }
        this.mAdCardBg.setBackground(getResources().getDrawable(R.drawable.jrw));
        if (isNoneButtonStyle()) {
            this.mAdBtnDesc.setTextColor(BLUE_COLOR);
            this.mAdBtnIcon.setColorFilter(BLUE_COLOR);
        } else {
            this.mAdBtn.setBackground(getResources().getDrawable(R.drawable.jrp));
        }
        this.mAdTitle.setTextColor(getResources().getColor(R.color.black));
        this.mAdContent.setTextColor(getResources().getColor(R.color.black));
    }

    public GdtMvBottomAdCardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsVertical = true;
        this.mIsAutoPlayAnimation = true;
        this.mIsNoneButtonStyle = false;
        this.mAnimatorList = Collections.synchronizedList(new ArrayList());
        this.mContext = context;
    }

    public GdtMvBottomAdCardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mIsVertical = true;
        this.mIsAutoPlayAnimation = true;
        this.mIsNoneButtonStyle = false;
        this.mAnimatorList = Collections.synchronizedList(new ArrayList());
        this.mContext = context;
    }

    public GdtMvBottomAdCardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.mIsVertical = true;
        this.mIsAutoPlayAnimation = true;
        this.mIsNoneButtonStyle = false;
        this.mAnimatorList = Collections.synchronizedList(new ArrayList());
        this.mContext = context;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (GdtMvBottomAdCardView.this.mRootView != null) {
                GdtMvBottomAdCardView.this.mRootView.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}

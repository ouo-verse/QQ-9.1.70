package com.tencent.gdtad.views.adcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
public class GdtMvBigBottomAdCardView extends FrameLayout {
    private static final int ANIMATION_DURATION = 400;
    private static int BLUE_COLOR = Color.parseColor("#0099FF");
    private static final String NONE_BUTTON_PRE = "\u70b9\u51fb\u5361\u7247";
    private static final String TAG = "GdtMvBigBottomAdCardView";
    private Button mAdBtn;
    private TextView mAdBtnDesc;
    private GdtAdCardImageView mAdBtnIcon;
    private LinearLayout mAdBtnLayout;
    private RelativeLayout mAdBtnWithSweepLight;
    private View mAdCardBg;
    private RelativeLayout mAdCardContent;
    private TextView mAdContent;
    private GdtAdCardImageView mAdLogo;
    private TextView mAdTitle;
    private final List<ValueAnimator> mAnimatorList;
    private int mBigBottomAdCardHeight;
    private int mBigBottomAdCardWidth;
    private final Context mContext;
    private boolean mIsNoneButtonStyle;
    private boolean mIsStyleWithoutTitle;
    private boolean mIsTipContainerExist;
    private boolean mIsVertical;
    private View mRootView;
    private GdtMvSweepLightView mSweepLightView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f109584d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f109585e;

        a(int i3, float f16) {
            this.f109584d = i3;
            this.f109585e = f16;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (GdtMvBigBottomAdCardView.this.mAdCardBg == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) GdtMvBigBottomAdCardView.this.mAdCardBg.getLayoutParams();
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int dpToPx = (int) (ViewUtils.dpToPx(12.0f) * floatValue);
            layoutParams.leftMargin = dpToPx;
            layoutParams.rightMargin = dpToPx;
            layoutParams.bottomMargin = (int) (this.f109584d * floatValue);
            layoutParams.height = (int) (ViewUtils.dpToPx(147.0f) + ((1.0f - floatValue) * this.f109585e));
            GdtUIUtils.setViewRadius(GdtMvBigBottomAdCardView.this.mAdCardBg, floatValue * 12.0f);
            GdtMvBigBottomAdCardView.this.mAdCardBg.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f109587d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f109588e;

        b(int i3, float f16) {
            this.f109587d = i3;
            this.f109588e = f16;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (GdtMvBigBottomAdCardView.this.mAdCardBg == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) GdtMvBigBottomAdCardView.this.mAdCardBg.getLayoutParams();
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int dpToPx = (int) (ViewUtils.dpToPx(12.0f) * floatValue);
            layoutParams.leftMargin = dpToPx;
            layoutParams.rightMargin = dpToPx;
            layoutParams.bottomMargin = (int) (this.f109587d * floatValue);
            layoutParams.height = (int) (ViewUtils.dpToPx(147.0f) + ((1.0f - floatValue) * this.f109588e));
            GdtUIUtils.setViewRadius(GdtMvBigBottomAdCardView.this.mAdCardBg, floatValue * 12.0f);
            GdtMvBigBottomAdCardView.this.mAdCardBg.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f109590d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f109591e;

        c(int i3, int i16) {
            this.f109590d = i3;
            this.f109591e = i16;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (GdtMvBigBottomAdCardView.this.mAdCardBg != null && GdtMvBigBottomAdCardView.this.mAdBtnWithSweepLight != null && GdtMvBigBottomAdCardView.this.mAdBtn != null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                GdtMvBigBottomAdCardView.this.mAdCardBg.setTranslationX(this.f109590d * floatValue);
                GdtMvBigBottomAdCardView.this.mAdBtnWithSweepLight.setTranslationY(this.f109591e * floatValue);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) GdtMvBigBottomAdCardView.this.mAdBtnWithSweepLight.getLayoutParams();
                layoutParams.leftMargin = ViewUtils.dpToPx((219.0f * floatValue) + 43.5f);
                layoutParams.rightMargin = ViewUtils.dpToPx(43.5f - (15.0f * floatValue));
                layoutParams.width = ViewUtils.dpToPx(319.0f - (100.0f * floatValue));
                layoutParams.height = ViewUtils.dpToPx(45.0f - (13.0f * floatValue));
                GdtMvBigBottomAdCardView.this.mAdBtnWithSweepLight.requestLayout();
                GdtMvBigBottomAdCardView.this.mAdBtn.setTextSize(17.0f - (floatValue * 3.0f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f109593d;

        d(int i3) {
            this.f109593d = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (GdtMvBigBottomAdCardView.this.mAdCardBg == null) {
                return;
            }
            GdtMvBigBottomAdCardView.this.mAdCardBg.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * this.f109593d);
        }
    }

    public GdtMvBigBottomAdCardView(@NonNull Context context) {
        super(context);
        this.mIsVertical = true;
        this.mIsStyleWithoutTitle = false;
        this.mIsTipContainerExist = false;
        this.mIsNoneButtonStyle = false;
        this.mBigBottomAdCardWidth = 0;
        this.mBigBottomAdCardHeight = 0;
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAdCardViewValid() {
        if (this.mRootView != null && this.mAdCardBg != null && this.mAdLogo != null && ((this.mAdBtn != null || this.mAdBtnLayout != null) && this.mAdTitle != null && this.mAdContent != null && this.mAdCardContent != null)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNoneButtonStyle() {
        return this.mIsNoneButtonStyle;
    }

    private void resizeAdCardBg() {
        float f16;
        View view = this.mAdCardBg;
        if (view == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (this.mIsTipContainerExist) {
            f16 = 19.0f;
        } else {
            f16 = 12.0f;
        }
        layoutParams.bottomMargin = ViewUtils.dpToPx(f16);
        int dpToPx = ViewUtils.dpToPx(12.0f);
        layoutParams.leftMargin = dpToPx;
        layoutParams.rightMargin = dpToPx;
        layoutParams.height = ViewUtils.dpToPx(147.0f);
        GdtUIUtils.setViewRadius(this.mAdCardBg, 12.0f);
        this.mAdCardBg.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStyleWithoutTitle() {
        this.mIsStyleWithoutTitle = true;
        this.mAdLogo.setVisibility(4);
        this.mAdTitle.setVisibility(8);
        this.mAdContent.setTextSize(17.0f);
        this.mAdContent.setAlpha(1.0f);
        this.mAdContent.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        this.mAdContent.getPaint().setStrokeWidth(0.7f);
        if (!isAdCardViewValid()) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mAdCardContent.getLayoutParams();
        if (this.mIsVertical) {
            ((RelativeLayout.LayoutParams) this.mRootView.getLayoutParams()).height = ViewUtils.dpToPx(192.0f);
            this.mRootView.requestLayout();
            this.mBigBottomAdCardHeight = ViewUtils.dpToPx(192.0f);
            layoutParams.topMargin = ViewUtils.dpToPx(4.0f);
        } else {
            this.mAdLogo.setVisibility(8);
            layoutParams.height = ViewUtils.dpToPx(152.0f);
        }
        this.mAdCardContent.requestLayout();
    }

    private void startAlphaAnimation() {
        if (!isAdCardViewValid()) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(400L);
        this.mAdLogo.startAnimation(alphaAnimation);
        this.mAdTitle.startAnimation(alphaAnimation);
        this.mAdContent.startAnimation(alphaAnimation);
    }

    private void startShowAnimationHorizontal() {
        int screenWidth;
        int i3;
        float f16;
        if (this.mAdCardBg == null || this.mAdBtnWithSweepLight == null || this.mAdBtn == null || (screenWidth = ViewUtils.getScreenWidth()) == 0) {
            return;
        }
        int i16 = this.mBigBottomAdCardWidth;
        if (this.mIsTipContainerExist) {
            i3 = 19;
        } else {
            i3 = 10;
        }
        int dpToPx = ViewUtils.dpToPx(i3 + 31.5f);
        if (this.mIsStyleWithoutTitle) {
            f16 = 152.0f;
        } else {
            f16 = 243.0f;
        }
        int dpToPx2 = ((int) ((screenWidth - ViewUtils.dpToPx(f16)) / 2.0f)) - dpToPx;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(400L);
        ofFloat.addUpdateListener(new c(i16, dpToPx2));
        ofFloat.start();
        this.mAnimatorList.add(ofFloat);
    }

    private void startShowAnimationHorizontalNoneButton() {
        if (this.mAdCardBg == null || ViewUtils.getScreenWidth() == 0) {
            return;
        }
        int i3 = this.mBigBottomAdCardWidth;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(400L);
        ofFloat.addUpdateListener(new d(i3));
        ofFloat.start();
        this.mAnimatorList.add(ofFloat);
    }

    private void startShowAnimationVertical() {
        float f16;
        float f17;
        if (this.mAdCardBg != null && this.mAdBtnWithSweepLight != null && this.mAdCardContent != null) {
            if (this.mIsTipContainerExist) {
                f16 = 31.0f;
            } else {
                f16 = 24.0f;
            }
            int dpToPx = ViewUtils.dpToPx(f16);
            if (this.mIsTipContainerExist) {
                f17 = 19.0f;
            } else {
                f17 = 12.0f;
            }
            int dpToPx2 = ViewUtils.dpToPx(f17);
            ((FrameLayout.LayoutParams) this.mAdCardContent.getLayoutParams()).bottomMargin = dpToPx;
            this.mAdCardContent.requestLayout();
            resizeAdCardBg();
            float dpToPx3 = this.mBigBottomAdCardHeight - ViewUtils.dpToPx(147.0f);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(400L);
            ofFloat.addUpdateListener(new a(dpToPx2, dpToPx3));
            ofFloat.start();
            this.mAnimatorList.add(ofFloat);
        }
    }

    private void startShowAnimationVerticalNoneButton() {
        float f16;
        float f17;
        if (this.mAdCardBg != null && this.mAdCardContent != null) {
            if (this.mIsTipContainerExist) {
                f16 = 31.0f;
            } else {
                f16 = 24.0f;
            }
            int dpToPx = ViewUtils.dpToPx(f16);
            if (this.mIsTipContainerExist) {
                f17 = 19.0f;
            } else {
                f17 = 12.0f;
            }
            int dpToPx2 = ViewUtils.dpToPx(f17);
            ((FrameLayout.LayoutParams) this.mAdCardContent.getLayoutParams()).bottomMargin = dpToPx;
            this.mAdCardContent.requestLayout();
            resizeAdCardBg();
            float dpToPx3 = this.mBigBottomAdCardHeight - ViewUtils.dpToPx(147.0f);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(400L);
            ofFloat.addUpdateListener(new b(dpToPx2, dpToPx3));
            ofFloat.start();
            this.mAnimatorList.add(ofFloat);
        }
    }

    public void bindData(final GdtMvAdCardData gdtMvAdCardData) {
        QLog.d(TAG, 1, "bindData");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.gdtad.views.adcard.GdtMvBigBottomAdCardView.1
            @Override // java.lang.Runnable
            public void run() {
                GdtMvAdCardData gdtMvAdCardData2;
                if (GdtMvBigBottomAdCardView.this.isAdCardViewValid() && (gdtMvAdCardData2 = gdtMvAdCardData) != null) {
                    if (TextUtils.isEmpty(gdtMvAdCardData2.adIconUrl) && TextUtils.isEmpty(gdtMvAdCardData.adTitle)) {
                        GdtMvBigBottomAdCardView.this.setStyleWithoutTitle();
                    } else {
                        GdtMvBigBottomAdCardView.this.mAdTitle.setText(gdtMvAdCardData.adTitle);
                        Drawable urlDrawable = GdtUIUtils.getUrlDrawable(GdtMvBigBottomAdCardView.this.getResources(), gdtMvAdCardData.adIconUrl);
                        if (urlDrawable != null) {
                            GdtMvBigBottomAdCardView.this.mAdLogo.setImageDrawable(urlDrawable);
                        }
                    }
                    GdtMvBigBottomAdCardView.this.mAdContent.setText(gdtMvAdCardData.adContent);
                    if (GdtMvBigBottomAdCardView.this.isNoneButtonStyle()) {
                        GdtMvBigBottomAdCardView.this.mAdBtnDesc.setText(GdtMvBigBottomAdCardView.NONE_BUTTON_PRE + gdtMvAdCardData.adBtnText);
                        if (GdtUIUtils.needUpdateIcon(gdtMvAdCardData.adBtnText)) {
                            GdtMvBigBottomAdCardView.this.mAdBtnIcon.setImageDrawable(GdtMvBigBottomAdCardView.this.getResources().getDrawable(R.drawable.mxw));
                            return;
                        }
                        return;
                    }
                    GdtMvBigBottomAdCardView.this.mAdBtn.setText(gdtMvAdCardData.adBtnText);
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

    public View getAdContent() {
        return this.mAdContent;
    }

    public View getAdLogoView() {
        return this.mAdLogo;
    }

    public View getAdTitle() {
        return this.mAdTitle;
    }

    public int getBigBottomAdCardHeight() {
        return this.mBigBottomAdCardHeight;
    }

    public int getBigBottomAdCardWidth() {
        return this.mBigBottomAdCardWidth;
    }

    public void initView(boolean z16, boolean z17) {
        this.mIsVertical = z16;
        this.mIsNoneButtonStyle = z17;
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (this.mIsVertical) {
            this.mRootView = from.inflate(R.layout.ecp, (ViewGroup) this, true);
            this.mBigBottomAdCardWidth = ViewUtils.getScreenWidth();
            this.mBigBottomAdCardHeight = ViewUtils.dpToPx(270.0f);
        } else {
            this.mRootView = from.inflate(R.layout.ecr, (ViewGroup) this, true);
            this.mBigBottomAdCardWidth = ViewUtils.dpToPx(270.0f);
            this.mBigBottomAdCardHeight = ViewUtils.getScreenHeight();
        }
        View view = this.mRootView;
        if (view == null) {
            QLog.e(TAG, 1, "initView fail: rootView is null");
            return;
        }
        this.mAdCardContent = (RelativeLayout) view.findViewById(R.id.sbc);
        this.mAdLogo = (GdtAdCardImageView) this.mRootView.findViewById(R.id.f163981fi);
        this.mAdTitle = (TextView) this.mRootView.findViewById(R.id.f163993fz);
        this.mAdContent = (TextView) this.mRootView.findViewById(R.id.f163968e4);
        this.mAdBtnIcon = (GdtAdCardImageView) this.mRootView.findViewById(R.id.f163965sb2);
        this.mAdBtnDesc = (TextView) this.mRootView.findViewById(R.id.sax);
        this.mAdBtnLayout = (LinearLayout) this.mRootView.findViewById(R.id.saw);
        this.mAdBtnDesc.setTextColor(BLUE_COLOR);
        this.mAdBtnIcon.setColorFilter(BLUE_COLOR);
        this.mAdBtn = (Button) this.mRootView.findViewById(R.id.sav);
        this.mAdBtnWithSweepLight = (RelativeLayout) this.mRootView.findViewById(R.id.f163967sb4);
        this.mSweepLightView = (GdtMvSweepLightView) this.mRootView.findViewById(R.id.f163966sb3);
        if (!isNoneButtonStyle()) {
            this.mAdBtnLayout.setVisibility(8);
            this.mAdBtnWithSweepLight.setVisibility(0);
        }
        this.mAdCardBg = this.mRootView.findViewById(R.id.sb8);
        GdtMvSweepLightView gdtMvSweepLightView = this.mSweepLightView;
        if (gdtMvSweepLightView != null) {
            GdtUIUtils.setViewRadius(gdtMvSweepLightView, 30.0f);
        }
        Button button = this.mAdBtn;
        if (button != null) {
            button.setClickable(false);
        }
    }

    public void onDestroy() {
        destroyAnimators();
        View view = this.mAdCardBg;
        if (view != null) {
            view.clearAnimation();
        }
        RelativeLayout relativeLayout = this.mAdBtnWithSweepLight;
        if (relativeLayout != null) {
            relativeLayout.clearAnimation();
        }
        GdtAdCardImageView gdtAdCardImageView = this.mAdLogo;
        if (gdtAdCardImageView != null) {
            gdtAdCardImageView.clearAnimation();
        }
        TextView textView = this.mAdTitle;
        if (textView != null) {
            textView.clearAnimation();
        }
        TextView textView2 = this.mAdContent;
        if (textView2 != null) {
            textView2.clearAnimation();
        }
        GdtMvSweepLightView gdtMvSweepLightView = this.mSweepLightView;
        if (gdtMvSweepLightView != null) {
            gdtMvSweepLightView.onDestroy();
        }
    }

    public void onShow() {
        if (this.mIsVertical) {
            if (this.mIsNoneButtonStyle) {
                startShowAnimationVerticalNoneButton();
            } else {
                startShowAnimationVertical();
            }
        } else if (this.mIsNoneButtonStyle) {
            startShowAnimationHorizontalNoneButton();
        } else {
            startShowAnimationHorizontal();
        }
        startAlphaAnimation();
    }

    public void setIsTipContainerExist(boolean z16) {
        this.mIsTipContainerExist = z16;
    }

    public void startSweepLightAnimation() {
        GdtMvSweepLightView gdtMvSweepLightView = this.mSweepLightView;
        if (gdtMvSweepLightView != null) {
            gdtMvSweepLightView.startSweepLightAnimation();
        }
    }

    public GdtMvBigBottomAdCardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsVertical = true;
        this.mIsStyleWithoutTitle = false;
        this.mIsTipContainerExist = false;
        this.mIsNoneButtonStyle = false;
        this.mBigBottomAdCardWidth = 0;
        this.mBigBottomAdCardHeight = 0;
        this.mAnimatorList = Collections.synchronizedList(new ArrayList());
        this.mContext = context;
    }

    public GdtMvBigBottomAdCardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mIsVertical = true;
        this.mIsStyleWithoutTitle = false;
        this.mIsTipContainerExist = false;
        this.mIsNoneButtonStyle = false;
        this.mBigBottomAdCardWidth = 0;
        this.mBigBottomAdCardHeight = 0;
        this.mAnimatorList = Collections.synchronizedList(new ArrayList());
        this.mContext = context;
    }

    public GdtMvBigBottomAdCardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.mIsVertical = true;
        this.mIsStyleWithoutTitle = false;
        this.mIsTipContainerExist = false;
        this.mIsNoneButtonStyle = false;
        this.mBigBottomAdCardWidth = 0;
        this.mBigBottomAdCardHeight = 0;
        this.mAnimatorList = Collections.synchronizedList(new ArrayList());
        this.mContext = context;
    }
}

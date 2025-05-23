package com.tencent.gdtad.views.adcard;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
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

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtMvEndAdCardView extends FrameLayout {
    private static final int ANIMATION_DURATION = 500;
    private static final int ANIMATION_SHORT_DURATION = 300;
    private static final int GDT_MV_AD_CARD_STYLE_SWIPE_UP = 3;
    private static final String NONE_BUTTON_PRE = "\u70b9\u51fb\u5361\u7247";
    private static final String TAG = "GdtMvBottomAdCardView";
    private TextView mAdBottomDesc;
    private GdtAdCardImageView mAdBottomIcon;
    private Button mAdBtn;
    private LinearLayout mAdBtnLayout;
    private View mAdCardBg;
    private int mAdCardStyle;
    private TextView mAdContent;
    private GdtAdCardImageView mAdLogo;
    private TextView mAdTitle;
    private final Context mContext;
    private boolean mIsNoneButtonStyle;
    private boolean mIsVertical;
    private RelativeLayout mTextArea;

    public GdtMvEndAdCardView(@NonNull Context context) {
        super(context);
        this.mIsVertical = true;
        this.mIsNoneButtonStyle = false;
        this.mContext = context;
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
        this.mAdLogo.setVisibility(8);
        this.mAdTitle.setVisibility(8);
        RelativeLayout relativeLayout = this.mTextArea;
        if (relativeLayout != null) {
            ((FrameLayout.LayoutParams) relativeLayout.getLayoutParams()).topMargin = ViewUtils.dpToPx(24.0f);
            this.mTextArea.requestLayout();
        }
        TextView textView = this.mAdContent;
        if (textView != null) {
            textView.setAlpha(1.0f);
            this.mAdContent.setTextSize(17.0f);
            this.mAdContent.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
            this.mAdContent.getPaint().setStrokeWidth(0.7f);
            ((RelativeLayout.LayoutParams) this.mAdContent.getLayoutParams()).topMargin = ViewUtils.dpToPx(20.0f);
            if (!this.mIsVertical) {
                this.mAdContent.setTextSize(17.0f);
            }
            this.mAdContent.requestLayout();
        }
    }

    public void bindData(final GdtMvAdCardData gdtMvAdCardData, final boolean z16) {
        QLog.d(TAG, 1, "bindData");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.gdtad.views.adcard.GdtMvEndAdCardView.1
            @Override // java.lang.Runnable
            public void run() {
                GdtMvAdCardData gdtMvAdCardData2;
                if (GdtMvEndAdCardView.this.isAdCardViewValid() && (gdtMvAdCardData2 = gdtMvAdCardData) != null) {
                    if (TextUtils.isEmpty(gdtMvAdCardData2.adIconUrl) && TextUtils.isEmpty(gdtMvAdCardData.adTitle)) {
                        GdtMvEndAdCardView.this.setStyleWithoutTitle();
                    } else {
                        GdtMvEndAdCardView.this.mAdTitle.setText(gdtMvAdCardData.adTitle);
                        Drawable urlDrawable = GdtUIUtils.getUrlDrawable(GdtMvEndAdCardView.this.getResources(), gdtMvAdCardData.adIconUrl);
                        if (urlDrawable != null) {
                            GdtMvEndAdCardView.this.mAdLogo.setImageDrawable(urlDrawable);
                        }
                    }
                    GdtMvEndAdCardView.this.mAdContent.setText(gdtMvAdCardData.adContent);
                    if (GdtMvEndAdCardView.this.isNoneButtonStyle()) {
                        GdtMvEndAdCardView.this.mAdBottomDesc.setText(GdtMvEndAdCardView.NONE_BUTTON_PRE + gdtMvAdCardData.adBtnText);
                        if (GdtUIUtils.needUpdateIcon(gdtMvAdCardData.adBtnText)) {
                            GdtMvEndAdCardView.this.mAdBottomIcon.setImageDrawable(GdtMvEndAdCardView.this.getResources().getDrawable(R.drawable.mxw));
                        }
                    } else {
                        GdtMvEndAdCardView.this.mAdBtn.setText(gdtMvAdCardData.adBtnText);
                    }
                    if (z16) {
                        GdtMvEndAdCardView.this.mAdCardBg.setAlpha(0.15f);
                    }
                }
            }
        });
    }

    public void clearNoneButtonColor() {
        GdtAdCardImageView gdtAdCardImageView = this.mAdBottomIcon;
        if (gdtAdCardImageView != null) {
            gdtAdCardImageView.setColorFilter(-1);
        }
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

    public void initView(int i3, boolean z16) {
        this.mAdCardStyle = i3;
        this.mIsNoneButtonStyle = z16;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.ecv, (ViewGroup) this, true);
        if (inflate == null) {
            QLog.e(TAG, 1, "initView fail: rootView is null");
            return;
        }
        this.mAdCardBg = inflate.findViewById(R.id.sb8);
        this.mAdLogo = (GdtAdCardImageView) inflate.findViewById(R.id.f163981fi);
        this.mTextArea = (RelativeLayout) inflate.findViewById(R.id.scb);
        this.mAdTitle = (TextView) inflate.findViewById(R.id.f163993fz);
        this.mAdContent = (TextView) inflate.findViewById(R.id.f163968e4);
        this.mAdBtnLayout = (LinearLayout) inflate.findViewById(R.id.saw);
        this.mAdBottomIcon = (GdtAdCardImageView) inflate.findViewById(R.id.f163965sb2);
        this.mAdBottomDesc = (TextView) inflate.findViewById(R.id.sax);
        Button button = (Button) inflate.findViewById(R.id.sav);
        this.mAdBtn = button;
        button.setClickable(false);
        if (!isNoneButtonStyle()) {
            this.mAdBtnLayout.setVisibility(8);
            this.mAdBtn.setVisibility(0);
        }
    }

    public void setIsVertical(boolean z16) {
        this.mIsVertical = z16;
    }

    public void startAlphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        startAnimation(alphaAnimation);
    }

    public void startEndCardAnimation() {
        if (this.mAdCardStyle < 3) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(500L);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        startAnimation(animationSet);
    }

    public GdtMvEndAdCardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsVertical = true;
        this.mIsNoneButtonStyle = false;
        this.mContext = context;
    }

    public GdtMvEndAdCardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mIsVertical = true;
        this.mIsNoneButtonStyle = false;
        this.mContext = context;
    }

    public GdtMvEndAdCardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.mIsVertical = true;
        this.mIsNoneButtonStyle = false;
        this.mContext = context;
    }
}

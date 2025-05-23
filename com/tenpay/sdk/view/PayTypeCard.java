package com.tenpay.sdk.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tenpay.api.BankImageUtil;
import com.tenpay.pay.PayChannelUtils;

/* loaded from: classes27.dex */
public class PayTypeCard extends FrameLayout {
    protected String available_amount;
    private boolean isArrow;
    protected int isCreditPay;
    protected int isRecommend;
    protected String jump_url;
    protected Context mContext;
    private ImageView mEntryLogo;
    private boolean mIsChangeRightArrow;
    private OnPayTypeCardListener mListener;
    protected ImageView mLogo;
    protected View mMarketingLayout;
    protected TextView mMarketingTitle;
    protected ImageView mRightArrow;
    private CheckBox mRightCheck;
    protected ConstraintLayout mRootLayout;
    protected TextView mSubTitle;
    protected TextView mTitle;
    protected ImageView status_image;
    protected int webankStatus;

    /* loaded from: classes27.dex */
    public interface OnPayTypeCardListener {
        void OnClickDetail();
    }

    public PayTypeCard(Context context) {
        super(context);
        this.isCreditPay = -1;
        this.isRecommend = -1;
        this.webankStatus = 0;
        this.mIsChangeRightArrow = true;
        this.isArrow = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.fyw, (ViewGroup) this, true);
        this.mRootLayout = (ConstraintLayout) inflate.findViewById(R.id.root_layout);
        this.mTitle = (TextView) inflate.findViewById(R.id.title);
        this.mSubTitle = (TextView) inflate.findViewById(R.id.f166931j64);
        this.mLogo = (ImageView) inflate.findViewById(R.id.f166149eh4);
        this.mMarketingLayout = inflate.findViewById(R.id.f165105by1);
        this.mMarketingTitle = (TextView) inflate.findViewById(R.id.uw7);
        this.mEntryLogo = (ImageView) inflate.findViewById(R.id.uw6);
        this.mRightArrow = (ImageView) inflate.findViewById(R.id.i_m);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.f74603wp);
        this.mRightCheck = checkBox;
        checkBox.setVisibility(0);
        setSelected(false);
    }

    private void setRightArrowIconEnable(boolean z16) {
        this.mRightArrow.setVisibility(8);
        this.mRightCheck.setVisibility(8);
        if (z16) {
            if (this.isArrow) {
                this.mRightArrow.setVisibility(0);
            } else {
                this.mRightCheck.setVisibility(0);
            }
        }
    }

    public String getAvailable_amount() {
        return this.available_amount;
    }

    public boolean getIsChangeRightArrow() {
        return this.mIsChangeRightArrow;
    }

    public int getIsCreditPay() {
        return this.isCreditPay;
    }

    public int getMaxTitleViewLen() {
        return (((this.mRightArrow.getLeft() - this.mLogo.getRight()) - 40) - 8) - 5;
    }

    public TextView getTitleTextView() {
        return this.mTitle;
    }

    public int getWebankStatus() {
        return this.webankStatus;
    }

    public void goneArrowAndCheck() {
        this.mRightArrow.setVisibility(8);
        this.mRightCheck.setVisibility(8);
    }

    public void processWeChatEntry(boolean z16, String str, String str2, View.OnClickListener onClickListener) {
        if (z16) {
            showArrow();
            setRightArrowIconEnable(true);
            this.mMarketingTitle.setVisibility(0);
            this.mMarketingTitle.setText(str);
            this.mMarketingTitle.setTextColor(Color.parseColor("#03081A"));
            this.mMarketingTitle.setTextSize(1, 14.0f);
            this.mEntryLogo.setVisibility(0);
            BankImageUtil.getInstance(this.mContext).setBankImage(str2, this.mEntryLogo);
            this.mMarketingLayout.setOnClickListener(onClickListener);
            return;
        }
        this.mMarketingTitle.setVisibility(8);
        this.mEntryLogo.setVisibility(8);
    }

    public void setDisableLogoId(int i3) {
        if (i3 > 0) {
            Drawable drawable = getResources().getDrawable(i3);
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            drawable.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            this.mLogo.setImageAlpha(127);
            this.mLogo.setImageDrawable(drawable);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        super.setEnabled(z16);
        if (z16) {
            this.mTitle.setTextColor(-16777216);
        } else {
            setSelected(false);
            this.mTitle.setTextColor(-4473925);
            this.mSubTitle.setTextColor(-4473925);
        }
        setRightArrowIconEnable(z16);
    }

    public void setListener(OnPayTypeCardListener onPayTypeCardListener) {
        if (onPayTypeCardListener != null) {
            this.mListener = onPayTypeCardListener;
        }
    }

    public void setLogoEnable(boolean z16) {
        if (z16) {
            this.mLogo.setVisibility(0);
        } else {
            this.mLogo.setVisibility(8);
        }
    }

    public void setLogoId(int i3) {
        if (i3 > -1) {
            this.mLogo.setBackgroundResource(i3);
        }
    }

    public void setMarketingTitle(String str) {
        this.mMarketingTitle.setVisibility(0);
        this.mMarketingTitle.setText(str);
        this.mMarketingTitle.setTextColor(getResources().getColor(R.color.f157586tx));
    }

    @Override // android.view.View
    public void setSelected(boolean z16) {
        super.setSelected(z16);
        this.mRightCheck.setChecked(z16);
    }

    public void setSubTitle(boolean z16, String str, String str2, final String str3) {
        if (!z16) {
            this.mSubTitle.setVisibility(8);
            return;
        }
        this.mSubTitle.setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            str = this.mSubTitle.getText().toString();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str2);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.tenpay.sdk.view.PayTypeCard.1
                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view) {
                    k.h(PayTypeCard.this.getContext(), str3);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(@NonNull TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                    textPaint.setColor(PayTypeCard.this.getContext().getColor(R.color.qui_common_text_link));
                }
            }, length, str2.length() + length, 33);
        }
        this.mSubTitle.setText(spannableStringBuilder);
    }

    public void setSubTitleColor(int i3) {
        this.mSubTitle.setTextColor(i3);
    }

    public void setSubTitleGone(boolean z16) {
        if (z16) {
            this.mSubTitle.setVisibility(8);
        } else {
            this.mSubTitle.setVisibility(0);
        }
    }

    public void setTitle(String str) {
        this.mTitle.setText(str);
    }

    public void setTitleSingleLine() {
        this.mTitle.setSingleLine(true);
        this.mTitle.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    }

    public void showArrow() {
        this.mRightArrow.setVisibility(0);
        this.mRightCheck.setVisibility(8);
        this.isArrow = true;
    }

    public void updateBgRound(int i3, int i16) {
        PayChannelUtils.BgRadiusEnum bgRadiusEnum;
        if (i16 <= 0) {
            return;
        }
        if (i16 == 1) {
            bgRadiusEnum = PayChannelUtils.BgRadiusEnum.BothRound;
        } else if (i3 == 0) {
            bgRadiusEnum = PayChannelUtils.BgRadiusEnum.TopRound;
        } else if (i3 == i16 - 1) {
            bgRadiusEnum = PayChannelUtils.BgRadiusEnum.BottomRound;
        } else {
            bgRadiusEnum = PayChannelUtils.BgRadiusEnum.NONE;
        }
        PayChannelUtils.updateBgRound(this.mRootLayout, bgRadiusEnum);
    }

    public void setLogoId(String str, boolean z16) {
        if (z16) {
            BankImageUtil.getInstance(this.mContext).setBankCardDisableLogo(str, this.mLogo);
        } else {
            BankImageUtil.getInstance(this.mContext).setBankImage(str, this.mLogo);
        }
    }

    public void setTitle(int i3) {
        this.mTitle.setText(i3);
    }

    public PayTypeCard(Context context, AttributeSet attributeSet) {
        super(context);
        this.isCreditPay = -1;
        this.isRecommend = -1;
        this.webankStatus = 0;
        this.mIsChangeRightArrow = true;
        this.isArrow = false;
        init(context);
    }

    public void setSubTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mSubTitle.setText(str);
        this.mSubTitle.setVisibility(0);
    }

    public void setSubTitle(int i3) {
        this.mSubTitle.setText(i3);
        this.mSubTitle.setVisibility(0);
    }
}

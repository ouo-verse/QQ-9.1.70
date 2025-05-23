package com.tencent.richframework.text.rich;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.biz.richframework.text.R$styleable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWTailExpandText extends AppCompatTextView {
    private boolean mAllowAnim;
    private int mAnimDuring;
    private String mCloseEndText;
    private int mCloseHeight;
    private CharSequence mCloseText;
    private int mCloseTextColor;
    private String mEllipseText;
    private boolean mEndTextBold;
    private boolean mIsAnimating;
    private boolean mIsOpen;
    private int mLimitLine;
    private String mOpenEndText;
    private int mOpenHeight;
    private int mOpenTextColor;
    private CharSequence mOriginText;
    private int mShowWidth;
    private static final String DEFAULT_OPEN_END_TEXT = HardCodeUtil.qqStr(R.string.f221356al);
    private static final String DEFAULT_CLOSE_END_TEXT = HardCodeUtil.qqStr(R.string.f221366am);
    private static final int DEFAULT_END_TEXT_COLOR = R.color.cod;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface OnExpandCallback {
    }

    public RFWTailExpandText(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 16)
    public void changeStateAnim(boolean z16) {
        if (this.mAllowAnim && this.mIsAnimating) {
            return;
        }
        this.mIsAnimating = true;
        setOpen(z16);
        setContent(this.mOriginText, this.mAllowAnim);
    }

    private void closeAnimatorStart(final SpannableStringBuilder spannableStringBuilder) {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mOpenHeight, this.mCloseHeight);
        ofInt.setDuration(this.mAnimDuring);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.richframework.text.rich.RFWTailExpandText.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RFWTailExpandText.this.setHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.tencent.richframework.text.rich.RFWTailExpandText.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RFWTailExpandText.this.setText(spannableStringBuilder);
                RFWTailExpandText rFWTailExpandText = RFWTailExpandText.this;
                rFWTailExpandText.setHeight(rFWTailExpandText.mCloseHeight);
                RFWTailExpandText.this.mIsAnimating = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                RFWTailExpandText.this.mIsAnimating = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ofInt.start();
    }

    @RequiresApi(api = 16)
    private DynamicLayout getDynamicLayout(SpannableStringBuilder spannableStringBuilder) {
        DynamicLayout.Builder obtain;
        DynamicLayout.Builder alignment;
        DynamicLayout.Builder breakStrategy;
        DynamicLayout.Builder useLineSpacingFromFallbacks;
        DynamicLayout.Builder hyphenationFrequency;
        DynamicLayout.Builder includePad;
        DynamicLayout build;
        if (Build.VERSION.SDK_INT >= 28) {
            obtain = DynamicLayout.Builder.obtain(spannableStringBuilder, getPaint(), this.mShowWidth);
            alignment = obtain.setAlignment(Layout.Alignment.ALIGN_NORMAL);
            breakStrategy = alignment.setBreakStrategy(getBreakStrategy());
            useLineSpacingFromFallbacks = breakStrategy.setUseLineSpacingFromFallbacks(true);
            hyphenationFrequency = useLineSpacingFromFallbacks.setHyphenationFrequency(getHyphenationFrequency());
            includePad = hyphenationFrequency.setIncludePad(true);
            includePad.setLineSpacing(getLineSpacingExtra(), getLineSpacingMultiplier());
            build = obtain.build();
            return build;
        }
        return new DynamicLayout(spannableStringBuilder, getPaint(), this.mShowWidth, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), true);
    }

    private SpannableString getEndSpannable() {
        String str;
        int i3;
        if (this.mIsOpen) {
            str = this.mOpenEndText;
        } else {
            str = this.mCloseEndText;
        }
        SpannableString spannableString = new SpannableString(str);
        setHighlightColor(0);
        spannableString.setSpan(new ClickableSpan() { // from class: com.tencent.richframework.text.rich.RFWTailExpandText.1
            @Override // android.text.style.ClickableSpan
            @RequiresApi(api = 16)
            public void onClick(@NonNull View view) {
                QLog.d("QCircleTailExpandText", 1, "mIsOpen : " + RFWTailExpandText.this.mIsOpen);
                RFWTailExpandText rFWTailExpandText = RFWTailExpandText.this;
                rFWTailExpandText.changeStateAnim(rFWTailExpandText.mIsOpen ^ true);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                textPaint.setUnderlineText(false);
                textPaint.setFakeBoldText(RFWTailExpandText.this.mEndTextBold);
                textPaint.clearShadowLayer();
            }
        }, 0, spannableString.length(), 17);
        setMovementMethod(LinkMovementMethod.getInstance());
        if (this.mIsOpen) {
            i3 = this.mOpenTextColor;
        } else {
            i3 = this.mCloseTextColor;
        }
        spannableString.setSpan(new ForegroundColorSpan(i3), 0, spannableString.length(), 17);
        return spannableString;
    }

    private void init(Context context, AttributeSet attributeSet) {
        String string;
        String string2;
        String string3;
        this.mIsOpen = false;
        this.mIsAnimating = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TailExpandText);
            setLimitLine(obtainStyledAttributes.getInt(R$styleable.TailExpandText_limitLine, 7));
            int dpToPx = ImmersiveUtils.dpToPx(obtainStyledAttributes.getDimension(R$styleable.TailExpandText_showWidth, 0.0f));
            if (dpToPx == 0) {
                dpToPx = ImmersiveUtils.getScreenWidth();
            }
            initShowWidth(dpToPx);
            int i3 = R$styleable.TailExpandText_closeEndText;
            if (obtainStyledAttributes.getString(i3) == null) {
                string = DEFAULT_CLOSE_END_TEXT;
            } else {
                string = obtainStyledAttributes.getString(i3);
            }
            setCloseEndText(string);
            int i16 = R$styleable.TailExpandText_openEndText;
            if (obtainStyledAttributes.getString(i16) == null) {
                string2 = DEFAULT_OPEN_END_TEXT;
            } else {
                string2 = obtainStyledAttributes.getString(i16);
            }
            setOpenEndText(string2);
            int i17 = R$styleable.TailExpandText_ellipseText;
            if (obtainStyledAttributes.getString(i17) == null) {
                string3 = MiniBoxNoticeInfo.APPNAME_SUFFIX;
            } else {
                string3 = obtainStyledAttributes.getString(i17);
            }
            setEllipseText(string3);
            setOpen(obtainStyledAttributes.getBoolean(R$styleable.TailExpandText_defaultOpen, false));
            setAnimDuring(obtainStyledAttributes.getInt(R$styleable.TailExpandText_animDuring, 400));
            setAllowAnim(obtainStyledAttributes.getBoolean(R$styleable.TailExpandText_allowAnim, true));
            int i18 = R$styleable.TailExpandText_openEndTextColor;
            int i19 = DEFAULT_END_TEXT_COLOR;
            setOpenTextColor(obtainStyledAttributes.getResourceId(i18, i19));
            setCloseTextColor(obtainStyledAttributes.getResourceId(R$styleable.TailExpandText_closeEndTextColor, i19));
            setEndTextBold(obtainStyledAttributes.getBoolean(R$styleable.TailExpandText_endTextBold, true));
            obtainStyledAttributes.recycle();
        }
    }

    private void openAnimatorStart(final SpannableStringBuilder spannableStringBuilder) {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mCloseHeight, this.mOpenHeight);
        ofInt.setDuration(this.mAnimDuring);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.richframework.text.rich.RFWTailExpandText.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RFWTailExpandText.this.setHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.tencent.richframework.text.rich.RFWTailExpandText.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RFWTailExpandText rFWTailExpandText = RFWTailExpandText.this;
                rFWTailExpandText.setHeight(rFWTailExpandText.mOpenHeight);
                RFWTailExpandText.this.mIsAnimating = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                RFWTailExpandText.this.mIsAnimating = true;
                RFWTailExpandText.this.setText(spannableStringBuilder);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ofInt.start();
    }

    public void initShowWidth(int i3) {
        this.mShowWidth = (i3 - getPaddingLeft()) - getPaddingRight();
    }

    public void setAllowAnim(boolean z16) {
        this.mAllowAnim = z16;
    }

    public void setAnimDuring(int i3) {
        this.mAnimDuring = i3;
    }

    public void setCloseEndText(String str) {
        this.mCloseEndText = str;
    }

    public void setCloseTextColor(int i3) {
        this.mCloseTextColor = i3;
    }

    @RequiresApi(api = 16)
    public void setContent(String str) {
        setContent(str, false);
    }

    public void setEllipseText(String str) {
        this.mEllipseText = str;
    }

    public void setEndTextBold(boolean z16) {
        this.mEndTextBold = z16;
    }

    public void setLimitLine(int i3) {
        this.mLimitLine = i3;
    }

    public void setOpen(boolean z16) {
        this.mIsOpen = z16;
    }

    public void setOpenEndText(String str) {
        this.mOpenEndText = str;
    }

    public void setOpenTextColor(int i3) {
        this.mOpenTextColor = i3;
    }

    public RFWTailExpandText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @RequiresApi(api = 16)
    private void setContent(CharSequence charSequence, boolean z16) {
        CharSequence charSequence2 = this.mOriginText;
        if (charSequence2 == null || !charSequence2.equals(charSequence)) {
            this.mOriginText = charSequence;
            this.mCloseHeight = 0;
            this.mOpenHeight = 0;
        }
        DynamicLayout dynamicLayout = getDynamicLayout(new SpannableStringBuilder(charSequence));
        int lineCount = dynamicLayout.getLineCount();
        int i3 = this.mLimitLine;
        if (lineCount <= i3) {
            setText(charSequence);
            setHeight(dynamicLayout.getHeight() + getPaddingTop() + getPaddingBottom());
            return;
        }
        if (!this.mIsOpen) {
            if (this.mCloseHeight == 0) {
                int lineEnd = dynamicLayout.getLineEnd(i3);
                this.mCloseText = charSequence.toString().substring(0, lineEnd);
                SpannableStringBuilder append = new SpannableStringBuilder(this.mCloseText).append((CharSequence) this.mEllipseText).append((CharSequence) getEndSpannable());
                DynamicLayout dynamicLayout2 = getDynamicLayout(append);
                getLayout();
                while (dynamicLayout2.getLineCount() > this.mLimitLine) {
                    lineEnd--;
                    this.mCloseText = charSequence.toString().substring(0, lineEnd);
                    append.clear();
                    append.append(this.mCloseText).append(this.mEllipseText).append(getEndSpannable());
                    dynamicLayout2 = getDynamicLayout(append);
                }
                this.mCloseHeight = dynamicLayout2.getHeight() + getPaddingTop() + getPaddingBottom();
            }
            SpannableStringBuilder append2 = new SpannableStringBuilder(this.mCloseText).append((CharSequence) this.mEllipseText).append((CharSequence) getEndSpannable());
            if (this.mAllowAnim && z16) {
                closeAnimatorStart(append2);
                return;
            } else {
                setText(append2);
                setHeight(this.mCloseHeight);
                return;
            }
        }
        SpannableStringBuilder append3 = new SpannableStringBuilder(charSequence).append((CharSequence) "\n").append((CharSequence) getEndSpannable());
        if (this.mOpenHeight == 0) {
            this.mOpenHeight = getDynamicLayout(append3).getHeight() + getPaddingTop() + getPaddingBottom();
        }
        if (this.mAllowAnim && z16) {
            openAnimatorStart(append3);
        } else {
            setText(append3);
            setHeight(this.mOpenHeight);
        }
    }

    public RFWTailExpandText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mEllipseText = MiniBoxNoticeInfo.APPNAME_SUFFIX;
        this.mCloseEndText = DEFAULT_CLOSE_END_TEXT;
        this.mOpenEndText = DEFAULT_OPEN_END_TEXT;
        init(context, attributeSet);
    }

    public void setOnExpandCallback(OnExpandCallback onExpandCallback) {
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i16) {
    }
}

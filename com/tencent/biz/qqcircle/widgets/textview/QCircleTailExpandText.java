package com.tencent.biz.qqcircle.widgets.textview;

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
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.ak;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleTailExpandText extends AppCompatTextView {
    private static final String R = h.a(R.string.f183183ih);
    private static final String S = h.a(R.string.f183193ii);
    private static final int T = R.color.qvideo_skin_color_text_primary;
    private String C;
    private int D;
    private boolean E;
    private int F;
    private int G;
    private boolean H;
    private g I;
    private int J;
    private boolean K;
    private CharSequence L;
    private CharSequence M;
    private int N;
    private int P;
    private boolean Q;

    /* renamed from: h, reason: collision with root package name */
    private int f93899h;

    /* renamed from: i, reason: collision with root package name */
    private String f93900i;

    /* renamed from: m, reason: collision with root package name */
    private String f93901m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        @RequiresApi(api = 16)
        public void onClick(@NonNull View view) {
            QLog.d("QCircleTailExpandText", 1, "mIsOpen : " + QCircleTailExpandText.this.E);
            QCircleTailExpandText qCircleTailExpandText = QCircleTailExpandText.this;
            qCircleTailExpandText.changeStateAnim(qCircleTailExpandText.E ^ true);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(QCircleTailExpandText.this.Q);
            textPaint.clearShadowLayer();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QCircleTailExpandText.this.setHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QCircleTailExpandText.this.setHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface g {
        void a(boolean z16);

        void onContentClick();
    }

    public QCircleTailExpandText(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 16)
    public void changeStateAnim(boolean z16) {
        if (this.K && this.H) {
            return;
        }
        this.H = true;
        setOpen(z16);
        g gVar = this.I;
        if (gVar != null) {
            gVar.a(z16);
        }
        setContent(this.L, this.K);
    }

    private void closeAnimatorStart(SpannableStringBuilder spannableStringBuilder) {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.G, this.F);
        ofInt.setDuration(this.J);
        ofInt.addUpdateListener(new e());
        ofInt.addListener(new f(spannableStringBuilder));
        ofInt.start();
    }

    private DynamicLayout getDynamicLayout(SpannableStringBuilder spannableStringBuilder) {
        DynamicLayout.Builder obtain;
        DynamicLayout.Builder alignment;
        DynamicLayout.Builder breakStrategy;
        DynamicLayout.Builder useLineSpacingFromFallbacks;
        DynamicLayout.Builder hyphenationFrequency;
        DynamicLayout.Builder includePad;
        DynamicLayout build;
        if (Build.VERSION.SDK_INT >= 28) {
            obtain = DynamicLayout.Builder.obtain(spannableStringBuilder, getPaint(), this.D);
            alignment = obtain.setAlignment(Layout.Alignment.ALIGN_NORMAL);
            breakStrategy = alignment.setBreakStrategy(getBreakStrategy());
            useLineSpacingFromFallbacks = breakStrategy.setUseLineSpacingFromFallbacks(isFallbackLineSpacing());
            hyphenationFrequency = useLineSpacingFromFallbacks.setHyphenationFrequency(getHyphenationFrequency());
            includePad = hyphenationFrequency.setIncludePad(getIncludeFontPadding());
            includePad.setLineSpacing(getLineSpacingExtra(), getLineSpacingMultiplier());
            build = obtain.build();
            return build;
        }
        return new DynamicLayout(spannableStringBuilder, getPaint(), this.D, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), getIncludeFontPadding());
    }

    private SpannableString getEndSpannable() {
        String str;
        int i3;
        if (this.E) {
            str = this.C;
        } else {
            str = this.f93901m;
        }
        SpannableString spannableString = new SpannableString(str);
        QCircleSkinHelper qCircleSkinHelper = QCircleSkinHelper.getInstance();
        Context context = getContext();
        if (this.E) {
            i3 = this.P;
        } else {
            i3 = this.N;
        }
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(qCircleSkinHelper.getColor(context, i3));
        setHighlightColor(0);
        spannableString.setSpan(new b(), 0, spannableString.length(), 17);
        setMovementMethod(LinkMovementMethod.getInstance());
        spannableString.setSpan(foregroundColorSpan, 0, spannableString.length(), 17);
        return spannableString;
    }

    private SpannableString i(CharSequence charSequence) {
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new a(), 0, spannableString.length(), 17);
        setMovementMethod(LinkMovementMethod.getInstance());
        return spannableString;
    }

    private void init(Context context, AttributeSet attributeSet) {
        String string;
        String string2;
        String string3;
        this.E = false;
        this.H = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.V9);
            setLimitLine(obtainStyledAttributes.getInt(y91.a.f449628da, 7));
            int dpToPx = ImmersiveUtils.dpToPx(obtainStyledAttributes.getDimension(y91.a.f449667ga, 0.0f));
            if (dpToPx == 0) {
                dpToPx = ImmersiveUtils.getScreenWidth();
            }
            initShowWidth(dpToPx);
            int i3 = y91.a.Y9;
            if (obtainStyledAttributes.getString(i3) == null) {
                string = S;
            } else {
                string = obtainStyledAttributes.getString(i3);
            }
            setCloseEndText(string);
            int i16 = y91.a.f449641ea;
            if (obtainStyledAttributes.getString(i16) == null) {
                string2 = R;
            } else {
                string2 = obtainStyledAttributes.getString(i16);
            }
            setOpenEndText(string2);
            int i17 = y91.a.f449602ba;
            if (obtainStyledAttributes.getString(i17) == null) {
                string3 = MiniBoxNoticeInfo.APPNAME_SUFFIX;
            } else {
                string3 = obtainStyledAttributes.getString(i17);
            }
            setEllipseText(string3);
            setOpen(obtainStyledAttributes.getBoolean(y91.a.f449589aa, false));
            setAnimDuring(obtainStyledAttributes.getInt(y91.a.X9, 200));
            setAllowAnim(obtainStyledAttributes.getBoolean(y91.a.W9, true));
            int i18 = y91.a.f449654fa;
            int i19 = T;
            setOpenTextColor(obtainStyledAttributes.getResourceId(i18, i19));
            setCloseTextColor(obtainStyledAttributes.getResourceId(y91.a.Z9, i19));
            setEndTextBold(obtainStyledAttributes.getBoolean(y91.a.f449615ca, true));
            obtainStyledAttributes.recycle();
        }
    }

    private void openAnimatorStart(SpannableStringBuilder spannableStringBuilder) {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.F, this.G);
        ofInt.setDuration(this.J);
        ofInt.addUpdateListener(new c());
        ofInt.addListener(new d(spannableStringBuilder));
        ofInt.start();
    }

    public void initShowWidth(int i3) {
        int paddingLeft = (i3 - getPaddingLeft()) - getPaddingRight();
        if (paddingLeft < 0) {
            paddingLeft = 0;
        }
        this.D = paddingLeft;
    }

    public void setAllowAnim(boolean z16) {
        this.K = z16;
    }

    public void setAnimDuring(int i3) {
        this.J = i3;
    }

    public void setCloseEndText(String str) {
        this.f93901m = str;
    }

    public void setCloseTextColor(int i3) {
        this.N = i3;
    }

    public void setContent(String str) {
        setContent(str, false);
    }

    public void setEllipseText(String str) {
        this.f93900i = str;
    }

    public void setEndTextBold(boolean z16) {
        this.Q = z16;
    }

    public void setLimitLine(int i3) {
        this.f93899h = i3;
    }

    public void setOnExpandCallback(g gVar) {
        this.I = gVar;
    }

    public void setOpen(boolean z16) {
        this.E = z16;
    }

    public void setOpenEndText(String str) {
        this.C = str;
    }

    public void setOpenTextColor(int i3) {
        this.P = i3;
    }

    public QCircleTailExpandText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setContent(CharSequence charSequence) {
        setContent(charSequence, false);
    }

    public QCircleTailExpandText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93900i = MiniBoxNoticeInfo.APPNAME_SUFFIX;
        this.f93901m = S;
        this.C = R;
        init(context, attributeSet);
    }

    private void setContent(CharSequence charSequence, boolean z16) {
        CharSequence charSequence2 = this.L;
        if (charSequence2 == null || !charSequence2.equals(charSequence)) {
            this.L = charSequence;
            this.F = 0;
            this.G = 0;
        }
        DynamicLayout dynamicLayout = getDynamicLayout(new SpannableStringBuilder(charSequence));
        int lineCount = dynamicLayout.getLineCount();
        int i3 = this.f93899h;
        if (lineCount <= i3) {
            setText(i(charSequence));
            setHeight(dynamicLayout.getHeight() + getPaddingTop() + getPaddingBottom());
            return;
        }
        if (!this.E) {
            if (this.F == 0) {
                int lineEnd = dynamicLayout.getLineEnd(i3 - 1) - 3;
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
                if (lineEnd >= spannableStringBuilder.length()) {
                    lineEnd = spannableStringBuilder.length() - 1;
                }
                if (lineEnd <= 0) {
                    setText(i(charSequence));
                    setHeight(dynamicLayout.getHeight() + getPaddingTop() + getPaddingBottom());
                    return;
                }
                this.M = new SpannableString(spannableStringBuilder.subSequence(0, lineEnd));
                SpannableStringBuilder append = new SpannableStringBuilder(i(this.M)).append((CharSequence) this.f93900i).append((CharSequence) getEndSpannable());
                DynamicLayout dynamicLayout2 = getDynamicLayout(append);
                getLayout();
                while (dynamicLayout2.getLineCount() > this.f93899h) {
                    lineEnd--;
                    this.M = new SpannableString(spannableStringBuilder.subSequence(0, lineEnd));
                    append.clear();
                    append.append(this.M).append(this.f93900i).append(getEndSpannable());
                    dynamicLayout2 = getDynamicLayout(append);
                    getLayout();
                }
                this.F = dynamicLayout2.getHeight() + getPaddingTop() + getPaddingBottom() + 6;
            }
            SpannableStringBuilder append2 = new SpannableStringBuilder(i(this.M)).append((CharSequence) this.f93900i).append((CharSequence) getEndSpannable());
            if (this.K && z16) {
                closeAnimatorStart(append2);
                return;
            } else {
                setText(append2);
                setHeight(this.F);
                return;
            }
        }
        SpannableStringBuilder append3 = new SpannableStringBuilder(i(charSequence)).append((CharSequence) "\n").append((CharSequence) getEndSpannable());
        if (this.G == 0) {
            this.G = getDynamicLayout(append3).getHeight() + getPaddingTop() + getPaddingBottom();
        }
        if (this.K && z16) {
            openAnimatorStart(append3);
        } else {
            setText(append3);
            setHeight(this.G);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        @RequiresApi(api = 16)
        public void onClick(@NonNull View view) {
            if (QCircleTailExpandText.this.I == null) {
                return;
            }
            QCircleTailExpandText.this.I.onContentClick();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d extends ak {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SpannableStringBuilder f93905d;

        d(SpannableStringBuilder spannableStringBuilder) {
            this.f93905d = spannableStringBuilder;
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QCircleTailExpandText qCircleTailExpandText = QCircleTailExpandText.this;
            qCircleTailExpandText.setHeight(qCircleTailExpandText.G);
            QCircleTailExpandText.this.H = false;
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QCircleTailExpandText.this.H = true;
            QCircleTailExpandText.this.setText(this.f93905d);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class f extends ak {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SpannableStringBuilder f93908d;

        f(SpannableStringBuilder spannableStringBuilder) {
            this.f93908d = spannableStringBuilder;
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QCircleTailExpandText.this.setText(this.f93908d);
            QCircleTailExpandText qCircleTailExpandText = QCircleTailExpandText.this;
            qCircleTailExpandText.setHeight(qCircleTailExpandText.F);
            QCircleTailExpandText.this.H = false;
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QCircleTailExpandText.this.H = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i16) {
    }
}

package com.tencent.biz.qqcircle.widgets;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSExpandableAsyncTextView extends QCircleAsyncTextView {
    private static final String W = com.tencent.biz.qqcircle.utils.h.a(R.string.f183183ih);

    /* renamed from: a0, reason: collision with root package name */
    private static final String f93223a0 = com.tencent.biz.qqcircle.utils.h.a(R.string.f183193ii);

    /* renamed from: b0, reason: collision with root package name */
    private static final int f93224b0 = R.color.qvideo_skin_color_icon_hashtag;

    /* renamed from: c0, reason: collision with root package name */
    private static final int f93225c0 = R.color.qvideo_skin_color_icon_hashtag;
    private Spannable E;
    private int F;
    private int G;
    private int H;
    private String I;
    private String J;
    private boolean K;
    private int L;
    private boolean M;
    private boolean N;
    private boolean P;
    private boolean Q;
    private int R;
    private int S;
    private float T;
    private b U;
    private int V;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements QCircleAsyncTextView.b {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.b
        public void onClick() {
            if (QFSExpandableAsyncTextView.this.U != null && QFSExpandableAsyncTextView.this.U.onClick(QFSExpandableAsyncTextView.this.M)) {
                return;
            }
            QFSExpandableAsyncTextView.this.B();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void a(int i3);

        void b(boolean z16);

        boolean onClick(boolean z16);
    }

    public QFSExpandableAsyncTextView(Context context) {
        this(context, null);
    }

    private void A() {
        if (this.P && this.M) {
            z(true);
        } else if (this.Q && !this.M) {
            z(false);
        }
    }

    private void k(SpannableStringBuilder spannableStringBuilder) {
        String str;
        int i3;
        if (this.M) {
            str = this.I;
        } else {
            str = this.J;
        }
        int length = str.length();
        if (this.M) {
            i3 = this.G;
        } else {
            i3 = this.H;
        }
        d(spannableStringBuilder, spannableStringBuilder.length() - length, spannableStringBuilder.length(), new a(), i3, this.K);
        b bVar = this.U;
        if (bVar != null) {
            bVar.b(this.M);
        }
    }

    private String m() {
        return "  " + this.J;
    }

    private CharSequence n(int i3) {
        if (!TextUtils.isEmpty(this.E) && i3 <= this.E.length()) {
            CharSequence subSequence = this.E.subSequence(0, i3);
            if (subSequence.toString().endsWith("\n")) {
                return subSequence.subSequence(0, subSequence.length() - 1);
            }
            return subSequence;
        }
        return this.E;
    }

    private int o(int i3, int i16, int i17) {
        String charSequence;
        if (TextUtils.isEmpty(this.E)) {
            charSequence = "";
        } else {
            charSequence = this.E.subSequence(0, i17).toString();
        }
        return p(i3, i16, i17, i17, com.tencent.biz.qqcircle.utils.bg.c(charSequence).getIndexList(), r6.size() - 1);
    }

    private int p(int i3, int i16, int i17, int i18, List<int[]> list, int i19) {
        int[] iArr;
        if (i18 > i17) {
            return i17;
        }
        if (i18 <= i16) {
            return i16;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(n(i18));
        spannableStringBuilder.append((CharSequence) q());
        if (new DynamicLayout(spannableStringBuilder, getPaint(), i3, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), true).getLineCount() <= this.F) {
            return i18;
        }
        if (i19 > 0 && list != null && list.size() > i19) {
            iArr = list.get(i19);
        } else {
            iArr = null;
        }
        if (iArr != null && iArr.length == 2 && iArr[1] == i18) {
            return p(i3, i16, i17, iArr[0], list, i19 - 1);
        }
        if (i18 < 1) {
            return i18;
        }
        return p(i3, i16, i17, i18 - 1, list, i19);
    }

    private String q() {
        return "... " + this.I;
    }

    private Spannable r() {
        CharSequence n3;
        String str;
        int width;
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(this.E)) {
            QLog.e("QFSExpandableAsyncTextView", 1, "getRealContent mSourceContent is empty");
            return this.E;
        }
        if (this.V <= 0) {
            if (getLayoutParams() != null && getLayoutParams().width > 0) {
                width = getLayoutParams().width;
            } else {
                width = getWidth();
            }
            this.V = width;
        }
        int i3 = this.V;
        QLog.d("QFSExpandableAsyncTextView", 4, "[getRealContent] exactWidth: " + i3);
        if (i3 <= 0) {
            QLog.e("QFSExpandableAsyncTextView", 1, "[getRealContent] exactWidth: " + i3 + ", content: " + com.tencent.biz.qqcircle.immersive.utils.ac.f90062a.a(String.valueOf(this.E)));
            return this.E;
        }
        int paddingLeft = (i3 - getPaddingLeft()) - getPaddingRight();
        DynamicLayout dynamicLayout = new DynamicLayout(this.E, getPaint(), paddingLeft, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), true);
        int lineCount = dynamicLayout.getLineCount();
        b bVar = this.U;
        if (bVar != null) {
            bVar.a(lineCount);
        }
        this.S = dynamicLayout.getHeight();
        int i16 = this.F;
        if (lineCount <= i16) {
            QLog.d("QFSExpandableAsyncTextView", 4, "[getRealContent] lineCount: " + lineCount + ", limitLines: " + this.F);
            return this.E;
        }
        this.R = dynamicLayout.getLineBottom(i16 - 1);
        if (this.M && !this.N) {
            QLog.d("QFSExpandableAsyncTextView", 4, "[getRealContent] mIsExpanded: true, mShowCollapse: false");
            return this.E;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.M) {
            str = m();
            int i17 = lineCount - 1;
            int lineWidth = paddingLeft - ((int) dynamicLayout.getLineWidth(i17));
            if (getPaint() != null && lineWidth < getPaint().measureText(str)) {
                str = "\n" + this.J;
                this.S += dynamicLayout.getLineBottom(i17) - dynamicLayout.getLineTop(i17);
            }
            n3 = this.E;
        } else {
            String q16 = q();
            int i18 = this.F - 1;
            int lineStart = dynamicLayout.getLineStart(i18);
            int lineEnd = dynamicLayout.getLineEnd(i18) - 3;
            if (this.T < 1.0f) {
                lineEnd = (int) (((dynamicLayout.getLineEnd(i18) - lineStart) * this.T) + lineStart);
            }
            if (lineEnd < lineStart) {
                lineEnd = dynamicLayout.getLineEnd(i18);
            }
            n3 = n(o(paddingLeft, lineStart, lineEnd));
            QLog.d("QFSExpandableAsyncTextView", 4, "[getRealContent] finalContent: " + ((Object) n3));
            str = q16;
        }
        spannableStringBuilder.append(n3);
        spannableStringBuilder.append((CharSequence) str);
        k(spannableStringBuilder);
        x(spannableStringBuilder);
        QLog.d("QFSExpandableAsyncTextView", 1, "getRealContent mIsExpanded = " + this.M + ", cosTime = " + (System.currentTimeMillis() - currentTimeMillis));
        return spannableStringBuilder;
    }

    @SuppressLint({"ResourceAsColor"})
    private void t(Context context, AttributeSet attributeSet, int i3) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, y91.a.f449787q6, i3, 0);
        this.F = obtainStyledAttributes.getInt(y91.a.f449863w6, 3);
        this.J = obtainStyledAttributes.getString(y91.a.f449826t6);
        this.I = obtainStyledAttributes.getString(y91.a.f449851v6);
        this.K = obtainStyledAttributes.getBoolean(y91.a.f449876x6, false);
        if (TextUtils.isEmpty(this.I)) {
            this.I = f93223a0;
        }
        if (TextUtils.isEmpty(this.J)) {
            this.J = W;
        }
        this.G = obtainStyledAttributes.getColor(y91.a.f449839u6, f93225c0);
        this.H = obtainStyledAttributes.getColor(y91.a.f449800r6, f93224b0);
        this.L = obtainStyledAttributes.getDimensionPixelSize(y91.a.f449813s6, 0);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = intValue;
        setLayoutParams(layoutParams);
    }

    private void x(SpannableStringBuilder spannableStringBuilder) {
        String str;
        if (this.L != 0 && spannableStringBuilder != null) {
            if (this.M) {
                str = this.I;
            } else {
                str = this.J;
            }
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.L), spannableStringBuilder.length() - str.length(), spannableStringBuilder.length(), 33);
        }
    }

    private void y(CharSequence charSequence) {
        setTextDirectly(charSequence, null);
    }

    private void z(boolean z16) {
        int i3;
        int i16;
        QLog.d("QFSExpandableAsyncTextView", 4, "[showAnim] isExpanded: " + z16 + ", mCollapseHeight: " + this.R + ", mExpandHeight: " + this.S);
        int i17 = this.R;
        if (i17 != 0 && (i3 = this.S) != 0) {
            int[] iArr = new int[2];
            if (z16) {
                i16 = i17;
            } else {
                i16 = i3;
            }
            iArr[0] = i16;
            if (z16) {
                i17 = i3;
            }
            iArr[1] = i17;
            ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.widgets.x
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    QFSExpandableAsyncTextView.this.v(valueAnimator);
                }
            });
            ofInt.start();
        }
    }

    public void B() {
        this.M = !this.M;
        y(r());
        A();
    }

    public int l() {
        return this.V;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView
    public Spannable parserText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        this.E = new SpannableStringBuilder(super.parserText(charSequence));
        return r();
    }

    public int s() {
        int width;
        if (this.V <= 0) {
            if (getLayoutParams() != null && getLayoutParams().width > 0) {
                width = getLayoutParams().width;
            } else {
                width = getWidth();
            }
            this.V = width;
        }
        if (this.V > 0 && !TextUtils.isEmpty(this.E)) {
            int paddingLeft = (this.V - getPaddingLeft()) - getPaddingRight();
            DynamicLayout dynamicLayout = new DynamicLayout(this.E, getPaint(), paddingLeft, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), true);
            QLog.i("QFSExpandableAsyncTextView", 1, "[getRealLineCount] width = " + paddingLeft + ", line count = " + dynamicLayout.getLineCount());
            return dynamicLayout.getLineCount();
        }
        QLog.i("QFSExpandableAsyncTextView", 1, "[getRealLineCount] mExactWidth = " + this.V + ", mSourceContent = " + ((Object) this.E));
        return 0;
    }

    public void setCollapseCollapseListener(b bVar) {
        this.U = bVar;
    }

    public void setCollapseString(String str) {
        this.J = str;
    }

    public void setCollapseTextColor(int i3) {
        this.H = i3;
    }

    public void setEnableCollapseAnim(boolean z16) {
        this.Q = z16;
    }

    public void setEnableExpandAnim(boolean z16) {
        this.P = z16;
    }

    public void setExactWidth(int i3) {
        this.V = i3;
    }

    public void setExpandString(String str) {
        this.I = str;
    }

    public void setExpandTextColor(int i3) {
        this.G = i3;
    }

    public void setExpanded(boolean z16) {
        this.M = z16;
    }

    public void setLastLineWidthRatio(float f16) {
        this.T = f16;
    }

    public void setLimitLines(int i3) {
        this.F = i3;
    }

    public void setShowCollapse(boolean z16) {
        this.N = z16;
    }

    public boolean u() {
        return this.M;
    }

    public void w() {
        this.M = false;
    }

    public QFSExpandableAsyncTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public QFSExpandableAsyncTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.N = true;
        this.P = false;
        this.Q = false;
        this.T = 1.0f;
        t(context, attributeSet, i3);
    }
}

package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FolderTextView extends RelativeLayout {
    private String C;
    private boolean D;
    private int E;
    private int F;
    private boolean G;
    private View.OnClickListener H;

    /* renamed from: d, reason: collision with root package name */
    private TextView f315640d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f315641e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f315642f;

    /* renamed from: h, reason: collision with root package name */
    private int f315643h;

    /* renamed from: i, reason: collision with root package name */
    private int f315644i;

    /* renamed from: m, reason: collision with root package name */
    private int f315645m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (FolderTextView.this.F == 0) {
                FolderTextView.this.F = 1;
            } else {
                FolderTextView.this.F = 0;
            }
            FolderTextView.this.i();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public FolderTextView(Context context) {
        this(context, null);
    }

    private int d(CharSequence charSequence, TextPaint textPaint, float f16) {
        if (TextUtils.isEmpty(charSequence) || f16 <= 0.0f) {
            return 0;
        }
        float measureText = f16 - textPaint.measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX);
        int length = charSequence.length();
        while (h(charSequence, textPaint) > measureText) {
            length = charSequence.length() - 1;
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                Object[] spans = spanned.getSpans(0, charSequence.length(), Object.class);
                for (int i3 = 0; i3 < spans.length; i3++) {
                    int spanStart = spanned.getSpanStart(Integer.valueOf(i3));
                    int spanEnd = spanned.getSpanEnd(Integer.valueOf(i3));
                    if (spanStart != -1 && spanEnd != -1 && (length >= spanStart || length <= spanEnd)) {
                        length = spanStart;
                    }
                }
            }
            if (length <= 0) {
                return 0;
            }
            charSequence = charSequence.subSequence(0, length);
        }
        return length;
    }

    private int e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return -16777216;
        }
        return colorStateList.getColorForState(getDrawableState(), -16777216);
    }

    private void f() {
        TextView textView = new TextView(getContext());
        this.f315640d = textView;
        textView.setId(R.id.mcn);
        this.f315640d.setTextColor(this.f315644i);
        this.f315640d.setTextSize(this.f315643h);
        addView(this.f315640d, new RelativeLayout.LayoutParams(-1, -2));
        TextView textView2 = new TextView(getContext());
        this.f315641e = textView2;
        textView2.setTextSize(this.f315643h);
        this.f315641e.setOnClickListener(this.H);
        this.f315641e.setText(this.C);
        this.f315641e.setTextColor(this.E);
        this.f315641e.setVisibility(4);
        int dip2px = ViewUtils.dip2px(10.0f);
        this.f315641e.setPadding(dip2px, 0, dip2px, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(8, R.id.mcn);
        layoutParams.addRule(7, R.id.mcn);
        addView(this.f315641e, layoutParams);
        if (!TextUtils.isEmpty(this.f315642f)) {
            post(new Runnable() { // from class: com.tencent.mobileqq.widget.FolderTextView.1
                @Override // java.lang.Runnable
                public void run() {
                    FolderTextView.this.i();
                }
            });
        }
        if (SimpleUIUtil.isNowElderMode()) {
            this.f315640d.setLineSpacing(0.0f, 1.3f);
        }
    }

    private Layout g(int i3, CharSequence charSequence) {
        if (j()) {
            return new DynamicLayout(charSequence, this.f315640d.getPaint(), i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        }
        return new StaticLayout(charSequence, this.f315640d.getPaint(), i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private float h(CharSequence charSequence, TextPaint textPaint) {
        return textPaint.measureText(charSequence.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        CharSequence charSequence;
        int measuredWidth = (this.f315640d.getMeasuredWidth() - this.f315640d.getPaddingLeft()) - this.f315640d.getPaddingRight();
        boolean z16 = true;
        if (measuredWidth <= 0) {
            this.F = 1;
            QLog.d("FolderTextView", 1, "updateFoldStatus, layoutWidth <= 0");
        }
        if (this.F == 0) {
            if (this.f315640d.getLayout() != null) {
                measuredWidth = this.f315640d.getLayout().getWidth();
            } else if (QLog.isDebugVersion()) {
                QLog.d("FolderTextView", 4, "getLayout == null");
            }
            Layout g16 = g(measuredWidth, this.f315642f);
            int lineCount = g16.getLineCount();
            int i3 = this.f315645m;
            if (lineCount <= i3) {
                this.f315640d.setText(this.f315642f);
                this.f315641e.setVisibility(4);
                return;
            }
            int lineStart = g16.getLineStart(i3 - 1);
            int lineEnd = g16.getLineEnd(this.f315645m - 1);
            CharSequence charSequence2 = this.f315642f;
            if (charSequence2 instanceof QQText) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append(this.f315642f, lineStart, lineEnd);
                charSequence = spannableStringBuilder;
            } else {
                charSequence = charSequence2.subSequence(lineStart, lineEnd);
            }
            if (QLog.isDebugVersion()) {
                QLog.d("FolderTextView", 4, String.format("mText: %s, lineCount: %s, lastLineText: %s", this.f315642f.toString(), Integer.valueOf(g16.getLineCount()), charSequence));
            }
            int length = charSequence.length();
            CharSequence charSequence3 = charSequence;
            if (length > 0) {
                char charAt = charSequence.toString().charAt(charSequence.length() - 1);
                charSequence3 = charSequence;
                if (charAt == '\n') {
                    if (charSequence.length() == 1) {
                        charSequence3 = "";
                    } else {
                        charSequence3 = charSequence.subSequence(0, charSequence.length() - 1);
                    }
                }
            }
            int d16 = d(charSequence3, this.f315640d.getPaint(), g16.getWidth() - this.f315641e.getMeasuredWidth());
            if (d16 == charSequence3.length()) {
                z16 = false;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append(this.f315642f, 0, d16 + lineStart);
            if (z16) {
                spannableStringBuilder2.append((CharSequence) MiniBoxNoticeInfo.APPNAME_SUFFIX);
            }
            this.f315640d.setText(spannableStringBuilder2);
            if (this.D) {
                this.f315641e.setVisibility(4);
                return;
            } else {
                this.f315641e.setVisibility(0);
                return;
            }
        }
        this.f315640d.setText(this.f315642f);
        this.f315641e.setVisibility(4);
    }

    private boolean j() {
        boolean z16 = this.f315642f instanceof Spannable;
        boolean isTextSelectable = this.f315640d.isTextSelectable();
        if (!z16 && !isTextSelectable) {
            return false;
        }
        return true;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (!this.G) {
            this.G = true;
            i();
        }
    }

    public void setText(CharSequence charSequence) {
        this.f315642f = charSequence;
        this.F = 0;
        if (this.G) {
            i();
        }
    }

    public FolderTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FolderTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.H = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.X1);
        try {
            try {
                this.f315642f = obtainStyledAttributes.getString(jj2.b.f409985a2);
                this.f315644i = e(obtainStyledAttributes.getColorStateList(jj2.b.Z1));
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(jj2.b.Y1, ViewUtils.dip2px(12.0f));
                this.f315643h = dimensionPixelSize;
                this.f315643h = ViewUtils.pxTosp(dimensionPixelSize);
                this.f315645m = obtainStyledAttributes.getInt(jj2.b.f410033e2, 2);
                this.C = obtainStyledAttributes.getString(jj2.b.f410021d2);
                this.D = obtainStyledAttributes.getBoolean(jj2.b.f409997b2, false);
                this.E = obtainStyledAttributes.getColor(jj2.b.f410009c2, context.getResources().getColor(R.color.f157768yz));
            } catch (Exception e16) {
                QLog.d("FolderTextView", 1, "Exception:", e16);
            }
            obtainStyledAttributes.recycle();
            if (TextUtils.isEmpty(this.C)) {
                this.C = HardCodeUtil.qqStr(R.string.mmh);
            }
            if (TextUtils.isEmpty(this.f315642f)) {
                this.f315642f = "";
            }
            this.F = 0;
            f();
        } catch (Throwable th5) {
            obtainStyledAttributes.recycle();
            throw th5;
        }
    }
}

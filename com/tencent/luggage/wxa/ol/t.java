package com.tencent.luggage.wxa.ol;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.MainThread;
import com.tencent.luggage.wxa.ol.a1;
import com.tencent.luggage.wxa.ol.q0;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class t extends i0 {
    public final InputFilter H;
    public float I;
    public float J;
    public float K;
    public float L;
    public com.tencent.luggage.wxa.cm.a M;
    public boolean N;
    public String O;
    public MotionEvent P;
    public boolean Q;
    public final x0 R;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends Spannable.Factory {
        public a() {
        }

        @Override // android.text.Spannable.Factory
        public Spannable newSpannable(CharSequence charSequence) {
            Spannable newSpannable = super.newSpannable(charSequence);
            if (t.this.M != null && !TextUtils.isEmpty(newSpannable)) {
                newSpannable.setSpan(t.this.M, 0, newSpannable.length(), 18);
            }
            return newSpannable;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements q0.c {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.ol.q0.c
        public void a(int i3, int i16) {
            t.this.s();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return t.this.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements InputFilter {
        public d() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            Spannable spannableStringBuilder;
            if (!TextUtils.isEmpty(charSequence) && t.this.M != null) {
                if (charSequence instanceof Spannable) {
                    spannableStringBuilder = (Spannable) charSequence;
                } else {
                    spannableStringBuilder = new SpannableStringBuilder(charSequence);
                }
                spannableStringBuilder.setSpan(t.this.M, 0, spannableStringBuilder.length(), 18);
                return spannableStringBuilder;
            }
            return null;
        }
    }

    public t(Context context) {
        super(context);
        this.H = new d();
        this.J = 0.0f;
        this.K = 1.2f;
        this.L = getTextSize();
        this.N = false;
        this.O = "cursor";
        this.Q = false;
        this.R = new x0(this);
        super.setSingleLine(false);
        super.setLineSpacing(0.0f, 1.0f);
        super.setVerticalScrollbarPosition(2);
        super.setSpannableFactory(new a());
        super.a(new b());
        super.setOnLongClickListener(new c());
        this.I = ViewConfiguration.get(context).getScaledTouchSlop();
        setAutoHeight(false);
        setAdjustKeyboardTo("cursor");
        a(0.0f, false);
    }

    @Override // com.tencent.luggage.wxa.ol.i0, com.tencent.luggage.wxa.ll.c
    public boolean c() {
        if (!this.N) {
            j();
            getMeasuredHeight();
        }
        if (!isFocusable() && !f()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i3) {
        if (j() <= getHeight()) {
            return false;
        }
        return super.canScrollVertically(i3);
    }

    @Override // com.tencent.luggage.wxa.ol.i0, com.tencent.luggage.wxa.ol.q0
    public boolean d() {
        return false;
    }

    public String getAdjustKeyboardTo() {
        return this.O;
    }

    @Override // com.tencent.luggage.wxa.ol.i0, com.tencent.luggage.wxa.ol.q0
    public View getInputPanel() {
        return f0.a((View) this);
    }

    @Override // android.widget.TextView
    public int getLineHeight() {
        com.tencent.luggage.wxa.cm.a aVar = this.M;
        if (aVar != null) {
            return aVar.a();
        }
        return super.getLineHeight();
    }

    @Override // android.widget.TextView
    @Deprecated
    public float getLineSpacingExtra() {
        return super.getLineSpacingExtra();
    }

    @Override // android.widget.TextView
    @Deprecated
    public float getLineSpacingMultiplier() {
        return super.getLineSpacingMultiplier();
    }

    @Override // com.tencent.luggage.wxa.ol.q0
    public boolean h() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.ol.i0
    public void k() {
        a1.b(this).restartInput(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if (r0 != 3) goto L39;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a16;
        if (c() && (getParent() instanceof com.tencent.luggage.wxa.ll.d)) {
            if (motionEvent.getActionMasked() == 0 && !((com.tencent.luggage.wxa.ll.d) getParent()).a(motionEvent)) {
                return false;
            }
            return this.R.a(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.Q) {
                        MotionEvent motionEvent2 = this.P;
                        float x16 = motionEvent2.getX(motionEvent2.getActionIndex());
                        MotionEvent motionEvent3 = this.P;
                        float y16 = motionEvent3.getY(motionEvent3.getActionIndex());
                        float x17 = motionEvent.getX(motionEvent.getActionIndex());
                        float y17 = motionEvent.getY(motionEvent.getActionIndex());
                        if (Math.abs(x16 - x17) > this.I || Math.abs(y16 - y17) > this.I) {
                            cancelLongPress();
                            setPressed(false);
                            this.Q = false;
                        }
                    }
                }
            }
            u();
            if (this.Q && (a16 = a1.a.a(this, motionEvent.getX(motionEvent.getActionIndex()), motionEvent.getY(motionEvent.getActionIndex()))) >= 0) {
                setSelection(a16);
            }
            if (getParent() == null) {
                return true;
            }
        } else {
            this.P = MotionEvent.obtain(motionEvent);
            this.Q = true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performHapticFeedback(int i3, int i16) {
        return super.performHapticFeedback(i3, i16);
    }

    public void s() {
        if (this.N) {
            if (getMeasuredHeight() > getMaxHeight()) {
                setMeasuredDimension(getMeasuredWidth(), getMaxHeight());
            } else if (getMeasuredHeight() < getMinHeight() && getMinHeight() > 0) {
                setMeasuredDimension(getMeasuredWidth(), getMinHeight());
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i3, int i16) {
        super.scrollBy(i3, i16);
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i16) {
        super.scrollTo(i3, i16);
    }

    public void setAdjustKeyboardTo(String str) {
        this.O = str;
    }

    public void setAutoHeight(boolean z16) {
        this.N = z16;
        setVerticalScrollBarEnabled(!z16);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        if (this.H != null) {
            int i3 = 0;
            if (inputFilterArr == null) {
                inputFilterArr = new InputFilter[0];
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            while (i3 < inputFilterArr.length) {
                inputFilterArr2[i3] = inputFilterArr[i3];
                i3++;
            }
            inputFilterArr2[i3] = this.H;
            inputFilterArr = inputFilterArr2;
        }
        super.setFilters(inputFilterArr);
    }

    @Override // android.widget.TextView
    public void setGravity(int i3) {
        super.setGravity((i3 & (-81) & (-17)) | 48);
    }

    @Override // com.tencent.luggage.wxa.ol.i0, android.widget.TextView
    public final void setInputType(int i3) {
        super.setInputType(i3 | 131072);
    }

    @MainThread
    public void setLineHeight(float f16) {
        if (f16 <= 0.0f) {
            return;
        }
        a(f16, true);
    }

    @MainThread
    public void setLineSpace(float f16) {
        setLineSpacing(f16, this.K);
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f16, float f17) {
        this.J = f16;
        this.K = f17;
        t();
    }

    @Override // com.tencent.luggage.wxa.ol.i0, android.widget.TextView
    public void setTextSize(int i3, float f16) {
        super.setTextSize(i3, f16);
        this.L = TypedValue.applyDimension(i3, f16, getResources().getDisplayMetrics());
        t();
    }

    public final void t() {
        a(0.0f, true);
    }

    public final void u() {
        this.Q = false;
        MotionEvent motionEvent = this.P;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.P = null;
        }
    }

    @Override // com.tencent.luggage.wxa.ol.i0
    public Editable a(Editable editable) {
        Editable a16 = super.a(editable);
        if (this.M != null && !TextUtils.isEmpty(a16)) {
            a16.setSpan(this.M, 0, a16.length(), 18);
        }
        return a16;
    }

    public final void a(float f16, boolean z16) {
        if (f16 <= 0.0f) {
            f16 = (this.K * this.L) + this.J;
        }
        com.tencent.luggage.wxa.cm.a aVar = this.M;
        if (aVar == null || aVar.b(f16)) {
            com.tencent.luggage.wxa.cm.a aVar2 = this.M;
            if (aVar2 == null) {
                this.M = new com.tencent.luggage.wxa.cm.a(f16, 17);
            } else {
                aVar2.a(f16);
            }
            if (z16) {
                if (hasFocus()) {
                    invalidate();
                } else {
                    r();
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ol.i0, com.tencent.luggage.wxa.ol.q0
    public void a(float f16, float f17) {
        int a16;
        if (isEnabled()) {
            if (c() && (a16 = a1.a.a(this, f16 + getScrollX(), f17 + getScrollY())) >= 0) {
                setSelection(a16);
            }
            super.performClick();
        }
    }

    @Override // com.tencent.luggage.wxa.ol.i0, android.widget.TextView
    public void setSingleLine(boolean z16) {
    }
}

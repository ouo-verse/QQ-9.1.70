package com.tencent.mobileqq.guild.widget.qqui;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.MovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.MotionEvent;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes14.dex */
public class StatableSpanTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    s12.a f236486d;

    /* renamed from: e, reason: collision with root package name */
    boolean f236487e;

    /* renamed from: f, reason: collision with root package name */
    private ImageSpan[] f236488f;

    /* renamed from: h, reason: collision with root package name */
    private StatableForegroundColorSpan[] f236489h;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class StatableForegroundColorSpan extends ForegroundColorSpan {

        /* renamed from: i, reason: collision with root package name */
        public static final int[] f236490i = {R.attr.state_pressed};

        /* renamed from: d, reason: collision with root package name */
        private int[] f236491d;

        /* renamed from: e, reason: collision with root package name */
        private int f236492e;

        /* renamed from: f, reason: collision with root package name */
        ArrayList<int[]> f236493f;

        /* renamed from: h, reason: collision with root package name */
        ArrayList<Integer> f236494h;

        private int a(int[] iArr) {
            ArrayList<int[]> arrayList = this.f236493f;
            if (arrayList == null) {
                return super.getForegroundColor();
            }
            int size = this.f236494h.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (StateSet.stateSetMatches(arrayList.get(i3), iArr)) {
                    return this.f236494h.get(i3).intValue();
                }
            }
            return super.getForegroundColor();
        }

        public void b(int[] iArr) {
            if (!Arrays.equals(this.f236491d, iArr)) {
                this.f236491d = iArr;
                this.f236492e = a(iArr);
            }
        }

        @Override // android.text.style.ForegroundColorSpan
        public int getForegroundColor() {
            return this.f236492e;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.f236492e);
        }
    }

    public StatableSpanTextView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f236488f != null) {
            int[] drawableState = getDrawableState();
            for (ImageSpan imageSpan : this.f236488f) {
                Drawable drawable = imageSpan.getDrawable();
                if (drawable.isStateful()) {
                    drawable.setState(drawableState);
                }
            }
        }
        if (this.f236489h != null) {
            int[] drawableState2 = getDrawableState();
            for (StatableForegroundColorSpan statableForegroundColorSpan : this.f236489h) {
                statableForegroundColorSpan.b(drawableState2);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action;
        MovementMethod movementMethod = getMovementMethod();
        if ((movementMethod != null || onCheckIsTextEditor()) && isEnabled() && (getText() instanceof Spannable) && getLayout() != null) {
            Spannable spannable = (Spannable) getText();
            if (movementMethod != null && ((action = motionEvent.getAction()) == 1 || action == 0 || action == 3)) {
                int x16 = (int) motionEvent.getX();
                int y16 = (int) motionEvent.getY();
                int totalPaddingLeft = x16 - getTotalPaddingLeft();
                int totalPaddingTop = y16 - getTotalPaddingTop();
                int scrollX = totalPaddingLeft + getScrollX();
                int scrollY = totalPaddingTop + getScrollY();
                Layout layout = getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                s12.a[] aVarArr = (s12.a[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, s12.a.class);
                if (aVarArr.length != 0) {
                    this.f236487e = false;
                    s12.a aVar = aVarArr[0];
                    if (action == 0) {
                        aVar.setPressed(this, true);
                        this.f236486d = aVar;
                    } else {
                        s12.a aVar2 = this.f236486d;
                        if (aVar2 != null) {
                            aVar2.setPressed(this, false);
                            this.f236486d = null;
                        }
                        if (action == 1) {
                            aVar.onClick(this);
                        }
                    }
                    return true;
                }
                if (action == 1) {
                    if (this.f236487e) {
                        this.f236487e = false;
                        performClick();
                    }
                } else if (action == 0) {
                    this.f236487e = true;
                } else if (action == 3) {
                    this.f236487e = false;
                }
                s12.a aVar3 = this.f236486d;
                if (aVar3 != null) {
                    aVar3.setPressed(this, false);
                    this.f236486d = null;
                }
            }
        }
        return false;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (charSequence != null && (charSequence instanceof Spannable)) {
            Spannable spannable = (Spannable) charSequence;
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
            this.f236488f = imageSpanArr;
            if (imageSpanArr != null) {
                ArrayList arrayList = new ArrayList();
                for (ImageSpan imageSpan : this.f236488f) {
                    arrayList.add(imageSpan);
                }
                if (arrayList.size() > 0) {
                    ImageSpan[] imageSpanArr2 = new ImageSpan[arrayList.size()];
                    this.f236488f = imageSpanArr2;
                    this.f236488f = (ImageSpan[]) arrayList.toArray(imageSpanArr2);
                } else {
                    this.f236488f = null;
                }
            }
            this.f236489h = (StatableForegroundColorSpan[]) spannable.getSpans(0, spannable.length(), StatableForegroundColorSpan.class);
        } else {
            this.f236488f = null;
            this.f236489h = null;
        }
        super.setText(charSequence, bufferType);
    }

    public StatableSpanTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StatableSpanTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}

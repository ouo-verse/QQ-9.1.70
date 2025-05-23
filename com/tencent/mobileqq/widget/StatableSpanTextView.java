package com.tencent.mobileqq.widget;

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
import com.tencent.mobileqq.text.ClickableImageSpan;
import com.tencent.mobileqq.text.ITopic;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes20.dex */
public class StatableSpanTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    ITopic f316311d;

    /* renamed from: e, reason: collision with root package name */
    boolean f316312e;

    /* renamed from: f, reason: collision with root package name */
    private ImageSpan[] f316313f;

    /* renamed from: h, reason: collision with root package name */
    private StatableForegroundColorSpan[] f316314h;

    public StatableSpanTextView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f316313f != null) {
            int[] drawableState = getDrawableState();
            for (ImageSpan imageSpan : this.f316313f) {
                Drawable drawable = imageSpan.getDrawable();
                if (drawable.isStateful()) {
                    drawable.setState(drawableState);
                }
            }
        }
        if (this.f316314h != null) {
            int[] drawableState2 = getDrawableState();
            for (StatableForegroundColorSpan statableForegroundColorSpan : this.f316314h) {
                statableForegroundColorSpan.c(drawableState2);
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
                ITopic[] iTopicArr = (ITopic[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ITopic.class);
                if (iTopicArr.length != 0) {
                    this.f316312e = false;
                    ITopic iTopic = iTopicArr[0];
                    if (action == 0) {
                        iTopic.setPressed(this, true);
                        this.f316311d = iTopic;
                    } else {
                        ITopic iTopic2 = this.f316311d;
                        if (iTopic2 != null) {
                            iTopic2.setPressed(this, false);
                            this.f316311d = null;
                        }
                        if (action == 1) {
                            iTopic.onClick(this);
                        }
                    }
                    return true;
                }
                if (action == 1) {
                    if (this.f316312e) {
                        this.f316312e = false;
                        performClick();
                    }
                } else if (action == 0) {
                    this.f316312e = true;
                } else if (action == 3) {
                    this.f316312e = false;
                }
                ITopic iTopic3 = this.f316311d;
                if (iTopic3 != null) {
                    iTopic3.setPressed(this, false);
                    this.f316311d = null;
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
            this.f316313f = imageSpanArr;
            if (imageSpanArr != null) {
                ArrayList arrayList = new ArrayList();
                for (ImageSpan imageSpan : this.f316313f) {
                    if (!(imageSpan instanceof ClickableImageSpan)) {
                        arrayList.add(imageSpan);
                    }
                }
                if (arrayList.size() > 0) {
                    ImageSpan[] imageSpanArr2 = new ImageSpan[arrayList.size()];
                    this.f316313f = imageSpanArr2;
                    this.f316313f = (ImageSpan[]) arrayList.toArray(imageSpanArr2);
                } else {
                    this.f316313f = null;
                }
            }
            this.f316314h = (StatableForegroundColorSpan[]) spannable.getSpans(0, spannable.length(), StatableForegroundColorSpan.class);
        } else {
            this.f316313f = null;
            this.f316314h = null;
        }
        super.setText(charSequence, bufferType);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class StatableForegroundColorSpan extends ForegroundColorSpan {

        /* renamed from: i, reason: collision with root package name */
        public static final int[] f316315i = {R.attr.state_pressed};

        /* renamed from: d, reason: collision with root package name */
        private int[] f316316d;

        /* renamed from: e, reason: collision with root package name */
        private int f316317e;

        /* renamed from: f, reason: collision with root package name */
        ArrayList<int[]> f316318f;

        /* renamed from: h, reason: collision with root package name */
        ArrayList<Integer> f316319h;

        public StatableForegroundColorSpan(int i3) {
            super(i3);
            this.f316317e = i3;
        }

        private int b(int[] iArr) {
            ArrayList<int[]> arrayList = this.f316318f;
            if (arrayList == null) {
                return super.getForegroundColor();
            }
            int size = this.f316319h.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (StateSet.stateSetMatches(arrayList.get(i3), iArr)) {
                    return this.f316319h.get(i3).intValue();
                }
            }
            return super.getForegroundColor();
        }

        public int a(int[] iArr, Integer num) {
            if (this.f316318f == null) {
                this.f316318f = new ArrayList<>();
                this.f316319h = new ArrayList<>();
            }
            this.f316318f.add(iArr);
            this.f316319h.add(num);
            return this.f316319h.size();
        }

        public void c(int[] iArr) {
            if (!Arrays.equals(this.f316316d, iArr)) {
                this.f316316d = iArr;
                this.f316317e = b(iArr);
            }
        }

        @Override // android.text.style.ForegroundColorSpan
        public int getForegroundColor() {
            return this.f316317e;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.f316317e);
        }

        public StatableForegroundColorSpan(int i3, int i16) {
            this(i3);
            a(f316315i, Integer.valueOf(i16));
        }
    }

    public StatableSpanTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StatableSpanTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}

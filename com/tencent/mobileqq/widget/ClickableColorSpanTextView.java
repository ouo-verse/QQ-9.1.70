package com.tencent.mobileqq.widget;

import android.content.Context;
import android.text.Spannable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.widget.StatableSpanTextView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ClickableColorSpanTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private a f315532d;

    /* renamed from: e, reason: collision with root package name */
    private StatableSpanTextView.StatableForegroundColorSpan[] f315533e;

    /* renamed from: f, reason: collision with root package name */
    private StatableSpanTextView.StatableForegroundColorSpan f315534f;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(ClickableColorSpanTextView clickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan statableForegroundColorSpan);
    }

    public ClickableColorSpanTextView(Context context) {
        super(context);
    }

    private float a(float f16) {
        return Math.min((getWidth() - getTotalPaddingRight()) - 1, Math.max(0.0f, f16 - getTotalPaddingLeft())) + getScrollX();
    }

    private int b(float f16) {
        return getLayout().getLineForVertical((int) (Math.min((getHeight() - getTotalPaddingBottom()) - 1, Math.max(0.0f, f16 - getTotalPaddingTop())) + getScrollY()));
    }

    private int c(int i3, float f16) {
        return getLayout().getOffsetForHorizontal(i3, a(f16));
    }

    @Override // android.widget.TextView
    public int getOffsetForPosition(float f16, float f17) {
        if (getLayout() == null) {
            return -1;
        }
        return c(b(f17), f16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        if (r0 != 3) goto L37;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        StatableSpanTextView.StatableForegroundColorSpan statableForegroundColorSpan;
        a aVar;
        if (this.f315533e != null && (getText() instanceof Spannable)) {
            int offsetForPosition = getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
            StatableSpanTextView.StatableForegroundColorSpan[] statableForegroundColorSpanArr = this.f315533e;
            int length = statableForegroundColorSpanArr.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    statableForegroundColorSpan = statableForegroundColorSpanArr[i3];
                    int spanStart = ((Spannable) getText()).getSpanStart(statableForegroundColorSpan);
                    int spanEnd = ((Spannable) getText()).getSpanEnd(statableForegroundColorSpan);
                    if (offsetForPosition > spanStart && offsetForPosition < spanEnd) {
                        break;
                    }
                    i3++;
                } else {
                    statableForegroundColorSpan = null;
                    break;
                }
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        StatableSpanTextView.StatableForegroundColorSpan statableForegroundColorSpan2 = this.f315534f;
                        if (statableForegroundColorSpan2 == statableForegroundColorSpan && statableForegroundColorSpan2 != null) {
                            return true;
                        }
                    }
                }
                StatableSpanTextView.StatableForegroundColorSpan statableForegroundColorSpan3 = this.f315534f;
                if (statableForegroundColorSpan3 != null) {
                    if (statableForegroundColorSpan3 == statableForegroundColorSpan && (aVar = this.f315532d) != null) {
                        aVar.a(this, statableForegroundColorSpan3);
                    }
                    this.f315534f.c(StateSet.WILD_CARD);
                    this.f315534f = null;
                    invalidate();
                }
            } else if (statableForegroundColorSpan != null) {
                statableForegroundColorSpan.c(StatableSpanTextView.StatableForegroundColorSpan.f316315i);
                this.f315534f = statableForegroundColorSpan;
                invalidate();
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSpanClickListener(a aVar) {
        this.f315532d = aVar;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (charSequence != null && (charSequence instanceof Spannable)) {
            Spannable spannable = (Spannable) charSequence;
            this.f315533e = (StatableSpanTextView.StatableForegroundColorSpan[]) spannable.getSpans(0, spannable.length(), StatableSpanTextView.StatableForegroundColorSpan.class);
            bufferType = TextView.BufferType.SPANNABLE;
        } else {
            this.f315533e = null;
        }
        super.setText(charSequence, bufferType);
    }

    public ClickableColorSpanTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ClickableColorSpanTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}

package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R;

/* compiled from: P */
@Deprecated
/* loaded from: classes9.dex */
public class MMAutoAdjustTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    public Paint f153965a;

    /* renamed from: b, reason: collision with root package name */
    public float f153966b;

    /* renamed from: c, reason: collision with root package name */
    public float f153967c;

    public MMAutoAdjustTextView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.f153966b = getTextSize();
        this.f153967c = o.b(getContext());
        Paint paint = new Paint();
        this.f153965a = paint;
        paint.set(getPaint());
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (i3 != i17) {
            a(getText().toString(), i3);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        super.onTextChanged(charSequence, i3, i16, i17);
        a(charSequence.toString(), getWidth());
    }

    public MMAutoAdjustTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context.obtainStyledAttributes(attributeSet, R.styleable.MMAutoAdjustTextView));
        a();
    }

    public final void a(TypedArray typedArray) {
        if (typedArray != null) {
            typedArray.recycle();
        }
    }

    public MMAutoAdjustTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context.obtainStyledAttributes(attributeSet, R.styleable.MMAutoAdjustTextView));
        a();
    }

    public final void a(String str, int i3) {
        if (i3 <= 0) {
            return;
        }
        measure(0, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        int measuredWidth = getMeasuredWidth();
        while (measuredWidth > i3) {
            float a16 = this.f153966b - o.a(getContext());
            this.f153966b = a16;
            setTextSize(0, a16 * this.f153967c);
            measure(0, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            measuredWidth = getMeasuredWidth();
        }
    }
}

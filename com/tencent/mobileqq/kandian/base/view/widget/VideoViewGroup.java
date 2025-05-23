package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes33.dex */
public class VideoViewGroup extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private boolean f239190d;

    /* renamed from: e, reason: collision with root package name */
    private float f239191e;

    /* renamed from: f, reason: collision with root package name */
    private float f239192f;

    public VideoViewGroup(Context context) {
        this(context, null);
    }

    private void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VideoViewGroup);
        this.f239191e = obtainStyledAttributes.getFloat(1, 0.0f);
        this.f239192f = obtainStyledAttributes.getFloat(0, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public void a(boolean z16) {
        this.f239190d = z16;
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        View.MeasureSpec.getMode(i3);
        View.MeasureSpec.getMode(i16);
        if (this.f239190d) {
            float f16 = this.f239191e;
            if (f16 == 1.0f) {
                float f17 = this.f239192f;
                if (f17 != 1.0f) {
                    int i17 = (int) (size * f17);
                    super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(i17, 1073741824));
                    setMeasuredDimension(size, i17);
                    return;
                }
            }
            if (f16 != 1.0f && this.f239192f == 1.0f) {
                super.onMeasure(i3, i16);
                setMeasuredDimension((int) (size2 * f16), size2);
                return;
            }
            if (f16 == 1.0f) {
                float f18 = this.f239192f;
                if (f18 == 1.0f) {
                    int i18 = (int) (size * f18);
                    super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
                    setMeasuredDimension(size, i18);
                    return;
                }
            }
            super.onMeasure(i3, i16);
            return;
        }
        super.onMeasure(i3, i16);
    }

    public void setCustomSize(float f16, float f17) {
        this.f239191e = f16;
        this.f239192f = f17;
        requestLayout();
    }

    public VideoViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoViewGroup(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f239190d = true;
        this.f239191e = 0.0f;
        this.f239192f = 0.0f;
        b(attributeSet);
    }
}

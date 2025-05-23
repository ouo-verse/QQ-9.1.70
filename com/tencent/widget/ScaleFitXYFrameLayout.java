package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ScaleFitXYFrameLayout extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Context f384664d;

    /* renamed from: e, reason: collision with root package name */
    private float f384665e;

    /* renamed from: f, reason: collision with root package name */
    private float f384666f;

    public ScaleFitXYFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f384665e = 1.0f;
        this.f384666f = 1.0f;
        this.f384664d = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScaleFitXYFrameLayout);
        this.f384665e = obtainStyledAttributes.getFloat(R.styleable.ScaleFitXYFrameLayout_layout_width_weight, 1.0f);
        this.f384666f = obtainStyledAttributes.getFloat(R.styleable.ScaleFitXYFrameLayout_layout_height_weight, 1.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        View.MeasureSpec.getSize(i16);
        if (this.f384665e == 1.0f) {
            if (mode != 0) {
                int i17 = (int) (size * this.f384666f);
                setMeasuredDimension(size, i17);
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, mode);
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i17, mode2);
            } else {
                setMeasuredDimension(0, 0);
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, mode);
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, mode2);
            }
            measureChildren(makeMeasureSpec, makeMeasureSpec2);
        }
    }
}

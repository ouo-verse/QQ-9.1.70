package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class LargeAreaPatchedButton extends PatchedButton {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private int E;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private int f384607d;

    /* renamed from: e, reason: collision with root package name */
    private int f384608e;

    /* renamed from: f, reason: collision with root package name */
    private int f384609f;

    /* renamed from: h, reason: collision with root package name */
    private int f384610h;

    /* renamed from: i, reason: collision with root package name */
    private final int f384611i;

    /* renamed from: m, reason: collision with root package name */
    private int f384612m;

    public LargeAreaPatchedButton(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f384607d = -1;
        this.f384608e = -1;
        this.f384609f = -1;
        this.f384610h = -1;
        this.f384611i = 0;
        this.f384612m = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LargeTouchableAreaView);
        int dimension = (int) obtainStyledAttributes.getDimension(R.styleable.LargeTouchableAreaView_addition, 0.0f);
        this.f384612m = dimension;
        this.C = dimension;
        this.D = dimension;
        this.E = dimension;
        this.F = 1;
        this.f384612m = (int) obtainStyledAttributes.getDimension(R.styleable.LargeTouchableAreaView_additionBottom, dimension);
        this.C = (int) obtainStyledAttributes.getDimension(R.styleable.LargeTouchableAreaView_additionLeft, this.C);
        this.D = (int) obtainStyledAttributes.getDimension(R.styleable.LargeTouchableAreaView_additionRight, this.D);
        this.E = (int) obtainStyledAttributes.getDimension(R.styleable.LargeTouchableAreaView_additionTop, this.E);
        this.F = obtainStyledAttributes.getInt(R.styleable.LargeTouchableAreaView_additionTouchDelegateCount, this.F);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (i3 != this.f384607d || i16 != this.f384610h || i17 != this.f384608e || i18 != this.f384609f) {
            this.f384607d = i3;
            this.f384610h = i16;
            this.f384608e = i17;
            this.f384609f = i18;
            TouchDelegate touchDelegate = new TouchDelegate(new Rect(i3 - this.C, i16 - this.E, i17 + this.D, i18 + this.f384612m), this);
            ViewParent parent = getParent();
            for (int i19 = 0; i19 < this.F; i19++) {
                if (parent instanceof View) {
                    ((View) parent).setTouchDelegate(touchDelegate);
                    parent = parent.getParent();
                }
            }
        }
    }

    public LargeAreaPatchedButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f384607d = -1;
        this.f384608e = -1;
        this.f384609f = -1;
        this.f384610h = -1;
        this.f384611i = 0;
        this.f384612m = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        a(context, attributeSet);
    }

    public LargeAreaPatchedButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f384607d = -1;
        this.f384608e = -1;
        this.f384609f = -1;
        this.f384610h = -1;
        this.f384611i = 0;
        this.f384612m = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        a(context, attributeSet);
    }
}

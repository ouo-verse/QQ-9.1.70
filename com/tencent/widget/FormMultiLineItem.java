package com.tencent.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.o;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FormMultiLineItem extends RelativeLayout {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f384561d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<MultiImageTextView> f384562e;

    /* renamed from: f, reason: collision with root package name */
    private int f384563f;

    /* renamed from: h, reason: collision with root package name */
    private int f384564h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f384565i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f384566m;

    public FormMultiLineItem(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MultiLineItem);
        try {
            try {
                if (this.f384564h < 0) {
                    this.f384564h = obtainStyledAttributes.getInt(R.styleable.MultiLineItem_line_num, 2);
                }
                this.F = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MultiLineItem_image_width, 0);
                this.E = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MultiLineItem_image_height, 0);
                this.D = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MultiLineItem_min_height, 0);
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158555is);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.f158556iu);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.f158553iq);
                this.G = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MultiLineItem_left_margin, dimensionPixelSize);
                this.H = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MultiLineItem_right_margin, dimensionPixelSize2);
                this.I = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MultiLineItem_picture_text_margin, dimensionPixelSize3);
                this.f384563f = obtainStyledAttributes.getInteger(R.styleable.MultiLineItem_bg_type, 0);
                this.f384566m = obtainStyledAttributes.getBoolean(u51.a.Z, true);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("FormMultiLineItem", 2, e16.toString());
                }
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void b() {
        int dimensionPixelSize;
        int i3 = this.f384564h;
        if (i3 < 2 && i3 > 0) {
            throw new RuntimeException("mLineNum < 2, recommend to use FormSimpleItem");
        }
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.f158563j1);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.f158570j9);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(R.dimen.f158561iz);
        if (this.f384564h == 2) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158548il);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158562j0);
        }
        this.C = dimensionPixelSize4;
        setBackgroundDrawable(o.h(getResources(), this.f384563f, true, this.f384566m));
        setMinimumHeight(this.D);
        setPadding(this.G, 0, this.H, 0);
        ImageView imageView = new ImageView(getContext());
        this.f384561d = imageView;
        imageView.setId(R.id.cjf);
        this.f384561d.setFocusable(false);
        this.f384561d.setClickable(false);
        this.f384561d.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f384561d);
        this.f384562e = new ArrayList<>();
        MultiImageTextView multiImageTextView = new MultiImageTextView(getContext());
        multiImageTextView.setId(R.id.cjd);
        multiImageTextView.setTextSize(0, dimensionPixelSize2);
        multiImageTextView.setTextColor(getResources().getColor(R.color.skin_dark_gray));
        multiImageTextView.setSingleLine(true);
        multiImageTextView.setDuplicateParentStateEnabled(true);
        multiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
        multiImageTextView.setText(HardCodeUtil.qqStr(R.string.f171999mo3));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, R.id.cjf);
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.leftMargin = this.I;
        this.f384562e.add(multiImageTextView);
        addView(multiImageTextView, layoutParams);
        for (int i16 = 1; i16 < this.f384564h; i16++) {
            MultiImageTextView multiImageTextView2 = new MultiImageTextView(getContext());
            multiImageTextView2.setTextSize(0, dimensionPixelSize3);
            multiImageTextView2.setTextColor(getResources().getColor(R.color.skin_gray3));
            multiImageTextView2.setSingleLine(true);
            multiImageTextView2.setDuplicateParentStateEnabled(true);
            multiImageTextView2.setEllipsize(TextUtils.TruncateAt.END);
            multiImageTextView2.setText(HardCodeUtil.qqStr(R.string.mo5));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = this.I;
            layoutParams2.addRule(1, R.id.cjf);
            if (i16 == 1) {
                multiImageTextView2.setId(R.id.cji);
            } else if (i16 == 2) {
                multiImageTextView2.setId(R.id.cjj);
            }
            if (i16 != this.f384564h - 1) {
                layoutParams2.bottomMargin = dimensionPixelSize4;
            }
            addView(multiImageTextView2, layoutParams2);
            this.f384562e.add(multiImageTextView2);
        }
    }

    private void c(int i3, int i16, int i17) {
        for (int i18 = 0; i18 < this.f384564h; i18++) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f384562e.get(i18).getLayoutParams();
            layoutParams.topMargin = i3;
            layoutParams.leftMargin = this.I;
            i3 += this.f384562e.get(i18).getMeasuredHeight();
            this.f384562e.get(i18).setLayoutParams(layoutParams);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.E == 0) {
            if (this.f384564h == 2) {
                this.E = getResources().getDimensionPixelSize(R.dimen.f158547ik);
            } else {
                this.E = getResources().getDimensionPixelSize(R.dimen.f158560iy);
            }
        }
        if (this.F == 0) {
            if (this.f384564h == 2) {
                this.F = getResources().getDimensionPixelSize(R.dimen.f158547ik);
            } else {
                this.F = getResources().getDimensionPixelSize(R.dimen.f158560iy);
            }
        }
        if (this.D == 0) {
            if (this.f384564h == 2) {
                this.D = getResources().getDimensionPixelSize(R.dimen.f158546ij);
            } else {
                this.D = getResources().getDimensionPixelSize(R.dimen.f158559ix);
            }
        }
        setMinimumHeight(this.D);
        setPadding(this.G, 0, this.H, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.F, this.E);
        this.f384561d.setLayoutParams(layoutParams);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        int i17 = 0;
        for (int i18 = 0; i18 < this.f384564h; i18++) {
            this.f384562e.get(i18).measure(i3, i16);
            i17 += this.f384562e.get(i18).getMeasuredHeight();
        }
        this.f384561d.measure(i3, i16);
        if (this.f384561d.getMeasuredHeight() <= i17 && this.f384564h > 3) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158557iv);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.f158554ir);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f384561d.getLayoutParams();
            layoutParams2.topMargin = dimensionPixelSize;
            this.f384561d.setLayoutParams(layoutParams2);
            c(dimensionPixelSize, i3, i16);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f384562e.get(this.f384564h - 1).getLayoutParams();
            layoutParams3.bottomMargin = dimensionPixelSize2;
            this.f384562e.get(this.f384564h - 1).setLayoutParams(layoutParams3);
        } else {
            c((this.D - (i17 + (this.C * (this.f384564h - 1)))) / 2, i3, i16);
        }
        super.onMeasure(i3, i16);
    }

    public void setAllTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        ColorStateList colorStateList = getResources().getColorStateList(i3);
        Iterator<MultiImageTextView> it = this.f384562e.iterator();
        while (it.hasNext()) {
            it.next().setTextColor(colorStateList);
        }
    }

    public void setAllTextSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
            return;
        }
        Iterator<MultiImageTextView> it = this.f384562e.iterator();
        while (it.hasNext()) {
            it.next().setTextSize(f16);
        }
    }

    public void setBackGroundByType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            setBackgroundDrawable(o.h(getResources(), i3, true, this.f384566m));
        }
    }

    public void setHeaderView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        ImageView imageView = this.f384561d;
        if (imageView != null) {
            imageView.setImageResource(i3);
        }
    }

    public void setHeaderWeight(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.F = i3;
            this.E = i16;
        }
    }

    public void setLineNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        if (i3 >= 2) {
            int i16 = this.f384564h;
            if (i16 != i3) {
                if (i16 < i3) {
                    int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158570j9);
                    int i17 = i3 - this.f384564h;
                    for (int i18 = 0; i18 < i17; i18++) {
                        MultiImageTextView multiImageTextView = new MultiImageTextView(getContext());
                        multiImageTextView.setTextSize(0, dimensionPixelSize);
                        multiImageTextView.setTextColor(getResources().getColor(R.color.skin_gray3));
                        multiImageTextView.setSingleLine(true);
                        multiImageTextView.setDuplicateParentStateEnabled(true);
                        multiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
                        multiImageTextView.setText(HardCodeUtil.qqStr(R.string.f172000mo4));
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.leftMargin = this.I;
                        layoutParams.addRule(1, R.id.cjf);
                        this.f384562e.add(multiImageTextView);
                        addView(multiImageTextView, layoutParams);
                    }
                    this.f384564h = i3;
                } else if (i16 > i3) {
                    while (i16 > i3) {
                        this.f384562e.remove(this.f384564h - 1);
                        i16--;
                    }
                    this.f384564h = i3;
                }
            }
            postInvalidate();
            return;
        }
        throw new RuntimeException("recommend to use >=2 lineNum, or use FormSingleItem widget");
    }

    public void setMarginLeftRight(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.G = i3;
            this.H = i16;
        }
    }

    public void setUseCardUIStyle(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.f384566m = z16;
        }
    }

    public void setmMinHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.D = i3;
        }
    }

    public FormMultiLineItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public FormMultiLineItem(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f384564h = -1;
        this.f384565i = false;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        a(attributeSet);
        b();
    }
}

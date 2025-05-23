package com.tencent.pts.ui.view.PTSSwiperView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qzone.proxy.feedcomponent.model.CellDynamicAlbum;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.utils.PTSDeviceUtil;

/* loaded from: classes22.dex */
public class PTSSwiperDotIndicator extends LinearLayout implements a {
    static IPatchRedirector $redirector_;
    private final GradientDrawable C;
    private final GradientDrawable D;

    /* renamed from: d, reason: collision with root package name */
    private int f342219d;

    /* renamed from: e, reason: collision with root package name */
    private int f342220e;

    /* renamed from: f, reason: collision with root package name */
    private int f342221f;

    /* renamed from: h, reason: collision with root package name */
    private int f342222h;

    /* renamed from: i, reason: collision with root package name */
    private float f342223i;

    /* renamed from: m, reason: collision with root package name */
    private int f342224m;

    public PTSSwiperDotIndicator(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f342219d = PTSDeviceUtil.dp2pxInt(16.0f);
        this.f342220e = PTSDeviceUtil.dp2pxInt(3.0f);
        this.f342221f = PTSDeviceUtil.dp2pxInt(12.0f);
        this.f342222h = PTSDeviceUtil.dp2pxInt(0.0f);
        this.f342223i = PTSDeviceUtil.dp2px(2.5f);
        this.f342224m = PTSDeviceUtil.dp2pxInt(4.0f);
        this.C = new GradientDrawable();
        this.D = new GradientDrawable();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        setPadding(0, 0, 0, this.f342221f);
        setLayoutParams(layoutParams);
        d();
    }

    private void d() {
        this.C.setColor(CellDynamicAlbum.sBtnBackgroundColor);
        this.C.setCornerRadius(this.f342223i);
        this.D.setColor(-16777216);
        this.D.setCornerRadius(this.f342223i);
    }

    @Override // com.tencent.pts.ui.view.PTSSwiperView.a
    public void a(int i3) {
        GradientDrawable gradientDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (getVisibility() != 0) {
            return;
        }
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (i16 == i3) {
                gradientDrawable = this.D;
            } else {
                gradientDrawable = this.C;
            }
            childAt.setBackgroundDrawable(gradientDrawable);
        }
    }

    @Override // com.tencent.pts.ui.view.PTSSwiperView.a
    public RelativeLayout.LayoutParams b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RelativeLayout.LayoutParams) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (RelativeLayout.LayoutParams) getLayoutParams();
    }

    @Override // com.tencent.pts.ui.view.PTSSwiperView.a
    public void c(int i3) {
        int i16;
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        int childCount = getChildCount();
        if (i3 <= 1) {
            for (int i17 = 0; i17 < childCount; i17++) {
                getChildAt(i17).setVisibility(8);
            }
            return;
        }
        if (i3 > childCount) {
            Context context = getContext();
            int i18 = this.f342219d;
            int i19 = this.f342220e;
            for (int i26 = childCount; i26 < i3; i26++) {
                View view = new View(context);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i18, i19);
                if (i26 == 0) {
                    i16 = 0;
                } else {
                    i16 = this.f342224m;
                }
                layoutParams.leftMargin = i16;
                if (i26 == 0) {
                    drawable = this.D;
                } else {
                    drawable = this.C;
                }
                view.setBackgroundDrawable(drawable);
                addView(view, layoutParams);
            }
        }
        for (int i27 = 0; i27 < i3; i27++) {
            getChildAt(i27).setVisibility(0);
        }
        while (i3 < childCount) {
            getChildAt(i3).setVisibility(8);
            i3++;
        }
    }

    public void setIndicatorFocusedColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.D.setColor(i3);
        }
    }

    public void setIndicatorGap(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        } else {
            this.f342224m = PTSDeviceUtil.dp2pxInt(f16);
        }
    }

    public void setIndicatorHeight(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            this.f342220e = PTSDeviceUtil.dp2pxInt(f16);
        }
    }

    @Override // com.tencent.pts.ui.view.PTSSwiperView.a
    public void setIndicatorLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) layoutParams);
        } else {
            setLayoutParams(layoutParams);
        }
    }

    public void setIndicatorMargin(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.f342222h = PTSDeviceUtil.dp2pxInt(f16);
        this.f342221f = PTSDeviceUtil.dp2pxInt(f17);
        setPadding(0, 0, 0, (int) f17);
    }

    public void setIndicatorNormalColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.C.setColor(i3);
        }
    }

    public void setIndicatorRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
            return;
        }
        float dp2pxInt = PTSDeviceUtil.dp2pxInt(f16);
        this.f342223i = dp2pxInt;
        this.C.setCornerRadius(dp2pxInt);
        this.D.setCornerRadius(this.f342223i);
    }

    @Override // com.tencent.pts.ui.view.PTSSwiperView.a
    public void setIndicatorVisible(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
    }

    public void setIndicatorWidth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else {
            this.f342219d = PTSDeviceUtil.dp2pxInt(f16);
        }
    }
}

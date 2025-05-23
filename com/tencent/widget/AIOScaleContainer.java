package com.tencent.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.p;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AIOScaleContainer extends FrameLayout {
    static IPatchRedirector $redirector_;
    private static int E;
    private boolean C;
    private Rect D;

    /* renamed from: d, reason: collision with root package name */
    private int f384489d;

    /* renamed from: e, reason: collision with root package name */
    private int f384490e;

    /* renamed from: f, reason: collision with root package name */
    private int f384491f;

    /* renamed from: h, reason: collision with root package name */
    private int f384492h;

    /* renamed from: i, reason: collision with root package name */
    private int f384493i;

    /* renamed from: m, reason: collision with root package name */
    private float f384494m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29311);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            E = -1;
        }
    }

    public AIOScaleContainer(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f384489d = 0;
        this.f384490e = 0;
        this.f384491f = 0;
        this.f384494m = 1.0f;
        this.C = false;
        this.D = new Rect();
    }

    private void a(int i3, int i16) {
        int i17 = this.f384490e;
        float f16 = i3 - (this.f384493i * 2);
        float f17 = this.f384494m;
        this.f384491f = (int) (f16 / f17);
        int i18 = (int) ((i16 - this.f384492h) / f17);
        this.f384490e = i18;
        if (this.f384489d <= 0) {
            this.f384489d = i16;
        }
        int i19 = i17 - i18;
        if (i19 > ((int) (this.f384489d * 0.2d))) {
            int c16 = c();
            if (i19 < c16) {
                this.f384490e -= c16 - i19;
                i19 = c16;
            }
            e(i19);
            if (QLog.isDevelopLevel()) {
                QLog.i("AIOScaleContainer", 4, "softInputShow");
            }
        }
    }

    private void b(int i3, int i16, int i17, int i18, View view) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOScaleContainer", 4, "defaultLayout: bottom is " + i18 + " topMargin is " + this.f384492h + " viewHeight is " + this.f384490e);
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(this.f384491f, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f384490e, 1073741824));
        int i19 = this.f384493i;
        int i26 = this.f384492h;
        view.layout(i16 + i19, i3 + i26, i16 + i19 + this.f384491f, i3 + i26 + this.f384490e);
    }

    private int c() {
        return ViewUtils.dpToPx(220.0f);
    }

    private void d(View view) {
        if (this.C) {
            return;
        }
        this.C = true;
        this.f384493i = 0;
        this.f384492h = ViewUtils.dpToPx(88.0f);
        view.setScaleX(this.f384494m);
        view.setScaleY(this.f384494m);
        view.setPivotY(0.0f);
        view.setPivotX(0.0f);
    }

    private void e(int i3) {
        if (i3 == E) {
            return;
        }
        QLog.i("AIOScaleContainer", 1, "savePanelHeight: " + i3);
        E = i3;
        p.g(BaseApplication.getContext(), "", true, "sp_key_minichat_panel_height", Integer.valueOf(i3));
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) rect)).booleanValue();
        }
        this.D.set(rect);
        rect.top = 0;
        rect.bottom = 0;
        return super.fitSystemWindows(rect);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOScaleContainer", 4, "onLayout top is " + i16 + " bottom is " + i18);
        }
        int i19 = i18 - this.D.bottom;
        View childAt = getChildAt(0);
        if (childAt == null) {
            QLog.e("AIOScaleContainer", 1, "onLayout err, main is null");
            return;
        }
        d(childAt);
        a(i17 - i3, i19 - i16);
        b(i16, i3, i17, i19, childAt);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i3), View.getDefaultSize(getSuggestedMinimumHeight(), i16));
        }
    }

    public AIOScaleContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f384489d = 0;
        this.f384490e = 0;
        this.f384491f = 0;
        this.f384494m = 1.0f;
        this.C = false;
        this.D = new Rect();
    }

    public AIOScaleContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f384489d = 0;
        this.f384490e = 0;
        this.f384491f = 0;
        this.f384494m = 1.0f;
        this.C = false;
        this.D = new Rect();
    }
}

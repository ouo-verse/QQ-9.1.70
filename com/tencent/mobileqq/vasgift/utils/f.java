package com.tencent.mobileqq.vasgift.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.util.VasPadUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private View f312018a;

    /* renamed from: b, reason: collision with root package name */
    private PopupWindow f312019b;

    /* renamed from: c, reason: collision with root package name */
    private Context f312020c;

    /* renamed from: d, reason: collision with root package name */
    private PopupWindow.OnDismissListener f312021d;

    /* renamed from: g, reason: collision with root package name */
    private int f312024g;

    /* renamed from: h, reason: collision with root package name */
    private int f312025h;

    /* renamed from: e, reason: collision with root package name */
    private boolean f312022e = true;

    /* renamed from: f, reason: collision with root package name */
    private boolean f312023f = true;

    /* renamed from: i, reason: collision with root package name */
    private boolean f312026i = false;

    /* renamed from: j, reason: collision with root package name */
    private PopupWindow.OnDismissListener f312027j = new a();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (f.this.f312022e) {
                f.this.c(1.0f, false);
            }
            if (f.this.f312021d != null) {
                f.this.f312021d.onDismiss();
            }
        }
    }

    public f(Context context, View view, int i3, int i16) {
        this.f312024g = -1;
        this.f312025h = -2;
        this.f312020c = context;
        this.f312018a = view;
        this.f312024g = i3;
        this.f312025h = i16;
    }

    private float e(int i3) {
        return TypedValue.applyDimension(1, i3, this.f312020c.getResources().getDisplayMetrics());
    }

    private void f() {
        int screenWidth = ImmersiveUtils.getScreenWidth();
        float e16 = screenWidth / e(432);
        this.f312024g = ((int) e(200)) + screenWidth;
        this.f312025h = (int) e(432);
        this.f312018a.setPivotX(this.f312024g);
        this.f312018a.setPivotY(0.0f);
        this.f312018a.setScaleY(e16);
        if (QLog.isColorLevel()) {
            QLog.i("QQGiftPopupHelper", 1, "getScreenWidth:" + screenWidth + " popWin measuredHeight:" + this.f312025h + " proportion:" + e16 + " real mWidth:" + this.f312024g);
        }
    }

    private void i(boolean z16) {
        if (z16) {
            this.f312019b.setOutsideTouchable(true);
            this.f312019b.setFocusable(true);
        } else {
            this.f312019b.setOutsideTouchable(false);
            this.f312019b.setFocusable(false);
        }
    }

    public void c(float f16, boolean z16) {
        WindowManager.LayoutParams attributes = ((Activity) this.f312020c).getWindow().getAttributes();
        attributes.alpha = f16;
        ((Activity) this.f312020c).getWindow().setAttributes(attributes);
        if (z16) {
            ((Activity) this.f312020c).getWindow().addFlags(2);
        } else {
            ((Activity) this.f312020c).getWindow().clearFlags(2);
        }
    }

    public void d() {
        if (this.f312020c != null) {
            boolean z16 = this.f312026i;
        }
        PopupWindow popupWindow = this.f312019b;
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }

    public void g() {
        if (QLog.isColorLevel()) {
            QLog.i("QQGiftPopupHelper", 1, "mIsLandscape:" + this.f312026i);
        }
        if (this.f312026i) {
            f();
            this.f312018a.setSystemUiVisibility(1028);
        }
        PopupWindow popupWindow = new PopupWindow(this.f312018a, this.f312024g, this.f312025h);
        this.f312019b = popupWindow;
        popupWindow.setOnDismissListener(this.f312027j);
        this.f312019b.setBackgroundDrawable(new ColorDrawable(0));
        i(this.f312023f);
    }

    public boolean h() {
        return this.f312019b.isShowing();
    }

    public void j(boolean z16) {
        this.f312022e = z16;
    }

    public void k(boolean z16) {
        this.f312026i = z16;
    }

    public void l(View view) {
        int i3;
        g();
        if (this.f312022e) {
            c(0.7f, true);
        }
        this.f312019b.setAnimationStyle(R.style.f243731l);
        PopupWindow popupWindow = this.f312019b;
        if (VasPadUtils.INSTANCE.isPadSplitLandscape(this.f312020c)) {
            i3 = 5;
        } else {
            i3 = 83;
        }
        popupWindow.showAtLocation(view, i3, 0, 0);
    }

    public void m(View view) {
        g();
        if (this.f312022e) {
            c(0.7f, true);
        }
        this.f312019b.setAnimationStyle(R.style.f243741m);
        this.f312019b.showAtLocation(view, 85, 0, 0);
    }
}

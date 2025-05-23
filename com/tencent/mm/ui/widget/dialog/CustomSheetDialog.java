package com.tencent.mm.ui.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.tencent.luggage.wxa.lo.q;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class CustomSheetDialog extends AppCompatDialog {

    /* renamed from: a, reason: collision with root package name */
    public Context f152864a;

    /* renamed from: b, reason: collision with root package name */
    public FrameLayout f152865b;

    public CustomSheetDialog(@NonNull Context context) {
        this(context, 0);
    }

    public static int a(int i3) {
        return i3 == 0 ? R.style.f173406a03 : i3;
    }

    public final void d() {
        int i3;
        if (q.d(this.f152864a) && Build.VERSION.SDK_INT < 30) {
            i3 = q.c(this.f152864a);
        } else {
            i3 = 0;
        }
        if (f()) {
            FrameLayout frameLayout = this.f152865b;
            if (frameLayout != null) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) frameLayout.getLayoutParams();
                if (e() == 1) {
                    layoutParams.setMargins(0, 0, i3, 0);
                } else if (e() == 3) {
                    layoutParams.setMargins(i3, 0, 0, 0);
                }
                this.f152865b.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        FrameLayout frameLayout2 = this.f152865b;
        if (frameLayout2 != null) {
            CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) frameLayout2.getLayoutParams();
            layoutParams2.setMargins(0, 0, 0, i3);
            this.f152865b.setLayoutParams(layoutParams2);
        }
    }

    public final int e() {
        return getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }

    public boolean f() {
        if (this.f152864a.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public boolean g() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(android.R.attr.windowCloseOnTouchOutside, typedValue, true) && typedValue.data != 0) {
            return true;
        }
        return false;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(a(0, view, null));
    }

    public CustomSheetDialog(@NonNull Context context, int i3) {
        super(context, a(i3));
        this.f152864a = context;
        supportRequestWindowFeature(1);
    }

    public final View a(int i3, View view, ViewGroup.LayoutParams layoutParams) {
        Window window = getWindow();
        if (f()) {
            window.setGravity(5);
            window.setWindowAnimations(R.style.a7i);
        } else {
            window.setGravity(80);
            window.setWindowAnimations(R.style.f2464891);
        }
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (f()) {
            attributes.width = -2;
            attributes.height = -1;
        } else {
            attributes.width = -1;
            attributes.height = -2;
        }
        window.setAttributes(attributes);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f152864a).inflate(R.layout.fh8, (ViewGroup) null);
        View findViewById = viewGroup.findViewById(R.id.f100585sw);
        if (i3 != 0 && view == null) {
            view = getLayoutInflater().inflate(i3, viewGroup, false);
        }
        if (f()) {
            this.f152865b = (FrameLayout) viewGroup.findViewById(R.id.z4m);
        } else {
            this.f152865b = (FrameLayout) viewGroup.findViewById(R.id.z4k);
        }
        d();
        this.f152865b.setVisibility(0);
        if (layoutParams == null) {
            this.f152865b.addView(view);
        } else {
            this.f152865b.addView(view, layoutParams);
        }
        if (g()) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.CustomSheetDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (CustomSheetDialog.this.isShowing()) {
                        CustomSheetDialog.this.cancel();
                    }
                }
            });
        }
        return viewGroup;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(a(0, view, layoutParams));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(int i3) {
        super.setContentView(a(i3, null, null));
    }

    public CustomSheetDialog(@NonNull Context context, boolean z16, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z16, onCancelListener);
        supportRequestWindowFeature(1);
    }
}

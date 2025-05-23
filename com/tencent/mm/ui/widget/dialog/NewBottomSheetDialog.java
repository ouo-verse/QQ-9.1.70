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
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.tencent.luggage.wxa.lo.q;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class NewBottomSheetDialog extends AppCompatDialog {

    /* renamed from: a, reason: collision with root package name */
    public Context f153157a;

    /* renamed from: b, reason: collision with root package name */
    public FrameLayout f153158b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f153159c;

    public NewBottomSheetDialog(Context context) {
        super(context, 0);
        this.f153159c = true;
    }

    public static int a(int i3) {
        return i3 == 0 ? R.style.f173406a03 : i3;
    }

    public final void d() {
        int i3;
        if (this.f153158b != null && !e()) {
            if (q.d(this.f153157a) && Build.VERSION.SDK_INT < 30) {
                i3 = q.c(this.f153157a);
            } else {
                i3 = 0;
            }
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.f153158b.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, i3);
            this.f153158b.setLayoutParams(layoutParams);
        }
    }

    public final boolean e() {
        if (this.f153157a.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public final boolean f() {
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

    public void setWindowCloseOnTouchOutside(boolean z16) {
        this.f153159c = z16;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(a(0, view, layoutParams));
    }

    public NewBottomSheetDialog(Context context, int i3) {
        super(context, a(i3));
        this.f153159c = true;
        this.f153157a = context;
        supportRequestWindowFeature(1);
    }

    public final View a(int i3, View view, ViewGroup.LayoutParams layoutParams) {
        Window window = getWindow();
        if (e()) {
            window.setGravity(1);
            window.setWindowAnimations(R.style.f2464992);
        } else {
            window.setGravity(80);
            window.setWindowAnimations(R.style.f2464992);
        }
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (e()) {
            attributes.width = -2;
            attributes.height = -2;
        } else {
            attributes.width = -1;
            attributes.height = -2;
        }
        window.setAttributes(attributes);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f153157a).inflate(R.layout.fon, (ViewGroup) null);
        View findViewById = viewGroup.findViewById(R.id.f100585sw);
        if (i3 != 0 && view == null) {
            view = getLayoutInflater().inflate(i3, viewGroup, false);
        }
        if (e()) {
            this.f153158b = (FrameLayout) viewGroup.findViewById(R.id.z4l);
        } else {
            this.f153158b = (FrameLayout) viewGroup.findViewById(R.id.z4k);
            d();
        }
        this.f153158b.setVisibility(0);
        if (layoutParams == null) {
            this.f153158b.addView(view);
        } else {
            this.f153158b.addView(view, layoutParams);
        }
        if (f()) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.NewBottomSheetDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (NewBottomSheetDialog.this.isShowing() && NewBottomSheetDialog.this.f153159c) {
                        NewBottomSheetDialog.this.cancel();
                    }
                }
            });
        }
        return viewGroup;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(int i3) {
        super.setContentView(a(i3, null, null));
    }

    public NewBottomSheetDialog(Context context, boolean z16, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z16, onCancelListener);
        this.f153159c = true;
        supportRequestWindowFeature(1);
    }
}

package com.qzone.album.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* loaded from: classes39.dex */
public class SafePopupWindow extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<Context> f44250a;

    public SafePopupWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f44250a = new WeakReference<>(context);
    }

    private boolean a() {
        Context context = this.f44250a.get();
        return context != null && (context instanceof Activity) && ((Activity) context).isFinishing();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        if (a()) {
            return;
        }
        try {
            super.showAsDropDown(view);
        } catch (Exception e16) {
            QLog.e("SafePopupWindow", 1, "showAsDropDown exception", e16);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i3, int i16, int i17) {
        if (a()) {
            return;
        }
        try {
            super.showAtLocation(view, i3, i16, i17);
        } catch (Exception e16) {
            QLog.e("SafePopupWindow", 1, "showAtLocation exception", e16);
        }
    }

    @Override // android.widget.PopupWindow
    public void update() {
        if (a()) {
            return;
        }
        try {
            super.update();
        } catch (Exception e16) {
            QLog.e("SafePopupWindow", 1, "update exception", e16);
        }
    }

    public SafePopupWindow(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f44250a = new WeakReference<>(context);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i16) {
        if (a()) {
            return;
        }
        try {
            super.showAsDropDown(view, i3, i16);
        } catch (Exception e16) {
            QLog.e("SafePopupWindow", 1, "showAsDropDown exception", e16);
        }
    }

    public SafePopupWindow(View view, int i3, int i16) {
        super(view, i3, i16);
        this.f44250a = new WeakReference<>(view.getContext());
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i16, int i17) {
        if (a()) {
            return;
        }
        try {
            super.showAsDropDown(view, i3, i16, i17);
        } catch (Exception e16) {
            QLog.e("SafePopupWindow", 1, "showAsDropDown exception", e16);
        }
    }
}

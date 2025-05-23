package com.qzone.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;

/* loaded from: classes37.dex */
public class QzoneBubblePopWindow extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f60540a;

    public QzoneBubblePopWindow(Context context) {
        super(context);
        this.f60540a = null;
        this.f60540a = new WeakReference<>(context);
    }

    public void a(Activity activity, float f16) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.alpha = f16;
        activity.getWindow().setAttributes(attributes);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        a((Activity) this.f60540a.get(), 1.0f);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        if (this.f60540a.get() == null) {
            return;
        }
        super.showAsDropDown(view);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i3, int i16, int i17) {
        if (this.f60540a.get() == null) {
            return;
        }
        super.showAtLocation(view, i3, i16, i17);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i16) {
        if (this.f60540a.get() == null) {
            return;
        }
        super.showAsDropDown(view, i3, i16);
    }

    public QzoneBubblePopWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60540a = null;
        this.f60540a = new WeakReference<>(context);
    }

    public QzoneBubblePopWindow(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60540a = null;
        this.f60540a = new WeakReference<>(context);
    }
}

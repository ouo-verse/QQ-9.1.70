package com.tencent.common.danmaku.edit.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.common.danmaku.edit.keyboard.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class EditLinearLayout extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private EditSettingLayout f99702d;

    /* renamed from: e, reason: collision with root package name */
    private final int[] f99703e;

    public EditLinearLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f99703e = new int[2];
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private boolean a() {
        getLocationOnScreen(this.f99703e);
        return a.a(this.f99703e[1] + getMeasuredHeight());
    }

    private void b(ViewGroup viewGroup) {
        if (this.f99702d == null) {
            if (viewGroup instanceof EditSettingLayout) {
                this.f99702d = (EditSettingLayout) viewGroup;
                return;
            }
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    b((ViewGroup) childAt);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        EditSettingLayout editSettingLayout = this.f99702d;
        if (editSettingLayout != null) {
            editSettingLayout.setKeyboardShowing(false);
        }
        super.onMeasure(i3, i16);
        b(this);
        if (this.f99702d != null && a() && this.f99702d.getMeasuredHeight() > 0) {
            this.f99702d.setKeyboardShowing(true);
            super.onMeasure(i3, i16);
        }
    }

    public EditLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f99703e = new int[2];
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public EditLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f99703e = new int[2];
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}

package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@TargetApi(21)
/* loaded from: classes16.dex */
public class a extends ViewOutlineProvider {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final float f264355a;

    public a(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16));
        } else {
            this.f264355a = f16;
        }
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) outline);
            return;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        int max = Math.max(view.getWidth(), rect.width());
        int max2 = Math.max(view.getHeight(), rect.height());
        int i3 = rect.left;
        int i16 = rect.top;
        rect.set(i3, i16, max + i3, max2 + i16);
        outline.setRoundRect(new Rect(0, 0, (rect.right - rect.left) - 0, (rect.bottom - rect.top) - 0), this.f264355a);
    }
}

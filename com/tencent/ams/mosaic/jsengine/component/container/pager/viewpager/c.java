package com.tencent.ams.mosaic.jsengine.component.container.pager.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private float f71091a;

    /* renamed from: b, reason: collision with root package name */
    private float f71092b;

    /* renamed from: c, reason: collision with root package name */
    private float f71093c;

    /* renamed from: d, reason: collision with root package name */
    private int f71094d;

    public c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f71091a = Utils.dp2px(8.0f);
        this.f71092b = 0.94f;
        this.f71093c = Utils.dp2px(40.0f);
        this.f71094d = 4;
    }

    private View f(View view) {
        View childAt;
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (childAt = frameLayout.getChildAt(0)) != null) {
                return childAt;
            }
        }
        return view;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.pager.viewpager.b
    protected void e(View view, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, Float.valueOf(f16));
            return;
        }
        if (view.getWidth() == 0.0f) {
            return;
        }
        View f17 = f(view);
        float pow = (float) Math.pow(this.f71092b, f16);
        view.setScaleX(pow);
        view.setScaleY(pow);
        view.setPivotX(f17.getX() + (f17.getWidth() / 2.0f));
        view.setPivotY(f17.getY() + (f17.getHeight() / 2.0f));
        view.setTranslationY((-view.getHeight()) * f16);
        if (f16 < 0.0f) {
            if (f16 >= -1.0f) {
                view.setAlpha(1.0f + f16);
                view.setTranslationY(((-view.getHeight()) * f16) + (f16 * this.f71093c));
            } else {
                view.setAlpha(0.0f);
                view.setTranslationY(0.0f);
            }
            view.setClickable(true);
            return;
        }
        int i3 = this.f71094d;
        if (f16 <= i3 + 1) {
            view.setAlpha(((i3 + 1) - f16) * 0.4f);
            view.setClickable(false);
            view.setTranslationY(((-view.getHeight()) * f16) + (f17.getHeight() * 0.5f * (1.0f - pow)) + (this.f71091a * f16));
        }
    }

    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f71094d = i3;
        }
    }
}

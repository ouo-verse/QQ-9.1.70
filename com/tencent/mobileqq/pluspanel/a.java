package com.tencent.mobileqq.pluspanel;

import android.R;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a implements Comparable<a> {
    static IPatchRedirector $redirector_;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public Drawable H;
    public Drawable I;

    /* renamed from: d, reason: collision with root package name */
    public int f258935d;

    /* renamed from: e, reason: collision with root package name */
    public int f258936e;

    /* renamed from: f, reason: collision with root package name */
    public String f258937f;

    /* renamed from: h, reason: collision with root package name */
    public String f258938h;

    /* renamed from: i, reason: collision with root package name */
    public String f258939i;

    /* renamed from: m, reason: collision with root package name */
    public int f258940m;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar)).intValue();
        }
        if (aVar != null) {
            return this.f258940m - aVar.f258940m;
        }
        return 0;
    }

    public Drawable h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        try {
            if (this.I == null && !TextUtils.isEmpty(this.F) && !TextUtils.isEmpty(this.G)) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                URLDrawable drawable = URLDrawable.getDrawable(this.F, obtain);
                URLDrawable drawable2 = URLDrawable.getDrawable(this.G, obtain);
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{-16842908, -16842913, -16842919}, drawable);
                stateListDrawable.addState(new int[]{-16842908, R.attr.state_selected, -16842919}, drawable2);
                this.I = stateListDrawable;
            }
        } catch (Throwable th5) {
            QLog.e("AIOPanelIconItem", 1, th5, new Object[0]);
        }
        return this.I;
    }

    public Drawable i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        try {
            if (this.H == null && !TextUtils.isEmpty(this.D) && !TextUtils.isEmpty(this.E)) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                URLDrawable drawable = URLDrawable.getDrawable(this.D, obtain);
                URLDrawable drawable2 = URLDrawable.getDrawable(this.E, obtain);
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{-16842908, -16842913, -16842919}, drawable);
                stateListDrawable.addState(new int[]{-16842908, R.attr.state_selected, -16842919}, drawable2);
                this.H = stateListDrawable;
            }
        } catch (Throwable th5) {
            QLog.e("AIOPanelIconItem", 1, th5, new Object[0]);
        }
        return this.H;
    }
}

package com.tencent.filter;

import android.graphics.Rect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class MRect {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private int f106452h;

    /* renamed from: w, reason: collision with root package name */
    private int f106453w;

    /* renamed from: x, reason: collision with root package name */
    private int f106454x;

    /* renamed from: y, reason: collision with root package name */
    private int f106455y;

    public MRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static MRect toMRect(Rect rect) {
        return new MRect(rect.left, rect.top, rect.width(), rect.height());
    }

    public MRect(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.f106454x = i3;
        this.f106455y = i16;
        this.f106453w = i17;
        this.f106452h = i18;
    }
}

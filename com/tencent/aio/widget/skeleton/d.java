package com.tencent.aio.widget.skeleton;

import android.graphics.Path;
import android.graphics.Rect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    Path f69991a;

    /* renamed from: b, reason: collision with root package name */
    Rect f69992b;

    /* renamed from: c, reason: collision with root package name */
    boolean f69993c;

    /* renamed from: d, reason: collision with root package name */
    boolean f69994d;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f69991a = new Path();
            this.f69992b = new Rect();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
    
        if (r7 != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(Rect rect, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, rect, Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        if (!this.f69992b.isEmpty()) {
            Rect rect2 = this.f69992b;
            if (rect2.top == rect.top) {
                if (rect2.bottom == rect.bottom) {
                    if (rect2.right == rect.right) {
                        if (rect2.left == rect.left) {
                            if (this.f69993c == z17) {
                                if (this.f69994d == z16) {
                                    if (z17) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        z18 = true;
        this.f69993c = z17;
        this.f69994d = z16;
        this.f69992b.set(rect);
        return z18;
    }
}

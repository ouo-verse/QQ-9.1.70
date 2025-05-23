package com.tencent.common.danmaku.render;

import android.graphics.Canvas;
import com.tencent.common.danmaku.data.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a<D extends com.tencent.common.danmaku.data.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<f> f99751a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void d(Canvas canvas, D d16, com.tencent.common.danmaku.inject.b bVar, float f16, float f17) {
        ArrayList<f> arrayList = this.f99751a;
        if (arrayList != null) {
            Iterator<f> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(canvas, d16, bVar, f16, f17);
            }
        }
    }

    public abstract boolean a(com.tencent.common.danmaku.data.a aVar);

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public final void c(Canvas canvas, D d16, com.tencent.common.danmaku.inject.b bVar, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, canvas, d16, bVar, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            f(canvas, d16, bVar, f16, f17);
            d(canvas, d16, bVar, f16, f17);
        }
    }

    public abstract com.tencent.common.danmaku.util.a e(D d16);

    public abstract void f(Canvas canvas, D d16, com.tencent.common.danmaku.inject.b bVar, float f16, float f17);

    public void g(D d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) d16);
        }
    }
}

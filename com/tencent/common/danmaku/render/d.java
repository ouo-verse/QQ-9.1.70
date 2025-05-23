package com.tencent.common.danmaku.render;

import android.graphics.Canvas;
import android.text.TextPaint;
import com.tencent.common.danmaku.inject.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private TextPaint f99756b;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f99756b = new TextPaint();
        }
    }

    private String h(com.tencent.common.danmaku.data.a aVar) {
        return String.valueOf(aVar.l());
    }

    @Override // com.tencent.common.danmaku.render.a
    public boolean a(com.tencent.common.danmaku.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.common.danmaku.render.a
    public com.tencent.common.danmaku.util.a e(com.tencent.common.danmaku.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.common.danmaku.util.a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
        m p16 = com.tencent.common.danmaku.inject.b.p();
        float d16 = com.tencent.common.danmaku.util.d.d(p16.l(), h(aVar)) + p16.g() + p16.g();
        float c16 = com.tencent.common.danmaku.util.d.c(p16.l()) + (p16.h() * 2.0f);
        aVar.g0(c16);
        aVar.h0(d16);
        return new com.tencent.common.danmaku.util.a(d16, c16);
    }

    @Override // com.tencent.common.danmaku.render.a
    public void f(Canvas canvas, com.tencent.common.danmaku.data.a aVar, com.tencent.common.danmaku.inject.b bVar, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, canvas, aVar, bVar, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        m p16 = com.tencent.common.danmaku.inject.b.p();
        this.f99756b.setTextSize(p16.l());
        this.f99756b.setColor(-1);
        canvas.drawText(h(aVar), f16 + p16.g(), (f17 + p16.h()) - this.f99756b.ascent(), this.f99756b);
    }
}

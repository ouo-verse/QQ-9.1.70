package com.tencent.common.danmaku.render;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.common.danmaku.inject.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Rect f99752a;

    /* renamed from: b, reason: collision with root package name */
    private final Rect f99753b;

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.common.danmaku.core.b f99754c;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f99755d;

    public b(com.tencent.common.danmaku.core.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        this.f99752a = new Rect();
        this.f99753b = new Rect();
        this.f99755d = new Paint();
        this.f99754c = bVar;
    }

    private boolean b(Canvas canvas, com.tencent.common.danmaku.data.a aVar, com.tencent.common.danmaku.inject.b bVar, a aVar2) {
        Bitmap b16 = this.f99754c.b(aVar, bVar);
        if (b16 == null) {
            return false;
        }
        int save = canvas.save();
        this.f99752a.set(0, 0, (int) aVar.y(), (int) aVar.x());
        this.f99753b.set((int) aVar.t(), (int) aVar.I(), (int) aVar.D(), (int) aVar.g());
        com.tencent.common.danmaku.util.e.a("draw bitmap");
        canvas.drawBitmap(b16, this.f99752a, this.f99753b, this.f99755d);
        com.tencent.common.danmaku.util.e.d();
        com.tencent.common.danmaku.util.e.a("restoreToCount");
        canvas.restoreToCount(save);
        com.tencent.common.danmaku.util.e.d();
        return true;
    }

    private void c(Canvas canvas, com.tencent.common.danmaku.data.a aVar, com.tencent.common.danmaku.inject.b bVar, a aVar2) {
        int save = canvas.save();
        com.tencent.common.danmaku.util.e.a("render draw");
        aVar2.c(canvas, aVar, bVar, aVar.j(), aVar.k());
        com.tencent.common.danmaku.util.e.d();
        com.tencent.common.danmaku.util.e.a("restoreToCount");
        canvas.restoreToCount(save);
        com.tencent.common.danmaku.util.e.d();
    }

    public void a(Canvas canvas, com.tencent.common.danmaku.data.a aVar, com.tencent.common.danmaku.inject.b bVar, a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, canvas, aVar, bVar, aVar2);
            return;
        }
        if (canvas == null) {
            return;
        }
        if (aVar.O()) {
            if (b(canvas, aVar, bVar, aVar2)) {
                return;
            } else {
                m.w(false);
            }
        }
        c(canvas, aVar, bVar, aVar2);
    }
}

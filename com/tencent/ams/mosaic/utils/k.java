package com.tencent.ams.mosaic.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f71574a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59242);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f71574a = new AtomicInteger(HWColorFormat.COLOR_FormatVendorStartUnused);
        }
    }

    public static void a(Canvas canvas, View view, Paint paint, float f16, float f17, float f18) {
        if (paint != null && canvas != null && view != null) {
            try {
                float j3 = MosaicUtils.j(f16);
                canvas.drawRoundRect(new RectF(view.getX() + f17, view.getY() + f18, view.getX() + view.getWidth() + f17, view.getY() + view.getHeight() + f18), j3, j3, paint);
            } catch (Throwable th5) {
                f.c("ViewUtils ", "drawShadowEffectToCanvasIfNeed error.", th5);
            }
        }
    }

    public static int b() {
        AtomicInteger atomicInteger;
        int i3;
        do {
            atomicInteger = f71574a;
            i3 = atomicInteger.get();
        } while (!atomicInteger.compareAndSet(i3, i3 + 1));
        return i3;
    }

    public static void c(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            try {
                ((ViewGroup) view.getParent()).removeView(view);
            } catch (Throwable unused) {
            }
        }
    }
}

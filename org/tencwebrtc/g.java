package org.tencwebrtc;

import android.support.annotation.Nullable;
import javax.microedition.khronos.egl.EGLContext;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.EglBase10;
import org.tencwebrtc.EglBase14;

/* compiled from: P */
/* loaded from: classes29.dex */
public final /* synthetic */ class g {
    static {
        Object obj = EglBase.lock;
    }

    public static EglBase a() {
        return c(null, EglBase.CONFIG_PLAIN);
    }

    public static EglBase b(EglBase.Context context) {
        return c(context, EglBase.CONFIG_PLAIN);
    }

    public static EglBase c(@Nullable EglBase.Context context, int[] iArr) {
        if (context == null) {
            if (EglBase14Impl.isEGL14Supported()) {
                return i(iArr);
            }
            return f(iArr);
        }
        if (context instanceof EglBase14.Context) {
            return h((EglBase14.Context) context, iArr);
        }
        if (context instanceof EglBase10.Context) {
            return e((EglBase10.Context) context, iArr);
        }
        throw new IllegalArgumentException("Unrecognized Context");
    }

    public static EglBase10 d(EGLContext eGLContext, int[] iArr) {
        return new EglBase10Impl(eGLContext, iArr);
    }

    public static EglBase10 e(EglBase10.Context context, int[] iArr) {
        EGLContext rawContext;
        if (context == null) {
            rawContext = null;
        } else {
            rawContext = context.getRawContext();
        }
        return new EglBase10Impl(rawContext, iArr);
    }

    public static EglBase10 f(int[] iArr) {
        return new EglBase10Impl(null, iArr);
    }

    public static EglBase14 g(android.opengl.EGLContext eGLContext, int[] iArr) {
        return new EglBase14Impl(eGLContext, iArr);
    }

    public static EglBase14 h(EglBase14.Context context, int[] iArr) {
        android.opengl.EGLContext rawContext;
        if (context == null) {
            rawContext = null;
        } else {
            rawContext = context.getRawContext();
        }
        return new EglBase14Impl(rawContext, iArr);
    }

    public static EglBase14 i(int[] iArr) {
        return new EglBase14Impl(null, iArr);
    }
}

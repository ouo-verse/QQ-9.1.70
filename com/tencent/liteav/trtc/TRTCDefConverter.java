package com.tencent.liteav.trtc;

import android.opengl.EGLContext;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;

/* compiled from: P */
@JNINamespace("liteav::trtc")
/* loaded from: classes7.dex */
public class TRTCDefConverter {
    public static long getGLContextNativeHandle(Object obj) {
        if (obj instanceof EGLContext) {
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
                return ((EGLContext) obj).getNativeHandle();
            }
            return ((EGLContext) obj).getHandle();
        }
        return 0L;
    }
}

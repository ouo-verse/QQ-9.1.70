package com.tencent.aelight.camera.ae.flashshow.util;

import android.opengl.EGL14;
import android.opengl.GLES10;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/util/d;", "", "", "d", "e", "", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setGpuName", "(Ljava/lang/String;)V", "gpuName", "getGlVersion", "setGlVersion", "glVersion", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f65104a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String gpuName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String glVersion;

    static {
        d dVar = new d();
        f65104a = dVar;
        gpuName = "";
        glVersion = "";
        dVar.d();
        if (!(gpuName.length() == 0)) {
            if (!(glVersion.length() == 0)) {
                return;
            }
        }
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            if (!Intrinsics.areEqual(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT)) {
                String glGetString = GLES10.glGetString(7937);
                Intrinsics.checkNotNullExpressionValue(glGetString, "glGetString(GLES10.GL_RENDERER)");
                gpuName = glGetString;
                String glGetString2 = GLES10.glGetString(7938);
                Intrinsics.checkNotNullExpressionValue(glGetString2, "glGetString(GLES10.GL_VERSION)");
                glVersion = glGetString2;
                return;
            }
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.util.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.b();
                }
            });
            QLog.e("AEGpuInfoProvider", 1, "eglContext is EGL_NO_CONTEXT, can not get gpu info, use default");
            return;
        }
        dVar.e();
    }

    d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b() {
        f65104a.e();
    }

    private final void d() {
        os.a aVar = os.a.f423933a;
        gpuName = aVar.d("device_gpu_name", "");
        glVersion = aVar.d("device_gl_version", "");
    }

    private final void e() {
        try {
            p pVar = new p();
            pVar.j();
            String glGetString = GLES10.glGetString(7937);
            Intrinsics.checkNotNullExpressionValue(glGetString, "glGetString(GLES10.GL_RENDERER)");
            gpuName = glGetString;
            String glGetString2 = GLES10.glGetString(7938);
            Intrinsics.checkNotNullExpressionValue(glGetString2, "glGetString(GLES10.GL_VERSION)");
            glVersion = glGetString2;
            pVar.k();
            QLog.i("AEGpuInfoProvider", 1, "init egl, gpuName: " + gpuName);
            os.a aVar = os.a.f423933a;
            aVar.h("device_gpu_name", gpuName);
            aVar.h("device_gl_version", glVersion);
        } catch (Exception unused) {
            gpuName = "invalidGpuName";
            glVersion = "invalidGLVersion";
        }
    }

    public final String c() {
        return gpuName;
    }
}

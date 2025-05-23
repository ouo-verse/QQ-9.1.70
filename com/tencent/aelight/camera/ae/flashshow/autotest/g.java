package com.tencent.aelight.camera.ae.flashshow.autotest;

import android.opengl.EGL14;
import android.opengl.Matrix;
import android.os.SystemClock;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\n\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002J\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0004J2\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u0016J\u001e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002R\u0014\u0010\u001b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001cR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010!R\"\u0010(\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010.\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010*\u001a\u0004\b\u001e\u0010+\"\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/autotest/g;", "", "", "textureId", "", "a", "", "f", "", "e", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "d", "width", "height", tl.h.F, "renderId", "j", "i", "textureType", "", "textureMatrix", "mvpMatrix", "", "timestampNanos", "b", "g", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "loc", "Z", "mIsFileExists", "c", "I", "mFrameCount", "Ljava/lang/String;", "mStoragePath", "[F", "getFlipMatrix", "()[F", "setFlipMatrix", "([F)V", "flipMatrix", "Lcom/tencent/mobileqq/videocodec/mediacodec/encoder/c;", "Lcom/tencent/mobileqq/videocodec/mediacodec/encoder/c;", "()Lcom/tencent/mobileqq/videocodec/mediacodec/encoder/c;", "setEncodeConfig", "(Lcom/tencent/mobileqq/videocodec/mediacodec/encoder/c;)V", "encodeConfig", "Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/e;", "Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/e;", "hwVideoRecorder", "<init>", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LocalMediaInfo loc;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFileExists;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mFrameCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String mStoragePath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float[] flipMatrix;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.videocodec.mediacodec.encoder.c encodeConfig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.videocodec.mediacodec.recorder.e hwVideoRecorder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/autotest/g$b", "Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/c;", "", "onEncodeStart", "onEncodeFrame", "", "filePath", "onEncodeFinish", "", "errorCode", "", "e", "onEncodeError", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements com.tencent.mobileqq.videocodec.mediacodec.recorder.c {
        b() {
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeError(int errorCode, Throwable e16) {
            ms.a.f("LSChooseTestManager", "onEncodeError");
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeFinish(String filePath) {
            ms.a.f("LSChooseTestManager", "onEncodeFinish");
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeFrame() {
            ms.a.f("LSChooseTestManager", "onEncodeFrame");
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeStart() {
            ms.a.f("LSChooseTestManager", "onEncodeStart");
        }
    }

    public g(LocalMediaInfo loc) {
        Intrinsics.checkNotNullParameter(loc, "loc");
        this.loc = loc;
        this.mStoragePath = "/sdcard/Android/data/com.tencent.mobileqq/files/ae/camera/choose_media_debug_result";
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
        this.flipMatrix = fArr;
        this.mIsFileExists = new File(loc.path).exists();
    }

    public final void b(int textureType, int textureId, float[] textureMatrix, float[] mvpMatrix, long timestampNanos) {
        if (aq.d.f26717a.g()) {
            ms.a.f("LSChooseTestManager", "useEGLContextVersion---Build.MODEL=" + DeviceInfoMonitor.getModel());
            com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = this.encodeConfig;
            if (cVar != null) {
                cVar.c(3);
            }
        }
        com.tencent.mobileqq.videocodec.mediacodec.recorder.e eVar = this.hwVideoRecorder;
        if (eVar != null) {
            eVar.h(textureType, textureId, textureMatrix, mvpMatrix, timestampNanos);
        }
    }

    /* renamed from: c, reason: from getter */
    public final com.tencent.mobileqq.videocodec.mediacodec.encoder.c getEncodeConfig() {
        return this.encodeConfig;
    }

    /* renamed from: d, reason: from getter */
    public final LocalMediaInfo getLoc() {
        return this.loc;
    }

    public final String e() {
        String str = this.loc.path;
        Intrinsics.checkNotNullExpressionValue(str, "loc.path");
        return str;
    }

    public final boolean f() {
        boolean contains$default;
        String str = this.loc.mMimeType;
        Intrinsics.checkNotNullExpressionValue(str, "loc.mMimeType");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "video", false, 2, (Object) null);
        return contains$default;
    }

    public final void g(int renderId, int width, int height) {
        this.mFrameCount++;
        if (f()) {
            j(renderId, width, height);
            return;
        }
        if (this.mFrameCount == 30) {
            c.f64158a.b(renderId, width, height, this.mStoragePath + File.separator + System.currentTimeMillis() + ".png");
        }
    }

    public final void h(int width, int height) {
        File parentFile;
        int i3 = width - (width % 6);
        int i16 = height - (height % 6);
        String str = this.mStoragePath + File.separator + System.currentTimeMillis() + ".mp4";
        File file = new File(str);
        File parentFile2 = file.getParentFile();
        boolean z16 = false;
        if (parentFile2 != null && parentFile2.exists()) {
            z16 = true;
        }
        if (z16 && (parentFile = file.getParentFile()) != null) {
            parentFile.mkdir();
        }
        this.encodeConfig = new com.tencent.mobileqq.videocodec.mediacodec.encoder.c(str, i3, i16, 30000000, 10, false, 0);
        this.hwVideoRecorder = new com.tencent.mobileqq.videocodec.mediacodec.recorder.e();
        com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = this.encodeConfig;
        if (cVar != null) {
            cVar.d(EGL14.eglGetCurrentContext());
        }
        com.tencent.mobileqq.videocodec.mediacodec.recorder.e eVar = this.hwVideoRecorder;
        if (eVar != null) {
            eVar.o();
        }
        com.tencent.mobileqq.videocodec.mediacodec.recorder.e eVar2 = this.hwVideoRecorder;
        if (eVar2 != null) {
            eVar2.q(this.encodeConfig, new b());
        }
    }

    public final void i() {
        com.tencent.mobileqq.videocodec.mediacodec.recorder.e eVar = this.hwVideoRecorder;
        if (eVar != null) {
            eVar.s();
        }
    }

    public final void j(int renderId, int width, int height) {
        if (this.encodeConfig == null) {
            h(width, height);
        }
        a(renderId);
    }

    private final void a(int textureId) {
        if (textureId <= 0) {
            return;
        }
        b(GLSLRender.GL_TEXTURE_2D, textureId, null, this.flipMatrix, SystemClock.elapsedRealtimeNanos());
    }
}

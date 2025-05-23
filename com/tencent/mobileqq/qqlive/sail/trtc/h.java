package com.tencent.mobileqq.qqlive.sail.trtc;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.trtc.RTCCameraDefine;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.utils.r;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J)\u0010\b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0012\u0010\u0018\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u0010\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001fH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020\fH\u0016R\u0018\u0010&\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/h;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/c;", "", "isEngineReady", "Lcom/tencent/mobileqq/qqlive/trtc/video/source/a;", "T", "Ljava/lang/Class;", "clazz", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/Class;)Lcom/tencent/mobileqq/qqlive/trtc/video/source/a;", "Lcom/tencent/mobileqq/qqlive/trtc/a;", EnginePathProvider.ENGINE_DIR, "", "l", "f", "k", "switchCamera", "mirror", "setMirror", "Lcom/tencent/mobileqq/qqlive/data/trtc/RTCCameraDefine$RTCMirrorType;", "type", "d", "Landroid/view/ViewGroup;", "viewGroup", "g", "Lcom/tencent/mobileqq/qqlive/trtc/video/videoprocess/a;", "process", "i", "needCreate", "Lcom/tencent/mobileqq/qqlive/trtc/video/source/camera/a;", "e", "Lcom/tencent/mobileqq/qqlive/data/trtc/TRTCVideoQualityParams;", "videoQuality", "setVideoQuality", "getVideoQuality", "b", "a", "Lcom/tencent/mobileqq/qqlive/trtc/a;", "trtcEngine", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class h implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.trtc.a trtcEngine;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/h$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.trtc.h$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47886);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean isEngineReady() {
        com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
        if (aVar == null || aVar.getEngineState() != 2) {
            return false;
        }
        return true;
    }

    private final <T extends com.tencent.mobileqq.qqlive.trtc.video.source.a> T m(Class<T> clazz) {
        T t16;
        com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
        if (aVar != null) {
            t16 = (T) aVar.g(clazz);
        } else {
            t16 = null;
        }
        com.tencent.mobileqq.qqlive.trtc.a aVar2 = this.trtcEngine;
        if (aVar2 != null) {
            aVar2.l(t16);
        }
        return t16;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.trtcEngine = null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.c
    public void d(@NotNull RTCCameraDefine.RTCMirrorType type, boolean mirror) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, type, Boolean.valueOf(mirror));
            return;
        }
        Intrinsics.checkNotNullParameter(type, "type");
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcCameraBridgeImpl", "setMirror2", "engine is not ready");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.camera.a e16 = e(false);
        if (e16 != null) {
            e16.d(type, mirror);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.tencent.mobileqq.qqlive.trtc.video.source.camera.a e(boolean needCreate) {
        com.tencent.mobileqq.qqlive.trtc.video.source.camera.a aVar;
        com.tencent.mobileqq.qqlive.trtc.a aVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.mobileqq.qqlive.trtc.video.source.camera.a) iPatchRedirector.redirect((short) 13, (Object) this, needCreate);
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcCameraBridgeImpl", "getCameraCaptureSource", "engine is not ready");
            return null;
        }
        try {
            aVar2 = this.trtcEngine;
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Open_Live|TRTC|TrtcCameraBridgeImpl", "getCameraCaptureSource", "error, ", e16);
        }
        if (aVar2 != null) {
            aVar = (com.tencent.mobileqq.qqlive.trtc.video.source.camera.a) aVar2.j(com.tencent.mobileqq.qqlive.trtc.video.source.camera.a.class);
            if (aVar != null) {
                if (!needCreate) {
                    return null;
                }
                return (com.tencent.mobileqq.qqlive.trtc.video.source.camera.a) m(com.tencent.mobileqq.qqlive.trtc.video.source.camera.a.class);
            }
            return aVar;
        }
        aVar = null;
        if (aVar != null) {
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.c
    public void f() {
        com.tencent.mobileqq.qqlive.trtc.render.a aVar;
        com.tencent.mobileqq.qqlive.trtc.engine.c d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcCameraBridgeImpl", "startPreview", "engine is not ready");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.a aVar2 = this.trtcEngine;
        Context context = null;
        if (aVar2 != null) {
            aVar = aVar2.b();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcCameraBridgeImpl", "startPreview", "engine has no local render");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.camera.a e16 = e(true);
        if (e16 == null) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcCameraBridgeImpl", "startPreview", "no camera");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.a aVar3 = this.trtcEngine;
        if (aVar3 != null && (d16 = aVar3.d()) != null) {
            context = d16.b();
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isColorLevel()) {
            companion.d("Open_Live|TRTC|TrtcCameraBridgeImpl", "startPreview", "context=" + context);
        }
        TRTCVideoQualityParams b16 = r.b(context);
        Intrinsics.checkNotNullExpressionValue(b16, "getDefaultCameraQualityParam(context)");
        setVideoQuality(b16);
        e16.p(aVar);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.c
    public void g(@Nullable ViewGroup viewGroup) {
        com.tencent.mobileqq.qqlive.trtc.render.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) viewGroup);
            return;
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcCameraBridgeImpl", "setPreviewViewGroup", "engine is not ready");
            return;
        }
        if (viewGroup == null) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcCameraBridgeImpl", "setPreviewViewGroup", "invalid viewGroup");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.a aVar2 = this.trtcEngine;
        if (aVar2 != null) {
            aVar = aVar2.b();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcCameraBridgeImpl", "setPreviewViewGroup", "invalid localRender");
        } else {
            aVar.a(new WeakReference<>(viewGroup));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.c
    @Nullable
    public TRTCVideoQualityParams getVideoQuality() {
        com.tencent.mobileqq.qqlive.trtc.video.source.a j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (TRTCVideoQualityParams) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcCameraBridgeImpl", "getVideoQuality", "engine is not ready");
            return null;
        }
        com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
        if (aVar == null || (j3 = aVar.j(com.tencent.mobileqq.qqlive.trtc.video.source.a.class)) == null) {
            return null;
        }
        return j3.getVideoQuality();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.c
    public void i(@Nullable com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a process) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) process);
            return;
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcCameraBridgeImpl", "setVideoProcess", "engine is not ready");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
        if (aVar != null) {
            aVar.setVideoPreProcess(process);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.c
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcCameraBridgeImpl", "stopPreview", "engine is not ready");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.camera.a e16 = e(false);
        if (e16 != null) {
            e16.stopCapture();
        }
    }

    public void l(@NotNull com.tencent.mobileqq.qqlive.trtc.a engine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) engine);
        } else {
            Intrinsics.checkNotNullParameter(engine, "engine");
            this.trtcEngine = engine;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.c
    public void setMirror(boolean mirror) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, mirror);
            return;
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcCameraBridgeImpl", "setMirror", "engine is not ready");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.camera.a e16 = e(false);
        if (e16 != null) {
            e16.setMirror(mirror);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.c
    public void setVideoQuality(@NotNull TRTCVideoQualityParams videoQuality) {
        com.tencent.mobileqq.qqlive.trtc.video.source.a j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) videoQuality);
            return;
        }
        Intrinsics.checkNotNullParameter(videoQuality, "videoQuality");
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcCameraBridgeImpl", "setVideoQuality", "engine is not ready");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
        if (aVar != null && (j3 = aVar.j(com.tencent.mobileqq.qqlive.trtc.video.source.a.class)) != null) {
            AegisLogger.INSTANCE.i("Open_Live|TRTC|TrtcCameraBridgeImpl", "setVideoQuality", "videoQuality=" + videoQuality);
            j3.setVideoQuality(videoQuality);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.c
    public void switchCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcCameraBridgeImpl", "switchCamera", "engine is not ready");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.camera.a e16 = e(false);
        if (e16 != null) {
            e16.switchCamera();
        }
    }
}

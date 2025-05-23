package com.tencent.mobileqq.qqlive.sail.trtc;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.utils.r;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00132\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J)\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/k;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/e;", "", "isEngineReady", "needCreate", "Lcom/tencent/mobileqq/qqlive/trtc/video/source/screen/c;", "d", "Lcom/tencent/mobileqq/qqlive/trtc/video/source/a;", "T", "Ljava/lang/Class;", "clazz", "g", "(Ljava/lang/Class;)Lcom/tencent/mobileqq/qqlive/trtc/video/source/a;", "Lcom/tencent/mobileqq/qqlive/trtc/a;", EnginePathProvider.ENGINE_DIR, "", "f", "Lcom/tencent/mobileqq/qqlive/data/trtc/TRTCVideoQualityParams;", "qualityParams", "b", "l", "e", "a", "Lcom/tencent/mobileqq/qqlive/trtc/a;", "trtcEngine", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class k implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.trtc.a trtcEngine;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/k$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.trtc.k$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47896);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final com.tencent.mobileqq.qqlive.trtc.video.source.screen.c d(boolean needCreate) {
        com.tencent.mobileqq.qqlive.trtc.video.source.screen.c cVar;
        com.tencent.mobileqq.qqlive.trtc.a aVar;
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcScreenBridgeImpl", "getScreenCaptureSource", "engine is not ready");
            return null;
        }
        try {
            aVar = this.trtcEngine;
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Open_Live|TRTC|TrtcScreenBridgeImpl", "getScreenCaptureSource", "error, ", e16);
        }
        if (aVar != null) {
            cVar = (com.tencent.mobileqq.qqlive.trtc.video.source.screen.c) aVar.j(com.tencent.mobileqq.qqlive.trtc.video.source.screen.c.class);
            if (cVar != null) {
                if (!needCreate) {
                    return null;
                }
                return (com.tencent.mobileqq.qqlive.trtc.video.source.screen.c) g(com.tencent.mobileqq.qqlive.trtc.video.source.screen.c.class);
            }
            return cVar;
        }
        cVar = null;
        if (cVar != null) {
        }
    }

    private final <T extends com.tencent.mobileqq.qqlive.trtc.video.source.a> T g(Class<T> clazz) {
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

    private final boolean isEngineReady() {
        com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
        if (aVar == null || aVar.getEngineState() != 2) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.e
    public void b(@Nullable TRTCVideoQualityParams qualityParams) {
        Context context;
        com.tencent.mobileqq.qqlive.trtc.engine.c d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qualityParams);
            return;
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcScreenBridgeImpl", "startScreen", "engine is not ready");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.screen.c d17 = d(true);
        if (d17 == null) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcScreenBridgeImpl", "startScreen", "no camera");
            return;
        }
        if (qualityParams == null) {
            com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
            if (aVar != null && (d16 = aVar.d()) != null) {
                context = d16.b();
            } else {
                context = null;
            }
            qualityParams = r.c(context);
        }
        d17.e(qualityParams, null);
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.trtcEngine = null;
        }
    }

    public void f(@NotNull com.tencent.mobileqq.qqlive.trtc.a engine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) engine);
        } else {
            Intrinsics.checkNotNullParameter(engine, "engine");
            this.trtcEngine = engine;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.e
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcScreenBridgeImpl", "stopScreen", "engine is not ready");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.video.source.screen.c d16 = d(false);
        if (d16 != null) {
            d16.stopScreenCapture();
        }
    }
}

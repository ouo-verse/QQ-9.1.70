package com.tencent.mobileqq.qqlive.sail.trtc;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/g;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/b;", "", "isEngineReady", "Lcom/tencent/mobileqq/qqlive/trtc/a;", EnginePathProvider.ENGINE_DIR, "", "f", "", "qualityType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "closeMic", "needCreate", "Lcom/tencent/mobileqq/qqlive/trtc/audio/b;", "d", WidgetCacheConstellationData.INTERVAL, "enableAudioVolumeEvaluation", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "setAudioVolume", "Lcom/tencent/mobileqq/qqlive/api/audio/audioeffect/IRTCMusicAccompany;", "createMusicAccompany", "mute", "e", "b", "a", "Lcom/tencent/mobileqq/qqlive/trtc/a;", "trtcEngine", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class g implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.trtc.a trtcEngine;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/g$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.trtc.g$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47883);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g() {
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

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.trtcEngine = null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.b
    public void closeMic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcAudioBridgeImpl", "stopAudio", "engine is not ready");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.audio.b d16 = d(false);
        if (d16 != null) {
            d16.d();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.b
    @Nullable
    public IRTCMusicAccompany createMusicAccompany() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (IRTCMusicAccompany) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcAudioBridgeImpl", "createMusicAccompany", "engine is not ready");
            return null;
        }
        com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
        if (aVar == null) {
            return null;
        }
        return aVar.createMusicAccompany();
    }

    @Nullable
    public com.tencent.mobileqq.qqlive.trtc.audio.b d(boolean needCreate) {
        com.tencent.mobileqq.qqlive.trtc.audio.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.qqlive.trtc.audio.b) iPatchRedirector.redirect((short) 5, (Object) this, needCreate);
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcAudioBridgeImpl", "getAudioSource", "engine is not ready");
            return null;
        }
        try {
            com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
            Intrinsics.checkNotNull(aVar);
            bVar = (com.tencent.mobileqq.qqlive.trtc.audio.b) aVar.i(com.tencent.mobileqq.qqlive.trtc.audio.b.class);
        } catch (Exception unused) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcAudioBridgeImpl", "getAudioSource", "has no audio source created");
            bVar = null;
        }
        if (bVar == null) {
            if (!needCreate) {
                return null;
            }
            com.tencent.mobileqq.qqlive.trtc.a aVar2 = this.trtcEngine;
            Intrinsics.checkNotNull(aVar2);
            com.tencent.mobileqq.qqlive.trtc.audio.b bVar2 = (com.tencent.mobileqq.qqlive.trtc.audio.b) aVar2.k(com.tencent.mobileqq.qqlive.trtc.audio.b.class);
            com.tencent.mobileqq.qqlive.trtc.a aVar3 = this.trtcEngine;
            Intrinsics.checkNotNull(aVar3);
            aVar3.c(bVar2);
            return bVar2;
        }
        return bVar;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.b
    public void e(boolean mute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, mute);
            return;
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcAudioBridgeImpl", "muteLocalMic", "engine is not ready");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.audio.b d16 = d(false);
        if (d16 != null) {
            d16.e(mute);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.b
    public void enableAudioVolumeEvaluation(int interval) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, interval);
            return;
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcAudioBridgeImpl", "enableAudioVolumeEvaluation", "engine is not ready");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.audio.b d16 = d(false);
        if (d16 != null) {
            d16.enableAudioVolumeEvaluation(interval);
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

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.b
    public void m(int qualityType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, qualityType);
            return;
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcAudioBridgeImpl", "openMic", "engine is not ready");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.audio.b d16 = d(true);
        if (d16 != null) {
            d16.g(qualityType);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.b
    public void setAudioVolume(int volume) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, volume);
            return;
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|TrtcAudioBridgeImpl", "enableAudioVolumeEvaluation", "engine is not ready");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.audio.b d16 = d(false);
        if (d16 != null) {
            d16.setAudioCaptureVolume(volume);
        }
    }
}

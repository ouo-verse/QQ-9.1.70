package com.tencent.mobileqq.qqlive.sail.trtc;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.data.trtc.RTCCameraDefine;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001SB\u0007\u00a2\u0006\u0004\bZ\u0010[J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u000b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0019\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0006H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0006H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0006H\u0096\u0001J\t\u0010\u001e\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0015\u0010!\u001a\u00020\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\bH\u0096\u0001J\t\u0010\"\u001a\u00020\u0006H\u0096\u0001J\t\u0010#\u001a\u00020\u0006H\u0096\u0001J\t\u0010$\u001a\u00020\u0006H\u0096\u0001J\u000b\u0010&\u001a\u0004\u0018\u00010%H\u0096\u0001J\u0011\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H\u0096\u0001J\u0011\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020'H\u0096\u0001J\u0011\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020'H\u0096\u0001J\u0011\u00100\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0019\u00104\u001a\u00020\u00062\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0096\u0001J\t\u00105\u001a\u00020\u0006H\u0096\u0001J\u0019\u00107\u001a\u00020\u00062\u0006\u00103\u001a\u0002062\u0006\u0010*\u001a\u00020\u000fH\u0096\u0001J\t\u00108\u001a\u00020\u0006H\u0096\u0001J\u0013\u00109\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0001J\u0019\u0010=\u001a\u00020\u00062\u0006\u0010:\u001a\u0002062\u0006\u0010<\u001a\u00020;H\u0096\u0001J\u0011\u0010>\u001a\u00020\u00062\u0006\u0010:\u001a\u000206H\u0096\u0001J#\u0010B\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u000206H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\bB\u0010CJ\u001b\u0010F\u001a\u0002012\u0006\u0010E\u001a\u00020DH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\bF\u0010GJ\"\u0010L\u001a\u00020\u00062\u0006\u0010H\u001a\u00020'2\u0006\u0010I\u001a\u00020\u000f2\b\u0010K\u001a\u0004\u0018\u00010JH\u0016J\u0010\u0010N\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u000fH\u0016J\u0010\u0010Q\u001a\u00020\u00062\u0006\u0010P\u001a\u00020OH\u0016J\b\u0010R\u001a\u00020\u0006H\u0016J\b\u0010S\u001a\u00020\u0006H\u0016J\b\u0010T\u001a\u00020\u000fH\u0016R\u0018\u0010V\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010X\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/f;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/a;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/c;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/e;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/b;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/d;", "", "u", "Lcom/tencent/mobileqq/qqlive/data/trtc/TRTCVideoQualityParams;", "getVideoQuality", "Lcom/tencent/mobileqq/qqlive/trtc/a;", EnginePathProvider.ENGINE_DIR, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/qqlive/data/trtc/RTCCameraDefine$RTCMirrorType;", "type", "", "mirror", "d", "setMirror", "Landroid/view/ViewGroup;", "viewGroup", "g", "Lcom/tencent/mobileqq/qqlive/trtc/video/videoprocess/a;", "process", "i", "videoQuality", "setVideoQuality", "f", "k", "switchCamera", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "qualityParams", "b", "l", "t", "closeMic", "Lcom/tencent/mobileqq/qqlive/api/audio/audioeffect/IRTCMusicAccompany;", "createMusicAccompany", "", WidgetCacheConstellationData.INTERVAL, "enableAudioVolumeEvaluation", "mute", "e", "qualityType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "setAudioVolume", HippyTKDListViewAdapter.X, "", "roomId", "userId", "connectRemote", "disconnectRemote", "", "muteRemoteAudio", "v", "y", "uid", "Landroid/widget/FrameLayout;", "videoView", "startRemoteView", "stopRemoteView", "Landroid/content/Context;", "context", "appId", DomainData.DOMAIN_NAME, "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qqlive/data/trtc/QQLiveRoomParams;", "params", tl.h.F, "(Lcom/tencent/mobileqq/qqlive/data/trtc/QQLiveRoomParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fps", "pauseAudio", "Landroid/graphics/Bitmap;", "holderBmp", "o", "resumeAudio", "j", "Lcom/tencent/mobileqq/qqlive/trtc/encoder/a;", "qosParam", "c", "exitRoom", "a", "isEngineReady", "Lcom/tencent/mobileqq/qqlive/trtc/a;", "trtcEngine", "Lcom/tencent/mobileqq/qqlive/sail/trtc/i;", "Lcom/tencent/mobileqq/qqlive/sail/trtc/i;", "trtcListener", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class f implements a, c, e, com.tencent.mobileqq.qqlive.sail.trtc.b, d {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ h f272440a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ k f272441b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ g f272442c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ j f272443d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.trtc.a trtcEngine;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private i trtcListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.trtc.f$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "state", "", "code", "onInitEvent"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    static final class b implements TRTCInitCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f272446a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f272447b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqlive.trtc.engine.b f272448c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f272449d;

        b(CancellableContinuation<? super Boolean> cancellableContinuation, f fVar, com.tencent.mobileqq.qqlive.trtc.engine.b bVar, String str) {
            this.f272446a = cancellableContinuation;
            this.f272447b = fVar;
            this.f272448c = bVar;
            this.f272449d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, cancellableContinuation, fVar, bVar, str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback
        public final void onInitEvent(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (!this.f272446a.isActive()) {
                AegisLogger.INSTANCE.w("Open_Live|TRTC|LiveRoomTrtcBridgeImpl", "initEngine", "cont is not active anymore");
                return;
            }
            if (i3 == 2) {
                this.f272447b.trtcEngine = this.f272448c;
                this.f272447b.A(this.f272448c);
                this.f272447b.z(this.f272448c);
                this.f272447b.x(this.f272448c);
                this.f272447b.y(this.f272448c);
                this.f272447b.trtcListener = new i(this.f272449d);
                this.f272448c.w(this.f272447b.trtcListener);
                CancellableContinuation<Boolean> cancellableContinuation = this.f272446a;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
                return;
            }
            AegisLogger.INSTANCE.w("Open_Live|TRTC|LiveRoomTrtcBridgeImpl", "initEngine", "state=" + i3 + ", code=" + i16);
            this.f272447b.a();
            CancellableContinuation<Boolean> cancellableContinuation2 = this.f272446a;
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47104);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 48)) {
            redirector.redirect((short) 48);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f272440a = new h();
        this.f272441b = new k();
        this.f272442c = new g();
        this.f272443d = new j();
    }

    public void A(@NotNull com.tencent.mobileqq.qqlive.trtc.a engine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) engine);
        } else {
            Intrinsics.checkNotNullParameter(engine, "engine");
            this.f272440a.l(engine);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this);
            return;
        }
        i iVar = this.trtcListener;
        if (iVar != null) {
            iVar.L();
        }
        u();
        w();
        t();
        v();
        com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
        if (aVar != null) {
            aVar.a();
        }
        this.trtcEngine = null;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.e
    public void b(@Nullable TRTCVideoQualityParams qualityParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) qualityParams);
        } else {
            this.f272441b.b(qualityParams);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.a
    public void c(@NotNull com.tencent.mobileqq.qqlive.trtc.encoder.a qosParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) qosParam);
            return;
        }
        Intrinsics.checkNotNullParameter(qosParam, "qosParam");
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|LiveRoomTrtcBridgeImpl", "setNetworkQosParam", "engine is not ready");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
        if (aVar != null) {
            aVar.setNetworkQosPreferenceParam(qosParam);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.b
    public void closeMic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            this.f272442c.closeMic();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.d
    public void connectRemote(long roomId, long userId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Long.valueOf(roomId), Long.valueOf(userId));
        } else {
            this.f272443d.connectRemote(roomId, userId);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.b
    @Nullable
    public IRTCMusicAccompany createMusicAccompany() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (IRTCMusicAccompany) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.f272442c.createMusicAccompany();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.c
    public void d(@NotNull RTCCameraDefine.RTCMirrorType type, boolean mirror) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, type, Boolean.valueOf(mirror));
        } else {
            Intrinsics.checkNotNullParameter(type, "type");
            this.f272440a.d(type, mirror);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.d
    public void disconnectRemote() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            this.f272443d.disconnectRemote();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.b
    public void e(boolean mute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, mute);
        } else {
            this.f272442c.e(mute);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.b
    public void enableAudioVolumeEvaluation(int interval) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, interval);
        } else {
            this.f272442c.enableAudioVolumeEvaluation(interval);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.a
    public void exitRoom() {
        com.tencent.mobileqq.qqlive.trtc.room.a m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this);
            return;
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|LiveRoomTrtcBridgeImpl", "exitRoom", "engine is not ready");
            return;
        }
        com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
        if (aVar != null && (m3 = aVar.m()) != null) {
            m3.exitRoom();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.c
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.f272440a.f();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.c
    public void g(@Nullable ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) viewGroup);
        } else {
            this.f272440a.g(viewGroup);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.c
    @Nullable
    public TRTCVideoQualityParams getVideoQuality() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TRTCVideoQualityParams) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f272440a.getVideoQuality();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.a
    @Nullable
    public Object h(@NotNull QQLiveRoomParams qQLiveRoomParams, @NotNull Continuation<? super Long> continuation) {
        Continuation intercepted;
        com.tencent.mobileqq.qqlive.trtc.room.a m3;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 40)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            if (isEngineReady()) {
                i iVar = this.trtcListener;
                if (iVar != null) {
                    iVar.M(cancellableContinuationImpl);
                }
                com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
                if (aVar != null && (m3 = aVar.m()) != null) {
                    m3.enterRoom(qQLiveRoomParams);
                }
            } else {
                AegisLogger.INSTANCE.w("Open_Live|TRTC|LiveRoomTrtcBridgeImpl", "enterRoom", "engine is not ready");
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 40, (Object) this, (Object) qQLiveRoomParams, (Object) continuation);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.c
    public void i(@Nullable com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a process) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) process);
        } else {
            this.f272440a.i(process);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.a
    public boolean isEngineReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
        if (aVar == null || aVar.getEngineState() != 2) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.a
    public void j(boolean resumeAudio) {
        com.tencent.mobileqq.qqlive.trtc.audio.a i3;
        com.tencent.mobileqq.qqlive.trtc.video.source.a j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, resumeAudio);
            return;
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|LiveRoomTrtcBridgeImpl", "resumeStream", "engine is not ready");
            return;
        }
        try {
            com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
            if (aVar != null && (j3 = aVar.j(com.tencent.mobileqq.qqlive.trtc.video.source.a.class)) != null) {
                j3.f();
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Open_Live|TRTC|LiveRoomTrtcBridgeImpl", "resumeStream", "resume video error, ", e16);
        }
        try {
            com.tencent.mobileqq.qqlive.trtc.a aVar2 = this.trtcEngine;
            if (aVar2 != null && (i3 = aVar2.i(com.tencent.mobileqq.qqlive.trtc.audio.a.class)) != null) {
                i3.f();
            }
        } catch (Exception e17) {
            AegisLogger.INSTANCE.e("Open_Live|TRTC|LiveRoomTrtcBridgeImpl", "resumeStream", "resume audio error, ", e17);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.c
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.f272440a.k();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.e
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            this.f272441b.l();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.b
    public void m(int qualityType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, qualityType);
        } else {
            this.f272442c.m(qualityType);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.d
    public void muteRemoteAudio(@NotNull String userId, boolean mute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, userId, Boolean.valueOf(mute));
        } else {
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.f272443d.muteRemoteAudio(userId, mute);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.a
    @Nullable
    public Object n(@NotNull Context context, @NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 39)) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            if (isEngineReady()) {
                AegisLogger.INSTANCE.i("Open_Live|TRTC|LiveRoomTrtcBridgeImpl", "initEngine", "engine is already inited");
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(true)));
            } else {
                com.tencent.mobileqq.qqlive.trtc.engine.b bVar = new com.tencent.mobileqq.qqlive.trtc.engine.b();
                bVar.initEngine(context, str, new b(cancellableContinuationImpl, this, bVar, str));
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return iPatchRedirector.redirect((short) 39, this, context, str, continuation);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.a
    public void o(int fps, boolean pauseAudio, @Nullable Bitmap holderBmp) {
        com.tencent.mobileqq.qqlive.trtc.audio.a i3;
        com.tencent.mobileqq.qqlive.trtc.video.source.a j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, Integer.valueOf(fps), Boolean.valueOf(pauseAudio), holderBmp);
            return;
        }
        if (!isEngineReady()) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|LiveRoomTrtcBridgeImpl", "pauseStream", "engine is not ready");
            return;
        }
        if (fps < 5 || fps > 20) {
            AegisLogger.INSTANCE.w("Open_Live|TRTC|LiveRoomTrtcBridgeImpl", "pauseStream", "invalid fps, use default value: 10");
            fps = 10;
        }
        try {
            com.tencent.mobileqq.qqlive.trtc.a aVar = this.trtcEngine;
            if (aVar != null && (j3 = aVar.j(com.tencent.mobileqq.qqlive.trtc.video.source.a.class)) != null) {
                if (holderBmp != null) {
                    j3.i(holderBmp, fps);
                }
                j3.b();
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Open_Live|TRTC|LiveRoomTrtcBridgeImpl", "pauseStream", "pause video error, ", e16);
        }
        try {
            com.tencent.mobileqq.qqlive.trtc.a aVar2 = this.trtcEngine;
            if (aVar2 != null && (i3 = aVar2.i(com.tencent.mobileqq.qqlive.trtc.audio.a.class)) != null) {
                i3.b();
            }
        } catch (Exception e17) {
            AegisLogger.INSTANCE.e("Open_Live|TRTC|LiveRoomTrtcBridgeImpl", "pauseStream", "pause audio error, ", e17);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.b
    public void setAudioVolume(int volume) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, volume);
        } else {
            this.f272442c.setAudioVolume(volume);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.c
    public void setMirror(boolean mirror) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, mirror);
        } else {
            this.f272440a.setMirror(mirror);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.c
    public void setVideoQuality(@NotNull TRTCVideoQualityParams videoQuality) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) videoQuality);
        } else {
            Intrinsics.checkNotNullParameter(videoQuality, "videoQuality");
            this.f272440a.setVideoQuality(videoQuality);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.d
    public void startRemoteView(@NotNull String uid, @NotNull FrameLayout videoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) uid, (Object) videoView);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        this.f272443d.startRemoteView(uid, videoView);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.d
    public void stopRemoteView(@NotNull String uid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) uid);
        } else {
            Intrinsics.checkNotNullParameter(uid, "uid");
            this.f272443d.stopRemoteView(uid);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.trtc.c
    public void switchCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            this.f272440a.switchCamera();
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            this.f272442c.b();
        }
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f272440a.b();
        }
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
        } else {
            this.f272443d.b();
        }
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.f272441b.e();
        }
    }

    public void x(@NotNull com.tencent.mobileqq.qqlive.trtc.a engine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) engine);
        } else {
            Intrinsics.checkNotNullParameter(engine, "engine");
            this.f272442c.f(engine);
        }
    }

    public void y(@Nullable com.tencent.mobileqq.qqlive.trtc.a engine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) engine);
        } else {
            this.f272443d.d(engine);
        }
    }

    public void z(@NotNull com.tencent.mobileqq.qqlive.trtc.a engine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) engine);
        } else {
            Intrinsics.checkNotNullParameter(engine, "engine");
            this.f272441b.f(engine);
        }
    }
}

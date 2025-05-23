package com.tencent.mobileqq.qqlive.sail.room;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany;
import com.tencent.mobileqq.qqlive.data.trtc.RTCCameraDefine;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.sail.error.a;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.utils.LiveCoroutineScopes;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Y2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001ZB\u0017\u0012\u0006\u0010S\u001a\u00020\u0017\u0012\u0006\u0010H\u001a\u00020E\u00a2\u0006\u0004\bT\u0010UB\u0019\b\u0016\u0012\u0006\u0010W\u001a\u00020V\u0012\u0006\u0010H\u001a\u00020E\u00a2\u0006\u0004\bT\u0010XJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\bJ\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0019\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0096\u0001J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\t\u0010\u0012\u001a\u00020\nH\u0096\u0001J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u0019\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u001a\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096\u0001J\u0019\u0010!\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0004H\u0096\u0001J\u0011\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\"H\u0096\u0001J\u0013\u0010'\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010%H\u0096\u0001J\u0013\u0010*\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010(H\u0096\u0001J\u0011\u0010,\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u0015H\u0096\u0001J\u0019\u00100\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00172\u0006\u0010/\u001a\u00020.H\u0096\u0001J\u0011\u00101\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u0017H\u0096\u0001J\t\u00102\u001a\u00020\nH\u0096\u0001J\b\u00103\u001a\u00020\u0017H\u0016J\u0015\u00105\u001a\b\u0012\u0004\u0012\u00020\u001704H\u0016\u00a2\u0006\u0004\b5\u00106J;\u0010=\u001a\u00020\n21\u0010<\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\n07j\b\u0012\u0004\u0012\u00020\u0004`;H\u0016JC\u0010?\u001a\u00020\n2\u0006\u0010>\u001a\u00020\u000421\u0010<\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\n07j\b\u0012\u0004\u0012\u00020\u0004`;H\u0016J;\u0010@\u001a\u00020\n21\u0010<\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\n07j\b\u0012\u0004\u0012\u00020\u0004`;H\u0016J;\u0010A\u001a\u00020\n21\u0010<\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\n07j\b\u0012\u0004\u0012\u00020\u0004`;H\u0016J\b\u0010B\u001a\u00020\nH\u0016J\b\u0010C\u001a\u00020\nH\u0016J\b\u0010D\u001a\u00020\nH\u0016R\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010\tR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/LiveAnchorTrtcRoom;", "Lcom/tencent/mobileqq/qqlive/sail/room/LiveAnchorRoom;", "Lcom/tencent/mobileqq/qqlive/sail/room/d;", "Lcom/tencent/mobileqq/qqlive/sail/room/i;", "", "Y", "Lcom/tencent/mobileqq/qqlive/sail/room/l;", "c0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Z", "", "closeMic", "", "roomId", "userId", "connectRemote", "Lcom/tencent/mobileqq/qqlive/api/audio/audioeffect/IRTCMusicAccompany;", "createMusicAccompany", "disconnectRemote", "Landroid/view/ViewGroup;", "getDisplayView", "Lcom/tencent/mobileqq/qqlive/data/trtc/TRTCVideoQualityParams;", "getVideoQuality", "", "mute", "muteRemoteAudio", "openMic", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "setAudioVolume", "Lcom/tencent/mobileqq/qqlive/data/trtc/RTCCameraDefine$RTCMirrorType;", "type", "mirror", "setCameraMirror", "Lcom/tencent/mobileqq/qqlive/trtc/encoder/a;", "qosParam", "c", "Landroid/graphics/Bitmap;", "bmp", "g", "Lcom/tencent/mobileqq/qqlive/trtc/video/videoprocess/a;", "process", "l", "params", "setVideoQuality", "uid", "Landroid/widget/FrameLayout;", "videoView", "startRemoteView", "stopRemoteView", "switchCamera", "N", "", "a0", "()[Ljava/lang/String;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mobileqq/qqlive/sail/room/Resulter;", "callback", "j", "enablePushStream", "b0", "v", "f", "resume", "pause", "destroy", "Lcom/tencent/mobileqq/qqlive/sail/room/RoomTrtcProxyImpl;", "E", "Lcom/tencent/mobileqq/qqlive/sail/room/RoomTrtcProxyImpl;", "trtcProxy", UserInfo.SEX_FEMALE, "isStreamPushed", "Lkotlin/coroutines/CoroutineContext;", "G", "Lkotlin/coroutines/CoroutineContext;", "initTrtcCoroutineContext", "Lkotlinx/coroutines/sync/Mutex;", "H", "Lkotlinx/coroutines/sync/Mutex;", "initTrtcMutex", "appId", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqlive/sail/room/RoomTrtcProxyImpl;)V", "Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "roomInfo", "(Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;Lcom/tencent/mobileqq/qqlive/sail/room/RoomTrtcProxyImpl;)V", "I", "a", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class LiveAnchorTrtcRoom extends LiveAnchorRoom implements d, i {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final RoomTrtcProxyImpl trtcProxy;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isStreamPushed;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final CoroutineContext initTrtcCoroutineContext;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Mutex initTrtcMutex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/LiveAnchorTrtcRoom$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.room.LiveAnchorTrtcRoom$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45900);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveAnchorTrtcRoom(@NotNull String appId, @NotNull RoomTrtcProxyImpl trtcProxy) {
        super(appId);
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(trtcProxy, "trtcProxy");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appId, (Object) trtcProxy);
            return;
        }
        this.trtcProxy = trtcProxy;
        this.initTrtcCoroutineContext = LiveCoroutineScopes.f273421a.b().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new j("Open_Live|initTrtc"));
        this.initTrtcMutex = MutexKt.Mutex$default(false, 1, null);
    }

    private final boolean Y() {
        for (String str : a0()) {
            if (BaseApplication.context.checkSelfPermission(str) != 0) {
                AegisLogger.INSTANCE.w(N(), "checkPermissions", str + " is not granted");
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Z(Continuation<? super l<Boolean>> continuation) {
        LiveAnchorTrtcRoom$doInitTrtc$1 liveAnchorTrtcRoom$doInitTrtc$1;
        Object coroutine_suspended;
        int i3;
        LiveAnchorTrtcRoom liveAnchorTrtcRoom;
        LiveAnchorTrtcRoom liveAnchorTrtcRoom2;
        l c16;
        if (continuation instanceof LiveAnchorTrtcRoom$doInitTrtc$1) {
            liveAnchorTrtcRoom$doInitTrtc$1 = (LiveAnchorTrtcRoom$doInitTrtc$1) continuation;
            int i16 = liveAnchorTrtcRoom$doInitTrtc$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                liveAnchorTrtcRoom$doInitTrtc$1.label = i16 - Integer.MIN_VALUE;
                Object obj = liveAnchorTrtcRoom$doInitTrtc$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = liveAnchorTrtcRoom$doInitTrtc$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            liveAnchorTrtcRoom2 = (LiveAnchorTrtcRoom) liveAnchorTrtcRoom$doInitTrtc$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            if (!((Boolean) obj).booleanValue()) {
                                AegisLogger.INSTANCE.i(liveAnchorTrtcRoom2.N(), "doInitTrtc", "init trtc success");
                                c16 = new l(Boxing.boxBoolean(true), 0L, null, 0, 12, null);
                            } else {
                                AegisLogger.INSTANCE.w(liveAnchorTrtcRoom2.N(), "doInitTrtc", "init trtc failed");
                                c16 = a.Companion.c(com.tencent.mobileqq.qqlive.sail.error.a.INSTANCE, -10000002L, Boxing.boxBoolean(false), null, 4, null);
                            }
                            liveAnchorTrtcRoom = liveAnchorTrtcRoom2;
                            Mutex.DefaultImpls.unlock$default(liveAnchorTrtcRoom.initTrtcMutex, null, 1, null);
                            return c16;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    liveAnchorTrtcRoom = (LiveAnchorTrtcRoom) liveAnchorTrtcRoom$doInitTrtc$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    AegisLogger.INSTANCE.i(N(), "doInitTrtc");
                    Mutex mutex = this.initTrtcMutex;
                    liveAnchorTrtcRoom$doInitTrtc$1.L$0 = this;
                    liveAnchorTrtcRoom$doInitTrtc$1.label = 1;
                    if (Mutex.DefaultImpls.lock$default(mutex, null, liveAnchorTrtcRoom$doInitTrtc$1, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    liveAnchorTrtcRoom = this;
                }
                if (!liveAnchorTrtcRoom.trtcProxy.m()) {
                    AegisLogger.INSTANCE.i(liveAnchorTrtcRoom.N(), "doInitTrtc", "already inited");
                    c16 = a.Companion.c(com.tencent.mobileqq.qqlive.sail.error.a.INSTANCE, 0L, Boxing.boxBoolean(true), null, 4, null);
                } else if (!liveAnchorTrtcRoom.Y()) {
                    AegisLogger.INSTANCE.w(liveAnchorTrtcRoom.N(), "doInitTrtc", "check permission failed");
                    c16 = a.Companion.c(com.tencent.mobileqq.qqlive.sail.error.a.INSTANCE, -10000001L, Boxing.boxBoolean(false), null, 4, null);
                } else {
                    RoomTrtcProxyImpl roomTrtcProxyImpl = liveAnchorTrtcRoom.trtcProxy;
                    BaseApplication context = BaseApplication.context;
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    String J = liveAnchorTrtcRoom.J();
                    liveAnchorTrtcRoom$doInitTrtc$1.L$0 = liveAnchorTrtcRoom;
                    liveAnchorTrtcRoom$doInitTrtc$1.label = 2;
                    obj = roomTrtcProxyImpl.k(context, J, liveAnchorTrtcRoom$doInitTrtc$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    liveAnchorTrtcRoom2 = liveAnchorTrtcRoom;
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    liveAnchorTrtcRoom = liveAnchorTrtcRoom2;
                }
                Mutex.DefaultImpls.unlock$default(liveAnchorTrtcRoom.initTrtcMutex, null, 1, null);
                return c16;
            }
        }
        liveAnchorTrtcRoom$doInitTrtc$1 = new LiveAnchorTrtcRoom$doInitTrtc$1(this, continuation);
        Object obj2 = liveAnchorTrtcRoom$doInitTrtc$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = liveAnchorTrtcRoom$doInitTrtc$1.label;
        if (i3 == 0) {
        }
        if (!liveAnchorTrtcRoom.trtcProxy.m()) {
        }
        Mutex.DefaultImpls.unlock$default(liveAnchorTrtcRoom.initTrtcMutex, null, 1, null);
        return c16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c0(Continuation<? super l<Boolean>> continuation) {
        LiveAnchorTrtcRoom$tryPushStream$1 liveAnchorTrtcRoom$tryPushStream$1;
        Object coroutine_suspended;
        int i3;
        LiveAnchorTrtcRoom liveAnchorTrtcRoom;
        l lVar;
        l lVar2;
        l lVar3;
        LiveAnchorTrtcRoom liveAnchorTrtcRoom2;
        long longValue;
        if (continuation instanceof LiveAnchorTrtcRoom$tryPushStream$1) {
            liveAnchorTrtcRoom$tryPushStream$1 = (LiveAnchorTrtcRoom$tryPushStream$1) continuation;
            int i16 = liveAnchorTrtcRoom$tryPushStream$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                liveAnchorTrtcRoom$tryPushStream$1.label = i16 - Integer.MIN_VALUE;
                Object obj = liveAnchorTrtcRoom$tryPushStream$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = liveAnchorTrtcRoom$tryPushStream$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    liveAnchorTrtcRoom2 = (LiveAnchorTrtcRoom) liveAnchorTrtcRoom$tryPushStream$1.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    longValue = ((Number) obj).longValue();
                                    if (longValue >= 0) {
                                        AegisLogger.INSTANCE.w(liveAnchorTrtcRoom2.N(), "tryPushStream", "trtc enter room failed, errCode=" + longValue);
                                        return new l(Boxing.boxBoolean(false), longValue, "trtc enter room failed", 4);
                                    }
                                    AegisLogger.INSTANCE.i(liveAnchorTrtcRoom2.N(), "tryPushStream", "room push stream success");
                                    liveAnchorTrtcRoom2.isStreamPushed = true;
                                    return new l(Boxing.boxBoolean(true), 0L, null, 0, 12, null);
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            liveAnchorTrtcRoom = (LiveAnchorTrtcRoom) liveAnchorTrtcRoom$tryPushStream$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            lVar3 = (l) obj;
                            if (lVar3.b() == 0) {
                                AegisLogger.INSTANCE.w(liveAnchorTrtcRoom.N(), "tryPushStream", "new stream failed, " + lVar3);
                                return lVar3.a(Boxing.boxBoolean(false));
                            }
                            RoomTrtcProxyImpl roomTrtcProxyImpl = liveAnchorTrtcRoom.trtcProxy;
                            AnchorRoomInfo L = liveAnchorTrtcRoom.L();
                            liveAnchorTrtcRoom$tryPushStream$1.L$0 = liveAnchorTrtcRoom;
                            liveAnchorTrtcRoom$tryPushStream$1.label = 4;
                            obj = roomTrtcProxyImpl.d(L, liveAnchorTrtcRoom$tryPushStream$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            liveAnchorTrtcRoom2 = liveAnchorTrtcRoom;
                            longValue = ((Number) obj).longValue();
                            if (longValue >= 0) {
                            }
                        } else {
                            liveAnchorTrtcRoom = (LiveAnchorTrtcRoom) liveAnchorTrtcRoom$tryPushStream$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            lVar2 = (l) obj;
                            if (lVar2.b() == 0) {
                                AegisLogger.INSTANCE.w(liveAnchorTrtcRoom.N(), "tryPushStream", "business enter room failed, " + lVar2);
                                return lVar2.a(Boxing.boxBoolean(false));
                            }
                            AnchorRoomInfo L2 = liveAnchorTrtcRoom.L();
                            Object d16 = lVar2.d();
                            Intrinsics.checkNotNull(d16);
                            L2.w((gr4.e) d16);
                            liveAnchorTrtcRoom$tryPushStream$1.L$0 = liveAnchorTrtcRoom;
                            liveAnchorTrtcRoom$tryPushStream$1.label = 3;
                            obj = liveAnchorTrtcRoom.R(liveAnchorTrtcRoom$tryPushStream$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            lVar3 = (l) obj;
                            if (lVar3.b() == 0) {
                            }
                        }
                    } else {
                        liveAnchorTrtcRoom = (LiveAnchorTrtcRoom) liveAnchorTrtcRoom$tryPushStream$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (this.isStreamPushed) {
                        AegisLogger.INSTANCE.i(N(), "", "room is streaming now");
                        return new l(Boxing.boxBoolean(true), 0L, null, 0, 12, null);
                    }
                    liveAnchorTrtcRoom$tryPushStream$1.L$0 = this;
                    liveAnchorTrtcRoom$tryPushStream$1.label = 1;
                    obj = P(liveAnchorTrtcRoom$tryPushStream$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    liveAnchorTrtcRoom = this;
                }
                lVar = (l) obj;
                if (lVar.b() == 0) {
                    AegisLogger.INSTANCE.w(liveAnchorTrtcRoom.N(), "tryPushStream", "setRoom failed, " + lVar);
                    return lVar.a(Boxing.boxBoolean(false));
                }
                liveAnchorTrtcRoom$tryPushStream$1.L$0 = liveAnchorTrtcRoom;
                liveAnchorTrtcRoom$tryPushStream$1.label = 2;
                obj = liveAnchorTrtcRoom.H(liveAnchorTrtcRoom$tryPushStream$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                lVar2 = (l) obj;
                if (lVar2.b() == 0) {
                }
            }
        }
        liveAnchorTrtcRoom$tryPushStream$1 = new LiveAnchorTrtcRoom$tryPushStream$1(this, continuation);
        Object obj2 = liveAnchorTrtcRoom$tryPushStream$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = liveAnchorTrtcRoom$tryPushStream$1.label;
        if (i3 == 0) {
        }
        lVar = (l) obj2;
        if (lVar.b() == 0) {
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.LiveAnchorRoom
    @NotNull
    public String N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return "Open_Live|LiveAnchorTrtcRoom";
    }

    @NotNull
    public String[] a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String[]) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return RoomTrtcProxyImpl.INSTANCE.a();
    }

    public void b0(boolean enablePushStream, @NotNull Function1<? super l<Boolean>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Boolean.valueOf(enablePushStream), callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveAnchorTrtcRoom$start$1(this, callback, enablePushStream, null), 3, null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void c(@NotNull com.tencent.mobileqq.qqlive.trtc.encoder.a qosParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) qosParam);
        } else {
            Intrinsics.checkNotNullParameter(qosParam, "qosParam");
            this.trtcProxy.c(qosParam);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void closeMic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.trtcProxy.closeMic();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void connectRemote(long roomId, long userId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(roomId), Long.valueOf(userId));
        } else {
            this.trtcProxy.connectRemote(roomId, userId);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    @Nullable
    public IRTCMusicAccompany createMusicAccompany() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IRTCMusicAccompany) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.trtcProxy.createMusicAccompany();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveAnchorTrtcRoom$destroy$1(this, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 30, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void disconnectRemote() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.trtcProxy.disconnectRemote();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.d
    public void f(@NotNull Function1<? super l<Boolean>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveAnchorTrtcRoom$pushStream$1(this, callback, null), 3, null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void g(@Nullable Bitmap bmp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bmp);
        } else {
            this.trtcProxy.g(bmp);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    @Nullable
    public ViewGroup getDisplayView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.trtcProxy.h();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    @Nullable
    public TRTCVideoQualityParams getVideoQuality() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TRTCVideoQualityParams) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.trtcProxy.getVideoQuality();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.d
    public void j(@NotNull Function1<? super l<Boolean>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveAnchorTrtcRoom$initTrtc$1(this, callback, null), 3, null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void l(@Nullable com.tencent.mobileqq.qqlive.trtc.video.videoprocess.a process) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) process);
        } else {
            this.trtcProxy.l(process);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void muteRemoteAudio(@NotNull String userId, boolean mute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, userId, Boolean.valueOf(mute));
        } else {
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.trtcProxy.muteRemoteAudio(userId, mute);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void openMic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.trtcProxy.openMic();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveAnchorTrtcRoom$pause$1(this, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 28, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new LiveAnchorTrtcRoom$resume$1(this, null), 3, null);
        } else {
            iPatchRedirector.redirect((short) 27, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void setAudioVolume(int volume) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, volume);
        } else {
            this.trtcProxy.setAudioVolume(volume);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void setCameraMirror(@NotNull RTCCameraDefine.RTCMirrorType type, boolean mirror) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, type, Boolean.valueOf(mirror));
        } else {
            Intrinsics.checkNotNullParameter(type, "type");
            this.trtcProxy.setCameraMirror(type, mirror);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void setVideoQuality(@NotNull TRTCVideoQualityParams params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) params);
        } else {
            Intrinsics.checkNotNullParameter(params, "params");
            this.trtcProxy.setVideoQuality(params);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void startRemoteView(@NotNull String uid, @NotNull FrameLayout videoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) uid, (Object) videoView);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        this.trtcProxy.startRemoteView(uid, videoView);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void stopRemoteView(@NotNull String uid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) uid);
        } else {
            Intrinsics.checkNotNullParameter(uid, "uid");
            this.trtcProxy.stopRemoteView(uid);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.i
    public void switchCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            this.trtcProxy.switchCamera();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.f
    public void v(@NotNull Function1<? super l<Boolean>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            b0(false, callback);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveAnchorTrtcRoom(@NotNull AnchorRoomInfo roomInfo, @NotNull RoomTrtcProxyImpl trtcProxy) {
        this(roomInfo.m(), trtcProxy);
        AnchorRoomInfo a16;
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        Intrinsics.checkNotNullParameter(trtcProxy, "trtcProxy");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) roomInfo, (Object) trtcProxy);
        } else {
            if (roomInfo.v()) {
                a16 = roomInfo.a((r28 & 1) != 0 ? roomInfo.avConfig : null, (r28 & 2) != 0 ? roomInfo.basicInfo : null, (r28 & 4) != 0 ? roomInfo.settingInfo : null, (r28 & 8) != 0 ? roomInfo.anchorInfo : null, (r28 & 16) != 0 ? roomInfo.trtcInfo : null, (r28 & 32) != 0 ? roomInfo.thirdPushInfo : null, (r28 & 64) != 0 ? roomInfo.heartBeatTime : 0L, (r28 & 128) != 0 ? roomInfo.appId : null, (r28 & 256) != 0 ? roomInfo.enterRoomTime : 0L, (r28 & 512) != 0 ? roomInfo.popupDialogUrl : null, (r28 & 1024) != 0 ? roomInfo.backgroundInfo : null);
                Q(a16);
                M().a(20);
                return;
            }
            AegisLogger.INSTANCE.w(N(), "constructor", "roomInfo is invalid");
        }
    }
}

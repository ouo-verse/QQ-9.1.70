package com.tencent.mobileqq.qqlive.api.impl.room.module;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.anchor.room.helper.u;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.av.AudioVolumeListener;
import com.tencent.mobileqq.qqlive.api.av.UserAudioAvailableListener;
import com.tencent.mobileqq.qqlive.api.av.UserVolumeInfo;
import com.tencent.mobileqq.qqlive.api.av.VoiceRoomListener;
import com.tencent.mobileqq.qqlive.api.impl.room.corelog.EnterExitTRTCRoomLog;
import com.tencent.mobileqq.qqlive.api.impl.room.voiceroom.ITRTCAudioRoom;
import com.tencent.mobileqq.qqlive.data.datareport.StatisticData;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveQuality;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener;
import com.tencent.mobileqq.qqlive.listener.trtc.RemoteUserAudioInfo;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002EH\u0018\u0000 P2\u00020\u0001:\u0002PQB\u0007\u00a2\u0006\u0004\bN\u0010OJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J \u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0019H\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010'\u001a\u00020\b2\u0006\u0010#\u001a\u00020&H\u0016J\u0010\u0010(\u001a\u00020\b2\u0006\u0010#\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020\b2\u0006\u0010#\u001a\u00020)H\u0016J\u0010\u0010+\u001a\u00020\b2\u0006\u0010#\u001a\u00020)H\u0016J\b\u0010,\u001a\u00020\bH\u0016R\u0016\u0010-\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00101\u001a\n 0*\u0004\u0018\u00010/0/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R!\u0010>\u001a\b\u0012\u0004\u0012\u00020\"098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R!\u0010A\u001a\b\u0012\u0004\u0012\u00020&098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010;\u001a\u0004\b@\u0010=R!\u0010D\u001a\b\u0012\u0004\u0012\u00020)098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010;\u001a\u0004\bC\u0010=R\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/room/module/TRTCAudioRoomModule;", "Lcom/tencent/mobileqq/qqlive/api/impl/room/voiceroom/ITRTCAudioRoom;", "Landroid/content/Context;", "appContext", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "liveSDK", "Lcom/tencent/mobileqq/qqlive/api/impl/room/module/TRTCAudioRoomModule$TrtcSdkInitListener;", "initListener", "", "initTRTC", "", "state", "code", "onInitFailed", "onInitSuccess", "initTRTCListener", "init", "errorCode", "", "msg", "notifyPreEnterRoomError", "Lcom/tencent/mobileqq/qqlive/data/trtc/QQLiveRoomParams;", "params", "enterRoom", "exitRoom", "", "enable", "enableMic", "isMicEnable", "startSpeaking", "stopSpeaking", "userId", "mute", "muteUserVoice", "Lcom/tencent/mobileqq/qqlive/api/av/AudioVolumeListener;", "listener", "addAudioVolumeListener", "removeAudioVolumeListener", "Lcom/tencent/mobileqq/qqlive/api/av/UserAudioAvailableListener;", "addUserAudioAvailableListener", "removeUserAudioAvailableListener", "Lcom/tencent/mobileqq/qqlive/api/av/VoiceRoomListener;", "addVoiceRoomListener", "removeVoiceRoomListener", "releaseTrtc", "isTRTCInit", "Z", "Lcom/tencent/mobileqq/qqlive/trtc/b;", "kotlin.jvm.PlatformType", "tRTCProxy", "Lcom/tencent/mobileqq/qqlive/trtc/b;", "Lcom/tencent/mobileqq/qqlive/anchor/report/a;", "techReport", "Lcom/tencent/mobileqq/qqlive/anchor/report/a;", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLogger", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "volumeListeners$delegate", "Lkotlin/Lazy;", "getVolumeListeners", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "volumeListeners", "userAudioAvailableListenerList$delegate", "getUserAudioAvailableListenerList", "userAudioAvailableListenerList", "roomListenerList$delegate", "getRoomListenerList", "roomListenerList", "com/tencent/mobileqq/qqlive/api/impl/room/module/TRTCAudioRoomModule$tRTCRoomListener$1", "tRTCRoomListener", "Lcom/tencent/mobileqq/qqlive/api/impl/room/module/TRTCAudioRoomModule$tRTCRoomListener$1;", "com/tencent/mobileqq/qqlive/api/impl/room/module/TRTCAudioRoomModule$tRTCRemoteListener$1", "tRTCRemoteListener", "Lcom/tencent/mobileqq/qqlive/api/impl/room/module/TRTCAudioRoomModule$tRTCRemoteListener$1;", "Lcom/tencent/mobileqq/qqlive/trtc/video/source/screen/d;", "statisticDataListener", "Lcom/tencent/mobileqq/qqlive/trtc/video/source/screen/d;", "<init>", "()V", "Companion", "TrtcSdkInitListener", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class TRTCAudioRoomModule implements ITRTCAudioRoom {
    static IPatchRedirector $redirector_ = null;

    @Deprecated
    private static final int AUDIO_VOLUME_NOTIFICATION_INTERVAL = 300;

    @NotNull
    private static final Companion Companion;

    @Deprecated
    private static final long ERROR_NOT_LOGIN = -19999;

    @Deprecated
    @NotNull
    private static final String TAG = "TRTCAudioRoomModule";

    @NotNull
    private final IAegisLogApi aegisLogger;
    private boolean isTRTCInit;

    /* renamed from: roomListenerList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy roomListenerList;

    @NotNull
    private final d statisticDataListener;
    private final com.tencent.mobileqq.qqlive.trtc.b tRTCProxy;

    @NotNull
    private final TRTCAudioRoomModule$tRTCRemoteListener$1 tRTCRemoteListener;

    @NotNull
    private final TRTCAudioRoomModule$tRTCRoomListener$1 tRTCRoomListener;

    @NotNull
    private final com.tencent.mobileqq.qqlive.anchor.report.a techReport;

    /* renamed from: userAudioAvailableListenerList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy userAudioAvailableListenerList;

    /* renamed from: volumeListeners$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy volumeListeners;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/room/module/TRTCAudioRoomModule$Companion;", "", "()V", "AUDIO_VOLUME_NOTIFICATION_INTERVAL", "", "ERROR_NOT_LOGIN", "", "TAG", "", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    private static final class Companion {
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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/room/module/TRTCAudioRoomModule$TrtcSdkInitListener;", "", "onInitFailed", "", "state", "", "code", "onInitSuccess", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public interface TrtcSdkInitListener {
        void onInitFailed(int state, int code);

        void onInitSuccess();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32909);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            Companion = new Companion(null);
        }
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [com.tencent.mobileqq.qqlive.api.impl.room.module.TRTCAudioRoomModule$tRTCRoomListener$1] */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.tencent.mobileqq.qqlive.api.impl.room.module.TRTCAudioRoomModule$tRTCRemoteListener$1] */
    public TRTCAudioRoomModule() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.tRTCProxy = com.tencent.mobileqq.qqlive.trtc.b.r();
        this.techReport = new com.tencent.mobileqq.qqlive.anchor.report.a();
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLogger = (IAegisLogApi) api;
        lazy = LazyKt__LazyJVMKt.lazy(TRTCAudioRoomModule$volumeListeners$2.INSTANCE);
        this.volumeListeners = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(TRTCAudioRoomModule$userAudioAvailableListenerList$2.INSTANCE);
        this.userAudioAvailableListenerList = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(TRTCAudioRoomModule$roomListenerList$2.INSTANCE);
        this.roomListenerList = lazy3;
        this.tRTCRoomListener = new u() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.module.TRTCAudioRoomModule$tRTCRoomListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TRTCAudioRoomModule.this);
                }
            }

            private final void onEnterRoomError(int errorCode, String message) {
                com.tencent.mobileqq.qqlive.anchor.report.a aVar;
                EnterExitTRTCRoomLog.INSTANCE.errorEnterTRTCRoom("errorCode:" + errorCode + ",message:" + message);
                aVar = TRTCAudioRoomModule.this.techReport;
                aVar.x(errorCode, message);
            }

            @Override // com.tencent.mobileqq.qqlive.anchor.room.helper.u, com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
            public void onEnterRoom(long errCode, @Nullable String message) {
                com.tencent.mobileqq.qqlive.anchor.report.a aVar;
                com.tencent.mobileqq.qqlive.trtc.b bVar;
                CopyOnWriteArrayList roomListenerList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Long.valueOf(errCode), message);
                    return;
                }
                super.onEnterRoom(errCode, message);
                aVar = TRTCAudioRoomModule.this.techReport;
                aVar.w(errCode, message);
                if (errCode < 0) {
                    EnterExitTRTCRoomLog.INSTANCE.errorEnterTRTCRoom("errCode:" + errCode + ",message:" + message);
                    onEnterRoomError((int) errCode, message);
                } else {
                    EnterExitTRTCRoomLog.INSTANCE.endEnteringTRTCRoom("cost " + errCode + " ms");
                    bVar = TRTCAudioRoomModule.this.tRTCProxy;
                    bVar.j(300);
                }
                roomListenerList = TRTCAudioRoomModule.this.getRoomListenerList();
                Iterator it = roomListenerList.iterator();
                while (it.hasNext()) {
                    ((VoiceRoomListener) it.next()).onEnterRoom(errCode, message);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.anchor.room.helper.u, com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
            public void onEvent(int eventId, int errorCode, @Nullable String message, @Nullable Bundle data) {
                IAegisLogApi iAegisLogApi;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Integer.valueOf(eventId), Integer.valueOf(errorCode), message, data);
                    return;
                }
                super.onEvent(eventId, errorCode, message, data);
                iAegisLogApi = TRTCAudioRoomModule.this.aegisLogger;
                iAegisLogApi.i("TRTCAudioRoomModule", "onEvent eventId:" + eventId + ",errorCode:" + errorCode + ",message:" + message);
                if (eventId != 1000) {
                    return;
                }
                onEnterRoomError(errorCode, message);
            }

            @Override // com.tencent.mobileqq.qqlive.anchor.room.helper.u, com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener
            public void onExitRoom(int reason) {
                CopyOnWriteArrayList roomListenerList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, reason);
                    return;
                }
                super.onExitRoom(reason);
                EnterExitTRTCRoomLog.INSTANCE.endExitingTRTCRoom("reason:" + reason);
                roomListenerList = TRTCAudioRoomModule.this.getRoomListenerList();
                Iterator it = roomListenerList.iterator();
                while (it.hasNext()) {
                    ((VoiceRoomListener) it.next()).onExitRoom(reason);
                }
            }
        };
        this.tRTCRemoteListener = new ITRTCRemoteListener() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.module.TRTCAudioRoomModule$tRTCRemoteListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TRTCAudioRoomModule.this);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
            public /* synthetic */ void onConnectOtherRoom(String str, int i3, String str2) {
                com.tencent.mobileqq.qqlive.listener.trtc.a.a(this, str, i3, str2);
            }

            @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
            public /* synthetic */ void onDisConnectOtherRoom(int i3, String str) {
                com.tencent.mobileqq.qqlive.listener.trtc.a.b(this, i3, str);
            }

            @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
            public /* synthetic */ void onFirstAudioFrame(String str) {
                com.tencent.mobileqq.qqlive.listener.trtc.a.c(this, str);
            }

            @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
            public /* synthetic */ void onFirstVideoFrame(String str, int i3, int i16, int i17) {
                com.tencent.mobileqq.qqlive.listener.trtc.a.d(this, str, i3, i16, i17);
            }

            @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
            public /* synthetic */ void onNetworkQuality(QQLiveQuality qQLiveQuality, ArrayList arrayList) {
                com.tencent.mobileqq.qqlive.listener.trtc.a.e(this, qQLiveQuality, arrayList);
            }

            @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
            public void onUserAudioAvailable(@Nullable String userId, boolean available) {
                IAegisLogApi iAegisLogApi;
                CopyOnWriteArrayList userAudioAvailableListenerList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                    iAegisLogApi = TRTCAudioRoomModule.this.aegisLogger;
                    iAegisLogApi.i("TRTCAudioRoomModule", "onUserAudioAvailable user:" + userId + ",available:" + available);
                    if (userId != null) {
                        userAudioAvailableListenerList = TRTCAudioRoomModule.this.getUserAudioAvailableListenerList();
                        Iterator it = userAudioAvailableListenerList.iterator();
                        while (it.hasNext()) {
                            ((UserAudioAvailableListener) it.next()).onUserAudioAvailable(userId, available);
                        }
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 3, this, userId, Boolean.valueOf(available));
            }

            @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
            public void onUserSei(@Nullable String userId, @Nullable byte[] sei) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) userId, (Object) sei);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
            public void onUserVideoAvailable(@Nullable String userId, boolean available) {
                IAegisLogApi iAegisLogApi;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 4)) {
                    iAegisLogApi = TRTCAudioRoomModule.this.aegisLogger;
                    iAegisLogApi.i("TRTCAudioRoomModule", "onUserVideoAvailable user:" + userId + ",available:" + available);
                    return;
                }
                iPatchRedirector2.redirect((short) 4, this, userId, Boolean.valueOf(available));
            }

            @Override // com.tencent.mobileqq.qqlive.listener.trtc.ITRTCRemoteListener
            public void onUserVoiceVolume(@Nullable ArrayList<RemoteUserAudioInfo> userVolumes, int totalVolume) {
                IAegisLogApi iAegisLogApi;
                CopyOnWriteArrayList volumeListeners;
                List<UserVolumeInfo> list;
                int collectionSizeOrDefault;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    iAegisLogApi = TRTCAudioRoomModule.this.aegisLogger;
                    iAegisLogApi.d("TRTCAudioRoomModule", "onUserVoiceVolume totalVolume:" + totalVolume);
                    volumeListeners = TRTCAudioRoomModule.this.getVolumeListeners();
                    Iterator it = volumeListeners.iterator();
                    while (it.hasNext()) {
                        AudioVolumeListener audioVolumeListener = (AudioVolumeListener) it.next();
                        if (userVolumes != null) {
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(userVolumes, 10);
                            list = new ArrayList<>(collectionSizeOrDefault);
                            Iterator<T> it5 = userVolumes.iterator();
                            while (it5.hasNext()) {
                                list.add(UserVolumeInfo.parse((RemoteUserAudioInfo) it5.next()));
                            }
                        } else {
                            list = null;
                        }
                        if (list == null) {
                            list = CollectionsKt__CollectionsKt.emptyList();
                        }
                        audioVolumeListener.onUserVoiceVolume(list, totalVolume);
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) userVolumes, totalVolume);
            }
        };
        this.statisticDataListener = new d() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.module.b
            @Override // com.tencent.mobileqq.qqlive.trtc.video.source.screen.d
            public final void a(StatisticData statisticData) {
                TRTCAudioRoomModule.statisticDataListener$lambda$0(TRTCAudioRoomModule.this, statisticData);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CopyOnWriteArrayList<VoiceRoomListener> getRoomListenerList() {
        return (CopyOnWriteArrayList) this.roomListenerList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CopyOnWriteArrayList<UserAudioAvailableListener> getUserAudioAvailableListenerList() {
        return (CopyOnWriteArrayList) this.userAudioAvailableListenerList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CopyOnWriteArrayList<AudioVolumeListener> getVolumeListeners() {
        return (CopyOnWriteArrayList) this.volumeListeners.getValue();
    }

    private final void initTRTC(Context appContext, IQQLiveSDK liveSDK, final TrtcSdkInitListener initListener) {
        if (this.isTRTCInit) {
            if (initListener != null) {
                initListener.onInitSuccess();
                return;
            }
            return;
        }
        EnterExitTRTCRoomLog.INSTANCE.beginInitTrtcSdk("appId:" + liveSDK.getConfigModule().getConfigData().getTrtcSDKAppId());
        this.tRTCProxy.w(appContext, liveSDK.getAppId(), new TRTCInitCallback() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.module.c
            @Override // com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback
            public final void onInitEvent(int i3, int i16) {
                TRTCAudioRoomModule.initTRTC$lambda$2(TRTCAudioRoomModule.this, initListener, i3, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTRTC$lambda$2(TRTCAudioRoomModule this$0, TrtcSdkInitListener trtcSdkInitListener, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(TAG, 1, "trtc init result:" + i3 + ", code:" + i16);
        if (i3 != 2) {
            if (i3 == 3) {
                this$0.onInitFailed(i3, i16);
                if (trtcSdkInitListener != null) {
                    trtcSdkInitListener.onInitFailed(i3, i16);
                }
                EnterExitTRTCRoomLog.INSTANCE.errorInitTrtcSdk("state:" + i3 + ",code:" + i16);
                return;
            }
            return;
        }
        this$0.onInitSuccess();
        if (trtcSdkInitListener != null) {
            trtcSdkInitListener.onInitSuccess();
        }
        EnterExitTRTCRoomLog.INSTANCE.endInitTrtcSdk("");
    }

    private final void initTRTCListener() {
        this.tRTCProxy.b(this.tRTCRoomListener);
        this.tRTCProxy.Y(this.tRTCRemoteListener);
        this.tRTCProxy.X(this.statisticDataListener);
    }

    private final void onInitFailed(int state, int code) {
        this.isTRTCInit = false;
    }

    private final void onInitSuccess() {
        this.isTRTCInit = true;
        initTRTCListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void statisticDataListener$lambda$0(TRTCAudioRoomModule this$0, StatisticData statisticData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.techReport.v(statisticData);
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void addAudioVolumeListener(@NotNull AudioVolumeListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            getVolumeListeners().add(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void addUserAudioAvailableListener(@NotNull UserAudioAvailableListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (getUserAudioAvailableListenerList().contains(listener)) {
            return;
        }
        getUserAudioAvailableListenerList().add(listener);
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void addVoiceRoomListener(@NotNull VoiceRoomListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (getRoomListenerList().contains(listener)) {
            return;
        }
        getRoomListenerList().add(listener);
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void enableMic(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, enable);
            return;
        }
        this.aegisLogger.i(TAG, 1, "enableMic enable:" + enable);
        if (enable) {
            this.tRTCProxy.b0();
        } else {
            this.tRTCProxy.i0();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.voiceroom.ITRTCAudioRoom
    public void enterRoom(@NotNull QQLiveRoomParams params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        if (!this.isTRTCInit) {
            EnterExitTRTCRoomLog.INSTANCE.errorEnterTRTCRoom("TRTC sdk not init");
        } else {
            this.tRTCProxy.F(true);
            this.tRTCProxy.l(params);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.voiceroom.ITRTCAudioRoom
    public void exitRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (!this.isTRTCInit) {
            EnterExitTRTCRoomLog.INSTANCE.errorExitTRTCRoom("TRTC sdk not init");
        } else {
            this.tRTCProxy.i0();
            this.tRTCProxy.m();
        }
    }

    public final void init(@NotNull Context appContext, @NotNull IQQLiveSDK liveSDK, @Nullable TrtcSdkInitListener initListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appContext, liveSDK, initListener);
            return;
        }
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(liveSDK, "liveSDK");
        initTRTC(appContext, liveSDK, initListener);
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public boolean isMicEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.tRTCProxy.A();
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void muteUserVoice(@NotNull String userId, boolean mute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, userId, Boolean.valueOf(mute));
            return;
        }
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.aegisLogger.i(TAG, 1, "muteUserVoice userId:" + userId + ",mute:" + mute);
        if (!this.isTRTCInit) {
            this.aegisLogger.e(TAG, 1, "muteUserVoice TRTC not init");
        } else {
            this.tRTCProxy.H(userId, mute);
        }
    }

    public final void notifyPreEnterRoomError(int errorCode, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) msg2);
            return;
        }
        Iterator<T> it = getRoomListenerList().iterator();
        while (it.hasNext()) {
            ((VoiceRoomListener) it.next()).onPreEnterRoom(errorCode, msg2);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void releaseTrtc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.tRTCProxy.K(this.tRTCRoomListener);
            getRoomListenerList().clear();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void removeAudioVolumeListener(@NotNull AudioVolumeListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            getVolumeListeners().remove(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void removeUserAudioAvailableListener(@NotNull UserAudioAvailableListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            getUserAudioAvailableListenerList().remove(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void removeVoiceRoomListener(@NotNull VoiceRoomListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            getRoomListenerList().remove(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void startSpeaking() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.aegisLogger.i(TAG, 1, "startSpeaking");
        if (!this.isTRTCInit) {
            this.aegisLogger.e(TAG, 1, "startSpeaking TRTC not init");
        } else {
            this.tRTCProxy.o0(0);
            this.tRTCProxy.b0();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void stopSpeaking() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.aegisLogger.i(TAG, 1, "stopSpeaking");
        if (!this.isTRTCInit) {
            this.aegisLogger.e(TAG, 1, "stopSpeaking TRTC not init");
        } else {
            this.tRTCProxy.o0(1);
            this.tRTCProxy.i0();
        }
    }
}

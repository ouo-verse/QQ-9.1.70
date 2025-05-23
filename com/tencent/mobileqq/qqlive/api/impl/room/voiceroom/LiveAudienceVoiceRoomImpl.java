package com.tencent.mobileqq.qqlive.api.impl.room.voiceroom;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.av.AudioVolumeListener;
import com.tencent.mobileqq.qqlive.api.av.UserAudioAvailableListener;
import com.tencent.mobileqq.qqlive.api.av.VoiceRoomListener;
import com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomEnterExitModule;
import com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom;
import com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom;
import com.tencent.mobileqq.qqlive.api.impl.room.common.AudioStreamPublisher;
import com.tencent.mobileqq.qqlive.api.impl.room.corelog.EnterExitRoomLog;
import com.tencent.mobileqq.qqlive.api.impl.room.corelog.EnterExitTRTCRoomLog;
import com.tencent.mobileqq.qqlive.api.impl.room.module.SdkLoginStateModule;
import com.tencent.mobileqq.qqlive.api.impl.room.module.TRTCAudioRoomModule;
import com.tencent.mobileqq.qqlive.api.impl.room.report.AudienceRoomTechReporter;
import com.tencent.mobileqq.qqlive.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.qqlive.api.room.EnterRoomReqConfig;
import com.tencent.mobileqq.qqlive.api.room.voiceroom.ILiveAudienceVoiceRoom;
import com.tencent.mobileqq.qqlive.api.room.voiceroom.VoiceAnchorInfo;
import com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataStreamInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataTrtcInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqlive.common.api.IAegisLogApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\"\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J \u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u001a\u0010*\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-H\u0016J*\u0010.\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020 2\u0006\u0010/\u001a\u00020-2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\"\u0010.\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020-2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J \u00100\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u00101\u001a\u00020\u00152\u0006\u0010!\u001a\u000202H\u0016J\b\u00103\u001a\u00020\u0015H\u0016J\n\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00106\u001a\u00020'H\u0002J\n\u00107\u001a\u0004\u0018\u000108H\u0016J\u0012\u00109\u001a\u00020\u00152\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020-H\u0016J\b\u0010=\u001a\u00020-H\u0016J\u0018\u0010>\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%2\u0006\u0010?\u001a\u00020-H\u0016J\b\u0010@\u001a\u00020\u0015H\u0016J\u0010\u0010A\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010B\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0019H\u0016J\u0010\u0010C\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001bH\u0016J\b\u0010D\u001a\u00020\u0015H\u0016J\b\u0010E\u001a\u00020\u0015H\u0016J\u0012\u0010F\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/room/voiceroom/LiveAudienceVoiceRoomImpl;", "Lcom/tencent/mobileqq/qqlive/api/impl/room/BaseAudienceRoom;", "Lcom/tencent/mobileqq/qqlive/api/room/voiceroom/ILiveAudienceVoiceRoom;", "context", "Landroid/content/Context;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/qqlive/api/room/AudienceRoomConfig;", "(Landroid/content/Context;Lcom/tencent/mobileqq/qqlive/api/room/AudienceRoomConfig;)V", "aegisLogger", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "appContext", "kotlin.jvm.PlatformType", "audioStreamPublisher", "Lcom/tencent/mobileqq/qqlive/api/impl/room/common/AudioStreamPublisher;", "sdkLoginStateModule", "Lcom/tencent/mobileqq/qqlive/api/impl/room/module/SdkLoginStateModule;", "tRTCAudioRoomModule", "Lcom/tencent/mobileqq/qqlive/api/impl/room/module/TRTCAudioRoomModule;", "voiceAnchorInfo", "Lcom/tencent/mobileqq/qqlive/api/room/voiceroom/VoiceAnchorInfo;", "addAudioVolumeListener", "", "listener", "Lcom/tencent/mobileqq/qqlive/api/av/AudioVolumeListener;", "addUserAudioAvailableListener", "Lcom/tencent/mobileqq/qqlive/api/av/UserAudioAvailableListener;", "addVoiceRoomListener", "Lcom/tencent/mobileqq/qqlive/api/av/VoiceRoomListener;", "destroy", "doEnterRoom", "roomInfo", "Lcom/tencent/mobileqq/qqlive/data/room/EnterRoomInfo;", "Lcom/tencent/mobileqq/qqlive/api/room/EnterRoomReqConfig;", "callback", "Lcom/tencent/mobileqq/qqlive/callback/room/audience/EnterAudienceRoomCallback;", "doEnterTrtcRoom", "userId", "", "roomId", "", "info", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorDataTrtcInfo;", "doWhenNotLogin", "enableMic", "enable", "", "enterRoom", "autoPlay", "enterTrtcRoom", "exitRoom", "Lcom/tencent/mobileqq/qqlive/callback/room/audience/ExitRoomCallback;", "exitTrtcRoom", "getAnchorInfo", "Lcom/tencent/mobileqq/qqlive/data/room/BaseAnchorInfo;", "getRoomId", "getRoomInfo", "Lcom/tencent/mobileqq/qqlive/data/room/BaseRoomInfo;", "init", "sdkImpl", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "isAnchorRoom", "isMicEnable", "muteUserVoice", "mute", "releaseTrtc", "removeAudioVolumeListener", "removeUserAudioAvailableListener", "removeVoiceRoomListener", "startSpeaking", "stopSpeaking", "updateVoiceAnchorInfo", "Companion", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class LiveAudienceVoiceRoomImpl extends BaseAudienceRoom implements ILiveAudienceVoiceRoom {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final Companion Companion;

    @Deprecated
    @NotNull
    private static final String TAG = "VoiceAudienceRoomImpl";

    @NotNull
    private final IAegisLogApi aegisLogger;
    private final Context appContext;

    @NotNull
    private final AudioStreamPublisher audioStreamPublisher;

    @NotNull
    private final SdkLoginStateModule sdkLoginStateModule;

    @NotNull
    private final TRTCAudioRoomModule tRTCAudioRoomModule;

    @Nullable
    private VoiceAnchorInfo voiceAnchorInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/room/voiceroom/LiveAudienceVoiceRoomImpl$Companion;", "", "()V", "TAG", "", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32978);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            Companion = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveAudienceVoiceRoomImpl(@NotNull Context context, @NotNull AudienceRoomConfig config) {
        super(config);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) config);
            return;
        }
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLogger = (IAegisLogApi) api;
        this.sdkLoginStateModule = new SdkLoginStateModule();
        this.tRTCAudioRoomModule = new TRTCAudioRoomModule();
        this.audioStreamPublisher = new AudioStreamPublisher();
        this.appContext = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doEnterRoom(final EnterRoomInfo roomInfo, EnterRoomReqConfig config, final EnterAudienceRoomCallback callback) {
        this.aegisLogger.i(TAG, 1, hashCode() + " doEnterRoom, roomid:" + roomInfo.getRoomId());
        this.enterRoomModule.enterRoom(roomInfo, config, this.liveSDK, AudienceRoomConfig.VideoFormat.RTMP, new EnterAudienceRoomCallback(roomInfo, callback) { // from class: com.tencent.mobileqq.qqlive.api.impl.room.voiceroom.LiveAudienceVoiceRoomImpl$doEnterRoom$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ EnterAudienceRoomCallback $callback;
            final /* synthetic */ EnterRoomInfo $roomInfo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$roomInfo = roomInfo;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, LiveAudienceVoiceRoomImpl.this, roomInfo, callback);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback
            public void onFailed(int code, @NotNull String msg2) {
                AudienceRoomTechReporter audienceRoomTechReporter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, code, (Object) msg2);
                    return;
                }
                Intrinsics.checkNotNullParameter(msg2, "msg");
                EnterExitRoomLog.INSTANCE.errorEnterRoom(this.$roomInfo.getRoomId() + " enterRoom Failed code is " + code + " :" + msg2);
                EnterAudienceRoomCallback enterAudienceRoomCallback = this.$callback;
                if (enterAudienceRoomCallback != null) {
                    enterAudienceRoomCallback.onFailed(code, msg2);
                }
                audienceRoomTechReporter = ((BaseAudienceRoom) LiveAudienceVoiceRoomImpl.this).techReporter;
                audienceRoomTechReporter.onFailed(code, msg2);
            }

            @Override // com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback
            public void onSuccess(@NotNull LiveInfo liveInfo) {
                boolean z16;
                AudienceRoomEnterExitModule audienceRoomEnterExitModule;
                IQQLiveSDK iQQLiveSDK;
                AudienceRoomTechReporter audienceRoomTechReporter;
                AudioStreamPublisher audioStreamPublisher;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) liveInfo);
                    return;
                }
                Intrinsics.checkNotNullParameter(liveInfo, "liveInfo");
                z16 = ((BaseLiveRoom) LiveAudienceVoiceRoomImpl.this).isExitRoom;
                if (!z16) {
                    LiveAudienceVoiceRoomImpl.this.onEnterRoom();
                    EnterExitRoomLog.INSTANCE.endEnteringRoom("enterRoomSuccess " + this.$roomInfo.getRoomId());
                    EnterAudienceRoomCallback enterAudienceRoomCallback = this.$callback;
                    if (enterAudienceRoomCallback != null) {
                        enterAudienceRoomCallback.onSuccess(liveInfo);
                    }
                    audienceRoomEnterExitModule = ((BaseAudienceRoom) LiveAudienceVoiceRoomImpl.this).enterRoomModule;
                    iQQLiveSDK = ((BaseLiveRoom) LiveAudienceVoiceRoomImpl.this).liveSDK;
                    audienceRoomEnterExitModule.recordCurRoom(iQQLiveSDK);
                    audienceRoomTechReporter = ((BaseAudienceRoom) LiveAudienceVoiceRoomImpl.this).techReporter;
                    audienceRoomTechReporter.onSuccess(liveInfo);
                    audioStreamPublisher = LiveAudienceVoiceRoomImpl.this.audioStreamPublisher;
                    audioStreamPublisher.setRoomInfo(LiveAudienceVoiceRoomImpl.this.getRoomInfo());
                    return;
                }
                EnterExitRoomLog.INSTANCE.endEnteringRoom("enterRoom success but exitRoom before");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doEnterTrtcRoom(final String userId, final long roomId, final QQLiveAnchorDataTrtcInfo info) {
        TRTCAudioRoomModule tRTCAudioRoomModule = this.tRTCAudioRoomModule;
        Context appContext = this.appContext;
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
        IQQLiveSDK liveSDK = this.liveSDK;
        Intrinsics.checkNotNullExpressionValue(liveSDK, "liveSDK");
        tRTCAudioRoomModule.init(appContext, liveSDK, new TRTCAudioRoomModule.TrtcSdkInitListener(userId, roomId, info, this) { // from class: com.tencent.mobileqq.qqlive.api.impl.room.voiceroom.LiveAudienceVoiceRoomImpl$doEnterTrtcRoom$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ QQLiveAnchorDataTrtcInfo $info;
            final /* synthetic */ long $roomId;
            final /* synthetic */ String $userId;
            final /* synthetic */ LiveAudienceVoiceRoomImpl this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$userId = userId;
                this.$roomId = roomId;
                this.$info = info;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, userId, Long.valueOf(roomId), info, this);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.api.impl.room.module.TRTCAudioRoomModule.TrtcSdkInitListener
            public void onInitFailed(int state, int code) {
                TRTCAudioRoomModule tRTCAudioRoomModule2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, Integer.valueOf(state), Integer.valueOf(code));
                    return;
                }
                int i3 = -2;
                if (code == -2) {
                    i3 = -3;
                }
                tRTCAudioRoomModule2 = this.this$0.tRTCAudioRoomModule;
                tRTCAudioRoomModule2.notifyPreEnterRoomError(i3, "trtc engine \u521d\u59cb\u5316\u5931\u8d25");
            }

            @Override // com.tencent.mobileqq.qqlive.api.impl.room.module.TRTCAudioRoomModule.TrtcSdkInitListener
            public void onInitSuccess() {
                String str;
                TRTCAudioRoomModule tRTCAudioRoomModule2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QQLiveRoomParams.Builder userSig = new QQLiveRoomParams.Builder().setUserId(this.$userId).setRoomId(this.$roomId).setRoleType(1).setScene(1).setUserSig(this.$info.sig);
                QQLiveAnchorDataStreamInfo qQLiveAnchorDataStreamInfo = this.$info.streamInfo;
                if (qQLiveAnchorDataStreamInfo != null) {
                    str = qQLiveAnchorDataStreamInfo.mainStreamId;
                } else {
                    str = null;
                }
                QQLiveRoomParams params = userSig.setStreamId(str).build();
                tRTCAudioRoomModule2 = this.this$0.tRTCAudioRoomModule;
                Intrinsics.checkNotNullExpressionValue(params, "params");
                tRTCAudioRoomModule2.enterRoom(params);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doWhenNotLogin(EnterRoomInfo roomInfo, EnterAudienceRoomCallback callback) {
        if (callback != null) {
            callback.onFailed(5105, "login failed");
        }
    }

    private final long getRoomId() {
        BaseRoomInfo roomInfo = getRoomInfo();
        if (roomInfo != null) {
            return roomInfo.getRoomId();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void addAudioVolumeListener(@NotNull AudioVolumeListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.tRTCAudioRoomModule.addAudioVolumeListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void addUserAudioAvailableListener(@NotNull UserAudioAvailableListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.tRTCAudioRoomModule.addUserAudioAvailableListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void addVoiceRoomListener(@NotNull VoiceRoomListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.tRTCAudioRoomModule.addVoiceRoomListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.destroy();
            this.audioStreamPublisher.destroy();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void enableMic(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, enable);
        } else {
            this.tRTCAudioRoomModule.enableMic(enable);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.qqlive.api.room.IAudienceRoom
    public void enterRoom(@NotNull EnterRoomInfo roomInfo, boolean autoPlay, @Nullable EnterAudienceRoomCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, roomInfo, Boolean.valueOf(autoPlay), callback);
        } else {
            Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
            enterRoom(roomInfo, new EnterRoomReqConfig(false), autoPlay, callback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.voiceroom.ILiveAudienceVoiceRoom
    public void enterTrtcRoom(@NotNull final String userId, final long roomId, @NotNull final QQLiveAnchorDataTrtcInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, userId, Long.valueOf(roomId), info);
            return;
        }
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(info, "info");
        this.audioStreamPublisher.setUserSig(info.sig);
        EnterExitTRTCRoomLog enterExitTRTCRoomLog = EnterExitTRTCRoomLog.INSTANCE;
        enterExitTRTCRoomLog.beginEnteringTRTCRoom("userId:" + userId + ",roomId:" + roomId);
        if (this.isDestroy) {
            enterExitTRTCRoomLog.errorEnterTRTCRoom("room has been destroyed");
        } else {
            enterExitTRTCRoomLog.beginCheckingLoginState("");
            this.sdkLoginStateModule.checkLoginState(this.liveSDK, new SdkLoginStateModule.CheckLoginStageCallback(userId, roomId, info) { // from class: com.tencent.mobileqq.qqlive.api.impl.room.voiceroom.LiveAudienceVoiceRoomImpl$enterTrtcRoom$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ QQLiveAnchorDataTrtcInfo $info;
                final /* synthetic */ long $roomId;
                final /* synthetic */ String $userId;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$userId = userId;
                    this.$roomId = roomId;
                    this.$info = info;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LiveAudienceVoiceRoomImpl.this, userId, Long.valueOf(roomId), info);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.api.impl.room.module.SdkLoginStateModule.CheckLoginStageCallback
                public void onCheckResult(boolean isLogin, @NotNull String errorMsg) {
                    TRTCAudioRoomModule tRTCAudioRoomModule;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(isLogin), errorMsg);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                    if (isLogin) {
                        EnterExitTRTCRoomLog.INSTANCE.endCheckingLoginState("is login");
                        LiveAudienceVoiceRoomImpl.this.doEnterTrtcRoom(this.$userId, this.$roomId, this.$info);
                    } else {
                        EnterExitTRTCRoomLog.INSTANCE.errorEnterTRTCRoom(errorMsg);
                        tRTCAudioRoomModule = LiveAudienceVoiceRoomImpl.this.tRTCAudioRoomModule;
                        tRTCAudioRoomModule.notifyPreEnterRoomError(-1, errorMsg);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoomBase
    public void exitRoom(@NotNull ExitRoomCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            super.exitRoom(callback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.voiceroom.ILiveAudienceVoiceRoom
    public void exitTrtcRoom() {
        LiveRoomInfo liveRoomInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        Long l3 = null;
        this.audioStreamPublisher.endPushStream(null);
        this.audioStreamPublisher.setUserSig(null);
        EnterExitTRTCRoomLog enterExitTRTCRoomLog = EnterExitTRTCRoomLog.INSTANCE;
        LiveInfo roomLiveInfo = getRoomLiveInfo();
        if (roomLiveInfo != null && (liveRoomInfo = roomLiveInfo.roomInfo) != null) {
            l3 = Long.valueOf(liveRoomInfo.roomId);
        }
        enterExitTRTCRoomLog.beginExitingTRTCRoom("roomId:" + l3);
        if (this.isDestroy) {
            enterExitTRTCRoomLog.errorExitTRTCRoom("room has been destroyed");
        } else {
            this.tRTCAudioRoomModule.exitRoom();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoomBase
    @Nullable
    public BaseAnchorInfo getAnchorInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BaseAnchorInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.isDestroy) {
            return null;
        }
        return this.enterRoomModule.getAnchorInfo();
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoomBase
    @Nullable
    public BaseRoomInfo getRoomInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BaseRoomInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.isDestroy) {
            return null;
        }
        return this.enterRoomModule.getRoomInfo();
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom, com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(@Nullable IQQLiveSDK sdkImpl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sdkImpl);
        } else {
            super.init(sdkImpl);
            this.audioStreamPublisher.setLiveSdk(sdkImpl);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.qqlive.api.room.ILiveRoom
    public boolean isAnchorRoom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public boolean isMicEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.tRTCAudioRoomModule.isMicEnable();
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void muteUserVoice(@NotNull String userId, boolean mute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, userId, Boolean.valueOf(mute));
            return;
        }
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (this.isDestroy) {
            return;
        }
        this.tRTCAudioRoomModule.muteUserVoice(userId, mute);
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void releaseTrtc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.tRTCAudioRoomModule.releaseTrtc();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void removeAudioVolumeListener(@NotNull AudioVolumeListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.tRTCAudioRoomModule.removeAudioVolumeListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void removeUserAudioAvailableListener(@NotNull UserAudioAvailableListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.tRTCAudioRoomModule.removeUserAudioAvailableListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void removeVoiceRoomListener(@NotNull VoiceRoomListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.tRTCAudioRoomModule.removeVoiceRoomListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void startSpeaking() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.isDestroy) {
            return;
        }
        this.tRTCAudioRoomModule.startSpeaking();
        VoiceAnchorInfo voiceAnchorInfo = this.voiceAnchorInfo;
        if (voiceAnchorInfo != null) {
            j3 = voiceAnchorInfo.anchorId;
        } else {
            j3 = 0;
        }
        this.aegisLogger.i(TAG, 1, "startSpeaking current voiceAnchorId:" + j3);
        this.audioStreamPublisher.startPushStream(j3, new AudioStreamPublisher.PushCallback() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.voiceroom.LiveAudienceVoiceRoomImpl$startSpeaking$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiveAudienceVoiceRoomImpl.this);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.api.impl.room.common.AudioStreamPublisher.PushCallback
            public void onFailed(@Nullable String msg2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) msg2);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.api.impl.room.common.AudioStreamPublisher.PushCallback
            public void onSuccess() {
                boolean z16;
                boolean z17;
                AudioStreamPublisher audioStreamPublisher;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    z16 = ((BaseLiveRoom) LiveAudienceVoiceRoomImpl.this).isDestroy;
                    if (!z16) {
                        z17 = ((BaseLiveRoom) LiveAudienceVoiceRoomImpl.this).isExitRoom;
                        if (!z17) {
                            audioStreamPublisher = LiveAudienceVoiceRoomImpl.this.audioStreamPublisher;
                            audioStreamPublisher.sendHeartbeat();
                            return;
                        }
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.api.av.IAudioAbility
    public void stopSpeaking() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.tRTCAudioRoomModule.stopSpeaking();
            this.audioStreamPublisher.endPushStream(new AudioStreamPublisher.PushCallback() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.voiceroom.LiveAudienceVoiceRoomImpl$stopSpeaking$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.api.impl.room.common.AudioStreamPublisher.PushCallback
                public void onFailed(@Nullable String msg2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) msg2);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.api.impl.room.common.AudioStreamPublisher.PushCallback
                public void onSuccess() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.voiceroom.ILiveAudienceVoiceRoom
    public void updateVoiceAnchorInfo(@Nullable VoiceAnchorInfo voiceAnchorInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) voiceAnchorInfo);
        } else {
            this.voiceAnchorInfo = voiceAnchorInfo;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.impl.room.BaseAudienceRoom, com.tencent.mobileqq.qqlive.api.room.IAudienceRoom
    public void enterRoom(@NotNull final EnterRoomInfo roomInfo, @NotNull final EnterRoomReqConfig config, boolean autoPlay, @Nullable final EnterAudienceRoomCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, roomInfo, config, Boolean.valueOf(autoPlay), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        Intrinsics.checkNotNullParameter(config, "config");
        EnterExitRoomLog enterExitRoomLog = EnterExitRoomLog.INSTANCE;
        enterExitRoomLog.beginEnteringRoom("roomId:" + roomInfo.getRoomId());
        if (this.isDestroy) {
            enterExitRoomLog.errorEnterRoom("room has been destroyed");
            if (callback != null) {
                callback.onFailed(5109, "room is destroy");
                return;
            }
            return;
        }
        this.isExitRoom = false;
        this.techReporter.onEnterRoomStart();
        enterExitRoomLog.beginCheckingLoginState("");
        this.sdkLoginStateModule.checkLoginState(this.liveSDK, new SdkLoginStateModule.CheckLoginStageCallback(roomInfo, config, callback) { // from class: com.tencent.mobileqq.qqlive.api.impl.room.voiceroom.LiveAudienceVoiceRoomImpl$enterRoom$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ EnterAudienceRoomCallback $callback;
            final /* synthetic */ EnterRoomReqConfig $config;
            final /* synthetic */ EnterRoomInfo $roomInfo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$roomInfo = roomInfo;
                this.$config = config;
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, LiveAudienceVoiceRoomImpl.this, roomInfo, config, callback);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.api.impl.room.module.SdkLoginStateModule.CheckLoginStageCallback
            public void onCheckResult(boolean isLogin, @NotNull String errorMsg) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(isLogin), errorMsg);
                    return;
                }
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                if (isLogin) {
                    EnterExitRoomLog.INSTANCE.endCheckingLoginState("is login");
                    LiveAudienceVoiceRoomImpl.this.doEnterRoom(this.$roomInfo, this.$config, this.$callback);
                } else {
                    EnterExitRoomLog.INSTANCE.errorEnterRoom("not login or login failed");
                    LiveAudienceVoiceRoomImpl.this.doWhenNotLogin(this.$roomInfo, this.$callback);
                }
            }
        });
    }
}

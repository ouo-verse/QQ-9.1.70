package com.tencent.mobileqq.qqlive.api.impl.room.common;

import android.os.Handler;
import android.text.TextUtils;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorThrowable;
import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.config.IQQLiveConfigModule;
import com.tencent.mobileqq.qqlive.api.impl.room.common.AudioStreamPublisher;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.sso.f;
import com.tencent.mobileqq.qqlive.sso.h;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqlive.common.api.IAegisLogApi;
import et3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lt3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pt3.i;
import pt3.j;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 12\u00020\u0001:\u000212B\u0007\u00a2\u0006\u0004\b/\u00100J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0012\u001a\u00020\nH\u0016J\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0016\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\nJ\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J*\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J,\u0010 \u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u0006H\u0016R\u0016\u0010!\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010#R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/room/common/AudioStreamPublisher;", "", "Lcom/tencent/mobileqq/qqlive/api/impl/room/common/AudioStreamPublisher$PushCallback;", "callback", "", "checkStatus", "", "getClientType", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "liveSDK", "", "setLiveSdk", "Lcom/tencent/mobileqq/qqlive/data/room/BaseRoomInfo;", "roomInfo", "setRoomInfo", "", PreloadTRTCPlayerParams.KEY_SIG, "setUserSig", "destroy", "", "voiceAnchorId", "startPushStream", "endPushStream", "sendHeartbeat", "stopHeartbeat", "clientType", "Llt3/b;", "createHeartbeatReq", "Lpt3/i;", "covertToStartNewReq", "programId", "Lpt3/a;", "covertToEndNewReq", "heartbeatIntervalInMs", "J", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "Lcom/tencent/mobileqq/qqlive/data/room/BaseRoomInfo;", "userSig", "Ljava/lang/String;", "isPublishing", "Z", "Landroid/os/Handler;", "heartBeatHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "heartbeatRunnable", "Ljava/lang/Runnable;", "<init>", "()V", "Companion", "PushCallback", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class AudioStreamPublisher {
    static IPatchRedirector $redirector_ = null;

    @Deprecated
    private static final int AV_TYPE_AUDIO = 1;

    @Deprecated
    private static final int CONTENT_TYPE_OD = 10001;

    @NotNull
    private static final Companion Companion;

    @Deprecated
    private static final int LIVE_TYPE_NORMAL_LIVE = 4;

    @Deprecated
    private static final int MAIN_ERR_CODE_END = 1001;

    @Deprecated
    private static final int MAIN_ERR_CODE_HEARTBEAT = 1002;

    @Deprecated
    private static final int MAIN_ERR_CODE_START = 1000;

    @Deprecated
    public static final int SDK_TYPE_TRTC = 3;

    @Deprecated
    @NotNull
    private static final String TAG = "AudioStreamPublisher";

    @NotNull
    private final Handler heartBeatHandler;
    private long heartbeatIntervalInMs;

    @NotNull
    private final Runnable heartbeatRunnable;
    private boolean isPublishing;

    @Nullable
    private IQQLiveSDK liveSDK;

    @Nullable
    private BaseRoomInfo roomInfo;

    @Nullable
    private String userSig;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/room/common/AudioStreamPublisher$Companion;", "", "()V", "AV_TYPE_AUDIO", "", "CONTENT_TYPE_OD", "LIVE_TYPE_NORMAL_LIVE", "MAIN_ERR_CODE_END", "MAIN_ERR_CODE_HEARTBEAT", "MAIN_ERR_CODE_START", "SDK_TYPE_TRTC", "TAG", "", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/room/common/AudioStreamPublisher$PushCallback;", "", "onFailed", "", "msg", "", "onSuccess", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public interface PushCallback {
        void onFailed(@Nullable String msg2);

        void onSuccess();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32643);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            Companion = new Companion(null);
        }
    }

    public AudioStreamPublisher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.heartbeatIntervalInMs = 1000L;
        this.userSig = "";
        this.heartBeatHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        this.heartbeatRunnable = new Runnable() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.common.a
            @Override // java.lang.Runnable
            public final void run() {
                AudioStreamPublisher.heartbeatRunnable$lambda$0(AudioStreamPublisher.this);
            }
        };
    }

    private final boolean checkStatus(PushCallback callback) {
        if (this.liveSDK == null) {
            c.a().e(TAG, 1, "live sdk is null");
            if (callback != null) {
                callback.onFailed("live sdk is null");
            }
            return false;
        }
        if (this.roomInfo == null) {
            c.a().e(TAG, 1, "roomInfo is null");
            if (callback != null) {
                callback.onFailed("roomInfo is null");
            }
            return false;
        }
        if (!TextUtils.isEmpty(this.userSig)) {
            return true;
        }
        c.a().e(TAG, 1, "userSig is null");
        if (callback != null) {
            callback.onFailed("userSig is null");
        }
        return false;
    }

    private final int getClientType() {
        IQQLiveConfigModule configModule;
        ConfigData configData;
        IQQLiveSDK iQQLiveSDK = this.liveSDK;
        if (iQQLiveSDK != null && (configModule = iQQLiveSDK.getConfigModule()) != null && (configData = configModule.getConfigData()) != null) {
            return configData.getLiveClientType();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void heartbeatRunnable$lambda$0(final AudioStreamPublisher this$0) {
        Long l3;
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IAegisLogApi a16 = c.a();
        BaseRoomInfo baseRoomInfo = this$0.roomInfo;
        com.tencent.mobileqq.qqlive.sso.c cVar = null;
        if (baseRoomInfo != null) {
            l3 = Long.valueOf(baseRoomInfo.getRoomId());
        } else {
            l3 = null;
        }
        a16.i(TAG, 1, "heartbeat->roomid:" + l3);
        if (!this$0.checkStatus(null)) {
            return;
        }
        BaseRoomInfo baseRoomInfo2 = this$0.roomInfo;
        Intrinsics.checkNotNull(baseRoomInfo2);
        b createHeartbeatReq = this$0.createHeartbeatReq(baseRoomInfo2, this$0.getClientType());
        IQQLiveSDK iQQLiveSDK = this$0.liveSDK;
        if (iQQLiveSDK != null) {
            obj = iQQLiveSDK.getExtModule("sso_module");
        } else {
            obj = null;
        }
        if (obj instanceof com.tencent.mobileqq.qqlive.sso.c) {
            cVar = (com.tencent.mobileqq.qqlive.sso.c) obj;
        }
        if (cVar == null) {
            c.a().e(TAG, 1, "heartbeat, get Sso module null");
        } else {
            cVar.f("trpc.qlive.media_hb4opensdk.MediaLogic", "SendHB", MessageNano.toByteArray(createHeartbeatReq), new f() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.common.AudioStreamPublisher$heartbeatRunnable$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AudioStreamPublisher.this);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.sso.f
                public void onReceive(int type, boolean isSuccess, @NotNull h data) {
                    lt3.c c16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), data);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(data, "data");
                    try {
                        com.tencent.mobileqq.qqlive.anchor.util.a.a(type, isSuccess, data);
                        c16 = lt3.c.c(data.e());
                    } catch (InvalidProtocolBufferNanoException e16) {
                        c.a().e("AudioStreamPublisher", 1, "parse pb error:" + e16.getMessage());
                    } catch (QQLiveAnchorThrowable e17) {
                        QQLiveErrorMsg covert = QQLiveAnchorThrowable.covert(1002, e17);
                        c.a().e("AudioStreamPublisher", 1, "check rsp error:" + covert);
                    }
                    if (c16.f415549a != 0) {
                        c.a().e("AudioStreamPublisher", 1, "heartbeat result error: " + c16.f415549a);
                        AudioStreamPublisher.this.sendHeartbeat();
                        return;
                    }
                    int i3 = c16.f415550b;
                    if (i3 > 0) {
                        AudioStreamPublisher.this.heartbeatIntervalInMs = i3 * 1000;
                    }
                    AudioStreamPublisher.this.sendHeartbeat();
                }
            });
        }
    }

    @NotNull
    public pt3.a covertToEndNewReq(@NotNull BaseRoomInfo roomInfo, @Nullable String sig, @Nullable String programId, int clientType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (pt3.a) iPatchRedirector.redirect((short) 12, this, roomInfo, sig, programId, Integer.valueOf(clientType));
        }
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        pt3.a aVar = new pt3.a();
        aVar.f427106a = roomInfo.getRoomId();
        aVar.f427107b = clientType;
        aVar.f427108c = 4;
        aVar.f427109d = com.tencent.mobileqq.qqlive.anchor.util.a.J(sig);
        aVar.f427110e = 3;
        pt3.c cVar = new pt3.c();
        cVar.f427121b = DeviceInfoMonitor.getModel();
        cVar.f427122c = AppSetting.f99551k;
        pt3.h hVar = new pt3.h();
        hVar.f427147b = 1280;
        hVar.f427146a = 720;
        cVar.f427123d = hVar;
        aVar.f427111f = cVar;
        aVar.f427113h = 0;
        aVar.f427114i = 1;
        aVar.f427107b = 10001;
        aVar.f427115j = 10001;
        aVar.f427116k = com.tencent.mobileqq.qqlive.anchor.util.a.J(programId);
        return aVar;
    }

    @NotNull
    public i covertToStartNewReq(long voiceAnchorId, @NotNull BaseRoomInfo roomInfo, @Nullable String sig, int clientType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (i) iPatchRedirector.redirect((short) 11, this, Long.valueOf(voiceAnchorId), roomInfo, sig, Integer.valueOf(clientType));
        }
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        i iVar = new i();
        iVar.f427148a = roomInfo.getRoomId();
        iVar.f427149b = clientType;
        iVar.f427150c = 4;
        iVar.f427151d = com.tencent.mobileqq.qqlive.anchor.util.a.J(sig);
        iVar.f427152e = 3;
        pt3.c cVar = new pt3.c();
        cVar.f427121b = DeviceInfoMonitor.getModel();
        cVar.f427122c = AppSetting.f99551k;
        pt3.h hVar = new pt3.h();
        hVar.f427147b = 1280;
        hVar.f427146a = 720;
        cVar.f427123d = hVar;
        cVar.f427124e = 10001;
        iVar.f427153f = cVar;
        iVar.f427155h = 0;
        iVar.f427156i = 1;
        iVar.f427157j = 10001;
        iVar.f427158k = com.tencent.mobileqq.qqlive.anchor.util.a.J(roomInfo.getProgramId());
        iVar.f427154g = voiceAnchorId;
        return iVar;
    }

    @NotNull
    public b createHeartbeatReq(@NotNull BaseRoomInfo roomInfo, int clientType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (b) iPatchRedirector.redirect((short) 10, (Object) this, (Object) roomInfo, clientType);
        }
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        b bVar = new b();
        bVar.f415540a = clientType;
        bVar.f415543d = (int) roomInfo.getRoomId();
        bVar.f415544e = 3;
        bVar.f415541b = 4;
        return bVar;
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.liveSDK = null;
        this.roomInfo = null;
        this.userSig = null;
        stopHeartbeat();
    }

    public final void endPushStream(@Nullable final PushCallback callback) {
        Long l3;
        IQQLiveModule iQQLiveModule;
        com.tencent.mobileqq.qqlive.sso.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) callback);
            return;
        }
        if (!this.isPublishing) {
            return;
        }
        IAegisLogApi a16 = c.a();
        BaseRoomInfo baseRoomInfo = this.roomInfo;
        String str = null;
        if (baseRoomInfo != null) {
            l3 = Long.valueOf(baseRoomInfo.getRoomId());
        } else {
            l3 = null;
        }
        a16.i(TAG, 1, "endPushStream->roomid:" + l3);
        if (!checkStatus(callback)) {
            return;
        }
        IQQLiveSDK iQQLiveSDK = this.liveSDK;
        if (iQQLiveSDK != null) {
            iQQLiveModule = iQQLiveSDK.getExtModule("sso_module");
        } else {
            iQQLiveModule = null;
        }
        if (iQQLiveModule instanceof com.tencent.mobileqq.qqlive.sso.c) {
            cVar = (com.tencent.mobileqq.qqlive.sso.c) iQQLiveModule;
        } else {
            cVar = null;
        }
        if (cVar == null) {
            c.a().e(TAG, 1, "ssoModule is null");
            if (callback != null) {
                callback.onFailed("ssoModule is null");
                return;
            }
            return;
        }
        BaseRoomInfo baseRoomInfo2 = this.roomInfo;
        Intrinsics.checkNotNull(baseRoomInfo2);
        String str2 = this.userSig;
        BaseRoomInfo baseRoomInfo3 = this.roomInfo;
        if (baseRoomInfo3 != null) {
            str = baseRoomInfo3.getProgramId();
        }
        pt3.a covertToEndNewReq = covertToEndNewReq(baseRoomInfo2, str2, str, getClientType());
        this.isPublishing = false;
        cVar.f("trpc.qlive.media_logic4opensdk.MediaLogic", "EndNew", MessageNano.toByteArray(covertToEndNewReq), new f() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.common.AudioStreamPublisher$endPushStream$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AudioStreamPublisher.PushCallback.this);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.sso.f
            public void onReceive(int type, boolean isSuccess, @NotNull h data) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), data);
                    return;
                }
                Intrinsics.checkNotNullParameter(data, "data");
                try {
                    com.tencent.mobileqq.qqlive.anchor.util.a.a(type, isSuccess, data);
                    int i3 = pt3.b.c(data.e()).f427119a;
                    if (i3 != 0) {
                        AudioStreamPublisher.PushCallback pushCallback = AudioStreamPublisher.PushCallback.this;
                        if (pushCallback != null) {
                            pushCallback.onFailed("end,result is " + i3);
                        }
                    } else {
                        AudioStreamPublisher.PushCallback pushCallback2 = AudioStreamPublisher.PushCallback.this;
                        if (pushCallback2 != null) {
                            pushCallback2.onSuccess();
                        }
                    }
                } catch (InvalidProtocolBufferNanoException e16) {
                    c.a().e("AudioStreamPublisher", 1, "parse pb error:" + e16.getMessage());
                    AudioStreamPublisher.PushCallback pushCallback3 = AudioStreamPublisher.PushCallback.this;
                    if (pushCallback3 != null) {
                        pushCallback3.onFailed(e16.getMessage());
                    }
                } catch (QQLiveAnchorThrowable e17) {
                    QQLiveErrorMsg covert = QQLiveAnchorThrowable.covert(1001, e17);
                    c.a().e("AudioStreamPublisher", 1, "check rsp error:" + covert);
                    AudioStreamPublisher.PushCallback pushCallback4 = AudioStreamPublisher.PushCallback.this;
                    if (pushCallback4 != null) {
                        pushCallback4.onFailed(covert.toString());
                    }
                }
            }
        });
        stopHeartbeat();
    }

    public final void sendHeartbeat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.heartBeatHandler.postDelayed(this.heartbeatRunnable, this.heartbeatIntervalInMs);
        }
    }

    public final void setLiveSdk(@Nullable IQQLiveSDK liveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) liveSDK);
        } else {
            this.liveSDK = liveSDK;
        }
    }

    public final void setRoomInfo(@Nullable BaseRoomInfo roomInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) roomInfo);
        } else {
            this.roomInfo = roomInfo;
        }
    }

    public final void setUserSig(@Nullable String sig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) sig);
        } else {
            this.userSig = sig;
        }
    }

    public final void startPushStream(long voiceAnchorId, @NotNull final PushCallback callback) {
        Long l3;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(voiceAnchorId), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        IAegisLogApi a16 = c.a();
        BaseRoomInfo baseRoomInfo = this.roomInfo;
        com.tencent.mobileqq.qqlive.sso.c cVar = null;
        if (baseRoomInfo != null) {
            l3 = Long.valueOf(baseRoomInfo.getRoomId());
        } else {
            l3 = null;
        }
        a16.i(TAG, 1, "startPushStream->roomid:" + l3);
        if (!checkStatus(callback)) {
            return;
        }
        BaseRoomInfo baseRoomInfo2 = this.roomInfo;
        Intrinsics.checkNotNull(baseRoomInfo2);
        i covertToStartNewReq = covertToStartNewReq(voiceAnchorId, baseRoomInfo2, this.userSig, getClientType());
        IQQLiveSDK iQQLiveSDK = this.liveSDK;
        if (iQQLiveSDK != null) {
            obj = iQQLiveSDK.getExtModule("sso_module");
        } else {
            obj = null;
        }
        if (obj instanceof com.tencent.mobileqq.qqlive.sso.c) {
            cVar = (com.tencent.mobileqq.qqlive.sso.c) obj;
        }
        if (cVar == null) {
            c.a().e(TAG, 1, "start, get Sso module null");
        } else {
            this.isPublishing = true;
            cVar.f("trpc.qlive.media_logic4opensdk.MediaLogic", "StartNew", MessageNano.toByteArray(covertToStartNewReq), new f() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.common.AudioStreamPublisher$startPushStream$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AudioStreamPublisher.PushCallback.this);
                    }
                }

                @Override // com.tencent.mobileqq.qqlive.sso.f
                public void onReceive(int type, boolean isSuccess, @NotNull h data) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), data);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(data, "data");
                    c.a().i("AudioStreamPublisher", 1, "push stream recieve, type:" + type + ", success:" + isSuccess);
                    try {
                        com.tencent.mobileqq.qqlive.anchor.util.a.a(type, isSuccess, data);
                        int i3 = j.c(data.e()).f427161a;
                        if (i3 != 0) {
                            AudioStreamPublisher.PushCallback.this.onFailed("start,result is " + i3);
                        } else {
                            AudioStreamPublisher.PushCallback.this.onSuccess();
                        }
                    } catch (InvalidProtocolBufferNanoException e16) {
                        c.a().e("AudioStreamPublisher", 1, "parse pb error:" + e16.getMessage());
                        AudioStreamPublisher.PushCallback.this.onFailed(e16.getMessage());
                    } catch (QQLiveAnchorThrowable e17) {
                        QQLiveErrorMsg covert = QQLiveAnchorThrowable.covert(1000, e17);
                        c.a().e("AudioStreamPublisher", 1, "check rsp error:" + covert);
                        AudioStreamPublisher.PushCallback.this.onFailed(covert.toString());
                    }
                }
            });
        }
    }

    public final void stopHeartbeat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.heartBeatHandler.removeCallbacksAndMessages(null);
        }
    }
}

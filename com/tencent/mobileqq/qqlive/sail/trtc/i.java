package com.tencent.mobileqq.qqlive.sail.trtc;

import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnConnectOtherRoomEvent;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnDisconnectOtherRoomEvent;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnErrorEvent;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnExitRoomEvent;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnFirstVideoFrameEvent;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnNetworkQualityEvent;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnRemoteUserEnterRoom;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnRemoteUserLeaveRoom;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnScreenCapturePausedEvent;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnScreenCaptureStartedEvent;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnScreenCaptureStoppedEvent;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnStatisticsEvent;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnUserVideoAvailableEvent;
import com.tencent.mobileqq.qqlive.sail.trtc.event.OnUserVoiceVolume;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u0000 62\u00020\u0001:\u0001.B\u000f\u0012\u0006\u00100\u001a\u00020\r\u00a2\u0006\u0004\b4\u00105J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\u0007\u001a\u00020\u0005J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J$\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0017\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\"\u0010\u001c\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001aH\u0016J \u0010 \u001a\u00020\u00052\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001a2\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0012\u0010#\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010'\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\r2\u0006\u0010&\u001a\u00020%H\u0016J$\u0010(\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010)\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J*\u0010-\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\r2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nH\u0016R\u0014\u00100\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/i;", "Lcom/tencent/trtc/TRTCCloudListener;", "Lkotlinx/coroutines/CancellableContinuation;", "", "cont", "", "M", "L", "errCode", "onEnterRoom", "", "reason", "onExitRoom", "", "errMsg", "Landroid/os/Bundle;", "extraInfo", "onError", "onScreenCaptureStarted", "onScreenCapturePaused", "onScreenCaptureStopped", "remoteUserId", "onRemoteUserEnterRoom", "onRemoteUserLeaveRoom", "Lcom/tencent/trtc/TRTCCloudDef$TRTCQuality;", "localQuality", "Ljava/util/ArrayList;", "remoteQuality", "onNetworkQuality", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVolumeInfo;", "userVolumes", "totalVolume", "onUserVoiceVolume", "Lcom/tencent/trtc/TRTCStatistics;", "statistics", "onStatistics", "userId", "", "available", "onUserVideoAvailable", "onConnectOtherRoom", "onDisConnectOtherRoom", "streamType", "width", "height", "onFirstVideoFrame", "a", "Ljava/lang/String;", "appId", "b", "Lkotlinx/coroutines/CancellableContinuation;", "enterRoomCont", "<init>", "(Ljava/lang/String;)V", "c", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class i extends TRTCCloudListener {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CancellableContinuation<? super Long> enterRoomCont;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/i$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.trtc.i$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47888);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public i(@NotNull String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appId);
        } else {
            this.appId = appId;
        }
    }

    public final void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        CancellableContinuation<? super Long> cancellableContinuation = this.enterRoomCont;
        if (cancellableContinuation != null) {
            CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, null, 1, null);
        }
        this.enterRoomCont = null;
    }

    public final void M(@NotNull CancellableContinuation<? super Long> cont) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cont);
        } else {
            Intrinsics.checkNotNullParameter(cont, "cont");
            this.enterRoomCont = cont;
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onConnectOtherRoom(@Nullable String userId, int errCode, @Nullable String errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, userId, Integer.valueOf(errCode), errMsg);
            return;
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String str = this.appId;
        if (userId == null) {
            userId = "";
        }
        if (errMsg == null) {
            errMsg = "";
        }
        simpleEventBus.dispatchEvent(new OnConnectOtherRoomEvent(str, userId, errCode, errMsg));
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onDisConnectOtherRoom(int errCode, @Nullable String errMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, errCode, (Object) errMsg);
            return;
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String str = this.appId;
        if (errMsg == null) {
            errMsg = "";
        }
        simpleEventBus.dispatchEvent(new OnDisconnectOtherRoomEvent(str, errCode, errMsg));
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onEnterRoom(long errCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, errCode);
            return;
        }
        AegisLogger.INSTANCE.i("Open_Live|TRTC|TrtcListenersBridgeImpl", "onEnterRoom", "errCode=" + errCode + ", cont=" + this.enterRoomCont);
        CancellableContinuation<? super Long> cancellableContinuation = this.enterRoomCont;
        if (cancellableContinuation != null && cancellableContinuation.isActive()) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(Long.valueOf(errCode)));
        }
        this.enterRoomCont = null;
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onError(int errCode, @Nullable String errMsg, @Nullable Bundle extraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(errCode), errMsg, extraInfo);
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new OnErrorEvent(this.appId, errCode, errMsg, extraInfo));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onExitRoom(int reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, reason);
            return;
        }
        AegisLogger.INSTANCE.i("Open_Live|TRTC|TrtcListenersBridgeImpl", "onExitRoom", "reason=" + reason);
        SimpleEventBus.getInstance().dispatchEvent(new OnExitRoomEvent(this.appId, reason));
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onFirstVideoFrame(@Nullable String userId, int streamType, int width, int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, userId, Integer.valueOf(streamType), Integer.valueOf(width), Integer.valueOf(height));
            return;
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String str = this.appId;
        if (userId == null) {
            userId = "";
        }
        simpleEventBus.dispatchEvent(new OnFirstVideoFrameEvent(str, userId, streamType, width, height));
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onNetworkQuality(@Nullable TRTCCloudDef.TRTCQuality localQuality, @Nullable ArrayList<TRTCCloudDef.TRTCQuality> remoteQuality) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) localQuality, (Object) remoteQuality);
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new OnNetworkQualityEvent(this.appId, localQuality, remoteQuality));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteUserEnterRoom(@Nullable String remoteUserId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) remoteUserId);
            return;
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String str = this.appId;
        if (remoteUserId == null) {
            remoteUserId = "";
        }
        simpleEventBus.dispatchEvent(new OnRemoteUserEnterRoom(str, remoteUserId));
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onRemoteUserLeaveRoom(@Nullable String remoteUserId, int reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) remoteUserId, reason);
            return;
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String str = this.appId;
        if (remoteUserId == null) {
            remoteUserId = "";
        }
        simpleEventBus.dispatchEvent(new OnRemoteUserLeaveRoom(str, remoteUserId, reason));
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onScreenCapturePaused() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new OnScreenCapturePausedEvent(this.appId));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onScreenCaptureStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new OnScreenCaptureStartedEvent(this.appId));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onScreenCaptureStopped(int reason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, reason);
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new OnScreenCaptureStoppedEvent(this.appId, reason));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onStatistics(@Nullable TRTCStatistics statistics) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) statistics);
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new OnStatisticsEvent(this.appId, statistics));
        }
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVideoAvailable(@Nullable String userId, boolean available) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, userId, Boolean.valueOf(available));
            return;
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String str = this.appId;
        if (userId == null) {
            userId = "";
        }
        simpleEventBus.dispatchEvent(new OnUserVideoAvailableEvent(str, userId, available));
    }

    @Override // com.tencent.trtc.TRTCCloudListener
    public void onUserVoiceVolume(@Nullable ArrayList<TRTCCloudDef.TRTCVolumeInfo> userVolumes, int totalVolume) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) userVolumes, totalVolume);
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new OnUserVoiceVolume(this.appId, userVolumes, totalVolume));
        }
    }
}

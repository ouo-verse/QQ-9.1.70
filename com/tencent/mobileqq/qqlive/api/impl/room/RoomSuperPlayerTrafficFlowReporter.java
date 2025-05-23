package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.monitor.IResourceProvider;
import com.tencent.mobileqq.qqlive.api.monitor.ISuperPlayerTrafficFlowReporter;
import com.tencent.qqlive.common.monitor.i;
import com.tencent.qqperf.reporter.flow.b;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.player.MediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B%\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0014J\b\u0010\u0011\u001a\u00020\u0006H\u0014J\b\u0010\u0012\u001a\u00020\u0006H\u0014J\b\u0010\u0013\u001a\u00020\u0006H\u0014J\b\u0010\u0014\u001a\u00020\u0006H\u0014J\b\u0010\u0015\u001a\u00020\u0006H\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u00038TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/room/RoomSuperPlayerTrafficFlowReporter;", "Lcom/tencent/qqlive/common/monitor/i;", "Lcom/tencent/mobileqq/qqlive/api/monitor/ISuperPlayerTrafficFlowReporter;", "", "scene", "entrancePath", "", "report", "Lcom/tencent/qqperf/reporter/flow/b$a;", "createReportParamsBuilder", "updateMediaSize", "resetMediaSize", "", "getMediaSize", "onPlayerFirstFrameCome", "onPlayerPause", "onNetWifi2Mobile", "onNetNone2Mobile", "onNetMobile2Wifi", "onNetMobile2None", "onProcess2Background", "unInit", "Lmqq/util/WeakReference;", "Lcom/tencent/superplayer/api/ISuperPlayer;", "superPlayer", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/qqlive/api/monitor/IResourceProvider;", "resourceProvider", "Lcom/tencent/mobileqq/qqlive/api/monitor/IResourceProvider;", "mediaSizeInByte", "J", AppConstants.Key.KEY_QZONE_VIDEO_URL, "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "<init>", "(Ljava/lang/String;Lmqq/util/WeakReference;Lcom/tencent/mobileqq/qqlive/api/monitor/IResourceProvider;)V", "Companion", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class RoomSuperPlayerTrafficFlowReporter extends i implements ISuperPlayerTrafficFlowReporter {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final Companion Companion;

    @Deprecated
    @NotNull
    private static final String ENTRANCE_PLAYER_PAUSE = "entrance_player_pause";
    private long mediaSizeInByte;

    @NotNull
    private final IResourceProvider resourceProvider;

    @NotNull
    private final WeakReference<ISuperPlayer> superPlayer;

    @NotNull
    private String videoUrl;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/room/RoomSuperPlayerTrafficFlowReporter$Companion;", "", "()V", "ENTRANCE_PLAYER_PAUSE", "", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31894);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            Companion = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomSuperPlayerTrafficFlowReporter(@NotNull String scene, @NotNull WeakReference<ISuperPlayer> superPlayer, @NotNull IResourceProvider resourceProvider) {
        super(scene);
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(superPlayer, "superPlayer");
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, scene, superPlayer, resourceProvider);
            return;
        }
        this.superPlayer = superPlayer;
        this.resourceProvider = resourceProvider;
        this.mediaSizeInByte = -1L;
        this.videoUrl = "";
    }

    private final b.a createReportParamsBuilder() {
        b.a f16 = new b.a().b(6).g(1).k(this.resourceProvider.getUrl()).f(Foreground.isCurrentProcessForeground() ? 1 : 0);
        Intrinsics.checkNotNullExpressionValue(f16, "Builder()\n              \u2026sForeground(isForeground)");
        return f16;
    }

    private final long getMediaSize() {
        MediaInfo mediaInfo;
        ISuperPlayer iSuperPlayer = this.superPlayer.get();
        if (iSuperPlayer != null) {
            mediaInfo = iSuperPlayer.getMediaInfo();
        } else {
            mediaInfo = null;
        }
        long j3 = 0;
        if (mediaInfo == null) {
            return 0L;
        }
        ISuperPlayer iSuperPlayer2 = this.superPlayer.get();
        if (iSuperPlayer2 != null) {
            j3 = iSuperPlayer2.getPlayableDurationMs();
        }
        return (j3 / 1000) * ((mediaInfo.getVideoBitRate() + mediaInfo.getVideoBitRate()) / 8);
    }

    private final void report(String scene, String entrancePath) {
        if (this.mediaSizeInByte == -1) {
            getLogger().w(getTAG(), "illegal state,video size not init");
            return;
        }
        long mediaSize = getMediaSize() - this.mediaSizeInByte;
        getLogger().i(getTAG(), "report -> lastDownloadedVideoSizeInByte:" + this.mediaSizeInByte + ",downloadSizeInByte:" + mediaSize);
        if (mediaSize <= 0) {
            getLogger().i(getTAG(), "no need report");
            return;
        }
        com.tencent.qqperf.reporter.flow.b reportParams = createReportParamsBuilder().c(scene).d(entrancePath).e(String.valueOf(byte2KByte(mediaSize))).a();
        Intrinsics.checkNotNullExpressionValue(reportParams, "reportParams");
        report(reportParams);
    }

    private final void resetMediaSize() {
        this.mediaSizeInByte = -1L;
    }

    private final void updateMediaSize() {
        this.mediaSizeInByte = getMediaSize();
        getLogger().i(getTAG(), "update media size:" + this.mediaSizeInByte);
    }

    @Override // com.tencent.qqlive.common.monitor.i
    @NotNull
    protected String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "SuperPlayerTrafficFlowReporter@" + hashCode();
    }

    @Override // com.tencent.qqlive.common.monitor.i
    protected void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            report(getScene(), "entrance_net_change_mobile_2_none");
            resetMediaSize();
        }
    }

    @Override // com.tencent.qqlive.common.monitor.i
    protected void onNetMobile2Wifi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            report(getScene(), "entrance_net_change_mobile_2_wifi");
            resetMediaSize();
        }
    }

    @Override // com.tencent.qqlive.common.monitor.i
    protected void onNetNone2Mobile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            updateMediaSize();
        }
    }

    @Override // com.tencent.qqlive.common.monitor.i
    protected void onNetWifi2Mobile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            updateMediaSize();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.monitor.ISuperPlayerTrafficFlowReporter
    public void onPlayerFirstFrameCome() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (isMobileNetwork()) {
            getLogger().i(getTAG(), "onPlayerFirstFrameCome->mobile conn");
            updateMediaSize();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.monitor.ISuperPlayerTrafficFlowReporter
    public void onPlayerPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (isMobileNetwork()) {
            getLogger().i(getTAG(), "onPlayerPause->mobile conn");
            report(getScene(), ENTRANCE_PLAYER_PAUSE);
            updateMediaSize();
        }
    }

    @Override // com.tencent.qqlive.common.monitor.i
    protected void onProcess2Background() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        boolean isMobileNetwork = isMobileNetwork();
        getLogger().i(getTAG(), "onProcess2Background->isMobileNet:" + isMobileNetwork + " ");
        if (isMobileNetwork) {
            report(getScene(), "entrance_process_change_foreground_2_background");
            updateMediaSize();
        }
    }

    @Override // com.tencent.qqlive.common.monitor.i, com.tencent.mobileqq.qqlive.api.monitor.ISuperPlayerTrafficFlowReporter
    public void unInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.unInit();
            resetMediaSize();
        }
    }
}

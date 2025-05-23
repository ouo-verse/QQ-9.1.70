package com.tencent.mobileqq.gamecenter.video.interceptor;

import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor;
import com.tencent.mobileqq.gamecenter.api.IGameCenterVideoReportApi;
import com.tencent.mobileqq.gamecenter.data.p;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.report.ISPReportProvider;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 B2\u00020\u0001:\u0001\u0006B\t\b\u0016\u00a2\u0006\u0004\b=\u0010>B\u001b\b\u0016\u0012\u0006\u0010?\u001a\u00020\n\u0012\b\u0010@\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b=\u0010AJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J4\u0010\u0018\u001a\u00020\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u001d\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u001e\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\nH\u0016J*\u0010'\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010%H\u0016R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R2\u00105\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000201j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`28\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010;\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/video/interceptor/GameCenterPerfReportInterceptor;", "Lcom/tencent/biz/richframework/video/rfw/player/playinterceptor/RFWPlayerBaseInterceptor;", "", "arg1", "", "c", "a", "onPlayerParamsReset", "onPlayerInfoBufferingStart", "onPlayerInfoBufferingEnd", "", "progress", "max", "onStopTrackingTouch", "Lcom/tencent/superplayer/api/ISuperPlayer;", "iSuperPlayer", "onSeekComplete", "mpImpl", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "extraInfo", "", "onError", "onCompletion", "Lcom/tencent/superplayer/api/SuperPlayerOption;", "superPlayerOption", "superPlayer", "beforeOpenMedia", "afterOpenMedia", "onVideoPrepare", "onPlayerInfoCurrentLoopEnd", "releaseSource", "onRelease", "what", "arg2", "", "extra", "onInfo", "Lcom/tencent/mobileqq/gamecenter/data/p;", "d", "Lcom/tencent/mobileqq/gamecenter/data/p;", "baseReportData", "e", "Z", "hasReportComplete", "f", "isSeeking", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", h.F, "Ljava/util/LinkedHashMap;", "dropFrameRecordMap", "i", "Lcom/tencent/superplayer/api/ISuperPlayer;", "player", "Lcom/tencent/mobileqq/gamecenter/api/IGameCenterVideoReportApi;", "b", "()Lcom/tencent/mobileqq/gamecenter/api/IGameCenterVideoReportApi;", "reportApi", "<init>", "()V", "source", "url", "(ILjava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GameCenterPerfReportInterceptor extends RFWPlayerBaseInterceptor {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private p baseReportData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasReportComplete;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isSeeking;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinkedHashMap<Long, Long> dropFrameRecordMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ISuperPlayer player;

    public GameCenterPerfReportInterceptor() {
        this.dropFrameRecordMap = new LinkedHashMap<>();
        this.baseReportData = new p(p.INSTANCE.b(), null, 2, null);
    }

    private final void a() {
        if (!this.hasReportComplete) {
            this.hasReportComplete = true;
            b().reportVideoComplete(this.baseReportData);
        }
    }

    private final IGameCenterVideoReportApi b() {
        QRouteApi api = QRoute.api(IGameCenterVideoReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGameCenterVideoReportApi::class.java)");
        return (IGameCenterVideoReportApi) api;
    }

    private final void c(long arg1) {
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null) {
            long j3 = this.baseReportData.videoFps;
            if (j3 != 0) {
                long currentPositionMs = iSuperPlayer.getCurrentPositionMs() / 1000;
                float f16 = (float) j3;
                long j16 = f16 - (((((float) arg1) * 1.0f) / 100) * f16);
                this.dropFrameRecordMap.put(Long.valueOf(currentPositionMs), Long.valueOf(j16));
                QLog.i("GameCenterPerfReportInterceptor", 2, "[onInfo] curSecond:" + currentPositionMs + ",curFrame:" + j16);
                return;
            }
            QLog.e("GameCenterPerfReportInterceptor", 1, "[onInfo] videoFps is 0");
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void afterOpenMedia(@Nullable SuperPlayerOption superPlayerOption, @Nullable ISuperPlayer superPlayer) {
        this.player = superPlayer;
        b().reportPlayStart(this.baseReportData);
        QLog.i("GameCenterPerfReportInterceptor", 2, "[afterOpenMedia]");
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void beforeOpenMedia(@Nullable SuperPlayerOption superPlayerOption, @Nullable ISuperPlayer superPlayer) {
        String realPlayUrl;
        boolean z16;
        QLog.i("GameCenterPerfReportInterceptor", 2, "[beforeOpenMedia]");
        this.baseReportData.lastStartPrepareTime = System.currentTimeMillis();
        RFWPlayerOptions rFWPlayerOptions = this.mPlayerOptions;
        if (rFWPlayerOptions != null && (realPlayUrl = rFWPlayerOptions.getRealPlayUrl()) != null) {
            if (realPlayUrl.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.baseReportData.url = realPlayUrl;
            }
        }
        if (((IGameCenterVideoReportApi) QRoute.api(IGameCenterVideoReportApi.class)).checkIfDetectDropFrame(this.baseReportData.url) && superPlayerOption != null) {
            superPlayerOption.dropFrameDetectTimeMs = 1000L;
            superPlayerOption.enableDropFrameDetect = true;
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onCompletion(@Nullable ISuperPlayer mpImpl) {
        a();
        QLog.i("GameCenterPerfReportInterceptor", 2, "[onCompletion]");
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public boolean onError(@Nullable ISuperPlayer mpImpl, int module, int errorType, int errorCode, @Nullable String extraInfo) {
        b().reportPlayError(this.baseReportData, module, errorType, errorCode);
        QLog.i("GameCenterPerfReportInterceptor", 2, "[onError] module:" + module + ",errorType:" + errorType + ",errorCode:" + errorCode);
        return false;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onInfo(int what, long arg1, long arg2, @Nullable Object extra) {
        QLog.i("GameCenterPerfReportInterceptor", 4, "[onInfo] what:" + what);
        if (what == 255) {
            try {
                c(arg1);
            } catch (Throwable unused) {
                QLog.e("GameCenterPerfReportInterceptor", 1, new Object[0]);
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerInfoBufferingEnd() {
        if (!this.isSeeking) {
            b().reportVideoBufferingEnd(this.baseReportData);
        }
        QLog.i("GameCenterPerfReportInterceptor", 2, "[onPlayerInfoBufferingEnd] isSeeking:" + this.isSeeking);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerInfoBufferingStart() {
        if (!this.isSeeking) {
            this.baseReportData.lastBufferingStartTime = System.currentTimeMillis();
            b().reportVideoBufferingStart(this.baseReportData);
        }
        QLog.i("GameCenterPerfReportInterceptor", 2, "[onPlayerInfoBufferingStart] isSeeking:" + this.isSeeking);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerInfoCurrentLoopEnd() {
        a();
        QLog.i("GameCenterPerfReportInterceptor", 2, "[onPlayerInfoCurrentLoopEnd]");
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerParamsReset() {
        this.baseReportData = new p(p.INSTANCE.b(), null, 2, null);
        this.hasReportComplete = false;
        this.isSeeking = false;
        this.dropFrameRecordMap.clear();
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onRelease(int releaseSource) {
        float f16;
        ISPReportProvider reportProvider;
        String joinToString$default;
        try {
            if (!this.dropFrameRecordMap.isEmpty()) {
                p pVar = this.baseReportData;
                Set<Map.Entry<Long, Long>> entrySet = this.dropFrameRecordMap.entrySet();
                Intrinsics.checkNotNullExpressionValue(entrySet, "dropFrameRecordMap.entries");
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(entrySet, "_", null, null, 0, null, new Function1<Map.Entry<Long, Long>, CharSequence>() { // from class: com.tencent.mobileqq.gamecenter.video.interceptor.GameCenterPerfReportInterceptor$onRelease$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final CharSequence invoke(@NotNull Map.Entry<Long, Long> it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.getKey() + "-" + it.getValue();
                    }
                }, 30, null);
                pVar.dropFrameRecordStr = joinToString$default;
            }
            p pVar2 = this.baseReportData;
            ISuperPlayer iSuperPlayer = this.player;
            if (iSuperPlayer != null && (reportProvider = iSuperPlayer.getReportProvider()) != null) {
                f16 = reportProvider.getAvgDropFrameRate();
            } else {
                f16 = 0.0f;
            }
            pVar2.avgDropFrame = f16 * 100;
            p pVar3 = this.baseReportData;
            QLog.i("GameCenterPerfReportInterceptor", 2, "[onRelease] avgDropFrame:" + pVar3.avgDropFrame + ",dropFrameRecordStr:" + pVar3.dropFrameRecordStr);
        } catch (Throwable th5) {
            QLog.e("GameCenterPerfReportInterceptor", 1, "[onRelease]", th5);
        }
        b().reportVideoRelease(this.baseReportData);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onSeekComplete(@Nullable ISuperPlayer iSuperPlayer) {
        this.isSeeking = false;
        QLog.i("GameCenterPerfReportInterceptor", 2, "[onSeekComplete]");
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onStopTrackingTouch(int progress, int max) {
        this.isSeeking = true;
        QLog.i("GameCenterPerfReportInterceptor", 2, "[onStopTrackingTouch]");
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onVideoPrepare() {
        long j3;
        MediaInfo mediaInfo;
        p pVar = this.baseReportData;
        ISuperPlayer iSuperPlayer = this.player;
        if (iSuperPlayer != null && (mediaInfo = iSuperPlayer.getMediaInfo()) != null) {
            j3 = mediaInfo.getVideoFps();
        } else {
            j3 = 0;
        }
        pVar.videoFps = j3;
        b().reportVideoPrepared(this.baseReportData);
        QLog.i("GameCenterPerfReportInterceptor", 2, "[onVideoPrepare] videoFps:" + this.baseReportData.videoFps);
    }

    public GameCenterPerfReportInterceptor(int i3, @Nullable String str) {
        this();
        this.baseReportData = new p(i3, str);
    }
}

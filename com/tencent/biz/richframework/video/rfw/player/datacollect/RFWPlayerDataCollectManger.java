package com.tencent.biz.richframework.video.rfw.player.datacollect;

import android.os.Handler;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.RFWPlayerListenerDispatchUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerDataCollectManger;
import com.tencent.biz.richframework.video.rfw.player.datacollect.action.RFWPlayerErrorAction;
import com.tencent.biz.richframework.video.rfw.player.datacollect.action.RFWPlayerFirstFrameAction;
import com.tencent.biz.richframework.video.rfw.player.datacollect.action.RFWPlayerFlushAction;
import com.tencent.biz.richframework.video.rfw.player.datacollect.action.RFWPlayerOptionFinishAction;
import com.tencent.biz.richframework.video.rfw.player.datacollect.action.RFWPlayerPrepareAction;
import com.tencent.biz.richframework.video.rfw.player.datacollect.action.RFWPlayerReplacePreloadAction;
import com.tencent.biz.richframework.video.rfw.player.datacollect.action.RFWPlayerSecondBufferEndAction;
import com.tencent.biz.richframework.video.rfw.player.datacollect.action.RFWPlayerSecondBufferStartAction;
import com.tencent.biz.richframework.video.rfw.player.datacollect.action.RFWPlayerSeekCompleteAction;
import com.tencent.biz.richframework.video.rfw.player.datacollect.action.RFWPlayerStartNewPlayAction;
import com.tencent.biz.richframework.video.rfw.player.datacollect.action.RFWPlayerStartTrackingTouchAction;
import com.tencent.biz.richframework.video.rfw.player.datacollect.action.RFWPlayerStopTrackingTouchAction;
import com.tencent.biz.richframework.video.rfw.player.datacollect.action.RFWPlayerWeakNetTipsAction;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class RFWPlayerDataCollectManger {
    private static volatile RFWPlayerDataCollectManger sInstance;
    private ConcurrentHashMap<String, RFWPlayerCollectParams> mDataParams = new ConcurrentHashMap<>();
    private final Handler mDataCollectHandler = RFWThreadManager.createNewThreadHandler("QFSPlayDataCollectManger", 0);

    RFWPlayerDataCollectManger() {
    }

    private boolean enableCollect() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_player_collect_report", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$flush$11(String str, long j3) {
        RFWPlayerCollectParams rFWPlayerCollectParams = this.mDataParams.get(str);
        if (rFWPlayerCollectParams == null) {
            return;
        }
        this.mDataParams.remove(str);
        new RFWPlayerFlushAction().onAction(str, rFWPlayerCollectParams, Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onError$5(String str, String str2) {
        RFWPlayerCollectParams rFWPlayerCollectParams = this.mDataParams.get(str);
        if (rFWPlayerCollectParams == null) {
            return;
        }
        new RFWPlayerErrorAction().onAction(str, rFWPlayerCollectParams, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFirstRenderAction$4(String str, long j3, RFWPlayer rFWPlayer, RFWPlayerOptions rFWPlayerOptions) {
        RFWPlayerCollectParams rFWPlayerCollectParams = this.mDataParams.get(str);
        if (rFWPlayerCollectParams == null) {
            return;
        }
        new RFWPlayerFirstFrameAction().onAction(str, rFWPlayerCollectParams, Long.valueOf(j3));
        notifyFirstRenderCollectFinish(rFWPlayer, rFWPlayerOptions, rFWPlayerCollectParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onOptionProcessFinishAction$1(String str, long j3, String str2, float f16) {
        RFWPlayerCollectParams rFWPlayerCollectParams = this.mDataParams.get(str);
        if (rFWPlayerCollectParams == null) {
            return;
        }
        new RFWPlayerOptionFinishAction().onAction(str, rFWPlayerCollectParams, Long.valueOf(j3), str2, Float.valueOf(f16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onReplacePreloadAction$2(String str, String str2, String str3, float f16) {
        RFWPlayerCollectParams rFWPlayerCollectParams = this.mDataParams.get(str);
        if (rFWPlayerCollectParams == null) {
            return;
        }
        new RFWPlayerReplacePreloadAction().onAction(str, rFWPlayerCollectParams, str2, str3, Float.valueOf(f16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSecondBufferEnd$10(String str, long j3) {
        RFWPlayerCollectParams rFWPlayerCollectParams = this.mDataParams.get(str);
        if (rFWPlayerCollectParams == null) {
            return;
        }
        new RFWPlayerSecondBufferEndAction().onAction(str, rFWPlayerCollectParams, Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSecondBufferStart$9(String str, long j3) {
        RFWPlayerCollectParams rFWPlayerCollectParams = this.mDataParams.get(str);
        if (rFWPlayerCollectParams == null) {
            return;
        }
        new RFWPlayerSecondBufferStartAction().onAction(str, rFWPlayerCollectParams, Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSeekCompletion$8(String str, long j3) {
        RFWPlayerCollectParams rFWPlayerCollectParams = this.mDataParams.get(str);
        if (rFWPlayerCollectParams == null) {
            return;
        }
        new RFWPlayerSeekCompleteAction().onAction(str, rFWPlayerCollectParams, Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStartNewPlayAction$0(int i3, String str, boolean z16, RFWStVideo rFWStVideo, long j3, long j16, HashMap hashMap) {
        RFWPlayerCollectParams playRequestStartTime = new RFWPlayerCollectParams(i3, str).setIsSdkReady(z16).setFileId(rFWStVideo.getFileId()).setStartOffset(((float) j3) / 1000.0f).setPlayRequestStartTime(j16);
        this.mDataParams.put(str, playRequestStartTime);
        new RFWPlayerStartNewPlayAction().onAction(str, playRequestStartTime, rFWStVideo, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStartTrackingTouch$6(String str, int i3) {
        RFWPlayerCollectParams rFWPlayerCollectParams = this.mDataParams.get(str);
        if (rFWPlayerCollectParams == null) {
            return;
        }
        new RFWPlayerStartTrackingTouchAction().onAction(str, rFWPlayerCollectParams, Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStopTrackingTouch$7(String str, int i3, long j3) {
        RFWPlayerCollectParams rFWPlayerCollectParams = this.mDataParams.get(str);
        if (rFWPlayerCollectParams == null) {
            return;
        }
        new RFWPlayerStopTrackingTouchAction().onAction(str, rFWPlayerCollectParams, Integer.valueOf(i3), Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onVideoPrepareAction$3(String str, long j3) {
        RFWPlayerCollectParams rFWPlayerCollectParams = this.mDataParams.get(str);
        if (rFWPlayerCollectParams == null) {
            return;
        }
        new RFWPlayerPrepareAction().onAction(str, rFWPlayerCollectParams, Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onWeakNetTipsShow$13(String str) {
        RFWPlayerCollectParams rFWPlayerCollectParams = this.mDataParams.get(str);
        if (rFWPlayerCollectParams == null) {
            return;
        }
        new RFWPlayerWeakNetTipsAction().onAction(str, rFWPlayerCollectParams, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onWeakNetTipsUserClick$12(String str, long j3) {
        RFWPlayerCollectParams rFWPlayerCollectParams = this.mDataParams.get(str);
        if (rFWPlayerCollectParams == null) {
            return;
        }
        new RFWPlayerWeakNetTipsAction().onAction(str, rFWPlayerCollectParams, 2, Long.valueOf(j3));
    }

    private static void notifyFirstRenderCollectFinish(RFWPlayer rFWPlayer, RFWPlayerOptions rFWPlayerOptions, RFWPlayerCollectParams rFWPlayerCollectParams) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QCircleReportHelper.newEntry("time_cost", String.valueOf(rFWPlayerCollectParams.getFirstRenderCostTimeS())));
        RFWPlayerListenerDispatchUtils.notifyReportFront(rFWPlayerOptions, rFWPlayer.getVideoPlayId(), "video_current_player", arrayList);
    }

    public void flush(final String str) {
        if (!enableCollect()) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        this.mDataCollectHandler.post(new Runnable() { // from class: pe0.c
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerDataCollectManger.this.lambda$flush$11(str, currentTimeMillis);
            }
        });
    }

    public void onError(final String str, final String str2) {
        if (!enableCollect()) {
            return;
        }
        this.mDataCollectHandler.post(new Runnable() { // from class: pe0.b
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerDataCollectManger.this.lambda$onError$5(str, str2);
            }
        });
    }

    public void onFirstRenderAction(final RFWPlayer rFWPlayer, final RFWPlayerOptions rFWPlayerOptions, final String str) {
        if (!enableCollect()) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        this.mDataCollectHandler.post(new Runnable() { // from class: pe0.d
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerDataCollectManger.this.lambda$onFirstRenderAction$4(str, currentTimeMillis, rFWPlayer, rFWPlayerOptions);
            }
        });
    }

    public void onOptionProcessFinishAction(final String str, final String str2, final float f16) {
        if (!enableCollect()) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        this.mDataCollectHandler.post(new Runnable() { // from class: pe0.n
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerDataCollectManger.this.lambda$onOptionProcessFinishAction$1(str, currentTimeMillis, str2, f16);
            }
        });
    }

    public void onReplacePreloadAction(final String str, final String str2, final String str3, final float f16) {
        if (!enableCollect()) {
            return;
        }
        this.mDataCollectHandler.post(new Runnable() { // from class: pe0.e
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerDataCollectManger.this.lambda$onReplacePreloadAction$2(str, str2, str3, f16);
            }
        });
    }

    public void onSecondBufferEnd(final String str) {
        if (!enableCollect()) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        this.mDataCollectHandler.post(new Runnable() { // from class: pe0.h
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerDataCollectManger.this.lambda$onSecondBufferEnd$10(str, currentTimeMillis);
            }
        });
    }

    public void onSecondBufferStart(final String str) {
        if (!enableCollect()) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        this.mDataCollectHandler.post(new Runnable() { // from class: pe0.l
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerDataCollectManger.this.lambda$onSecondBufferStart$9(str, currentTimeMillis);
            }
        });
    }

    public void onSeekCompletion(final String str) {
        if (!enableCollect()) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        this.mDataCollectHandler.post(new Runnable() { // from class: pe0.k
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerDataCollectManger.this.lambda$onSeekCompletion$8(str, currentTimeMillis);
            }
        });
    }

    public void onStartNewPlayAction(RFWPlayerOptions rFWPlayerOptions) {
        if (enableCollect() && rFWPlayerOptions != null && rFWPlayerOptions.enableDataCollected() && rFWPlayerOptions.getAttachInfo() != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            final boolean isSDKReady = QQVideoPlaySDKManager.isSDKReady();
            final int sceneId = rFWPlayerOptions.getSceneId();
            final String tag = rFWPlayerOptions.tag();
            final RFWStVideo stVideo = rFWPlayerOptions.getStVideo();
            final long startOffset = rFWPlayerOptions.getStartOffset();
            final HashMap<String, Object> attachInfo = rFWPlayerOptions.getAttachInfo();
            this.mDataCollectHandler.post(new Runnable() { // from class: pe0.i
                @Override // java.lang.Runnable
                public final void run() {
                    RFWPlayerDataCollectManger.this.lambda$onStartNewPlayAction$0(sceneId, tag, isSDKReady, stVideo, startOffset, currentTimeMillis, attachInfo);
                }
            });
        }
    }

    public void onStartTrackingTouch(final String str, final int i3) {
        if (!enableCollect()) {
            return;
        }
        this.mDataCollectHandler.post(new Runnable() { // from class: pe0.m
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerDataCollectManger.this.lambda$onStartTrackingTouch$6(str, i3);
            }
        });
    }

    public void onStopTrackingTouch(final String str, final int i3) {
        if (!enableCollect()) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        this.mDataCollectHandler.post(new Runnable() { // from class: pe0.g
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerDataCollectManger.this.lambda$onStopTrackingTouch$7(str, i3, currentTimeMillis);
            }
        });
    }

    public void onVideoPrepareAction(final String str) {
        if (!enableCollect()) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        this.mDataCollectHandler.post(new Runnable() { // from class: pe0.j
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerDataCollectManger.this.lambda$onVideoPrepareAction$3(str, currentTimeMillis);
            }
        });
    }

    public void onWeakNetTipsShow(final String str) {
        this.mDataCollectHandler.post(new Runnable() { // from class: pe0.a
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerDataCollectManger.this.lambda$onWeakNetTipsShow$13(str);
            }
        });
    }

    public void onWeakNetTipsUserClick(final String str, final long j3) {
        this.mDataCollectHandler.post(new Runnable() { // from class: pe0.f
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerDataCollectManger.this.lambda$onWeakNetTipsUserClick$12(str, j3);
            }
        });
    }

    public static RFWPlayerDataCollectManger g() {
        if (sInstance == null) {
            synchronized (RFWPlayerDataCollectManger.class) {
                if (sInstance == null) {
                    sInstance = new RFWPlayerDataCollectManger();
                }
            }
        }
        return sInstance;
    }
}

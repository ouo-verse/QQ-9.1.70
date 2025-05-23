package com.tencent.qqlive.module.videoreport.dtreport.video.playback;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportManager;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.tpplayer.TPPlayer;

/* loaded from: classes22.dex */
public class ReportThumbPlayer {
    private static final String TAG = "video.ReportThumbPlayer";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        private static final ReportThumbPlayer INSTANCE = new ReportThumbPlayer();

        InstanceHolder() {
        }
    }

    public static ReportThumbPlayer getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void onCompletion(Object obj) {
        if (DTConfigConstants.config.videoReportSupport() && (obj instanceof TPPlayer)) {
            Log.i(TAG, "thumbplayer onCompletion");
            VideoReportManager.getInstance().onCompletion(obj);
        }
    }

    public void onError(Object obj, int i3, int i16) {
        if (DTConfigConstants.config.videoReportSupport()) {
            Log.d(TAG, "onError(), hook thumbplayer onError");
            VideoReportManager.getInstance().onError(obj, i3, i16);
        }
    }

    public void onInfo(Object obj, int i3, long j3, long j16) {
        if (DTConfigConstants.config.videoReportSupport()) {
            VideoReportManager.getInstance().onInfo(obj, i3, j3, j16);
        }
    }

    public void onPrepared(Object obj) {
        if (DTConfigConstants.config.videoReportSupport() && (obj instanceof TPPlayer)) {
            Log.i(TAG, "thumbplayer onPrepared");
            VideoReportManager.getInstance().onPrepared(obj);
        }
    }

    public void pause(Object obj) {
        if (DTConfigConstants.config.videoReportSupport()) {
            Log.d(TAG, "pause(), hook thumbplayer pause");
            VideoReportManager.getInstance().pause(obj);
        }
    }

    public void release(Object obj) {
        if (DTConfigConstants.config.videoReportSupport()) {
            Log.d(TAG, "release(), hook thumbplayer release");
            VideoReportManager.getInstance().release(obj);
        }
    }

    public void reset(Object obj) {
        if (DTConfigConstants.config.videoReportSupport()) {
            Log.d(TAG, "reset(), hook thumbplayer reset");
            VideoReportManager.getInstance().reset(obj);
        }
    }

    public void seekTo(Object obj, int i3) {
        if (DTConfigConstants.config.videoReportSupport() && DTConfigConstants.config.seekReportSupport()) {
            Log.d(TAG, "seekTo(), hook thumbplayer seekTo");
            VideoReportManager.getInstance().seekTo(obj, i3);
        }
    }

    public void seekToAsync(Object obj, long j3) {
        if (DTConfigConstants.config.videoReportSupport() && DTConfigConstants.config.seekReportSupport()) {
            Log.i(TAG, "thumbplayer seekTo playerObject: " + obj);
            VideoReportManager.getInstance().seekTo(obj, j3);
        }
    }

    public void setDataSource(Object obj, Object obj2) {
        if (DTConfigConstants.config.videoReportSupport()) {
            Log.i(TAG, "thumbplayer setReportInfo");
            VideoReportManager.getInstance().bindDataSource(obj, obj2);
        }
    }

    public void setLoopback(Object obj, boolean z16, long j3, long j16) {
        if (DTConfigConstants.config.videoReportSupport()) {
            Log.d(TAG, "setLoopback(), hook thumbplayer setLoopback");
            VideoReportManager.getInstance().setLoopback(obj, z16, j3, j16);
        }
    }

    public void setPlaySpeedRatio(Object obj, float f16) {
        if (DTConfigConstants.config.videoReportSupport() && DTConfigConstants.config.speedRatioReportSupport()) {
            Log.d(TAG, "setPlaySpeedRatio(), hook thumbplayer setPlaySpeedRatio");
            VideoReportManager.getInstance().setPlaySpeedRatio(obj, f16);
        }
    }

    public void setPlayerOptionalParam(Object obj, Object obj2) {
        if (DTConfigConstants.config.videoReportSupport()) {
            Log.d(TAG, "setPlayerOptionalParam(), hook thumbplayer setPlayerOptionalParam");
            VideoReportManager.getInstance().setStartPosition(obj, obj2);
        }
    }

    public void start(final Object obj) {
        if (DTConfigConstants.config.videoReportSupport()) {
            Log.d(TAG, "start(), hook thumbplayer start");
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoReportManager.getInstance().start(obj);
                }
            });
        }
    }

    public void stop(Object obj) {
        if (DTConfigConstants.config.videoReportSupport()) {
            Log.d(TAG, "stop(), hook thumbplayer stop");
            VideoReportManager.getInstance().stop(obj);
        }
    }

    ReportThumbPlayer() {
    }

    public void onInfo(Object obj, int i3, TPOnInfoParam tPOnInfoParam) {
        if (DTConfigConstants.config.videoReportSupport() && (obj instanceof TPPlayer)) {
            if (tPOnInfoParam == null) {
                VideoReportManager.getInstance().onInfo(obj, i3, 0L, 0L);
            } else {
                VideoReportManager.getInstance().onInfo(obj, i3, tPOnInfoParam.getLongParam1(), tPOnInfoParam.getLongParam2());
            }
        }
    }

    public void onError(Object obj, TPError tPError) {
        if (DTConfigConstants.config.videoReportSupport() && (obj instanceof TPPlayer)) {
            Log.i(TAG, "thumbplayer onError");
            if (tPError != null) {
                VideoReportManager.getInstance().onError(obj, tPError.getErrorType(), tPError.getErrorCode());
            } else {
                VideoReportManager.getInstance().onError(obj, 0, 0);
            }
        }
    }
}

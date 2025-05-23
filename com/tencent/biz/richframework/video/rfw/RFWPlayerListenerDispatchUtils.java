package com.tencent.biz.richframework.video.rfw;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerConfig;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerManger;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWOnTvkPermissionTimeOutListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerDownGradeListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerDownloadListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerOnInfoListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPassivePauseListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerRateChangListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSecondBufferListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSprListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWSeekCompletionListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWTVKOnNetVideoInfoListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWVideoSizeChangedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.superplayer.api.ISuperPlayer;
import feedcloud.FeedCloudCommon$Entry;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class RFWPlayerListenerDispatchUtils {
    public static void notifyOptionsCallback(String str, RFWPlayerOptions rFWPlayerOptions, boolean z16) {
        if (rFWPlayerOptions != null && !TextUtils.isEmpty(str)) {
            RFWPlayerConfig config = RFWPlayerManger.g(rFWPlayerOptions.getSceneId()).getConfig();
            if (config != null && config.getPlayerProcessCallback() != null) {
                if (z16) {
                    config.getPlayerProcessCallback().onOptionsStart(rFWPlayerOptions, str);
                    return;
                } else {
                    config.getPlayerProcessCallback().onOptionsFinish(rFWPlayerOptions, str);
                    return;
                }
            }
            QLog.d(rFWPlayerOptions.tag(), 1, "[notifyProcessEnd] error, process callback no init");
            return;
        }
        RFWLog.d("RFWPlayerListenerDispatchUtils", RFWLog.USR, "[notifyProcessEnd] current params illegality.");
    }

    public static void notifyReportFront(RFWPlayerOptions rFWPlayerOptions, long j3, String str, List<FeedCloudCommon$Entry> list) {
        if (rFWPlayerOptions != null && !TextUtils.isEmpty(str) && list != null) {
            RFWPlayerConfig config = RFWPlayerManger.g(rFWPlayerOptions.getSceneId()).getConfig();
            if (config != null && config.getPlayerReportCallback() != null) {
                config.getPlayerReportCallback().onReportFront(rFWPlayerOptions, j3, str, list);
                return;
            } else {
                QLog.d(rFWPlayerOptions.tag(), 1, "[notifyReportFront] error, process callback no init");
                return;
            }
        }
        RFWLog.d("RFWPlayerListenerDispatchUtils", RFWLog.USR, "[notifyReportFront] current params illegality.");
    }

    public static void onCompletion(RFWPlayerOptions rFWPlayerOptions, ISuperPlayer iSuperPlayer) {
        try {
            List<IRFWPlayerCompletionListener> completionListener = rFWPlayerOptions.getListenerSet().getCompletionListener();
            if (completionListener != null && completionListener.size() > 0) {
                Iterator<IRFWPlayerCompletionListener> it = completionListener.iterator();
                while (it.hasNext()) {
                    it.next().onCompletion(iSuperPlayer);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onCompletion() error ", e16);
        }
    }

    public static void onDeInit(@NonNull RFWPlayerOptions rFWPlayerOptions, RFWPlayer rFWPlayer) {
        try {
            List<IRFWPlayerLifeCycle> lifeCycleListeners = rFWPlayerOptions.getListenerSet().getLifeCycleListeners();
            if (lifeCycleListeners != null && lifeCycleListeners.size() > 0) {
                Iterator<IRFWPlayerLifeCycle> it = lifeCycleListeners.iterator();
                while (it.hasNext()) {
                    it.next().onDeInit(rFWPlayer);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onDeInit() error ", e16);
        }
    }

    public static void onDowngradeVideoUrl(@NonNull RFWPlayerOptions rFWPlayerOptions) {
        try {
            List<IRFWPlayerDownGradeListener> downGradeVideoListener = rFWPlayerOptions.getListenerSet().getDownGradeVideoListener();
            if (downGradeVideoListener != null && downGradeVideoListener.size() > 0) {
                Iterator<IRFWPlayerDownGradeListener> it = downGradeVideoListener.iterator();
                while (it.hasNext()) {
                    it.next().onDowngradeVideoUrl();
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onDowngradeVideoUrl() error ", e16);
        }
    }

    public static void onDownloadComplete(RFWPlayerOptions rFWPlayerOptions) {
        try {
            List<IRFWPlayerDownloadListener> downloadListener = rFWPlayerOptions.getListenerSet().getDownloadListener();
            if (downloadListener != null && downloadListener.size() > 0) {
                Iterator<IRFWPlayerDownloadListener> it = downloadListener.iterator();
                while (it.hasNext()) {
                    it.next().onDownloadComplete(rFWPlayerOptions);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onDownloadComplete() error: ", e16);
        }
    }

    public static void onFirstFrameRendered(@NonNull RFWPlayerOptions rFWPlayerOptions, RFWPlayer rFWPlayer) {
        try {
            List<IRFWPlayerPrepareListener> prePrepareListeners = rFWPlayerOptions.getListenerSet().getPrePrepareListeners();
            if (prePrepareListeners != null && prePrepareListeners.size() > 0) {
                Iterator<IRFWPlayerPrepareListener> it = prePrepareListeners.iterator();
                while (it.hasNext()) {
                    it.next().onFirstFrameRendered(rFWPlayer);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onFirstFrameRendered() error ", e16);
        }
    }

    public static void onInfo(RFWPlayerOptions rFWPlayerOptions, int i3, long j3, long j16, Object obj) {
        try {
            List<IRFWPlayerOnInfoListener> infoListener = rFWPlayerOptions.getListenerSet().getInfoListener();
            if (infoListener != null && infoListener.size() > 0) {
                Iterator<IRFWPlayerOnInfoListener> it = infoListener.iterator();
                while (it.hasNext()) {
                    it.next().onInfo(i3, j3, j16, obj);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onInfo() error: ", e16);
        }
    }

    public static void onInitSuccess(@NonNull RFWPlayerOptions rFWPlayerOptions, RFWPlayer rFWPlayer) {
        try {
            List<IRFWPlayerSdkInitListener> sDKInitListeners = rFWPlayerOptions.getListenerSet().getSDKInitListeners();
            if (sDKInitListeners != null && sDKInitListeners.size() > 0) {
                Iterator<IRFWPlayerSdkInitListener> it = sDKInitListeners.iterator();
                while (it.hasNext()) {
                    it.next().onInitSuccess(rFWPlayer);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onInitSuccess() error ", e16);
        }
    }

    public static void onNetVideoInfo(RFWPlayerOptions rFWPlayerOptions, TVKNetVideoInfo tVKNetVideoInfo) {
        try {
            List<IRFWTVKOnNetVideoInfoListener> tVKNetVideoInfoListener = rFWPlayerOptions.getListenerSet().getTVKNetVideoInfoListener();
            if (tVKNetVideoInfoListener != null && tVKNetVideoInfoListener.size() > 0) {
                Iterator<IRFWTVKOnNetVideoInfoListener> it = tVKNetVideoInfoListener.iterator();
                while (it.hasNext()) {
                    it.next().onNetVideoInfo(tVKNetVideoInfo);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onNetVideoInfo() error: ", e16);
        }
    }

    public static void onPause(@NonNull RFWPlayerOptions rFWPlayerOptions, RFWPlayer rFWPlayer) {
        try {
            List<IRFWPlayerLifeCycle> lifeCycleListeners = rFWPlayerOptions.getListenerSet().getLifeCycleListeners();
            if (lifeCycleListeners != null && lifeCycleListeners.size() > 0) {
                Iterator<IRFWPlayerLifeCycle> it = lifeCycleListeners.iterator();
                while (it.hasNext()) {
                    it.next().onPause(rFWPlayer);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onPause() error ", e16);
        }
    }

    public static void onPermissionTimeout(RFWPlayerOptions rFWPlayerOptions, ISuperPlayer iSuperPlayer) {
        try {
            List<IRFWOnTvkPermissionTimeOutListener> tvkPermissionTimeOutListener = rFWPlayerOptions.getListenerSet().getTvkPermissionTimeOutListener();
            if (tvkPermissionTimeOutListener != null && tvkPermissionTimeOutListener.size() > 0) {
                Iterator<IRFWOnTvkPermissionTimeOutListener> it = tvkPermissionTimeOutListener.iterator();
                while (it.hasNext()) {
                    it.next().onPermissionTimeout();
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onPermissionTimeout() : ", e16);
        }
    }

    public static void onPlayerRateChanged(RFWPlayerOptions rFWPlayerOptions, float f16, long j3, RFWPlayer rFWPlayer) {
        try {
            List<IRFWPlayerRateChangListener> playerRateChangeListener = rFWPlayerOptions.getListenerSet().getPlayerRateChangeListener();
            if (playerRateChangeListener != null && playerRateChangeListener.size() > 0) {
                Iterator<IRFWPlayerRateChangListener> it = playerRateChangeListener.iterator();
                while (it.hasNext()) {
                    it.next().onPlayerRateChanged(f16, j3, rFWPlayer);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onPlayerRateChanged() : ", e16);
        }
    }

    public static void onProgress(RFWPlayerOptions rFWPlayerOptions, String str, int i3, int i16) {
        try {
            List<IRFWPlayerSeekListener> seekListeners = rFWPlayerOptions.getListenerSet().getSeekListeners();
            if (seekListeners != null && seekListeners.size() > 0) {
                Iterator<IRFWPlayerSeekListener> it = seekListeners.iterator();
                while (it.hasNext()) {
                    it.next().onProgress(str, i3, i16);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onSeekBarProgressChanged() error ", e16);
        }
    }

    public static void onRelease(@NonNull RFWPlayerOptions rFWPlayerOptions, RFWPlayer rFWPlayer) {
        try {
            List<IRFWPlayerLifeCycle> lifeCycleListeners = rFWPlayerOptions.getListenerSet().getLifeCycleListeners();
            if (lifeCycleListeners != null && lifeCycleListeners.size() > 0) {
                Iterator<IRFWPlayerLifeCycle> it = lifeCycleListeners.iterator();
                while (it.hasNext()) {
                    it.next().onRelease(rFWPlayer);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onRelease() error ", e16);
        }
    }

    public static void onSecondBufferEnd(@NonNull RFWPlayerOptions rFWPlayerOptions) {
        try {
            List<IRFWPlayerSecondBufferListener> secondBufferListeners = rFWPlayerOptions.getListenerSet().getSecondBufferListeners();
            if (secondBufferListeners != null && secondBufferListeners.size() > 0) {
                Iterator<IRFWPlayerSecondBufferListener> it = secondBufferListeners.iterator();
                while (it.hasNext()) {
                    it.next().onSecondBufferEnd();
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onSecondBufferEnd() error ", e16);
        }
    }

    public static void onSecondBufferStart(@NonNull RFWPlayerOptions rFWPlayerOptions) {
        try {
            List<IRFWPlayerSecondBufferListener> secondBufferListeners = rFWPlayerOptions.getListenerSet().getSecondBufferListeners();
            if (secondBufferListeners != null && secondBufferListeners.size() > 0) {
                Iterator<IRFWPlayerSecondBufferListener> it = secondBufferListeners.iterator();
                while (it.hasNext()) {
                    it.next().onSecondBufferStart();
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onSecondBufferStart() error ", e16);
        }
    }

    public static void onSeekBarProgressChanged(RFWPlayerOptions rFWPlayerOptions, SeekBar seekBar, int i3, boolean z16) {
        try {
            List<IRFWPlayerSeekListener> seekListeners = rFWPlayerOptions.getListenerSet().getSeekListeners();
            if (seekListeners != null && seekListeners.size() > 0) {
                Iterator<IRFWPlayerSeekListener> it = seekListeners.iterator();
                while (it.hasNext()) {
                    it.next().onSeekBarProgressChanged(seekBar, i3, z16);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onSeekBarProgressChanged() error ", e16);
        }
    }

    public static void onSeekCompletion(RFWPlayerOptions rFWPlayerOptions, ISuperPlayer iSuperPlayer) {
        try {
            List<IRFWSeekCompletionListener> seekCompletionListeners = rFWPlayerOptions.getListenerSet().getSeekCompletionListeners();
            if (seekCompletionListeners != null && seekCompletionListeners.size() > 0) {
                Iterator<IRFWSeekCompletionListener> it = seekCompletionListeners.iterator();
                while (it.hasNext()) {
                    it.next().onSeekCompletion(iSuperPlayer);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onSeekCompletion() : ", e16);
        }
    }

    public static void onSprEnable(RFWPlayerOptions rFWPlayerOptions, boolean z16) {
        try {
            List<IRFWPlayerSprListener> sprListener = rFWPlayerOptions.getListenerSet().getSprListener();
            if (sprListener != null && sprListener.size() > 0) {
                Iterator<IRFWPlayerSprListener> it = sprListener.iterator();
                while (it.hasNext()) {
                    it.next().onSprEnable(z16);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onSprOriginFrameBack() error: ", e16);
        }
    }

    public static void onSprOriginFrameBack(RFWPlayerOptions rFWPlayerOptions, Bitmap bitmap) {
        try {
            List<IRFWPlayerSprListener> sprListener = rFWPlayerOptions.getListenerSet().getSprListener();
            if (sprListener != null && sprListener.size() > 0) {
                Iterator<IRFWPlayerSprListener> it = sprListener.iterator();
                while (it.hasNext()) {
                    it.next().onOriginFrameBack(bitmap);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onSprOriginFrameBack() error: ", e16);
        }
    }

    public static void onStart(@NonNull RFWPlayerOptions rFWPlayerOptions, RFWPlayer rFWPlayer) {
        try {
            List<IRFWPlayerLifeCycle> lifeCycleListeners = rFWPlayerOptions.getListenerSet().getLifeCycleListeners();
            if (lifeCycleListeners != null && lifeCycleListeners.size() > 0) {
                Iterator<IRFWPlayerLifeCycle> it = lifeCycleListeners.iterator();
                while (it.hasNext()) {
                    it.next().onStart(rFWPlayer);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onStart() error:", e16);
        }
    }

    public static void onStartTrackingTouch(@NonNull RFWPlayerOptions rFWPlayerOptions, SeekBar seekBar) {
        try {
            List<IRFWPlayerSeekListener> seekListeners = rFWPlayerOptions.getListenerSet().getSeekListeners();
            if (seekListeners != null && seekListeners.size() > 0) {
                Iterator<IRFWPlayerSeekListener> it = seekListeners.iterator();
                while (it.hasNext()) {
                    it.next().onStartTrackingTouch(seekBar);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onStartTrackingTouch() error ", e16);
        }
    }

    public static void onStop(@NonNull RFWPlayerOptions rFWPlayerOptions, RFWPlayer rFWPlayer) {
        try {
            List<IRFWPlayerLifeCycle> lifeCycleListeners = rFWPlayerOptions.getListenerSet().getLifeCycleListeners();
            if (lifeCycleListeners != null && lifeCycleListeners.size() > 0) {
                Iterator<IRFWPlayerLifeCycle> it = lifeCycleListeners.iterator();
                while (it.hasNext()) {
                    it.next().onStop(rFWPlayer);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onStop() error ", e16);
        }
    }

    public static void onStopTrackingTouch(@NonNull RFWPlayerOptions rFWPlayerOptions, SeekBar seekBar) {
        try {
            List<IRFWPlayerSeekListener> seekListeners = rFWPlayerOptions.getListenerSet().getSeekListeners();
            if (seekListeners != null && seekListeners.size() > 0) {
                Iterator<IRFWPlayerSeekListener> it = seekListeners.iterator();
                while (it.hasNext()) {
                    it.next().onStopTrackingTouch(seekBar);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onStopTrackingTouch() error ", e16);
        }
    }

    public static void onVideoLoopEnd(@NonNull RFWPlayerOptions rFWPlayerOptions) {
        try {
            List<IRFWPlayerLooperListener> looperListeners = rFWPlayerOptions.getListenerSet().getLooperListeners();
            if (looperListeners != null && looperListeners.size() > 0) {
                Iterator<IRFWPlayerLooperListener> it = looperListeners.iterator();
                while (it.hasNext()) {
                    it.next().onVideoLoopEnd();
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onVideoLoopEnd() error ", e16);
        }
    }

    public static void onVideoLoopStart(@NonNull RFWPlayerOptions rFWPlayerOptions) {
        try {
            List<IRFWPlayerLooperListener> looperListeners = rFWPlayerOptions.getListenerSet().getLooperListeners();
            if (looperListeners != null && looperListeners.size() > 0) {
                Iterator<IRFWPlayerLooperListener> it = looperListeners.iterator();
                while (it.hasNext()) {
                    it.next().onVideoLoopStart();
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onVideoLoopStart() error ", e16);
        }
    }

    public static void onVideoPassivePause(@NonNull RFWPlayerOptions rFWPlayerOptions, int i3, int i16, long j3, long j16, long j17) {
        try {
            List<IRFWPlayerPassivePauseListener> playerPassivePauseListeners = rFWPlayerOptions.getListenerSet().getPlayerPassivePauseListeners();
            if (playerPassivePauseListeners != null && playerPassivePauseListeners.size() > 0) {
                Iterator<IRFWPlayerPassivePauseListener> it = playerPassivePauseListeners.iterator();
                while (it.hasNext()) {
                    it.next().onVideoPassivePause(i3, i16, j3, j16, j17);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onVideoPassivePause() error ", e16);
        }
    }

    public static void onVideoPlayError(@NonNull RFWPlayerOptions rFWPlayerOptions, int i3, int i16, int i17, String str) {
        try {
            List<IRFWPlayErrorStatusListener> errorStatusListener = rFWPlayerOptions.getListenerSet().getErrorStatusListener();
            if (errorStatusListener != null && errorStatusListener.size() > 0) {
                Iterator<IRFWPlayErrorStatusListener> it = errorStatusListener.iterator();
                while (it.hasNext()) {
                    it.next().onVideoPlayError(i3, i16, i17, str);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onVideoPlayError() error ", e16);
        }
    }

    public static void onVideoPrepared(@NonNull RFWPlayerOptions rFWPlayerOptions, RFWPlayer rFWPlayer) {
        try {
            List<IRFWPlayerPrepareListener> prePrepareListeners = rFWPlayerOptions.getListenerSet().getPrePrepareListeners();
            if (prePrepareListeners != null && prePrepareListeners.size() > 0) {
                Iterator<IRFWPlayerPrepareListener> it = prePrepareListeners.iterator();
                while (it.hasNext()) {
                    it.next().onVideoPrepared(rFWPlayer);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onVideoPrepared() error ", e16);
        }
    }

    public static void onVideoSizeChanged(RFWPlayerOptions rFWPlayerOptions, ISuperPlayer iSuperPlayer, int i3, int i16) {
        try {
            List<IRFWVideoSizeChangedListener> videoSizeChangedListener = rFWPlayerOptions.getListenerSet().getVideoSizeChangedListener();
            if (videoSizeChangedListener != null && !videoSizeChangedListener.isEmpty()) {
                Iterator<IRFWVideoSizeChangedListener> it = videoSizeChangedListener.iterator();
                while (it.hasNext()) {
                    it.next().onVideoSizeChanged(iSuperPlayer, i3, i16);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(rFWPlayerOptions.tag(), RFWLog.CLR, "dispatch onVideoSizeChanged() error ", e16);
        }
    }
}

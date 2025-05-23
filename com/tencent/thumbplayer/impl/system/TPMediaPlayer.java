package com.tencent.thumbplayer.impl.system;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.thumbplayer.common.TPContext;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import common.config.service.QzoneConfig;
import java.io.FileDescriptor;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPMediaPlayer extends ReportMediaPlayer {
    private static final String TAG = "TPMediaPlayer";
    private final TPContext mTPContext;

    public TPMediaPlayer(@NonNull TPContext tPContext) {
        this.mTPContext = tPContext;
    }

    @Override // android.media.MediaPlayer
    protected void finalize() {
        try {
            super.finalize();
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
        }
    }

    @Override // android.media.MediaPlayer
    public int getCurrentPosition() {
        try {
            return super.getCurrentPosition();
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
            return 0;
        }
    }

    @Override // android.media.MediaPlayer
    public int getDuration() {
        try {
            return super.getDuration();
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
            return 0;
        }
    }

    @Override // android.media.MediaPlayer
    public int getSelectedTrack(int i3) {
        try {
            return super.getSelectedTrack(i3);
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
            return 0;
        }
    }

    @Override // android.media.MediaPlayer
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        try {
            return super.getTrackInfo();
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
            return new MediaPlayer.TrackInfo[0];
        }
    }

    @Override // android.media.MediaPlayer
    public int getVideoHeight() {
        try {
            return super.getVideoHeight();
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
            return 0;
        }
    }

    @Override // android.media.MediaPlayer
    public int getVideoWidth() {
        try {
            return super.getVideoWidth();
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
            return 0;
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer, android.media.MediaPlayer
    public void prepare() {
        try {
            super.prepare();
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
        }
    }

    @Override // android.media.MediaPlayer
    public void release() {
        try {
            if ("N1W".equalsIgnoreCase(TPSystemInfo.getDeviceName()) || "X909T".equalsIgnoreCase(TPSystemInfo.getDeviceName()) || "X909".equalsIgnoreCase(TPSystemInfo.getDeviceName()) || QzoneConfig.DefaultValue.DEFAULT_CATEGORY_SCANNER_FRONT_CAM_BLACKLIST.equalsIgnoreCase(TPSystemInfo.getDeviceName())) {
                super.setOnPreparedListener(null);
                super.setOnCompletionListener(null);
                super.setOnErrorListener(null);
                super.setOnInfoListener(null);
                super.setOnBufferingUpdateListener(null);
                super.setOnSeekCompleteListener(null);
                super.setOnVideoSizeChangedListener(null);
                ((Handler) super.getClass().getDeclaredField("mA2dpHandler").get(this)).removeCallbacksAndMessages(null);
            }
        } catch (IllegalAccessException e16) {
            TPLogUtil.e(TAG, e16);
        } catch (NoSuchFieldException e17) {
            TPLogUtil.e(TAG, e17);
        }
        try {
            super.release();
        } catch (Exception e18) {
            TPLogUtil.e(TAG, e18);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer, android.media.MediaPlayer
    public void reset() {
        try {
            super.reset();
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
        }
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(Context context, Uri uri) {
        try {
            super.setDataSource(context, uri);
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
        }
    }

    @Override // android.media.MediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        try {
            super.setDisplay(surfaceHolder);
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
        }
    }

    @Override // android.media.MediaPlayer
    public void setLooping(boolean z16) {
        try {
            super.setLooping(z16);
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
        }
    }

    @Override // android.media.MediaPlayer
    public void setPlaybackParams(PlaybackParams playbackParams) {
        try {
            super.setPlaybackParams(playbackParams);
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
        }
    }

    @Override // android.media.MediaPlayer
    public void setSurface(Surface surface) {
        try {
            super.setSurface(surface);
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
        }
    }

    @Override // android.media.MediaPlayer
    public void setVolume(float f16, float f17) {
        try {
            super.setVolume(f16, f17);
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer, android.media.MediaPlayer
    public void start() {
        try {
            super.start();
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer, android.media.MediaPlayer
    public void stop() {
        try {
            super.stop();
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
        }
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) {
        try {
            super.setDataSource(fileDescriptor);
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
        }
    }

    @Override // android.media.MediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        try {
            super.setDataSource(context, uri, map);
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16);
        }
    }
}

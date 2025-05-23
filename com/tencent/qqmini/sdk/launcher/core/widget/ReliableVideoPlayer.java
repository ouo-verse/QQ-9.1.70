package com.tencent.qqmini.sdk.launcher.core.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes23.dex */
public interface ReliableVideoPlayer {
    public static final int MEDIA_ERROR_IO = -1004;
    public static final int MEDIA_ERROR_MALFORMED = -1007;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_TIMED_OUT = -110;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
    public static final int MEDIA_INFO_AUDIO_DECODED_START = 10003;
    public static final int MEDIA_INFO_AUDIO_RENDERING_START = 10002;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_COMPONENT_OPEN = 10007;
    public static final int MEDIA_INFO_FIND_STREAM_INFO = 10006;
    public static final int MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE = 10100;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_OPEN_INPUT = 10005;
    public static final int MEDIA_INFO_STARTED_AS_NEXT = 2;
    public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
    public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
    public static final int MEDIA_INFO_VIDEO_DECODED_START = 10004;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    public static final int PLAY_MODE_AUDIO = 2;
    public static final int PLAY_MODE_VIDEO = 1;
    public static final boolean SUPPORT_NEXT_MEDIA = false;

    /* loaded from: classes23.dex */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(ReliableVideoPlayer reliableVideoPlayer, int i3);
    }

    /* loaded from: classes23.dex */
    public interface OnCompletionListener {
        void onCompletion(ReliableVideoPlayer reliableVideoPlayer);
    }

    /* loaded from: classes23.dex */
    public interface OnErrorListener {
        boolean onError(ReliableVideoPlayer reliableVideoPlayer, int i3, int i16);
    }

    /* loaded from: classes23.dex */
    public interface OnInfoListener {
        boolean onInfo(ReliableVideoPlayer reliableVideoPlayer, int i3, int i16);
    }

    /* loaded from: classes23.dex */
    public interface OnLoopStartListener {
        void onLoopStart(ReliableVideoPlayer reliableVideoPlayer);
    }

    /* loaded from: classes23.dex */
    public interface OnPreparedListener {
        void onPrepared(ReliableVideoPlayer reliableVideoPlayer);
    }

    /* loaded from: classes23.dex */
    public interface OnSeekCompleteListener {
        void onSeekComplete(ReliableVideoPlayer reliableVideoPlayer);
    }

    /* loaded from: classes23.dex */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(ReliableVideoPlayer reliableVideoPlayer, int i3, int i16);
    }

    int getAudioSessionId();

    long getCurrentPosition();

    String getDataSource();

    long getDuration();

    int getScore();

    int getVideoHeight();

    int getVideoSarDen();

    int getVideoSarNum();

    int getVideoWidth();

    boolean isLooping();

    @Deprecated
    boolean isPlayable();

    boolean isPlaying();

    void pause() throws IllegalStateException, Exception;

    void prepareAsync() throws IllegalStateException;

    void release();

    void reset();

    void seekTo(long j3) throws IllegalStateException;

    void setAudioStreamType(int i3);

    void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException;

    @TargetApi(14)
    void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException;

    void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException, UnsupportedOperationException;

    void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException, UnsupportedOperationException;

    void setDisplay(SurfaceHolder surfaceHolder);

    @Deprecated
    void setKeepInBackground(boolean z16);

    @Deprecated
    void setLogEnabled(boolean z16);

    void setLooping(boolean z16);

    void setNextMediaPlayer(ReliableVideoPlayer reliableVideoPlayer) throws UnsupportedOperationException;

    void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnLoopStartListener(OnLoopStartListener onLoopStartListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setScreenOnWhilePlaying(boolean z16);

    void setSurface(Surface surface);

    void setVolume(float f16, float f17);

    @Deprecated
    void setWakeMode(Context context, int i3);

    void start() throws IllegalStateException, Exception;

    void stop() throws IllegalStateException;
}

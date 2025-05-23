package com.google.android.exoplayer2.ext.mediaplayer;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface MediaPlayerInterface {
    public static final int EXO_MEDIA_ERROR_EXTRA_CONN = -3;
    public static final int EXO_MEDIA_ERROR_EXTRA_NETWORK = -2;
    public static final int EXO_MEDIA_ERROR_EXTRA_UNKNOWN = -1;
    public static final int EXO_MEDIA_ERROR_LOADER = -4004;
    public static final int EXO_MEDIA_ERROR_RESPONSE_403 = -10;
    public static final int EXO_MEDIA_ERROR_RESPONSE_404 = -11;
    public static final int EXO_MEDIA_ERROR_RESPONSE_500 = -12;
    public static final int EXO_MEDIA_ERROR_RESPONSE_502 = -13;
    public static final int EXO_MEDIA_ERROR_RESPONSE_OTHER = -30;
    public static final int EXO_MEDIA_ERROR_WHAT_EXTRACTOR = -4001;
    public static final int EXO_MEDIA_ERROR_WHAT_IO = -4000;
    public static final int EXO_MEDIA_ERROR_WHAT_UNKNOWN = -4999;
    public static final int EXO_MEIDA_ERROR_ILLEGAL_STATE = -4002;
    public static final int EXO_MEIDA_ERROR_MEDIACODEC_DECODER_INIT = -4003;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;

    /* loaded from: classes2.dex */
    public interface AudioEventListener {
        void onRenderAudioData(byte[] bArr, Format format);
    }

    /* loaded from: classes2.dex */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(MediaPlayerInterface mediaPlayerInterface, int i3);
    }

    /* loaded from: classes2.dex */
    public interface OnCompletionListener {
        void onCompletion(MediaPlayerInterface mediaPlayerInterface);
    }

    /* loaded from: classes2.dex */
    public interface OnErrorListener {
        boolean onError(MediaPlayerInterface mediaPlayerInterface, int i3, int i16);
    }

    /* loaded from: classes2.dex */
    public interface OnInfoListener {
        boolean onInfo(MediaPlayerInterface mediaPlayerInterface, int i3, int i16);
    }

    /* loaded from: classes2.dex */
    public interface OnLoopStartListener {
        void onLoopStart(MediaPlayerInterface mediaPlayerInterface);
    }

    /* loaded from: classes2.dex */
    public interface OnPreparedListener {
        void onPrepared(MediaPlayerInterface mediaPlayerInterface);
    }

    /* loaded from: classes2.dex */
    public interface OnSeekCompleteListener {
        void onSeekComplete(MediaPlayerInterface mediaPlayerInterface);
    }

    /* loaded from: classes2.dex */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(MediaPlayerInterface mediaPlayerInterface, int i3, int i16);
    }

    long getCurrentPosition();

    long getDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isLooping();

    boolean isPlaying();

    void pause() throws IllegalStateException;

    void prepareAsync() throws IllegalStateException;

    void release();

    void reset();

    void seekTo(long j3) throws IllegalStateException;

    void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setDataSource(Context context, List<String> list) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setDataSource(List<VideoMeta> list) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setDisplay(SurfaceHolder surfaceHolder);

    void setLooping(boolean z16);

    void setNextMediaPlayer(MediaPlayerInterface mediaPlayerInterface) throws UnsupportedOperationException;

    void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnLoopStartListener(OnLoopStartListener onLoopStartListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setRate(float f16);

    void setScreenOnWhilePlaying(boolean z16);

    void setSurface(Surface surface);

    void setVolume(float f16, float f17);

    @Deprecated
    void setWakeMode(Context context, int i3);

    void start() throws IllegalStateException;

    void stop() throws IllegalStateException;
}

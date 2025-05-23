package com.gyailib.library;

import android.util.Log;
import android.view.Surface;

/* loaded from: classes2.dex */
public class VideoPlayer {
    public static final int FFMEDIA_PLAYER = 0;
    public static final int HWCODEC_PLAYER = 1;
    public static final int MEDIA_PARAM_ASSET_MANAGER = 32;
    public static final int MEDIA_PARAM_VIDEO_DURATION = 3;
    public static final int MEDIA_PARAM_VIDEO_HEIGHT = 2;
    public static final int MEDIA_PARAM_VIDEO_WIDTH = 1;
    public static final int MSG_DECODER_DONE = 2;
    public static final int MSG_DECODER_INIT_ERROR = 0;
    public static final int MSG_DECODER_READY = 1;
    public static final int MSG_DECODING_TIME = 4;
    public static final int MSG_REQUEST_RENDER = 3;
    public static final int VIDEO_RENDER_ANWINDOW = 1;
    public static final int VIDEO_RENDER_OPENGL = 0;
    private long nativePlayerHandle = 0;
    private EventCallback eventCallback = null;

    /* loaded from: classes2.dex */
    public interface EventCallback {
        void onPlayerEvent(int i3, float f16);
    }

    public static String getFFmpegVersion() {
        return native_GetFFmpegVersion();
    }

    public static native String native_GetFFmpegVersion();

    public static native void onDrawFrame(int i3);

    public static native void onSurfaceChanged(int i3, int i16, int i17);

    public static native void onSurfaceCreated(int i3);

    private void playerEventCallback(int i3, float f16) {
        Log.w(VideoPlayer.class.getSimpleName(), "playerEventCallBack success");
        EventCallback eventCallback = this.eventCallback;
        if (eventCallback != null) {
            eventCallback.onPlayerEvent(i3, f16);
        }
    }

    public void addEventCallback(EventCallback eventCallback) {
        this.eventCallback = eventCallback;
    }

    public void deinit() {
        deinit(this.nativePlayerHandle);
    }

    public native void deinit(long j3);

    public long getMediaParams(int i3) {
        return getMediaParams(this.nativePlayerHandle, i3);
    }

    public native long getMediaParams(long j3, int i3);

    public native long init(String str, boolean z16, int i3, int i16, int i17, Object obj);

    public void initPlayer(String str, boolean z16, int i3, int i16, Surface surface) {
        this.nativePlayerHandle = init(str, z16, 0, i3, i16, surface);
    }

    public void pause() {
        pause(this.nativePlayerHandle);
    }

    public native void pause(long j3);

    public void play() {
        play(this.nativePlayerHandle);
    }

    public native void play(long j3);

    public void seekToPosition(float f16) {
        seekToPosition(this.nativePlayerHandle, f16);
    }

    public native void seekToPosition(long j3, float f16);

    public native void setMediaParams(long j3, int i3, Object obj);

    public void stop() {
        stop(this.nativePlayerHandle);
    }

    public native void stop(long j3);
}

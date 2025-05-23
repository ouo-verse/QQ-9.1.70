package com.tencent.qqmini.sdk.widget.media;

import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;

/* loaded from: classes23.dex */
public class MiniAppVideoPlayerListenerHolder {
    public AbsVideoPlayer.OnCaptureImageListener onCaptureImageListener;
    public AbsVideoPlayer.OnCompletionListener onCompletionListener;
    public AbsVideoPlayer.OnControllerClickListener onControllerClickListener;
    public AbsVideoPlayer.OnErrorListener onErrorListener;
    public AbsVideoPlayer.OnInfoListener onInfoListener;
    public AbsVideoPlayer.OnSeekCompleteListener onSeekCompleteListener;
    public AbsVideoPlayer.OnVideoPreparedListener onVideoPreparedListener;
    public AbsVideoPlayer.OnVideoViewInitListener onVideoViewInitListener;

    /* loaded from: classes23.dex */
    public static class Builder {
        MiniAppVideoPlayerListenerHolder holder = new MiniAppVideoPlayerListenerHolder();

        public MiniAppVideoPlayerListenerHolder build() {
            return this.holder;
        }

        public Builder setOnCaptureImageListener(AbsVideoPlayer.OnCaptureImageListener onCaptureImageListener) {
            this.holder.onCaptureImageListener = onCaptureImageListener;
            return this;
        }

        public Builder setOnCompletionListener(AbsVideoPlayer.OnCompletionListener onCompletionListener) {
            this.holder.onCompletionListener = onCompletionListener;
            return this;
        }

        public Builder setOnControllerClickListener(AbsVideoPlayer.OnControllerClickListener onControllerClickListener) {
            this.holder.onControllerClickListener = onControllerClickListener;
            return this;
        }

        public Builder setOnErrorListener(AbsVideoPlayer.OnErrorListener onErrorListener) {
            this.holder.onErrorListener = onErrorListener;
            return this;
        }

        public Builder setOnInfoListener(AbsVideoPlayer.OnInfoListener onInfoListener) {
            this.holder.onInfoListener = onInfoListener;
            return this;
        }

        public Builder setOnSeekCompleteListener(AbsVideoPlayer.OnSeekCompleteListener onSeekCompleteListener) {
            this.holder.onSeekCompleteListener = onSeekCompleteListener;
            return this;
        }

        public Builder setOnVideoPreparedListener(AbsVideoPlayer.OnVideoPreparedListener onVideoPreparedListener) {
            this.holder.onVideoPreparedListener = onVideoPreparedListener;
            return this;
        }

        public Builder setOnVideoViewInitListener(AbsVideoPlayer.OnVideoViewInitListener onVideoViewInitListener) {
            this.holder.onVideoViewInitListener = onVideoViewInitListener;
            return this;
        }
    }
}

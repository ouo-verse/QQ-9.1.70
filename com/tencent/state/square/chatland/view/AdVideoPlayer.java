package com.tencent.state.square.chatland.view;

import android.media.MediaPlayer;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u0006\u0010\u000f\u001a\u00020\u0007J\u001c\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0007R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/chatland/view/AdVideoPlayer;", "", "textureView", "Landroid/view/TextureView;", "(Landroid/view/TextureView;)V", "completionListener", "Lkotlin/Function0;", "", "mediaPlayer", "Landroid/media/MediaPlayer;", "videoCurrentPosition", "", "getVideoHeight", "getVideoWidth", "initPlayerIfNeed", "pauseVideo", "playVideo", "videoPath", "", "onCompletion", "resumeVideo", "stopVideo", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class AdVideoPlayer {
    private static final String TAG = "AdVideoPlayer";
    private Function0<Unit> completionListener;
    private MediaPlayer mediaPlayer;
    private final TextureView textureView;
    private int videoCurrentPosition;

    public AdVideoPlayer(TextureView textureView) {
        Intrinsics.checkNotNullParameter(textureView, "textureView");
        this.textureView = textureView;
    }

    private final void initPlayerIfNeed() {
        if (this.mediaPlayer == null) {
            try {
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setSurface(new Surface(this.textureView.getSurfaceTexture()));
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.tencent.state.square.chatland.view.AdVideoPlayer$initPlayerIfNeed$$inlined$apply$lambda$1
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public final void onCompletion(MediaPlayer mediaPlayer2) {
                        Function0 function0;
                        function0 = AdVideoPlayer.this.completionListener;
                        if (function0 != null) {
                        }
                    }
                });
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.state.square.chatland.view.AdVideoPlayer$initPlayerIfNeed$1$2
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public final void onPrepared(MediaPlayer mediaPlayer2) {
                        mediaPlayer2.start();
                    }
                });
                Unit unit = Unit.INSTANCE;
                this.mediaPlayer = mediaPlayer;
            } catch (Throwable th5) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, th5.toString(), null, 4, null);
            }
        }
    }

    public final int getVideoHeight() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    public final int getVideoWidth() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    public final void pauseVideo() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        mediaPlayer.pause();
        this.videoCurrentPosition = mediaPlayer.getCurrentPosition();
        SquareBaseKt.getSquareLog().i(TAG, "pauseVideo, currentPosition:" + mediaPlayer.getCurrentPosition());
    }

    public final void playVideo(String videoPath, Function0<Unit> onCompletion) {
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        Intrinsics.checkNotNullParameter(onCompletion, "onCompletion");
        this.completionListener = onCompletion;
        initPlayerIfNeed();
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setDataSource(videoPath);
            mediaPlayer.prepareAsync();
        }
    }

    public final void resumeVideo() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null || mediaPlayer.isPlaying()) {
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "resumeVideo, videoCurrentPosition:" + this.videoCurrentPosition + ", currentPosition:" + mediaPlayer.getCurrentPosition());
        if (this.videoCurrentPosition != 0 && mediaPlayer.getCurrentPosition() == 0) {
            mediaPlayer.seekTo(this.videoCurrentPosition);
            this.videoCurrentPosition = 0;
        }
        mediaPlayer.start();
    }

    public final void stopVideo() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        this.mediaPlayer = null;
        this.completionListener = null;
        SquareBaseKt.getSquareLog().i(TAG, "stopVideo");
    }
}

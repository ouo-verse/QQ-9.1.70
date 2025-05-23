package com.tencent.oskplayer.player;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.videorenderer.OnSurfaceSizeChangedListener;
import com.tencent.oskplayer.videorenderer.TextureSurfaceRenderer;
import com.tencent.oskplayer.videorenderer.VideoTextureRenderer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: classes22.dex */
public class GLTextureMediaPlayer extends SegmentMediaPlayerProxy {
    private static final String LOG_TAG = "GLTextureMediaPlayer";
    private TextureSurfaceRenderer videoRenderer;
    private Surface videoSurface;

    /* loaded from: classes22.dex */
    public static class GLTextureTimeoutException extends TimeoutException {
        public GLTextureTimeoutException(String str) {
            super(str);
        }
    }

    public GLTextureMediaPlayer(IMediaPlayer iMediaPlayer) {
        super(iMediaPlayer);
    }

    public OnSurfaceSizeChangedListener getSurfaceTextureListener() {
        return this.videoRenderer;
    }

    @Override // tv.danmaku.ijk.media.player.MediaPlayerProxy, tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        super.release();
        TextureSurfaceRenderer textureSurfaceRenderer = this.videoRenderer;
        if (textureSurfaceRenderer != null) {
            textureSurfaceRenderer.release();
        }
        Surface surface = this.videoSurface;
        if (surface != null) {
            surface.release();
        }
        this.videoRenderer = null;
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture, int i3, int i16) throws GLTextureTimeoutException {
        TextureSurfaceRenderer textureSurfaceRenderer = this.videoRenderer;
        if (textureSurfaceRenderer != null) {
            textureSurfaceRenderer.release();
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.videoRenderer = new VideoTextureRenderer(countDownLatch, surfaceTexture, i3, i16);
        try {
            countDownLatch.await(800L, TimeUnit.MILLISECONDS);
            SurfaceTexture surfaceTexture2 = this.videoRenderer.getSurfaceTexture();
            if (surfaceTexture2 != null) {
                Surface surface = new Surface(surfaceTexture2);
                this.videoSurface = surface;
                this.mBackEndMediaPlayer.setSurface(surface);
            }
            if (surfaceTexture2 != null) {
                return;
            }
            PlayerUtils.log(6, LOG_TAG, "SurfaceTexture is not available,timeout");
            throw new GLTextureTimeoutException("init VideoTextureRenderer timeout");
        } catch (InterruptedException unused) {
            PlayerUtils.log(6, LOG_TAG, "SurfaceTexture is not available,interrupted");
            throw new GLTextureTimeoutException("init VideoTextureRenderer timeout");
        }
    }
}

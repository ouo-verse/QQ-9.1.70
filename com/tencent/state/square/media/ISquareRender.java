package com.tencent.state.square.media;

import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.MediaCodec;
import android.view.Surface;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001%J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\rH&J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J(\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u001aH\u0016J \u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH&J\u0012\u0010 \u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH&J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020$H&\u00a8\u0006&"}, d2 = {"Lcom/tencent/state/square/media/ISquareRender;", "", "getOutputSurface", "Landroid/view/Surface;", "isDestroying", "", "isSurfaceReady", "onBeforeDecode", "", "videoWidth", "", "videoHeight", "callback", "Lkotlin/Function1;", "onFrameRender", "info", "Landroid/media/MediaCodec$BufferInfo;", "image", "Landroid/media/Image;", "yBuffer", "Ljava/nio/ByteBuffer;", "uvBuffer", "alphaBuffer", "isStart", "rgba", "onOutFormatChanged", "Lcom/tencent/state/square/media/VideoInfo;", "onSurfaceAvailable", "surface", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceDestroyed", "onSurfaceSizeChanged", "setRenderListener", "listener", "Lcom/tencent/state/square/media/ISquareRender$Listener;", "Listener", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface ISquareRender {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static void onFrameRender(ISquareRender iSquareRender, MediaCodec.BufferInfo info, ByteBuffer yBuffer, ByteBuffer uvBuffer, ByteBuffer alphaBuffer) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(yBuffer, "yBuffer");
            Intrinsics.checkNotNullParameter(uvBuffer, "uvBuffer");
            Intrinsics.checkNotNullParameter(alphaBuffer, "alphaBuffer");
        }

        public static void onOutFormatChanged(ISquareRender iSquareRender, VideoInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
        }

        public static void onFrameRender(ISquareRender iSquareRender, MediaCodec.BufferInfo info, boolean z16) {
            Intrinsics.checkNotNullParameter(info, "info");
        }

        public static void onFrameRender(ISquareRender iSquareRender, ByteBuffer rgba) {
            Intrinsics.checkNotNullParameter(rgba, "rgba");
        }
    }

    Surface getOutputSurface();

    boolean isDestroying();

    boolean isSurfaceReady();

    void onBeforeDecode(int videoWidth, int videoHeight, Function1<? super Boolean, Unit> callback);

    void onFrameRender(MediaCodec.BufferInfo info, Image image);

    void onFrameRender(MediaCodec.BufferInfo info, ByteBuffer yBuffer, ByteBuffer uvBuffer, ByteBuffer alphaBuffer);

    void onFrameRender(MediaCodec.BufferInfo info, boolean isStart);

    void onFrameRender(ByteBuffer rgba);

    void onOutFormatChanged(VideoInfo info);

    void onSurfaceAvailable(SurfaceTexture surface, int width, int height);

    void onSurfaceDestroyed(SurfaceTexture surface);

    void onSurfaceSizeChanged(int width, int height);

    void setRenderListener(Listener listener);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/square/media/ISquareRender$Listener;", "", "onRenderError", "", "code", "", "message", "", "onRenderFirstFrame", "square_media_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public interface Listener {
        void onRenderError(int code, String message);

        void onRenderFirstFrame();

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes38.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ void onRenderError$default(Listener listener, int i3, String str, int i16, Object obj) {
                if (obj == null) {
                    if ((i16 & 2) != 0) {
                        str = "";
                    }
                    listener.onRenderError(i3, str);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRenderError");
            }
        }
    }
}

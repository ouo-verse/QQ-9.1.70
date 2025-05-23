package org.tencwebrtc;

import android.graphics.Matrix;
import android.os.Handler;
import android.support.annotation.Nullable;
import java.util.concurrent.Callable;
import org.tencwebrtc.VideoFrame;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TextureBufferImpl implements VideoFrame.TextureBuffer {
    private final int height;

    /* renamed from: id, reason: collision with root package name */
    private final int f423849id;
    private final RefCountDelegate refCountDelegate;
    private final Handler toI420Handler;
    private final Matrix transformMatrix;
    private final VideoFrame.TextureBuffer.Type type;
    private final int unscaledHeight;
    private final int unscaledWidth;
    private final int width;
    private final YuvConverter yuvConverter;

    public TextureBufferImpl(int i3, int i16, VideoFrame.TextureBuffer.Type type, int i17, Matrix matrix, Handler handler, YuvConverter yuvConverter, @Nullable Runnable runnable) {
        this.unscaledWidth = i3;
        this.unscaledHeight = i16;
        this.width = i3;
        this.height = i16;
        this.type = type;
        this.f423849id = i17;
        this.transformMatrix = matrix;
        this.toI420Handler = handler;
        this.yuvConverter = yuvConverter;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ VideoFrame.I420Buffer lambda$toI420$0() throws Exception {
        return this.yuvConverter.convert(this);
    }

    public TextureBufferImpl applyTransformMatrix(Matrix matrix, int i3, int i16) {
        return applyTransformMatrix(matrix, i3, i16, i3, i16);
    }

    @Override // org.tencwebrtc.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i3, int i16, int i17, int i18, int i19, int i26) {
        Matrix matrix = new Matrix();
        matrix.preTranslate(i3 / this.width, (r0 - (i16 + i18)) / this.height);
        matrix.preScale(i17 / this.width, i18 / this.height);
        return applyTransformMatrix(matrix, Math.round((this.unscaledWidth * i17) / this.width), Math.round((this.unscaledHeight * i18) / this.height), i19, i26);
    }

    @Override // org.tencwebrtc.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // org.tencwebrtc.VideoFrame.TextureBuffer
    public int getTextureId() {
        return this.f423849id;
    }

    public Handler getToI420Handler() {
        return this.toI420Handler;
    }

    @Override // org.tencwebrtc.VideoFrame.TextureBuffer
    public Matrix getTransformMatrix() {
        return this.transformMatrix;
    }

    @Override // org.tencwebrtc.VideoFrame.TextureBuffer
    public VideoFrame.TextureBuffer.Type getType() {
        return this.type;
    }

    public int getUnscaledHeight() {
        return this.unscaledHeight;
    }

    public int getUnscaledWidth() {
        return this.unscaledWidth;
    }

    @Override // org.tencwebrtc.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    public YuvConverter getYuvConverter() {
        return this.yuvConverter;
    }

    @Override // org.tencwebrtc.VideoFrame.Buffer, org.tencwebrtc.RefCounted
    public void release() {
        this.refCountDelegate.release();
    }

    @Override // org.tencwebrtc.VideoFrame.Buffer, org.tencwebrtc.RefCounted
    public void retain() {
        this.refCountDelegate.retain();
    }

    @Override // org.tencwebrtc.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        return (VideoFrame.I420Buffer) ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new Callable() { // from class: org.tencwebrtc.ab
            @Override // java.util.concurrent.Callable
            public final Object call() {
                VideoFrame.I420Buffer lambda$toI420$0;
                lambda$toI420$0 = TextureBufferImpl.this.lambda$toI420$0();
                return lambda$toI420$0;
            }
        });
    }

    private TextureBufferImpl applyTransformMatrix(Matrix matrix, int i3, int i16, int i17, int i18) {
        Matrix matrix2 = new Matrix(this.transformMatrix);
        matrix2.preConcat(matrix);
        retain();
        return new TextureBufferImpl(i3, i16, i17, i18, this.type, this.f423849id, matrix2, this.toI420Handler, this.yuvConverter, new Runnable() { // from class: org.tencwebrtc.ac
            @Override // java.lang.Runnable
            public final void run() {
                TextureBufferImpl.this.release();
            }
        });
    }

    TextureBufferImpl(int i3, int i16, int i17, int i18, VideoFrame.TextureBuffer.Type type, int i19, Matrix matrix, Handler handler, YuvConverter yuvConverter, @Nullable Runnable runnable) {
        this.unscaledWidth = i3;
        this.unscaledHeight = i16;
        this.width = i17;
        this.height = i18;
        this.type = type;
        this.f423849id = i19;
        this.transformMatrix = matrix;
        this.toI420Handler = handler;
        this.yuvConverter = yuvConverter;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }
}

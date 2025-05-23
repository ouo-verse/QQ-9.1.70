package org.tencwebrtc;

import android.graphics.Matrix;
import android.graphics.Point;
import android.opengl.GLES20;
import android.support.annotation.Nullable;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;
import java.nio.ByteBuffer;
import org.tencwebrtc.RendererCommon;
import org.tencwebrtc.VideoFrame;

/* compiled from: P */
/* loaded from: classes29.dex */
public class VideoFrameDrawer {
    public static final String TAG = "VideoFrameDrawer";
    static final float[] srcPoints = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};

    @Nullable
    private VideoFrame lastI420Frame;
    private int renderHeight;
    private int renderWidth;
    private final float[] dstPoints = new float[6];
    private final Point renderSize = new Point();
    private final YuvUploader yuvUploader = new YuvUploader(null);
    private final Matrix renderMatrix = new Matrix();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: org.tencwebrtc.VideoFrameDrawer$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$tencwebrtc$VideoFrame$TextureBuffer$Type;

        static {
            int[] iArr = new int[VideoFrame.TextureBuffer.Type.values().length];
            $SwitchMap$org$tencwebrtc$VideoFrame$TextureBuffer$Type = iArr;
            try {
                iArr[VideoFrame.TextureBuffer.Type.OES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$tencwebrtc$VideoFrame$TextureBuffer$Type[VideoFrame.TextureBuffer.Type.RGB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class YuvUploader {

        @Nullable
        private ByteBuffer copyBuffer;

        @Nullable
        private int[] yuvTextures;

        YuvUploader() {
        }

        @Nullable
        public int[] getYuvTextures() {
            return this.yuvTextures;
        }

        public void release() {
            this.copyBuffer = null;
            int[] iArr = this.yuvTextures;
            if (iArr != null) {
                GLES20.glDeleteTextures(3, iArr, 0);
                this.yuvTextures = null;
            }
        }

        @Nullable
        public int[] uploadFromBuffer(VideoFrame.I420Buffer i420Buffer) {
            return uploadYuvData(i420Buffer.getWidth(), i420Buffer.getHeight(), new int[]{i420Buffer.getStrideY(), i420Buffer.getStrideU(), i420Buffer.getStrideV()}, new ByteBuffer[]{i420Buffer.getDataY(), i420Buffer.getDataU(), i420Buffer.getDataV()});
        }

        @Nullable
        public int[] uploadYuvData(int i3, int i16, int[] iArr, ByteBuffer[] byteBufferArr) {
            ByteBuffer byteBuffer;
            ByteBuffer byteBuffer2;
            int i17 = i3 / 2;
            int[] iArr2 = {i3, i17, i17};
            int i18 = i16 / 2;
            int[] iArr3 = {i16, i18, i18};
            int i19 = 0;
            for (int i26 = 0; i26 < 3; i26++) {
                int i27 = iArr[i26];
                int i28 = iArr2[i26];
                if (i27 > i28) {
                    i19 = Math.max(i19, i28 * iArr3[i26]);
                }
            }
            if (i19 > 0 && ((byteBuffer2 = this.copyBuffer) == null || byteBuffer2.capacity() < i19)) {
                this.copyBuffer = ByteBuffer.allocateDirect(i19);
            }
            if (this.yuvTextures == null) {
                this.yuvTextures = new int[3];
                for (int i29 = 0; i29 < 3; i29++) {
                    this.yuvTextures[i29] = GlUtil.generateTexture(GLSLRender.GL_TEXTURE_2D);
                }
            }
            for (int i36 = 0; i36 < 3; i36++) {
                GLES20.glActiveTexture(33984 + i36);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.yuvTextures[i36]);
                int i37 = iArr[i36];
                int i38 = iArr2[i36];
                if (i37 == i38) {
                    byteBuffer = byteBufferArr[i36];
                } else {
                    YuvHelper.copyPlane(byteBufferArr[i36], i37, this.copyBuffer, i38, i38, iArr3[i36]);
                    byteBuffer = this.copyBuffer;
                }
                GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, MonetPacketDescriptor.MonetDataFormat.R8, iArr2[i36], iArr3[i36], 0, MonetPacketDescriptor.MonetDataFormat.R8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, byteBuffer);
            }
            return this.yuvTextures;
        }

        /* synthetic */ YuvUploader(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private void calculateTransformedRenderSize(int i3, int i16, @Nullable Matrix matrix) {
        if (matrix == null) {
            this.renderWidth = i3;
            this.renderHeight = i16;
            return;
        }
        matrix.mapPoints(this.dstPoints, srcPoints);
        for (int i17 = 0; i17 < 3; i17++) {
            float[] fArr = this.dstPoints;
            int i18 = i17 * 2;
            int i19 = i18 + 0;
            fArr[i19] = fArr[i19] * i3;
            int i26 = i18 + 1;
            fArr[i26] = fArr[i26] * i16;
        }
        float[] fArr2 = this.dstPoints;
        this.renderWidth = distance(fArr2[0], fArr2[1], fArr2[2], fArr2[3]);
        float[] fArr3 = this.dstPoints;
        this.renderHeight = distance(fArr3[0], fArr3[1], fArr3[4], fArr3[5]);
    }

    private static int distance(float f16, float f17, float f18, float f19) {
        return (int) Math.round(Math.hypot(f18 - f16, f19 - f17));
    }

    public static void drawTexture(RendererCommon.GlDrawer glDrawer, VideoFrame.TextureBuffer textureBuffer, Matrix matrix, int i3, int i16, int i17, int i18, int i19, int i26) {
        Matrix matrix2 = new Matrix(textureBuffer.getTransformMatrix());
        matrix2.preConcat(matrix);
        float[] convertMatrixFromAndroidGraphicsMatrix = RendererCommon.convertMatrixFromAndroidGraphicsMatrix(matrix2);
        int i27 = AnonymousClass1.$SwitchMap$org$tencwebrtc$VideoFrame$TextureBuffer$Type[textureBuffer.getType().ordinal()];
        if (i27 != 1) {
            if (i27 == 2) {
                glDrawer.drawRgb(textureBuffer.getTextureId(), convertMatrixFromAndroidGraphicsMatrix, i3, i16, i17, i18, i19, i26);
                return;
            }
            throw new RuntimeException("Unknown texture type.");
        }
        glDrawer.drawOes(textureBuffer.getTextureId(), convertMatrixFromAndroidGraphicsMatrix, i3, i16, i17, i18, i19, i26);
    }

    public void drawFrame(VideoFrame videoFrame, RendererCommon.GlDrawer glDrawer) {
        drawFrame(videoFrame, glDrawer, null);
    }

    public VideoFrame.Buffer prepareBufferForViewportSize(VideoFrame.Buffer buffer, int i3, int i16) {
        buffer.retain();
        return buffer;
    }

    public void release() {
        this.yuvUploader.release();
        this.lastI420Frame = null;
    }

    public void drawFrame(VideoFrame videoFrame, RendererCommon.GlDrawer glDrawer, Matrix matrix) {
        drawFrame(videoFrame, glDrawer, matrix, 0, 0, videoFrame.getRotatedWidth(), videoFrame.getRotatedHeight());
    }

    public void drawFrame(VideoFrame videoFrame, RendererCommon.GlDrawer glDrawer, @Nullable Matrix matrix, int i3, int i16, int i17, int i18) {
        calculateTransformedRenderSize(videoFrame.getRotatedWidth(), videoFrame.getRotatedHeight(), matrix);
        if (this.renderWidth > 0 && this.renderHeight > 0) {
            boolean z16 = videoFrame.getBuffer() instanceof VideoFrame.TextureBuffer;
            this.renderMatrix.reset();
            this.renderMatrix.preTranslate(0.5f, 0.5f);
            if (!z16) {
                this.renderMatrix.preScale(1.0f, -1.0f);
            }
            this.renderMatrix.preRotate(videoFrame.getRotation());
            this.renderMatrix.preTranslate(-0.5f, -0.5f);
            if (matrix != null) {
                this.renderMatrix.preConcat(matrix);
            }
            if (z16) {
                this.lastI420Frame = null;
                drawTexture(glDrawer, (VideoFrame.TextureBuffer) videoFrame.getBuffer(), this.renderMatrix, this.renderWidth, this.renderHeight, i3, i16, i17, i18);
                return;
            }
            if (videoFrame != this.lastI420Frame) {
                this.lastI420Frame = videoFrame;
                VideoFrame.I420Buffer i420 = videoFrame.getBuffer().toI420();
                this.yuvUploader.uploadFromBuffer(i420);
                i420.release();
            }
            glDrawer.drawYuv(this.yuvUploader.getYuvTextures(), RendererCommon.convertMatrixFromAndroidGraphicsMatrix(this.renderMatrix), this.renderWidth, this.renderHeight, i3, i16, i17, i18);
            return;
        }
        Logging.w(TAG, "Illegal frame size: " + this.renderWidth + HippyTKDListViewAdapter.X + this.renderHeight);
    }
}

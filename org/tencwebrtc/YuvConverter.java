package org.tencwebrtc;

import android.graphics.Matrix;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import java.nio.ByteBuffer;
import org.tencwebrtc.GlGenericDrawer;
import org.tencwebrtc.ThreadUtils;
import org.tencwebrtc.VideoFrame;

/* compiled from: P */
/* loaded from: classes29.dex */
public class YuvConverter {
    private static final String FRAGMENT_SHADER = "uniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 1.5 * xUnit).rgb);\n}\n";
    private final GlGenericDrawer drawer;
    private final GlTextureFrameBuffer i420TextureFrameBuffer;
    private final ShaderCallbacks shaderCallbacks;
    private final ThreadUtils.ThreadChecker threadChecker;
    private final VideoFrameDrawer videoFrameDrawer;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class ShaderCallbacks implements GlGenericDrawer.ShaderCallbacks {
        private float[] coeffs;
        private int coeffsLoc;
        private float stepSize;
        private int xUnitLoc;
        private static final float[] yCoeffs = {0.256788f, 0.504129f, 0.0979059f, 0.0627451f};
        private static final float[] uCoeffs = {-0.148223f, -0.290993f, 0.439216f, 0.501961f};
        private static final float[] vCoeffs = {0.439216f, -0.367788f, -0.0714274f, 0.501961f};

        ShaderCallbacks() {
        }

        @Override // org.tencwebrtc.GlGenericDrawer.ShaderCallbacks
        public void onNewShader(GlShader glShader) {
            this.xUnitLoc = glShader.getUniformLocation("xUnit");
            this.coeffsLoc = glShader.getUniformLocation("coeffs");
        }

        @Override // org.tencwebrtc.GlGenericDrawer.ShaderCallbacks
        public void onPrepareShader(GlShader glShader, float[] fArr, int i3, int i16, int i17, int i18) {
            GLES20.glUniform4fv(this.coeffsLoc, 1, this.coeffs, 0);
            int i19 = this.xUnitLoc;
            float f16 = this.stepSize;
            float f17 = i3;
            GLES20.glUniform2f(i19, (fArr[0] * f16) / f17, (f16 * fArr[1]) / f17);
        }

        public void setPlaneU() {
            this.coeffs = uCoeffs;
            this.stepSize = 2.0f;
        }

        public void setPlaneV() {
            this.coeffs = vCoeffs;
            this.stepSize = 2.0f;
        }

        public void setPlaneY() {
            this.coeffs = yCoeffs;
            this.stepSize = 1.0f;
        }
    }

    public YuvConverter() {
        this(new VideoFrameDrawer());
    }

    public VideoFrame.I420Buffer convert(VideoFrame.TextureBuffer textureBuffer) {
        this.threadChecker.checkIsOnValidThread();
        VideoFrame.TextureBuffer textureBuffer2 = (VideoFrame.TextureBuffer) this.videoFrameDrawer.prepareBufferForViewportSize(textureBuffer, textureBuffer.getWidth(), textureBuffer.getHeight());
        int width = textureBuffer2.getWidth();
        int height = textureBuffer2.getHeight();
        int i3 = ((width + 7) / 8) * 8;
        int i16 = (height + 1) / 2;
        int i17 = height + i16;
        final ByteBuffer nativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer(i3 * i17);
        int i18 = i3 / 4;
        Matrix matrix = new Matrix();
        matrix.preTranslate(0.5f, 0.5f);
        matrix.preScale(1.0f, -1.0f);
        matrix.preTranslate(-0.5f, -0.5f);
        this.i420TextureFrameBuffer.setSize(i18, i17);
        GLES20.glBindFramebuffer(36160, this.i420TextureFrameBuffer.getFrameBufferId());
        GlUtil.checkNoGLES2Error("glBindFramebuffer");
        this.shaderCallbacks.setPlaneY();
        VideoFrameDrawer.drawTexture(this.drawer, textureBuffer2, matrix, width, height, 0, 0, i18, height);
        this.shaderCallbacks.setPlaneU();
        int i19 = i18 / 2;
        VideoFrameDrawer.drawTexture(this.drawer, textureBuffer2, matrix, width, height, 0, height, i19, i16);
        this.shaderCallbacks.setPlaneV();
        VideoFrameDrawer.drawTexture(this.drawer, textureBuffer2, matrix, width, height, i19, height, i19, i16);
        GLES20.glReadPixels(0, 0, this.i420TextureFrameBuffer.getWidth(), this.i420TextureFrameBuffer.getHeight(), 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, nativeAllocateByteBuffer);
        GlUtil.checkNoGLES2Error("YuvConverter.convert");
        GLES20.glBindFramebuffer(36160, 0);
        int i26 = (i3 * height) + 0;
        int i27 = i3 / 2;
        int i28 = i26 + i27;
        nativeAllocateByteBuffer.position(0);
        nativeAllocateByteBuffer.limit(i26);
        ByteBuffer slice = nativeAllocateByteBuffer.slice();
        nativeAllocateByteBuffer.position(i26);
        int i29 = ((i16 - 1) * i3) + i27;
        nativeAllocateByteBuffer.limit(i26 + i29);
        ByteBuffer slice2 = nativeAllocateByteBuffer.slice();
        nativeAllocateByteBuffer.position(i28);
        nativeAllocateByteBuffer.limit(i28 + i29);
        ByteBuffer slice3 = nativeAllocateByteBuffer.slice();
        textureBuffer2.release();
        return JavaI420Buffer.wrap(width, height, slice, i3, slice2, i3, slice3, i3, new Runnable() { // from class: org.tencwebrtc.ao
            @Override // java.lang.Runnable
            public final void run() {
                JniCommon.nativeFreeByteBuffer(nativeAllocateByteBuffer);
            }
        });
    }

    public void release() {
        this.threadChecker.checkIsOnValidThread();
        this.drawer.release();
        this.i420TextureFrameBuffer.release();
        this.videoFrameDrawer.release();
        this.threadChecker.detachThread();
    }

    public YuvConverter(VideoFrameDrawer videoFrameDrawer) {
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.threadChecker = threadChecker;
        this.i420TextureFrameBuffer = new GlTextureFrameBuffer(6408);
        ShaderCallbacks shaderCallbacks = new ShaderCallbacks();
        this.shaderCallbacks = shaderCallbacks;
        this.drawer = new GlGenericDrawer(FRAGMENT_SHADER, shaderCallbacks);
        this.videoFrameDrawer = videoFrameDrawer;
        threadChecker.detachThread();
    }
}

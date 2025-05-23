package com.tencent.av.video.effect.core.qqavimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;
import com.tencent.av.video.effect.core.qqavimage.util.TextureRotationUtil;
import com.tencent.filter.GLSLRender;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import java.util.Scanner;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageFilter {
    public static final String NO_FILTER_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
    public static final String NO_FILTER_VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
    protected FloatBuffer cubeBuffer;
    private final String mFragmentShader;
    protected int mGLAttribPosition;
    protected int mGLAttribTextureCoordinate;
    protected int mGLProgId;
    protected int mGLUniformTexture;
    private boolean mIsInitialized;
    protected int mOutputHeight;
    protected int mOutputWidth;
    protected String mQQAVEffectID;
    protected String mQQAVEffectName;
    protected int mQQAVEffectType;
    private final LinkedList<Runnable> mRunOnDraw;
    private final String mVertexShader;
    protected FloatBuffer textureBuffer;

    public QQAVImageFilter() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", NO_FILTER_FRAGMENT_SHADER);
        this.mQQAVEffectType = -1;
        setBufferCubeTexture();
    }

    public static String convertStreamToString(InputStream inputStream) {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        if (useDelimiter.hasNext()) {
            return useDelimiter.next();
        }
        return "";
    }

    public static String loadShader(String str, Context context) {
        try {
            InputStream open = context.getAssets().open(str);
            String convertStreamToString = convertStreamToString(open);
            open.close();
            return convertStreamToString;
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public final void destroy() {
        this.mIsInitialized = false;
        GLES20.glDeleteProgram(this.mGLProgId);
        onDestroy();
    }

    public int getAttribPosition() {
        return this.mGLAttribPosition;
    }

    public int getAttribTextureCoordinate() {
        return this.mGLAttribTextureCoordinate;
    }

    public int getOutputHeight() {
        return this.mOutputHeight;
    }

    public int getOutputWidth() {
        return this.mOutputWidth;
    }

    public int getProgram() {
        return this.mGLProgId;
    }

    public String getQQAVEffectID() {
        return this.mQQAVEffectID;
    }

    public String getQQAVEffectName() {
        return this.mQQAVEffectName;
    }

    public int getQQAVEffectType() {
        return this.mQQAVEffectType;
    }

    public int getUniformTexture() {
        return this.mGLUniformTexture;
    }

    public final void init() {
        if (!this.mIsInitialized) {
            onInit();
            this.mIsInitialized = true;
            onInitialized();
        }
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public void onDraw(int i3, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLES20.glUseProgram(this.mGLProgId);
        runPendingOnDrawTasks();
        if (!this.mIsInitialized) {
            return;
        }
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.mGLAttribPosition, 2, 5126, false, 0, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(this.mGLAttribPosition);
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.mGLAttribTextureCoordinate, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoordinate);
        if (i3 != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
            GLES20.glUniform1i(this.mGLUniformTexture, 0);
        }
        onDrawArraysPre();
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.mGLAttribPosition);
        GLES20.glDisableVertexAttribArray(this.mGLAttribTextureCoordinate);
        onDrawArraysAfter();
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
    }

    public void onDraw2(int i3, int i16) {
        if (i16 != -1 && i3 != -1) {
            GLES20.glBindFramebuffer(36160, i16);
            GLES20.glViewport(0, 0, getOutputWidth(), getOutputHeight());
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16640);
            onDraw(i3, this.cubeBuffer, this.textureBuffer);
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    public void onInit() {
        int loadProgram = OpenGlUtils.loadProgram(this.mVertexShader, this.mFragmentShader);
        this.mGLProgId = loadProgram;
        this.mGLAttribPosition = GLES20.glGetAttribLocation(loadProgram, "position");
        this.mGLUniformTexture = GLES20.glGetUniformLocation(this.mGLProgId, "inputImageTexture");
        this.mGLAttribTextureCoordinate = GLES20.glGetAttribLocation(this.mGLProgId, "inputTextureCoordinate");
        this.mIsInitialized = true;
    }

    public void onOutputSizeChanged(int i3, int i16) {
        if (this.mOutputWidth != i3 || this.mOutputHeight != i16) {
            this.mOutputWidth = i3;
            this.mOutputHeight = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runOnDraw(Runnable runnable) {
        synchronized (this.mRunOnDraw) {
            this.mRunOnDraw.addLast(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runPendingOnDrawTasks() {
        while (!this.mRunOnDraw.isEmpty()) {
            this.mRunOnDraw.removeFirst().run();
        }
    }

    public void setBufferCubeTexture() {
        float[] fArr = OpenGlUtils.CUBE8;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.cubeBuffer = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        float[] fArr2 = TextureRotationUtil.TEXTURE_NO_ROTATION2;
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.textureBuffer = asFloatBuffer2;
        asFloatBuffer2.put(fArr2).position(0);
    }

    public void setFloat(final int i3, final float f16) {
        runOnDraw(new Runnable() { // from class: com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter.2
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform1f(i3, f16);
            }
        });
    }

    public void setInteger(final int i3, final int i16) {
        runOnDraw(new Runnable() { // from class: com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter.1
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform1i(i3, i16);
            }
        });
    }

    public void setPoint(final int i3, final PointF pointF) {
        runOnDraw(new Runnable() { // from class: com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter.3
            @Override // java.lang.Runnable
            public void run() {
                PointF pointF2 = pointF;
                GLES20.glUniform2fv(i3, 1, new float[]{pointF2.x, pointF2.y}, 0);
            }
        });
    }

    public void setQQAVEffectID(String str) {
        this.mQQAVEffectID = str;
    }

    public void setQQAVEffectName(String str) {
        this.mQQAVEffectName = str;
    }

    public void setQQAVEffectType(int i3) {
        this.mQQAVEffectType = i3;
    }

    public QQAVImageFilter(String str) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", str);
        this.mQQAVEffectType = -1;
        setBufferCubeTexture();
    }

    public QQAVImageFilter(String str, String str2) {
        this.mQQAVEffectID = null;
        this.mQQAVEffectName = null;
        this.mIsInitialized = false;
        this.mRunOnDraw = new LinkedList<>();
        this.mVertexShader = str;
        this.mFragmentShader = str2;
        this.mQQAVEffectType = -1;
        setBufferCubeTexture();
    }

    public void onDestroy() {
    }

    protected void onDrawArraysAfter() {
    }

    protected void onDrawArraysPre() {
    }

    public void onInitialized() {
    }

    public void setBitmap(int i3, Bitmap bitmap) {
    }
}

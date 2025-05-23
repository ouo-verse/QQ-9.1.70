package com.tencent.av.video.effect.core.qqavimage;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;
import com.tencent.av.video.effect.core.qqavimage.util.TextureRotationUtil;
import com.tencent.filter.GLSLRender;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageFilterGroup extends QQAVImageFilter {
    protected List<QQAVImageFilter> mFilters;
    private int[] mFrameBufferTextures;
    private int[] mFrameBuffers;
    private final FloatBuffer mGLCubeBuffer;
    private final FloatBuffer mGLTextureBuffer;
    private final FloatBuffer mGLTextureFlipBuffer;
    protected List<QQAVImageFilter> mMergedFilters;

    public QQAVImageFilterGroup() {
        this(null);
    }

    private void destroyFramebuffers() {
        int[] iArr = this.mFrameBufferTextures;
        if (iArr != null) {
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            this.mFrameBufferTextures = null;
        }
        int[] iArr2 = this.mFrameBuffers;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
            this.mFrameBuffers = null;
        }
    }

    public void addFilter(QQAVImageFilter qQAVImageFilter) {
        if (qQAVImageFilter == null) {
            return;
        }
        this.mFilters.add(qQAVImageFilter);
        updateMergedFilters();
    }

    public List<QQAVImageFilter> getFilters() {
        return this.mFilters;
    }

    public List<QQAVImageFilter> getMergedFilters() {
        return this.mMergedFilters;
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDestroy() {
        destroyFramebuffers();
        Iterator<QQAVImageFilter> it = this.mFilters.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        super.onDestroy();
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    @SuppressLint({"WrongCall"})
    public void onDraw(int i3, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        List<QQAVImageFilter> list;
        boolean z16;
        FloatBuffer floatBuffer3;
        runPendingOnDrawTasks();
        if (isInitialized() && this.mFrameBuffers != null && this.mFrameBufferTextures != null && (list = this.mMergedFilters) != null) {
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                QQAVImageFilter qQAVImageFilter = this.mMergedFilters.get(i16);
                int i17 = size - 1;
                if (i16 < i17) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i16]);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                }
                if (i16 == 0) {
                    qQAVImageFilter.onDraw(i3, floatBuffer, floatBuffer2);
                } else if (i16 == i17) {
                    FloatBuffer floatBuffer4 = this.mGLCubeBuffer;
                    if (size % 2 == 0) {
                        floatBuffer3 = this.mGLTextureFlipBuffer;
                    } else {
                        floatBuffer3 = this.mGLTextureBuffer;
                    }
                    qQAVImageFilter.onDraw(i3, floatBuffer4, floatBuffer3);
                } else {
                    qQAVImageFilter.onDraw(i3, this.mGLCubeBuffer, this.mGLTextureBuffer);
                }
                if (z16) {
                    GLES20.glBindFramebuffer(36160, 0);
                    i3 = this.mFrameBufferTextures[i16];
                }
            }
        }
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDraw2(int i3, int i16) {
        List<QQAVImageFilter> list;
        boolean z16;
        runPendingOnDrawTasks();
        if (isInitialized() && this.mMergedFilters.size() == 1) {
            QQAVImageFilter qQAVImageFilter = this.mMergedFilters.get(0);
            GLES20.glBindFramebuffer(36160, i16);
            GLES20.glViewport(0, 0, qQAVImageFilter.getOutputWidth(), qQAVImageFilter.getOutputHeight());
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16640);
            qQAVImageFilter.onDraw(i3, this.cubeBuffer, this.textureBuffer);
            GLES20.glBindFramebuffer(36160, 0);
            return;
        }
        if (isInitialized() && this.mFrameBuffers != null && this.mFrameBufferTextures != null && (list = this.mMergedFilters) != null) {
            int size = list.size();
            for (int i17 = 0; i17 < size; i17++) {
                QQAVImageFilter qQAVImageFilter2 = this.mMergedFilters.get(i17);
                int i18 = size - 1;
                if (i17 < i18) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i17]);
                    GLES20.glViewport(0, 0, qQAVImageFilter2.getOutputWidth(), qQAVImageFilter2.getOutputHeight());
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glClear(16640);
                }
                if (i17 == 0) {
                    qQAVImageFilter2.onDraw(i3, this.cubeBuffer, this.textureBuffer);
                } else if (i17 == i18) {
                    GLES20.glBindFramebuffer(36160, i16);
                    GLES20.glViewport(0, 0, qQAVImageFilter2.getOutputWidth(), qQAVImageFilter2.getOutputHeight());
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glClear(16640);
                    qQAVImageFilter2.onDraw(i3, this.cubeBuffer, this.textureBuffer);
                    GLES20.glBindFramebuffer(36160, 0);
                } else {
                    qQAVImageFilter2.onDraw(i3, this.cubeBuffer, this.textureBuffer);
                }
                if (z16) {
                    GLES20.glBindFramebuffer(36160, 0);
                    i3 = this.mFrameBufferTextures[i17];
                }
            }
        }
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        Iterator<QQAVImageFilter> it = this.mFilters.iterator();
        while (it.hasNext()) {
            it.next().init();
        }
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onOutputSizeChanged(int i3, int i16) {
        super.onOutputSizeChanged(i3, i16);
        if (this.mFrameBuffers != null) {
            destroyFramebuffers();
        }
        int size = this.mFilters.size();
        for (int i17 = 0; i17 < size; i17++) {
            this.mFilters.get(i17).onOutputSizeChanged(i3, i16);
        }
        List<QQAVImageFilter> list = this.mMergedFilters;
        if (list != null && list.size() > 0) {
            int i18 = 1;
            int size2 = this.mMergedFilters.size() - 1;
            this.mFrameBuffers = new int[size2];
            this.mFrameBufferTextures = new int[size2];
            int i19 = 0;
            while (i19 < size2) {
                GLES20.glGenFramebuffers(i18, this.mFrameBuffers, i19);
                GLES20.glGenTextures(i18, this.mFrameBufferTextures, i19);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mFrameBufferTextures[i19]);
                GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
                GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i19]);
                GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.mFrameBufferTextures[i19], 0);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
                GLES20.glBindFramebuffer(36160, 0);
                i19++;
                i18 = 1;
            }
        }
    }

    public void updateMergedFilters() {
        if (this.mFilters == null) {
            return;
        }
        List<QQAVImageFilter> list = this.mMergedFilters;
        if (list == null) {
            this.mMergedFilters = new ArrayList();
        } else {
            list.clear();
        }
        for (QQAVImageFilter qQAVImageFilter : this.mFilters) {
            if (qQAVImageFilter instanceof QQAVImageFilterGroup) {
                QQAVImageFilterGroup qQAVImageFilterGroup = (QQAVImageFilterGroup) qQAVImageFilter;
                qQAVImageFilterGroup.updateMergedFilters();
                List<QQAVImageFilter> mergedFilters = qQAVImageFilterGroup.getMergedFilters();
                if (mergedFilters != null && !mergedFilters.isEmpty()) {
                    this.mMergedFilters.addAll(mergedFilters);
                }
            } else {
                this.mMergedFilters.add(qQAVImageFilter);
            }
        }
    }

    public QQAVImageFilterGroup(List<QQAVImageFilter> list) {
        this.mFilters = list;
        if (list == null) {
            this.mFilters = new ArrayList();
        } else {
            updateMergedFilters();
        }
        float[] fArr = OpenGlUtils.CUBE8;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLCubeBuffer = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        float[] fArr2 = TextureRotationUtil.TEXTURE_NO_ROTATION2;
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLTextureBuffer = asFloatBuffer2;
        asFloatBuffer2.put(fArr2).position(0);
        float[] rotation = TextureRotationUtil.getRotation(0, false, true);
        FloatBuffer asFloatBuffer3 = ByteBuffer.allocateDirect(rotation.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLTextureFlipBuffer = asFloatBuffer3;
        asFloatBuffer3.put(rotation).position(0);
    }
}

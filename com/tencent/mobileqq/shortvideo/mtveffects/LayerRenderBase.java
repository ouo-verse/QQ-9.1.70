package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class LayerRenderBase {
    protected int mHeight;
    private int mMaterialHeight;
    private HashMap<Integer, RectF> mMaterialMap = new HashMap<>();
    private int mMaterialTextureID = -1;
    private int mMaterialWidth;
    protected int mWidth;

    public static void clearColorBuffer(RenderBuffer renderBuffer, int i3) {
        if (renderBuffer == null) {
            return;
        }
        renderBuffer.bind();
        GLES20.glClearColor(getRed(i3), getGreen(i3), getBlue(i3), getAlpha(i3));
        GLES20.glClear(16384);
        renderBuffer.unbind();
    }

    public static float getAlpha(int i3) {
        return (((i3 >> 24) & 255) * 1.0f) / 255.0f;
    }

    public static float getBlue(int i3) {
        return ((i3 & 255) * 1.0f) / 255.0f;
    }

    public static float getGreen(int i3) {
        return (((i3 >> 8) & 255) * 1.0f) / 255.0f;
    }

    public static float getRed(int i3) {
        return (((i3 >> 16) & 255) * 1.0f) / 255.0f;
    }

    public static void releaseRenderBuffer(RenderBuffer renderBuffer) {
        if (renderBuffer == null) {
            return;
        }
        if (renderBuffer.getTexId() >= 0) {
            GlUtil.deleteTexture(renderBuffer.getTexId());
            renderBuffer.setTexId(0);
        }
        renderBuffer.destroy();
    }

    public void addMaterial(int i3, RectF rectF) {
        this.mMaterialMap.put(Integer.valueOf(i3), rectF);
    }

    public int getHeight() {
        return this.mHeight;
    }

    public RectF getMaterialArea(int i3) {
        return this.mMaterialMap.get(Integer.valueOf(i3));
    }

    public int getMaterialHeight() {
        return this.mMaterialHeight;
    }

    public int getMaterialTextureID() {
        return this.mMaterialTextureID;
    }

    public int getMaterialWidth() {
        return this.mMaterialWidth;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void onSurfaceChanged(int i3, int i16) {
        this.mWidth = i3;
        this.mHeight = i16;
    }

    public void onSurfaceDestroy() {
        this.mMaterialMap.clear();
    }

    public int process(RenderBuffer renderBuffer, int i3, float[] fArr, float[] fArr2) {
        return -1;
    }

    public void removeAllMaterials() {
        this.mMaterialMap.clear();
    }

    public void removeMaterial(int i3) {
        this.mMaterialMap.remove(Integer.valueOf(i3));
    }

    public void setMaterialTexture(int i3, int i16, int i17) {
        this.mMaterialTextureID = i3;
        this.mMaterialWidth = i16;
        this.mMaterialHeight = i17;
    }

    public void onMusicScale(float f16) {
    }
}

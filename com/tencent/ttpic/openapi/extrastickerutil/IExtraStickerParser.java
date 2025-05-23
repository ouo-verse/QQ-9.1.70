package com.tencent.ttpic.openapi.extrastickerutil;

import android.graphics.Bitmap;
import android.opengl.EGLContext;

/* loaded from: classes27.dex */
public interface IExtraStickerParser {
    public static final int RESULT_AS_BITMAP = 1;
    public static final int RESULT_AS_TEXTURE = 2;

    boolean clear();

    int getResultType();

    void initInGLThread(int i3, String str, String str2);

    boolean prepare(String str, String str2);

    void reset();

    boolean setSize(int i3, int i16);

    Bitmap updateBitmap(float f16);

    int updateTexture(int i3, float f16, EGLContext eGLContext);
}

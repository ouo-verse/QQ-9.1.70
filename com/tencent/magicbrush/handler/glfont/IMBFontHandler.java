package com.tencent.magicbrush.handler.glfont;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import java.nio.FloatBuffer;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public interface IMBFontHandler {
    boolean checkAndFlushClearSignal();

    int[] checkAndFlushDirtySignal();

    FloatBuffer drawText(String str);

    void enableStroke(boolean z16);

    Bitmap getBitmapAtlas();

    float getTextLineHeight(String str);

    void init(int i3, int i16);

    String loadFont(String str);

    byte[] loadFontData(String str);

    float measureText(String str);

    void release();

    void setStrokeWidth(float f16);

    void useFont(String str, String str2, float f16, boolean z16, boolean z17);
}

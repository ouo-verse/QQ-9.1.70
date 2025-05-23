package com.github.henryye.nativeiv.bitmap;

import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class NativeBitmapStruct {

    @Keep
    public int glFormat;

    @Keep
    public int glType;

    @Keep
    public int height;

    @Keep
    public long ptr;

    @Keep
    public int width;

    /* compiled from: P */
    @Keep
    /* loaded from: classes2.dex */
    public interface GLFormat {
        public static final int GL_ALPHA = 6406;
        public static final int GL_RGB = 6407;
        public static final int GL_RGBA = 6408;
    }

    /* compiled from: P */
    @Keep
    /* loaded from: classes2.dex */
    public interface GLType {
        public static final int GL_UNSIGNED_BYTE = 5121;
        public static final int GL_UNSIGNED_SHORT_4_4_4_4 = 32819;
        public static final int GL_UNSIGNED_SHORT_5_5_5_1 = 32820;
        public static final int GL_UNSIGNED_SHORT_5_6_5 = 33635;
    }
}

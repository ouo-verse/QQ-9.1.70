package com.tencent.liteav.videobase.base;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface GLConstants {

    /* renamed from: a, reason: collision with root package name */
    public static final float[] f119219a = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: b, reason: collision with root package name */
    public static final float[] f119220b = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: c, reason: collision with root package name */
    public static final float[] f119221c = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: d, reason: collision with root package name */
    public static final float[] f119222d = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: e, reason: collision with root package name */
    public static final float[] f119223e = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: f, reason: collision with root package name */
    public static final float[] f119224f = {1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: g, reason: collision with root package name */
    public static final float[] f119225g = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: h, reason: collision with root package name */
    public static final float[] f119226h = {1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum ColorRange {
        UNKNOWN(0),
        VIDEO_RANGE(1),
        FULL_RANGE(2);

        private final int mJniValue;

        ColorRange(int i3) {
            this.mJniValue = i3;
        }

        public static ColorRange a(int i3) {
            for (ColorRange colorRange : values()) {
                if (colorRange.mJniValue == i3) {
                    return colorRange;
                }
            }
            return UNKNOWN;
        }

        public final int getValue() {
            return this.mJniValue;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum ColorSpace {
        UNKNOWN(0),
        BT601(1),
        BT709(2);

        private final int mJniValue;

        ColorSpace(int i3) {
            this.mJniValue = i3;
        }

        public static ColorSpace a(int i3) {
            for (ColorSpace colorSpace : values()) {
                if (colorSpace.mJniValue == i3) {
                    return colorSpace;
                }
            }
            return UNKNOWN;
        }

        public final int getValue() {
            return this.mJniValue;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum GLScaleType {
        CENTER_CROP(0),
        FIT_CENTER(1),
        FILL(2);


        /* renamed from: d, reason: collision with root package name */
        private static final GLScaleType[] f119238d = values();
        public int mValue;

        GLScaleType(int i3) {
            this.mValue = i3;
        }

        public static GLScaleType a(int i3) {
            for (GLScaleType gLScaleType : f119238d) {
                if (gLScaleType.mValue == i3) {
                    return gLScaleType;
                }
            }
            return FIT_CENTER;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum PixelFormatType {
        I420(0),
        NV12(1),
        NV21(2),
        RGB(3),
        YUY2(4),
        RGBA(5),
        BGR(6),
        YV12(7),
        BGRA(8),
        ARGB(9),
        YUV422P(10),
        UYVY(11),
        YUYV(12),
        JPG(13),
        H264(14),
        MAX(100);


        /* renamed from: q, reason: collision with root package name */
        private static final PixelFormatType[] f119256q = values();
        private final int mJniValue;

        PixelFormatType(int i3) {
            this.mJniValue = i3;
        }

        public static PixelFormatType a(int i3) {
            for (PixelFormatType pixelFormatType : f119256q) {
                if (pixelFormatType.mJniValue == i3) {
                    return pixelFormatType;
                }
            }
            return null;
        }

        public final int getValue() {
            return this.mJniValue;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum a {
        BYTE_BUFFER(0),
        TEXTURE_2D(1),
        TEXTURE_OES(2),
        BYTE_ARRAY(3);


        /* renamed from: e, reason: collision with root package name */
        private static final a[] f119262e = values();
        public int mValue;

        a(int i3) {
            this.mValue = i3;
        }

        public static a a(int i3) {
            for (a aVar : f119262e) {
                if (aVar.mValue == i3) {
                    return aVar;
                }
            }
            return TEXTURE_2D;
        }
    }
}

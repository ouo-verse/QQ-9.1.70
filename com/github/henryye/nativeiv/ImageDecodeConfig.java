package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class ImageDecodeConfig {

    @Keep
    public Bitmap.Config mConfig = Bitmap.Config.ARGB_8888;

    @Keep
    public boolean mPremultiplyAlpha = true;

    @Keep
    public ReferrerPolicy mReferrerPolicy = ReferrerPolicy.NOT_SET;

    @Keep
    public int mPreferredWidth = 0;

    @Keep
    public int mPreferredHeight = 0;

    @Keep
    public double mPreferredScale = 0.0d;

    /* compiled from: P */
    @Keep
    /* loaded from: classes2.dex */
    public enum ReferrerPolicy {
        NOT_SET,
        NO_REFERRER,
        ORIGIN
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32861a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f32862b;

        static {
            int[] iArr = new int[ReferrerPolicy.values().length];
            f32862b = iArr;
            try {
                iArr[ReferrerPolicy.NO_REFERRER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32862b[ReferrerPolicy.ORIGIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Bitmap.Config.values().length];
            f32861a = iArr2;
            try {
                iArr2[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32861a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32861a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32861a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Keep
    public static ImageDecodeConfig createConfig(Bitmap.Config config, boolean z16) {
        ImageDecodeConfig imageDecodeConfig = new ImageDecodeConfig();
        imageDecodeConfig.mPremultiplyAlpha = z16;
        imageDecodeConfig.mConfig = config;
        return imageDecodeConfig;
    }

    @Keep
    public int getNativeConfig() {
        int i3 = a.f32861a[this.mConfig.ordinal()];
        if (i3 == 2) {
            return 4;
        }
        if (i3 != 3) {
            if (i3 != 4) {
                return 1;
            }
            return 8;
        }
        return 7;
    }

    @Keep
    public int getNativeReferrerPolicy() {
        int i3 = a.f32862b[this.mReferrerPolicy.ordinal()];
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2) {
                return 0;
            }
        }
        return i16;
    }

    public String toString() {
        return "ImageDecodeConfig{mConfig=" + this.mConfig + ", mPremultiplyAlpha=" + this.mPremultiplyAlpha + ", mReferrerPolicy=" + this.mReferrerPolicy + ", mPreferredWidth=" + this.mPreferredWidth + ", mPreferredHeight=" + this.mPreferredHeight + ", mPreferredScale=" + this.mPreferredScale + '}';
    }

    @Keep
    public static Object createConfig(int i3, boolean z16, int i16, int i17, int i18, double d16) {
        ImageDecodeConfig imageDecodeConfig = new ImageDecodeConfig();
        imageDecodeConfig.mPremultiplyAlpha = z16;
        if (i3 == 8) {
            imageDecodeConfig.mConfig = Bitmap.Config.ALPHA_8;
        } else if (i3 == 4) {
            imageDecodeConfig.mConfig = Bitmap.Config.RGB_565;
        } else if (i3 == 7) {
            imageDecodeConfig.mConfig = Bitmap.Config.ARGB_4444;
        } else if (i3 == 1) {
            imageDecodeConfig.mConfig = Bitmap.Config.ARGB_8888;
        } else {
            imageDecodeConfig.mConfig = Bitmap.Config.ARGB_8888;
        }
        if (i16 == 0) {
            imageDecodeConfig.mReferrerPolicy = ReferrerPolicy.NOT_SET;
        } else if (i16 == 1) {
            imageDecodeConfig.mReferrerPolicy = ReferrerPolicy.NO_REFERRER;
        } else if (i16 == 2) {
            imageDecodeConfig.mReferrerPolicy = ReferrerPolicy.ORIGIN;
        }
        imageDecodeConfig.mPreferredWidth = i17;
        imageDecodeConfig.mPreferredHeight = i18;
        imageDecodeConfig.mPreferredScale = d16;
        return imageDecodeConfig;
    }
}

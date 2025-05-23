package com.google.android.filament.android;

import android.graphics.Bitmap;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.android.filament.Engine;
import com.google.android.filament.Texture;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class TextureHelper {
    private static final int BITMAP_CONFIG_ALPHA_8 = 0;
    private static final int BITMAP_CONFIG_HARDWARE = 5;
    private static final int BITMAP_CONFIG_RGBA_4444 = 2;
    private static final int BITMAP_CONFIG_RGBA_8888 = 3;
    private static final int BITMAP_CONFIG_RGBA_F16 = 4;
    private static final int BITMAP_CONFIG_RGB_565 = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.google.android.filament.android.TextureHelper$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            Bitmap.Config config;
            Bitmap.Config config2;
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr2 = $SwitchMap$android$graphics$Bitmap$Config;
                config2 = Bitmap.Config.RGBA_F16;
                iArr2[config2.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr3 = $SwitchMap$android$graphics$Bitmap$Config;
                config = Bitmap.Config.HARDWARE;
                iArr3[config.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    TextureHelper() {
    }

    private static native void nSetBitmap(long j3, long j16, int i3, int i16, int i17, int i18, int i19, Bitmap bitmap, int i26);

    private static native void nSetBitmapWithCallback(long j3, long j16, int i3, int i16, int i17, int i18, int i19, Bitmap bitmap, int i26, Object obj, Runnable runnable);

    public static void setBitmap(@NonNull Engine engine, @NonNull Texture texture, @IntRange(from = 0) int i3, @NonNull Bitmap bitmap) {
        setBitmap(engine, texture, i3, 0, 0, texture.getWidth(i3), texture.getHeight(i3), bitmap);
    }

    private static int toNativeFormat(Bitmap.Config config) {
        int i3 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return 1;
            }
            if (i3 == 3) {
                return 2;
            }
            if (i3 != 5) {
                if (i3 != 6) {
                    return 3;
                }
                return 5;
            }
            return 4;
        }
        return 0;
    }

    public static void setBitmap(@NonNull Engine engine, @NonNull Texture texture, @IntRange(from = 0) int i3, @NonNull Bitmap bitmap, Object obj, Runnable runnable) {
        setBitmap(engine, texture, i3, 0, 0, texture.getWidth(i3), texture.getHeight(i3), bitmap, obj, runnable);
    }

    public static void setBitmap(@NonNull Engine engine, @NonNull Texture texture, @IntRange(from = 0) int i3, @IntRange(from = 0) int i16, @IntRange(from = 0) int i17, @IntRange(from = 0) int i18, @IntRange(from = 0) int i19, @NonNull Bitmap bitmap) {
        int nativeFormat = toNativeFormat(bitmap.getConfig());
        if (nativeFormat != 2 && nativeFormat != 5) {
            nSetBitmap(texture.getNativeObject(), engine.getNativeObject(), i3, i16, i17, i18, i19, bitmap, nativeFormat);
            return;
        }
        throw new IllegalArgumentException("Unsupported config: ARGB_4444 or HARDWARE");
    }

    public static void setBitmap(@NonNull Engine engine, @NonNull Texture texture, @IntRange(from = 0) int i3, @IntRange(from = 0) int i16, @IntRange(from = 0) int i17, @IntRange(from = 0) int i18, @IntRange(from = 0) int i19, @NonNull Bitmap bitmap, Object obj, Runnable runnable) {
        int nativeFormat = toNativeFormat(bitmap.getConfig());
        if (nativeFormat != 2 && nativeFormat != 5) {
            nSetBitmapWithCallback(texture.getNativeObject(), engine.getNativeObject(), i3, i16, i17, i18, i19, bitmap, nativeFormat, obj, runnable);
            return;
        }
        throw new IllegalArgumentException("Unsupported config: ARGB_4444 or HARDWARE");
    }
}

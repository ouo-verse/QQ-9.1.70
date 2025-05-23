package com.tencent.gdtad.splash.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes6.dex */
final class a {
    /* JADX WARN: Removed duplicated region for block: B:38:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(Context context, String str, int i3, int i16) {
        AssetManager assetManager;
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (context != null) {
            assetManager = context.getAssets();
        } else {
            assetManager = null;
        }
        if (assetManager != null) {
            try {
                inputStream = assetManager.open(str);
            } catch (Exception e16) {
                e = e16;
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (inputStream2 != null) {
                }
                throw th;
            }
            try {
                try {
                    Bitmap b16 = b(BitmapFactory.decodeStream(inputStream), i3, i16, true);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e17) {
                            QLog.e("GdtSplashAdViewUtil", 1, "bitmapFromAssets", e17);
                        }
                    }
                    return b16;
                } catch (Throwable th6) {
                    th = th6;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e18) {
                            QLog.e("GdtSplashAdViewUtil", 1, "bitmapFromAssets", e18);
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
                QLog.e("GdtSplashAdViewUtil", 1, "bitmapFromAssets error.", e);
                if (inputStream == null) {
                    return null;
                }
                try {
                    inputStream.close();
                    return null;
                } catch (IOException e26) {
                    QLog.e("GdtSplashAdViewUtil", 1, "bitmapFromAssets", e26);
                    return null;
                }
            }
        }
        QLog.e("GdtSplashAdViewUtil", 1, "assetManager is null");
        return null;
    }

    public static Bitmap b(Bitmap bitmap, int i3, int i16, boolean z16) {
        if (bitmap != null && bitmap.getWidth() != i3 && bitmap.getHeight() != i16) {
            if (i3 > 0 && i16 > 0) {
                try {
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i3, i16, true);
                    if (createScaledBitmap != bitmap) {
                        if (z16) {
                            bitmap.recycle();
                        }
                        return createScaledBitmap;
                    }
                } catch (Throwable th5) {
                    QLog.e("GdtSplashAdViewUtil", 1, "createBitmap error.", th5);
                }
                return bitmap;
            }
            QLog.e("GdtSplashAdViewUtil", 1, "createBitmap error width|height");
            return bitmap;
        }
        QLog.i("GdtSplashAdViewUtil", 1, "createBitmap no need to resample.");
        return bitmap;
    }

    public static final int c(float f16, @NonNull Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }
}

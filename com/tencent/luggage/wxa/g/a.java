package com.tencent.luggage.wxa.g;

import android.graphics.Bitmap;
import android.os.Build;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static int a() {
        return 4;
    }

    public static int b(int i3) {
        if (i3 == 4 || i3 == 3 || i3 == 2) {
            return NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE;
        }
        return 0;
    }

    public static int a(int i3) {
        if (i3 == 4) {
            return 6408;
        }
        if (i3 == 3) {
            return 6407;
        }
        if (i3 == 2) {
            return NativeBitmapStruct.GLFormat.GL_ALPHA;
        }
        return 0;
    }

    public static int a(Bitmap.Config config) {
        if (config != null) {
            if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.ARGB_4444 || config == Bitmap.Config.RGB_565) {
                return 4;
            }
            if (config == Bitmap.Config.ALPHA_8) {
                return 2;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                return 4;
            }
            return a();
        }
        return a();
    }
}

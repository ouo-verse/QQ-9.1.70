package org.libpag;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.hardware.HardwareBuffer;
import android.os.Build;
import android.util.Pair;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair a(int i3, int i16, boolean z16) {
        ColorSpace.Named named;
        ColorSpace colorSpace;
        Bitmap wrapHardwareBuffer;
        if (i3 != 0 && i16 != 0) {
            int i17 = Build.VERSION.SDK_INT;
            if (i17 >= 30 || (!z16 && i17 >= 29)) {
                HardwareBuffer a16 = a(i3, i16);
                if (a16 != null) {
                    try {
                        named = ColorSpace.Named.SRGB;
                        colorSpace = ColorSpace.get(named);
                        wrapHardwareBuffer = Bitmap.wrapHardwareBuffer(a16, colorSpace);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    if (wrapHardwareBuffer != null) {
                        return Pair.create(wrapHardwareBuffer, a16);
                    }
                }
                wrapHardwareBuffer = null;
                if (wrapHardwareBuffer != null) {
                }
            }
            return Pair.create(Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888), null);
        }
        return Pair.create(null, null);
    }

    private static HardwareBuffer a(int i3, int i16) {
        HardwareBuffer create;
        if (i3 <= 0 || i16 <= 0 || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            create = HardwareBuffer.create(i3, i16, 1, 1, 819L);
            return create;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}

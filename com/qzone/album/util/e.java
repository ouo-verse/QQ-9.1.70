package com.qzone.album.util;

import android.graphics.drawable.Drawable;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {
    public static Drawable a(int i3) {
        int b16 = b(i3);
        if (b16 == 0) {
            return null;
        }
        try {
            return u4.a.z().K().getDrawable(b16);
        } catch (Throwable unused) {
            QZLog.e("AlbumResourcesUtil", "AlbumResourcesUtil getDrawableId Exception");
            return null;
        }
    }

    private static int b(int i3) {
        return 0;
    }
}

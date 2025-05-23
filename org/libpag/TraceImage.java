package org.libpag;

import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TraceImage {
    public static void Trace(String str, ByteBuffer byteBuffer, int i3, int i16) {
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(byteBuffer);
        Log.i(str, "Image(width = " + createBitmap.getWidth() + ", height = " + createBitmap.getHeight() + ")");
    }
}

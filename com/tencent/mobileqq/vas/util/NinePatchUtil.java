package com.tencent.mobileqq.vas.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes20.dex */
public class NinePatchUtil {

    /* loaded from: classes20.dex */
    public static class NinePatchParams {
        int bitmapHeight;
        int bitmapWidth;
        int patchOffsetX;
        int patchOffsetY;
        int patchStartX;
        int patchStartY;

        public NinePatchParams(int i3, int i16, int i17, int i18, int i19, int i26) {
            this.bitmapWidth = i3;
            this.bitmapHeight = i16;
            this.patchStartX = i17;
            this.patchOffsetX = i18;
            this.patchStartY = i19;
            this.patchOffsetY = i26;
        }
    }

    public static Bitmap createNineBitmap(Bitmap bitmap, NinePatchParams ninePatchParams, Rect rect) {
        Bitmap bitmap2 = null;
        if (bitmap != null && ninePatchParams != null) {
            try {
                bitmap2 = Bitmap.createBitmap(ninePatchParams.bitmapWidth, ninePatchParams.bitmapHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap2);
                NinePatch createNinePatchDrawable = createNinePatchDrawable(bitmap, ninePatchParams);
                if (rect == null) {
                    rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                if (createNinePatchDrawable != null) {
                    createNinePatchDrawable.draw(canvas, rect, new Paint(6));
                }
            } catch (OutOfMemoryError unused) {
            }
        }
        return bitmap2;
    }

    private static byte[] createNinePatchChunk(Bitmap bitmap, NinePatchParams ninePatchParams) {
        if (bitmap != null && ninePatchParams != null) {
            int i3 = ninePatchParams.patchStartX;
            int[] iArr = {i3, i3 + ninePatchParams.patchOffsetX};
            int i16 = ninePatchParams.patchStartY;
            return getNinePatchChunk(iArr, new int[]{i16, i16 + ninePatchParams.patchOffsetY});
        }
        return null;
    }

    public static NinePatch createNinePatchDrawable(Bitmap bitmap, NinePatchParams ninePatchParams) {
        byte[] createNinePatchChunk;
        if (bitmap == null || ninePatchParams == null || (createNinePatchChunk = createNinePatchChunk(bitmap, ninePatchParams)) == null || !NinePatch.isNinePatchChunk(createNinePatchChunk)) {
            return null;
        }
        return new NinePatch(bitmap, createNinePatchChunk, null);
    }

    public static byte[] getNinePatchChunk(int[] iArr, int[] iArr2) {
        ByteBuffer order = ByteBuffer.allocate((iArr.length * 4) + (iArr2.length * 4) + 36 + 32).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) 2);
        order.put((byte) 2);
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        for (int i3 : iArr) {
            order.putInt(i3);
        }
        for (int i16 : iArr2) {
            order.putInt(i16);
        }
        for (int i17 = 0; i17 < 9; i17++) {
            order.putInt(1);
        }
        return order.array();
    }
}

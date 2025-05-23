package com.tencent.biz.richframework.compat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import org.jf.dexlib2.analysis.RegisterType;

/* loaded from: classes5.dex */
public class RFWNinePatchUtils {
    private static Field sNineChunkField;
    private static Paint sPaint;

    private static void dealPaddingInfo(Bitmap bitmap, byte[] bArr) {
        int width = bitmap.getWidth() - 2;
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, width, 1, bitmap.getHeight() - 1, width, 1);
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (i16 >= width) {
                break;
            }
            if (-16777216 == iArr[i16]) {
                writeInt(bArr, 12, i16);
                break;
            }
            i16++;
        }
        int i17 = width - 1;
        while (true) {
            if (i17 < 0) {
                break;
            }
            if (-16777216 == iArr[i17]) {
                writeInt(bArr, 16, (width - i17) - 1);
                break;
            }
            i17--;
        }
        int height = bitmap.getHeight() - 2;
        int[] iArr2 = new int[height];
        bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, height);
        while (true) {
            if (i3 >= height) {
                break;
            }
            if (-16777216 == iArr2[i3]) {
                writeInt(bArr, 20, i3);
                break;
            }
            i3++;
        }
        for (int i18 = height - 1; i18 >= 0; i18--) {
            if (-16777216 == iArr2[i18]) {
                writeInt(bArr, 24, (height - i18) - 1);
                return;
            }
        }
    }

    public static Bitmap getCompiledNinePatchBitmap(Bitmap bitmap, boolean z16) {
        try {
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            if (ninePatchChunk == null) {
                ninePatchChunk = readChunk(bitmap);
                setNineChunkToBitmap(ninePatchChunk, bitmap);
            }
            if (!z16) {
                Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
                Canvas canvas = new Canvas(copy);
                if (sPaint == null) {
                    Paint paint = new Paint();
                    sPaint = paint;
                    paint.setAntiAlias(true);
                }
                canvas.drawBitmap(bitmap, new Rect(1, 1, bitmap.getWidth() - 1, bitmap.getHeight() - 1), new Rect(0, 0, copy.getWidth(), copy.getHeight()), sPaint);
                bitmap.recycle();
                setNineChunkToBitmap(ninePatchChunk, copy);
                return copy;
            }
            return bitmap;
        } catch (Throwable th5) {
            RFWLog.e("RFWNinePatchUtils", RFWLog.USR, th5);
            return null;
        }
    }

    private static int getInt(byte[] bArr, int i3) {
        byte b16 = bArr[i3 + 0];
        byte b17 = bArr[i3 + 1];
        byte b18 = bArr[i3 + 2];
        return ((bArr[i3 + 3] << 24) & (-16777216)) | (b16 & 255) | ((b17 << 8) & 65280) | ((b18 << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT);
    }

    public static NinePatchDrawable getNinePatchDrawable(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Rect rect = new Rect();
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        readPaddingFromChunk(ninePatchChunk, rect);
        return new NinePatchDrawable(RFWApplication.getApplication().getResources(), bitmap, ninePatchChunk, rect, null);
    }

    public static byte[] readChunk(Bitmap bitmap) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i3 = 0; i3 < 32; i3++) {
            byteArrayOutputStream.write(0);
        }
        int i16 = width - 2;
        int[] iArr = new int[i16];
        bitmap.getPixels(iArr, 0, width, 1, 0, i16, 1);
        if (iArr[0] == -16777216) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (iArr[i16 - 1] == -16777216) {
            z17 = true;
        } else {
            z17 = false;
        }
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < i16; i19++) {
            if (iArr[i19] != -16777216) {
                iArr[i19] = 0;
            }
            if (i18 != iArr[i19]) {
                i17++;
                writeInt(byteArrayOutputStream, i19);
                i18 = iArr[i19];
            }
        }
        if (z17) {
            i17++;
            writeInt(byteArrayOutputStream, i16);
        }
        int i26 = i17 + 1;
        if (z16) {
            i26--;
        }
        if (z17) {
            i26--;
        }
        int i27 = height - 2;
        int[] iArr2 = new int[i27];
        bitmap.getPixels(iArr2, 0, 1, 0, 1, 1, i27);
        if (iArr2[0] == -16777216) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (iArr2[i27 - 1] == -16777216) {
            z19 = true;
        } else {
            z19 = false;
        }
        int i28 = 0;
        int i29 = 0;
        for (int i36 = 0; i36 < i27; i36++) {
            if (iArr2[i36] != -16777216) {
                iArr2[i36] = 0;
            }
            if (i29 != iArr2[i36]) {
                i28++;
                writeInt(byteArrayOutputStream, i36);
                i29 = iArr2[i36];
            }
        }
        if (z19) {
            i28++;
            writeInt(byteArrayOutputStream, i27);
        }
        int i37 = i28 + 1;
        if (z18) {
            i37--;
        }
        if (z19) {
            i37--;
        }
        int i38 = 0;
        while (true) {
            int i39 = i26 * i37;
            if (i38 < i39) {
                writeInt(byteArrayOutputStream, 1);
                i38++;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArray[0] = 1;
                byteArray[1] = (byte) i17;
                byteArray[2] = (byte) i28;
                byteArray[3] = (byte) i39;
                dealPaddingInfo(bitmap, byteArray);
                return byteArray;
            }
        }
    }

    public static void readPaddingFromChunk(byte[] bArr, Rect rect) {
        rect.left = getInt(bArr, 12);
        rect.right = getInt(bArr, 16);
        rect.top = getInt(bArr, 20);
        rect.bottom = getInt(bArr, 24);
    }

    public static void setNineChunkToBitmap(byte[] bArr, Bitmap bitmap) {
        try {
            if (sNineChunkField == null) {
                sNineChunkField = bitmap.getClass().getDeclaredField("mNinePatchChunk");
            }
            sNineChunkField.setAccessible(true);
            sNineChunkField.set(bitmap, bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static void writeInt(ByteArrayOutputStream byteArrayOutputStream, int i3) {
        try {
            byteArrayOutputStream.write((byte) ((i3 >> 0) & 255));
            byteArrayOutputStream.write((byte) ((i3 >> 8) & 255));
            byteArrayOutputStream.write((byte) ((i3 >> 16) & 255));
            byteArrayOutputStream.write((byte) ((i3 >> 24) & 255));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static void writeInt(byte[] bArr, int i3, int i16) {
        bArr[i3 + 0] = (byte) (i16 >> 0);
        bArr[i3 + 1] = (byte) (i16 >> 8);
        bArr[i3 + 2] = (byte) (i16 >> 16);
        bArr[i3 + 3] = (byte) (i16 >> 24);
    }
}

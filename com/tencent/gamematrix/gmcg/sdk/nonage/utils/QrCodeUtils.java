package com.tencent.gamematrix.gmcg.sdk.nonage.utils;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.Hashtable;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QrCodeUtils {
    public static Bitmap createQRCode(String str, int i3) {
        try {
            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hashtable.put(EncodeHintType.MARGIN, "0");
            BitMatrix encode = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i3, i3, hashtable);
            int[] iArr = new int[i3 * i3];
            for (int i16 = 0; i16 < i3; i16++) {
                for (int i17 = 0; i17 < i3; i17++) {
                    if (encode.get(i17, i16)) {
                        iArr[(i16 * i3) + i17] = -16777216;
                    } else {
                        iArr[(i16 * i3) + i17] = -1;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, i3, 0, 0, i3, i3);
            return createBitmap;
        } catch (WriterException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}

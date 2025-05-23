package com.tencent.tavkit.utils;

import android.media.ExifInterface;
import com.tencent.tav.decoder.logger.Logger;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVBitmapUtils {
    private static final String TAG = "TAVBitmapUtils";

    public static int readImagePreferRotation(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt == 6) {
                    return 3;
                }
                if (attributeInt != 8) {
                    return 0;
                }
                return 1;
            }
            return 2;
        } catch (IOException e16) {
            Logger.e(TAG, "readImagePreferRotation: ", e16);
            return 0;
        }
    }
}

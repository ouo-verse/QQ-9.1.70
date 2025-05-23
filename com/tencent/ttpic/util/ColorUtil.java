package com.tencent.ttpic.util;

import android.graphics.Color;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ColorUtil {
    public static int hex2Int(String str) {
        return Color.parseColor(str);
    }

    public static int[] hex2Rgb(String str) {
        return int2Rgb(hex2Int(str));
    }

    public static String int2Hex(int i3) {
        return String.format("#%06X", Integer.valueOf(i3 & 16777215));
    }

    public static int[] int2Rgb(int i3) {
        int[] iArr = {0, 0, 0};
        int red = Color.red(i3);
        int green = Color.green(i3);
        int blue = Color.blue(i3);
        iArr[0] = red;
        iArr[1] = green;
        iArr[2] = blue;
        return iArr;
    }

    public static String rgb2Hex(int[] iArr) {
        String str = "#";
        for (int i3 : iArr) {
            if (i3 < 0) {
                i3 = 0;
            } else if (i3 > 255) {
                i3 = 255;
            }
            String[] strArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE};
            str = str + strArr[i3 / 16] + strArr[i3 % 16];
        }
        return str;
    }

    public static int rgb2Int(int[] iArr) {
        return Color.rgb(iArr[0], iArr[1], iArr[2]);
    }
}

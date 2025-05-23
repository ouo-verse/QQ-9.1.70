package com.tencent.av.utils;

import android.text.TextPaint;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public class n {
    public static float a(StringBuilder sb5, String str, TextPaint textPaint, float f16) {
        float measureText = textPaint.measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX);
        if (measureText > b(sb5, str, textPaint, f16 - measureText)) {
            sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
        }
        return measureText;
    }

    public static float b(StringBuilder sb5, String str, TextPaint textPaint, float f16) {
        if (str == null) {
            return f16;
        }
        char[] charArray = str.toCharArray();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            float measureText = textPaint.measureText(charArray, i3, 1);
            if (measureText >= f16) {
                break;
            }
            f16 -= measureText;
            sb5.append(charArray[i3]);
        }
        return f16;
    }

    public static float c(String str, TextPaint textPaint) {
        return textPaint.measureText(str);
    }
}

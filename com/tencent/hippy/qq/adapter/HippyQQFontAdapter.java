package com.tencent.hippy.qq.adapter;

import android.text.TextUtils;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQFontAdapter implements HippyFontScaleAdapter {
    private static final String[] FONT_EXTENSIONS = {".ttf", ".otf"};
    private static final String TAG = "HippyQQFontAdapter";

    private StringBuilder decodeEmojiFromString(String str) {
        int i3;
        int convertToLocal;
        StringBuilder sb5 = new StringBuilder();
        int i16 = 0;
        while (i16 < str.length()) {
            if (str.charAt(i16) == 20 && (i3 = i16 + 2) < str.length()) {
                int i17 = i16 + 1;
                int charAt = (((str.charAt(i17) - 'A') * 128) + str.charAt(i3)) - 65;
                if (charAt >= 0 && (convertToLocal = QQSysFaceUtil.convertToLocal(charAt)) >= 0) {
                    sb5.append(str.charAt(i16));
                    sb5.append((char) convertToLocal);
                }
                i16 = i17 + 1;
            } else {
                sb5.append(str.charAt(i16));
            }
            i16++;
        }
        return sb5;
    }

    @Override // com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter
    public String getCustomDefaultFontFamily() {
        return null;
    }

    @Override // com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter
    public String getCustomFontFilePath(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getCustomFontFilePath fontFamilyName = " + str);
        }
        String hippyFontRootDir = HippyUtils.getHippyFontRootDir();
        for (String str2 : FONT_EXTENSIONS) {
            String str3 = hippyFontRootDir + str + str2;
            if (new File(str3).exists()) {
                return str3;
            }
        }
        return null;
    }

    @Override // com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter
    public CharSequence getEmoticonText(CharSequence charSequence, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            return "";
        }
        return new QQText(decodeEmojiFromString(charSequence.toString()), 2, (int) (i3 / 2.5d));
    }

    @Override // com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter
    public float getFontScale() {
        return 1.0f;
    }
}

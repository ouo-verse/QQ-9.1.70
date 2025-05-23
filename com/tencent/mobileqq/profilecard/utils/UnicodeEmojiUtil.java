package com.tencent.mobileqq.profilecard.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import org.apache.commons.lang.CharEncoding;

/* compiled from: P */
/* loaded from: classes35.dex */
public class UnicodeEmojiUtil {
    private static final String TAG = "UnicodeEmojiUtil";
    private static final char UNICODE_EMOJI_FIRST_CHAR_BEGIN = '\ud800';
    private static final char UNICODE_EMOJI_FIRST_CHAR_END = '\ud83f';

    public static boolean isEmojiFirstCharacter(String str, int i3) {
        if (!TextUtils.isEmpty(str) && i3 < str.length()) {
            try {
                byte[] bytes = String.valueOf(str.charAt(i3)).getBytes(CharEncoding.UTF_16BE);
                if (bytes.length == 2 && str.length() > 1) {
                    char c16 = (char) ((((char) (bytes[0] & 255)) << '\b') | ((char) (bytes[1] & 255)));
                    if (c16 >= '\ud800' && c16 <= '\ud83f') {
                        return true;
                    }
                }
            } catch (UnsupportedEncodingException e16) {
                QLog.e(TAG, 2, "isEmojiFirstCharacter error", e16);
            }
        }
        return false;
    }
}

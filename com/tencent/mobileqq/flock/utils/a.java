package com.tencent.mobileqq.flock.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static String a(String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        int i16 = 0;
        while (i16 < str.length()) {
            if (str.charAt(i16) == 20 && (i3 = i16 + 2) < str.length()) {
                int i17 = i16 + 1;
                int charAt = (((str.charAt(i17) - 'A') * 128) + str.charAt(i3)) - 65;
                if (charAt >= 0) {
                    sb5.append(String.valueOf(new char[]{20, (char) QQSysFaceUtil.convertToLocal(charAt)}));
                    i16 = i17 + 1;
                }
            } else {
                sb5.append(str.charAt(i16));
            }
            i16++;
        }
        return sb5.toString();
    }

    public static String b(String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        int i16 = 0;
        while (i16 < str.length()) {
            if (str.charAt(i16) == 20 && (i3 = i16 + 1) < str.length()) {
                int convertToServer = QQSysFaceUtil.convertToServer(str.charAt(i3));
                if (convertToServer >= 0) {
                    sb5.append(str.charAt(i16));
                    sb5.append((char) ((convertToServer / 128) + 65));
                    sb5.append((char) ((convertToServer % 128) + 65));
                    i16 = i3;
                }
            } else {
                sb5.append(str.charAt(i16));
            }
            i16++;
        }
        return sb5.toString();
    }
}

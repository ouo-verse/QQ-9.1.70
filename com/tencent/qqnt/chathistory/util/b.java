package com.tencent.qqnt.chathistory.util;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes23.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static String a(CharSequence charSequence) {
        int i3;
        StringBuilder sb5 = new StringBuilder(charSequence);
        int length = sb5.length();
        int i16 = 0;
        while (i16 < sb5.length()) {
            int codePointAt = sb5.codePointAt(i16);
            if (codePointAt == c.b() && i16 < length - 1) {
                int i17 = i16 + 1;
                if (sb5.charAt(i17) < c.c()) {
                    sb5.replace(i16, i16 + 2, "\u0001\u0001");
                    i16 = i17;
                }
            } else if (c.a().get(codePointAt, -1) >= 0) {
                if (codePointAt > 65535 && length >= (i3 = i16 + 2)) {
                    sb5.replace(i16, i3, "\u0001\u0001");
                } else {
                    sb5.replace(i16, i16 + 1, "\u0001");
                }
            }
            i16++;
        }
        return sb5.toString();
    }

    public static SpannableString b(String str, @Nullable String str2) {
        String lowerCase = a(str).toLowerCase(Locale.US);
        if (TextUtils.isEmpty(str2)) {
            return new SpannableString(lowerCase);
        }
        int indexOf = lowerCase.indexOf(str2);
        if (indexOf > 20) {
            int i3 = indexOf - 20;
            int codePointAt = str.codePointAt(i3 - 1);
            if (codePointAt == c.b() || (c.a().get(codePointAt, -1) >= 0 && codePointAt > 65535)) {
                i3++;
            }
            StringBuilder sb5 = new StringBuilder(str.length());
            sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
            sb5.append(str.substring(i3));
            SpannableString spannableString = new SpannableString(sb5.toString());
            spannableString.setSpan(MiniBoxNoticeInfo.APPNAME_SUFFIX, 0, 3, 33);
            return spannableString;
        }
        return new SpannableString(str);
    }

    public static void c(Spannable spannable, int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String lowerCase = a(spannable.toString()).toString().toLowerCase(Locale.US);
        int length = str.length();
        int i16 = 0;
        String[] strArr = (String[]) spannable.getSpans(0, spannable.length(), String.class);
        if (strArr != null) {
            int length2 = strArr.length;
            int i17 = 0;
            while (i16 < length2) {
                if (MiniBoxNoticeInfo.APPNAME_SUFFIX.equals(strArr[i16])) {
                    i17 = 3;
                }
                i16++;
            }
            i16 = i17;
        }
        do {
            int indexOf = lowerCase.indexOf(str, i16);
            if (indexOf >= 0 && indexOf < lowerCase.length()) {
                int i18 = indexOf + length;
                spannable.setSpan(new ForegroundColorSpan(i3), indexOf, i18, 33);
                i16 = i18;
            } else {
                i16 = indexOf;
            }
            if (i16 < 0) {
                return;
            }
        } while (i16 < lowerCase.length());
    }
}

package com.tencent.mobileqq.phonecontact.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.MD5;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static String a(String str) {
        if (str != null && str.length() != 0) {
            StringBuffer stringBuffer = new StringBuffer(str.length());
            for (int i3 = 0; i3 < str.length(); i3++) {
                char charAt = str.charAt(i3);
                if (charAt != ' ' && charAt != '-' && charAt != ')' && charAt != '(' && charAt != '_') {
                    stringBuffer.append(charAt);
                }
            }
            return stringBuffer.toString();
        }
        return str;
    }

    public static String b(String str, String str2) {
        byte[] bytes = "isNull".getBytes();
        byte[] bytes2 = str2.getBytes();
        if (bytes.length > 10) {
            byte[] bArr = new byte[10];
            System.arraycopy(bytes, 0, bArr, 0, 10);
            bytes = bArr;
        }
        return MD5.toMD5(ByteBuffer.allocate(bytes.length + bytes2.length).put(bytes).put(bytes2).array());
    }

    public static String c(String str) {
        String str2;
        if (str == null || str.length() == 0) {
            str2 = "#";
        } else {
            str2 = String.valueOf(str.charAt(0)).toUpperCase();
        }
        if (!StringUtil.isAsciiAlpha(str2.charAt(0))) {
            return "#";
        }
        return str2;
    }
}

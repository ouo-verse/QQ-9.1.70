package com.tencent.mobileqq.winkpublish.util;

import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes35.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f327440a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f327441b = new byte[0];

    public static byte a(char c16) {
        int i3;
        if (c16 >= '0' && c16 <= '9') {
            i3 = c16 - '0';
        } else {
            char c17 = 'a';
            if (c16 < 'a' || c16 > 'f') {
                c17 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET;
                if (c16 < 'A' || c16 > 'F') {
                    return (byte) 0;
                }
            }
            i3 = (c16 - c17) + 10;
        }
        return (byte) i3;
    }

    public static byte[] b(String str) {
        if (str != null && !str.equals("")) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                int i16 = i3 * 2;
                try {
                    bArr[i3] = (byte) ((a(str.charAt(i16)) * RegisterType.UNINIT_REF) + a(str.charAt(i16 + 1)));
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("HexUtil", 2, " === hexStr2Bytes error === " + e16.toString());
                    }
                    return f327441b;
                }
            }
            return bArr;
        }
        return f327441b;
    }
}

package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.text.EmotcationConstants;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final char f62428a = (char) Integer.parseInt("00000011", 2);

    /* renamed from: b, reason: collision with root package name */
    private static final char f62429b = (char) Integer.parseInt("00001111", 2);

    /* renamed from: c, reason: collision with root package name */
    private static final char f62430c = (char) Integer.parseInt("00111111", 2);

    /* renamed from: d, reason: collision with root package name */
    private static final char f62431d = (char) Integer.parseInt("11111100", 2);

    /* renamed from: e, reason: collision with root package name */
    private static final char f62432e = (char) Integer.parseInt("11110000", 2);

    /* renamed from: f, reason: collision with root package name */
    private static final char f62433f = (char) Integer.parseInt("11000000", 2);

    /* renamed from: g, reason: collision with root package name */
    private static final char[] f62434g = {EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    public static String a(byte[] bArr) {
        int i3;
        int i16;
        StringBuilder sb5 = new StringBuilder(((int) (bArr.length * 1.34d)) + 3);
        int i17 = 0;
        char c16 = 0;
        for (int i18 = 0; i18 < bArr.length; i18++) {
            i17 %= 8;
            while (i17 < 8) {
                if (i17 == 0) {
                    i3 = ((char) (bArr[i18] & f62431d)) >>> 2;
                } else if (i17 == 2) {
                    i3 = bArr[i18] & f62430c;
                } else if (i17 == 4) {
                    c16 = (char) (((char) (bArr[i18] & f62429b)) << 2);
                    int i19 = i18 + 1;
                    if (i19 < bArr.length) {
                        i16 = (bArr[i19] & f62433f) >>> 6;
                        i3 = c16 | i16;
                    } else {
                        sb5.append(f62434g[c16]);
                        i17 += 6;
                    }
                } else {
                    if (i17 == 6) {
                        c16 = (char) (((char) (bArr[i18] & f62428a)) << 4);
                        int i26 = i18 + 1;
                        if (i26 < bArr.length) {
                            i16 = (bArr[i26] & f62432e) >>> 4;
                            i3 = c16 | i16;
                        }
                    }
                    sb5.append(f62434g[c16]);
                    i17 += 6;
                }
                c16 = (char) i3;
                sb5.append(f62434g[c16]);
                i17 += 6;
            }
        }
        if (sb5.length() % 4 != 0) {
            for (int length = 4 - (sb5.length() % 4); length > 0; length--) {
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            }
        }
        return sb5.toString();
    }
}

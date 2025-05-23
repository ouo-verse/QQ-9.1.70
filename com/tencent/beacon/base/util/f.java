package com.tencent.beacon.base.util;

import android.text.TextUtils;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes2.dex */
public class f {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Charset.forName("ISO-8859-1").newEncoder().canEncode(str);
        } catch (Exception e16) {
            c.a(e16);
            return false;
        }
    }
}

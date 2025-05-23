package com.tencent.msdk.dns.core.n.b;

import android.text.TextUtils;
import com.tencent.msdk.dns.core.rest.share.f;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes21.dex */
final class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                byte[] c16 = com.tencent.msdk.dns.base.jni.a.c(f.b(str), str2, 1);
                if (c16 == null) {
                    return "";
                }
                return new String(c16, Charset.forName("UTF-8"));
            } catch (Exception unused) {
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return f.a(com.tencent.msdk.dns.base.jni.a.c(str.getBytes("utf-8"), str2, 0));
            } catch (Exception unused) {
            }
        }
        return "";
    }
}

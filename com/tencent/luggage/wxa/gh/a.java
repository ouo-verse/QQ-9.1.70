package com.tencent.luggage.wxa.gh;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static String[] a(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            String str = strArr[i3];
            if (str != null && str.startsWith("data:image/")) {
                strArr2[i3] = b(strArr[i3]);
            } else {
                strArr2[i3] = strArr[i3];
            }
        }
        return strArr2;
    }

    public static void b(String[] strArr) {
        for (String str : strArr) {
            try {
                x.c(str);
            } catch (Exception unused) {
            }
        }
    }

    public static String c(String str) {
        byte[] bArr;
        OutputStream outputStream = null;
        try {
            bArr = Base64.decode(str, 0);
        } catch (Exception e16) {
            w.a("", e16, "writeToFile", new Object[0]);
            bArr = null;
        }
        if (bArr != null && bArr.length != 0) {
            v vVar = new v(z.c().getCacheDir(), "preview_" + System.currentTimeMillis() + "_" + str.hashCode());
            try {
                outputStream = x.b(vVar);
                outputStream.write(bArr);
                try {
                    outputStream.close();
                } catch (IOException unused) {
                }
                return vVar.g();
            } catch (Exception unused2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused3) {
                    }
                }
            } catch (Throwable th5) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th5;
            }
        }
        return "";
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : c(a(str));
    }

    public static String[] a(String[] strArr, String[] strArr2) {
        String str;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < strArr.length; i3++) {
            String str2 = strArr[i3];
            if (str2 != null && (str = strArr2[i3]) != null && !str2.equals(str)) {
                arrayList.add(strArr[i3]);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String a(String str) {
        return str.substring(str.indexOf("base64,") + 7).trim();
    }
}

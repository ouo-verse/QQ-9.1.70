package com.xiaomi.push;

import android.net.Uri;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ab {
    public static String a(String str) {
        try {
            return String.valueOf(aa.e(MessageDigest.getInstance("SHA1").digest(str.getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException e16) {
            jz4.c.o("CloudCoder.hash4SHA1 ", e16);
            throw new IllegalStateException("failed to SHA1");
        } catch (NoSuchAlgorithmException e17) {
            jz4.c.o("CloudCoder.hash4SHA1 ", e17);
            throw new IllegalStateException("failed to SHA1");
        } catch (Exception e18) {
            jz4.c.o("CloudCoder.hash4SHA1 ", e18);
            throw new IllegalStateException("failed to SHA1");
        }
    }

    public static String b(String str, String str2, Map<String, String> map, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            ArrayList<String> arrayList = new ArrayList();
            if (str != null) {
                arrayList.add(str.toUpperCase());
            }
            if (str2 != null) {
                arrayList.add(Uri.parse(str2).getEncodedPath());
            }
            boolean z16 = true;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : new TreeMap(map).entrySet()) {
                    arrayList.add(String.format("%s=%s", entry.getKey(), entry.getValue()));
                }
            }
            arrayList.add(str3);
            StringBuilder sb5 = new StringBuilder();
            for (String str4 : arrayList) {
                if (!z16) {
                    sb5.append(Typography.amp);
                }
                sb5.append(str4);
                z16 = false;
            }
            return a(sb5.toString());
        }
        throw new InvalidParameterException("security is not nullable");
    }
}

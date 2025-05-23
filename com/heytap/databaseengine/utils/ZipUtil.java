package com.heytap.databaseengine.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ZipUtil {
    public static String compress(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
        gZIPOutputStream.close();
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    public static String uncompress(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        byte[] decode = Base64.decode(str, 2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(decode));
        byte[] bArr = new byte[256];
        while (true) {
            int read = gZIPInputStream.read(bArr);
            if (read >= 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                gZIPInputStream.close();
                return byteArrayOutputStream.toString("UTF-8");
            }
        }
    }
}

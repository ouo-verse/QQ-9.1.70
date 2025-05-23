package com.tencent.mobileqq.mini.cache;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Util {
    static final Charset US_ASCII = Charset.forName("US-ASCII");
    static final Charset UTF_8 = Charset.forName("UTF-8");

    Util() {
    }

    public static String[] decode(String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArr = new String[2];
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf == -1 || str.length() <= (i3 = lastIndexOf + 1)) {
            return null;
        }
        String substring = str.substring(0, lastIndexOf);
        String substring2 = str.substring(i3);
        strArr[0] = substring;
        strArr[1] = substring2;
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void deleteContents(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }

    public static String encode(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str + ":" + str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String readFully(Reader reader) throws IOException {
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read != -1) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    return stringWriter.toString();
                }
            }
        } finally {
            reader.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e16) {
                throw e16;
            } catch (Exception unused) {
            }
        }
    }
}

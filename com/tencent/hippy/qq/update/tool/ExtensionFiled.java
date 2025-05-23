package com.tencent.hippy.qq.update.tool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ExtensionFiled extends QIO {
    public static String DEFAULT_KEY_ENCODE = "encode";
    public static String DEFAULT_KEY_UNCOMPRESS = "uncompress";
    public static final String DEFAULT_VALUE_ENCODE = "utf-8";
    public static final int HEADER_EX = 1;
    public static final int HEADER_NO_EX = 0;
    public String key;
    public String value;

    public void md5Ex(MessageDigest messageDigest) throws IOException {
        md5String(messageDigest, this.key);
        md5String(messageDigest, this.value);
    }

    public void readEx(InputStream inputStream) throws Exception {
        this.key = readString(inputStream);
        this.value = readString(inputStream);
    }

    public void setEx(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public void writeEx(OutputStream outputStream) throws IOException {
        writeString(outputStream, this.key);
        writeString(outputStream, this.value);
    }
}

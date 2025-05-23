package com.tencent.hippy.qq.update.tool;

import com.tencent.hippy.qq.update.tool.v.VersionConfiguration;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes7.dex */
public class QIO {
    public void md5Int(MessageDigest messageDigest, int i3) throws IOException {
        byte[] intToByte = TypeHelper.intToByte(i3);
        messageDigest.update(intToByte, 0, intToByte.length);
    }

    public void md5Long(MessageDigest messageDigest, long j3) throws IOException {
        byte[] longToByte = TypeHelper.longToByte(j3);
        messageDigest.update(longToByte, 0, longToByte.length);
    }

    public void md5String(MessageDigest messageDigest, String str) throws IOException {
        byte[] bytes = str.getBytes();
        md5Int(messageDigest, bytes.length);
        messageDigest.update(bytes, 0, bytes.length);
    }

    public int readInt(InputStream inputStream) throws Exception {
        inputStream.read(VersionConfiguration.BYTE_4);
        return TypeHelper.byteToInt(VersionConfiguration.BYTE_4);
    }

    public long readLong(InputStream inputStream) throws Exception {
        inputStream.read(VersionConfiguration.BYTE_8);
        return TypeHelper.byteToLong(VersionConfiguration.BYTE_8);
    }

    public String readString(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[readInt(inputStream)];
        inputStream.read(bArr);
        return new String(bArr);
    }

    public void writeInt(OutputStream outputStream, int i3) throws IOException {
        outputStream.write(TypeHelper.intToByte(i3));
    }

    public void writeLong(OutputStream outputStream, long j3) throws IOException {
        outputStream.write(TypeHelper.longToByte(j3));
    }

    public void writeString(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes();
        writeInt(outputStream, bytes.length);
        outputStream.write(bytes);
    }
}

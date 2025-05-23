package com.tencent.mobileqq.nearby.now.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IIOUtils extends QRouteApi {
    ReadableByteChannel getChannel(InputStream inputStream);

    WritableByteChannel getChannel(OutputStream outputStream);

    byte[] getFileMD5(File file);

    int indexOf(byte[] bArr, int i3, byte[] bArr2);

    byte[] numberToBytes(long j3, int i3, boolean z16);

    byte[] readBytes(InputStream inputStream, int i3) throws IOException;

    float readFloat(InputStream inputStream) throws IOException;

    float readFloat(InputStream inputStream, boolean z16) throws IOException;

    long readInt(InputStream inputStream) throws IOException;

    long readInt(InputStream inputStream, boolean z16) throws IOException;

    long readNumber(InputStream inputStream, int i3, boolean z16) throws IOException;

    String readString(InputStream inputStream, int i3) throws IOException;

    String readString(InputStream inputStream, int i3, String str) throws IOException;

    void skip(InputStream inputStream, int i3) throws IOException;

    void writeFloat(OutputStream outputStream, float f16) throws IOException;

    void writeFloat(OutputStream outputStream, float f16, boolean z16) throws IOException;

    void writeInt(OutputStream outputStream, long j3) throws IOException;

    void writeInt(OutputStream outputStream, long j3, boolean z16) throws IOException;

    void writeNumber(OutputStream outputStream, long j3, int i3, boolean z16) throws IOException;

    void writeShort(OutputStream outputStream, int i3) throws IOException;

    void writeShort(OutputStream outputStream, int i3, boolean z16) throws IOException;
}

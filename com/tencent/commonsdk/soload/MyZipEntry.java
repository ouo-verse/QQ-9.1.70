package com.tencent.commonsdk.soload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public class MyZipEntry implements MyZipConstants, Cloneable {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFLATED = 8;
    public static final int STORED = 0;
    String comment;
    int commentLength;
    long compressedSize;
    int compressionMethod;
    long crc;
    int diskNumbers;
    long externalFileAttri;
    byte[] extra;
    int extraLength;
    int flags;
    boolean hasDD;
    int internalFileAttri;
    long mLocContentSize;
    long mLocalHeaderRelOffset;
    int modDate;
    String name;
    byte[] nameBytes;
    int nameLength;
    long size;
    int time;
    int version;
    int versionMinimum;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MyZipEntry(byte[] bArr, InputStream inputStream) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr, (Object) inputStream);
            return;
        }
        this.compressedSize = -1L;
        this.crc = -1L;
        this.size = -1L;
        this.compressionMethod = -1;
        this.time = -1;
        this.modDate = -1;
        this.nameLength = -1;
        this.mLocalHeaderRelOffset = -1L;
        this.mLocContentSize = -1L;
        this.version = -1;
        this.versionMinimum = -1;
        this.flags = -1;
        this.extraLength = -1;
        this.commentLength = -1;
        this.diskNumbers = -1;
        this.internalFileAttri = -1;
        this.externalFileAttri = -1L;
        this.hasDD = false;
        Streams.readFully(inputStream, bArr, 0, bArr.length);
        HeapBufferIterator it = HeapBufferIterator.iterator(bArr, 0, bArr.length, ByteOrder.LITTLE_ENDIAN);
        it.readInt();
        this.version = it.readShort();
        this.versionMinimum = it.readShort();
        this.flags = it.readShort();
        this.compressionMethod = it.readShort();
        this.time = it.readShort();
        this.modDate = it.readShort();
        this.crc = it.readInt() & 4294967295L;
        this.compressedSize = it.readInt() & 4294967295L;
        this.size = it.readInt() & 4294967295L;
        this.nameLength = it.readShort();
        this.extraLength = it.readShort();
        this.commentLength = it.readShort();
        this.diskNumbers = it.readShort();
        this.internalFileAttri = it.readShort();
        this.externalFileAttri = it.readInt() & 4294967295L;
        this.mLocalHeaderRelOffset = it.readInt() & 4294967295L;
        byte[] bArr2 = new byte[this.nameLength];
        this.nameBytes = bArr2;
        Streams.readFully(inputStream, bArr2, 0, bArr2.length);
        byte[] bArr3 = this.nameBytes;
        this.name = new String(bArr3, 0, bArr3.length, "UTF-8");
        int i3 = this.commentLength;
        if (i3 > 0) {
            byte[] bArr4 = new byte[i3];
            Streams.readFully(inputStream, bArr4, 0, i3);
            this.comment = new String(bArr4, 0, i3, "UTF-8");
        }
        int i16 = this.extraLength;
        if (i16 > 0) {
            byte[] bArr5 = new byte[i16];
            this.extra = bArr5;
            Streams.readFully(inputStream, bArr5, 0, i16);
        }
    }

    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.name;
    }

    public long getSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.size;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.name;
    }
}

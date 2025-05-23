package com.tencent.commonsdk.soload;

import com.tencent.commonsdk.zip.QZipIOException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public class MyZipFile implements MyZipConstants {
    static IPatchRedirector $redirector_ = null;
    static final int GPBF_DATA_DESCRIPTOR_FLAG = 8;
    static final int GPBF_UTF8_FLAG = 2048;
    public static final int OPEN_DELETE = 4;
    public static final int OPEN_READ = 1;
    private MyZipEntry desentry;
    private final String fileName;
    private File fileToDeleteOnClose;
    private String libname;
    private final LinkedHashMap<String, MyZipEntry> mEntries;
    private RandomAccessFile mRaf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class RAFStream extends InputStream {
        static IPatchRedirector $redirector_;
        long mLength;
        long mOffset;
        RandomAccessFile mSharedRaf;

        public RAFStream(RandomAccessFile randomAccessFile, long j3) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, randomAccessFile, Long.valueOf(j3));
                return;
            }
            this.mSharedRaf = randomAccessFile;
            this.mOffset = j3;
            this.mLength = randomAccessFile.length();
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (this.mOffset < this.mLength) {
                return 1;
            }
            return 0;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? Streams.readSingleByte(this) : ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }

        @Override // java.io.InputStream
        public long skip(long j3) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, j3)).longValue();
            }
            long j16 = this.mLength;
            long j17 = this.mOffset;
            if (j3 > j16 - j17) {
                j3 = j16 - j17;
            }
            this.mOffset = j17 + j3;
            return j3;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i16) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
            }
            synchronized (this.mSharedRaf) {
                this.mSharedRaf.seek(this.mOffset);
                long j3 = i16;
                long j16 = this.mLength;
                long j17 = this.mOffset;
                if (j3 > j16 - j17) {
                    i16 = (int) (j16 - j17);
                }
                int read = this.mSharedRaf.read(bArr, i3, i16);
                if (read <= 0) {
                    return -1;
                }
                this.mOffset += read;
                return read;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class ZipInflaterInputStream extends InflaterInputStream {
        static IPatchRedirector $redirector_;
        long bytesRead;
        MyZipEntry entry;

        public ZipInflaterInputStream(InputStream inputStream, Inflater inflater, int i3, MyZipEntry myZipEntry) {
            super(inputStream, inflater, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, inputStream, inflater, Integer.valueOf(i3), myZipEntry);
            } else {
                this.bytesRead = 0L;
                this.entry = myZipEntry;
            }
        }

        @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            if (super.available() == 0) {
                return 0;
            }
            return (int) (this.entry.getSize() - this.bytesRead);
        }

        @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i3, int i16) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
            }
            int read = super.read(bArr, i3, i16);
            if (read != -1) {
                this.bytesRead += read;
            }
            return read;
        }
    }

    public MyZipFile(File file, String str) throws ZipException, IOException {
        this(file, 1, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) file, (Object) str);
    }

    private void checkNotClosed() {
        if (this.mRaf != null) {
        } else {
            throw new IllegalStateException("Zip file closed");
        }
    }

    private void readCentralDir() throws IOException {
        long length = this.mRaf.length() - 22;
        long j3 = 0;
        if (length >= 0) {
            long j16 = length - 65536;
            if (j16 >= 0) {
                j3 = j16;
            }
            do {
                this.mRaf.seek(length);
                if (Integer.reverseBytes(this.mRaf.readInt()) == 101010256) {
                    byte[] bArr = new byte[18];
                    this.mRaf.readFully(bArr);
                    HeapBufferIterator it = HeapBufferIterator.iterator(bArr, 0, 18, ByteOrder.LITTLE_ENDIAN);
                    short readShort = it.readShort();
                    short readShort2 = it.readShort();
                    short readShort3 = it.readShort();
                    short readShort4 = it.readShort();
                    it.skip(4);
                    int readInt = it.readInt();
                    if (readShort3 == readShort4 && readShort == 0 && readShort2 == 0) {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new RAFStream(this.mRaf, readInt), 4096);
                        byte[] bArr2 = new byte[46];
                        for (int i3 = 0; i3 < readShort3; i3++) {
                            MyZipEntry myZipEntry = new MyZipEntry(bArr2, bufferedInputStream);
                            this.mEntries.put(myZipEntry.getName(), myZipEntry);
                            if (myZipEntry.getName().equals(this.libname)) {
                                this.desentry = myZipEntry;
                                return;
                            }
                            myZipEntry.getName().contains(RFixConstants.SO_PATH);
                        }
                        return;
                    }
                    throw new ZipException("spanned archives not supported");
                }
                length--;
            } while (length >= j3);
            throw new ZipException("EOCD not found; not a Zip archive?");
        }
        throw new ZipException("too short to be Zip");
    }

    public void closeResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        RandomAccessFile randomAccessFile = this.mRaf;
        if (randomAccessFile == null) {
            return;
        }
        try {
            randomAccessFile.close();
        } catch (IOException e16) {
            QLog.e(SoLoadCore.TAG, 1, e16, new Object[0]);
        }
    }

    public MyZipEntry getDesEntry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MyZipEntry) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.desentry;
    }

    public MyZipEntry getEntry(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MyZipEntry) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        checkNotClosed();
        str.getClass();
        MyZipEntry myZipEntry = this.mEntries.get(str);
        if (myZipEntry == null) {
            return this.mEntries.get(str + "/");
        }
        return myZipEntry;
    }

    public InputStream getInputStream(MyZipEntry myZipEntry) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (InputStream) iPatchRedirector.redirect((short) 6, (Object) this, (Object) myZipEntry);
        }
        MyZipEntry entry = getEntry(myZipEntry.getName());
        if (entry == null) {
            return null;
        }
        String name = entry.getName();
        if (name != null && (name.contains("../") || name.contains("..\\"))) {
            throw new QZipIOException();
        }
        RandomAccessFile randomAccessFile = this.mRaf;
        synchronized (randomAccessFile) {
            RAFStream rAFStream = new RAFStream(randomAccessFile, entry.mLocalHeaderRelOffset + 28);
            DataInputStream dataInputStream = new DataInputStream(rAFStream);
            short reverseBytes = Short.reverseBytes(dataInputStream.readShort());
            dataInputStream.close();
            rAFStream.skip(entry.nameLength + reverseBytes);
            rAFStream.mLength = rAFStream.mOffset + entry.compressedSize;
            if (entry.compressionMethod == 8) {
                return new ZipInflaterInputStream(rAFStream, new Inflater(true), Math.max(1024, (int) Math.min(entry.getSize(), WebSocketProtocol.PAYLOAD_SHORT_MAX)), entry);
            }
            return rAFStream;
        }
    }

    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.fileName;
    }

    public MyZipFile(File file, int i3, String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, file, Integer.valueOf(i3), str);
            return;
        }
        this.desentry = null;
        this.mEntries = new LinkedHashMap<>();
        this.libname = str;
        String path = file.getPath();
        this.fileName = path;
        if (i3 != 1 && i3 != 5) {
            throw new IllegalArgumentException();
        }
        if ((i3 & 4) != 0) {
            this.fileToDeleteOnClose = file;
        } else {
            this.fileToDeleteOnClose = null;
        }
        this.mRaf = new RandomAccessFile(path, "r");
        readCentralDir();
    }

    public MyZipFile(String str, String str2) throws IOException {
        this(new File(str), 1, str2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
    }
}

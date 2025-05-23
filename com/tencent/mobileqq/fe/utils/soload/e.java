package com.tencent.mobileqq.fe.utils.soload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
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
/* loaded from: classes12.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f205858a;

    /* renamed from: b, reason: collision with root package name */
    private final LinkedHashMap<String, d> f205859b;

    /* renamed from: c, reason: collision with root package name */
    private String f205860c;

    /* renamed from: d, reason: collision with root package name */
    private File f205861d;

    /* renamed from: e, reason: collision with root package name */
    private RandomAccessFile f205862e;

    /* renamed from: f, reason: collision with root package name */
    private d f205863f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a extends InputStream {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        RandomAccessFile f205864d;

        /* renamed from: e, reason: collision with root package name */
        long f205865e;

        /* renamed from: f, reason: collision with root package name */
        long f205866f;

        a(RandomAccessFile randomAccessFile, long j3) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, randomAccessFile, Long.valueOf(j3));
                return;
            }
            this.f205864d = randomAccessFile;
            this.f205865e = j3;
            this.f205866f = randomAccessFile.length();
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (this.f205865e < this.f205866f) {
                return 1;
            }
            return 0;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? g.b(this) : ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }

        @Override // java.io.InputStream
        public long skip(long j3) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, j3)).longValue();
            }
            long j16 = this.f205866f;
            long j17 = this.f205865e;
            if (j3 > j16 - j17) {
                j3 = j16 - j17;
            }
            this.f205865e = j17 + j3;
            return j3;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i16) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
            }
            synchronized (this.f205864d) {
                this.f205864d.seek(this.f205865e);
                long j3 = i16;
                long j16 = this.f205866f;
                long j17 = this.f205865e;
                if (j3 > j16 - j17) {
                    i16 = (int) (j16 - j17);
                }
                int read = this.f205864d.read(bArr, i3, i16);
                if (read <= 0) {
                    return -1;
                }
                this.f205865e += read;
                return read;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b extends InflaterInputStream {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        d f205867d;

        /* renamed from: e, reason: collision with root package name */
        long f205868e;

        b(InputStream inputStream, Inflater inflater, int i3, d dVar) {
            super(inputStream, inflater, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, inputStream, inflater, Integer.valueOf(i3), dVar);
            } else {
                this.f205868e = 0L;
                this.f205867d = dVar;
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
            return (int) (this.f205867d.b() - this.f205868e);
        }

        @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i3, int i16) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
            }
            int read = super.read(bArr, i3, i16);
            if (read != -1) {
                this.f205868e += read;
            }
            return read;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(File file, String str) throws IOException {
        this(file, 1, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) file, (Object) str);
    }

    private void a() {
        if (this.f205862e != null) {
        } else {
            throw new IllegalStateException("Zip file closed");
        }
    }

    private void f() throws IOException {
        long length = this.f205862e.length() - 22;
        long j3 = 0;
        if (length >= 0) {
            long j16 = length - 65536;
            if (j16 >= 0) {
                j3 = j16;
            }
            do {
                this.f205862e.seek(length);
                if (Integer.reverseBytes(this.f205862e.readInt()) == 101010256) {
                    byte[] bArr = new byte[18];
                    this.f205862e.readFully(bArr);
                    com.tencent.mobileqq.fe.utils.soload.b d16 = com.tencent.mobileqq.fe.utils.soload.b.d(bArr, 0, 18, ByteOrder.LITTLE_ENDIAN);
                    short b16 = d16.b();
                    short b17 = d16.b();
                    short b18 = d16.b();
                    short b19 = d16.b();
                    d16.c(4);
                    int a16 = d16.a();
                    if (b18 == b19 && b16 == 0 && b17 == 0) {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new a(this.f205862e, a16), 4096);
                        byte[] bArr2 = new byte[46];
                        for (int i3 = 0; i3 < b18; i3++) {
                            d dVar = new d(bArr2, bufferedInputStream);
                            this.f205859b.put(dVar.a(), dVar);
                            if (dVar.a().equals(this.f205860c)) {
                                this.f205863f = dVar;
                                return;
                            }
                            dVar.a().contains(RFixConstants.SO_PATH);
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

    public void b() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        RandomAccessFile randomAccessFile = this.f205862e;
        if (randomAccessFile != null) {
            synchronized (randomAccessFile) {
                this.f205862e = null;
                randomAccessFile.close();
            }
            File file = this.f205861d;
            if (file != null) {
                file.delete();
                this.f205861d = null;
            }
        }
    }

    public d c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (d) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f205863f;
    }

    public d d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (d) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        a();
        str.getClass();
        d dVar = this.f205859b.get(str);
        if (dVar == null) {
            return this.f205859b.get(str + "/");
        }
        return dVar;
    }

    public InputStream e(d dVar) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (InputStream) iPatchRedirector.redirect((short) 7, (Object) this, (Object) dVar);
        }
        d d16 = d(dVar.a());
        if (d16 == null) {
            return null;
        }
        String a16 = d16.a();
        if (a16 != null && (a16.contains("../") || a16.contains("..\\"))) {
            throw new QZipIOException();
        }
        RandomAccessFile randomAccessFile = this.f205862e;
        synchronized (randomAccessFile) {
            a aVar = new a(randomAccessFile, d16.G + 28);
            DataInputStream dataInputStream = new DataInputStream(aVar);
            short reverseBytes = Short.reverseBytes(dataInputStream.readShort());
            dataInputStream.close();
            aVar.skip(d16.F + reverseBytes);
            aVar.f205866f = aVar.f205865e + d16.f205854f;
            if (d16.f205857m == 8) {
                return new b(aVar, new Inflater(true), Math.max(1024, (int) Math.min(d16.b(), WebSocketProtocol.PAYLOAD_SHORT_MAX)), d16);
            }
            return aVar;
        }
    }

    protected void finalize() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            super.finalize();
        } catch (Throwable th5) {
            throw new AssertionError(th5);
        }
    }

    e(File file, int i3, String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, file, Integer.valueOf(i3), str);
            return;
        }
        this.f205859b = new LinkedHashMap<>();
        this.f205863f = null;
        this.f205860c = str;
        String path = file.getPath();
        this.f205858a = path;
        if (i3 != 1 && i3 != 5) {
            throw new IllegalArgumentException();
        }
        if ((i3 & 4) != 0) {
            this.f205861d = file;
        } else {
            this.f205861d = null;
        }
        this.f205862e = new RandomAccessFile(path, "r");
        f();
    }
}

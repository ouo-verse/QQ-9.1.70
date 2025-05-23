package common.qzone.component.cache.common;

import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.Adler32;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a implements Closeable {
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private RandomAccessFile H;
    private RandomAccessFile I;
    private int J;
    private int K;
    private byte[] L = new byte[32];
    private byte[] M = new byte[20];
    private Adler32 N = new Adler32();
    private int P;
    private int Q;

    /* renamed from: d, reason: collision with root package name */
    private RandomAccessFile f390052d;

    /* renamed from: e, reason: collision with root package name */
    private RandomAccessFile f390053e;

    /* renamed from: f, reason: collision with root package name */
    private RandomAccessFile f390054f;

    /* renamed from: h, reason: collision with root package name */
    private FileChannel f390055h;

    /* renamed from: i, reason: collision with root package name */
    private MappedByteBuffer f390056i;

    /* renamed from: m, reason: collision with root package name */
    private int f390057m;

    /* compiled from: P */
    /* renamed from: common.qzone.component.cache.common.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static class C10099a {

        /* renamed from: a, reason: collision with root package name */
        public long f390058a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f390059b;

        /* renamed from: c, reason: collision with root package name */
        public int f390060c;
    }

    public a(String str, int i3, int i16, boolean z16, int i17) throws IOException {
        this.f390052d = new RandomAccessFile(str + ".idx", "rw");
        this.f390053e = new RandomAccessFile(str + ".0", "rw");
        this.f390054f = new RandomAccessFile(str + ".1", "rw");
        this.G = i17;
        if (!z16 && k()) {
            return;
        }
        p(i3, i16);
        if (k()) {
            return;
        }
        d();
        throw new IOException("unable to load index");
    }

    private void b(int i3) {
        byte[] bArr = new byte[1024];
        this.f390056i.position(i3);
        int i16 = this.f390057m * 12;
        while (i16 > 0) {
            int min = Math.min(i16, 1024);
            this.f390056i.put(bArr, 0, min);
            i16 -= min;
        }
    }

    private void d() {
        e(this.f390055h);
        e(this.f390052d);
        e(this.f390053e);
        e(this.f390054f);
    }

    static void e(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    private void g() throws IOException {
        int i3 = 1 - this.D;
        this.D = i3;
        this.E = 0;
        this.F = 4;
        u(this.L, 12, i3);
        u(this.L, 16, this.E);
        u(this.L, 20, this.F);
        t();
        q();
        b(this.J);
        s();
    }

    private boolean h(RandomAccessFile randomAccessFile, int i3, C10099a c10099a) throws IOException {
        byte[] bArr = this.M;
        long filePointer = randomAccessFile.getFilePointer();
        try {
            randomAccessFile.seek(i3);
            if (randomAccessFile.read(bArr) != 20) {
                return false;
            }
            if (o(bArr, 0) != c10099a.f390058a) {
                return false;
            }
            int n3 = n(bArr, 8);
            if (n(bArr, 12) != i3) {
                return false;
            }
            int n16 = n(bArr, 16);
            if (n16 >= 0 && n16 <= (this.C - i3) - 20) {
                byte[] bArr2 = c10099a.f390059b;
                if (bArr2 == null || bArr2.length < n16) {
                    c10099a.f390059b = new byte[n16];
                }
                byte[] bArr3 = c10099a.f390059b;
                c10099a.f390060c = n16;
                if (randomAccessFile.read(bArr3, 0, n16) != n16) {
                    return false;
                }
                if (a(bArr3, 0, n16) != n3) {
                    return false;
                }
                randomAccessFile.seek(filePointer);
                return true;
            }
            return false;
        } catch (Throwable th5) {
            try {
                QLog.e("BlobCache", 2, "getBlob failed.", th5);
                return false;
            } finally {
                randomAccessFile.seek(filePointer);
            }
        }
    }

    private void j(long j3, byte[] bArr, int i3) throws IOException {
        byte[] bArr2 = this.M;
        int a16 = a(bArr, 0, i3);
        v(bArr2, 0, j3);
        u(bArr2, 8, a16);
        u(bArr2, 12, this.F);
        u(bArr2, 16, i3);
        this.H.write(bArr2);
        this.H.write(bArr, 0, i3);
        this.f390056i.putLong(this.P, j3);
        this.f390056i.putInt(this.P + 8, this.F);
        int i16 = this.F + i3 + 20;
        this.F = i16;
        u(this.L, 20, i16);
    }

    private boolean k() {
        int i3;
        int i16;
        int i17;
        int i18;
        try {
            this.f390052d.seek(0L);
            this.f390053e.seek(0L);
            this.f390054f.seek(0L);
            byte[] bArr = this.L;
            if (this.f390052d.read(bArr) != 32 || n(bArr, 0) != -1289277377 || n(bArr, 24) != this.G) {
                return false;
            }
            this.f390057m = n(bArr, 4);
            this.C = n(bArr, 8);
            this.D = n(bArr, 12);
            this.E = n(bArr, 16);
            this.F = n(bArr, 20);
            if (a(bArr, 0, 28) != n(bArr, 28) || (i3 = this.f390057m) <= 0 || (i16 = this.C) <= 0) {
                return false;
            }
            int i19 = this.D;
            if ((i19 != 0 && i19 != 1) || (i17 = this.E) < 0 || i17 > i3 || (i18 = this.F) < 4 || i18 > i16 || this.f390052d.length() != (this.f390057m * 12 * 2) + 32) {
                return false;
            }
            byte[] bArr2 = new byte[4];
            if (this.f390053e.read(bArr2) != 4 || n(bArr2, 0) != -1121680097 || this.f390054f.read(bArr2) != 4 || n(bArr2, 0) != -1121680097) {
                return false;
            }
            FileChannel channel = this.f390052d.getChannel();
            this.f390055h = channel;
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, this.f390052d.length());
            this.f390056i = map;
            map.order(ByteOrder.LITTLE_ENDIAN);
            q();
            return true;
        } catch (IOException e16) {
            QLog.e("BlobCache", 2, "loadIndex failed.", e16);
            return false;
        }
    }

    private boolean m(long j3, int i3) {
        int i16 = this.f390057m;
        int i17 = (int) (j3 % i16);
        if (i17 < 0) {
            i17 += i16;
        }
        int i18 = i17;
        while (true) {
            int i19 = (i18 * 12) + i3;
            long j16 = this.f390056i.getLong(i19);
            int i26 = this.f390056i.getInt(i19 + 8);
            if (i26 == 0) {
                this.P = i19;
                return false;
            }
            if (j16 == j3) {
                this.P = i19;
                this.Q = i26;
                return true;
            }
            i18++;
            if (i18 >= this.f390057m) {
                i18 = 0;
            }
            if (i18 == i17) {
                this.f390056i.putInt((i18 * 12) + i3 + 8, 0);
            }
        }
    }

    static int n(byte[] bArr, int i3) {
        return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
    }

    static long o(byte[] bArr, int i3) {
        long j3 = bArr[i3 + 7] & 255;
        for (int i16 = 6; i16 >= 0; i16--) {
            j3 = (j3 << 8) | (bArr[i3 + i16] & 255);
        }
        return j3;
    }

    private void p(int i3, int i16) throws IOException {
        this.f390052d.setLength(0L);
        this.f390052d.setLength((i3 * 12 * 2) + 32);
        this.f390052d.seek(0L);
        byte[] bArr = this.L;
        u(bArr, 0, -1289277377);
        u(bArr, 4, i3);
        u(bArr, 8, i16);
        u(bArr, 12, 0);
        u(bArr, 16, 0);
        u(bArr, 20, 4);
        u(bArr, 24, this.G);
        u(bArr, 28, a(bArr, 0, 28));
        this.f390052d.write(bArr);
        this.f390053e.setLength(0L);
        this.f390054f.setLength(0L);
        this.f390053e.seek(0L);
        this.f390054f.seek(0L);
        u(bArr, 0, -1121680097);
        this.f390053e.write(bArr, 0, 4);
        this.f390054f.write(bArr, 0, 4);
    }

    private void q() throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        int i3 = this.D;
        if (i3 == 0) {
            randomAccessFile = this.f390053e;
        } else {
            randomAccessFile = this.f390054f;
        }
        this.H = randomAccessFile;
        if (i3 == 1) {
            randomAccessFile2 = this.f390053e;
        } else {
            randomAccessFile2 = this.f390054f;
        }
        this.I = randomAccessFile2;
        randomAccessFile.setLength(this.F);
        this.H.seek(this.F);
        this.J = 32;
        this.K = 32;
        if (this.D == 0) {
            this.K = 32 + (this.f390057m * 12);
        } else {
            this.J = 32 + (this.f390057m * 12);
        }
    }

    private void t() {
        byte[] bArr = this.L;
        u(bArr, 28, a(bArr, 0, 28));
        this.f390056i.position(0);
        this.f390056i.put(this.L);
    }

    static void u(byte[] bArr, int i3, int i16) {
        for (int i17 = 0; i17 < 4; i17++) {
            bArr[i3 + i17] = (byte) (i16 & 255);
            i16 >>= 8;
        }
    }

    static void v(byte[] bArr, int i3, long j3) {
        for (int i16 = 0; i16 < 8; i16++) {
            bArr[i3 + i16] = (byte) (255 & j3);
            j3 >>= 8;
        }
    }

    int a(byte[] bArr, int i3, int i16) {
        this.N.reset();
        this.N.update(bArr, i3, i16);
        return (int) this.N.getValue();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        r();
        d();
    }

    public void i(long j3, byte[] bArr) throws IOException {
        int length = bArr.length + 24;
        int i3 = this.C;
        if (length <= i3) {
            if (this.F + 20 + bArr.length > i3 || this.E * 2 >= this.f390057m) {
                g();
            }
            if (!m(j3, this.J)) {
                int i16 = this.E + 1;
                this.E = i16;
                u(this.L, 16, i16);
            }
            j(j3, bArr, bArr.length);
            t();
            return;
        }
        throw new RuntimeException("blob is too large!");
    }

    public boolean l(C10099a c10099a) throws IOException {
        if (m(c10099a.f390058a, this.J) && h(this.H, this.Q, c10099a)) {
            return true;
        }
        int i3 = this.P;
        if (m(c10099a.f390058a, this.K) && h(this.I, this.Q, c10099a)) {
            int i16 = this.F + 20;
            int i17 = c10099a.f390060c;
            if (i16 + i17 <= this.C && this.E * 2 < this.f390057m) {
                this.P = i3;
                try {
                    j(c10099a.f390058a, c10099a.f390059b, i17);
                    int i18 = this.E + 1;
                    this.E = i18;
                    u(this.L, 16, i18);
                    t();
                } catch (Throwable unused) {
                    QLog.e("BlobCache", 2, "cannot copy over");
                }
            }
            return true;
        }
        return false;
    }

    public void r() {
        s();
        try {
            this.f390053e.getFD().sync();
        } catch (Throwable unused) {
        }
        try {
            this.f390054f.getFD().sync();
        } catch (Throwable unused2) {
        }
    }

    public void s() {
        try {
            this.f390056i.force();
        } catch (Throwable unused) {
        }
    }
}

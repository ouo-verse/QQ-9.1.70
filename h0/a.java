package h0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReference<byte[]> f403940a = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final int f403943a;

        /* renamed from: b, reason: collision with root package name */
        final int f403944b;

        /* renamed from: c, reason: collision with root package name */
        final byte[] f403945c;

        b(@NonNull byte[] bArr, int i3, int i16) {
            this.f403945c = bArr;
            this.f403943a = i3;
            this.f403944b = i16;
        }
    }

    @NonNull
    public static ByteBuffer a(@NonNull File file) throws IOException {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length <= TTL.MAX_VALUE) {
                if (length != 0) {
                    randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        fileChannel = randomAccessFile.getChannel();
                        MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                        try {
                            fileChannel.close();
                        } catch (IOException unused) {
                        }
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused2) {
                        }
                        return load;
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                                throw th;
                            } catch (IOException unused4) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                }
                throw new IOException("File unsuitable for memory mapping");
            }
            throw new IOException("File too large to map into memory");
        } catch (Throwable th6) {
            th = th6;
            randomAccessFile = null;
        }
    }

    @NonNull
    public static ByteBuffer b(@NonNull InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = f403940a.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(andSet);
            if (read >= 0) {
                byteArrayOutputStream.write(andSet, 0, read);
            } else {
                f403940a.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return (ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
            }
        }
    }

    @Nullable
    private static b c(@NonNull ByteBuffer byteBuffer) {
        if (!byteBuffer.isReadOnly() && byteBuffer.hasArray()) {
            return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        }
        return null;
    }

    @NonNull
    public static byte[] d(@NonNull ByteBuffer byteBuffer) {
        b c16 = c(byteBuffer);
        if (c16 != null && c16.f403943a == 0 && c16.f403944b == c16.f403945c.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static void e(@NonNull ByteBuffer byteBuffer, @NonNull File file) throws IOException {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th5) {
            th = th5;
            randomAccessFile = null;
        }
        try {
            fileChannel = randomAccessFile.getChannel();
            fileChannel.write(byteBuffer);
            fileChannel.force(false);
            fileChannel.close();
            randomAccessFile.close();
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th6) {
            th = th6;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused3) {
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
            throw th;
        }
    }

    @NonNull
    public static InputStream f(@NonNull ByteBuffer byteBuffer) {
        return new C10404a(byteBuffer);
    }

    /* compiled from: P */
    /* renamed from: h0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C10404a extends InputStream {

        /* renamed from: d, reason: collision with root package name */
        @NonNull
        private final ByteBuffer f403941d;

        /* renamed from: e, reason: collision with root package name */
        private int f403942e = -1;

        C10404a(@NonNull ByteBuffer byteBuffer) {
            this.f403941d = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f403941d.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i3) {
            this.f403942e = this.f403941d.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f403941d.hasRemaining()) {
                return this.f403941d.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            int i3 = this.f403942e;
            if (i3 != -1) {
                this.f403941d.position(i3);
            } else {
                throw new IOException("Cannot reset to unset mark position");
            }
        }

        @Override // java.io.InputStream
        public long skip(long j3) throws IOException {
            if (!this.f403941d.hasRemaining()) {
                return -1L;
            }
            long min = Math.min(j3, available());
            this.f403941d.position((int) (r0.position() + min));
            return min;
        }

        @Override // java.io.InputStream
        public int read(@NonNull byte[] bArr, int i3, int i16) throws IOException {
            if (!this.f403941d.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i16, available());
            this.f403941d.get(bArr, i3, min);
            return min;
        }
    }
}

package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f31779a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f31780b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface Reader {

        /* loaded from: classes.dex */
        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1;

            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        short a() throws IOException;

        int b() throws IOException;

        int read(byte[] bArr, int i3) throws IOException;

        long skip(long j3) throws IOException;
    }

    /* loaded from: classes.dex */
    private static final class a implements Reader {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f31781a;

        a(ByteBuffer byteBuffer) {
            this.f31781a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short a() throws Reader.EndOfFileException {
            if (this.f31781a.remaining() >= 1) {
                return (short) (this.f31781a.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int b() throws Reader.EndOfFileException {
            return (a() << 8) | a();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i3) {
            int min = Math.min(i3, this.f31781a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f31781a.get(bArr, 0, min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j3) {
            int min = (int) Math.min(this.f31781a.remaining(), j3);
            ByteBuffer byteBuffer = this.f31781a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f31782a;

        b(byte[] bArr, int i3) {
            this.f31782a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i3);
        }

        private boolean c(int i3, int i16) {
            if (this.f31782a.remaining() - i3 >= i16) {
                return true;
            }
            return false;
        }

        short a(int i3) {
            if (c(i3, 2)) {
                return this.f31782a.getShort(i3);
            }
            return (short) -1;
        }

        int b(int i3) {
            if (c(i3, 4)) {
                return this.f31782a.getInt(i3);
            }
            return -1;
        }

        int d() {
            return this.f31782a.remaining();
        }

        void e(ByteOrder byteOrder) {
            this.f31782a.order(byteOrder);
        }
    }

    /* loaded from: classes.dex */
    private static final class c implements Reader {

        /* renamed from: a, reason: collision with root package name */
        private final InputStream f31783a;

        c(InputStream inputStream) {
            this.f31783a = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short a() throws IOException {
            int read = this.f31783a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int b() throws IOException {
            return (a() << 8) | a();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i3) throws IOException {
            int i16 = 0;
            int i17 = 0;
            while (i16 < i3 && (i17 = this.f31783a.read(bArr, i16, i3 - i16)) != -1) {
                i16 += i17;
            }
            if (i16 == 0 && i17 == -1) {
                throw new Reader.EndOfFileException();
            }
            return i16;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j3) throws IOException {
            if (j3 < 0) {
                return 0L;
            }
            long j16 = j3;
            while (j16 > 0) {
                long skip = this.f31783a.skip(j16);
                if (skip <= 0) {
                    if (this.f31783a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j16 -= skip;
            }
            return j3 - j16;
        }
    }

    private static int b(int i3, int i16) {
        return i3 + 2 + (i16 * 12);
    }

    private int c(Reader reader, r.b bVar) throws IOException {
        try {
            int b16 = reader.b();
            if (!e(b16)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + b16);
                }
                return -1;
            }
            int g16 = g(reader);
            if (g16 == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) bVar.b(g16, byte[].class);
            try {
                return i(reader, bArr, g16);
            } finally {
                bVar.put(bArr);
            }
        } catch (Reader.EndOfFileException unused) {
            return -1;
        }
    }

    @NonNull
    private ImageHeaderParser.ImageType d(Reader reader) throws IOException {
        try {
            int b16 = reader.b();
            if (b16 == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int a16 = (b16 << 8) | reader.a();
            if (a16 == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int a17 = (a16 << 8) | reader.a();
            if (a17 == -1991225785) {
                reader.skip(21L);
                try {
                    if (reader.a() >= 3) {
                        return ImageHeaderParser.ImageType.PNG_A;
                    }
                    return ImageHeaderParser.ImageType.PNG;
                } catch (Reader.EndOfFileException unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (a17 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            reader.skip(4L);
            if (((reader.b() << 16) | reader.b()) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int b17 = (reader.b() << 16) | reader.b();
            if ((b17 & (-256)) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i3 = b17 & 255;
            if (i3 == 88) {
                reader.skip(4L);
                if ((reader.a() & 16) != 0) {
                    return ImageHeaderParser.ImageType.WEBP_A;
                }
                return ImageHeaderParser.ImageType.WEBP;
            }
            if (i3 == 76) {
                reader.skip(4L);
                if ((reader.a() & 8) != 0) {
                    return ImageHeaderParser.ImageType.WEBP_A;
                }
                return ImageHeaderParser.ImageType.WEBP;
            }
            return ImageHeaderParser.ImageType.WEBP;
        } catch (Reader.EndOfFileException unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    private static boolean e(int i3) {
        if ((i3 & 65496) != 65496 && i3 != 19789 && i3 != 18761) {
            return false;
        }
        return true;
    }

    private boolean f(byte[] bArr, int i3) {
        boolean z16;
        if (bArr != null && i3 > f31779a.length) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            int i16 = 0;
            while (true) {
                byte[] bArr2 = f31779a;
                if (i16 >= bArr2.length) {
                    break;
                }
                if (bArr[i16] != bArr2[i16]) {
                    return false;
                }
                i16++;
            }
        }
        return z16;
    }

    private int g(Reader reader) throws IOException {
        short a16;
        int b16;
        long j3;
        long skip;
        do {
            short a17 = reader.a();
            if (a17 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) a17));
                }
                return -1;
            }
            a16 = reader.a();
            if (a16 == 218) {
                return -1;
            }
            if (a16 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            b16 = reader.b() - 2;
            if (a16 != 225) {
                j3 = b16;
                skip = reader.skip(j3);
            } else {
                return b16;
            }
        } while (skip == j3);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) a16) + ", wanted to skip: " + b16 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    private static int h(b bVar) {
        ByteOrder byteOrder;
        short a16 = bVar.a(6);
        if (a16 != 18761) {
            if (a16 != 19789) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) a16));
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.BIG_ENDIAN;
            }
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.e(byteOrder);
        int b16 = bVar.b(10) + 6;
        short a17 = bVar.a(b16);
        for (int i3 = 0; i3 < a17; i3++) {
            int b17 = b(b16, i3);
            short a18 = bVar.a(b17);
            if (a18 == 274) {
                short a19 = bVar.a(b17 + 2);
                if (a19 >= 1 && a19 <= 12) {
                    int b18 = bVar.b(b17 + 4);
                    if (b18 < 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i3 + " tagType=" + ((int) a18) + " formatCode=" + ((int) a19) + " componentCount=" + b18);
                        }
                        int i16 = b18 + f31780b[a19];
                        if (i16 > 4) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) a19));
                            }
                        } else {
                            int i17 = b17 + 8;
                            if (i17 >= 0 && i17 <= bVar.d()) {
                                if (i16 >= 0 && i16 + i17 <= bVar.d()) {
                                    return bVar.a(i17);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) a18));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i17 + " tagType=" + ((int) a18));
                            }
                        }
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) a19));
                }
            }
        }
        return -1;
    }

    private int i(Reader reader, byte[] bArr, int i3) throws IOException {
        int read = reader.read(bArr, i3);
        if (read != i3) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i3 + ", actually read: " + read);
            }
            return -1;
        }
        if (f(bArr, i3)) {
            return h(new b(bArr, i3));
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(@NonNull InputStream inputStream, @NonNull r.b bVar) throws IOException {
        return c(new c((InputStream) h0.j.d(inputStream)), (r.b) h0.j.d(bVar));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull InputStream inputStream) throws IOException {
        return d(new c((InputStream) h0.j.d(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull ByteBuffer byteBuffer) throws IOException {
        return d(new a((ByteBuffer) h0.j.d(byteBuffer)));
    }
}

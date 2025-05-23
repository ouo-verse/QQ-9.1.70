package com.tencent.hippy.qq.adapter.image.decoder;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ImageDetector {
    public static final int AVIF_AVIF = 1635150182;
    public static final int AVIF_AVIS = 1635150195;
    public static final int AVIF_FTYP = 1718909296;
    public static final String TAG = "ImageDetector";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class AvifFileType {
        public final int[] compatibleBrands;
        public final int ftyp;
        public final int majorBrand;
        public final int minorVersion;

        AvifFileType(int i3, int i16, int i17, int[] iArr) {
            this.ftyp = i3;
            this.majorBrand = i16;
            this.minorVersion = i17;
            this.compatibleBrands = iArr;
        }

        public boolean matchBrand(int i3) {
            for (int i16 : this.compatibleBrands) {
                if (i16 == i3) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class ByteBufferReader implements Reader {
        private final ByteBuffer byteBuffer;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.byteBuffer = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.tencent.hippy.qq.adapter.image.decoder.ImageDetector.Reader
        public int getInt16BE() throws IOException {
            return (getInt8() << 8) | getInt8();
        }

        @Override // com.tencent.hippy.qq.adapter.image.decoder.ImageDetector.Reader
        public int getInt16LE() throws IOException {
            return getInt8() | (getInt8() << 8);
        }

        @Override // com.tencent.hippy.qq.adapter.image.decoder.ImageDetector.Reader
        public int getInt32BE() throws IOException {
            return (getInt8() << 24) | (getInt8() << 16) | (getInt8() << 8) | getInt8();
        }

        @Override // com.tencent.hippy.qq.adapter.image.decoder.ImageDetector.Reader
        public int getInt32LE() throws IOException {
            return getInt8() | (getInt8() << 8) | (getInt8() << 16) | (getInt8() << 24);
        }

        @Override // com.tencent.hippy.qq.adapter.image.decoder.ImageDetector.Reader
        public int getInt8() throws IOException {
            if (this.byteBuffer.remaining() >= 1) {
                return this.byteBuffer.get();
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.tencent.hippy.qq.adapter.image.decoder.ImageDetector.Reader
        public int read(byte[] bArr, int i3) {
            int min = Math.min(i3, this.byteBuffer.remaining());
            if (min == 0) {
                return -1;
            }
            this.byteBuffer.get(bArr, 0, min);
            return min;
        }

        @Override // com.tencent.hippy.qq.adapter.image.decoder.ImageDetector.Reader
        public long skip(long j3) {
            int min = (int) Math.min(this.byteBuffer.remaining(), j3);
            ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface Reader {

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1;

            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int getInt16BE() throws IOException;

        int getInt16LE() throws IOException;

        int getInt32BE() throws IOException;

        int getInt32LE() throws IOException;

        int getInt8() throws IOException;

        int read(byte[] bArr, int i3) throws IOException;

        long skip(long j3) throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class StreamReader implements Reader {

        /* renamed from: is, reason: collision with root package name */
        private final InputStream f114008is;

        StreamReader(InputStream inputStream) {
            this.f114008is = inputStream;
        }

        @Override // com.tencent.hippy.qq.adapter.image.decoder.ImageDetector.Reader
        public int getInt16BE() throws IOException {
            return (getInt8() << 8) | getInt8();
        }

        @Override // com.tencent.hippy.qq.adapter.image.decoder.ImageDetector.Reader
        public int getInt16LE() throws IOException {
            return getInt8() | (getInt8() << 8);
        }

        @Override // com.tencent.hippy.qq.adapter.image.decoder.ImageDetector.Reader
        public int getInt32BE() throws IOException {
            return (getInt8() << 24) | (getInt8() << 16) | (getInt8() << 8) | getInt8();
        }

        @Override // com.tencent.hippy.qq.adapter.image.decoder.ImageDetector.Reader
        public int getInt32LE() throws IOException {
            return getInt8() | (getInt8() << 8) | (getInt8() << 16) | (getInt8() << 24);
        }

        @Override // com.tencent.hippy.qq.adapter.image.decoder.ImageDetector.Reader
        public int getInt8() throws IOException {
            int read = this.f114008is.read();
            if (read != -1) {
                return read;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.tencent.hippy.qq.adapter.image.decoder.ImageDetector.Reader
        public int read(byte[] bArr, int i3) throws IOException {
            int i16 = 0;
            int i17 = 0;
            while (i16 < i3 && (i17 = this.f114008is.read(bArr, i16, i3 - i16)) != -1) {
                i16 += i17;
            }
            if (i16 == 0 && i17 == -1) {
                throw new Reader.EndOfFileException();
            }
            return i16;
        }

        @Override // com.tencent.hippy.qq.adapter.image.decoder.ImageDetector.Reader
        public long skip(long j3) throws IOException {
            if (j3 < 0) {
                return 0L;
            }
            long j16 = j3;
            while (j16 > 0) {
                long skip = this.f114008is.skip(j16);
                if (skip <= 0) {
                    if (this.f114008is.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j16 -= skip;
            }
            return j3 - j16;
        }
    }

    private static int getInt32BE(byte[] bArr, int i3) {
        return bArr[i3 + 3] | (bArr[i3] << 24) | (bArr[i3 + 1] << RegisterType.UNINIT_REF) | (bArr[i3 + 2] << 8);
    }

    public static boolean isAvif(InputStream inputStream) {
        int i3;
        AvifFileType parseAvifFileType = parseAvifFileType(inputStream);
        if (parseAvifFileType != null && ((i3 = parseAvifFileType.majorBrand) == 1635150182 || i3 == 1635150195 || parseAvifFileType.matchBrand(AVIF_AVIF) || parseAvifFileType.matchBrand(AVIF_AVIS))) {
            return true;
        }
        return false;
    }

    public static boolean isAvifAnimated(ByteBuffer byteBuffer) {
        AvifFileType parseAvifFileType = parseAvifFileType(byteBuffer);
        if (parseAvifFileType != null && (parseAvifFileType.majorBrand == 1635150195 || parseAvifFileType.matchBrand(AVIF_AVIS))) {
            return true;
        }
        return false;
    }

    public static boolean isAvifStaticImage(ByteBuffer byteBuffer) {
        AvifFileType parseAvifFileType = parseAvifFileType(byteBuffer);
        if (parseAvifFileType != null && (parseAvifFileType.majorBrand == 1635150182 || parseAvifFileType.matchBrand(AVIF_AVIF))) {
            return true;
        }
        return false;
    }

    public static AvifFileType parseAvifFileType(InputStream inputStream) {
        return parseAvifFileType(new StreamReader(inputStream));
    }

    public static AvifFileType parseAvifFileType(ByteBuffer byteBuffer) {
        return parseAvifFileType(new ByteBufferReader(byteBuffer));
    }

    private static AvifFileType parseAvifFileType(Reader reader) {
        try {
            int int32BE = reader.getInt32BE();
            int int32BE2 = reader.getInt32BE();
            if (int32BE2 != 1718909296) {
                return null;
            }
            int int32BE3 = reader.getInt32BE();
            int int32BE4 = reader.getInt32BE();
            int i3 = int32BE - 16;
            if (i3 % 4 != 0) {
                return null;
            }
            byte[] bArr = new byte[i3];
            if (reader.read(bArr, i3) != i3) {
                return null;
            }
            int i16 = i3 / 4;
            int[] iArr = new int[i16];
            for (int i17 = 0; i17 < i16; i17++) {
                iArr[i17] = getInt32BE(bArr, i17 * 4);
            }
            return new AvifFileType(int32BE2, int32BE3, int32BE4, iArr);
        } catch (IOException e16) {
            QLog.e(TAG, 1, "parseAvifFileType, e:" + e16);
            return null;
        }
    }
}

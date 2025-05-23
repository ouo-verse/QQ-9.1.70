package org.apache.commons.io.input;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.io.ByteOrderMark;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BOMInputStream extends ProxyInputStream {
    private static final Comparator<ByteOrderMark> ByteOrderMarkLengthComparator = new Comparator<ByteOrderMark>() { // from class: org.apache.commons.io.input.BOMInputStream.1
        @Override // java.util.Comparator
        public int compare(ByteOrderMark byteOrderMark, ByteOrderMark byteOrderMark2) {
            int length = byteOrderMark.length();
            int length2 = byteOrderMark2.length();
            if (length > length2) {
                return -1;
            }
            return length2 > length ? 1 : 0;
        }
    };
    private final List<ByteOrderMark> boms;
    private ByteOrderMark byteOrderMark;
    private int fbIndex;
    private int fbLength;
    private int[] firstBytes;
    private final boolean include;
    private int markFbIndex;
    private boolean markedAtStart;

    public BOMInputStream(InputStream inputStream) {
        this(inputStream, false, ByteOrderMark.UTF_8);
    }

    private ByteOrderMark find() {
        for (ByteOrderMark byteOrderMark : this.boms) {
            if (matches(byteOrderMark)) {
                return byteOrderMark;
            }
        }
        return null;
    }

    private boolean matches(ByteOrderMark byteOrderMark) {
        for (int i3 = 0; i3 < byteOrderMark.length(); i3++) {
            if (byteOrderMark.get(i3) != this.firstBytes[i3]) {
                return false;
            }
        }
        return true;
    }

    private int readFirstBytes() throws IOException {
        getBOM();
        int i3 = this.fbIndex;
        if (i3 < this.fbLength) {
            int[] iArr = this.firstBytes;
            this.fbIndex = i3 + 1;
            return iArr[i3];
        }
        return -1;
    }

    public ByteOrderMark getBOM() throws IOException {
        if (this.firstBytes == null) {
            this.fbLength = 0;
            this.firstBytes = new int[this.boms.get(0).length()];
            int i3 = 0;
            while (true) {
                int[] iArr = this.firstBytes;
                if (i3 >= iArr.length) {
                    break;
                }
                iArr[i3] = ((FilterInputStream) this).in.read();
                this.fbLength++;
                if (this.firstBytes[i3] < 0) {
                    break;
                }
                i3++;
            }
            ByteOrderMark find = find();
            this.byteOrderMark = find;
            if (find != null && !this.include) {
                if (find.length() < this.firstBytes.length) {
                    this.fbIndex = this.byteOrderMark.length();
                } else {
                    this.fbLength = 0;
                }
            }
        }
        return this.byteOrderMark;
    }

    public String getBOMCharsetName() throws IOException {
        getBOM();
        ByteOrderMark byteOrderMark = this.byteOrderMark;
        if (byteOrderMark == null) {
            return null;
        }
        return byteOrderMark.getCharsetName();
    }

    public boolean hasBOM() throws IOException {
        return getBOM() != null;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i3) {
        boolean z16;
        this.markFbIndex = this.fbIndex;
        if (this.firstBytes == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.markedAtStart = z16;
        ((FilterInputStream) this).in.mark(i3);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int readFirstBytes = readFirstBytes();
        return readFirstBytes >= 0 ? readFirstBytes : ((FilterInputStream) this).in.read();
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        this.fbIndex = this.markFbIndex;
        if (this.markedAtStart) {
            this.firstBytes = null;
        }
        ((FilterInputStream) this).in.reset();
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j3) throws IOException {
        long j16;
        int i3 = 0;
        while (true) {
            j16 = i3;
            if (j3 <= j16 || readFirstBytes() < 0) {
                break;
            }
            i3++;
        }
        return ((FilterInputStream) this).in.skip(j3 - j16) + j16;
    }

    public BOMInputStream(InputStream inputStream, boolean z16) {
        this(inputStream, z16, ByteOrderMark.UTF_8);
    }

    public boolean hasBOM(ByteOrderMark byteOrderMark) throws IOException {
        if (this.boms.contains(byteOrderMark)) {
            getBOM();
            ByteOrderMark byteOrderMark2 = this.byteOrderMark;
            return byteOrderMark2 != null && byteOrderMark2.equals(byteOrderMark);
        }
        throw new IllegalArgumentException("Stream not configure to detect " + byteOrderMark);
    }

    public BOMInputStream(InputStream inputStream, ByteOrderMark... byteOrderMarkArr) {
        this(inputStream, false, byteOrderMarkArr);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        int i17 = 0;
        int i18 = 0;
        while (i16 > 0 && i17 >= 0) {
            i17 = readFirstBytes();
            if (i17 >= 0) {
                bArr[i3] = (byte) (i17 & 255);
                i16--;
                i18++;
                i3++;
            }
        }
        int read = ((FilterInputStream) this).in.read(bArr, i3, i16);
        if (read >= 0) {
            return i18 + read;
        }
        if (i18 > 0) {
            return i18;
        }
        return -1;
    }

    public BOMInputStream(InputStream inputStream, boolean z16, ByteOrderMark... byteOrderMarkArr) {
        super(inputStream);
        if (byteOrderMarkArr != null && byteOrderMarkArr.length != 0) {
            this.include = z16;
            List<ByteOrderMark> asList = Arrays.asList(byteOrderMarkArr);
            Collections.sort(asList, ByteOrderMarkLengthComparator);
            this.boms = asList;
            return;
        }
        throw new IllegalArgumentException("No BOMs specified");
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}

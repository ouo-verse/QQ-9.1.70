package org.apache.commons.io.input;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.Charsets;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ReversedLinesFileReader implements Closeable {
    private final int avoidNewlineSplitBufferSize;
    private final int blockSize;
    private final int byteDecrement;
    private FilePart currentFilePart;
    private final Charset encoding;
    private final byte[][] newLineSequences;
    private final RandomAccessFile randomAccessFile;
    private final long totalBlockCount;
    private final long totalByteLength;
    private boolean trailingNewlineOfFileSkipped;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private class FilePart {
        private int currentLastBytePos;
        private final byte[] data;
        private byte[] leftOver;

        /* renamed from: no, reason: collision with root package name */
        private final long f423534no;

        private void createLeftOver() {
            int i3 = this.currentLastBytePos + 1;
            if (i3 > 0) {
                byte[] bArr = new byte[i3];
                this.leftOver = bArr;
                System.arraycopy(this.data, 0, bArr, 0, i3);
            } else {
                this.leftOver = null;
            }
            this.currentLastBytePos = -1;
        }

        private int getNewLineMatchByteCount(byte[] bArr, int i3) {
            boolean z16;
            for (byte[] bArr2 : ReversedLinesFileReader.this.newLineSequences) {
                boolean z17 = true;
                for (int length = bArr2.length - 1; length >= 0; length--) {
                    int length2 = (i3 + length) - (bArr2.length - 1);
                    if (length2 >= 0 && bArr[length2] == bArr2[length]) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    z17 &= z16;
                }
                if (z17) {
                    return bArr2.length;
                }
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String readLine() throws IOException {
            boolean z16;
            String str;
            byte[] bArr;
            if (this.f423534no == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            int i3 = this.currentLastBytePos;
            while (true) {
                if (i3 > -1) {
                    if (!z16 && i3 < ReversedLinesFileReader.this.avoidNewlineSplitBufferSize) {
                        createLeftOver();
                        break;
                    }
                    int newLineMatchByteCount = getNewLineMatchByteCount(this.data, i3);
                    if (newLineMatchByteCount > 0) {
                        int i16 = i3 + 1;
                        int i17 = (this.currentLastBytePos - i16) + 1;
                        if (i17 >= 0) {
                            byte[] bArr2 = new byte[i17];
                            System.arraycopy(this.data, i16, bArr2, 0, i17);
                            str = new String(bArr2, ReversedLinesFileReader.this.encoding);
                            this.currentLastBytePos = i3 - newLineMatchByteCount;
                        } else {
                            throw new IllegalStateException("Unexpected negative line length=" + i17);
                        }
                    } else {
                        i3 -= ReversedLinesFileReader.this.byteDecrement;
                        if (i3 < 0) {
                            createLeftOver();
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
            str = null;
            if (z16 && (bArr = this.leftOver) != null) {
                String str2 = new String(bArr, ReversedLinesFileReader.this.encoding);
                this.leftOver = null;
                return str2;
            }
            return str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FilePart rollOver() throws IOException {
            if (this.currentLastBytePos <= -1) {
                long j3 = this.f423534no;
                if (j3 > 1) {
                    ReversedLinesFileReader reversedLinesFileReader = ReversedLinesFileReader.this;
                    return new FilePart(j3 - 1, reversedLinesFileReader.blockSize, this.leftOver);
                }
                if (this.leftOver == null) {
                    return null;
                }
                throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=" + new String(this.leftOver, ReversedLinesFileReader.this.encoding));
            }
            throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + this.currentLastBytePos);
        }

        FilePart(long j3, int i3, byte[] bArr) throws IOException {
            this.f423534no = j3;
            byte[] bArr2 = new byte[(bArr != null ? bArr.length : 0) + i3];
            this.data = bArr2;
            long j16 = (j3 - 1) * ReversedLinesFileReader.this.blockSize;
            if (j3 > 0) {
                ReversedLinesFileReader.this.randomAccessFile.seek(j16);
                if (ReversedLinesFileReader.this.randomAccessFile.read(bArr2, 0, i3) != i3) {
                    throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
                }
            }
            if (bArr != null) {
                System.arraycopy(bArr, 0, bArr2, i3, bArr.length);
            }
            this.currentLastBytePos = bArr2.length - 1;
            this.leftOver = null;
        }
    }

    @Deprecated
    public ReversedLinesFileReader(File file) throws IOException {
        this(file, 4096, Charset.defaultCharset());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.randomAccessFile.close();
    }

    public String readLine() throws IOException {
        String readLine = this.currentFilePart.readLine();
        while (readLine == null) {
            FilePart rollOver = this.currentFilePart.rollOver();
            this.currentFilePart = rollOver;
            if (rollOver == null) {
                break;
            }
            readLine = rollOver.readLine();
        }
        if ("".equals(readLine) && !this.trailingNewlineOfFileSkipped) {
            this.trailingNewlineOfFileSkipped = true;
            return readLine();
        }
        return readLine;
    }

    public ReversedLinesFileReader(File file, Charset charset) throws IOException {
        this(file, 4096, charset);
    }

    public ReversedLinesFileReader(File file, int i3, Charset charset) throws IOException {
        int i16;
        this.trailingNewlineOfFileSkipped = false;
        this.blockSize = i3;
        this.encoding = charset;
        Charset charset2 = Charsets.toCharset(charset);
        if (charset2.newEncoder().maxBytesPerChar() == 1.0f) {
            this.byteDecrement = 1;
        } else if (charset2 == StandardCharsets.UTF_8) {
            this.byteDecrement = 1;
        } else if (charset2 != Charset.forName("Shift_JIS") && charset2 != Charset.forName("windows-31j") && charset2 != Charset.forName("x-windows-949") && charset2 != Charset.forName("gbk") && charset2 != Charset.forName("x-windows-950")) {
            if (charset2 != StandardCharsets.UTF_16BE && charset2 != StandardCharsets.UTF_16LE) {
                if (charset2 == StandardCharsets.UTF_16) {
                    throw new UnsupportedEncodingException("For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)");
                }
                throw new UnsupportedEncodingException("Encoding " + charset + " is not supported yet (feel free to submit a patch)");
            }
            this.byteDecrement = 2;
        } else {
            this.byteDecrement = 1;
        }
        byte[][] bArr = {"\r\n".getBytes(charset), "\n".getBytes(charset), "\r".getBytes(charset)};
        this.newLineSequences = bArr;
        this.avoidNewlineSplitBufferSize = bArr[0].length;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        this.randomAccessFile = randomAccessFile;
        long length = randomAccessFile.length();
        this.totalByteLength = length;
        long j3 = i3;
        int i17 = (int) (length % j3);
        if (i17 > 0) {
            this.totalBlockCount = (length / j3) + 1;
        } else {
            this.totalBlockCount = length / j3;
            if (length > 0) {
                i16 = i3;
                this.currentFilePart = new FilePart(this.totalBlockCount, i16, null);
            }
        }
        i16 = i17;
        this.currentFilePart = new FilePart(this.totalBlockCount, i16, null);
    }

    public ReversedLinesFileReader(File file, int i3, String str) throws IOException {
        this(file, i3, Charsets.toCharset(str));
    }
}

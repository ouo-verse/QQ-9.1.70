package org.apache.commons.fileupload;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.util.Closeable;
import org.apache.commons.fileupload.util.Streams;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MultipartStream {
    public static final byte CR = 13;
    protected static final int DEFAULT_BUFSIZE = 4096;
    public static final int HEADER_PART_SIZE_MAX = 10240;
    public static final byte LF = 10;
    private final byte[] boundary;
    private int boundaryLength;
    private final int[] boundaryTable;
    private final int bufSize;
    private final byte[] buffer;
    private int head;
    private String headerEncoding;
    private final InputStream input;
    private final int keepRegion;
    private final ProgressNotifier notifier;
    private int tail;
    protected static final byte[] HEADER_SEPARATOR = {13, 10, 13, 10};
    protected static final byte[] FIELD_SEPARATOR = {13, 10};
    public static final byte DASH = 45;
    protected static final byte[] STREAM_TERMINATOR = {DASH, DASH};
    protected static final byte[] BOUNDARY_PREFIX = {13, 10, DASH, DASH};

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class IllegalBoundaryException extends IOException {
        private static final long serialVersionUID = -161533165102632918L;

        public IllegalBoundaryException() {
        }

        public IllegalBoundaryException(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class ItemInputStream extends InputStream implements Closeable {
        private static final int BYTE_POSITIVE_OFFSET = 256;
        private boolean closed;
        private int pad;
        private int pos;
        private long total;

        ItemInputStream() {
            findSeparator();
        }

        private void findSeparator() {
            int findSeparator = MultipartStream.this.findSeparator();
            this.pos = findSeparator;
            if (findSeparator == -1) {
                if (MultipartStream.this.tail - MultipartStream.this.head > MultipartStream.this.keepRegion) {
                    this.pad = MultipartStream.this.keepRegion;
                } else {
                    this.pad = MultipartStream.this.tail - MultipartStream.this.head;
                }
            }
        }

        private int makeAvailable() throws IOException {
            int available;
            if (this.pos != -1) {
                return 0;
            }
            this.total += (MultipartStream.this.tail - MultipartStream.this.head) - this.pad;
            System.arraycopy(MultipartStream.this.buffer, MultipartStream.this.tail - this.pad, MultipartStream.this.buffer, 0, this.pad);
            MultipartStream.this.head = 0;
            MultipartStream.this.tail = this.pad;
            do {
                int read = MultipartStream.this.input.read(MultipartStream.this.buffer, MultipartStream.this.tail, MultipartStream.this.bufSize - MultipartStream.this.tail);
                if (read != -1) {
                    if (MultipartStream.this.notifier != null) {
                        MultipartStream.this.notifier.noteBytesRead(read);
                    }
                    MultipartStream.this.tail += read;
                    findSeparator();
                    available = available();
                    if (available > 0) {
                        break;
                    }
                } else {
                    throw new MalformedStreamException("Stream ended unexpectedly");
                }
            } while (this.pos == -1);
            return available;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            int i3;
            int i16 = this.pos;
            if (i16 != -1) {
                i3 = MultipartStream.this.head;
            } else {
                i16 = MultipartStream.this.tail - MultipartStream.this.head;
                i3 = this.pad;
            }
            return i16 - i3;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable, org.apache.commons.fileupload.util.Closeable
        public void close() throws IOException {
            close(false);
        }

        public long getBytesRead() {
            return this.total;
        }

        @Override // org.apache.commons.fileupload.util.Closeable
        public boolean isClosed() {
            return this.closed;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (!this.closed) {
                if (available() == 0 && makeAvailable() == 0) {
                    return -1;
                }
                this.total++;
                byte b16 = MultipartStream.this.buffer[MultipartStream.access$108(MultipartStream.this)];
                return b16 >= 0 ? b16 : b16 + 256;
            }
            throw new FileItemStream.ItemSkippedException();
        }

        @Override // java.io.InputStream
        public long skip(long j3) throws IOException {
            if (!this.closed) {
                int available = available();
                if (available == 0 && (available = makeAvailable()) == 0) {
                    return 0L;
                }
                long min = Math.min(available, j3);
                MultipartStream.this.head = (int) (r0.head + min);
                return min;
            }
            throw new FileItemStream.ItemSkippedException();
        }

        public void close(boolean z16) throws IOException {
            if (this.closed) {
                return;
            }
            if (!z16) {
                while (true) {
                    int available = available();
                    if (available == 0 && (available = makeAvailable()) == 0) {
                        break;
                    } else {
                        skip(available);
                    }
                }
            } else {
                this.closed = true;
                MultipartStream.this.input.close();
            }
            this.closed = true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i16) throws IOException {
            if (this.closed) {
                throw new FileItemStream.ItemSkippedException();
            }
            if (i16 == 0) {
                return 0;
            }
            int available = available();
            if (available == 0 && (available = makeAvailable()) == 0) {
                return -1;
            }
            int min = Math.min(available, i16);
            System.arraycopy(MultipartStream.this.buffer, MultipartStream.this.head, bArr, i3, min);
            MultipartStream.this.head += min;
            this.total += min;
            return min;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class MalformedStreamException extends IOException {
        private static final long serialVersionUID = 6466926458059796677L;

        public MalformedStreamException() {
        }

        public MalformedStreamException(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class ProgressNotifier {
        private long bytesRead;
        private final long contentLength;
        private int items;
        private final ProgressListener listener;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ProgressNotifier(ProgressListener progressListener, long j3) {
            this.listener = progressListener;
            this.contentLength = j3;
        }

        private void notifyListener() {
            ProgressListener progressListener = this.listener;
            if (progressListener != null) {
                progressListener.update(this.bytesRead, this.contentLength, this.items);
            }
        }

        void noteBytesRead(int i3) {
            this.bytesRead += i3;
            notifyListener();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void noteItem() {
            this.items++;
            notifyListener();
        }
    }

    @Deprecated
    public MultipartStream() {
        this((InputStream) null, (byte[]) null, (ProgressNotifier) null);
    }

    static /* synthetic */ int access$108(MultipartStream multipartStream) {
        int i3 = multipartStream.head;
        multipartStream.head = i3 + 1;
        return i3;
    }

    public static boolean arrayequals(byte[] bArr, byte[] bArr2, int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            if (bArr[i16] != bArr2[i16]) {
                return false;
            }
        }
        return true;
    }

    private void computeBoundaryTable() {
        int[] iArr = this.boundaryTable;
        iArr[0] = -1;
        iArr[1] = 0;
        int i3 = 2;
        int i16 = 0;
        while (i3 <= this.boundaryLength) {
            byte[] bArr = this.boundary;
            if (bArr[i3 - 1] == bArr[i16]) {
                i16++;
                this.boundaryTable[i3] = i16;
            } else if (i16 > 0) {
                i16 = this.boundaryTable[i16];
            } else {
                this.boundaryTable[i3] = 0;
            }
            i3++;
        }
    }

    public int discardBodyData() throws MalformedStreamException, IOException {
        return readBodyData(null);
    }

    protected int findByte(byte b16, int i3) {
        while (i3 < this.tail) {
            if (this.buffer[i3] == b16) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    protected int findSeparator() {
        int i3 = this.head;
        int i16 = 0;
        while (i3 < this.tail) {
            while (i16 >= 0 && this.buffer[i3] != this.boundary[i16]) {
                i16 = this.boundaryTable[i16];
            }
            i3++;
            i16++;
            int i17 = this.boundaryLength;
            if (i16 == i17) {
                return i3 - i17;
            }
        }
        return -1;
    }

    public String getHeaderEncoding() {
        return this.headerEncoding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ItemInputStream newInputStream() {
        return new ItemInputStream();
    }

    public int readBodyData(OutputStream outputStream) throws MalformedStreamException, IOException {
        return (int) Streams.copy(newInputStream(), outputStream, false);
    }

    public boolean readBoundary() throws FileUploadBase.FileUploadIOException, MalformedStreamException {
        byte[] bArr = new byte[2];
        this.head += this.boundaryLength;
        try {
            byte readByte = readByte();
            bArr[0] = readByte;
            if (readByte == 10) {
                return true;
            }
            bArr[1] = readByte();
            if (arrayequals(bArr, STREAM_TERMINATOR, 2)) {
                return false;
            }
            if (arrayequals(bArr, FIELD_SEPARATOR, 2)) {
                return true;
            }
            throw new MalformedStreamException("Unexpected characters follow a boundary");
        } catch (FileUploadBase.FileUploadIOException e16) {
            throw e16;
        } catch (IOException unused) {
            throw new MalformedStreamException("Stream ended unexpectedly");
        }
    }

    public byte readByte() throws IOException {
        if (this.head == this.tail) {
            this.head = 0;
            int read = this.input.read(this.buffer, 0, this.bufSize);
            this.tail = read;
            if (read != -1) {
                ProgressNotifier progressNotifier = this.notifier;
                if (progressNotifier != null) {
                    progressNotifier.noteBytesRead(read);
                }
            } else {
                throw new IOException("No more data is available");
            }
        }
        byte[] bArr = this.buffer;
        int i3 = this.head;
        this.head = i3 + 1;
        return bArr[i3];
    }

    public String readHeaders() throws FileUploadBase.FileUploadIOException, MalformedStreamException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 0;
        int i16 = 0;
        while (true) {
            byte[] bArr = HEADER_SEPARATOR;
            if (i3 < bArr.length) {
                try {
                    byte readByte = readByte();
                    i16++;
                    if (i16 <= 10240) {
                        if (readByte == bArr[i3]) {
                            i3++;
                        } else {
                            i3 = 0;
                        }
                        byteArrayOutputStream.write(readByte);
                    } else {
                        throw new MalformedStreamException(String.format("Header section has more than %s bytes (maybe it is not properly terminated)", 10240));
                    }
                } catch (FileUploadBase.FileUploadIOException e16) {
                    throw e16;
                } catch (IOException unused) {
                    throw new MalformedStreamException("Stream ended unexpectedly");
                }
            } else {
                String str = this.headerEncoding;
                if (str != null) {
                    try {
                        return byteArrayOutputStream.toString(str);
                    } catch (UnsupportedEncodingException unused2) {
                        return byteArrayOutputStream.toString();
                    }
                }
                return byteArrayOutputStream.toString();
            }
        }
    }

    public void setBoundary(byte[] bArr) throws IllegalBoundaryException {
        int length = bArr.length;
        int i3 = this.boundaryLength;
        byte[] bArr2 = BOUNDARY_PREFIX;
        if (length == i3 - bArr2.length) {
            System.arraycopy(bArr, 0, this.boundary, bArr2.length, bArr.length);
            computeBoundaryTable();
            return;
        }
        throw new IllegalBoundaryException("The length of a boundary token cannot be changed");
    }

    public void setHeaderEncoding(String str) {
        this.headerEncoding = str;
    }

    public boolean skipPreamble() throws IOException {
        byte[] bArr = this.boundary;
        System.arraycopy(bArr, 2, bArr, 0, bArr.length - 2);
        this.boundaryLength = this.boundary.length - 2;
        computeBoundaryTable();
        try {
            discardBodyData();
            return readBoundary();
        } catch (MalformedStreamException unused) {
            return false;
        } finally {
            byte[] bArr2 = this.boundary;
            System.arraycopy(bArr2, 0, bArr2, 2, bArr2.length - 2);
            byte[] bArr3 = this.boundary;
            this.boundaryLength = bArr3.length;
            bArr3[0] = 13;
            bArr3[1] = 10;
            computeBoundaryTable();
        }
    }

    @Deprecated
    public MultipartStream(InputStream inputStream, byte[] bArr, int i3) {
        this(inputStream, bArr, i3, null);
    }

    public MultipartStream(InputStream inputStream, byte[] bArr, int i3, ProgressNotifier progressNotifier) {
        if (bArr != null) {
            int length = bArr.length;
            byte[] bArr2 = BOUNDARY_PREFIX;
            int length2 = length + bArr2.length;
            this.boundaryLength = length2;
            if (i3 >= length2 + 1) {
                this.input = inputStream;
                int max = Math.max(i3, length2 * 2);
                this.bufSize = max;
                this.buffer = new byte[max];
                this.notifier = progressNotifier;
                int i16 = this.boundaryLength;
                byte[] bArr3 = new byte[i16];
                this.boundary = bArr3;
                this.boundaryTable = new int[i16 + 1];
                this.keepRegion = bArr3.length;
                System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                System.arraycopy(bArr, 0, bArr3, bArr2.length, bArr.length);
                computeBoundaryTable();
                this.head = 0;
                this.tail = 0;
                return;
            }
            throw new IllegalArgumentException("The buffer size specified for the MultipartStream is too small");
        }
        throw new IllegalArgumentException("boundary may not be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultipartStream(InputStream inputStream, byte[] bArr, ProgressNotifier progressNotifier) {
        this(inputStream, bArr, 4096, progressNotifier);
    }

    @Deprecated
    public MultipartStream(InputStream inputStream, byte[] bArr) {
        this(inputStream, bArr, 4096, null);
    }
}

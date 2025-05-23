package kotlin.reflect.jvm.internal.impl.protobuf;

import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class ByteString implements Iterable<Byte> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final ByteString EMPTY = new LiteralByteString(new byte[0]);

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    private static ByteString balancedConcat(Iterator<ByteString> it, int i3) {
        if (i3 == 1) {
            return it.next();
        }
        int i16 = i3 >>> 1;
        return balancedConcat(it, i16).concat(balancedConcat(it, i3 - i16));
    }

    public static ByteString copyFrom(byte[] bArr, int i3, int i16) {
        byte[] bArr2 = new byte[i16];
        System.arraycopy(bArr, i3, bArr2, 0, i16);
        return new LiteralByteString(bArr2);
    }

    public static ByteString copyFromUtf8(String str) {
        try {
            return new LiteralByteString(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e16) {
            throw new RuntimeException("UTF-8 not supported?", e16);
        }
    }

    public static Output newOutput() {
        return new Output(128);
    }

    public ByteString concat(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        if (size + size2 < TTL.MAX_VALUE) {
            return RopeByteString.concatenate(this, byteString);
        }
        StringBuilder sb5 = new StringBuilder(53);
        sb5.append("ByteString would be too long: ");
        sb5.append(size);
        sb5.append(Marker.ANY_NON_NULL_MARKER);
        sb5.append(size2);
        throw new IllegalArgumentException(sb5.toString());
    }

    public void copyTo(byte[] bArr, int i3, int i16, int i17) {
        if (i3 >= 0) {
            if (i16 >= 0) {
                if (i17 >= 0) {
                    int i18 = i3 + i17;
                    if (i18 <= size()) {
                        int i19 = i16 + i17;
                        if (i19 <= bArr.length) {
                            if (i17 > 0) {
                                copyToInternal(bArr, i3, i16, i17);
                                return;
                            }
                            return;
                        } else {
                            StringBuilder sb5 = new StringBuilder(34);
                            sb5.append("Target end offset < 0: ");
                            sb5.append(i19);
                            throw new IndexOutOfBoundsException(sb5.toString());
                        }
                    }
                    StringBuilder sb6 = new StringBuilder(34);
                    sb6.append("Source end offset < 0: ");
                    sb6.append(i18);
                    throw new IndexOutOfBoundsException(sb6.toString());
                }
                StringBuilder sb7 = new StringBuilder(23);
                sb7.append("Length < 0: ");
                sb7.append(i17);
                throw new IndexOutOfBoundsException(sb7.toString());
            }
            StringBuilder sb8 = new StringBuilder(30);
            sb8.append("Target offset < 0: ");
            sb8.append(i16);
            throw new IndexOutOfBoundsException(sb8.toString());
        }
        StringBuilder sb9 = new StringBuilder(30);
        sb9.append("Source offset < 0: ");
        sb9.append(i3);
        throw new IndexOutOfBoundsException(sb9.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void copyToInternal(byte[] bArr, int i3, int i16, int i17);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getTreeDepth();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isBalanced();

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public abstract boolean isValidUtf8();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Iterable
    public abstract Iterator<Byte> iterator();

    public abstract CodedInputStream newCodedInput();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int partialHash(int i3, int i16, int i17);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int partialIsValidUtf8(int i3, int i16, int i17);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int peekCachedHashCode();

    public abstract int size();

    public byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        copyToInternal(bArr, 0, 0, size);
        return bArr;
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract String toString(String str) throws UnsupportedEncodingException;

    public String toStringUtf8() {
        try {
            return toString("UTF-8");
        } catch (UnsupportedEncodingException e16) {
            throw new RuntimeException("UTF-8 not supported?", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeTo(OutputStream outputStream, int i3, int i16) throws IOException {
        if (i3 >= 0) {
            if (i16 >= 0) {
                int i17 = i3 + i16;
                if (i17 <= size()) {
                    if (i16 > 0) {
                        writeToInternal(outputStream, i3, i16);
                        return;
                    }
                    return;
                } else {
                    StringBuilder sb5 = new StringBuilder(39);
                    sb5.append("Source end offset exceeded: ");
                    sb5.append(i17);
                    throw new IndexOutOfBoundsException(sb5.toString());
                }
            }
            StringBuilder sb6 = new StringBuilder(23);
            sb6.append("Length < 0: ");
            sb6.append(i16);
            throw new IndexOutOfBoundsException(sb6.toString());
        }
        StringBuilder sb7 = new StringBuilder(30);
        sb7.append("Source offset < 0: ");
        sb7.append(i3);
        throw new IndexOutOfBoundsException(sb7.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeToInternal(OutputStream outputStream, int i3, int i16) throws IOException;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Output extends OutputStream {
        private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
        private byte[] buffer;
        private int bufferPos;
        private final ArrayList<ByteString> flushedBuffers;
        private int flushedBuffersTotalBytes;
        private final int initialCapacity;

        Output(int i3) {
            if (i3 >= 0) {
                this.initialCapacity = i3;
                this.flushedBuffers = new ArrayList<>();
                this.buffer = new byte[i3];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private byte[] copyArray(byte[] bArr, int i3) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i3));
            return bArr2;
        }

        private void flushFullBuffer(int i3) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            int length = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = length;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(i3, length >>> 1))];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            int i3 = this.bufferPos;
            byte[] bArr = this.buffer;
            if (i3 < bArr.length) {
                if (i3 > 0) {
                    this.flushedBuffers.add(new LiteralByteString(copyArray(bArr, i3)));
                }
            } else {
                this.flushedBuffers.add(new LiteralByteString(this.buffer));
                this.buffer = EMPTY_BYTE_ARRAY;
            }
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
        }

        public synchronized int size() {
            return this.flushedBuffersTotalBytes + this.bufferPos;
        }

        public synchronized ByteString toByteString() {
            flushLastBuffer();
            return ByteString.copyFrom(this.flushedBuffers);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i3) {
            if (this.bufferPos == this.buffer.length) {
                flushFullBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i16 = this.bufferPos;
            this.bufferPos = i16 + 1;
            bArr[i16] = (byte) i3;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i3, int i16) {
            byte[] bArr2 = this.buffer;
            int length = bArr2.length;
            int i17 = this.bufferPos;
            if (i16 <= length - i17) {
                System.arraycopy(bArr, i3, bArr2, i17, i16);
                this.bufferPos += i16;
            } else {
                int length2 = bArr2.length - i17;
                System.arraycopy(bArr, i3, bArr2, i17, length2);
                int i18 = i16 - length2;
                flushFullBuffer(i18);
                System.arraycopy(bArr, i3 + length2, this.buffer, 0, i18);
                this.bufferPos = i18;
            }
        }
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        Collection collection;
        if (!(iterable instanceof Collection)) {
            collection = new ArrayList();
            Iterator<ByteString> it = iterable.iterator();
            while (it.hasNext()) {
                collection.add(it.next());
            }
        } else {
            collection = (Collection) iterable;
        }
        if (collection.isEmpty()) {
            return EMPTY;
        }
        return balancedConcat(collection.iterator(), collection.size());
    }
}

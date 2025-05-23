package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import org.slf4j.Marker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public class BoundedByteString extends LiteralByteString {
    private final int bytesLength;
    private final int bytesOffset;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class BoundedByteIterator implements ByteString.ByteIterator {
        private final int limit;
        private int position;

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.position < this.limit) {
                return true;
            }
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            int i3 = this.position;
            if (i3 < this.limit) {
                byte[] bArr = BoundedByteString.this.bytes;
                this.position = i3 + 1;
                return bArr[i3];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        BoundedByteIterator() {
            int offsetIntoBytes = BoundedByteString.this.getOffsetIntoBytes();
            this.position = offsetIntoBytes;
            this.limit = offsetIntoBytes + BoundedByteString.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundedByteString(byte[] bArr, int i3, int i16) {
        super(bArr);
        if (i3 >= 0) {
            if (i16 >= 0) {
                if (i3 + i16 <= bArr.length) {
                    this.bytesOffset = i3;
                    this.bytesLength = i16;
                    return;
                }
                StringBuilder sb5 = new StringBuilder(48);
                sb5.append("Offset+Length too large: ");
                sb5.append(i3);
                sb5.append(Marker.ANY_NON_NULL_MARKER);
                sb5.append(i16);
                throw new IllegalArgumentException(sb5.toString());
            }
            StringBuilder sb6 = new StringBuilder(29);
            sb6.append("Length too small: ");
            sb6.append(i3);
            throw new IllegalArgumentException(sb6.toString());
        }
        StringBuilder sb7 = new StringBuilder(29);
        sb7.append("Offset too small: ");
        sb7.append(i3);
        throw new IllegalArgumentException(sb7.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString
    public byte byteAt(int i3) {
        if (i3 >= 0) {
            if (i3 < size()) {
                return this.bytes[this.bytesOffset + i3];
            }
            int size = size();
            StringBuilder sb5 = new StringBuilder(41);
            sb5.append("Index too large: ");
            sb5.append(i3);
            sb5.append(", ");
            sb5.append(size);
            throw new ArrayIndexOutOfBoundsException(sb5.toString());
        }
        StringBuilder sb6 = new StringBuilder(28);
        sb6.append("Index too small: ");
        sb6.append(i3);
        throw new ArrayIndexOutOfBoundsException(sb6.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i3, int i16, int i17) {
        System.arraycopy(this.bytes, getOffsetIntoBytes() + i3, bArr, i16, i17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString
    public int getOffsetIntoBytes() {
        return this.bytesOffset;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.bytesLength;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new BoundedByteIterator();
    }
}

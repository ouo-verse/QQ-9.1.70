package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public class LiteralByteString extends ByteString {
    protected final byte[] bytes;
    private int hash = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class LiteralByteIterator implements ByteString.ByteIterator {
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
            try {
                byte[] bArr = LiteralByteString.this.bytes;
                int i3 = this.position;
                this.position = i3 + 1;
                return bArr[i3];
            } catch (ArrayIndexOutOfBoundsException e16) {
                throw new NoSuchElementException(e16.getMessage());
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        LiteralByteIterator() {
            this.position = 0;
            this.limit = LiteralByteString.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiteralByteString(byte[] bArr) {
        this.bytes = bArr;
    }

    public byte byteAt(int i3) {
        return this.bytes[i3];
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected void copyToInternal(byte[] bArr, int i3, int i16, int i17) {
        System.arraycopy(this.bytes, i3, bArr, i16, i17);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof LiteralByteString) {
            return equalsRange((LiteralByteString) obj, 0, size());
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        String valueOf = String.valueOf(obj.getClass());
        StringBuilder sb5 = new StringBuilder(valueOf.length() + 49);
        sb5.append("Has a new type of ByteString been created? Found ");
        sb5.append(valueOf);
        throw new IllegalArgumentException(sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean equalsRange(LiteralByteString literalByteString, int i3, int i16) {
        if (i16 <= literalByteString.size()) {
            if (i3 + i16 <= literalByteString.size()) {
                byte[] bArr = this.bytes;
                byte[] bArr2 = literalByteString.bytes;
                int offsetIntoBytes = getOffsetIntoBytes() + i16;
                int offsetIntoBytes2 = getOffsetIntoBytes();
                int offsetIntoBytes3 = literalByteString.getOffsetIntoBytes() + i3;
                while (offsetIntoBytes2 < offsetIntoBytes) {
                    if (bArr[offsetIntoBytes2] != bArr2[offsetIntoBytes3]) {
                        return false;
                    }
                    offsetIntoBytes2++;
                    offsetIntoBytes3++;
                }
                return true;
            }
            int size = literalByteString.size();
            StringBuilder sb5 = new StringBuilder(59);
            sb5.append("Ran off end of other: ");
            sb5.append(i3);
            sb5.append(", ");
            sb5.append(i16);
            sb5.append(", ");
            sb5.append(size);
            throw new IllegalArgumentException(sb5.toString());
        }
        int size2 = size();
        StringBuilder sb6 = new StringBuilder(40);
        sb6.append("Length too large: ");
        sb6.append(i16);
        sb6.append(size2);
        throw new IllegalArgumentException(sb6.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getOffsetIntoBytes() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int getTreeDepth() {
        return 0;
    }

    public int hashCode() {
        int i3 = this.hash;
        if (i3 == 0) {
            int size = size();
            i3 = partialHash(size, 0, size);
            if (i3 == 0) {
                i3 = 1;
            }
            this.hash = i3;
        }
        return i3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected boolean isBalanced() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isValidUtf8() {
        int offsetIntoBytes = getOffsetIntoBytes();
        return Utf8.isValidUtf8(this.bytes, offsetIntoBytes, size() + offsetIntoBytes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int partialHash(int i3, int i16, int i17) {
        return hashCode(i3, this.bytes, getOffsetIntoBytes() + i16, i17);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int partialIsValidUtf8(int i3, int i16, int i17) {
        int offsetIntoBytes = getOffsetIntoBytes() + i16;
        return Utf8.partialIsValidUtf8(i3, this.bytes, offsetIntoBytes, i17 + offsetIntoBytes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int peekCachedHashCode() {
        return this.hash;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.bytes.length;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public String toString(String str) throws UnsupportedEncodingException {
        return new String(this.bytes, getOffsetIntoBytes(), size(), str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    void writeToInternal(OutputStream outputStream, int i3, int i16) throws IOException {
        outputStream.write(this.bytes, getOffsetIntoBytes() + i3, i16);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new LiteralByteIterator();
    }

    static int hashCode(int i3, byte[] bArr, int i16, int i17) {
        for (int i18 = i16; i18 < i16 + i17; i18++) {
            i3 = (i3 * 31) + bArr[i18];
        }
        return i3;
    }
}

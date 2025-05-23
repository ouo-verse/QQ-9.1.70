package com.google.protobuf;

import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = new LiteralByteString(ad.f35642c);
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;

    /* renamed from: d, reason: collision with root package name */
    private static final e f35238d;

    /* renamed from: e, reason: collision with root package name */
    private static final Comparator<ByteString> f35239e;
    private int hash = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        BoundedByteString(byte[] bArr, int i3, int i16) {
            super(bArr);
            ByteString.checkRange(i3, i3 + i16, bArr.length);
            this.bytesOffset = i3;
            this.bytesLength = i16;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public byte byteAt(int i3) {
            ByteString.checkIndex(i3, size());
            return this.bytes[this.bytesOffset + i3];
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        protected void copyToInternal(byte[] bArr, int i3, int i16, int i17) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + i3, bArr, i16, i17);
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString
        protected int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        byte internalByteAt(int i3) {
            return this.bytes[this.bytesOffset + i3];
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }

        Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static abstract class LeafByteString extends ByteString {
        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract boolean equalsRange(ByteString byteString, int i3, int i16);

        @Override // com.google.protobuf.ByteString
        protected final int getTreeDepth() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        protected final boolean isBalanced() {
            return true;
        }

        @Override // com.google.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator2();
        }

        @Override // com.google.protobuf.ByteString
        void writeToReverse(j jVar) throws IOException {
            writeTo(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.bytes = bArr;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.google.protobuf.ByteString
        public byte byteAt(int i3) {
            return this.bytes[i3];
        }

        @Override // com.google.protobuf.ByteString
        public final void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        protected void copyToInternal(byte[] bArr, int i3, int i16, int i17) {
            System.arraycopy(this.bytes, i3, bArr, i16, i17);
        }

        @Override // com.google.protobuf.ByteString
        public final boolean equals(Object obj) {
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
                LiteralByteString literalByteString = (LiteralByteString) obj;
                int peekCachedHashCode = peekCachedHashCode();
                int peekCachedHashCode2 = literalByteString.peekCachedHashCode();
                if (peekCachedHashCode != 0 && peekCachedHashCode2 != 0 && peekCachedHashCode != peekCachedHashCode2) {
                    return false;
                }
                return equalsRange(literalByteString, 0, size());
            }
            return obj.equals(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.protobuf.ByteString.LeafByteString
        public final boolean equalsRange(ByteString byteString, int i3, int i16) {
            if (i16 <= byteString.size()) {
                int i17 = i3 + i16;
                if (i17 <= byteString.size()) {
                    if (byteString instanceof LiteralByteString) {
                        LiteralByteString literalByteString = (LiteralByteString) byteString;
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
                    return byteString.substring(i3, i17).equals(substring(0, i16));
                }
                throw new IllegalArgumentException("Ran off end of other: " + i3 + ", " + i16 + ", " + byteString.size());
            }
            throw new IllegalArgumentException("Length too large: " + i16 + size());
        }

        protected int getOffsetIntoBytes() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        byte internalByteAt(int i3) {
            return this.bytes[i3];
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isValidUtf8() {
            int offsetIntoBytes = getOffsetIntoBytes();
            return Utf8.t(this.bytes, offsetIntoBytes, size() + offsetIntoBytes);
        }

        @Override // com.google.protobuf.ByteString
        public final k newCodedInput() {
            return k.m(this.bytes, getOffsetIntoBytes(), size(), true);
        }

        @Override // com.google.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        protected final int partialHash(int i3, int i16, int i17) {
            return ad.k(i3, this.bytes, getOffsetIntoBytes() + i16, i17);
        }

        @Override // com.google.protobuf.ByteString
        protected final int partialIsValidUtf8(int i3, int i16, int i17) {
            int offsetIntoBytes = getOffsetIntoBytes() + i16;
            return Utf8.v(i3, this.bytes, offsetIntoBytes, i17 + offsetIntoBytes);
        }

        @Override // com.google.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteString substring(int i3, int i16) {
            int checkRange = ByteString.checkRange(i3, i16, size());
            if (checkRange == 0) {
                return ByteString.EMPTY;
            }
            return new BoundedByteString(this.bytes, getOffsetIntoBytes() + i3, checkRange);
        }

        @Override // com.google.protobuf.ByteString
        protected final String toStringInternal(Charset charset) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), charset);
        }

        @Override // com.google.protobuf.ByteString
        public final void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }

        @Override // com.google.protobuf.ByteString
        final void writeToInternal(OutputStream outputStream, int i3, int i16) throws IOException {
            outputStream.write(this.bytes, getOffsetIntoBytes() + i3, i16);
        }

        @Override // com.google.protobuf.ByteString
        final void writeTo(j jVar) throws IOException {
            jVar.b(this.bytes, getOffsetIntoBytes(), size());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends c {

        /* renamed from: d, reason: collision with root package name */
        private int f35240d = 0;

        /* renamed from: e, reason: collision with root package name */
        private final int f35241e;

        a() {
            this.f35241e = ByteString.this.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f35240d < this.f35241e) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.ByteString.f
        public byte nextByte() {
            int i3 = this.f35240d;
            if (i3 < this.f35241e) {
                this.f35240d = i3 + 1;
                return ByteString.this.internalByteAt(i3);
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class b implements Comparator<ByteString> {
        b() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Iterator, com.google.protobuf.ByteString$f] */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Iterator, com.google.protobuf.ByteString$f] */
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ByteString byteString, ByteString byteString2) {
            ?? iterator2 = byteString.iterator2();
            ?? iterator22 = byteString2.iterator2();
            while (iterator2.hasNext() && iterator22.hasNext()) {
                int compare = Integer.compare(ByteString.g(iterator2.nextByte()), ByteString.g(iterator22.nextByte()));
                if (compare != 0) {
                    return compare;
                }
            }
            return Integer.compare(byteString.size(), byteString2.size());
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static abstract class c implements f {
        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class d implements e {
        d() {
        }

        @Override // com.google.protobuf.ByteString.e
        public byte[] a(byte[] bArr, int i3, int i16) {
            return Arrays.copyOfRange(bArr, i3, i16 + i3);
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface e {
        byte[] a(byte[] bArr, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface f extends Iterator<Byte> {
        byte nextByte();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class g {

        /* renamed from: a, reason: collision with root package name */
        private final CodedOutputStream f35243a;

        /* renamed from: b, reason: collision with root package name */
        private final byte[] f35244b;

        /* synthetic */ g(int i3, a aVar) {
            this(i3);
        }

        public ByteString a() {
            this.f35243a.d();
            return new LiteralByteString(this.f35244b);
        }

        public CodedOutputStream b() {
            return this.f35243a;
        }

        g(int i3) {
            byte[] bArr = new byte[i3];
            this.f35244b = bArr;
            this.f35243a = CodedOutputStream.i0(bArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class i implements e {
        i() {
        }

        @Override // com.google.protobuf.ByteString.e
        public byte[] a(byte[] bArr, int i3, int i16) {
            byte[] bArr2 = new byte[i16];
            System.arraycopy(bArr, i3, bArr2, 0, i16);
            return bArr2;
        }

        /* synthetic */ i(a aVar) {
            this();
        }
    }

    static {
        e dVar;
        a aVar = null;
        if (com.google.protobuf.e.c()) {
            dVar = new i(aVar);
        } else {
            dVar = new d(aVar);
        }
        f35238d = dVar;
        f35239e = new b();
    }

    private static ByteString a(Iterator<ByteString> it, int i3) {
        if (i3 >= 1) {
            if (i3 == 1) {
                return it.next();
            }
            int i16 = i3 >>> 1;
            return a(it, i16).concat(a(it, i3 - i16));
        }
        throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkIndex(int i3, int i16) {
        if (((i16 - (i3 + 1)) | i3) < 0) {
            if (i3 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i3);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i3 + ", " + i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int checkRange(int i3, int i16, int i17) {
        int i18 = i16 - i3;
        if ((i3 | i16 | i18 | (i17 - i16)) < 0) {
            if (i3 >= 0) {
                if (i16 < i3) {
                    throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i3 + ", " + i16);
                }
                throw new IndexOutOfBoundsException("End index: " + i16 + " >= " + i17);
            }
            throw new IndexOutOfBoundsException("Beginning index: " + i3 + " < 0");
        }
        return i18;
    }

    public static ByteString copyFrom(byte[] bArr, int i3, int i16) {
        checkRange(i3, i3 + i16, bArr.length);
        return new LiteralByteString(f35238d.a(bArr, i3, i16));
    }

    public static ByteString copyFromUtf8(String str) {
        return new LiteralByteString(str.getBytes(ad.f35640a));
    }

    private static ByteString d(InputStream inputStream, int i3) throws IOException {
        byte[] bArr = new byte[i3];
        int i16 = 0;
        while (i16 < i3) {
            int read = inputStream.read(bArr, i16, i3 - i16);
            if (read == -1) {
                break;
            }
            i16 += read;
        }
        if (i16 == 0) {
            return null;
        }
        return copyFrom(bArr, 0, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(byte b16) {
        return b16 & 255;
    }

    private String h() {
        if (size() <= 50) {
            return bx.a(this);
        }
        return bx.a(substring(0, 47)) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g newCodedBuilder(int i3) {
        return new g(i3, null);
    }

    public static h newOutput(int i3) {
        return new h(i3);
    }

    public static ByteString readFrom(InputStream inputStream) throws IOException {
        return readFrom(inputStream, 256, 8192);
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return f35239e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString wrap(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return wrap(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        }
        return new NioByteString(byteBuffer);
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int i3);

    public final ByteString concat(ByteString byteString) {
        if (Integer.MAX_VALUE - size() >= byteString.size()) {
            return RopeByteString.concatenate(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + Marker.ANY_NON_NULL_MARKER + byteString.size());
    }

    public abstract void copyTo(ByteBuffer byteBuffer);

    public void copyTo(byte[] bArr, int i3) {
        copyTo(bArr, 0, i3, size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void copyToInternal(byte[] bArr, int i3, int i16, int i17);

    public final boolean endsWith(ByteString byteString) {
        if (size() >= byteString.size() && substring(size() - byteString.size()).equals(byteString)) {
            return true;
        }
        return false;
    }

    public abstract boolean equals(Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getTreeDepth();

    public final int hashCode() {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte internalByteAt(int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isBalanced();

    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public abstract boolean isValidUtf8();

    public abstract k newCodedInput();

    public abstract InputStream newInput();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int partialHash(int i3, int i16, int i17);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int partialIsValidUtf8(int i3, int i16, int i17);

    /* JADX INFO: Access modifiers changed from: protected */
    public final int peekCachedHashCode() {
        return this.hash;
    }

    public abstract int size();

    public final boolean startsWith(ByteString byteString) {
        if (size() < byteString.size() || !substring(0, byteString.size()).equals(byteString)) {
            return false;
        }
        return true;
    }

    public final ByteString substring(int i3) {
        return substring(i3, size());
    }

    public abstract ByteString substring(int i3, int i16);

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return ad.f35642c;
        }
        byte[] bArr = new byte[size];
        copyToInternal(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString(String str) throws UnsupportedEncodingException {
        try {
            return toString(Charset.forName(str));
        } catch (UnsupportedCharsetException e16) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e16);
            throw unsupportedEncodingException;
        }
    }

    protected abstract String toStringInternal(Charset charset);

    public final String toStringUtf8() {
        return toString(ad.f35640a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeTo(j jVar) throws IOException;

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    final void writeTo(OutputStream outputStream, int i3, int i16) throws IOException {
        checkRange(i3, i3 + i16, size());
        if (i16 > 0) {
            writeToInternal(outputStream, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeToInternal(OutputStream outputStream, int i3, int i16) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeToReverse(j jVar) throws IOException;

    public static h newOutput() {
        return new h(128);
    }

    public static ByteString readFrom(InputStream inputStream, int i3) throws IOException {
        return readFrom(inputStream, i3, i3);
    }

    @Deprecated
    public final void copyTo(byte[] bArr, int i3, int i16, int i17) {
        checkRange(i3, i3 + i17, size());
        checkRange(i16, i16 + i17, bArr.length);
        if (i17 > 0) {
            copyToInternal(bArr, i3, i16, i17);
        }
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Byte> iterator2() {
        return new a();
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteString readFrom(InputStream inputStream, int i3, int i16) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            ByteString d16 = d(inputStream, i3);
            if (d16 == null) {
                return copyFrom(arrayList);
            }
            arrayList.add(d16);
            i3 = Math.min(i3 * 2, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class h extends OutputStream {

        /* renamed from: m, reason: collision with root package name */
        private static final byte[] f35245m = new byte[0];

        /* renamed from: d, reason: collision with root package name */
        private final int f35246d;

        /* renamed from: e, reason: collision with root package name */
        private final ArrayList<ByteString> f35247e;

        /* renamed from: f, reason: collision with root package name */
        private int f35248f;

        /* renamed from: h, reason: collision with root package name */
        private byte[] f35249h;

        /* renamed from: i, reason: collision with root package name */
        private int f35250i;

        h(int i3) {
            if (i3 >= 0) {
                this.f35246d = i3;
                this.f35247e = new ArrayList<>();
                this.f35249h = new byte[i3];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private void a(int i3) {
            this.f35247e.add(new LiteralByteString(this.f35249h));
            int length = this.f35248f + this.f35249h.length;
            this.f35248f = length;
            this.f35249h = new byte[Math.max(this.f35246d, Math.max(i3, length >>> 1))];
            this.f35250i = 0;
        }

        public synchronized int d() {
            return this.f35248f + this.f35250i;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(d()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i3) {
            if (this.f35250i == this.f35249h.length) {
                a(1);
            }
            byte[] bArr = this.f35249h;
            int i16 = this.f35250i;
            this.f35250i = i16 + 1;
            bArr[i16] = (byte) i3;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i3, int i16) {
            byte[] bArr2 = this.f35249h;
            int length = bArr2.length;
            int i17 = this.f35250i;
            if (i16 <= length - i17) {
                System.arraycopy(bArr, i3, bArr2, i17, i16);
                this.f35250i += i16;
            } else {
                int length2 = bArr2.length - i17;
                System.arraycopy(bArr, i3, bArr2, i17, length2);
                int i18 = i16 - length2;
                a(i18);
                System.arraycopy(bArr, i3 + length2, this.f35249h, 0, i18);
                this.f35250i = i18;
            }
        }
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int i3) {
        checkRange(0, i3, byteBuffer.remaining());
        byte[] bArr = new byte[i3];
        byteBuffer.get(bArr);
        return new LiteralByteString(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString wrap(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    public final String toString(Charset charset) {
        return size() == 0 ? "" : toStringInternal(charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString wrap(byte[] bArr, int i3, int i16) {
        return new BoundedByteString(bArr, i3, i16);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), h());
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString copyFrom(String str, String str2) throws UnsupportedEncodingException {
        return new LiteralByteString(str.getBytes(str2));
    }

    public static ByteString copyFrom(String str, Charset charset) {
        return new LiteralByteString(str.getBytes(charset));
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        int size;
        if (!(iterable instanceof Collection)) {
            Iterator<ByteString> it = iterable.iterator();
            size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
        } else {
            size = ((Collection) iterable).size();
        }
        if (size == 0) {
            return EMPTY;
        }
        return a(iterable.iterator(), size);
    }
}

package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class RopeByteString extends ByteString {
    static final int[] minLengthByDepth = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, NotificationUtil.Constants.NOTIFY_ID_UNIFORM_DOWNLOAD_END, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private static final long serialVersionUID = 1;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends ByteString.c {

        /* renamed from: d, reason: collision with root package name */
        final c f35594d;

        /* renamed from: e, reason: collision with root package name */
        ByteString.f f35595e = b();

        a() {
            this.f35594d = new c(RopeByteString.this, null);
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [com.google.protobuf.ByteString$f] */
        private ByteString.f b() {
            if (this.f35594d.hasNext()) {
                return this.f35594d.next().iterator2();
            }
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f35595e != null) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.ByteString.f
        public byte nextByte() {
            ByteString.f fVar = this.f35595e;
            if (fVar != null) {
                byte nextByte = fVar.nextByte();
                if (!this.f35595e.hasNext()) {
                    this.f35595e = b();
                }
                return nextByte;
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class c implements Iterator<ByteString.LeafByteString> {

        /* renamed from: d, reason: collision with root package name */
        private final ArrayDeque<RopeByteString> f35598d;

        /* renamed from: e, reason: collision with root package name */
        private ByteString.LeafByteString f35599e;

        /* synthetic */ c(ByteString byteString, a aVar) {
            this(byteString);
        }

        private ByteString.LeafByteString a(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.f35598d.push(ropeByteString);
                byteString = ropeByteString.left;
            }
            return (ByteString.LeafByteString) byteString;
        }

        private ByteString.LeafByteString b() {
            ByteString.LeafByteString a16;
            do {
                ArrayDeque<RopeByteString> arrayDeque = this.f35598d;
                if (arrayDeque != null && !arrayDeque.isEmpty()) {
                    a16 = a(this.f35598d.pop().right);
                } else {
                    return null;
                }
            } while (a16.isEmpty());
            return a16;
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public ByteString.LeafByteString next() {
            ByteString.LeafByteString leafByteString = this.f35599e;
            if (leafByteString != null) {
                this.f35599e = b();
                return leafByteString;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f35599e != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        c(ByteString byteString) {
            if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                ArrayDeque<RopeByteString> arrayDeque = new ArrayDeque<>(ropeByteString.getTreeDepth());
                this.f35598d = arrayDeque;
                arrayDeque.push(ropeByteString);
                this.f35599e = a(ropeByteString.left);
                return;
            }
            this.f35598d = null;
            this.f35599e = (ByteString.LeafByteString) byteString;
        }
    }

    /* synthetic */ RopeByteString(ByteString byteString, ByteString byteString2, a aVar) {
        this(byteString, byteString2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString concatenate(ByteString byteString, ByteString byteString2) {
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int size = byteString.size() + byteString2.size();
        if (size < 128) {
            return i(byteString, byteString2);
        }
        if (byteString instanceof RopeByteString) {
            RopeByteString ropeByteString = (RopeByteString) byteString;
            if (ropeByteString.right.size() + byteString2.size() < 128) {
                return new RopeByteString(ropeByteString.left, i(ropeByteString.right, byteString2));
            }
            if (ropeByteString.left.getTreeDepth() > ropeByteString.right.getTreeDepth() && ropeByteString.getTreeDepth() > byteString2.getTreeDepth()) {
                return new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString2));
            }
        }
        if (size < minLength(Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1)) {
            return new b(null).b(byteString, byteString2);
        }
        return new RopeByteString(byteString, byteString2);
    }

    private static ByteString i(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[size + size2];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return ByteString.wrap(bArr);
    }

    private boolean m(ByteString byteString) {
        boolean equalsRange;
        a aVar = null;
        c cVar = new c(this, aVar);
        ByteString.LeafByteString next = cVar.next();
        c cVar2 = new c(byteString, aVar);
        ByteString.LeafByteString next2 = cVar2.next();
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            int size = next.size() - i3;
            int size2 = next2.size() - i16;
            int min = Math.min(size, size2);
            if (i3 == 0) {
                equalsRange = next.equalsRange(next2, i16, min);
            } else {
                equalsRange = next2.equalsRange(next, i3, min);
            }
            if (!equalsRange) {
                return false;
            }
            i17 += min;
            int i18 = this.totalLength;
            if (i17 >= i18) {
                if (i17 == i18) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                i3 = 0;
                next = cVar.next();
            } else {
                i3 += min;
                next = next;
            }
            if (min == size2) {
                next2 = cVar2.next();
                i16 = 0;
            } else {
                i16 += min;
            }
        }
    }

    static int minLength(int i3) {
        int[] iArr = minLengthByDepth;
        if (i3 >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i3];
    }

    static RopeByteString newInstanceForTest(ByteString byteString, ByteString byteString2) {
        return new RopeByteString(byteString, byteString2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList arrayList = new ArrayList();
        c cVar = new c(this, null);
        while (cVar.hasNext()) {
            arrayList.add(cVar.next().asReadOnlyByteBuffer());
        }
        return arrayList;
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i3) {
        ByteString.checkIndex(i3, this.totalLength);
        return internalByteAt(i3);
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        this.left.copyTo(byteBuffer);
        this.right.copyTo(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i3, int i16, int i17) {
        int i18 = i3 + i17;
        int i19 = this.leftLength;
        if (i18 <= i19) {
            this.left.copyToInternal(bArr, i3, i16, i17);
        } else {
            if (i3 >= i19) {
                this.right.copyToInternal(bArr, i3 - i19, i16, i17);
                return;
            }
            int i26 = i19 - i3;
            this.left.copyToInternal(bArr, i3, i16, i26);
            this.right.copyToInternal(bArr, 0, i16 + i26, i17 - i26);
        }
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        int peekCachedHashCode = peekCachedHashCode();
        int peekCachedHashCode2 = byteString.peekCachedHashCode();
        if (peekCachedHashCode != 0 && peekCachedHashCode2 != 0 && peekCachedHashCode != peekCachedHashCode2) {
            return false;
        }
        return m(byteString);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public int getTreeDepth() {
        return this.treeDepth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ByteString
    public byte internalByteAt(int i3) {
        int i16 = this.leftLength;
        if (i3 < i16) {
            return this.left.internalByteAt(i3);
        }
        return this.right.internalByteAt(i3 - i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public boolean isBalanced() {
        if (this.totalLength >= minLength(this.treeDepth)) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        int partialIsValidUtf8 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString byteString = this.right;
        if (byteString.partialIsValidUtf8(partialIsValidUtf8, 0, byteString.size()) != 0) {
            return false;
        }
        return true;
    }

    @Override // com.google.protobuf.ByteString
    public k newCodedInput() {
        return k.g(new d());
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public int partialHash(int i3, int i16, int i17) {
        int i18 = i16 + i17;
        int i19 = this.leftLength;
        if (i18 <= i19) {
            return this.left.partialHash(i3, i16, i17);
        }
        if (i16 >= i19) {
            return this.right.partialHash(i3, i16 - i19, i17);
        }
        int i26 = i19 - i16;
        return this.right.partialHash(this.left.partialHash(i3, i16, i26), 0, i17 - i26);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public int partialIsValidUtf8(int i3, int i16, int i17) {
        int i18 = i16 + i17;
        int i19 = this.leftLength;
        if (i18 <= i19) {
            return this.left.partialIsValidUtf8(i3, i16, i17);
        }
        if (i16 >= i19) {
            return this.right.partialIsValidUtf8(i3, i16 - i19, i17);
        }
        int i26 = i19 - i16;
        return this.right.partialIsValidUtf8(this.left.partialIsValidUtf8(i3, i16, i26), 0, i17 - i26);
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i3, int i16) {
        int checkRange = ByteString.checkRange(i3, i16, this.totalLength);
        if (checkRange == 0) {
            return ByteString.EMPTY;
        }
        if (checkRange == this.totalLength) {
            return this;
        }
        int i17 = this.leftLength;
        if (i16 <= i17) {
            return this.left.substring(i3, i16);
        }
        if (i3 >= i17) {
            return this.right.substring(i3 - i17, i16 - i17);
        }
        return new RopeByteString(this.left.substring(i3), this.right.substring(0, i16 - this.leftLength));
    }

    @Override // com.google.protobuf.ByteString
    protected String toStringInternal(Charset charset) {
        return new String(toByteArray(), charset);
    }

    Object writeReplace() {
        return ByteString.wrap(toByteArray());
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ByteString
    public void writeToInternal(OutputStream outputStream, int i3, int i16) throws IOException {
        int i17 = i3 + i16;
        int i18 = this.leftLength;
        if (i17 <= i18) {
            this.left.writeToInternal(outputStream, i3, i16);
        } else {
            if (i3 >= i18) {
                this.right.writeToInternal(outputStream, i3 - i18, i16);
                return;
            }
            int i19 = i18 - i3;
            this.left.writeToInternal(outputStream, i3, i19);
            this.right.writeToInternal(outputStream, 0, i16 - i19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ByteString
    public void writeToReverse(j jVar) throws IOException {
        this.right.writeToReverse(jVar);
        this.left.writeToReverse(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final ArrayDeque<ByteString> f35597a;

        b() {
            this.f35597a = new ArrayDeque<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ByteString b(ByteString byteString, ByteString byteString2) {
            c(byteString);
            c(byteString2);
            ByteString pop = this.f35597a.pop();
            while (!this.f35597a.isEmpty()) {
                pop = new RopeByteString(this.f35597a.pop(), pop, null);
            }
            return pop;
        }

        private void c(ByteString byteString) {
            if (byteString.isBalanced()) {
                e(byteString);
                return;
            }
            if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                c(ropeByteString.left);
                c(ropeByteString.right);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
            }
        }

        private int d(int i3) {
            int binarySearch = Arrays.binarySearch(RopeByteString.minLengthByDepth, i3);
            if (binarySearch < 0) {
                return (-(binarySearch + 1)) - 1;
            }
            return binarySearch;
        }

        private void e(ByteString byteString) {
            a aVar;
            int d16 = d(byteString.size());
            int minLength = RopeByteString.minLength(d16 + 1);
            if (!this.f35597a.isEmpty() && this.f35597a.peek().size() < minLength) {
                int minLength2 = RopeByteString.minLength(d16);
                ByteString pop = this.f35597a.pop();
                while (true) {
                    aVar = null;
                    if (this.f35597a.isEmpty() || this.f35597a.peek().size() >= minLength2) {
                        break;
                    } else {
                        pop = new RopeByteString(this.f35597a.pop(), pop, aVar);
                    }
                }
                RopeByteString ropeByteString = new RopeByteString(pop, byteString, aVar);
                while (!this.f35597a.isEmpty()) {
                    if (this.f35597a.peek().size() >= RopeByteString.minLength(d(ropeByteString.size()) + 1)) {
                        break;
                    } else {
                        ropeByteString = new RopeByteString(this.f35597a.pop(), ropeByteString, aVar);
                    }
                }
                this.f35597a.push(ropeByteString);
                return;
            }
            this.f35597a.push(byteString);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    RopeByteString(ByteString byteString, ByteString byteString2) {
        this.left = byteString;
        this.right = byteString2;
        int size = byteString.size();
        this.leftLength = size;
        this.totalLength = size + byteString2.size();
        this.treeDepth = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    @Override // com.google.protobuf.ByteString, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Byte> iterator2() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ByteString
    public void writeTo(j jVar) throws IOException {
        this.left.writeTo(jVar);
        this.right.writeTo(jVar);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class d extends InputStream {

        /* renamed from: d, reason: collision with root package name */
        private c f35600d;

        /* renamed from: e, reason: collision with root package name */
        private ByteString.LeafByteString f35601e;

        /* renamed from: f, reason: collision with root package name */
        private int f35602f;

        /* renamed from: h, reason: collision with root package name */
        private int f35603h;

        /* renamed from: i, reason: collision with root package name */
        private int f35604i;

        /* renamed from: m, reason: collision with root package name */
        private int f35605m;

        public d() {
            d();
        }

        private void a() {
            if (this.f35601e != null) {
                int i3 = this.f35603h;
                int i16 = this.f35602f;
                if (i3 == i16) {
                    this.f35604i += i16;
                    this.f35603h = 0;
                    if (this.f35600d.hasNext()) {
                        ByteString.LeafByteString next = this.f35600d.next();
                        this.f35601e = next;
                        this.f35602f = next.size();
                    } else {
                        this.f35601e = null;
                        this.f35602f = 0;
                    }
                }
            }
        }

        private void d() {
            c cVar = new c(RopeByteString.this, null);
            this.f35600d = cVar;
            ByteString.LeafByteString next = cVar.next();
            this.f35601e = next;
            this.f35602f = next.size();
            this.f35603h = 0;
            this.f35604i = 0;
        }

        private int e(byte[] bArr, int i3, int i16) {
            int i17 = i16;
            while (i17 > 0) {
                a();
                if (this.f35601e == null) {
                    break;
                }
                int min = Math.min(this.f35602f - this.f35603h, i17);
                if (bArr != null) {
                    this.f35601e.copyTo(bArr, this.f35603h, i3, min);
                    i3 += min;
                }
                this.f35603h += min;
                i17 -= min;
            }
            return i16 - i17;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return RopeByteString.this.size() - (this.f35604i + this.f35603h);
        }

        @Override // java.io.InputStream
        public void mark(int i3) {
            this.f35605m = this.f35604i + this.f35603h;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i16) {
            bArr.getClass();
            if (i3 >= 0 && i16 >= 0 && i16 <= bArr.length - i3) {
                int e16 = e(bArr, i3, i16);
                if (e16 == 0) {
                    return -1;
                }
                return e16;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            d();
            e(null, 0, this.f35605m);
        }

        @Override // java.io.InputStream
        public long skip(long j3) {
            if (j3 >= 0) {
                if (j3 > TTL.MAX_VALUE) {
                    j3 = 2147483647L;
                }
                return e(null, 0, (int) j3);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            a();
            ByteString.LeafByteString leafByteString = this.f35601e;
            if (leafByteString == null) {
                return -1;
            }
            int i3 = this.f35603h;
            this.f35603h = i3 + 1;
            return leafByteString.byteAt(i3) & 255;
        }
    }
}

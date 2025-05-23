package kotlin.reflect.jvm.internal.impl.protobuf;

import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public class RopeByteString extends ByteString {
    private static final int[] minLengthByDepth;
    private int hash;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static class Balancer {
        private final Stack<ByteString> prefixesStack;

        Balancer() {
            this.prefixesStack = new Stack<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ByteString balance(ByteString byteString, ByteString byteString2) {
            doBalance(byteString);
            doBalance(byteString2);
            ByteString pop = this.prefixesStack.pop();
            while (!this.prefixesStack.isEmpty()) {
                pop = new RopeByteString(this.prefixesStack.pop(), pop);
            }
            return pop;
        }

        private void doBalance(ByteString byteString) {
            if (byteString.isBalanced()) {
                insert(byteString);
                return;
            }
            if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                doBalance(ropeByteString.left);
                doBalance(ropeByteString.right);
            } else {
                String valueOf = String.valueOf(byteString.getClass());
                StringBuilder sb5 = new StringBuilder(valueOf.length() + 49);
                sb5.append("Has a new type of ByteString been created? Found ");
                sb5.append(valueOf);
                throw new IllegalArgumentException(sb5.toString());
            }
        }

        private int getDepthBinForLength(int i3) {
            int binarySearch = Arrays.binarySearch(RopeByteString.minLengthByDepth, i3);
            if (binarySearch < 0) {
                return (-(binarySearch + 1)) - 1;
            }
            return binarySearch;
        }

        private void insert(ByteString byteString) {
            int depthBinForLength = getDepthBinForLength(byteString.size());
            int i3 = RopeByteString.minLengthByDepth[depthBinForLength + 1];
            if (!this.prefixesStack.isEmpty() && this.prefixesStack.peek().size() < i3) {
                int i16 = RopeByteString.minLengthByDepth[depthBinForLength];
                ByteString pop = this.prefixesStack.pop();
                while (true) {
                    if (this.prefixesStack.isEmpty() || this.prefixesStack.peek().size() >= i16) {
                        break;
                    } else {
                        pop = new RopeByteString(this.prefixesStack.pop(), pop);
                    }
                }
                RopeByteString ropeByteString = new RopeByteString(pop, byteString);
                while (!this.prefixesStack.isEmpty()) {
                    if (this.prefixesStack.peek().size() >= RopeByteString.minLengthByDepth[getDepthBinForLength(ropeByteString.size()) + 1]) {
                        break;
                    } else {
                        ropeByteString = new RopeByteString(this.prefixesStack.pop(), ropeByteString);
                    }
                }
                this.prefixesStack.push(ropeByteString);
                return;
            }
            this.prefixesStack.push(byteString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class PieceIterator implements Iterator<LiteralByteString> {
        private final Stack<RopeByteString> breadCrumbs;
        private LiteralByteString next;

        private LiteralByteString getLeafByLeft(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.breadCrumbs.push(ropeByteString);
                byteString = ropeByteString.left;
            }
            return (LiteralByteString) byteString;
        }

        private LiteralByteString getNextNonEmptyLeaf() {
            while (!this.breadCrumbs.isEmpty()) {
                LiteralByteString leafByLeft = getLeafByLeft(this.breadCrumbs.pop().right);
                if (!leafByLeft.isEmpty()) {
                    return leafByLeft;
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.next != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        PieceIterator(ByteString byteString) {
            this.breadCrumbs = new Stack<>();
            this.next = getLeafByLeft(byteString);
        }

        @Override // java.util.Iterator
        public LiteralByteString next() {
            LiteralByteString literalByteString = this.next;
            if (literalByteString != null) {
                this.next = getNextNonEmptyLeaf();
                return literalByteString;
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class RopeByteIterator implements ByteString.ByteIterator {
        private ByteString.ByteIterator bytes;
        int bytesRemaining;
        private final PieceIterator pieces;

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.bytesRemaining > 0) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Type inference failed for: r0v8, types: [kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator] */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            if (!this.bytes.hasNext()) {
                this.bytes = this.pieces.next().iterator();
            }
            this.bytesRemaining--;
            return this.bytes.nextByte();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator] */
        RopeByteIterator() {
            PieceIterator pieceIterator = new PieceIterator(RopeByteString.this);
            this.pieces = pieceIterator;
            this.bytes = pieceIterator.next().iterator();
            this.bytesRemaining = RopeByteString.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i3 = 1;
        int i16 = 1;
        while (i3 > 0) {
            arrayList.add(Integer.valueOf(i3));
            int i17 = i16 + i3;
            i16 = i3;
            i3 = i17;
        }
        arrayList.add(Integer.MAX_VALUE);
        minLengthByDepth = new int[arrayList.size()];
        int i18 = 0;
        while (true) {
            int[] iArr = minLengthByDepth;
            if (i18 < iArr.length) {
                iArr[i18] = ((Integer) arrayList.get(i18)).intValue();
                i18++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString concatenate(ByteString byteString, ByteString byteString2) {
        RopeByteString ropeByteString;
        if (byteString instanceof RopeByteString) {
            ropeByteString = (RopeByteString) byteString;
        } else {
            ropeByteString = null;
        }
        if (byteString2.size() != 0) {
            if (byteString.size() != 0) {
                int size = byteString.size() + byteString2.size();
                if (size < 128) {
                    return concatenateBytes(byteString, byteString2);
                }
                if (ropeByteString != null && ropeByteString.right.size() + byteString2.size() < 128) {
                    byteString2 = new RopeByteString(ropeByteString.left, concatenateBytes(ropeByteString.right, byteString2));
                } else if (ropeByteString != null && ropeByteString.left.getTreeDepth() > ropeByteString.right.getTreeDepth() && ropeByteString.getTreeDepth() > byteString2.getTreeDepth()) {
                    byteString2 = new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString2));
                } else {
                    if (size < minLengthByDepth[Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1]) {
                        return new Balancer().balance(byteString, byteString2);
                    }
                    return new RopeByteString(byteString, byteString2);
                }
            }
            return byteString2;
        }
        return byteString;
    }

    private static LiteralByteString concatenateBytes(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[size + size2];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return new LiteralByteString(bArr);
    }

    private boolean equalsFragments(ByteString byteString) {
        boolean equalsRange;
        PieceIterator pieceIterator = new PieceIterator(this);
        LiteralByteString next = pieceIterator.next();
        PieceIterator pieceIterator2 = new PieceIterator(byteString);
        LiteralByteString next2 = pieceIterator2.next();
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
                next = pieceIterator.next();
                i3 = 0;
            } else {
                i3 += min;
            }
            if (min == size2) {
                next2 = pieceIterator2.next();
                i16 = 0;
            } else {
                i16 += min;
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected void copyToInternal(byte[] bArr, int i3, int i16, int i17) {
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

    public boolean equals(Object obj) {
        int peekCachedHashCode;
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
        if (this.hash != 0 && (peekCachedHashCode = byteString.peekCachedHashCode()) != 0 && this.hash != peekCachedHashCode) {
            return false;
        }
        return equalsFragments(byteString);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int getTreeDepth() {
        return this.treeDepth;
    }

    public int hashCode() {
        int i3 = this.hash;
        if (i3 == 0) {
            int i16 = this.totalLength;
            i3 = partialHash(i16, 0, i16);
            if (i3 == 0) {
                i3 = 1;
            }
            this.hash = i3;
        }
        return i3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected boolean isBalanced() {
        if (this.totalLength >= minLengthByDepth[this.treeDepth]) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isValidUtf8() {
        int partialIsValidUtf8 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString byteString = this.right;
        if (byteString.partialIsValidUtf8(partialIsValidUtf8, 0, byteString.size()) != 0) {
            return false;
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(new RopeInputStream());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int partialHash(int i3, int i16, int i17) {
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

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int partialIsValidUtf8(int i3, int i16, int i17) {
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

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int peekCachedHashCode() {
        return this.hash;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public String toString(String str) throws UnsupportedEncodingException {
        return new String(toByteArray(), str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    void writeToInternal(OutputStream outputStream, int i3, int i16) throws IOException {
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

    RopeByteString(ByteString byteString, ByteString byteString2) {
        this.hash = 0;
        this.left = byteString;
        this.right = byteString2;
        int size = byteString.size();
        this.leftLength = size;
        this.totalLength = size + byteString2.size();
        this.treeDepth = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new RopeByteIterator();
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private class RopeInputStream extends InputStream {
        private LiteralByteString currentPiece;
        private int currentPieceIndex;
        private int currentPieceOffsetInRope;
        private int currentPieceSize;
        private int mark;
        private PieceIterator pieceIterator;

        public RopeInputStream() {
            initialize();
        }

        private void advanceIfCurrentPieceFullyRead() {
            if (this.currentPiece != null) {
                int i3 = this.currentPieceIndex;
                int i16 = this.currentPieceSize;
                if (i3 == i16) {
                    this.currentPieceOffsetInRope += i16;
                    this.currentPieceIndex = 0;
                    if (this.pieceIterator.hasNext()) {
                        LiteralByteString next = this.pieceIterator.next();
                        this.currentPiece = next;
                        this.currentPieceSize = next.size();
                    } else {
                        this.currentPiece = null;
                        this.currentPieceSize = 0;
                    }
                }
            }
        }

        private void initialize() {
            PieceIterator pieceIterator = new PieceIterator(RopeByteString.this);
            this.pieceIterator = pieceIterator;
            LiteralByteString next = pieceIterator.next();
            this.currentPiece = next;
            this.currentPieceSize = next.size();
            this.currentPieceIndex = 0;
            this.currentPieceOffsetInRope = 0;
        }

        private int readSkipInternal(byte[] bArr, int i3, int i16) {
            int i17 = i16;
            while (true) {
                if (i17 <= 0) {
                    break;
                }
                advanceIfCurrentPieceFullyRead();
                if (this.currentPiece == null) {
                    if (i17 == i16) {
                        return -1;
                    }
                } else {
                    int min = Math.min(this.currentPieceSize - this.currentPieceIndex, i17);
                    if (bArr != null) {
                        this.currentPiece.copyTo(bArr, this.currentPieceIndex, i3, min);
                        i3 += min;
                    }
                    this.currentPieceIndex += min;
                    i17 -= min;
                }
            }
            return i16 - i17;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return RopeByteString.this.size() - (this.currentPieceOffsetInRope + this.currentPieceIndex);
        }

        @Override // java.io.InputStream
        public void mark(int i3) {
            this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i16) {
            bArr.getClass();
            if (i3 >= 0 && i16 >= 0 && i16 <= bArr.length - i3) {
                return readSkipInternal(bArr, i3, i16);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            initialize();
            readSkipInternal(null, 0, this.mark);
        }

        @Override // java.io.InputStream
        public long skip(long j3) {
            if (j3 >= 0) {
                if (j3 > TTL.MAX_VALUE) {
                    j3 = 2147483647L;
                }
                return readSkipInternal(null, 0, (int) j3);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            advanceIfCurrentPieceFullyRead();
            LiteralByteString literalByteString = this.currentPiece;
            if (literalByteString == null) {
                return -1;
            }
            int i3 = this.currentPieceIndex;
            this.currentPieceIndex = i3 + 1;
            return literalByteString.byteAt(i3) & 255;
        }
    }
}

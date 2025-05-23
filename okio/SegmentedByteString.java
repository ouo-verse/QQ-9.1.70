package okio;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._SegmentedByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0010\u00a2\u0006\u0002\b\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\r\u0010 \u001a\u00020\u0015H\u0010\u00a2\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0015H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u001d\u0010$\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0001H\u0010\u00a2\u0006\u0002\b&J\u0018\u0010'\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J\r\u0010)\u001a\u00020\u0004H\u0010\u00a2\u0006\u0002\b*J\u0015\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0015H\u0010\u00a2\u0006\u0002\b.J\u0018\u0010/\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J(\u00100\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0015H\u0016J\b\u00108\u001a\u00020\u0001H\u0016J\b\u00109\u001a\u00020\u0001H\u0016J\b\u0010:\u001a\u00020\u0004H\u0016J\b\u0010;\u001a\u00020\u0001H\u0002J\b\u0010<\u001a\u00020\u0010H\u0016J\u0010\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020?H\u0016J%\u0010=\u001a\u00020\u00132\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0010\u00a2\u0006\u0002\bBJ\b\u0010C\u001a\u00020DH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u00a8\u0006E"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", SegmentKeeper.KEY_SEGMENT_LIST, "", "", "directory", "", "([[B[I)V", "getDirectory$okio", "()[I", "getSegments$okio", "()[[B", "[[B", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "", "base64Url", "copyInto", "", "offset", "", "target", "targetOffset", "byteCount", PublicAccountMessageUtilImpl.ITEM_DIGEST_NAME, "algorithm", "digest$okio", "equals", "", "other", "", "getSize", "getSize$okio", "hashCode", "hex", "hmac", "key", "hmac$okio", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "", com.tencent.luggage.wxa.c8.c.G, "internalGet$okio", "lastIndexOf", "rangeEquals", "otherOffset", HippyControllerProps.STRING, HttpMsg.CHARSET, "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toByteString", "toString", com.tencent.mobileqq.msf.core.auth.k.f247492f, "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeReplace", "Ljava/lang/Object;", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class SegmentedByteString extends ByteString {

    @NotNull
    private final transient int[] directory;

    @NotNull
    private final transient byte[][] segments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(@NotNull byte[][] segments, @NotNull int[] directory) {
        super(ByteString.EMPTY.getData());
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        return toByteString();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(asReadOnlyBuffer, "wrap(toByteArray()).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @Override // okio.ByteString
    @NotNull
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    @NotNull
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    public void copyInto(int offset, @NotNull byte[] target, int targetOffset, int byteCount) {
        int i3;
        Intrinsics.checkNotNullParameter(target, "target");
        long j3 = byteCount;
        _UtilKt.checkOffsetAndCount(size(), offset, j3);
        _UtilKt.checkOffsetAndCount(target.length, targetOffset, j3);
        int i16 = byteCount + offset;
        int segment = _SegmentedByteStringKt.segment(this, offset);
        while (offset < i16) {
            if (segment == 0) {
                i3 = 0;
            } else {
                i3 = getDirectory()[segment - 1];
            }
            int i17 = getDirectory()[segment] - i3;
            int i18 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i16, i17 + i3) - offset;
            int i19 = i18 + (offset - i3);
            ArraysKt___ArraysJvmKt.copyInto(getSegments()[segment], target, targetOffset, i19, i19 + min);
            targetOffset += min;
            offset += min;
            segment++;
        }
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString digest$okio(@NotNull String algorithm) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments().length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            int i17 = getDirectory()[length + i3];
            int i18 = getDirectory()[i3];
            messageDigest.update(getSegments()[i3], i17, i18 - i16);
            i3++;
            i16 = i18;
        }
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    @Override // okio.ByteString
    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ByteString) {
            ByteString byteString = (ByteString) other;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* renamed from: getDirectory$okio, reason: from getter */
    public final int[] getDirectory() {
        return this.directory;
    }

    @NotNull
    /* renamed from: getSegments$okio, reason: from getter */
    public final byte[][] getSegments() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory()[getSegments().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode == 0) {
            int length = getSegments().length;
            int i3 = 0;
            int i16 = 1;
            int i17 = 0;
            while (i3 < length) {
                int i18 = getDirectory()[length + i3];
                int i19 = getDirectory()[i3];
                byte[] bArr = getSegments()[i3];
                int i26 = (i19 - i17) + i18;
                while (i18 < i26) {
                    i16 = (i16 * 31) + bArr[i18];
                    i18++;
                }
                i3++;
                i17 = i19;
            }
            setHashCode$okio(i16);
            return i16;
        }
        return hashCode;
    }

    @Override // okio.ByteString
    @NotNull
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString hmac$okio(@NotNull String algorithm, @NotNull ByteString key) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            int length = getSegments().length;
            int i3 = 0;
            int i16 = 0;
            while (i3 < length) {
                int i17 = getDirectory()[length + i3];
                int i18 = getDirectory()[i3];
                mac.update(getSegments()[i3], i17, i18 - i16);
                i3++;
                i16 = i18;
            }
            byte[] doFinal = mac.doFinal();
            Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e16) {
            throw new IllegalArgumentException(e16);
        }
    }

    @Override // okio.ByteString
    public int indexOf(@NotNull byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return toByteString().indexOf(other, fromIndex);
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int pos) {
        int i3;
        _UtilKt.checkOffsetAndCount(getDirectory()[getSegments().length - 1], pos, 1L);
        int segment = _SegmentedByteStringKt.segment(this, pos);
        if (segment == 0) {
            i3 = 0;
        } else {
            i3 = getDirectory()[segment - 1];
        }
        return getSegments()[segment][(pos - i3) + getDirectory()[getSegments().length + segment]];
    }

    @Override // okio.ByteString
    public int lastIndexOf(@NotNull byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return toByteString().lastIndexOf(other, fromIndex);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int offset, @NotNull ByteString other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (offset < 0 || offset > size() - byteCount) {
            return false;
        }
        int i3 = byteCount + offset;
        int segment = _SegmentedByteStringKt.segment(this, offset);
        while (offset < i3) {
            int i16 = segment == 0 ? 0 : getDirectory()[segment - 1];
            int i17 = getDirectory()[segment] - i16;
            int i18 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i3, i17 + i16) - offset;
            if (!other.rangeEquals(otherOffset, getSegments()[segment], i18 + (offset - i16), min)) {
                return false;
            }
            otherOffset += min;
            offset += min;
            segment++;
        }
        return true;
    }

    @Override // okio.ByteString
    @NotNull
    public String string(@NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString substring(int beginIndex, int endIndex) {
        boolean z16;
        boolean z17;
        boolean z18;
        Object[] copyOfRange;
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(this, endIndex);
        int i3 = 0;
        if (beginIndex >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (resolveDefaultParameter <= size()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                int i16 = resolveDefaultParameter - beginIndex;
                if (i16 >= 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    if (beginIndex == 0 && resolveDefaultParameter == size()) {
                        return this;
                    }
                    if (beginIndex == resolveDefaultParameter) {
                        return ByteString.EMPTY;
                    }
                    int segment = _SegmentedByteStringKt.segment(this, beginIndex);
                    int segment2 = _SegmentedByteStringKt.segment(this, resolveDefaultParameter - 1);
                    copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(getSegments(), segment, segment2 + 1);
                    byte[][] bArr = (byte[][]) copyOfRange;
                    int[] iArr = new int[bArr.length * 2];
                    if (segment <= segment2) {
                        int i17 = 0;
                        int i18 = segment;
                        while (true) {
                            int i19 = i18 + 1;
                            iArr[i17] = Math.min(getDirectory()[i18] - beginIndex, i16);
                            int i26 = i17 + 1;
                            iArr[i17 + bArr.length] = getDirectory()[getSegments().length + i18];
                            if (i18 == segment2) {
                                break;
                            }
                            i18 = i19;
                            i17 = i26;
                        }
                    }
                    if (segment != 0) {
                        i3 = getDirectory()[segment - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = iArr[length] + (beginIndex - i3);
                    return new SegmentedByteString(bArr, iArr);
                }
                throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + beginIndex).toString());
            }
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + size() + ')').toString());
        }
        throw new IllegalArgumentException(("beginIndex=" + beginIndex + " < 0").toString());
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments().length;
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i3 < length) {
            int i18 = getDirectory()[length + i3];
            int i19 = getDirectory()[i3];
            int i26 = i19 - i16;
            ArraysKt___ArraysJvmKt.copyInto(getSegments()[i3], bArr, i17, i18, i18 + i26);
            i17 += i26;
            i3++;
            i16 = i19;
        }
        return bArr;
    }

    @Override // okio.ByteString
    @NotNull
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public void write(@NotNull OutputStream out) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        int length = getSegments().length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            int i17 = getDirectory()[length + i3];
            int i18 = getDirectory()[i3];
            out.write(getSegments()[i3], i17, i18 - i16);
            i3++;
            i16 = i18;
        }
    }

    @Override // okio.ByteString
    public void write$okio(@NotNull Buffer buffer, int offset, int byteCount) {
        int i3;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i16 = offset + byteCount;
        int segment = _SegmentedByteStringKt.segment(this, offset);
        while (offset < i16) {
            if (segment == 0) {
                i3 = 0;
            } else {
                i3 = getDirectory()[segment - 1];
            }
            int i17 = getDirectory()[segment] - i3;
            int i18 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i16, i17 + i3) - offset;
            int i19 = i18 + (offset - i3);
            Segment segment2 = new Segment(getSegments()[segment], i19, i19 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                Intrinsics.checkNotNull(segment3);
                Segment segment4 = segment3.prev;
                Intrinsics.checkNotNull(segment4);
                segment4.push(segment2);
            }
            offset += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + byteCount);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int offset, @NotNull byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (offset < 0 || offset > size() - byteCount || otherOffset < 0 || otherOffset > other.length - byteCount) {
            return false;
        }
        int i3 = byteCount + offset;
        int segment = _SegmentedByteStringKt.segment(this, offset);
        while (offset < i3) {
            int i16 = segment == 0 ? 0 : getDirectory()[segment - 1];
            int i17 = getDirectory()[segment] - i16;
            int i18 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i3, i17 + i16) - offset;
            if (!_UtilKt.arrayRangeEquals(getSegments()[segment], i18 + (offset - i16), other, otherOffset, min)) {
                return false;
            }
            otherOffset += min;
            offset += min;
            segment++;
        }
        return true;
    }
}

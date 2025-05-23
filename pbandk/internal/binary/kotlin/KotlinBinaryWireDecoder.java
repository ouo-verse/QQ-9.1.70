package pbandk.internal.binary.kotlin;

import c45.a;
import c45.b;
import c45.d;
import c45.j;
import c45.m;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import e45.c;
import e45.g;
import e45.k;
import f45.e;
import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import kotlin.text.StringsKt__StringsJVMKt;
import pbandk.InvalidProtocolBufferException;

/* compiled from: P */
/* loaded from: classes34.dex */
public final class KotlinBinaryWireDecoder implements g {

    /* renamed from: a, reason: collision with root package name */
    public final e f425878a;

    /* renamed from: b, reason: collision with root package name */
    public int f425879b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f425880c;

    /* renamed from: d, reason: collision with root package name */
    public Integer f425881d;

    public KotlinBinaryWireDecoder(e eVar) {
        this.f425878a = eVar;
    }

    @Override // e45.g
    public final int a() {
        return (int) u();
    }

    @Override // e45.g
    public final long b() {
        return u();
    }

    @Override // e45.g
    public final boolean c() {
        return u() != 0;
    }

    @Override // e45.g
    public final String d() {
        String decodeToString;
        decodeToString = StringsKt__StringsJVMKt.decodeToString(q((int) u()));
        return decodeToString;
    }

    @Override // e45.g
    public final a e() {
        return new a(q((int) u()));
    }

    @Override // e45.g
    public final long f() {
        return u();
    }

    @Override // e45.g
    public final j g(j jVar) {
        Integer o16 = o((int) u());
        j decodeWith = jVar.decodeWith(new c(this));
        if (n()) {
            this.f425881d = o16;
            return decodeWith;
        }
        throw new InvalidProtocolBufferException("Not at the end of the current message limit as expected");
    }

    @Override // e45.g
    public final int h() {
        return (int) u();
    }

    @Override // e45.g
    public final int i() {
        if (n()) {
            this.f425879b = 0;
            return 0;
        }
        int u16 = (int) u();
        this.f425879b = u16;
        if ((u16 >>> 3) != 0) {
            return u16;
        }
        throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
    }

    @Override // e45.g
    public final <T extends d> T j(d.a<T> aVar) {
        Integer o16 = o((int) u());
        T b16 = aVar.b(new c(this));
        if (n()) {
            this.f425881d = o16;
            return b16;
        }
        throw new InvalidProtocolBufferException("Not at the end of the current message limit as expected");
    }

    @Override // e45.g
    public final <T extends d.b> T k(d.b.a<T> aVar) {
        return aVar.a((int) u());
    }

    @Override // e45.g
    public final m.a l(int i3) {
        return new m.a(i3, new a(r(i3)));
    }

    @Override // e45.g
    public final <T> Sequence<T> m(b bVar) {
        Sequence<T> sequence;
        sequence = SequencesKt__SequenceBuilderKt.sequence(new KotlinBinaryWireDecoder$readPackedRepeated$2(this, bVar, null));
        return sequence;
    }

    public final boolean n() {
        int i3 = this.f425880c;
        Integer num = this.f425881d;
        return (num != null && i3 == num.intValue()) || (this.f425881d == null && this.f425878a.isAtEnd());
    }

    public final Integer o(int i3) {
        Integer num = this.f425881d;
        this.f425881d = Integer.valueOf(this.f425880c + i3);
        return num;
    }

    @Override // e45.g
    public final double readDouble() {
        DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
        return Double.longBitsToDouble(t());
    }

    @Override // e45.g
    public final float readFloat() {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(s());
    }

    public final void v() {
        int i3;
        do {
            int i16 = i();
            i3 = 0;
            if (e45.j.b(i16, 0)) {
                return;
            }
            int i17 = i16 & 7;
            if (k.a(i17, 0)) {
                while (i3 < 10) {
                    if (p() < 0) {
                        i3++;
                    }
                }
                throw InvalidProtocolBufferException.Companion.a();
            }
            if (k.a(i17, 5)) {
                this.f425878a.a(4);
            } else if (k.a(i17, 1)) {
                this.f425878a.a(8);
            } else if (k.a(i17, 2)) {
                this.f425878a.a((int) u());
            } else if (k.a(i17, 3)) {
                v();
                if (!e45.j.b(this.f425879b, e45.j.a(i16 >>> 3, 4))) {
                    throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
                }
            } else if (!k.a(i17, 4)) {
                throw new InvalidProtocolBufferException("Protocol message tag had invalid wire type.");
            }
            i3 = 1;
        } while (i3 != 0);
    }

    public final byte p() {
        return q(1)[0];
    }

    public final byte[] r(int i3) {
        byte[] plus;
        if (k.a(i3, 0)) {
            byte[] bArr = new byte[10];
            for (int i16 = 0; i16 < 10; i16++) {
                byte p16 = p();
                bArr[i16] = p16;
                if (p16 >= 0) {
                    byte[] copyOf = Arrays.copyOf(bArr, i16 + 1);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                    return copyOf;
                }
            }
            throw InvalidProtocolBufferException.Companion.a();
        }
        if (k.a(i3, 1)) {
            return q(8);
        }
        if (k.a(i3, 2)) {
            byte[] r16 = r(0);
            plus = ArraysKt___ArraysJvmKt.plus(r16, q((int) new KotlinBinaryWireDecoder(new f45.a(r16, r16.length)).u()));
            return plus;
        }
        if (k.a(i3, 3)) {
            v();
            if (k.a(this.f425879b & 7, 4)) {
                return new byte[0];
            }
            throw new InvalidProtocolBufferException("Encountered a malformed START_GROUP tag with no matching END_GROUP tag");
        }
        if (k.a(i3, 5)) {
            return q(4);
        }
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Unrecognized wire type: ");
        m3.append((Object) ("WireType(value=" + i3 + ')'));
        throw new InvalidProtocolBufferException(m3.toString());
    }

    public final int s() {
        int lastIndex;
        byte[] q16 = q(4);
        int i3 = 0;
        for (lastIndex = ArraysKt___ArraysKt.getLastIndex(q16); lastIndex >= 0; lastIndex--) {
            i3 = (i3 << 8) | (q16[lastIndex] & 255);
        }
        return i3;
    }

    public final byte[] q(int i3) {
        if (i3 >= 0) {
            int i16 = this.f425880c + i3;
            Integer num = this.f425881d;
            if (i16 <= (num != null ? num.intValue() : Integer.MAX_VALUE)) {
                this.f425880c += i3;
                return this.f425878a.b(i3);
            }
        }
        if (i3 > 0) {
            throw InvalidProtocolBufferException.Companion.c();
        }
        if (i3 == 0) {
            return new byte[0];
        }
        throw InvalidProtocolBufferException.Companion.b();
    }

    public final long t() {
        int lastIndex;
        long j3 = 0;
        for (lastIndex = ArraysKt___ArraysKt.getLastIndex(q(8)); lastIndex >= 0; lastIndex--) {
            j3 = (j3 << 8) | (r1[lastIndex] & 255);
        }
        return j3;
    }

    public final long u() {
        IntRange until;
        IntProgression step;
        until = RangesKt___RangesKt.until(0, 64);
        step = RangesKt___RangesKt.step(until, 7);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            long j3 = 0;
            while (true) {
                j3 |= (r5 & Byte.MAX_VALUE) << first;
                if ((p() & 128) != 0) {
                    if (first == last) {
                        break;
                    }
                    first += step2;
                } else {
                    return j3;
                }
            }
        }
        throw InvalidProtocolBufferException.Companion.a();
    }
}

package com.tencent.luggage.wxa.n3;

import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e0 extends Number {

    /* renamed from: b, reason: collision with root package name */
    public static final a f135163b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f135164a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(long j3) {
            return new e0(j3).toString();
        }

        public final String b(long j3) {
            int checkRadix;
            int checkRadix2;
            String a16;
            int checkRadix3;
            if (j3 >= 0) {
                checkRadix3 = CharsKt__CharJVMKt.checkRadix(10);
                String l3 = Long.toString(j3, checkRadix3);
                Intrinsics.checkNotNullExpressionValue(l3, "toString(this, checkRadix(radix))");
                return l3;
            }
            long j16 = 10;
            long j17 = ((j3 >>> 1) / j16) << 1;
            long j18 = j3 - (j17 * j16);
            if (j18 >= j16) {
                j18 -= j16;
                j17++;
            }
            StringBuilder sb5 = new StringBuilder();
            checkRadix = CharsKt__CharJVMKt.checkRadix(10);
            String l16 = Long.toString(j17, checkRadix);
            Intrinsics.checkNotNullExpressionValue(l16, "toString(this, checkRadix(radix))");
            sb5.append(l16);
            checkRadix2 = CharsKt__CharJVMKt.checkRadix(10);
            String l17 = Long.toString(j18, checkRadix2);
            Intrinsics.checkNotNullExpressionValue(l17, "toString(this, checkRadix(radix))");
            sb5.append(l17);
            String sb6 = sb5.toString();
            try {
                a16 = ab.a(ULong.m648constructorimpl(j3), 10);
                com.tencent.luggage.wxa.er.a.a(sb6, a16);
            } catch (VerifyError unused) {
            }
            return sb6;
        }
    }

    public e0(long j3) {
        this.f135164a = j3;
    }

    public byte a() {
        return (byte) this.f135164a;
    }

    public double b() {
        return this.f135164a;
    }

    @Override // java.lang.Number
    public final /* bridge */ byte byteValue() {
        return a();
    }

    public float c() {
        return (float) this.f135164a;
    }

    public int d() {
        return (int) this.f135164a;
    }

    @Override // java.lang.Number
    public final /* bridge */ double doubleValue() {
        return b();
    }

    public long e() {
        return this.f135164a;
    }

    public short f() {
        return (short) this.f135164a;
    }

    @Override // java.lang.Number
    public final /* bridge */ float floatValue() {
        return c();
    }

    @Override // java.lang.Number
    public final /* bridge */ int intValue() {
        return d();
    }

    @Override // java.lang.Number
    public final /* bridge */ long longValue() {
        return e();
    }

    @Override // java.lang.Number
    public final /* bridge */ short shortValue() {
        return f();
    }

    public String toString() {
        return f135163b.b(this.f135164a);
    }
}

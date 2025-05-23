package c45;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f30290b = new a(new byte[0]);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f30291a;

    public a(byte[] bArr) {
        this.f30291a = bArr;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && Arrays.equals(this.f30291a, ((a) obj).f30291a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f30291a);
    }

    public final String toString() {
        String arrays = Arrays.toString(this.f30291a);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return arrays;
    }
}

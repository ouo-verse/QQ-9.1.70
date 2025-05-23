package f45;

import kotlin.collections.ArraysKt___ArraysJvmKt;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b implements f {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f397845a;

    /* renamed from: b, reason: collision with root package name */
    public int f397846b;

    public b(byte[] bArr) {
        this.f397845a = bArr;
    }

    @Override // f45.f
    public final void a(byte[] bArr, int i3) {
        ArraysKt___ArraysJvmKt.copyInto(bArr, this.f397845a, this.f397846b, 0, i3 + 0);
        this.f397846b += i3;
    }
}

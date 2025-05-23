package o01;

import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends j {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f421675c;

    @Override // o01.j
    public final int a() {
        return this.f421675c.length;
    }

    @Override // o01.j
    public final void b(a aVar) {
        int length = this.f421675c.length;
        for (int i3 = 0; i3 < length; i3++) {
            aVar.a(this.f421675c[i3], 8);
        }
    }

    public c(String str) {
        super(3, str);
        byte[] encodeToByteArray;
        encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(str);
        this.f421675c = encodeToByteArray;
    }
}

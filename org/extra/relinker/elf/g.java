package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class g extends d {

    /* renamed from: j, reason: collision with root package name */
    private final i f423585j;

    public g(boolean z16, i iVar) {
        ByteOrder byteOrder;
        this.f423571a = z16;
        this.f423585j = iVar;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        if (z16) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        this.f423572b = iVar.b(allocate, 16L);
        this.f423573c = iVar.e(allocate, 28L);
        this.f423574d = iVar.e(allocate, 32L);
        this.f423575e = iVar.b(allocate, 42L);
        this.f423576f = iVar.b(allocate, 44L);
        this.f423577g = iVar.b(allocate, 46L);
        this.f423578h = iVar.b(allocate, 48L);
        this.f423579i = iVar.b(allocate, 50L);
    }

    @Override // org.extra.relinker.elf.d
    public f a(int i3) {
        return new l(this.f423585j, this, i3);
    }

    @Override // org.extra.relinker.elf.d
    public e a(long j3) {
        return new j(this.f423585j, this, j3);
    }

    @Override // org.extra.relinker.elf.d
    public c a(long j3, int i3) {
        return new a(this.f423585j, this, j3, i3);
    }
}

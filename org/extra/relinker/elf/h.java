package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class h extends d {

    /* renamed from: j, reason: collision with root package name */
    private final i f423586j;

    public h(boolean z16, i iVar) {
        ByteOrder byteOrder;
        this.f423571a = z16;
        this.f423586j = iVar;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        if (z16) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        this.f423572b = iVar.b(allocate, 16L);
        this.f423573c = iVar.c(allocate, 32L);
        this.f423574d = iVar.c(allocate, 40L);
        this.f423575e = iVar.b(allocate, 54L);
        this.f423576f = iVar.b(allocate, 56L);
        this.f423577g = iVar.b(allocate, 58L);
        this.f423578h = iVar.b(allocate, 60L);
        this.f423579i = iVar.b(allocate, 62L);
    }

    @Override // org.extra.relinker.elf.d
    public f a(int i3) {
        return new m(this.f423586j, this, i3);
    }

    @Override // org.extra.relinker.elf.d
    public e a(long j3) {
        return new k(this.f423586j, this, j3);
    }

    @Override // org.extra.relinker.elf.d
    public c a(long j3, int i3) {
        return new b(this.f423586j, this, j3, i3);
    }
}

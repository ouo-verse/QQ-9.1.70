package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class e extends d {

    /* renamed from: h, reason: collision with root package name */
    static HashMap<String, byte[]> f98497h;

    /* renamed from: i, reason: collision with root package name */
    static HashMap<String, HashMap<String, byte[]>> f98498i;

    /* renamed from: g, reason: collision with root package name */
    protected g f98499g;

    /* renamed from: j, reason: collision with root package name */
    private int f98500j;

    public e() {
        g gVar = new g();
        this.f98499g = gVar;
        this.f98500j = 0;
        gVar.f98506a = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.c
    public final <T> void a(String str, T t16) {
        if (!str.startsWith(".")) {
            super.a(str, (String) t16);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is ".concat(str));
    }

    @Override // com.tencent.bugly.proguard.d
    public final void b() {
        super.b();
        this.f98499g.f98506a = (short) 3;
    }

    public final void c(String str) {
        this.f98499g.f98511f = str;
    }

    public final void c() {
        this.f98499g.f98509d = 1;
    }

    public final void b(String str) {
        this.f98499g.f98510e = str;
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.c
    public final byte[] a() {
        g gVar = this.f98499g;
        if (gVar.f98506a == 2) {
            if (!gVar.f98510e.equals("")) {
                if (this.f98499g.f98511f.equals("")) {
                    throw new IllegalArgumentException("funcName can not is null");
                }
            } else {
                throw new IllegalArgumentException("servantName can not is null");
            }
        } else {
            if (gVar.f98510e == null) {
                gVar.f98510e = "";
            }
            if (gVar.f98511f == null) {
                gVar.f98511f = "";
            }
        }
        l lVar = new l(0);
        lVar.a(this.f98380c);
        if (this.f98499g.f98506a == 2) {
            lVar.a((Map) this.f98378a, 0);
        } else {
            lVar.a((Map) ((d) this).f98494e, 0);
        }
        this.f98499g.f98512g = n.a(lVar.f98522a);
        l lVar2 = new l(0);
        lVar2.a(this.f98380c);
        this.f98499g.a(lVar2);
        byte[] a16 = n.a(lVar2.f98522a);
        int length = a16.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a16).flip();
        return allocate.array();
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.c
    public final void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                k kVar = new k(bArr, (byte) 0);
                kVar.a(this.f98380c);
                this.f98499g.a(kVar);
                g gVar = this.f98499g;
                if (gVar.f98506a == 3) {
                    k kVar2 = new k(gVar.f98512g);
                    kVar2.a(this.f98380c);
                    if (f98497h == null) {
                        HashMap<String, byte[]> hashMap = new HashMap<>();
                        f98497h = hashMap;
                        hashMap.put("", new byte[0]);
                    }
                    ((d) this).f98494e = kVar2.a((Map) f98497h, 0, false);
                    return;
                }
                k kVar3 = new k(gVar.f98512g);
                kVar3.a(this.f98380c);
                if (f98498i == null) {
                    f98498i = new HashMap<>();
                    HashMap<String, byte[]> hashMap2 = new HashMap<>();
                    hashMap2.put("", new byte[0]);
                    f98498i.put("", hashMap2);
                }
                this.f98378a = kVar3.a((Map) f98498i, 0, false);
                this.f98379b = new HashMap<>();
                return;
            } catch (Exception e16) {
                throw new RuntimeException(e16);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }
}

package com.tencent.mapsdk.internal;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f extends e {

    /* renamed from: h, reason: collision with root package name */
    public static final int f148341h = 4;

    /* renamed from: i, reason: collision with root package name */
    static HashMap<String, byte[]> f148342i;

    /* renamed from: j, reason: collision with root package name */
    static HashMap<String, HashMap<String, byte[]>> f148343j;

    /* renamed from: g, reason: collision with root package name */
    protected h f148344g;

    /* renamed from: k, reason: collision with root package name */
    private int f148345k;

    /* renamed from: l, reason: collision with root package name */
    private int f148346l;

    public f() {
        h hVar = new h();
        this.f148344g = hVar;
        this.f148345k = 0;
        this.f148346l = 0;
        hVar.f148610a = (short) 2;
    }

    private int h() {
        return this.f148344g.f148610a;
    }

    private int i() {
        return this.f148345k;
    }

    private void j() {
        m mVar = new m(this.f148344g.f148616g);
        mVar.a(this.f147973c);
        if (f148342i == null) {
            HashMap<String, byte[]> hashMap = new HashMap<>();
            f148342i = hashMap;
            hashMap.put("", new byte[0]);
        }
        ((e) this).f148140e = mVar.a((Map) f148342i, 0, false);
    }

    private void k() {
        m mVar = new m(this.f148344g.f148616g);
        mVar.a(this.f147973c);
        if (f148343j == null) {
            f148343j = new HashMap<>();
            HashMap<String, byte[]> hashMap = new HashMap<>();
            hashMap.put("", new byte[0]);
            f148343j.put("", hashMap);
        }
        this.f147971a = mVar.a((Map) f148343j, 0, false);
        this.f147972b = new HashMap<>();
    }

    private String l() {
        return this.f148344g.f148614e;
    }

    private String m() {
        return this.f148344g.f148615f;
    }

    private int n() {
        return this.f148344g.f148613d;
    }

    private f o() {
        f fVar = new f();
        h hVar = this.f148344g;
        fVar.f148344g.f148613d = hVar.f148613d;
        fVar.c(hVar.f148614e);
        fVar.d(this.f148344g.f148615f);
        fVar.a(this.f147973c);
        fVar.f148344g.f148610a = this.f148344g.f148610a;
        return fVar;
    }

    private byte[] p() {
        n nVar = new n(0);
        nVar.a(this.f147973c);
        nVar.a((Map) this.f147971a, 0);
        byte[] a16 = q.a(nVar.f149372a);
        n nVar2 = new n(0);
        nVar2.a(this.f147973c);
        nVar2.a(this.f148344g.f148610a, 1);
        nVar2.a(this.f148344g.f148611b, 2);
        nVar2.a(this.f148344g.f148613d, 3);
        nVar2.a(this.f148344g.f148612c, 4);
        nVar2.a(this.f148346l, 5);
        nVar2.a(a16, 6);
        nVar2.a((Map) this.f148344g.f148619j, 7);
        return q.a(nVar2.f149372a);
    }

    private int q() {
        return this.f148346l;
    }

    @Override // com.tencent.mapsdk.internal.e, com.tencent.mapsdk.internal.c
    public final <T> void a(String str, T t16) {
        if (!str.startsWith(".")) {
            super.a(str, (String) t16);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is ".concat(str));
    }

    @Override // com.tencent.mapsdk.internal.e
    public final void b(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                m mVar = new m(bArr, (byte) 0);
                mVar.a(this.f147973c);
                this.f148344g.readFrom(mVar);
                j();
                return;
            } catch (Exception e16) {
                throw new RuntimeException(e16);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    @Override // com.tencent.mapsdk.internal.e
    public final void c(byte[] bArr) {
        if (bArr.length >= 4) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 0, 4);
            allocate.put(bArr2).flip();
            this.f148345k = allocate.getInt();
            try {
                m mVar = new m(bArr, (byte) 0);
                mVar.a(this.f147973c);
                this.f148344g.readFrom(mVar);
                k();
                return;
            } catch (Exception e16) {
                throw new RuntimeException(e16);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    public final void d(String str) {
        this.f148344g.f148615f = str;
    }

    @Override // com.tencent.mapsdk.internal.e, com.tencent.mapsdk.internal.c
    public final byte[] f() {
        h hVar = this.f148344g;
        if (hVar.f148610a == 2) {
            String str = hVar.f148614e;
            if (str != null && !str.equals("")) {
                String str2 = this.f148344g.f148615f;
                if (str2 == null || str2.equals("")) {
                    throw new IllegalArgumentException("funcName can not is null");
                }
            } else {
                throw new IllegalArgumentException("servantName can not is null");
            }
        } else {
            if (hVar.f148614e == null) {
                hVar.f148614e = "";
            }
            if (hVar.f148615f == null) {
                hVar.f148615f = "";
            }
        }
        n nVar = new n(0);
        nVar.a(this.f147973c);
        short s16 = this.f148344g.f148610a;
        if (s16 != 2 && s16 != 1) {
            nVar.a((Map) ((e) this).f148140e, 0);
        } else {
            nVar.a((Map) this.f147971a, 0);
        }
        this.f148344g.f148616g = q.a(nVar.f149372a);
        n nVar2 = new n(0);
        nVar2.a(this.f147973c);
        this.f148344g.writeTo(nVar2);
        byte[] a16 = q.a(nVar2.f149372a);
        int length = a16.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a16).flip();
        return allocate.array();
    }

    @Override // com.tencent.mapsdk.internal.e
    public final void g() {
        super.g();
        this.f148344g.f148610a = (short) 3;
    }

    @Override // com.tencent.mapsdk.internal.e, com.tencent.mapsdk.internal.c
    public final void a(byte[] bArr) {
        if (bArr.length >= 4) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 0, 4);
            allocate.put(bArr2).flip();
            this.f148345k = allocate.getInt();
            try {
                m mVar = new m(bArr, (byte) 0);
                mVar.a(this.f147973c);
                this.f148344g.readFrom(mVar);
                if (this.f148344g.f148610a == 3) {
                    j();
                    return;
                } else {
                    ((e) this).f148140e = null;
                    k();
                    return;
                }
            } catch (Exception e16) {
                throw new RuntimeException(e16);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    f(boolean z16) {
        h hVar = new h();
        this.f148344g = hVar;
        this.f148345k = 0;
        this.f148346l = 0;
        if (z16) {
            g();
        } else {
            hVar.f148610a = (short) 2;
        }
    }

    private void b(int i3) {
        this.f148346l = i3;
    }

    public final void c(String str) {
        this.f148344g.f148614e = str;
    }

    private void a(int i3) {
        this.f148344g.f148613d = i3;
    }

    private void a(n nVar) {
        this.f148344g.writeTo(nVar);
    }

    private void a(m mVar) {
        this.f148344g.readFrom(mVar);
    }

    private void a(StringBuilder sb5, int i3) {
        this.f148344g.display(sb5, i3);
    }
}

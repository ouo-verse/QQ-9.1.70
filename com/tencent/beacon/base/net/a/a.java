package com.tencent.beacon.base.net.a;

import com.tencent.beacon.base.net.a.c;
import com.tencent.beacon.d.h;
import com.tencent.beacon.pack.AbstractJceStruct;
import com.tencent.beacon.pack.RequestPackage;
import com.tencent.beacon.pack.ResponsePackage;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class a extends c.a<byte[], AbstractJceStruct> {

    /* renamed from: a, reason: collision with root package name */
    private final C0785a f77703a = new C0785a();

    /* renamed from: b, reason: collision with root package name */
    private final b f77704b = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.beacon.base.net.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0785a implements c<RequestPackage, byte[]> {
        C0785a() {
        }

        private byte[] b(RequestPackage requestPackage) {
            com.tencent.beacon.pack.c cVar = new com.tencent.beacon.pack.c();
            cVar.a(1);
            cVar.b("test");
            cVar.a("test");
            cVar.b("detail", requestPackage);
            return cVar.a();
        }

        @Override // com.tencent.beacon.base.net.a.c
        public byte[] a(RequestPackage requestPackage) {
            if (requestPackage == null) {
                return null;
            }
            com.tencent.beacon.base.util.c.a("[BeaconNet]", "RequestPackage: " + requestPackage.toString(), new Object[0]);
            byte[] a16 = a(b(requestPackage));
            if (a16 != null) {
                com.tencent.beacon.base.util.c.a("[BeaconNet]", "request package after processing size: " + a16.length, new Object[0]);
            }
            return a16;
        }

        private byte[] a(byte[] bArr) {
            h c16 = h.c();
            return c16 != null ? com.tencent.beacon.base.util.b.b(bArr, 2, 3, c16.a()) : bArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class b implements c<byte[], ResponsePackage> {
        b() {
        }

        private ResponsePackage b(byte[] bArr) {
            if (bArr != null) {
                try {
                    if (bArr.length > 0) {
                        com.tencent.beacon.pack.c cVar = new com.tencent.beacon.pack.c();
                        cVar.a(bArr);
                        return (ResponsePackage) cVar.a("detail", (String) new ResponsePackage());
                    }
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return null;
        }

        private byte[] c(byte[] bArr) {
            return com.tencent.beacon.base.util.b.a(bArr, 2, 3, h.c().a());
        }

        @Override // com.tencent.beacon.base.net.a.c
        public ResponsePackage a(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            return b(c(bArr));
        }
    }

    public static a a() {
        return new a();
    }

    public c<byte[], ResponsePackage> b() {
        return this.f77704b;
    }

    public c<RequestPackage, byte[]> c() {
        return this.f77703a;
    }
}

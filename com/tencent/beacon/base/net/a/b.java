package com.tencent.beacon.base.net.a;

import com.tencent.beacon.base.net.a.c;
import com.tencent.beacon.d.h;
import com.tencent.beacon.pack.AbstractJceStruct;
import com.tencent.beacon.pack.RequestPackageV2;
import com.tencent.beacon.pack.ResponsePackageV2;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b extends c.a<byte[], AbstractJceStruct> {

    /* renamed from: a, reason: collision with root package name */
    private final a f77705a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final C0786b f77706b = new C0786b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class a implements c<RequestPackageV2, byte[]> {
        a() {
        }

        @Override // com.tencent.beacon.base.net.a.c
        public byte[] a(RequestPackageV2 requestPackageV2) {
            if (requestPackageV2 == null) {
                return null;
            }
            com.tencent.beacon.base.util.c.a("[BeaconNet]", "RequestPackageV2: " + requestPackageV2.toString(), new Object[0]);
            com.tencent.beacon.pack.b bVar = new com.tencent.beacon.pack.b();
            requestPackageV2.writeTo(bVar);
            byte[] a16 = a(bVar.b());
            if (a16 != null) {
                com.tencent.beacon.base.util.c.a("[BeaconNet]", "request package after processing size: " + a16.length, new Object[0]);
            }
            return a16;
        }

        private byte[] a(byte[] bArr) {
            h c16 = h.c();
            if (c16 == null) {
                return bArr;
            }
            if (com.tencent.beacon.d.b.a().m()) {
                return com.tencent.beacon.base.util.b.b(bArr, 2, 3, c16.a());
            }
            return com.tencent.beacon.base.util.b.b(bArr, 2);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.beacon.base.net.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0786b implements c<byte[], ResponsePackageV2> {
        C0786b() {
        }

        private byte[] b(byte[] bArr) {
            h c16 = h.c();
            if (com.tencent.beacon.d.b.a().m()) {
                return com.tencent.beacon.base.util.b.a(bArr, 2, 3, c16.a());
            }
            return com.tencent.beacon.base.util.b.a(bArr, 2);
        }

        @Override // com.tencent.beacon.base.net.a.c
        public ResponsePackageV2 a(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            byte[] b16 = b(bArr);
            ResponsePackageV2 responsePackageV2 = new ResponsePackageV2();
            responsePackageV2.readFrom(new com.tencent.beacon.pack.a(b16));
            return responsePackageV2;
        }
    }

    public static b a() {
        return new b();
    }

    public c<byte[], ResponsePackageV2> b() {
        return this.f77706b;
    }

    public c<RequestPackageV2, byte[]> c() {
        return this.f77705a;
    }
}

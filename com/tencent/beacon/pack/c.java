package com.tencent.beacon.pack;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, byte[]> f78103a;

    /* renamed from: b, reason: collision with root package name */
    public final RequestPacket f78104b = new RequestPacket();

    /* renamed from: c, reason: collision with root package name */
    public HashMap<String, byte[]> f78105c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public String f78106d = "GBK";

    /* renamed from: e, reason: collision with root package name */
    a f78107e = new a();

    static {
        HashMap<String, byte[]> hashMap = new HashMap<>();
        f78103a = hashMap;
        hashMap.put("", new byte[0]);
    }

    public void a(int i3) {
        this.f78104b.iRequestId = i3;
    }

    public void b(String str) {
        this.f78104b.sServantName = str;
    }

    public void a(String str) {
        this.f78104b.sFuncName = str;
    }

    public <T> void b(String str, T t16) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t16 != null) {
            if (!(t16 instanceof Set)) {
                b bVar = new b();
                bVar.a(this.f78106d);
                bVar.a(t16, 0);
                this.f78105c.put(str, a(bVar.a()));
                return;
            }
            throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
    }

    public byte[] a() {
        b bVar = new b(0);
        bVar.a(this.f78106d);
        bVar.a((Map) this.f78105c, 0);
        RequestPacket requestPacket = this.f78104b;
        requestPacket.iVersion = (short) 3;
        requestPacket.sBuffer = a(bVar.a());
        b bVar2 = new b(0);
        bVar2.a(this.f78106d);
        this.f78104b.writeTo(bVar2);
        byte[] a16 = a(bVar2.a());
        int length = a16.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a16).flip();
        return allocate.array();
    }

    private void b() {
        a aVar = new a(this.f78104b.sBuffer);
        aVar.a(this.f78106d);
        this.f78105c = aVar.a((Map) f78103a, 0, false);
    }

    public void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                a aVar = new a(bArr, 4);
                aVar.a(this.f78106d);
                this.f78104b.readFrom(aVar);
                b();
                return;
            } catch (Exception e16) {
                throw new RuntimeException(e16);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    public <T> T a(String str, T t16) throws Exception {
        if (!this.f78105c.containsKey(str)) {
            return null;
        }
        try {
            return (T) a(this.f78105c.get(str), t16);
        } catch (Exception e16) {
            throw new Exception(e16);
        }
    }

    private Object a(byte[] bArr, Object obj) {
        this.f78107e.a(bArr);
        this.f78107e.a(this.f78106d);
        return this.f78107e.a((a) obj, 0, true);
    }

    private byte[] a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, position);
        return bArr;
    }
}

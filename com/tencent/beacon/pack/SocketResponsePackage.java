package com.tencent.beacon.pack;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class SocketResponsePackage extends AbstractJceStruct {
    static byte[] cache_body;
    static Map<String, String> cache_header;
    public byte[] body;
    public Map<String, String> header;

    /* renamed from: msg, reason: collision with root package name */
    public String f78093msg;
    public int statusCode;

    static {
        HashMap hashMap = new HashMap();
        cache_header = hashMap;
        hashMap.put("", "");
        cache_body = r0;
        byte[] bArr = {0};
    }

    public SocketResponsePackage() {
        this.statusCode = 0;
        this.header = null;
        this.body = null;
        this.f78093msg = "";
    }

    @Override // com.tencent.beacon.pack.AbstractJceStruct
    public void readFrom(a aVar) {
        this.statusCode = aVar.a(this.statusCode, 0, true);
        this.header = (Map) aVar.a((a) cache_header, 1, true);
        this.body = aVar.a(cache_body, 2, true);
        this.f78093msg = aVar.a(3, false);
    }

    @Override // com.tencent.beacon.pack.AbstractJceStruct
    public void writeTo(b bVar) {
        bVar.a(this.statusCode, 0);
        bVar.a((Map) this.header, 1);
        bVar.a(this.body, 2);
        String str = this.f78093msg;
        if (str != null) {
            bVar.a(str, 3);
        }
    }

    public SocketResponsePackage(int i3, Map<String, String> map, byte[] bArr, String str) {
        this.statusCode = i3;
        this.header = map;
        this.body = bArr;
        this.f78093msg = str;
    }
}

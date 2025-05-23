package com.tencent.luggage.wxa.f9;

import com.tencent.luggage.wxa.cp.x;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public InputStream f125535a;

    /* renamed from: b, reason: collision with root package name */
    public String f125536b;

    /* renamed from: c, reason: collision with root package name */
    public String f125537c;

    public b(String str, boolean z16, String str2) {
        if (z16) {
            this.f125537c = com.tencent.luggage.wxa.m9.a.b(str2, str);
        } else {
            this.f125537c = com.tencent.luggage.wxa.m9.a.a(str);
        }
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioConvertCacheReader", "cacheFile:%s", this.f125537c);
        try {
            this.f125535a = x.a(com.tencent.luggage.wxa.m9.a.b(this.f125537c));
        } catch (FileNotFoundException e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioConvertCacheReader", e16, "VFSFileOp.openRead", new Object[0]);
        } catch (Exception e17) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioConvertCacheReader", e17, "VFSFileOp.openRead", new Object[0]);
        }
        this.f125536b = str;
    }

    public byte[] a(int i3) {
        InputStream inputStream = this.f125535a;
        if (inputStream == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioConvertCacheReader", "readPcmDataTrack, inputStream is null");
            return null;
        }
        if (i3 > 0) {
            byte[] bArr = new byte[i3];
            try {
                if (inputStream.read(bArr, 0, i3) > 0) {
                    return bArr;
                }
            } catch (Exception e16) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioConvertCacheReader", e16, "readPcmDataTrack", new Object[0]);
            }
        }
        return null;
    }

    public void a() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioConvertCacheReader", "release");
        try {
            InputStream inputStream = this.f125535a;
            if (inputStream != null) {
                inputStream.close();
                this.f125535a = null;
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioConvertCacheReader", e16, "inputStream close", new Object[0]);
        }
    }
}

package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.jce.rtt.RttResponse;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class rs extends lu {

    /* renamed from: a, reason: collision with root package name */
    private static final int f150127a = 3;

    /* renamed from: b, reason: collision with root package name */
    private static rs f150128b;

    private static RttResponse b(byte[] bArr) {
        for (int i3 = 0; i3 < 3; i3++) {
            try {
                NetResponse rttData = ((dh) ((dw) cr.a(dw.class)).i()).rttData(bArr);
                if (rttData != null && rttData.data != null) {
                    f fVar = new f();
                    fVar.a("UTF-8");
                    fVar.a(rttData.data);
                    return (RttResponse) fVar.b("res", true, (ClassLoader) null);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    public static synchronized rs c() {
        rs rsVar;
        synchronized (rs.class) {
            if (f150128b == null) {
                f150128b = new rs();
            }
            rsVar = f150128b;
        }
        return rsVar;
    }

    @Override // com.tencent.mapsdk.internal.lu
    public final byte[] a(byte[] bArr) {
        RttResponse b16;
        if (bArr != null) {
            try {
                if (bArr.length == 0 || (b16 = b(bArr)) == null) {
                    return null;
                }
                return b16.result;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static byte[] a(RttResponse rttResponse) {
        if (rttResponse == null) {
            return null;
        }
        return rttResponse.result;
    }
}

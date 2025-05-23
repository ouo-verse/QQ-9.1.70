package com.tencent.beacon.base.net.call;

import com.tencent.beacon.base.net.NetException;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.pack.ResponsePackage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class i implements Callback<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Callback f77773a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ j f77774b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(j jVar, Callback callback) {
        this.f77774b = jVar;
        this.f77773a = callback;
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResponse(byte[] bArr) throws NetException {
        JceRequestEntity jceRequestEntity;
        ResponsePackage a16;
        JceRequestEntity jceRequestEntity2;
        byte[] bArr2;
        long j3;
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "raw response size: " + bArr.length, new Object[0]);
        jceRequestEntity = this.f77774b.f77775a;
        if (jceRequestEntity.getType() == RequestType.EVENT) {
            a16 = com.tencent.beacon.base.net.c.c().f77734e.b().a(bArr);
            if (a16 != null) {
                bArr2 = null;
            } else {
                throw new NetException("ResponsePackageV2 == null");
            }
        } else {
            a16 = com.tencent.beacon.base.net.c.c().f77733d.b().a(bArr);
            if (a16 != null) {
                ResponsePackage responsePackage = a16;
                int i3 = responsePackage.cmd;
                jceRequestEntity2 = this.f77774b.f77775a;
                if (i3 == jceRequestEntity2.getResponseCmd()) {
                    if (responsePackage.result == 0) {
                        bArr2 = responsePackage.sBuffer;
                        if (bArr2 == null || bArr2.length <= 0) {
                            throw new NetException("responsePackage.buffer == null");
                        }
                    } else {
                        throw new NetException("responsePackage.result != OK(0)");
                    }
                } else {
                    throw new NetException("responsePackage.cmd != requestEntity.responseCmd");
                }
            } else {
                throw new NetException("responsePackage == null");
            }
        }
        j3 = this.f77774b.f77776b;
        com.tencent.beacon.base.net.b.d.a(j3, a16.serverTime, a16.srcGatewayIp);
        Callback callback = this.f77773a;
        if (callback != null) {
            callback.onResponse(bArr2);
        }
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(com.tencent.beacon.base.net.d dVar) {
        Callback callback = this.f77773a;
        if (callback != null) {
            callback.onFailure(dVar);
        }
    }
}

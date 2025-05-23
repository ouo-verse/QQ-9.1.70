package com.tencent.beacon.base.net.a;

import com.tencent.beacon.pack.SocketResponsePackage;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class e implements c<byte[], SocketResponsePackage> {
    @Override // com.tencent.beacon.base.net.a.c
    public SocketResponsePackage a(byte[] bArr) {
        SocketResponsePackage socketResponsePackage = new SocketResponsePackage();
        socketResponsePackage.readFrom(new com.tencent.beacon.pack.a(bArr));
        com.tencent.beacon.base.net.b.d.c(socketResponsePackage.header);
        return socketResponsePackage;
    }
}

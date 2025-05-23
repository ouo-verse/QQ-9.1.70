package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.core.components.protocol.jce.sso.Header;
import com.tencent.mapsdk.core.components.protocol.jce.sso.Package;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class cy {
    private static Package a(byte[] bArr) throws Exception {
        Package r06 = new Package();
        m mVar = new m(bArr);
        mVar.a("utf-8");
        r06.readFrom(mVar);
        m mVar2 = new m(r06.head);
        Header header = new Header();
        header.readFrom(mVar2);
        if (header.stResult.iErrCode == 0) {
            return r06;
        }
        throw new Exception(header.stResult.strErrDesc);
    }

    private static Package a(p pVar, int i3, String str) {
        pVar.display(new StringBuilder(), 0);
        Package r06 = new Package();
        r06.shVer = (short) 0;
        r06.eCmd = i3;
        r06.strSubCmd = str;
        r06.iSeqNo = 0;
        r06.cEncodeType = (byte) 0;
        r06.sAppId = "0";
        r06.uin = "0";
        Header header = new Header();
        header.lCurrTime = System.currentTimeMillis();
        r06.head = header.toByteArray();
        r06.busiBuff = pVar.toByteArray("UTF-8");
        return r06;
    }
}

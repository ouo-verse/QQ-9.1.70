package com.tencent.ilinkservice;

import com.tencent.ilink.tdi.TdiApiProto;
import com.tencent.ilinkservice.IlinkServiceProto;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IlinkTdiCloneSessionInterface {
    void cancelAppRequest(int i3);

    TdiApiProto.TdiUserInfo getUserInfo();

    int sendAppRequest(TdiApiProto.TdiAppRequest tdiAppRequest);

    void setCallback(TdiCloneCallback tdiCloneCallback);

    void setSmcBaseInfo(IlinkServiceProto.IlinkSmcBaseInfo ilinkSmcBaseInfo);

    void setSmcUin(int i3);

    void writeKvData(int i3, byte[] bArr, boolean z16, int i16, boolean z17);

    void writeKvData(int i3, byte[] bArr, boolean z16, int i16, boolean z17, int i17);
}

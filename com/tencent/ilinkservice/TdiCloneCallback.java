package com.tencent.ilinkservice;

import com.tencent.ilink.tdi.TdiApiProto;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface TdiCloneCallback {
    void onCloneDestroyed();

    void onReceiveAppMessage(TdiApiProto.TdiAppMessage tdiAppMessage);

    void onReceiveAppResponse(int i3, int i16, TdiApiProto.TdiAppResponse tdiAppResponse);
}

package com.tencent.qfsmonet.api.inputstream;

import com.tencent.qfsmonet.api.data.MonetPacket;

/* loaded from: classes22.dex */
public interface IMonetPacketInputStream extends IMonetInputStream {
    void pushPacketToStream(MonetPacket monetPacket);
}

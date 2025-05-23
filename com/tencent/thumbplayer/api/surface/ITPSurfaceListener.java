package com.tencent.thumbplayer.api.surface;

import com.tencent.thumbplayer.api.common.TPVideoPacketBuffer;

/* loaded from: classes26.dex */
public interface ITPSurfaceListener {
    void onFlush();

    void onRenderInfo(TPSurfaceRenderInfo tPSurfaceRenderInfo);

    void onVideoPacket(TPVideoPacketBuffer tPVideoPacketBuffer, long j3);
}

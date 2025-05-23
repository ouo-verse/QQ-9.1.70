package com.tencent.avcore.jni.net;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface INetworkAccelerationAdapter {
    void bindToNetInterface(SocketInfo socketInfo);

    boolean isSupport();

    void startRoomAccelerate();

    void stopRoomAccelerate();

    void unBindToNetInterface(SocketInfo socketInfo);
}

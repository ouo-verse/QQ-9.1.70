package com.tencent.upload.network.base;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface INetworkEngine {
    boolean connectAsync(String str, int i3, String str2, int i16, int i17);

    boolean isRunning();

    boolean sendAsync(byte[] bArr, int i3, int i16, int i17);

    boolean start();

    boolean stop();

    void wakeUp();
}

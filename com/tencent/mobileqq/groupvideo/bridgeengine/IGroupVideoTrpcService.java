package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public interface IGroupVideoTrpcService {
    void addPushListener(IGroupVideoNTPushListener iGroupVideoNTPushListener) throws NoSuchMethodException;

    void removePushListener(IGroupVideoNTPushListener iGroupVideoNTPushListener) throws NoSuchMethodException;

    void sendOIDBRequest(int i3, String str, byte[] bArr, int i16, IGroupVideoTrpcCallback iGroupVideoTrpcCallback) throws NoSuchMethodException;

    void sendRequest(String str, String str2, byte[] bArr, int i3, String str3, IGroupVideoTrpcCallback iGroupVideoTrpcCallback) throws NoSuchMethodException;
}

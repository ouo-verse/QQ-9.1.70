package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public interface IGroupVideoTrpcCallback {
    void onError(@NonNull IGroupVideoTrpcRemoteResponse iGroupVideoTrpcRemoteResponse) throws NoSuchMethodException;

    void onSuccess(@NonNull IGroupVideoTrpcRemoteResponse iGroupVideoTrpcRemoteResponse) throws NoSuchMethodException;
}

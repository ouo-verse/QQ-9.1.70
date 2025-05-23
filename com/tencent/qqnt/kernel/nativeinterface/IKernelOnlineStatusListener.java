package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelOnlineStatusListener {
    void onRecvLikeStatusResultAfterGetAggregation(int i3, String str, OSCheckLikeRsp oSCheckLikeRsp);

    void onRecvOnlineStatusPraisePush(OSGetLikeListRsp oSGetLikeListRsp);
}

package com.tencent.state.api;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/api/INetworkDelegateCallBack;", "", "onError", "", "data", "Lcom/tencent/state/api/SquareErrorData;", "onReceive", "rspData", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface INetworkDelegateCallBack {
    void onError(SquareErrorData data);

    void onReceive(byte[] rspData);
}

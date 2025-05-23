package com.tencent.rdelivery.reshub.net;

import com.tencent.raft.standard.net.IRNetwork;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\b"}, d2 = {"", "isHttpError", "", "errorCode", "", "errorMsg", "Lcom/tencent/raft/standard/net/IRNetwork$ResultInfo;", "a", "reshub-net_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a {
    @NotNull
    public static final IRNetwork.ResultInfo a(boolean z16, int i3, @NotNull String errorMsg) {
        IRNetwork.ResultInfo.ErrorType errorType;
        Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
        IRNetwork.ResultInfo resultInfo = new IRNetwork.ResultInfo();
        if (z16) {
            errorType = IRNetwork.ResultInfo.ErrorType.HTTP_ERROR;
        } else {
            errorType = IRNetwork.ResultInfo.ErrorType.OTHER_ERROR;
        }
        resultInfo.setErrorType(errorType);
        resultInfo.setErrorCode(Integer.valueOf(i3));
        resultInfo.setErrorMessage(errorMsg);
        return resultInfo;
    }
}

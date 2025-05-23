package com.tencent.state.common.push;

import com.tencent.state.service.ResultCallback;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/common/push/IVasPushService;", "", "getRegisterKey", "Lcom/tencent/state/common/push/RegisterKey;", "pullMessage", "", "roomId", "", "offset", "", "callback", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/common/push/PullMsgResponse;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IVasPushService {
    RegisterKey getRegisterKey();

    void pullMessage(long roomId, byte[] offset, ResultCallback<PullMsgResponse> callback);
}

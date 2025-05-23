package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/aa;", "", "", "server", "method", "requestJson", "Lcom/tencent/mobileqq/zootopia/ipc/ah;", "callback", "", "sendJsonRequest", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ZootopiaNetRemoteManagerImpl.class)
/* loaded from: classes35.dex */
public interface aa {
    void sendJsonRequest(String server, String method, String requestJson, ah callback);
}

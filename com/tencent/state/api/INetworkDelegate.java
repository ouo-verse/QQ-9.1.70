package com.tencent.state.api;

import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\fH&JD\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/api/INetworkDelegate;", "", "sendVasProxyRequest", "", "service", "", "method", "reqData", "", "extData", "", "callBack", "Lcom/tencent/state/api/INetworkDelegateCallBack;", "source", "", "callback", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface INetworkDelegate {
    void sendVasProxyRequest(String service, String method, byte[] reqData, Map<String, String> extData, int source, INetworkDelegateCallBack callback);

    void sendVasProxyRequest(String service, String method, byte[] reqData, Map<String, String> extData, INetworkDelegateCallBack callBack);
}

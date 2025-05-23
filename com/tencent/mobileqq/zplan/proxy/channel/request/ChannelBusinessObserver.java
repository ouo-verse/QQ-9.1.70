package com.tencent.mobileqq.zplan.proxy.channel.request;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/channel/request/ChannelBusinessObserver;", "", "onResponse", "", "ssoResultCode", "", "trpcRspFuncRetCode", "trpcRspErrorMsg", "", "rspData", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public interface ChannelBusinessObserver {
    void onResponse(int ssoResultCode, int trpcRspFuncRetCode, String trpcRspErrorMsg, Object rspData);
}

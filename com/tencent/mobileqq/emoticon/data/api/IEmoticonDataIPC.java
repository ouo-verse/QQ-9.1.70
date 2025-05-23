package com.tencent.mobileqq.emoticon.data.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/api/IEmoticonDataIPC;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getIPCModule", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getModuleName", "", "qqemoticondata-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IEmoticonDataIPC extends QRouteApi {
    @NotNull
    QIPCModule getIPCModule();

    @NotNull
    String getModuleName();
}

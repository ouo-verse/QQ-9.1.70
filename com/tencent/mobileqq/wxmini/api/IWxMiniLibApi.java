package com.tencent.mobileqq.wxmini.api;

import com.tencent.luggage.wxaapi.WxaExtendApiJSBridge;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWxMiniLibApi extends QRouteApi {
    public static final String WX_MINI_IPC_MODULE_NAME = "WxMiniIPCModule";

    WxaExtendApiJSBridge.b getHandler();

    QIPCModule getWxQIPCModule();
}

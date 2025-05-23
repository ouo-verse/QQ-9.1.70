package com.tencent.qqnt.emotion.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface INTEmoticonPanelIpcService extends QRouteApi {
    public static final String NT_EMOTICON_MAINPANEL_IPC_NAME = "nt_module_emoticon_mainpanel";

    QIPCModule onCreateModule(String str);
}

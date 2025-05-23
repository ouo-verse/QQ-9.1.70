package com.tencent.mobileqq.qqlive.api.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import eipc.EIPCResult;
import org.jetbrains.annotations.Nullable;

@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQLiveIPCServerApi extends QRouteApi {
    public static final String MODULE_NAME_LIVE = "QQLiveServerQIPCModule";

    @Nullable
    EIPCResult callSync(@Nullable String str, @Nullable Bundle bundle);

    QIPCModule getQQLiveServerIPCModule();
}

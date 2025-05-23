package com.tencent.mobileqq.matchfriend.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {""})
/* loaded from: classes15.dex */
public interface IMatchFriendIPCServer extends QRouteApi {
    QIPCModule getFlutterIpcModule();

    QIPCModule getVoiceChatIpcModule();
}

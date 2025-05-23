package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildIPCService extends QRouteApi {
    public static final String ACTION_GET_MEMBERINFO_BY_OPENID = "action_get_memberinfo_by_openid";
    public static final String GUILD_NAME_IPC_NAME = "module_ipc_server_guild";

    QIPCModule onCreateModule(String str);
}

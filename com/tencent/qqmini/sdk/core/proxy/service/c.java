package com.tencent.qqmini.sdk.core.proxy.service;

import android.content.Context;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.GuildProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
@ProxyService(proxy = GuildProxy.class)
/* loaded from: classes23.dex */
public class c implements GuildProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.GuildProxy
    public void jumpToJoinGuild(String str, String str2, AsyncResult asyncResult, Context context) {
        QMLog.d("GuildProxyDefault", "jumpToJoinGuild should run at QQ");
    }
}

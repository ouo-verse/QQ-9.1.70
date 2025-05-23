package com.tencent.mobileqq.guild.message.api;

import com.tencent.imcore.message.MsgPool;
import com.tencent.mobileqq.guild.message.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes14.dex */
public interface IGuildMessageManagerApi extends QRouteApi {
    b newGuildMessageManager(AppRuntime appRuntime, MsgPool msgPool);
}

package com.tencent.mobileqq.guild.nt.misc.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IAppBadgeApi extends QRouteApi {
    void refreshAppBadge(AppRuntime appRuntime);
}

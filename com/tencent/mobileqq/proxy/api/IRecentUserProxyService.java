package com.tencent.mobileqq.proxy.api;

import com.tencent.mobileqq.app.proxy.IRecentForwardUserProxy;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process = {""})
/* loaded from: classes16.dex */
public interface IRecentUserProxyService extends IRuntimeService {
    IRecentForwardUserProxy getRecentForwardCache();

    RecentUserProxy getRecentUserCache();
}

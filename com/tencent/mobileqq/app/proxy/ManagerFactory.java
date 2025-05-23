package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.app.asyncdb.BaseCacheManager;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface ManagerFactory {
    BaseCacheManager getCacheManager(AppRuntime appRuntime);

    BaseProxyManager getProxyManager(AppRuntime appRuntime);
}

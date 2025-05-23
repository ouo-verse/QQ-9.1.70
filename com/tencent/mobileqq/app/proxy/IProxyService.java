package com.tencent.mobileqq.app.proxy;

import android.util.SparseArray;
import mqq.app.AppRuntime;

/* loaded from: classes11.dex */
public interface IProxyService {
    SparseArray<BaseProxy> getBusinessProxy(AppRuntime appRuntime, BaseProxyManager baseProxyManager);

    boolean getSQLiteSwitchBySample();

    boolean isMessageRecord(Object obj);

    boolean isSQLiteReportVersion();
}

package com.tencent.mobileqq.vas.updatesystem.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasBusinessManager extends QRouteApi {
    List<IBusinessCallback> getAllBusiness();

    <T extends QQVasUpdateBusiness> T getBusinessInstance(Class<T> cls);

    <T extends QQVasUpdateBusiness> T getBusinessInstance(Long l3);

    List<String> getCustomCleanFiles();

    long refreshCustomCleanFiles(boolean z16);
}

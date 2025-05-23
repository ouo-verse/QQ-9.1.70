package com.tencent.mobileqq.vas.updatesystem.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemVersionCallback;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes20.dex */
public interface IVasEngine extends IRuntimeService {
    void cancelDwonloadItem(long j3, String str);

    void downloadGatherItem(long j3, String str, String[] strArr, String str2);

    void downloadItem(long j3, String str, String str2);

    <T extends IBusinessCallback> T getBusinessCallback(Class<T> cls);

    void queryItemVersion(int i3, String str, boolean z16, QueryItemVersionCallback queryItemVersionCallback);

    void startUpdateAllItem();
}

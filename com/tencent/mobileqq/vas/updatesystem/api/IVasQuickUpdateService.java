package com.tencent.mobileqq.vas.updatesystem.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {""})
/* loaded from: classes20.dex */
public interface IVasQuickUpdateService extends IRuntimeService {
    void addCallBacker(CallBacker callBacker);

    void addWeakCallback(CallBacker callBacker);

    void callBackToAll(long j3, String str, String str2, String str3, int i3, int i16);

    void cancelDwonloadItem(long j3, String str);

    void cleanCache();

    void downloadGatherItem(long j3, String str, String[] strArr, String str2);

    void downloadItem(long j3, String str, String str2);

    <T extends IBusinessCallback> T getBusinessCallback(Class<T> cls);

    void onProgressToAll(long j3, String str, String str2, long j16, long j17);

    void queryItemVersion(int i3, String str, boolean z16, boolean z17, long j3, QueryItemCallback queryItemCallback);

    void removeCallBacker(CallBacker callBacker);
}

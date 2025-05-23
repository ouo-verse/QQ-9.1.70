package com.tencent.mobileqq.gamecenter.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin = false, process = {"all"})
/* loaded from: classes12.dex */
public interface ISearchPopService extends IRuntimeService {
    int getRequestPopConfigVersion();

    he1.a getSearchPopAnimationData(String str);

    void handlePreloadConfig(int i3, Object obj);

    void onEnterSearch();

    void onExitSearch();

    void onRequestPopConfigFinished(boolean z16);

    void requestPreloadConfig(boolean z16);
}

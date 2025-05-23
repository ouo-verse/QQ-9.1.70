package com.tencent.mobileqq.webview.api;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.webview.util.u;
import mqq.app.api.IRuntimeService;

@Service(process = {"all"})
/* loaded from: classes20.dex */
public interface IWebProcessManagerService extends IRuntimeService {
    boolean enablePreloadInBusiness(int i3);

    boolean isNeedPreloadWebProcess();

    void startWebProcess(int i3, @Nullable u uVar);

    boolean startWebProcessUnderStrategy(int i3, @Nullable u uVar);

    void updatePreloadWebProcessFlag();
}

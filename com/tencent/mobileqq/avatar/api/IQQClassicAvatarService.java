package com.tencent.mobileqq.avatar.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes11.dex */
public interface IQQClassicAvatarService extends IRuntimeService {
    void handleGetHeadError(String str);

    boolean isClassicHeadActivityActivate();
}

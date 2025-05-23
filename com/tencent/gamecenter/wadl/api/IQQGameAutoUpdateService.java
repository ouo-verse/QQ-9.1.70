package com.tencent.gamecenter.wadl.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes6.dex */
public interface IQQGameAutoUpdateService extends IRuntimeService {
    void pullAutoUpdateTask(boolean z16);
}

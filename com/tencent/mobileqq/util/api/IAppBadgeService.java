package com.tencent.mobileqq.util.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes20.dex */
public interface IAppBadgeService extends IRuntimeService {
    int getAppBadgeCount(int i3);

    void refreshAppBadge();

    void refreshAppBadge(int i3);
}

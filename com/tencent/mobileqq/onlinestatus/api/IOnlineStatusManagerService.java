package com.tencent.mobileqq.onlinestatus.api;

import com.tencent.mobileqq.onlinestatus.manager.j;
import com.tencent.mobileqq.qroute.annotation.Service;
import ec2.d;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {""})
/* loaded from: classes16.dex */
public interface IOnlineStatusManagerService extends IRuntimeService {
    void addConfigUpdateListener(d dVar);

    <T extends j> T getManager(Class<T> cls);

    void removeConfigUpdateListener(d dVar);
}

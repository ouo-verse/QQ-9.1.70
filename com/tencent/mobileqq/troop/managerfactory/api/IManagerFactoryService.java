package com.tencent.mobileqq.troop.managerfactory.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface IManagerFactoryService extends IRuntimeService {
    <T extends Manager> T getManager(Class<T> cls);
}

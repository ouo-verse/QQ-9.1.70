package com.tencent.mobileqq.troop.fans.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.fans.data.a;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopFansService extends IRuntimeService {
    a.C8682a getTroopIdolInfoDate(String str);

    void setTroopIdolInfoDate(String str, a.C8682a c8682a);
}

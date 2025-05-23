package com.tencent.hippykotlin.demo.pages.nearby.base;

import c45.e;
import com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import m25.c;

/* loaded from: classes31.dex */
public abstract class NearbyBasePbRequest<Req extends e, Rsp extends e> extends BasePbRequest<Req, Rsp> {
    public final c getCommonExtInfo() {
        return UserDataManager.INSTANCE.getCommonExtInfo();
    }
}

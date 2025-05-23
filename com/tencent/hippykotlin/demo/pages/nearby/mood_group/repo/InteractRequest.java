package com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo;

import c45.e;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import k35.h;
import k35.i;
import m25.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class InteractRequest extends NearbyBasePbRequest<h, i> {
    public final long actId;
    public final int mid;
    public final long tid;

    public InteractRequest(long j3, int i3, long j16) {
        this.tid = j3;
        this.mid = i3;
        this.actId = j16;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        return (i) c45.i.b(new i(), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.mood_svr.MoodSvr.SsoInteract";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        c commonExtInfo = userDataManager.getCommonExtInfo();
        long j3 = this.tid;
        int i3 = this.mid;
        long j16 = this.actId;
        userDataManager.getUserSelfInfo();
        return new h(commonExtInfo, j3, i3, j16, NearbyProUtilsKt.getCoord());
    }
}

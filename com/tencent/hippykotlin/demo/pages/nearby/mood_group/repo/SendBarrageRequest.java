package com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import k35.o;
import k35.p;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SendBarrageRequest extends NearbyBasePbRequest<o, p> {
    public final long barrageId;
    public final int mid;

    public SendBarrageRequest(int i3, long j3) {
        this.mid = i3;
        this.barrageId = j3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        return (p) i.b(new p(), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.mood_svr.MoodSvr.SsoSendBarrage";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return new o(UserDataManager.INSTANCE.getCommonExtInfo(), this.barrageId, this.mid);
    }
}

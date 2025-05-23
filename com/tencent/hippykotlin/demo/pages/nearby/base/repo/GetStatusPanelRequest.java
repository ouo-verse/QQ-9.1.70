package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import e35.d;
import e35.e;

/* loaded from: classes31.dex */
public final class GetStatusPanelRequest extends NearbyBasePbRequest<d, e> {
    public final int gender;
    public final int status = 0;
    public final int richStatus = 0;

    public GetStatusPanelRequest(int i3) {
        this.gender = i3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e decodeResponse(byte[] bArr) {
        return (e) i.b(new e(null, null, null, null, 15, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.status_panel_svr.StatusPanelSvr.SsoGetStatusPanel";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e getRequest() {
        return new d(UserDataManager.INSTANCE.getCommonExtInfo(), this.gender != 1 ? 2 : 1, this.status, this.richStatus);
    }
}

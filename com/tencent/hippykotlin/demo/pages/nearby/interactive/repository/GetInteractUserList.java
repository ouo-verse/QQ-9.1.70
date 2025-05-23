package com.tencent.hippykotlin.demo.pages.nearby.interactive.repository;

import c45.a;
import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import k35.f;
import k35.g;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetInteractUserList extends NearbyBasePbRequest<f, g> {
    public final a cookies;
    public final int count;
    public final int mid;

    public GetInteractUserList(int i3, int i16, a aVar) {
        this.mid = i3;
        this.count = i16;
        this.cookies = aVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        return (g) i.b(new g(null, false, null, 7, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.mood_svr.MoodSvr.SsoGetInteractUserList";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return new f(UserDataManager.INSTANCE.getCommonExtInfo(), this.mid, this.count, this.cookies);
    }
}

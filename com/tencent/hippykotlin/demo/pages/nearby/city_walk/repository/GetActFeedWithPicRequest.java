package com.tencent.hippykotlin.demo.pages.nearby.city_walk.repository;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import s25.a;
import s25.b;

/* loaded from: classes31.dex */
public final class GetActFeedWithPicRequest extends NearbyBasePbRequest<a, b> {
    public final int count = 10;
    public final int source;
    public final String times;

    public GetActFeedWithPicRequest(String str, int i3) {
        this.times = str;
        this.source = i3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        return (b) i.b(new b(null, null, null, 0, 15, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.feed_svr.StatusRead.SsoGetActFeedWithPic";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return new a(UserDataManager.INSTANCE.getCommonExtInfo(), this.source, this.count, this.times);
    }
}

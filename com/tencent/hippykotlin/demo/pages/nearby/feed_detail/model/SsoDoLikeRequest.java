package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.model;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import u25.a;
import u25.b;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SsoDoLikeRequest extends NearbyBasePbRequest<a, b> {
    public final int operType;
    public final String posterTid;
    public final String statusFeedId;

    public SsoDoLikeRequest(int i3, String str, String str2) {
        this.operType = i3;
        this.statusFeedId = str;
        this.posterTid = str2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        return (b) i.b(new b(null, null, 3, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.like_svr.Like.SsoDoLike";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return new a(this.operType, this.statusFeedId, this.posterTid, UserDataManager.INSTANCE.getCommonExtInfo(), 16);
    }
}

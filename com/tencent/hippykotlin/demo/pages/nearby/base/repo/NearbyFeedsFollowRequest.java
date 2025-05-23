package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.a;
import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import java.util.List;
import m25.c;
import p35.aa;
import p35.ab;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyFeedsFollowRequest extends NearbyBasePbRequest<aa, ab> {
    public final String anchorId;
    public final a cookie;
    public final int count = 15;
    public final String userId;

    public NearbyFeedsFollowRequest(String str, a aVar, String str2) {
        this.userId = str;
        this.cookie = aVar;
        this.anchorId = str2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        return (ab) i.b(new ab((List) null, false, (a) null, 0, (c) null, 0, (String) null, 255), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.feed_svr.StatusRead.SsoGetUserFollowList";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return new aa(this.userId, StrangerFeedRepoKt.getAccountType(2), this.count, this.cookie, this.anchorId, UserDataManager.INSTANCE.getCommonExtInfo(), null, 64);
    }
}

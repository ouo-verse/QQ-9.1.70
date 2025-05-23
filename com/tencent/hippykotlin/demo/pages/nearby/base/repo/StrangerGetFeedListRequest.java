package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.a;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import java.util.List;
import m25.c;
import p35.aa;
import p35.ab;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class StrangerGetFeedListRequest implements IBizRequestByProxy<aa, ab> {
    public final String anchorId;
    public final int appId;
    public final a cookie;
    public final String userId;

    public StrangerGetFeedListRequest(int i3, String str, a aVar, String str2) {
        this.appId = i3;
        this.userId = str;
        this.cookie = aVar;
        this.anchorId = str2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final ab decodeResponse(byte[] bArr) {
        try {
            return (ab) i.b(new ab((List) null, false, (a) null, 0, (c) null, 0, (String) null, 255), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("StrangerGetFeedListRequest", "GetUserFeedListRsp decode error: " + th5);
            return new ab((List) null, false, (a) null, 0, (c) null, 0, (String) null, 255);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getMethod() {
        return "SsoGetFeedList";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final aa getRequest() {
        return new aa(this.userId, StrangerFeedRepoKt.getAccountType(this.appId), 10, this.cookie, this.anchorId, UserDataManager.INSTANCE.getCommonExtInfo(), null, 64);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getService() {
        return "QQStranger.FeedSvr";
    }
}

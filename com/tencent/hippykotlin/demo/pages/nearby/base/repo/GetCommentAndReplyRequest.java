package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import p35.q;
import p35.r;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetCommentAndReplyRequest implements IBizRequestByProxy<q, r> {
    public final int appId;
    public final String attachInfo;
    public final int count = 10;
    public final String feedId;
    public final String userId;

    public GetCommentAndReplyRequest(int i3, String str, String str2, String str3) {
        this.appId = i3;
        this.userId = str;
        this.feedId = str2;
        this.attachInfo = str3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getMethod() {
        return "GetCommentAndReply";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final q getRequest() {
        return new q(this.userId, StrangerFeedRepoKt.getAccountType(this.appId), this.feedId, this.count, this.attachInfo, UserDataManager.INSTANCE.getCommonExtInfo(), 40);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getService() {
        return "QQStranger.FeedSvr";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final r decodeResponse(byte[] bArr) {
        try {
            return (r) i.b(new r(null, null, 3, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("GetCommentAndReplyRequest", "GetCommentAndReplyRsp decode error: " + th5);
            return new r(null, null, 3, null);
        }
    }
}

package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.i;
import com.tencent.kuikly.core.log.KLog;
import p35.o;
import p35.p;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetCommentAndReplyByIdRequest implements IBizRequestByProxy<o, p> {
    public final int appId;
    public final String commentId;
    public final String feedId;

    public GetCommentAndReplyByIdRequest(int i3, String str, String str2) {
        this.appId = i3;
        this.feedId = str;
        this.commentId = str2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getMethod() {
        return "GetCommentAndReplyById";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final o getRequest() {
        return new o(this.feedId, this.commentId);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getService() {
        return "QQStranger.FeedSvr";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final p decodeResponse(byte[] bArr) {
        try {
            return (p) i.b(new p(0, null, 3, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("GetCommentAndReplyByIdRequest", "GetCommentAndReplyByIdRsp decode error: " + th5);
            return new p(0, null, 3, null);
        }
    }
}

package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import p35.e;
import p35.f;
import p35.i;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CommentAndReplyRequest implements IBizRequestByProxy<e, f> {
    public final int appId;
    public final String commentId;
    public final i content;
    public final String feedId;
    public final boolean isQuickComment;
    public final String method;
    public final String replyId;
    public final int source;
    public final String targetTid;

    public CommentAndReplyRequest(int i3, String str, String str2, i iVar, boolean z16, String str3, String str4, String str5, int i16) {
        this.appId = i3;
        this.method = str;
        this.feedId = str2;
        this.content = iVar;
        this.isQuickComment = z16;
        this.commentId = str3;
        this.replyId = str4;
        this.targetTid = str5;
        this.source = i16;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final f decodeResponse(byte[] bArr) {
        try {
            return (f) c45.i.b(new f(0, null, null, null, 15, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("CommentAndReplyRequest", "CommentAndReplyRsp decode error: " + th5);
            return new f(0, null, null, null, 15, null);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getMethod() {
        return this.method;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final e getRequest() {
        return new e(this.feedId, this.commentId, this.replyId, this.content, true, this.targetTid, UserDataManager.INSTANCE.getCommonExtInfo(), this.isQuickComment, this.source);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getService() {
        return "QQStranger.FeedSvr";
    }

    public /* synthetic */ CommentAndReplyRequest(int i3, String str, String str2, i iVar, boolean z16, String str3, String str4, String str5, int i16, int i17) {
        this(i3, str, str2, (i17 & 8) != 0 ? new i(null, 1, null) : iVar, (i17 & 16) != 0 ? false : z16, (i17 & 32) != 0 ? "" : str3, (i17 & 64) != 0 ? "" : str4, (i17 & 128) != 0 ? "" : str5, (i17 & 256) != 0 ? 0 : i16);
    }
}

package com.qzone.reborn.albumx.common.bean;

import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0003\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/g;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "id", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "c", "()Lcom/qzone/proxy/feedcomponent/model/Reply;", "f", "(Lcom/qzone/proxy/feedcomponent/model/Reply;)V", "stReply", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "()Lcom/qzone/proxy/feedcomponent/model/Comment;", "d", "(Lcom/qzone/proxy/feedcomponent/model/Comment;)V", "hostComment", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Reply stReply;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Comment hostComment;

    /* renamed from: a, reason: from getter */
    public final Comment getHostComment() {
        return this.hostComment;
    }

    /* renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final Reply getStReply() {
        return this.stReply;
    }

    public final void d(Comment comment) {
        this.hostComment = comment;
    }

    public final void e(String str) {
        this.id = str;
    }

    public final void f(Reply reply) {
        this.stReply = reply;
    }
}

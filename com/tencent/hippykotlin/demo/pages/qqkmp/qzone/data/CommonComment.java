package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR \u0010%\u001a\b\u0012\u0004\u0012\u00020&0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR\u001c\u0010)\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001a\u0010,\u001a\u00020-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R \u00102\u001a\b\u0012\u0004\u0012\u0002030!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\r\"\u0004\b5\u0010\u000fR\u001a\u00106\u001a\u00020-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010/\"\u0004\b8\u00101R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>\u00a8\u0006?"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "", "()V", "clientKey", "", "getClientKey", "()Ljava/lang/String;", "setClientKey", "(Ljava/lang/String;)V", "content", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRichMsg;", "getContent", "()Ljava/util/List;", "setContent", "(Ljava/util/List;)V", "hasMoreReply", "", "getHasMoreReply", "()Ljava/lang/Boolean;", "setHasMoreReply", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "id", "getId", "setId", "like", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLike;", "getLike", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLike;", "setLike", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLike;)V", "mapExt", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonEntry;", "getMapExt", "setMapExt", "mediaItems", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "getMediaItems", "setMediaItems", "replyAttachInfo", "getReplyAttachInfo", "setReplyAttachInfo", "replyNum", "", "getReplyNum", "()J", "setReplyNum", "(J)V", "replys", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "getReplys", "setReplys", "time", "getTime", "setTime", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "getUser", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "setUser", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonComment {
    public static final int $stable = 8;
    private String clientKey;
    private List<CommonRichMsg> content;
    private Boolean hasMoreReply;
    private String id;
    private CommonLike like;
    private List<CommonEntry> mapExt;
    private List<CommonMedia> mediaItems;
    private String replyAttachInfo;
    private long replyNum;
    private List<CommonReply> replys;
    private long time;
    private CommonUser user;

    public CommonComment() {
        List<CommonRichMsg> emptyList;
        List<CommonMedia> emptyList2;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.content = emptyList;
        this.replys = new ArrayList();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.mediaItems = emptyList2;
        this.mapExt = new ArrayList();
    }

    public final String getClientKey() {
        return this.clientKey;
    }

    public final List<CommonRichMsg> getContent() {
        return this.content;
    }

    public final Boolean getHasMoreReply() {
        return this.hasMoreReply;
    }

    public final String getId() {
        return this.id;
    }

    public final CommonLike getLike() {
        return this.like;
    }

    public final List<CommonEntry> getMapExt() {
        return this.mapExt;
    }

    public final List<CommonMedia> getMediaItems() {
        return this.mediaItems;
    }

    public final String getReplyAttachInfo() {
        return this.replyAttachInfo;
    }

    public final long getReplyNum() {
        return this.replyNum;
    }

    public final List<CommonReply> getReplys() {
        return this.replys;
    }

    public final long getTime() {
        return this.time;
    }

    public final CommonUser getUser() {
        return this.user;
    }

    public final void setClientKey(String str) {
        this.clientKey = str;
    }

    public final void setContent(List<CommonRichMsg> list) {
        this.content = list;
    }

    public final void setHasMoreReply(Boolean bool) {
        this.hasMoreReply = bool;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setLike(CommonLike commonLike) {
        this.like = commonLike;
    }

    public final void setMapExt(List<CommonEntry> list) {
        this.mapExt = list;
    }

    public final void setMediaItems(List<CommonMedia> list) {
        this.mediaItems = list;
    }

    public final void setReplyAttachInfo(String str) {
        this.replyAttachInfo = str;
    }

    public final void setReplyNum(long j3) {
        this.replyNum = j3;
    }

    public final void setReplys(List<CommonReply> list) {
        this.replys = list;
    }

    public final void setTime(long j3) {
        this.time = j3;
    }

    public final void setUser(CommonUser commonUser) {
        this.user = commonUser;
    }
}

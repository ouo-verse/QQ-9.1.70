package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#\u00a8\u0006-"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "", "()V", "clientKey", "", "getClientKey", "()Ljava/lang/String;", "setClientKey", "(Ljava/lang/String;)V", "content", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRichMsg;", "getContent", "()Ljava/util/List;", "setContent", "(Ljava/util/List;)V", "id", "getId", "setId", "like", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLike;", "getLike", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLike;", "setLike", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLike;)V", "mapExt", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonEntry;", "getMapExt", "setMapExt", "targetUser", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "getTargetUser", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "setTargetUser", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;)V", "time", "", "getTime", "()J", "setTime", "(J)V", QCircleAlphaUserReporter.KEY_USER, "getUser", "setUser", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonReply {
    public static final int $stable = 8;
    private String clientKey;
    private List<CommonRichMsg> content;
    private String id;
    private CommonLike like;
    private List<CommonEntry> mapExt;
    private CommonUser targetUser;
    private long time;
    private CommonUser user;

    public CommonReply() {
        List<CommonRichMsg> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.content = emptyList;
        this.mapExt = new ArrayList();
    }

    public final String getClientKey() {
        return this.clientKey;
    }

    public final List<CommonRichMsg> getContent() {
        return this.content;
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

    public final CommonUser getTargetUser() {
        return this.targetUser;
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

    public final void setId(String str) {
        this.id = str;
    }

    public final void setLike(CommonLike commonLike) {
        this.like = commonLike;
    }

    public final void setMapExt(List<CommonEntry> list) {
        this.mapExt = list;
    }

    public final void setTargetUser(CommonUser commonUser) {
        this.targetUser = commonUser;
    }

    public final void setTime(long j3) {
        this.time = j3;
    }

    public final void setUser(CommonUser commonUser) {
        this.user = commonUser;
    }
}

package com.tencent.biz.qqcircle.events;

import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/events/QFSPushRanCommentUpdateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", WSAutoShowCommentParams.KEY_COMMENT_ID, "", "type", "", "isPushRan", "", "(Ljava/lang/String;IZ)V", "getCommentId", "()Ljava/lang/String;", "()Z", "getType", "()I", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSPushRanCommentUpdateEvent extends SimpleBaseEvent {

    @NotNull
    private final String commentId;
    private final boolean isPushRan;
    private final int type;

    public QFSPushRanCommentUpdateEvent(@NotNull String commentId, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        this.commentId = commentId;
        this.type = i3;
        this.isPushRan = z16;
    }

    @NotNull
    public final String getCommentId() {
        return this.commentId;
    }

    public final int getType() {
        return this.type;
    }

    /* renamed from: isPushRan, reason: from getter */
    public final boolean getIsPushRan() {
        return this.isPushRan;
    }
}

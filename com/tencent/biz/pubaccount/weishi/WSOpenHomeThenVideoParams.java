package com.tencent.biz.pubaccount.weishi;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/WSOpenHomeThenVideoParams;", "Ljava/io/Serializable;", "feedId", "", "feedJson", "autoShowCommentParams", "Lcom/tencent/biz/pubaccount/weishi/WSAutoShowCommentParams;", "playScene", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/weishi/WSAutoShowCommentParams;Ljava/lang/String;)V", "getAutoShowCommentParams", "()Lcom/tencent/biz/pubaccount/weishi/WSAutoShowCommentParams;", "getFeedId", "()Ljava/lang/String;", "getFeedJson", "getPlayScene", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public final class WSOpenHomeThenVideoParams implements Serializable {
    private final WSAutoShowCommentParams autoShowCommentParams;
    private final String feedId;
    private final String feedJson;
    private final String playScene;

    public WSOpenHomeThenVideoParams(String str, String str2, WSAutoShowCommentParams autoShowCommentParams, String playScene) {
        Intrinsics.checkNotNullParameter(autoShowCommentParams, "autoShowCommentParams");
        Intrinsics.checkNotNullParameter(playScene, "playScene");
        this.feedId = str;
        this.feedJson = str2;
        this.autoShowCommentParams = autoShowCommentParams;
        this.playScene = playScene;
    }

    public final WSAutoShowCommentParams getAutoShowCommentParams() {
        return this.autoShowCommentParams;
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final String getFeedJson() {
        return this.feedJson;
    }

    public final String getPlayScene() {
        return this.playScene;
    }
}

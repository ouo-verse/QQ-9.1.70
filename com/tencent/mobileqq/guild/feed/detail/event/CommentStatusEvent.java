package com.tencent.mobileqq.guild.feed.detail.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\fR\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/detail/event/CommentStatusEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "result", "", "feedId", "status", "", "fromList", "", "retCode", "", "errMsg", "(Ljava/lang/String;Ljava/lang/String;IZJLjava/lang/String;)V", "getErrMsg", "()Ljava/lang/String;", "getFeedId", "getFromList", "()Z", "getResult", "getRetCode", "()J", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()I", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class CommentStatusEvent extends SimpleBaseEvent {

    @NotNull
    private final String errMsg;

    @NotNull
    private final String feedId;
    private final boolean fromList;

    @NotNull
    private final String result;
    private final long retCode;
    private final int status;

    public /* synthetic */ CommentStatusEvent(String str, String str2, int i3, boolean z16, long j3, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i3, z16, (i16 & 16) != 0 ? 0L : j3, (i16 & 32) != 0 ? "" : str3);
    }

    @NotNull
    public final String getErrMsg() {
        return this.errMsg;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    public final boolean getFromList() {
        return this.fromList;
    }

    @NotNull
    public final String getResult() {
        return this.result;
    }

    public final long getRetCode() {
        return this.retCode;
    }

    public final int getStatus() {
        return this.status;
    }

    public CommentStatusEvent(@NotNull String result, @NotNull String feedId, int i3, boolean z16, long j3, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.result = result;
        this.feedId = feedId;
        this.status = i3;
        this.fromList = z16;
        this.retCode = j3;
        this.errMsg = errMsg;
    }
}

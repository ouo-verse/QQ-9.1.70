package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/event/PostFeedFailedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "mainTaskId", "", "isEdition", "", "errorCode", "", "errorMessage", "(Ljava/lang/String;ZILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "()Z", "getMainTaskId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class PostFeedFailedEvent extends SimpleBaseEvent {
    private final int errorCode;

    @NotNull
    private final String errorMessage;
    private final boolean isEdition;

    @NotNull
    private final String mainTaskId;

    public PostFeedFailedEvent(@NotNull String mainTaskId, boolean z16, int i3, @NotNull String errorMessage) {
        Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        this.mainTaskId = mainTaskId;
        this.isEdition = z16;
        this.errorCode = i3;
        this.errorMessage = errorMessage;
    }

    public static /* synthetic */ PostFeedFailedEvent copy$default(PostFeedFailedEvent postFeedFailedEvent, String str, boolean z16, int i3, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = postFeedFailedEvent.mainTaskId;
        }
        if ((i16 & 2) != 0) {
            z16 = postFeedFailedEvent.isEdition;
        }
        if ((i16 & 4) != 0) {
            i3 = postFeedFailedEvent.errorCode;
        }
        if ((i16 & 8) != 0) {
            str2 = postFeedFailedEvent.errorMessage;
        }
        return postFeedFailedEvent.copy(str, z16, i3, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getMainTaskId() {
        return this.mainTaskId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsEdition() {
        return this.isEdition;
    }

    /* renamed from: component3, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @NotNull
    public final PostFeedFailedEvent copy(@NotNull String mainTaskId, boolean isEdition, int errorCode, @NotNull String errorMessage) {
        Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        return new PostFeedFailedEvent(mainTaskId, isEdition, errorCode, errorMessage);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostFeedFailedEvent)) {
            return false;
        }
        PostFeedFailedEvent postFeedFailedEvent = (PostFeedFailedEvent) other;
        if (Intrinsics.areEqual(this.mainTaskId, postFeedFailedEvent.mainTaskId) && this.isEdition == postFeedFailedEvent.isEdition && this.errorCode == postFeedFailedEvent.errorCode && Intrinsics.areEqual(this.errorMessage, postFeedFailedEvent.errorMessage)) {
            return true;
        }
        return false;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @NotNull
    public final String getMainTaskId() {
        return this.mainTaskId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.mainTaskId.hashCode() * 31;
        boolean z16 = this.isEdition;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((hashCode + i3) * 31) + this.errorCode) * 31) + this.errorMessage.hashCode();
    }

    public final boolean isEdition() {
        return this.isEdition;
    }

    @NotNull
    public String toString() {
        return "PostFeedFailedEvent(mainTaskId=" + this.mainTaskId + ", isEdition=" + this.isEdition + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ")";
    }
}

package com.tencent.mobileqq.gamecenter.qa.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefChannel;", "Ljava/io/Serializable;", "", "component1", "component2", "inviteCode", "contentId", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getInviteCode", "()Ljava/lang/String;", "getContentId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final /* data */ class GameQALinkRefChannel implements Serializable {
    private static final long serialVersionUID = 1;

    @NotNull
    private final String contentId;

    @NotNull
    private final String inviteCode;

    public GameQALinkRefChannel(@NotNull String inviteCode, @NotNull String contentId) {
        Intrinsics.checkNotNullParameter(inviteCode, "inviteCode");
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        this.inviteCode = inviteCode;
        this.contentId = contentId;
    }

    public static /* synthetic */ GameQALinkRefChannel copy$default(GameQALinkRefChannel gameQALinkRefChannel, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = gameQALinkRefChannel.inviteCode;
        }
        if ((i3 & 2) != 0) {
            str2 = gameQALinkRefChannel.contentId;
        }
        return gameQALinkRefChannel.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getInviteCode() {
        return this.inviteCode;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getContentId() {
        return this.contentId;
    }

    @NotNull
    public final GameQALinkRefChannel copy(@NotNull String inviteCode, @NotNull String contentId) {
        Intrinsics.checkNotNullParameter(inviteCode, "inviteCode");
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        return new GameQALinkRefChannel(inviteCode, contentId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameQALinkRefChannel)) {
            return false;
        }
        GameQALinkRefChannel gameQALinkRefChannel = (GameQALinkRefChannel) other;
        if (Intrinsics.areEqual(this.inviteCode, gameQALinkRefChannel.inviteCode) && Intrinsics.areEqual(this.contentId, gameQALinkRefChannel.contentId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getContentId() {
        return this.contentId;
    }

    @NotNull
    public final String getInviteCode() {
        return this.inviteCode;
    }

    public int hashCode() {
        return (this.inviteCode.hashCode() * 31) + this.contentId.hashCode();
    }

    @NotNull
    public String toString() {
        return "GameQALinkRefChannel(inviteCode=" + this.inviteCode + ", contentId=" + this.contentId + ")";
    }
}

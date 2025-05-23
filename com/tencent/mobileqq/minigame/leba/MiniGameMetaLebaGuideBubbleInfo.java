package com.tencent.mobileqq.minigame.leba;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/minigame/leba/MiniGameMetaLebaGuideBubbleInfo;", "", "content", "", "iconUrl", "duration", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getContent", "()Ljava/lang/String;", "getDuration", "()I", "getIconUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final /* data */ class MiniGameMetaLebaGuideBubbleInfo {

    @NotNull
    private final String content;
    private final int duration;

    @NotNull
    private final String iconUrl;

    public MiniGameMetaLebaGuideBubbleInfo(@NotNull String content, @NotNull String iconUrl, int i3) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        this.content = content;
        this.iconUrl = iconUrl;
        this.duration = i3;
    }

    public static /* synthetic */ MiniGameMetaLebaGuideBubbleInfo copy$default(MiniGameMetaLebaGuideBubbleInfo miniGameMetaLebaGuideBubbleInfo, String str, String str2, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = miniGameMetaLebaGuideBubbleInfo.content;
        }
        if ((i16 & 2) != 0) {
            str2 = miniGameMetaLebaGuideBubbleInfo.iconUrl;
        }
        if ((i16 & 4) != 0) {
            i3 = miniGameMetaLebaGuideBubbleInfo.duration;
        }
        return miniGameMetaLebaGuideBubbleInfo.copy(str, str2, i3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    @NotNull
    public final MiniGameMetaLebaGuideBubbleInfo copy(@NotNull String content, @NotNull String iconUrl, int duration) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        return new MiniGameMetaLebaGuideBubbleInfo(content, iconUrl, duration);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MiniGameMetaLebaGuideBubbleInfo)) {
            return false;
        }
        MiniGameMetaLebaGuideBubbleInfo miniGameMetaLebaGuideBubbleInfo = (MiniGameMetaLebaGuideBubbleInfo) other;
        if (Intrinsics.areEqual(this.content, miniGameMetaLebaGuideBubbleInfo.content) && Intrinsics.areEqual(this.iconUrl, miniGameMetaLebaGuideBubbleInfo.iconUrl) && this.duration == miniGameMetaLebaGuideBubbleInfo.duration) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final int getDuration() {
        return this.duration;
    }

    @NotNull
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public int hashCode() {
        return (((this.content.hashCode() * 31) + this.iconUrl.hashCode()) * 31) + this.duration;
    }

    @NotNull
    public String toString() {
        return "MiniGameMetaLebaGuideBubbleInfo(content=" + this.content + ", iconUrl=" + this.iconUrl + ", duration=" + this.duration + ')';
    }
}

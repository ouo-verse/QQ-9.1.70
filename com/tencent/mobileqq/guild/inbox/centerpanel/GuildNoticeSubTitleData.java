package com.tencent.mobileqq.guild.inbox.centerpanel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0015\u001a\u0004\b\n\u0010\u0016\"\u0004\b\u001a\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/a;", "", "", "e", "", "toString", "", "hashCode", "other", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "subtitleContent", "b", "g", "guildId", "c", "I", "()I", h.F, "(I)V", "startIndex", "f", "endIndex", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.inbox.centerpanel.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildNoticeSubTitleData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String subtitleContent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String guildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int startIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int endIndex;

    public GuildNoticeSubTitleData() {
        this(null, null, 0, 0, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getEndIndex() {
        return this.endIndex;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* renamed from: c, reason: from getter */
    public final int getStartIndex() {
        return this.startIndex;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getSubtitleContent() {
        return this.subtitleContent;
    }

    public final boolean e() {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(this.guildId);
        if (!isBlank) {
            return true;
        }
        if (this.startIndex == 0 && this.endIndex == 0) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildNoticeSubTitleData)) {
            return false;
        }
        GuildNoticeSubTitleData guildNoticeSubTitleData = (GuildNoticeSubTitleData) other;
        if (Intrinsics.areEqual(this.subtitleContent, guildNoticeSubTitleData.subtitleContent) && Intrinsics.areEqual(this.guildId, guildNoticeSubTitleData.guildId) && this.startIndex == guildNoticeSubTitleData.startIndex && this.endIndex == guildNoticeSubTitleData.endIndex) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        this.endIndex = i3;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildId = str;
    }

    public final void h(int i3) {
        this.startIndex = i3;
    }

    public int hashCode() {
        return (((((this.subtitleContent.hashCode() * 31) + this.guildId.hashCode()) * 31) + this.startIndex) * 31) + this.endIndex;
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subtitleContent = str;
    }

    @NotNull
    public String toString() {
        return "GuildNoticeSubTitleData(subtitleContent=" + this.subtitleContent + ", guildId=" + this.guildId + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ")";
    }

    public GuildNoticeSubTitleData(@NotNull String subtitleContent, @NotNull String guildId, int i3, int i16) {
        Intrinsics.checkNotNullParameter(subtitleContent, "subtitleContent");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.subtitleContent = subtitleContent;
        this.guildId = guildId;
        this.startIndex = i3;
        this.endIndex = i16;
    }

    public /* synthetic */ GuildNoticeSubTitleData(String str, String str2, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? "" : str2, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }
}

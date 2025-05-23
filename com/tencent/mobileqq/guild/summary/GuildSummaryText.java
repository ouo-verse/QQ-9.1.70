package com.tencent.mobileqq.guild.summary;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0019\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/summary/GuildSummaryText;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "content", "Lcom/tencent/mobileqq/guild/summary/GuildSummaryText$TextStyle;", "b", "Lcom/tencent/mobileqq/guild/summary/GuildSummaryText$TextStyle;", "()Lcom/tencent/mobileqq/guild/summary/GuildSummaryText$TextStyle;", "style", "<init>", "(Ljava/lang/CharSequence;Lcom/tencent/mobileqq/guild/summary/GuildSummaryText$TextStyle;)V", "TextStyle", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class GuildSummaryText {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final CharSequence content;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final TextStyle style;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/summary/GuildSummaryText$TextStyle;", "", "(Ljava/lang/String;I)V", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, "WEAK_BOLD", "HIGHLIGHT_BOLD", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum TextStyle {
        NORMAL,
        WEAK_BOLD,
        HIGHLIGHT_BOLD
    }

    public GuildSummaryText(@NotNull CharSequence content, @NotNull TextStyle style) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(style, "style");
        this.content = content;
        this.style = style;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final CharSequence getContent() {
        return this.content;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final TextStyle getStyle() {
        return this.style;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildSummaryText)) {
            return false;
        }
        GuildSummaryText guildSummaryText = (GuildSummaryText) other;
        if (Intrinsics.areEqual(this.content, guildSummaryText.content) && this.style == guildSummaryText.style) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.content.hashCode() * 31) + this.style.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildSummaryText(content=" + ((Object) this.content) + ", style=" + this.style + ')';
    }
}

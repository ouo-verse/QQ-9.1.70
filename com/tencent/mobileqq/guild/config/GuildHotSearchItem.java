package com.tencent.mobileqq.guild.config;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\fR\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/config/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getType", "()I", "setType", "(I)V", "type", "b", "Ljava/lang/String;", "()Ljava/lang/String;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/String;)V", "text", "c", "getIcon", "icon", "d", "getLink", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.config.j, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildHotSearchItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String text;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int icon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String link;

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildHotSearchItem)) {
            return false;
        }
        GuildHotSearchItem guildHotSearchItem = (GuildHotSearchItem) other;
        if (this.type == guildHotSearchItem.type && Intrinsics.areEqual(this.text, guildHotSearchItem.text) && this.icon == guildHotSearchItem.icon && Intrinsics.areEqual(this.link, guildHotSearchItem.link)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.type * 31) + this.text.hashCode()) * 31) + this.icon) * 31) + this.link.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildHotSearchItem(type=" + this.type + ", text=" + this.text + ", icon=" + this.icon + ", link=" + this.link + ")";
    }
}

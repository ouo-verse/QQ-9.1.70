package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/n;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "b", "()I", "type", "", "J", "()J", "id", "<init>", "(IJ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.n, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildCategoryChannelTitleHideInEditHolderData extends b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long id;

    public /* synthetic */ GuildCategoryChannelTitleHideInEditHolderData(int i3, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? 0L : j3);
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b
    /* renamed from: a, reason: from getter */
    public long getId() {
        return this.id;
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b
    /* renamed from: b, reason: from getter */
    public int getType() {
        return this.type;
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildCategoryChannelTitleHideInEditHolderData)) {
            return false;
        }
        GuildCategoryChannelTitleHideInEditHolderData guildCategoryChannelTitleHideInEditHolderData = (GuildCategoryChannelTitleHideInEditHolderData) other;
        if (getType() == guildCategoryChannelTitleHideInEditHolderData.getType() && getId() == guildCategoryChannelTitleHideInEditHolderData.getId()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b
    public int hashCode() {
        return (getType() * 31) + androidx.fragment.app.a.a(getId());
    }

    @NotNull
    public String toString() {
        return "GuildCategoryChannelTitleHideInEditHolderData(type=" + getType() + ", id=" + getId() + ")";
    }

    public GuildCategoryChannelTitleHideInEditHolderData(int i3, long j3) {
        this.type = i3;
        this.id = j3;
    }
}

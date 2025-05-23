package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import com.tencent.mobileqq.guild.setting.group.ItemPositionType;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelIdList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\b\u0002\u0010$\u001a\u00020\u001e\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001a\u0010\u0012\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u001d\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001b\u001a\u0004\b\u0013\u0010\u001cR\"\u0010$\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/f;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "()J", "id", "b", "I", "()I", "type", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "defaultSettingTitle", "e", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelIdList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelIdList;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelIdList;", "categoryChannel", "Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;", "f", "Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;", "()Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;", "setPositionType", "(Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;)V", "positionType", "<init>", "(JILjava/lang/String;JLcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelIdList;Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.f, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildCategoryChannelDefaultSettingItemData extends b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String defaultSettingTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long guildId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IGProCategoryChannelIdList categoryChannel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ItemPositionType positionType;

    public /* synthetic */ GuildCategoryChannelDefaultSettingItemData(long j3, int i3, String str, long j16, IGProCategoryChannelIdList iGProCategoryChannelIdList, ItemPositionType itemPositionType, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, (i16 & 2) != 0 ? 4 : i3, str, j16, iGProCategoryChannelIdList, (i16 & 32) != 0 ? ItemPositionType.Single : itemPositionType);
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

    @NotNull
    /* renamed from: c, reason: from getter */
    public final IGProCategoryChannelIdList getCategoryChannel() {
        return this.categoryChannel;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getDefaultSettingTitle() {
        return this.defaultSettingTitle;
    }

    /* renamed from: e, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildCategoryChannelDefaultSettingItemData)) {
            return false;
        }
        GuildCategoryChannelDefaultSettingItemData guildCategoryChannelDefaultSettingItemData = (GuildCategoryChannelDefaultSettingItemData) other;
        if (getId() == guildCategoryChannelDefaultSettingItemData.getId() && getType() == guildCategoryChannelDefaultSettingItemData.getType() && Intrinsics.areEqual(this.defaultSettingTitle, guildCategoryChannelDefaultSettingItemData.defaultSettingTitle) && this.guildId == guildCategoryChannelDefaultSettingItemData.guildId && Intrinsics.areEqual(this.categoryChannel, guildCategoryChannelDefaultSettingItemData.categoryChannel) && this.positionType == guildCategoryChannelDefaultSettingItemData.positionType) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final ItemPositionType getPositionType() {
        return this.positionType;
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b
    public int hashCode() {
        return (((((((((androidx.fragment.app.a.a(getId()) * 31) + getType()) * 31) + this.defaultSettingTitle.hashCode()) * 31) + androidx.fragment.app.a.a(this.guildId)) * 31) + this.categoryChannel.hashCode()) * 31) + this.positionType.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildCategoryChannelDefaultSettingItemData(id=" + getId() + ", type=" + getType() + ", defaultSettingTitle=" + this.defaultSettingTitle + ", guildId=" + this.guildId + ", categoryChannel=" + this.categoryChannel + ", positionType=" + this.positionType + ")";
    }

    public GuildCategoryChannelDefaultSettingItemData(long j3, int i3, @NotNull String defaultSettingTitle, long j16, @NotNull IGProCategoryChannelIdList categoryChannel, @NotNull ItemPositionType positionType) {
        Intrinsics.checkNotNullParameter(defaultSettingTitle, "defaultSettingTitle");
        Intrinsics.checkNotNullParameter(categoryChannel, "categoryChannel");
        Intrinsics.checkNotNullParameter(positionType, "positionType");
        this.id = j3;
        this.type = i3;
        this.defaultSettingTitle = defaultSettingTitle;
        this.guildId = j16;
        this.categoryChannel = categoryChannel;
        this.positionType = positionType;
    }
}

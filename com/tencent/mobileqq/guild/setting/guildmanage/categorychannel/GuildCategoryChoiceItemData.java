package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import com.tencent.mobileqq.guild.setting.group.ItemPositionType;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelIdList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\b\b\u0002\u0010$\u001a\u00020\u001f\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001a\u0010\u0012\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\rR\u0017\u0010\u001a\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001e\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001c\u001a\u0004\b\u0013\u0010\u001dR\"\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\u0016\u0010\"\"\u0004\b \u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/t;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "()J", "id", "b", "I", "()I", "type", "c", "getGuildId", "guildId", "d", "Z", "e", "()Z", "isSelect", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelIdList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelIdList;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelIdList;", "categoryChannel", "Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;", "f", "Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;", "()Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;", "(Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;)V", "positionType", "<init>", "(JIJZLcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelIdList;Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.t, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildCategoryChoiceItemData extends b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long guildId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSelect;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IGProCategoryChannelIdList categoryChannel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ItemPositionType positionType;

    public /* synthetic */ GuildCategoryChoiceItemData(long j3, int i3, long j16, boolean z16, IGProCategoryChannelIdList iGProCategoryChannelIdList, ItemPositionType itemPositionType, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, (i16 & 2) != 0 ? 5 : i3, j16, z16, iGProCategoryChannelIdList, (i16 & 32) != 0 ? ItemPositionType.Middle : itemPositionType);
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
    public final ItemPositionType getPositionType() {
        return this.positionType;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildCategoryChoiceItemData)) {
            return false;
        }
        GuildCategoryChoiceItemData guildCategoryChoiceItemData = (GuildCategoryChoiceItemData) other;
        if (getId() == guildCategoryChoiceItemData.getId() && getType() == guildCategoryChoiceItemData.getType() && this.guildId == guildCategoryChoiceItemData.guildId && this.isSelect == guildCategoryChoiceItemData.isSelect && Intrinsics.areEqual(this.categoryChannel, guildCategoryChoiceItemData.categoryChannel) && this.positionType == guildCategoryChoiceItemData.positionType) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull ItemPositionType itemPositionType) {
        Intrinsics.checkNotNullParameter(itemPositionType, "<set-?>");
        this.positionType = itemPositionType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b
    public int hashCode() {
        int a16 = ((((androidx.fragment.app.a.a(getId()) * 31) + getType()) * 31) + androidx.fragment.app.a.a(this.guildId)) * 31;
        boolean z16 = this.isSelect;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((a16 + i3) * 31) + this.categoryChannel.hashCode()) * 31) + this.positionType.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildCategoryChoiceItemData(id=" + getId() + ", type=" + getType() + ", guildId=" + this.guildId + ", isSelect=" + this.isSelect + ", categoryChannel=" + this.categoryChannel + ", positionType=" + this.positionType + ")";
    }

    public GuildCategoryChoiceItemData(long j3, int i3, long j16, boolean z16, @NotNull IGProCategoryChannelIdList categoryChannel, @NotNull ItemPositionType positionType) {
        Intrinsics.checkNotNullParameter(categoryChannel, "categoryChannel");
        Intrinsics.checkNotNullParameter(positionType, "positionType");
        this.id = j3;
        this.type = i3;
        this.guildId = j16;
        this.isSelect = z16;
        this.categoryChannel = categoryChannel;
        this.positionType = positionType;
    }
}

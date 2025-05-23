package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import com.tencent.mobileqq.guild.setting.group.ItemPositionType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u001b\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/u;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "b", "()I", "type", "", "J", "()J", "id", "c", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "title", "d", "selectedSubCategoryType", "selectSubCategoryName", "Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;", "f", "Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;", "getPositionType", "()Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;", "setPositionType", "(Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;)V", "positionType", "<init>", "(IJLjava/lang/String;ILjava/lang/String;Lcom/tencent/mobileqq/guild/setting/group/ItemPositionType;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.u, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildCategoryChoiceSubItemData extends b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long id;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int selectedSubCategoryType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String selectSubCategoryName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ItemPositionType positionType;

    public /* synthetic */ GuildCategoryChoiceSubItemData(int i3, long j3, String str, int i16, String str2, ItemPositionType itemPositionType, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 6 : i3, j3, str, i16, str2, itemPositionType);
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
    public final String getSelectSubCategoryName() {
        return this.selectSubCategoryName;
    }

    /* renamed from: d, reason: from getter */
    public final int getSelectedSubCategoryType() {
        return this.selectedSubCategoryType;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildCategoryChoiceSubItemData)) {
            return false;
        }
        GuildCategoryChoiceSubItemData guildCategoryChoiceSubItemData = (GuildCategoryChoiceSubItemData) other;
        if (getType() == guildCategoryChoiceSubItemData.getType() && getId() == guildCategoryChoiceSubItemData.getId() && Intrinsics.areEqual(this.title, guildCategoryChoiceSubItemData.title) && this.selectedSubCategoryType == guildCategoryChoiceSubItemData.selectedSubCategoryType && Intrinsics.areEqual(this.selectSubCategoryName, guildCategoryChoiceSubItemData.selectSubCategoryName) && this.positionType == guildCategoryChoiceSubItemData.positionType) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b
    public int hashCode() {
        return (((((((((getType() * 31) + androidx.fragment.app.a.a(getId())) * 31) + this.title.hashCode()) * 31) + this.selectedSubCategoryType) * 31) + this.selectSubCategoryName.hashCode()) * 31) + this.positionType.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildCategoryChoiceSubItemData(type=" + getType() + ", id=" + getId() + ", title=" + this.title + ", selectedSubCategoryType=" + this.selectedSubCategoryType + ", selectSubCategoryName=" + this.selectSubCategoryName + ", positionType=" + this.positionType + ")";
    }

    public GuildCategoryChoiceSubItemData(int i3, long j3, @NotNull String title, int i16, @NotNull String selectSubCategoryName, @NotNull ItemPositionType positionType) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(selectSubCategoryName, "selectSubCategoryName");
        Intrinsics.checkNotNullParameter(positionType, "positionType");
        this.type = i3;
        this.id = j3;
        this.title = title;
        this.selectedSubCategoryType = i16;
        this.selectSubCategoryName = selectSubCategoryName;
        this.positionType = positionType;
    }
}

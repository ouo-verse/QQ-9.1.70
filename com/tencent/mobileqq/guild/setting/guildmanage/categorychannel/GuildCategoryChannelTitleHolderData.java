package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0018\u001a\u0004\b\u0013\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/o;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "b", "()I", "type", "", "J", "()J", "id", "c", "Z", "d", "()Z", "isShowRightBtn", "Ljava/lang/String;", "()Ljava/lang/String;", "rightBtnText", "<init>", "(IJZLjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.o, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildCategoryChannelTitleHolderData extends b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long id;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isShowRightBtn;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String rightBtnText;

    public /* synthetic */ GuildCategoryChannelTitleHolderData(int i3, long j3, boolean z16, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? 0L : j3, z16, str);
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
    public final String getRightBtnText() {
        return this.rightBtnText;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsShowRightBtn() {
        return this.isShowRightBtn;
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildCategoryChannelTitleHolderData)) {
            return false;
        }
        GuildCategoryChannelTitleHolderData guildCategoryChannelTitleHolderData = (GuildCategoryChannelTitleHolderData) other;
        if (getType() == guildCategoryChannelTitleHolderData.getType() && getId() == guildCategoryChannelTitleHolderData.getId() && this.isShowRightBtn == guildCategoryChannelTitleHolderData.isShowRightBtn && Intrinsics.areEqual(this.rightBtnText, guildCategoryChannelTitleHolderData.rightBtnText)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.setting.guildmanage.categorychannel.b
    public int hashCode() {
        int type = ((getType() * 31) + androidx.fragment.app.a.a(getId())) * 31;
        boolean z16 = this.isShowRightBtn;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((type + i3) * 31) + this.rightBtnText.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildCategoryChannelTitleHolderData(type=" + getType() + ", id=" + getId() + ", isShowRightBtn=" + this.isShowRightBtn + ", rightBtnText=" + this.rightBtnText + ")";
    }

    public GuildCategoryChannelTitleHolderData(int i3, long j3, boolean z16, @NotNull String rightBtnText) {
        Intrinsics.checkNotNullParameter(rightBtnText, "rightBtnText");
        this.type = i3;
        this.id = j3;
        this.isShowRightBtn = z16;
        this.rightBtnText = rightBtnText;
    }
}

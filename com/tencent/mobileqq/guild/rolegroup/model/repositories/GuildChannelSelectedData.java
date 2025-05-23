package com.tencent.mobileqq.guild.rolegroup.model.repositories;

import com.gcore.abase.utils.PatternUtils;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\fBA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b \u0010!JG\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\r\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b\u0018\u0010\u001dR\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/d;", "", "", "type", "", "name", "", "isPostSquareCategory", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;", "channelInfo", "isSelectable", "isSelected", "a", "toString", "hashCode", "other", "equals", "I", "e", "()I", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "c", "Z", "f", "()Z", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;", "g", tl.h.F, "<init>", "(ILjava/lang/String;ZLcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;ZZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.rolegroup.model.repositories.d, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildChannelSelectedData {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isPostSquareCategory;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IGProChannel channelInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSelectable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSelected;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/d$a;", "", "", "name", "", "isPostSquareCategory", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/d;", "a", "b", "", "CATEGORY", "I", "CHANNEL", PatternUtils.NO_MATCH, "GROUP", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.model.repositories.d$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GuildChannelSelectedData a(@NotNull String name, boolean isPostSquareCategory) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new GuildChannelSelectedData(2, name, isPostSquareCategory, null, false, false, 56, null);
        }

        @NotNull
        public final GuildChannelSelectedData b(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new GuildChannelSelectedData(4, name, false, null, false, false, 60, null);
        }

        Companion() {
        }
    }

    public GuildChannelSelectedData(int i3, @NotNull String name, boolean z16, @Nullable IGProChannel iGProChannel, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.type = i3;
        this.name = name;
        this.isPostSquareCategory = z16;
        this.channelInfo = iGProChannel;
        this.isSelectable = z17;
        this.isSelected = z18;
    }

    public static /* synthetic */ GuildChannelSelectedData b(GuildChannelSelectedData guildChannelSelectedData, int i3, String str, boolean z16, IGProChannel iGProChannel, boolean z17, boolean z18, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = guildChannelSelectedData.type;
        }
        if ((i16 & 2) != 0) {
            str = guildChannelSelectedData.name;
        }
        String str2 = str;
        if ((i16 & 4) != 0) {
            z16 = guildChannelSelectedData.isPostSquareCategory;
        }
        boolean z19 = z16;
        if ((i16 & 8) != 0) {
            iGProChannel = guildChannelSelectedData.channelInfo;
        }
        IGProChannel iGProChannel2 = iGProChannel;
        if ((i16 & 16) != 0) {
            z17 = guildChannelSelectedData.isSelectable;
        }
        boolean z26 = z17;
        if ((i16 & 32) != 0) {
            z18 = guildChannelSelectedData.isSelected;
        }
        return guildChannelSelectedData.a(i3, str2, z19, iGProChannel2, z26, z18);
    }

    @NotNull
    public final GuildChannelSelectedData a(int type, @NotNull String name, boolean isPostSquareCategory, @Nullable IGProChannel channelInfo, boolean isSelectable, boolean isSelected) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new GuildChannelSelectedData(type, name, isPostSquareCategory, channelInfo, isSelectable, isSelected);
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final IGProChannel getChannelInfo() {
        return this.channelInfo;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: e, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildChannelSelectedData)) {
            return false;
        }
        GuildChannelSelectedData guildChannelSelectedData = (GuildChannelSelectedData) other;
        if (this.type == guildChannelSelectedData.type && Intrinsics.areEqual(this.name, guildChannelSelectedData.name) && this.isPostSquareCategory == guildChannelSelectedData.isPostSquareCategory && Intrinsics.areEqual(this.channelInfo, guildChannelSelectedData.channelInfo) && this.isSelectable == guildChannelSelectedData.isSelectable && this.isSelected == guildChannelSelectedData.isSelected) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsPostSquareCategory() {
        return this.isPostSquareCategory;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsSelectable() {
        return this.isSelectable;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.type * 31) + this.name.hashCode()) * 31;
        boolean z16 = this.isPostSquareCategory;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        IGProChannel iGProChannel = this.channelInfo;
        if (iGProChannel == null) {
            hashCode = 0;
        } else {
            hashCode = iGProChannel.hashCode();
        }
        int i18 = (i17 + hashCode) * 31;
        boolean z17 = this.isSelectable;
        int i19 = z17;
        if (z17 != 0) {
            i19 = 1;
        }
        int i26 = (i18 + i19) * 31;
        boolean z18 = this.isSelected;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        return i26 + i3;
    }

    @NotNull
    public String toString() {
        return "GuildChannelSelectedData(type=" + this.type + ", name=" + this.name + ", isPostSquareCategory=" + this.isPostSquareCategory + ", channelInfo=" + this.channelInfo + ", isSelectable=" + this.isSelectable + ", isSelected=" + this.isSelected + ")";
    }

    public /* synthetic */ GuildChannelSelectedData(int i3, String str, boolean z16, IGProChannel iGProChannel, boolean z17, boolean z18, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i16 & 4) != 0 ? false : z16, (i16 & 8) != 0 ? null : iGProChannel, (i16 & 16) != 0 ? false : z17, (i16 & 32) != 0 ? false : z18);
    }
}

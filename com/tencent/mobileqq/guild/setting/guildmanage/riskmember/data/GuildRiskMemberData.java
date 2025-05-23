package com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001f\u0010 J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016JE\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\u0011\u001a\u00020\bH\u00d6\u0001R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u001e\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/f;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/e;", "", "other", "", "equals", "", "hashCode", "", "guildId", "", "tinyId", "nickName", PhotoCategorySummaryInfo.AVATAR_URL, "isSelect", "isEditMode", "b", "toString", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "c", "J", "g", "()J", "d", "f", "Z", "i", "()Z", tl.h.F, "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.f, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildRiskMemberData extends e {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long tinyId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String nickName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String avatarUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSelect;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isEditMode;

    public /* synthetic */ GuildRiskMemberData(String str, long j3, String str2, String str3, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j3, str2, str3, (i3 & 16) != 0 ? false : z16, (i3 & 32) != 0 ? false : z17);
    }

    public static /* synthetic */ GuildRiskMemberData c(GuildRiskMemberData guildRiskMemberData, String str, long j3, String str2, String str3, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = guildRiskMemberData.guildId;
        }
        if ((i3 & 2) != 0) {
            j3 = guildRiskMemberData.tinyId;
        }
        long j16 = j3;
        if ((i3 & 4) != 0) {
            str2 = guildRiskMemberData.nickName;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            str3 = guildRiskMemberData.avatarUrl;
        }
        String str5 = str3;
        if ((i3 & 16) != 0) {
            z16 = guildRiskMemberData.isSelect;
        }
        boolean z18 = z16;
        if ((i3 & 32) != 0) {
            z17 = guildRiskMemberData.isEditMode;
        }
        return guildRiskMemberData.b(str, j16, str4, str5, z18, z17);
    }

    @NotNull
    public final GuildRiskMemberData b(@NotNull String guildId, long tinyId, @NotNull String nickName, @NotNull String avatarUrl, boolean isSelect, boolean isEditMode) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        return new GuildRiskMemberData(guildId, tinyId, nickName, avatarUrl, isSelect, isEditMode);
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e
    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(GuildRiskMemberData.class, cls) || !super.equals(other)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.GuildRiskMemberData");
        GuildRiskMemberData guildRiskMemberData = (GuildRiskMemberData) other;
        if (Intrinsics.areEqual(this.guildId, guildRiskMemberData.guildId) && this.tinyId == guildRiskMemberData.tinyId && Intrinsics.areEqual(this.nickName, guildRiskMemberData.nickName) && Intrinsics.areEqual(this.avatarUrl, guildRiskMemberData.avatarUrl) && this.isSelect == guildRiskMemberData.isSelect && this.isEditMode == guildRiskMemberData.isEditMode) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* renamed from: g, reason: from getter */
    public final long getTinyId() {
        return this.tinyId;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsEditMode() {
        return this.isEditMode;
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e
    public int hashCode() {
        return (((((((((((super.hashCode() * 31) + this.guildId.hashCode()) * 31) + androidx.fragment.app.a.a(this.tinyId)) * 31) + this.nickName.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + com.tencent.aio.widget.textView.param.a.a(this.isSelect)) * 31) + com.tencent.aio.widget.textView.param.a.a(this.isEditMode);
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    @NotNull
    public String toString() {
        return "GuildRiskMemberData(guildId=" + this.guildId + ", tinyId=" + this.tinyId + ", nickName=" + this.nickName + ", avatarUrl=" + this.avatarUrl + ", isSelect=" + this.isSelect + ", isEditMode=" + this.isEditMode + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRiskMemberData(@NotNull String guildId, long j3, @NotNull String nickName, @NotNull String avatarUrl, boolean z16, boolean z17) {
        super(1);
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        this.guildId = guildId;
        this.tinyId = j3;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
        this.isSelect = z16;
        this.isEditMode = z17;
    }
}

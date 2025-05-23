package com.tencent.mobileqq.guild.media.widget;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qqguildsdk.data.eu;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010#\u001a\u00020 \u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u000e\u0010\u001aR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u0018\u0010\u001eR\u0017\u0010#\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b\u0011\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "tinyId", "b", "d", "name", "c", "avatarMeta", "", UserInfo.SEX_FEMALE, "g", "()F", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "e", "I", "()I", "gender", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRoleManagementTag;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRoleManagementTag;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRoleManagementTag;", "roleTag", "Lcom/tencent/mobileqq/qqguildsdk/data/eu;", "Lcom/tencent/mobileqq/qqguildsdk/data/eu;", "()Lcom/tencent/mobileqq/qqguildsdk/data/eu;", "medalInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FILcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRoleManagementTag;Lcom/tencent/mobileqq/qqguildsdk/data/eu;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.media.widget.b, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class AvatarInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tinyId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String avatarMeta;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final float volume;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int gender;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IGProRoleManagementTag roleTag;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final eu medalInfo;

    public AvatarInfo(@NotNull String tinyId, @NotNull String name, @NotNull String avatarMeta, float f16, int i3, @Nullable IGProRoleManagementTag iGProRoleManagementTag, @NotNull eu medalInfo) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(avatarMeta, "avatarMeta");
        Intrinsics.checkNotNullParameter(medalInfo, "medalInfo");
        this.tinyId = tinyId;
        this.name = name;
        this.avatarMeta = avatarMeta;
        this.volume = f16;
        this.gender = i3;
        this.roleTag = iGProRoleManagementTag;
        this.medalInfo = medalInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAvatarMeta() {
        return this.avatarMeta;
    }

    /* renamed from: b, reason: from getter */
    public final int getGender() {
        return this.gender;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final eu getMedalInfo() {
        return this.medalInfo;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final IGProRoleManagementTag getRoleTag() {
        return this.roleTag;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarInfo)) {
            return false;
        }
        AvatarInfo avatarInfo = (AvatarInfo) other;
        if (Intrinsics.areEqual(this.tinyId, avatarInfo.tinyId) && Intrinsics.areEqual(this.name, avatarInfo.name) && Intrinsics.areEqual(this.avatarMeta, avatarInfo.avatarMeta) && Float.compare(this.volume, avatarInfo.volume) == 0 && this.gender == avatarInfo.gender && Intrinsics.areEqual(this.roleTag, avatarInfo.roleTag) && Intrinsics.areEqual(this.medalInfo, avatarInfo.medalInfo)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTinyId() {
        return this.tinyId;
    }

    /* renamed from: g, reason: from getter */
    public final float getVolume() {
        return this.volume;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((this.tinyId.hashCode() * 31) + this.name.hashCode()) * 31) + this.avatarMeta.hashCode()) * 31) + Float.floatToIntBits(this.volume)) * 31) + this.gender) * 31;
        IGProRoleManagementTag iGProRoleManagementTag = this.roleTag;
        if (iGProRoleManagementTag == null) {
            hashCode = 0;
        } else {
            hashCode = iGProRoleManagementTag.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + this.medalInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "AvatarInfo(tinyId=" + this.tinyId + ", name=" + this.name + ", avatarMeta=" + this.avatarMeta + ", volume=" + this.volume + ", gender=" + this.gender + ", roleTag=" + this.roleTag + ", medalInfo=" + this.medalInfo + ")";
    }
}

package ey1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\tB%\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Ley1/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "tinyId", "b", "guildId", "I", "()I", "avatarType", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ey1.e, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class MemberData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tinyId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int avatarType;

    public MemberData() {
        this(null, null, 0, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getAvatarType() {
        return this.avatarType;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTinyId() {
        return this.tinyId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberData)) {
            return false;
        }
        MemberData memberData = (MemberData) other;
        if (Intrinsics.areEqual(this.tinyId, memberData.tinyId) && Intrinsics.areEqual(this.guildId, memberData.guildId) && this.avatarType == memberData.avatarType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.tinyId.hashCode() * 31) + this.guildId.hashCode()) * 31) + this.avatarType;
    }

    @NotNull
    public String toString() {
        return "MemberData(tinyId=" + this.tinyId + ", guildId=" + this.guildId + ", avatarType=" + this.avatarType + ")";
    }

    public MemberData(@NotNull String tinyId, @NotNull String guildId, int i3) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.tinyId = tinyId;
        this.guildId = guildId;
        this.avatarType = i3;
    }

    public /* synthetic */ MemberData(String str, String str2, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? 1 : i3);
    }
}

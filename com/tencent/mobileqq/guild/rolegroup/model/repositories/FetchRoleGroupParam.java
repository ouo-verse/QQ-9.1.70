package com.tencent.mobileqq.guild.rolegroup.model.repositories;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0012\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "b", "setRoleId", "roleId", "c", "Z", "getFetchPermissionList", "()Z", "setFetchPermissionList", "(Z)V", "fetchPermissionList", "d", "I", "()I", "setSourceType", "(I)V", "sourceType", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.rolegroup.model.repositories.c, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class FetchRoleGroupParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String roleId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean fetchPermissionList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int sourceType;

    public FetchRoleGroupParam() {
        this(null, null, false, 0, 15, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getRoleId() {
        return this.roleId;
    }

    /* renamed from: c, reason: from getter */
    public final int getSourceType() {
        return this.sourceType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FetchRoleGroupParam)) {
            return false;
        }
        FetchRoleGroupParam fetchRoleGroupParam = (FetchRoleGroupParam) other;
        if (Intrinsics.areEqual(this.guildId, fetchRoleGroupParam.guildId) && Intrinsics.areEqual(this.roleId, fetchRoleGroupParam.roleId) && this.fetchPermissionList == fetchRoleGroupParam.fetchPermissionList && this.sourceType == fetchRoleGroupParam.sourceType) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.guildId.hashCode() * 31) + this.roleId.hashCode()) * 31;
        boolean z16 = this.fetchPermissionList;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.sourceType;
    }

    @NotNull
    public String toString() {
        return "FetchRoleGroupParam(guildId=" + this.guildId + ", roleId=" + this.roleId + ", fetchPermissionList=" + this.fetchPermissionList + ", sourceType=" + this.sourceType + ")";
    }

    public FetchRoleGroupParam(@NotNull String guildId, @NotNull String roleId, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(roleId, "roleId");
        this.guildId = guildId;
        this.roleId = roleId;
        this.fetchPermissionList = z16;
        this.sourceType = i3;
    }

    public /* synthetic */ FetchRoleGroupParam(String str, String str2, boolean z16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? false : z16, (i16 & 8) != 0 ? 100 : i3);
    }
}

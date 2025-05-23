package com.tencent.guild.aio.input.at.utils.data;

import androidx.fragment.app.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/guild/aio/input/at/utils/data/AtRoleInfo;", "Ljava/io/Serializable;", "roleId", "", "name", "color", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getColor", "()J", "getName", "()Ljava/lang/String;", "getRoleId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class AtRoleInfo implements Serializable {
    private final long color;

    @NotNull
    private final String name;

    @NotNull
    private final String roleId;

    public AtRoleInfo(@NotNull String roleId, @NotNull String name, long j3) {
        Intrinsics.checkNotNullParameter(roleId, "roleId");
        Intrinsics.checkNotNullParameter(name, "name");
        this.roleId = roleId;
        this.name = name;
        this.color = j3;
    }

    public static /* synthetic */ AtRoleInfo copy$default(AtRoleInfo atRoleInfo, String str, String str2, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = atRoleInfo.roleId;
        }
        if ((i3 & 2) != 0) {
            str2 = atRoleInfo.name;
        }
        if ((i3 & 4) != 0) {
            j3 = atRoleInfo.color;
        }
        return atRoleInfo.copy(str, str2, j3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getRoleId() {
        return this.roleId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final long getColor() {
        return this.color;
    }

    @NotNull
    public final AtRoleInfo copy(@NotNull String roleId, @NotNull String name, long color) {
        Intrinsics.checkNotNullParameter(roleId, "roleId");
        Intrinsics.checkNotNullParameter(name, "name");
        return new AtRoleInfo(roleId, name, color);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AtRoleInfo)) {
            return false;
        }
        AtRoleInfo atRoleInfo = (AtRoleInfo) other;
        if (Intrinsics.areEqual(this.roleId, atRoleInfo.roleId) && Intrinsics.areEqual(this.name, atRoleInfo.name) && this.color == atRoleInfo.color) {
            return true;
        }
        return false;
    }

    public final long getColor() {
        return this.color;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getRoleId() {
        return this.roleId;
    }

    public int hashCode() {
        return (((this.roleId.hashCode() * 31) + this.name.hashCode()) * 31) + a.a(this.color);
    }

    @NotNull
    public String toString() {
        return "AtRoleInfo(roleId=" + this.roleId + ", name=" + this.name + ", color=" + this.color + ")";
    }
}

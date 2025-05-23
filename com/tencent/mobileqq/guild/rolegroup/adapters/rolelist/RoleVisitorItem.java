package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/y;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "d", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "()Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "role", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.y, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class RoleVisitorItem extends r {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RoleGroupModel role;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoleVisitorItem(@NotNull String text, @NotNull RoleGroupModel role) {
        super(7, role.getId(), null);
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(role, "role");
        this.text = text;
        this.role = role;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final RoleGroupModel getRole() {
        return this.role;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoleVisitorItem)) {
            return false;
        }
        RoleVisitorItem roleVisitorItem = (RoleVisitorItem) other;
        if (Intrinsics.areEqual(this.text, roleVisitorItem.text) && Intrinsics.areEqual(this.role, roleVisitorItem.role)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.role.hashCode();
    }

    @NotNull
    public String toString() {
        return "RoleVisitorItem(text=" + this.text + ", role=" + this.role + ")";
    }
}

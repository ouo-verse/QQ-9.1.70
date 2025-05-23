package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/j;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "desc", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.j, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class LevelRoleTipItem extends r {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String desc;

    public LevelRoleTipItem() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof LevelRoleTipItem) && Intrinsics.areEqual(this.desc, ((LevelRoleTipItem) other).desc)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.desc.hashCode();
    }

    @NotNull
    public String toString() {
        return "LevelRoleTipItem(desc=" + this.desc + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LevelRoleTipItem(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
        if ((i3 & 1) != 0) {
            str = HardCodeUtil.qqStr(R.string.f154781fq);
            Intrinsics.checkNotNullExpressionValue(str, "qqStr(R.string.guild_role_list_level_role_tip)");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LevelRoleTipItem(@NotNull String desc) {
        super(6, null, 2, null);
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.desc = desc;
    }
}

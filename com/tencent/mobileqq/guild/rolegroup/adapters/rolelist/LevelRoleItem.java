package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/i;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "title", QQWinkConstants.TAB_SUBTITLE, "e", "Z", "()Z", "isEnable", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.i, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class LevelRoleItem extends r {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String subTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isEnable;

    public LevelRoleItem() {
        this(null, null, false, 7, null);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getSubTitle() {
        return this.subTitle;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsEnable() {
        return this.isEnable;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LevelRoleItem)) {
            return false;
        }
        LevelRoleItem levelRoleItem = (LevelRoleItem) other;
        if (Intrinsics.areEqual(this.title, levelRoleItem.title) && Intrinsics.areEqual(this.subTitle, levelRoleItem.subTitle) && this.isEnable == levelRoleItem.isEnable) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.title.hashCode() * 31) + this.subTitle.hashCode()) * 31;
        boolean z16 = this.isEnable;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "LevelRoleItem(title=" + this.title + ", subTitle=" + this.subTitle + ", isEnable=" + this.isEnable + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LevelRoleItem(String str, String str2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? false : z16);
        if ((i3 & 1) != 0) {
            str = HardCodeUtil.qqStr(R.string.f154741fm);
            Intrinsics.checkNotNullExpressionValue(str, "qqStr(R.string.guild_role_list_level_role)");
        }
        if ((i3 & 2) != 0) {
            str2 = HardCodeUtil.qqStr(R.string.f154771fp);
            Intrinsics.checkNotNullExpressionValue(str2, "qqStr(R.string.guild_rol\u2026ist_level_role_sub_title)");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LevelRoleItem(@NotNull String title, @NotNull String subTitle, boolean z16) {
        super(5, null, 2, null);
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        this.title = title;
        this.subTitle = subTitle;
        this.isEnable = z16;
    }
}

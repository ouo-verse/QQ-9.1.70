package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/ab;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "c", UserInfo.SEX_FEMALE, "()F", "heightInDp", "<init>", "(F)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.ab, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class SpaceItem extends r {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float heightInDp;

    public SpaceItem(float f16) {
        super(0, null, 2, null);
        this.heightInDp = f16;
    }

    /* renamed from: c, reason: from getter */
    public final float getHeightInDp() {
        return this.heightInDp;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof SpaceItem) && Float.compare(this.heightInDp, ((SpaceItem) other).heightInDp) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.heightInDp);
    }

    @NotNull
    public String toString() {
        return "SpaceItem(heightInDp=" + this.heightInDp + ")";
    }
}

package com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/e;", "", "other", "", "equals", "", "hashCode", "a", "I", "()I", "itemType", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int itemType;

    public e(int i3) {
        this.itemType = i3;
    }

    /* renamed from: a, reason: from getter */
    public int getItemType() {
        return this.itemType;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        Class<?> cls2 = getClass();
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(cls2, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.GuildRiskMemberBaseData");
        if (getItemType() == ((e) other).getItemType()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return getItemType();
    }
}

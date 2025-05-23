package com.tencent.mobileqq.guild.setting.group;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0000H\u0016R\u0014\u0010\n\u001a\u00020\u00078&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/a;", "", "newItem", "", "b", "a", "c", "", "d", "()I", "type", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class a {
    public boolean a(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (getClass().isInstance(newItem) && Intrinsics.areEqual(this, newItem)) {
            return true;
        }
        return false;
    }

    public boolean b(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (getClass().isInstance(newItem) && d() == newItem.d()) {
            return true;
        }
        return false;
    }

    @Nullable
    public Object c(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return null;
    }

    public abstract int d();
}

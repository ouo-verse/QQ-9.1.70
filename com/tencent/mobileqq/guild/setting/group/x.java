package com.tencent.mobileqq.guild.setting.group;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindableGroups;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBindableGroups;", "Lcom/tencent/mobileqq/guild/setting/group/f;", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class x {
    @NotNull
    public static final f a(@NotNull IGProBindableGroups iGProBindableGroups) {
        List take;
        List drop;
        Intrinsics.checkNotNullParameter(iGProBindableGroups, "<this>");
        ArrayList<IGProBindingGroup> groups = iGProBindableGroups.getGroups();
        Intrinsics.checkNotNullExpressionValue(groups, "groups");
        take = CollectionsKt___CollectionsKt.take(groups, iGProBindableGroups.getActiveGroups());
        ArrayList<IGProBindingGroup> groups2 = iGProBindableGroups.getGroups();
        Intrinsics.checkNotNullExpressionValue(groups2, "groups");
        drop = CollectionsKt___CollectionsKt.drop(groups2, iGProBindableGroups.getActiveGroups());
        return new f(take, drop);
    }
}

package com.tencent.mobileqq.guild.rolegroup.fragments;

import android.view.View;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public /* synthetic */ class GuildRoleListFragment$initUi$1 extends FunctionReferenceImpl implements Function2<r, View, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildRoleListFragment$initUi$1(Object obj) {
        super(2, obj, GuildRoleListFragment.class, "onItemClick", "onItemClick(Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/RoleGroupUiItem;Landroid/view/View;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(r rVar, View view) {
        invoke2(rVar, view);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull r p06, @Nullable View view) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((GuildRoleListFragment) this.receiver).Th(p06, view);
    }
}

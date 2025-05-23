package com.tencent.mobileqq.guild.setting.guildmanage.rule;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public /* synthetic */ class GuildRuleEditFragment$initView$1$3 extends FunctionReferenceImpl implements Function1<RecyclerView.ViewHolder, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildRuleEditFragment$initView$1$3(Object obj) {
        super(1, obj, GuildRuleEditFragment.class, "startDrag", "startDrag(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RecyclerView.ViewHolder viewHolder) {
        invoke2(viewHolder);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull RecyclerView.ViewHolder p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((GuildRuleEditFragment) this.receiver).qi(p06);
    }
}

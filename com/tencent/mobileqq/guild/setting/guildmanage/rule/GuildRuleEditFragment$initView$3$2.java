package com.tencent.mobileqq.guild.setting.guildmanage.rule;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rz1.RuleData;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public /* synthetic */ class GuildRuleEditFragment$initView$3$2 extends FunctionReferenceImpl implements Function2<View, RuleData, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildRuleEditFragment$initView$3$2(Object obj) {
        super(2, obj, GuildRuleEditFragment.class, "deleteRule", "deleteRule(Landroid/view/View;Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/data/RuleData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View view, RuleData ruleData) {
        invoke2(view, ruleData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull View p06, @NotNull RuleData p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        ((GuildRuleEditFragment) this.receiver).Uh(p06, p16);
    }
}

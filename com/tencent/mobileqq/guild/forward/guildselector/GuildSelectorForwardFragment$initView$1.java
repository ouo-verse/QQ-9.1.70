package com.tencent.mobileqq.guild.forward.guildselector;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public /* synthetic */ class GuildSelectorForwardFragment$initView$1 extends FunctionReferenceImpl implements Function2<GuildData, View, Unit> {
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(GuildData guildData, View view) {
        invoke2(guildData, view);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildSelectorForwardFragment$initView$1(Object obj) {
        super(2, obj, GuildSelectorForwardFragment.class, "shareToGuild", "shareToGuild(Lcom/tencent/mobileqq/guild/forward/guildselector/GuildData;Landroid/view/View;)V", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildData p06, View p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        ((GuildSelectorForwardFragment) this.receiver).zh(p06, p16);
    }
}

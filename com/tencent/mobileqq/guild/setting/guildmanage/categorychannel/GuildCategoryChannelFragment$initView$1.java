package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

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
public /* synthetic */ class GuildCategoryChannelFragment$initView$1 extends FunctionReferenceImpl implements Function1<GuildCategoryChannelItemData, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildCategoryChannelFragment$initView$1(Object obj) {
        super(1, obj, GuildCategoryChannelFragment.class, "updateShowState", "updateShowState(Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/GuildCategoryChannelItemData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildCategoryChannelItemData guildCategoryChannelItemData) {
        invoke2(guildCategoryChannelItemData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull GuildCategoryChannelItemData p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((GuildCategoryChannelFragment) this.receiver).bi(p06);
    }
}

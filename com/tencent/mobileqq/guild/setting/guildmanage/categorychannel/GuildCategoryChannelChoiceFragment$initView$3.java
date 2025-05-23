package com.tencent.mobileqq.guild.setting.guildmanage.categorychannel;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public /* synthetic */ class GuildCategoryChannelChoiceFragment$initView$3 extends FunctionReferenceImpl implements Function2<View, b, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildCategoryChannelChoiceFragment$initView$3(Object obj) {
        super(2, obj, GuildCategoryChannelChoiceFragment.class, "itemClick", "itemClick(Landroid/view/View;Lcom/tencent/mobileqq/guild/setting/guildmanage/categorychannel/GuildCategoryChannelBaseData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View view, b bVar) {
        invoke2(view, bVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull View p06, @NotNull b p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        ((GuildCategoryChannelChoiceFragment) this.receiver).Lh(p06, p16);
    }
}

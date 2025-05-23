package com.tencent.mobileqq.guild.channel.managev2.item.arrowform;

import com.tencent.mobileqq.qqguildsdk.data.ISlowModeInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
/* synthetic */ class ChannelSlowModeViewModel$handleItemClick$2 extends FunctionReferenceImpl implements Function1<ISlowModeInfo, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelSlowModeViewModel$handleItemClick$2(Object obj) {
        super(1, obj, ChannelSlowModeViewModel.class, "handleModifyModeForText", "handleModifyModeForText(Lcom/tencent/mobileqq/qqguildsdk/data/ISlowModeInfo;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ISlowModeInfo iSlowModeInfo) {
        invoke2(iSlowModeInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull ISlowModeInfo p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((ChannelSlowModeViewModel) this.receiver).v(p06);
    }
}

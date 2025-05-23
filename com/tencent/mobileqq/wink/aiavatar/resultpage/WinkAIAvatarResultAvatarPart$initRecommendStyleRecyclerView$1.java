package com.tencent.mobileqq.wink.aiavatar.resultpage;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
/* synthetic */ class WinkAIAvatarResultAvatarPart$initRecommendStyleRecyclerView$1 extends FunctionReferenceImpl implements Function1<MetaMaterial, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public WinkAIAvatarResultAvatarPart$initRecommendStyleRecyclerView$1(Object obj) {
        super(1, obj, WinkAIAvatarResultAvatarPart.class, "onStyleItemClick", "onStyleItemClick(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MetaMaterial metaMaterial) {
        invoke2(metaMaterial);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull MetaMaterial p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((WinkAIAvatarResultAvatarPart) this.receiver).Ta(p06);
    }
}

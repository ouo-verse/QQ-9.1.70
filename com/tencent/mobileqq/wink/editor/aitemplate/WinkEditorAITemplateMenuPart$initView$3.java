package com.tencent.mobileqq.wink.editor.aitemplate;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public /* synthetic */ class WinkEditorAITemplateMenuPart$initView$3 extends FunctionReferenceImpl implements Function1<MetaMaterial, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public WinkEditorAITemplateMenuPart$initView$3(Object obj) {
        super(1, obj, WinkEditorAITemplateMenuPart.class, "onRetryClick", "onRetryClick(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MetaMaterial metaMaterial) {
        invoke2(metaMaterial);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull MetaMaterial p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((WinkEditorAITemplateMenuPart) this.receiver).bb(p06);
    }
}

package com.tencent.mobileqq.wink.magicstudio.view;

import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public /* synthetic */ class ImageCreateJumpPart$initFlow$1$1 extends FunctionReferenceImpl implements Function1<MagicStudioCreationViewModel.b.GotoMultiSelect, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageCreateJumpPart$initFlow$1$1(Object obj) {
        super(1, obj, ImageCreateJumpPart.class, "gotoMultiSelect", "gotoMultiSelect(Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$Event$GotoMultiSelect;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MagicStudioCreationViewModel.b.GotoMultiSelect gotoMultiSelect) {
        invoke2(gotoMultiSelect);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull MagicStudioCreationViewModel.b.GotoMultiSelect p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((ImageCreateJumpPart) this.receiver).z9(p06);
    }
}

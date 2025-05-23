package com.tencent.mobileqq.wink.preview.part.label;

import com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewSyncQZonePart;
import com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/part/label/WinkLabelSharePreviewSyncQZonePart;", "Lcom/tencent/mobileqq/wink/preview/part/base/WinkBaseSharePreviewSyncQZonePart;", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel;", "D9", "Lcom/tencent/mobileqq/wink/preview/viewmodel/a;", "e", "Lkotlin/Lazy;", "I9", "()Lcom/tencent/mobileqq/wink/preview/viewmodel/a;", "viewModel", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkLabelSharePreviewSyncQZonePart extends WinkBaseSharePreviewSyncQZonePart {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public WinkLabelSharePreviewSyncQZonePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.preview.viewmodel.a>() { // from class: com.tencent.mobileqq.wink.preview.part.label.WinkLabelSharePreviewSyncQZonePart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.preview.viewmodel.a invoke() {
                return (com.tencent.mobileqq.wink.preview.viewmodel.a) WinkLabelSharePreviewSyncQZonePart.this.getViewModel(com.tencent.mobileqq.wink.preview.viewmodel.a.class);
            }
        });
        this.viewModel = lazy;
    }

    private final com.tencent.mobileqq.wink.preview.viewmodel.a I9() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (com.tencent.mobileqq.wink.preview.viewmodel.a) value;
    }

    @Override // com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewSyncQZonePart
    @NotNull
    public WinkBasePreviewShareViewModel D9() {
        return I9();
    }
}

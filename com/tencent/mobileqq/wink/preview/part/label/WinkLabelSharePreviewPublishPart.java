package com.tencent.mobileqq.wink.preview.part.label;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewPublishPart;
import com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import uq3.c;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/part/label/WinkLabelSharePreviewPublishPart;", "Lcom/tencent/mobileqq/wink/preview/part/base/WinkBaseSharePreviewPublishPart;", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel;", "J9", "", "G9", "H9", "Lcom/tencent/mobileqq/wink/preview/viewmodel/a;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "P9", "()Lcom/tencent/mobileqq/wink/preview/viewmodel/a;", "viewModel", "<init>", "()V", "D", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkLabelSharePreviewPublishPart extends WinkBaseSharePreviewPublishPart {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public WinkLabelSharePreviewPublishPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.preview.viewmodel.a>() { // from class: com.tencent.mobileqq.wink.preview.part.label.WinkLabelSharePreviewPublishPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.preview.viewmodel.a invoke() {
                return (com.tencent.mobileqq.wink.preview.viewmodel.a) WinkLabelSharePreviewPublishPart.this.getViewModel(com.tencent.mobileqq.wink.preview.viewmodel.a.class);
            }
        });
        this.viewModel = lazy;
    }

    private final com.tencent.mobileqq.wink.preview.viewmodel.a P9() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (com.tencent.mobileqq.wink.preview.viewmodel.a) value;
    }

    @Override // com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewPublishPart
    @NotNull
    public String G9() {
        return "gexingbiaoqian";
    }

    @Override // com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewPublishPart
    @NotNull
    public String H9() {
        String d36 = c.d3();
        Intrinsics.checkNotNullExpressionValue(d36, "getQCircleLowLevelPublisLabelContent()");
        return d36;
    }

    @Override // com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewPublishPart
    @NotNull
    public WinkBasePreviewShareViewModel J9() {
        return P9();
    }
}

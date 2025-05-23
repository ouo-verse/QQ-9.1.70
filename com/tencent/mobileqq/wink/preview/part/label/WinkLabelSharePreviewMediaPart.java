package com.tencent.mobileqq.wink.preview.part.label;

import android.graphics.drawable.ColorDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewMediaPart;
import com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/part/label/WinkLabelSharePreviewMediaPart;", "Lcom/tencent/mobileqq/wink/preview/part/base/WinkBaseSharePreviewMediaPart;", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel;", "L9", "Lcom/tencent/image/URLDrawable;", "J9", "Lcom/tencent/mobileqq/wink/preview/viewmodel/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "W9", "()Lcom/tencent/mobileqq/wink/preview/viewmodel/a;", "viewModel", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkLabelSharePreviewMediaPart extends WinkBaseSharePreviewMediaPart {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public WinkLabelSharePreviewMediaPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.preview.viewmodel.a>() { // from class: com.tencent.mobileqq.wink.preview.part.label.WinkLabelSharePreviewMediaPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.preview.viewmodel.a invoke() {
                return (com.tencent.mobileqq.wink.preview.viewmodel.a) WinkLabelSharePreviewMediaPart.this.getViewModel(com.tencent.mobileqq.wink.preview.viewmodel.a.class);
            }
        });
        this.viewModel = lazy;
    }

    private final com.tencent.mobileqq.wink.preview.viewmodel.a W9() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (com.tencent.mobileqq.wink.preview.viewmodel.a) value;
    }

    @Override // com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewMediaPart
    @NotNull
    public URLDrawable J9() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        URLDrawable drawable = URLDrawable.getDrawable("https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8920/dimenkan_qqfile/qqfile_mylabel_bg.jpg", obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(\n           \u2026ANSPARENT)\n            })");
        return drawable;
    }

    @Override // com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewMediaPart
    @NotNull
    public WinkBasePreviewShareViewModel L9() {
        return W9();
    }
}

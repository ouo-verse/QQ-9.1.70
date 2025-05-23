package com.tencent.mobileqq.wink.preview.part.photowall;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewMediaPart;
import com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel;
import com.tencent.mobileqq.wink.preview.viewmodel.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/part/photowall/WinkPhotoWallPreviewMediaPart;", "Lcom/tencent/mobileqq/wink/preview/part/base/WinkBaseSharePreviewMediaPart;", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel;", "L9", "Lcom/tencent/image/URLDrawable;", "J9", "Landroid/view/View;", "mRootView", "", "onInitView", "Lcom/tencent/mobileqq/wink/preview/viewmodel/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "X9", "()Lcom/tencent/mobileqq/wink/preview/viewmodel/c;", "viewModel", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkPhotoWallPreviewMediaPart extends WinkBaseSharePreviewMediaPart {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public WinkPhotoWallPreviewMediaPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.wink.preview.part.photowall.WinkPhotoWallPreviewMediaPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                return (c) WinkPhotoWallPreviewMediaPart.this.getViewModel(c.class);
            }
        });
        this.viewModel = lazy;
    }

    private final c X9() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (c) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(WinkPhotoWallPreviewMediaPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.Q9();
        this$0.X9().i2();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewMediaPart
    @NotNull
    public URLDrawable J9() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        URLDrawable drawable = URLDrawable.getDrawable("https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8920/dimenkan_qqfile/qqfile_myphoto_bg.jpg", obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(\n           \u2026ANSPARENT)\n            })");
        return drawable;
    }

    @Override // com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewMediaPart
    @NotNull
    public WinkBasePreviewShareViewModel L9() {
        return X9();
    }

    @Override // com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewMediaPart, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View mRootView) {
        super.onInitView(mRootView);
        G9().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.preview.part.photowall.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkPhotoWallPreviewMediaPart.Y9(WinkPhotoWallPreviewMediaPart.this, view);
            }
        });
    }
}

package com.tencent.mobileqq.zplan.aigc;

import android.view.View;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene;
import com.tencent.mobileqq.zplan.aigc.vm.SuitOutfitViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
final class SuitOutfitPreviewFragment$initView$7$1$onResult$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SuitOutfitPreviewFragment$initView$7$thumbnailExportCallback$1 $thumbnailExportCallback;
    final /* synthetic */ SuitOutfitPreviewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitOutfitPreviewFragment$initView$7$1$onResult$2(SuitOutfitPreviewFragment suitOutfitPreviewFragment, SuitOutfitPreviewFragment$initView$7$thumbnailExportCallback$1 suitOutfitPreviewFragment$initView$7$thumbnailExportCallback$1) {
        super(0);
        this.this$0 = suitOutfitPreviewFragment;
        this.$thumbnailExportCallback = suitOutfitPreviewFragment$initView$7$thumbnailExportCallback$1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final SuitOutfitPreviewFragment this$0, final SuitOutfitPreviewFragment$initView$7$thumbnailExportCallback$1 thumbnailExportCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(thumbnailExportCallback, "$thumbnailExportCallback");
        SuitOutfitViewModel suitOutfitViewModel = this$0.vm;
        if (suitOutfitViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel = null;
        }
        AigcPreviewBusinessScene scene = suitOutfitViewModel.getScene();
        if (scene != null) {
            scene.runOnViewerThread("recordAndExportThumbnailImage", new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initView$7$1$onResult$2$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    SuitOutfitPreviewFragment.this.Bk(thumbnailExportCallback);
                }
            });
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        View view;
        this.this$0.Qk(true, true);
        view = this.this$0.textureView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
            view = null;
        }
        final SuitOutfitPreviewFragment suitOutfitPreviewFragment = this.this$0;
        final SuitOutfitPreviewFragment$initView$7$thumbnailExportCallback$1 suitOutfitPreviewFragment$initView$7$thumbnailExportCallback$1 = this.$thumbnailExportCallback;
        view.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.ax
            @Override // java.lang.Runnable
            public final void run() {
                SuitOutfitPreviewFragment$initView$7$1$onResult$2.b(SuitOutfitPreviewFragment.this, suitOutfitPreviewFragment$initView$7$thumbnailExportCallback$1);
            }
        });
    }
}

package com.tencent.mobileqq.zplan.aigc.viewBinder;

import android.widget.FrameLayout;
import com.tencent.mobileqq.zplan.aigc.data.ZplanSuitOutfitPreviewConfig;
import com.tencent.mobileqq.zplan.aigc.vm.SuitOutfitViewModel;
import com.tencent.qphone.base.util.QLog;
import fi3.bz;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/tencent/mobileqq/zplan/aigc/data/ZplanSuitOutfitPreviewConfig;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class SuitOutfitPreviewViewBinder$bindMasterActionButton$1 extends Lambda implements Function1<ZplanSuitOutfitPreviewConfig, Unit> {
    final /* synthetic */ bz $binding;
    final /* synthetic */ SuitOutfitViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitOutfitPreviewViewBinder$bindMasterActionButton$1(bz bzVar, SuitOutfitViewModel suitOutfitViewModel) {
        super(1);
        this.$binding = bzVar;
        this.$viewModel = suitOutfitViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SuitOutfitViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "$viewModel");
        viewModel.u2();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ZplanSuitOutfitPreviewConfig zplanSuitOutfitPreviewConfig) {
        invoke2(zplanSuitOutfitPreviewConfig);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ZplanSuitOutfitPreviewConfig zplanSuitOutfitPreviewConfig) {
        if (zplanSuitOutfitPreviewConfig == null) {
            QLog.e("SuitOutfitPreviewViewBinder", 1, "outfitPreviewConfig is empty!!!");
            return;
        }
        this.$binding.f399192g.setVisibility(0);
        FrameLayout frameLayout = this.$binding.f399192g;
        final SuitOutfitViewModel suitOutfitViewModel = this.$viewModel;
        frameLayout.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.viewBinder.c
            @Override // java.lang.Runnable
            public final void run() {
                SuitOutfitPreviewViewBinder$bindMasterActionButton$1.b(SuitOutfitViewModel.this);
            }
        });
    }
}

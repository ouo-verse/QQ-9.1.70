package com.tencent.mobileqq.zplan.aigc.viewBinder;

import android.widget.FrameLayout;
import com.tencent.mobileqq.zplan.aigc.vm.SuitOutfitViewModel;
import com.tencent.qphone.base.util.QLog;
import fi3.bz;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "success", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class SuitOutfitPreviewViewBinder$bindOtherOutfitAction$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ bz $binding;
    final /* synthetic */ SuitOutfitViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitOutfitPreviewViewBinder$bindOtherOutfitAction$1(bz bzVar, SuitOutfitViewModel suitOutfitViewModel) {
        super(1);
        this.$binding = bzVar;
        this.$viewModel = suitOutfitViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SuitOutfitViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "$viewModel");
        viewModel.S1(false, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.viewBinder.SuitOutfitPreviewViewBinder$bindOtherOutfitAction$1$1$1
            public final void invoke(boolean z16) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        });
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16) {
        if (!z16) {
            QLog.e("SuitOutfitPreviewViewBinder", 1, "fetchOutfitPreviewActions failed");
            return;
        }
        FrameLayout frameLayout = this.$binding.f399192g;
        final SuitOutfitViewModel suitOutfitViewModel = this.$viewModel;
        frameLayout.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.viewBinder.d
            @Override // java.lang.Runnable
            public final void run() {
                SuitOutfitPreviewViewBinder$bindOtherOutfitAction$1.b(SuitOutfitViewModel.this);
            }
        });
    }
}

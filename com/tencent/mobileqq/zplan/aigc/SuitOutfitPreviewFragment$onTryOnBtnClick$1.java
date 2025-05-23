package com.tencent.mobileqq.zplan.aigc;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.aigc.utils.SuitOutfitHelper;
import com.tencent.mobileqq.zplan.aigc.vm.SuitOutfitViewModel;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.common.HippyMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
final class SuitOutfitPreviewFragment$onTryOnBtnClick$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SuitOutfitPreviewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitOutfitPreviewFragment$onTryOnBtnClick$1(SuitOutfitPreviewFragment suitOutfitPreviewFragment) {
        super(0);
        this.this$0 = suitOutfitPreviewFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean z16;
        boolean z17;
        z16 = this.this$0.isMasterMode;
        if (z16) {
            return;
        }
        z17 = this.this$0.isDressed;
        if (!z17) {
            SuitOutfitViewModel suitOutfitViewModel = this.this$0.vm;
            if (suitOutfitViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitOutfitViewModel = null;
            }
            suitOutfitViewModel.z2(String.valueOf(this.this$0.currentFeedId));
            this.this$0.isDressed = true;
        }
        SuitOutfitViewModel suitOutfitViewModel2 = this.this$0.vm;
        if (suitOutfitViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel2 = null;
        }
        LiveData<Long> k26 = suitOutfitViewModel2.k2();
        LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
        final SuitOutfitPreviewFragment suitOutfitPreviewFragment = this.this$0;
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$onTryOnBtnClick$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l3) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushString("feedID", SuitOutfitPreviewFragment.this.currentFeedId);
                hippyMap.pushString("tryonNum", String.valueOf(l3));
                HippyQQEngine.dispatchEvent("updateTryonNum", null, hippyMap);
            }
        };
        k26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.ay
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitOutfitPreviewFragment$onTryOnBtnClick$1.b(Function1.this, obj);
            }
        });
        SuitOutfitHelper suitOutfitHelper = SuitOutfitHelper.f330689a;
        SuitOutfitViewModel suitOutfitViewModel3 = this.this$0.vm;
        if (suitOutfitViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel3 = null;
        }
        bv4.a value = suitOutfitViewModel3.o2().getValue();
        String b16 = suitOutfitHelper.b(value != null ? value.f29257e : null, "feeds_samestyle");
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        iSchemeApi.launchScheme(requireContext, b16);
    }
}

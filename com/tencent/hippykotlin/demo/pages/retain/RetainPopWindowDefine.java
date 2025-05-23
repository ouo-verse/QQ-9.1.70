package com.tencent.hippykotlin.demo.pages.retain;

import com.tencent.hippykotlin.demo.pages.retain.RetainPopWindowInfo;
import com.tencent.hippykotlin.demo.pages.retain.viewModel.IRetainPopWindowViewModel;
import com.tencent.hippykotlin.demo.pages.retain.viewModel.RetainPopWindowCouponViewModel;
import com.tencent.hippykotlin.demo.pages.retain.viewModel.RetainPopWindowLiveViewModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes33.dex */
public enum RetainPopWindowDefine {
    /* JADX INFO: Fake field, exist only in values array */
    RetainCouponPopWindow(new Function1<e, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.retain.viewModel.RetainPopWindowCouponViewModel$Companion$isTheViewModel$1
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(e eVar) {
            return Boolean.valueOf(eVar.k("type", 0) == 1);
        }
    }, new Function2<RetainPopWindowInfo, e, RetainPopWindowCouponViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.retain.viewModel.RetainPopWindowCouponViewModel$Companion$newViewModel$1
        @Override // kotlin.jvm.functions.Function2
        public final RetainPopWindowCouponViewModel invoke(RetainPopWindowInfo retainPopWindowInfo, e eVar) {
            return new RetainPopWindowCouponViewModel(retainPopWindowInfo, eVar);
        }
    }),
    /* JADX INFO: Fake field, exist only in values array */
    RetainLivePopWindow(new Function1<e, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.retain.viewModel.RetainPopWindowLiveViewModel$Companion$isTheViewModel$1
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(e eVar) {
            return Boolean.valueOf(eVar.k("type", 0) == 2);
        }
    }, new Function2<RetainPopWindowInfo, e, RetainPopWindowLiveViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.retain.viewModel.RetainPopWindowLiveViewModel$Companion$newViewModel$1
        @Override // kotlin.jvm.functions.Function2
        public final RetainPopWindowLiveViewModel invoke(RetainPopWindowInfo retainPopWindowInfo, e eVar) {
            return new RetainPopWindowLiveViewModel(retainPopWindowInfo, eVar);
        }
    });

    public final Function1<e, Boolean> isThePageModelBlock;
    public final Function2<RetainPopWindowInfo, e, IRetainPopWindowViewModel> newPageModelBlock;

    static {
        RetainPopWindowCouponViewModel.Companion.getClass();
        RetainPopWindowLiveViewModel.Companion.getClass();
    }

    RetainPopWindowDefine(Function1 function1, Function2 function2) {
        this.isThePageModelBlock = function1;
        this.newPageModelBlock = function2;
    }
}

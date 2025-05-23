package com.tencent.hippykotlin.demo.pages.retain;

import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.retain.model.GetPromotePopupRsp;
import com.tencent.hippykotlin.demo.pages.retain.viewModel.IRetainPopWindowViewModel;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes33.dex */
public final class RetainPopWindowPage extends BasePager {
    public IRetainPopWindowViewModel viewModel;

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.RetainPopWindowPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.RetainPopWindowPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.mo113backgroundColor(new h(0L));
                        return Unit.INSTANCE;
                    }
                });
                IRetainPopWindowViewModel iRetainPopWindowViewModel = RetainPopWindowPage.this.viewModel;
                Intrinsics.checkNotNull(iRetainPopWindowViewModel);
                ComposeView<RetainPopWindowCardAttr, l> popWindowView = iRetainPopWindowViewModel.getPopWindowView();
                final RetainPopWindowPage retainPopWindowPage = RetainPopWindowPage.this;
                viewContainer2.addChild(popWindowView, new Function1<ComposeView<RetainPopWindowCardAttr, l>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.RetainPopWindowPage$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ComposeView<RetainPopWindowCardAttr, l> composeView) {
                        final RetainPopWindowPage retainPopWindowPage2 = RetainPopWindowPage.this;
                        composeView.attr(new Function1<RetainPopWindowCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.RetainPopWindowPage.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RetainPopWindowCardAttr retainPopWindowCardAttr) {
                                IRetainPopWindowViewModel iRetainPopWindowViewModel2 = RetainPopWindowPage.this.viewModel;
                                Intrinsics.checkNotNull(iRetainPopWindowViewModel2);
                                retainPopWindowCardAttr.viewModel = iRetainPopWindowViewModel2;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        List reversed;
        super.created();
        e m3 = PageDataExtKt.getUserData(getPageData()).m("pb_data");
        if (m3 == null && (m3 = getPageData().n().m("pb_data")) == null) {
            m3 = new e();
        }
        e m16 = PageDataExtKt.getUserData(getPageData()).m("reportJson");
        if (m16 == null && (m16 = getPageData().n().m("report_data")) == null) {
            m16 = new e();
        }
        RetainPopWindowInfo retainPopWindowInfo = new RetainPopWindowInfo(GetPromotePopupRsp.Companion.decode(m3));
        reversed = ArraysKt___ArraysKt.reversed(RetainPopWindowDefine.values());
        int size = reversed.size();
        for (int i3 = 0; i3 < size; i3++) {
            RetainPopWindowDefine retainPopWindowDefine = (RetainPopWindowDefine) reversed.get(i3);
            if (retainPopWindowDefine.isThePageModelBlock.invoke(m3).booleanValue()) {
                this.viewModel = retainPopWindowDefine.newPageModelBlock.invoke(retainPopWindowInfo, m16);
                return;
            }
        }
        throw new Exception("please check RetainPopWindowDefine file, define param illegal");
    }
}

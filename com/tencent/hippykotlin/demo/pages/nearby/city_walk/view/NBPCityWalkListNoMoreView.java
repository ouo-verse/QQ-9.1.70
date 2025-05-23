package com.tencent.hippykotlin.demo.pages.nearby.city_walk.view;

import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view_model.NBPCityWalkViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPCityWalkListNoMoreView extends ComposeView<NBPCityWalkListNoMoreAttr, NBPCityWalkListNoMoreEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPCityWalkListNoMoreAttr access$getAttr(NBPCityWalkListNoMoreView nBPCityWalkListNoMoreView) {
        return (NBPCityWalkListNoMoreAttr) nBPCityWalkListNoMoreView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkListNoMoreView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkListNoMoreView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m140flex(1.0f);
                        mVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                final NBPCityWalkListNoMoreView nBPCityWalkListNoMoreView = NBPCityWalkListNoMoreView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkListNoMoreView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final NBPCityWalkListNoMoreView nBPCityWalkListNoMoreView2 = NBPCityWalkListNoMoreView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkListNoMoreView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                NBPCityWalkViewModel nBPCityWalkViewModel = NBPCityWalkListNoMoreView.access$getAttr(NBPCityWalkListNoMoreView.this).viewModel;
                                if (nBPCityWalkViewModel == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    nBPCityWalkViewModel = null;
                                }
                                if (nBPCityWalkViewModel.getSelectListView().isEmpty()) {
                                    ceVar2.text("\u7a7a\u7a7a\u5982\u4e5f\uff0c\u5feb\u53bb\u53d1\u5e03\u4e00\u6761\u8db3\u8ff9\u5427");
                                } else {
                                    ceVar2.text("- \u4f60\u5df2\u770b\u5b8c\u4e86\u6240\u6709\u8db3\u8ff9\u5566 -");
                                }
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ceVar2.color(new h(9211020L, 1.0f));
                                ceVar2.marginTop(8.0f);
                                ceVar2.marginBottom(12.0f);
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

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPCityWalkListNoMoreAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPCityWalkListNoMoreEvent();
    }
}

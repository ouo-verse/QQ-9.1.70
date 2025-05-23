package com.tencent.hippykotlin.demo.pages.nearby.city_walk.view;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.f;
import com.tencent.kuikly.core.views.h;
import com.tencent.kuikly.core.views.i;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NBPCityWalkListLoadingView extends ComposeView<NBPCityWalkListLoadingAttr, NBPCityWalkListLoadingEvent> {
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkListLoadingView$body$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkListLoadingView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m140flex(1.0f);
                        mVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkListLoadingView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkListLoadingView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.allCenter();
                                tVar2.flexDirectionRow();
                                tVar2.marginTop(8.0f);
                                tVar2.marginBottom(12.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        i.a(vVar2, new Function1<h, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkListLoadingView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(h hVar) {
                                hVar.attr(new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkListLoadingView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(f fVar) {
                                        f fVar2 = fVar;
                                        fVar2.size(20.0f, 20.0f);
                                        fVar2.h(true);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkListLoadingView.body.1.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkListLoadingView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginLeft(4.0f);
                                        ceVar2.text("\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u5019...");
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.color(new com.tencent.kuikly.core.base.h(9211020L, 1.0f));
                                        return Unit.INSTANCE;
                                    }
                                });
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
        return new NBPCityWalkListLoadingAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPCityWalkListLoadingEvent();
    }
}

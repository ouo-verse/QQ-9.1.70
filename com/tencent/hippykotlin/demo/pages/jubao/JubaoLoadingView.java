package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.f;
import com.tencent.kuikly.core.views.h;
import com.tencent.kuikly.core.views.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoLoadingView extends ComposeView<k, l> {
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoLoadingView$body$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoLoadingView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.allCenter();
                        mVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getPageBackgroundColor());
                        return Unit.INSTANCE;
                    }
                });
                i.a(viewContainer2, new Function1<h, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoLoadingView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(h hVar) {
                        hVar.attr(new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoLoadingView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(f fVar) {
                                f fVar2 = fVar;
                                fVar2.h(true);
                                fVar2.mo141height(20.0f);
                                fVar2.mo153width(20.0f);
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
        return new k();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}

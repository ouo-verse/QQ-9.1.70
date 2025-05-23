package com.tencent.hippykotlin.demo.pages.game_content_page.base;

import com.tencent.hippykotlin.demo.pages.foundation.view.APNGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGVView;
import com.tencent.hippykotlin.demo.pages.foundation.view.APNGViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCircleLoadingView extends ComposeView<ECCircleLoadingAttr, ECCircleLoadingEvent> {
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.ECCircleLoadingView$body$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.ECCircleLoadingView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                        mVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.ECCircleLoadingView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.ECCircleLoadingView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        APNGViewKt.APNG(vVar2, new Function1<APNGVView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.ECCircleLoadingView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(APNGVView aPNGVView) {
                                aPNGVView.attr(new Function1<APNGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.ECCircleLoadingView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(APNGAttr aPNGAttr) {
                                        APNGAttr aPNGAttr2 = aPNGAttr;
                                        aPNGAttr2.size(52.0f, 52.0f);
                                        aPNGAttr2.with("src", "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/rXujrsX8.png");
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.ECCircleLoadingView.body.1.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.base.ECCircleLoadingView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginTop(10.0f);
                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null).fontWeight500();
                                        ceVar2.color(new h("qecommerce_skin_color_text_primary"));
                                        ceVar2.value("\u5185\u5bb9\u52a0\u8f7d\u4e2d");
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
        return new ECCircleLoadingAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ECCircleLoadingEvent();
    }
}

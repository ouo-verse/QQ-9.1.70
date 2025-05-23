package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchErrorView extends ComposeView<QSearchErrorAttr, QSearchErrorEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchErrorAttr access$getAttr(QSearchErrorView qSearchErrorView) {
        return (QSearchErrorAttr) qSearchErrorView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchErrorView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchErrorView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchErrorView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchErrorView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                String str;
                                af afVar2 = afVar;
                                if (SkinColor.INSTANCE.isNightMode(BridgeManager.f117344a.u())) {
                                    str = "data:image/png;base64,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";
                                } else {
                                    str = "data:image/png;base64,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";
                                }
                                b.a.b(afVar2, str, false, 2, null);
                                afVar2.size(100.0f, 100.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchErrorView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchErrorView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginTop(24.0f);
                                ceVar2.text("\u65e0\u6cd5\u8fde\u63a5");
                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                ceVar2.fontWeight400();
                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QSearchErrorView qSearchErrorView = QSearchErrorView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchErrorView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchErrorView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.paddingTop(20.0f);
                                tVar2.mo141height((tVar2.getPager().getPageData().g() - 148.0f) / 2);
                                tVar2.alignItemsCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchErrorView qSearchErrorView2 = QSearchErrorView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchErrorView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final QSearchErrorView qSearchErrorView3 = QSearchErrorView.this;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchErrorView.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(168.0f, 40.0f);
                                        QUISkinColor qUISkinColor = QUISkinColor.INSTANCE;
                                        tVar2.mo113backgroundColor(QUIToken.color$default("button_bg_primary_default"));
                                        tVar2.borderRadius(4.0f);
                                        tVar2.allCenter();
                                        EcommerceExtKt.vr$default(tVar2, null, "em_search_reload_button", QSearchErrorView.access$getAttr(QSearchErrorView.this).reportParam, null, null, true, 25);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchErrorView qSearchErrorView4 = QSearchErrorView.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchErrorView.body.1.4.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final QSearchErrorView qSearchErrorView5 = QSearchErrorView.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchErrorView.body.1.4.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                Function0<Unit> function0 = QSearchErrorView.access$getAttr(QSearchErrorView.this).retryHandler;
                                                if (function0 != null) {
                                                    function0.invoke();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchErrorView.body.1.4.2.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchErrorView.body.1.4.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u91cd\u65b0\u52a0\u8f7d");
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("button_text_primary_default"));
                                                ceVar2.fontWeight500();
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
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchErrorAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchErrorEvent();
    }
}

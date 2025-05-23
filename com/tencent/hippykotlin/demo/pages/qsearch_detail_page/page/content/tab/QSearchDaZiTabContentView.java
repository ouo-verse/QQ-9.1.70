package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchDaZiTabContentView extends QSearchTabContentView {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchTabContentAttr access$getAttr(QSearchDaZiTabContentView qSearchDaZiTabContentView) {
        return (QSearchTabContentAttr) qSearchDaZiTabContentView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchTabContentView
    public final Function1<ViewContainer<?, ?>, Unit> appendEmptyView(e eVar) {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchDaZiTabContentView$appendEmptyView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchDaZiTabContentView qSearchDaZiTabContentView = QSearchDaZiTabContentView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchDaZiTabContentView$appendEmptyView$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchDaZiTabContentView.appendEmptyView.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.absolutePositionAllZero();
                                tVar2.flexDirectionColumn();
                                tVar2.justifyContentFlexEnd();
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchDaZiTabContentView qSearchDaZiTabContentView2 = QSearchDaZiTabContentView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchDaZiTabContentView.appendEmptyView.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchDaZiTabContentView.appendEmptyView.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height((tVar2.getPager().getPageData().g() - 148.0f) / 2);
                                        tVar2.paddingTop(20.0f);
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchDaZiTabContentView qSearchDaZiTabContentView3 = QSearchDaZiTabContentView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchDaZiTabContentView.appendEmptyView.1.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        final QSearchDaZiTabContentView qSearchDaZiTabContentView4 = QSearchDaZiTabContentView.this;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchDaZiTabContentView.appendEmptyView.1.1.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(168.0f, FontModuleExtKt.qqFontScaleAddSize(17.0f) + 40.0f);
                                                QUISkinColor qUISkinColor = QUISkinColor.INSTANCE;
                                                tVar2.mo113backgroundColor(QUIToken.color$default("button_bg_primary_default"));
                                                tVar2.borderRadius(4.0f);
                                                tVar2.allCenter();
                                                QSearchDaZiTabContentView qSearchDaZiTabContentView5 = QSearchDaZiTabContentView.this;
                                                EcommerceExtKt.vr$default(tVar2, null, "em_bas_search_create_active_button", qSearchDaZiTabContentView5.getEmptyOrErrorViewReportParams(QSearchDaZiTabContentView.access$getAttr(qSearchDaZiTabContentView5).getKeyword(), QSearchDaZiTabContentView.access$getAttr(QSearchDaZiTabContentView.this).getViewModel().repo.currentTraceId, null), null, null, true, 25);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchDaZiTabContentView.appendEmptyView.1.1.2.2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchDaZiTabContentView.appendEmptyView.1.1.2.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        BridgeModule.openPage$default(Utils.INSTANCE.currentBridgeModule(), "mqqapi://qevent/openpublish?qevent_from=3", false, null, null, 30);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchDaZiTabContentView.appendEmptyView.1.1.2.2.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.QSearchDaZiTabContentView.appendEmptyView.1.1.2.2.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text("\u521b\u5efa\u65b0\u6d3b\u52a8");
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
                });
                return Unit.INSTANCE;
            }
        };
    }
}

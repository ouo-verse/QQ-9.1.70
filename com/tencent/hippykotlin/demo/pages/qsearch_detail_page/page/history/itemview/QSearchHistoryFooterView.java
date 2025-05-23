package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
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
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchHistoryFooterView extends QSearchBaseSingleItemView<QSearchHistoryFooterAttr, QSearchHistoryFooterEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryFooterView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final QSearchHistoryFooterView qSearchHistoryFooterView = QSearchHistoryFooterView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryFooterView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.paddingLeft(16.0f).paddingRight(16.0f);
                        mVar2.flexDirectionColumn();
                        QSearchHistoryFooterView qSearchHistoryFooterView2 = QSearchHistoryFooterView.this;
                        int i3 = QSearchHistoryFooterView.$r8$clinit;
                        EcommerceExtKt.elementVR(mVar2, "em_bas_clear_history", qSearchHistoryFooterView2.getReportParams());
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryFooterView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryFooterView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(0.5f);
                                tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("border_standard"));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryFooterView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryFooterView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(14.0f) + 56.0f);
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                tVar2.justifyContentCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryFooterView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryFooterView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        String sb5;
                                        af afVar2 = afVar;
                                        afVar2.size(FontModuleExtKt.qqFontScale() * 16.0f, FontModuleExtKt.qqFontScale() * 16.0f);
                                        String str = "qui_image://delete?color=text_secondary";
                                        if (SkinColor.INSTANCE.isNightMode(BridgeManager.f117344a.u())) {
                                            StringBuilder m3 = HotViewKt$$ExternalSyntheticOutline0.m(str, "&image_unique_id=");
                                            m3.append(SkinColor.colorUniqueID);
                                            sb5 = m3.toString();
                                        } else {
                                            StringBuilder m16 = HotViewKt$$ExternalSyntheticOutline0.m(str, "&image_unique_id=");
                                            m16.append(SkinColor.colorUniqueID);
                                            sb5 = m16.toString();
                                        }
                                        b.a.b(afVar2, sb5, false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryFooterView.body.1.3.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryFooterView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginLeft(4.0f);
                                        ceVar2.text("\u6e05\u9664\u6700\u8fd1\u641c\u7d22");
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                        ceVar2.textOverFlowTail();
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
        return new QSearchHistoryFooterAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchHistoryFooterEvent();
    }
}

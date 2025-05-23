package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.QSearchHistoryViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageEvent;
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
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchHistoryItemView extends QSearchBaseSingleItemView<QSearchHistoryItemAttr, QSearchHistoryItemEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchHistoryItemAttr access$getAttr(QSearchHistoryItemView qSearchHistoryItemView) {
        return (QSearchHistoryItemAttr) qSearchHistoryItemView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryItemView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final QSearchHistoryItemView qSearchHistoryItemView = QSearchHistoryItemView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryItemView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        QSearchHistoryItemView qSearchHistoryItemView2 = QSearchHistoryItemView.this;
                        int i3 = QSearchHistoryItemView.$r8$clinit;
                        e reportParams = qSearchHistoryItemView2.getReportParams();
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("item_");
                        m3.append(QSearchHistoryItemView.access$getAttr(QSearchHistoryItemView.this).getHistoryWord().hashCode());
                        EcommerceExtKt.vr$default(mVar2, null, "em_bas_search_history_box", reportParams, null, m3.toString(), true, 9);
                        return Unit.INSTANCE;
                    }
                });
                final QSearchHistoryItemView qSearchHistoryItemView2 = QSearchHistoryItemView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryItemView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryItemView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.paddingLeft(16.0f).paddingRight(16.0f);
                                tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(17.0f) + 48.0f);
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryItemView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryItemView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        String sb5;
                                        af afVar2 = afVar;
                                        afVar2.size(FontModuleExtKt.qqFontScale() * 20.0f, FontModuleExtKt.qqFontScale() * 20.0f);
                                        String str = "qui_image://time?color=text_secondary";
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
                        final QSearchHistoryItemView qSearchHistoryItemView3 = QSearchHistoryItemView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryItemView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final QSearchHistoryItemView qSearchHistoryItemView4 = QSearchHistoryItemView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryItemView.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.m140flex(1.0f);
                                        ceVar2.marginLeft(4.0f).marginRight(16.0f);
                                        ceVar2.text(QSearchHistoryItemView.access$getAttr(QSearchHistoryItemView.this).getHistoryWord());
                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                        ceVar2.lineHeight(FontModuleExtKt.qqTextViewLineHeightScale() * 20.0f);
                                        ceVar2.lines(1);
                                        ceVar2.textOverFlowTail();
                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                        ceVar2.textOverFlowTail();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchHistoryItemView qSearchHistoryItemView4 = QSearchHistoryItemView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryItemView.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                ImageView imageView2 = imageView;
                                final QSearchHistoryItemView qSearchHistoryItemView5 = QSearchHistoryItemView.this;
                                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryItemView.body.1.2.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        String sb5;
                                        af afVar2 = afVar;
                                        afVar2.size(FontModuleExtKt.qqFontScale() * 20.0f, FontModuleExtKt.qqFontScale() * 20.0f);
                                        String str = "qui_image://close?color=text_secondary";
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
                                        QSearchHistoryItemView qSearchHistoryItemView6 = QSearchHistoryItemView.this;
                                        int i3 = QSearchHistoryItemView.$r8$clinit;
                                        e reportParams = qSearchHistoryItemView6.getReportParams();
                                        StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("deletion_");
                                        m17.append(QSearchHistoryItemView.access$getAttr(QSearchHistoryItemView.this).getHistoryWord().hashCode());
                                        EcommerceExtKt.vr$default(afVar2, null, "em_bas_history_deletion", reportParams, null, m17.toString(), true, 9);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchHistoryItemView qSearchHistoryItemView6 = QSearchHistoryItemView.this;
                                imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryItemView.body.1.2.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageEvent imageEvent) {
                                        final QSearchHistoryItemView qSearchHistoryItemView7 = QSearchHistoryItemView.this;
                                        imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history.itemview.QSearchHistoryItemView.body.1.2.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                QSearchHistoryViewModel qSearchHistoryViewModel = QSearchHistoryItemView.access$getAttr(QSearchHistoryItemView.this).viewModel;
                                                if (qSearchHistoryViewModel == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                                    qSearchHistoryViewModel = null;
                                                }
                                                String historyWord = QSearchHistoryItemView.access$getAttr(QSearchHistoryItemView.this).getHistoryWord();
                                                if (qSearchHistoryViewModel.getDataList().contains(historyWord)) {
                                                    qSearchHistoryViewModel.getDataList().remove(historyWord);
                                                    qSearchHistoryViewModel.syncStorage();
                                                }
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
        return new QSearchHistoryItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchHistoryItemEvent();
    }
}

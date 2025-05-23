package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.item;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.HighlightTextViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.JSONException;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchSugWordsItemView extends QSearchBaseSingleItemView<QSearchSugWordsItemAttr, QSearchSugWordsItemEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchSugWordsItemAttr access$getAttr(QSearchSugWordsItemView qSearchSugWordsItemView) {
        return (QSearchSugWordsItemAttr) qSearchSugWordsItemView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.item.QSearchSugWordsItemView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final QSearchSugWordsItemView qSearchSugWordsItemView = QSearchSugWordsItemView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.item.QSearchSugWordsItemView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        EcommerceExtKt.vr$default(mVar, null, "em_bas_associative_word", QSearchSugWordsItemView.this.getReportParams(), null, String.valueOf(QSearchSugWordsItemView.access$getAttr(QSearchSugWordsItemView.this).getSugWordInfo().hashCode()), true, 9);
                        return Unit.INSTANCE;
                    }
                });
                final QSearchSugWordsItemView qSearchSugWordsItemView2 = QSearchSugWordsItemView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.item.QSearchSugWordsItemView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.item.QSearchSugWordsItemView.body.1.2.1
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
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.item.QSearchSugWordsItemView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.item.QSearchSugWordsItemView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        String sb5;
                                        af afVar2 = afVar;
                                        afVar2.size(FontModuleExtKt.qqFontScale() * 20.0f, FontModuleExtKt.qqFontScale() * 20.0f);
                                        String str = "qui_image://search?color=text_secondary";
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
                        final QSearchSugWordsItemView qSearchSugWordsItemView3 = QSearchSugWordsItemView.this;
                        HighlightTextViewKt.HighlightText(vVar2, new Function1<HighlightTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.item.QSearchSugWordsItemView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(HighlightTextView highlightTextView) {
                                final QSearchSugWordsItemView qSearchSugWordsItemView4 = QSearchSugWordsItemView.this;
                                highlightTextView.attr(new Function1<HighlightAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.item.QSearchSugWordsItemView.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(HighlightAttr highlightAttr) {
                                        HighlightAttr highlightAttr2 = highlightAttr;
                                        highlightAttr2.m140flex(1.0f);
                                        highlightAttr2.marginLeft(4.0f);
                                        highlightAttr2.mo141height(FontModuleExtKt.qqFontScaleAddSize(17.0f) + 20.0f);
                                        highlightAttr2.justifyContentCenter();
                                        highlightAttr2.text = QSearchSugWordsItemView.access$getAttr(QSearchSugWordsItemView.this).getSugWordInfo().f413220d;
                                        highlightAttr2.highlightText = QSearchSugWordsItemView.access$getAttr(QSearchSugWordsItemView.this).getSugWordInfo().f413221e;
                                        highlightAttr2.fontSize = 17.0f;
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
        return new QSearchSugWordsItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchSugWordsItemEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemView
    public final e getReportParams() {
        e reportParams = super.getReportParams();
        String str = ((QSearchSugWordsItemAttr) getAttr()).getSugWordInfo().f413222f;
        try {
            e eVar = new e(str);
            Iterator<String> c16 = eVar.c();
            while (c16.hasNext()) {
                String next = c16.next();
                reportParams.v(next, eVar.p(next));
            }
        } catch (JSONException unused) {
            Utils.INSTANCE.logToNative("sugWordItem report parse extension error, extension=" + str);
        }
        return reportParams;
    }
}

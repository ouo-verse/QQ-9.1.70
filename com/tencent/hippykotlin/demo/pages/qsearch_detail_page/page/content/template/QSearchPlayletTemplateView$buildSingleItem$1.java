package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchButton;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes32.dex */
public final class QSearchPlayletTemplateView$buildSingleItem$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ QSearchButton $button;
    public final /* synthetic */ QSearchPlayletTemplateView $ctx;
    public final /* synthetic */ boolean $isMore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchPlayletTemplateView$buildSingleItem$1(boolean z16, QSearchButton qSearchButton, QSearchPlayletTemplateView qSearchPlayletTemplateView) {
        super(1);
        this.$isMore = z16;
        this.$button = qSearchButton;
        this.$ctx = qSearchPlayletTemplateView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final boolean z16 = this.$isMore;
        final QSearchButton qSearchButton = this.$button;
        final QSearchPlayletTemplateView qSearchPlayletTemplateView = this.$ctx;
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView$buildSingleItem$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                final QSearchButton qSearchButton2 = qSearchButton;
                final QSearchPlayletTemplateView qSearchPlayletTemplateView2 = qSearchPlayletTemplateView;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildSingleItem.1.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        float qqFontScaleAddSize = FontModuleExtKt.qqFontScaleAddSize(14.0f) + 48.0f;
                        tVar2.mo153width(qqFontScaleAddSize);
                        tVar2.mo141height(qqFontScaleAddSize);
                        tVar2.paddingLeft(8.0f);
                        tVar2.paddingRight(8.0f);
                        QUISkinColor qUISkinColor = QUISkinColor.INSTANCE;
                        tVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_primary"));
                        tVar2.allCenter();
                        tVar2.borderRadius(4.0f);
                        tVar2.marginRight(8.0f);
                        QSearchReportInfo qSearchReportInfo = QSearchButton.this.reportInfo;
                        if (qSearchReportInfo != null) {
                            EcommerceExtKt.vr$default(tVar2, null, qSearchReportInfo.eid, TemplateItemsKt.getReportParams(qSearchReportInfo, qSearchPlayletTemplateView2.getTemplateCardReportInfo()), null, String.valueOf(qSearchReportInfo.hashCode()), true, 9);
                        }
                        return Unit.INSTANCE;
                    }
                });
                final QSearchPlayletTemplateView qSearchPlayletTemplateView3 = qSearchPlayletTemplateView;
                final QSearchButton qSearchButton3 = qSearchButton;
                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildSingleItem.1.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(u uVar) {
                        final QSearchPlayletTemplateView qSearchPlayletTemplateView4 = QSearchPlayletTemplateView.this;
                        final QSearchButton qSearchButton4 = qSearchButton3;
                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildSingleItem.1.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                QSearchPlayletTemplateView.this.doJump(qSearchButton4.jumpLink, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                if (z16) {
                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildSingleItem.1.1.3
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ImageView imageView) {
                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildSingleItem.1.1.3.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(af afVar) {
                                    String sb5;
                                    af afVar2 = afVar;
                                    afVar2.size(14.0f, 14.0f);
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append("qui_image://");
                                    sb6.append("more");
                                    String m3 = OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(sb6, "?color=", "icon_primary");
                                    if (SkinColor.INSTANCE.isNightMode(BridgeManager.f117344a.u())) {
                                        StringBuilder m16 = HotViewKt$$ExternalSyntheticOutline0.m(m3, "&image_unique_id=");
                                        m16.append(SkinColor.colorUniqueID);
                                        sb5 = m16.toString();
                                    } else {
                                        StringBuilder m17 = HotViewKt$$ExternalSyntheticOutline0.m(m3, "&image_unique_id=");
                                        m17.append(SkinColor.colorUniqueID);
                                        sb5 = m17.toString();
                                    }
                                    b.a.b(afVar2, sb5, false, 2, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                } else {
                    final QSearchButton qSearchButton4 = qSearchButton;
                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildSingleItem.1.1.4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(TextView textView) {
                            final QSearchButton qSearchButton5 = QSearchButton.this;
                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildSingleItem.1.1.4.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ce ceVar) {
                                    ce ceVar2 = ceVar;
                                    ceVar2.text(QSearchButton.this.title);
                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                    ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                    ceVar2.fontWeight400();
                                    ceVar2.lines(1);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}

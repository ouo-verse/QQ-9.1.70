package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchPlaylet;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchText;
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
public final class QSearchPlayletTemplateView$buildSubTitle$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ QSearchPlaylet $contentData;
    public final /* synthetic */ QSearchPlayletTemplateView $ctx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchPlayletTemplateView$buildSubTitle$1(QSearchPlaylet qSearchPlaylet, QSearchPlayletTemplateView qSearchPlayletTemplateView) {
        super(1);
        this.$contentData = qSearchPlaylet;
        this.$ctx = qSearchPlayletTemplateView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        ViewContainer<?, ?> viewContainer2 = viewContainer;
        final QSearchText qSearchText = this.$contentData.subTitle;
        if (qSearchText != null) {
            final QSearchPlayletTemplateView qSearchPlayletTemplateView = this.$ctx;
            w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView$buildSubTitle$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(v vVar) {
                    v vVar2 = vVar;
                    final QSearchText qSearchText2 = QSearchText.this;
                    final QSearchPlayletTemplateView qSearchPlayletTemplateView2 = qSearchPlayletTemplateView;
                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView$buildSubTitle$1$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(t tVar) {
                            t tVar2 = tVar;
                            tVar2.paddingTop(8.0f);
                            tVar2.flexDirectionRow();
                            tVar2.alignItemsCenter();
                            tVar2.alignSelfFlexStart();
                            QSearchReportInfo qSearchReportInfo = QSearchText.this.reportInfo;
                            if (qSearchReportInfo != null) {
                                EcommerceExtKt.vr$default(tVar2, null, qSearchReportInfo.eid, TemplateItemsKt.getReportParams(qSearchReportInfo, qSearchPlayletTemplateView2.getTemplateCardReportInfo()), null, String.valueOf(qSearchReportInfo.hashCode()), true, 9);
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    final QSearchPlayletTemplateView qSearchPlayletTemplateView3 = qSearchPlayletTemplateView;
                    final QSearchText qSearchText3 = QSearchText.this;
                    vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView$buildSubTitle$1$1$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(u uVar) {
                            final QSearchPlayletTemplateView qSearchPlayletTemplateView4 = QSearchPlayletTemplateView.this;
                            final QSearchText qSearchText4 = qSearchText3;
                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildSubTitle.1.1.1.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ClickParams clickParams) {
                                    QSearchPlayletTemplateView.this.doJump(qSearchText4.jumpLink, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    final QSearchText qSearchText4 = QSearchText.this;
                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView$buildSubTitle$1$1$1.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(TextView textView) {
                            final QSearchText qSearchText5 = QSearchText.this;
                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildSubTitle.1.1.1.3.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ce ceVar) {
                                    ce ceVar2 = ceVar;
                                    ceVar2.text(QSearchText.this.text);
                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                    ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                    ceVar2.fontWeight400();
                                    ceVar2.m140flex(1.0f);
                                    ceVar2.lines(1);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView$buildSubTitle$1$1$1.4
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ImageView imageView) {
                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildSubTitle.1.1.1.4.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(af afVar) {
                                    String sb5;
                                    af afVar2 = afVar;
                                    afVar2.size(14.0f, 14.0f);
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append("qui_image://");
                                    sb6.append("chevron_right");
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
                    return Unit.INSTANCE;
                }
            });
        }
        return Unit.INSTANCE;
    }
}

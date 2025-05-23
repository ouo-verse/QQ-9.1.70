package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBannerTemplateModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchBaseTemplateModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchButtonInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchListItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchTabContentViewModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchBlueButtonAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchBlueButtonEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchBlueButtonView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchBlueButtonViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.LoadResolutionParams;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchBannerTemplateView extends QSearchBaseTemplateView<QSearchBannerTemplateModel, QSearchBannerAttr, QSearchBannerEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchBannerTemplateView.class, "bannerImageHeight", "getBannerImageHeight()F", 0)};
    public final ReadWriteProperty bannerImageHeight$delegate = c.a(Float.valueOf(102.0f));

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchBannerAttr access$getAttr(QSearchBannerTemplateView qSearchBannerTemplateView) {
        return (QSearchBannerAttr) qSearchBannerTemplateView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView
    public final Function1<ViewContainer<?, ?>, Unit> buildContent() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView$buildContent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchBannerTemplateView qSearchBannerTemplateView = QSearchBannerTemplateView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView$buildContent$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        if (QSearchBannerTemplateView.access$getAttr(QSearchBannerTemplateView.this).getData().layoutInfo.showDivider) {
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.mo141height(0.5f);
                                            tVar2.absolutePositionAllZero();
                                            tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("border_standard"));
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        final QSearchBannerTemplateView qSearchBannerTemplateView2 = QSearchBannerTemplateView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2
                            {
                                super(1);
                            }

                            /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchButtonInfo>, java.util.ArrayList] */
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final QSearchBannerTemplateView qSearchBannerTemplateView3 = QSearchBannerTemplateView.this;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        QSearchBannerTemplateView qSearchBannerTemplateView4 = QSearchBannerTemplateView.this;
                                        KProperty<Object>[] kPropertyArr = QSearchBannerTemplateView.$$delegatedProperties;
                                        float f16 = qSearchBannerTemplateView4.isBannerImageFull() ? 0.0f : 12.0f;
                                        float f17 = QSearchBannerTemplateView.this.isBannerImageFull() ? 0.0f : 12.0f;
                                        tVar2.paddingTop(f16);
                                        tVar2.paddingBottom(f17);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchBannerTemplateView qSearchBannerTemplateView4 = QSearchBannerTemplateView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        final QSearchBannerTemplateView qSearchBannerTemplateView5 = QSearchBannerTemplateView.this;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                QSearchBannerTemplateView qSearchBannerTemplateView6 = QSearchBannerTemplateView.this;
                                                KProperty<Object>[] kPropertyArr = QSearchBannerTemplateView.$$delegatedProperties;
                                                tVar2.borderRadius(qSearchBannerTemplateView6.isBannerImageFull() ? 0.0f : 4.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchBannerTemplateView qSearchBannerTemplateView6 = QSearchBannerTemplateView.this;
                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                float m3;
                                                float f16;
                                                ImageView imageView2 = imageView;
                                                QSearchBannerTemplateView qSearchBannerTemplateView7 = QSearchBannerTemplateView.this;
                                                KProperty<Object>[] kPropertyArr = QSearchBannerTemplateView.$$delegatedProperties;
                                                if (qSearchBannerTemplateView7.isBannerImageFull()) {
                                                    m3 = QSearchBannerTemplateView.this.getPagerData().m();
                                                    f16 = 16.0f;
                                                } else {
                                                    m3 = QSearchBannerTemplateView.this.getPagerData().m();
                                                    f16 = 48.0f;
                                                }
                                                final float f17 = m3 - f16;
                                                final QSearchBannerTemplateView qSearchBannerTemplateView8 = QSearchBannerTemplateView.this;
                                                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        b.a.b(afVar2, QSearchBannerTemplateView.access$getAttr(QSearchBannerTemplateView.this).getData().background, false, 2, null);
                                                        afVar2.mo153width(f17);
                                                        QSearchBannerTemplateView qSearchBannerTemplateView9 = QSearchBannerTemplateView.this;
                                                        afVar2.mo141height(((Number) qSearchBannerTemplateView9.bannerImageHeight$delegate.getValue(qSearchBannerTemplateView9, QSearchBannerTemplateView.$$delegatedProperties[0])).floatValue());
                                                        QSearchTemplateReportInfo qSearchTemplateReportInfo = QSearchBannerTemplateView.access$getAttr(QSearchBannerTemplateView.this).getData().reportInfo;
                                                        if (qSearchTemplateReportInfo != null) {
                                                            EcommerceExtKt.vr$default(afVar2, null, qSearchTemplateReportInfo.eid, qSearchTemplateReportInfo.getReportParams(QSearchBannerTemplateView.this.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo.hashCode()), true, 9);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QSearchBannerTemplateView qSearchBannerTemplateView9 = QSearchBannerTemplateView.this;
                                                imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageEvent imageEvent) {
                                                        ImageEvent imageEvent2 = imageEvent;
                                                        if (QSearchBannerTemplateView.access$getAttr(QSearchBannerTemplateView.this).getData().jumpInfo != null) {
                                                            final QSearchBannerTemplateView qSearchBannerTemplateView10 = QSearchBannerTemplateView.this;
                                                            imageEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.2.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    QSearchBannerTemplateView qSearchBannerTemplateView11 = QSearchBannerTemplateView.this;
                                                                    qSearchBannerTemplateView11.doJump(QSearchBannerTemplateView.access$getAttr(qSearchBannerTemplateView11).getData().jumpInfo, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        }
                                                        final QSearchBannerTemplateView qSearchBannerTemplateView11 = QSearchBannerTemplateView.this;
                                                        final float f18 = f17;
                                                        imageEvent2.i(new Function1<LoadResolutionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.2.2.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(LoadResolutionParams loadResolutionParams) {
                                                                LoadResolutionParams loadResolutionParams2 = loadResolutionParams;
                                                                float width = loadResolutionParams2.getWidth() / loadResolutionParams2.getHeight();
                                                                if (width > 0.0f) {
                                                                    QSearchBannerTemplateView qSearchBannerTemplateView12 = QSearchBannerTemplateView.this;
                                                                    qSearchBannerTemplateView12.bannerImageHeight$delegate.setValue(qSearchBannerTemplateView12, QSearchBannerTemplateView.$$delegatedProperties[0], Float.valueOf(f18 / width));
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
                                        final QSearchListItemModel qSearchListItemModel = QSearchBannerTemplateView.access$getAttr(QSearchBannerTemplateView.this).getData().itemModel;
                                        if (qSearchListItemModel != null) {
                                            final QSearchBannerTemplateView qSearchBannerTemplateView7 = QSearchBannerTemplateView.this;
                                            w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar7) {
                                                    v vVar8 = vVar7;
                                                    final QSearchListItemModel qSearchListItemModel2 = QSearchListItemModel.this;
                                                    vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.3.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 1, null);
                                                            float qqFontScaleAddSize = FontModuleExtKt.qqFontScaleAddSize(17.0f);
                                                            if (QSearchListItemModel.this.desc.length() > 0) {
                                                                qqFontScaleAddSize += FontModuleExtKt.qqFontScaleAddSize(14.0f);
                                                            }
                                                            if (QSearchListItemModel.this.button != null) {
                                                                qqFontScaleAddSize += FontModuleExtKt.qqFontScaleAddSize(14.0f);
                                                            }
                                                            tVar2.mo141height(qqFontScaleAddSize + 60.0f);
                                                            tVar2.flexDirectionRow();
                                                            tVar2.alignItemsCenter();
                                                            tVar2.paddingLeft(10.0f);
                                                            tVar2.paddingRight(10.0f);
                                                            tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h(0, 0, 0, 0.0f), 0.0f), new j(new h(0, 0, 0, 0.6f), 1.0f));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    if (QSearchListItemModel.this.icon.length() > 0) {
                                                        final QSearchListItemModel qSearchListItemModel3 = QSearchListItemModel.this;
                                                        ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.3.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                final QSearchListItemModel qSearchListItemModel4 = QSearchListItemModel.this;
                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.3.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(af afVar) {
                                                                        af afVar2 = afVar;
                                                                        afVar2.marginRight(12.0f);
                                                                        b.a.b(afVar2, QSearchListItemModel.this.icon, false, 2, null);
                                                                        afVar2.size(40.0f, 40.0f);
                                                                        afVar2.borderRadius(4.0f);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                    }
                                                    final QSearchListItemModel qSearchListItemModel4 = QSearchListItemModel.this;
                                                    w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.3.3
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar9) {
                                                            v vVar10 = vVar9;
                                                            vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.3.3.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.m140flex(1.0f);
                                                                    tVar2.justifyContentCenter();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final QSearchListItemModel qSearchListItemModel5 = QSearchListItemModel.this;
                                                            cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.3.3.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(TextView textView) {
                                                                    final QSearchListItemModel qSearchListItemModel6 = QSearchListItemModel.this;
                                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.3.3.2.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ce ceVar) {
                                                                            ce ceVar2 = ceVar;
                                                                            ceVar2.text(QSearchListItemModel.this.title);
                                                                            ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                            ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_white"));
                                                                            ceVar2.fontWeight500();
                                                                            ceVar2.lines(1);
                                                                            ceVar2.textOverFlowTail();
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            if (QSearchListItemModel.this.desc.length() > 0) {
                                                                final QSearchListItemModel qSearchListItemModel6 = QSearchListItemModel.this;
                                                                cg.a(vVar10, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.3.3.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final QSearchListItemModel qSearchListItemModel7 = QSearchListItemModel.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.3.3.3.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                ceVar2.marginTop(4.0f);
                                                                                ceVar2.text(QSearchListItemModel.this.desc);
                                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_white"));
                                                                                ceVar2.fontWeight500();
                                                                                ceVar2.lines(1);
                                                                                ceVar2.textOverFlowTail();
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
                                                    final QSearchButtonInfo qSearchButtonInfo = QSearchListItemModel.this.button;
                                                    if (qSearchButtonInfo != null) {
                                                        final QSearchBannerTemplateView qSearchBannerTemplateView8 = qSearchBannerTemplateView7;
                                                        QSearchBlueButtonViewKt.QSearchBlueButton(vVar8, new Function1<QSearchBlueButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.3.4
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(QSearchBlueButtonView qSearchBlueButtonView) {
                                                                QSearchBlueButtonView qSearchBlueButtonView2 = qSearchBlueButtonView;
                                                                final QSearchButtonInfo qSearchButtonInfo2 = QSearchButtonInfo.this;
                                                                final QSearchBannerTemplateView qSearchBannerTemplateView9 = qSearchBannerTemplateView8;
                                                                qSearchBlueButtonView2.attr(new Function1<QSearchBlueButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.3.4.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(QSearchBlueButtonAttr qSearchBlueButtonAttr) {
                                                                        QSearchBlueButtonAttr qSearchBlueButtonAttr2 = qSearchBlueButtonAttr;
                                                                        qSearchBlueButtonAttr2.text = QSearchButtonInfo.this.text;
                                                                        qSearchBlueButtonAttr2.marginLeft(12.0f);
                                                                        QSearchTemplateReportInfo qSearchTemplateReportInfo = QSearchButtonInfo.this.reportInfo;
                                                                        if (qSearchTemplateReportInfo != null) {
                                                                            EcommerceExtKt.vr$default(qSearchBlueButtonAttr2, null, qSearchTemplateReportInfo.eid, qSearchTemplateReportInfo.getReportParams(qSearchBannerTemplateView9.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo.hashCode()), true, 9);
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final QSearchBannerTemplateView qSearchBannerTemplateView10 = qSearchBannerTemplateView8;
                                                                final QSearchButtonInfo qSearchButtonInfo3 = QSearchButtonInfo.this;
                                                                qSearchBlueButtonView2.event(new Function1<QSearchBlueButtonEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.3.4.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(QSearchBlueButtonEvent qSearchBlueButtonEvent) {
                                                                        final QSearchBannerTemplateView qSearchBannerTemplateView11 = QSearchBannerTemplateView.this;
                                                                        final QSearchButtonInfo qSearchButtonInfo4 = qSearchButtonInfo3;
                                                                        qSearchBlueButtonEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.2.3.4.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                QSearchBannerTemplateView.this.clickButton(qSearchButtonInfo4);
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
                                            });
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                if (!QSearchBannerTemplateView.access$getAttr(QSearchBannerTemplateView.this).getData().textLinkList.isEmpty()) {
                                    final QSearchBannerTemplateView qSearchBannerTemplateView5 = QSearchBannerTemplateView.this;
                                    w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.3
                                        {
                                            super(1);
                                        }

                                        /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchButtonInfo>, java.util.ArrayList] */
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar5) {
                                            v vVar6 = vVar5;
                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildContent.1.1.2.3.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.paddingTop(12.0f);
                                                    tVar2.flexDirectionRow();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            ?? r06 = QSearchBannerTemplateView.access$getAttr(QSearchBannerTemplateView.this).getData().textLinkList;
                                            final QSearchBannerTemplateView qSearchBannerTemplateView6 = QSearchBannerTemplateView.this;
                                            Iterator it = r06.iterator();
                                            int i3 = 0;
                                            while (it.hasNext()) {
                                                Object next = it.next();
                                                int i16 = i3 + 1;
                                                if (i3 < 0) {
                                                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                }
                                                final QSearchButtonInfo qSearchButtonInfo = (QSearchButtonInfo) next;
                                                final boolean z16 = i3 > 0;
                                                qSearchBannerTemplateView6.getClass();
                                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView$buildTextLinkItem$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                                        final boolean z17 = z16;
                                                        final QSearchButtonInfo qSearchButtonInfo2 = qSearchButtonInfo;
                                                        final QSearchBannerTemplateView qSearchBannerTemplateView7 = qSearchBannerTemplateView6;
                                                        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView$buildTextLinkItem$1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar7) {
                                                                v vVar8 = vVar7;
                                                                final QSearchButtonInfo qSearchButtonInfo3 = qSearchButtonInfo2;
                                                                final QSearchBannerTemplateView qSearchBannerTemplateView8 = qSearchBannerTemplateView7;
                                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildTextLinkItem.1.1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.m140flex(1.0f);
                                                                        tVar2.flexDirectionRow();
                                                                        tVar2.alignItemsCenter();
                                                                        QSearchTemplateReportInfo qSearchTemplateReportInfo = QSearchButtonInfo.this.reportInfo;
                                                                        if (qSearchTemplateReportInfo != null) {
                                                                            EcommerceExtKt.vr$default(tVar2, null, qSearchTemplateReportInfo.eid, qSearchTemplateReportInfo.getReportParams(qSearchBannerTemplateView8.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo.hashCode()), true, 9);
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final QSearchBannerTemplateView qSearchBannerTemplateView9 = qSearchBannerTemplateView7;
                                                                final QSearchButtonInfo qSearchButtonInfo4 = qSearchButtonInfo2;
                                                                vVar8.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildTextLinkItem.1.1.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(u uVar) {
                                                                        final QSearchBannerTemplateView qSearchBannerTemplateView10 = QSearchBannerTemplateView.this;
                                                                        final QSearchButtonInfo qSearchButtonInfo5 = qSearchButtonInfo4;
                                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildTextLinkItem.1.1.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                QSearchBannerTemplateView.this.clickButton(qSearchButtonInfo5);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                if (z17) {
                                                                    w.a(vVar8, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildTextLinkItem.1.1.3
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(v vVar9) {
                                                                            vVar9.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildTextLinkItem.1.1.3.1
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(t tVar) {
                                                                                    t tVar2 = tVar;
                                                                                    tVar2.mo153width(0.5f);
                                                                                    tVar2.mo141height(20.0f);
                                                                                    tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("border_standard"));
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                }
                                                                final QSearchButtonInfo qSearchButtonInfo5 = qSearchButtonInfo2;
                                                                cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildTextLinkItem.1.1.4
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final QSearchButtonInfo qSearchButtonInfo6 = QSearchButtonInfo.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBannerTemplateView.buildTextLinkItem.1.1.4.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                ceVar2.m140flex(1.0f);
                                                                                ceVar2.marginLeft(5.0f);
                                                                                ceVar2.marginRight(5.0f);
                                                                                ceVar2.textAlignCenter();
                                                                                ceVar2.text(QSearchButtonInfo.this.text);
                                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                                                ceVar2.lines(1);
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
                                                }.invoke(vVar6);
                                                i3 = i16;
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
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
        return new QSearchBannerAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchBannerEvent();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView
    public final float getPaddingHorizontal() {
        return isBannerImageFull() ? 0.0f : 16.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchButtonInfo>, java.util.ArrayList] */
    public final boolean isBannerImageFull() {
        QSearchTabContentViewModel qSearchTabContentViewModel;
        com.tencent.kuikly.core.reactive.collection.c<ISearchItemModel> dataList;
        com.tencent.kuikly.core.reactive.collection.c<ISearchItemModel> dataList2;
        int i3 = ((QSearchBannerAttr) getAttr()).index + 1;
        QSearchTabContentViewModel qSearchTabContentViewModel2 = ((QSearchBannerAttr) getAttr()).viewModel;
        ISearchItemModel iSearchItemModel = (i3 >= ((qSearchTabContentViewModel2 == null || (dataList2 = qSearchTabContentViewModel2.getDataList()) == null) ? 0 : dataList2.size()) - 1 || (qSearchTabContentViewModel = ((QSearchBannerAttr) getAttr()).viewModel) == null || (dataList = qSearchTabContentViewModel.getDataList()) == null) ? null : dataList.get(((QSearchBannerAttr) getAttr()).index);
        return !((((QSearchBannerAttr) getAttr()).index != 0 && (((QSearchBannerAttr) getAttr()).getData().layoutInfo.marginTop > 0.0f ? 1 : (((QSearchBannerAttr) getAttr()).getData().layoutInfo.marginTop == 0.0f ? 0 : -1)) == 0) || (!(iSearchItemModel == null || !(iSearchItemModel instanceof QSearchBaseTemplateModel)) && (((QSearchBaseTemplateModel) iSearchItemModel).layoutInfo.marginTop > 0.0f ? 1 : (((QSearchBaseTemplateModel) iSearchItemModel).layoutInfo.marginTop == 0.0f ? 0 : -1)) == 0)) && ((QSearchBannerAttr) getAttr()).getData().textLinkList.isEmpty();
    }
}

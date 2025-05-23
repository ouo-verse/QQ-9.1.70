package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.dialog;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchFileTemplateView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchReportView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.dialog.IDialogPager;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.dialog.QSearchBaseDialogAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.dialog.QSearchBaseDialogEvent;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.a;
import com.tencent.kuikly.core.views.compose.c;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class QSearchBaseDialogView<A extends QSearchBaseDialogAttr, E extends QSearchBaseDialogEvent> extends QSearchReportView<A, E> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchBaseDialogAttr access$getAttr(QSearchBaseDialogView qSearchBaseDialogView) {
        return (QSearchBaseDialogAttr) qSearchBaseDialogView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.dialog.QSearchBaseDialogView$body$1
            public final /* synthetic */ QSearchBaseDialogView<A, E> $ctx;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$ctx = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.dialog.QSearchBaseDialogView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.absolutePositionAllZero();
                        mVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("overlay_dark"));
                        return Unit.INSTANCE;
                    }
                });
                if (QSearchBaseDialogView.access$getAttr(this.$ctx).enableClickMask) {
                    final QSearchBaseDialogView<A, E> qSearchBaseDialogView = this.$ctx;
                    viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.dialog.QSearchBaseDialogView$body$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Event event) {
                            final QSearchBaseDialogView<QSearchBaseDialogAttr, QSearchBaseDialogEvent> qSearchBaseDialogView2 = qSearchBaseDialogView;
                            event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.dialog.QSearchBaseDialogView.body.1.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ClickParams clickParams) {
                                    QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView = (QSearchFileAddTroopPanelView) qSearchBaseDialogView2;
                                    qSearchFileAddTroopPanelView.animated$delegate.setValue(qSearchFileAddTroopPanelView, QSearchFileAddTroopPanelView.$$delegatedProperties[0], Boolean.FALSE);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                final QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView = (QSearchFileAddTroopPanelView) this.$ctx;
                qSearchFileAddTroopPanelView.getClass();
                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView$buildContent$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                        ViewContainer<?, ?> viewContainer4 = viewContainer3;
                        viewContainer4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView$buildContent$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(m mVar) {
                                m mVar2 = mVar;
                                mVar2.flexDirectionColumn();
                                mVar2.justifyContentFlexEnd();
                                return Unit.INSTANCE;
                            }
                        });
                        final QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView2 = QSearchFileAddTroopPanelView.this;
                        w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView$buildContent$1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView3 = QSearchFileAddTroopPanelView.this;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height((FontModuleExtKt.qqFontScaleAddSize(17.0f) * 2) + FontModuleExtKt.qqFontScaleAddSize(16.0f) + 250.0f);
                                        tVar2.flexDirectionColumn();
                                        tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("fill_light_secondary"));
                                        tVar2.m137borderRadius(new f(16.0f, 16.0f, 0.0f, 0.0f));
                                        if (QSearchFileAddTroopPanelView.access$getAnimated(QSearchFileAddTroopPanelView.this)) {
                                            tVar2.transform(new y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
                                        } else {
                                            tVar2.transform(new y(0.0f, 1.0f, 0.0f, 0.0f, 12, null));
                                        }
                                        tVar2.m134animation(b.Companion.n(b.INSTANCE, 0.4f, 0.92f, 1.0f, null, 8, null), (Object) Boolean.valueOf(QSearchFileAddTroopPanelView.access$getAnimated(QSearchFileAddTroopPanelView.this)));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView4 = QSearchFileAddTroopPanelView.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        u uVar2 = uVar;
                                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView5 = QSearchFileAddTroopPanelView.this;
                                        uVar2.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                                if (!QSearchFileAddTroopPanelView.access$getAnimated(QSearchFileAddTroopPanelView.this)) {
                                                    com.tencent.kuikly.core.pager.b pager = QSearchFileAddTroopPanelView.this.getPager();
                                                    IDialogPager iDialogPager = pager instanceof IDialogPager ? (IDialogPager) pager : null;
                                                    if (iDialogPager != null) {
                                                        iDialogPager.setDialogBuilder(null);
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView5 = QSearchFileAddTroopPanelView.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.marginTop(32.0f);
                                                tVar2.marginBottom(16.0f);
                                                tVar2.marginLeft(16.0f);
                                                tVar2.marginRight(16.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.3.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.3.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.m140flex(1.0f);
                                                        ceVar2.text("\u8bf7\u5148\u52a0\u7fa4\u518d\u67e5\u770b\u6587\u4ef6");
                                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                        ceVar2.fontWeight500();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView6 = QSearchFileAddTroopPanelView.this;
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                ImageView imageView2 = imageView;
                                                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.3.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        String sb5;
                                                        af afVar2 = afVar;
                                                        afVar2.size(20.0f, 20.0f);
                                                        StringBuilder sb6 = new StringBuilder();
                                                        sb6.append("qui_image://");
                                                        sb6.append("close");
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
                                                final QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView7 = QSearchFileAddTroopPanelView.this;
                                                imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.3.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageEvent imageEvent) {
                                                        final QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView8 = QSearchFileAddTroopPanelView.this;
                                                        imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.3.3.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView9 = QSearchFileAddTroopPanelView.this;
                                                                qSearchFileAddTroopPanelView9.animated$delegate.setValue(qSearchFileAddTroopPanelView9, QSearchFileAddTroopPanelView.$$delegatedProperties[0], Boolean.FALSE);
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
                                final QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView6 = QSearchFileAddTroopPanelView.this;
                                vVar2.addChild(new QSearchFileTemplateView(), new Function1<QSearchFileTemplateView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QSearchFileTemplateView qSearchFileTemplateView) {
                                        final QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView7 = QSearchFileAddTroopPanelView.this;
                                        qSearchFileTemplateView.attr(new Function1<QSearchFileAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchFileAttr qSearchFileAttr) {
                                                QSearchFileAttr qSearchFileAttr2 = qSearchFileAttr;
                                                qSearchFileAttr2.data = QSearchFileAddTroopPanelView.access$getAttr(QSearchFileAddTroopPanelView.this).fileTemplateModel;
                                                qSearchFileAttr2.isOnFileAddTroopPanel = true;
                                                qSearchFileAttr2.tabData = QSearchFileAddTroopPanelView.access$getAttr(QSearchFileAddTroopPanelView.this).tabData;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView7 = QSearchFileAddTroopPanelView.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.5.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.marginTop(32.0f);
                                                tVar2.alignItemsCenter();
                                                tVar2.justifyContentCenter();
                                                tVar2.flexDirectionRow();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView8 = QSearchFileAddTroopPanelView.this;
                                        c.a(vVar4, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.5.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ButtonView buttonView) {
                                                ButtonView buttonView2 = buttonView;
                                                final QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView9 = QSearchFileAddTroopPanelView.this;
                                                buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.5.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(a aVar) {
                                                        a aVar2 = aVar;
                                                        aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.5.2.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text("\u7533\u8bf7\u52a0\u7fa4");
                                                                ceVar2.fontWeight500();
                                                                ceVar2.color(h.INSTANCE.m());
                                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        aVar2.m140flex(1.0f);
                                                        c.a.a(aVar2, 0.0f, 52.0f, 0.0f, 52.0f, 5, null);
                                                        aVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(17.0f) + 45.0f);
                                                        aVar2.borderRadius(4.0f);
                                                        QUISkinColor qUISkinColor = QUISkinColor.INSTANCE;
                                                        aVar2.mo113backgroundColor(QUIToken.color$default("brand_standard"));
                                                        EcommerceExtKt.vr$default(aVar2, null, "em_bas_search_apply_group_panel_join", QSearchFileAddTroopPanelView.access$getAttr(QSearchFileAddTroopPanelView.this).fileTemplateReportParams, null, null, true, 25);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView10 = QSearchFileAddTroopPanelView.this;
                                                buttonView2.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.5.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(com.tencent.kuikly.core.views.compose.b bVar) {
                                                        final QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView11 = QSearchFileAddTroopPanelView.this;
                                                        bVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchFileAddTroopPanelView.buildContent.1.2.5.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                QSearchFileAddTroopPanelView.access$joinTroop(QSearchFileAddTroopPanelView.this);
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
                }.invoke(viewContainer2);
                return Unit.INSTANCE;
            }
        };
    }
}

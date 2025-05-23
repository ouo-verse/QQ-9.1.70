package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
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
import com.tencent.ttpic.openapi.filter.LightConstants;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchSingleTagView extends ComposeView<QSearchSingleTagAttr, QSearchSingleTagEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchSingleTagAttr access$getAttr(QSearchSingleTagView qSearchSingleTagView) {
        return (QSearchSingleTagAttr) qSearchSingleTagView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchSingleTagView qSearchSingleTagView = QSearchSingleTagView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        Function1<ViewContainer<?, ?>, Unit> function1;
                        v vVar2 = vVar;
                        final QSearchSingleTagView qSearchSingleTagView2 = QSearchSingleTagView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(10.0f) + 18.0f);
                                if (QSearchSingleTagView.access$getAttr(QSearchSingleTagView.this).getMaxWidth() > 0.0f) {
                                    tVar2.mo153width(QSearchSingleTagView.access$getAttr(QSearchSingleTagView.this).getMaxWidth());
                                }
                                tVar2.paddingLeft(6.0f);
                                tVar2.paddingRight(6.0f);
                                tVar2.marginRight(6.0f);
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                tVar2.mo113backgroundColor(QSearchSingleTagView.access$getAttr(QSearchSingleTagView.this).getLabel().bgColor);
                                tVar2.borderRadius(4.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        int i3 = QSearchSingleTagView.access$getAttr(QSearchSingleTagView.this).getLabel().type;
                        if (i3 == -1) {
                            final SearchNetLabel label = QSearchSingleTagView.access$getAttr(QSearchSingleTagView.this).getLabel();
                            function1 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView$buildContactLabel$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                    ViewContainer<?, ?> viewContainer3 = viewContainer2;
                                    final SearchNetLabel searchNetLabel = SearchNetLabel.this;
                                    ah.a(viewContainer3, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView$buildContactLabel$1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            final SearchNetLabel searchNetLabel2 = SearchNetLabel.this;
                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView.buildContactLabel.1.1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    String sb5;
                                                    af afVar2 = afVar;
                                                    afVar2.size(10.0f, 10.0f);
                                                    if (SearchNetLabel.this.gender == 1) {
                                                        String m3 = QUISkinImage$$ExternalSyntheticOutline0.m("qui_image://", LightConstants.MALE, "?color=", "4278229503");
                                                        if (SkinColor.INSTANCE.isNightMode(BridgeManager.f117344a.u())) {
                                                            StringBuilder m16 = HotViewKt$$ExternalSyntheticOutline0.m(m3, "&image_unique_id=");
                                                            m16.append(SkinColor.colorUniqueID);
                                                            sb5 = m16.toString();
                                                        } else {
                                                            StringBuilder m17 = HotViewKt$$ExternalSyntheticOutline0.m(m3, "&image_unique_id=");
                                                            m17.append(SkinColor.colorUniqueID);
                                                            sb5 = m17.toString();
                                                        }
                                                    } else {
                                                        String m18 = QUISkinImage$$ExternalSyntheticOutline0.m("qui_image://", LightConstants.FEMALE, "?color=", "4294724004");
                                                        if (SkinColor.INSTANCE.isNightMode(BridgeManager.f117344a.u())) {
                                                            StringBuilder m19 = HotViewKt$$ExternalSyntheticOutline0.m(m18, "&image_unique_id=");
                                                            m19.append(SkinColor.colorUniqueID);
                                                            sb5 = m19.toString();
                                                        } else {
                                                            StringBuilder m26 = HotViewKt$$ExternalSyntheticOutline0.m(m18, "&image_unique_id=");
                                                            m26.append(SkinColor.colorUniqueID);
                                                            sb5 = m26.toString();
                                                        }
                                                    }
                                                    b.a.b(afVar2, sb5, false, 2, null);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final SearchNetLabel searchNetLabel2 = SearchNetLabel.this;
                                    cg.a(viewContainer3, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView$buildContactLabel$1.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final SearchNetLabel searchNetLabel3 = SearchNetLabel.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView.buildContactLabel.1.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.marginLeft(2.0f);
                                                    ceVar2.text(SearchNetLabel.this.text);
                                                    ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                    ceVar2.fontWeight400();
                                                    ceVar2.color(SearchNetLabel.this.textColor);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            };
                        } else if (i3 == 1) {
                            final SearchNetLabel label2 = QSearchSingleTagView.access$getAttr(QSearchSingleTagView.this).getLabel();
                            function1 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView$buildTroopMemberCountLabel$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                    ViewContainer<?, ?> viewContainer3 = viewContainer2;
                                    ah.a(viewContainer3, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView$buildTroopMemberCountLabel$1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView.buildTroopMemberCountLabel.1.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    String sb5;
                                                    af afVar2 = afVar;
                                                    afVar2.size(10.0f, 10.0f);
                                                    StringBuilder sb6 = new StringBuilder();
                                                    sb6.append("qui_image://");
                                                    sb6.append(QCircleAlphaUserReporter.KEY_USER);
                                                    String m3 = OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(sb6, "?color=", "text_secondary");
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
                                    final SearchNetLabel searchNetLabel = SearchNetLabel.this;
                                    cg.a(viewContainer3, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView$buildTroopMemberCountLabel$1.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final SearchNetLabel searchNetLabel2 = SearchNetLabel.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView.buildTroopMemberCountLabel.1.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.marginLeft(2.0f);
                                                    ceVar2.text(SearchNetLabel.this.text);
                                                    ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                    ceVar2.fontWeight400();
                                                    ceVar2.color(SearchNetLabel.this.textColor);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            };
                        } else if (i3 != 4) {
                            final QSearchSingleTagView qSearchSingleTagView3 = QSearchSingleTagView.this;
                            final SearchNetLabel label3 = QSearchSingleTagView.access$getAttr(qSearchSingleTagView3).getLabel();
                            function1 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView$buildCommonLabel$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                    final QSearchSingleTagView qSearchSingleTagView4 = QSearchSingleTagView.this;
                                    final SearchNetLabel searchNetLabel = label3;
                                    cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView$buildCommonLabel$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final QSearchSingleTagView qSearchSingleTagView5 = QSearchSingleTagView.this;
                                            final SearchNetLabel searchNetLabel2 = searchNetLabel;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView.buildCommonLabel.1.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    if (QSearchSingleTagView.access$getAttr(QSearchSingleTagView.this).getMaxWidth() > 0.0f) {
                                                        ceVar2.mo153width(QSearchSingleTagView.access$getAttr(QSearchSingleTagView.this).getMaxWidth() - 12.0f);
                                                    }
                                                    ceVar2.text(searchNetLabel2.text);
                                                    ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                    ceVar2.fontWeight400();
                                                    ceVar2.color(searchNetLabel2.textColor);
                                                    ceVar2.textOverFlowTail();
                                                    ceVar2.lines(1);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            final QSearchSingleTagView qSearchSingleTagView4 = QSearchSingleTagView.this;
                            final SearchNetLabel label4 = QSearchSingleTagView.access$getAttr(qSearchSingleTagView4).getLabel();
                            function1 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView$buildTemplateLabel$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                    ViewContainer<?, ?> viewContainer3 = viewContainer2;
                                    final Ref.FloatRef floatRef = new Ref.FloatRef();
                                    if (SearchNetLabel.this.icon.length() > 0) {
                                        final SearchNetLabel searchNetLabel = SearchNetLabel.this;
                                        ah.a(viewContainer3, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView$buildTemplateLabel$1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final SearchNetLabel searchNetLabel2 = SearchNetLabel.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView.buildTemplateLabel.1.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.marginRight(2.0f);
                                                        afVar2.size(10.0f, 10.0f);
                                                        b.a.b(afVar2, SearchNetLabel.this.icon, false, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        floatRef.element = 12.0f;
                                    }
                                    final QSearchSingleTagView qSearchSingleTagView5 = qSearchSingleTagView4;
                                    final SearchNetLabel searchNetLabel2 = SearchNetLabel.this;
                                    cg.a(viewContainer3, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView$buildTemplateLabel$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final QSearchSingleTagView qSearchSingleTagView6 = QSearchSingleTagView.this;
                                            final Ref.FloatRef floatRef2 = floatRef;
                                            final SearchNetLabel searchNetLabel3 = searchNetLabel2;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchSingleTagView.buildTemplateLabel.1.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    if (QSearchSingleTagView.access$getAttr(QSearchSingleTagView.this).getMaxWidth() > 0.0f) {
                                                        ceVar2.mo153width((QSearchSingleTagView.access$getAttr(QSearchSingleTagView.this).getMaxWidth() - 12.0f) - floatRef2.element);
                                                    }
                                                    ceVar2.text(searchNetLabel3.text);
                                                    ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                    ceVar2.fontWeight400();
                                                    ceVar2.color(searchNetLabel3.textColor);
                                                    ceVar2.textOverFlowTail();
                                                    ceVar2.lines(1);
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
                        function1.invoke(vVar2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchSingleTagAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchSingleTagEvent();
    }
}

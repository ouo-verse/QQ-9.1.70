package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchJump;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchText;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchButtonInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchGameAppInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchGameTemplateModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchBlueButtonAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchBlueButtonEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchBlueButtonView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchBlueButtonViewKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGameButtonAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchGameButtonView;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
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
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchGameTemplateView extends QSearchBaseTemplateView<QSearchGameTemplateModel, QSearchGameTemplateAttr, QSearchGameTemplateEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchGameTemplateView.class, "isExpanded", "isExpanded()Z", 0)};
    public final ReadWriteProperty isExpanded$delegate = c.a(Boolean.FALSE);

    public static final Function1 access$buildIconRow(QSearchGameTemplateView qSearchGameTemplateView, List list, boolean z16) {
        qSearchGameTemplateView.getClass();
        return new QSearchGameTemplateView$buildIconRow$1(list, qSearchGameTemplateView, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchIconModel>, java.util.ArrayList] */
    public static final Function1 access$buildIcons(final QSearchGameTemplateView qSearchGameTemplateView) {
        if (((QSearchGameTemplateAttr) qSearchGameTemplateView.getAttr()).getData().iconList.isEmpty()) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildIcons$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                    return Unit.INSTANCE;
                }
            };
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildIcons$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchGameTemplateView qSearchGameTemplateView2 = QSearchGameTemplateView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildIcons$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        List take;
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildIcons.2.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.paddingTop(8.0f);
                                tVar2.paddingBottom(12.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final ArrayList arrayList = new ArrayList();
                        arrayList.addAll(QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().iconList);
                        if (arrayList.size() > 4) {
                            take = CollectionsKt___CollectionsKt.take(arrayList, 4);
                            ((QSearchGameTemplateView$buildIconRow$1) QSearchGameTemplateView.access$buildIconRow(QSearchGameTemplateView.this, take, true)).invoke(vVar2);
                            arrayList.removeAll(take);
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildIcons.2.1.2
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildIcons.2.1.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            tVar.mo141height(16.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            final QSearchGameTemplateView qSearchGameTemplateView3 = QSearchGameTemplateView.this;
                            Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildIcons.2.1.3
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    boolean booleanValue;
                                    booleanValue = ((Boolean) r0.isExpanded$delegate.getValue(QSearchGameTemplateView.this, QSearchGameTemplateView.$$delegatedProperties[0])).booleanValue();
                                    return Boolean.valueOf(booleanValue);
                                }
                            };
                            final QSearchGameTemplateView qSearchGameTemplateView4 = QSearchGameTemplateView.this;
                            ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildIcons.2.1.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ConditionView conditionView) {
                                    List windowed;
                                    ConditionView conditionView2 = conditionView;
                                    windowed = CollectionsKt___CollectionsKt.windowed(arrayList, 4, 4, true);
                                    QSearchGameTemplateView qSearchGameTemplateView5 = qSearchGameTemplateView4;
                                    Iterator it = windowed.iterator();
                                    while (it.hasNext()) {
                                        ((QSearchGameTemplateView$buildIconRow$1) QSearchGameTemplateView.access$buildIconRow(qSearchGameTemplateView5, (List) it.next(), true)).invoke(conditionView2);
                                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildIcons$2$1$4$1$1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildIcons$2$1$4$1$1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        tVar.mo141height(16.0f);
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
                            final QSearchGameTemplateView qSearchGameTemplateView5 = QSearchGameTemplateView.this;
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildIcons.2.1.5
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    v vVar4 = vVar3;
                                    final QSearchGameTemplateView qSearchGameTemplateView6 = QSearchGameTemplateView.this;
                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildIcons.2.1.5.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.flexDirectionRow();
                                            tVar2.allCenter();
                                            tVar2.mo141height(FontModuleExtKt.qqFontScaleAddSize(14.0f) + 24.0f);
                                            QSearchTemplateReportInfo qSearchTemplateReportInfo = QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().expandReportInfo;
                                            if (qSearchTemplateReportInfo != null) {
                                                EcommerceExtKt.vr$default(tVar2, null, qSearchTemplateReportInfo.eid, qSearchTemplateReportInfo.getReportParams(QSearchGameTemplateView.this.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo.hashCode()), true, 9);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final QSearchGameTemplateView qSearchGameTemplateView7 = QSearchGameTemplateView.this;
                                    vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildIcons.2.1.5.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(u uVar) {
                                            final QSearchGameTemplateView qSearchGameTemplateView8 = QSearchGameTemplateView.this;
                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildIcons.2.1.5.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    boolean booleanValue;
                                                    QSearchGameTemplateView qSearchGameTemplateView9 = QSearchGameTemplateView.this;
                                                    booleanValue = ((Boolean) qSearchGameTemplateView9.isExpanded$delegate.getValue(qSearchGameTemplateView9, QSearchGameTemplateView.$$delegatedProperties[0])).booleanValue();
                                                    qSearchGameTemplateView9.isExpanded$delegate.setValue(qSearchGameTemplateView9, QSearchGameTemplateView.$$delegatedProperties[0], Boolean.valueOf(!booleanValue));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final QSearchGameTemplateView qSearchGameTemplateView8 = QSearchGameTemplateView.this;
                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildIcons.2.1.5.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final QSearchGameTemplateView qSearchGameTemplateView9 = QSearchGameTemplateView.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildIcons.2.1.5.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    boolean booleanValue;
                                                    String str;
                                                    ce ceVar2 = ceVar;
                                                    booleanValue = ((Boolean) r0.isExpanded$delegate.getValue(QSearchGameTemplateView.this, QSearchGameTemplateView.$$delegatedProperties[0])).booleanValue();
                                                    if (booleanValue) {
                                                        str = "\u6536\u8d77";
                                                    } else {
                                                        str = "\u67e5\u770b\u66f4\u591a";
                                                    }
                                                    ceVar2.text(str);
                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                    ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final QSearchGameTemplateView qSearchGameTemplateView9 = QSearchGameTemplateView.this;
                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildIcons.2.1.5.4
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            final QSearchGameTemplateView qSearchGameTemplateView10 = QSearchGameTemplateView.this;
                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildIcons.2.1.5.4.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    boolean booleanValue;
                                                    String sb5;
                                                    af afVar2 = afVar;
                                                    afVar2.size(16.0f, 16.0f);
                                                    afVar2.marginLeft(2.0f);
                                                    booleanValue = ((Boolean) r0.isExpanded$delegate.getValue(QSearchGameTemplateView.this, QSearchGameTemplateView.$$delegatedProperties[0])).booleanValue();
                                                    if (booleanValue) {
                                                        String m3 = QUISkinImage$$ExternalSyntheticOutline0.m("qui_image://", "chevron_up", "?color=", "icon_secondary");
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
                                                        String m18 = QUISkinImage$$ExternalSyntheticOutline0.m("qui_image://", "chevron_down", "?color=", "icon_secondary");
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
                                    return Unit.INSTANCE;
                                }
                            });
                        } else {
                            ((QSearchGameTemplateView$buildIconRow$1) QSearchGameTemplateView.access$buildIconRow(QSearchGameTemplateView.this, arrayList, false)).invoke(vVar2);
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchGameTemplateAttr access$getAttr(QSearchGameTemplateView qSearchGameTemplateView) {
        return (QSearchGameTemplateAttr) qSearchGameTemplateView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView
    public final Function1<ViewContainer<?, ?>, Unit> buildContent() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildContent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchGameTemplateView qSearchGameTemplateView = QSearchGameTemplateView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildContent$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final QSearchGameTemplateView qSearchGameTemplateView2 = QSearchGameTemplateView.this;
                        w.a(vVar, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildContent.1.1.1
                            {
                                super(1);
                            }

                            /* JADX WARN: Type inference failed for: r0v18, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchIconModel>, java.util.ArrayList] */
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar2) {
                                final String str;
                                v vVar3 = vVar2;
                                if (QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().layoutInfo.showDivider) {
                                    w.a(vVar3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildContent.1.1.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar4) {
                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildContent.1.1.1.1.1
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
                                final QSearchGameTemplateView qSearchGameTemplateView3 = QSearchGameTemplateView.this;
                                qSearchGameTemplateView3.getClass();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildHeader$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                        final QSearchGameTemplateView qSearchGameTemplateView4 = QSearchGameTemplateView.this;
                                        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildHeader$1.1
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Type inference failed for: r0v11, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar4) {
                                                v vVar5 = vVar4;
                                                vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.paddingTop(12.0f);
                                                        tVar2.paddingBottom(8.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final String str2 = QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().topIcon;
                                                if (str2.length() > 0) {
                                                    w.a(vVar5, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar6) {
                                                            v vVar7 = vVar6;
                                                            vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.2.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    tVar.padding(4.0f);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final String str3 = str2;
                                                            ah.a(vVar7, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.2.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ImageView imageView) {
                                                                    ImageView imageView2 = imageView;
                                                                    final String str4 = str3;
                                                                    final float f16 = 12.0f;
                                                                    imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.2.2.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(af afVar) {
                                                                            af afVar2 = afVar;
                                                                            afVar2.mo153width(48.0f);
                                                                            afVar2.mo141height(f16);
                                                                            b.a.b(afVar2, str4, false, 2, null);
                                                                            afVar2.q();
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.2.2.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ImageEvent imageEvent) {
                                                                            final ImageEvent imageEvent2 = imageEvent;
                                                                            final float f17 = f16;
                                                                            imageEvent2.i(new Function1<LoadResolutionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.2.2.2.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                /* JADX WARN: Type inference failed for: r3v7, types: [com.tencent.kuikly.core.base.Attr] */
                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(LoadResolutionParams loadResolutionParams) {
                                                                                    ?? viewAttr;
                                                                                    LoadResolutionParams loadResolutionParams2 = loadResolutionParams;
                                                                                    if (loadResolutionParams2.getWidth() > 0 && loadResolutionParams2.getHeight() > 0) {
                                                                                        float height = (f17 / loadResolutionParams2.getHeight()) * loadResolutionParams2.getWidth();
                                                                                        AbstractBaseView<?, ?> view = imageEvent2.getView();
                                                                                        if (view != null && (viewAttr = view.getViewAttr()) != 0) {
                                                                                            viewAttr.mo153width(height);
                                                                                        }
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
                                                }
                                                final QSearchGameTemplateView qSearchGameTemplateView5 = QSearchGameTemplateView.this;
                                                w.a(vVar5, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar6) {
                                                        v vVar7 = vVar6;
                                                        vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                tVar.flexDirectionRow();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QSearchGameTemplateView qSearchGameTemplateView6 = QSearchGameTemplateView.this;
                                                        w.a(vVar7, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.3.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar8) {
                                                                v vVar9 = vVar8;
                                                                vVar9.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.3.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.m140flex(1.0f);
                                                                        tVar2.marginRight(16.0f);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final QSearchGameTemplateView qSearchGameTemplateView7 = QSearchGameTemplateView.this;
                                                                cg.a(vVar9, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.3.2.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final QSearchGameTemplateView qSearchGameTemplateView8 = QSearchGameTemplateView.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.3.2.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                ceVar2.text(QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().title);
                                                                                ceVar2.lines(1);
                                                                                ceVar2.textOverFlowTail();
                                                                                ce.fontSize$default(ceVar2, 20.0f, null, 2, null);
                                                                                ceVar2.fontWeight500();
                                                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                if (QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().desc.length() > 0) {
                                                                    final QSearchGameTemplateView qSearchGameTemplateView8 = QSearchGameTemplateView.this;
                                                                    cg.a(vVar9, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.3.2.3
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(TextView textView) {
                                                                            final QSearchGameTemplateView qSearchGameTemplateView9 = QSearchGameTemplateView.this;
                                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.3.2.3.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ce ceVar) {
                                                                                    ce ceVar2 = ceVar;
                                                                                    ceVar2.marginTop(4.0f);
                                                                                    ceVar2.text(QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().desc);
                                                                                    ceVar2.lines(1);
                                                                                    ceVar2.textOverFlowTail();
                                                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                                    ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
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
                                                        final QSearchGameAppInfo qSearchGameAppInfo = QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().appInfo;
                                                        final QSearchButtonInfo qSearchButtonInfo = QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().button;
                                                        if (qSearchGameAppInfo != null) {
                                                            final e reportParams = QSearchGameTemplateView.this.getReportParams();
                                                            QSearchTemplateReportInfo qSearchTemplateReportInfo = qSearchGameAppInfo.reportInfo;
                                                            if (qSearchTemplateReportInfo != null) {
                                                                qSearchTemplateReportInfo.getReportParams(reportParams);
                                                            }
                                                            vVar7.addChild(new QSearchGameButtonView(), new Function1<QSearchGameButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.3.3
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(QSearchGameButtonView qSearchGameButtonView) {
                                                                    final QSearchGameAppInfo qSearchGameAppInfo2 = QSearchGameAppInfo.this;
                                                                    final e eVar = reportParams;
                                                                    qSearchGameButtonView.attr(new Function1<QSearchGameButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.3.3.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(QSearchGameButtonAttr qSearchGameButtonAttr) {
                                                                            QSearchGameButtonAttr qSearchGameButtonAttr2 = qSearchGameButtonAttr;
                                                                            qSearchGameButtonAttr2.size(60.0f, 29.0f);
                                                                            qSearchGameButtonAttr2.marginLeft(12.0f);
                                                                            QSearchGameAppInfo qSearchGameAppInfo3 = QSearchGameAppInfo.this;
                                                                            e eVar2 = eVar;
                                                                            e eVar3 = new e();
                                                                            eVar3.v("appId", qSearchGameAppInfo3.appId);
                                                                            eVar3.v("channelId", qSearchGameAppInfo3.channelId);
                                                                            eVar3.v(PushClientConstants.TAG_PKG_NAME, qSearchGameAppInfo3.pkgName);
                                                                            eVar3.v("name", qSearchGameAppInfo3.name);
                                                                            eVar3.v("icon", qSearchGameAppInfo3.icon);
                                                                            eVar3.v("url", qSearchGameAppInfo3.url);
                                                                            eVar3.v("appSize", qSearchGameAppInfo3.appSize);
                                                                            eVar3.v("businessChannel", qSearchGameAppInfo3.businessChannel);
                                                                            eVar3.v("reportData", eVar2);
                                                                            qSearchGameButtonAttr2.with("appInfo", eVar3.toString());
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        } else if (qSearchButtonInfo != null) {
                                                            final QSearchGameTemplateView qSearchGameTemplateView7 = QSearchGameTemplateView.this;
                                                            QSearchBlueButtonViewKt.QSearchBlueButton(vVar7, new Function1<QSearchBlueButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.3.4
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(QSearchBlueButtonView qSearchBlueButtonView) {
                                                                    QSearchBlueButtonView qSearchBlueButtonView2 = qSearchBlueButtonView;
                                                                    final QSearchButtonInfo qSearchButtonInfo2 = QSearchButtonInfo.this;
                                                                    final QSearchGameTemplateView qSearchGameTemplateView8 = qSearchGameTemplateView7;
                                                                    qSearchBlueButtonView2.attr(new Function1<QSearchBlueButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.3.4.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(QSearchBlueButtonAttr qSearchBlueButtonAttr) {
                                                                            QSearchBlueButtonAttr qSearchBlueButtonAttr2 = qSearchBlueButtonAttr;
                                                                            qSearchBlueButtonAttr2.text = QSearchButtonInfo.this.text;
                                                                            qSearchBlueButtonAttr2.marginLeft(12.0f);
                                                                            QSearchTemplateReportInfo qSearchTemplateReportInfo2 = QSearchButtonInfo.this.reportInfo;
                                                                            if (qSearchTemplateReportInfo2 != null) {
                                                                                EcommerceExtKt.vr$default(qSearchBlueButtonAttr2, null, qSearchTemplateReportInfo2.eid, qSearchTemplateReportInfo2.getReportParams(qSearchGameTemplateView8.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo2.hashCode()), true, 9);
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final QSearchGameTemplateView qSearchGameTemplateView9 = qSearchGameTemplateView7;
                                                                    final QSearchButtonInfo qSearchButtonInfo3 = QSearchButtonInfo.this;
                                                                    qSearchBlueButtonView2.event(new Function1<QSearchBlueButtonEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.3.4.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(QSearchBlueButtonEvent qSearchBlueButtonEvent) {
                                                                            final QSearchGameTemplateView qSearchGameTemplateView10 = QSearchGameTemplateView.this;
                                                                            final QSearchButtonInfo qSearchButtonInfo4 = qSearchButtonInfo3;
                                                                            qSearchBlueButtonEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.3.4.2.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ClickParams clickParams) {
                                                                                    QSearchGameTemplateView.this.clickButton(qSearchButtonInfo4);
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
                                                final boolean z16 = !QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().avatarList.isEmpty();
                                                final boolean z17 = QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().userDesc.length() > 0;
                                                if (z16 || z17) {
                                                    final QSearchGameTemplateView qSearchGameTemplateView6 = QSearchGameTemplateView.this;
                                                    w.a(vVar5, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.4
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar6) {
                                                            v vVar7 = vVar6;
                                                            vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.4.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.flexDirectionRow();
                                                                    tVar2.marginTop(4.0f);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            if (z16) {
                                                                final QSearchGameTemplateView qSearchGameTemplateView7 = qSearchGameTemplateView6;
                                                                w.a(vVar7, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.4.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar8) {
                                                                        List take;
                                                                        v vVar9 = vVar8;
                                                                        vVar9.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.4.2.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                tVar.flexDirectionRow();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        take = CollectionsKt___CollectionsKt.take(QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().avatarList, 3);
                                                                        final int i3 = 0;
                                                                        for (Object obj : take) {
                                                                            int i16 = i3 + 1;
                                                                            if (i3 < 0) {
                                                                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                                            }
                                                                            final String str3 = (String) obj;
                                                                            ah.a(vVar9, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildHeader$1$1$4$2$2$1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ImageView imageView) {
                                                                                    final String str4 = str3;
                                                                                    final int i17 = i3;
                                                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildHeader$1$1$4$2$2$1.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(af afVar) {
                                                                                            af afVar2 = afVar;
                                                                                            afVar2.mo153width(20.0f);
                                                                                            afVar2.mo141height(20.0f);
                                                                                            afVar2.borderRadius(10.0f);
                                                                                            afVar2.m136border(new com.tencent.kuikly.core.base.e(1.0f, BorderStyle.SOLID, h.INSTANCE.m()));
                                                                                            b.a.b(afVar2, str4, false, 2, null);
                                                                                            if (i17 != 0) {
                                                                                                afVar2.marginLeft(-12.0f);
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            i3 = i16;
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                            }
                                                            if (z17) {
                                                                final QSearchGameTemplateView qSearchGameTemplateView8 = qSearchGameTemplateView6;
                                                                cg.a(vVar7, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.4.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final QSearchGameTemplateView qSearchGameTemplateView9 = QSearchGameTemplateView.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildHeader.1.1.4.3.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                ceVar2.m140flex(1.0f);
                                                                                ceVar2.marginLeft(4.0f);
                                                                                ceVar2.text(QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().userDesc);
                                                                                ceVar2.lines(1);
                                                                                ceVar2.textOverFlowTail();
                                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                                ceVar2.fontWeight500();
                                                                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
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
                                        return Unit.INSTANCE;
                                    }
                                }.invoke(vVar3);
                                QSearchText qSearchText = QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().content;
                                if (qSearchText == null || (str = qSearchText.text) == null) {
                                    str = "";
                                }
                                if (str.length() > 0) {
                                    final QSearchGameTemplateView qSearchGameTemplateView4 = QSearchGameTemplateView.this;
                                    w.a(vVar3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildContent.1.1.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar4) {
                                            final QSearchJump qSearchJump;
                                            v vVar5 = vVar4;
                                            final QSearchGameTemplateView qSearchGameTemplateView5 = QSearchGameTemplateView.this;
                                            vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildContent.1.1.1.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    QSearchReportInfo qSearchReportInfo;
                                                    t tVar2 = tVar;
                                                    tVar2.paddingTop(8.0f);
                                                    tVar2.paddingBottom(8.0f);
                                                    QSearchText qSearchText2 = QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().content;
                                                    if (qSearchText2 != null && (qSearchReportInfo = qSearchText2.reportInfo) != null) {
                                                        EcommerceExtKt.vr$default(tVar2, null, qSearchReportInfo.eid, TemplateItemsKt.getReportParams(qSearchReportInfo, QSearchGameTemplateView.this.getTemplateCardReportInfo()), null, String.valueOf(qSearchReportInfo.hashCode()), true, 9);
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            QSearchText qSearchText2 = QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().content;
                                            if (qSearchText2 != null && (qSearchJump = qSearchText2.jumpLink) != null) {
                                                final QSearchGameTemplateView qSearchGameTemplateView6 = QSearchGameTemplateView.this;
                                                vVar5.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildContent$1$1$1$2$2$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final QSearchGameTemplateView qSearchGameTemplateView7 = QSearchGameTemplateView.this;
                                                        final QSearchJump qSearchJump2 = qSearchJump;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildContent$1$1$1$2$2$1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                QSearchGameTemplateView.this.doJump(qSearchJump2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                            }
                                            final String str2 = str;
                                            cg.a(vVar5, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildContent.1.1.1.2.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final String str3 = str2;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildContent.1.1.1.2.3.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.text(str3);
                                                            ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                            ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                            ceVar2.lines(4);
                                                            ceVar2.lineSpacing(2.0f);
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
                                }
                                if (!QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().iconList.isEmpty()) {
                                    QSearchGameTemplateView.access$buildIcons(QSearchGameTemplateView.this).invoke(vVar3);
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

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView
    public final Function1<ViewContainer<?, ?>, Unit> buildOverlay() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildOverlay$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                if (QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().background.length() > 0) {
                    final QSearchGameTemplateView qSearchGameTemplateView = QSearchGameTemplateView.this;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildOverlay$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            final QSearchGameTemplateView qSearchGameTemplateView2 = QSearchGameTemplateView.this;
                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildOverlay.1.1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    tVar.mo141height(100.0f - QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().layoutInfo.marginTop);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    final QSearchGameTemplateView qSearchGameTemplateView2 = QSearchGameTemplateView.this;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView$buildOverlay$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            final QSearchGameTemplateView qSearchGameTemplateView3 = QSearchGameTemplateView.this;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildOverlay.1.2.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    Attr.absolutePosition$default(tVar, QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().layoutInfo.marginTop, 0.0f, 0.0f, 0.0f, 4, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            final QSearchGameTemplateView qSearchGameTemplateView4 = QSearchGameTemplateView.this;
                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildOverlay.1.2.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageView imageView) {
                                    final QSearchGameTemplateView qSearchGameTemplateView5 = QSearchGameTemplateView.this;
                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildOverlay.1.2.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(af afVar) {
                                            af afVar2 = afVar;
                                            b.a.b(afVar2, QSearchGameTemplateView.access$getAttr(QSearchGameTemplateView.this).getData().background, false, 2, null);
                                            afVar2.mo141height(169.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildOverlay.1.2.3
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchGameTemplateView.buildOverlay.1.2.3.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 1, null);
                                            tVar2.mo141height(36.0f);
                                            tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(h.INSTANCE.j(), 0.0f), new j(QUISkinColor.INSTANCE.wrapColor("bg_bottom_standard"), 1.0f));
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchGameTemplateAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchGameTemplateEvent();
    }
}

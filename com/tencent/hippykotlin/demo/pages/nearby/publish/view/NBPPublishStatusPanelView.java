package com.tencent.hippykotlin.demo.pages.nearby.publish.view;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishCategoryData;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishStatusData;
import com.tencent.hippykotlin.demo.pages.nearby.publish.NBPPublishViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.PageListEvent;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.be;
import com.tencent.kuikly.core.views.bf;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.ck;
import com.tencent.kuikly.core.views.cm;
import com.tencent.kuikly.core.views.cn;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPPublishStatusPanelView extends ComposeView<NBPPublishStatusPanelAttr, NBPPublishStatusPanelEvent> {
    public aa<PageListView<?, ?>> categoryPageListRef;

    public static final void access$customDtReportCategoryTab(NBPPublishStatusPanelView nBPPublishStatusPanelView, String str, String str2) {
        nBPPublishStatusPanelView.getClass();
        e eVar = new e();
        eVar.v("nearby_tab_type", str);
        eVar.v("nearby_event_type", str2);
        eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("ev_nearby_status_choose_tab", eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPPublishStatusPanelAttr access$getAttr(NBPPublishStatusPanelView nBPPublishStatusPanelView) {
        return (NBPPublishStatusPanelAttr) nBPPublishStatusPanelView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(mVar2.getPager().getPageData().m(), 284.0f);
                        mVar2.mo113backgroundColor(h.INSTANCE.m());
                        mVar2.m137borderRadius(new f(8.0f, 8.0f, 0.0f, 0.0f));
                        mVar2.mo139boxShadow(new g(0.0f, 4.0f, 4.0f, new h(0L, 0.08f)));
                        mVar2.flexDirectionColumn();
                        mVar2.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(tVar2.getPagerData().m(), 14.0f);
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(36.0f, 5.0f);
                                        tVar2.borderRadius(3.0f);
                                        tVar2.mo113backgroundColor(new h(4291611852L));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPPublishStatusPanelView nBPPublishStatusPanelView = NBPPublishStatusPanelView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NBPPublishStatusPanelView.access$getAttr(NBPPublishStatusPanelView.this).getViewModel().getStatusCategoryList();
                    }
                };
                final NBPPublishStatusPanelView nBPPublishStatusPanelView2 = NBPPublishStatusPanelView.this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                        final NBPPublishStatusPanelView nBPPublishStatusPanelView3 = NBPPublishStatusPanelView.this;
                        w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.4.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(tVar2.getPager().getPageData().m(), 56.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.justifyContentSpaceEvenly();
                                        tVar2.overflow(false);
                                        return Unit.INSTANCE;
                                    }
                                });
                                ArrayList<NBPPublishCategoryData> statusCategoryList = NBPPublishStatusPanelView.access$getAttr(NBPPublishStatusPanelView.this).getViewModel().getStatusCategoryList();
                                final NBPPublishStatusPanelView nBPPublishStatusPanelView4 = NBPPublishStatusPanelView.this;
                                final int i3 = 0;
                                for (Object obj : statusCategoryList) {
                                    int i16 = i3 + 1;
                                    if (i3 < 0) {
                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                    }
                                    final NBPPublishCategoryData nBPPublishCategoryData = (NBPPublishCategoryData) obj;
                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1$4$1$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            v vVar4 = vVar3;
                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1$4$1$2$1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.flexDirectionColumn();
                                                    tVar2.alignItemsCenter();
                                                    tVar2.size(56.0f, 56.0f);
                                                    tVar2.paddingTop(15.5f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPPublishCategoryData nBPPublishCategoryData2 = NBPPublishCategoryData.this;
                                            final int i17 = i3;
                                            final NBPPublishStatusPanelView nBPPublishStatusPanelView5 = nBPPublishStatusPanelView4;
                                            cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1$4$1$2$1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final NBPPublishCategoryData nBPPublishCategoryData3 = NBPPublishCategoryData.this;
                                                    final int i18 = i17;
                                                    final NBPPublishStatusPanelView nBPPublishStatusPanelView6 = nBPPublishStatusPanelView5;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.4.1.2.1.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.size(56.0f, 22.0f);
                                                            ceVar2.textAlignCenter();
                                                            ceVar2.text(NBPPublishCategoryData.this.name);
                                                            if (i18 == NBPPublishStatusPanelView.access$getAttr(nBPPublishStatusPanelView6).getViewModel().getStatusCategoryIndex()) {
                                                                ceVar2.color(new h(4278231039L));
                                                                ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                                ceVar2.fontWeight500();
                                                            } else {
                                                                ceVar2.color(new h(4279901214L));
                                                                ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                                ceVar2.fontWeight400();
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPPublishCategoryData nBPPublishCategoryData3 = NBPPublishCategoryData.this;
                                            ConditionViewKt.c(vVar4, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1$4$1$2$1.3
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    NBPPublishCategoryData nBPPublishCategoryData4 = NBPPublishCategoryData.this;
                                                    return Boolean.valueOf(((Boolean) nBPPublishCategoryData4.hasRedDot$delegate.getValue(nBPPublishCategoryData4, NBPPublishCategoryData.$$delegatedProperties[0])).booleanValue());
                                                }
                                            }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1$4$1$2$1.4
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ConditionView conditionView) {
                                                    w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.4.1.2.1.4.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar5) {
                                                            vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.4.1.2.1.4.1.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.size(8.0f, 8.0f);
                                                                    tVar2.borderRadius(4.0f);
                                                                    tVar2.mo113backgroundColor(h.INSTANCE.i());
                                                                    Attr.absolutePosition$default(tVar2, 6.0f, 0.0f, 0.0f, -8.0f, 6, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final int i18 = i3;
                                            final NBPPublishStatusPanelView nBPPublishStatusPanelView6 = nBPPublishStatusPanelView4;
                                            w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1$4$1$2$1.5
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar5) {
                                                    final int i19 = i18;
                                                    final NBPPublishStatusPanelView nBPPublishStatusPanelView7 = nBPPublishStatusPanelView6;
                                                    vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.4.1.2.1.5.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.size(32.0f, 2.0f);
                                                            tVar2.mo113backgroundColor(new h(4278231039L));
                                                            tVar2.marginTop(5.0f);
                                                            tVar2.m152visibility(i19 == NBPPublishStatusPanelView.access$getAttr(nBPPublishStatusPanelView7).getViewModel().getStatusCategoryIndex());
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPPublishStatusPanelView nBPPublishStatusPanelView7 = nBPPublishStatusPanelView4;
                                            final int i19 = i3;
                                            final NBPPublishCategoryData nBPPublishCategoryData4 = NBPPublishCategoryData.this;
                                            vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1$4$1$2$1.6
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(u uVar) {
                                                    u uVar2 = uVar;
                                                    final NBPPublishStatusPanelView nBPPublishStatusPanelView8 = NBPPublishStatusPanelView.this;
                                                    final int i26 = i19;
                                                    final NBPPublishCategoryData nBPPublishCategoryData5 = nBPPublishCategoryData4;
                                                    uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.4.1.2.1.6.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            PageListView<?, ?> b16;
                                                            aa<PageListView<?, ?>> aaVar = NBPPublishStatusPanelView.this.categoryPageListRef;
                                                            if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                                PageListView.scrollToPageIndex$default(b16, i26, false, 2, null);
                                                            }
                                                            NBPPublishStatusPanelView.access$customDtReportCategoryTab(NBPPublishStatusPanelView.this, nBPPublishCategoryData5.name, "clck");
                                                            NBPPublishStatusPanelView.access$getAttr(NBPPublishStatusPanelView.this).getViewModel().saveTitleRedDotStatusIdListStr(nBPPublishCategoryData5);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPPublishStatusPanelView nBPPublishStatusPanelView9 = NBPPublishStatusPanelView.this;
                                                    final NBPPublishCategoryData nBPPublishCategoryData6 = nBPPublishCategoryData4;
                                                    VisibilityEventKt.e(uVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.4.1.2.1.6.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(Object obj2) {
                                                            NBPPublishStatusPanelView.access$customDtReportCategoryTab(NBPPublishStatusPanelView.this, nBPPublishCategoryData6.name, "imp");
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
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
                        final NBPPublishStatusPanelView nBPPublishStatusPanelView4 = NBPPublishStatusPanelView.this;
                        bf.a(bindDirectivesView2, new Function1<PageListView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(PageListView<?, ?> pageListView) {
                                PageListView<?, ?> pageListView2 = pageListView;
                                final NBPPublishStatusPanelView nBPPublishStatusPanelView5 = NBPPublishStatusPanelView.this;
                                pageListView2.ref(pageListView2, new Function1<aa<PageListView<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<PageListView<?, ?>> aaVar) {
                                        NBPPublishStatusPanelView.this.categoryPageListRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPPublishStatusPanelView nBPPublishStatusPanelView6 = NBPPublishStatusPanelView.this;
                                pageListView2.attr(new Function1<be, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.4.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(be beVar) {
                                        be beVar2 = beVar;
                                        beVar2.pageDirection(true);
                                        beVar2.pageItemWidth(beVar2.getPagerData().m());
                                        beVar2.pageItemHeight(214.0f);
                                        beVar2.showScrollerIndicator(false);
                                        beVar2.defaultPageIndex(NBPPublishStatusPanelView.access$getAttr(NBPPublishStatusPanelView.this).getViewModel().getStatusCategoryIndex());
                                        return Unit.INSTANCE;
                                    }
                                });
                                ArrayList<NBPPublishCategoryData> statusCategoryList = NBPPublishStatusPanelView.access$getAttr(NBPPublishStatusPanelView.this).getViewModel().getStatusCategoryList();
                                final NBPPublishStatusPanelView nBPPublishStatusPanelView7 = NBPPublishStatusPanelView.this;
                                for (final NBPPublishCategoryData nBPPublishCategoryData : statusCategoryList) {
                                    cn.a(pageListView2, new Function1<cm, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1$4$2$3$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(cm cmVar) {
                                            cm cmVar2 = cmVar;
                                            final NBPPublishStatusPanelView nBPPublishStatusPanelView8 = nBPPublishStatusPanelView7;
                                            cmVar2.attr(new Function1<ck, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1$4$2$3$1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ck ckVar) {
                                                    ck ckVar2 = ckVar;
                                                    ckVar2.w(ckVar2.getPagerData().m());
                                                    ckVar2.h(4);
                                                    ckVar2.u(8.0f);
                                                    ckVar2.t(8.0f);
                                                    ckVar2.i(0.0f, 13.5f, NBPPublishStatusPanelView.this.getPagerData().getSafeAreaInsets().getBottom() + 8.0f, 13.5f);
                                                    ckVar2.showScrollerIndicator(false);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            List<NBPPublishStatusData> list = NBPPublishCategoryData.this.statusList;
                                            final NBPPublishStatusPanelView nBPPublishStatusPanelView9 = nBPPublishStatusPanelView7;
                                            for (final NBPPublishStatusData nBPPublishStatusData : list) {
                                                w.a(cmVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1$4$2$3$1$2$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar) {
                                                        v vVar2 = vVar;
                                                        final NBPPublishStatusPanelView nBPPublishStatusPanelView10 = NBPPublishStatusPanelView.this;
                                                        final NBPPublishStatusData nBPPublishStatusData2 = nBPPublishStatusData;
                                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1$4$2$3$1$2$1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                h j3;
                                                                t tVar2 = tVar;
                                                                tVar2.mo141height(80.0f);
                                                                tVar2.flexDirectionColumn();
                                                                tVar2.justifyContentFlexStart();
                                                                tVar2.alignItemsCenter();
                                                                tVar2.borderRadius(8.0f);
                                                                h.Companion companion = h.INSTANCE;
                                                                tVar2.mo113backgroundColor(companion.j());
                                                                BorderStyle borderStyle = BorderStyle.SOLID;
                                                                NBPPublishStatusData selectStatus = NBPPublishStatusPanelView.access$getAttr(NBPPublishStatusPanelView.this).getViewModel().getSelectStatus();
                                                                if (selectStatus != null && selectStatus.uniqueId == nBPPublishStatusData2.uniqueId) {
                                                                    j3 = new h(4278231039L);
                                                                } else {
                                                                    j3 = companion.j();
                                                                }
                                                                tVar2.m136border(new com.tencent.kuikly.core.base.e(1.0f, borderStyle, j3));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPPublishStatusData nBPPublishStatusData3 = nBPPublishStatusData;
                                                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1$4$2$3$1$2$1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                final NBPPublishStatusData nBPPublishStatusData4 = NBPPublishStatusData.this;
                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.4.2.3.1.2.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(af afVar) {
                                                                        af afVar2 = afVar;
                                                                        b.a.b(afVar2, NBPPublishStatusData.this.motionImage, false, 2, null);
                                                                        afVar2.size(48.0f, 48.0f);
                                                                        afVar2.marginTop(7.0f);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPPublishStatusData nBPPublishStatusData4 = nBPPublishStatusData;
                                                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1$4$2$3$1$2$1.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final NBPPublishStatusData nBPPublishStatusData5 = NBPPublishStatusData.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.4.2.3.1.2.1.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.text(NBPPublishStatusData.this.title);
                                                                        ceVar2.color(new h(4287664276L));
                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                        ceVar2.fontWeight400();
                                                                        ceVar2.marginTop(4.0f);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPPublishStatusData nBPPublishStatusData5 = nBPPublishStatusData;
                                                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1$4$2$3$1$2$1.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                final NBPPublishStatusData nBPPublishStatusData6 = NBPPublishStatusData.this;
                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.4.2.3.1.2.1.4.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(af afVar) {
                                                                        af afVar2 = afVar;
                                                                        b.a.b(afVar2, NBPPublishStatusData.this.cornerIcon, false, 2, null);
                                                                        afVar2.size(24.0f, 11.0f);
                                                                        Attr.absolutePosition$default(afVar2, 6.0f, 0.0f, 0.0f, 6.0f, 6, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPPublishStatusPanelView nBPPublishStatusPanelView11 = NBPPublishStatusPanelView.this;
                                                        final NBPPublishStatusData nBPPublishStatusData6 = nBPPublishStatusData;
                                                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView$body$1$4$2$3$1$2$1.5
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                final u uVar2 = uVar;
                                                                final NBPPublishStatusPanelView nBPPublishStatusPanelView12 = NBPPublishStatusPanelView.this;
                                                                final NBPPublishStatusData nBPPublishStatusData7 = nBPPublishStatusData6;
                                                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.4.2.3.1.2.1.5.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        NBPPublishViewModel viewModel = NBPPublishStatusPanelView.access$getAttr(NBPPublishStatusPanelView.this).getViewModel();
                                                                        viewModel.selectStatus$delegate.setValue(viewModel, NBPPublishViewModel.$$delegatedProperties[6], nBPPublishStatusData7);
                                                                        AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m(IPagerIdKtxKt.getNotifyModule(uVar2), "NBPPublishStatusPanelSelectStatus", false, 4, null);
                                                                        NBPPublishStatusPanelView nBPPublishStatusPanelView13 = NBPPublishStatusPanelView.this;
                                                                        NBPPublishStatusData nBPPublishStatusData8 = nBPPublishStatusData7;
                                                                        int i3 = nBPPublishStatusData8.statusId;
                                                                        int i16 = nBPPublishStatusData8.richStatusId;
                                                                        nBPPublishStatusPanelView13.getClass();
                                                                        e eVar = new e();
                                                                        eVar.t("nearby_status_id", i3);
                                                                        eVar.t("nearby_action_id", i16);
                                                                        eVar.v("nearby_event_type", "clck");
                                                                        eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("ev_nearby_status_icon", eVar);
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
                                final NBPPublishStatusPanelView nBPPublishStatusPanelView8 = NBPPublishStatusPanelView.this;
                                pageListView2.event(new Function1<PageListEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.4.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(PageListEvent pageListEvent) {
                                        final NBPPublishStatusPanelView nBPPublishStatusPanelView9 = NBPPublishStatusPanelView.this;
                                        pageListEvent.pageIndexDidChanged(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.publish.view.NBPPublishStatusPanelView.body.1.4.2.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                                int j3 = ((e) obj).j("index");
                                                if (j3 != NBPPublishStatusPanelView.access$getAttr(NBPPublishStatusPanelView.this).getViewModel().getStatusCategoryIndex()) {
                                                    NBPPublishViewModel viewModel = NBPPublishStatusPanelView.access$getAttr(NBPPublishStatusPanelView.this).getViewModel();
                                                    viewModel.statusCategoryIndex$delegate.setValue(viewModel, NBPPublishViewModel.$$delegatedProperties[5], Integer.valueOf(j3));
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
        return new NBPPublishStatusPanelAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPPublishStatusPanelEvent();
    }
}

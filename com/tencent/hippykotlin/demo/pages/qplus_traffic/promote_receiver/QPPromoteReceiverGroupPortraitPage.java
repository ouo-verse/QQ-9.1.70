package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver;

import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNav;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitNavAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitItemCard;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBar;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchBarAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchItemCardAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitListItem;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitPageModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverGroupPortraitPage extends BasePager {
    public final Lazy viewModel$delegate;

    public QPPromoteReceiverGroupPortraitPage() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QPPromoteReceiverPortraitPageModel>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage$viewModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QPPromoteReceiverPortraitPageModel invoke() {
                Object d16;
                Object d17;
                QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel = new QPPromoteReceiverPortraitPageModel();
                QPPromoteReceiverGroupPortraitPage qPPromoteReceiverGroupPortraitPage = QPPromoteReceiverGroupPortraitPage.this;
                b l3 = PageDataExtKt.getUserData(qPPromoteReceiverGroupPortraitPage.getPageData()).l("allGroupList");
                if (l3 != null) {
                    int c16 = l3.c();
                    for (int i3 = 0; i3 < c16; i3++) {
                        if (BooleanCompanionObject.INSTANCE instanceof e) {
                            d17 = Boolean.valueOf(l3.e(i3));
                        } else if (IntCompanionObject.INSTANCE instanceof e) {
                            d17 = Integer.valueOf(l3.i(i3));
                        } else if (LongCompanionObject.INSTANCE instanceof e) {
                            d17 = Long.valueOf(l3.m(i3));
                        } else if (StringCompanionObject.INSTANCE instanceof e) {
                            d17 = l3.o(i3);
                        } else if (DoubleCompanionObject.INSTANCE instanceof e) {
                            d17 = Double.valueOf(l3.g(i3));
                        } else {
                            d17 = l3.d(i3);
                        }
                        if (d17 != null) {
                            e eVar = (e) d17;
                            qPPromoteReceiverPortraitPageModel.getAllItemList().add(new QPPromoteReceiverPortraitListItem(eVar.p("uin"), Utils.INSTANCE.currentBridgeModule().urlDecode(eVar.p("name")), eVar.p("icon"), eVar.j(NotifyMsgApiImpl.KEY_GROUP_TYPE), eVar.f("isBlueV"), eVar.f("isBigV")));
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        }
                    }
                }
                b l16 = PageDataExtKt.getUserData(qPPromoteReceiverGroupPortraitPage.getPageData()).l("selectedGroupList");
                if (l16 != null) {
                    int c17 = l16.c();
                    for (int i16 = 0; i16 < c17; i16++) {
                        if (BooleanCompanionObject.INSTANCE instanceof e) {
                            d16 = Boolean.valueOf(l16.e(i16));
                        } else if (IntCompanionObject.INSTANCE instanceof e) {
                            d16 = Integer.valueOf(l16.i(i16));
                        } else if (LongCompanionObject.INSTANCE instanceof e) {
                            d16 = Long.valueOf(l16.m(i16));
                        } else if (StringCompanionObject.INSTANCE instanceof e) {
                            d16 = l16.o(i16);
                        } else if (DoubleCompanionObject.INSTANCE instanceof e) {
                            d16 = Double.valueOf(l16.g(i16));
                        } else {
                            d16 = l16.d(i16);
                        }
                        if (d16 != null) {
                            e eVar2 = (e) d16;
                            String p16 = eVar2.p("uin");
                            Utils.INSTANCE.currentBridgeModule().urlDecode(eVar2.p("name"));
                            eVar2.p("icon");
                            eVar2.j(NotifyMsgApiImpl.KEY_GROUP_TYPE);
                            eVar2.f("isBlueV");
                            eVar2.f("isBigV");
                            Iterator<QPPromoteReceiverPortraitListItem> it = qPPromoteReceiverPortraitPageModel.getAllItemList().iterator();
                            while (it.hasNext()) {
                                QPPromoteReceiverPortraitListItem next = it.next();
                                if (Intrinsics.areEqual(next.uin, p16)) {
                                    qPPromoteReceiverPortraitPageModel.getSelectedList().add(next);
                                    qPPromoteReceiverPortraitPageModel.setSelectedCount(qPPromoteReceiverPortraitPageModel.getSelectedCount() + 1);
                                }
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        }
                    }
                }
                qPPromoteReceiverPortraitPageModel.dataParam = "selectedGroupList";
                return qPPromoteReceiverPortraitPageModel;
            }
        });
        this.viewModel$delegate = lazy;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_backplate", false);
                        mVar2.mo113backgroundColor(hVar);
                        return Unit.INSTANCE;
                    }
                });
                final QPPromoteReceiverGroupPortraitPage qPPromoteReceiverGroupPortraitPage = QPPromoteReceiverGroupPortraitPage.this;
                viewContainer2.addChild(new QPPromoteReceiverPortraitNav(), new Function1<QPPromoteReceiverPortraitNav, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QPPromoteReceiverPortraitNav qPPromoteReceiverPortraitNav) {
                        final QPPromoteReceiverGroupPortraitPage qPPromoteReceiverGroupPortraitPage2 = QPPromoteReceiverGroupPortraitPage.this;
                        qPPromoteReceiverPortraitNav.attr(new Function1<QPPromoteReceiverPortraitNavAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QPPromoteReceiverPortraitNavAttr qPPromoteReceiverPortraitNavAttr) {
                                QPPromoteReceiverPortraitNavAttr qPPromoteReceiverPortraitNavAttr2 = qPPromoteReceiverPortraitNavAttr;
                                qPPromoteReceiverPortraitNavAttr2.titleText$delegate.setValue(qPPromoteReceiverPortraitNavAttr2, QPPromoteReceiverPortraitNavAttr.$$delegatedProperties[0], "\u9009\u62e9\u7fa4\u753b\u50cf");
                                qPPromoteReceiverPortraitNavAttr2.viewModel = QPPromoteReceiverGroupPortraitPage.this.getViewModel();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QPPromoteReceiverGroupPortraitPage qPPromoteReceiverGroupPortraitPage2 = QPPromoteReceiverGroupPortraitPage.this;
                viewContainer2.addChild(new QPPromoteReceiverSearchBar(), new Function1<QPPromoteReceiverSearchBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QPPromoteReceiverSearchBar qPPromoteReceiverSearchBar) {
                        final QPPromoteReceiverGroupPortraitPage qPPromoteReceiverGroupPortraitPage3 = QPPromoteReceiverGroupPortraitPage.this;
                        qPPromoteReceiverSearchBar.attr(new Function1<QPPromoteReceiverSearchBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QPPromoteReceiverSearchBarAttr qPPromoteReceiverSearchBarAttr) {
                                qPPromoteReceiverSearchBarAttr.viewModel = QPPromoteReceiverGroupPortraitPage.this.getViewModel();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QPPromoteReceiverGroupPortraitPage qPPromoteReceiverGroupPortraitPage3 = QPPromoteReceiverGroupPortraitPage.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(QPPromoteReceiverGroupPortraitPage.this.getViewModel().getSearchStatus() == 0);
                    }
                };
                final QPPromoteReceiverGroupPortraitPage qPPromoteReceiverGroupPortraitPage4 = QPPromoteReceiverGroupPortraitPage.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final QPPromoteReceiverGroupPortraitPage qPPromoteReceiverGroupPortraitPage5 = QPPromoteReceiverGroupPortraitPage.this;
                        ar.a(conditionView, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aq<?, ?> aqVar) {
                                aq<?, ?> aqVar2 = aqVar;
                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ao aoVar) {
                                        ao aoVar2 = aoVar;
                                        aoVar2.mo153width(aoVar2.getPagerData().m());
                                        aoVar2.m140flex(1.0f);
                                        aoVar2.mo113backgroundColor(new h("qecommerce_skin_color_bg_backplate"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverGroupPortraitPage qPPromoteReceiverGroupPortraitPage6 = QPPromoteReceiverGroupPortraitPage.this;
                                w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.marginTop(8.0f);
                                                tVar2.flexDirectionColumn();
                                                AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_bg_default");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1.2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text("\u6700\u8fd1\u804a\u5929");
                                                        ce.fontSize$default(ceVar2, 15.0f, null, 2, null);
                                                        ceVar2.fontWeight500();
                                                        ceVar2.marginLeft(16.0f);
                                                        ceVar2.marginTop(16.0f);
                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_primary");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QPPromoteReceiverGroupPortraitPage qPPromoteReceiverGroupPortraitPage7 = QPPromoteReceiverGroupPortraitPage.this;
                                        ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1.2.3
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Boolean.valueOf(QPPromoteReceiverGroupPortraitPage.this.getViewModel().getAllItemList().isEmpty());
                                            }
                                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1.2.4
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView2) {
                                                w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1.2.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        v vVar4 = vVar3;
                                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1.2.4.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.flexDirectionColumn();
                                                                tVar2.alignItemsCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1.2.4.1.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1.2.4.1.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(af afVar) {
                                                                        af afVar2 = afVar;
                                                                        afVar2.size(176.0f, 132.0f);
                                                                        ImageAttrExtKt.urlToken$default(afVar2, "qecommerce_skin_emptystate_img_dongtai");
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1.2.4.1.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1.2.4.1.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.marginTop(16.0f);
                                                                        ceVar2.fontWeight500();
                                                                        ceVar2.textAlignCenter();
                                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_primary");
                                                                        ceVar2.text("\u6682\u65e0\u7fa4\u804a\u5929");
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1.2.4.1.4
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1.2.4.1.4.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.marginTop(7.0f);
                                                                        ceVar2.marginBottom(60.0f);
                                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_secondary");
                                                                        ceVar2.textAlignCenter();
                                                                        ceVar2.text("\u5feb\u53bb\u52a0\u5165\u7fa4\u804a\u5427\uff5e");
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
                                        final QPPromoteReceiverGroupPortraitPage qPPromoteReceiverGroupPortraitPage8 = QPPromoteReceiverGroupPortraitPage.this;
                                        ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1.2.5
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView2) {
                                                final QPPromoteReceiverGroupPortraitPage qPPromoteReceiverGroupPortraitPage9 = QPPromoteReceiverGroupPortraitPage.this;
                                                ar.a(conditionView2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1.2.5.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aq<?, ?> aqVar3) {
                                                        aq<?, ?> aqVar4 = aqVar3;
                                                        final QPPromoteReceiverGroupPortraitPage qPPromoteReceiverGroupPortraitPage10 = QPPromoteReceiverGroupPortraitPage.this;
                                                        aqVar4.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.5.1.2.5.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ao aoVar) {
                                                                ao aoVar2 = aoVar;
                                                                aoVar2.marginTop(8.0f);
                                                                aoVar2.mo153width(aoVar2.getPagerData().m());
                                                                aoVar2.mo141height(QPPromoteReceiverGroupPortraitPage.this.getViewModel().getAllItemList().size() * 56.0f);
                                                                aoVar2.allCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        c<QPPromoteReceiverPortraitListItem> allItemList = QPPromoteReceiverGroupPortraitPage.this.getViewModel().getAllItemList();
                                                        final QPPromoteReceiverGroupPortraitPage qPPromoteReceiverGroupPortraitPage11 = QPPromoteReceiverGroupPortraitPage.this;
                                                        Iterator<QPPromoteReceiverPortraitListItem> it = allItemList.iterator();
                                                        while (it.hasNext()) {
                                                            final QPPromoteReceiverPortraitListItem next = it.next();
                                                            aqVar4.addChild(new QPPromoteReceiverPortraitItemCard(), new Function1<QPPromoteReceiverPortraitItemCard, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage$body$1$5$1$2$5$1$2$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(QPPromoteReceiverPortraitItemCard qPPromoteReceiverPortraitItemCard) {
                                                                    final QPPromoteReceiverGroupPortraitPage qPPromoteReceiverGroupPortraitPage12 = QPPromoteReceiverGroupPortraitPage.this;
                                                                    final QPPromoteReceiverPortraitListItem qPPromoteReceiverPortraitListItem = next;
                                                                    qPPromoteReceiverPortraitItemCard.attr(new Function1<QPPromoteReceiverSearchItemCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage$body$1$5$1$2$5$1$2$1.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(QPPromoteReceiverSearchItemCardAttr qPPromoteReceiverSearchItemCardAttr) {
                                                                            QPPromoteReceiverSearchItemCardAttr qPPromoteReceiverSearchItemCardAttr2 = qPPromoteReceiverSearchItemCardAttr;
                                                                            qPPromoteReceiverSearchItemCardAttr2.mo153width(qPPromoteReceiverSearchItemCardAttr2.getPagerData().m());
                                                                            qPPromoteReceiverSearchItemCardAttr2.viewModel = QPPromoteReceiverGroupPortraitPage.this.getViewModel();
                                                                            qPPromoteReceiverSearchItemCardAttr2.item(qPPromoteReceiverPortraitListItem);
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
                final QPPromoteReceiverGroupPortraitPage qPPromoteReceiverGroupPortraitPage5 = QPPromoteReceiverGroupPortraitPage.this;
                ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        QPPromoteReceiverPortraitPageModel viewModel = QPPromoteReceiverGroupPortraitPage.this.getViewModel();
                        conditionView.addChild(new QPPromoteReceiverPortraitSearchResultList(viewModel), new Function1<QPPromoteReceiverPortraitSearchResultList, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverGroupPortraitPage.body.1.6.1
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList) {
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

    public final QPPromoteReceiverPortraitPageModel getViewModel() {
        return (QPPromoteReceiverPortraitPageModel) this.viewModel$delegate.getValue();
    }
}

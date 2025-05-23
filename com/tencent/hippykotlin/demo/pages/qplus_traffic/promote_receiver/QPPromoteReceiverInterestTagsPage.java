package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.tags_views.QPPromoteReceiverInterestTag;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.tags_views.QPPromoteReceiverInterestTagViewAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusTag;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.ck;
import com.tencent.kuikly.core.views.cm;
import com.tencent.kuikly.core.views.cn;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverInterestTagsPage extends BasePager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Lazy interestTags$delegate;
    public final ArrayList<Boolean> selectedFlag;
    public final ArrayList<QPlusTag> selectedTags;

    public QPPromoteReceiverInterestTagsPage() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<QPlusTag>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage$interestTags$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<QPlusTag> invoke() {
                ArrayList arrayList;
                ArrayList<QPlusTag> arrayList2 = new ArrayList<>();
                e m3 = PageDataExtKt.getUserData(QPPromoteReceiverInterestTagsPage.this.getPagerData()).m("tagsRsp");
                if (m3 != null) {
                    QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage = QPPromoteReceiverInterestTagsPage.this;
                    b l3 = m3.l(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
                    if (l3 != null) {
                        arrayList = new ArrayList();
                        int c16 = l3.c();
                        for (int i3 = 0; i3 < c16; i3++) {
                            Object d16 = l3.d(i3);
                            if (d16 != null) {
                                Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                arrayList.add(new QPlusTag(((e) d16).q("tag_name", "")));
                            }
                        }
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                        int size = arrayList.size();
                        for (int i16 = 0; i16 < size; i16++) {
                            qPPromoteReceiverInterestTagsPage.selectedFlag.add(Boolean.FALSE);
                        }
                    }
                }
                return arrayList2;
            }
        });
        this.interestTags$delegate = lazy;
        this.selectedFlag = new ArrayList<>();
        this.selectedTags = new ArrayList<>();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final float max = Math.max(Math.min(((getInterestTags().size() / 3) + 1) * 32.0f, getPagerData().l() * 0.6f), getPagerData().l() * 0.3f);
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                ECTransitionViewKt.TransitionFadeInOutView(viewContainer2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECTransitionView eCTransitionView) {
                        eCTransitionView.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                                eCTransitionAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                eCTransitionAttr2.mo113backgroundColor(new h(0, 0, 0, 0.5f));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final float f16 = max;
                final QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage = this;
                final int i3 = 3;
                ECTransitionViewKt.TransitionFromBottomView(viewContainer2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECTransitionView eCTransitionView) {
                        ECTransitionView eCTransitionView2 = eCTransitionView;
                        eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                                eCTransitionAttr2.setTransitionAppear(true);
                                eCTransitionAttr2.absolutePositionAllZero();
                                eCTransitionAttr2.flexDirectionColumn();
                                eCTransitionAttr2.justifyContentFlexStart();
                                return Unit.INSTANCE;
                            }
                        });
                        final float f17 = f16;
                        w.a(eCTransitionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.body.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final float f18 = f17;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.body.1.2.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(tVar2.getPagerData().m(), tVar2.getPagerData().l() - ((f18 + 64.0f) + 36.0f));
                                        tVar2.mo113backgroundColor(new h(0L));
                                        return Unit.INSTANCE;
                                    }
                                });
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.body.1.2.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.body.1.2.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                BridgeModule.closePage$default(Utils.INSTANCE.currentBridgeModule(), null, null, 3);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage2 = qPPromoteReceiverInterestTagsPage;
                        final float f18 = f16;
                        final int i16 = i3;
                        w.a(eCTransitionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.body.1.2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final float f19 = f18;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.body.1.2.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionColumn();
                                        tVar2.size(tVar2.getPagerData().m(), f19 + 36.0f + 64.0f);
                                        tVar2.borderRadius(8.0f, 8.0f, 0.0f, 0.0f);
                                        GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_bg_default", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage3 = QPPromoteReceiverInterestTagsPage.this;
                                int i17 = QPPromoteReceiverInterestTagsPage.$r8$clinit;
                                qPPromoteReceiverInterestTagsPage3.getClass();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage$navBar$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                        final QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage4 = QPPromoteReceiverInterestTagsPage.this;
                                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage$navBar$1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.navBar.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        h hVar;
                                                        t tVar2 = tVar;
                                                        tVar2.size(tVar2.getPagerData().m(), 64.0f);
                                                        tVar2.padding(24.0f, 16.0f, 5.0f, 16.0f);
                                                        tVar2.justifyContentSpaceBetween();
                                                        tVar2.flexDirectionRow();
                                                        hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                                        tVar2.mo113backgroundColor(hVar);
                                                        tVar2.m137borderRadius(new f(6.0f, 6.0f, 0.0f, 0.0f));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.navBar.1.1.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.navBar.1.1.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.navBar.1.1.2.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        BridgeModule.closePage$default(Utils.INSTANCE.currentBridgeModule(), null, null, 3);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.navBar.1.1.2.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.navBar.1.1.2.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.text("\u53d6\u6d88");
                                                                        ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 17.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_primary", false, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.navBar.1.1.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        cg.a(vVar5, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.navBar.1.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.navBar.1.1.3.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        h hVar;
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.text("\u9009\u62e9\u5174\u8da3");
                                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                        ceVar2.fontWeightBold();
                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                                        ceVar2.color(hVar);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage5 = QPPromoteReceiverInterestTagsPage.this;
                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.navBar.1.1.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        v vVar6 = vVar5;
                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.navBar.1.1.4.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final /* bridge */ /* synthetic */ Unit invoke(t tVar) {
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage6 = QPPromoteReceiverInterestTagsPage.this;
                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.navBar.1.1.4.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                TextView textView2 = textView;
                                                                textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.navBar.1.1.4.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.text("\u786e\u5b9a");
                                                                        ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 17.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_primary", false, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage7 = QPPromoteReceiverInterestTagsPage.this;
                                                                textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.navBar.1.1.4.2.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextEvent textEvent) {
                                                                        final QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage8 = QPPromoteReceiverInterestTagsPage.this;
                                                                        textEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.navBar.1.1.4.2.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                com.tencent.kuikly.core.pager.b k3 = c.f117352a.k(BridgeManager.f117344a.u());
                                                                                e eVar = new e();
                                                                                QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage9 = QPPromoteReceiverInterestTagsPage.this;
                                                                                b bVar = new b();
                                                                                Iterator<QPlusTag> it = qPPromoteReceiverInterestTagsPage9.selectedTags.iterator();
                                                                                while (it.hasNext()) {
                                                                                    bVar.t(it.next().encode());
                                                                                }
                                                                                Unit unit = Unit.INSTANCE;
                                                                                eVar.v("selectedTags", bVar);
                                                                                IPagerIdKtxKt.callbackResult(k3, eVar);
                                                                                BridgeModule.closePage$default(Utils.INSTANCE.currentBridgeModule(), null, null, 3);
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
                                }.invoke(vVar2);
                                final QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage4 = QPPromoteReceiverInterestTagsPage.this;
                                final int i18 = i16;
                                final float f26 = f18;
                                cn.a(vVar2, new Function1<cm, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.body.1.2.3.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(cm cmVar) {
                                        cm cmVar2 = cmVar;
                                        final int i19 = i18;
                                        final float f27 = f26;
                                        cmVar2.attr(new Function1<ck, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.body.1.2.3.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ck ckVar) {
                                                ck ckVar2 = ckVar;
                                                ckVar2.marginLeft(16.0f);
                                                ckVar2.marginRight(16.0f);
                                                ckVar2.marginTop(6.0f);
                                                ckVar2.m140flex(1.0f);
                                                ckVar2.alignSelfCenter();
                                                ckVar2.h(i19);
                                                ckVar2.mo141height(f27);
                                                ckVar2.w(ckVar2.getPagerData().m() - 32.0f);
                                                ckVar2.t(8.0f);
                                                ckVar2.u(8.0f);
                                                ckVar2.showScrollerIndicator(false);
                                                ckVar2.mo113backgroundColor(new h(0L));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage5 = QPPromoteReceiverInterestTagsPage.this;
                                        int i26 = QPPromoteReceiverInterestTagsPage.$r8$clinit;
                                        int size = qPPromoteReceiverInterestTagsPage5.getInterestTags().size();
                                        for (final int i27 = 0; i27 < size; i27++) {
                                            final QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage6 = QPPromoteReceiverInterestTagsPage.this;
                                            final float m3 = (((qPPromoteReceiverInterestTagsPage6.getPagerData().m() - 16.0f) - 16.0f) - 16.0f) / 3.0f;
                                            new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage$items$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                    final QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage7 = QPPromoteReceiverInterestTagsPage.this;
                                                    final int i28 = i27;
                                                    final float f28 = m3;
                                                    viewContainer3.addChild(new QPPromoteReceiverInterestTag(), new Function1<QPPromoteReceiverInterestTag, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage$items$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(QPPromoteReceiverInterestTag qPPromoteReceiverInterestTag) {
                                                            final QPPromoteReceiverInterestTag qPPromoteReceiverInterestTag2 = qPPromoteReceiverInterestTag;
                                                            final QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage8 = QPPromoteReceiverInterestTagsPage.this;
                                                            final int i29 = i28;
                                                            final float f29 = f28;
                                                            qPPromoteReceiverInterestTag2.attr(new Function1<QPPromoteReceiverInterestTagViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.items.1.1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(QPPromoteReceiverInterestTagViewAttr qPPromoteReceiverInterestTagViewAttr) {
                                                                    QPPromoteReceiverInterestTagViewAttr qPPromoteReceiverInterestTagViewAttr2 = qPPromoteReceiverInterestTagViewAttr;
                                                                    qPPromoteReceiverInterestTagViewAttr2.status$delegate.setValue(qPPromoteReceiverInterestTagViewAttr2, QPPromoteReceiverInterestTagViewAttr.$$delegatedProperties[0], Boolean.valueOf(QPPromoteReceiverInterestTagsPage.this.selectedFlag.get(i29).booleanValue()));
                                                                    qPPromoteReceiverInterestTagViewAttr2.labelText = QPPromoteReceiverInterestTagsPage.this.getInterestTags().get(i29).tagName;
                                                                    qPPromoteReceiverInterestTagViewAttr2.mo153width(f29);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage9 = QPPromoteReceiverInterestTagsPage.this;
                                                            final int i36 = i28;
                                                            qPPromoteReceiverInterestTag2.event(new Function1<l, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.items.1.1.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(l lVar) {
                                                                    final QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage10 = QPPromoteReceiverInterestTagsPage.this;
                                                                    final int i37 = i36;
                                                                    final QPPromoteReceiverInterestTag qPPromoteReceiverInterestTag3 = qPPromoteReceiverInterestTag2;
                                                                    lVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.QPPromoteReceiverInterestTagsPage.items.1.1.2.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        /* JADX WARN: Multi-variable type inference failed */
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            if (QPPromoteReceiverInterestTagsPage.this.selectedFlag.get(i37).booleanValue()) {
                                                                                QPPromoteReceiverInterestTagsPage.this.selectedFlag.set(i37, Boolean.FALSE);
                                                                                QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage11 = QPPromoteReceiverInterestTagsPage.this;
                                                                                qPPromoteReceiverInterestTagsPage11.selectedTags.remove(qPPromoteReceiverInterestTagsPage11.getInterestTags().get(i37));
                                                                            } else {
                                                                                QPPromoteReceiverInterestTagsPage.this.selectedFlag.set(i37, Boolean.TRUE);
                                                                                QPPromoteReceiverInterestTagsPage qPPromoteReceiverInterestTagsPage12 = QPPromoteReceiverInterestTagsPage.this;
                                                                                qPPromoteReceiverInterestTagsPage12.selectedTags.add(qPPromoteReceiverInterestTagsPage12.getInterestTags().get(i37));
                                                                            }
                                                                            QPPromoteReceiverInterestTagViewAttr qPPromoteReceiverInterestTagViewAttr = (QPPromoteReceiverInterestTagViewAttr) qPPromoteReceiverInterestTag3.getViewAttr();
                                                                            qPPromoteReceiverInterestTagViewAttr.status$delegate.setValue(qPPromoteReceiverInterestTagViewAttr, QPPromoteReceiverInterestTagViewAttr.$$delegatedProperties[0], Boolean.valueOf(QPPromoteReceiverInterestTagsPage.this.selectedFlag.get(i37).booleanValue()));
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
                                            }.invoke(cmVar2);
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
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        b l3 = PageDataExtKt.getUserData(getPagerData()).l("selectedTags");
        if (l3 != null) {
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                e l16 = l3.l(i3);
                if (l16 != null) {
                    String q16 = l16.q("tag_name", "");
                    int size = getInterestTags().size();
                    int i16 = 0;
                    while (true) {
                        if (i16 >= size) {
                            break;
                        }
                        if (Intrinsics.areEqual(q16, getInterestTags().get(i16).tagName)) {
                            this.selectedTags.add(getInterestTags().get(i16));
                            this.selectedFlag.set(i16, Boolean.TRUE);
                            break;
                        }
                        i16++;
                    }
                }
            }
        }
    }

    public final ArrayList<QPlusTag> getInterestTags() {
        return (ArrayList) this.interestTags$delegate.getValue();
    }
}

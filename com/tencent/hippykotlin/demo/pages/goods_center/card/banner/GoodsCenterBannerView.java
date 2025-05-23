package com.tencent.hippykotlin.demo.pages.goods_center.card.banner;

import c01.c;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.FlexWrap;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterBannerView extends ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterBannerView.class, "containerWidth", "getContainerWidth()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterBannerView.class, "cardWidth", "getCardWidth()F", 0)};
    public final ReadWriteProperty cardWidth$delegate;
    public final ReadWriteProperty containerWidth$delegate;

    public GoodsCenterBannerView() {
        Float valueOf = Float.valueOf(0.0f);
        this.containerWidth$delegate = c.a(valueOf);
        this.cardWidth$delegate = c.a(valueOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GoodsCenterCardAttr access$getAttr(GoodsCenterBannerView goodsCenterBannerView) {
        return (GoodsCenterCardAttr) goodsCenterBannerView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.banner.GoodsCenterBannerViewModel");
        final GoodsCenterBannerViewModel goodsCenterBannerViewModel = (GoodsCenterBannerViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.banner.GoodsCenterBannerView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                b bVar;
                ArrayList<BannerInfo> arrayList;
                Object d16;
                viewContainer.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.banner.GoodsCenterBannerView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.keepAlive(true);
                        mVar2.mo153width(mVar2.getPagerData().m() - 16.0f);
                        mVar2.flexDirectionRow();
                        mVar2.margin(0.0f, 8.0f, 4.0f, 8.0f);
                        mVar2.flexWrap(FlexWrap.WRAP);
                        mVar2.justifyContentFlexStart();
                        return Unit.INSTANCE;
                    }
                });
                GoodsCenterBannerViewModel goodsCenterBannerViewModel2 = GoodsCenterBannerViewModel.this;
                if (!goodsCenterBannerViewModel2.bannerList.isEmpty()) {
                    arrayList = goodsCenterBannerViewModel2.bannerList;
                } else {
                    Utils utils = Utils.INSTANCE;
                    BridgeManager bridgeManager = BridgeManager.f117344a;
                    BridgeModule bridgeModule = utils.bridgeModule(bridgeManager.u());
                    e eVar = new e();
                    eVar.t("configID", com.tencent.luggage.wxa.eg.b.CTRL_INDEX);
                    eVar.v("configKey", "has_banner");
                    eVar.v(RemoteHandleConst.PARAM_DEFAULT_VALUE, "0");
                    String syncToNativeMethod = bridgeModule.syncToNativeMethod("loadRemoteConfig", eVar, (Function1<? super e, Unit>) null);
                    if (!(syncToNativeMethod.length() == 0) && Integer.parseInt(syncToNativeMethod) != 0) {
                        BridgeModule bridgeModule2 = utils.bridgeModule(bridgeManager.u());
                        e eVar2 = new e();
                        eVar2.t("configID", com.tencent.luggage.wxa.eg.b.CTRL_INDEX);
                        eVar2.v("configKey", "banner_list");
                        eVar2.v(RemoteHandleConst.PARAM_DEFAULT_VALUE, "");
                        bVar = new b(bridgeModule2.syncToNativeMethod("loadRemoteConfig", eVar2, (Function1<? super e, Unit>) null));
                    } else {
                        bVar = new b();
                    }
                    int c16 = bVar.c();
                    for (int i3 = 0; i3 < c16; i3++) {
                        if (BooleanCompanionObject.INSTANCE instanceof e) {
                            d16 = Boolean.valueOf(bVar.e(i3));
                        } else if (IntCompanionObject.INSTANCE instanceof e) {
                            d16 = Integer.valueOf(bVar.i(i3));
                        } else if (LongCompanionObject.INSTANCE instanceof e) {
                            d16 = Long.valueOf(bVar.m(i3));
                        } else if (StringCompanionObject.INSTANCE instanceof e) {
                            d16 = bVar.o(i3);
                        } else if (DoubleCompanionObject.INSTANCE instanceof e) {
                            d16 = Double.valueOf(bVar.g(i3));
                        } else {
                            d16 = bVar.d(i3);
                        }
                        if (d16 != null) {
                            e eVar3 = (e) d16;
                            BannerInfo bannerInfo = new BannerInfo(eVar3.q("image_url", ""), eVar3.q("jump_url", ""), eVar3.q("banner_id", ""), eVar3.q("banner_name", ""));
                            if (goodsCenterBannerViewModel2.bannerList.size() < 4) {
                                goodsCenterBannerViewModel2.bannerList.add(bannerInfo);
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        }
                    }
                    arrayList = goodsCenterBannerViewModel2.bannerList;
                }
                final GoodsCenterBannerView goodsCenterBannerView = this;
                for (final BannerInfo bannerInfo2 : arrayList) {
                    goodsCenterBannerView.getClass();
                    w.a(goodsCenterBannerView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.banner.GoodsCenterBannerView$bannerCardView$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            IGoodsCenterCardViewModel viewModel2 = GoodsCenterBannerView.access$getAttr(GoodsCenterBannerView.this).getViewModel();
                            Intrinsics.checkNotNull(viewModel2, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.banner.GoodsCenterBannerViewModel");
                            final GoodsCenterBannerViewModel goodsCenterBannerViewModel3 = (GoodsCenterBannerViewModel) viewModel2;
                            BannerInfo bannerInfo3 = bannerInfo2;
                            goodsCenterBannerViewModel3.getClass();
                            e eVar4 = new e();
                            eVar4.v("banner_id", bannerInfo3.bannerId);
                            eVar4.v("banner_name", bannerInfo3.bannerName);
                            e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("bus_id", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, com.tencent.kuikly.core.manager.c.f117352a, WadlProxyConsts.CHANNEL));
                            Iterator<String> c17 = eVar4.c();
                            while (c17.hasNext()) {
                                String next = c17.next();
                                m3.v(next, eVar4.p(next));
                            }
                            Utils.INSTANCE.currentBridgeModule().reportDT("xuanpin_banner_exp", m3);
                            final GoodsCenterBannerView goodsCenterBannerView2 = GoodsCenterBannerView.this;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.banner.GoodsCenterBannerView$bannerCardView$1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    GoodsCenterBannerView goodsCenterBannerView3 = GoodsCenterBannerView.this;
                                    float m16 = (goodsCenterBannerView3.getPagerData().m() - 16.0f) - 16.0f;
                                    ReadWriteProperty readWriteProperty = goodsCenterBannerView3.containerWidth$delegate;
                                    KProperty<?>[] kPropertyArr = GoodsCenterBannerView.$$delegatedProperties;
                                    readWriteProperty.setValue(goodsCenterBannerView3, kPropertyArr[0], Float.valueOf(m16));
                                    GoodsCenterBannerView goodsCenterBannerView4 = GoodsCenterBannerView.this;
                                    goodsCenterBannerView4.cardWidth$delegate.setValue(goodsCenterBannerView4, kPropertyArr[1], Float.valueOf((((Number) goodsCenterBannerView4.containerWidth$delegate.getValue(goodsCenterBannerView4, kPropertyArr[0])).floatValue() / 2.0f) - 8.0f));
                                    tVar2.size(GoodsCenterBannerView.this.getCardWidth(), GoodsCenterBannerView.this.getCardWidth() * 0.6328358f);
                                    tVar2.marginRight(8.0f);
                                    tVar2.marginLeft(8.0f);
                                    tVar2.marginBottom(8.0f);
                                    tVar2.m137borderRadius(new f(8.0f, 8.0f, 8.0f, 8.0f));
                                    return Unit.INSTANCE;
                                }
                            });
                            final BannerInfo bannerInfo4 = bannerInfo2;
                            final GoodsCenterBannerView goodsCenterBannerView3 = GoodsCenterBannerView.this;
                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.banner.GoodsCenterBannerView$bannerCardView$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageView imageView) {
                                    ImageView imageView2 = imageView;
                                    final GoodsCenterBannerViewModel goodsCenterBannerViewModel4 = GoodsCenterBannerViewModel.this;
                                    final BannerInfo bannerInfo5 = bannerInfo4;
                                    imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.banner.GoodsCenterBannerView.bannerCardView.1.2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageEvent imageEvent) {
                                            final GoodsCenterBannerViewModel goodsCenterBannerViewModel5 = GoodsCenterBannerViewModel.this;
                                            final BannerInfo bannerInfo6 = bannerInfo5;
                                            imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.banner.GoodsCenterBannerView.bannerCardView.1.2.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    GoodsCenterBannerViewModel goodsCenterBannerViewModel6 = GoodsCenterBannerViewModel.this;
                                                    BannerInfo bannerInfo7 = bannerInfo6;
                                                    goodsCenterBannerViewModel6.getClass();
                                                    e eVar5 = new e();
                                                    eVar5.v("banner_id", bannerInfo7.bannerId);
                                                    eVar5.v("banner_name", bannerInfo7.bannerName);
                                                    e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("bus_id", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, com.tencent.kuikly.core.manager.c.f117352a, WadlProxyConsts.CHANNEL));
                                                    Iterator<String> c18 = eVar5.c();
                                                    while (c18.hasNext()) {
                                                        String next2 = c18.next();
                                                        m16.v(next2, eVar5.p(next2));
                                                    }
                                                    Utils utils2 = Utils.INSTANCE;
                                                    utils2.currentBridgeModule().reportDT("xuanpin_banner_clk", m16);
                                                    BridgeModule.openPage$default(utils2.currentBridgeModule(), bannerInfo7.jumpUrl, false, null, null, 30);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final GoodsCenterBannerView goodsCenterBannerView4 = goodsCenterBannerView3;
                                    final BannerInfo bannerInfo6 = bannerInfo4;
                                    final float f16 = 0.6328358f;
                                    imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.banner.GoodsCenterBannerView.bannerCardView.1.2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(af afVar) {
                                            af afVar2 = afVar;
                                            afVar2.size(GoodsCenterBannerView.this.getCardWidth(), GoodsCenterBannerView.this.getCardWidth() * f16);
                                            ImageAttrExtKt.srcUrl(afVar2, bannerInfo6.imageUrl, null);
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
        return new GoodsCenterCardAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GoodsCenterEvent();
    }

    public final float getCardWidth() {
        return ((Number) this.cardWidth$delegate.getValue(this, $$delegatedProperties[1])).floatValue();
    }
}

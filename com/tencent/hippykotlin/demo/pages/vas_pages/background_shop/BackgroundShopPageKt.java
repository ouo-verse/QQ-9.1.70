package com.tencent.hippykotlin.demo.pages.vas_pages.background_shop;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.QQComposeViewExtCreator$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.SchemaBuilder;
import com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VipTrackerKt;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VipTrackerView;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VipTrackerViewAttr;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.GoodsItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.ItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.TittleItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItemAttr;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BgEvent;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes33.dex */
public final class BackgroundShopPageKt {
    public static final void DataToView(ViewContainer<?, ?> viewContainer, final ItemData itemData, final float f16, final float f17, final boolean z16) {
        if (itemData instanceof GoodsItemData) {
            VasBasePage ctx = VasBasePage.Companion.getCtx();
            viewContainer.addChild(new BackgroundItem(ctx), new Function1<BackgroundItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPageKt$DataToView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(BackgroundItem backgroundItem) {
                    BackgroundItem backgroundItem2 = backgroundItem;
                    final float f18 = f17;
                    final ItemData itemData2 = itemData;
                    final boolean z17 = z16;
                    backgroundItem2.attr(new Function1<BackgroundItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPageKt$DataToView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(BackgroundItemAttr backgroundItemAttr) {
                            BackgroundItemAttr backgroundItemAttr2 = backgroundItemAttr;
                            float f19 = f18;
                            ReadWriteProperty readWriteProperty = backgroundItemAttr2.itemWidth$delegate;
                            KProperty<?>[] kPropertyArr = BackgroundItemAttr.$$delegatedProperties;
                            readWriteProperty.setValue(backgroundItemAttr2, kPropertyArr[0], Float.valueOf(f19));
                            GoodsItemData goodsItemData = (GoodsItemData) itemData2;
                            ReadWriteProperty readWriteProperty2 = goodsItemData.title$delegate;
                            KProperty<?>[] kPropertyArr2 = GoodsItemData.$$delegatedProperties;
                            backgroundItemAttr2.title = (String) readWriteProperty2.getValue(goodsItemData, kPropertyArr2[0]);
                            GoodsItemData goodsItemData2 = (GoodsItemData) itemData2;
                            backgroundItemAttr2.type = (String) goodsItemData2.type$delegate.getValue(goodsItemData2, kPropertyArr2[1]);
                            backgroundItemAttr2.scene = "shop";
                            GoodsItemData goodsItemData3 = (GoodsItemData) itemData2;
                            backgroundItemAttr2.url = (String) goodsItemData3.url$delegate.getValue(goodsItemData3, kPropertyArr2[2]);
                            GoodsItemData goodsItemData4 = (GoodsItemData) itemData2;
                            backgroundItemAttr2.itemId = (String) goodsItemData4.itemId$delegate.getValue(goodsItemData4, kPropertyArr2[3]);
                            ItemData itemData3 = itemData2;
                            backgroundItemAttr2.moduleId = itemData3.moduleId;
                            GoodsItemData goodsItemData5 = (GoodsItemData) itemData3;
                            backgroundItemAttr2.price = ((Number) goodsItemData5.price$delegate.getValue(goodsItemData5, kPropertyArr2[4])).floatValue();
                            backgroundItemAttr2.isSvip = z17;
                            itemData2.getClass();
                            backgroundItemAttr2.isFromCache$delegate.setValue(backgroundItemAttr2, kPropertyArr[2], Boolean.FALSE);
                            return Unit.INSTANCE;
                        }
                    });
                    backgroundItem2.event(new Function1<BgEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPageKt$DataToView$1.2
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(BgEvent bgEvent) {
                            bgEvent.registerEvent("item_click", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPageKt.DataToView.1.2.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Object obj) {
                                    if (obj != null) {
                                        e eVar = (e) obj;
                                        String p16 = eVar.p("item_id");
                                        String p17 = eVar.p("trace_detail");
                                        if (Intrinsics.areEqual("btn", eVar.p("from"))) {
                                            String buildUrlWithParams = SchemaBuilder.INSTANCE.buildUrlWithParams(QQComposeViewExtCreator$$ExternalSyntheticOutline0.m("https://zb.vip.qq.com/v2/pages/itemDetail?appid=8&_nav_titleclr=000000&_nav_txtclr=000000&itemid=", p16, "&isSetupImmediately=1&enteranceId=kshop"), new Pair[]{TuplesKt.to("traceDetail", p17)});
                                            VasBasePage.Companion companion = VasBasePage.Companion;
                                            companion.getCtx().platformApi.getVasModule().openPage(buildUrlWithParams);
                                            KLog.INSTANCE.i(companion.getCtx().getPageName(), AgreementConsentViewKt$$ExternalSyntheticOutline0.m("user click setup , result: ", buildUrlWithParams));
                                        } else {
                                            String buildUrlWithParams2 = SchemaBuilder.INSTANCE.buildUrlWithParams(QQComposeViewExtCreator$$ExternalSyntheticOutline0.m("https://zb.vip.qq.com/v2/pages/itemDetail?appid=8&_nav_titleclr=000000&_nav_txtclr=000000&itemid=", p16, "&enteranceId=kshop"), new Pair[]{TuplesKt.to("traceDetail", p17)});
                                            VasBasePage.Companion companion2 = VasBasePage.Companion;
                                            companion2.getCtx().platformApi.getVasModule().openPage(buildUrlWithParams2);
                                            KLog.INSTANCE.i(companion2.getCtx().getPageName(), AgreementConsentViewKt$$ExternalSyntheticOutline0.m("user click detail, result: ", buildUrlWithParams2));
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
        } else if (itemData instanceof TittleItemData) {
            VipTrackerKt.VipTracker(viewContainer, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPageKt$DataToView$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(VipTrackerView vipTrackerView) {
                    VipTrackerView vipTrackerView2 = vipTrackerView;
                    final float f18 = f16;
                    final ItemData itemData2 = itemData;
                    vipTrackerView2.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPageKt$DataToView$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                            VipTrackerViewAttr vipTrackerViewAttr2 = vipTrackerViewAttr;
                            vipTrackerViewAttr2.mo153width(f18);
                            vipTrackerViewAttr2.tracker.moduleId = itemData2.moduleId;
                            vipTrackerViewAttr2.tracker.expose = true;
                            return Unit.INSTANCE;
                        }
                    });
                    final ItemData itemData3 = itemData;
                    cg.a(vipTrackerView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPageKt$DataToView$2.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(TextView textView) {
                            final ItemData itemData4 = ItemData.this;
                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPageKt.DataToView.2.2.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ce ceVar) {
                                    h hVar;
                                    ce ceVar2 = ceVar;
                                    if (!VasUIToken.INSTANCE.isDarkMode()) {
                                        hVar = new h(4279901214L);
                                    } else {
                                        hVar = new h(4293980404L);
                                    }
                                    ceVar2.color(hVar);
                                    TittleItemData tittleItemData = (TittleItemData) ItemData.this;
                                    ReadWriteProperty readWriteProperty = tittleItemData.title$delegate;
                                    KProperty<?>[] kPropertyArr = TittleItemData.$$delegatedProperties;
                                    ceVar2.text((String) readWriteProperty.getValue(tittleItemData, kPropertyArr[0]));
                                    ce.fontSize$default(ceVar2, 20.0f, null, 2, null);
                                    ceVar2.fontWeightBold();
                                    TittleItemData tittleItemData2 = (TittleItemData) ItemData.this;
                                    if (!Intrinsics.areEqual((String) tittleItemData2.title$delegate.getValue(tittleItemData2, kPropertyArr[0]), "\u6700\u65b0\u4e0a\u67b6")) {
                                        ceVar2.marginTop(20.0f);
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
        }
    }
}

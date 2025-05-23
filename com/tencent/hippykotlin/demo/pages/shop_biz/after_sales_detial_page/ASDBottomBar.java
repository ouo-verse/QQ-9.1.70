package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.lib.vas_report_utils.VasBusinessReportData$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.a;
import com.tencent.kuikly.core.views.compose.b;
import com.tencent.kuikly.core.views.compose.c;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import defpackage.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ASDBottomBar extends ComposeView<ASDBottomBarAttr, ASDBottomBarEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public ASDBottomBarAttr viewAttr = new ASDBottomBarAttr();

    public final String afterSalesApplyPageSchema(int i3) {
        String p16 = getPager().getPageData().n().p("order_id");
        String p17 = getPager().getPageData().n().p(WadlProxyConsts.CHANNEL);
        AfterSalesDetailPageData afterSalesDetailPageData = this.viewAttr.getRspModel().detailPage;
        Intrinsics.checkNotNull(afterSalesDetailPageData);
        String str = afterSalesDetailPageData.afterSalesId;
        AfterSalesDetailPageData afterSalesDetailPageData2 = this.viewAttr.getRspModel().detailPage;
        Intrinsics.checkNotNull(afterSalesDetailPageData2);
        String str2 = afterSalesDetailPageData2.processId;
        String p18 = getPager().getPageData().n().p("sku_id");
        StringBuilder m3 = VasBusinessReportData$$ExternalSyntheticOutline0.m(j.a("mqqapi://ecommerce/open?target=36&channel=", p17, "&order_id=", p16, "&after_sales_id="), str, "&process_id=", str2, "&page_type=");
        m3.append(i3);
        m3.append("&sku_id=");
        m3.append(p18);
        return m3.toString();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo113backgroundColor(SkinColor.INSTANCE.fgColor(mVar2.getPagerId()));
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(0.5f);
                                tVar2.mo113backgroundColor(SkinColor.INSTANCE.sepColor(tVar2.getPagerId()));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ASDBottomBar aSDBottomBar = ASDBottomBar.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(60.0f);
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                tVar2.justifyContentFlexEnd();
                                tVar2.paddingRight(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        if (ASDBottomBar.this.viewAttr.getOperationPrivilege().enableCancelApply) {
                            final ASDBottomBar aSDBottomBar2 = ASDBottomBar.this;
                            c.a(vVar2, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ButtonView buttonView) {
                                    ButtonView buttonView2 = buttonView;
                                    buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(a aVar) {
                                            aVar.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.2.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.text("\u64a4\u9500\u7533\u8bf7");
                                                    ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                    ceVar2.fontWeightSemisolid();
                                                    ceVar2.color(SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId()));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.2.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(a aVar) {
                                            a aVar2 = aVar;
                                            aVar2.mo141height(40.0f);
                                            aVar2.marginLeft(8.0f);
                                            aVar2.paddingLeft(24.0f);
                                            aVar2.paddingRight(24.0f);
                                            aVar2.borderRadius(4.0f);
                                            aVar2.mo113backgroundColor(SkinColor.INSTANCE.bgColor(aVar2.getPagerId()));
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final ASDBottomBar aSDBottomBar3 = ASDBottomBar.this;
                                    buttonView2.event(new Function1<b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.2.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(b bVar) {
                                            final ASDBottomBar aSDBottomBar4 = ASDBottomBar.this;
                                            bVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.2.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    final ASDBottomBar aSDBottomBar5 = ASDBottomBar.this;
                                                    ASDReportModel aSDReportModel = aSDBottomBar5.viewAttr.reportModel;
                                                    if (aSDReportModel != null) {
                                                        aSDReportModel.reportBottomButtonClick$enumunboxing$(1);
                                                    }
                                                    Utils.INSTANCE.bridgeModule(aSDBottomBar5.getPagerId()).showAlert(null, "\u786e\u8ba4\u53d6\u6d88\u672c\u6b21\u552e\u540e\uff1f", "\u53d6\u6d88", "\u786e\u5b9a", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar$onClickCancelApply$1
                                                        {
                                                            super(1);
                                                        }

                                                        /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
                                                        
                                                            if (r3.j("index") == 1) goto L8;
                                                         */
                                                        @Override // kotlin.jvm.functions.Function1
                                                        /*
                                                            Code decompiled incorrectly, please refer to instructions dump.
                                                        */
                                                        public final Unit invoke(e eVar) {
                                                            e eVar2 = eVar;
                                                            boolean z16 = eVar2 != null;
                                                            if (z16) {
                                                                ASDCancelApplyRequestModel aSDCancelApplyRequestModel = new ASDCancelApplyRequestModel(ASDBottomBar.this.getPagerId());
                                                                AfterSalesDetailPageData afterSalesDetailPageData = ASDBottomBar.this.viewAttr.getRspModel().detailPage;
                                                                Intrinsics.checkNotNull(afterSalesDetailPageData);
                                                                String str = afterSalesDetailPageData.afterSalesId;
                                                                AfterSalesDetailPageData afterSalesDetailPageData2 = ASDBottomBar.this.viewAttr.getRspModel().detailPage;
                                                                Intrinsics.checkNotNull(afterSalesDetailPageData2);
                                                                String str2 = afterSalesDetailPageData2.processId;
                                                                aSDCancelApplyRequestModel.afterSalesId = str;
                                                                aSDCancelApplyRequestModel.processId = str2;
                                                                final ASDBottomBar aSDBottomBar6 = ASDBottomBar.this;
                                                                aSDCancelApplyRequestModel.requestData(new Function3<e, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar$onClickCancelApply$1.1
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public final Unit invoke(e eVar3, Integer num, String str3) {
                                                                        if (num.intValue() == 0) {
                                                                            ASDBottomBar.this.emit("didCancelApply", null);
                                                                            Utils.INSTANCE.bridgeModule(ASDBottomBar.this.getPagerId()).toast("\u5df2\u53d6\u6d88\u7533\u8bf7");
                                                                        } else {
                                                                            Utils.INSTANCE.bridgeModule(ASDBottomBar.this.getPagerId()).toast("\u53d6\u6d88\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5");
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
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        if (ASDBottomBar.this.viewAttr.getOperationPrivilege().enableApplyAgain) {
                            final ASDBottomBar aSDBottomBar3 = ASDBottomBar.this;
                            c.a(vVar2, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ButtonView buttonView) {
                                    ButtonView buttonView2 = buttonView;
                                    buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.3.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(a aVar) {
                                            a aVar2 = aVar;
                                            aVar2.mo141height(40.0f);
                                            aVar2.paddingLeft(16.0f);
                                            aVar2.paddingRight(16.0f);
                                            aVar2.marginLeft(8.0f);
                                            aVar2.borderRadius(4.0f);
                                            aVar2.mo113backgroundColor(SkinColor.INSTANCE.bgColor(aVar2.getPagerId()));
                                            aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.3.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.text("\u518d\u6b21\u7533\u8bf7\u552e\u540e");
                                                    ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                    ceVar2.fontWeightSemisolid();
                                                    ceVar2.color(SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId()));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final ASDBottomBar aSDBottomBar4 = ASDBottomBar.this;
                                    buttonView2.event(new Function1<b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.3.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(b bVar) {
                                            final ASDBottomBar aSDBottomBar5 = ASDBottomBar.this;
                                            bVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.3.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    ASDBottomBar aSDBottomBar6 = ASDBottomBar.this;
                                                    int i3 = ASDBottomBar.$r8$clinit;
                                                    BridgeModule.openPage$default(Utils.INSTANCE.bridgeModule(aSDBottomBar6.getPagerId()), aSDBottomBar6.afterSalesApplyPageSchema(0), false, null, null, 30);
                                                    ASDReportModel aSDReportModel = aSDBottomBar6.viewAttr.reportModel;
                                                    if (aSDReportModel != null) {
                                                        aSDReportModel.reportBottomButtonClick$enumunboxing$(3);
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
                        if (ASDBottomBar.this.viewAttr.getOperationPrivilege().enableApplyJudgement) {
                            final ASDBottomBar aSDBottomBar4 = ASDBottomBar.this;
                            c.a(vVar2, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.4
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ButtonView buttonView) {
                                    ButtonView buttonView2 = buttonView;
                                    buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.4.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(a aVar) {
                                            aVar.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.4.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.text("\u7533\u8bf7\u5e73\u53f0\u4ecb\u5165");
                                                    ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                    ceVar2.fontWeightSemisolid();
                                                    ceVar2.color(SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId()));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.4.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(a aVar) {
                                            a aVar2 = aVar;
                                            aVar2.mo141height(40.0f);
                                            aVar2.paddingLeft(16.0f);
                                            aVar2.paddingRight(16.0f);
                                            aVar2.marginLeft(8.0f);
                                            aVar2.borderRadius(4.0f);
                                            aVar2.mo113backgroundColor(SkinColor.INSTANCE.bgColor(aVar2.getPagerId()));
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final ASDBottomBar aSDBottomBar5 = ASDBottomBar.this;
                                    buttonView2.event(new Function1<b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.4.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(b bVar) {
                                            final ASDBottomBar aSDBottomBar6 = ASDBottomBar.this;
                                            bVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.4.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    ASDBottomBar aSDBottomBar7 = ASDBottomBar.this;
                                                    int i3 = ASDBottomBar.$r8$clinit;
                                                    BridgeModule.openPage$default(Utils.INSTANCE.bridgeModule(aSDBottomBar7.getPagerId()), aSDBottomBar7.afterSalesApplyPageSchema(4), false, null, null, 30);
                                                    ASDReportModel aSDReportModel = aSDBottomBar7.viewAttr.reportModel;
                                                    if (aSDReportModel != null) {
                                                        aSDReportModel.reportBottomButtonClick$enumunboxing$(2);
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
                        if (ASDBottomBar.this.viewAttr.getOperationPrivilege().enableContactPlatform) {
                            final ASDBottomBar aSDBottomBar5 = ASDBottomBar.this;
                            c.a(vVar2, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.5
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ButtonView buttonView) {
                                    ButtonView buttonView2 = buttonView;
                                    buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.5.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(a aVar) {
                                            aVar.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.5.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.text("\u8054\u7cfb\u5ba2\u670d");
                                                    ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                    ceVar2.fontWeightSemisolid();
                                                    ceVar2.color(SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId()));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.5.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(a aVar) {
                                            a aVar2 = aVar;
                                            aVar2.mo141height(40.0f);
                                            aVar2.paddingLeft(24.0f);
                                            aVar2.marginLeft(8.0f);
                                            aVar2.paddingRight(24.0f);
                                            aVar2.borderRadius(4.0f);
                                            aVar2.mo113backgroundColor(SkinColor.INSTANCE.bgColor(aVar2.getPagerId()));
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final ASDBottomBar aSDBottomBar6 = ASDBottomBar.this;
                                    buttonView2.event(new Function1<b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.5.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(b bVar) {
                                            final ASDBottomBar aSDBottomBar7 = ASDBottomBar.this;
                                            bVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.3.5.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    ASDBottomBar aSDBottomBar8 = ASDBottomBar.this;
                                                    int i3 = ASDBottomBar.$r8$clinit;
                                                    String p16 = aSDBottomBar8.getPager().getPageData().n().p("order_id");
                                                    String p17 = aSDBottomBar8.getPager().getPageData().n().p(WadlProxyConsts.CHANNEL);
                                                    AfterSalesDetailPageData afterSalesDetailPageData = aSDBottomBar8.viewAttr.getRspModel().detailPage;
                                                    Intrinsics.checkNotNull(afterSalesDetailPageData);
                                                    afterSalesDetailPageData.getClass();
                                                    AfterSalesDetailPageData afterSalesDetailPageData2 = aSDBottomBar8.viewAttr.getRspModel().detailPage;
                                                    Intrinsics.checkNotNull(afterSalesDetailPageData2);
                                                    afterSalesDetailPageData2.getClass();
                                                    BridgeModule.openPage$default(Utils.INSTANCE.bridgeModule(aSDBottomBar8.getPagerId()), "mqqapi://ecommerce/open?target=43&channel=" + p17 + "&scene=5&order_id=" + p16 + "&src_type=internal&version=1", false, null, null, 30);
                                                    ASDReportModel aSDReportModel = aSDBottomBar8.viewAttr.reportModel;
                                                    if (aSDReportModel != null) {
                                                        aSDReportModel.reportBottomButtonClick$enumunboxing$(4);
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
                        return Unit.INSTANCE;
                    }
                });
                if (viewContainer2.getPager().getPageData().getIsIphoneX()) {
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar$body$1.4
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBottomBar.body.1.4.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    tVar.mo141height(34.0f);
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
        return this.viewAttr;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ASDBottomBarEvent();
    }
}

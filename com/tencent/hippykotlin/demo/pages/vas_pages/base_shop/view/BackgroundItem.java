package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.extension.FloatExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.view.DynamicAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.VasDynamicView;
import com.tencent.hippykotlin.demo.pages.foundation.view.VasDynamicViewKt;
import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.BaseVipTrackerViewAttr;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VipTrackerKt;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VipTrackerView;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VipTrackerViewAttr;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.view.VipTrackerViewEvent;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.ParamExtKt;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.report.BaseReportInfo;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.report.ReportInfoExtKt;
import com.tencent.hippykotlin.demo.pages.vas_pages.gxh.common.FeeType;
import com.tencent.hippykotlin.demo.pages.vas_pages.gxh.common.models.DressItem;
import com.tencent.hippykotlin.demo.pages.vas_pages.gxh.common.models.User;
import com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconView;
import com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.PriceAndFeeTypeIconViewAttr;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.c;
import com.tencent.kuikly.core.views.layout.ColumnView;
import com.tencent.kuikly.core.views.layout.a;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class BackgroundItem extends ComposeView<BackgroundItemAttr, BgEvent> {
    public BackgroundItem(VasBasePage vasBasePage) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ BackgroundItemAttr access$getAttr(BackgroundItem backgroundItem) {
        return (BackgroundItemAttr) backgroundItem.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final String access$getPriceAccess(BackgroundItem backgroundItem) {
        FeeType feeType;
        int parseInt = Integer.parseInt(((BackgroundItemAttr) backgroundItem.getAttr()).type);
        FeeType[] values = FeeType.values();
        int length = values.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                feeType = null;
                break;
            }
            feeType = values[i3];
            if (feeType.value == parseInt) {
                break;
            }
            i3++;
        }
        if (feeType == null) {
            feeType = FeeType.UNKNOWN;
        }
        if (feeType == FeeType.MEIHUA_AT) {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u4ef7\u683c");
            m3.append(((BackgroundItemAttr) backgroundItem.getAttr()).price / 100);
            m3.append('\u5143');
            return m3.toString();
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final String str;
        if (Intrinsics.areEqual(((BackgroundItemAttr) getAttr()).moduleId, "5")) {
            str = "2";
        } else {
            str = "-1";
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                final BackgroundItem backgroundItem = BackgroundItem.this;
                final String str2 = str;
                VipTrackerKt.VipTracker(viewContainer2, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(VipTrackerView vipTrackerView) {
                        VipTrackerView vipTrackerView2 = vipTrackerView;
                        final BackgroundItem backgroundItem2 = BackgroundItem.this;
                        vipTrackerView2.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                VipTrackerViewAttr vipTrackerViewAttr2 = vipTrackerViewAttr;
                                vipTrackerViewAttr2.tracker.moduleId = BackgroundItem.access$getAttr(BackgroundItem.this).moduleId;
                                vipTrackerViewAttr2.alignItemsCenter();
                                vipTrackerViewAttr2.tracker.expose = false;
                                return Unit.INSTANCE;
                            }
                        });
                        final String str3 = str2;
                        final BackgroundItem backgroundItem3 = BackgroundItem.this;
                        VipTrackerKt.VipTracker(vipTrackerView2, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(VipTrackerView vipTrackerView3) {
                                VipTrackerView vipTrackerView4 = vipTrackerView3;
                                final String str4 = str3;
                                vipTrackerView4.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                        VipTrackerViewAttr vipTrackerViewAttr2 = vipTrackerViewAttr;
                                        vipTrackerViewAttr2.tracker.subModuleId = str4;
                                        vipTrackerViewAttr2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final BackgroundItem backgroundItem4 = backgroundItem3;
                                final String str5 = str3;
                                VipTrackerKt.VipTracker(vipTrackerView4, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(VipTrackerView vipTrackerView5) {
                                        final VipTrackerView vipTrackerView6 = vipTrackerView5;
                                        final BackgroundItem backgroundItem5 = BackgroundItem.this;
                                        vipTrackerView6.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                                HashMap<String, Object> extProps;
                                                VipTrackerViewAttr vipTrackerViewAttr2 = vipTrackerViewAttr;
                                                vipTrackerViewAttr2.tracker.itemId = BackgroundItem.access$getAttr(BackgroundItem.this).itemId;
                                                BaseReportInfo reportInfo = ReportInfoExtKt.getReportInfo(VasBasePage.Companion.getCtx());
                                                vipTrackerViewAttr2.tracker.itemType = String.valueOf((reportInfo == null || (extProps = reportInfo.getExtProps()) == null) ? null : extProps.get("shopId"));
                                                vipTrackerViewAttr2.tracker.ruleInfo.v("str_ruleid", BackgroundItem.access$getAttr(BackgroundItem.this).strRuleId);
                                                vipTrackerViewAttr2.exposeStrategy = 3;
                                                BackgroundItemAttr access$getAttr = BackgroundItem.access$getAttr(BackgroundItem.this);
                                                vipTrackerViewAttr2.exposeActive$delegate.setValue(vipTrackerViewAttr2, BaseVipTrackerViewAttr.$$delegatedProperties[0], Boolean.valueOf(!((Boolean) access$getAttr.isFromCache$delegate.getValue(access$getAttr, BackgroundItemAttr.$$delegatedProperties[2])).booleanValue()));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final BackgroundItem backgroundItem6 = BackgroundItem.this;
                                        VasDynamicViewKt.VasDynamicImg(vipTrackerView6, new Function1<VasDynamicView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(VasDynamicView vasDynamicView) {
                                                final BackgroundItem backgroundItem7 = BackgroundItem.this;
                                                vasDynamicView.attr(new Function1<DynamicAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(DynamicAttr dynamicAttr) {
                                                        DynamicAttr dynamicAttr2 = dynamicAttr;
                                                        dynamicAttr2.m140flex(1.0f);
                                                        dynamicAttr2.size(BackgroundItem.access$getAttr(BackgroundItem.this).getItemWidth(), (BackgroundItem.access$getAttr(BackgroundItem.this).getItemWidth() / 105.0f) * 183.75f);
                                                        dynamicAttr2.with("sceneTag", BackgroundItem.access$getAttr(BackgroundItem.this).scene);
                                                        dynamicAttr2.with("scaleType", "aspectFill");
                                                        dynamicAttr2.borderRadius(4.0f);
                                                        dynamicAttr2.with("src", BackgroundItem.access$getAttr(BackgroundItem.this).url);
                                                        dynamicAttr2.accessibility(BackgroundItem.access$getAttr(BackgroundItem.this).title + BackgroundItem.access$getPriceAccess(BackgroundItem.this));
                                                        dynamicAttr2.accessibilityRole(AccessibilityRole.BUTTON);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final BackgroundItem backgroundItem7 = BackgroundItem.this;
                                        final String str6 = str5;
                                        vipTrackerView6.event(new Function1<VipTrackerViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.2.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(VipTrackerViewEvent vipTrackerViewEvent) {
                                                final VipTrackerView vipTrackerView7 = VipTrackerView.this;
                                                final BackgroundItem backgroundItem8 = backgroundItem7;
                                                final String str7 = str6;
                                                vipTrackerViewEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.2.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        HashMap<String, Object> extProps;
                                                        String base64String = ParamExtKt.getTraceDetailInfo(VipTrackerView.this).toBase64String();
                                                        BackgroundItem backgroundItem9 = backgroundItem8;
                                                        e eVar = new e();
                                                        BackgroundItem backgroundItem10 = backgroundItem8;
                                                        String str8 = str7;
                                                        eVar.v("from", VasProfileTemplatePreloadHelper.BACKGROUND);
                                                        eVar.v("module_id", BackgroundItem.access$getAttr(backgroundItem10).moduleId);
                                                        eVar.v("item_id", BackgroundItem.access$getAttr(backgroundItem10).itemId);
                                                        eVar.v("trace_detail", base64String);
                                                        eVar.v("sub_module_id", str8);
                                                        BaseReportInfo reportInfo = ReportInfoExtKt.getReportInfo(VasBasePage.Companion.getCtx());
                                                        eVar.v("item_type", String.valueOf((reportInfo == null || (extProps = reportInfo.getExtProps()) == null) ? null : extProps.get("shopId")));
                                                        Unit unit = Unit.INSTANCE;
                                                        backgroundItem9.emit("item_click", eVar);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final BackgroundItem backgroundItem5 = backgroundItem3;
                                final String str6 = str3;
                                a.b(vipTrackerView4, new Function1<ColumnView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ColumnView columnView) {
                                        ColumnView columnView2 = columnView;
                                        columnView2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(m mVar) {
                                                mVar.alignItemsCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final BackgroundItem backgroundItem6 = BackgroundItem.this;
                                        w.a(columnView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                final BackgroundItem backgroundItem7 = BackgroundItem.this;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionRow();
                                                        tVar2.marginTop(8.0f);
                                                        tVar2.mo153width(BackgroundItem.access$getAttr(BackgroundItem.this).getItemWidth());
                                                        tVar2.mo141height(14.0f);
                                                        tVar2.alignItemsCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final BackgroundItem backgroundItem8 = BackgroundItem.this;
                                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.3.2.2
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        return Boolean.valueOf(!Intrinsics.areEqual(BackgroundItem.access$getAttr(BackgroundItem.this).type, ""));
                                                    }
                                                };
                                                final BackgroundItem backgroundItem9 = BackgroundItem.this;
                                                ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.3.2.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView) {
                                                        final BackgroundItem backgroundItem10 = BackgroundItem.this;
                                                        conditionView.addChild(new PriceAndFeeTypeIconView(), new Function1<PriceAndFeeTypeIconView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.3.2.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(PriceAndFeeTypeIconView priceAndFeeTypeIconView) {
                                                                final BackgroundItem backgroundItem11 = BackgroundItem.this;
                                                                priceAndFeeTypeIconView.attr(new Function1<PriceAndFeeTypeIconViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.3.2.3.1.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(PriceAndFeeTypeIconViewAttr priceAndFeeTypeIconViewAttr) {
                                                                        FeeType feeType;
                                                                        PriceAndFeeTypeIconViewAttr priceAndFeeTypeIconViewAttr2 = priceAndFeeTypeIconViewAttr;
                                                                        priceAndFeeTypeIconViewAttr2.accessibility(BackgroundItem.access$getPriceAccess(BackgroundItem.this));
                                                                        priceAndFeeTypeIconViewAttr2.marginLeft(2.0f);
                                                                        priceAndFeeTypeIconViewAttr2.mo141height(14.0f);
                                                                        priceAndFeeTypeIconViewAttr2.alignItemsCenter();
                                                                        float to375 = 14.0f / FloatExtKt.getTo375(18.0f);
                                                                        ReadWriteProperty readWriteProperty = priceAndFeeTypeIconViewAttr2.viewScale$delegate;
                                                                        KProperty<?>[] kPropertyArr = PriceAndFeeTypeIconViewAttr.$$delegatedProperties;
                                                                        readWriteProperty.setValue(priceAndFeeTypeIconViewAttr2, kPropertyArr[2], Float.valueOf(to375));
                                                                        DressItem dressItem = new DressItem();
                                                                        BackgroundItem backgroundItem12 = BackgroundItem.this;
                                                                        int parseInt = Integer.parseInt(BackgroundItem.access$getAttr(backgroundItem12).type);
                                                                        FeeType[] values = FeeType.values();
                                                                        int length = values.length;
                                                                        int i3 = 0;
                                                                        while (true) {
                                                                            if (i3 >= length) {
                                                                                feeType = null;
                                                                                break;
                                                                            }
                                                                            feeType = values[i3];
                                                                            if (feeType.value == parseInt) {
                                                                                break;
                                                                            }
                                                                            i3++;
                                                                        }
                                                                        if (feeType == null) {
                                                                            feeType = FeeType.UNKNOWN;
                                                                        }
                                                                        ReadWriteProperty readWriteProperty2 = dressItem.feeType$delegate;
                                                                        KProperty<?>[] kPropertyArr2 = DressItem.$$delegatedProperties;
                                                                        readWriteProperty2.setValue(dressItem, kPropertyArr2[8], feeType);
                                                                        dressItem.price$delegate.setValue(dressItem, kPropertyArr2[7], Float.valueOf(BackgroundItem.access$getAttr(backgroundItem12).price));
                                                                        dressItem.hideZeroPrice$delegate.setValue(dressItem, kPropertyArr2[12], Boolean.TRUE);
                                                                        priceAndFeeTypeIconViewAttr2.item$delegate.setValue(priceAndFeeTypeIconViewAttr2, kPropertyArr[0], dressItem);
                                                                        User user = new User();
                                                                        user.isSvip$delegate.setValue(user, User.$$delegatedProperties[1], Boolean.valueOf(BackgroundItem.access$getAttr(BackgroundItem.this).isSvip));
                                                                        priceAndFeeTypeIconViewAttr2.user$delegate.setValue(priceAndFeeTypeIconViewAttr2, kPropertyArr[1], user);
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
                                        final BackgroundItem backgroundItem7 = BackgroundItem.this;
                                        final String str7 = str6;
                                        VipTrackerKt.VipTracker(columnView2, new Function1<VipTrackerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.3.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(VipTrackerView vipTrackerView5) {
                                                final VipTrackerView vipTrackerView6 = vipTrackerView5;
                                                final float itemWidth = (BackgroundItem.access$getAttr(BackgroundItem.this).getItemWidth() * 30) / 105;
                                                if (itemWidth > 33.0f) {
                                                    itemWidth = 33.0f;
                                                }
                                                final BackgroundItem backgroundItem8 = BackgroundItem.this;
                                                vipTrackerView6.attr(new Function1<VipTrackerViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.3.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(VipTrackerViewAttr vipTrackerViewAttr) {
                                                        HashMap<String, Object> extProps;
                                                        VipTrackerViewAttr vipTrackerViewAttr2 = vipTrackerViewAttr;
                                                        vipTrackerViewAttr2.tracker.itemId = BackgroundItem.access$getAttr(BackgroundItem.this).itemId;
                                                        BaseReportInfo reportInfo = ReportInfoExtKt.getReportInfo(VasBasePage.Companion.getCtx());
                                                        vipTrackerViewAttr2.tracker.itemType = String.valueOf((reportInfo == null || (extProps = reportInfo.getExtProps()) == null) ? null : extProps.get("shopId"));
                                                        vipTrackerViewAttr2.tracker.ruleInfo.v("str_ruleid", BackgroundItem.access$getAttr(BackgroundItem.this).strRuleId);
                                                        vipTrackerViewAttr2.exposeStrategy = 3;
                                                        BackgroundItemAttr access$getAttr = BackgroundItem.access$getAttr(BackgroundItem.this);
                                                        vipTrackerViewAttr2.exposeActive$delegate.setValue(vipTrackerViewAttr2, BaseVipTrackerViewAttr.$$delegatedProperties[0], Boolean.valueOf(!((Boolean) access$getAttr.isFromCache$delegate.getValue(access$getAttr, BackgroundItemAttr.$$delegatedProperties[2])).booleanValue()));
                                                        vipTrackerViewAttr2.allCenter();
                                                        vipTrackerViewAttr2.mo141height(itemWidth);
                                                        vipTrackerViewAttr2.marginTop(((double) (BackgroundItem.this.getPagerData().l() / BackgroundItem.this.getPagerData().m())) < 1.35d ? 28.0f : 8.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final BackgroundItem backgroundItem9 = BackgroundItem.this;
                                                c.a(vipTrackerView6, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.3.3.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ButtonView buttonView) {
                                                        final BackgroundItem backgroundItem10 = BackgroundItem.this;
                                                        final float f16 = itemWidth;
                                                        buttonView.attr(new Function1<com.tencent.kuikly.core.views.compose.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.3.3.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(com.tencent.kuikly.core.views.compose.a aVar) {
                                                                String str8;
                                                                com.tencent.kuikly.core.views.compose.a aVar2 = aVar;
                                                                aVar2.mo153width((BackgroundItem.access$getAttr(BackgroundItem.this).getItemWidth() * 73) / 105);
                                                                aVar2.mo141height(f16);
                                                                final BackgroundItem backgroundItem11 = BackgroundItem.this;
                                                                aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.3.3.2.1.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        String str9;
                                                                        ce ceVar2 = ceVar;
                                                                        BackgroundItemAttr access$getAttr = BackgroundItem.access$getAttr(BackgroundItem.this);
                                                                        if (((Boolean) access$getAttr.isDressUp$delegate.getValue(access$getAttr, BackgroundItemAttr.$$delegatedProperties[1])).booleanValue()) {
                                                                            str9 = "\u518d\u6b21\u88c5\u626e";
                                                                        } else {
                                                                            str9 = "\u7acb\u5373\u88c5\u626e";
                                                                        }
                                                                        ceVar2.text(str9);
                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                aVar2.backgroundColor(h.INSTANCE.o("0xFFebedf5"));
                                                                aVar2.borderRadius(f16 / 2);
                                                                StringBuilder sb5 = new StringBuilder();
                                                                sb5.append(BackgroundItem.access$getAttr(BackgroundItem.this).title);
                                                                sb5.append(TokenParser.SP);
                                                                BackgroundItemAttr access$getAttr = BackgroundItem.access$getAttr(BackgroundItem.this);
                                                                if (((Boolean) access$getAttr.isDressUp$delegate.getValue(access$getAttr, BackgroundItemAttr.$$delegatedProperties[1])).booleanValue()) {
                                                                    str8 = "\u518d\u6b21\u88c5\u626e";
                                                                } else {
                                                                    str8 = "\u7acb\u5373\u88c5\u626e";
                                                                }
                                                                sb5.append(str8);
                                                                aVar2.accessibility(sb5.toString());
                                                                aVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final BackgroundItem backgroundItem10 = BackgroundItem.this;
                                                final String str8 = str7;
                                                vipTrackerView6.event(new Function1<VipTrackerViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.3.3.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(VipTrackerViewEvent vipTrackerViewEvent) {
                                                        final VipTrackerView vipTrackerView7 = VipTrackerView.this;
                                                        final BackgroundItem backgroundItem11 = backgroundItem10;
                                                        final String str9 = str8;
                                                        vipTrackerViewEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.view.BackgroundItem.body.1.2.2.3.3.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                HashMap<String, Object> extProps;
                                                                String base64String = ParamExtKt.getTraceDetailInfo(VipTrackerView.this).toBase64String();
                                                                BackgroundItem backgroundItem12 = backgroundItem11;
                                                                e eVar = new e();
                                                                BackgroundItem backgroundItem13 = backgroundItem11;
                                                                String str10 = str9;
                                                                eVar.v("module_id", BackgroundItem.access$getAttr(backgroundItem13).moduleId);
                                                                eVar.v("item_id", BackgroundItem.access$getAttr(backgroundItem13).itemId);
                                                                eVar.v("trace_detail", base64String);
                                                                BaseReportInfo reportInfo = ReportInfoExtKt.getReportInfo(VasBasePage.Companion.getCtx());
                                                                eVar.v("item_type", String.valueOf((reportInfo == null || (extProps = reportInfo.getExtProps()) == null) ? null : extProps.get("shopId")));
                                                                eVar.v("sub_module_id", str10);
                                                                eVar.v("from", "btn");
                                                                Unit unit = Unit.INSTANCE;
                                                                backgroundItem12.emit("item_click", eVar);
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
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new BackgroundItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new BgEvent();
    }
}

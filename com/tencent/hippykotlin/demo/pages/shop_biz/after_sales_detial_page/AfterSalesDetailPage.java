package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.ECErrorView;
import com.tencent.hippykotlin.demo.pages.base.ECErrorViewKt;
import com.tencent.hippykotlin.demo.pages.base.ErrorViewEvent;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes33.dex */
public final class AfterSalesDetailPage extends BasePager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public boolean didReportPageCostTime;
    public Boolean isPageDidDisappear;
    public final AfterSalesDetailPageAttr pageAttr = new AfterSalesDetailPageAttr();
    public AfterSalesDetailRequestModel requestModel;

    public static final void access$reportPageCostTimeIfNeed(AfterSalesDetailPage afterSalesDetailPage, boolean z16) {
        if (afterSalesDetailPage.didReportPageCostTime) {
            return;
        }
        afterSalesDetailPage.didReportPageCostTime = true;
        if (z16) {
            Utils.INSTANCE.bridgeModule(afterSalesDetailPage.getPagerId()).callNativeMethod("reportPageCostTimeForSuccess", null, null);
        } else {
            Utils.INSTANCE.bridgeModule(afterSalesDetailPage.getPagerId()).callNativeMethod("reportPageCostTimeForError", null, null);
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        mVar2.mo113backgroundColor(SkinColor.INSTANCE.bgColor(mVar2.getPagerId()));
                        return Unit.INSTANCE;
                    }
                });
                final AfterSalesDetailPage afterSalesDetailPage = AfterSalesDetailPage.this;
                ASDNavigationBarKt.NavBar(viewContainer2, new Function1<ASDNavigationBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ASDNavigationBar aSDNavigationBar) {
                        final AfterSalesDetailPage afterSalesDetailPage2 = AfterSalesDetailPage.this;
                        aSDNavigationBar.attr(new Function1<NavBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NavBarAttr navBarAttr) {
                                AfterSalesDetailPageAttr afterSalesDetailPageAttr = AfterSalesDetailPage.this.pageAttr;
                                navBarAttr.setNavTitle((String) afterSalesDetailPageAttr.pageTitle$delegate.getValue(afterSalesDetailPageAttr, AfterSalesDetailPageAttr.$$delegatedProperties[2]));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final AfterSalesDetailPage afterSalesDetailPage2 = AfterSalesDetailPage.this;
                ar.a(viewContainer2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aq<?, ?> aqVar) {
                        aq<?, ?> aqVar2 = aqVar;
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                aoVar.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final AfterSalesDetailPage afterSalesDetailPage3 = AfterSalesDetailPage.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return AfterSalesDetailPage.this.pageAttr.getProcessStatusData();
                            }
                        };
                        final AfterSalesDetailPage afterSalesDetailPage4 = AfterSalesDetailPage.this;
                        BindDirectivesViewKt.a(aqVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                final AfterSalesDetailPage afterSalesDetailPage5 = AfterSalesDetailPage.this;
                                bindDirectivesView.addChild(new ASDProcessStatusView(), new Function1<ASDProcessStatusView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ASDProcessStatusView aSDProcessStatusView) {
                                        final AfterSalesDetailPage afterSalesDetailPage6 = AfterSalesDetailPage.this;
                                        aSDProcessStatusView.attr(new Function1<ASDProcessStatusViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.3.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ASDProcessStatusViewAttr aSDProcessStatusViewAttr) {
                                                int i3;
                                                ArrayList<HyperTextSpan> arrayList;
                                                ASDProcessStatusViewAttr aSDProcessStatusViewAttr2 = aSDProcessStatusViewAttr;
                                                ProcessStatusCard processStatusData = AfterSalesDetailPage.this.pageAttr.getProcessStatusData();
                                                Intrinsics.checkNotNull(processStatusData);
                                                if (!aSDProcessStatusViewAttr2.getProcessStatusList().isEmpty()) {
                                                    aSDProcessStatusViewAttr2.getProcessStatusList().clear();
                                                }
                                                String str = processStatusData.tipsTextBig;
                                                ReadWriteProperty readWriteProperty = aSDProcessStatusViewAttr2.title$delegate;
                                                KProperty<?>[] kPropertyArr = ASDProcessStatusViewAttr.$$delegatedProperties;
                                                readWriteProperty.setValue(aSDProcessStatusViewAttr2, kPropertyArr[1], str);
                                                aSDProcessStatusViewAttr2.subTitle$delegate.setValue(aSDProcessStatusViewAttr2, kPropertyArr[2], processStatusData.tipsTextSmall);
                                                ArrayList<ProcessStatus> arrayList2 = processStatusData.processStatuses;
                                                if (arrayList2 != null) {
                                                    Iterator<ProcessStatus> it = arrayList2.iterator();
                                                    int i16 = 0;
                                                    i3 = 0;
                                                    while (it.hasNext()) {
                                                        if (it.next().isCurrentStatus) {
                                                            i3 = i16;
                                                        }
                                                        i16++;
                                                    }
                                                } else {
                                                    i3 = 0;
                                                }
                                                ArrayList<ProcessStatus> arrayList3 = processStatusData.processStatuses;
                                                if (arrayList3 != null) {
                                                    Iterator<ProcessStatus> it5 = arrayList3.iterator();
                                                    int i17 = 0;
                                                    while (it5.hasNext()) {
                                                        ProcessStatus next = it5.next();
                                                        ProcessStatusItem processStatusItem = new ProcessStatusItem();
                                                        processStatusItem.index = i17;
                                                        processStatusItem.statusText = next.statusText;
                                                        processStatusItem.dottedLine = i17 > i3;
                                                        aSDProcessStatusViewAttr2.getProcessStatusList().add(processStatusItem);
                                                        i17++;
                                                    }
                                                }
                                                ArrayList arrayList4 = new ArrayList();
                                                HyperText hyperText = processStatusData.progressDescription;
                                                if (hyperText != null && (arrayList = hyperText.hyperTextSpans) != null) {
                                                    Iterator<HyperTextSpan> it6 = arrayList.iterator();
                                                    while (it6.hasNext()) {
                                                        HyperTextSpan next2 = it6.next();
                                                        cf cfVar = new cf();
                                                        int i18 = next2.colorStyle;
                                                        if (i18 == 2) {
                                                            cfVar.color(4294914928L);
                                                        } else if (i18 == 3) {
                                                            cfVar.color(4278229503L);
                                                        } else {
                                                            cfVar.color(SkinColor.INSTANCE.blackTextColor(aSDProcessStatusViewAttr2.getPagerId()));
                                                        }
                                                        cfVar.text(next2.content);
                                                        ce.fontSize$default(cfVar, 13.0f, null, 2, null);
                                                        arrayList4.add(cfVar);
                                                    }
                                                }
                                                aSDProcessStatusViewAttr2.hyperTextSpanList$delegate.setValue(aSDProcessStatusViewAttr2, ASDProcessStatusViewAttr.$$delegatedProperties[3], arrayList4);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final AfterSalesDetailPage afterSalesDetailPage5 = AfterSalesDetailPage.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                AfterSalesDetailPageAttr afterSalesDetailPageAttr = AfterSalesDetailPage.this.pageAttr;
                                return (Bulletin) afterSalesDetailPageAttr.bulletin$delegate.getValue(afterSalesDetailPageAttr, AfterSalesDetailPageAttr.$$delegatedProperties[11]);
                            }
                        };
                        final AfterSalesDetailPage afterSalesDetailPage6 = AfterSalesDetailPage.this;
                        BindDirectivesViewKt.a(aqVar2, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                final AfterSalesDetailPage afterSalesDetailPage7 = AfterSalesDetailPage.this;
                                bindDirectivesView.addChild(new ASDBulletinBarView(), new Function1<ASDBulletinBarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ASDBulletinBarView aSDBulletinBarView) {
                                        final AfterSalesDetailPage afterSalesDetailPage8 = AfterSalesDetailPage.this;
                                        aSDBulletinBarView.attr(new Function1<ASDBulletinBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.5.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ASDBulletinBarAttr aSDBulletinBarAttr) {
                                                ASDBulletinBarAttr aSDBulletinBarAttr2 = aSDBulletinBarAttr;
                                                AfterSalesDetailPageAttr afterSalesDetailPageAttr = AfterSalesDetailPage.this.pageAttr;
                                                Bulletin bulletin = (Bulletin) afterSalesDetailPageAttr.bulletin$delegate.getValue(afterSalesDetailPageAttr, AfterSalesDetailPageAttr.$$delegatedProperties[11]);
                                                Intrinsics.checkNotNull(bulletin);
                                                aSDBulletinBarAttr2.bulletin = bulletin;
                                                aSDBulletinBarAttr2.reportModel = AfterSalesDetailPage.this.pageAttr.reportModel;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final AfterSalesDetailPage afterSalesDetailPage7 = AfterSalesDetailPage.this;
                        Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.6
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return AfterSalesDetailPage.this.pageAttr.getLogisticsCard();
                            }
                        };
                        final AfterSalesDetailPage afterSalesDetailPage8 = AfterSalesDetailPage.this;
                        BindDirectivesViewKt.a(aqVar2, function03, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.7
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                final AfterSalesDetailPage afterSalesDetailPage9 = AfterSalesDetailPage.this;
                                bindDirectivesView.addChild(new ASDLogisticsCardView(), new Function1<ASDLogisticsCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.7.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ASDLogisticsCardView aSDLogisticsCardView) {
                                        final AfterSalesDetailPage afterSalesDetailPage10 = AfterSalesDetailPage.this;
                                        aSDLogisticsCardView.attr(new Function1<ASDLogisticsCardViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.7.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ASDLogisticsCardViewAttr aSDLogisticsCardViewAttr) {
                                                ASDLogisticsCardViewAttr aSDLogisticsCardViewAttr2 = aSDLogisticsCardViewAttr;
                                                LogisticsCard logisticsCard = AfterSalesDetailPage.this.pageAttr.getLogisticsCard();
                                                Intrinsics.checkNotNull(logisticsCard);
                                                aSDLogisticsCardViewAttr2.getClass();
                                                String str = logisticsCard.title;
                                                ReadWriteProperty readWriteProperty = aSDLogisticsCardViewAttr2.title$delegate;
                                                KProperty<?>[] kPropertyArr = ASDLogisticsCardViewAttr.$$delegatedProperties;
                                                readWriteProperty.setValue(aSDLogisticsCardViewAttr2, kPropertyArr[0], str);
                                                aSDLogisticsCardViewAttr2.content$delegate.setValue(aSDLogisticsCardViewAttr2, kPropertyArr[1], logisticsCard.content);
                                                aSDLogisticsCardViewAttr2.jumpUrl$delegate.setValue(aSDLogisticsCardViewAttr2, kPropertyArr[3], logisticsCard.logisticsDetailUrl);
                                                aSDLogisticsCardViewAttr2.showBtn$delegate.setValue(aSDLogisticsCardViewAttr2, kPropertyArr[4], Boolean.valueOf(logisticsCard.hasSubmitButton));
                                                if (((Boolean) aSDLogisticsCardViewAttr2.showBtn$delegate.getValue(aSDLogisticsCardViewAttr2, kPropertyArr[4])).booleanValue()) {
                                                    aSDLogisticsCardViewAttr2.setIconUrl("qecommerce_skin_icon_general_location_primary");
                                                } else {
                                                    if (((String) aSDLogisticsCardViewAttr2.title$delegate.getValue(aSDLogisticsCardViewAttr2, kPropertyArr[0])).length() > 0) {
                                                        aSDLogisticsCardViewAttr2.setIconUrl("qecommerce_skin_icon_general_log_primary");
                                                    } else {
                                                        aSDLogisticsCardViewAttr2.setIconUrl("");
                                                    }
                                                }
                                                AfterSalesDetailRspModel afterSalesDetailRspModel = AfterSalesDetailPage.this.pageAttr.rspModel;
                                                Intrinsics.checkNotNull(afterSalesDetailRspModel);
                                                aSDLogisticsCardViewAttr2.rspModel = afterSalesDetailRspModel;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final AfterSalesDetailPage afterSalesDetailPage9 = AfterSalesDetailPage.this;
                        Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.8
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return AfterSalesDetailPage.this.pageAttr.getRefundProgressCard();
                            }
                        };
                        final AfterSalesDetailPage afterSalesDetailPage10 = AfterSalesDetailPage.this;
                        BindDirectivesViewKt.a(aqVar2, function04, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.9
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                final AfterSalesDetailPage afterSalesDetailPage11 = AfterSalesDetailPage.this;
                                bindDirectivesView.addChild(new ASDRefundProgressCardView(), new Function1<ASDRefundProgressCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.9.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ASDRefundProgressCardView aSDRefundProgressCardView) {
                                        final AfterSalesDetailPage afterSalesDetailPage12 = AfterSalesDetailPage.this;
                                        aSDRefundProgressCardView.attr(new Function1<ASDRefundProgressCardViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.9.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ASDRefundProgressCardViewAttr aSDRefundProgressCardViewAttr) {
                                                ArrayList<RefundProgressRecord> arrayList;
                                                Object last;
                                                ASDRefundProgressCardViewAttr aSDRefundProgressCardViewAttr2 = aSDRefundProgressCardViewAttr;
                                                RefundProgressCard refundProgressCard = AfterSalesDetailPage.this.pageAttr.getRefundProgressCard();
                                                Intrinsics.checkNotNull(refundProgressCard);
                                                aSDRefundProgressCardViewAttr2.getClass();
                                                boolean z16 = false;
                                                aSDRefundProgressCardViewAttr2.actualAmount$delegate.setValue(aSDRefundProgressCardViewAttr2, ASDRefundProgressCardViewAttr.$$delegatedProperties[0], refundProgressCard.actualAmount);
                                                if (!aSDRefundProgressCardViewAttr2.getRefundRecords().isEmpty()) {
                                                    aSDRefundProgressCardViewAttr2.getRefundRecords().clear();
                                                }
                                                if (refundProgressCard.refundRecords != null && (!r1.isEmpty())) {
                                                    z16 = true;
                                                }
                                                if (z16 && (arrayList = refundProgressCard.refundRecords) != null) {
                                                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
                                                }
                                                ArrayList<RefundProgressRecord> arrayList2 = refundProgressCard.refundRecords;
                                                if (arrayList2 != null) {
                                                    Iterator<RefundProgressRecord> it = arrayList2.iterator();
                                                    while (it.hasNext()) {
                                                        aSDRefundProgressCardViewAttr2.getRefundRecords().add(it.next());
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
                        final AfterSalesDetailPage afterSalesDetailPage11 = AfterSalesDetailPage.this;
                        Function0<Object> function05 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.10
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                AfterSalesDetailPageAttr afterSalesDetailPageAttr = AfterSalesDetailPage.this.pageAttr;
                                return Boolean.valueOf(!(((OrderCard) afterSalesDetailPageAttr.orderCard$delegate.getValue(afterSalesDetailPageAttr, AfterSalesDetailPageAttr.$$delegatedProperties[7])).goodTitle.length() == 0));
                            }
                        };
                        final AfterSalesDetailPage afterSalesDetailPage12 = AfterSalesDetailPage.this;
                        ConditionViewKt.c(aqVar2, function05, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.11
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                ConditionView conditionView2 = conditionView;
                                final AfterSalesDetailPage afterSalesDetailPage13 = AfterSalesDetailPage.this;
                                ConditionViewKt.c(conditionView2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.11.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        HyperText hyperText;
                                        ArrayList<HyperTextSpan> arrayList;
                                        boolean z16 = true;
                                        if (AfterSalesDetailPage.this.pageAttr.getRefundProgressCard() == null && AfterSalesDetailPage.this.pageAttr.getLogisticsCard() == null) {
                                            ProcessStatusCard processStatusData = AfterSalesDetailPage.this.pageAttr.getProcessStatusData();
                                            if (!((processStatusData == null || (hyperText = processStatusData.progressDescription) == null || (arrayList = hyperText.hyperTextSpans) == null || !(arrayList.isEmpty() ^ true)) ? false : true)) {
                                                z16 = false;
                                            }
                                        }
                                        return Boolean.valueOf(z16);
                                    }
                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.11.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView3) {
                                        w.a(conditionView3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.11.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.11.2.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        tVar.mo141height(8.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final AfterSalesDetailPage afterSalesDetailPage14 = AfterSalesDetailPage.this;
                                conditionView2.addChild(new ASDOrderCardView(), new Function1<ASDOrderCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.11.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ASDOrderCardView aSDOrderCardView) {
                                        final AfterSalesDetailPage afterSalesDetailPage15 = AfterSalesDetailPage.this;
                                        aSDOrderCardView.attr(new Function1<ASDOrderCardViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.11.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ASDOrderCardViewAttr aSDOrderCardViewAttr) {
                                                ASDOrderCardViewAttr aSDOrderCardViewAttr2 = aSDOrderCardViewAttr;
                                                AfterSalesDetailPageAttr afterSalesDetailPageAttr = AfterSalesDetailPage.this.pageAttr;
                                                OrderCard orderCard = (OrderCard) afterSalesDetailPageAttr.orderCard$delegate.getValue(afterSalesDetailPageAttr, AfterSalesDetailPageAttr.$$delegatedProperties[7]);
                                                Intrinsics.checkNotNull(orderCard, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.OrderCard");
                                                aSDOrderCardViewAttr2.orderCard = orderCard;
                                                AfterSalesDetailRspModel afterSalesDetailRspModel = AfterSalesDetailPage.this.pageAttr.rspModel;
                                                Intrinsics.checkNotNull(afterSalesDetailRspModel);
                                                aSDOrderCardViewAttr2.rspModel = afterSalesDetailRspModel;
                                                aSDOrderCardViewAttr2.reportModel = AfterSalesDetailPage.this.pageAttr.reportModel;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final AfterSalesDetailPage afterSalesDetailPage13 = AfterSalesDetailPage.this;
                        Function0<Object> function06 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.12
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                AfterSalesDetailPageAttr afterSalesDetailPageAttr = AfterSalesDetailPage.this.pageAttr;
                                return (String) afterSalesDetailPageAttr.refundAmount$delegate.getValue(afterSalesDetailPageAttr, AfterSalesDetailPageAttr.$$delegatedProperties[8]);
                            }
                        };
                        final AfterSalesDetailPage afterSalesDetailPage14 = AfterSalesDetailPage.this;
                        BindDirectivesViewKt.a(aqVar2, function06, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.13
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                final AfterSalesDetailPage afterSalesDetailPage15 = AfterSalesDetailPage.this;
                                bindDirectivesView.addChild(new ASDRefundAmountCardView(), new Function1<ASDRefundAmountCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.13.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ASDRefundAmountCardView aSDRefundAmountCardView) {
                                        final AfterSalesDetailPage afterSalesDetailPage16 = AfterSalesDetailPage.this;
                                        aSDRefundAmountCardView.attr(new Function1<ASDRefundAmountCardViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.13.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ASDRefundAmountCardViewAttr aSDRefundAmountCardViewAttr) {
                                                ASDRefundAmountCardViewAttr aSDRefundAmountCardViewAttr2 = aSDRefundAmountCardViewAttr;
                                                AfterSalesDetailPageAttr afterSalesDetailPageAttr = AfterSalesDetailPage.this.pageAttr;
                                                ReadWriteProperty readWriteProperty = afterSalesDetailPageAttr.refundAmount$delegate;
                                                KProperty<?>[] kPropertyArr = AfterSalesDetailPageAttr.$$delegatedProperties;
                                                String str = (String) readWriteProperty.getValue(afterSalesDetailPageAttr, kPropertyArr[8]);
                                                Intrinsics.checkNotNull(str);
                                                ReadWriteProperty readWriteProperty2 = aSDRefundAmountCardViewAttr2.refundAmount$delegate;
                                                KProperty<?>[] kPropertyArr2 = ASDRefundAmountCardViewAttr.$$delegatedProperties;
                                                readWriteProperty2.setValue(aSDRefundAmountCardViewAttr2, kPropertyArr2[1], str);
                                                AfterSalesDetailPageAttr afterSalesDetailPageAttr2 = AfterSalesDetailPage.this.pageAttr;
                                                aSDRefundAmountCardViewAttr2.goodsNum$delegate.setValue(aSDRefundAmountCardViewAttr2, kPropertyArr2[0], (String) afterSalesDetailPageAttr2.goodsNum$delegate.getValue(afterSalesDetailPageAttr2, kPropertyArr[9]));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final AfterSalesDetailPage afterSalesDetailPage15 = AfterSalesDetailPage.this;
                        Function0<Object> function07 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.14
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return AfterSalesDetailPage.this.pageAttr.getDetailInfoCard();
                            }
                        };
                        final AfterSalesDetailPage afterSalesDetailPage16 = AfterSalesDetailPage.this;
                        BindDirectivesViewKt.a(aqVar2, function07, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.15
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                final AfterSalesDetailPage afterSalesDetailPage17 = AfterSalesDetailPage.this;
                                bindDirectivesView.addChild(new ASDDetailInfoCardViewView(), new Function1<ASDDetailInfoCardViewView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.15.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ASDDetailInfoCardViewView aSDDetailInfoCardViewView) {
                                        final AfterSalesDetailPage afterSalesDetailPage18 = AfterSalesDetailPage.this;
                                        aSDDetailInfoCardViewView.attr(new Function1<ASDDetailInfoCardViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.15.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ASDDetailInfoCardViewAttr aSDDetailInfoCardViewAttr) {
                                                DetailInfoCard detailInfoCard = AfterSalesDetailPage.this.pageAttr.getDetailInfoCard();
                                                Intrinsics.checkNotNull(detailInfoCard);
                                                aSDDetailInfoCardViewAttr.detailInfo = detailInfoCard;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final AfterSalesDetailPage afterSalesDetailPage17 = AfterSalesDetailPage.this;
                        Function0<Object> function08 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.16
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return AfterSalesDetailPage.this.pageAttr.getDetailInfoCard();
                            }
                        };
                        final AfterSalesDetailPage afterSalesDetailPage18 = AfterSalesDetailPage.this;
                        ConditionViewKt.c(aqVar2, function08, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.17
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final AfterSalesDetailPage afterSalesDetailPage19 = AfterSalesDetailPage.this;
                                conditionView.addChild(new ASDNegotiationHistoryCardView(), new Function1<ASDNegotiationHistoryCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.17.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ASDNegotiationHistoryCardView aSDNegotiationHistoryCardView) {
                                        final AfterSalesDetailPage afterSalesDetailPage20 = AfterSalesDetailPage.this;
                                        aSDNegotiationHistoryCardView.attr(new Function1<ASDNegotiationHistoryCardViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.17.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ASDNegotiationHistoryCardViewAttr aSDNegotiationHistoryCardViewAttr) {
                                                ASDNegotiationHistoryCardViewAttr aSDNegotiationHistoryCardViewAttr2 = aSDNegotiationHistoryCardViewAttr;
                                                AfterSalesDetailRspModel afterSalesDetailRspModel = AfterSalesDetailPage.this.pageAttr.rspModel;
                                                Intrinsics.checkNotNull(afterSalesDetailRspModel);
                                                aSDNegotiationHistoryCardViewAttr2.rspModel = afterSalesDetailRspModel;
                                                aSDNegotiationHistoryCardViewAttr2.reportModel = AfterSalesDetailPage.this.pageAttr.reportModel;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.18
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.3.18.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.mo141height(34.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final AfterSalesDetailPage afterSalesDetailPage3 = AfterSalesDetailPage.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        AfterSalesDetailPageAttr afterSalesDetailPageAttr = AfterSalesDetailPage.this.pageAttr;
                        return (OperationPrivilege) afterSalesDetailPageAttr.operationPrivilege$delegate.getValue(afterSalesDetailPageAttr, AfterSalesDetailPageAttr.$$delegatedProperties[3]);
                    }
                };
                final AfterSalesDetailPage afterSalesDetailPage4 = AfterSalesDetailPage.this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        final AfterSalesDetailPage afterSalesDetailPage5 = AfterSalesDetailPage.this;
                        bindDirectivesView.addChild(new ASDBottomBar(), new Function1<ASDBottomBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ASDBottomBar aSDBottomBar) {
                                ASDBottomBar aSDBottomBar2 = aSDBottomBar;
                                final AfterSalesDetailPage afterSalesDetailPage6 = AfterSalesDetailPage.this;
                                aSDBottomBar2.attr(new Function1<ASDBottomBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.5.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ASDBottomBarAttr aSDBottomBarAttr) {
                                        ASDBottomBarAttr aSDBottomBarAttr2 = aSDBottomBarAttr;
                                        AfterSalesDetailPageAttr afterSalesDetailPageAttr = AfterSalesDetailPage.this.pageAttr;
                                        OperationPrivilege operationPrivilege = (OperationPrivilege) afterSalesDetailPageAttr.operationPrivilege$delegate.getValue(afterSalesDetailPageAttr, AfterSalesDetailPageAttr.$$delegatedProperties[3]);
                                        Intrinsics.checkNotNull(operationPrivilege);
                                        aSDBottomBarAttr2.operationPrivilege = operationPrivilege;
                                        AfterSalesDetailRspModel afterSalesDetailRspModel = AfterSalesDetailPage.this.pageAttr.rspModel;
                                        Intrinsics.checkNotNull(afterSalesDetailRspModel);
                                        aSDBottomBarAttr2.rspModel = afterSalesDetailRspModel;
                                        aSDBottomBarAttr2.reportModel = AfterSalesDetailPage.this.pageAttr.reportModel;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final AfterSalesDetailPage afterSalesDetailPage7 = AfterSalesDetailPage.this;
                                aSDBottomBar2.event(new Function1<ASDBottomBarEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.5.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ASDBottomBarEvent aSDBottomBarEvent) {
                                        final AfterSalesDetailPage afterSalesDetailPage8 = AfterSalesDetailPage.this;
                                        aSDBottomBarEvent.registerEvent("didCancelApply", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.5.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                AfterSalesDetailPage afterSalesDetailPage9 = AfterSalesDetailPage.this;
                                                int i3 = AfterSalesDetailPage.$r8$clinit;
                                                afterSalesDetailPage9.getClass();
                                                Utils.INSTANCE.bridgeModule(afterSalesDetailPage9.getPagerId()).log("AfterSalesDetailPage silenceUpdateData");
                                                afterSalesDetailPage9.requestData("");
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
                final AfterSalesDetailPage afterSalesDetailPage5 = AfterSalesDetailPage.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage$body$1.6
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        AfterSalesDetailPageAttr afterSalesDetailPageAttr = AfterSalesDetailPage.this.pageAttr;
                        return Boolean.valueOf(((Boolean) afterSalesDetailPageAttr.firstDataRequesting$delegate.getValue(afterSalesDetailPageAttr, AfterSalesDetailPageAttr.$$delegatedProperties[0])).booleanValue());
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage$body$1.7
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        conditionView.addChild(new ASDLoading(), new Function1<ASDLoading, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.7.1
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(ASDLoading aSDLoading) {
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final AfterSalesDetailPage afterSalesDetailPage6 = AfterSalesDetailPage.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage$body$1.8
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        AfterSalesDetailPageAttr afterSalesDetailPageAttr = AfterSalesDetailPage.this.pageAttr;
                        return Boolean.valueOf(((Boolean) afterSalesDetailPageAttr.showErrorView$delegate.getValue(afterSalesDetailPageAttr, AfterSalesDetailPageAttr.$$delegatedProperties[1])).booleanValue());
                    }
                };
                final AfterSalesDetailPage afterSalesDetailPage7 = AfterSalesDetailPage.this;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage$body$1.9
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final AfterSalesDetailPage afterSalesDetailPage8 = AfterSalesDetailPage.this;
                        ECErrorViewKt.ErrorView(conditionView, new Function1<ECErrorView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.9.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECErrorView eCErrorView) {
                                final AfterSalesDetailPage afterSalesDetailPage9 = AfterSalesDetailPage.this;
                                eCErrorView.event(new Function1<ErrorViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.9.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ErrorViewEvent errorViewEvent) {
                                        final AfterSalesDetailPage afterSalesDetailPage10 = AfterSalesDetailPage.this;
                                        errorViewEvent.registerEvent("clickRetryButton", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage.body.1.9.1.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                final AfterSalesDetailPage afterSalesDetailPage11 = AfterSalesDetailPage.this;
                                                AfterSalesDetailPageAttr afterSalesDetailPageAttr = afterSalesDetailPage11.pageAttr;
                                                ReadWriteProperty readWriteProperty = afterSalesDetailPageAttr.firstDataRequesting$delegate;
                                                KProperty<?>[] kPropertyArr = AfterSalesDetailPageAttr.$$delegatedProperties;
                                                readWriteProperty.setValue(afterSalesDetailPageAttr, kPropertyArr[0], Boolean.TRUE);
                                                AfterSalesDetailPageAttr afterSalesDetailPageAttr2 = afterSalesDetailPage11.pageAttr;
                                                afterSalesDetailPageAttr2.showErrorView$delegate.setValue(afterSalesDetailPageAttr2, kPropertyArr[1], Boolean.FALSE);
                                                TimerKt.f(afterSalesDetailPage11.getPagerId(), new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage$clickRetryButton$1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        AfterSalesDetailPage.this.requestData("");
                                                        return Unit.INSTANCE;
                                                    }
                                                }, 1000);
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

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.base.AbstractBaseView
    public final l createEvent() {
        return new l();
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        requestData("");
    }

    public final AfterSalesDetailRequestModel getRequestModel() {
        AfterSalesDetailRequestModel afterSalesDetailRequestModel = this.requestModel;
        if (afterSalesDetailRequestModel != null) {
            return afterSalesDetailRequestModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("requestModel");
        return null;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidAppear() {
        super.pageDidAppear();
        if (Intrinsics.areEqual(this.isPageDidDisappear, Boolean.TRUE)) {
            Utils.INSTANCE.bridgeModule(getPagerId()).log("AfterSalesDetailPage silenceUpdateData");
            requestData("");
        }
        this.isPageDidDisappear = Boolean.FALSE;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidDisappear() {
        super.pageDidDisappear();
        this.isPageDidDisappear = Boolean.TRUE;
    }

    public final void requestData(String str) {
        String p16 = getPageData().n().p("order_id");
        if (!(str.length() > 0)) {
            str = p16;
        }
        String p17 = getPageData().n().p("sku_id");
        this.requestModel = new AfterSalesDetailRequestModel(getPagerId());
        getRequestModel().orderId = str;
        if (str.length() == 0) {
            Utils.INSTANCE.bridgeModule(getPagerId()).log("error : orderId is empty");
        }
        getRequestModel().skuId = p17;
        getRequestModel().requestData(new Function3<e, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailPage$requestData$1
            {
                super(3);
            }

            /* JADX WARN: Removed duplicated region for block: B:41:0x00be  */
            /* JADX WARN: Removed duplicated region for block: B:47:0x00dd  */
            /* JADX WARN: Removed duplicated region for block: B:50:0x00ef  */
            /* JADX WARN: Removed duplicated region for block: B:53:0x0101  */
            /* JADX WARN: Removed duplicated region for block: B:66:0x0149  */
            /* JADX WARN: Removed duplicated region for block: B:69:0x015c  */
            /* JADX WARN: Removed duplicated region for block: B:72:0x016f  */
            /* JADX WARN: Removed duplicated region for block: B:74:0x015f  */
            /* JADX WARN: Removed duplicated region for block: B:75:0x014c  */
            /* JADX WARN: Removed duplicated region for block: B:76:0x0104  */
            /* JADX WARN: Removed duplicated region for block: B:77:0x00f2  */
            /* JADX WARN: Removed duplicated region for block: B:78:0x00e0  */
            /* JADX WARN: Removed duplicated region for block: B:80:0x00ce  */
            @Override // kotlin.jvm.functions.Function3
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(e eVar, Integer num, String str2) {
                String str3;
                boolean z16;
                AfterSalesDetailPageData afterSalesDetailPageData;
                AfterSalesDetailPageData afterSalesDetailPageData2;
                OrderCard orderCard;
                OrderCard orderCard2;
                OperationPrivilege operationPrivilege;
                AfterSalesDetailPageData afterSalesDetailPageData3;
                num.intValue();
                AfterSalesDetailPage afterSalesDetailPage = AfterSalesDetailPage.this;
                AfterSalesDetailPageAttr afterSalesDetailPageAttr = afterSalesDetailPage.pageAttr;
                boolean z17 = afterSalesDetailPage.getRequestModel().rspModel == null && AfterSalesDetailPage.this.pageAttr.rspModel == null;
                ReadWriteProperty readWriteProperty = afterSalesDetailPageAttr.showErrorView$delegate;
                KProperty<?>[] kPropertyArr = AfterSalesDetailPageAttr.$$delegatedProperties;
                readWriteProperty.setValue(afterSalesDetailPageAttr, kPropertyArr[1], Boolean.valueOf(z17));
                AfterSalesDetailPageAttr afterSalesDetailPageAttr2 = AfterSalesDetailPage.this.pageAttr;
                if (((Boolean) afterSalesDetailPageAttr2.showErrorView$delegate.getValue(afterSalesDetailPageAttr2, kPropertyArr[1])).booleanValue()) {
                    AfterSalesDetailPage.access$reportPageCostTimeIfNeed(AfterSalesDetailPage.this, false);
                }
                AfterSalesDetailRspModel afterSalesDetailRspModel = AfterSalesDetailPage.this.getRequestModel().rspModel;
                if (afterSalesDetailRspModel != null) {
                    AfterSalesDetailPage afterSalesDetailPage2 = AfterSalesDetailPage.this;
                    AfterSalesDetailPageAttr afterSalesDetailPageAttr3 = afterSalesDetailPage2.pageAttr;
                    afterSalesDetailPageAttr3.rspModel = afterSalesDetailRspModel;
                    if (afterSalesDetailPageAttr3.reportModel == null && (afterSalesDetailPageData3 = afterSalesDetailRspModel.detailPage) != null && afterSalesDetailPageData3.reportExt != null) {
                        String pagerId = afterSalesDetailPage2.getPagerId();
                        AfterSalesDetailRspModel afterSalesDetailRspModel2 = afterSalesDetailPage2.pageAttr.rspModel;
                        Intrinsics.checkNotNull(afterSalesDetailRspModel2);
                        afterSalesDetailPageAttr3.reportModel = new ASDReportModel(pagerId, afterSalesDetailRspModel2);
                        ASDReportModel aSDReportModel = afterSalesDetailPage2.pageAttr.reportModel;
                        if (aSDReportModel != null) {
                            aSDReportModel.reportDT("qstore_after_sales_detail_exp", new e());
                        }
                    }
                    AfterSalesDetailPageData afterSalesDetailPageData4 = afterSalesDetailRspModel.detailPage;
                    if (afterSalesDetailPageData4 != null && (str3 = afterSalesDetailPageData4.pageTitle) != null) {
                        AfterSalesDetailPageAttr afterSalesDetailPageAttr4 = afterSalesDetailPage2.pageAttr;
                        afterSalesDetailPageAttr4.pageTitle$delegate.setValue(afterSalesDetailPageAttr4, kPropertyArr[2], str3);
                        AfterSalesDetailPageData afterSalesDetailPageData5 = afterSalesDetailRspModel.detailPage;
                        if (afterSalesDetailPageData5 != null && (operationPrivilege = afterSalesDetailPageData5.operationPrivilege) != null) {
                            if (operationPrivilege.enableCancelApply || operationPrivilege.enableApplyAgain || operationPrivilege.enableApplyJudgement || operationPrivilege.enableContactPlatform) {
                                z16 = true;
                                if (!z16) {
                                    AfterSalesDetailPageAttr afterSalesDetailPageAttr5 = afterSalesDetailPage2.pageAttr;
                                    afterSalesDetailPageAttr5.operationPrivilege$delegate.setValue(afterSalesDetailPageAttr5, kPropertyArr[3], afterSalesDetailPageData5 != null ? afterSalesDetailPageData5.operationPrivilege : null);
                                } else {
                                    AfterSalesDetailPageAttr afterSalesDetailPageAttr6 = afterSalesDetailPage2.pageAttr;
                                    afterSalesDetailPageAttr6.operationPrivilege$delegate.setValue(afterSalesDetailPageAttr6, kPropertyArr[3], null);
                                }
                                AfterSalesDetailPageAttr afterSalesDetailPageAttr7 = afterSalesDetailPage2.pageAttr;
                                AfterSalesDetailPageData afterSalesDetailPageData6 = afterSalesDetailRspModel.detailPage;
                                afterSalesDetailPageAttr7.processStatusData$delegate.setValue(afterSalesDetailPageAttr7, kPropertyArr[4], afterSalesDetailPageData6 == null ? afterSalesDetailPageData6.processStatusCard : null);
                                AfterSalesDetailPageAttr afterSalesDetailPageAttr8 = afterSalesDetailPage2.pageAttr;
                                AfterSalesDetailPageData afterSalesDetailPageData7 = afterSalesDetailRspModel.detailPage;
                                afterSalesDetailPageAttr8.logisticsCard$delegate.setValue(afterSalesDetailPageAttr8, kPropertyArr[5], afterSalesDetailPageData7 == null ? afterSalesDetailPageData7.logisticsCard : null);
                                AfterSalesDetailPageAttr afterSalesDetailPageAttr9 = afterSalesDetailPage2.pageAttr;
                                AfterSalesDetailPageData afterSalesDetailPageData8 = afterSalesDetailRspModel.detailPage;
                                afterSalesDetailPageAttr9.refundProgressCard$delegate.setValue(afterSalesDetailPageAttr9, kPropertyArr[6], afterSalesDetailPageData8 == null ? afterSalesDetailPageData8.refundProgressCard : null);
                                afterSalesDetailPageData = afterSalesDetailRspModel.detailPage;
                                if (afterSalesDetailPageData != null && (orderCard2 = afterSalesDetailPageData.orderCard) != null) {
                                    AfterSalesDetailPageAttr afterSalesDetailPageAttr10 = afterSalesDetailPage2.pageAttr;
                                    afterSalesDetailPageAttr10.orderCard$delegate.setValue(afterSalesDetailPageAttr10, kPropertyArr[7], orderCard2);
                                    AfterSalesDetailPage.access$reportPageCostTimeIfNeed(afterSalesDetailPage2, true);
                                }
                                AfterSalesDetailPageAttr afterSalesDetailPageAttr11 = afterSalesDetailPage2.pageAttr;
                                afterSalesDetailPageAttr11.goodsNum$delegate.setValue(afterSalesDetailPageAttr11, kPropertyArr[9], "");
                                afterSalesDetailPageData2 = afterSalesDetailRspModel.detailPage;
                                if (afterSalesDetailPageData2 != null && (orderCard = afterSalesDetailPageData2.orderCard) != null) {
                                    AfterSalesDetailPageAttr afterSalesDetailPageAttr12 = afterSalesDetailPage2.pageAttr;
                                    afterSalesDetailPageAttr12.goodsNum$delegate.setValue(afterSalesDetailPageAttr12, kPropertyArr[9], orderCard.goodNum);
                                }
                                AfterSalesDetailPageAttr afterSalesDetailPageAttr13 = afterSalesDetailPage2.pageAttr;
                                AfterSalesDetailPageData afterSalesDetailPageData9 = afterSalesDetailRspModel.detailPage;
                                afterSalesDetailPageAttr13.refundAmount$delegate.setValue(afterSalesDetailPageAttr13, kPropertyArr[8], afterSalesDetailPageData9 == null ? afterSalesDetailPageData9.refundAmount : null);
                                AfterSalesDetailPageAttr afterSalesDetailPageAttr14 = afterSalesDetailPage2.pageAttr;
                                AfterSalesDetailPageData afterSalesDetailPageData10 = afterSalesDetailRspModel.detailPage;
                                afterSalesDetailPageAttr14.detailInfoCard$delegate.setValue(afterSalesDetailPageAttr14, kPropertyArr[10], afterSalesDetailPageData10 == null ? afterSalesDetailPageData10.detailInfoCard : null);
                                AfterSalesDetailPageAttr afterSalesDetailPageAttr15 = afterSalesDetailPage2.pageAttr;
                                AfterSalesDetailPageData afterSalesDetailPageData11 = afterSalesDetailRspModel.detailPage;
                                afterSalesDetailPageAttr15.bulletin$delegate.setValue(afterSalesDetailPageAttr15, kPropertyArr[11], afterSalesDetailPageData11 != null ? afterSalesDetailPageData11.bulletin : null);
                            }
                        }
                        z16 = false;
                        if (!z16) {
                        }
                        AfterSalesDetailPageAttr afterSalesDetailPageAttr72 = afterSalesDetailPage2.pageAttr;
                        AfterSalesDetailPageData afterSalesDetailPageData62 = afterSalesDetailRspModel.detailPage;
                        afterSalesDetailPageAttr72.processStatusData$delegate.setValue(afterSalesDetailPageAttr72, kPropertyArr[4], afterSalesDetailPageData62 == null ? afterSalesDetailPageData62.processStatusCard : null);
                        AfterSalesDetailPageAttr afterSalesDetailPageAttr82 = afterSalesDetailPage2.pageAttr;
                        AfterSalesDetailPageData afterSalesDetailPageData72 = afterSalesDetailRspModel.detailPage;
                        afterSalesDetailPageAttr82.logisticsCard$delegate.setValue(afterSalesDetailPageAttr82, kPropertyArr[5], afterSalesDetailPageData72 == null ? afterSalesDetailPageData72.logisticsCard : null);
                        AfterSalesDetailPageAttr afterSalesDetailPageAttr92 = afterSalesDetailPage2.pageAttr;
                        AfterSalesDetailPageData afterSalesDetailPageData82 = afterSalesDetailRspModel.detailPage;
                        afterSalesDetailPageAttr92.refundProgressCard$delegate.setValue(afterSalesDetailPageAttr92, kPropertyArr[6], afterSalesDetailPageData82 == null ? afterSalesDetailPageData82.refundProgressCard : null);
                        afterSalesDetailPageData = afterSalesDetailRspModel.detailPage;
                        if (afterSalesDetailPageData != null) {
                            AfterSalesDetailPageAttr afterSalesDetailPageAttr102 = afterSalesDetailPage2.pageAttr;
                            afterSalesDetailPageAttr102.orderCard$delegate.setValue(afterSalesDetailPageAttr102, kPropertyArr[7], orderCard2);
                            AfterSalesDetailPage.access$reportPageCostTimeIfNeed(afterSalesDetailPage2, true);
                        }
                        AfterSalesDetailPageAttr afterSalesDetailPageAttr112 = afterSalesDetailPage2.pageAttr;
                        afterSalesDetailPageAttr112.goodsNum$delegate.setValue(afterSalesDetailPageAttr112, kPropertyArr[9], "");
                        afterSalesDetailPageData2 = afterSalesDetailRspModel.detailPage;
                        if (afterSalesDetailPageData2 != null) {
                            AfterSalesDetailPageAttr afterSalesDetailPageAttr122 = afterSalesDetailPage2.pageAttr;
                            afterSalesDetailPageAttr122.goodsNum$delegate.setValue(afterSalesDetailPageAttr122, kPropertyArr[9], orderCard.goodNum);
                        }
                        AfterSalesDetailPageAttr afterSalesDetailPageAttr132 = afterSalesDetailPage2.pageAttr;
                        AfterSalesDetailPageData afterSalesDetailPageData92 = afterSalesDetailRspModel.detailPage;
                        afterSalesDetailPageAttr132.refundAmount$delegate.setValue(afterSalesDetailPageAttr132, kPropertyArr[8], afterSalesDetailPageData92 == null ? afterSalesDetailPageData92.refundAmount : null);
                        AfterSalesDetailPageAttr afterSalesDetailPageAttr142 = afterSalesDetailPage2.pageAttr;
                        AfterSalesDetailPageData afterSalesDetailPageData102 = afterSalesDetailRspModel.detailPage;
                        afterSalesDetailPageAttr142.detailInfoCard$delegate.setValue(afterSalesDetailPageAttr142, kPropertyArr[10], afterSalesDetailPageData102 == null ? afterSalesDetailPageData102.detailInfoCard : null);
                        AfterSalesDetailPageAttr afterSalesDetailPageAttr152 = afterSalesDetailPage2.pageAttr;
                        AfterSalesDetailPageData afterSalesDetailPageData112 = afterSalesDetailRspModel.detailPage;
                        afterSalesDetailPageAttr152.bulletin$delegate.setValue(afterSalesDetailPageAttr152, kPropertyArr[11], afterSalesDetailPageData112 != null ? afterSalesDetailPageData112.bulletin : null);
                    }
                }
                AfterSalesDetailPageAttr afterSalesDetailPageAttr16 = AfterSalesDetailPage.this.pageAttr;
                afterSalesDetailPageAttr16.firstDataRequesting$delegate.setValue(afterSalesDetailPageAttr16, kPropertyArr[0], Boolean.FALSE);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}

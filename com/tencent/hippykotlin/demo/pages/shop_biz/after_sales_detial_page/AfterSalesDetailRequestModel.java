package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.hippykotlin.demo.pages.base.SSORequestModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class AfterSalesDetailRequestModel extends SSORequestModel {
    public String orderId;
    public AfterSalesDetailRspModel rspModel;
    public String skuId;

    public AfterSalesDetailRequestModel(String str) {
        super(str);
        this.orderId = "";
        this.skuId = "";
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.SSORequestModel
    public final String cmd() {
        return "trpc.ecom.after_sales_svr.AfterSales/GetAfterSalesDetailPage";
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.SSORequestModel
    public final e reqParam() {
        e eVar = new e();
        eVar.v("order_id", this.orderId);
        eVar.v("sku_id", this.skuId);
        return eVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.SSORequestModel
    public final void requestData(final Function3<? super e, ? super Integer, ? super String, Unit> function3) {
        super.requestData(new Function3<e, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.AfterSalesDetailRequestModel$requestData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(e eVar, Integer num, String str) {
                b bVar;
                b bVar2;
                int i3;
                b bVar3;
                b bVar4;
                int i16;
                e eVar2 = eVar;
                int intValue = num.intValue();
                String str2 = str;
                if (eVar2.d() > 0) {
                    AfterSalesDetailRequestModel afterSalesDetailRequestModel = AfterSalesDetailRequestModel.this;
                    AfterSalesDetailRspModel afterSalesDetailRspModel = new AfterSalesDetailRspModel();
                    afterSalesDetailRequestModel.rspModel = afterSalesDetailRspModel;
                    e m3 = eVar2.m("detail_page");
                    if (m3 != null) {
                        AfterSalesDetailPageData afterSalesDetailPageData = new AfterSalesDetailPageData();
                        afterSalesDetailRspModel.detailPage = afterSalesDetailPageData;
                        m3.k("status", 0);
                        afterSalesDetailPageData.afterSalesId = m3.q("after_sales_id", "");
                        afterSalesDetailPageData.pageTitle = m3.q("page_title", "");
                        e m16 = m3.m("process_status_card");
                        if (m16 != null) {
                            ProcessStatusCard processStatusCard = new ProcessStatusCard();
                            afterSalesDetailPageData.processStatusCard = processStatusCard;
                            processStatusCard.tipsTextBig = m16.q("tips_text_big", "");
                            processStatusCard.tipsTextSmall = m16.q("tips_text_small", "");
                            processStatusCard.tipsTextSmall = m16.q("tips_text_small", "");
                            b l3 = m16.l("process_statuses");
                            if (l3 != null) {
                                processStatusCard.processStatuses = new ArrayList<>();
                                int c16 = l3.c();
                                int i17 = 0;
                                while (i17 < c16) {
                                    Object d16 = l3.d(i17);
                                    if (d16 != null) {
                                        ProcessStatus processStatus = new ProcessStatus();
                                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                        e eVar3 = (e) d16;
                                        bVar4 = l3;
                                        i16 = c16;
                                        eVar3.k("status_type", 0);
                                        processStatus.statusText = eVar3.q("status_text", "");
                                        processStatus.isCurrentStatus = eVar3.f("is_current_status");
                                        ArrayList<ProcessStatus> arrayList = processStatusCard.processStatuses;
                                        if (arrayList != null) {
                                            arrayList.add(processStatus);
                                        }
                                    } else {
                                        bVar4 = l3;
                                        i16 = c16;
                                    }
                                    i17++;
                                    l3 = bVar4;
                                    c16 = i16;
                                }
                            }
                            e m17 = m16.m("progress_description");
                            if (m17 != null) {
                                HyperText hyperText = new HyperText();
                                processStatusCard.progressDescription = hyperText;
                                b l16 = m17.l("hyper_text_spans");
                                if (l16 != null) {
                                    hyperText.hyperTextSpans = new ArrayList<>();
                                    int c17 = l16.c();
                                    int i18 = 0;
                                    while (i18 < c17) {
                                        Object d17 = l16.d(i18);
                                        if (d17 != null) {
                                            HyperTextSpan hyperTextSpan = new HyperTextSpan();
                                            Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                            e eVar4 = (e) d17;
                                            hyperTextSpan.content = eVar4.q("content", "");
                                            bVar3 = l16;
                                            hyperTextSpan.colorStyle = eVar4.k("color_style", 0);
                                            ArrayList<HyperTextSpan> arrayList2 = hyperText.hyperTextSpans;
                                            if (arrayList2 != null) {
                                                arrayList2.add(hyperTextSpan);
                                            }
                                        } else {
                                            bVar3 = l16;
                                        }
                                        i18++;
                                        l16 = bVar3;
                                    }
                                }
                            }
                        }
                        e m18 = m3.m("logistics_card");
                        if (m18 != null) {
                            LogisticsCard logisticsCard = new LogisticsCard();
                            afterSalesDetailPageData.logisticsCard = logisticsCard;
                            m18.q("icon_url", "");
                            logisticsCard.title = m18.q("title", "");
                            logisticsCard.content = m18.q("content", "");
                            logisticsCard.logisticsDetailUrl = m18.q("logistics_detail_url", "");
                            logisticsCard.hasSubmitButton = m18.g("has_submit_button", false);
                            logisticsCard.phoneNum = m18.q(AuthDevOpenUgActivity.KEY_PHONE_NUM, "");
                        }
                        e m19 = m3.m("product_card");
                        if (m19 != null) {
                            OrderCard orderCard = new OrderCard();
                            afterSalesDetailPageData.orderCard = orderCard;
                            orderCard.cover = m19.q("cover", "");
                            orderCard.goodTitle = m19.q("product_title", "");
                            orderCard.price = m19.q("price", "");
                            orderCard.goodNum = m19.q("product_num", "");
                            orderCard.specification = m19.q("specification", "");
                            e m26 = m19.m("shop_info");
                            if (m26 != null) {
                                ShopInfo shopInfo = new ShopInfo();
                                orderCard.shopInfo = shopInfo;
                                m26.q("shop_name", "");
                                m26.q("shop_img", "");
                                shopInfo.shopId = m26.q("shop_id", "");
                            }
                        }
                        e m27 = m3.m("refund_progress_card");
                        if (m27 != null) {
                            RefundProgressCard refundProgressCard = new RefundProgressCard();
                            afterSalesDetailPageData.refundProgressCard = refundProgressCard;
                            refundProgressCard.actualAmount = m27.q("actual_amount", "");
                            b l17 = m27.l("refund_records");
                            if (l17 != null) {
                                refundProgressCard.refundRecords = new ArrayList<>();
                                int c18 = l17.c();
                                int i19 = 0;
                                while (i19 < c18) {
                                    Object d18 = l17.d(i19);
                                    if (d18 != null) {
                                        RefundProgressRecord refundProgressRecord = new RefundProgressRecord();
                                        Intrinsics.checkNotNull(d18, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                        e eVar5 = (e) d18;
                                        bVar2 = l17;
                                        refundProgressRecord.title = eVar5.q("title", "");
                                        refundProgressRecord.content = eVar5.q("content", "");
                                        refundProgressRecord.recordTime = eVar5.q("record_time", "");
                                        i3 = c18;
                                        eVar5.g("is_lighted", false);
                                        ArrayList<RefundProgressRecord> arrayList3 = refundProgressCard.refundRecords;
                                        if (arrayList3 != null) {
                                            arrayList3.add(refundProgressRecord);
                                        }
                                    } else {
                                        bVar2 = l17;
                                        i3 = c18;
                                    }
                                    i19++;
                                    l17 = bVar2;
                                    c18 = i3;
                                }
                            }
                        }
                        afterSalesDetailPageData.refundAmount = m3.q("refund_amount", "");
                        e m28 = m3.m("detail_info_card");
                        if (m28 != null) {
                            DetailInfoCard detailInfoCard = new DetailInfoCard();
                            afterSalesDetailPageData.detailInfoCard = detailInfoCard;
                            b l18 = m28.l("records");
                            if (l18 != null) {
                                detailInfoCard.records = new ArrayList<>();
                                int c19 = l18.c();
                                int i26 = 0;
                                while (i26 < c19) {
                                    Object d19 = l18.d(i26);
                                    if (d19 != null) {
                                        DetailInfoRecord detailInfoRecord = new DetailInfoRecord();
                                        Intrinsics.checkNotNull(d19, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                        e eVar6 = (e) d19;
                                        bVar = l18;
                                        detailInfoRecord.title = eVar6.q("title", "");
                                        detailInfoRecord.content = eVar6.q("content", "");
                                        detailInfoRecord.detaiInfoType = eVar6.j("detail_info_type");
                                        eVar6.q("detail_link_url", "");
                                        ArrayList<DetailInfoRecord> arrayList4 = detailInfoCard.records;
                                        if (arrayList4 != null) {
                                            arrayList4.add(detailInfoRecord);
                                        }
                                    } else {
                                        bVar = l18;
                                    }
                                    i26++;
                                    l18 = bVar;
                                }
                            }
                        }
                        e m29 = m3.m("operation_privilege");
                        if (m29 != null) {
                            OperationPrivilege operationPrivilege = new OperationPrivilege();
                            afterSalesDetailPageData.operationPrivilege = operationPrivilege;
                            operationPrivilege.enableCancelApply = m29.g("enable_cancel_apply", false);
                            operationPrivilege.enableApplyAgain = m29.g("enable_apply_again", false);
                            operationPrivilege.enableApplyJudgement = m29.g("enable_apply_judgement", false);
                            operationPrivilege.enableContactPlatform = m29.g("enable_contact_platform", false);
                        }
                        afterSalesDetailPageData.processId = m3.q(CrashHianalyticsData.PROCESS_ID, "");
                        afterSalesDetailPageData.reportExt = m3.m("report_ext");
                        e m36 = m3.m("bulletin");
                        if (m36 != null) {
                            Bulletin bulletin = new Bulletin();
                            afterSalesDetailPageData.bulletin = bulletin;
                            bulletin.txt = m36.q(FileReaderHelper.TXT_EXT, "");
                        }
                    }
                }
                function3.invoke(eVar2, Integer.valueOf(intValue), str2);
                return Unit.INSTANCE;
            }
        });
    }
}

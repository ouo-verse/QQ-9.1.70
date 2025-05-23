package com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model;

import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.SSORequestModel;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class LiveExplainRequestModel extends SSORequestModel {
    public String gdtClickId;
    public int roomId;
    public LiveExplainDataRspModel rspModel;

    public LiveExplainRequestModel(String str) {
        super(str);
        this.gdtClickId = "";
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.SSORequestModel
    public final String cmd() {
        return "trpc.ecom.qqlive_window_read_svr.QqliveWindowReadSvr/GetBubbleInfo";
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.SSORequestModel
    public final e reqParam() {
        e eVar = new e();
        eVar.t(AudienceReportConst.ROOM_ID, this.roomId);
        eVar.t(WadlProxyConsts.CHANNEL, 8);
        b bVar = new b();
        if (this.gdtClickId.length() > 0) {
            e eVar2 = new e();
            eVar2.v("qz_gdt", this.gdtClickId);
            bVar.t(eVar2);
            Utils utils = Utils.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("LiveExplainRequestModel roomID:");
            m3.append(this.roomId);
            m3.append(" clickID ");
            m3.append(this.gdtClickId);
            utils.logToNative(m3.toString());
        }
        eVar.v("trans_kv", bVar);
        return eVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.SSORequestModel
    public final void requestData(final Function3<? super e, ? super Integer, ? super String, Unit> function3) {
        super.requestData(new Function3<e, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.LiveExplainRequestModel$requestData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(e eVar, Integer num, String str) {
                e eVar2 = eVar;
                int intValue = num.intValue();
                String str2 = str;
                if (eVar2.d() > 0) {
                    LiveExplainRequestModel liveExplainRequestModel = LiveExplainRequestModel.this;
                    LiveExplainDataRspModel liveExplainDataRspModel = new LiveExplainDataRspModel();
                    liveExplainRequestModel.rspModel = liveExplainDataRspModel;
                    e m3 = eVar2.m("bubble_info");
                    if (m3 != null) {
                        ExplainBubbleInfo explainBubbleInfo = new ExplainBubbleInfo();
                        liveExplainDataRspModel.bubbleInfo = explainBubbleInfo;
                        m3.q("rich_txt", "");
                        explainBubbleInfo.detailUrl = m3.q("detail_url", "");
                        e m16 = m3.m(ReportDataBuilder.KEY_PRODUCT_ID);
                        if (m16 != null) {
                            m16.k("goods_type", 0);
                            m16.q("media_product_id", "");
                            m16.q("shop_id", "");
                            m16.q("sku_id", "");
                            m16.q("activity_id", "");
                        }
                        explainBubbleInfo.reportInfo = m3.m(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO);
                        explainBubbleInfo.type = m3.k("type", 0);
                        e m17 = m3.m("detail");
                        if (m17 != null) {
                            ExplainBubbleDetail explainBubbleDetail = new ExplainBubbleDetail();
                            explainBubbleInfo.detail = explainBubbleDetail;
                            explainBubbleDetail.cover = m17.q("cover", "");
                            explainBubbleDetail.title = m17.q("title", "");
                            explainBubbleDetail.adTxt = m17.q("ad_txt", "");
                            e m18 = m17.m("price");
                            if (m18 != null) {
                                ExplainPrice explainPrice = new ExplainPrice();
                                explainBubbleDetail.price = explainPrice;
                                explainPrice.decode(m18);
                            }
                            e m19 = m17.m("ui_style");
                            if (m19 != null) {
                                ExplainUIStyle explainUIStyle = new ExplainUIStyle();
                                explainBubbleDetail.uiStyle = explainUIStyle;
                                m19.k("ui_type", 0);
                                explainUIStyle.uiTitle = m19.q("ui_title", "");
                            }
                            explainBubbleDetail.inventory = m17.k("inventory", 0);
                            explainBubbleDetail.salesCnt = m17.k("sales_cnt", 0);
                        }
                        e m26 = m3.m(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                        if (m26 != null) {
                            ExplainActivity explainActivity = new ExplainActivity();
                            explainBubbleInfo.activity = explainActivity;
                            e m27 = m26.m("price");
                            if (m27 != null) {
                                ExplainActivityPrice explainActivityPrice = new ExplainActivityPrice();
                                explainActivity.price = explainActivityPrice;
                                m27.k("original", 0);
                                m27.k("live", 0);
                                explainActivityPrice.liveSpecial = m27.k("live_special", 0);
                            }
                            m26.q("activity_id", "");
                            m26.q("info", "");
                            m26.k("activity_type", 0);
                            e m28 = m26.m("stock");
                            if (m28 != null) {
                                ExplainActiveStock explainActiveStock = new ExplainActiveStock();
                                explainActivity.stock = explainActiveStock;
                                explainActiveStock.total = m28.k("total", 0);
                                explainActiveStock.remain = m28.k("remain", 0);
                                m28.k("active", 0);
                            }
                            e m29 = m26.m("time_range");
                            if (m29 != null) {
                                ExplainTimeRange explainTimeRange = new ExplainTimeRange();
                                explainActivity.timeRange = explainTimeRange;
                                explainTimeRange.begin = m29.k("begin", 0);
                                m29.k("end", 0);
                            }
                            e m36 = m26.m(WSPublicAccReport.SOP_NAME_FOCUS);
                            if (m36 != null) {
                                m36.q("label", "");
                                m36.k("time_limit", 0);
                                m36.q("hot_icon", "");
                            }
                            explainActivity.status = m26.k("status", 0);
                            e m37 = m26.m("feed_selling");
                            if (m37 != null) {
                                e m38 = m37.m("title_left");
                                if (m38 != null) {
                                    m38.q("label", "");
                                    m38.k("time_limit", 0);
                                    m38.q("hot_icon", "");
                                }
                                e m39 = m37.m("middle_selling");
                                if (m39 != null) {
                                    m39.q("label", "");
                                    m39.k("time_limit", 0);
                                    m39.q("hot_icon", "");
                                }
                                e m46 = m37.m("discount_price");
                                if (m46 != null) {
                                    m46.q("label", "");
                                    m46.k("time_limit", 0);
                                    m46.q("hot_icon", "");
                                }
                            }
                            e m47 = m26.m("hot");
                            if (m47 != null) {
                                m47.q("prefix", "");
                                m47.k("sales_cnt", 0);
                                m47.m("extra");
                            }
                            explainActivity.f114288ts = m26.k("ts", 0);
                        }
                        e m48 = m3.m("coupon");
                        if (m48 != null) {
                            ExplainLiveCouponInfo explainLiveCouponInfo = new ExplainLiveCouponInfo();
                            explainBubbleInfo.coupon = explainLiveCouponInfo;
                            b l3 = m48.l("coupons");
                            if (l3 != null) {
                                explainLiveCouponInfo.coupons = new ArrayList<>();
                                int c16 = l3.c();
                                for (int i3 = 0; i3 < c16; i3++) {
                                    Object d16 = l3.d(i3);
                                    if (d16 != null) {
                                        ExplainLiveCouponDetail explainLiveCouponDetail = new ExplainLiveCouponDetail();
                                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                        e eVar3 = (e) d16;
                                        eVar3.q("coupon_batch_id", "");
                                        eVar3.q("msg", "");
                                        ArrayList<ExplainLiveCouponDetail> arrayList = explainLiveCouponInfo.coupons;
                                        if (arrayList != null) {
                                            arrayList.add(explainLiveCouponDetail);
                                        }
                                    }
                                }
                            }
                            e m49 = m48.m("after_coupon");
                            if (m49 != null) {
                                ExplainPrice explainPrice2 = new ExplainPrice();
                                explainLiveCouponInfo.afterCoupon = explainPrice2;
                                explainPrice2.decode(m49);
                            }
                        }
                        e m56 = m3.m("live_common_style_infos");
                        if (m56 != null) {
                            ExplainCommonShowStyle explainCommonShowStyle = new ExplainCommonShowStyle();
                            explainBubbleInfo.liveCommonStyleInfos = explainCommonShowStyle;
                            e m57 = m56.m("normal_style_info");
                            if (m57 != null) {
                                ExplainLiveShowItem explainLiveShowItem = new ExplainLiveShowItem();
                                explainCommonShowStyle.normalStyleInfo = explainLiveShowItem;
                                explainLiveShowItem.decode(m57);
                            }
                            e m58 = m56.m("coupon_style_info");
                            if (m58 != null) {
                                ExplainLiveShowItem explainLiveShowItem2 = new ExplainLiveShowItem();
                                explainCommonShowStyle.couponStyleInfo = explainLiveShowItem2;
                                explainLiveShowItem2.decode(m58);
                            }
                            e m59 = m56.m("live_active_style_info");
                            if (m59 != null) {
                                ExplainLiveShowItem explainLiveShowItem3 = new ExplainLiveShowItem();
                                explainCommonShowStyle.liveActiveStyleInfo = explainLiveShowItem3;
                                explainLiveShowItem3.decode(m59);
                            }
                        }
                    }
                }
                function3.invoke(eVar2, Integer.valueOf(intValue), str2);
                return Unit.INSTANCE;
            }
        });
    }
}

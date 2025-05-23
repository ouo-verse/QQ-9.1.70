package com.tencent.hippykotlin.demo.pages.nearby.feed_comment;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QuickCommentItem;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPCommentUtils;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NearbyFeedCommentPageViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFeedCommentPageViewModel.class, "quickComments", "getQuickComments()Ljava/util/List;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFeedCommentPageViewModel.class, "aiQuickComments", "getAiQuickComments()Ljava/util/List;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFeedCommentPageViewModel.class, "commentCount", "getCommentCount()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFeedCommentPageViewModel.class, "firstPageLoaded", "getFirstPageLoaded()Z", 0)};
    public final ReadWriteProperty aiQuickComments$delegate;
    public final ReadWriteProperty commentCount$delegate;
    public final ReadWriteProperty firstPageLoaded$delegate;
    public final NearbyFeedCommentPageData pageData;
    public final ReadWriteProperty quickComments$delegate;

    public NearbyFeedCommentPageViewModel(NearbyFeedCommentPageData nearbyFeedCommentPageData) {
        List emptyList;
        List emptyList2;
        this.pageData = nearbyFeedCommentPageData;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.quickComments$delegate = c.a(emptyList);
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.aiQuickComments$delegate = c.a(emptyList2);
        this.commentCount$delegate = c.a(0);
        this.firstPageLoaded$delegate = c.a(Boolean.FALSE);
        loadQuickCommentsData();
    }

    public final void dtReportQuickComment(String str, QuickCommentItem quickCommentItem) {
        e dTReportPageParams = getDTReportPageParams();
        dTReportPageParams.v("dt_eid", "em_nearby_quic_comment");
        dTReportPageParams.v("nearby_comment_id", quickCommentItem.f114209id);
        dTReportPageParams.v("cur_pg", getDTReportPageParams());
        dTReportPageParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, dTReportPageParams);
    }

    public final List<QuickCommentItem> getAiQuickComments() {
        return (List) this.aiQuickComments$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final e getDTReportPageParams() {
        e nearbyDTBaseParams = NearbyConstKt.getNearbyDTBaseParams();
        nearbyDTBaseParams.v("dt_pgid", "pg_nearby_comment_card_float");
        nearbyDTBaseParams.t("nearby_kl_appid", this.pageData.appId);
        nearbyDTBaseParams.t("nearby_kl_source", this.pageData.source);
        return nearbyDTBaseParams;
    }

    public final List<QuickCommentItem> getQuickComments() {
        return (List) this.quickComments$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void loadQuickCommentsData() {
        NBPCommentUtils nBPCommentUtils = NBPCommentUtils.INSTANCE;
        NearbyFeedCommentPageData nearbyFeedCommentPageData = this.pageData;
        nBPCommentUtils.loadQuickCommentsData(nearbyFeedCommentPageData.appId, nearbyFeedCommentPageData.feedId, new Function2<List<? extends QuickCommentItem>, List<? extends QuickCommentItem>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment.NearbyFeedCommentPageViewModel$loadQuickCommentsData$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(List<? extends QuickCommentItem> list, List<? extends QuickCommentItem> list2) {
                NearbyFeedCommentPageViewModel nearbyFeedCommentPageViewModel = NearbyFeedCommentPageViewModel.this;
                ReadWriteProperty readWriteProperty = nearbyFeedCommentPageViewModel.quickComments$delegate;
                KProperty<?>[] kPropertyArr = NearbyFeedCommentPageViewModel.$$delegatedProperties;
                readWriteProperty.setValue(nearbyFeedCommentPageViewModel, kPropertyArr[0], list);
                NearbyFeedCommentPageViewModel nearbyFeedCommentPageViewModel2 = NearbyFeedCommentPageViewModel.this;
                nearbyFeedCommentPageViewModel2.aiQuickComments$delegate.setValue(nearbyFeedCommentPageViewModel2, kPropertyArr[1], list2);
                return Unit.INSTANCE;
            }
        });
    }

    public final void dtReportPageExposure(boolean z16) {
        String str;
        if (z16) {
            str = "dt_pgin";
        } else {
            str = "dt_pgout";
        }
        e dTReportPageParams = getDTReportPageParams();
        dTReportPageParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, dTReportPageParams);
    }
}

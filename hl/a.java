package hl;

import bl.CommonNoticeBean;
import bl.f;
import com.qzone.common.account.LoginData;
import com.qzone.module.feedcomponent.ui.DataPreCalculateTool;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.reborn.message.data.QZonePassiveMessageFeedPreprocessor;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lhl/a;", "Lhl/d;", "", "getLogTag", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedList", "d2", "Lbl/a;", "Q1", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends d {
    @Override // hl.d
    public List<CommonNoticeBean> Q1(List<? extends BusinessFeedData> feedList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(feedList, "feedList");
        List<? extends BusinessFeedData> list = feedList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (BusinessFeedData businessFeedData : list) {
            f fVar = new f();
            fVar.q(businessFeedData);
            arrayList.add(new CommonNoticeBean(fVar, null, 2, null));
        }
        return arrayList;
    }

    @Override // hl.d, com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZOldStylePassiveMessageViewModel";
    }

    @Override // hl.d
    public List<BusinessFeedData> d2(List<? extends BusinessFeedData> feedList) {
        int collectionSizeOrDefault;
        CellCommentInfo commentInfoV2;
        Intrinsics.checkNotNullParameter(feedList, "feedList");
        List<? extends BusinessFeedData> list = feedList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (BusinessFeedData businessFeedData : list) {
            DataPreCalculateTool.preCalculate(businessFeedData, false);
            businessFeedData.setLeftThumb(QZonePassiveMessageFeedPreprocessor.f58250a.b(businessFeedData));
            CellSummary cellSummaryV2 = businessFeedData.getCellSummaryV2();
            if (cellSummaryV2 != null) {
                Intrinsics.checkNotNullExpressionValue(cellSummaryV2, "cellSummaryV2");
                String str = cellSummaryV2.displayStr;
                if (str == null) {
                    str = "";
                }
                cellSummaryV2.displayStr = str;
            }
            CellCommentInfo commentInfoV22 = businessFeedData.getCommentInfoV2();
            ArrayList<Comment> arrayList2 = commentInfoV22 != null ? commentInfoV22.commments : null;
            if (arrayList2 == null || arrayList2.isEmpty()) {
                BusinessFeedData originalInfo = businessFeedData.getOriginalInfo();
                ArrayList<Comment> arrayList3 = (originalInfo == null || (commentInfoV2 = originalInfo.getCommentInfoV2()) == null) ? null : commentInfoV2.commments;
                if (!(arrayList3 == null || arrayList3.isEmpty())) {
                    BusinessFeedData originalInfo2 = businessFeedData.getOriginalInfo();
                    businessFeedData.setCellCommentInfo(originalInfo2 != null ? originalInfo2.getCommentInfoV2() : null);
                }
            }
            CellFeedCommInfo feedCommInfoV2 = businessFeedData.getFeedCommInfoV2();
            if (feedCommInfoV2 != null) {
                Intrinsics.checkNotNullExpressionValue(feedCommInfoV2, "feedCommInfoV2");
                if (!(feedCommInfoV2.actiontype == 2)) {
                    feedCommInfoV2 = null;
                }
                if (feedCommInfoV2 != null) {
                    String str2 = feedCommInfoV2.actionurl;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.actionurl");
                    if (str2.length() == 0) {
                        feedCommInfoV2.actiontype = 6;
                    }
                    if (Intrinsics.areEqual(feedCommInfoV2.actionurl, QZoneHelper.SCHEME_OPEN_HOME_PAGE)) {
                        long j3 = businessFeedData.getUser().uin;
                        String uinString = LoginData.getInstance().getUinString();
                        feedCommInfoV2.actionurl = feedCommInfoV2.actionurl + "?uin=" + j3 + "&from_uin=" + uinString;
                    }
                }
            }
            CellLeftThumb leftThumb = businessFeedData.getLeftThumb();
            if (leftThumb != null) {
                Intrinsics.checkNotNullExpressionValue(leftThumb, "leftThumb");
                CellLeftThumb cellLeftThumb = leftThumb.getActionType() == 2 ? leftThumb : null;
                if (cellLeftThumb != null) {
                    String actionUrl = cellLeftThumb.getActionUrl();
                    Intrinsics.checkNotNullExpressionValue(actionUrl, "it.actionUrl");
                    if (actionUrl.length() == 0) {
                        cellLeftThumb.setActionType(6);
                    }
                    if (Intrinsics.areEqual(cellLeftThumb.getActionUrl(), QZoneHelper.SCHEME_OPEN_HOME_PAGE)) {
                        long j16 = businessFeedData.getUser().uin;
                        String uinString2 = LoginData.getInstance().getUinString();
                        cellLeftThumb.setActionUrl(cellLeftThumb.getActionUrl() + "?uin=" + j16 + "&from_uin=" + uinString2);
                    }
                }
            }
            arrayList.add(businessFeedData);
        }
        return arrayList;
    }
}

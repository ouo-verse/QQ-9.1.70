package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellAdv;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellBigTail;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellBottomRecomm;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellDeviceInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellFeedDeco;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellForwardInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellH5Jump;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellLocalInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellMusic;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellOperation;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellOrigin;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellPermission;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellRecommend;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellRemark;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellSealOffMemory;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellShare;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellSmallTail;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellUserDesc;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellLBS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellLike;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellQunInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellSpaceInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellSummary;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellTitle;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellUserInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellVisitor;
import com.tencent.hippykotlin.demo.pages.qzone.data.CommonCellLikeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0001\u001a\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0005"}, d2 = {"copyFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "toCommonFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeed;", "toPbFeed", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonFeedKt {
    public static final CommonFeed copyFeed(CommonFeed commonFeed) {
        return toCommonFeed(toPbFeed(commonFeed));
    }

    public static final CommonFeed toCommonFeed(StFeed stFeed) {
        int collectionSizeOrDefault;
        List<CommonCellBigTail> mutableList;
        if (stFeed == null) {
            return null;
        }
        CommonFeed commonFeed = new CommonFeed();
        commonFeed.setCellCommon(CommonCellCommonKt.toCommon(stFeed.cellCommon));
        commonFeed.setCellUserInfo(CommonCellUserInfoKt.toCommon(stFeed.cellUserInfo));
        commonFeed.setCellTitle(CommonCellTitleKt.toCommon(stFeed.cellTitle));
        commonFeed.setCellSummary(CommonCellSummaryKt.toCommon(stFeed.cellSummary));
        commonFeed.setCellMedia(CommonCellMediaKt.toCommon(stFeed.cellMedia));
        commonFeed.setCellLbs(CommonCellLBSKt.toCommon(stFeed.cellLbs));
        commonFeed.setCellComment(CommonCellCommentKt.toCommon(stFeed.cellComment));
        commonFeed.setCellLike(CommonCellLikeKt.toCommon(stFeed.cellLike));
        commonFeed.setCellBottomRecomm(CommonCellBottomRecommKt.toCommon(stFeed.cellBottomRecomm));
        commonFeed.setCellVisitor(CommonCellVisitorKt.toCommon(stFeed.cellVisitor));
        commonFeed.setCellRemark(CommonCellRemarkKt.toCommon(stFeed.cellRemark));
        commonFeed.setCellOrigin(CommonCellOriginKt.toCommon(stFeed.cellOrigin));
        commonFeed.setCellShare(CommonCellShareKt.toCommon(stFeed.cellShare));
        commonFeed.setCellDeviceInfo(CommonCellDeviceInfoKt.toCommon(stFeed.cellDeviceInfo));
        commonFeed.setCellUserDesc(CommonCellUserDescKt.toCommon(stFeed.cellUserDesc));
        commonFeed.setCellMusic(CommonCellMusicKt.toCommon(stFeed.cellMusic));
        commonFeed.setCellForwardInfo(CommonCellForwardInfoKt.toCommon(stFeed.cellFowardInfo));
        commonFeed.setCellPermission(CommonCellPermissionKt.toCommon(stFeed.cellPermission));
        commonFeed.setCellSmallTail(CommonCellSmallTailKt.toCommon(stFeed.cellSmallTail));
        commonFeed.setCellAdv(CommonCellAdvKt.toCommon(stFeed.cellAdv));
        commonFeed.setCellH5Jump(CommonCellH5JumpKt.toCommon(stFeed.cellH5Jump));
        commonFeed.setCellFeedDeco(CommonCellFeedDecoKt.toCommon(stFeed.cellFeedDeco));
        commonFeed.setCellLocalInfo(CommonCellLocalInfoKt.toCommon(stFeed.cellLocalInfo));
        commonFeed.setCellMemory(CommonCellSealOffMemoryKt.toCommon(stFeed.cellMemory));
        commonFeed.setCellOperation(CommonCellOperationKt.toCommon(stFeed.cellOperation));
        commonFeed.setCellRecommend(CommonCellRecommendKt.toCommon(stFeed.cellRecommend));
        List<StCellBigTail> list = stFeed.rptCellBigTail;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonCellBigTailKt.toCommonNonNull((StCellBigTail) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        commonFeed.setRptCellBigTail(mutableList);
        return commonFeed;
    }

    public static final StFeed toPbFeed(CommonFeed commonFeed) {
        int collectionSizeOrDefault;
        List mutableList;
        if (commonFeed == null) {
            return null;
        }
        StFeedCellCommon pb5 = CommonCellCommonKt.toPb(commonFeed.getCellCommon());
        StFeedCellUserInfo pb6 = CommonCellUserInfoKt.toPb(commonFeed.getCellUserInfo());
        StFeedCellTitle pb7 = CommonCellTitleKt.toPb(commonFeed.getCellTitle());
        StFeedCellSummary pb8 = CommonCellSummaryKt.toPb(commonFeed.getCellSummary());
        StFeedCellMedia pb9 = CommonCellMediaKt.toPb(commonFeed.getCellMedia());
        StFeedCellLBS pb10 = CommonCellLBSKt.toPb(commonFeed.getCellLbs());
        StFeedCellComment pb11 = CommonCellCommentKt.toPb(commonFeed.getCellComment());
        StFeedCellLike pb12 = CommonCellLikeKt.toPb(commonFeed.getCellLike());
        StCellBottomRecomm pb13 = CommonCellBottomRecommKt.toPb(commonFeed.getCellBottomRecomm());
        StFeedCellSpaceInfo stFeedCellSpaceInfo = null;
        StFeedCellVisitor pb14 = CommonCellVisitorKt.toPb(commonFeed.getCellVisitor());
        StFeedCellQunInfo stFeedCellQunInfo = null;
        StCellRemark pb15 = CommonCellRemarkKt.toPb(commonFeed.getCellRemark());
        StCellOrigin pb16 = CommonCellOriginKt.toPb(commonFeed.getCellOrigin());
        StCellShare pb17 = CommonCellShareKt.toPb(commonFeed.getCellShare());
        StCellDeviceInfo pb18 = CommonCellDeviceInfoKt.toPb(commonFeed.getCellDeviceInfo());
        StCellUserDesc pb19 = CommonCellUserDescKt.toPb(commonFeed.getCellUserDesc());
        StCellMusic pb20 = CommonCellMusicKt.toPb(commonFeed.getCellMusic());
        StCellForwardInfo pb21 = CommonCellForwardInfoKt.toPb(commonFeed.getCellForwardInfo());
        StCellPermission pb22 = CommonCellPermissionKt.toPb(commonFeed.getCellPermission());
        StCellSmallTail pb23 = CommonCellSmallTailKt.toPb(commonFeed.getCellSmallTail());
        StCellBigTail stCellBigTail = null;
        StCellAdv pb24 = CommonCellAdvKt.toPb(commonFeed.getCellAdv());
        StCellH5Jump pb25 = CommonCellH5JumpKt.toPb(commonFeed.getCellH5Jump());
        StCellFeedDeco pb26 = CommonCellFeedDecoKt.toPb(commonFeed.getCellFeedDeco());
        StCellLocalInfo pb27 = CommonCellLocalInfoKt.toPb(commonFeed.getCellLocalInfo());
        StCellSealOffMemory pb28 = CommonCellSealOffMemoryKt.toPb(commonFeed.getCellMemory());
        StCellOperation pb29 = CommonCellOperationKt.toPb(commonFeed.getCellOperation());
        StCellRecommend pb30 = CommonCellRecommendKt.toPb(commonFeed.getCellRecommend());
        List<CommonCellBigTail> rptCellBigTail = commonFeed.getRptCellBigTail();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(rptCellBigTail, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = rptCellBigTail.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonCellBigTailKt.toPbNonNull((CommonCellBigTail) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return new StFeed(pb5, pb6, pb7, pb8, pb9, pb10, pb11, pb12, pb13, stFeedCellSpaceInfo, pb14, stFeedCellQunInfo, null, pb15, pb16, pb17, pb18, pb19, pb20, pb21, pb22, pb23, stCellBigTail, pb24, pb25, pb26, pb27, pb28, pb29, pb30, mutableList, 4200960, null);
    }
}

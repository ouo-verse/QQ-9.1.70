package com.tencent.biz.qqcircle.helpers;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.helpers.QFSPublicListTabCommonHelper;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import feedcloud.FeedCloudRead$StGetNoticeCategoryDetailPageRsp;
import java.util.ArrayList;
import qqcircle.QQCircleCounter$MergePsvRedPointsRsp;
import qqcircle.QQCircleCounterMsg$MergePsvRedPoint;

/* compiled from: P */
/* loaded from: classes4.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList<QFSPublicListTabCommonHelper.MsgTabEntity> f84665a;

    static {
        ArrayList<QFSPublicListTabCommonHelper.MsgTabEntity> arrayList = new ArrayList<>();
        f84665a = arrayList;
        arrayList.add(new QFSPublicListTabCommonHelper.MsgTabEntity("\u65b0\u7684\u670b\u53cb", 4));
        arrayList.add(new QFSPublicListTabCommonHelper.MsgTabEntity("\u65b0\u670b\u53cb\u611f\u8c22", 19));
    }

    @NonNull
    public static Pair<Integer, Integer> a(FeedCloudRead$StGetNoticeCategoryDetailPageRsp feedCloudRead$StGetNoticeCategoryDetailPageRsp, int i3) {
        QQCircleCounterMsg$MergePsvRedPoint qQCircleCounterMsg$MergePsvRedPoint;
        if (feedCloudRead$StGetNoticeCategoryDetailPageRsp != null && feedCloudRead$StGetNoticeCategoryDetailPageRsp.red_point_bytes != null) {
            QQCircleCounter$MergePsvRedPointsRsp qQCircleCounter$MergePsvRedPointsRsp = new QQCircleCounter$MergePsvRedPointsRsp();
            try {
                qQCircleCounter$MergePsvRedPointsRsp.mergeFrom(feedCloudRead$StGetNoticeCategoryDetailPageRsp.red_point_bytes.get().toByteArray());
                qQCircleCounterMsg$MergePsvRedPoint = (QQCircleCounterMsg$MergePsvRedPoint) RFSafeListUtils.get(qQCircleCounter$MergePsvRedPointsRsp.redPoints.get(), 0);
            } catch (Exception e16) {
                QLog.e("NFT-QFSNewFriendThanksHelper", 1, "[getRedPointReceiveResult] error: ", e16);
                qQCircleCounterMsg$MergePsvRedPoint = null;
            }
            if (qQCircleCounterMsg$MergePsvRedPoint == null) {
                return new Pair<>(Integer.valueOf(i3), 0);
            }
            return new Pair<>(Integer.valueOf(qQCircleCounterMsg$MergePsvRedPoint.categoryID.get()), Integer.valueOf(qQCircleCounterMsg$MergePsvRedPoint.num.get()));
        }
        QLog.e("NFT-QFSNewFriendThanksHelper", 1, "[getRedPointReceiveResult] rsp == null || rsp.red_point_bytes == null.");
        return new Pair<>(Integer.valueOf(i3), 0);
    }

    public static boolean b(int i3) {
        if (i3 == 19) {
            return true;
        }
        return false;
    }
}

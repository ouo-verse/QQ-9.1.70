package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellLBS;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellLBS;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellLBS;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellLBSKt {
    public static final CommonCellLBS toCommon(StFeedCellLBS stFeedCellLBS) {
        if (stFeedCellLBS == null) {
            return null;
        }
        CommonCellLBS commonCellLBS = new CommonCellLBS();
        commonCellLBS.setLbs(CommonLBSKt.toCommon(stFeedCellLBS.lbs));
        commonCellLBS.setIconToken(stFeedCellLBS.iconToken);
        return commonCellLBS;
    }

    public static final StFeedCellLBS toPb(CommonCellLBS commonCellLBS) {
        if (commonCellLBS != null) {
            return new StFeedCellLBS(CommonLBSKt.toPb(commonCellLBS.getLbs()), commonCellLBS.getIconToken());
        }
        return null;
    }
}

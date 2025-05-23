package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellBottomRecomm;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellBottomRecomm;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellBottomRecomm;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellBottomRecommKt {
    public static final CommonCellBottomRecomm toCommon(StCellBottomRecomm stCellBottomRecomm) {
        if (stCellBottomRecomm == null) {
            return null;
        }
        CommonCellBottomRecomm commonCellBottomRecomm = new CommonCellBottomRecomm();
        commonCellBottomRecomm.setTitle(stCellBottomRecomm.title);
        commonCellBottomRecomm.setIconToken(stCellBottomRecomm.iconToken);
        commonCellBottomRecomm.setActionUrl(stCellBottomRecomm.actionUrl);
        commonCellBottomRecomm.setRecommType(stCellBottomRecomm.recommType);
        return commonCellBottomRecomm;
    }

    public static final StCellBottomRecomm toPb(CommonCellBottomRecomm commonCellBottomRecomm) {
        if (commonCellBottomRecomm != null) {
            return new StCellBottomRecomm(commonCellBottomRecomm.getTitle(), commonCellBottomRecomm.getIconToken(), commonCellBottomRecomm.getActionUrl(), commonCellBottomRecomm.getRecommType());
        }
        return null;
    }
}

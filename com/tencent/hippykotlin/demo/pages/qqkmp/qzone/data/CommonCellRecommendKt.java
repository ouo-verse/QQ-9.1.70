package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellRecommend;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellRecommend;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellRecommend;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellRecommendKt {
    public static final CommonCellRecommend toCommon(StCellRecommend stCellRecommend) {
        if (stCellRecommend == null) {
            return null;
        }
        CommonCellRecommend commonCellRecommend = new CommonCellRecommend();
        commonCellRecommend.setCustomType(stCellRecommend.customType);
        commonCellRecommend.setTianshuAttach(CommonTianshuAttachKt.toCommon(stCellRecommend.tianshuAttach));
        return commonCellRecommend;
    }

    public static final StCellRecommend toPb(CommonCellRecommend commonCellRecommend) {
        if (commonCellRecommend != null) {
            return new StCellRecommend(commonCellRecommend.getCustomType(), CommonTianshuAttachKt.toPb(commonCellRecommend.getTianshuAttach()));
        }
        return null;
    }
}

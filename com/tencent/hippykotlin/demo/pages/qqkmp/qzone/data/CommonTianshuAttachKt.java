package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.TianshuAttach;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonTianshuAttach;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/TianshuAttach;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonTianshuAttachKt {
    public static final CommonTianshuAttach toCommon(TianshuAttach tianshuAttach) {
        if (tianshuAttach == null) {
            return null;
        }
        CommonTianshuAttach commonTianshuAttach = new CommonTianshuAttach();
        commonTianshuAttach.setAdvId(tianshuAttach.advId);
        commonTianshuAttach.setTianshuAdPlaceInfo(tianshuAttach.tianshuAdPlaceInfo);
        return commonTianshuAttach;
    }

    public static final TianshuAttach toPb(CommonTianshuAttach commonTianshuAttach) {
        if (commonTianshuAttach != null) {
            return new TianshuAttach(commonTianshuAttach.getAdvId(), commonTianshuAttach.getTianshuAdPlaceInfo());
        }
        return null;
    }
}

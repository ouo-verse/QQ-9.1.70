package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellLocalInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellLocalInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellLocalInfo;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellLocalInfoKt {
    public static final CommonCellLocalInfo toCommon(StCellLocalInfo stCellLocalInfo) {
        if (stCellLocalInfo == null) {
            return null;
        }
        CommonCellLocalInfo commonCellLocalInfo = new CommonCellLocalInfo();
        Integer num = stCellLocalInfo.fakeType;
        commonCellLocalInfo.setFakeType(num != null ? num.intValue() : 0);
        return commonCellLocalInfo;
    }

    public static final StCellLocalInfo toPb(CommonCellLocalInfo commonCellLocalInfo) {
        if (commonCellLocalInfo != null) {
            return new StCellLocalInfo(Integer.valueOf(commonCellLocalInfo.getFakeType()));
        }
        return null;
    }
}

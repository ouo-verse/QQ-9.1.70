package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLBS;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLBS;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StLBS;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonLBSKt {
    public static final CommonLBS toCommon(StLBS stLBS) {
        if (stLBS == null) {
            return null;
        }
        CommonLBS commonLBS = new CommonLBS();
        commonLBS.setGps(CommonGPSKt.toCommon(stLBS.gps));
        commonLBS.setLocation(stLBS.location);
        commonLBS.setId(stLBS.id);
        commonLBS.setAddress(stLBS.address);
        return commonLBS;
    }

    public static final StLBS toPb(CommonLBS commonLBS) {
        if (commonLBS != null) {
            return new StLBS(CommonGPSKt.toPb(commonLBS.getGps()), commonLBS.getLocation(), commonLBS.getId(), commonLBS.getAddress());
        }
        return null;
    }
}

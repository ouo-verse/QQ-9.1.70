package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StH5JumpUrl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonH5JumpUrl;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StH5JumpUrl;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonH5JumpUrl_Kt {
    public static final CommonH5JumpUrl toCommon(StH5JumpUrl stH5JumpUrl) {
        CommonH5JumpUrl commonH5JumpUrl = new CommonH5JumpUrl();
        Integer num = stH5JumpUrl.type;
        commonH5JumpUrl.setType(num != null ? num.intValue() : 0);
        commonH5JumpUrl.setActionUrl(stH5JumpUrl.actionUrl);
        return commonH5JumpUrl;
    }

    public static final StH5JumpUrl toPb(CommonH5JumpUrl commonH5JumpUrl) {
        return new StH5JumpUrl(Integer.valueOf(commonH5JumpUrl.getType()), commonH5JumpUrl.getActionUrl());
    }
}

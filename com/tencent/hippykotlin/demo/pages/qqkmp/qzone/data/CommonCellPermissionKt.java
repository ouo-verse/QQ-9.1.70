package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellPermission;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellPermission;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellPermission;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellPermissionKt {
    public static final CommonCellPermission toCommon(StCellPermission stCellPermission) {
        if (stCellPermission == null) {
            return null;
        }
        CommonCellPermission commonCellPermission = new CommonCellPermission();
        commonCellPermission.setDesc(stCellPermission.desc);
        commonCellPermission.setIcon(stCellPermission.icon);
        commonCellPermission.setActionUrl(stCellPermission.actionUrl);
        commonCellPermission.setRight(CommonRightKt.toCommon(stCellPermission.right));
        return commonCellPermission;
    }

    public static final StCellPermission toPb(CommonCellPermission commonCellPermission) {
        if (commonCellPermission != null) {
            return new StCellPermission(commonCellPermission.getDesc(), commonCellPermission.getIcon(), commonCellPermission.getActionUrl(), CommonRightKt.toPb(commonCellPermission.getRight()), null, null, 48, null);
        }
        return null;
    }
}

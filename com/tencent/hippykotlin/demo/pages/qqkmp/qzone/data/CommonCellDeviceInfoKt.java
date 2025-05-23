package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellDeviceInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellDeviceInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellDeviceInfo;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellDeviceInfoKt {
    public static final CommonCellDeviceInfo toCommon(StCellDeviceInfo stCellDeviceInfo) {
        if (stCellDeviceInfo == null) {
            return null;
        }
        CommonCellDeviceInfo commonCellDeviceInfo = new CommonCellDeviceInfo();
        commonCellDeviceInfo.setName(stCellDeviceInfo.name);
        commonCellDeviceInfo.setIconUrl(stCellDeviceInfo.iconUrl);
        commonCellDeviceInfo.setActionUrl(stCellDeviceInfo.actionUrl);
        return commonCellDeviceInfo;
    }

    public static final StCellDeviceInfo toPb(CommonCellDeviceInfo commonCellDeviceInfo) {
        if (commonCellDeviceInfo != null) {
            return new StCellDeviceInfo(commonCellDeviceInfo.getName(), commonCellDeviceInfo.getIconUrl(), commonCellDeviceInfo.getActionUrl());
        }
        return null;
    }
}

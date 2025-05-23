package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StOperationForwardToQzoneInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonOperationForwardToQzoneInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StOperationForwardToQzoneInfo;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonOperationForwardToQzoneInfoKt {
    public static final CommonOperationForwardToQzoneInfo toCommon(StOperationForwardToQzoneInfo stOperationForwardToQzoneInfo) {
        if (stOperationForwardToQzoneInfo == null) {
            return null;
        }
        CommonOperationForwardToQzoneInfo commonOperationForwardToQzoneInfo = new CommonOperationForwardToQzoneInfo();
        String str = stOperationForwardToQzoneInfo.forwardButtonToast;
        if (str == null) {
            str = "";
        }
        commonOperationForwardToQzoneInfo.setForwardButtonToast(str);
        return commonOperationForwardToQzoneInfo;
    }

    public static final StOperationForwardToQzoneInfo toPb(CommonOperationForwardToQzoneInfo commonOperationForwardToQzoneInfo) {
        if (commonOperationForwardToQzoneInfo != null) {
            return new StOperationForwardToQzoneInfo(commonOperationForwardToQzoneInfo.getForwardButtonToast());
        }
        return null;
    }
}

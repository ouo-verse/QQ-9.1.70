package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.QzoneRightGroupItem;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRightGroupItem;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/QzoneRightGroupItem;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonRightGroupItemKt {
    public static final CommonRightGroupItem toCommon(QzoneRightGroupItem qzoneRightGroupItem) {
        CommonRightGroupItem commonRightGroupItem = new CommonRightGroupItem();
        commonRightGroupItem.setGroupId(qzoneRightGroupItem.groupId);
        commonRightGroupItem.setSeqId(qzoneRightGroupItem.seqId);
        commonRightGroupItem.setGroupName(qzoneRightGroupItem.groupName);
        commonRightGroupItem.setFlag(qzoneRightGroupItem.flag);
        return commonRightGroupItem;
    }

    public static final QzoneRightGroupItem toPb(CommonRightGroupItem commonRightGroupItem) {
        return new QzoneRightGroupItem(commonRightGroupItem.getGroupId(), commonRightGroupItem.getSeqId(), commonRightGroupItem.getGroupName(), commonRightGroupItem.getFlag());
    }
}

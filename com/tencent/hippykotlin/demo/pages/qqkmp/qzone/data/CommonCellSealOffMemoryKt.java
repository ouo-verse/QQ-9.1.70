package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellSealOffMemory;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellSealOffMemory;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellSealOffMemory;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellSealOffMemoryKt {
    public static final CommonCellSealOffMemory toCommon(StCellSealOffMemory stCellSealOffMemory) {
        if (stCellSealOffMemory == null) {
            return null;
        }
        CommonCellSealOffMemory commonCellSealOffMemory = new CommonCellSealOffMemory();
        Long l3 = stCellSealOffMemory.memoryTime;
        commonCellSealOffMemory.setMemoryTime(l3 != null ? l3.longValue() : 0L);
        commonCellSealOffMemory.setSummary(stCellSealOffMemory.summary);
        commonCellSealOffMemory.setActionType(stCellSealOffMemory.actionType);
        commonCellSealOffMemory.setActionUrl(stCellSealOffMemory.actionUrl);
        commonCellSealOffMemory.setButtonText(stCellSealOffMemory.buttonText);
        commonCellSealOffMemory.setType(stCellSealOffMemory.type);
        commonCellSealOffMemory.setNoRightSummary(stCellSealOffMemory.noRightSummary);
        return commonCellSealOffMemory;
    }

    public static final StCellSealOffMemory toPb(CommonCellSealOffMemory commonCellSealOffMemory) {
        if (commonCellSealOffMemory != null) {
            return new StCellSealOffMemory(Long.valueOf(commonCellSealOffMemory.getMemoryTime()), commonCellSealOffMemory.getSummary(), commonCellSealOffMemory.getActionType(), commonCellSealOffMemory.getActionUrl(), commonCellSealOffMemory.getButtonText(), commonCellSealOffMemory.getType(), commonCellSealOffMemory.getNoRightSummary());
        }
        return null;
    }
}

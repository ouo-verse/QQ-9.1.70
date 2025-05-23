package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheQzoneVipData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellRecommend;", "", "()V", WidgetCacheQzoneVipData.CUSTOMTYPE, "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/CustomType;", "getCustomType", "()Ljava/lang/Integer;", "setCustomType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "tianshuAttach", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonTianshuAttach;", "getTianshuAttach", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonTianshuAttach;", "setTianshuAttach", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonTianshuAttach;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellRecommend {
    public static final int $stable = 8;
    private Integer customType;
    private CommonTianshuAttach tianshuAttach;

    public final Integer getCustomType() {
        return this.customType;
    }

    public final CommonTianshuAttach getTianshuAttach() {
        return this.tianshuAttach;
    }

    public final void setCustomType(Integer num) {
        this.customType = num;
    }

    public final void setTianshuAttach(CommonTianshuAttach commonTianshuAttach) {
        this.tianshuAttach = commonTianshuAttach;
    }
}

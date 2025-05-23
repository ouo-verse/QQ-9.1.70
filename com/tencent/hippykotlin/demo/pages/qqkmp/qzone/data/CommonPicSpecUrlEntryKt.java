package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StPicSpecUrlEntry;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicSpecUrlEntry;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StPicSpecUrlEntry;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonPicSpecUrlEntryKt {
    public static final CommonPicSpecUrlEntry toCommon(StPicSpecUrlEntry stPicSpecUrlEntry) {
        CommonPicSpecUrlEntry commonPicSpecUrlEntry = new CommonPicSpecUrlEntry();
        commonPicSpecUrlEntry.setSpec(stPicSpecUrlEntry.spec);
        commonPicSpecUrlEntry.setUrl(CommonPicUrlKt.toCommon(stPicSpecUrlEntry.url));
        return commonPicSpecUrlEntry;
    }

    public static final StPicSpecUrlEntry toPb(CommonPicSpecUrlEntry commonPicSpecUrlEntry) {
        return new StPicSpecUrlEntry(commonPicSpecUrlEntry.getSpec(), CommonPicUrlKt.toPb(commonPicSpecUrlEntry.getUrl()));
    }
}

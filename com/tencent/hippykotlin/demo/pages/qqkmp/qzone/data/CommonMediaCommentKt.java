package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMediaComment;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMediaComment;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMediaComment;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonMediaCommentKt {
    public static final CommonMediaComment toCommon(StMediaComment stMediaComment) {
        if (stMediaComment == null) {
            return null;
        }
        CommonMediaComment commonMediaComment = new CommonMediaComment();
        Integer num = stMediaComment.num;
        commonMediaComment.setNum(num != null ? num.intValue() : 0);
        return commonMediaComment;
    }

    public static final StMediaComment toPb(CommonMediaComment commonMediaComment) {
        if (commonMediaComment != null) {
            return new StMediaComment(Integer.valueOf(commonMediaComment.getNum()));
        }
        return null;
    }
}

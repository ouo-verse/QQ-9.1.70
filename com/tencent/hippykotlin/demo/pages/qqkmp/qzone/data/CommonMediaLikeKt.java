package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMediaLike;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMediaLike;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMediaLike;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonMediaLikeKt {
    public static final CommonMediaLike toCommon(StMediaLike stMediaLike) {
        if (stMediaLike == null) {
            return null;
        }
        CommonMediaLike commonMediaLike = new CommonMediaLike();
        commonMediaLike.setKey(stMediaLike.key);
        Integer num = stMediaLike.num;
        commonMediaLike.setNum(num != null ? num.intValue() : 0);
        Boolean bool = stMediaLike.liked;
        commonMediaLike.setLiked(bool != null ? bool.booleanValue() : false);
        return commonMediaLike;
    }

    public static final StMediaLike toPb(CommonMediaLike commonMediaLike) {
        if (commonMediaLike != null) {
            return new StMediaLike(commonMediaLike.getKey(), Integer.valueOf(commonMediaLike.getNum()), Boolean.valueOf(commonMediaLike.getLiked()));
        }
        return null;
    }
}

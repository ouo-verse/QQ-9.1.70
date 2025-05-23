package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLikeMan;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLikeMan;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StLikeMan;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonLikeManKt {
    public static final CommonLikeMan toCommon(StLikeMan stLikeMan) {
        CommonLikeMan commonLikeMan = new CommonLikeMan();
        commonLikeMan.setUser(CommonUserKt.toCommon(stLikeMan.user));
        return commonLikeMan;
    }

    public static final StLikeMan toPb(CommonLikeMan commonLikeMan) {
        return new StLikeMan(CommonUserKt.toPb(commonLikeMan.getUser()));
    }
}

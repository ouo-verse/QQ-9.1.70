package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StPicUrl;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicUrl;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StPicUrl;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonPicUrlKt {
    public static final CommonPicUrl toCommon(StPicUrl stPicUrl) {
        if (stPicUrl == null) {
            return null;
        }
        CommonPicUrl commonPicUrl = new CommonPicUrl();
        commonPicUrl.setUrl(stPicUrl.url);
        Integer num = stPicUrl.width;
        commonPicUrl.setWidth(num != null ? num.intValue() : 0);
        Integer num2 = stPicUrl.height;
        commonPicUrl.setHeight(num2 != null ? num2.intValue() : 0);
        return commonPicUrl;
    }

    public static final StPicUrl toPb(CommonPicUrl commonPicUrl) {
        if (commonPicUrl != null) {
            return new StPicUrl(commonPicUrl.getUrl(), Integer.valueOf(commonPicUrl.getWidth()), Integer.valueOf(commonPicUrl.getHeight()));
        }
        return null;
    }
}

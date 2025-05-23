package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u001a\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u00060\tj\u0002`\n\u00a8\u0006\u000b"}, d2 = {"richMsgToString", "", "richMsgList", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRichMsg;", "pickUrl", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicUrl;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonImage;", "photoSpec", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/PhotoSpec;", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonFeedDataConvertorKt {
    public static final String richMsgToString(List<CommonRichMsg> list) {
        String str = "";
        if (list != null) {
            for (CommonRichMsg commonRichMsg : list) {
                Integer type = commonRichMsg.getType();
                if (type != null && type.intValue() == 0) {
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(str);
                    m3.append(commonRichMsg.getContent());
                    str = m3.toString();
                }
            }
        }
        return str;
    }

    public static final CommonPicUrl pickUrl(CommonImage commonImage, int i3) {
        Object obj;
        if (commonImage != null && !commonImage.getPhotoUrl().isEmpty()) {
            Iterator<T> it = commonImage.getPhotoUrl().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                Integer spec = ((CommonPicSpecUrlEntry) obj).getSpec();
                if (spec != null && spec.intValue() == i3) {
                    break;
                }
            }
            CommonPicSpecUrlEntry commonPicSpecUrlEntry = (CommonPicSpecUrlEntry) obj;
            if (commonPicSpecUrlEntry != null) {
                return commonPicSpecUrlEntry.getUrl();
            }
        }
        return null;
    }
}

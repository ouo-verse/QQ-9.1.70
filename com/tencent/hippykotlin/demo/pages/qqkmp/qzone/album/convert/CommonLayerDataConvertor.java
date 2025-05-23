package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.enumtype.CommonEnumMediaType;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/CommonLayerDataConvertor;", "", "()V", "getStMediaLLoc", "", "stMedia", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMedia;", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonLayerDataConvertor {
    public static final int $stable = 0;
    public static final CommonLayerDataConvertor INSTANCE = new CommonLayerDataConvertor();

    CommonLayerDataConvertor() {
    }

    public final String getStMediaLLoc(CommonStMedia stMedia) {
        if (stMedia.getType() == CommonEnumMediaType.IMAGE.ordinal()) {
            return stMedia.getImage().getLloc();
        }
        return stMedia.getVideo().getCover().getLloc();
    }
}

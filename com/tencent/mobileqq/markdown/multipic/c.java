package com.tencent.mobileqq.markdown.multipic;

import com.tencent.libra.request.Option;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/markdown/multipic/c;", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "layerItemInfo", "", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f243753a = new c();

    c() {
    }

    public final String a(RFWLayerItemMediaInfo layerItemInfo) {
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo originPicInfo = (layerItemInfo == null || (layerPicInfo = layerItemInfo.getLayerPicInfo()) == null) ? null : layerPicInfo.getOriginPicInfo();
        String localPath = originPicInfo != null ? originPicInfo.getLocalPath() : null;
        if (!(localPath == null || localPath.length() == 0)) {
            Intrinsics.checkNotNull(originPicInfo);
            String localPath2 = originPicInfo.getLocalPath();
            Intrinsics.checkNotNull(localPath2);
            return localPath2;
        }
        String url = originPicInfo != null ? originPicInfo.getUrl() : null;
        if (url == null || url.length() == 0) {
            return "";
        }
        String picLocalPath = QQPicLoader.f201806a.d().getPicLocalPath(Option.obtain().setUrl(url));
        if ((picLocalPath == null || picLocalPath.length() == 0) || !new File(picLocalPath).exists()) {
            return "";
        }
        originPicInfo.setLocalPath(picLocalPath);
        Intrinsics.checkNotNullExpressionValue(picLocalPath, "{\n            originPicI\u2026   picLocalPath\n        }");
        return picLocalPath;
    }
}

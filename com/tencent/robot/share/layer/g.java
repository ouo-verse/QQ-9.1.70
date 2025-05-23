package com.tencent.robot.share.layer;

import com.tencent.libra.request.Option;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/share/layer/g;", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "layerItemInfo", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f368413a = new g();

    g() {
    }

    @NotNull
    public final String a(@Nullable RFWLayerItemMediaInfo layerItemInfo) {
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo;
        String str;
        boolean z16;
        boolean z17;
        RFWLayerPicInfo layerPicInfo;
        String str2 = null;
        if (layerItemInfo != null && (layerPicInfo = layerItemInfo.getLayerPicInfo()) != null) {
            rFWPicInfo = layerPicInfo.getOriginPicInfo();
        } else {
            rFWPicInfo = null;
        }
        if (rFWPicInfo != null) {
            str = rFWPicInfo.getLocalPath();
        } else {
            str = null;
        }
        boolean z18 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            Intrinsics.checkNotNull(rFWPicInfo);
            String localPath = rFWPicInfo.getLocalPath();
            Intrinsics.checkNotNull(localPath);
            return localPath;
        }
        if (rFWPicInfo != null) {
            str2 = rFWPicInfo.getUrl();
        }
        if (str2 != null && str2.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            return "";
        }
        String picLocalPath = QQPicLoader.f201806a.d().getPicLocalPath(Option.obtain().setUrl(str2));
        if (picLocalPath == null || picLocalPath.length() == 0) {
            z18 = true;
        }
        if (z18 || !new File(picLocalPath).exists()) {
            return "";
        }
        rFWPicInfo.setLocalPath(picLocalPath);
        Intrinsics.checkNotNullExpressionValue(picLocalPath, "{\n            originPicI\u2026   picLocalPath\n        }");
        return picLocalPath;
    }
}

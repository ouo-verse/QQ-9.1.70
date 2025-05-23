package com.tencent.mobileqq.wink.api;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWinkMediaHelper extends QRouteApi {
    LocalMediaInfo buildLocalMediaInfoByPath(String str);

    LocalMediaInfo buildLocalMediaInfoForVideo(String str);

    boolean isSupportImageFormat(File file);

    boolean isSupportVideoFormat(int i3, int i16, int i17);
}

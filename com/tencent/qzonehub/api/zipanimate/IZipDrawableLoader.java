package com.tencent.qzonehub.api.zipanimate;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.zipanimate.ZipDrawableLoaderInterface;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IZipDrawableLoader extends QRouteApi {
    ZipDrawableLoaderInterface getZipDrawableLoader(Context context);
}

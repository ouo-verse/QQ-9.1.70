package com.tencent.mobileqq.qrscan.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IScannerAlbumApi extends QRouteApi {
    void jumpToAlbumForResult(Activity activity);
}

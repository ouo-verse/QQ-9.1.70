package com.tencent.qzonehub.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.IQzoneGiftFullScreenViewController;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneGiftFullScreenViewControllerProxy extends QRouteApi {
    IQzoneGiftFullScreenViewController getQzoneGiftFullScreenViewController(Activity activity);

    boolean isSupportMagicface();
}

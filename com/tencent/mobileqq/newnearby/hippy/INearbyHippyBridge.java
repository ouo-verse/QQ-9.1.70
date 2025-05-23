package com.tencent.mobileqq.newnearby.hippy;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.modules.Promise;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyHippyBridge extends QRouteApi {
    void openAppSetting();

    void openMqqUrl(String str);

    void requestLBS(Promise promise);

    void selectAndUploadPicture(int i3, Promise promise);

    void uploadProfilePicture(Promise promise);
}

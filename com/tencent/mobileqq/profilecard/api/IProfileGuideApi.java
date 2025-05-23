package com.tencent.mobileqq.profilecard.api;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface IProfileGuideApi extends QRouteApi {
    void jumpLabelEdit(IComponentCenter iComponentCenter);

    void jumpPhotoEdit(Activity activity, String str, boolean z16);

    void jumpProfileEdit(AppInterface appInterface, Activity activity, ProfileCardInfo profileCardInfo);

    void jumpProfileEditWithData(AppInterface appInterface, Activity activity, ProfileCardInfo profileCardInfo, Bundle bundle);

    void jumpSignEdit(Activity activity, ProfileCardInfo profileCardInfo);
}

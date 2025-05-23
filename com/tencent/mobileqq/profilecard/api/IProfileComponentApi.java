package com.tencent.mobileqq.profilecard.api;

import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface IProfileComponentApi extends QRouteApi {
    AbsProfileComponent create(int i3, IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo, IProfileActivityDelegate iProfileActivityDelegate);

    void initProfileComponentArray(IProfileActivityDelegate iProfileActivityDelegate);
}

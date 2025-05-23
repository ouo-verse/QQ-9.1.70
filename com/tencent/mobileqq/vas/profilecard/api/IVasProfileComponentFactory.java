package com.tencent.mobileqq.vas.profilecard.api;

import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {""})
/* loaded from: classes20.dex */
public interface IVasProfileComponentFactory extends QRouteApi {
    AbsProfileComponent create(int i3, IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo);
}

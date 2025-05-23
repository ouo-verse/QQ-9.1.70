package com.tencent.mobileqq.subaccount.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes18.dex */
public interface ISubAccountConfigApi extends QRouteApi {
    boolean getIsHideSubAccountTroopMsg();
}

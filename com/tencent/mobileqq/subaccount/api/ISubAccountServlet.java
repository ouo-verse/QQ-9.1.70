package com.tencent.mobileqq.subaccount.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.NewIntent;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISubAccountServlet extends QRouteApi {
    NewIntent fetchOneTroopNewMsg(AppInterface appInterface, String str);
}

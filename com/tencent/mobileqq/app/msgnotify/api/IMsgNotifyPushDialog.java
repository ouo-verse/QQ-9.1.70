package com.tencent.mobileqq.app.msgnotify.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {""})
/* loaded from: classes11.dex */
public interface IMsgNotifyPushDialog extends QRouteApi {
    void parsePushOpenNotifyXML(AppRuntime appRuntime, String str, boolean z16);
}

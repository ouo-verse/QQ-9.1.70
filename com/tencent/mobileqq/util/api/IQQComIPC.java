package com.tencent.mobileqq.util.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {""})
/* loaded from: classes20.dex */
public interface IQQComIPC extends QRouteApi {
    public static final String KEY_REQ_PARAM = "req_param";

    void cancelAlarmNotifaction(Bundle bundle);

    void removeMessageRecord(Bundle bundle);

    void setAlarmNotifaction(Bundle bundle);
}

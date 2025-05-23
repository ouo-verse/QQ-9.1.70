package com.tencent.open.agent.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes22.dex */
public interface IOpenAuthTelemetryReportMgr extends QRouteApi {
    public static final String KEY_IS_SUCCESS = "isSuccess";
    public static final String KEY_REPORT_ACTION = "reportAction";
    public static final String KEY_UIN = "uin";

    void doReportAction(Bundle bundle);
}

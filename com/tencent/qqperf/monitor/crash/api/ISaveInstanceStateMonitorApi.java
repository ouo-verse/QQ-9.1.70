package com.tencent.qqperf.monitor.crash.api;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface ISaveInstanceStateMonitorApi extends QRouteApi {
    void recordActivitySaveInstanceStateInfo(Activity activity, Bundle bundle);

    void recordFragmentSaveInstanceStateInfo(Fragment fragment, Bundle bundle);
}

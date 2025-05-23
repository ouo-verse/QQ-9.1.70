package com.tencent.qqperf.monitor.crash.api.impl;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.api.ISaveInstanceStateMonitorApi;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SaveInstanceStateMonitorApiImpl implements ISaveInstanceStateMonitorApi {
    private static final String TAG = "SaveInstanceStateMonitorApiImpl";

    @Override // com.tencent.qqperf.monitor.crash.api.ISaveInstanceStateMonitorApi
    public void recordActivitySaveInstanceStateInfo(Activity activity, Bundle bundle) {
        if (activity != null && bundle != null && a.a(activity, bundle)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(activity + " savedState, sumSize: " + com.tencent.qqperf.tools.a.d(bundle) + "\n");
            sb5.append(com.tencent.qqperf.tools.a.b(bundle));
            String sb6 = sb5.toString();
            a.e(activity, sb6);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "recordActivitySaveInstanceStateInfo find large size info: " + sb6);
            }
        }
    }

    @Override // com.tencent.qqperf.monitor.crash.api.ISaveInstanceStateMonitorApi
    public void recordFragmentSaveInstanceStateInfo(Fragment fragment, Bundle bundle) {
        if (fragment != null && bundle != null && a.b(fragment)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(fragment + " savedState, sumSize: " + com.tencent.qqperf.tools.a.d(bundle) + "\n");
            sb5.append(com.tencent.qqperf.tools.a.b(bundle));
            String sb6 = sb5.toString();
            a.f(fragment, sb6);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "recordFragmentSaveInstanceStateInfo find large size info: " + sb6);
            }
        }
    }
}

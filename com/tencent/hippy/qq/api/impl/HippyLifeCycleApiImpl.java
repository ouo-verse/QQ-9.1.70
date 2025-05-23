package com.tencent.hippy.qq.api.impl;

import com.tencent.hippy.qq.api.IHippyLifeCycleApi;
import com.tencent.hippy.qq.offline.HippyOfflineAssist;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyLifeCycleApiImpl implements IHippyLifeCycleApi {
    public static final String TAG = "HippyLifeCycleApi";

    @Override // com.tencent.hippy.qq.api.IHippyLifeCycleApi
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[onDestroy]");
        }
        HippyOfflineAssist.updateUrl();
    }
}

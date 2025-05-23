package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.utils.abtest.IOnlineExpProvider;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes16.dex */
public class QCircleOnlineExpProviderImpl implements IOnlineExpProvider {
    private static final String TAG = "QCircleOnlineExpProviderImpl";

    @Override // com.tencent.mobileqq.utils.abtest.IOnlineExpProvider
    public Map<String, String> getBusinessProfiles() {
        HashMap hashMap = new HashMap();
        hashMap.put("wezone_user", "2");
        QLog.d(TAG, 2, "getBusinessProfiles is qcircle user");
        return hashMap;
    }

    @Override // com.tencent.mobileqq.utils.abtest.IOnlineExpProvider
    public List<String> getRegisterExpNameList() {
        return uq3.b.b();
    }
}

package com.tencent.gdtad.impl;

import com.tencent.gdtad.abtest.AdABTestConstants;
import com.tencent.mobileqq.utils.abtest.IOnlineExpProvider;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a implements IOnlineExpProvider {
    @Override // com.tencent.mobileqq.utils.abtest.IOnlineExpProvider
    public Map<String, String> getBusinessProfiles() {
        return null;
    }

    @Override // com.tencent.mobileqq.utils.abtest.IOnlineExpProvider
    public List<String> getRegisterExpNameList() {
        return Arrays.asList(AdABTestConstants.REGISTER_ABTEST_LIST);
    }
}

package com.tencent.mobileqq.utils.abtest;

import java.util.List;
import java.util.Map;

/* loaded from: classes20.dex */
public interface IOnlineExpProvider {
    Map<String, String> getBusinessProfiles();

    @Deprecated
    List<String> getRegisterExpNameList();
}

package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.utils.abtest.IOnlineExpProvider;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class u implements IOnlineExpProvider {
    @Override // com.tencent.mobileqq.utils.abtest.IOnlineExpProvider
    public Map<String, String> getBusinessProfiles() {
        return null;
    }

    @Override // com.tencent.mobileqq.utils.abtest.IOnlineExpProvider
    public List<String> getRegisterExpNameList() {
        return Arrays.asList(com.tencent.mobileqq.guild.config.c.f216118a);
    }
}

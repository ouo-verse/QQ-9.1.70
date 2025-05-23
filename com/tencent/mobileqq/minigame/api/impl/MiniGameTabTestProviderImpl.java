package com.tencent.mobileqq.minigame.api.impl;

import com.tencent.mobileqq.minigame.utils.MiniGameTabTestConstants;
import com.tencent.mobileqq.utils.abtest.IOnlineExpProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/impl/MiniGameTabTestProviderImpl;", "Lcom/tencent/mobileqq/utils/abtest/IOnlineExpProvider;", "()V", "getBusinessProfiles", "", "", "getRegisterExpNameList", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameTabTestProviderImpl implements IOnlineExpProvider {
    @Override // com.tencent.mobileqq.utils.abtest.IOnlineExpProvider
    public Map<String, String> getBusinessProfiles() {
        return new HashMap();
    }

    @Override // com.tencent.mobileqq.utils.abtest.IOnlineExpProvider
    public List<String> getRegisterExpNameList() {
        return MiniGameTabTestConstants.INSTANCE.getREGISTER_ABTEST_LIST();
    }
}

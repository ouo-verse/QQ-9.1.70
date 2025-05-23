package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes17.dex */
public interface IGProClientIdentityByteInfo extends Serializable {
    int getClientId();

    List<IGProIdentityInfoWithClientId> getDefaultIdentityList();

    List<IGProIdentityInfo> getIdentityList();
}

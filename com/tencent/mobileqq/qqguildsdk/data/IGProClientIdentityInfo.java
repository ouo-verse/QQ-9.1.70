package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProClientIdentityInfo extends Serializable {
    String getClientId();

    String getDesc();

    IGProClientIdentityByteInfo getIdentityBytes();
}

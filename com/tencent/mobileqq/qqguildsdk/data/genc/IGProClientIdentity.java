package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProClientIdentity extends Serializable {
    int getClientId();

    String getDesc();

    IGProClientIdentityBytes getIdentityBytes();

    String toString();
}

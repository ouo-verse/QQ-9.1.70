package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProIdentity extends Serializable {
    int getIdentityType();

    byte[] getThirdPartyData();

    int getType();

    String getValue();

    String toString();
}

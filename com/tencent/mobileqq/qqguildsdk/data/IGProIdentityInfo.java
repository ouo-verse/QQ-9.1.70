package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProIdentityInfo extends Serializable {
    int getIdentityType();

    byte[] getPlateData();

    int getType();

    String getValue();
}

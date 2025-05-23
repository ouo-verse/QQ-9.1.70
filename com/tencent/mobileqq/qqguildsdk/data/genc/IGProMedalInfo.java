package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProMedalInfo extends Serializable {
    long getExpireTime();

    String getIconUrl();

    String getName();

    IGProOfficialMedalInfoExt getOfficialMedalInfoExt();

    String toString();
}

package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProCreateGuildRsp extends Serializable {
    long getGuildId();

    IGProSecurityResult getSecRet();

    String toString();
}

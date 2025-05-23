package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProCmd0xf5dGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProJoinGuildResult extends Serializable {
    IGProCmd0xf5dGuildInfo getGuildChannels();

    long getGuildId();

    IGProGuildInfo getGuildInfo();

    int getOpenTab();

    int getQqMsgInList();

    int getRetCode();

    IGProSecurityResult getSecRet();

    String toString();
}

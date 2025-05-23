package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterChannelPermission;

/* loaded from: classes17.dex */
public interface IEnterChannelPermission extends IGProEnterChannelPermission {
    boolean getAllowEnter();

    boolean getAllowLive();

    String getDisallowLiveReason();

    String getDisallowReason();

    int getLiveType();

    String getLiveUrl();

    long getMsgSeq();
}

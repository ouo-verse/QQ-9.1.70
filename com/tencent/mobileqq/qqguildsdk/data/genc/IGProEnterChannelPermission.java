package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProEnterChannelPermission extends Serializable {
    boolean getAllowEnter();

    boolean getAllowLive();

    String getDisallowLiveReason();

    String getDisallowReason();

    int getLiveType();

    String getLiveUrl();

    long getMsgSeq();

    String toString();
}

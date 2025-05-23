package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProRecentVisitChannelInfo extends Serializable {
    long getChannelId();

    IGProChannel getChannelInfo();

    long getUpdateTime();

    String toString();
}

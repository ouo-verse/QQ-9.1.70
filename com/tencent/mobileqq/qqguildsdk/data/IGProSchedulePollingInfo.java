package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProSchedulePollingInfo extends Serializable {
    long getChannelId();

    long getGuildId();

    ArrayList<IGProScheduleStatusInfo> getSchedulerStatus();

    String toString();
}

package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProAtSetInfo extends Serializable {
    long getGuildId();

    int getRemainingAtAllCount();

    int getRemainingAtNotifyTimes();

    int getRemainingAtOnlCount();

    int getRemainingAtRoleCount();

    int getTotalAtAllCount();

    int getTotalAtNotifyTimes();

    int getTotalAtOnlCount();

    int getTotalAtRoleCount();

    String toString();
}

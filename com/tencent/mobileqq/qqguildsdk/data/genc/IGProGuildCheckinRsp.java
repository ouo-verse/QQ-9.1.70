package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProGuildCheckinRsp extends Serializable {
    int getCheckinCnt();

    int getCheckinStatus();

    int getFirstCheckin();

    int getRank();

    int getTodayActive();

    int getTomorrowActive();

    String toString();
}

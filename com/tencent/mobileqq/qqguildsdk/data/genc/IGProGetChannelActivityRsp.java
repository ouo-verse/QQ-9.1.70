package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGetChannelActivityRsp extends Serializable {
    ArrayList<IGProChannelActivity> getChannelActivities();

    int getCloseOption();

    long getGuildId();

    boolean getIsShow();

    String toString();
}

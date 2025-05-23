package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProScheduleInfo extends Serializable {
    int getAcceptedNums();

    ArrayList<IGProScheduleUser> getAcceptedUser();

    IGProScheduleChannelInfo getChannelInfo();

    String getContent();

    long getCreateTimeMs();

    IGProScheduleUser getCreator();

    long getEndTimeMs();

    int getInviteStatus();

    boolean getIsNotified();

    IGProOtherJumpAddress getOtherJumpAddress();

    int getRejectedNums();

    int getReminderTimeType();

    long getScheduleId();

    long getStartTimeMs();

    String getTitle();

    String toString();
}

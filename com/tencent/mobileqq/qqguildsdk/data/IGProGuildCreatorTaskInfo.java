package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTaskInfo;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGuildCreatorTaskInfo extends Serializable {
    int getFinishedCnt();

    boolean getIsAllFinished();

    int getSkipStatus();

    ArrayList<IGProTaskInfo> getTasks();

    int getTotalCnt();

    String toString();
}

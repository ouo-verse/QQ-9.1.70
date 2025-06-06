package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProRecommendH5Game extends Serializable {
    IGProRecommendGameInfo getGame();

    ArrayList<IGProRecommendMsg> getMembers();

    long getReadyExpireTime();

    long getTeamId();

    int getTeamStatus();

    String toString();
}

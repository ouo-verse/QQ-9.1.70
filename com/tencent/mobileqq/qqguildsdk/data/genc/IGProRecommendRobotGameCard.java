package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProRecommendRobotGameCard extends Serializable {
    IGProRecommendRobotInfo getRobotInfo();

    ArrayList<IGProRecommendRobotTextChannel> getRobotTextChannel();

    String toString();
}

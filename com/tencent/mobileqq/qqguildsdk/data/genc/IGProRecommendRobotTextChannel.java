package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProRecommendRobotTextChannel extends Serializable {
    ArrayList<String> getAvatars();

    IGProRecommendChannelInfo getChannelInfo();

    ArrayList<com.tencent.mobileqq.qqguildsdk.data.fe> getMsgAbstracts();

    String toString();
}

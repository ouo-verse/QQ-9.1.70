package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGuildLabelInfo extends Serializable {
    String getGuildCover();

    String getGuildIcon();

    long getGuildId();

    String getGuildName();

    ArrayList<IGProGuildLabel> getLabels();

    ArrayList<IGProMedalInfo> getMedals();

    String getProfile();

    ArrayList<IGProRecommendGuildState> getStateList();

    String toString();
}

package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProSelectedGuildCard extends Serializable {
    String getGuildAvatar();

    long getGuildId();

    String getGuildName();

    ArrayList<IGProMedalInfo> getMedals();

    ArrayList<IGProGuildLabel> getTagList();

    String toString();
}

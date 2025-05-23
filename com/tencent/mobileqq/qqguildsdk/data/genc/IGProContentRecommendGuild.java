package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProContentRecommendGuild extends Serializable {
    String getCover();

    IGProGameGiftInfo getGiftInfo();

    String getGuildAvatar();

    long getGuildId();

    String getGuildIntro();

    String getGuildName();

    String getGuildProfile();

    byte[] getJoinSig();

    ArrayList<IGProMedalInfo> getMedals();

    ArrayList<IGProGuildLabel> getTagList();

    String toString();
}

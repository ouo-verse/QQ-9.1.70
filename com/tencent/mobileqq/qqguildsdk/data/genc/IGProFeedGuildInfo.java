package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProFeedGuildInfo extends Serializable {
    long getChannelId();

    String getGuildIcon();

    long getGuildId();

    String getGuildName();

    String getJoinGuildSig();

    ArrayList<IGProMedalInfo> getMedals();

    String toString();
}

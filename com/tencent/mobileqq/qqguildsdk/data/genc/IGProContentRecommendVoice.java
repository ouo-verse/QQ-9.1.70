package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProContentRecommendVoice extends Serializable {
    long getChannelId();

    int getChannelType();

    String getCover();

    long getGuildId();

    IGProFeedGuildInfo getGuildInfo();

    byte[] getJoinSig();

    ArrayList<String> getMemberAvatarList();

    IGProContentRecommendStreamInfo getScreenStreamUrl();

    String getThemeSessionId();

    int getThemeType();

    String getVoiceTitle();

    String toString();
}

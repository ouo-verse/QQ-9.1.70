package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProHotLiveCard extends Serializable {
    long getChannelId();

    int getChannelType();

    String getCover();

    long getGuildId();

    String getIcon();

    String getLiveTitle();

    ArrayList<String> getMemberAvatarList();

    long getRoomId();

    String getThemeSessionId();

    int getThemeType();

    String toString();
}

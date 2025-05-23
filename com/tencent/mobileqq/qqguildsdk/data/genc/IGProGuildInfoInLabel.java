package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGuildInfoInLabel extends Serializable {
    String getGuildIcon();

    long getGuildId();

    ArrayList<String> getGuildLabels();

    String getGuildName();

    int getGuildStatus();

    String getJoinGuildSig();

    String toString();
}

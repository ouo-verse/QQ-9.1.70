package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProRecommendShareLive extends Serializable {
    String getAnchorIcon();

    long getAnchorId();

    ArrayList<String> getAudienceIcons();

    long getChannelId();

    long getRoomId();

    String getRoomName();

    String getStreamUrl();

    String toString();
}

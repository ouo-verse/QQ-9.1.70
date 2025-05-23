package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProRecentVisitChannelList extends Serializable {
    long getGuildId();

    ArrayList<IGProRecentVisitChannelInfo> getRecentList();

    String toString();
}

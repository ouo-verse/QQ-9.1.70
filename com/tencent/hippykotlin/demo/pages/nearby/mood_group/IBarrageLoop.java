package com.tencent.hippykotlin.demo.pages.nearby.mood_group;

import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes31.dex */
public interface IBarrageLoop {
    NBPMoodGroupPageState getCurrentPageState();

    List<UserMarkerInfo> getMarkerList();

    int getMid();

    NBPMoodGroupConfig getMoodConfig();

    boolean isShooting();
}

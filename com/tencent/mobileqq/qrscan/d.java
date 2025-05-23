package com.tencent.mobileqq.qrscan;

import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface d {
    void a(AppRuntime appRuntime);

    String getFriendDisplayNameJustCache(AppRuntime appRuntime, String str);

    boolean isRingEqualsZero(AppRuntime appRuntime);

    boolean isRingerSilent(AppRuntime appRuntime);

    boolean isRingerVibrate(AppRuntime appRuntime);

    boolean isVideoChatting(AppRuntime appRuntime);

    void speak(String str);
}

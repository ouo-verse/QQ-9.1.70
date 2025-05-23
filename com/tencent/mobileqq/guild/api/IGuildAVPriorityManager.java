package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildAVPriorityManager extends QRouteApi {
    public static final int IN_CURRENT_ROOM = 2;
    public static final int NOT_IN_CURRENT_ROOM = 1;
    public static final int NOT_IN_ROOM = 0;

    void abandonAVFocus(String str);

    int checkIsInAudioRoom(String str);

    boolean checkIsInGuildLive();

    boolean requestAVFocus(AppRuntime appRuntime, String str);
}

package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Set;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGuildConfigApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void g(String str);
    }

    String getGuildTabName();

    double getInputRobotHintProbability();

    boolean getShowRobotButtonInAddPanel();

    Set<String> getShowRobotCommandGuildList();

    Set<Long> getTroopJoinGuildBean_AllowShowClassSet();

    String getTroopJoinGuildBean_JumpUrl();

    int getTroopJoinGuildBean_ShowMaxTimes();

    boolean getTroopJoinGuildBean_Switch();

    String getTroopJoinGuildBean_TipStr();

    void registerGuildTabNameUpdate(a aVar);
}

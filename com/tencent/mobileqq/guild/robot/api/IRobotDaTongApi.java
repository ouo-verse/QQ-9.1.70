package com.tencent.mobileqq.guild.robot.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IRobotDaTongApi extends QRouteApi {
    void reportBlackRobotGray(View view, String str, String str2);

    void reportDirectMsgBotBtn(View view, String str, String str2);

    void reportRobotServiceTab(View view);

    void setAndReportBotSourceTail(View view, String str, String str2, String str3, String str4);

    void setAtPanelShowFunc(View view, int i3);

    void setRobotServiceTab(View view);
}

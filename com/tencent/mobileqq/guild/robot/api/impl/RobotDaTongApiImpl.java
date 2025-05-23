package com.tencent.mobileqq.guild.robot.api.impl;

import android.view.View;
import com.tencent.mobileqq.guild.robot.api.IRobotDaTongApi;
import kx1.c;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RobotDaTongApiImpl implements IRobotDaTongApi {
    @Override // com.tencent.mobileqq.guild.robot.api.IRobotDaTongApi
    public void reportBlackRobotGray(View view, String str, String str2) {
        rx1.a.c(view, str, str2);
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IRobotDaTongApi
    public void reportDirectMsgBotBtn(View view, String str, String str2) {
        rx1.a.d(view, str, str2);
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IRobotDaTongApi
    public void reportRobotServiceTab(View view) {
        rx1.a.e(view);
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IRobotDaTongApi
    public void setAndReportBotSourceTail(View view, String str, String str2, String str3, String str4) {
        c.a(view, str, str2, str3, str4);
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IRobotDaTongApi
    public void setAtPanelShowFunc(View view, int i3) {
        rx1.a.f(view, i3);
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IRobotDaTongApi
    public void setRobotServiceTab(View view) {
        rx1.a.g(view);
    }
}

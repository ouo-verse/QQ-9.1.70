package com.tencent.mobileqq.guild.schedule.create;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import vh2.ce;
import vh2.cg;

/* compiled from: P */
/* loaded from: classes14.dex */
public class l extends com.tencent.mobileqq.mvvm.a {

    /* renamed from: a, reason: collision with root package name */
    private AppInterface f233091a;

    public l(AppInterface appInterface) {
        this.f233091a = appInterface;
    }

    public void j(String str, String str2, GuildScheduleInfo guildScheduleInfo, ce ceVar) {
        ((IGPSService) this.f233091a.getRuntimeService(IGPSService.class, "")).createSchedule(str, str2, guildScheduleInfo, ceVar);
    }

    public AppInterface k() {
        return this.f233091a;
    }

    public void l(String str, String str2, GuildScheduleInfo guildScheduleInfo, cg cgVar) {
        ((IGPSService) this.f233091a.getRuntimeService(IGPSService.class, "")).editSchedule(str, str2, guildScheduleInfo, 2, cgVar);
    }
}

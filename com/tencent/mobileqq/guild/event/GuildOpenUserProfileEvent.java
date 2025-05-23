package com.tencent.mobileqq.guild.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes13.dex */
public class GuildOpenUserProfileEvent extends SimpleBaseEvent {
    public Boolean isRobot;

    public GuildOpenUserProfileEvent(Boolean bool) {
        this.isRobot = bool;
    }

    public String toString() {
        return "GuildAtUserTypeEvent{isRobot=" + this.isRobot + "} " + super.toString();
    }
}

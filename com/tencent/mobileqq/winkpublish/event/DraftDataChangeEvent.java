package com.tencent.mobileqq.winkpublish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;

/* compiled from: P */
@PluginInterface
/* loaded from: classes21.dex */
public class DraftDataChangeEvent extends SimpleBaseEvent {
    public static final int OPTION_TYPE_ADD = 1;
    public static final int OPTION_TYPE_DEL = 2;
    public static final int OPTION_TYPE_QUERY = 4;
    public static final int OPTION_TYPE_UPDATE = 3;
    private String missionId;
    private int optionType;

    public DraftDataChangeEvent(int i3) {
        this.optionType = i3;
    }

    public String getMissionId() {
        return this.missionId;
    }

    public int getOptionType() {
        return this.optionType;
    }

    public void setMissionId(String str) {
        this.missionId = str;
    }

    public void setOptionType(int i3) {
        this.optionType = i3;
    }

    public String toString() {
        return "DraftDataChangeEvent{optionType=" + this.optionType + ", missionId='" + this.missionId + "'}";
    }

    public DraftDataChangeEvent(int i3, String str) {
        this.optionType = i3;
        this.missionId = str;
    }
}

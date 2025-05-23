package com.qzone.reborn.intimate.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.List;
import qzone.QZIntimateSpaceMedal$MedalInfo;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneIntimateNewBadgeFullAnimEvent extends SimpleBaseEvent {
    private String mAlertMedalId;
    private final boolean mHasDoneAnim;
    private List<QZIntimateSpaceMedal$MedalInfo> mNewMedalInfo;

    public QZoneIntimateNewBadgeFullAnimEvent(boolean z16, List<QZIntimateSpaceMedal$MedalInfo> list, String str) {
        this.mHasDoneAnim = z16;
        this.mNewMedalInfo = list;
        this.mAlertMedalId = str;
    }

    public String getAlertMedalId() {
        return this.mAlertMedalId;
    }

    public List<QZIntimateSpaceMedal$MedalInfo> getNewMedalInfo() {
        return this.mNewMedalInfo;
    }

    public boolean hasDoneAnim() {
        return this.mHasDoneAnim;
    }
}

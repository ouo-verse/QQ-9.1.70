package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import java.io.Serializable;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class PushSwitchGrayTipsInfo extends Entity implements Serializable {
    public long lastShowTime;
    public int sessionType;
    public int showCount;
    public String toUin;
    public String uin;

    public PushSwitchGrayTipsInfo(String str, String str2, int i3, long j3, int i16) {
        this.uin = str;
        this.toUin = str2;
        this.sessionType = i3;
        this.lastShowTime = j3;
        this.showCount = i16;
    }

    public PushSwitchGrayTipsInfo() {
    }
}

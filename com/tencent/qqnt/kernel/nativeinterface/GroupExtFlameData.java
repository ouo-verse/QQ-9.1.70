package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupExtFlameData {
    public ArrayList<Integer> dayNums = new ArrayList<>();
    public boolean isDisplayDayNum;
    public int state;
    public int switchState;
    public long updateTime;
    public int version;

    public ArrayList<Integer> getDayNums() {
        return this.dayNums;
    }

    public boolean getIsDisplayDayNum() {
        return this.isDisplayDayNum;
    }

    public int getState() {
        return this.state;
    }

    public int getSwitchState() {
        return this.switchState;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public int getVersion() {
        return this.version;
    }

    public String toString() {
        return "GroupExtFlameData{switchState=" + this.switchState + ",state=" + this.state + ",dayNums=" + this.dayNums + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",updateTime=" + this.updateTime + ",isDisplayDayNum=" + this.isDisplayDayNum + ",}";
    }
}

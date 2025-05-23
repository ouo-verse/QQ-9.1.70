package com.tencent.mobileqq.gamecenter.msginfo;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameSwitchConfig extends Entity {
    public static final String TAG = "GameCenterMsg.GameSwitchConfig";

    @unique
    public String mAppId;
    public int mBlockSwitch;
    public int mBoxSwitch;
    public int mMuteSwitch;
    public int mSyncSwitch;

    public void print() {
        StringBuilder sb5 = new StringBuilder(500);
        sb5.append("appId:");
        sb5.append(this.mAppId);
        sb5.append(",syncSwitch:");
        sb5.append(this.mSyncSwitch);
        sb5.append(",blockSwitch:");
        sb5.append(this.mBlockSwitch);
        sb5.append(", boxSwitch:");
        sb5.append(this.mBoxSwitch);
        sb5.append(", mMuteSwitch");
        sb5.append(this.mMuteSwitch);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, sb5.toString());
        }
    }
}

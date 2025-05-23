package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProChannelOpenStateResultInfo extends Serializable {
    int getMsgNotifyTypeGuildNumber();

    boolean getPeakActivityGuildFlag();

    ArrayList<IGProSwitchInfo> getSwitchInfoList();

    String toString();
}

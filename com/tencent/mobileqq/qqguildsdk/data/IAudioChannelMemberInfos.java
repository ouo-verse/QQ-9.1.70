package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IAudioChannelMemberInfos extends Serializable {
    IGProAVChannelConfig getAVChannelConfig();

    int getChannelGameStatus();

    int getChannelMemberCount();

    int getChannelMemberMax();

    ArrayList<IGProChannelStateInfo> getChannelStateList();

    String getChannleId();

    int getNoMemberMaxLimit();

    IGProUserInfo getScreenShareUserInfo();

    int getSource();

    long getUpdateTime();

    List<IGProUserInfo> getUserList();

    List<IGProUserInfo> getUserListOfMuting();

    List<IGProUserInfo> getUserListOfUnMuting();

    boolean removeUser(String str);
}

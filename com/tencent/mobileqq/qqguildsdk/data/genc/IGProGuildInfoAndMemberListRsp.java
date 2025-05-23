package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGuildInfoAndMemberListRsp extends Serializable {
    ArrayList<String> getAvatarMetas();

    IGProGuildInfo getGuildInfo();

    ArrayList<IGProUserInfo> getMemberList();

    int getTotalMemberCnt();

    String toString();
}

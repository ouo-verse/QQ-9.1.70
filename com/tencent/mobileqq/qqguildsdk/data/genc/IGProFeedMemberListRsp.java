package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProFeedMemberListRsp extends Serializable {
    boolean getIsFinished();

    boolean getIsSmallGuild();

    long getNextIndex();

    long getNextRoleIdIndex();

    ArrayList<IGProUserInfo> getRobotMembers();

    ArrayList<IGProRoleMemberList> getRoleList();

    int getTotalMemberNum();

    String toString();
}

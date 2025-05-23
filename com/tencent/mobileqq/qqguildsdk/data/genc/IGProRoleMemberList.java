package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProRoleMemberList extends Serializable {
    ArrayList<IGProUserInfo> getMembers();

    IGProGuildRoleInfo getRole();

    String toString();
}

package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes17.dex */
public interface IGProRoleMemberListInfo extends Serializable {
    List<IGProUserInfo> getMemberList();

    IGProGuildRoleInfo getRoleInfo();

    String toString();
}

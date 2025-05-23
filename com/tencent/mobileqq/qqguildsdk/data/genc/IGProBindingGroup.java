package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProBindingGroup extends Serializable {
    long getGroupCode();

    int getGroupFlag();

    long getGroupMemberSize();

    String getGroupName();

    String getGroupUrl();

    int getIsConfGroup();

    boolean getIsGroupMember();

    String getOnlineMemberSize();

    int getPrivilege();

    String getSignature();

    String toString();
}

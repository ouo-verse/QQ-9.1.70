package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes17.dex */
public interface IGProRoleMemberChange extends Serializable {
    List<String> getAddMembers();

    List<String> getRemoveMembers();

    String getRoleId();
}

package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProMVPUser extends Serializable {
    String getAvatar();

    String getNick();

    ArrayList<IGProMVPRoleGroup> getRoleGroups();

    long getTinyid();

    long getUin();

    String toString();
}

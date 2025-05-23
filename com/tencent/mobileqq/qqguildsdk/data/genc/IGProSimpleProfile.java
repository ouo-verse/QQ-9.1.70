package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProSimpleProfile extends Serializable {
    String getAvatarMeta();

    String getAvatarPendant();

    ArrayList<Long> getCategoryIds();

    IGProClientIdentity getClientIdentityBytes();

    String getDisplayName();

    long getGuildId();

    long getLevelRoleId();

    String getMemberName();

    String getNickName();

    IGProMedal getPersonalMedal();

    long getRoleId();

    long getTinyId();

    String toString();
}

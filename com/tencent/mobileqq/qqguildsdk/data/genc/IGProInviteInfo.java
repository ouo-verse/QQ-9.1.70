package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProInviteInfo extends Serializable {
    String getBase64Avatar();

    long getChnId();

    long getGuildId();

    String getInviteUrl();

    String getJoinSig();

    String getName();

    String getNickName();

    String toString();
}

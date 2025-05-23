package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProFetchUserJoinedGuildListRsp extends Serializable {
    String getCookie();

    boolean getIsEnd();

    IGProUserJoinedGuildSummary getJoinedGuildSummary();

    String toString();
}

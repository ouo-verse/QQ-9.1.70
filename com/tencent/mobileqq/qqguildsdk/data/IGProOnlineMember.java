package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes17.dex */
public interface IGProOnlineMember extends Serializable {
    String getGuildId();

    String getHotIcon();

    @Deprecated
    String getMemberCnt();

    @Deprecated
    String getMemberTitle();

    List<String> getOnlineMemberAvatars();

    String getOnlineMemberCnt();

    String toString();
}

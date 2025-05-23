package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProStickyTextChannel extends Serializable {
    String getActiveMemberCount();

    ArrayList<IGProUserInfo> getActiveMemberList();

    ArrayList<fe> getMsgAbstracts();

    ArrayList<IGProMsgSummary> getMsgList();
}

package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProAISearchGetSessionMsgListRsp extends Serializable {
    long getCookie();

    boolean getIsFinished();

    String getSessionId();

    ArrayList<IGProAISearchSessionMsg> getSessionMsgList();

    String getWebCookie();

    String toString();
}

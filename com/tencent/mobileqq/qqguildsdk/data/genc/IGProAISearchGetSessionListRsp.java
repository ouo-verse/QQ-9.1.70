package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProAISearchGetSessionListRsp extends Serializable {
    long getCookie();

    boolean getIsFinished();

    long getTotalCount();

    ArrayList<IGProAISearchUserSessionCategory> getUserSessionList();

    String toString();
}

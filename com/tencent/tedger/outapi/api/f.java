package com.tencent.tedger.outapi.api;

import com.tencent.tedger.outapi.beans.EdgeAction;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface f {
    EdgeAction getAction();

    int getEventType();

    String getReqId();

    boolean isMutex();
}

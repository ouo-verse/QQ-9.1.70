package com.qzone.adapter.feedcomponent;

import android.os.Bundle;
import android.os.Handler;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface IResult {
    Bundle getBundle();

    Object getData();

    boolean getHasMore();

    String getMessage();

    long getNewCnt();

    Object getObjectData();

    int getReturnCode();

    boolean getSucceed();

    int getWhat();

    void sendToHandler(Handler handler);

    void setData(Object obj);

    void setFailReason(String str);

    void setHasMore(boolean z16);

    void setNewCnt(long j3);

    void setObjectData(Object obj);

    void setReturnCode(int i3);

    void setSucceed(boolean z16);

    void setWhat(int i3);
}

package com.tencent.mobileqq.teamwork.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IAudioHelper extends QRouteApi {
    public static final int index_Show_Doc_Tip = 10;
    public static final int value_true = 1;

    int getDebugValue(int i3);

    boolean isDev();

    void writeTestLog(String str);
}

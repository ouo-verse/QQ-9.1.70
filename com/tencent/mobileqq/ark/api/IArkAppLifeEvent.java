package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import i91.a;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IArkAppLifeEvent extends QRouteApi {
    public static final int EVENT_CREATEAPP = 0;
    public static final int EVENT_CREATEVIEW = 2;
    public static final int EVENT_DESTROYAPP = 1;
    public static final int EVENT_DESTROYVIEW = 3;

    void attachEvent(String str, String str2, a aVar);

    void detachEvent(String str, String str2);

    void doAction(int i3, String str, Object obj);
}

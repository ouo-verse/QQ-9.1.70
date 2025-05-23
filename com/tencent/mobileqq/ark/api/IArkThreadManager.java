package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IArkThreadManager extends QRouteApi {
    void postToAppThread(String str, Runnable runnable);

    void postToAppThreadDelay(String str, Runnable runnable, int i3);

    void postToLogicThread(Runnable runnable);

    void postToLogicThreadDelay(Runnable runnable, int i3);

    void postToMainThread(Runnable runnable);

    void postToMainThreadDelay(Runnable runnable, int i3);

    void sendToAppThread(String str, Runnable runnable);

    void sendToMainThread(Runnable runnable);
}

package com.tencent.mobileqq.mqq.api;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.adapter.aj;
import com.tencent.mobileqq.adapter.s;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.concurrent.Executor;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IThreadManagerApi<T> extends QRouteApi {
    void execute(Runnable runnable, int i3, s sVar, boolean z16);

    void executeOnFileThread(Runnable runnable);

    void executeOnSubThread(Runnable runnable);

    void executeOnSubThread(Runnable runnable, boolean z16);

    Thread getFileThread();

    T getFileThreadHandler();

    Looper getFileThreadLooper();

    Thread getRecentThread();

    Looper getRecentThreadLooper();

    Thread getSubThread();

    T getSubThreadHandler();

    Looper getSubThreadLooper();

    T getUIHandler();

    Handler getUIHandlerV2();

    HandlerThread newFreeHandlerThread(String str, int i3);

    Thread newFreeThread(Runnable runnable, String str, int i3);

    Executor newFreeThreadPool(aj ajVar);

    boolean removeJobFromThreadPool(Runnable runnable, int i3);

    String reportCurrentState();
}

package com.tencent.luggage.wxa.xd;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface d {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        boolean a(String str, com.tencent.luggage.wxa.ei.p pVar);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a(String str);

        void proceed();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void a(int i3, String str);

        void a(k0 k0Var, com.tencent.luggage.wxa.ei.p pVar, b bVar);

        void a(o oVar, String str, String str2, int i3, String str3);

        boolean a(o oVar, String str, String str2, int i3, b bVar);
    }

    l a(Class cls);

    o a(String str);

    void a(int i3, String str);

    void a(k0 k0Var);

    void a(k0 k0Var, int[] iArr);

    void a(Runnable runnable);

    void a(String str, String str2);

    void a(String str, String str2, int i3);

    void a(String str, String str2, int[] iArr);

    boolean a(m mVar);

    boolean a(String str, com.tencent.luggage.wxa.ei.p pVar);

    com.tencent.luggage.wxa.h1.b b(Class cls);

    void b(Runnable runnable);

    m c(Class cls);

    String getAppId();

    com.tencent.luggage.wxa.qc.b getAppState();

    @Nullable
    com.tencent.luggage.wxa.dq.a getAsyncHandler();

    int getComponentId();

    Context getContext();

    com.tencent.luggage.wxa.ml.r getDialogContainer();

    com.tencent.luggage.wxa.rc.r getFileSystem();

    c getInterceptor();

    @Nullable
    g1 getInvokeCostManager();

    com.tencent.luggage.wxa.ei.j getJsRuntime();

    @Nullable
    LifecycleOwner getLifecycleOwner();

    boolean isRunning();
}

package com.tencent.minibox.loader.core;

import android.app.Application;
import android.os.Bundle;
import com.tencent.minibox.common.log.LogUtils;
import com.tencent.minibox.dynamic.api.IDynamicApiManager;
import com.tencent.minibox.dynamic.api.IDynamicApiManagerFactory;
import com.tencent.minibox.dynamic.api.IMiniBoxCore;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/minibox/loader/core/a;", "", "Lcom/tencent/minibox/dynamic/api/IDynamicApiManagerFactory;", "e", "", "c", "Landroid/app/Application;", "application", "Landroid/os/Bundle;", "bundle", "d", "Lcom/tencent/minibox/dynamic/api/IDynamicApiManager;", "a", "", "b", "Lcom/tencent/minibox/dynamic/api/IDynamicApiManager;", "mApiImpl", "<init>", "()V", "MiniBoxLoader_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes9.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static volatile IDynamicApiManager mApiImpl;

    /* renamed from: b, reason: collision with root package name */
    public static final a f151655b = new a();

    a() {
    }

    private final IDynamicApiManagerFactory e() {
        Class<?> a16 = e.f151663b.a("com.tencent.minibox.dynamic.impl.DynamicApiManagerFactory");
        LogUtils.i("DynamicModuleManager", "factoryClazz: " + a16);
        Object newInstance = a16.newInstance();
        if (newInstance != null) {
            return (IDynamicApiManagerFactory) newInstance;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.minibox.dynamic.api.IDynamicApiManagerFactory");
    }

    @NotNull
    public final IDynamicApiManager a() {
        IDynamicApiManager iDynamicApiManager = mApiImpl;
        if (iDynamicApiManager == null) {
            Intrinsics.throwNpe();
        }
        return iDynamicApiManager;
    }

    public final boolean b() {
        if (mApiImpl != null) {
            return true;
        }
        return false;
    }

    public final synchronized void c() {
        if (mApiImpl != null) {
            return;
        }
        mApiImpl = e().createApiManager();
    }

    public final void d(@NotNull Application application, @NotNull Bundle bundle) {
        IMiniBoxCore miniBoxCore;
        Intrinsics.checkParameterIsNotNull(application, "application");
        Intrinsics.checkParameterIsNotNull(bundle, "bundle");
        IDynamicApiManager iDynamicApiManager = mApiImpl;
        if (iDynamicApiManager != null && (miniBoxCore = iDynamicApiManager.getMiniBoxCore()) != null) {
            miniBoxCore.init(application, bundle);
        }
        h.f151669a.b(application);
    }
}

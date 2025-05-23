package com.tencent.tbs.one;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.one.impl.common.f;
import com.tencent.tbs.one.impl.d;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class TBSOneManager {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f374510a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f374511b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static TBSOneManager f374512c;

    /* renamed from: d, reason: collision with root package name */
    private static Map<String, TBSOneManager> f374513d;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum Policy {
        AUTO,
        BUILTIN_ONLY,
        BUILTIN_FIRST,
        BUILTIN_ASSETS_ONLY,
        BUILTIN_ASSETS_FIRST,
        LOCAL_ONLY,
        LOCAL_FIRST,
        ONLINE
    }

    public static synchronized TBSOneManager getDefaultInstance(Context context) {
        TBSOneManager tBSOneManager;
        synchronized (TBSOneManager.class) {
            synchronized (f374510a) {
                if (f374512c == null) {
                    f374512c = new d(context, "default");
                }
                tBSOneManager = f374512c;
            }
        }
        return tBSOneManager;
    }

    public static int getInstalledComponentVersion(Context context, String str, String str2) {
        if (context == null) {
            return -2;
        }
        return f.a(context, str, str2);
    }

    public static TBSOneManager getInstance(Context context, String str) {
        TBSOneManager tBSOneManager;
        if (str.equals("default")) {
            return getDefaultInstance(context);
        }
        synchronized (f374511b) {
            if (f374513d == null) {
                f374513d = new HashMap();
            }
            tBSOneManager = f374513d.get(str);
            if (tBSOneManager == null) {
                tBSOneManager = new d(context, str);
                f374513d.put(str, tBSOneManager);
            }
        }
        return tBSOneManager;
    }

    public static void setNeedReportEvent(boolean z16) {
        com.tencent.tbs.one.impl.a.a(z16);
    }

    public abstract void cancelComponent(String str);

    public abstract void configure(String str, Object obj);

    public abstract String getBuildNumber();

    public abstract TBSOneDebugger getDebugger();

    public abstract String getDexUtilsExtraMsg();

    public abstract File getInstalledComponentPath(String str);

    public abstract int[] getInstalledVersionCodesOfComponent(String str);

    public abstract TBSOneComponent getLoadedComponent(String str);

    public abstract TBSOneOnlineService getOnlineService();

    public abstract int getVersionCode();

    public abstract String getVersionName();

    public abstract void installComponent(String str, Bundle bundle, TBSOneCallback<File> tBSOneCallback);

    public abstract void installComponent(String str, TBSOneCallback<File> tBSOneCallback);

    public abstract File installComponentSync(String str, Bundle bundle, long j3) throws TBSOneException;

    public abstract boolean isComponentInstalled(String str);

    public abstract void loadComponentAsync(String str, Bundle bundle, TBSOneCallback<TBSOneComponent> tBSOneCallback);

    public abstract void loadComponentAsync(String str, TBSOneCallback<TBSOneComponent> tBSOneCallback);

    public abstract TBSOneComponent loadComponentSync(String str, long j3) throws TBSOneException;

    public abstract TBSOneComponent loadComponentSync(String str, Bundle bundle, long j3) throws TBSOneException;

    public abstract void setAutoUpdateEnabled(boolean z16);

    public abstract void setDelegate(TBSOneDelegate tBSOneDelegate);

    public abstract void setOatOptEnable(boolean z16);

    public abstract void setPolicy(Policy policy);

    public abstract void setTBSOneLoggingHandler(a aVar);
}

package com.tencent.smtt.sdk;

import android.content.Context;
import java.lang.reflect.Field;

/* compiled from: P */
@Deprecated
/* loaded from: classes23.dex */
public class CookieSyncManager {

    /* renamed from: a, reason: collision with root package name */
    private static android.webkit.CookieSyncManager f368957a = null;

    /* renamed from: b, reason: collision with root package name */
    private static CookieSyncManager f368958b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f368959c = false;

    CookieSyncManager(Context context) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[]{Context.class}, context);
            f368959c = true;
        }
    }

    public static synchronized CookieSyncManager createInstance(Context context) {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            f368957a = android.webkit.CookieSyncManager.createInstance(context);
            if (f368958b == null || !f368959c) {
                f368958b = new CookieSyncManager(context.getApplicationContext());
            }
            cookieSyncManager = f368958b;
        }
        return cookieSyncManager;
    }

    public static synchronized CookieSyncManager getInstance() {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            cookieSyncManager = f368958b;
            if (cookieSyncManager == null) {
                throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
            }
        }
        return cookieSyncManager;
    }

    public void startSync() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
            return;
        }
        f368957a.startSync();
        try {
            Field declaredField = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
            declaredField.setAccessible(true);
            ((Thread) declaredField.get(f368957a)).setUncaughtExceptionHandler(new h());
        } catch (Exception unused) {
        }
    }

    public void stopSync() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
        } else {
            f368957a.stopSync();
        }
    }

    public void sync() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
        } else {
            f368957a.sync();
        }
    }
}

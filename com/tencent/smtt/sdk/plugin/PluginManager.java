package com.tencent.smtt.sdk.plugin;

import android.content.Context;

/* loaded from: classes23.dex */
public class PluginManager {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f369482a = false;

    /* renamed from: b, reason: collision with root package name */
    private static PluginManager f369483b;

    /* renamed from: c, reason: collision with root package name */
    private b f369484c;

    PluginManager(Context context) {
        this.f369484c = b.a(context);
    }

    public static PluginManager getInstance(Context context) {
        if (f369483b == null) {
            f369483b = new PluginManager(context);
        }
        return f369483b;
    }

    public static boolean printDebugLog() {
        return f369482a;
    }

    public static void setPrintDebugLog(boolean z16) {
        f369482a = z16;
    }

    public void installPluginList() {
        this.f369484c.b();
    }
}

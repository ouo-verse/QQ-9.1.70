package com.tencent.qqperf.monitor.crash.safemode;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f363217a;

    public static b a(String str) {
        b bVar = new b();
        try {
            bVar.f363217a = new JSONObject(str).optBoolean("test_crash_enabled", false);
            return bVar;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}

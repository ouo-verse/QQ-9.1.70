package com.heytap.mcssdk.f;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36195a = "shared_msg_sdk";

    /* renamed from: b, reason: collision with root package name */
    private static final String f36196b = "hasDefaultChannelCreated";

    public static void a(Context context, boolean z16) {
        context.getSharedPreferences(f36195a, 0).edit().putBoolean(f36196b, z16).commit();
    }

    public static boolean a(Context context) {
        return context.getSharedPreferences(f36195a, 0).getBoolean(f36196b, false);
    }
}

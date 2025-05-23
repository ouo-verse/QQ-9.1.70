package com.tencent.rdelivery.reshub.util;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes34.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static a f364598a;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public interface a {
        void e(String str, String str2, Throwable th5);
    }

    public static void a(String str, String str2, Throwable th5) {
        a aVar = f364598a;
        if (aVar != null) {
            aVar.e(str, str2, th5);
        } else {
            Log.e(str, str2, th5);
        }
    }

    public static void b(a aVar) {
        f364598a = aVar;
    }
}

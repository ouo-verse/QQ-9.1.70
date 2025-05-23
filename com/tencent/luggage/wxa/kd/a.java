package com.tencent.luggage.wxa.kd;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static b f131903a = new C6376a();

    /* renamed from: b, reason: collision with root package name */
    public static String f131904b;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kd.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6376a implements b {
        @Override // com.tencent.luggage.wxa.kd.b
        public void a(String str, Throwable th5, String str2) {
            th5.printStackTrace();
        }

        @Override // com.tencent.luggage.wxa.kd.b
        public void e(String str, String str2) {
            Log.e(str, str2);
        }

        @Override // com.tencent.luggage.wxa.kd.b
        public void i(String str, String str2) {
            Log.i(str, str2);
        }
    }

    public static void a(String str, b bVar) {
        f131904b = str;
        f131903a = bVar;
    }

    public static void b(String str, String str2) {
        f131903a.i(f131904b + str, str2);
        Log.i(f131904b + str, str2);
    }

    public static void a(String str, String str2) {
        f131903a.e(f131904b + str, str2);
        Log.e(f131904b + str, str2);
    }

    public static void a(String str, Throwable th5, String str2) {
        f131903a.a(str, th5, str2);
        Log.e(f131904b + str, str2, th5);
    }
}

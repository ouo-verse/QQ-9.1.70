package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private String f36767b;

    /* renamed from: a, reason: collision with root package name */
    private int f36766a = 4;

    /* renamed from: c, reason: collision with root package name */
    private d f36768c = new c();

    public void a(Context context, int i3, String str) {
        this.f36766a = i3;
        this.f36767b = str;
        this.f36768c.a(context, "HMSCore");
    }

    public void b(int i3, String str, String str2, Throwable th5) {
        try {
            if (a(i3)) {
                e a16 = a(i3, str, str2, th5);
                String str3 = a16.c() + a16.a();
                this.f36768c.a(str3, i3, str, str2 + '\n' + Log.getStackTraceString(th5));
            }
        } catch (OutOfMemoryError unused) {
            b();
        }
    }

    public d a() {
        return this.f36768c;
    }

    public void a(d dVar) {
        this.f36768c = dVar;
    }

    private void b() {
        try {
            Log.e("HMSSDK_LogAdaptor", "log happened OOM error.");
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i3) {
        return i3 >= this.f36766a;
    }

    public void a(int i3, String str, String str2) {
        try {
            if (a(i3)) {
                e a16 = a(i3, str, str2, null);
                this.f36768c.a(a16.c() + a16.a(), i3, str, str2);
            }
        } catch (OutOfMemoryError unused) {
            b();
        }
    }

    public void a(String str, String str2) {
        try {
            e a16 = a(4, str, str2, null);
            this.f36768c.a(a16.c() + '\n' + a16.a(), 4, str, str2);
        } catch (OutOfMemoryError unused) {
            b();
        }
    }

    private e a(int i3, String str, String str2, Throwable th5) {
        e eVar = new e(8, this.f36767b, i3, str);
        eVar.a((e) str2);
        eVar.a(th5);
        return eVar;
    }
}

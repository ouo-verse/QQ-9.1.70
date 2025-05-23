package com.tencent.tbs.one.impl.a;

import android.util.Log;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static a f374572a = new a(0);

    /* renamed from: b, reason: collision with root package name */
    private static com.tencent.tbs.one.a f374573b = null;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface b {
        void a(int i3, String str);
    }

    public static void a(b bVar) {
        f374572a.f374574a = bVar;
    }

    public static void b(String str, Object... objArr) {
        try {
            String a16 = a(str, a(objArr), objArr);
            f374572a.a(5, a16);
            a("TBSOne", "|W| " + a16);
        } catch (Throwable th5) {
            th5.getMessage();
        }
    }

    public static void c(String str, Object... objArr) {
        try {
            String a16 = a(str, a(objArr), objArr);
            f374572a.a(6, a16);
            a("TBSOne", "|E| " + a16);
        } catch (Throwable th5) {
            th5.getMessage();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class a implements b {

        /* renamed from: a, reason: collision with root package name */
        b f374574a;

        /* renamed from: b, reason: collision with root package name */
        boolean f374575b;

        a() {
            this.f374575b = false;
        }

        @Override // com.tencent.tbs.one.impl.a.g.b
        public final void a(int i3, String str) {
            b bVar = this.f374574a;
            if (bVar != null) {
                bVar.a(i3, str);
            }
            if (5 == i3 || this.f374575b) {
                Log.println(i3, "TBSOne", str);
            }
        }

        /* synthetic */ a(byte b16) {
            this();
        }
    }

    public static void a(boolean z16) {
        f374572a.f374575b = z16;
    }

    public static void a(com.tencent.tbs.one.a aVar) {
        f374573b = aVar;
    }

    private static void a(String str, String str2) {
        com.tencent.tbs.one.a aVar = f374573b;
        if (aVar != null) {
            aVar.log(str, str2);
        }
    }

    private static String a(String str, Throwable th5, Object... objArr) {
        if (objArr != null && ((th5 == null && objArr.length > 0) || objArr.length > 1)) {
            str = String.format(Locale.US, str, objArr);
        }
        if (th5 == null) {
            return str;
        }
        return str + '\n' + Log.getStackTraceString(th5);
    }

    public static void a(String str, Object... objArr) {
        try {
            String a16 = a(str, a(objArr), objArr);
            f374572a.a(4, a16);
            a("TBSOne", "|I| " + a16);
        } catch (Throwable th5) {
            th5.getMessage();
        }
    }

    private static Throwable a(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        return null;
    }
}

package com.tencent.luggage.wxa.fd;

import android.text.TextUtils;
import android.util.SparseIntArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum u {
    ;


    /* renamed from: a, reason: collision with root package name */
    public static final b f125980a;

    /* renamed from: b, reason: collision with root package name */
    public static final b f125981b;

    static {
        f125980a = new b();
        f125981b = new b();
    }

    public static void b(String str, int i3) {
        f125981b.a(str, i3);
    }

    public static u valueOf(String str) {
        com.tencent.luggage.wxa.k0.d.a(Enum.valueOf(u.class, str));
        return null;
    }

    public static void a(String str, int i3) {
        f125980a.a(str, i3);
    }

    public static int b(String str) {
        n0 n0Var;
        int a16 = f125981b.a(str);
        if (a16 <= 0) {
            try {
                n0Var = o0.a().a(str, "dynamicInfo");
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppServiceSettingsResolver", e16, "queryWithAppId(%s)", str);
                n0Var = null;
            }
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(n0Var == null ? -1 : n0Var.g().f125894a.f125897b);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppServiceSettingsResolver", "readAppOpendataLocalStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d", objArr);
            a16 = n0Var != null ? n0Var.g().f125894a.f125897b : 5;
            b(str, a16);
        }
        return a16 * 1048576;
    }

    public static int a(String str) {
        n0 n0Var;
        int a16 = f125980a.a(str);
        if (a16 <= 0) {
            try {
                n0Var = o0.a().a(str, "dynamicInfo");
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppServiceSettingsResolver", e16, "queryWithAppId(%s)", str);
                n0Var = null;
            }
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(n0Var == null ? -1 : n0Var.g().f125894a.f125896a);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppServiceSettingsResolver", "readAppFileStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d", objArr);
            a16 = n0Var != null ? n0Var.g().f125894a.f125896a : 5;
            a(str, a16);
        }
        return a16 * 1048576;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final SparseIntArray f125983a;

        public b() {
            this.f125983a = new SparseIntArray();
        }

        public void a(String str, int i3) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (this.f125983a) {
                this.f125983a.put(str.hashCode(), i3);
            }
        }

        public int a(String str) {
            int i3;
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            synchronized (this.f125983a) {
                i3 = this.f125983a.get(str.hashCode(), -1);
            }
            return i3;
        }
    }
}

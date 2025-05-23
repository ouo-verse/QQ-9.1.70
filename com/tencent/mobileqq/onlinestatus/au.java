package com.tencent.mobileqq.onlinestatus;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class au {
    public com.tencent.mobileqq.onlinestatus.model.c A;
    public int B;

    /* renamed from: a, reason: collision with root package name */
    public String f255488a;

    /* renamed from: b, reason: collision with root package name */
    public long f255489b;

    /* renamed from: c, reason: collision with root package name */
    public String f255490c;

    /* renamed from: d, reason: collision with root package name */
    public String f255491d;

    /* renamed from: e, reason: collision with root package name */
    public String f255492e;

    /* renamed from: f, reason: collision with root package name */
    public int f255493f;

    /* renamed from: g, reason: collision with root package name */
    public AppRuntime.Status f255494g;

    /* renamed from: h, reason: collision with root package name */
    public int f255495h;

    /* renamed from: i, reason: collision with root package name */
    public String f255496i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f255497j;

    /* renamed from: k, reason: collision with root package name */
    public String f255498k;

    /* renamed from: l, reason: collision with root package name */
    public String f255499l;

    /* renamed from: m, reason: collision with root package name */
    public String f255500m;

    /* renamed from: n, reason: collision with root package name */
    public String f255501n;

    /* renamed from: o, reason: collision with root package name */
    public String f255502o;

    /* renamed from: p, reason: collision with root package name */
    public String f255503p;

    /* renamed from: q, reason: collision with root package name */
    public String f255504q;

    /* renamed from: r, reason: collision with root package name */
    public String f255505r;

    /* renamed from: s, reason: collision with root package name */
    public String f255506s;

    /* renamed from: t, reason: collision with root package name */
    public String f255507t;

    /* renamed from: u, reason: collision with root package name */
    public String f255508u;

    /* renamed from: v, reason: collision with root package name */
    public String f255509v;

    /* renamed from: w, reason: collision with root package name */
    public String f255510w;

    /* renamed from: x, reason: collision with root package name */
    public String f255511x;

    /* renamed from: y, reason: collision with root package name */
    public ArrayList<au> f255512y;

    /* renamed from: z, reason: collision with root package name */
    public long f255513z;

    public au() {
        this.f255493f = 1;
        this.f255494g = AppRuntime.Status.online;
        this.f255497j = true;
        this.f255503p = "";
        this.f255504q = "";
        this.f255505r = "";
        this.f255506s = "";
        this.f255507t = "";
        this.f255508u = "";
        this.f255509v = "";
        this.f255510w = "";
        this.f255511x = "";
        this.f255512y = null;
        this.f255513z = -1L;
        this.B = 0;
    }

    public static String a(AppRuntime.Status status, long j3) {
        return status.getValue() + "" + j3 + "";
    }

    public static boolean b(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static int c(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static boolean d(long j3) {
        if (j3 == 1000) {
            return true;
        }
        return false;
    }

    public Boolean e() {
        boolean z16;
        if (this.f255489b == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        au auVar = (au) obj;
        if (this.f255489b == auVar.f255489b && this.f255493f == auVar.f255493f && this.f255495h == auVar.f255495h && this.f255497j == auVar.f255497j && this.f255494g == auVar.f255494g && b(this.f255488a, auVar.f255488a) && b(this.f255490c, auVar.f255490c) && b(this.f255491d, auVar.f255491d) && b(this.f255496i, auVar.f255496i) && b(this.f255502o, auVar.f255502o)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return c(this.f255488a, Long.valueOf(this.f255489b), this.f255490c, this.f255491d, Integer.valueOf(this.f255493f), this.f255494g, Integer.valueOf(this.f255495h), this.f255496i, Boolean.valueOf(this.f255497j), this.f255502o);
    }

    @NonNull
    public String toString() {
        return "id=" + this.f255489b + " title=" + this.f255490c;
    }

    public au(long j3, String str, String str2, String str3) {
        this(j3, str, str2);
        if (TextUtils.isEmpty(str3)) {
            QLog.d("OnlineStatusConfProcessor", 1, "bigIcon is empty, use icon");
        } else {
            str2 = str3;
        }
        this.f255492e = str2;
    }

    public au(long j3, String str, String str2) {
        this.f255493f = 1;
        this.f255494g = AppRuntime.Status.online;
        this.f255497j = true;
        this.f255503p = "";
        this.f255504q = "";
        this.f255505r = "";
        this.f255506s = "";
        this.f255507t = "";
        this.f255508u = "";
        this.f255509v = "";
        this.f255510w = "";
        this.f255511x = "";
        this.f255512y = null;
        this.f255513z = -1L;
        this.B = 0;
        this.f255489b = j3;
        this.f255490c = str;
        this.f255491d = str2;
    }

    public au(AppRuntime.Status status) {
        this.f255493f = 1;
        AppRuntime.Status status2 = AppRuntime.Status.online;
        this.f255497j = true;
        this.f255503p = "";
        this.f255504q = "";
        this.f255505r = "";
        this.f255506s = "";
        this.f255507t = "";
        this.f255508u = "";
        this.f255509v = "";
        this.f255510w = "";
        this.f255511x = "";
        this.f255512y = null;
        this.f255513z = -1L;
        this.B = 0;
        this.f255493f = 2;
        this.f255494g = status;
        this.f255489b = 0L;
        this.f255495h = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getButtonId(status);
        this.f255490c = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getStatusName(status);
    }
}

package com.tencent.qcircle.cooperation.config.debug;

import android.text.TextUtils;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {

    /* renamed from: e, reason: collision with root package name */
    public static final List<e> f342446e = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    private long f342447a;

    /* renamed from: b, reason: collision with root package name */
    private String f342448b;

    /* renamed from: c, reason: collision with root package name */
    private int f342449c;

    /* renamed from: d, reason: collision with root package name */
    private String f342450d;

    public e(long j3, String str, int i3, String str2) {
        this.f342447a = j3;
        this.f342448b = str;
        this.f342449c = i3;
        this.f342450d = str2;
    }

    public static void a(e eVar) {
        if (!AppSetting.isDebugVersion() || eVar == null || TextUtils.isEmpty(eVar.c())) {
            return;
        }
        f342446e.add(eVar);
    }

    public String b() {
        return this.f342450d;
    }

    public String c() {
        return this.f342448b;
    }

    public int d() {
        return this.f342449c;
    }

    public long e() {
        return this.f342447a;
    }

    public String toString() {
        return "QCircleTabReportInfo{mReportTime=" + this.f342447a + ", mExpName='" + this.f342448b + "', mExpZone=" + this.f342449c + ", mExpAssignment='" + this.f342450d + "'}";
    }
}

package com.tencent.beacon.a.b;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, String> f77605a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    private boolean f77606b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f77607c = false;

    /* renamed from: d, reason: collision with root package name */
    private final Object f77608d = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(String str, String str2, Throwable th5) {
        a(str, str2, th5, true, new d(this));
    }

    private synchronized void e() {
        if (this.f77606b) {
            return;
        }
        Map<String, String> map = f77605a;
        map.put("attaid", b());
        map.put("token", c());
        map.put("error_code", "");
        map.put("platform", "Android");
        map.put("uin", com.tencent.beacon.a.c.e.l().d());
        map.put("model", Build.BOARD + " " + com.tencent.beacon.a.c.f.e().h());
        map.put("os", com.tencent.beacon.a.c.e.l().t());
        map.put("error_msg", "");
        map.put("error_stack_full", "");
        map.put("app_version", com.tencent.beacon.a.c.b.a());
        map.put("sdk_version", com.tencent.beacon.a.c.c.c().i());
        map.put(ReportDataBuilder.KEY_PRODUCT_ID, com.tencent.beacon.a.c.c.c().e());
        map.put("_dc", "");
        this.f77606b = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String c();

    public boolean d() {
        if (this.f77607c) {
            return true;
        }
        if (!com.tencent.beacon.d.b.a().i()) {
            com.tencent.beacon.base.util.c.b("atta report closed by user.", new Object[0]);
            return false;
        }
        com.tencent.beacon.base.util.c.b("atta report.", new Object[0]);
        if (com.tencent.beacon.base.util.c.b()) {
            return false;
        }
        return com.tencent.beacon.base.util.b.b(100);
    }

    public void a(boolean z16) {
        this.f77607c = z16;
    }

    public synchronized void a(String str, String str2) {
        a(str, str2, (Throwable) null);
    }

    public synchronized void a(String str, String str2, Throwable th5) {
        a(str, str2, th5, false, new b(this, str, str2, th5));
    }

    public synchronized void a(String str, String str2, Throwable th5, boolean z16, Callback<BResponse> callback) {
        if (d()) {
            if (!this.f77606b) {
                e();
            }
            if (TextUtils.isEmpty(str)) {
                com.tencent.beacon.base.util.c.b("[atta] errorCode isn't valid value!", new Object[0]);
            } else {
                a.a().a(new c(this, str, str2, th5, z16, callback));
            }
        }
    }

    public synchronized void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            com.tencent.beacon.base.util.c.b("[atta] errorCode isn't valid value!", new Object[0]);
        } else if (TextUtils.isEmpty(str)) {
            com.tencent.beacon.base.util.c.b("init beacon twice, but appkey is null!", new Object[0]);
        } else {
            if (com.tencent.beacon.base.util.b.a(10000) > 1) {
                return;
            }
            a.a().a(new f(this, str, str2, str3));
        }
    }
}

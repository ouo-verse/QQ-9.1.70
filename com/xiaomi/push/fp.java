package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.io.File;

/* compiled from: P */
/* loaded from: classes28.dex */
public class fp implements XMPushService.z {

    /* renamed from: d, reason: collision with root package name */
    private static boolean f388906d = false;

    /* renamed from: a, reason: collision with root package name */
    private Context f388907a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f388908b;

    /* renamed from: c, reason: collision with root package name */
    private int f388909c;

    public fp(Context context) {
        this.f388907a = context;
    }

    private void b(Context context) {
        this.f388908b = com.xiaomi.push.service.ah.d(context).m(gk.TinyDataUploadSwitch.a(), true);
        int a16 = com.xiaomi.push.service.ah.d(context).a(gk.TinyDataUploadFrequency.a(), 7200);
        this.f388909c = a16;
        this.f388909c = Math.max(60, a16);
    }

    public static void c(boolean z16) {
        f388906d = z16;
    }

    private boolean d() {
        if (Math.abs((System.currentTimeMillis() / 1000) - this.f388907a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > this.f388909c) {
            return true;
        }
        return false;
    }

    private boolean e(ft ftVar) {
        if (!au.t(this.f388907a) || ftVar == null || TextUtils.isEmpty(a(this.f388907a.getPackageName())) || !new File(this.f388907a.getFilesDir(), "tiny_data.data").exists() || f388906d) {
            return false;
        }
        if (com.xiaomi.push.service.ah.d(this.f388907a).m(gk.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) && !ge.k(this.f388907a) && !ge.q(this.f388907a)) {
            return false;
        }
        return true;
    }

    @Override // com.xiaomi.push.service.XMPushService.z
    public void a() {
        b(this.f388907a);
        if (this.f388908b && d()) {
            jz4.c.m("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            ft b16 = fs.a(this.f388907a).b();
            if (!e(b16)) {
                jz4.c.m("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                return;
            }
            f388906d = true;
            gb.b(this.f388907a, b16);
        }
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f388907a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }
}

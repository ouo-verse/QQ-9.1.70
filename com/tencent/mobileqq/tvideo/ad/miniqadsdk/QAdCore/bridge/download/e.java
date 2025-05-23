package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADApkDownloadTaskState;
import hv2.k;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e implements gv2.b {

    /* renamed from: a, reason: collision with root package name */
    private Context f303774a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences f303775b;

    /* renamed from: c, reason: collision with root package name */
    private volatile Set<String> f303776c;

    public e(Context context) {
        this.f303774a = context.getApplicationContext();
    }

    private synchronized void c(String str) {
        d();
        this.f303776c.remove(str);
        this.f303775b.edit().putStringSet("installed_apk_package", this.f303776c).apply();
    }

    private void d() {
        e();
        if (this.f303776c == null) {
            this.f303776c = this.f303775b.getStringSet("installed_apk_package", new HashSet());
        }
        if (this.f303776c == null) {
            this.f303776c = new HashSet();
        }
    }

    private void e() {
        if (this.f303775b != null) {
            return;
        }
        k kVar = (k) dv2.b.d().a(k.class);
        if (kVar != null) {
            this.f303775b = kVar.b("qad_installed_apk");
        }
        if (this.f303775b == null) {
            this.f303775b = this.f303774a.getSharedPreferences("qad_installed_apk", 0);
        }
    }

    private synchronized void f(String str) {
        d();
        this.f303776c.add(str);
        this.f303775b.edit().putStringSet("installed_apk_package", this.f303776c).apply();
    }

    @Override // gv2.b
    public void b(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e eVar) {
        if (eVar == null) {
            return;
        }
        if (QADApkDownloadTaskState.TASK_APK_INSTALLED == eVar.a()) {
            f(eVar.d());
        } else if (QADApkDownloadTaskState.TASK_DELETE == eVar.a()) {
            c(eVar.d());
        }
    }

    @Override // gv2.b
    public void a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.d dVar) {
    }
}

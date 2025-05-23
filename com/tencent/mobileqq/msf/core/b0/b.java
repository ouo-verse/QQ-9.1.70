package com.tencent.mobileqq.msf.core.b0;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b implements Runnable {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: c, reason: collision with root package name */
    public static final String f247536c = "MSF.D.MMKV.MigrateTask";

    /* renamed from: d, reason: collision with root package name */
    public static final String f247537d = "_msf_migrate_flag";

    /* renamed from: e, reason: collision with root package name */
    public static final String f247538e = "_msf_migrate_count";

    /* renamed from: f, reason: collision with root package name */
    public static final String f247539f = "event_code_msf_mmkv_migrate";

    /* renamed from: g, reason: collision with root package name */
    public static final String f247540g = "key_sp_name";

    /* renamed from: h, reason: collision with root package name */
    public static final String f247541h = "key_migrate_result";

    /* renamed from: i, reason: collision with root package name */
    public static final String f247542i = "key_sp_key_size";

    /* renamed from: j, reason: collision with root package name */
    public static final String f247543j = "key_uin";

    /* renamed from: k, reason: collision with root package name */
    public static final String f247544k = "key_time";

    /* renamed from: l, reason: collision with root package name */
    public static final String f247545l = "success";

    /* renamed from: m, reason: collision with root package name */
    public static final String f247546m = "fail";

    /* renamed from: n, reason: collision with root package name */
    public static final String f247547n = "error";

    /* renamed from: a, reason: collision with root package name */
    private final String f247548a;

    /* renamed from: b, reason: collision with root package name */
    private final String f247549b;

    public b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
        } else {
            this.f247548a = str;
            this.f247549b = str2;
        }
    }

    private void a(String str, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put(f247540g, this.f247548a);
        hashMap.put(f247541h, str);
        hashMap.put(f247542i, String.valueOf(i3));
        if (MsfService.getCore() != null && MsfService.getCore().getAccountCenter() != null) {
            hashMap.put("key_uin", MsfService.getCore().getAccountCenter().e());
        }
        hashMap.put("key_time", String.valueOf(System.currentTimeMillis()));
        com.tencent.mobileqq.msf.core.c0.j statReporter = MsfService.getCore().getStatReporter();
        if (statReporter != null) {
            statReporter.a(f247539f, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Object valueOf;
        String str;
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (TextUtils.isEmpty(this.f247548a)) {
            return;
        }
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(BaseApplication.getContext(), this.f247548a, this.f247549b);
        try {
            Map<String, ?> all = BaseApplication.context.getSharedPreferences(this.f247548a, 0).getAll();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("MSFMMKVMigrateTask start migrated:");
            sb5.append(this.f247548a);
            sb5.append(" to ");
            sb5.append(this.f247549b);
            sb5.append(", map: ");
            if (all == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(all.size());
            }
            sb5.append(valueOf);
            QLog.i(f247536c, 1, sb5.toString());
            boolean migrateToSpAdapter = QMMKV.migrateToSpAdapter(BaseApplication.getContext(), this.f247548a, 0, this.f247549b);
            synchronized (a.b(this.f247548a)) {
                fromSpAdapter.edit().putBoolean(f247537d, migrateToSpAdapter).apply();
            }
            if (migrateToSpAdapter) {
                str = "success";
            } else {
                str = "fail";
            }
            if (all == null) {
                size = 0;
            } else {
                size = all.size();
            }
            a(str, size);
            QLog.d(f247536c, 1, "MSFMMKVMigrateTask migrate " + this.f247548a + " to " + this.f247549b + ", result: " + migrateToSpAdapter);
        } catch (Exception unused) {
            int i3 = fromSpAdapter.getInt(f247538e, 0) + 1;
            fromSpAdapter.edit().putInt(f247538e, i3).apply();
            a("error", 0);
            QLog.e(f247536c, 1, "MSFMMKVMigrateTask migrate " + this.f247548a + " to " + this.f247549b + " fail, times: " + i3);
        }
    }
}

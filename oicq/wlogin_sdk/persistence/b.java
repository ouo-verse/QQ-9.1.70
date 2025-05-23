package oicq.wlogin_sdk.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.qmmkv.QMMKV;
import java.util.Map;
import oicq.wlogin_sdk.report.event.EventConstant;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Context f422785a;

    /* renamed from: b, reason: collision with root package name */
    public final String f422786b;

    /* renamed from: c, reason: collision with root package name */
    public final String f422787c;

    public b(Context context, String str, String str2) {
        this.f422785a = context;
        this.f422786b = str;
        this.f422787c = str2;
    }

    public final void a(String str, int i3) {
        util.LOGI("WtloginMMKV reportMMKVMigrateResult result " + str + " size " + i3, "");
        oicq.wlogin_sdk.report.c.a aVar = new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_MMKV_MIGRATE, "", "");
        aVar.f422861g.put(com.tencent.mobileqq.msf.core.b0.b.f247540g, this.f422786b);
        aVar.f422861g.put(com.tencent.mobileqq.msf.core.b0.b.f247541h, str);
        aVar.f422861g.put(com.tencent.mobileqq.msf.core.b0.b.f247542i, String.valueOf(i3));
        oicq.wlogin_sdk.report.c.b.a(aVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        Object valueOf;
        String str;
        int size;
        if (TextUtils.isEmpty(this.f422786b)) {
            return;
        }
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(this.f422785a, this.f422786b, this.f422787c);
        try {
            Map<String, ?> all = this.f422785a.getSharedPreferences(this.f422786b, 0).getAll();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("WtloginMMKV MSFMMKVMigrateTask start migrated:");
            sb5.append(this.f422786b);
            sb5.append(" to ");
            sb5.append(this.f422787c);
            sb5.append(", map: ");
            if (all == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(all.size());
            }
            sb5.append(valueOf);
            util.LOGI(sb5.toString(), "");
            boolean migrateToSpAdapter = QMMKV.migrateToSpAdapter(this.f422785a, this.f422786b, 0, this.f422787c);
            synchronized (a.a(this.f422786b)) {
                fromSpAdapter.edit().putBoolean("_wtlogin_migrate_flag", migrateToSpAdapter).apply();
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
            util.LOGI("WtloginMMKV MSFMMKVMigrateTask migrate " + this.f422786b + " to " + this.f422787c + ", result: " + migrateToSpAdapter);
        } catch (Exception unused) {
            int i3 = fromSpAdapter.getInt("_wtlogin_migrate_count", 0) + 1;
            fromSpAdapter.edit().putInt("_wtlogin_migrate_count", i3).apply();
            a("error", 0);
            util.LOGI("WtloginMMKV MSFMMKVMigrateTask migrate " + this.f422786b + " to " + this.f422787c + " fail, times: " + i3);
        }
    }
}

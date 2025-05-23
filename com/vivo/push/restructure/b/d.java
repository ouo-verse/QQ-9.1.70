package com.vivo.push.restructure.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.vivo.push.PushConfig;
import com.vivo.push.util.aa;
import com.vivo.push.util.g;
import com.vivo.push.util.u;
import com.vivo.push.util.z;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class d implements a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, c> f387802a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private String f387803b;

    /* renamed from: c, reason: collision with root package name */
    private z f387804c;

    /* renamed from: d, reason: collision with root package name */
    private volatile PushConfig f387805d;

    public d(z zVar) {
        this.f387804c = zVar;
    }

    @Override // com.vivo.push.restructure.b.a
    public final String a(Context context, String str) {
        if (!TextUtils.isEmpty(this.f387803b)) {
            return this.f387803b;
        }
        if (context != null && !TextUtils.isEmpty(str)) {
            String packageName = context.getPackageName();
            String a16 = a(context, packageName, str);
            this.f387803b = a16;
            if (TextUtils.isEmpty(a16)) {
                u.d("PushRelyImpl", " reflectReceiver error: receiver for: " + str + " not found, package: " + packageName);
            }
            return this.f387803b;
        }
        u.a("PushRelyImpl", "getReceiverClassName() params error, context = " + context + ", action = " + str);
        return "";
    }

    @Override // com.vivo.push.restructure.b.a
    public final void b() {
        a("");
    }

    @Override // com.vivo.push.restructure.b.a
    public final String c() {
        c cVar = f387802a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar != null) {
            String b16 = cVar.b();
            if (!TextUtils.isEmpty(b16)) {
                return b16;
            }
        }
        String c16 = this.f387804c.c();
        if (!TextUtils.isEmpty(c16)) {
            if (cVar == null) {
                cVar = new c();
            }
            cVar.b(c16);
            f387802a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
        }
        return c16;
    }

    @Override // com.vivo.push.restructure.b.a
    public final void d() {
        b("");
    }

    @Override // com.vivo.push.restructure.b.a
    public final void e() {
        this.f387804c.a();
        f387802a.clear();
    }

    @Override // com.vivo.push.restructure.b.a
    public final String f() {
        return this.f387804c.b("APP_TOKEN", (String) null);
    }

    @Override // com.vivo.push.restructure.b.a
    public final String g() {
        return this.f387804c.b("APP_TAGS", (String) null);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void h() {
        this.f387804c.a("APP_TAGS");
    }

    @Override // com.vivo.push.restructure.b.a
    public final String i() {
        return this.f387804c.b("APP_ALIAS", (String) null);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void j() {
        this.f387804c.a("APP_ALIAS");
    }

    @Override // com.vivo.push.restructure.b.a
    public final String k() {
        com.vivo.push.model.b a16 = aa.a(com.vivo.push.restructure.a.a().b(), com.vivo.push.restructure.a.a().f());
        if (a16 != null && !a16.c()) {
            return a16.a();
        }
        return null;
    }

    @Override // com.vivo.push.restructure.b.a
    public final PushConfig l() {
        boolean z16;
        if (this.f387805d != null) {
            return this.f387805d;
        }
        boolean z17 = true;
        int b16 = this.f387804c.b("PUSH_CLIENT_CONFIG", 1);
        PushConfig.Builder builder = new PushConfig.Builder();
        int i3 = b16 & 1;
        if (i3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        PushConfig.Builder agreePrivacyStatement = builder.agreePrivacyStatement(z16);
        if (i3 == 0) {
            z17 = false;
        }
        return agreePrivacyStatement.openMultiUserMode(z17).build();
    }

    @Override // com.vivo.push.restructure.b.a
    public final void b(String str) {
        this.f387804c.a("APP_APIKEY", str);
        c cVar = f387802a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar == null) {
            cVar = new c();
        }
        cVar.b(str);
        f387802a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void d(String str) {
        this.f387804c.a("APP_TAGS", str);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void e(String str) {
        this.f387804c.a("APP_ALIAS", str);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void c(String str) {
        this.f387804c.a("APP_TOKEN", str);
    }

    private static String a(Context context, String str, String str2) {
        List<ResolveInfo> queryBroadcastReceivers;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 64)) == null || queryBroadcastReceivers.size() <= 0) {
                return null;
            }
            return queryBroadcastReceivers.get(0).activityInfo.name;
        } catch (Exception e16) {
            u.a("PushRelyImpl", "error  " + e16.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.restructure.b.a
    public final String a() {
        c cVar = f387802a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar != null) {
            String a16 = cVar.a();
            if (!TextUtils.isEmpty(a16)) {
                return a16;
            }
        }
        String b16 = this.f387804c.b();
        if (!TextUtils.isEmpty(b16)) {
            if (cVar == null) {
                cVar = new c();
            }
            cVar.a(b16);
            f387802a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
        }
        return b16;
    }

    @Override // com.vivo.push.restructure.b.a
    public final void a(String str) {
        this.f387804c.a("APP_APPID", str);
        c cVar = f387802a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar == null) {
            cVar = new c();
        }
        cVar.a(str);
        f387802a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void a(PushConfig pushConfig) {
        if (pushConfig == null) {
            return;
        }
        this.f387805d = null;
        Context b16 = com.vivo.push.restructure.a.a().b();
        this.f387804c.a("PUSH_CLIENT_CONFIG", (pushConfig.isAgreePrivacyStatement() ? 1 : 0) | (pushConfig.isOpenMultiUser() ? 1 : 0));
        g.a().execute(new e(this, b16, pushConfig));
        this.f387805d = pushConfig;
    }
}

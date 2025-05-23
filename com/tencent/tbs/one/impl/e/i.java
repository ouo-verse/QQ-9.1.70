package com.tencent.tbs.one.impl.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneConfigurationKeys;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.k;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.a.o;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.e.e;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class i extends h {

    /* renamed from: q, reason: collision with root package name */
    public SharedPreferences f375067q;

    /* renamed from: r, reason: collision with root package name */
    g f375068r;

    /* renamed from: s, reason: collision with root package name */
    private final Object f375069s;

    /* renamed from: t, reason: collision with root package name */
    private final Object f375070t;

    /* renamed from: u, reason: collision with root package name */
    private Set<String> f375071u;

    /* renamed from: v, reason: collision with root package name */
    private Set<String> f375072v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f375073w;

    /* renamed from: x, reason: collision with root package name */
    private final Runnable f375074x;

    /* renamed from: y, reason: collision with root package name */
    private com.tencent.tbs.one.impl.b.b f375075y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tbs.one.impl.e.i$6, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static /* synthetic */ class AnonymousClass6 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f375089a;

        static {
            int[] iArr = new int[TBSOneManager.Policy.values().length];
            f375089a = iArr;
            try {
                iArr[TBSOneManager.Policy.BUILTIN_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f375089a[TBSOneManager.Policy.BUILTIN_ASSETS_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f375089a[TBSOneManager.Policy.LOCAL_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f375089a[TBSOneManager.Policy.ONLINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f375089a[TBSOneManager.Policy.AUTO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public i(Context context, String str) {
        super(context, str);
        this.f375069s = new Object();
        this.f375070t = new Object();
        this.f375073w = false;
        this.f375074x = new Runnable() { // from class: com.tencent.tbs.one.impl.e.i.1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z16;
                boolean z17;
                i iVar = i.this;
                String str2 = iVar.f375049b;
                g gVar = iVar.f375068r;
                if (gVar != null) {
                    if (gVar.f375036a != null) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl].mIdleRunnable %s in updating", str2, "Early out for idle task,");
                        i.this.j();
                        return;
                    }
                }
                for (com.tencent.tbs.one.impl.c.b bVar : iVar.f375053f.values()) {
                    if (bVar.f374734d && bVar.f374739i == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl].mIdleRunnable %s in loading component", str2, "Early out for idle task,");
                        i.this.j();
                        return;
                    }
                }
                f.a(i.this.f375048a);
                f.d(i.this.f375050c);
                if (!i.this.f375056i) {
                    com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl].mIdleRunnable %s disabled", str2, "Early out for auto update,");
                } else if (!i.this.b()) {
                    com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl].mIdleRunnable %s not use online service", str2, "Early out for auto update,");
                } else {
                    i.this.e();
                }
            }
        };
        SharedPreferences sharedPreferences = context.getSharedPreferences(String.format("com.tencent.tbs.one.%s.prefs", str), 4);
        this.f375067q = sharedPreferences;
        if (!sharedPreferences.contains(DeviceProfileManager.KEY_LAST_UPDATE_TIME)) {
            k();
        }
        this.f375071u = this.f375067q.getStringSet("disabled_component_names", new HashSet());
        this.f375072v = this.f375067q.getStringSet("disabled_local_components", new HashSet());
        com.tencent.tbs.one.impl.a.g.a("[%s] {%s} Disabled components from preferences", str, TextUtils.join(", ", this.f375071u));
        j();
    }

    private String m() {
        Object g16 = g(TBSOneConfigurationKeys.LOCAL_REPOSITORY_PATH);
        if (g16 instanceof String) {
            return (String) g16;
        }
        return "/android_asset/";
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final TBSOneManager.Policy a() {
        Object g16 = g("overridden_policy");
        if (g16 instanceof TBSOneManager.Policy) {
            return (TBSOneManager.Policy) g16;
        }
        if (g16 instanceof String) {
            return TBSOneManager.Policy.valueOf(g16.toString());
        }
        return super.a();
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final boolean b(String str) {
        File[] listFiles;
        File a16 = a(str);
        if (!a16.exists() || (listFiles = a16.listFiles()) == null) {
            return false;
        }
        File b16 = com.tencent.tbs.one.impl.common.f.b(this.f375050c);
        if (!b16.exists()) {
            return false;
        }
        try {
            d.a b17 = com.tencent.tbs.one.impl.common.d.a(b16).b(str);
            if (b17 == null) {
                return false;
            }
            String[] strArr = b17.f374831f;
            if (strArr != null) {
                for (String str2 : strArr) {
                    if (!b(str2)) {
                        return false;
                    }
                }
            }
            for (File file : listFiles) {
                if (file.isDirectory() && f.g(file)) {
                    return true;
                }
            }
            return false;
        } catch (TBSOneException e16) {
            com.tencent.tbs.one.impl.a.g.c("[%s] Failed to parse DEPS file %s", this.f375049b, b16.getAbsolutePath(), e16);
            return false;
        }
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final TBSOneOnlineService c() {
        g gVar;
        if (!b()) {
            return null;
        }
        synchronized (this.f375069s) {
            if (this.f375068r == null) {
                this.f375068r = new g(this);
            }
            gVar = this.f375068r;
        }
        return gVar;
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final TBSOneDebugger d() {
        com.tencent.tbs.one.impl.b.b bVar;
        synchronized (this.f375070t) {
            if (this.f375075y == null) {
                this.f375075y = new com.tencent.tbs.one.impl.b.b(this.f375049b);
            }
            bVar = this.f375075y;
        }
        return bVar;
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final void e() {
        com.tencent.tbs.one.impl.a.g.a("[PolicyManagerImpl].doUpdate", new Object[0]);
        if (this.f375073w) {
            return;
        }
        this.f375073w = true;
        TBSOneOnlineService c16 = c();
        if (c16 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        if (this.f375059l) {
            bundle.putBoolean(TBSOneConfigurationKeys.IGNORE_FLOW_CONTROL_SUGGESTION, true);
        }
        if (this.f375060m) {
            bundle.putBoolean(TBSOneConfigurationKeys.IGNORE_WIFI_STATE, true);
        }
        c16.update(bundle, new TBSOneCallback<Void>() { // from class: com.tencent.tbs.one.impl.e.i.2
            @Override // com.tencent.tbs.one.TBSOneCallback
            public final /* synthetic */ void onCompleted(Void r16) {
                i.this.k();
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onError(int i3, String str) {
            }
        });
    }

    public final String f() {
        Object g16 = g(TBSOneConfigurationKeys.ONLINE_SERVICE_URL);
        if (g16 instanceof String) {
            return (String) g16;
        }
        return "https://tbsone.imtt.qq.com";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File g() {
        return new File(this.f375050c, "incomplete-update");
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final boolean h(String str) {
        return str == null || this.f375067q.getInt(str, -1) == f.c(a(str));
    }

    public final k i() {
        return k.a(com.tencent.tbs.one.impl.common.f.e(com.tencent.tbs.one.impl.common.f.c(this.f375050c), ".lock"));
    }

    final void j() {
        Handler a16 = o.a();
        a16.removeCallbacks(this.f375074x);
        a16.postDelayed(this.f375074x, 10000L);
    }

    final void k() {
        SharedPreferences.Editor edit = this.f375067q.edit();
        edit.putLong(DeviceProfileManager.KEY_LAST_UPDATE_TIME, System.currentTimeMillis());
        edit.apply();
    }

    public final String[] l() {
        return (String[]) this.f375067q.getStringSet("in_use_component_names", new HashSet()).toArray(new String[0]);
    }

    public final boolean h() {
        boolean exists = com.tencent.tbs.one.impl.common.f.c(this.f375050c).exists();
        boolean z16 = !g().exists();
        com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl] Checking update availability, exists: %b, complete: %b", this.f375049b, Boolean.valueOf(exists), Boolean.valueOf(z16));
        return exists && z16;
    }

    private void i(String str) {
        File d16 = com.tencent.tbs.one.impl.common.f.d(com.tencent.tbs.one.impl.common.f.a(this.f375048a.getDir("tbs", 0), Process.myPid()), this.f375049b);
        com.tencent.tbs.one.impl.a.d.e(d16.getParentFile());
        if (!d16.exists()) {
            com.tencent.tbs.one.impl.a.d.b(d16);
        }
        HashSet hashSet = new HashSet(Arrays.asList(l()));
        hashSet.add(str);
        SharedPreferences.Editor edit = this.f375067q.edit();
        edit.putStringSet("in_use_component_names", hashSet);
        edit.apply();
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final void a(String str, Object obj) {
        super.a(str, obj);
        if (str == null) {
            return;
        }
        if (str.equals(TBSOneConfigurationKeys.PERMANENT_VERSION)) {
            a(false);
        }
        if (obj == null) {
            return;
        }
        if (str.equals("guid")) {
            com.tencent.tbs.one.impl.a.e.a(obj.toString());
        }
        if (str.equals(TBSOneConfigurationKeys.PPVN)) {
            com.tencent.tbs.one.impl.a.e.b(obj.toString());
        }
        if (str.equals(TBSOneConfigurationKeys.DISABLE_QUERY_RUNNING_PROCESSES)) {
            com.tencent.tbs.one.impl.a.e.a(com.tencent.tbs.one.impl.a.e.a(obj));
        }
        if (str.equals(TBSOneConfigurationKeys.ENABLE_CONSOLE_LOGGING)) {
            com.tencent.tbs.one.impl.a.g.a(com.tencent.tbs.one.impl.a.e.a(obj));
        }
        if (str.equals(TBSOneConfigurationKeys.NEED_UPDATE_AT_UPGRADE) && (obj instanceof Boolean)) {
            this.f375058k = ((Boolean) obj).booleanValue();
        }
        if (str.equals("update_interval") && (obj instanceof Long)) {
            this.f375057j = ((Long) obj).longValue();
        }
        if (str.equals(TBSOneConfigurationKeys.IGNORE_UPDATE_FLOW_CONTROL) && (obj instanceof Boolean)) {
            this.f375059l = ((Boolean) obj).booleanValue();
        }
        if (str.equals(TBSOneConfigurationKeys.IGNORE_UPDATE_WIFI_NETWORK) && (obj instanceof Boolean)) {
            this.f375060m = ((Boolean) obj).booleanValue();
        }
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final int[] c(String str) {
        File[] listFiles;
        File a16 = a(str);
        if (!a16.exists() || (listFiles = a16.listFiles()) == null) {
            return new int[0];
        }
        int[] iArr = new int[listFiles.length];
        int i3 = 0;
        for (File file : listFiles) {
            if (file.isDirectory() && f.g(file)) {
                try {
                    int i16 = i3 + 1;
                    try {
                        iArr[i3] = Integer.parseInt(file.getName());
                        i3 = i16;
                    } catch (Exception unused) {
                        i3 = i16;
                        com.tencent.tbs.one.impl.a.g.c("[%s] Failed to parse installed version from path %s", this.f375049b, file.getAbsolutePath());
                    }
                } catch (Exception unused2) {
                }
            }
        }
        return Arrays.copyOfRange(iArr, 0, i3);
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final void b(String str, Bundle bundle, TBSOneCallback<File> tBSOneCallback) {
        i(str);
        if (a(str, (TBSOneCallback) tBSOneCallback)) {
            super.b(str, bundle, tBSOneCallback);
        }
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final void a(boolean z16) {
        super.a(z16);
        if (z16) {
            j();
        }
    }

    private boolean a(String str, TBSOneCallback tBSOneCallback) {
        if (!this.f375071u.contains(str)) {
            return true;
        }
        if (tBSOneCallback == null) {
            return false;
        }
        tBSOneCallback.onError(501, "The component has disabled");
        return false;
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final void a(String str, Bundle bundle, TBSOneCallback<TBSOneComponent> tBSOneCallback) {
        i(str);
        super.a(str, bundle, tBSOneCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b8  */
    @Override // com.tencent.tbs.one.impl.e.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.tencent.tbs.one.impl.a.b<e<File>> a(Bundle bundle, d.a aVar, m<e<File>> mVar) {
        com.tencent.tbs.one.impl.a.b<e<File>> bVar;
        com.tencent.tbs.one.impl.a.h hVar;
        com.tencent.tbs.one.impl.a.b<e<File>> bVar2;
        TBSOneManager.Policy a16 = a();
        TBSOneManager.Policy policy = TBSOneManager.Policy.BUILTIN_ONLY;
        if (a16 == policy) {
            return super.a(bundle, aVar, mVar);
        }
        com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl].installComponent Installing component %s, version: %d, policy: %s", this.f375049b, aVar.f374826a, Integer.valueOf(aVar.f374828c), a16);
        File a17 = a(aVar.f374826a, aVar.f374828c);
        com.tencent.tbs.one.impl.a.d.e(a17.getParentFile());
        TBSOneManager.Policy policy2 = TBSOneManager.Policy.AUTO;
        if (a16 == policy2) {
            bVar = a(policy2, aVar, a17, bundle);
        } else {
            TBSOneManager.Policy policy3 = TBSOneManager.Policy.LOCAL_ONLY;
            if (a16 == policy3) {
                bVar = a(policy3, aVar, a17, bundle);
            } else {
                TBSOneManager.Policy policy4 = TBSOneManager.Policy.ONLINE;
                if (a16 == policy4) {
                    bVar = a(policy4, aVar, a17, bundle);
                } else {
                    if (a16 == TBSOneManager.Policy.BUILTIN_FIRST) {
                        hVar = new com.tencent.tbs.one.impl.a.h(new com.tencent.tbs.one.impl.a.b[]{a(policy, aVar, a17, bundle), a(policy2, aVar, a17, bundle)});
                    } else {
                        TBSOneManager.Policy policy5 = TBSOneManager.Policy.BUILTIN_ASSETS_ONLY;
                        if (a16 == policy5) {
                            bVar = a(policy5, aVar, a17, bundle);
                        } else if (a16 == TBSOneManager.Policy.BUILTIN_ASSETS_FIRST) {
                            hVar = new com.tencent.tbs.one.impl.a.h(new com.tencent.tbs.one.impl.a.b[]{a(policy5, aVar, a17, bundle), a(policy2, aVar, a17, bundle)});
                        } else if (a16 == TBSOneManager.Policy.LOCAL_FIRST) {
                            hVar = new com.tencent.tbs.one.impl.a.h(new com.tencent.tbs.one.impl.a.b[]{a(policy3, aVar, a17, bundle), a(policy2, aVar, a17, bundle)});
                        } else {
                            bVar = null;
                        }
                    }
                    bVar2 = hVar;
                    c cVar = new c(this.f375048a, aVar, bVar2, a17, bundle == null ? bundle.getInt("time_out", 10000) : 10000);
                    cVar.a((m) mVar);
                    return cVar;
                }
            }
        }
        bVar2 = bVar;
        c cVar2 = new c(this.f375048a, aVar, bVar2, a17, bundle == null ? bundle.getInt("time_out", 10000) : 10000);
        cVar2.a((m) mVar);
        return cVar2;
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final void a(Bundle bundle, String str, TBSOneCallback<File> tBSOneCallback) {
        com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl].installDependency Dependency: %s", a(), str);
        if (a(str, (TBSOneCallback) tBSOneCallback)) {
            super.a(bundle, str, tBSOneCallback);
        }
    }

    @Override // com.tencent.tbs.one.impl.e.h
    public final com.tencent.tbs.one.impl.a.b<e<com.tencent.tbs.one.impl.common.d>> a(Bundle bundle, m<e<com.tencent.tbs.one.impl.common.d>> mVar) {
        com.tencent.tbs.one.impl.a.b<e<com.tencent.tbs.one.impl.common.d>> bVar;
        com.tencent.tbs.one.impl.a.h hVar;
        boolean a16;
        boolean z16;
        TBSOneManager.Policy a17 = a();
        if (a17 == TBSOneManager.Policy.BUILTIN_ONLY) {
            return super.a(bundle, mVar);
        }
        String str = this.f375049b;
        File b16 = com.tencent.tbs.one.impl.common.f.b(this.f375050c);
        com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl] Installing DEPS, Policy=%s, Path=%s", str, a17, b16);
        if (h()) {
            com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl] Applying the last update", str);
            Context context = this.f375048a;
            f.a(context);
            k i3 = i();
            if (i3 != null) {
                k a18 = k.a(com.tencent.tbs.one.impl.common.f.e(b16, ".lock"));
                if (a18 != null) {
                    if (h()) {
                        File[] listFiles = com.tencent.tbs.one.impl.common.f.b(context).listFiles();
                        if (listFiles != null) {
                            for (File file : listFiles) {
                                if (!file.getName().equals(String.valueOf(Process.myPid())) && com.tencent.tbs.one.impl.common.f.d(file, str).exists()) {
                                    com.tencent.tbs.one.impl.a.g.a("[%s] The category is being used by process %s", str, file.getName());
                                    z16 = true;
                                    break;
                                }
                            }
                        }
                        z16 = false;
                        if (!z16) {
                            try {
                                com.tencent.tbs.one.impl.a.d.b(com.tencent.tbs.one.impl.common.f.c(this.f375050c), b16);
                            } catch (IOException e16) {
                                com.tencent.tbs.one.impl.a.g.c("[%s] [PolicyManagerImpl] Failed to apply the last update", str, e16);
                            }
                        } else {
                            com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl] %s the category is being used by other processes", str, "Early out for applying the last update,");
                        }
                    } else {
                        com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl] %s the last update has applied by another process", str, "Early out for applying the last update,");
                    }
                    a18.a();
                } else {
                    com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl] %s the DEPS installation lock is busy", str, "Early out for applying the last update,");
                }
                i3.a();
            } else {
                com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl] %s the update lock is busy", str, "Early out for applying the last update,");
            }
        }
        com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl].installDEPS exclusiveJob targetFile is %s", str, b16);
        String str2 = this.f375049b;
        com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl].createInstallationJob", str2);
        TBSOneManager.Policy a19 = a();
        Object obj = this.f375052e.get(TBSOneConfigurationKeys.PERMANENT_VERSION);
        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : -1;
        TBSOneManager.Policy policy = TBSOneManager.Policy.AUTO;
        if (a19 == policy) {
            bVar = a(policy, intValue, b16, bundle);
        } else {
            TBSOneManager.Policy policy2 = TBSOneManager.Policy.LOCAL_ONLY;
            if (a19 == policy2) {
                bVar = a(policy2, intValue, b16, bundle);
            } else {
                TBSOneManager.Policy policy3 = TBSOneManager.Policy.ONLINE;
                if (a19 == policy3) {
                    bVar = a(policy3, intValue, b16, bundle);
                } else {
                    TBSOneManager.Policy policy4 = TBSOneManager.Policy.BUILTIN_ASSETS_ONLY;
                    if (a19 == policy4) {
                        a16 = a(b16, a19);
                        com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl].createInstallationJob BUILTIN_ASSETS_ONLY ignoreExisting=" + a16, str2);
                        bVar = a(policy4, intValue, b16, bundle);
                    } else if (a19 == TBSOneManager.Policy.BUILTIN_FIRST) {
                        a16 = a(b16, a19);
                        com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl].createInstallationJob BUILTIN_FIRST ignoreExisting=" + a16, str2);
                        bVar = new com.tencent.tbs.one.impl.a.h(new com.tencent.tbs.one.impl.a.b[]{a(TBSOneManager.Policy.BUILTIN_ONLY, intValue, b16, bundle), a(policy, intValue, b16, bundle)});
                    } else {
                        if (a19 == TBSOneManager.Policy.BUILTIN_ASSETS_FIRST) {
                            hVar = new com.tencent.tbs.one.impl.a.h(new com.tencent.tbs.one.impl.a.b[]{a(policy4, intValue, b16, bundle), a(policy, intValue, b16, bundle)});
                        } else if (a19 == TBSOneManager.Policy.LOCAL_FIRST) {
                            hVar = new com.tencent.tbs.one.impl.a.h(new com.tencent.tbs.one.impl.a.b[]{a(policy2, intValue, b16, bundle), a(policy, intValue, b16, bundle)});
                        } else {
                            bVar = null;
                        }
                        bVar = hVar;
                    }
                    d dVar = new d(a16, bVar, b16);
                    com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl] Finish Creation of DEPS Installation Job", str);
                    dVar.a((m) new m<e<com.tencent.tbs.one.impl.common.d>>() { // from class: com.tencent.tbs.one.impl.e.i.3
                        @Override // com.tencent.tbs.one.impl.a.m
                        public final /* bridge */ /* synthetic */ void a(e<com.tencent.tbs.one.impl.common.d> eVar) {
                            i.this.a(eVar, false);
                        }
                    });
                    dVar.a((m) mVar);
                    return dVar;
                }
            }
        }
        a16 = false;
        d dVar2 = new d(a16, bVar, b16);
        com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl] Finish Creation of DEPS Installation Job", str);
        dVar2.a((m) new m<e<com.tencent.tbs.one.impl.common.d>>() { // from class: com.tencent.tbs.one.impl.e.i.3
            @Override // com.tencent.tbs.one.impl.a.m
            public final /* bridge */ /* synthetic */ void a(e<com.tencent.tbs.one.impl.common.d> eVar) {
                i.this.a(eVar, false);
            }
        });
        dVar2.a((m) mVar);
        return dVar2;
    }

    private void a(e<com.tencent.tbs.one.impl.common.d> eVar, Set<String> set) {
        com.tencent.tbs.one.impl.a.g.a("[PolicyManagerImpl].handleInstallationResult", new Object[0]);
        Object obj = eVar.f375022c;
        if (obj instanceof JSONObject) {
            String str = this.f375049b;
            JSONObject jSONObject = (JSONObject) obj;
            JSONObject optJSONObject = jSONObject.optJSONObject("SWITCH");
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    if (optJSONObject.optInt(str2, 0) == 1) {
                        set.add(str2);
                        int c16 = f.c(a(str2));
                        SharedPreferences.Editor edit = this.f375067q.edit();
                        edit.putInt(str2, c16);
                        edit.apply();
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("RESET");
            if (optJSONObject2 != null) {
                Iterator keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String str3 = (String) keys2.next();
                    if (optJSONObject2.optInt(str3, 0) == 1) {
                        File a16 = a(str3, f.c(a(str3)));
                        if (a16.exists()) {
                            f.e(a16);
                            com.tencent.tbs.one.impl.a.g.a("[%s] Reset component %s", str, a16.getAbsolutePath());
                        } else {
                            com.tencent.tbs.one.impl.a.g.c("[%s] Failed to reset component, %s does not exist", str, a16.getAbsolutePath());
                        }
                    }
                }
            }
            if (jSONObject.optInt("ULOG") == 1) {
                com.tencent.tbs.one.impl.common.h.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tbs.one.impl.e.h
    public final void a(e<com.tencent.tbs.one.impl.common.d> eVar) {
        super.a(eVar);
        SharedPreferences.Editor edit = this.f375067q.edit();
        edit.putInt("in_use_deps_version", eVar.f375021b.f374824b);
        edit.apply();
    }

    public final com.tencent.tbs.one.impl.a.b<e<com.tencent.tbs.one.impl.common.d>> a(TBSOneManager.Policy policy, int i3, final File file, Bundle bundle) {
        com.tencent.tbs.one.impl.a.b<e<com.tencent.tbs.one.impl.common.d>> bVar;
        final Context context = this.f375048a;
        String str = this.f375049b;
        int i16 = AnonymousClass6.f375089a[policy.ordinal()];
        if (i16 == 1) {
            return new com.tencent.tbs.one.impl.e.c.b(context, str, file);
        }
        if (i16 == 2) {
            return new com.tencent.tbs.one.impl.e.b.a.b(context, str, file);
        }
        if (i16 == 3) {
            final String m3 = m();
            bVar = new com.tencent.tbs.one.impl.a.b<e<com.tencent.tbs.one.impl.common.d>>() { // from class: com.tencent.tbs.one.impl.e.i.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.tbs.one.impl.a.b
                public final void a() {
                    InputStream inputStream = null;
                    try {
                        try {
                            inputStream = com.tencent.tbs.one.impl.a.d.a(context, m3, "DEPS");
                            String a16 = com.tencent.tbs.one.impl.a.d.a(inputStream, "utf-8", file);
                            com.tencent.tbs.one.impl.common.d a17 = com.tencent.tbs.one.impl.common.d.a(a16);
                            com.tencent.tbs.one.impl.a.d.a(a16, "utf-8", file);
                            com.tencent.tbs.one.impl.a.d.a(inputStream);
                            a((AnonymousClass4) e.a(e.a.LOCAL, a17));
                        } catch (TBSOneException e16) {
                            a(e16.getErrorCode(), e16.getMessage(), e16.getCause());
                            com.tencent.tbs.one.impl.a.d.a(inputStream);
                        } catch (IOException e17) {
                            a(303, "Failed to copy local DEPS from " + m3 + " to " + file.getAbsolutePath(), e17);
                            com.tencent.tbs.one.impl.a.d.a(inputStream);
                        }
                    } catch (Throwable th5) {
                        com.tencent.tbs.one.impl.a.d.a(inputStream);
                        throw th5;
                    }
                }
            };
        } else {
            if (i16 != 4) {
                if (i16 != 5) {
                    return null;
                }
                return com.tencent.tbs.one.impl.a.a(this, i3, file, bundle);
            }
            bVar = new com.tencent.tbs.one.impl.e.d.b(context, str, f(), file);
        }
        return bVar;
    }

    private com.tencent.tbs.one.impl.a.b<e<File>> a(TBSOneManager.Policy policy, d.a aVar, final File file, Bundle bundle) {
        final Context context = this.f375048a;
        String str = this.f375049b;
        int i3 = AnonymousClass6.f375089a[policy.ordinal()];
        if (i3 == 1) {
            return new com.tencent.tbs.one.impl.e.c.a(context, str, aVar, file, bundle, m());
        }
        if (i3 == 2) {
            return new com.tencent.tbs.one.impl.e.b.a.a(context, str, aVar, file, bundle, m());
        }
        if (i3 == 3) {
            final String m3 = m();
            final String str2 = aVar.f374829d;
            final int i16 = aVar.f374828c;
            return new com.tencent.tbs.one.impl.a.b<e<File>>() { // from class: com.tencent.tbs.one.impl.e.i.5
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.tbs.one.impl.a.b
                public final void a() {
                    Throwable th5;
                    InputStream inputStream;
                    IOException e16;
                    try {
                        try {
                            inputStream = com.tencent.tbs.one.impl.a.d.a(context, m3, str2);
                        } catch (IOException e17) {
                            inputStream = null;
                            e16 = e17;
                        } catch (Throwable th6) {
                            th5 = th6;
                            com.tencent.tbs.one.impl.a.d.a((Closeable) null);
                            throw th5;
                        }
                        try {
                            com.tencent.tbs.one.impl.a.d.a(inputStream, file, (File) null);
                            com.tencent.tbs.one.impl.a.d.a(inputStream);
                            try {
                                File file2 = file;
                                f.a(file2, file2);
                                f.a(file, i16);
                                a((AnonymousClass5) e.a(e.a.LOCAL, file));
                            } catch (TBSOneException e18) {
                                a(e18.getErrorCode(), e18.getMessage(), e18.getCause());
                            }
                        } catch (IOException e19) {
                            e16 = e19;
                            a(313, "Failed to unzip local component from " + str2 + " to " + file.getAbsolutePath() + ", localRepository: " + m3, e16);
                            com.tencent.tbs.one.impl.a.d.a(inputStream);
                        }
                    } catch (Throwable th7) {
                        th5 = th7;
                        com.tencent.tbs.one.impl.a.d.a((Closeable) null);
                        throw th5;
                    }
                }
            };
        }
        if (i3 == 4) {
            return new com.tencent.tbs.one.impl.e.d.a(context, str, aVar, file, bundle);
        }
        if (i3 != 5) {
            return null;
        }
        return new com.tencent.tbs.one.impl.e.a.a(context, str, f(), aVar, file, bundle);
    }

    private boolean a(File file, TBSOneManager.Policy policy) {
        com.tencent.tbs.one.impl.common.d a16;
        String str = this.f375049b;
        if (file.exists()) {
            com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl].shouldIgnoreExisting Have Existing DEPS File", str);
            try {
                com.tencent.tbs.one.impl.common.d a17 = com.tencent.tbs.one.impl.common.d.a(file);
                if (policy == TBSOneManager.Policy.BUILTIN_FIRST) {
                    a16 = com.tencent.tbs.one.impl.common.d.a(com.tencent.tbs.one.impl.common.f.c(com.tencent.tbs.one.impl.common.f.a(this.f375048a), str));
                } else if (policy == TBSOneManager.Policy.BUILTIN_ASSETS_ONLY) {
                    try {
                        InputStream open = this.f375048a.getAssets().open("webkit/repo/" + str + "/DEPS");
                        if (open == null) {
                            return false;
                        }
                        a16 = com.tencent.tbs.one.impl.common.d.a(open);
                        if (!a17.f374823a.equals(a16.f374823a)) {
                            com.tencent.tbs.one.impl.a.g.a("[%s] In BUILTIN_ASSETS_ONLY Existing Version Name not equals. Ignoring existing DEPS, use builtin DEPS instead. %s => %s", str, a17.f374823a, a16.f374823a);
                            return true;
                        }
                    } catch (Throwable unused) {
                        return false;
                    }
                } else {
                    a16 = null;
                }
                int i3 = a17.f374824b;
                if (i3 < a16.f374824b) {
                    com.tencent.tbs.one.impl.a.g.a("[%s] In BUILTIN_FIRST Existing Version Code is lower. Ignoring existing DEPS, use builtin DEPS instead. %d => %d", str, Integer.valueOf(i3), Integer.valueOf(a16.f374824b));
                    return true;
                }
            } catch (TBSOneException unused2) {
                com.tencent.tbs.one.impl.a.g.b("[%s] [PolicyManagerImpl].shouldIgnoreExisting TBSOneException: Not BUILTIN_FIRST or BUILTIN_ASSETS_ONLY [ignored]", str);
            }
        } else {
            com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl].shouldIgnoreExisting No Existing DEPS File. Don't have to ignore.", str);
        }
        return false;
    }

    public final void a(e<com.tencent.tbs.one.impl.common.d> eVar, boolean z16) {
        com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl].populateDEPSExtra", this.f375049b);
        if (eVar.f375020a != e.a.ONLINE) {
            return;
        }
        HashSet hashSet = new HashSet();
        a(eVar, hashSet);
        com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManagerImpl].updateComponentDisability Disabled components {%s} from server", this.f375049b, TextUtils.join(", ", hashSet));
        SharedPreferences.Editor edit = this.f375067q.edit();
        if (z16) {
            this.f375071u = hashSet;
            edit.putStringSet("disabled_component_names", hashSet);
        } else {
            this.f375072v = hashSet;
            edit.putStringSet("disabled_local_components", hashSet);
        }
        edit.apply();
    }
}

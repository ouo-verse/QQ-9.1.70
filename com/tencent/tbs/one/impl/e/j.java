package com.tencent.tbs.one.impl.e;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.impl.common.d;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class j extends com.tencent.tbs.one.impl.a.b<Void> {

    /* renamed from: b, reason: collision with root package name */
    i f375090b;

    /* renamed from: c, reason: collision with root package name */
    Bundle f375091c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f375092d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, com.tencent.tbs.one.impl.a.b> f375093e = new ConcurrentHashMap();

    public j(i iVar, Bundle bundle) {
        this.f375090b = iVar;
        this.f375091c = bundle;
    }

    private void c() {
        Iterator<com.tencent.tbs.one.impl.a.b> it = this.f375093e.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.f375093e.clear();
    }

    @Override // com.tencent.tbs.one.impl.a.b
    public final void b() {
        super.b();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0095  */
    @Override // com.tencent.tbs.one.impl.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        boolean z16;
        com.tencent.tbs.one.impl.common.d dVar;
        com.tencent.tbs.one.impl.a.g.a("[%s] Requesting the latest DEPS", this.f375090b.f375049b);
        final i iVar = this.f375090b;
        final String str = iVar.f375049b;
        File c16 = com.tencent.tbs.one.impl.common.f.c(iVar.f375050c);
        if (!c16.exists()) {
            com.tencent.tbs.one.impl.a.g.a("[%s] latest file is not exist,request DEPS from server", this.f375090b.f375049b);
        } else {
            long j3 = this.f375090b.f375067q.getLong(DeviceProfileManager.KEY_LAST_UPDATE_TIME, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            i iVar2 = this.f375090b;
            String string = iVar2.f375067q.getString("last_version_name", "");
            String c17 = com.tencent.tbs.one.impl.a.e.c(iVar2.f375048a);
            iVar2.f375067q.edit().putString("last_version_name", c17).apply();
            boolean z17 = (TextUtils.isEmpty(string) || string.equals(c17)) ? false : true;
            if (currentTimeMillis - j3 < this.f375090b.f375057j && !z17) {
                com.tencent.tbs.one.impl.a.g.a("[%s] the interval is not reached, last update time: %s,is new version: false", this.f375090b.f375049b, com.tencent.tbs.one.impl.a.e.a(j3));
                z16 = false;
                if (!z16) {
                    if (c16.exists()) {
                        com.tencent.tbs.one.impl.a.d.c(c16);
                    }
                    com.tencent.tbs.one.impl.a.b<e<com.tencent.tbs.one.impl.common.d>> a16 = iVar.a(TBSOneManager.Policy.AUTO, -1, c16, this.f375091c);
                    a16.a(new com.tencent.tbs.one.impl.common.c<e<com.tencent.tbs.one.impl.common.d>>() { // from class: com.tencent.tbs.one.impl.e.j.1
                        @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
                        public final /* synthetic */ void a(Object obj) {
                            e<com.tencent.tbs.one.impl.common.d> eVar = (e) obj;
                            com.tencent.tbs.one.impl.a.g.a("[%s] Finished Requesting the latest DEPS#%d from %s", str, Integer.valueOf(eVar.f375021b.f374824b), eVar.f375020a);
                            iVar.a(eVar, true);
                            j jVar = j.this;
                            jVar.a(jVar.f375091c, eVar.f375021b);
                        }

                        @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
                        public final void a(int i3, String str2, Throwable th5) {
                            com.tencent.tbs.one.impl.a.g.c("[%s] Failed to request the latest DEPS, error: [%d] %s", str, Integer.valueOf(i3), str2, th5);
                            j.this.a(i3, str2, th5);
                        }
                    });
                    this.f375093e.put("DEPS", a16);
                    return;
                }
                if (!c16.exists()) {
                    com.tencent.tbs.one.impl.a.g.a("[%s] last File %s is not exist,no need download component", str, c16.getAbsolutePath());
                    return;
                }
                try {
                    dVar = com.tencent.tbs.one.impl.common.d.a(c16);
                } catch (TBSOneException e16) {
                    a(321, "parse file " + c16.getAbsolutePath() + " failed", e16);
                    dVar = null;
                }
                if (dVar != null) {
                    a(this.f375091c, dVar);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public final class a extends com.tencent.tbs.one.impl.common.c<e<File>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f375102f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f375103g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f375104h;

        a(String str, String str2, int i3) {
            this.f375102f = str;
            this.f375103g = str2;
            this.f375104h = i3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
        public final /* synthetic */ void a(Object obj) {
            e eVar = (e) obj;
            com.tencent.tbs.one.impl.a.g.a("[%s] Finished updating component at %s from %s", this.f375102f, ((File) eVar.f375021b).getAbsolutePath(), eVar.f375020a);
            j.a(j.this, this.f375103g);
        }

        @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
        public final void a(int i3, String str, Throwable th5) {
            com.tencent.tbs.one.impl.a.g.c("[%s] Failed to update component %s#%d, error: [%d] %s", this.f375102f, this.f375103g, Integer.valueOf(this.f375104h), Integer.valueOf(i3), str, th5);
            j.this.a(i3, "Failed to update component " + this.f375103g + ", error: " + str, th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle, com.tencent.tbs.one.impl.common.d dVar) {
        String[] strArr;
        int i3;
        final String str = this.f375090b.f375049b;
        this.f375093e.remove("DEPS");
        if (dVar.f374824b <= this.f375090b.f375067q.getInt("in_use_deps_version", -1)) {
            a(506, "Failed to request more recent DEPS", (Throwable) null);
            return;
        }
        String[] l3 = this.f375090b.l();
        if (l3 != null && l3.length > 0) {
            int length = l3.length;
            char c16 = 0;
            Bundle bundle2 = bundle;
            int i16 = 0;
            int i17 = 0;
            while (i17 < length) {
                final String str2 = l3[i17];
                d.a b16 = dVar.b(str2);
                if (b16 == null) {
                    Object[] objArr = new Object[1];
                    objArr[c16] = str2;
                    com.tencent.tbs.one.impl.a.g.b("The component %s is no longer valid", objArr);
                    strArr = l3;
                    i3 = length;
                } else {
                    int i18 = i16 + 1;
                    final String str3 = b16.f374826a;
                    final int i19 = b16.f374828c;
                    Object[] objArr2 = new Object[3];
                    objArr2[c16] = str;
                    objArr2[1] = str3;
                    objArr2[2] = Integer.valueOf(i19);
                    com.tencent.tbs.one.impl.a.g.a("[%s] Updating component %s#%d", objArr2);
                    if (bundle2 == null) {
                        bundle2 = new Bundle();
                    }
                    Bundle bundle3 = bundle2;
                    bundle3.putInt("info_from", 1);
                    strArr = l3;
                    i3 = length;
                    this.f375093e.put(str3, this.f375090b.a(bundle3, b16, new com.tencent.tbs.one.impl.common.c<e<File>>() { // from class: com.tencent.tbs.one.impl.e.j.2
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
                        public final /* synthetic */ void a(Object obj) {
                            e eVar = (e) obj;
                            com.tencent.tbs.one.impl.a.g.a("[%s] Finished updating component at %s from %s", str, ((File) eVar.f375021b).getAbsolutePath(), eVar.f375020a);
                            j.a(j.this, str3);
                        }

                        @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
                        public final void a(int i26, String str4, Throwable th5) {
                            if (i26 == 322) {
                                i iVar = j.this.f375090b;
                                String str5 = str2;
                                com.tencent.tbs.one.impl.a.g.c("deleteInUseComponentNames", str5);
                                HashSet hashSet = new HashSet(Arrays.asList(iVar.l()));
                                hashSet.remove(str5);
                                SharedPreferences.Editor edit = iVar.f375067q.edit();
                                edit.putStringSet("in_use_component_names", hashSet);
                                edit.apply();
                            }
                            com.tencent.tbs.one.impl.a.g.c("[%s] Failed to update component %s#%d, error: [%d] %s", str, str3, Integer.valueOf(i19), Integer.valueOf(i26), str4, th5);
                            j.this.a(i26, "Failed to update component " + str3 + ", error: " + str4, th5);
                        }
                    }));
                    String[] strArr2 = b16.f374831f;
                    if (strArr2 != null) {
                        for (String str4 : strArr2) {
                            this.f375093e.put(str4, this.f375090b.a(bundle3, dVar.b(str4), new a(str, str4, i19)));
                        }
                    }
                    bundle2 = bundle3;
                    i16 = i18;
                }
                i17++;
                l3 = strArr;
                length = i3;
                c16 = 0;
            }
            if (i16 <= 0) {
                a(508, "No valid components", (Throwable) null);
                return;
            }
            return;
        }
        a(507, "No in-use components", (Throwable) null);
    }

    @Override // com.tencent.tbs.one.impl.a.b
    public final void a(int i3, String str, Throwable th5) {
        com.tencent.tbs.one.impl.a.g.b("Failed to update, error: [%d] %s", Integer.valueOf(i3), str);
        this.f375092d = true;
        c();
        File c16 = com.tencent.tbs.one.impl.common.f.c(this.f375090b.f375050c);
        if (c16.exists()) {
            com.tencent.tbs.one.impl.a.d.c(c16);
        }
        super.a(i3, str, th5);
    }

    static /* synthetic */ void a(j jVar, String str) {
        jVar.f375093e.remove(str);
        if (jVar.f375092d || jVar.f375093e.size() > 0) {
            return;
        }
        com.tencent.tbs.one.impl.a.g.a("[%s] Finished updating", jVar.f375090b.f375049b);
        jVar.a((j) null);
    }
}

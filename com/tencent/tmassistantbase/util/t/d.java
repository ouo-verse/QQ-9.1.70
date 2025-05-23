package com.tencent.tmassistantbase.util.t;

import android.content.Context;
import com.tencent.tmassistant.common.jce.BypassInterceptConfig;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    private static d f380532d;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<e> f380533a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private boolean f380534b = false;

    /* renamed from: c, reason: collision with root package name */
    private c f380535c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements Runnable {
        a(d dVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            SDKReportManager2.getInstance().postReport(2001, "hook_am");
        }
    }

    d() {
    }

    private void a(e eVar) {
        if (this.f380533a.contains(eVar)) {
            return;
        }
        this.f380533a.add(eVar);
    }

    public static synchronized d b() {
        d dVar;
        synchronized (d.class) {
            if (f380532d == null) {
                f380532d = new d();
            }
            dVar = f380532d;
        }
        return dVar;
    }

    private void c() {
        Iterator<e> it = this.f380533a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        if (GlobalUtil.getInstance().getContext() == null) {
            GlobalUtil.getInstance().setContext(context.getApplicationContext());
            com.tencent.tmdownloader.c.a();
        }
        if (a()) {
            System.currentTimeMillis();
            if (!this.f380534b) {
                if (this.f380533a.contains(this.f380535c)) {
                    this.f380533a.remove(this.f380535c);
                }
                c cVar = new c(context);
                this.f380535c = cVar;
                a(cVar);
                c();
                this.f380534b = true;
            }
            c cVar2 = this.f380535c;
            if (cVar2 != null && !cVar2.c()) {
                this.f380535c.a(true);
            }
            com.tencent.tmassistantbase.util.e.a().post(new a(this));
        }
    }

    public static boolean a() {
        System.currentTimeMillis();
        BypassInterceptConfig bypassInterceptConfig = (BypassInterceptConfig) com.tencent.tmdownloader.f.b.b.a().a("key_bypass_config", BypassInterceptConfig.class);
        return (bypassInterceptConfig == null || bypassInterceptConfig.status == 0) ? false : true;
    }

    public static boolean a(String str) {
        BypassInterceptConfig bypassInterceptConfig = (BypassInterceptConfig) com.tencent.tmdownloader.f.b.b.a().a("key_bypass_config", BypassInterceptConfig.class);
        if (bypassInterceptConfig == null) {
            return false;
        }
        if (bypassInterceptConfig.status == 1) {
            return true;
        }
        ArrayList<String> arrayList = bypassInterceptConfig.pkgList;
        return arrayList != null && arrayList.contains(str);
    }
}

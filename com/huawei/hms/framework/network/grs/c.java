package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.h;
import com.huawei.hms.framework.network.grs.g.i;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: i, reason: collision with root package name */
    private static final String f36924i = "c";

    /* renamed from: j, reason: collision with root package name */
    private static final ExecutorService f36925j = ExecutorsUtils.newSingleThreadExecutor("GRS_GrsClient-Init");

    /* renamed from: k, reason: collision with root package name */
    private static AtomicInteger f36926k = new AtomicInteger(0);

    /* renamed from: a, reason: collision with root package name */
    private GrsBaseInfo f36927a;

    /* renamed from: b, reason: collision with root package name */
    private Context f36928b;

    /* renamed from: c, reason: collision with root package name */
    private h f36929c;

    /* renamed from: d, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.a f36930d;

    /* renamed from: e, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f36931e;

    /* renamed from: f, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f36932f;

    /* renamed from: g, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.a f36933g;

    /* renamed from: h, reason: collision with root package name */
    private FutureTask<Boolean> f36934h;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Callable<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f36935a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GrsBaseInfo f36936b;

        a(Context context, GrsBaseInfo grsBaseInfo) {
            this.f36935a = context;
            this.f36936b = grsBaseInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            c.this.f36929c = new h();
            c.this.f36931e = new com.huawei.hms.framework.network.grs.e.c(this.f36935a, GrsApp.getInstance().getBrand("_") + "share_pre_grs_conf_");
            c.this.f36932f = new com.huawei.hms.framework.network.grs.e.c(this.f36935a, GrsApp.getInstance().getBrand("_") + "share_pre_grs_services_");
            c cVar = c.this;
            cVar.f36930d = new com.huawei.hms.framework.network.grs.e.a(cVar.f36931e, c.this.f36932f, c.this.f36929c);
            c cVar2 = c.this;
            cVar2.f36933g = new com.huawei.hms.framework.network.grs.a(cVar2.f36927a, c.this.f36930d, c.this.f36929c, c.this.f36932f);
            if (c.f36926k.incrementAndGet() <= 2 || com.huawei.hms.framework.network.grs.f.b.a(this.f36935a.getPackageName(), c.this.f36927a) == null) {
                new com.huawei.hms.framework.network.grs.f.b(this.f36935a, this.f36936b, true).a(this.f36936b);
            }
            String c16 = new com.huawei.hms.framework.network.grs.g.k.c(this.f36936b, this.f36935a).c();
            Logger.v(c.f36924i, "scan serviceSet is: " + c16);
            String a16 = c.this.f36932f.a("services", "");
            String a17 = i.a(a16, c16);
            if (!TextUtils.isEmpty(a17)) {
                c.this.f36932f.b("services", a17);
                Logger.i(c.f36924i, "postList is:" + StringUtils.anonymizeMessage(a17));
                Logger.i(c.f36924i, "currentServices:" + StringUtils.anonymizeMessage(a16));
                if (!a17.equals(a16)) {
                    c.this.f36929c.a(c.this.f36927a.getGrsParasKey(true, true, this.f36935a));
                    c.this.f36929c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.f36936b, this.f36935a), (String) null, c.this.f36932f);
                }
            }
            c cVar3 = c.this;
            cVar3.a(cVar3.f36931e.a());
            c.this.f36930d.b(this.f36936b, this.f36935a);
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, GrsBaseInfo grsBaseInfo) {
        this.f36934h = null;
        this.f36928b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        a(grsBaseInfo);
        GrsBaseInfo grsBaseInfo2 = this.f36927a;
        FutureTask<Boolean> futureTask = new FutureTask<>(new a(this.f36928b, grsBaseInfo2));
        this.f36934h = futureTask;
        f36925j.execute(futureTask);
        Logger.i(f36924i, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s", com.huawei.hms.framework.network.grs.h.a.a(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GrsBaseInfo grsBaseInfo) {
        this.f36934h = null;
        a(grsBaseInfo);
    }

    private boolean e() {
        String str;
        String str2;
        FutureTask<Boolean> futureTask = this.f36934h;
        if (futureTask == null) {
            return false;
        }
        try {
            return futureTask.get(8L, TimeUnit.SECONDS).booleanValue();
        } catch (InterruptedException e16) {
            e = e16;
            str = f36924i;
            str2 = "init compute task interrupted.";
            Logger.w(str, str2, e);
            return false;
        } catch (CancellationException unused) {
            Logger.i(f36924i, "init compute task canceled.");
            return false;
        } catch (ExecutionException e17) {
            e = e17;
            str = f36924i;
            str2 = "init compute task failed.";
            Logger.w(str, str2, e);
            return false;
        } catch (TimeoutException unused2) {
            Logger.w(f36924i, "init compute task timed out");
            return false;
        } catch (Exception e18) {
            e = e18;
            str = f36924i;
            str2 = "init compute task occur unknown Exception";
            Logger.w(str, str2, e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!e() || (grsBaseInfo = this.f36927a) == null || (context = this.f36928b) == null) {
            return false;
        }
        this.f36930d.a(grsBaseInfo, context);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str, String str2) {
        if (this.f36927a == null || str == null || str2 == null) {
            Logger.w(f36924i, "invalid para!");
            return null;
        }
        if (e()) {
            return this.f36933g.a(str, str2, this.f36928b);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> a(String str) {
        if (this.f36927a != null && str != null) {
            return e() ? this.f36933g.a(str, this.f36928b) : new HashMap();
        }
        Logger.w(f36924i, "invalid para!");
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (e()) {
            String grsParasKey = this.f36927a.getGrsParasKey(true, true, this.f36928b);
            this.f36931e.a(grsParasKey);
            this.f36931e.a(grsParasKey + "time");
            this.f36931e.a(grsParasKey + "ETag");
            this.f36929c.a(grsParasKey);
        }
    }

    private void a(GrsBaseInfo grsBaseInfo) {
        try {
            this.f36927a = grsBaseInfo.m69clone();
        } catch (CloneNotSupportedException e16) {
            Logger.w(f36924i, "GrsClient catch CloneNotSupportedException", e16);
            this.f36927a = grsBaseInfo.copy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        if (iQueryUrlsCallBack == null) {
            Logger.w(f36924i, "IQueryUrlsCallBack is must not null for process continue.");
            return;
        }
        if (this.f36927a == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.f36933g.a(str, iQueryUrlsCallBack, this.f36928b);
        } else {
            Logger.i(f36924i, "grs init task has not completed.");
            iQueryUrlsCallBack.onCallBackFail(-7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        if (iQueryUrlCallBack == null) {
            Logger.w(f36924i, "IQueryUrlCallBack is must not null for process continue.");
            return;
        }
        if (this.f36927a == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.f36933g.a(str, str2, iQueryUrlCallBack, this.f36928b);
        } else {
            Logger.i(f36924i, "grs init task has not completed.");
            iQueryUrlCallBack.onCallBackFail(-7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            Logger.v(f36924i, "sp's content is empty.");
            return;
        }
        for (String str : map.keySet()) {
            if (str.endsWith("time")) {
                String a16 = this.f36931e.a(str, "");
                long j3 = 0;
                if (!TextUtils.isEmpty(a16) && a16.matches("\\d+")) {
                    try {
                        j3 = Long.parseLong(a16);
                    } catch (NumberFormatException e16) {
                        Logger.w(f36924i, "convert expire time from String to Long catch NumberFormatException.", e16);
                    }
                }
                if (!a(j3)) {
                    Logger.i(f36924i, "init interface auto clear some invalid sp's data.");
                    String substring = str.substring(0, str.length() - 4);
                    this.f36931e.a(substring);
                    this.f36931e.a(str);
                    this.f36931e.a(substring + "ETag");
                }
            }
        }
    }

    private boolean a(long j3) {
        return System.currentTimeMillis() - j3 <= 604800000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass() && (obj instanceof c)) {
            return this.f36927a.compare(((c) obj).f36927a);
        }
        return false;
    }
}

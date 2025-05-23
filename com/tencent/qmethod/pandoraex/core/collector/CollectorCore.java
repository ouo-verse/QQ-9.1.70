package com.tencent.qmethod.pandoraex.core.collector;

import android.content.Context;
import com.tencent.qmethod.pandoraex.api.q;
import com.tencent.qmethod.pandoraex.core.collector.utils.SamplingUtil;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.core.x;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import org.json.JSONArray;
import ur3.b;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CollectorCore {

    /* renamed from: d, reason: collision with root package name */
    private static final Object f344025d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Context f344026a;

    /* renamed from: b, reason: collision with root package name */
    private final a f344027b = new a("0c800065317", "1884376177");

    /* renamed from: c, reason: collision with root package name */
    private ur3.a f344028c;

    public CollectorCore(Context context) {
        this.f344026a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(Context context) {
        if (this.f344028c != null) {
            return true;
        }
        synchronized (f344025d) {
            if (this.f344028c == null) {
                try {
                    ur3.a aVar = new ur3.a(context.getPackageName(), context.getString(context.getApplicationInfo().labelRes), InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName);
                    this.f344028c = aVar;
                    aVar.a();
                } catch (Exception e16) {
                    o.d("CollectAppInfo.CollectorCore", "initAppItem exception", e16);
                }
            }
        }
        if (this.f344028c != null) {
            return true;
        }
        o.a("CollectAppInfo.CollectorCore", "appItem is init fail! ");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(Context context, int i3) {
        SamplingUtil.SamplingResult c16 = SamplingUtil.c(context, i3);
        if (c16 != SamplingUtil.SamplingResult.REPORT) {
            o.a("CollectAppInfo.CollectorCore", "filter report for reason = " + c16.name());
            return false;
        }
        return true;
    }

    public void g() {
        x.j(new Runnable() { // from class: com.tencent.qmethod.pandoraex.core.collector.CollectorCore.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CollectorCore collectorCore = CollectorCore.this;
                    if (collectorCore.h(collectorCore.f344026a, q.c())) {
                        CollectorCore collectorCore2 = CollectorCore.this;
                        if (!collectorCore2.f(collectorCore2.f344026a)) {
                            o.a("CollectAppInfo.CollectorCore", "appItem is init fail! ");
                            return;
                        }
                        b bVar = new b("Android");
                        bVar.a(CollectorCore.this.f344028c);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.mo162put(bVar.b());
                        CollectorCore.this.f344027b.c(jSONArray);
                    }
                } catch (Exception e16) {
                    o.d("CollectAppInfo.CollectorCore", "report error ", e16);
                }
            }
        }, 15000L);
    }
}

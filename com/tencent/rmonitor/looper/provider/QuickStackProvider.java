package com.tencent.rmonitor.looper.provider;

import android.os.Handler;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.g;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.base.thread.trace.QuickJavaThreadTrace;
import com.tencent.rmonitor.looper.MonitorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes25.dex */
public class QuickStackProvider extends com.tencent.rmonitor.looper.provider.a {
    private QuickJavaThreadTrace E = null;
    private c14.a F = null;
    private Handler G = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        long f365670a;

        /* renamed from: b, reason: collision with root package name */
        long f365671b;

        /* renamed from: c, reason: collision with root package name */
        int f365672c;

        /* renamed from: d, reason: collision with root package name */
        int f365673d;

        /* renamed from: e, reason: collision with root package name */
        String f365674e;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<a> s(ArrayList<com.tencent.rmonitor.base.thread.trace.b> arrayList) {
        if (arrayList.size() > 0) {
            a aVar = new a();
            int i3 = 0;
            aVar.f365670a = arrayList.get(0).f365450e;
            aVar.f365671b = arrayList.get(0).f365450e + (arrayList.get(0).f365452h / 1000);
            aVar.f365672c = 1;
            aVar.f365674e = arrayList.get(0).f365449d;
            aVar.f365673d = 0;
            ArrayList<a> arrayList2 = new ArrayList<>();
            arrayList2.add(aVar);
            for (int i16 = 1; i16 < arrayList.size(); i16++) {
                if (arrayList.get(i16).f365449d.equals(aVar.f365674e)) {
                    aVar.f365672c++;
                    aVar.f365671b = arrayList.get(i16).f365450e + (arrayList.get(i16).f365452h / 1000);
                } else {
                    i3++;
                    aVar = new a();
                    aVar.f365670a = arrayList.get(i16).f365450e;
                    aVar.f365671b = arrayList.get(i16).f365450e + (arrayList.get(i16).f365452h / 1000);
                    aVar.f365672c = 1;
                    aVar.f365674e = arrayList.get(i16).f365449d;
                    aVar.f365673d = i3;
                    arrayList2.add(aVar);
                }
            }
            return arrayList2;
        }
        return null;
    }

    private void t(final MonitorInfo monitorInfo, final ArrayList<com.tencent.rmonitor.base.thread.trace.b> arrayList) {
        this.G.post(new Runnable() { // from class: com.tencent.rmonitor.looper.provider.QuickStackProvider.1
            @Override // java.lang.Runnable
            public void run() {
                monitorInfo.q(arrayList.size());
                monitorInfo.w(true);
                long j3 = 0;
                monitorInfo.r(0L);
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        j3 += ((com.tencent.rmonitor.base.thread.trace.b) it.next()).f365452h;
                    }
                }
                monitorInfo.p(j3);
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                try {
                    ArrayList s16 = QuickStackProvider.this.s(arrayList);
                    if (s16 != null && s16.size() > 0) {
                        Iterator it5 = s16.iterator();
                        while (it5.hasNext()) {
                            a aVar = (a) it5.next();
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("type", "normal");
                            jSONObject2.put(CrashHianalyticsData.THREAD_NAME, monitorInfo.getThreadName());
                            jSONObject2.put(CrashHianalyticsData.THREAD_ID, monitorInfo.getThreadId());
                            jSONObject2.put("index", aVar.f365673d);
                            jSONObject2.put("repeat_count", aVar.f365672c);
                            jSONObject2.put("timestamp", aVar.f365670a);
                            jSONObject2.put("end_time", aVar.f365671b);
                            jSONObject2.put("call_stack", aVar.f365674e);
                            jSONArray.mo162put(jSONObject2);
                        }
                    }
                    jSONObject.put("stacks", jSONArray);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                monitorInfo.u(jSONObject);
                QuickStackProvider.this.F.a(monitorInfo);
            }
        });
    }

    @Override // com.tencent.rmonitor.looper.provider.a
    public void f(@NotNull MonitorInfo monitorInfo, long j3, long j16) {
        QuickJavaThreadTrace quickJavaThreadTrace = this.E;
        if (quickJavaThreadTrace != null) {
            quickJavaThreadTrace.i();
        }
        if (j16 > getLagParam().f365684b) {
            d(monitorInfo);
            t(monitorInfo.d(), this.E.d(monitorInfo.getLastStackRequestTime(), j3));
        }
    }

    @Override // com.tencent.rmonitor.looper.provider.a
    public void g(@NotNull MonitorInfo monitorInfo, long j3) {
        QuickJavaThreadTrace quickJavaThreadTrace = this.E;
        if (quickJavaThreadTrace != null) {
            quickJavaThreadTrace.h();
        }
    }

    @Override // com.tencent.rmonitor.looper.provider.a
    public boolean l(@NotNull c14.a aVar) {
        boolean z16;
        boolean z17;
        if (this.E == null) {
            m mVar = ConfigProxy.INSTANCE.getConfig().i(BuglyMonitorName.LOOPER_STACK).com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String;
            if (mVar instanceof g) {
                g gVar = (g) mVar;
                z16 = gVar.b();
                z17 = gVar.a();
            } else {
                z16 = true;
                z17 = false;
            }
            QuickJavaThreadTrace quickJavaThreadTrace = new QuickJavaThreadTrace(getLooperThread(), z16, z17);
            this.E = quickJavaThreadTrace;
            if (!quickJavaThreadTrace.e()) {
                return false;
            }
        }
        this.F = aVar;
        this.E.g(((int) getLagParam().f365686d) * 1000, 100);
        this.E.h();
        this.G = new Handler(ThreadManager.getMonitorThreadLooper());
        return true;
    }

    @Override // com.tencent.rmonitor.looper.provider.a
    public void n() {
        QuickJavaThreadTrace quickJavaThreadTrace = this.E;
        if (quickJavaThreadTrace != null) {
            quickJavaThreadTrace.i();
        }
    }

    public boolean r() {
        return QuickJavaThreadTrace.f();
    }

    @Override // com.tencent.rmonitor.looper.provider.a
    public void e() {
    }
}

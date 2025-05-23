package com.tencent.rmonitor.pagelaunch;

import android.app.Activity;
import com.tencent.bugly.common.trace.TraceSpan;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.pagelaunch.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f365794a;

    /* renamed from: b, reason: collision with root package name */
    public int f365795b;

    /* renamed from: c, reason: collision with root package name */
    public long f365796c;

    /* renamed from: d, reason: collision with root package name */
    public long f365797d;

    /* renamed from: e, reason: collision with root package name */
    public long f365798e;

    /* renamed from: f, reason: collision with root package name */
    public long f365799f;

    /* renamed from: g, reason: collision with root package name */
    public b.ViewTreeObserverOnWindowFocusChangeListenerC9750b f365800g;

    /* renamed from: h, reason: collision with root package name */
    CopyOnWriteArrayList<TraceSpan> f365801h = new CopyOnWriteArrayList<>();

    public a(Activity activity) {
        this.f365795b = activity.hashCode();
        this.f365794a = activity.getClass().getName();
    }

    private long a() {
        Iterator<TraceSpan> it = this.f365801h.iterator();
        long j3 = Long.MAX_VALUE;
        while (it.hasNext()) {
            TraceSpan next = it.next();
            if (next.getStartTimeInMs() < j3) {
                j3 = next.getStartTimeInMs();
            }
        }
        return j3;
    }

    private ArrayList<TraceSpan> b() {
        ArrayList<TraceSpan> arrayList = new ArrayList<>();
        Iterator<TraceSpan> it = this.f365801h.iterator();
        while (it.hasNext()) {
            TraceSpan next = it.next();
            if (next.isSpanEnd()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public JSONObject c() {
        int i3;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page_name", this.f365794a);
            if (this.f365798e > 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            jSONObject.put("render_state", i3);
            long j3 = this.f365798e;
            long j16 = this.f365796c;
            if (j3 > j16) {
                jSONObject.put("page_render_time", j3 - j16);
            } else {
                jSONObject.put("page_render_time", 0);
            }
            long j17 = this.f365799f;
            long j18 = this.f365796c;
            if (j17 > j18) {
                jSONObject.put("page_load_time", j17 - j18);
            } else {
                long j19 = this.f365798e;
                if (j19 > j18) {
                    jSONObject.put("page_load_time", j19 - j18);
                } else {
                    jSONObject.put("page_load_time", 0);
                }
            }
            JSONArray jSONArray = new JSONArray();
            long a16 = a();
            Iterator<TraceSpan> it = b().iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next().toJson(a16, this.f365797d));
            }
            jSONObject.put("spans", jSONArray);
        } catch (Throwable th5) {
            Logger.f365497g.c("PageLaunchInfo", th5);
        }
        return jSONObject;
    }
}

package com.tencent.rmonitor.base.config.data;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes25.dex */
public class o extends m {

    /* renamed from: m, reason: collision with root package name */
    private final ArrayList<a> f365322m;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f365323a = null;

        /* renamed from: b, reason: collision with root package name */
        public float f365324b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        public float f365325c = 0.1f;

        /* renamed from: d, reason: collision with root package name */
        public long f365326d = 500;

        /* renamed from: e, reason: collision with root package name */
        public long f365327e = 300;

        /* renamed from: f, reason: collision with root package name */
        public long f365328f = 20000;

        public boolean a() {
            if (!TextUtils.isEmpty(this.f365323a) && this.f365326d > 0 && this.f365327e > 0 && this.f365328f > 0) {
                return true;
            }
            return false;
        }

        public void b(a aVar) {
            if (aVar == null) {
                return;
            }
            this.f365323a = aVar.f365323a;
            this.f365324b = aVar.f365324b;
            this.f365325c = aVar.f365325c;
            this.f365326d = aVar.f365326d;
            this.f365327e = aVar.f365327e;
            this.f365328f = aVar.f365328f;
        }
    }

    public o() {
        super("work_thread_lag", false, 100, 0.1f);
        this.f365322m = new ArrayList<>();
    }

    private void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            a aVar = new a();
            if (jSONObject.has(CrashHianalyticsData.THREAD_NAME)) {
                aVar.f365323a = jSONObject.getString(CrashHianalyticsData.THREAD_NAME);
            }
            if (jSONObject.has(k.SAMPLE_RATION_KEY)) {
                aVar.f365324b = (float) jSONObject.getDouble(k.SAMPLE_RATION_KEY);
            }
            if (jSONObject.has("event_sample_ratio")) {
                aVar.f365325c = (float) jSONObject.getDouble("event_sample_ratio");
            }
            if (jSONObject.has("lag_threshold")) {
                aVar.f365326d = jSONObject.getLong("lag_threshold");
            }
            if (jSONObject.has("stack_interval")) {
                aVar.f365327e = jSONObject.getLong("stack_interval");
            }
            if (jSONObject.has("max_stack_duration")) {
                aVar.f365328f = jSONObject.getLong("max_stack_duration");
            }
            a(aVar);
        } catch (Throwable th5) {
            Logger.f365497g.e("RMonitor_config", "parseWorkTypeConfig, t: " + th5);
        }
    }

    public void a(a aVar) {
        if (aVar != null && aVar.a()) {
            a c16 = c(aVar.f365323a);
            if (c16 != null) {
                c16.b(aVar);
            } else {
                this.f365322m.add(aVar);
            }
        }
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o mo105clone() {
        return new o(this);
    }

    public a c(String str) {
        try {
            Iterator<a> it = this.f365322m.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (TextUtils.equals(str, next.f365323a)) {
                    return next;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.tencent.rmonitor.base.config.data.m, com.tencent.rmonitor.base.config.h
    public void parsePluginConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        super.parsePluginConfig(jSONObject);
        try {
            if (jSONObject.has("threads")) {
                JSONArray jSONArray = jSONObject.getJSONArray("threads");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    d(jSONArray.getJSONObject(i3));
                }
            }
        } catch (Throwable th5) {
            Logger.f365497g.b("RMonitor_config", "parsePluginConfig", th5);
        }
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    public void update(m mVar) {
        super.update(mVar);
        ArrayList<a> arrayList = this.f365322m;
        if (arrayList != null && (mVar instanceof o)) {
            arrayList.clear();
            this.f365322m.addAll(((o) mVar).f365322m);
        }
    }

    protected o(@NonNull o oVar) {
        super(oVar);
        this.f365322m = new ArrayList<>();
        update(oVar);
    }
}

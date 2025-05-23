package com.tencent.rmonitor.launch;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.bugly.common.constants.SPKey;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.trace.TraceSpan;
import com.tencent.bugly.common.utils.GcInfoStatHelper;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f365628a;

    /* renamed from: b, reason: collision with root package name */
    private final long f365629b;

    /* renamed from: c, reason: collision with root package name */
    private final long f365630c;

    /* renamed from: d, reason: collision with root package name */
    private final long f365631d;

    /* renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArrayList<TraceSpan> f365632e = new CopyOnWriteArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private final CopyOnWriteArrayList<String> f365633f = new CopyOnWriteArrayList<>();

    public a(String str, long j3, long j16, long j17) {
        this.f365628a = str;
        this.f365630c = j3;
        this.f365629b = j16;
        this.f365631d = j17;
    }

    private boolean b() {
        if (BaseInfo.sharePreference == null) {
            return true;
        }
        return !TextUtils.equals(r0.getString(SPKey.KEY_LAST_APP_VERSION, ""), BaseInfo.userMeta.appVersion);
    }

    private JSONObject c() throws JSONException {
        JSONObject makeAttributes = ReportDataBuilder.makeAttributes();
        makeAttributes.put("process_name", com.tencent.rmonitor.common.util.a.e(BaseInfo.app));
        makeAttributes.put("launch_type", this.f365628a);
        makeAttributes.put("launch_cost", this.f365629b);
        makeAttributes.put("start_time", this.f365631d);
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f365633f.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next());
        }
        makeAttributes.put(ComicCancelRedPointPopItemData.JSON_KEY_TAGS, jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        Iterator<TraceSpan> it5 = this.f365632e.iterator();
        while (it5.hasNext()) {
            jSONArray2.mo162put(it5.next().toJson(this.f365630c, this.f365631d));
        }
        makeAttributes.put("spans", jSONArray2);
        GcInfoStatHelper gcInfoStatHelper = GcInfoStatHelper.getInstance();
        long j3 = this.f365631d;
        JSONObject json = gcInfoStatHelper.toJSON(j3, this.f365629b + j3);
        if (json != null) {
            makeAttributes.put(ReportDataBuilder.KEY_GC_INFO, json);
        }
        return makeAttributes;
    }

    private void g() {
        SharedPreferences sharedPreferences = BaseInfo.sharePreference;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(SPKey.KEY_LAST_APP_VERSION, BaseInfo.userMeta.appVersion).apply();
        }
    }

    public void a() {
        if (StartupReportKey.COLD_LAUNCH.equals(this.f365628a) && b()) {
            this.f365633f.add("tag_first_launch");
            g();
        }
    }

    public void d(List<TraceSpan> list) {
        if (list != null) {
            this.f365632e.clear();
            this.f365632e.addAll(list);
        }
    }

    public void e(List<String> list) {
        if (list != null) {
            this.f365633f.clear();
            this.f365633f.addAll(list);
        }
    }

    public JSONObject f() {
        JSONObject jSONObject = null;
        try {
            jSONObject = ReportDataBuilder.makeParam(BaseInfo.app, "launch", BuglyMonitorName.LAUNCH, BaseInfo.userMeta);
            jSONObject.put("event_time", this.f365631d / 1000);
            jSONObject.put(ReportDataBuilder.KEY_EVENT_TIME_IN_MS, this.f365631d);
            jSONObject.put(ReportDataBuilder.KEY_ATTRIBUTES, c());
            return jSONObject;
        } catch (Throwable th5) {
            Logger.f365497g.b("AppLaunchResult", "realReport", th5);
            return jSONObject;
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(200);
        sb5.append("{launchType: ");
        sb5.append(this.f365628a);
        sb5.append(", launchCostInMs: ");
        sb5.append(this.f365629b);
        sb5.append(", tags: [");
        Iterator<String> it = this.f365633f.iterator();
        int i3 = 0;
        int i16 = 0;
        while (it.hasNext()) {
            String next = it.next();
            if (i16 > 0) {
                sb5.append(",");
            }
            sb5.append(next);
            i16++;
        }
        sb5.append("], spans: [");
        Iterator<TraceSpan> it5 = this.f365632e.iterator();
        while (it5.hasNext()) {
            TraceSpan next2 = it5.next();
            if (i3 > 0) {
                sb5.append(",");
            }
            sb5.append(next2);
            i3++;
        }
        sb5.append("]}");
        return sb5.toString();
    }
}

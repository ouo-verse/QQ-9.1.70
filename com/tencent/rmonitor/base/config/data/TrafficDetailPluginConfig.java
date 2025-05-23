package com.tencent.rmonitor.base.config.data;

import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes25.dex */
public class TrafficDetailPluginConfig extends m {
    public double C;
    public double D;
    public double E;
    public double F;
    public boolean G;
    public double H;
    public double I;
    public List<String> J;

    /* renamed from: m, reason: collision with root package name */
    public double f365308m;

    public TrafficDetailPluginConfig() {
        super(BuglyMonitorName.TRAFFIC_DETAIL, false, 1000, 0.5f, 0.0f, 100);
        this.f365308m = 500.0d;
        this.C = 50.0d;
        this.D = 200.0d;
        this.E = 200.0d;
        this.F = 50.0d;
        this.G = true;
        this.H = 1.0d;
        this.I = 1.0d;
        this.J = new ArrayList<String>() { // from class: com.tencent.rmonitor.base.config.data.TrafficDetailPluginConfig.1
            {
                add(".*/librmonitor_memory.so$");
                add(".*/librmonitor_base.so$");
                add(".*/libBugly_Native.so$");
                add(".*/libbuglybacktrace.so$");
            }
        };
    }

    private void b(JSONObject jSONObject) {
        if (jSONObject.has("ignore_so_list")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("ignore_so_list");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    this.J.add(jSONArray.getString(i3));
                }
            } catch (Throwable th5) {
                Logger.f365497g.b("TrafficDetailPluginConfig", "ignore_so_list parse failed", th5);
            }
        }
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public TrafficDetailPluginConfig mo105clone() {
        return new TrafficDetailPluginConfig(this);
    }

    @Override // com.tencent.rmonitor.base.config.data.m, com.tencent.rmonitor.base.config.data.k
    public String getName() {
        return BuglyMonitorName.TRAFFIC_DETAIL;
    }

    @Override // com.tencent.rmonitor.base.config.data.m, com.tencent.rmonitor.base.config.h
    public void parsePluginConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        super.parsePluginConfig(jSONObject);
        try {
            if (jSONObject.has("total_limit_in_megabyte")) {
                this.f365308m = jSONObject.getDouble("total_limit_in_megabyte");
            }
            if (jSONObject.has("mobile_limit_in_megabyte")) {
                this.D = jSONObject.getDouble("mobile_limit_in_megabyte");
            }
            if (jSONObject.has("backend_limit_in_megabyte")) {
                this.C = jSONObject.getDouble("backend_limit_in_megabyte");
            }
            if (jSONObject.has("custom_limit_in_megabyte")) {
                this.E = jSONObject.getDouble("custom_limit_in_megabyte");
            }
            if (jSONObject.has("auto_start_limit_in_megabyte")) {
                this.F = jSONObject.getDouble("auto_start_limit_in_megabyte");
            }
            if (jSONObject.has("filter_local_address")) {
                this.G = jSONObject.getBoolean("filter_local_address");
            }
            if (jSONObject.has("metric_event_sample_ratio")) {
                this.H = jSONObject.optDouble("metric_event_sample_ratio", 1.0d);
            }
            if (jSONObject.has("error_event_sample_ratio")) {
                this.I = jSONObject.optDouble("error_event_sample_ratio", 1.0d);
            }
            b(jSONObject);
        } catch (Throwable th5) {
            Logger.f365497g.b("TrafficDetailPluginConfig", "parsePluginConfig", th5);
        }
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    public void update(m mVar) {
        super.update(mVar);
        if (mVar instanceof TrafficDetailPluginConfig) {
            TrafficDetailPluginConfig trafficDetailPluginConfig = (TrafficDetailPluginConfig) mVar;
            this.f365308m = trafficDetailPluginConfig.f365308m;
            this.D = trafficDetailPluginConfig.D;
            this.E = trafficDetailPluginConfig.E;
            this.F = trafficDetailPluginConfig.F;
            this.C = trafficDetailPluginConfig.C;
            this.J = trafficDetailPluginConfig.J;
            this.G = trafficDetailPluginConfig.G;
            this.H = trafficDetailPluginConfig.H;
            this.I = trafficDetailPluginConfig.I;
        }
    }

    public TrafficDetailPluginConfig(TrafficDetailPluginConfig trafficDetailPluginConfig) {
        super(trafficDetailPluginConfig);
        this.f365308m = 500.0d;
        this.C = 50.0d;
        this.D = 200.0d;
        this.E = 200.0d;
        this.F = 50.0d;
        this.G = true;
        this.H = 1.0d;
        this.I = 1.0d;
        this.J = new ArrayList<String>() { // from class: com.tencent.rmonitor.base.config.data.TrafficDetailPluginConfig.1
            {
                add(".*/librmonitor_memory.so$");
                add(".*/librmonitor_base.so$");
                add(".*/libBugly_Native.so$");
                add(".*/libbuglybacktrace.so$");
            }
        };
        update(trafficDetailPluginConfig);
    }
}

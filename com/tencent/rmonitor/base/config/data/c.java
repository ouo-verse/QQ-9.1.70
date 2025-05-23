package com.tencent.rmonitor.base.config.data;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes25.dex */
public class c extends m {
    public int C;
    public int D;
    public int E;
    public boolean F;
    public boolean G;
    public List<String> H;
    public List<String> I;

    /* renamed from: m, reason: collision with root package name */
    public int f365310m;

    public c() {
        super(BuglyMonitorName.ASAN, false, 1000, 1.0f, 1.0f, 0);
        this.f365310m = 8192;
        this.C = 4096;
        this.D = 5;
        this.E = 30;
        this.F = false;
        this.G = false;
        this.H = new ArrayList();
        this.I = new ArrayList();
    }

    private void b(JSONObject jSONObject) {
        try {
            if (jSONObject.has("slot_size")) {
                this.f365310m = Math.max(jSONObject.getInt("slot_size"), 0);
            }
            if (jSONObject.has("slot_count")) {
                this.C = Math.max(jSONObject.getInt("slot_count"), 0);
            }
            if (jSONObject.has("max_sample_gap_count")) {
                this.D = Math.max(jSONObject.getInt("max_sample_gap_count"), 0);
            }
            if (jSONObject.has("left_side_align_percentage")) {
                this.E = Math.max(Math.min(jSONObject.getInt("left_side_align_percentage"), 100), 0);
            }
            if (jSONObject.has("right_side_perfect_align")) {
                this.F = jSONObject.getBoolean("right_side_perfect_align");
            }
            if (jSONObject.has("ignore_overlapped_reading")) {
                this.G = jSONObject.getBoolean("ignore_overlapped_reading");
            }
            if (jSONObject.has("target_so_patterns")) {
                c(this.H, jSONObject.getJSONArray("target_so_patterns"));
            }
            if (jSONObject.has("ignore_so_patterns")) {
                c(this.I, jSONObject.getJSONArray("ignore_so_patterns"));
            }
        } catch (Throwable th5) {
            Logger.f365497g.b("RMonitor_config", "parse asan config failed", th5);
        }
    }

    private void c(List<String> list, JSONArray jSONArray) {
        if (list != null && jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    list.add(jSONArray.getString(i3));
                } catch (Exception e16) {
                    Logger.f365497g.c("RMonitor_config", e16);
                    return;
                }
            }
        }
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c mo105clone() {
        return new c(this);
    }

    @Override // com.tencent.rmonitor.base.config.data.m, com.tencent.rmonitor.base.config.h
    public void parsePluginConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        super.parsePluginConfig(jSONObject);
        b(jSONObject);
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    public void update(m mVar) {
        super.update(mVar);
        if (mVar instanceof c) {
            c cVar = (c) mVar;
            this.f365310m = cVar.f365310m;
            this.C = cVar.C;
            this.D = cVar.D;
            this.E = cVar.E;
            this.F = cVar.F;
            this.G = cVar.G;
            this.H = cVar.H;
            this.I = cVar.I;
        }
    }

    protected c(c cVar) {
        super(cVar);
        this.f365310m = 8192;
        this.C = 4096;
        this.D = 5;
        this.E = 30;
        this.F = false;
        this.G = false;
        this.H = new ArrayList();
        this.I = new ArrayList();
        update(cVar);
    }
}

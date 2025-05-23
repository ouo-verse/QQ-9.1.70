package com.tencent.rmonitor.base.config.data;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.rmonitor.common.logger.Logger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class m extends k implements Cloneable {
    static final String TAG = "RMonitor_config";
    public int dailyReportLimit;
    public boolean enabled;
    public float eventSampleRatio;
    public final String name;
    public float reportSampleRatio;
    public float sampleRatio;
    public int threshold;

    public m(String str) {
        this.enabled = false;
        this.dailyReportLimit = 10;
        this.sampleRatio = 0.0f;
        this.eventSampleRatio = 0.0f;
        this.reportSampleRatio = 1.0f;
        this.threshold = 0;
        this.name = str;
    }

    @Override // com.tencent.rmonitor.base.config.data.k
    public String getName() {
        return this.name;
    }

    @Override // com.tencent.rmonitor.base.config.h
    public void parsePluginConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.has(k.SAMPLE_RATION_KEY)) {
                this.sampleRatio = (float) jSONObject.getDouble(k.SAMPLE_RATION_KEY);
            }
            if (jSONObject.has(NodeProps.ENABLED)) {
                this.enabled = jSONObject.getBoolean(NodeProps.ENABLED);
            }
            if (jSONObject.has("daily_report_limit")) {
                this.dailyReportLimit = jSONObject.getInt("daily_report_limit");
            }
            if (jSONObject.has("event_sample_ratio")) {
                this.eventSampleRatio = (float) jSONObject.getDouble("event_sample_ratio");
            }
            if (jSONObject.has("report_sample_ratio")) {
                this.reportSampleRatio = (float) jSONObject.getDouble("report_sample_ratio");
            }
            if (jSONObject.has("threshold")) {
                this.threshold = jSONObject.getInt("threshold");
            }
        } catch (Throwable th5) {
            Logger.f365497g.b(TAG, "parsePluginConfig", th5);
        }
    }

    public void update(m mVar) {
        if (mVar == null) {
            return;
        }
        this.enabled = mVar.enabled;
        this.dailyReportLimit = mVar.dailyReportLimit;
        this.sampleRatio = mVar.sampleRatio;
        this.eventSampleRatio = mVar.eventSampleRatio;
        this.reportSampleRatio = mVar.reportSampleRatio;
        this.threshold = mVar.threshold;
    }

    @Override // 
    @NotNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public m mo105clone() {
        return new m(this);
    }

    public m(String str, boolean z16, int i3, float f16) {
        this(str);
        this.dailyReportLimit = i3;
        this.eventSampleRatio = f16;
        this.enabled = z16;
    }

    public m(String str, boolean z16, int i3, float f16, int i16) {
        this(str, z16, i3, f16);
        this.threshold = i16;
    }

    public m(String str, boolean z16, int i3, float f16, float f17, int i16) {
        this(str, z16, i3, f16);
        this.sampleRatio = f17;
        this.threshold = i16;
    }

    public m(m mVar) {
        this(mVar.name);
        update(mVar);
    }
}

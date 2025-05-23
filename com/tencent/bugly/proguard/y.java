package com.tencent.bugly.proguard;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class y extends com.tencent.rmonitor.base.config.data.k {

    /* renamed from: a, reason: collision with root package name */
    public boolean f98582a = false;

    /* renamed from: b, reason: collision with root package name */
    public double f98583b = 0.0d;

    @Override // com.tencent.rmonitor.base.config.data.k
    public final String getName() {
        return "application_exit";
    }

    @Override // com.tencent.rmonitor.base.config.h
    public final void parsePluginConfig(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(NodeProps.ENABLED)) {
            this.f98582a = jSONObject.getBoolean(NodeProps.ENABLED);
        }
        if (jSONObject.has("exit_file_ratio")) {
            this.f98583b = jSONObject.getDouble("exit_file_ratio");
        }
    }
}

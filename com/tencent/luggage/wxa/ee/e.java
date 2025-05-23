package com.tencent.luggage.wxa.ee;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.sdk.core.ReportConst;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e extends com.tencent.luggage.wxa.xd.a {
    private static final String TAG = "MicroMsg.BaseViewOperateJsApi";

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }

    public final View findViewById(@NonNull com.tencent.luggage.wxa.xd.d dVar, @NonNull JSONObject jSONObject) throws IllegalArgumentException {
        try {
            int viewId = getViewId(jSONObject);
            boolean independent = getIndependent(jSONObject);
            com.tencent.luggage.wxa.xd.f componentView = getComponentView(dVar, jSONObject);
            if (componentView != null) {
                View c16 = componentView.a(independent).c(viewId);
                if (c16 != null) {
                    return c16;
                }
                w.h(TAG, "get view by viewId(%s) return null.", Integer.valueOf(viewId));
                throw new IllegalArgumentException("got 'null' when get view by the given viewId");
            }
            throw new IllegalArgumentException("ComponentView is null.");
        } catch (JSONException unused) {
            throw new IllegalArgumentException("view id do not exist");
        }
    }

    @Nullable
    public final com.tencent.luggage.wxa.xd.f getComponentView(@NonNull com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        g gVar = (g) dVar.b(g.class);
        if (gVar == null) {
            w.b(TAG, "getComponentView NULL IComponentConverter");
            return null;
        }
        return gVar.a(dVar, jSONObject);
    }

    public String getDragConfig(JSONObject jSONObject) {
        return jSONObject.optString("dragConfig");
    }

    public boolean getDraggable(JSONObject jSONObject) {
        return jSONObject.optBoolean("draggable", false);
    }

    public Boolean getFixed(JSONObject jSONObject) {
        try {
            return Boolean.valueOf(jSONObject.getBoolean(QCircleDaTongConstant.ElementParamValue.FIXED));
        } catch (JSONException unused) {
            return null;
        }
    }

    public Boolean getFullScreen(JSONObject jSONObject) {
        try {
            return Boolean.valueOf(jSONObject.getBoolean(ReportConst.ACTION.FULLSCREEN));
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean getIndependent(JSONObject jSONObject) {
        return jSONObject.optBoolean("independent", false);
    }

    public int getParentId(JSONObject jSONObject) {
        return jSONObject.optInt("parentId", 0);
    }

    public float[] getPosition(JSONObject jSONObject) throws JSONException {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("position"));
            return new float[]{com.tencent.luggage.wxa.tk.g.a(jSONObject2, "left", 0.0f), com.tencent.luggage.wxa.tk.g.a(jSONObject2, "top", 0.0f), com.tencent.luggage.wxa.tk.g.a(jSONObject2, "width", 0.0f), com.tencent.luggage.wxa.tk.g.a(jSONObject2, "height", 0.0f), com.tencent.luggage.wxa.h6.f.a(jSONObject, NodeProps.Z_INDEX, Float.NaN)};
        } catch (Exception unused) {
            return null;
        }
    }

    public Boolean getUnderView(JSONObject jSONObject) {
        return null;
    }

    public int getViewId(JSONObject jSONObject) {
        throw new JSONException("viewId do not exist, override the method getViewId(data).");
    }

    public int getVisibility(JSONObject jSONObject) {
        try {
            if (jSONObject.getBoolean("hide")) {
                return 4;
            }
            return 0;
        } catch (JSONException unused) {
            return -1;
        }
    }

    public void beforeOperateFromOriginThread(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
    }
}

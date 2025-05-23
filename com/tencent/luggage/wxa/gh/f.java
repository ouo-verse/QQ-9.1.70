package com.tencent.luggage.wxa.gh;

import android.view.View;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {
    /* JADX WARN: Can't wrap try/catch for region: R(17:3|(3:39|40|(17:44|(3:47|(2:49|50)(1:51)|45)|52|6|(1:8)(1:38)|9|10|(2:14|15)|17|(1:21)|22|(1:24)|25|(1:27)|28|(1:30)(1:36)|(2:32|33)(1:35)))|5|6|(0)(0)|9|10|(3:12|14|15)|17|(2:19|21)|22|(0)|25|(0)|28|(0)(0)|(0)(0)) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(View view, JSONObject jSONObject) {
        JSONArray jSONArray;
        boolean z16;
        boolean z17;
        JSONArray optJSONArray;
        float f16;
        if (view != 0 && jSONObject != null) {
            int a16 = com.tencent.luggage.wxa.tk.g.a(jSONObject.optString("bgColor"));
            int a17 = com.tencent.luggage.wxa.tk.g.a(jSONObject.optString(NodeProps.BORDER_COLOR));
            float a18 = com.tencent.luggage.wxa.tk.g.a(jSONObject, NodeProps.BORDER_WIDTH, 0.0f);
            float a19 = com.tencent.luggage.wxa.tk.g.a(jSONObject, NodeProps.BORDER_RADIUS, 0.0f);
            float[] fArr = new float[4];
            if (jSONObject.has(NodeProps.BORDER_RADIUS)) {
                try {
                    jSONArray = jSONObject.getJSONArray(NodeProps.BORDER_RADIUS);
                } catch (Exception unused) {
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        float f17 = (float) jSONArray.getDouble(i3);
                        if (i3 >= 4) {
                            break;
                        }
                        fArr[i3] = com.tencent.luggage.wxa.tk.g.a(f17);
                    }
                    z16 = true;
                    if (!(view instanceof g)) {
                        g gVar = (g) view;
                        gVar.setBgColor(a16);
                        gVar.setBorderColor(a17);
                        gVar.setBorderRadius(a19);
                        gVar.setBorderWidth(a18);
                        gVar.setBorderRadius(fArr);
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    f16 = (float) jSONObject.getDouble("opacity");
                    if (f16 >= 0.0f && f16 <= 1.0f) {
                        view.setAlpha(f16);
                        z17 = true;
                    }
                    optJSONArray = jSONObject.optJSONArray("padding");
                    if (optJSONArray != null && optJSONArray.length() == 4) {
                        view.setPadding(com.tencent.luggage.wxa.tk.g.c(optJSONArray, 3), com.tencent.luggage.wxa.tk.g.c(optJSONArray, 0), com.tencent.luggage.wxa.tk.g.c(optJSONArray, 1), com.tencent.luggage.wxa.tk.g.c(optJSONArray, 2));
                    }
                    float optDouble = (float) jSONObject.optDouble(CanvasView.ACTION_ROTATE, 0.0d);
                    float optDouble2 = (float) jSONObject.optDouble(BasicAnimation.KeyPath.SCALE_X, 1.0d);
                    float optDouble3 = (float) jSONObject.optDouble(BasicAnimation.KeyPath.SCALE_Y, 1.0d);
                    if (jSONObject.has(CanvasView.ACTION_ROTATE)) {
                        view.setRotation(optDouble);
                        z17 = true;
                    }
                    if (jSONObject.has(BasicAnimation.KeyPath.SCALE_X)) {
                        view.setScaleX(optDouble2);
                        z17 = true;
                    }
                    if (!jSONObject.has(BasicAnimation.KeyPath.SCALE_Y)) {
                        view.setScaleY(optDouble3);
                    } else {
                        z16 = z17;
                    }
                    if (!z16) {
                        view.invalidate();
                        return;
                    }
                    return;
                }
            }
            fArr = null;
            z16 = true;
            if (!(view instanceof g)) {
            }
            f16 = (float) jSONObject.getDouble("opacity");
            if (f16 >= 0.0f) {
                view.setAlpha(f16);
                z17 = true;
            }
            optJSONArray = jSONObject.optJSONArray("padding");
            if (optJSONArray != null) {
                view.setPadding(com.tencent.luggage.wxa.tk.g.c(optJSONArray, 3), com.tencent.luggage.wxa.tk.g.c(optJSONArray, 0), com.tencent.luggage.wxa.tk.g.c(optJSONArray, 1), com.tencent.luggage.wxa.tk.g.c(optJSONArray, 2));
            }
            float optDouble4 = (float) jSONObject.optDouble(CanvasView.ACTION_ROTATE, 0.0d);
            float optDouble22 = (float) jSONObject.optDouble(BasicAnimation.KeyPath.SCALE_X, 1.0d);
            float optDouble32 = (float) jSONObject.optDouble(BasicAnimation.KeyPath.SCALE_Y, 1.0d);
            if (jSONObject.has(CanvasView.ACTION_ROTATE)) {
            }
            if (jSONObject.has(BasicAnimation.KeyPath.SCALE_X)) {
            }
            if (!jSONObject.has(BasicAnimation.KeyPath.SCALE_Y)) {
            }
            if (!z16) {
            }
        }
    }
}

package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class LogUtils {
    public static boolean sShouldLog = false;

    public static void d(String str, String str2) {
        LogUtil.QLog.d(str, 1, str2);
    }

    private static void dumpViewBaseHierarchy(@NonNull ViewBase viewBase, @NonNull JSONObject jSONObject) throws JSONException {
        List<ViewBase> subViews;
        Rect rect = new Rect(viewBase.getDrawLeft(), viewBase.getDrawTop(), viewBase.getWidth(), viewBase.getHeight());
        String simpleName = viewBase.getClass().getSimpleName();
        String name = viewBase.getName();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("name", simpleName);
        jSONObject2.put("id", name);
        jSONObject2.put("visibility", viewBase.getVisibility());
        jSONObject2.put("bounds", rect);
        jSONObject.put("view", jSONObject2);
        if ((viewBase instanceof Layout) && (subViews = ((Layout) viewBase).getSubViews()) != null && subViews.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (ViewBase viewBase2 : subViews) {
                JSONObject jSONObject3 = new JSONObject();
                dumpViewBaseHierarchy(viewBase2, jSONObject3);
                jSONArray.mo162put(jSONObject3);
            }
            jSONObject.put(Node.CHILDREN_ATTR, jSONArray);
        }
    }

    public static void e(String str, String str2) {
        LogUtil.QLog.e(str, 1, str2);
    }

    public static void logViewBaseHierarchy(@NonNull ViewBase viewBase, String str) {
        if (shouldLog()) {
            try {
                JSONObject jSONObject = new JSONObject();
                dumpViewBaseHierarchy(viewBase, jSONObject);
                d(str, "logViewBaseHierarchy: " + jSONObject.toString());
            } catch (Exception e16) {
                LogUtil.QLog.e(str, 1, "[logViewBaseHierarchy] ", e16);
            }
        }
    }

    public static boolean shouldLog() {
        return sShouldLog;
    }
}

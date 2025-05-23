package com.tencent.mobileqq.mutualmark.web;

import ab1.a;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.mutualmark.util.WebMutualMarkCardUpdateUtil;
import com.tencent.mobileqq.mutualmark.utils.c;
import com.tencent.mobileqq.mutualmark.widget.detailcard.MutualMarkDetailListHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.utils.b;
import com.tencent.util.k;
import f61.g;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class QQMutualMarkCrossEndHandler {
    private static final String TAG = "QQCrossEndDemoHandler";

    private void decodeMurualMarkGrade(MutualMarkModel mutualMarkModel, JSONObject jSONObject) throws JSONException {
        mutualMarkModel.Y = new ArrayList();
        JSONArray jSONArray = new JSONArray();
        if (jSONObject.has("graded")) {
            jSONArray = jSONObject.optJSONArray("graded");
        }
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                MutualMarkModel.Graded graded = new MutualMarkModel.Graded();
                if (jSONObject2.has("desc")) {
                    graded.f252171h = jSONObject2.optString("desc");
                }
                if (jSONObject2.has("name")) {
                    graded.f252169e = jSONObject2.optString("name");
                }
                if (jSONObject2.has("threshold")) {
                    graded.f252170f = jSONObject2.optInt("threshold");
                }
                if (jSONObject2.has("level")) {
                    graded.f252168d = jSONObject2.optInt("level");
                }
                mutualMarkModel.Y.add(graded);
                g.b(mutualMarkModel, mutualMarkModel.H, graded.f252168d, graded.f252169e);
            }
        }
    }

    private void decodeMurualMarkStatus(MutualMarkModel mutualMarkModel, JSONObject jSONObject) {
        if (jSONObject.has("dst_uin")) {
            mutualMarkModel.C = jSONObject.optLong("dst_uin");
        }
        if (jSONObject.has("level")) {
            mutualMarkModel.H = jSONObject.optInt("level");
        }
        if (jSONObject.has("sub_level")) {
            mutualMarkModel.I = jSONObject.optInt("sub_level");
        }
        if (jSONObject.has("count")) {
            mutualMarkModel.L = jSONObject.optInt("count");
        }
        if (jSONObject.has("is_wearing")) {
            mutualMarkModel.M = jSONObject.optBoolean("is_wearing");
        }
        if (jSONObject.has("is_lightup")) {
            mutualMarkModel.N = jSONObject.optBoolean("is_lightup");
        }
        if (jSONObject.has("is_degrade")) {
            mutualMarkModel.P = jSONObject.optBoolean("is_degrade");
        }
        if (jSONObject.has("is_prefetch")) {
            mutualMarkModel.Q = jSONObject.optBoolean("is_prefetch");
        }
        if (jSONObject.has("is_lightoff")) {
            mutualMarkModel.R = jSONObject.optBoolean("is_lightoff");
        }
    }

    private void decodeMutualMarkButton(MutualMarkModel mutualMarkModel, JSONObject jSONObject) throws JSONException {
        mutualMarkModel.Z = new ArrayList();
        JSONArray jSONArray = new JSONArray();
        if (jSONObject.has("action")) {
            jSONArray = jSONObject.optJSONArray("action");
        }
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                MutualMarkModel.Button button = new MutualMarkModel.Button();
                if (jSONObject2.has("name")) {
                    button.f252162d = jSONObject2.optString("name");
                }
                if (jSONObject2.has("text")) {
                    button.f252163e = jSONObject2.optString("text");
                }
                if (jSONObject2.has("url")) {
                    button.f252164f = jSONObject2.optString("url");
                }
                if (jSONObject2.has("react_button_name")) {
                    button.f252165h = jSONObject2.optString("react_button_name");
                }
                if (jSONObject2.has("hide")) {
                    button.f252166i = jSONObject2.optBoolean("hide");
                }
                if (jSONObject2.has("style")) {
                    button.f252167m = jSONObject2.optInt("style");
                }
                mutualMarkModel.Z.add(button);
            }
        }
    }

    private void decodeMutualMarkInfo(MutualMarkModel mutualMarkModel, JSONObject jSONObject) {
        if (jSONObject.has("id")) {
            mutualMarkModel.D = jSONObject.optLong("id");
        }
        if (jSONObject.has("category")) {
            mutualMarkModel.F = jSONObject.optInt("category");
        }
        if (jSONObject.has("rarity")) {
            mutualMarkModel.G = jSONObject.optInt("rarity");
        } else {
            mutualMarkModel.G = 0;
        }
        if (jSONObject.has("icon_format")) {
            mutualMarkModel.U = jSONObject.optString("icon_format");
        }
    }

    private void getEnterNewMutualMarkMainPageTime(JSONObject jSONObject, a aVar) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", 0);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("enter_time", c.d().f());
            jSONObject3.put("x_time_show_guid", c.f252290b);
            jSONObject2.put("data", jSONObject3);
            aVar.f(jSONObject2);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "getEnterNewMutualMarkMainPageTime, callback=" + jSONObject2.toString());
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private void getMutualMarkTABValue(JSONObject jSONObject, a aVar) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", 0);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("tab_value", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isElegantVersion() ? 1 : 0);
            jSONObject2.put("data", jSONObject3);
            aVar.f(jSONObject2);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "getMutualMarkTABValue, callback=" + jSONObject2.toString());
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private void getUnsafeLocalCache(JSONObject jSONObject, a aVar) {
        if (jSONObject == null) {
            return;
        }
        try {
            String str = "";
            if (jSONObject.has("key")) {
                str = jSONObject.getString("key");
            }
            int unsafeLocalCache = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getUnsafeLocalCache(str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", 0);
            jSONObject2.put("data", unsafeLocalCache);
            aVar.f(jSONObject2);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private void increaseEnterNewMutualMarkMainPageTime(JSONObject jSONObject, a aVar) {
        if (jSONObject == null) {
            return;
        }
        c.d().a();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "increaseEnterNewMutualMarkMainPageTime, IntimateElegantPageShowTimes=" + c.d().f());
        }
        try {
            int i3 = jSONObject.has("has_show_guid") ? jSONObject.getInt("has_show_guid") : -1;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "increaseEnterNewMutualMarkMainPageTime, has_show_guid=" + i3);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", 0);
            jSONObject2.put("data", new JSONObject());
            aVar.f(jSONObject2);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private void showMutualMarkDetail(JSONObject jSONObject, a aVar) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (jSONObject == null) {
            return;
        }
        QLog.i(TAG, 1, "showMutualMarkDetail invoke: " + k.f(jSONObject, Arrays.asList("name", "intro", "desc")));
        ArrayList arrayList = new ArrayList();
        MutualMarkModel mutualMarkModel = new MutualMarkModel();
        try {
            optJSONObject = jSONObject.has("info") ? jSONObject.optJSONObject("info") : null;
            optJSONObject2 = jSONObject.has("status") ? jSONObject.optJSONObject("status") : null;
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        if (optJSONObject != null && optJSONObject2 != null) {
            decodeMutualMarkInfo(mutualMarkModel, optJSONObject);
            decodeMurualMarkStatus(mutualMarkModel, optJSONObject2);
            decodeMurualMarkGrade(mutualMarkModel, optJSONObject);
            decodeMutualMarkButton(mutualMarkModel, optJSONObject2);
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isNewIcon(true, String.valueOf(mutualMarkModel.C), mutualMarkModel);
            mutualMarkModel.f252159h = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getIconUrlFormat(mutualMarkModel);
            arrayList.add(mutualMarkModel);
            MutualMarkDetailListHelper mutualMarkDetailListHelper = new MutualMarkDetailListHelper(b.a(), arrayList, 0);
            mutualMarkDetailListHelper.w(aVar);
            mutualMarkDetailListHelper.A(b.a());
            WebMutualMarkCardUpdateUtil.b().c(mutualMarkDetailListHelper);
        }
    }

    private void setUnsafeLocalCache(JSONObject jSONObject, a aVar) {
        if (jSONObject == null) {
            return;
        }
        try {
            String str = (String) jSONObject.keys().next();
            ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).setUnsafeLocalCache(str, Integer.parseInt((String) jSONObject.get(str)));
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }
}

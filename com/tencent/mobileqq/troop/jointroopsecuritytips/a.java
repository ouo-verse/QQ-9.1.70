package com.tencent.mobileqq.troop.jointroopsecuritytips;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.jointroopsecuritytips.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<Integer, c> f297551a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f297551a = new HashMap<>();
        }
    }

    private boolean c(c cVar) {
        List<c.a> list;
        if (cVar != null && !TextUtils.isEmpty(cVar.f297555b) && !TextUtils.isEmpty(cVar.f297556c) && (list = cVar.f297557d) != null && list.size() != 0) {
            for (int i3 = 0; i3 < cVar.f297557d.size(); i3++) {
                c.a aVar = cVar.f297557d.get(i3);
                if (aVar != null) {
                    if (TextUtils.isEmpty(aVar.f297558a)) {
                        return true;
                    }
                    if ("web".equals(aVar.f297559b) && TextUtils.isEmpty(aVar.f297560c)) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static a d(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("JoinTroopSecurityTipsConfig.config", 2, "content : " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap<Integer, c> hashMap = new HashMap<>();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(SensorJsPlugin.SENSOR_INTERVAL_UI);
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    if (jSONObject != null) {
                        c cVar = new c();
                        cVar.f297554a = jSONObject.optInt("id", 0);
                        cVar.f297555b = jSONObject.optString("title", "");
                        cVar.f297556c = jSONObject.optString("text", "");
                        JSONArray jSONArray2 = jSONObject.getJSONArray("btns");
                        if (jSONArray2 != null && jSONArray2.length() > 0) {
                            for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                                JSONObject jSONObject2 = jSONArray2.getJSONObject(i16);
                                if (jSONObject2 != null) {
                                    c.a aVar = new c.a();
                                    aVar.f297558a = jSONObject2.optString("text", "");
                                    aVar.f297559b = jSONObject2.optString("action", "");
                                    aVar.f297560c = jSONObject2.optString("url", "");
                                    cVar.f297557d.add(aVar);
                                }
                            }
                        }
                        hashMap.put(Integer.valueOf(cVar.f297554a), cVar);
                    }
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        a aVar2 = new a();
        aVar2.f297551a = hashMap;
        return aVar2;
    }

    public c a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (c) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        c cVar = new c();
        cVar.f297554a = 0;
        cVar.f297555b = context.getString(R.string.f161561y2);
        cVar.f297556c = context.getString(R.string.f161551y1);
        c.a aVar = new c.a();
        aVar.f297558a = context.getString(R.string.f161541y0);
        cVar.f297557d.add(aVar);
        return cVar;
    }

    public c b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        c cVar = this.f297551a.get(Integer.valueOf(i3));
        if (c(cVar)) {
            if (QLog.isColorLevel()) {
                QLog.d("JoinTroopSecurityTipsConfig.config", 2, "getItem isInvalidItem");
            }
            return null;
        }
        return cVar;
    }
}

package com.tencent.mobileqq.troop.handler;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private List<String> f296258a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f296258a = new ArrayList();
        }
    }

    public static a a(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopInfoHandlerConfig", 2, "content : " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("FieldsFor88d");
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList.add(jSONArray.getString(i3));
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        a aVar = new a();
        aVar.f296258a = arrayList;
        if (QLog.isColorLevel()) {
            QLog.d("TroopInfoHandlerConfig", 2, "tempGrayList.size : " + arrayList.size());
        }
        return aVar;
    }
}

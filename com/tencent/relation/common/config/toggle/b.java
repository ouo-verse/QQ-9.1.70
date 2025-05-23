package com.tencent.relation.common.config.toggle;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public static boolean a(int i3) {
        c cVar = c.X;
        boolean g16 = cVar.g(false);
        if (QLog.isColorLevel()) {
            QLog.i("BusinessFor0x5ebManagerToggle", 1, String.format("mergeSyncMsg:%b businessType:%s", Boolean.valueOf(g16), String.valueOf(i3)));
        }
        if (!g16) {
            return false;
        }
        JSONObject c16 = cVar.c();
        if (c16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("BusinessFor0x5ebManagerToggle", 1, "null == jsonObject");
            }
            return true;
        }
        boolean has = c16.has("blackList");
        if (QLog.isColorLevel()) {
            QLog.i("BusinessFor0x5ebManagerToggle", 1, String.format("exitBlackList:%b businessType:%s", Boolean.valueOf(has), String.valueOf(i3)));
        }
        if (has) {
            try {
                JSONArray jSONArray = c16.getJSONArray("blackList");
                if (QLog.isColorLevel()) {
                    QLog.d("BusinessFor0x5ebManagerToggle", 1, String.format("jsonArray:%s", jSONArray.toString()));
                }
                new a();
                if (com.tencent.mobileqq.jsonconverter.a.d(jSONArray, a.class.getGenericSuperclass()) != null) {
                    return !r0.contains(Integer.valueOf(i3));
                }
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("BusinessFor0x5ebManagerToggle", 1, String.format("e:%s", e16.toString()));
                }
            }
        }
        return true;
    }
}

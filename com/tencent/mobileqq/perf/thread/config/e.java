package com.tencent.mobileqq.perf.thread.config;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public Map<Integer, JSONObject> f258140d;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f258140d = new HashMap();
        }
    }

    public static e a(String str) {
        e eVar = new e();
        if (str != null && str.length() > 0) {
            QLog.d("ThreadPoolMonitorBean", 2, "[config] parse: invoked. ", " content: ", str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("normal")) {
                    eVar.f258140d.put(16, jSONObject.getJSONObject("normal"));
                }
            } catch (JSONException e16) {
                QLog.e("ThreadPoolMonitorBean", 1, e16, new Object[0]);
            }
        }
        return eVar;
    }
}

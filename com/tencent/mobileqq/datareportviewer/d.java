package com.tencent.mobileqq.datareportviewer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<c> f203354c;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static d c(JSONObject jSONObject) {
        d dVar = new d();
        dVar.f203342a = jSONObject.optString(VipFunCallConstants.KEY_GROUP);
        JSONArray optJSONArray = jSONObject.optJSONArray(Constants.Configs.CONFIGS);
        dVar.f203354c = new ArrayList<>(optJSONArray.length());
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            c c16 = c.c(optJSONArray.optJSONObject(i3));
            c16.f203352d = dVar;
            dVar.f203354c.add(c16);
        }
        return dVar;
    }

    @Override // com.tencent.mobileqq.datareportviewer.a
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.datareportviewer.a
    public JSONObject b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(VipFunCallConstants.KEY_GROUP, this.f203342a);
            jSONObject.put("isChecked", this.f203343b);
            JSONArray jSONArray = new JSONArray();
            Iterator<c> it = this.f203354c.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next().b());
            }
            jSONObject.put(Constants.Configs.CONFIGS, jSONArray);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }
}

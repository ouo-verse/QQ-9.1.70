package com.tencent.ams.mosaic;

import android.text.TextUtils;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h implements IEventCenter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final List<i> f70652a;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f70652a = new CopyOnWriteArrayList();
        }
    }

    public static List<Object> c(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            Object obj = jSONArray.get(i3);
            if (obj instanceof JSONArray) {
                obj = c((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = d((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static Map<String, Object> d(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object opt = jSONObject.opt(str);
            if (opt instanceof JSONArray) {
                opt = c((JSONArray) opt);
            } else if (opt instanceof JSONObject) {
                opt = d((JSONObject) opt);
            }
            hashMap.put(str, opt);
        }
        return hashMap;
    }

    public void a(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iVar);
        } else if (iVar != null) {
            this.f70652a.add(iVar);
        }
    }

    public void b(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gVar);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a(Event.TAG, "sendEvent key: " + gVar.a() + ", msg: " + gVar.b() + ", params: " + gVar.c());
        Iterator<i> it = this.f70652a.iterator();
        while (it.hasNext()) {
            it.next().onEvent(gVar);
        }
    }

    public void e(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iVar);
        } else if (iVar != null) {
            this.f70652a.remove(iVar);
        }
    }

    @Override // com.tencent.ams.mosaic.IEventCenter
    public void sendEvent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("key");
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            if (!TextUtils.isEmpty(optString) && optJSONObject != null) {
                b(new g(optString, d(optJSONObject)));
                return;
            }
            com.tencent.ams.mosaic.utils.f.h(Event.TAG, "sendEvent failed, invalid event content: " + str);
        } catch (JSONException e16) {
            com.tencent.ams.mosaic.utils.f.i(Event.TAG, "sendEvent failed: " + str, e16);
        }
    }
}

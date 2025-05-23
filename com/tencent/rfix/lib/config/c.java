package com.tencent.rfix.lib.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.utils.ManifestUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final int f364934a;

    /* renamed from: b, reason: collision with root package name */
    private final String f364935b;

    /* renamed from: c, reason: collision with root package name */
    private final List<a> f364936c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, String> f364937d;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f364938a;

        /* renamed from: b, reason: collision with root package name */
        public String f364939b;

        /* renamed from: c, reason: collision with root package name */
        public String f364940c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public c(int i3, String str) throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
            return;
        }
        this.f364934a = i3;
        this.f364935b = str;
        this.f364936c = new ArrayList();
        this.f364937d = new HashMap();
        e();
    }

    private void e() throws JSONException {
        JSONObject optJSONObject;
        JSONObject jSONObject = new JSONObject(this.f364935b);
        JSONArray optJSONArray = jSONObject.optJSONArray(DKConfiguration.Directory.RESOURCES);
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                if (optJSONObject2 != null) {
                    a aVar = new a();
                    aVar.f364938a = optJSONObject2.optString("url");
                    aVar.f364939b = optJSONObject2.optString("md5");
                    aVar.f364940c = optJSONObject2.optString("identify_id");
                    this.f364936c.add(aVar);
                }
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("custom_content");
        if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("data")) != null) {
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                this.f364937d.put(str, optJSONObject.optString(str));
            }
        }
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f364934a;
    }

    public a b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        String manifestPatchId = ManifestUtils.getManifestPatchId(context);
        Iterator<a> it = this.f364936c.iterator();
        while (true) {
            if (it.hasNext()) {
                a next = it.next();
                if (!TextUtils.isEmpty(next.f364940c)) {
                    for (String str : next.f364940c.split(",")) {
                        if (TextUtils.equals(manifestPatchId, str)) {
                            return next;
                        }
                    }
                }
            } else {
                RFixLog.e("RFix.RDeliveryConfig", "getMatchResource no one match, return first.");
                if (this.f364936c.isEmpty()) {
                    return null;
                }
                return this.f364936c.get(0);
            }
        }
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String str = this.f364937d.get("patch_process");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length == 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (String str2 : split) {
            String trim = str2.trim();
            if (!TextUtils.isEmpty(trim)) {
                arrayList.add(trim);
            }
        }
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = true;
        for (String str3 : arrayList) {
            if (z16) {
                sb5.append(str3);
                z16 = false;
            } else {
                sb5.append("|");
                sb5.append(str3);
            }
        }
        return sb5.toString();
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f364934a > 0 && !TextUtils.isEmpty(this.f364935b) && !this.f364936c.isEmpty()) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "RDeliveryConfig{configId=" + this.f364934a + ", content='" + this.f364935b + "'}";
    }
}

package com.tencent.qqnt.doutu;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes24.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f356104a;

    /* renamed from: b, reason: collision with root package name */
    public a f356105b;

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f356106a;

        /* renamed from: b, reason: collision with root package name */
        public String f356107b;

        /* renamed from: c, reason: collision with root package name */
        public String f356108c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<String> f356109d;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<String> f356110e;

        /* renamed from: f, reason: collision with root package name */
        public String f356111f;

        /* renamed from: g, reason: collision with root package name */
        public String f356112g;

        /* renamed from: h, reason: collision with root package name */
        public String f356113h;

        /* renamed from: i, reason: collision with root package name */
        public String f356114i;

        /* renamed from: j, reason: collision with root package name */
        public String f356115j;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public JSONObject a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("user_id", this.f356105b.f356106a);
            jSONObject2.put("source_md5", this.f356105b.f356107b);
            jSONObject2.put(AppConstants.Key.SHARE_SOURCE_URL, this.f356105b.f356108c);
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.f356105b.f356109d.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next());
            }
            jSONObject2.put("expose_md5s", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            Iterator<String> it5 = this.f356105b.f356110e.iterator();
            while (it5.hasNext()) {
                jSONArray2.mo162put(it5.next());
            }
            jSONObject2.put("expose_urls", jSONArray2);
            jSONObject2.put("click_md5", this.f356105b.f356111f);
            jSONObject2.put("click_url", this.f356105b.f356112g);
            jSONObject2.put("aio_type", this.f356105b.f356113h);
            jSONObject2.put("mobile_type", this.f356105b.f356114i);
            jSONObject2.put("to_user_id", this.f356105b.f356115j);
            jSONObject.put("dcId", this.f356104a);
            jSONObject.put("data", jSONObject2);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("DoutuReportData", 2, "convert error:" + e16);
            }
        }
        return jSONObject;
    }
}

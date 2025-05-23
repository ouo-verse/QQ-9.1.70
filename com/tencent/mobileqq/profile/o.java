package com.tencent.mobileqq.profile;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static o f260268b;

    /* renamed from: a, reason: collision with root package name */
    public SparseArray<a> f260269a;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f260270a;

        /* renamed from: b, reason: collision with root package name */
        public String f260271b;

        /* renamed from: c, reason: collision with root package name */
        public String f260272c;

        /* renamed from: d, reason: collision with root package name */
        public int f260273d;

        /* renamed from: e, reason: collision with root package name */
        public b f260274e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f260275a;

        /* renamed from: b, reason: collision with root package name */
        public int f260276b;

        /* renamed from: c, reason: collision with root package name */
        public String f260277c;

        /* renamed from: d, reason: collision with root package name */
        public int f260278d;

        /* renamed from: e, reason: collision with root package name */
        public int f260279e;

        /* renamed from: f, reason: collision with root package name */
        public String f260280f;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean a() {
        if (f260268b == null) {
            if (!p.d(VasUpdateConstants.SCID_WZRY_TEMPLATE)) {
                p.a(null);
                return false;
            }
            return b(p.c() + "xydata.json");
        }
        return true;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e("VipWZRYTemplateConfig", 2, "configPath = " + str);
            }
            return false;
        }
        try {
            String readFileToString = FileUtils.readFileToString(new File(str));
            if (TextUtils.isEmpty(readFileToString)) {
                QLog.e("VipWZRYTemplateConfig", 1, str + " content is empty.");
                return false;
            }
            o oVar = new o();
            JSONArray optJSONArray = new JSONObject(readFileToString).optJSONArray("cardWZResourceGrade");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                oVar.f260269a = new SparseArray<>();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        a aVar = new a();
                        aVar.f260270a = optJSONObject.optInt("wz_id");
                        aVar.f260271b = optJSONObject.optString("wz_name");
                        aVar.f260272c = optJSONObject.optString("wz_format");
                        aVar.f260273d = optJSONObject.optInt("position_type", 1);
                        if (optJSONObject.has("wz_icon")) {
                            b bVar = new b();
                            JSONObject jSONObject = optJSONObject.getJSONObject("wz_icon");
                            bVar.f260275a = jSONObject.optString("src");
                            bVar.f260276b = jSONObject.optInt("size");
                            bVar.f260277c = jSONObject.optString("md5");
                            bVar.f260278d = jSONObject.optInt("width");
                            bVar.f260279e = jSONObject.optInt("height");
                            bVar.f260280f = jSONObject.optString("mainColor");
                            aVar.f260274e = bVar;
                        }
                        oVar.f260269a.put(aVar.f260270a, aVar);
                    }
                }
            }
            f260268b = oVar;
            return true;
        } catch (Exception e16) {
            QLog.e("VipWZRYTemplateConfig", 1, e16.getMessage());
            return false;
        }
    }
}

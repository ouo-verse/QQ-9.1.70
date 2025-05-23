package com.tencent.mobileqq.dating;

import android.text.TextUtils;
import appoint.define.appoint_define$StrangerInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f203419a;

    /* renamed from: b, reason: collision with root package name */
    public String f203420b;

    /* renamed from: c, reason: collision with root package name */
    public int f203421c;

    /* renamed from: d, reason: collision with root package name */
    public int f203422d;

    /* renamed from: e, reason: collision with root package name */
    public int f203423e;

    /* renamed from: f, reason: collision with root package name */
    public String f203424f;

    /* renamed from: g, reason: collision with root package name */
    public int f203425g;

    /* renamed from: h, reason: collision with root package name */
    public int f203426h;

    /* renamed from: i, reason: collision with root package name */
    public int f203427i;

    /* renamed from: j, reason: collision with root package name */
    public String f203428j;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f203419a = 0L;
        this.f203421c = 0;
        this.f203422d = 0;
        this.f203423e = 0;
        this.f203424f = "";
        this.f203425g = 0;
        this.f203426h = 0;
        this.f203427i = 0;
        this.f203428j = "";
    }

    public static e a(appoint_define$StrangerInfo appoint_define_strangerinfo) {
        if (appoint_define_strangerinfo != null && appoint_define_strangerinfo.uint64_tinyid.get() != 0) {
            e eVar = new e();
            if (appoint_define_strangerinfo.uint64_tinyid.has()) {
                eVar.f203419a = appoint_define_strangerinfo.uint64_tinyid.get();
            }
            if (appoint_define_strangerinfo.uint32_age.has()) {
                eVar.f203421c = appoint_define_strangerinfo.uint32_age.get();
            }
            if (appoint_define_strangerinfo.uint32_gender.has()) {
                eVar.f203422d = appoint_define_strangerinfo.uint32_gender.get();
            }
            if (appoint_define_strangerinfo.bytes_nickname.has()) {
                eVar.f203420b = appoint_define_strangerinfo.bytes_nickname.get().toStringUtf8();
            }
            if (appoint_define_strangerinfo.uint32_dating.has()) {
                eVar.f203423e = appoint_define_strangerinfo.uint32_dating.get();
            }
            if (appoint_define_strangerinfo.uint32_list_idx.has()) {
                eVar.f203427i = appoint_define_strangerinfo.uint32_list_idx.get();
            }
            if (appoint_define_strangerinfo.str_constellation.has()) {
                eVar.f203424f = appoint_define_strangerinfo.str_constellation.get();
            }
            if (appoint_define_strangerinfo.uint32_profession.has()) {
                eVar.f203425g = appoint_define_strangerinfo.uint32_profession.get();
            }
            if (appoint_define_strangerinfo.uint32_marriage.has()) {
                eVar.f203426h = appoint_define_strangerinfo.uint32_marriage.get();
            }
            if (appoint_define_strangerinfo.str_vipinfo.has()) {
                eVar.f203428j = appoint_define_strangerinfo.str_vipinfo.get();
            }
            return eVar;
        }
        return null;
    }

    public static String b(List<e> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<e> it = list.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                JSONObject c16 = c(it.next());
                if (c16 != null) {
                    jSONArray.mo162put(c16);
                    i3++;
                }
                if (i3 >= 20) {
                    break;
                }
            }
            return jSONArray.toString();
        }
        return "";
    }

    public static JSONObject c(e eVar) {
        if (eVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("open_id", eVar.f203419a);
            jSONObject.put("nickname", eVar.f203420b);
            jSONObject.put("age", eVar.f203421c);
            jSONObject.put("gender", eVar.f203422d);
            jSONObject.put("state", eVar.f203423e);
            jSONObject.put(LpReport_UserInfo_dc02148.CONSTELLATION, eVar.f203424f);
            jSONObject.put(IProfileProtocolConst.KEY_PROFESSION, eVar.f203425g);
            jSONObject.put("emotion", eVar.f203426h);
            jSONObject.put("listIdx", eVar.f203427i);
            jSONObject.put("vip", eVar.f203428j);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    public static void d(List<e> list, String str) {
        if (list != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    e e16 = e(jSONArray.getJSONObject(i3));
                    if (e16 != null) {
                        list.add(e16);
                    }
                }
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
    }

    public static e e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        e eVar = new e();
        try {
            eVar.f203419a = jSONObject.getLong("open_id");
            eVar.f203420b = jSONObject.getString("nickname");
            eVar.f203421c = jSONObject.getInt("age");
            eVar.f203422d = jSONObject.getInt("gender");
            eVar.f203423e = jSONObject.getInt("state");
            try {
                eVar.f203424f = jSONObject.getString(LpReport_UserInfo_dc02148.CONSTELLATION);
                eVar.f203425g = jSONObject.getInt(IProfileProtocolConst.KEY_PROFESSION);
                eVar.f203426h = jSONObject.getInt("emotion");
                eVar.f203427i = jSONObject.getInt("listIdx");
                eVar.f203428j = jSONObject.getString("vip");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return eVar;
        } catch (JSONException e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass() || ((e) obj).f203419a != this.f203419a) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return Long.valueOf(this.f203419a).hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "[" + this.f203419a + "," + this.f203420b + "," + this.f203421c + "," + this.f203422d + "," + this.f203423e + "," + this.f203424f + "," + this.f203425g + "," + this.f203426h + "," + this.f203427i + "," + this.f203428j + "]";
    }
}

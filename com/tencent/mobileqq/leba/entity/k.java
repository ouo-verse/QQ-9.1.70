package com.tencent.mobileqq.leba.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.leba.pb.UserSetDynamicPlugin$PluginData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private List<l> f240496a;

    /* renamed from: b, reason: collision with root package name */
    public long f240497b;

    /* renamed from: c, reason: collision with root package name */
    private final a f240498c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        void a(String str, List<l> list) {
            String str2;
            LinkedList<l> linkedList = new LinkedList(list);
            String str3 = "LebaPluginSetting";
            int i3 = 1;
            if (linkedList.isEmpty()) {
                QLog.i("LebaPluginSetting", 1, str + " list empty");
                return;
            }
            StringBuilder sb5 = new StringBuilder(str);
            sb5.append(" size: ");
            StringBuilder sb6 = new StringBuilder(str);
            sb6.append(" show: ");
            StringBuilder sb7 = new StringBuilder(str);
            sb7.append(" hide: ");
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            for (l lVar : linkedList) {
                if (lVar == null) {
                    i18++;
                } else {
                    int i26 = lVar.f240500b;
                    if (i26 == i3) {
                        str2 = str3;
                        sb6.append(lVar.f240499a);
                        sb6.append(" v");
                        sb6.append(lVar.f240501c);
                        sb6.append("|");
                        i16++;
                    } else {
                        str2 = str3;
                        if (i26 == 2) {
                            sb7.append(lVar.f240499a);
                            sb7.append(" v");
                            sb7.append(lVar.f240501c);
                            sb7.append("|");
                            i17++;
                        } else {
                            i19++;
                        }
                    }
                    str3 = str2;
                    i3 = 1;
                }
            }
            String str4 = str3;
            sb5.append(linkedList.size());
            sb5.append(" show:");
            sb5.append(i16);
            sb5.append(" hide:");
            sb5.append(i17);
            if (i18 > 0) {
                sb5.append(" show:");
                sb5.append(i18);
            }
            if (i19 > 0) {
                sb5.append(" show:");
                sb5.append(i19);
            }
            QLog.d(str4, 1, sb5.toString());
            QLog.d(str4, 1, sb6.toString());
            QLog.d(str4, 1, sb7.toString());
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f240498c = new a();
        }
    }

    public static k b(String str, String str2) {
        k kVar = new k();
        if (TextUtils.isEmpty(str)) {
            QLog.i("LebaPluginSetting", 1, "changeFormJson fail TextUtils.isEmpty(json)");
            return kVar;
        }
        try {
            kVar.f240496a = new ArrayList();
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("json_key_items");
            kVar.f240497b = jSONObject.optLong("json_key_sequence");
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                l lVar = new l(jSONObject2.optLong("json_key_plugin_id"), jSONObject2.optInt("json_key_plugin_type"), jSONObject2.optInt("json_key_plugin_version", 0));
                if (!kVar.f240496a.contains(lVar)) {
                    kVar.f240496a.add(lVar);
                }
            }
        } catch (Exception e16) {
            QLog.i("LebaPluginSetting", 1, "changeFormJson fail json=" + str, e16);
        }
        kVar.i("changeFormJson[" + str2 + "]");
        return kVar;
    }

    public static k c(List<UserSetDynamicPlugin$PluginData> list, long j3) {
        k kVar = new k();
        kVar.f240497b = j3;
        if (list == null) {
            return kVar;
        }
        kVar.f240496a = new ArrayList();
        for (UserSetDynamicPlugin$PluginData userSetDynamicPlugin$PluginData : list) {
            if (userSetDynamicPlugin$PluginData != null) {
                l lVar = new l(userSetDynamicPlugin$PluginData.f240727id.get(), userSetDynamicPlugin$PluginData.type.get(), userSetDynamicPlugin$PluginData.version.get());
                if (!kVar.f240496a.contains(lVar)) {
                    kVar.f240496a.add(lVar);
                }
            }
        }
        kVar.i("changeFormPb");
        return kVar;
    }

    public static String d(k kVar, String str) {
        List<l> list;
        if (kVar != null && (list = kVar.f240496a) != null && !list.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (l lVar : kVar.f240496a) {
                    if (lVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("json_key_plugin_id", lVar.f240499a);
                        jSONObject.put("json_key_plugin_type", lVar.f240500b);
                        jSONObject.put("json_key_plugin_version", lVar.f240501c);
                        jSONArray.mo162put(jSONObject);
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("json_key_items", jSONArray);
                jSONObject2.put("json_key_sequence", kVar.f240497b);
                String jSONObject3 = jSONObject2.toString();
                kVar.i("changeToJson[" + str + "]");
                return jSONObject3;
            } catch (Exception e16) {
                QLog.i("LebaPluginSetting", 1, "changeToJson fail ", e16);
                return "";
            }
        }
        QLog.i("LebaPluginSetting", 1, "changeToJson fail setting == null || setting.items == null || setting.items.isEmpty()");
        return "";
    }

    public static List<UserSetDynamicPlugin$PluginData> e(k kVar) {
        List<l> list;
        ArrayList arrayList = new ArrayList();
        if (kVar != null && (list = kVar.f240496a) != null) {
            for (l lVar : list) {
                UserSetDynamicPlugin$PluginData userSetDynamicPlugin$PluginData = new UserSetDynamicPlugin$PluginData();
                userSetDynamicPlugin$PluginData.f240727id.set((int) lVar.f240499a);
                userSetDynamicPlugin$PluginData.type.set(lVar.f240500b);
                userSetDynamicPlugin$PluginData.version.set(lVar.f240501c);
                arrayList.add(userSetDynamicPlugin$PluginData);
            }
        }
        return arrayList;
    }

    public void a(l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) lVar);
        } else if (lVar != null && !this.f240496a.contains(lVar)) {
            this.f240496a.add(lVar);
        }
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        List<l> list = this.f240496a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<l> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new LinkedList(this.f240496a);
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (this.f240496a == null) {
            this.f240496a = new ArrayList();
        }
    }

    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f240498c.a(str, this.f240496a);
        }
    }

    public void j(l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) lVar);
        } else {
            if (lVar == null) {
                return;
            }
            this.f240496a.remove(lVar);
        }
    }
}

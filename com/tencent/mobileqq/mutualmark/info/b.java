package com.tencent.mobileqq.mutualmark.info;

import com.tencent.mobileqq.mutualmark.g;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f252068a;

    /* renamed from: b, reason: collision with root package name */
    public String f252069b;

    /* renamed from: c, reason: collision with root package name */
    public int f252070c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f252071d;

    /* renamed from: e, reason: collision with root package name */
    public int f252072e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f252073f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<C8128b> f252074g;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f252075a;

        /* renamed from: b, reason: collision with root package name */
        public String f252076b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            aVar.f252075a = jSONObject.optString("name");
            aVar.f252076b = new String(PluginBaseInfoHelper.Base64Helper.decode(jSONObject.optString("iconUrl"), 0));
            return aVar;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "name=" + this.f252075a + "|iconUrl=" + this.f252076b + "|";
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.mutualmark.info.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C8128b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f252077a;

        /* renamed from: b, reason: collision with root package name */
        public String f252078b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f252079c;

        /* renamed from: d, reason: collision with root package name */
        public long f252080d;

        /* renamed from: e, reason: collision with root package name */
        public long f252081e;

        /* renamed from: f, reason: collision with root package name */
        public String f252082f;

        /* renamed from: g, reason: collision with root package name */
        public b f252083g;

        /* renamed from: h, reason: collision with root package name */
        public ArrayList<a> f252084h;

        public C8128b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f252079c = true;
            }
        }

        public static C8128b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            C8128b c8128b = new C8128b();
            try {
                String optString = jSONObject.optString("id");
                c8128b.f252077a = optString;
                c8128b.f252080d = g.i(optString);
                c8128b.f252081e = g.g(c8128b.f252077a);
                c8128b.f252078b = jSONObject.optString("name");
                c8128b.f252082f = jSONObject.optString("Android_iconPath");
                c8128b.f252079c = true;
                if (jSONObject.has("subLevelInfo")) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("subLevelInfo");
                    if (optJSONArray == null) {
                        return c8128b;
                    }
                    c8128b.f252084h = new ArrayList<>();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        a a16 = a.a(optJSONArray.getJSONObject(i3));
                        if (a16 != null) {
                            c8128b.f252084h.add(a16);
                        }
                    }
                }
                return c8128b;
            } catch (Exception e16) {
                QLog.e("MutualMarkConfigIRType", 1, "parse error->" + e16.toString());
                return null;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "id=" + this.f252077a + "|type=" + this.f252080d + "|level=" + this.f252081e + "|name=" + this.f252078b + "|iconPath=" + this.f252082f + "|enable=" + this.f252079c + "|subLevelInfoArrayList=" + this.f252084h + "|";
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f252070c = -1;
        this.f252071d = false;
        this.f252072e = 999;
    }

    public static b f(JSONObject jSONObject) {
        boolean z16;
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        try {
            bVar.f252068a = jSONObject.optLong("type");
            bVar.f252069b = jSONObject.optString("cluster");
            if (jSONObject.has("disableLocalResource")) {
                if (jSONObject.optInt("disableLocalResource") == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar.f252073f = z16;
            }
            if (jSONObject.has("typeItem")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("typeItem");
                if (optJSONArray == null) {
                    return bVar;
                }
                bVar.f252074g = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    C8128b a16 = C8128b.a(optJSONArray.getJSONObject(i3));
                    if (a16 != null) {
                        bVar.f252074g.add(a16);
                        a16.f252083g = bVar;
                    }
                }
            }
            return bVar;
        } catch (Exception e16) {
            QLog.e("MutualMarkConfigIRType", 1, "parse error->" + e16.toString());
            return null;
        }
    }

    public long a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, j3)).longValue();
        }
        ArrayList<C8128b> arrayList = this.f252074g;
        long j16 = -1;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<C8128b> it = this.f252074g.iterator();
            while (it.hasNext()) {
                C8128b next = it.next();
                if (next != null && next.f252079c) {
                    long j17 = next.f252081e;
                    if (j17 <= j3) {
                        j16 = j17;
                    }
                }
            }
        }
        return j16;
    }

    public C8128b b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (C8128b) iPatchRedirector.redirect((short) 2, (Object) this, j3);
        }
        ArrayList<C8128b> arrayList = this.f252074g;
        if (arrayList != null) {
            Iterator<C8128b> it = arrayList.iterator();
            while (it.hasNext()) {
                C8128b next = it.next();
                if (next != null && next.f252081e == j3) {
                    return next;
                }
            }
            return null;
        }
        return null;
    }

    public String c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, j3);
        }
        C8128b b16 = b(j3);
        if (b16 != null) {
            return b16.f252078b;
        }
        return "";
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        ArrayList<C8128b> arrayList = this.f252074g;
        if (arrayList != null) {
            Iterator<C8128b> it = arrayList.iterator();
            while (it.hasNext()) {
                C8128b next = it.next();
                if (next != null && next.f252079c) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean e(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, j3)).booleanValue();
        }
        C8128b b16 = b(j3);
        if (b16 != null) {
            return b16.f252079c;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "MutualMarkConfigIRType{type=" + this.f252068a + ", cluster='" + this.f252069b + "', sortKeyForNormal=" + this.f252070c + ", isInAIOTitleLeft2=" + this.f252071d + ", sortKeyForAIOTitle=" + this.f252072e + ", disableLocalResource=" + this.f252073f + ", typeItems=" + this.f252074g + '}';
    }
}

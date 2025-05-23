package com.tencent.halley.common.a;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class h {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private JSONObject f113268a;

        /* compiled from: P */
        /* renamed from: com.tencent.halley.common.a.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        final class C1239a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public String f113269a;

            /* renamed from: b, reason: collision with root package name */
            public boolean f113270b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f113271c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f113272d;

            /* renamed from: e, reason: collision with root package name */
            public boolean f113273e;

            /* renamed from: f, reason: collision with root package name */
            public boolean f113274f;

            /* renamed from: g, reason: collision with root package name */
            public boolean f113275g;

            /* renamed from: i, reason: collision with root package name */
            private String[] f113277i;

            public C1239a(String str, int i3, String str2, String str3, String str4, String str5) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, a.this, str, Integer.valueOf(i3), str2, str3, str4, str5);
                    return;
                }
                this.f113270b = true;
                this.f113271c = false;
                this.f113272d = false;
                this.f113273e = false;
                this.f113274f = false;
                this.f113275g = false;
                this.f113269a = str;
                String[] split = str.split("-");
                if (split.length < 5) {
                    this.f113277i = new String[]{"all", "all", "all", "all", "all"};
                    for (int i16 = 0; i16 < split.length; i16++) {
                        this.f113277i[i16] = split[i16];
                    }
                } else {
                    this.f113277i = split;
                }
                this.f113271c = a(0, String.valueOf(i3));
                this.f113272d = a(1, str2);
                this.f113273e = a(2, str3);
                this.f113274f = a(3, str4);
                this.f113275g = a(4, str5);
                this.f113277i = null;
            }

            private boolean a(int i3, String str) {
                String[] strArr = this.f113277i;
                if (strArr.length < i3 + 1) {
                    return false;
                }
                boolean equals = strArr[i3].equals(str);
                if (!equals && !this.f113277i[i3].equals("all")) {
                    this.f113270b = false;
                }
                return equals;
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final synchronized String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            JSONObject jSONObject = this.f113268a;
            if (jSONObject == null) {
                return "";
            }
            return jSONObject.toString();
        }

        public final synchronized void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.f113268a = null;
            }
        }

        public final synchronized String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            JSONObject jSONObject = this.f113268a;
            if (jSONObject != null) {
                return jSONObject.optString("version");
            }
            return "";
        }

        /* JADX WARN: Code restructure failed: missing block: B:67:0x00fc, code lost:
        
            r1 = r3;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final synchronized String a(String str, int i3, String str2, String str3, String str4, String str5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str2, str3, str4, str5);
            }
            if (this.f113268a != null && !TextUtils.isEmpty(str)) {
                JSONObject optJSONObject = this.f113268a.optJSONObject("data");
                if (optJSONObject == null) {
                    return "";
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
                if (optJSONObject2 == null) {
                    return "";
                }
                ArrayList arrayList = new ArrayList();
                Iterator keys = optJSONObject2.keys();
                while (keys.hasNext()) {
                    String str6 = (String) keys.next();
                    if (!TextUtils.isEmpty(str6)) {
                        if (str6.equals("deviceid")) {
                            return optJSONObject2.optString("deviceid");
                        }
                        C1239a c1239a = new C1239a(str6, i3, str2, str3, str4, str5);
                        if (c1239a.f113270b) {
                            arrayList.add(c1239a);
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    return "";
                }
                if (arrayList.size() == 1) {
                    return optJSONObject2.optString(((C1239a) arrayList.get(0)).f113269a);
                }
                C1239a c1239a2 = (C1239a) arrayList.get(0);
                for (int i16 = 1; i16 < arrayList.size(); i16++) {
                    C1239a c1239a3 = (C1239a) arrayList.get(i16);
                    if (!c1239a2.f113270b || ((r4 = c1239a3.f113271c) == c1239a2.f113271c && (r4 = c1239a3.f113272d) == c1239a2.f113272d && (r4 = c1239a3.f113273e) == c1239a2.f113273e && (r4 = c1239a3.f113274f) == c1239a2.f113274f && (r4 = c1239a3.f113275g) == c1239a2.f113275g)) {
                        boolean z16 = true;
                    }
                }
                return optJSONObject2.optString(c1239a2.f113269a);
            }
            return "";
        }

        public final synchronized void a(String str) {
            JSONObject optJSONObject;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                return;
            }
            com.tencent.halley.common.utils.d.c("halley-cloud-SettingsQuerier", "received new json data:".concat(String.valueOf(str)));
            com.tencent.halley.common.utils.d.c("halley-cloud-SettingsQuerier", "old json data:" + this.f113268a);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (this.f113268a == null) {
                    this.f113268a = jSONObject;
                    return;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                String optString = jSONObject.optString("version");
                if (optJSONObject2 != null && !TextUtils.isEmpty(optString)) {
                    JSONObject optJSONObject3 = this.f113268a.optJSONObject("data");
                    if (optJSONObject3 == null) {
                        this.f113268a.putOpt("data", optJSONObject2);
                        this.f113268a.putOpt("version", optString);
                        return;
                    }
                    Iterator keys = optJSONObject2.keys();
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        if (!TextUtils.isEmpty(str2) && (optJSONObject = optJSONObject2.optJSONObject(str2)) != null) {
                            optJSONObject3.putOpt(str2, optJSONObject);
                        }
                    }
                    this.f113268a.putOpt("version", optString);
                    com.tencent.halley.common.utils.d.c("halley-cloud-SettingsQuerier", "updated json data:" + this.f113268a);
                }
            } catch (Throwable th5) {
                com.tencent.halley.common.utils.d.a("halley-cloud-SettingsQuerier", th5);
            }
        }
    }

    public static int a(String str, int i3, int i16, int i17) {
        int i18;
        try {
            String a16 = a(str, com.tencent.halley.common.a.c());
            if (TextUtils.isEmpty(a16)) {
                a16 = a(str, 0);
            }
            com.tencent.halley.common.utils.d.a("halley-cloud-SettingsQuerier", "querySetting " + str + ":" + a16);
            i18 = Integer.parseInt(a16);
        } catch (Throwable unused) {
            i18 = i17;
        }
        return com.tencent.halley.common.utils.j.a(i18, i3, i16, i17);
    }

    private static String a(String str, int i3) {
        return com.tencent.halley.common.d.h.d().e().a(str, i3, com.tencent.halley.common.a.d(), com.tencent.halley.common.a.f113172a, com.tencent.halley.common.d.b.a.b.a().a(c.b()), com.tencent.halley.common.d.i.a(c.h()));
    }
}

package com.tencent.gamecenter.wadl.sdk.common.b;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class g {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private JSONObject f107024a;

        /* compiled from: P */
        /* renamed from: com.tencent.gamecenter.wadl.sdk.common.b.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        private final class C1125a {

            /* renamed from: a, reason: collision with root package name */
            public String f107025a;

            /* renamed from: b, reason: collision with root package name */
            private String[] f107026b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f107027c = true;

            /* renamed from: d, reason: collision with root package name */
            public boolean f107028d;

            /* renamed from: e, reason: collision with root package name */
            public boolean f107029e;

            /* renamed from: f, reason: collision with root package name */
            public boolean f107030f;

            /* renamed from: g, reason: collision with root package name */
            public boolean f107031g;

            /* renamed from: h, reason: collision with root package name */
            public boolean f107032h;

            public C1125a(a aVar, String str, int i3, String str2, String str3, String str4, String str5) {
                this.f107028d = false;
                this.f107029e = false;
                this.f107030f = false;
                this.f107031g = false;
                this.f107032h = false;
                this.f107025a = str;
                String[] split = str.split("-");
                if (split.length < 5) {
                    this.f107026b = new String[]{"all", "all", "all", "all", "all"};
                    for (int i16 = 0; i16 < split.length; i16++) {
                        this.f107026b[i16] = split[i16];
                    }
                } else {
                    this.f107026b = split;
                }
                this.f107028d = a(0, "" + i3);
                this.f107029e = a(1, str2);
                this.f107030f = a(2, str3);
                this.f107031g = a(3, str4);
                this.f107032h = a(4, str5);
                this.f107026b = null;
            }

            private boolean a(int i3, String str) {
                String[] strArr = this.f107026b;
                if (strArr.length < i3 + 1) {
                    return false;
                }
                boolean equals = strArr[i3].equals(str);
                if (!equals && !this.f107026b[i3].equals("all")) {
                    this.f107027c = false;
                }
                return equals;
            }

            public boolean b(C1125a c1125a) {
                if (!c1125a.f107027c) {
                    return true;
                }
                boolean z16 = this.f107028d;
                if (z16 != c1125a.f107028d) {
                    return z16;
                }
                boolean z17 = this.f107029e;
                if (z17 != c1125a.f107029e) {
                    return z17;
                }
                boolean z18 = this.f107030f;
                if (z18 != c1125a.f107030f) {
                    return z18;
                }
                boolean z19 = this.f107031g;
                if (z19 != c1125a.f107031g) {
                    return z19;
                }
                boolean z26 = this.f107032h;
                if (z26 == c1125a.f107032h) {
                    return true;
                }
                return z26;
            }
        }

        public synchronized String a(String str, int i3, String str2, String str3, String str4, String str5) {
            if (this.f107024a != null && !TextUtils.isEmpty(str)) {
                JSONObject optJSONObject = this.f107024a.optJSONObject("data");
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
                        C1125a c1125a = new C1125a(this, str6, i3, str2, str3, str4, str5);
                        if (c1125a.f107027c) {
                            arrayList.add(c1125a);
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    return "";
                }
                if (arrayList.size() == 1) {
                    return optJSONObject2.optString(((C1125a) arrayList.get(0)).f107025a);
                }
                C1125a c1125a2 = (C1125a) arrayList.get(0);
                for (int i16 = 1; i16 < arrayList.size(); i16++) {
                    C1125a c1125a3 = (C1125a) arrayList.get(i16);
                    if (c1125a3.b(c1125a2)) {
                        c1125a2 = c1125a3;
                    }
                }
                return optJSONObject2.optString(c1125a2.f107025a);
            }
            return "";
        }

        public synchronized String b() {
            String jSONObject;
            JSONObject jSONObject2 = this.f107024a;
            if (jSONObject2 == null) {
                jSONObject = "";
            } else {
                jSONObject = jSONObject2.toString();
            }
            return jSONObject;
        }

        public synchronized String c() {
            JSONObject jSONObject = this.f107024a;
            if (jSONObject != null) {
                return jSONObject.optString("version");
            }
            return "";
        }

        public synchronized void a() {
            this.f107024a = null;
        }

        public synchronized void a(String str) {
            JSONObject optJSONObject;
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-SettingsQuerier", "received new json data:" + str);
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-SettingsQuerier", "old json data:" + this.f107024a);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (this.f107024a == null) {
                    this.f107024a = jSONObject;
                } else {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                    String optString = jSONObject.optString("version");
                    if (optJSONObject2 != null && !TextUtils.isEmpty(optString)) {
                        JSONObject optJSONObject3 = this.f107024a.optJSONObject("data");
                        if (optJSONObject3 == null) {
                            this.f107024a.putOpt("data", optJSONObject2);
                        } else {
                            Iterator keys = optJSONObject2.keys();
                            while (keys.hasNext()) {
                                String str2 = (String) keys.next();
                                if (!TextUtils.isEmpty(str2) && (optJSONObject = optJSONObject2.optJSONObject(str2)) != null) {
                                    optJSONObject3.putOpt(str2, optJSONObject);
                                }
                            }
                        }
                        this.f107024a.putOpt("version", optString);
                        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-SettingsQuerier", "updated json data:" + this.f107024a);
                    }
                }
            } catch (Throwable th5) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-SettingsQuerier", th5);
            }
        }
    }

    public static int a(String str, int i3, int i16, int i17) {
        int i18;
        try {
            i18 = Integer.parseInt(a(str));
        } catch (Throwable unused) {
            i18 = i17;
        }
        return com.tencent.gamecenter.wadl.sdk.common.e.g.a(i18, i3, i16, i17);
    }

    public static String a(String str) {
        String a16 = a(str, com.tencent.gamecenter.wadl.sdk.common.a.c());
        if (TextUtils.isEmpty(a16)) {
            a16 = a(str, 0);
        }
        com.tencent.gamecenter.wadl.sdk.common.e.b.d("Wadl-cloud-SettingsQuerier", "querySetting " + str + ":" + a16);
        return a16;
    }

    private static String a(String str, int i3) {
        return com.tencent.gamecenter.wadl.sdk.common.d.h.e().g().a(str, i3, com.tencent.gamecenter.wadl.sdk.common.a.d(), com.tencent.gamecenter.wadl.sdk.common.a.f106981d, com.tencent.gamecenter.wadl.sdk.common.d.k.a.b.a().a(c.b()), com.tencent.gamecenter.wadl.sdk.common.d.i.a(c.d()));
    }
}

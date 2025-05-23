package com.tencent.luggage.wxa.fd;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.pts.utils.PTSFileUtil;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements com.tencent.luggage.wxa.xd.l {
    public Set D;
    public JSONArray E;
    public ArrayList F;
    public g I;
    public h J;
    public j K;
    public Set L;
    public JSONObject M;
    public JSONObject N;
    public JSONObject O;
    public JSONObject P;
    public JSONObject Q;
    public JSONObject R;
    public String S;
    public String U;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f125628a;

    /* renamed from: b, reason: collision with root package name */
    public String f125629b;

    /* renamed from: c, reason: collision with root package name */
    public c f125630c;

    /* renamed from: d, reason: collision with root package name */
    public c f125631d;

    /* renamed from: f, reason: collision with root package name */
    public Map f125633f;

    /* renamed from: g, reason: collision with root package name */
    public Map f125634g;

    /* renamed from: h, reason: collision with root package name */
    public Map f125635h;

    /* renamed from: i, reason: collision with root package name */
    public k f125636i;

    /* renamed from: j, reason: collision with root package name */
    public k f125637j;

    /* renamed from: k, reason: collision with root package name */
    public d f125638k;

    /* renamed from: l, reason: collision with root package name */
    public C6205b f125639l;

    /* renamed from: e, reason: collision with root package name */
    public final Object f125632e = new byte[0];

    /* renamed from: m, reason: collision with root package name */
    public Boolean f125640m = null;
    public Boolean C = Boolean.FALSE;
    public boolean G = false;
    public boolean H = false;
    public boolean T = false;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.fd.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6205b {

        /* renamed from: a, reason: collision with root package name */
        public String f125641a = "portrait";

        /* renamed from: b, reason: collision with root package name */
        public boolean f125642b = true;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c extends m {
        public c(JSONObject jSONObject, boolean z16) {
            this(jSONObject, null, z16);
        }

        public c(JSONObject jSONObject, m mVar, boolean z16) {
            super(jSONObject, mVar, z16);
            (jSONObject == null ? m.f125680u : jSONObject).optJSONObject("window");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f125643a;

        /* renamed from: b, reason: collision with root package name */
        public int f125644b;

        /* renamed from: c, reason: collision with root package name */
        public int f125645c;

        /* renamed from: d, reason: collision with root package name */
        public int f125646d;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class e extends m {

        /* renamed from: v, reason: collision with root package name */
        public String f125647v;

        /* renamed from: w, reason: collision with root package name */
        public final h f125648w;

        public e(JSONObject jSONObject, m mVar, h hVar) {
            super(jSONObject, mVar);
            JSONObject jSONObject2;
            String str;
            if (jSONObject != null) {
                jSONObject2 = jSONObject.optJSONObject("window");
            } else {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                str = jSONObject2.optString("handleWebviewPreload");
            } else {
                str = "";
            }
            this.f125647v = str;
            this.f125648w = h.a(jSONObject2, hVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final String f125649a;

        /* renamed from: b, reason: collision with root package name */
        public final String f125650b;

        public f(String str, JSONObject jSONObject) {
            this.f125649a = str;
            this.f125650b = jSONObject.getString("desc");
        }

        public String toString() {
            return "Permission{name='" + this.f125649a + "', desc='" + this.f125650b + "'}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public final String f125651a;

        /* renamed from: b, reason: collision with root package name */
        public final String[] f125652b;

        public g(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f125651a = jSONObject.optString("default", "webview");
                JSONArray optJSONArray = jSONObject.optJSONArray("allUsed");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.f125652b = new String[optJSONArray.length()];
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        this.f125652b[i3] = optJSONArray.optString(i3, this.f125651a);
                    }
                } else {
                    this.f125652b = new String[0];
                }
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandAppConfig", "renderBackend is %s, default is %s", jSONObject, this.f125651a);
                return;
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandAppConfig", "renderBackend is null");
            this.f125651a = "webview";
            this.f125652b = new String[0];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public a f125653a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public boolean f125654a;

            /* renamed from: b, reason: collision with root package name */
            public String f125655b;

            /* renamed from: c, reason: collision with root package name */
            public String f125656c;

            /* renamed from: d, reason: collision with root package name */
            public String f125657d;

            /* renamed from: e, reason: collision with root package name */
            public String f125658e;
        }

        public static h a(JSONObject jSONObject, h hVar) {
            JSONObject optJSONObject;
            a aVar;
            boolean z16;
            String str;
            String str2;
            String str3;
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("rendererOptions")) != null) {
                h hVar2 = new h();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("skyline");
                if (optJSONObject2 != null) {
                    if (hVar != null) {
                        aVar = hVar.f125653a;
                    } else {
                        aVar = null;
                    }
                    a aVar2 = new a();
                    hVar2.f125653a = aVar2;
                    if (aVar != null && aVar.f125654a) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    aVar2.f125654a = optJSONObject2.optBoolean("disableABTest", z16);
                    a aVar3 = hVar2.f125653a;
                    String str4 = "";
                    if (aVar == null) {
                        str = "";
                    } else {
                        str = aVar.f125655b;
                    }
                    aVar3.f125655b = optJSONObject2.optString("sdkVersionBegin", str);
                    a aVar4 = hVar2.f125653a;
                    if (aVar == null) {
                        str2 = "";
                    } else {
                        str2 = aVar.f125656c;
                    }
                    aVar4.f125656c = optJSONObject2.optString("sdkVersionEnd", str2);
                    a aVar5 = hVar2.f125653a;
                    if (aVar == null) {
                        str3 = "";
                    } else {
                        str3 = aVar.f125657d;
                    }
                    aVar5.f125657d = optJSONObject2.optString("androidVersionBegin", str3);
                    a aVar6 = hVar2.f125653a;
                    if (aVar != null) {
                        str4 = aVar.f125658e;
                    }
                    aVar6.f125658e = optJSONObject2.optString("androidVersionEnd", str4);
                }
                return hVar2;
            }
            return hVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public String f125659a;

        /* renamed from: b, reason: collision with root package name */
        public String f125660b;

        /* renamed from: c, reason: collision with root package name */
        public double f125661c = -1.0d;

        /* renamed from: d, reason: collision with root package name */
        public String f125662d;

        /* renamed from: e, reason: collision with root package name */
        public String f125663e;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        public final String f125675a;

        /* renamed from: b, reason: collision with root package name */
        public final String f125676b;

        /* renamed from: c, reason: collision with root package name */
        public final String f125677c;

        /* renamed from: d, reason: collision with root package name */
        public final String f125678d;

        public l(JSONObject jSONObject) {
            this.f125675a = jSONObject.optString("pagePath");
            this.f125676b = jSONObject.optString("text");
            this.f125677c = jSONObject.optString("iconData");
            this.f125678d = jSONObject.optString("selectedIconData");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class m {

        /* renamed from: t, reason: collision with root package name */
        public static final m f125679t = new a();

        /* renamed from: u, reason: collision with root package name */
        public static final JSONObject f125680u = new JSONObject();

        /* renamed from: a, reason: collision with root package name */
        public final String f125681a;

        /* renamed from: b, reason: collision with root package name */
        public final String f125682b;

        /* renamed from: c, reason: collision with root package name */
        public final double f125683c;

        /* renamed from: d, reason: collision with root package name */
        public final String f125684d;

        /* renamed from: e, reason: collision with root package name */
        public final String f125685e;

        /* renamed from: f, reason: collision with root package name */
        public final String f125686f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f125687g;

        /* renamed from: h, reason: collision with root package name */
        public final String f125688h;

        /* renamed from: i, reason: collision with root package name */
        public final String f125689i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f125690j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f125691k;

        /* renamed from: l, reason: collision with root package name */
        public final boolean f125692l;

        /* renamed from: m, reason: collision with root package name */
        public final String f125693m;

        /* renamed from: n, reason: collision with root package name */
        public final String f125694n;

        /* renamed from: o, reason: collision with root package name */
        public final boolean f125695o;

        /* renamed from: p, reason: collision with root package name */
        public final String f125696p;

        /* renamed from: q, reason: collision with root package name */
        public final i f125697q;

        /* renamed from: r, reason: collision with root package name */
        public final String f125698r;

        /* renamed from: s, reason: collision with root package name */
        public final boolean f125699s;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a extends m {
            public a() {
                super();
            }
        }

        public boolean a() {
            return "custom".equalsIgnoreCase(this.f125684d);
        }

        public m() {
            this.f125683c = 1.0d;
            this.f125681a = null;
            this.f125682b = null;
            this.f125684d = "default";
            this.f125685e = "#000000";
            this.f125686f = null;
            this.f125687g = false;
            this.f125688h = null;
            this.f125689i = null;
            this.f125690j = false;
            this.f125691k = false;
            this.f125692l = false;
            this.f125693m = null;
            this.f125694n = null;
            this.f125697q = new i();
            this.f125698r = null;
            this.f125695o = false;
            this.f125699s = false;
            this.f125696p = "";
        }

        public static i a(JSONObject jSONObject) {
            i iVar = new i();
            if (jSONObject == null) {
                return iVar;
            }
            iVar.f125659a = jSONObject.optString("navigationBarFit", null);
            iVar.f125660b = jSONObject.optString("navigationBarBackgroundColor", "");
            iVar.f125661c = jSONObject.optDouble("navigationBarBackgroundAlpha", -1.0d);
            iVar.f125662d = jSONObject.optString("navigationBarTextStyle", "");
            iVar.f125663e = jSONObject.optString("navigationBarTitleText", "");
            return iVar;
        }

        public m(JSONObject jSONObject, m mVar, boolean z16) {
            this.f125683c = 1.0d;
            mVar = mVar == null ? f125679t : mVar;
            jSONObject = jSONObject == null ? f125680u : jSONObject;
            JSONObject optJSONObject = jSONObject.optJSONObject("window");
            optJSONObject = optJSONObject == null ? f125680u : optJSONObject;
            this.f125681a = optJSONObject.optString("navigationBarTitleText", mVar.f125681a);
            this.f125682b = optJSONObject.optString("navigationBarTextStyle", mVar.f125682b);
            this.f125684d = z16 ? "custom" : optJSONObject.optString("navigationStyle", mVar.f125684d);
            this.f125685e = optJSONObject.optString("navigationBarBackgroundColor", mVar.f125685e);
            this.f125688h = optJSONObject.optString("backgroundColor", mVar.f125688h);
            this.f125689i = optJSONObject.optString("backgroundColorContent", mVar.f125689i);
            this.f125691k = optJSONObject.optBoolean("enablePullDownRefresh", mVar.f125691k);
            this.f125693m = optJSONObject.optString("backgroundTextStyle", mVar.f125693m);
            this.f125690j = optJSONObject.optBoolean("enableFullScreen", mVar.f125690j);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("navigationBarRightButton");
            optJSONObject2 = optJSONObject2 == null ? f125680u : optJSONObject2;
            this.f125692l = optJSONObject.optBoolean("disableSwipeBack", mVar.f125692l);
            this.f125687g = optJSONObject2.optBoolean("hide", mVar.f125687g);
            this.f125686f = optJSONObject2.optString("customButtonIconData", mVar.f125686f);
            this.f125694n = optJSONObject.optString("pageOrientation", mVar.f125694n);
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("singlePage");
            this.f125697q = a(optJSONObject3 == null ? jSONObject.optJSONObject("singlePage") : optJSONObject3);
            this.f125695o = optJSONObject.optBoolean("resizable", false);
            this.f125698r = optJSONObject.optString("visualEffectInBackground", mVar.f125698r);
            this.f125696p = optJSONObject.optString("renderer", "");
            this.f125699s = optJSONObject.optBoolean("homeButton", mVar.f125699s);
        }

        public m(JSONObject jSONObject, m mVar) {
            this(jSONObject, mVar, false);
        }
    }

    public b(boolean z16) {
        this.f125628a = z16;
    }

    public static Map d(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject != null) {
                try {
                    hashMap.put(str, new f(str, optJSONObject));
                } catch (JSONException e16) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandAppConfig", e16.getMessage());
                }
            }
        }
        return hashMap;
    }

    public static l e(JSONObject jSONObject) {
        return new l(jSONObject);
    }

    public c b() {
        c cVar;
        return (!j() || (cVar = this.f125631d) == null) ? this.f125630c : cVar;
    }

    public boolean c(String str) {
        Map map;
        boolean z16 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this.f125632e) {
            if (!this.f125633f.containsKey(str)) {
                str = com.tencent.luggage.wxa.rc.m.c(str);
            }
            if (this.f125633f.containsKey(str) || (j() && (map = this.f125634g) != null && map.containsKey(str))) {
                z16 = true;
            }
        }
        return z16;
    }

    public JSONObject f() {
        JSONObject jSONObject;
        if (j() && (jSONObject = this.P) != null && jSONObject.length() != 0) {
            return this.P;
        }
        return this.O;
    }

    public d g() {
        return this.f125638k;
    }

    public Set h() {
        return this.D;
    }

    public k i() {
        k kVar;
        if (!j() || (kVar = this.f125637j) == null) {
            return this.f125636i;
        }
        return kVar;
    }

    public final boolean j() {
        return this.f125628a;
    }

    public final boolean k() {
        JSONObject jSONObject = this.N;
        if (jSONObject != null && jSONObject.length() > 0) {
            return true;
        }
        return false;
    }

    public final boolean l() {
        if (k() && j()) {
            return true;
        }
        return false;
    }

    public Boolean m() {
        return this.C;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap f125664a;

        public j(HashMap hashMap) {
            this.f125664a = hashMap;
        }

        public static j a(JSONObject jSONObject) {
            JSONObject optJSONObject;
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("splashCache")) == null || (optJSONArray = optJSONObject.optJSONArray("pages")) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                Object opt = optJSONArray.opt(i3);
                if (opt instanceof JSONObject) {
                    JSONObject jSONObject2 = (JSONObject) opt;
                    hashMap.put(jSONObject2.optString("path"), new a(jSONObject2.optInt("snapshotDelay", 0), jSONObject2.optInt("imageBlockingCount", -1)));
                } else if (opt instanceof String) {
                    hashMap.put((String) opt, new a());
                }
            }
            return new j(hashMap);
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public final int f125665a;

            /* renamed from: b, reason: collision with root package name */
            public final int f125666b;

            public a(int i3, int i16) {
                this.f125665a = i3;
                this.f125666b = i16;
            }

            public a() {
                this.f125665a = 0;
                this.f125666b = -1;
            }
        }
    }

    public e a(String str) {
        Map map;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f125632e) {
                if (!this.f125633f.containsKey(str)) {
                    str = com.tencent.luggage.wxa.rc.m.c(str);
                }
                if (this.f125633f.containsKey(str)) {
                    if (j() && (map = this.f125634g) != null && map.containsKey(str)) {
                        return (e) this.f125634g.get(str);
                    }
                    return (e) this.f125633f.get(str);
                }
            }
        }
        return a((JSONObject) null, (m) this.f125630c, this.J);
    }

    public f b(String str) {
        return (f) this.f125635h.get(str);
    }

    public JSONObject e() {
        JSONObject jSONObject;
        return (!j() || (jSONObject = this.R) == null || jSONObject.length() == 0) ? this.Q : this.R;
    }

    public static C6205b b(JSONObject jSONObject) {
        C6205b c6205b = new C6205b();
        if (jSONObject == null) {
            return c6205b;
        }
        c6205b.f125641a = jSONObject.optString("deviceOrientation", "portrait");
        c6205b.f125642b = jSONObject.optBoolean("showStatusBar", false);
        return c6205b;
    }

    public static Set b(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray == null) {
            return hashSet;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            String optString = jSONArray.optString(i3);
            if (!w0.c(optString)) {
                hashSet.add(optString);
            }
        }
        return hashSet;
    }

    public String c() {
        return !w0.c(this.S) ? this.S : "index.html";
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class k {

        /* renamed from: h, reason: collision with root package name */
        public static final k f125667h = new k();

        /* renamed from: a, reason: collision with root package name */
        public final String f125668a;

        /* renamed from: b, reason: collision with root package name */
        public final String f125669b;

        /* renamed from: c, reason: collision with root package name */
        public final String f125670c;

        /* renamed from: d, reason: collision with root package name */
        public final String f125671d;

        /* renamed from: e, reason: collision with root package name */
        public final String f125672e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f125673f;

        /* renamed from: g, reason: collision with root package name */
        public final ArrayList f125674g;

        public k() {
            this.f125674g = new ArrayList();
            this.f125668a = "";
            this.f125669b = "";
            this.f125670c = "";
            this.f125671d = "";
            this.f125672e = "";
            this.f125673f = false;
        }

        public boolean a(String str) {
            Iterator it = this.f125674g.iterator();
            while (it.hasNext()) {
                if (((l) it.next()).f125675a.equals(com.tencent.luggage.wxa.h6.o.b(str))) {
                    return true;
                }
            }
            return false;
        }

        public k(JSONObject jSONObject, k kVar) {
            ArrayList arrayList = new ArrayList();
            this.f125674g = arrayList;
            kVar = kVar == null ? f125667h : kVar;
            this.f125668a = jSONObject.optString("position", kVar.f125668a);
            this.f125669b = jSONObject.optString("color", kVar.f125669b);
            this.f125670c = jSONObject.optString("selectedColor", kVar.f125670c);
            this.f125671d = jSONObject.optString("backgroundColor", kVar.f125671d);
            this.f125672e = jSONObject.optString(NodeProps.BORDER_STYLES, kVar.f125672e);
            this.f125673f = jSONObject.optBoolean("custom", kVar.f125673f);
            arrayList.addAll(kVar.f125674g);
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("list");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    l e16 = b.e(jSONArray.getJSONObject(i3));
                    Iterator it = this.f125674g.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (TextUtils.equals(((l) it.next()).f125675a, e16.f125675a)) {
                                it.remove();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.f125674g.add(e16);
                }
            } catch (Exception e17) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandAppConfig", e17.getMessage());
            }
        }
    }

    public JSONObject d() {
        JSONObject jSONObject;
        return (!j() || (jSONObject = this.N) == null || jSONObject.length() == 0) ? this.M : this.N;
    }

    public static d c(JSONObject jSONObject) {
        d dVar = new d();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        dVar.f125643a = jSONObject.optInt(Const.BUNDLE_KEY_REQUEST);
        dVar.f125644b = jSONObject.optInt("connectSocket");
        dVar.f125646d = jSONObject.optInt("downloadFile");
        dVar.f125645c = jSONObject.optInt("uploadFile");
        return dVar;
    }

    public void a(String str, String str2, String str3) {
        Map emptyMap = Collections.emptyMap();
        try {
            if (!TextUtils.isEmpty(str2)) {
                emptyMap = a(new JSONObject(str2).optJSONObject("page"), this.f125630c, this.J);
            }
        } catch (Exception e16) {
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(emptyMap == null ? -1 : emptyMap.size());
            objArr[2] = e16;
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandAppConfig", "addPageConfigs(%s), parse extPagesJson(%d) get exception:%s", objArr);
        }
        Map emptyMap2 = Collections.emptyMap();
        try {
            if (!TextUtils.isEmpty(str3)) {
                emptyMap2 = a(new JSONObject(str3).optJSONObject("page"), this.f125631d, this.J);
            }
        } catch (Exception e17) {
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = Integer.valueOf(emptyMap2 != null ? emptyMap2.size() : -1);
            objArr2[2] = e17;
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandAppConfig", "addPageConfigs(%s), parse extDarkModePagesJson(%d) get exception:%s", objArr2);
        }
        if (emptyMap.isEmpty() && emptyMap2.isEmpty()) {
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandAppConfig", "addPageConfigs(%s), extPages.size:%d, extDarkModePages.size:%d", str, Integer.valueOf(emptyMap.size()), Integer.valueOf(emptyMap2.size()));
        synchronized (this.f125632e) {
            this.f125633f.putAll(emptyMap);
            Map map = this.f125634g;
            if (map != null) {
                map.putAll(emptyMap2);
            }
        }
    }

    public static Set c(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray == null) {
            return hashSet;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            String optString = jSONArray.optString(i3);
            if (!w0.c(optString)) {
                hashSet.add(optString);
            }
        }
        return hashSet;
    }

    public C6205b a() {
        return this.f125639l;
    }

    public void a(Boolean bool) {
        this.C = bool;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b a(String str, String str2, String str3, boolean z16, boolean z17) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandAppConfig", "parse appId:%s, json?:%b, darkJson?:%b, forceCustomNavigationStyle?:%b, isDarkModeByPlatform?:%b, stack:%s", str, Boolean.valueOf(!TextUtils.isEmpty(str2)), Boolean.valueOf(!TextUtils.isEmpty(str3)), Boolean.valueOf(z16), Boolean.valueOf(z17), Log.getStackTraceString(new Throwable()));
        b bVar = new b(z17);
        bVar.f125629b = str;
        try {
            jSONObject = new JSONObject(str2);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandAppConfig", e16.getMessage());
            jSONObject = new JSONObject();
        }
        if (jSONObject.length() != 0) {
            bVar.a(Boolean.TRUE);
        }
        a(jSONObject, bVar);
        bVar.f125630c = a(jSONObject.optJSONObject(ReadInJoyMMapKvStorage.NAME_DEFAULT), z16);
        Map map = null;
        bVar.J = h.a(jSONObject, null);
        Map a16 = a(jSONObject.optJSONObject("page"), bVar.f125630c, bVar.J);
        bVar.f125635h = d(jSONObject.optJSONObject(QCircleDaTongConstant.ElementParamValue.PERMISSION));
        bVar.f125636i = a(jSONObject.optJSONObject("tabBar"), (k) null);
        bVar.f125638k = c(jSONObject.optJSONObject("networkTimeout"));
        bVar.f125639l = b(jSONObject);
        if (jSONObject.has("useCommandBuffer")) {
            bVar.f125640m = Boolean.valueOf(jSONObject.optBoolean("useCommandBuffer", false));
        }
        bVar.D = b(jSONObject.optJSONArray("requiredBackgroundModes"));
        bVar.E = jSONObject.optJSONArray("preloadResources");
        bVar.F = a(jSONObject.optJSONArray("preloadSubpackages"));
        bVar.G = jSONObject.optBoolean("manualHideSplashScreen", false);
        bVar.H = jSONObject.optBoolean("resizable", false);
        bVar.I = new g(jSONObject.optJSONObject("renderer"));
        bVar.J = h.a(jSONObject, null);
        bVar.K = j.a(jSONObject);
        bVar.L = c(jSONObject.optJSONArray("requiredPrivateInfos"));
        try {
        } catch (Exception e17) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandAppConfig", "parse darkMode appId:%s, e:%s", str, e17);
            jSONObject2 = new JSONObject();
        }
        if (!TextUtils.isEmpty(str3) && !"{}".equals(str3)) {
            jSONObject2 = new JSONObject(str3);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("darkModeJson is Empty = ");
            sb5.append(jSONObject2.length() == 0);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandAppConfig", sb5.toString());
            if (jSONObject2.length() != 0) {
                bVar.f125631d = a(jSONObject2.optJSONObject(ReadInJoyMMapKvStorage.NAME_DEFAULT), z16);
                bVar.f125637j = a(jSONObject2.optJSONObject("tabBar"), (k) null);
                map = a(jSONObject2.optJSONObject("page"), bVar.f125631d, bVar.J);
            }
            synchronized (bVar.f125632e) {
                bVar.f125633f = a16;
                bVar.f125634g = map;
            }
            a(str, jSONObject, jSONObject2, bVar);
            return bVar;
        }
        jSONObject2 = new JSONObject();
        StringBuilder sb52 = new StringBuilder();
        sb52.append("darkModeJson is Empty = ");
        sb52.append(jSONObject2.length() == 0);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandAppConfig", sb52.toString());
        if (jSONObject2.length() != 0) {
        }
        synchronized (bVar.f125632e) {
        }
    }

    public static void a(JSONObject jSONObject, b bVar) {
        bVar.S = jSONObject.optString("entryPagePath");
        bVar.U = jSONObject.optString("referrerPolicy");
    }

    public static void a(String str, JSONObject jSONObject, JSONObject jSONObject2, b bVar) {
        if (jSONObject == null) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandAppConfig", "extractInjectConfig NULL obj, appId[%s]", str);
        }
        bVar.M = jSONObject;
        if (jSONObject != null) {
            bVar.O = jSONObject.optJSONObject("page");
            bVar.Q = jSONObject.optJSONObject("preloadRule");
        }
        JSONObject jSONObject3 = bVar.M;
        if (jSONObject3 != null) {
            com.tencent.luggage.wxa.fd.c.a(str, jSONObject3);
        }
        bVar.N = jSONObject2;
        if (jSONObject2 != null) {
            bVar.P = jSONObject2.optJSONObject("page");
            bVar.R = jSONObject2.optJSONObject("preloadRule");
            if (jSONObject2.length() > 0) {
                try {
                    String str2 = bVar.j() ? MiniAppConst.MENU_STYLE_DARK : MiniAppConst.MENU_STYLE_LIGHT;
                    bVar.N.put("theme", str2);
                    bVar.M.put("theme", str2);
                } catch (JSONException e16) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandAppConfig", e16, "", new Object[0]);
                }
            }
        }
        JSONObject jSONObject4 = bVar.N;
        if (jSONObject4 != null) {
            com.tencent.luggage.wxa.fd.c.a(str, jSONObject4);
        }
    }

    public static c a(JSONObject jSONObject, boolean z16) {
        return new c(jSONObject, z16);
    }

    public static Map a(JSONObject jSONObject, c cVar, h hVar) {
        if (jSONObject != null && jSONObject.length() > 0) {
            HashMap hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, a(jSONObject.optJSONObject(str), (m) cVar, hVar));
            }
            return hashMap;
        }
        return new HashMap();
    }

    public static e a(JSONObject jSONObject, m mVar, h hVar) {
        return new e(jSONObject, mVar, hVar);
    }

    public static k a(JSONObject jSONObject, k kVar) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return new k(jSONObject, kVar);
    }

    public static ArrayList a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("root");
                if (!w0.c(optString)) {
                    if (!optString.startsWith("/")) {
                        optString = "/" + optString;
                    }
                    if (!optString.endsWith(PTSFileUtil.JS_FORMAT) && !optString.endsWith("/")) {
                        optString = optString + "/";
                    }
                    arrayList.add(optString);
                }
            }
        }
        return arrayList;
    }
}

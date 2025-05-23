package hr;

import com.qzone.homepage.ui.Facade.model.FacadeCacheData;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends hr.a {

    /* renamed from: u, reason: collision with root package name */
    public static boolean f406010u = false;

    /* renamed from: n, reason: collision with root package name */
    public List<c> f406011n;

    /* renamed from: o, reason: collision with root package name */
    public String f406012o;

    /* renamed from: p, reason: collision with root package name */
    public String f406013p;

    /* renamed from: q, reason: collision with root package name */
    public String f406014q;

    /* renamed from: r, reason: collision with root package name */
    public String f406015r;

    /* renamed from: s, reason: collision with root package name */
    public int f406016s;

    /* renamed from: t, reason: collision with root package name */
    public Map<String, Map<String, a>> f406017t;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f406018a;

        /* renamed from: b, reason: collision with root package name */
        public String f406019b;

        /* renamed from: c, reason: collision with root package name */
        public String f406020c;

        /* renamed from: d, reason: collision with root package name */
        public String f406021d;
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface b {
        void b(boolean z16);

        void e();
    }

    public d(String str) {
        super(str);
        this.f406013p = "default";
        this.f406011n = new ArrayList();
    }

    public static List<c> h(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            arrayList.add(new c(jSONArray.getJSONObject(i3)));
        }
        return arrayList;
    }

    @Override // hr.a
    public int b() {
        return this.f406011n.size();
    }

    @Override // hr.a
    public String e() {
        return "InformationFacePackage";
    }

    public c g(String str) {
        List<c> list;
        if (StringUtil.isEmpty(str) || (list = this.f406011n) == null) {
            return null;
        }
        for (c cVar : list) {
            if (str.equals(cVar.f406023b)) {
                return cVar;
            }
        }
        return null;
    }

    @Override // hr.a
    public String d(int i3) {
        if (i3 < 0 || i3 >= this.f406011n.size()) {
            return null;
        }
        return this.f406011n.get(i3).f406026e;
    }

    public String i(int i3) {
        if (i3 < 0 || i3 >= this.f406011n.size()) {
            return null;
        }
        return this.f406011n.get(i3).f406027f;
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private b f406022a;

        /* renamed from: b, reason: collision with root package name */
        public String f406023b;

        /* renamed from: c, reason: collision with root package name */
        public String f406024c;

        /* renamed from: d, reason: collision with root package name */
        public int f406025d;

        /* renamed from: e, reason: collision with root package name */
        public String f406026e;

        /* renamed from: f, reason: collision with root package name */
        public String f406027f;

        /* renamed from: g, reason: collision with root package name */
        public int f406028g;

        /* renamed from: h, reason: collision with root package name */
        public String f406029h;

        /* renamed from: i, reason: collision with root package name */
        public String f406030i;

        /* renamed from: j, reason: collision with root package name */
        public String f406031j;

        /* renamed from: k, reason: collision with root package name */
        public String f406032k;

        /* renamed from: l, reason: collision with root package name */
        public String f406033l;

        /* renamed from: m, reason: collision with root package name */
        public String f406034m;

        /* renamed from: n, reason: collision with root package name */
        public String f406035n;

        /* renamed from: o, reason: collision with root package name */
        public int f406036o;

        /* renamed from: p, reason: collision with root package name */
        public int f406037p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f406038q;

        /* renamed from: r, reason: collision with root package name */
        public String f406039r = "";

        /* renamed from: s, reason: collision with root package name */
        public int f406040s = -1;

        /* renamed from: t, reason: collision with root package name */
        public int f406041t = -1;

        /* renamed from: u, reason: collision with root package name */
        public String f406042u;

        public c() {
        }

        public b a() {
            return this.f406022a;
        }

        public void b(b bVar) {
            this.f406022a = bVar;
        }

        public c(JSONObject jSONObject) throws JSONException {
            this.f406023b = jSONObject.optString("poi_poster_id");
            this.f406024c = jSONObject.getString("poster_name");
            this.f406025d = jSONObject.getInt("poster_type");
            this.f406026e = jSONObject.getString(FacadeCacheData.THUMB_URL);
            this.f406028g = jSONObject.optInt("predownload", 0);
            this.f406027f = jSONObject.getString("static_url");
            JSONObject jSONObject2 = jSONObject.getJSONObject("resource");
            this.f406029h = jSONObject2.optString("resurl", "");
            this.f406030i = jSONObject2.optString("md5", "");
            this.f406031j = jSONObject2.optString("name");
            this.f406032k = jSONObject2.optString("id", "");
            this.f406038q = hr.c.e(this.f406025d);
        }
    }

    public static Map<String, Map<String, a>> j(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            HashMap hashMap = new HashMap(jSONArray.length());
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String string = jSONObject.getString("id");
                JSONArray jSONArray2 = jSONObject.getJSONArray("res");
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    HashMap hashMap2 = new HashMap(jSONArray2.length());
                    for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i16);
                        a aVar = new a();
                        aVar.f406018a = jSONObject2.getString("resname");
                        aVar.f406019b = jSONObject2.getString("resurl");
                        aVar.f406021d = jSONObject2.getString("cityname");
                        aVar.f406020c = jSONObject2.getString("md5");
                        hashMap2.put(aVar.f406021d, aVar);
                    }
                    hashMap.put(string, hashMap2);
                }
            }
            return hashMap;
        } catch (JSONException e16) {
            QLog.e("FacePackage", 1, e16, new Object[0]);
            return null;
        }
    }
}

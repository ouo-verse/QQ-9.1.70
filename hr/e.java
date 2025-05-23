package hr;

import android.graphics.drawable.Drawable;
import com.qzone.homepage.ui.Facade.model.FacadeCacheData;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e extends hr.a {

    /* renamed from: n, reason: collision with root package name */
    public List<a> f406043n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f406044o;

    /* renamed from: p, reason: collision with root package name */
    public String f406045p;

    public e(String str) {
        super(str);
        this.f406043n = new ArrayList();
    }

    public static List<a> i(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            arrayList.add(new a(jSONArray.getJSONObject(i3)));
        }
        return arrayList;
    }

    @Override // hr.a
    public int b() {
        List<a> list = this.f406043n;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // hr.a
    public String e() {
        return "LocationFacePackage";
    }

    public a h(String str) {
        List<a> list;
        if (StringUtil.isEmpty(str) || (list = this.f406043n) == null) {
            return null;
        }
        for (a aVar : list) {
            if (str.equals(aVar.f406053h)) {
                return aVar;
            }
        }
        return null;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("LocationFacePackage{");
        stringBuffer.append("id='");
        stringBuffer.append(this.f405988a);
        stringBuffer.append('\'');
        stringBuffer.append("logoUrl='");
        stringBuffer.append(this.f405990c);
        stringBuffer.append('\'');
        stringBuffer.append("logoDrawable='");
        stringBuffer.append(this.f405992e);
        stringBuffer.append('\'');
        stringBuffer.append("items=");
        stringBuffer.append(this.f406043n);
        stringBuffer.append(", isLocating=");
        stringBuffer.append(this.f406044o);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f406046a;

        /* renamed from: b, reason: collision with root package name */
        public String f406047b;

        /* renamed from: c, reason: collision with root package name */
        public String f406048c;

        /* renamed from: d, reason: collision with root package name */
        public String f406049d;

        /* renamed from: e, reason: collision with root package name */
        public Drawable f406050e;

        /* renamed from: f, reason: collision with root package name */
        public String f406051f;

        /* renamed from: g, reason: collision with root package name */
        public C10470a f406052g;

        /* renamed from: h, reason: collision with root package name */
        public String f406053h;

        /* renamed from: i, reason: collision with root package name */
        public String f406054i;

        /* renamed from: j, reason: collision with root package name */
        public int f406055j;

        /* compiled from: P */
        /* renamed from: hr.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes38.dex */
        public static class C10470a {

            /* renamed from: a, reason: collision with root package name */
            public int f406056a;

            /* renamed from: b, reason: collision with root package name */
            public int[] f406057b;

            /* renamed from: c, reason: collision with root package name */
            public String f406058c;

            /* renamed from: d, reason: collision with root package name */
            public int f406059d;

            /* renamed from: e, reason: collision with root package name */
            public int f406060e;

            /* renamed from: f, reason: collision with root package name */
            public int f406061f;

            /* renamed from: g, reason: collision with root package name */
            public int f406062g;

            /* renamed from: h, reason: collision with root package name */
            public int f406063h;
        }

        public a() {
            this.f406052g = new C10470a();
        }

        public boolean a() {
            if (this.f406052g == null) {
                this.f406052g = new C10470a();
            }
            try {
                JSONObject jSONObject = new JSONObject(this.f406051f);
                int i3 = jSONObject.getInt("align");
                JSONArray jSONArray = jSONObject.getJSONArray("picture_margin");
                int[] iArr = {jSONArray.getInt(0), jSONArray.getInt(1), jSONArray.getInt(2), jSONArray.getInt(3)};
                String string = jSONObject.getString("text_color");
                int i16 = jSONObject.getInt("text_size");
                int i17 = jSONObject.getInt("picture_width");
                int i18 = jSONObject.getInt("picture_height");
                int i19 = jSONObject.getInt("standard_width");
                int i26 = jSONObject.getInt("standard_height");
                C10470a c10470a = this.f406052g;
                c10470a.f406056a = i3;
                c10470a.f406057b = iArr;
                c10470a.f406058c = string;
                c10470a.f406059d = i16;
                c10470a.f406060e = i17;
                c10470a.f406061f = i18;
                c10470a.f406062g = i19;
                c10470a.f406063h = i26;
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
                return false;
            }
        }

        public String toString() {
            return "Item{thumbUrl='" + this.f406046a + "', name='" + this.f406047b + "', desc='" + this.f406048c + "', imageUrl='" + this.f406049d + "', imageDrawable=" + this.f406050e + ", layoutJson='" + this.f406051f + "', params=" + this.f406052g + '}';
        }

        public a(JSONObject jSONObject) throws JSONException {
            this.f406046a = jSONObject.getString(FacadeCacheData.THUMB_URL);
            this.f406047b = jSONObject.getString("poster_name");
            this.f406049d = jSONObject.getString("poster_url");
            this.f406048c = jSONObject.getString("desc");
            this.f406051f = jSONObject.getString("poster_json_layout_desc");
            this.f406053h = jSONObject.getString("poi_poster_id");
        }
    }

    @Override // hr.a
    public String d(int i3) {
        if (i3 >= 0 && i3 < this.f406043n.size()) {
            return this.f406043n.get(i3).f406046a;
        }
        throw new IndexOutOfBoundsException("getThumbUri with illegal index : " + i3 + ", the item size is : " + this.f406043n.size());
    }

    public String g(int i3) {
        if (i3 >= 0 && i3 < this.f406043n.size()) {
            return this.f406043n.get(i3).f406047b;
        }
        throw new IndexOutOfBoundsException("getCategory with illegal index : " + i3 + ", the item size is : " + this.f406043n.size());
    }
}

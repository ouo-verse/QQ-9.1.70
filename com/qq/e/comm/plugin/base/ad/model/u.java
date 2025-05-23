package com.qq.e.comm.plugin.base.ad.model;

import android.graphics.Point;
import com.qq.e.comm.plugin.k.ae;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private String f39144a;

    /* renamed from: b, reason: collision with root package name */
    private List<Integer> f39145b;

    /* renamed from: c, reason: collision with root package name */
    private List<Point> f39146c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f39147d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f39148e;

    /* renamed from: f, reason: collision with root package name */
    private int f39149f = 0;

    public static List<u> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                Object opt = jSONArray.opt(i3);
                if (opt instanceof JSONObject) {
                    u a16 = a((JSONObject) opt);
                    if (a16 != null) {
                        arrayList.add(a16);
                    }
                } else {
                    GDTLogger.e("Slot.parseList error !");
                }
            }
        }
        return arrayList;
    }

    public int b() {
        return this.f39149f;
    }

    public List<Integer> c() {
        return this.f39145b;
    }

    public List<Point> d() {
        return this.f39146c;
    }

    public List<String> e() {
        return this.f39147d;
    }

    public boolean f() {
        return this.f39148e;
    }

    public void b(List<Point> list) {
        this.f39146c = list;
    }

    public void c(List<String> list) {
        this.f39147d = list;
    }

    public static u a(JSONObject jSONObject) {
        if (!y.a(jSONObject)) {
            return null;
        }
        u uVar = new u();
        uVar.a(jSONObject.optString("date"));
        uVar.a(y.c(jSONObject, "priority_num"));
        uVar.a(ae.b(jSONObject.optJSONArray("index")));
        JSONArray optJSONArray = jSONObject.optJSONArray("effectivetime");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    Point point = new Point();
                    point.x = optJSONObject.optInt("start");
                    point.y = optJSONObject.optInt("end");
                    arrayList.add(point);
                }
            }
        }
        uVar.b(arrayList);
        uVar.c(ae.a(jSONObject.optJSONArray("server_data")));
        uVar.a(jSONObject.optInt("is_first_play") == 1);
        return uVar;
    }

    public String a() {
        return this.f39144a;
    }

    public void a(String str) {
        this.f39144a = str;
    }

    public void a(int i3) {
        this.f39149f = i3;
    }

    public void a(List<Integer> list) {
        this.f39145b = list;
    }

    public String a(Integer num) {
        int indexOf;
        List<Integer> c16 = c();
        List<String> e16 = e();
        if (c16 != null && e16 != null && (indexOf = c16.indexOf(num)) >= 0 && indexOf < e16.size()) {
            return e16.get(indexOf);
        }
        if (e16 == null || e16.size() <= 0) {
            return null;
        }
        return e16.get(0);
    }

    public void a(boolean z16) {
        this.f39148e = z16;
    }
}

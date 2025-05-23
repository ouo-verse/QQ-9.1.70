package c.t.m.sapp.c;

import android.content.Context;
import cooperation.qzone.patch.QZonePatchService;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public Context f30167a;

    /* renamed from: b, reason: collision with root package name */
    public List<a> f30168b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f30169c = false;

    /* renamed from: d, reason: collision with root package name */
    public List<a> f30170d = null;

    /* renamed from: e, reason: collision with root package name */
    public c f30171e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f30172f;

    public h(Context context, List<a> list, boolean z16) {
        this.f30168b = null;
        this.f30171e = null;
        this.f30167a = context;
        this.f30172f = z16;
        ArrayList arrayList = new ArrayList();
        this.f30168b = arrayList;
        arrayList.addAll(list);
        this.f30171e = new c(this.f30167a);
    }

    public final boolean a(String str) {
        String c16 = q.c(l.a(str, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q"));
        if (c16 == null) {
            return false;
        }
        this.f30170d = q.d(c16);
        List<a> d16 = q.d(q.c(this.f30167a, "__bad_dex_info___sapp", "preference_default_sapp"));
        boolean a16 = !d16.isEmpty() ? k.a(d16, this.f30170d) : false;
        boolean a17 = a(this.f30168b, this.f30170d);
        List<a> d17 = q.d(q.c(this.f30167a, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "preference_default_sapp"));
        boolean a18 = !d17.isEmpty() ? k.a(d17, this.f30170d) : false;
        e.a(this.f30167a).a("DRG", "need and samebad:" + a17 + "," + a16);
        if (a17 || a16 || a18) {
            return false;
        }
        e.a(this.f30167a).a("DRG", "to download:" + c16);
        this.f30171e.b(this.f30170d);
        return true;
    }

    public final boolean b() {
        if (System.currentTimeMillis() - q.a(this.f30167a, "__last_check_update_time___sapp", (Long) 0L).longValue() > 3600000) {
            return true;
        }
        return false;
    }

    public final boolean c() {
        byte[] bytes;
        String a16 = a();
        if (a16 != null && (bytes = a16.getBytes()) != null) {
            new HashMap();
            int i3 = 0;
            while (true) {
                int i16 = i3 + 1;
                if (i3 >= 3) {
                    break;
                }
                byte[] a17 = o.a("https://lhp.map.qq.com?desc_c", bytes);
                if (a17 != null) {
                    String str = new String(a17);
                    e.a(this.f30167a).a("DRG", "response suc,try:" + i16);
                    return a(str);
                }
                q.a(10000L);
                i3 = i16;
            }
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b16 = b();
        e.a(this.f30167a).a("DRG", "t:" + b16 + ",i:" + this.f30172f);
        c();
        q.b(this.f30167a, "__last_check_update_time___sapp", Long.valueOf(System.currentTimeMillis()));
        e.a(this.f30167a).d();
    }

    public final boolean a(List<a> list, List<a> list2) {
        boolean z16;
        boolean z17 = true;
        for (a aVar : list) {
            Iterator<a> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z16 = false;
                    break;
                }
                a next = it.next();
                if (!next.f30130c.contains(QZonePatchService.PATCH_SUFFIX_DEX)) {
                    next.f30130c += QZonePatchService.PATCH_SUFFIX_DEX;
                }
                if (aVar.f30130c.equals(next.f30130c) && aVar.f30131d == next.f30131d && aVar.f30132e.equals(next.f30132e)) {
                    z16 = true;
                    break;
                }
            }
            if (!z16) {
                z17 = false;
            }
        }
        return z17;
    }

    public final String a() {
        JSONObject jSONObject = new JSONObject();
        String str = this.f30167a.getFilesDir().getAbsolutePath() + File.separator + q.f30189b;
        try {
            jSONObject.put("appkey", q.k(this.f30167a));
            jSONObject.put("appversion", q.b(this.f30167a));
            jSONObject.put("imei", q.g(this.f30167a));
            jSONObject.put("coverSDKver", g.f30163a);
            jSONObject.put("model", q.e() + "_" + q.f());
            jSONObject.put("APILevel", q.b());
            JSONArray jSONArray = new JSONArray();
            List<a> list = this.f30168b;
            if (list != null) {
                for (a aVar : list) {
                    if (aVar != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("compId", aVar.f30128a);
                        jSONObject2.put("compVer", aVar.f30129b);
                        jSONObject2.put("size", aVar.f30131d);
                        jSONObject2.put("md5", q.a(new File(str, aVar.f30130c)));
                        jSONArray.mo162put(jSONObject2);
                    }
                }
            }
            jSONObject.put("compList", jSONArray);
            String jSONObject3 = jSONObject.toString();
            e.a(this.f30167a).a("DRG", "req:" + jSONObject3);
            return l.b(jSONObject3, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
        } catch (Exception e16) {
            e.a(this.f30167a).a("DRG", "reqDerror:" + e16.toString());
            return null;
        }
    }
}

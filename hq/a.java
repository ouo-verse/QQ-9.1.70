package hq;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: g, reason: collision with root package name */
    private static HashMap<String, BeautyRealConfig.TYPE> f405867g;

    /* renamed from: a, reason: collision with root package name */
    public int f405868a;

    /* renamed from: b, reason: collision with root package name */
    public String f405869b;

    /* renamed from: c, reason: collision with root package name */
    public int f405870c;

    /* renamed from: d, reason: collision with root package name */
    public List<C10462a> f405871d;

    /* renamed from: e, reason: collision with root package name */
    public List<b> f405872e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, List<C10462a>> f405873f;

    /* compiled from: P */
    /* renamed from: hq.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class C10462a {

        /* renamed from: a, reason: collision with root package name */
        public String f405874a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f405875b;

        /* renamed from: c, reason: collision with root package name */
        public int f405876c;

        /* renamed from: d, reason: collision with root package name */
        public int f405877d;

        /* renamed from: e, reason: collision with root package name */
        public String f405878e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f405879f;

        /* renamed from: g, reason: collision with root package name */
        public HashMap<String, Integer> f405880g;

        /* renamed from: h, reason: collision with root package name */
        public c f405881h;

        /* renamed from: i, reason: collision with root package name */
        public d f405882i;

        /* renamed from: j, reason: collision with root package name */
        public d f405883j;

        /* renamed from: k, reason: collision with root package name */
        public d f405884k;

        /* renamed from: l, reason: collision with root package name */
        public String f405885l;

        /* renamed from: m, reason: collision with root package name */
        public d f405886m;

        /* renamed from: n, reason: collision with root package name */
        public String f405887n;

        /* renamed from: o, reason: collision with root package name */
        private HashMap<BeautyRealConfig.TYPE, Integer> f405888o;

        public C10462a() {
        }

        public C10462a c() {
            C10462a c10462a = new C10462a();
            c10462a.f405874a = this.f405874a;
            c10462a.f405875b = this.f405875b;
            c10462a.f405876c = this.f405876c;
            c10462a.f405877d = this.f405877d;
            c10462a.f405878e = this.f405878e;
            c10462a.f405879f = this.f405879f;
            c10462a.f405880g = this.f405880g;
            c10462a.f405881h = this.f405881h;
            c10462a.f405882i = this.f405882i;
            c10462a.f405883j = this.f405883j;
            c10462a.f405884k = this.f405884k;
            c10462a.f405885l = this.f405885l;
            c10462a.f405886m = this.f405886m;
            c10462a.f405887n = this.f405887n;
            c10462a.f405888o = this.f405888o;
            return c10462a;
        }

        public HashMap<BeautyRealConfig.TYPE, Integer> d() {
            return this.f405888o;
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public String f405898a;

        /* renamed from: b, reason: collision with root package name */
        public int f405899b;

        /* renamed from: c, reason: collision with root package name */
        public int f405900c;

        public c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        public String f405902a;

        /* renamed from: b, reason: collision with root package name */
        public int f405903b;

        public d() {
        }
    }

    private void e(List<C10462a> list) {
        Iterator<C10462a> it = list.iterator();
        while (it.hasNext()) {
            d(it.next());
        }
    }

    private List<C10462a> f() {
        if (!l()) {
            QLog.i("LSAutoTestConfigBeans", 4, "createNodeFromImageSet | \u65e0\u9700\u521b\u5efa\u65b0\u7684autoTestNode");
            return null;
        }
        Date date = new Date();
        String str = "" + (date.getYear() + 1900) + "_" + (date.getMonth() + 1) + "_" + date.getDate() + File.separator;
        QLog.i("LSAutoTestConfigBeans", 4, "createNodeFromImageSet | parentFolder:" + str);
        ArrayList arrayList = new ArrayList();
        for (b bVar : this.f405872e) {
            List<C10462a> list = this.f405873f.get(bVar.f405894e);
            if (list != null && list.size() != 0) {
                Iterator<C10462a> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(bVar.c(it.next(), str));
                }
            } else {
                QLog.e("LSAutoTestConfigBeans", 4, "can not found test cases for " + bVar.f405894e);
            }
        }
        return arrayList;
    }

    private HashMap<BeautyRealConfig.TYPE, Integer> g() {
        if (f405867g == null) {
            k();
        }
        HashMap<BeautyRealConfig.TYPE, Integer> hashMap = new HashMap<>();
        for (BeautyRealConfig.TYPE type : BeautyRealConfig.TYPE.values()) {
            hashMap.put(type, 0);
        }
        return hashMap;
    }

    private c h() {
        c cVar = new c();
        cVar.f405898a = null;
        cVar.f405899b = 0;
        cVar.f405900c = 0;
        return cVar;
    }

    private d i() {
        d dVar = new d();
        dVar.f405902a = null;
        dVar.f405903b = 0;
        return dVar;
    }

    private void j() {
        f405867g.put("\u65e0", BeautyRealConfig.TYPE.NONE);
        f405867g.put("\u7f8e\u767d", BeautyRealConfig.TYPE.LUT_FOUNDATION_ALPHA);
        f405867g.put("\u5c0f\u8138", BeautyRealConfig.TYPE.FACTOR_SMALL_NEW);
        f405867g.put("\u5634\u5f62", BeautyRealConfig.TYPE.MOUTH_SHAPE);
        f405867g.put("\u816e\u7ea2", BeautyRealConfig.TYPE.FACE_FEATURE_REDCHEEK);
        f405867g.put("\u989d\u5934", BeautyRealConfig.TYPE.FOREHEAD);
        f405867g.put("\u6e05\u6670", BeautyRealConfig.TYPE.LUT_CLERA_ALPHA);
        f405867g.put("\u7acb\u4f53", BeautyRealConfig.TYPE.FACE_FEATURE_SOFT);
        f405867g.put("\u6cd5\u4ee4\u7eb9", BeautyRealConfig.TYPE.REMOVE_WRINKLES2);
        f405867g.put("\u78e8\u76ae", BeautyRealConfig.TYPE.BEAUTY);
        f405867g.put("\u7626\u98a7\u9aa8", BeautyRealConfig.TYPE.CHEEKBONE_THIN);
        f405867g.put("\u767d\u7259", BeautyRealConfig.TYPE.TOOTH_WHITEN);
        f405867g.put("\u53e3\u7ea2", BeautyRealConfig.TYPE.FACE_FEATURE_LIPS_LUT_ALPHA);
        f405867g.put("\u7a84\u8138", BeautyRealConfig.TYPE.FACE_THIN);
        f405867g.put("\u7626\u9f3b", BeautyRealConfig.TYPE.NOSE);
        f405867g.put("\u7626\u8138", BeautyRealConfig.TYPE.FACTOR_THIN_NEW);
        f405867g.put("\u5927\u773c", BeautyRealConfig.TYPE.EYE);
        f405867g.put("\u9ed1\u773c\u5708", BeautyRealConfig.TYPE.REMOVE_POUNCH);
    }

    private void k() {
        f405867g = new HashMap<>();
        j();
    }

    private boolean l() {
        HashMap<String, List<C10462a>> hashMap;
        List<b> list = this.f405872e;
        return list != null && list.size() > 0 && (hashMap = this.f405873f) != null && hashMap.size() > 0;
    }

    public void a() {
        List<C10462a> list = this.f405871d;
        if (list != null && list.size() > 0) {
            e(this.f405871d);
        }
        if (l()) {
            Iterator<Map.Entry<String, List<C10462a>>> it = this.f405873f.entrySet().iterator();
            while (it.hasNext()) {
                e(it.next().getValue());
            }
            c(this.f405872e);
            List<C10462a> list2 = this.f405871d;
            if (list2 != null) {
                list2.addAll(f());
            } else {
                this.f405871d = f();
            }
            QLog.i("LSAutoTestConfigBeans", 4, "checkBeans | autoTestNode size:" + this.f405871d.size());
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public String f405890a;

        /* renamed from: b, reason: collision with root package name */
        public int f405891b;

        /* renamed from: c, reason: collision with root package name */
        public int f405892c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f405893d;

        /* renamed from: e, reason: collision with root package name */
        public String f405894e;

        /* renamed from: f, reason: collision with root package name */
        private String f405895f;

        /* renamed from: g, reason: collision with root package name */
        private String f405896g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ a f405897h;

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            String str;
            if (this.f405895f != null || (str = this.f405890a) == null) {
                return;
            }
            String str2 = str.split(File.separator)[r0.length - 1];
            int lastIndexOf = str2.lastIndexOf(46);
            if (lastIndexOf < 0) {
                return;
            }
            this.f405895f = str2.substring(0, lastIndexOf);
            this.f405896g = str2.substring(lastIndexOf);
            QLog.i("LSAutoTestConfigBeans", 4, "file name:" + this.f405895f + ",suffix:" + this.f405896g);
        }

        C10462a c(C10462a c10462a, String str) {
            C10462a c16;
            if (c10462a == null) {
                c16 = new C10462a();
            } else {
                c16 = c10462a.c();
            }
            c16.f405874a = this.f405890a;
            c16.f405876c = this.f405891b;
            c16.f405877d = this.f405892c;
            c16.f405879f = this.f405893d;
            c16.f405878e = "/sdcard/qq_img_auto_test/result_imgs/" + str + this.f405894e + File.separator + this.f405895f + c16.f405887n + this.f405896g;
            return c16;
        }
    }

    private void c(List<b> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    private void b(b bVar) {
        if (bVar == null || !bVar.f405893d || TextUtils.isEmpty(bVar.f405890a)) {
            return;
        }
        bVar.b();
    }

    private void d(C10462a c10462a) {
        if (c10462a == null) {
            return;
        }
        if (c10462a.f405880g == null) {
            c10462a.f405880g = new HashMap<>();
        }
        if (c10462a.f405875b) {
            return;
        }
        c10462a.f405888o = g();
        for (Map.Entry<String, Integer> entry : c10462a.f405880g.entrySet()) {
            BeautyRealConfig.TYPE type = f405867g.get(entry.getKey());
            if (type == null) {
                QLog.e("LSAutoTestConfigBeans", 4, "can not find related TYPE for param key: " + entry.getKey());
            } else {
                c10462a.f405888o.put(type, entry.getValue());
            }
        }
        d dVar = c10462a.f405884k;
        if (dVar == null) {
            c10462a.f405884k = i();
        } else if (!TextUtils.isEmpty(dVar.f405902a)) {
            c10462a.f405884k.f405902a = "/sdcard/qq_img_auto_test/materials/" + c10462a.f405884k.f405902a;
        }
        d dVar2 = c10462a.f405886m;
        if (dVar2 == null) {
            c10462a.f405886m = i();
        } else if (!TextUtils.isEmpty(dVar2.f405902a)) {
            c10462a.f405886m.f405902a = "/sdcard/qq_img_auto_test/lut_res/" + c10462a.f405886m.f405902a;
        }
        if (c10462a.f405882i == null) {
            c10462a.f405882i = i();
        }
        if (c10462a.f405883j == null) {
            c10462a.f405883j = i();
        }
        if (c10462a.f405881h == null) {
            c10462a.f405881h = h();
        }
    }
}

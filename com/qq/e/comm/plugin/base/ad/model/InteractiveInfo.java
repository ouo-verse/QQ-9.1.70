package com.qq.e.comm.plugin.base.ad.model;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.util.GDTLogger;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ams.fusion.widget.animatorplayer.AnimationItem;
import com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayInfo;
import com.tencent.mobileqq.qwallet.impl.QWalletPreferenceApiImpl;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes3.dex */
public class InteractiveInfo {
    public static final int DIRECTION_LEFT = 1;
    public static final int DIRECTION_LEFT_AND_RIGHT = 5;
    public static final int DIRECTION_RIGHT = 2;
    public static final int INTERACTIVE_MODE_CLICK = 1;
    public static final int INTERACTIVE_MODE_FLIP = 3;
    public static final int INTERACTIVE_MODE_LEAN_FORWARD = 4;
    public static final int INTERACTIVE_MODE_SCAN_QRCODE = 7;
    public static final int INTERACTIVE_MODE_SCROLL = 6;
    public static final int INTERACTIVE_MODE_SHAKE = 5;
    public static final int INTERACTIVE_MODE_SLIDE = 2;
    public static final int INTERACTIVE_MODE_TILT = 9;
    public static final int INTERACTIVE_MODE_TWIST = 8;
    public static final int INTERACTIVE_MODE_UNKNOWN = 0;
    public static final int INTERACTIVE_STATE_EASTER_EGG = 2;
    public static final int INTERACTIVE_STATE_FINISH = 3;
    public static final int INTERACTIVE_STATE_REPLAY = 4;
    public static final int INTERACTIVE_STATE_REPLAY_FINISH = 5;
    public static final int INTERACTIVE_STATE_SHOW_VIEW = 1;
    public static final int MASK_APPEAR_TYPE_DELAY = 1;
    public static final int MODE_CLICK = 2;
    public static final int MODE_SHAKE = 1;
    public static final int MODE_SHAKE_AND_CLICK = 3;
    public static final String TAG = "InteractiveInfo";
    private String B;
    private String C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private String K;
    private int L;
    private String M;
    private int N;
    private int O;
    private String P;
    private int Q;
    private int R;
    private t S;
    private int T;
    private c U;

    /* renamed from: ac, reason: collision with root package name */
    private String f38853ac;

    /* renamed from: ad, reason: collision with root package name */
    private String f38854ad;

    /* renamed from: f, reason: collision with root package name */
    private a f38859f;

    /* renamed from: g, reason: collision with root package name */
    private b f38860g;

    /* renamed from: j, reason: collision with root package name */
    private int f38863j;

    /* renamed from: k, reason: collision with root package name */
    private String f38864k;

    /* renamed from: l, reason: collision with root package name */
    private String f38865l;

    /* renamed from: m, reason: collision with root package name */
    private float f38866m;

    /* renamed from: n, reason: collision with root package name */
    private int f38867n;

    /* renamed from: o, reason: collision with root package name */
    private String f38868o;

    /* renamed from: p, reason: collision with root package name */
    private int f38869p;

    /* renamed from: q, reason: collision with root package name */
    private int f38870q;

    /* renamed from: r, reason: collision with root package name */
    private int f38871r;

    /* renamed from: s, reason: collision with root package name */
    private int f38872s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f38873t;

    /* renamed from: a, reason: collision with root package name */
    private int f38850a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f38855b = 6;

    /* renamed from: c, reason: collision with root package name */
    private String f38856c = "";

    /* renamed from: d, reason: collision with root package name */
    private String f38857d = "";

    /* renamed from: e, reason: collision with root package name */
    private double f38858e = 0.0d;

    /* renamed from: h, reason: collision with root package name */
    private boolean f38861h = false;

    /* renamed from: i, reason: collision with root package name */
    private int f38862i = 1;

    /* renamed from: u, reason: collision with root package name */
    private int f38874u = 0;

    /* renamed from: v, reason: collision with root package name */
    private int f38875v = 1000;

    /* renamed from: w, reason: collision with root package name */
    private int f38876w = 1000;

    /* renamed from: x, reason: collision with root package name */
    private int f38877x = 500;

    /* renamed from: y, reason: collision with root package name */
    private int f38878y = 3;

    /* renamed from: z, reason: collision with root package name */
    private float f38879z = 0.0f;
    private boolean A = true;
    private int[] V = null;
    private int W = 0;
    private int X = 0;
    private int[] Y = null;
    private int Z = 0;

    /* renamed from: aa, reason: collision with root package name */
    private int f38851aa = 0;

    /* renamed from: ab, reason: collision with root package name */
    private int f38852ab = 0;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface InteractiveState {
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f38880a;

        /* renamed from: b, reason: collision with root package name */
        public int f38881b;

        /* renamed from: c, reason: collision with root package name */
        public int f38882c;

        /* renamed from: d, reason: collision with root package name */
        public int f38883d;

        /* renamed from: e, reason: collision with root package name */
        public String f38884e;

        /* renamed from: h, reason: collision with root package name */
        public String f38887h;

        /* renamed from: i, reason: collision with root package name */
        public String f38888i;

        /* renamed from: j, reason: collision with root package name */
        public String f38889j;

        /* renamed from: k, reason: collision with root package name */
        public int f38890k;

        /* renamed from: l, reason: collision with root package name */
        public long f38891l;

        /* renamed from: m, reason: collision with root package name */
        public String f38892m;

        /* renamed from: o, reason: collision with root package name */
        private int f38894o;

        /* renamed from: f, reason: collision with root package name */
        public String f38885f = "\u70b9\u51fb\u4e86\u89e3\u8be6\u60c5";

        /* renamed from: g, reason: collision with root package name */
        public String f38886g = "0xFF6022";

        /* renamed from: n, reason: collision with root package name */
        public boolean f38893n = false;

        public boolean a() {
            return this.f38894o == 1;
        }

        public String b() {
            return this.f38887h;
        }

        public String c() {
            return this.f38892m;
        }

        public void a(int i3) {
            this.f38894o = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: c, reason: collision with root package name */
        private int f38897c;

        /* renamed from: d, reason: collision with root package name */
        private int f38898d;

        /* renamed from: e, reason: collision with root package name */
        private AnimationPlayInfo f38899e;

        /* renamed from: f, reason: collision with root package name */
        private final List<String> f38900f = new ArrayList();

        /* renamed from: g, reason: collision with root package name */
        private final List<JSONObject> f38901g = new ArrayList();

        /* renamed from: a, reason: collision with root package name */
        List<AnimationItem> f38895a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        List<Bitmap> f38896b = new ArrayList();

        public List<String> b() {
            return this.f38900f;
        }

        public AnimationPlayInfo a() {
            return this.f38899e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(JSONObject jSONObject) {
            if (y.a(jSONObject)) {
                this.f38899e = new AnimationPlayInfo();
                int optInt = jSONObject.optInt("animation_type");
                this.f38897c = optInt;
                this.f38899e.setAnimationType(optInt);
                JSONArray optJSONArray = jSONObject.optJSONArray("image_animation_set");
                if (!y.a(optJSONArray)) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        this.f38901g.add(optJSONArray.optJSONObject(i3));
                    }
                }
                a(jSONObject.optJSONArray("image_list"));
                JSONObject optJSONObject = jSONObject.optJSONObject("physical_property");
                if (!y.a(optJSONObject)) {
                    GDTLogger.d("InteractiveInfo null propertyJson:");
                    return;
                }
                this.f38899e.setFixedRotation(optJSONObject.optBoolean("enable_rotate"));
                this.f38899e.setFriction((float) optJSONObject.optDouble("friction"));
                this.f38899e.setGravity(optJSONObject.optInt("gravity_magnitude"));
                this.f38899e.setGravityAngle((float) optJSONObject.optDouble("gravity_direction"));
                if (optJSONObject.optInt("is_elastic") == 1) {
                    this.f38899e.setRestitution((float) optJSONObject.optDouble("elasticity"));
                } else {
                    this.f38899e.setRestitution(0.0f);
                }
                GDTLogger.d("InteractiveInfo android property:" + jSONObject);
                this.f38898d = optJSONObject.optInt(WidgetCacheConstellationData.INTERVAL);
            }
        }

        public void a(List<Rect> list) {
            if (com.qq.e.comm.plugin.k.g.b(list)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<Rect> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(AnimationItem.createBrokenItem(it.next()));
            }
            this.f38895a.addAll(0, arrayList);
        }

        private void a(JSONArray jSONArray) {
            if (y.a(jSONArray)) {
                return;
            }
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                this.f38900f.add(jSONArray.optString(i3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private int f38902a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f38903b = 0;

        /* renamed from: c, reason: collision with root package name */
        private int f38904c = 0;

        public c(JSONObject jSONObject) {
            a(jSONObject);
        }

        private void a(JSONObject jSONObject) {
            if (!y.a(jSONObject)) {
                return;
            }
            this.f38902a = y.c(jSONObject, IjkMediaMeta.IJKM_KEY_SAMPLE_RATE);
            this.f38903b = y.c(jSONObject, "energy_threshold");
            this.f38904c = y.c(jSONObject, "blow_times");
        }
    }

    public int A() {
        return this.f38877x;
    }

    public int B() {
        return this.I;
    }

    public int C() {
        return this.N;
    }

    public int D() {
        return this.O;
    }

    public int E() {
        return this.Q;
    }

    public t F() {
        return this.S;
    }

    public int[] G() {
        return this.V;
    }

    public int H() {
        return this.W;
    }

    public int I() {
        return this.X;
    }

    public int[] J() {
        return this.Y;
    }

    public String K() {
        return this.f38853ac;
    }

    public String L() {
        return this.f38854ad;
    }

    public void a(int i3) {
        this.f38850a = i3;
    }

    public void b(int i3) {
        this.f38855b = i3;
    }

    public void c(String str) {
        try {
            this.f38858e = Double.parseDouble(str);
        } catch (Exception e16) {
            GDTLogger.e("setTrackPrecision exception: " + e16.getMessage());
        }
    }

    public String d() {
        return this.f38856c;
    }

    public double e() {
        return this.f38858e;
    }

    public a f() {
        return this.f38859f;
    }

    public b g() {
        return this.f38860g;
    }

    public int h() {
        return this.f38862i;
    }

    public void i() {
        int i3 = this.f38862i;
        if (i3 == 1) {
            this.f38862i = 2;
            return;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 4) {
                    this.f38862i = 5;
                    return;
                } else if (i3 != 5) {
                    return;
                }
            }
            this.f38862i = 4;
            return;
        }
        this.f38862i = 3;
    }

    public String j() {
        return this.f38864k;
    }

    public String k() {
        return this.f38865l;
    }

    public float l() {
        return this.f38866m;
    }

    public int m() {
        return this.f38863j;
    }

    public int n() {
        return this.f38867n;
    }

    public String o() {
        return this.f38868o;
    }

    public int p() {
        return this.f38869p;
    }

    public int q() {
        return this.f38870q;
    }

    public boolean r() {
        return this.f38873t;
    }

    public int s() {
        return this.f38874u;
    }

    public int t() {
        return this.f38878y;
    }

    public String u() {
        return this.B;
    }

    public String v() {
        return this.C;
    }

    public int w() {
        return this.f38875v;
    }

    public int x() {
        return this.f38876w;
    }

    public boolean y() {
        return this.D;
    }

    public int z() {
        return this.E;
    }

    public void A(int i3) {
        this.X = i3;
    }

    public void B(int i3) {
        this.Z = i3;
    }

    public void a(String str) {
        this.f38856c = str;
    }

    public void b(String str) {
        this.f38857d = str;
    }

    public void d(String str) {
        this.f38864k = str;
    }

    public void e(String str) {
        this.f38865l = str;
    }

    public void f(String str) {
        this.f38868o = str;
    }

    public void g(int i3) {
        this.f38871r = i3;
    }

    public void h(int i3) {
        this.f38872s = i3;
    }

    public void j(int i3) {
        this.f38878y = i3;
    }

    public void k(int i3) {
        this.f38875v = i3;
    }

    public void l(int i3) {
        this.f38876w = i3;
    }

    public void m(int i3) {
        this.f38877x = i3;
    }

    public void n(int i3) {
        this.E = i3;
    }

    public void o(int i3) {
        this.F = i3;
    }

    public void p(int i3) {
        this.G = i3;
    }

    public void q(int i3) {
        this.H = i3;
    }

    public void r(int i3) {
        this.I = i3;
    }

    public void s(int i3) {
        this.J = i3;
    }

    public void t(int i3) {
        this.L = i3;
    }

    public void u(int i3) {
        this.N = i3;
    }

    public void v(int i3) {
        this.O = i3;
    }

    public void w(int i3) {
        this.Q = i3;
    }

    public void x(int i3) {
        this.R = i3;
    }

    public void y(int i3) {
        this.T = i3;
    }

    public void z(int i3) {
        this.W = i3;
    }

    public int a() {
        return this.f38850a;
    }

    public int b() {
        return this.f38855b;
    }

    public String c() {
        return this.f38857d;
    }

    public void d(int i3) {
        this.f38867n = i3;
    }

    public void e(int i3) {
        this.f38869p = i3;
    }

    public void f(int i3) {
        this.f38870q = i3;
    }

    public void g(String str) {
        this.B = str;
    }

    public void h(String str) {
        this.K = str;
    }

    public void j(String str) {
        this.P = str;
    }

    public void k(String str) {
        this.f38853ac = str;
    }

    public void l(String str) {
        this.f38854ad = str;
    }

    public void a(JSONObject jSONObject) {
        if (y.a(jSONObject)) {
            a aVar = new a();
            this.f38859f = aVar;
            aVar.a(jSONObject.optInt("is_page"));
            this.f38859f.f38881b = jSONObject.optInt("is_action_button");
            this.f38859f.f38882c = jSONObject.optInt("is_open_sound");
            this.f38859f.f38883d = jSONObject.optInt("sound_rate");
            this.f38859f.f38884e = jSONObject.optString("action_button_color");
            this.f38859f.f38892m = jSONObject.optString(QWalletPreferenceApiImpl.PREF_KEY_ZIP_URL);
            this.f38859f.f38893n = jSONObject.optBoolean("enable_auto_jump");
            String optString = jSONObject.optString("action_button_text");
            if (!TextUtils.isEmpty(optString)) {
                this.f38859f.f38885f = optString;
            }
            String optString2 = jSONObject.optString("action_button_background_color");
            if (!TextUtils.isEmpty(optString2)) {
                this.f38859f.f38886g = optString2;
            }
            this.f38859f.f38887h = jSONObject.optString("video_url");
            this.f38859f.f38888i = y.e(jSONObject, "image_url");
            this.f38859f.f38880a = y.e(jSONObject, "background_image_url");
            this.f38859f.f38889j = y.e(jSONObject, "text");
            this.f38859f.f38890k = y.b(jSONObject, "pullup_type", 1);
            this.f38859f.f38891l = y.b(jSONObject, "auto_open_landing_page_time", 1000);
        }
    }

    public void b(JSONObject jSONObject) {
        if (y.a(jSONObject)) {
            b bVar = new b();
            this.f38860g = bVar;
            bVar.a(jSONObject);
        }
    }

    public void c(int i3) {
        this.f38863j = i3;
    }

    public void d(JSONObject jSONObject) {
        if (y.a(jSONObject)) {
            this.U = new c(jSONObject);
        }
    }

    public void c(boolean z16) {
        this.D = z16;
    }

    public void c(JSONObject jSONObject) {
        this.S = new t(jSONObject);
    }

    public void i(int i3) {
        this.f38874u = i3;
    }

    public void b(double d16) {
        this.f38879z = (float) d16;
    }

    public void i(String str) {
        this.M = str;
    }

    public void b(boolean z16) {
        this.A = z16;
    }

    public void b(JSONArray jSONArray) {
        if (y.a(jSONArray)) {
            return;
        }
        this.Y = new int[jSONArray.length()];
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            this.Y[i3] = y.b(jSONArray, i3);
        }
    }

    public void a(double d16) {
        this.f38866m = (float) d16;
    }

    public void a(boolean z16) {
        this.f38873t = z16;
    }

    public void a(JSONArray jSONArray) {
        if (y.a(jSONArray)) {
            return;
        }
        this.V = new int[jSONArray.length()];
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            this.V[i3] = y.b(jSONArray, i3);
        }
    }
}

package com.tencent.mobileqq.bubble;

import android.graphics.Rect;
import com.qzone.widget.v;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f200705a;

    /* renamed from: b, reason: collision with root package name */
    public long f200706b;

    /* renamed from: c, reason: collision with root package name */
    public int f200707c;

    /* renamed from: d, reason: collision with root package name */
    public int f200708d;

    /* renamed from: e, reason: collision with root package name */
    public String f200709e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f200710f;

    /* renamed from: g, reason: collision with root package name */
    public int f200711g;

    /* renamed from: h, reason: collision with root package name */
    public String f200712h;

    /* renamed from: i, reason: collision with root package name */
    public Rect f200713i;

    /* renamed from: j, reason: collision with root package name */
    public Rect f200714j;

    /* renamed from: k, reason: collision with root package name */
    public String f200715k;

    /* renamed from: l, reason: collision with root package name */
    public int f200716l;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: m, reason: collision with root package name */
        public int f200717m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f200718n;

        /* renamed from: o, reason: collision with root package name */
        public String f200719o;

        /* renamed from: p, reason: collision with root package name */
        public String f200720p;

        /* renamed from: q, reason: collision with root package name */
        public Rect f200721q;

        /* renamed from: r, reason: collision with root package name */
        public Rect f200722r;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f200717m = -1;
            this.f200718n = false;
            this.f200719o = "";
            this.f200720p = "";
            this.f200721q = null;
            this.f200722r = null;
        }

        @Override // com.tencent.mobileqq.bubble.d
        public void a(int i3, String str, JSONObject jSONObject) throws Exception {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, jSONObject);
                return;
            }
            if (jSONObject != null) {
                super.a(i3, str, jSONObject);
                BaseApplication context = BaseApplication.getContext();
                this.f200717m = jSONObject.optInt("passive_type", -1);
                this.f200718n = jSONObject.optBoolean("passive_rotate", false);
                String optString = jSONObject.optString("start_align", this.f200712h);
                this.f200719o = optString;
                this.f200712h = optString;
                this.f200720p = jSONObject.optString("end_align", "");
                if (jSONObject.has("start_rect")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("start_rect");
                    Rect rect = new Rect();
                    this.f200721q = rect;
                    rect.left = BaseAIOUtils.f(jSONArray.getInt(0) / 2, context.getResources());
                    this.f200721q.top = BaseAIOUtils.f(jSONArray.getInt(1) / 2, context.getResources());
                    this.f200721q.right = BaseAIOUtils.f(jSONArray.getInt(2) / 2, context.getResources());
                    this.f200721q.bottom = BaseAIOUtils.f(jSONArray.getInt(3) / 2, context.getResources());
                    this.f200713i = this.f200721q;
                }
                if (jSONObject.has("end_rect")) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("end_rect");
                    Rect rect2 = new Rect();
                    this.f200722r = rect2;
                    rect2.left = BaseAIOUtils.f(jSONArray2.getInt(0) / 2, context.getResources());
                    this.f200722r.top = BaseAIOUtils.f(jSONArray2.getInt(1) / 2, context.getResources());
                    this.f200722r.right = BaseAIOUtils.f(jSONArray2.getInt(2) / 2, context.getResources());
                    this.f200722r.bottom = BaseAIOUtils.f(jSONArray2.getInt(3) / 2, context.getResources());
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class b extends d {
        static IPatchRedirector $redirector_;
        public boolean A;
        public int B;

        /* renamed from: m, reason: collision with root package name */
        public float f200723m;

        /* renamed from: n, reason: collision with root package name */
        public float f200724n;

        /* renamed from: o, reason: collision with root package name */
        public float f200725o;

        /* renamed from: p, reason: collision with root package name */
        public float f200726p;

        /* renamed from: q, reason: collision with root package name */
        public float f200727q;

        /* renamed from: r, reason: collision with root package name */
        public float f200728r;

        /* renamed from: s, reason: collision with root package name */
        public float f200729s;

        /* renamed from: t, reason: collision with root package name */
        public float f200730t;

        /* renamed from: u, reason: collision with root package name */
        public int f200731u;

        /* renamed from: v, reason: collision with root package name */
        public boolean f200732v;

        /* renamed from: w, reason: collision with root package name */
        public int f200733w;

        /* renamed from: x, reason: collision with root package name */
        public int f200734x;

        /* renamed from: y, reason: collision with root package name */
        public int f200735y;

        /* renamed from: z, reason: collision with root package name */
        public int f200736z;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f200731u = 0;
            this.f200732v = false;
            this.f200733w = 100;
            this.f200734x = 100;
            this.f200735y = 0;
            this.f200736z = 0;
            this.A = false;
            this.B = 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class c extends d {
        static IPatchRedirector $redirector_;

        /* renamed from: m, reason: collision with root package name */
        public String f200737m;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f200737m = "";
            }
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f200705a = "";
        this.f200706b = 0L;
        this.f200707c = 1;
        this.f200708d = 0;
        this.f200709e = "";
        this.f200711g = 0;
        this.f200712h = "";
        this.f200716l = 0;
    }

    public void a(int i3, String str, JSONObject jSONObject) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, jSONObject);
            return;
        }
        if (jSONObject == null) {
            return;
        }
        this.f200705a = str;
        this.f200716l = i3;
        BaseApplication context = BaseApplication.getContext();
        if (jSONObject.has(CanvasView.ACTION_RECT)) {
            JSONArray jSONArray = jSONObject.getJSONArray(CanvasView.ACTION_RECT);
            Rect rect = new Rect();
            this.f200713i = rect;
            rect.left = BaseAIOUtils.f(jSONArray.getInt(0) / 2, context.getResources());
            this.f200713i.top = BaseAIOUtils.f(jSONArray.getInt(1) / 2, context.getResources());
            this.f200713i.right = BaseAIOUtils.f(jSONArray.getInt(2) / 2, context.getResources());
            this.f200713i.bottom = BaseAIOUtils.f(jSONArray.getInt(3) / 2, context.getResources());
        }
        this.f200706b = jSONObject.optInt("time", 0);
        this.f200707c = jSONObject.optInt("cycle_count", 1);
        this.f200708d = jSONObject.optInt("count", 0);
        this.f200709e = jSONObject.optString("img_prefix", "");
        this.f200711g = jSONObject.optInt(com.tencent.luggage.wxa.c8.c.f123400v, 0);
        this.f200712h = jSONObject.optString("align", "");
        this.f200715k = jSONObject.optString(v.COLUMN_ZIP_NAME, "");
        this.f200710f = jSONObject.optBoolean("img_reverse", true);
        JSONArray optJSONArray = jSONObject.optJSONArray("padding");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            Rect rect2 = new Rect();
            this.f200714j = rect2;
            rect2.left = BaseAIOUtils.f(optJSONArray.getInt(0) / 2, context.getResources());
            this.f200714j.top = BaseAIOUtils.f(optJSONArray.getInt(1) / 2, context.getResources());
            this.f200714j.right = BaseAIOUtils.f(optJSONArray.getInt(2) / 2, context.getResources());
            this.f200714j.bottom = BaseAIOUtils.f(optJSONArray.getInt(3) / 2, context.getResources());
        }
    }
}

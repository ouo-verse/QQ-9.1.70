package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqmini.minigame.action.OperateCustomButton;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class hi extends hj {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = OperateCustomButton.OPERATE_CREATE)
    public long f148659a;

    /* renamed from: b, reason: collision with root package name */
    @Json(name = "destroy")
    public long f148660b;

    /* renamed from: c, reason: collision with root package name */
    @Json(name = "tag")
    public String f148661c;

    /* renamed from: d, reason: collision with root package name */
    @Json(name = "mapLoad")
    private hd f148662d;

    /* renamed from: e, reason: collision with root package name */
    @Json(name = "oversea")
    private hf f148663e;

    /* renamed from: f, reason: collision with root package name */
    @Json(name = "indoorLog")
    private hc f148664f;

    /* renamed from: h, reason: collision with root package name */
    @Json(name = "darkMode")
    private gx f148665h;

    /* renamed from: i, reason: collision with root package name */
    @Json(name = "pointEvent")
    private hg f148666i;

    /* renamed from: j, reason: collision with root package name */
    @Json(name = "aoi")
    private gs f148667j;

    /* renamed from: k, reason: collision with root package name */
    @Json(name = "vectorHeat")
    private hm f148668k;

    /* renamed from: l, reason: collision with root package name */
    @Json(name = "heatMap")
    private hb f148669l;

    /* renamed from: m, reason: collision with root package name */
    @Json(name = "arcLine")
    private gt f148670m;

    /* renamed from: n, reason: collision with root package name */
    @Json(name = "dotScatter")
    private gy f148671n;

    /* renamed from: o, reason: collision with root package name */
    @Json(name = "bitmapScatter")
    private gv f148672o;

    /* renamed from: p, reason: collision with root package name */
    @Json(name = "trail")
    private hk f148673p;

    /* renamed from: q, reason: collision with root package name */
    @Json(name = "model")
    private gz f148674q;

    /* renamed from: r, reason: collision with root package name */
    @Json(name = "groundOverlay")
    private ha f148675r;

    /* renamed from: s, reason: collision with root package name */
    @Json(name = "offline")
    private he f148676s;

    /* renamed from: t, reason: collision with root package name */
    @Json(name = "customStyle")
    private gw f148677t;

    /* renamed from: u, reason: collision with root package name */
    @Json(name = "ugc")
    private hl f148678u;

    /* renamed from: v, reason: collision with root package name */
    @Json(name = WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_PROMOTE)
    private hh f148679v;

    /* renamed from: w, reason: collision with root package name */
    @Json(name = WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH)
    private gu f148680w;

    hi() {
    }

    private void a(String str) {
        this.f148661c = str;
    }

    private hi u() {
        this.f148660b = System.currentTimeMillis() - this.f148659a;
        return this;
    }

    public final hf b() {
        if (this.f148663e == null) {
            this.f148663e = new hf(System.currentTimeMillis() - this.f148681g);
        }
        return this.f148663e;
    }

    public final hl c() {
        if (this.f148678u == null) {
            this.f148678u = new hl(System.currentTimeMillis() - this.f148681g);
        }
        return this.f148678u;
    }

    public final hc d() {
        if (this.f148664f == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.f148681g;
            this.f148664f = new hc(currentTimeMillis - j3, j3);
        }
        return this.f148664f;
    }

    public final gx e() {
        if (this.f148665h == null) {
            this.f148665h = new gx(System.currentTimeMillis() - this.f148681g);
        }
        return this.f148665h;
    }

    public final hg f() {
        if (this.f148666i == null) {
            this.f148666i = new hg(System.currentTimeMillis() - this.f148681g);
        }
        return this.f148666i;
    }

    public final gs g() {
        if (this.f148667j == null) {
            this.f148667j = new gs(System.currentTimeMillis() - this.f148681g);
        }
        return this.f148667j;
    }

    public final hm h() {
        if (this.f148668k == null) {
            this.f148668k = new hm(System.currentTimeMillis() - this.f148681g);
        }
        return this.f148668k;
    }

    public final hb i() {
        if (this.f148669l == null) {
            this.f148669l = new hb(System.currentTimeMillis() - this.f148681g);
        }
        return this.f148669l;
    }

    public final gt j() {
        if (this.f148670m == null) {
            this.f148670m = new gt(System.currentTimeMillis() - this.f148681g);
        }
        return this.f148670m;
    }

    public final gy k() {
        if (this.f148671n == null) {
            this.f148671n = new gy(System.currentTimeMillis() - this.f148681g);
        }
        return this.f148671n;
    }

    public final gv l() {
        if (this.f148672o == null) {
            this.f148672o = new gv(System.currentTimeMillis() - this.f148681g);
        }
        return this.f148672o;
    }

    public final hk m() {
        if (this.f148673p == null) {
            this.f148673p = new hk(System.currentTimeMillis() - this.f148681g);
        }
        return this.f148673p;
    }

    public final gz n() {
        if (this.f148674q == null) {
            this.f148674q = new gz(System.currentTimeMillis() - this.f148681g);
        }
        return this.f148674q;
    }

    public final ha o() {
        if (this.f148675r == null) {
            this.f148675r = new ha(System.currentTimeMillis() - this.f148681g);
        }
        return this.f148675r;
    }

    public final he p() {
        if (this.f148676s == null) {
            this.f148676s = new he(System.currentTimeMillis() - this.f148681g);
        }
        return this.f148676s;
    }

    public final gw q() {
        if (this.f148677t == null) {
            this.f148677t = new gw(System.currentTimeMillis() - this.f148681g);
        }
        return this.f148677t;
    }

    public final hh r() {
        if (this.f148679v == null) {
            this.f148679v = new hh(System.currentTimeMillis() - this.f148681g);
        }
        return this.f148679v;
    }

    public final gu s() {
        if (this.f148680w == null) {
            this.f148680w = new gu(System.currentTimeMillis() - this.f148681g);
        }
        return this.f148680w;
    }

    public hi(long j3) {
        super(j3);
        this.f148659a = j3;
    }

    public final hd a() {
        if (this.f148662d == null) {
            this.f148662d = new hd(this.f148681g);
        }
        return this.f148662d;
    }
}

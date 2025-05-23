package com.tencent.mobileqq.ar.arengine;

import android.graphics.RectF;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch$JdSearchDetail;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch$JdSearchRsp;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch$JdSkuItem;
import com.tencent.mobileqq.ar.arcloud.pb.JDSearch$Rectangle;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ac extends com.tencent.mobileqq.ar.arengine.e implements com.tencent.mobileqq.ar.arengine.f {

    /* renamed from: p, reason: collision with root package name */
    public static final String f197990p = HardCodeUtil.qqStr(R.string.jqw);

    /* renamed from: e, reason: collision with root package name */
    public int f197991e;

    /* renamed from: f, reason: collision with root package name */
    public String f197992f;

    /* renamed from: g, reason: collision with root package name */
    public long f197993g;

    /* renamed from: h, reason: collision with root package name */
    public int f197994h;

    /* renamed from: i, reason: collision with root package name */
    public String f197995i;

    /* renamed from: j, reason: collision with root package name */
    public g[] f197996j;

    /* renamed from: k, reason: collision with root package name */
    public int f197997k;

    /* renamed from: l, reason: collision with root package name */
    public String f197998l;

    /* renamed from: m, reason: collision with root package name */
    public f f197999m;

    /* renamed from: n, reason: collision with root package name */
    public c f198000n;

    /* renamed from: o, reason: collision with root package name */
    public String f198001o;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f198008a;

        /* renamed from: b, reason: collision with root package name */
        public String f198009b;

        /* renamed from: c, reason: collision with root package name */
        public String f198010c;

        /* renamed from: d, reason: collision with root package name */
        public String f198011d;

        /* renamed from: e, reason: collision with root package name */
        public String f198012e;

        public String toString() {
            return "skuId:" + this.f198010c + ",skuName:" + this.f198011d + ",skuPrice:" + this.f198012e + ",imageUrl:" + this.f198009b + ",detailUrl:" + this.f198008a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f198013a;

        /* renamed from: b, reason: collision with root package name */
        public String f198014b;

        /* renamed from: c, reason: collision with root package name */
        public int f198015c;

        /* renamed from: d, reason: collision with root package name */
        public String f198016d;

        /* renamed from: e, reason: collision with root package name */
        public String f198017e;

        /* renamed from: f, reason: collision with root package name */
        b[] f198018f;

        /* renamed from: g, reason: collision with root package name */
        public String f198019g;

        /* renamed from: h, reason: collision with root package name */
        public RectF f198020h = new RectF();

        /* renamed from: i, reason: collision with root package name */
        public int f198021i = -1;

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ssoErrCode:");
            sb5.append(this.f198013a);
            sb5.append(",ssoErrMsg:");
            sb5.append(this.f198014b);
            sb5.append(",errCode:");
            sb5.append(this.f198015c);
            sb5.append(",errMsg:");
            sb5.append(this.f198016d);
            sb5.append(",sessionId:");
            sb5.append(this.f198017e);
            sb5.append(",moreUrl:");
            sb5.append(this.f198019g);
            int i3 = 0;
            while (true) {
                b[] bVarArr = this.f198018f;
                if (bVarArr == null || i3 >= bVarArr.length) {
                    break;
                }
                sb5.append("\n{index=");
                sb5.append(i3);
                sb5.append(":");
                sb5.append(this.f198018f[i3].toString());
                sb5.append("}\n");
                i3++;
            }
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f198022a;

        /* renamed from: b, reason: collision with root package name */
        public String f198023b;

        /* renamed from: c, reason: collision with root package name */
        public String f198024c;

        /* renamed from: d, reason: collision with root package name */
        public String f198025d;

        /* renamed from: e, reason: collision with root package name */
        public String f198026e;

        /* renamed from: f, reason: collision with root package name */
        public String f198027f;
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class e {

        /* renamed from: b, reason: collision with root package name */
        public RectF f198029b;

        /* renamed from: c, reason: collision with root package name */
        public String f198030c;

        /* renamed from: d, reason: collision with root package name */
        public double f198031d;

        /* renamed from: e, reason: collision with root package name */
        public String f198032e;

        /* renamed from: f, reason: collision with root package name */
        public String f198033f;

        /* renamed from: g, reason: collision with root package name */
        public String f198034g;

        /* renamed from: h, reason: collision with root package name */
        public byte[] f198035h;

        /* renamed from: a, reason: collision with root package name */
        public boolean f198028a = false;

        /* renamed from: i, reason: collision with root package name */
        public boolean f198036i = false;
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public int f198037a;

        /* renamed from: b, reason: collision with root package name */
        public int f198038b;

        /* renamed from: c, reason: collision with root package name */
        public int f198039c;

        /* renamed from: d, reason: collision with root package name */
        public int f198040d;

        /* renamed from: e, reason: collision with root package name */
        public float f198041e;

        /* renamed from: f, reason: collision with root package name */
        public int f198042f;

        public String toString() {
            return "xMIN:" + this.f198037a + ",xMAX:" + this.f198038b + ",yMIN:" + this.f198039c + ",yMAX:" + this.f198040d;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public int f198043a;

        /* renamed from: b, reason: collision with root package name */
        public String f198044b;

        /* renamed from: c, reason: collision with root package name */
        public double f198045c;

        /* renamed from: d, reason: collision with root package name */
        public h[] f198046d;

        /* renamed from: e, reason: collision with root package name */
        public int f198047e;

        public String toString() {
            StringBuilder sb5 = new StringBuilder("");
            h[] hVarArr = this.f198046d;
            if (hVarArr != null && hVarArr.length > 0) {
                for (int i3 = 0; i3 < this.f198046d.length; i3++) {
                    sb5.append("\n index:");
                    sb5.append(i3);
                    sb5.append(this.f198046d[i3].toString());
                    sb5.append('\n');
                }
            } else {
                sb5.append("\n only have one itemContent:" + this.f198044b + ",prob:" + this.f198045c);
                sb5.append('\n');
            }
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public int f198048a;

        /* renamed from: b, reason: collision with root package name */
        public String f198049b;

        /* renamed from: c, reason: collision with root package name */
        public double f198050c;

        /* renamed from: d, reason: collision with root package name */
        public String f198051d;

        /* renamed from: e, reason: collision with root package name */
        public d f198052e;

        /* renamed from: f, reason: collision with root package name */
        public int f198053f;

        /* renamed from: g, reason: collision with root package name */
        public String f198054g;

        /* renamed from: h, reason: collision with root package name */
        public String f198055h;

        /* renamed from: i, reason: collision with root package name */
        public String f198056i;

        /* renamed from: j, reason: collision with root package name */
        public String f198057j;

        /* renamed from: k, reason: collision with root package name */
        public byte[] f198058k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f198059l = false;

        /* renamed from: m, reason: collision with root package name */
        public boolean f198060m = false;

        /* renamed from: n, reason: collision with root package name */
        public int f198061n = 0;

        /* renamed from: o, reason: collision with root package name */
        public String f198062o = "";

        public String toString() {
            String str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("result:{sclass:");
            String str2 = this.f198049b;
            String str3 = "";
            if (str2 == null) {
                str2 = "";
            }
            sb5.append(str2);
            sb5.append(",");
            sb5.append("sItemId:");
            d dVar = this.f198052e;
            if (dVar == null) {
                str = "";
            } else {
                str = dVar.f198022a;
            }
            sb5.append(str);
            sb5.append(",");
            sb5.append("dProb:");
            sb5.append(this.f198050c);
            sb5.append(",");
            sb5.append("sTitle:");
            sb5.append(this.f198055h);
            sb5.append(",");
            sb5.append("sWiki:");
            sb5.append(this.f198056i);
            sb5.append(",");
            sb5.append("sJumpUrl:");
            sb5.append(this.f198057j);
            sb5.append(",");
            sb5.append("sCdbRes:");
            byte[] bArr = this.f198058k;
            if (bArr != null) {
                str3 = new String(bArr);
            }
            sb5.append(str3);
            sb5.append(",");
            sb5.append("isAutoJump:");
            sb5.append(this.f198059l);
            sb5.append(",");
            sb5.append("iNeedCheckLBS:");
            sb5.append(this.f198061n);
            sb5.append(",");
            sb5.append("imageId:");
            sb5.append(this.f198062o);
            sb5.append("}");
            return sb5.toString();
        }
    }

    public ac() {
        super(2, 0);
        this.f197991e = -1;
        this.f198001o = "";
    }

    private e d() {
        if (!j()) {
            return null;
        }
        e eVar = new e();
        h g16 = g();
        if (g16 == null) {
            return null;
        }
        if (this.f197999m != null) {
            f fVar = this.f197999m;
            eVar.f198029b = new RectF(fVar.f198037a, fVar.f198039c, fVar.f198038b, fVar.f198040d);
        } else {
            eVar.f198029b = new RectF();
        }
        boolean z16 = false;
        if (g16.f198060m) {
            eVar.f198030c = g16.f198049b;
            eVar.f198028a = false;
            eVar.f198031d = g16.f198050c;
        } else {
            eVar.f198030c = g16.f198052e.f198022a;
            byte[] bArr = g16.f198058k;
            if (bArr != null && bArr.length > 20) {
                z16 = true;
            }
            eVar.f198028a = z16;
            eVar.f198031d = g16.f198050c;
            eVar.f198035h = bArr;
            eVar.f198032e = g16.f198055h;
            eVar.f198033f = g16.f198056i;
            eVar.f198034g = g16.f198057j;
            eVar.f198036i = g16.f198059l;
        }
        return eVar;
    }

    private h g() {
        g[] gVarArr;
        h hVar = null;
        if (!j()) {
            return null;
        }
        int i3 = 0;
        while (true) {
            gVarArr = this.f197996j;
            if (i3 >= gVarArr.length) {
                break;
            }
            int i16 = 0;
            while (true) {
                h[] hVarArr = this.f197996j[i3].f198046d;
                if (hVarArr != null && i16 < hVarArr.length) {
                    if (hVar == null || hVarArr[i16].f198050c < hVar.f198050c) {
                        hVar = hVarArr[i3];
                    }
                    i16++;
                }
            }
            i3++;
        }
        if (hVar == null && gVarArr.length == 1) {
            h hVar2 = new h();
            hVar2.f198060m = true;
            g gVar = this.f197996j[0];
            String str = gVar.f198044b;
            hVar2.f198049b = str;
            hVar2.f198050c = gVar.f198045c;
            hVar2.f198051d = str;
            hVar2.f198061n = 0;
            hVar2.f198062o = "";
            return hVar2;
        }
        return hVar;
    }

    public static c m(JDSearch$JdSearchRsp jDSearch$JdSearchRsp) {
        int i3;
        String str;
        int i16;
        String str2;
        String str3;
        List<JDSearch$JdSkuItem> list;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        float f16;
        float f17;
        float f18;
        c cVar = new c();
        int i17 = -1;
        if (jDSearch$JdSearchRsp.jd_search_errorcode.has()) {
            i3 = jDSearch$JdSearchRsp.jd_search_errorcode.get();
        } else {
            i3 = -1;
        }
        cVar.f198013a = i3;
        if (!jDSearch$JdSearchRsp.jd_search_errormsg.has()) {
            str = "";
        } else {
            str = jDSearch$JdSearchRsp.jd_search_errormsg.get();
        }
        cVar.f198014b = str;
        if (jDSearch$JdSearchRsp.jd_search_detail.has()) {
            JDSearch$JdSearchDetail jDSearch$JdSearchDetail = jDSearch$JdSearchRsp.jd_search_detail.get();
            if (jDSearch$JdSearchDetail.errorcode.has()) {
                i16 = jDSearch$JdSearchDetail.errorcode.get();
            } else {
                i16 = -1;
            }
            cVar.f198015c = i16;
            if (!jDSearch$JdSearchDetail.errormsg.has()) {
                str2 = "";
            } else {
                str2 = jDSearch$JdSearchDetail.errormsg.get();
            }
            cVar.f198016d = str2;
            if (!jDSearch$JdSearchDetail.jd_more_url.has()) {
                str3 = "";
            } else {
                str3 = jDSearch$JdSearchDetail.jd_more_url.get();
            }
            cVar.f198019g = str3;
            if (jDSearch$JdSearchDetail.rectangle.has()) {
                JDSearch$Rectangle jDSearch$Rectangle = jDSearch$JdSearchDetail.rectangle.get();
                RectF rectF = cVar.f198020h;
                float f19 = 0.0f;
                if (jDSearch$Rectangle.left.has()) {
                    f16 = jDSearch$Rectangle.left.get();
                } else {
                    f16 = 0.0f;
                }
                rectF.left = f16;
                RectF rectF2 = cVar.f198020h;
                if (jDSearch$Rectangle.top.has()) {
                    f17 = jDSearch$Rectangle.top.get();
                } else {
                    f17 = 0.0f;
                }
                rectF2.top = f17;
                RectF rectF3 = cVar.f198020h;
                if (jDSearch$Rectangle.right.has()) {
                    f18 = jDSearch$Rectangle.right.get();
                } else {
                    f18 = 0.0f;
                }
                rectF3.right = f18;
                RectF rectF4 = cVar.f198020h;
                if (jDSearch$Rectangle.bottom.has()) {
                    f19 = jDSearch$Rectangle.bottom.get();
                }
                rectF4.bottom = f19;
                if (jDSearch$Rectangle.is_user_rectangle.has()) {
                    i17 = jDSearch$Rectangle.is_user_rectangle.get();
                }
                cVar.f198021i = i17;
            }
            if (jDSearch$JdSearchDetail.jd_sku_item.has()) {
                list = jDSearch$JdSearchDetail.jd_sku_item.get();
            } else {
                list = null;
            }
            if (list != null && !list.isEmpty()) {
                cVar.f198018f = new b[list.size()];
            }
            if (list != null && list.size() > 0) {
                int i18 = 0;
                for (JDSearch$JdSkuItem jDSearch$JdSkuItem : list) {
                    cVar.f198018f[i18] = new b();
                    b bVar = cVar.f198018f[i18];
                    if (!jDSearch$JdSkuItem.detail_url.has()) {
                        str4 = "";
                    } else {
                        str4 = jDSearch$JdSkuItem.detail_url.get();
                    }
                    bVar.f198008a = str4;
                    b bVar2 = cVar.f198018f[i18];
                    if (!jDSearch$JdSkuItem.image_url.has()) {
                        str5 = "";
                    } else {
                        str5 = jDSearch$JdSkuItem.image_url.get();
                    }
                    bVar2.f198009b = str5;
                    b bVar3 = cVar.f198018f[i18];
                    if (!jDSearch$JdSkuItem.sku_id.has()) {
                        str6 = "";
                    } else {
                        str6 = jDSearch$JdSkuItem.sku_id.get();
                    }
                    bVar3.f198010c = str6;
                    b bVar4 = cVar.f198018f[i18];
                    if (!jDSearch$JdSkuItem.sku_name.has()) {
                        str7 = "";
                    } else {
                        str7 = jDSearch$JdSkuItem.sku_name.get();
                    }
                    bVar4.f198011d = str7;
                    b bVar5 = cVar.f198018f[i18];
                    if (!jDSearch$JdSkuItem.sku_price.has()) {
                        str8 = "";
                    } else {
                        str8 = jDSearch$JdSkuItem.sku_price.get();
                    }
                    bVar5.f198012e = str8;
                    i18++;
                }
            }
        }
        return cVar;
    }

    @Override // com.tencent.mobileqq.ar.arengine.f
    public byte[] a() {
        e d16 = d();
        if (d16 != null && d16.f198028a) {
            return d16.f198035h;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.ar.arengine.e
    public boolean b() {
        return j();
    }

    public a e() {
        a aVar = new a();
        aVar.f198003b = true;
        aVar.f198007f = this.f198000n;
        aVar.f198006e = d();
        aVar.f198005d = false;
        return aVar;
    }

    public String f() {
        h g16 = g();
        if (g16 == null) {
            return "";
        }
        return g16.f198062o;
    }

    public int h() {
        h g16;
        byte[] bArr;
        if (!b()) {
            return -1;
        }
        if (j() && (g16 = g()) != null && (bArr = g16.f198058k) != null && bArr.length > 20) {
            return 1;
        }
        return 0;
    }

    public boolean i() {
        c cVar;
        b[] bVarArr;
        if (this.f197991e == 0 && (cVar = this.f198000n) != null && cVar.f198013a == 0 && cVar.f198015c == 0 && (bVarArr = cVar.f198018f) != null && bVarArr.length > 0) {
            return true;
        }
        return false;
    }

    public boolean j() {
        g[] gVarArr;
        if (this.f197991e != 0 || this.f197994h != 0 || (gVarArr = this.f197996j) == null || gVarArr.length <= 0 || gVarArr[0].f198044b.equalsIgnoreCase(f197990p)) {
            return false;
        }
        return true;
    }

    public boolean k(ac acVar) {
        if (acVar == null) {
            return false;
        }
        h g16 = acVar.g();
        h g17 = g();
        if (g16 == null || g17 == null || !g16.f198049b.equalsIgnoreCase(g17.f198049b)) {
            return false;
        }
        return true;
    }

    public boolean l() {
        h g16 = g();
        if (g16 == null || g16.f198061n != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.ar.arengine.n
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (j()) {
            sb5.append("\n {migObjectClassifyResult:" + this.f197996j[0].toString() + "} \n");
        }
        if (i()) {
            sb5.append("\n {jdSearchResult:" + this.f198000n.toString() + "}\n");
        }
        return sb5.toString();
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a extends ab {

        /* renamed from: g, reason: collision with root package name */
        public static final a f198002g = new a(false);

        /* renamed from: b, reason: collision with root package name */
        public boolean f198003b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f198004c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f198005d;

        /* renamed from: e, reason: collision with root package name */
        public e f198006e;

        /* renamed from: f, reason: collision with root package name */
        public c f198007f;

        public a() {
            this.f198003b = false;
            this.f198004c = false;
            this.f198005d = false;
            this.f197989a = 128L;
        }

        public a(boolean z16) {
            this.f198004c = false;
            this.f198005d = false;
            this.f197989a = 128L;
            this.f198003b = z16;
        }
    }
}

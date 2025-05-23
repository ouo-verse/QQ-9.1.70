package com.tencent.mapsdk.internal;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.map.tools.net.exception.NetErrorException;
import com.tencent.map.tools.net.exception.NetUnavailableException;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.vector.VectorMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class tt extends lu {

    /* renamed from: a, reason: collision with root package name */
    private Context f151099a;

    /* renamed from: c, reason: collision with root package name */
    private String f151101c;

    /* renamed from: e, reason: collision with root package name */
    private String f151103e;

    /* renamed from: f, reason: collision with root package name */
    private String f151104f;

    /* renamed from: g, reason: collision with root package name */
    private VectorMap f151105g;

    /* renamed from: h, reason: collision with root package name */
    private hi f151106h;

    /* renamed from: b, reason: collision with root package name */
    private lz f151100b = new lz();

    /* renamed from: d, reason: collision with root package name */
    private String f151102d = "";

    public tt(tz tzVar) {
        this.f151101c = "UNKNOW";
        Context H = tzVar.H();
        this.f151099a = H;
        this.f151101c = H.getClass().getSimpleName();
        this.f151099a = this.f151099a.getApplicationContext();
        this.f151105g = (VectorMap) tzVar.e_;
        this.f151106h = tzVar.aC.f147918e;
    }

    private String a(@NonNull String str) {
        ne neVar;
        String scheme;
        dr drVar = (dr) cr.a(dr.class);
        Cdo cdo = (Cdo) cr.a(Cdo.class);
        String indoorMapUrl = ((dc) drVar.i()).getIndoorMapUrl();
        String indoorMapUrl2 = ((da) cdo.i()).getIndoorMapUrl();
        Uri parse = Uri.parse(str);
        Uri parse2 = Uri.parse(indoorMapUrl);
        Uri parse3 = Uri.parse(indoorMapUrl2);
        String c16 = hs.c(parse.getAuthority());
        String c17 = hs.c(parse.getPath());
        String c18 = hs.c(parse2.getPath());
        String c19 = hs.c(parse3.getPath());
        if (c16.equals(parse2.getAuthority()) && (c17.startsWith(c18) || c17.startsWith(c19))) {
            if (cdo.f148118b) {
                scheme = "https";
            } else {
                scheme = parse.getScheme();
            }
            str = parse3.buildUpon().scheme(scheme).encodedPath(c17.replace(c18, c19)).encodedQuery(parse.getQuery()).appendQueryParameter("type", "1").toString();
        }
        dy dyVar = (dy) cr.a(dy.class);
        if (dyVar != null && !str.endsWith(".jpg") && !str.startsWith(dyVar.j())) {
            VectorMap vectorMap = this.f151105g;
            if (vectorMap != null && (neVar = vectorMap.f151351o) != null) {
                neVar.D();
                this.f151103e = this.f151105g.f151351o.D().f147927c;
                this.f151104f = this.f151105g.f151351o.D().f147928d;
            }
            return str + this.f151102d + ho.a(this.f151101c, this.f151103e, this.f151104f);
        }
        return str;
    }

    @Override // com.tencent.mapsdk.internal.lu
    public final byte[] f(String str) {
        int i3;
        ne neVar;
        String scheme;
        LogUtil.b(ky.B, "download url : ".concat(String.valueOf(str)));
        if (this.f151099a == null || hs.a(str) || !this.f151100b.a(str)) {
            return null;
        }
        if (this.f151105g != null && hs.a(this.f151102d) && !hs.a(this.f151105g.z())) {
            this.f151102d = "&eng_ver=" + this.f151105g.z();
        }
        dr drVar = (dr) cr.a(dr.class);
        Cdo cdo = (Cdo) cr.a(Cdo.class);
        String indoorMapUrl = ((dc) drVar.i()).getIndoorMapUrl();
        String indoorMapUrl2 = ((da) cdo.i()).getIndoorMapUrl();
        Uri parse = Uri.parse(str);
        Uri parse2 = Uri.parse(indoorMapUrl);
        Uri parse3 = Uri.parse(indoorMapUrl2);
        String c16 = hs.c(parse.getAuthority());
        String c17 = hs.c(parse.getPath());
        String c18 = hs.c(parse2.getPath());
        String c19 = hs.c(parse3.getPath());
        if (c16.equals(parse2.getAuthority()) && (c17.startsWith(c18) || c17.startsWith(c19))) {
            if (cdo.f148118b) {
                scheme = "https";
            } else {
                scheme = parse.getScheme();
            }
            str = parse3.buildUpon().scheme(scheme).encodedPath(c17.replace(c18, c19)).encodedQuery(parse.getQuery()).appendQueryParameter("type", "1").toString();
        }
        dy dyVar = (dy) cr.a(dy.class);
        if (dyVar != null && !str.endsWith(".jpg") && !str.startsWith(dyVar.j())) {
            VectorMap vectorMap = this.f151105g;
            if (vectorMap != null && (neVar = vectorMap.f151351o) != null) {
                neVar.D();
                this.f151103e = this.f151105g.f151351o.D().f147927c;
                this.f151104f = this.f151105g.f151351o.D().f147928d;
            }
            str = str + this.f151102d + ho.a(this.f151101c, this.f151103e, this.f151104f);
        }
        LogUtil.b(ky.B, "rectify url : ".concat(String.valueOf(str)));
        try {
            NetResponse doGet = NetManager.getInstance().builder().url(str).userAgent(NetUtil.STR_UserAgent).doGet();
            if (doGet == null) {
                return null;
            }
            if (!str.contains("qt=rtt")) {
                this.f151100b.b(str);
            }
            return doGet.data;
        } catch (Exception e16) {
            if (str.contains("/mvd_map")) {
                if (e16 instanceof NetUnavailableException) {
                    i3 = ((NetUnavailableException) e16).errorCode;
                } else if (e16 instanceof NetErrorException) {
                    i3 = ((NetErrorException) e16).statusCode;
                } else {
                    i3 = -1;
                }
                this.f151106h.a().a(System.currentTimeMillis(), str.substring(str.indexOf(63) + 1), i3);
            }
            return null;
        }
    }
}

package com.tencent.luggage.wxa.k3;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.wxa.bk.e;
import com.tencent.luggage.wxa.fd.n;
import com.tencent.luggage.wxa.ii.h;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.mc.g;
import com.tencent.luggage.wxa.mc.j0;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.z4.f;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.k3.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public enum EnumC6356a {
        OK,
        ERR_URL_INVALID,
        ERR_UIN_INVALID,
        ERR_DEV_CODE_EXPIRED
    }

    public final EnumC6356a a(Context context, String str, int i3) {
        Uri parse;
        EnumC6356a a16;
        w.d("Luggage.AbsLinkOpener", "handle url = %s", str);
        if (w0.c(str)) {
            a16 = EnumC6356a.ERR_URL_INVALID;
            parse = null;
        } else {
            int indexOf = str.indexOf(35);
            int indexOf2 = str.indexOf(63);
            if (indexOf > 0 && indexOf2 > 0 && indexOf < indexOf2) {
                str = str.substring(0, indexOf) + str.substring(indexOf2, str.length());
                w.d("Luggage.AbsLinkOpener", "replace url for parsing %s", str);
            }
            parse = Uri.parse(str);
            a16 = a(context, str, parse, i3);
        }
        a(str, parse, i3, a16);
        return a16;
    }

    public abstract void a(Context context, String str, String str2, String str3, int i3, int i16, e eVar, n nVar, b bVar);

    public abstract void a(String str, Uri uri, int i3, EnumC6356a enumC6356a);

    public final EnumC6356a a(Context context, String str, Uri uri, int i3) {
        if (w0.a(uri.getQueryParameter("debug"), 0) > 0) {
            int a16 = w0.a(uri.getQueryParameter("ret"), 0);
            if (a16 == 1) {
                return EnumC6356a.ERR_UIN_INVALID;
            }
            if (a16 == 2) {
                return EnumC6356a.ERR_DEV_CODE_EXPIRED;
            }
            String queryParameter = uri.getQueryParameter("appid");
            String queryParameter2 = uri.getQueryParameter("username");
            String d16 = w0.d(uri.getQueryParameter("path"));
            String queryParameter3 = uri.getQueryParameter("codeurl");
            String queryParameter4 = uri.getQueryParameter("md5");
            w0.a(uri.getQueryParameter("test_lifespan"), 7200L);
            if (!w0.c(queryParameter) && !w0.c(queryParameter2) && !w0.c(queryParameter3)) {
                if (e.a.a(queryParameter2, queryParameter)) {
                    new g("qrcode", queryParameter3, queryParameter4).c();
                    return EnumC6356a.OK;
                }
                boolean a17 = j0.a().a(queryParameter, 1, queryParameter3, queryParameter4);
                w.d("Luggage.AbsLinkOpener", "updated:%b", Boolean.valueOf(a17));
                if (a17) {
                    f.a().f(queryParameter, -1);
                }
                String queryParameter5 = uri.getQueryParameter("json_extinfo");
                b bVar = new b();
                bVar.f136267c = queryParameter5;
                h.a().a(queryParameter, 1, queryParameter5);
                a(context, queryParameter, queryParameter2, d16, 1, -1, new com.tencent.luggage.wxa.bk.e(), null, bVar);
                return EnumC6356a.OK;
            }
            w.d("Luggage.AbsLinkOpener", "appId = %s, username = %s, codeURL = %s, invalid, return", queryParameter, queryParameter2, queryParameter3);
            return EnumC6356a.ERR_URL_INVALID;
        }
        int a18 = w0.a(uri.getQueryParameter("openType"), 0);
        if (2 == a18) {
            String queryParameter6 = uri.getQueryParameter("userName");
            String queryParameter7 = uri.getQueryParameter("appId");
            String queryParameter8 = uri.getQueryParameter("extJsonInfo");
            String queryParameter9 = uri.getQueryParameter("relativeURL");
            if (TextUtils.isEmpty(queryParameter7)) {
                return EnumC6356a.ERR_URL_INVALID;
            }
            h.a().a(queryParameter7, a18, queryParameter8);
            com.tencent.luggage.wxa.bk.e eVar = new com.tencent.luggage.wxa.bk.e();
            eVar.f122984c = w0.a(uri.getQueryParameter("scene"), i3);
            b bVar2 = new b();
            bVar2.f136267c = queryParameter8;
            a(context, queryParameter7, queryParameter6, queryParameter9, a18, -1, eVar, null, bVar2);
            return EnumC6356a.OK;
        }
        String queryParameter10 = uri.getQueryParameter("username");
        String queryParameter11 = uri.getQueryParameter("appid");
        if (w0.c(queryParameter10) && w0.c(queryParameter11)) {
            w.d("Luggage.AbsLinkOpener", "username = %s, invalid, return", queryParameter10);
            return EnumC6356a.ERR_URL_INVALID;
        }
        a(context, queryParameter11, queryParameter10, w0.d(uri.getQueryParameter("path")), w0.a(uri.getQueryParameter("type"), 0), w0.a(uri.getQueryParameter("version"), 0), new com.tencent.luggage.wxa.bk.e(), null, null);
        return EnumC6356a.OK;
    }
}

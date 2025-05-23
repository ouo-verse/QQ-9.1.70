package com.tencent.mobileqq.qzoneplayer.videosource;

import android.text.TextUtils;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f280071a;

    /* renamed from: b, reason: collision with root package name */
    public int f280072b;

    /* renamed from: c, reason: collision with root package name */
    public int f280073c;

    /* renamed from: d, reason: collision with root package name */
    public long f280074d;

    /* renamed from: e, reason: collision with root package name */
    public long f280075e;

    /* renamed from: f, reason: collision with root package name */
    public long f280076f;

    /* renamed from: g, reason: collision with root package name */
    public long f280077g;

    /* renamed from: h, reason: collision with root package name */
    public int f280078h;

    /* renamed from: i, reason: collision with root package name */
    public int f280079i;

    /* renamed from: j, reason: collision with root package name */
    public int f280080j;

    /* renamed from: k, reason: collision with root package name */
    public String f280081k;

    /* renamed from: l, reason: collision with root package name */
    public String f280082l;

    /* renamed from: m, reason: collision with root package name */
    public String f280083m;

    /* renamed from: n, reason: collision with root package name */
    public List<String> f280084n;

    /* renamed from: o, reason: collision with root package name */
    public String f280085o;

    /* renamed from: p, reason: collision with root package name */
    public String f280086p;

    /* renamed from: q, reason: collision with root package name */
    public int f280087q;

    /* renamed from: r, reason: collision with root package name */
    public long f280088r;

    /* renamed from: s, reason: collision with root package name */
    public int f280089s;

    /* renamed from: t, reason: collision with root package name */
    public int f280090t;

    /* renamed from: u, reason: collision with root package name */
    public int f280091u;

    /* renamed from: v, reason: collision with root package name */
    public int f280092v;

    /* renamed from: w, reason: collision with root package name */
    public int f280093w;

    /* renamed from: x, reason: collision with root package name */
    public int f280094x;

    c() {
    }

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c cVar = new c();
            cVar.f280071a = jSONObject.optInt("callBackType");
            cVar.f280072b = jSONObject.optInt("playID");
            cVar.f280073c = jSONObject.optInt("clipNo");
            cVar.f280074d = jSONObject.optLong("fileSize");
            cVar.f280075e = jSONObject.optLong("offset");
            cVar.f280076f = jSONObject.optLong("httpDownloadSum");
            cVar.f280077g = jSONObject.optLong("dataFromCacheSize");
            cVar.f280078h = jSONObject.optInt("speedKBS");
            cVar.f280079i = jSONObject.optInt("errorCode");
            cVar.f280080j = jSONObject.optInt("errorDetailCode");
            cVar.f280081k = jSONObject.optString("errorMsg");
            cVar.f280082l = jSONObject.optString("httpURL");
            cVar.f280083m = jSONObject.optString("locationHttpURL");
            cVar.f280084n = b(jSONObject.optString("contentType"));
            cVar.f280085o = jSONObject.optString("contentType");
            cVar.f280086p = jSONObject.optString("httpCDNIPStr");
            cVar.f280087q = jSONObject.optInt("httpCDNPort");
            cVar.f280088r = jSONObject.optLong("newFileSize");
            cVar.f280089s = jSONObject.optInt("serverDetailErrorCode");
            cVar.f280090t = jSONObject.optInt("httpRedirectNum");
            cVar.f280091u = jSONObject.optInt("httpRedirectCostMs");
            cVar.f280092v = jSONObject.optInt("httpDNSCostMs");
            cVar.f280093w = jSONObject.optInt("httpConnectCostMs");
            cVar.f280094x = jSONObject.optInt("httpFirstRecvCostMs");
            return cVar;
        } catch (JSONException e16) {
            PlayerUtils.log(6, "TcDownloadInfo", PlayerUtils.getPrintableStackTrace(e16));
            return null;
        }
    }

    private static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (String str2 : str.split("\\|")) {
            arrayList.add(str2);
        }
        return arrayList;
    }
}

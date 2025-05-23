package com.tencent.gdt.tangram.ad.qzone;

import android.text.TextUtils;
import android.view.View;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
import yl0.i;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: h, reason: collision with root package name */
    private static a f108409h;

    /* renamed from: a, reason: collision with root package name */
    public i f108410a = null;

    /* renamed from: b, reason: collision with root package name */
    public i f108411b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f108412c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f108413d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f108414e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f108415f = -1;

    /* renamed from: g, reason: collision with root package name */
    public long f108416g = -1;

    a() {
    }

    public static String a(View view) {
        String str;
        a aVar;
        if (view == null || (aVar = f108409h) == null || !c(aVar.f108410a, aVar.f108411b)) {
            str = "";
        } else {
            int b16 = f108409h.f108410a.b();
            int c16 = f108409h.f108410a.c() - ((int) (FeedGlobalEnv.g().getDensity() * 35.0f));
            int b17 = f108409h.f108411b.b();
            int c17 = f108409h.f108411b.c() - ((int) (FeedGlobalEnv.g().getDensity() * 35.0f));
            long currentTimeMillis = System.currentTimeMillis() - f108409h.f108410a.a();
            long currentTimeMillis2 = System.currentTimeMillis() - f108409h.f108411b.a();
            int height = view.getHeight() - ((int) (FeedGlobalEnv.g().getDensity() * 35.0f));
            int width = view.getWidth();
            d.i("AdAntiSpamManager", "touchDownX:" + b16 + " touchDownY:" + c16 + " touchUpX:" + b17 + " touchUpY:" + c17 + " touchDownTime:" + (currentTimeMillis / 1000) + " touchUpTime:" + (currentTimeMillis2 / 1000));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ec", "" + currentTimeMillis);
                jSONObject.put("sc", "" + currentTimeMillis2);
                jSONObject.put("aa", "" + b16);
                jSONObject.put("ab", "" + c16);
                jSONObject.put("ba", "" + b17);
                jSONObject.put("bb", "" + c17);
                jSONObject.put("da", "" + width);
                jSONObject.put(TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "" + height);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            str = jSONObject.toString();
        }
        AnalysisHelperRunnable analysisHelperRunnable = new AnalysisHelperRunnable();
        analysisHelperRunnable.f108406e = "AdAntiSpamManager::getAntiSpam";
        analysisHelperRunnable.f108405d = view != null ? view.getContext() : null;
        analysisHelperRunnable.f108407f = false;
        analysisHelperRunnable.f108408h = "";
        GdtFeedUtilForQZone.z(analysisHelperRunnable);
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e17) {
            e17.printStackTrace();
            return str;
        }
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f108409h == null) {
                f108409h = new a();
            }
            aVar = f108409h;
        }
        return aVar;
    }

    public static boolean c(i iVar, i iVar2) {
        if (iVar == null || iVar2 == null) {
            return false;
        }
        if ((iVar2.a() - f108409h.f108416g) / 1000 < 0.5d && (System.currentTimeMillis() - f108409h.f108410a.a()) / 1000 < 0.5d) {
            f108409h.f108416g = iVar.a();
            return true;
        }
        if (f108409h.f108412c == iVar.b() && f108409h.f108413d == iVar.c() && f108409h.f108414e == iVar2.b() && f108409h.f108415f == iVar2.c()) {
            return false;
        }
        f108409h.f108412c = iVar.b();
        f108409h.f108413d = iVar.c();
        f108409h.f108414e = iVar2.b();
        f108409h.f108415f = iVar2.c();
        f108409h.f108416g = iVar.a();
        return true;
    }
}

package com.tencent.biz.pubaccount.weishi.verticalvideo.report;

import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi.player.e;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.d;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GdtAdWsVideoReport {
    public static String a(com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.d dVar) {
        if (dVar == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bt", dVar.f82074a + "");
            jSONObject.put(FileReaderHelper.ET_EXT, dVar.f82075b + "");
            StringBuilder sb5 = new StringBuilder();
            int i3 = 1;
            sb5.append(dVar.f82076c ? 1 : 0);
            sb5.append("");
            jSONObject.put("bf", sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            if (!dVar.f82077d) {
                i3 = 0;
            }
            sb6.append(i3);
            sb6.append("");
            jSONObject.put("ef", sb6.toString());
            jSONObject.put("pp", "11");
            jSONObject.put("pa", dVar.f82079f + "");
            jSONObject.put("ft", dVar.f82080g + "");
            if (dVar.f82081h != 0) {
                jSONObject.put(Constants.KEYS.PLACEMENTS, dVar.f82081h + "");
            }
            return jSONObject.toString();
        } catch (Exception e16) {
            x.i("GdtAdWsVideoReport", " @getGdtInfo createGDTVideoAttachment" + e16.toString());
            return null;
        }
    }

    public static String b(String str, String str2) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append("&video=");
                stringBuffer.append(URLEncoder.encode(str2));
            }
            return stringBuffer.toString();
        } catch (Exception e16) {
            x.i("GdtAdWsVideoReport", " @getGdtInfo getHttpVideoPlayUrl" + e16.toString());
            return "";
        }
    }

    private static void e(final String str) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.report.GdtAdWsVideoReport.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    x.i("GdtAdWsVideoReport", "@getGdtInfo exposure rspCode " + responseCode + "\uff0c request third party" + (responseCode == 200) + " url =" + str);
                } catch (Exception e16) {
                    x.h("GdtAdWsVideoReport", 2, e16.toString());
                }
            }
        }, 0L);
    }

    public static void f(long j3, long j16, boolean z16, boolean z17, int i3, int i16, int i17, int i18, String str) {
        d.a aVar = new d.a();
        aVar.i(j3).b(z17).c(j16).e(i18).h(i3).g(z16).f(i16).d(i17);
        d(aVar.a(), str);
    }

    private static String c(stSimpleMetaFeed stsimplemetafeed, e eVar) {
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        PBStringField pBStringField;
        if (stsimplemetafeed != null && stsimplemetafeed.gdt_ad_type == 1 && stsimplemetafeed.gdt_ad_info != null && (reportInfo = com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.a.d(stsimplemetafeed).report_info) != null && (pBStringField = reportInfo.exposure_url) != null && eVar != null && eVar.f81129e != null) {
            return pBStringField.get();
        }
        return "";
    }

    private static void d(com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.d dVar, String str) {
        if (dVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a16 = a(dVar);
        String b16 = b(str, a16);
        x.h("GdtAdWsVideoReport", 2, "reportHttpVideoUrl = " + a16);
        e(b16);
    }

    public static void g(j jVar, e eVar, final boolean z16, final int i3) {
        stSimpleMetaFeed e16;
        if (jVar == null || eVar == null) {
            return;
        }
        if ((jVar.e() == null && jVar.a() == null) || eVar.f81127c == null || (e16 = jVar.e()) == null) {
            return;
        }
        final String c16 = c(e16, eVar);
        if (eVar.f81129e == null || TextUtils.isEmpty(c16)) {
            return;
        }
        WSPlayerWrapper wSPlayerWrapper = eVar.f81129e;
        final long j3 = eVar.f81132h;
        final long z17 = wSPlayerWrapper.z();
        final int i16 = eVar.f81127c.f81169d;
        final boolean z18 = j3 == 0;
        final int i17 = jVar.a().numbersOfGdtAdPlayed != 0 ? 13 : 11;
        com.tencent.qav.thread.a.c().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.report.GdtAdWsVideoReport.1
            @Override // java.lang.Runnable
            public void run() {
                long j16;
                long j17 = j3;
                boolean z19 = z16;
                if (z19) {
                    j16 = i16;
                } else {
                    j16 = z17;
                }
                GdtAdWsVideoReport.f(j17, j16, z18, z19, 11, i17, i3, 0, c16);
            }
        });
    }
}

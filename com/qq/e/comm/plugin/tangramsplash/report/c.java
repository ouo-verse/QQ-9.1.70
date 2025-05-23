package com.qq.e.comm.plugin.tangramsplash.report;

import android.text.TextUtils;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.tangramsplash.selector.c;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$BizKey;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {
    public static void a(int i3, c.b bVar, r rVar, long j3, int i16, int i17) {
        a(i3, bVar, rVar, j3, i16, false, i17);
    }

    public static void b(int i3, String str, r rVar, int i16, boolean z16) {
        a(i3, 0, str, rVar, i16, z16);
    }

    public static void c(int i3, String str, r rVar, int i16, boolean z16) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        if (rVar != null) {
            bVar.b(rVar.f());
            bVar.c(rVar.y());
            cVar.a("ad_type", rVar.bP());
        }
        cVar.a("error_code", String.valueOf(i16));
        cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(z16));
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f40307a;

        /* renamed from: b, reason: collision with root package name */
        public int f40308b;

        public a(int i3, int i16) {
            this.f40307a = i3;
            this.f40308b = i16;
        }

        public void a(boolean z16, int i3) {
            if (z16) {
                this.f40307a = i3;
            } else {
                this.f40308b = i3;
            }
        }

        public int a() {
            return (this.f40307a * 100) + this.f40308b;
        }
    }

    public static void a(int i3, c.b bVar, boolean z16, boolean z17, int i16, int i17) {
        com.qq.e.comm.plugin.stat.b bVar2 = new com.qq.e.comm.plugin.stat.b();
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(z17));
        cVar.a("fetch_ad_only", com.qq.e.comm.plugin.tangramsplash.d.a.a(z16));
        cVar.a("splashPreloadGap", String.valueOf(i16));
        cVar.a("is_fusion_sdk", "1");
        cVar.a("error_code", Integer.valueOf(i17));
        if (bVar != null) {
            bVar2.a(bVar.f40335b);
            LoadAdParams loadAdParams = bVar.f40338e;
            if (loadAdParams != null) {
                cVar.a("code1", Integer.valueOf(loadAdParams.isCanDownloadSrcInRealtimeSelect() ? 1 : 0));
            }
        }
        StatTracer.trackEvent(i3, 0, bVar2, cVar);
    }

    public static void a(int i3, String str, String str2, String str3, long j3, boolean z16, int i16, int i17, Map map, int i18) {
        a(i3, str, str2, str3, "", j3, z16, i16, i17, map, i18, null, 0);
    }

    public static void a(int i3, String str, String str2, String str3, String str4, long j3, boolean z16, int i16, int i17, Map map, int i18, String str5, int i19) {
        Iterator it;
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        bVar.b(str2);
        bVar.c(str3);
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(z16));
        if (map != null && (it = map.keySet().iterator()) != null) {
            while (it.hasNext()) {
                Object obj = map.get(it.next());
                if (obj != null) {
                    cVar.a(it.next().toString(), obj instanceof Boolean ? com.qq.e.comm.plugin.tangramsplash.d.a.a(((Boolean) obj).booleanValue()) : obj.toString());
                }
            }
        }
        if (j3 > 0) {
            cVar.a("cost_time", String.valueOf(j3));
        }
        if (i16 != Integer.MIN_VALUE) {
            cVar.a("error_code", String.valueOf(i16));
        }
        if (i17 != Integer.MIN_VALUE) {
            cVar.a("httpErrorCode", String.valueOf(i17));
        }
        if (!TextUtils.isEmpty(str5)) {
            cVar.a("download_url", str5);
        }
        if (i19 > 0) {
            cVar.a("res_type", String.valueOf(i19));
        }
        if (!TextUtils.isEmpty(str4)) {
            cVar.a("ad_type", str4);
        }
        cVar.a("is_fusion_sdk", String.valueOf(i18));
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    public static void a(int i3, c.b bVar, r rVar, long j3, int i16, boolean z16, int i17) {
        com.qq.e.comm.plugin.stat.b bVar2 = new com.qq.e.comm.plugin.stat.b();
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        if (bVar != null) {
            bVar2.a(bVar.f40335b);
            cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(com.qq.e.comm.plugin.tangramsplash.d.a.a(bVar.f40338e)));
            cVar.a("fetch_ad_only", com.qq.e.comm.plugin.tangramsplash.d.a.a(bVar.f40339f));
            cVar.a("splashPreloadGap", String.valueOf(bVar.f40340g));
            cVar.a("is_fusion_sdk", "1");
            LoadAdParams loadAdParams = bVar.f40338e;
            if (loadAdParams != null) {
                cVar.a("code2", Integer.valueOf(loadAdParams.isCanDownloadSrcInRealtimeSelect() ? 1 : 0));
            }
        }
        if (rVar != null) {
            bVar2.b(rVar.f());
            bVar2.c(rVar.y());
            cVar.a("httpErrorCode", Integer.valueOf(rVar.bf()));
            cVar.a("ad_type", rVar.bP());
        }
        if (j3 > 0) {
            cVar.a("cost_time", String.valueOf(j3));
        }
        if (i16 != Integer.MAX_VALUE) {
            cVar.a("error_code", String.valueOf(i16));
        }
        cVar.a("code1", Integer.valueOf(i17));
        cVar.a("isPendingTaskCalled", String.valueOf(z16));
        StatTracer.trackEvent(i3, 0, bVar2, cVar);
    }

    public static void a(int i3, String str, r rVar, long j3, int i16, boolean z16, boolean z17) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        if (rVar != null) {
            bVar.b(rVar.f());
            bVar.c(rVar.y());
        }
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(z16));
        if (j3 > 0) {
            cVar.a("cost_time", String.valueOf(j3));
        }
        cVar.a("fetch_ad_only", com.qq.e.comm.plugin.tangramsplash.d.a.a(z17));
        if (i16 != Integer.MAX_VALUE) {
            cVar.a("error_code", String.valueOf(i16));
        }
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    public static void a(int i3, String str, r rVar, long j3, int i16, int i17, boolean z16, boolean z17) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        if (rVar != null) {
            bVar.b(rVar.f());
            bVar.c(rVar.y());
            cVar.a("ad_type", rVar.bP());
        }
        cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(z16));
        if (j3 > 0) {
            cVar.a("cost_time", String.valueOf(j3));
        }
        cVar.a("fetch_ad_only", com.qq.e.comm.plugin.tangramsplash.d.a.a(z17));
        cVar.a("isContract", String.valueOf(com.qq.e.comm.plugin.k.b.a(rVar) ? 1 : 0));
        cVar.a("splashVideoPlayMode", String.valueOf(i16));
        if (i17 != Integer.MAX_VALUE) {
            cVar.a("error_code", String.valueOf(i17));
        }
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    public static void a(int i3, String str, r rVar, int i16, boolean z16) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        if (rVar != null) {
            bVar.b(rVar.f());
            bVar.c(rVar.y());
        }
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(z16));
        if (i16 != Integer.MIN_VALUE) {
            cVar.a("error_code", String.valueOf(i16));
        }
        cVar.a("is_fusion_sdk", com.qq.e.comm.plugin.j.c.b() ? "1" : "0");
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    public static void a(int i3, int i16, String str, r rVar, int i17, boolean z16) {
        a(i3, i16, str, rVar, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, i17, z16);
    }

    public static void a(int i3, int i16, String str, r rVar, long j3, int i17, boolean z16) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        if (rVar != null) {
            bVar.b(rVar.f());
            bVar.c(rVar.y());
            bVar.a("interactive_compo", i17);
        }
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(z16));
        if (j3 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            cVar.a("cost_time", String.valueOf(j3));
        }
        StatTracer.trackEvent(i3, i16, bVar, cVar);
    }

    public static void a(int i3, String str, r rVar, boolean z16, int i16) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        if (rVar != null) {
            bVar.b(rVar.f());
            bVar.c(rVar.y());
        }
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(z16));
        if (i16 != Integer.MIN_VALUE) {
            cVar.a("httpErrorCode", Integer.valueOf(i16));
        }
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    public static void a(int i3, String str, String str2, String str3, boolean z16, int i16) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        bVar.b(str2);
        bVar.c(str3);
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(z16));
        if (i16 != Integer.MIN_VALUE) {
            cVar.a("httpErrorCode", Integer.valueOf(i16));
        }
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    public static void a(int i3, String str, r rVar, int i16) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        if (rVar != null) {
            bVar.b(rVar.f());
            bVar.c(rVar.y());
        }
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("error_code", String.valueOf(i16));
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    public static void a(int i3, r rVar, int i16, long j3, long j16) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("error_code", String.valueOf(i16));
        cVar.a("httpErrorCode", Long.valueOf(j3));
        cVar.a("cost_time", Long.valueOf(j16));
        if (rVar != null) {
            bVar.a(rVar.s());
            bVar.b(rVar.f());
            bVar.c(rVar.y());
            cVar.a("ad_type", rVar.bP());
        }
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    public static void a(int i3, String str, r rVar, long j3) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        if (rVar != null) {
            bVar.b(rVar.f());
            bVar.c(rVar.y());
        }
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("cost_time", String.valueOf(j3));
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    public static void a(int i3, String str) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        StatTracer.trackEvent(i3, 0, bVar);
    }

    public static void a(int i3, String str, r rVar, boolean z16) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        if (rVar != null) {
            bVar.b(rVar.f());
            bVar.c(rVar.y());
            cVar.a("ad_type", rVar.bP());
        }
        cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(z16));
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    public static void a(int i3, r rVar, boolean z16) {
        a(i3, rVar, z16, (Map) null);
    }

    public static void a(int i3, r rVar, boolean z16, Map map) {
        int n3;
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        com.qq.e.comm.plugin.stat.c cVar = (map == null || map.size() <= 0) ? new com.qq.e.comm.plugin.stat.c() : new com.qq.e.comm.plugin.stat.c(map);
        if (rVar != null) {
            bVar.b(rVar.f());
            bVar.c(rVar.y());
            bVar.a(rVar.s());
            cVar.a("ad_type", rVar.bP());
        }
        cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(z16));
        if (rVar != null && rVar.bJ() != null && (n3 = rVar.bJ().n()) != Integer.MIN_VALUE) {
            cVar.a("error_code", String.valueOf(n3));
        }
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    public static void a(int i3, String str, r rVar, Map<String, String> map) {
        String str2;
        String str3;
        com.qq.e.comm.plugin.stat.c cVar;
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("preloadReport error invalid params");
            return;
        }
        if (rVar != null) {
            str2 = rVar.f();
            str3 = rVar.y();
        } else {
            str2 = null;
            str3 = null;
        }
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        bVar.b(str2);
        bVar.c(str3);
        if (map != null) {
            cVar = new com.qq.e.comm.plugin.stat.c(map);
        } else {
            cVar = new com.qq.e.comm.plugin.stat.c();
        }
        cVar.a("ad_type", rVar != null ? rVar.bP() : "");
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    public static void a(int i3, String str, Map<String, String> map) {
        a(i3, 0, str, map);
    }

    public static void a(int i3, int i16, String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str) && map != null) {
            com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
            bVar.a(str);
            com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                cVar.a(entry.getKey(), entry.getValue());
            }
            StatTracer.trackEvent(i3, i16, bVar, cVar);
            return;
        }
        GDTLogger.e("preloadReport error invalid params");
    }

    public static Map<String, String> a(long j3, int i3, int i16, int i17, int i18, String str, boolean z16) {
        HashMap hashMap = new HashMap();
        if (j3 != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            hashMap.put("cost_time", String.valueOf(j3));
        }
        if (i3 != Integer.MIN_VALUE) {
            hashMap.put("error_code", String.valueOf(i3));
        }
        if (i16 != Integer.MIN_VALUE) {
            hashMap.put("disk_status", String.valueOf(i16));
        }
        if (i17 != Integer.MIN_VALUE) {
            hashMap.put("is_sdk_downloader", String.valueOf(i17));
        }
        if (i18 != Integer.MIN_VALUE) {
            hashMap.put("file_type", String.valueOf(i18));
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("download_url", String.valueOf(str));
        }
        hashMap.put("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(z16));
        return hashMap;
    }

    public static Map<String, String> a(long j3, int i3, int i16, int i17, int i18, String str, boolean z16, int i19, int i26) {
        Map<String, String> a16 = a(j3, i3, i16, i17, i18, str, z16);
        a16.put(LinkReportConstant$BizKey.DOWNLOAD_SCENE, String.valueOf(i19));
        if (i26 != Integer.MIN_VALUE) {
            a16.put("httpErrorCode", String.valueOf(i26));
        }
        return a16;
    }

    public static Map<String, String> a(long j3, int i3, int i16, int i17, int i18, String str, boolean z16, int i19, int i26, boolean z17) {
        Map<String, String> a16 = a(j3, i3, i16, i17, i18, str, z16);
        a16.put(LinkReportConstant$BizKey.DOWNLOAD_SCENE, String.valueOf(i19));
        if (i26 != Integer.MIN_VALUE) {
            a16.put("httpErrorCode", String.valueOf(i26));
        }
        a16.put("isPendingTaskCalled", z17 ? "1" : "0");
        return a16;
    }

    public static Map<String, String> a(long j3, int i3, int i16, int i17, int i18, String str, boolean z16, int i19, int i26, String str2, int i27, boolean z17) {
        Map<String, String> a16 = a(j3, i3, i16, i17, i18, str, z16, i19, i26, z17);
        if (!TextUtils.isEmpty(str2)) {
            a16.put("internalErrorMessage", a(str2));
        }
        if (i27 != Integer.MIN_VALUE) {
            a16.put("retry_times", String.valueOf(i27));
        }
        return a16;
    }

    public static Map<String, String> a(long j3, int i3, int i16, int i17, int i18, String str, boolean z16, int i19) {
        Map<String, String> a16 = a(j3, i3, i16, i17, i18, str, z16);
        if (i19 != Integer.MIN_VALUE) {
            a16.put("httpErrorCode", String.valueOf(i19));
        }
        return a16;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int integer = GDTADManager.getInstance().getSM().getInteger("error_message_report_length", 150);
        return str.length() > integer ? str.substring(0, integer) : str;
    }

    public static Map<String, String> a(Map<String, String> map, String... strArr) {
        if (map == null || map.isEmpty()) {
            return map;
        }
        HashMap hashMap = new HashMap(map);
        if (g.a((Object[]) strArr)) {
            if (!TextUtils.isEmpty(strArr[0])) {
                hashMap.put("aid", strArr[0]);
            }
            if (1 < strArr.length && !TextUtils.isEmpty(strArr[1])) {
                hashMap.put("file_size", strArr[1]);
            }
            if (2 < strArr.length && !TextUtils.isEmpty(strArr[2])) {
                hashMap.put("exp_map", strArr[2]);
            }
        }
        return hashMap;
    }

    public static void a(int i3, String str, int i16, long j3) {
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        if (j3 > 0) {
            cVar.a("cost_time", String.valueOf(j3));
        } else {
            cVar.a("cost_time", "0");
        }
        cVar.a(LinkReportConstant$BizKey.DOWNLOAD_SCENE, String.valueOf(i16));
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    public static void a(int i3, String str, int i16, long j3, boolean z16) {
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        if (j3 > 0) {
            cVar.a("cost_time", String.valueOf(j3));
        } else {
            cVar.a("cost_time", "0");
        }
        cVar.a(LinkReportConstant$BizKey.DOWNLOAD_SCENE, String.valueOf(i16));
        cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(z16));
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    public static void a(int i3, String str, int i16, boolean z16) {
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        cVar.a("preload_info_from", String.valueOf(i16));
        cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(z16));
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    public static void a(int i3, String str, boolean z16, int i16, int i17) {
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(z16));
        cVar.a("reuse_num", String.valueOf(i16));
        cVar.a("total_num", String.valueOf(i17));
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    public static void a(int i3, String str, r rVar, int i16, int i17, float f16, float f17) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        if (rVar != null) {
            bVar.b(rVar.f());
            bVar.c(rVar.y());
        }
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("screenWidth", String.valueOf(i16));
        cVar.a("screenHeight", String.valueOf(i17));
        cVar.a(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_X, String.valueOf(f16));
        cVar.a(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_Y, String.valueOf(f17));
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }

    public static void a(int i3, int i16, c.b bVar) {
        com.qq.e.comm.plugin.stat.b bVar2 = new com.qq.e.comm.plugin.stat.b();
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        if (bVar != null) {
            bVar2.a(bVar.f40335b);
            cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(com.qq.e.comm.plugin.tangramsplash.d.a.a(bVar.f40338e)));
            cVar.a("fetch_ad_only", com.qq.e.comm.plugin.tangramsplash.d.a.a(bVar.f40339f));
            cVar.a("splashPreloadGap", String.valueOf(bVar.f40340g));
            cVar.a("is_fusion_sdk", "1");
        }
        if (i16 > 0) {
            cVar.a("cost_time", String.valueOf(i16));
        }
        StatTracer.trackEvent(i3, i16, bVar2, cVar);
    }

    public static void a(int i3, c.b bVar, r rVar, int i16) {
        com.qq.e.comm.plugin.stat.b bVar2 = new com.qq.e.comm.plugin.stat.b();
        if (rVar != null) {
            bVar2.b(rVar.f());
            bVar2.c(rVar.y());
        }
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        if (bVar != null) {
            bVar2.a(bVar.f40335b);
            cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(com.qq.e.comm.plugin.tangramsplash.d.a.a(bVar.f40338e)));
        }
        cVar.a("error_code", Integer.valueOf(i16));
        StatTracer.trackEvent(i3, 0, bVar2, cVar);
    }

    public static void a(r rVar, boolean z16, int i3, int i16, Map map) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        if (rVar != null) {
            bVar.b(rVar.f());
            bVar.c(rVar.y());
            bVar.a(rVar.s());
        }
        bVar.a("custom_select_stage", i3);
        bVar.a(LinkReportConstant$BizKey.ORIGIN_ERROR_CODE, i16);
        com.qq.e.comm.plugin.stat.c cVar = (map == null || map.size() <= 0) ? new com.qq.e.comm.plugin.stat.c() : new com.qq.e.comm.plugin.stat.c(map);
        cVar.a("startMode", com.qq.e.comm.plugin.tangramsplash.d.a.a(z16));
        StatTracer.trackEvent(5000053, 0, bVar, cVar);
    }

    public static void a(int i3, int i16) {
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("error_code", String.valueOf(com.qq.e.comm.plugin.j.c.f() ? 1 : 0));
        StatTracer.trackEvent(i3, i16, (com.qq.e.comm.plugin.stat.b) null, cVar);
    }
}

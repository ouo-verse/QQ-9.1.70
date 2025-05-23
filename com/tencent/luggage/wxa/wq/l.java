package com.tencent.luggage.wxa.wq;

import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.yq.n;
import com.tencent.xweb.XWebDownloader;
import com.tencent.xweb.XWebSdk;
import com.tencent.xweb.xwalk.plugin.XWalkPlugin;
import com.tencent.xweb.xwalk.plugin.XWalkPluginManager;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class l {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f144362a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f144363b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f144364c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f144365d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f144366e = "";

        /* renamed from: f, reason: collision with root package name */
        public n.d f144367f = null;

        /* renamed from: g, reason: collision with root package name */
        public StringBuilder f144368g = new StringBuilder();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f144369a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f144370b = "";

        /* renamed from: c, reason: collision with root package name */
        public int f144371c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f144372d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f144373e = -1;

        /* renamed from: f, reason: collision with root package name */
        public String f144374f = "";

        /* renamed from: g, reason: collision with root package name */
        public a f144375g = null;

        /* renamed from: h, reason: collision with root package name */
        public XWebDownloader.DownloadInfo f144376h = null;

        /* renamed from: i, reason: collision with root package name */
        public long f144377i = -1;

        /* renamed from: j, reason: collision with root package name */
        public int f144378j = 0;

        /* renamed from: k, reason: collision with root package name */
        public long f144379k = -1;

        /* renamed from: l, reason: collision with root package name */
        public long f144380l = -1;
    }

    public static void a(a aVar) {
        String str;
        try {
            if (aVar == null) {
                x0.c("KVReportForPluginUpdate", "reportPluginConfigUpdate error, data is null");
                return;
            }
            if ("5".equals(aVar.f144363b)) {
                x0.d("KVReportForPluginUpdate", "reportPluginConfigUpdate, checkType is config only, skip report");
                return;
            }
            if (aVar.f144367f == null) {
                n.d dVar = new n.d();
                aVar.f144367f = dVar;
                dVar.f146101a = "";
                dVar.f146102b = "";
                dVar.f146103c = 0;
                dVar.f146104d = -1;
                dVar.f146105e = "";
                dVar.f146106f = -1;
                dVar.f146107g = -1L;
                dVar.f146108h = -1L;
                dVar.f146109i = -1;
            }
            String packageName = XWalkEnvironment.getApplicationContext() != null ? XWalkEnvironment.getApplicationContext().getPackageName() : "";
            StringBuilder sb5 = new StringBuilder();
            sb5.append(aVar.f144362a);
            sb5.append(",");
            if (packageName == null) {
                packageName = "";
            }
            sb5.append(packageName);
            sb5.append(",");
            sb5.append(XWebSdk.getXWebSdkVersion());
            sb5.append(",");
            String str2 = aVar.f144363b;
            if (str2 == null) {
                str2 = "";
            }
            sb5.append(str2);
            sb5.append(",");
            String str3 = aVar.f144364c;
            if (str3 == null) {
                str3 = "";
            }
            sb5.append(str3);
            sb5.append(",");
            String str4 = aVar.f144365d;
            if (str4 == null) {
                str4 = "";
            }
            sb5.append(str4);
            sb5.append(",");
            String str5 = aVar.f144366e;
            if (str5 == null) {
                str5 = "";
            }
            sb5.append(str5);
            sb5.append(",");
            sb5.append(aVar.f144367f.f146103c);
            sb5.append(",");
            sb5.append(aVar.f144367f.f146104d);
            sb5.append(",");
            sb5.append(aVar.f144367f.f146106f);
            sb5.append(",");
            sb5.append(aVar.f144367f.f146107g);
            sb5.append(",");
            sb5.append(aVar.f144367f.f146108h);
            sb5.append(",");
            sb5.append(aVar.f144367f.f146109i);
            sb5.append(",");
            StringBuilder sb6 = aVar.f144368g;
            sb5.append(sb6 != null ? sb6.toString() : "");
            String sb7 = sb5.toString();
            x0.d("KVReportForPluginUpdate", "reportPluginConfigUpdate, key = 26264, value = " + sb7);
            n0.a(26264, sb7);
            if (aVar.f144362a == 0 || (str = aVar.f144364c) == null || str.isEmpty()) {
                return;
            }
            x0.d("KVReportForPluginUpdate", "reportPluginConfigUpdate, config error, single plugin is not empty, try reportPluginUpdate");
            b bVar = new b();
            bVar.f144375g = aVar;
            String str6 = aVar.f144364c;
            bVar.f144370b = str6;
            XWalkPlugin plugin = XWalkPluginManager.getPlugin(str6);
            if (plugin != null) {
                bVar.f144371c = plugin.getAvailableVersion();
            }
            bVar.f144369a = -1;
            a(bVar);
        } catch (Exception e16) {
            x0.c("KVReportForPluginUpdate", "reportPluginConfigUpdate error: " + e16.getMessage());
        }
    }

    public static void a(b bVar) {
        try {
            if (bVar == null) {
                x0.c("KVReportForPluginUpdate", "reportPluginUpdate error, data is null");
                return;
            }
            a aVar = bVar.f144375g;
            if (aVar == null) {
                x0.c("KVReportForPluginUpdate", "reportPluginUpdate error, configReportData is null");
                return;
            }
            if ("5".equals(aVar.f144363b)) {
                x0.d("KVReportForPluginUpdate", "reportPluginUpdate, checkType is config only, skip report");
                return;
            }
            XWebDownloader.DownloadInfo downloadInfo = bVar.f144376h;
            long j3 = -1;
            int i3 = 0;
            if (downloadInfo == null) {
                XWebDownloader.DownloadInfo downloadInfo2 = new XWebDownloader.DownloadInfo();
                bVar.f144376h = downloadInfo2;
                downloadInfo2.mDownloadType = -1;
                downloadInfo2.mUrl = "";
                downloadInfo2.mSavePath = "";
                downloadInfo2.mStartTimestamp = -1L;
                downloadInfo2.mNetWorkType = -1;
                downloadInfo2.mIsDownloadResume = false;
                downloadInfo2.mFileTotalSize = -1L;
                downloadInfo2.mIsRuntime = false;
                downloadInfo2.mBizType = -1;
                downloadInfo2.mRetryTimes = -1;
                i3 = -1;
            } else if (downloadInfo.mIsDownloadResume) {
                i3 = 1;
            }
            long j16 = bVar.f144380l;
            long j17 = bVar.f144379k;
            if (j16 > j17 && j17 > 0) {
                j3 = j16 - j17;
            }
            String packageName = XWalkEnvironment.getApplicationContext() != null ? XWalkEnvironment.getApplicationContext().getPackageName() : "";
            StringBuilder sb5 = new StringBuilder();
            sb5.append(bVar.f144369a);
            sb5.append(",");
            if (packageName == null) {
                packageName = "";
            }
            sb5.append(packageName);
            sb5.append(",");
            sb5.append(XWebSdk.getXWebSdkVersion());
            sb5.append(",");
            String str = bVar.f144370b;
            if (str == null) {
                str = "";
            }
            sb5.append(str);
            sb5.append(",");
            sb5.append(bVar.f144371c);
            sb5.append(",");
            sb5.append(bVar.f144372d);
            sb5.append(",");
            sb5.append(bVar.f144373e);
            sb5.append(",");
            String str2 = bVar.f144374f;
            if (str2 == null) {
                str2 = "";
            }
            sb5.append(str2);
            sb5.append(",");
            String str3 = bVar.f144375g.f144363b;
            if (str3 == null) {
                str3 = "";
            }
            sb5.append(str3);
            sb5.append(",");
            String str4 = bVar.f144375g.f144364c;
            if (str4 == null) {
                str4 = "";
            }
            sb5.append(str4);
            sb5.append(",");
            String str5 = bVar.f144375g.f144365d;
            if (str5 == null) {
                str5 = "";
            }
            sb5.append(str5);
            sb5.append(",");
            String str6 = bVar.f144375g.f144366e;
            sb5.append(str6 != null ? str6 : "");
            sb5.append(",");
            sb5.append(bVar.f144375g.f144362a);
            sb5.append(",");
            sb5.append(bVar.f144376h.mErrorCode);
            sb5.append(",");
            sb5.append(bVar.f144376h.mDownloadType);
            sb5.append(",");
            sb5.append(bVar.f144376h.mNetWorkType);
            sb5.append(",");
            sb5.append(bVar.f144376h.mRetryTimes);
            sb5.append(",");
            sb5.append(bVar.f144377i);
            sb5.append(",");
            sb5.append(bVar.f144376h.mFileTotalSize);
            sb5.append(",");
            sb5.append(i3);
            sb5.append(",");
            sb5.append(bVar.f144378j);
            sb5.append(",");
            sb5.append(j3);
            String sb6 = sb5.toString();
            x0.d("KVReportForPluginUpdate", "reportPluginUpdate, key = 26265, value = " + sb6);
            n0.a(26265, sb6);
        } catch (Exception e16) {
            x0.c("KVReportForPluginUpdate", "reportPluginUpdate error: " + e16.getMessage());
        }
    }
}

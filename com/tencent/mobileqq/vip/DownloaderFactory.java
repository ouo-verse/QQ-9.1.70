package com.tencent.mobileqq.vip;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.TrafficStats;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.ams.fusion.widget.cny2025.twist.CNYTwistArrowLayer;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.component.media.image.ImageConsts;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.apollo.res.api.IApolloQueueDownloader;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoLoadTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.au;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vip.g;
import com.tencent.open.base.MD5Utils;
import com.tencent.oskplayer.cache.FileDataSink;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.AVDecodeError;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DownloaderFactory implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    static ConnectivityManager f312712d;

    /* renamed from: e, reason: collision with root package name */
    public static ConcurrentHashMap<Integer, h> f312713e;

    /* renamed from: f, reason: collision with root package name */
    public static volatile boolean f312714f;

    /* renamed from: h, reason: collision with root package name */
    public static ConcurrentHashMap<String, Integer> f312715h;

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f312716i;

    /* renamed from: m, reason: collision with root package name */
    private static Map<String, Integer> f312717m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
            } else {
                super.onDone(gVar);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar)).booleanValue();
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f312719a;

        /* renamed from: b, reason: collision with root package name */
        long f312720b;

        /* renamed from: c, reason: collision with root package name */
        boolean f312721c;

        /* renamed from: d, reason: collision with root package name */
        int f312722d;

        /* renamed from: e, reason: collision with root package name */
        int f312723e;

        /* renamed from: f, reason: collision with root package name */
        long f312724f;

        /* renamed from: g, reason: collision with root package name */
        long f312725g;

        /* renamed from: h, reason: collision with root package name */
        boolean f312726h;

        /* renamed from: i, reason: collision with root package name */
        int f312727i;

        /* renamed from: j, reason: collision with root package name */
        BufferedOutputStream f312728j;

        /* renamed from: k, reason: collision with root package name */
        HttpEntity f312729k;

        /* renamed from: l, reason: collision with root package name */
        InputStream f312730l;

        /* renamed from: m, reason: collision with root package name */
        String f312731m;

        /* renamed from: n, reason: collision with root package name */
        String f312732n;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f312720b = System.currentTimeMillis();
            this.f312721c = false;
            this.f312722d = -1;
            this.f312723e = 2000;
            this.f312724f = 0L;
            this.f312725g = 0L;
            this.f312726h = false;
            this.f312727i = 2048;
            this.f312728j = null;
            this.f312729k = null;
            this.f312730l = null;
            this.f312731m = "";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77219);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f312712d = null;
        f312714f = true;
        f312715h = null;
        f312716i = WebpSoLoader.b();
        f312717m = new HashMap<String, Integer>() { // from class: com.tencent.mobileqq.vip.DownloaderFactory.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                put("cmshow.gtimg.cn", 1015);
                put("imgcache.qq.com", 1016);
                put("imgcache.gtimg.cn", 1016);
                put("i.gtimg.cn", 1016);
            }
        };
    }

    public DownloaderFactory(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        f312715h = new ConcurrentHashMap<>();
        f312713e = new ConcurrentHashMap<>();
        if (f312712d == null) {
            f312712d = (ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity");
        }
    }

    public static boolean A(String str) {
        if (TextUtils.isEmpty(str) || str.indexOf(63) <= -1) {
            return false;
        }
        return true;
    }

    private static String B(g gVar, String str, String str2) {
        if (!TextUtils.isEmpty(gVar.R)) {
            return MsfSdkUtils.insertMtype(gVar.R, str);
        }
        return str2;
    }

    public static void C(String str, String str2, int i3, Context context) {
        if (context == null) {
            return;
        }
        String num = Integer.toString(NetworkUtil.getSystemNetwork(context));
        if (str2 == null) {
            str2 = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        }
        ReportController.o(null, "P_CliOper", "VipDownload", "0", "VipDownload", "ip", 0, i3, "", num, str2, str);
    }

    private static boolean D(boolean z16, boolean z17, boolean z18, boolean z19) {
        if (z16 && z17 && z18 && !z19) {
            return true;
        }
        return false;
    }

    public static boolean E(String str) {
        int i3;
        if (f312715h.containsKey(str)) {
            i3 = f312715h.get(str).intValue();
        } else {
            i3 = 0;
        }
        if (i3 <= 0) {
            return false;
        }
        if (((int) (System.currentTimeMillis() / 1000)) < i3 + 600) {
            return true;
        }
        f312715h.remove(str);
        return false;
    }

    private static boolean F(g gVar, Throwable th5, boolean z16) {
        boolean z17 = th5 instanceof ConnectTimeoutException;
        if (z17 || (th5 instanceof SocketTimeoutException) || (th5 instanceof SocketException)) {
            z16 = true;
        }
        if (th5 instanceof IOException) {
            gVar.f313006d = -111;
        } else if (th5 instanceof NullPointerException) {
            gVar.f313006d = -112;
        } else if (!z17 && !(th5 instanceof SocketTimeoutException)) {
            if (th5 instanceof SocketException) {
                gVar.f313006d = AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR;
            } else if (gVar.f313006d == 0) {
                gVar.f313006d = AVDecodeError.JNI_BITMAP_STRIDE_ERR;
            }
        } else {
            gVar.f313006d = -113;
        }
        return z16;
    }

    public static boolean G(Context context) {
        if (context != null) {
            int systemNetwork = NetworkUtil.getSystemNetwork(context);
            if (QLog.isColorLevel()) {
                QLog.d("DownloaderFactory", 2, "isQualityNetwork type=" + systemNetwork);
            }
            if (systemNetwork == 3 || systemNetwork == 4 || systemNetwork == 1) {
                return true;
            }
        }
        return false;
    }

    private static void H(g gVar, c cVar, InputStream inputStream, BufferedOutputStream bufferedOutputStream, int i3, StringBuilder sb5, long j3, byte[] bArr, int i16) throws IOException {
        int read;
        long j16 = j3;
        int i17 = i16;
        while (!gVar.j() && (read = inputStream.read(bArr)) != -1) {
            V(sb5, j16, read, bArr);
            bufferedOutputStream.write(bArr, 0, read);
            long j17 = read;
            long j18 = j16 + j17;
            cVar.f312725g += j17;
            i17 += read;
            long j19 = cVar.f312724f;
            if (j19 > 0) {
                if (gVar.G == 0) {
                    gVar.G = j19 / 100;
                }
                if (i17 >= gVar.G || j18 >= j19) {
                    gVar.x(j19, j18, i3);
                    gVar.s();
                    j16 = j18;
                    i17 = 0;
                }
            }
            j16 = j18;
        }
    }

    private static void I(StringBuilder sb5, HeaderIterator headerIterator) {
        while (headerIterator.hasNext()) {
            Header nextHeader = headerIterator.nextHeader();
            String[] strArr = {HttpMsg.X_CACHE_LOOKUP, HttpMsg.CDN_LOG_UUID, "Content-Length", "cache-control", "last-modified", "Location", "Content-Type", HttpMsg.CONTENTRANGE, "Content-Encoding", "server_ip"};
            String name = nextHeader.getName();
            for (int i3 = 0; i3 < 10; i3++) {
                if (strArr[i3].equalsIgnoreCase(name)) {
                    sb5.append(", ");
                    sb5.append(name);
                    sb5.append(" :");
                    sb5.append(nextHeader.getValue());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02c5 A[LOOP:0: B:2:0x0020->B:41:0x02c5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x02c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0281  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean J(g gVar, String str, Context context, c cVar, HttpParams httpParams, boolean z16, boolean z17, int i3, Object obj, HashMap<String, String> hashMap, File file, File file2, File file3, DownloadInfo downloadInfo) {
        StringBuilder sb5;
        String str2;
        String str3;
        String str4;
        boolean z18;
        StringBuilder sb6;
        boolean z19;
        boolean z26;
        int i16;
        boolean z27;
        HttpParams httpParams2 = httpParams;
        String str5 = "1";
        String str6 = ", cost: ";
        String str7 = "DownloaderFactory";
        boolean z28 = z16;
        while (true) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb7 = new StringBuilder("start download");
            sb7.append(", Gzip: ");
            sb7.append(gVar.Q);
            sb7.append(", supportRedirect: ");
            sb7.append(gVar.U);
            sb7.append(", retryCount: ");
            sb7.append(gVar.f313008f);
            sb7.append(", Duplicate callback: ");
            sb7.append(gVar.f313001a0);
            try {
                cVar.f312721c = false;
                cVar.f312723e = 2000;
                try {
                    downloadInfo.clearParams();
                    l(gVar, cVar, file2, sb7);
                    NetworkInfo v3 = v(gVar, cVar, sb7);
                    str3 = str5;
                    try {
                        cVar.f312732n = O(gVar, str, cVar.f312732n);
                        Map<String, String> f16 = gVar.f();
                        String d16 = d(gVar, cVar, cVar.f312732n);
                        cVar.f312732n = d16;
                        HttpGet httpGet = new HttpGet(d16);
                        N(gVar, httpGet, cVar.f312732n, sb7, f16);
                        Q(httpGet, file3, sb7);
                        P(gVar, httpGet, file, sb7);
                        R(gVar, httpGet, downloadInfo, sb7);
                        c(gVar, cVar, httpParams2, sb7, v3);
                        i(gVar, httpParams2);
                        httpParams2.setIntParameter("http.socket.buffer-size", cVar.f312727i);
                        httpGet.setParams(httpParams2);
                        httpGet.setHeader("Accept-Encoding", gVar.Q ? "gzip" : "identity");
                        b(cVar.f312732n, httpGet);
                        TrafficStats.setThreadStatsTag(65535);
                        HttpResponse execute = HttpDownloadUtil.CLIENT.execute(httpGet);
                        try {
                            int statusCode = execute.getStatusLine().getStatusCode();
                            gVar.O = statusCode;
                            downloadInfo.httpRespCode = statusCode;
                            sb7.append("\nurl=");
                            sb7.append(httpGet.getURI());
                            sb7.append(", http code: ");
                            sb7.append(statusCode);
                            sb7.append("\nHeader:");
                            I(sb7, execute.headerIterator());
                            if (200 != statusCode && 206 != statusCode) {
                                try {
                                    i16 = statusCode;
                                    z27 = true;
                                    sb5 = sb7;
                                    str4 = str7;
                                    try {
                                        cVar.f312732n = p(gVar, cVar, cVar.f312732n, file3, execute, i16);
                                        str2 = str6;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        z28 = z27;
                                        z18 = false;
                                        str2 = str6;
                                        boolean F = F(gVar, th, z18);
                                        String message = th.getMessage();
                                        gVar.f313007e = message;
                                        k(gVar, cVar, z28, F);
                                        sb6 = sb5;
                                        sb6.append(", sdcardWritable:");
                                        sb6.append(FileUtils.hasSDCardAndWritable());
                                        sb6.append(", sdcard available size: ");
                                        sb6.append(FileUtils.getAvailableExternalMemorySize() / 1048576.0f);
                                        sb6.append("\ndownload failed: ");
                                        sb6.append(message);
                                        VasLogReporter.getDownload().report("error download[" + downloadInfo.urlOriginal + "] " + message);
                                        VasCommonReporter.getDownLoader().setValue1(downloadInfo.urlOriginal).setValue2(message).report(z18);
                                        TrafficStats.clearThreadStatsTag();
                                        QLog.i(str4, 1, sb6.toString() + str2 + (System.currentTimeMillis() - currentTimeMillis));
                                        y(gVar, context, cVar.f312719a, file, downloadInfo);
                                        StringBuilder sb8 = new StringBuilder();
                                        sb8.append(downloadInfo.isHttps ? "11" : "10");
                                        sb8.append(downloadInfo.isIPUrl ? str3 : "0");
                                        cVar.f312731m = sb8.toString();
                                        cVar.f312722d++;
                                        j(cVar.f312729k, cVar.f312730l, cVar.f312728j, cVar.f312732n);
                                        if (cVar.f312719a == 0) {
                                        }
                                        z26 = !cVar.f312721c;
                                        if (cVar.f312722d < gVar.f313008f) {
                                        }
                                        if (D(z19, z26, z18, gVar.j())) {
                                        }
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    sb5 = sb7;
                                    str4 = str7;
                                    z27 = true;
                                }
                            } else {
                                i16 = statusCode;
                                sb5 = sb7;
                                str4 = str7;
                                str2 = str6;
                                try {
                                    r(gVar, cVar, i3, file, file3, sb5, execute);
                                } catch (Throwable th7) {
                                    th = th7;
                                    z28 = true;
                                    z18 = false;
                                    try {
                                        boolean F2 = F(gVar, th, z18);
                                        String message2 = th.getMessage();
                                        gVar.f313007e = message2;
                                        k(gVar, cVar, z28, F2);
                                        sb6 = sb5;
                                    } catch (Throwable th8) {
                                        th = th8;
                                        sb6 = sb5;
                                    }
                                    try {
                                        sb6.append(", sdcardWritable:");
                                        sb6.append(FileUtils.hasSDCardAndWritable());
                                        sb6.append(", sdcard available size: ");
                                        sb6.append(FileUtils.getAvailableExternalMemorySize() / 1048576.0f);
                                        sb6.append("\ndownload failed: ");
                                        sb6.append(message2);
                                        VasLogReporter.getDownload().report("error download[" + downloadInfo.urlOriginal + "] " + message2);
                                        VasCommonReporter.getDownLoader().setValue1(downloadInfo.urlOriginal).setValue2(message2).report(z18);
                                        TrafficStats.clearThreadStatsTag();
                                        QLog.i(str4, 1, sb6.toString() + str2 + (System.currentTimeMillis() - currentTimeMillis));
                                        y(gVar, context, cVar.f312719a, file, downloadInfo);
                                        StringBuilder sb82 = new StringBuilder();
                                        sb82.append(downloadInfo.isHttps ? "11" : "10");
                                        sb82.append(downloadInfo.isIPUrl ? str3 : "0");
                                        cVar.f312731m = sb82.toString();
                                        cVar.f312722d++;
                                        j(cVar.f312729k, cVar.f312730l, cVar.f312728j, cVar.f312732n);
                                        if (cVar.f312719a == 0) {
                                        }
                                        z26 = !cVar.f312721c;
                                        if (cVar.f312722d < gVar.f313008f) {
                                        }
                                        if (D(z19, z26, z18, gVar.j())) {
                                        }
                                    } catch (Throwable th9) {
                                        th = th9;
                                        TrafficStats.clearThreadStatsTag();
                                        QLog.i(str4, 1, sb6.toString() + str2 + (System.currentTimeMillis() - currentTimeMillis));
                                        y(gVar, context, cVar.f312719a, file, downloadInfo);
                                        StringBuilder sb9 = new StringBuilder();
                                        sb9.append(downloadInfo.isHttps ? "11" : "10");
                                        sb9.append(downloadInfo.isIPUrl ? str3 : "0");
                                        cVar.f312731m = sb9.toString();
                                        cVar.f312722d++;
                                        j(cVar.f312729k, cVar.f312730l, cVar.f312728j, cVar.f312732n);
                                        throw th;
                                    }
                                }
                            }
                            VasCommonReporter.getDownLoader().setValue1(downloadInfo.urlOriginal).setNum1(i16).report();
                            T(gVar, cVar, obj, hashMap, cVar.f312732n, execute);
                            TrafficStats.clearThreadStatsTag();
                            QLog.i(str4, 1, sb5.toString() + str2 + (System.currentTimeMillis() - currentTimeMillis));
                            y(gVar, context, cVar.f312719a, file, downloadInfo);
                            StringBuilder sb10 = new StringBuilder();
                            sb10.append(downloadInfo.isHttps ? "11" : "10");
                            sb10.append(downloadInfo.isIPUrl ? str3 : "0");
                            cVar.f312731m = sb10.toString();
                            cVar.f312722d++;
                            j(cVar.f312729k, cVar.f312730l, cVar.f312728j, cVar.f312732n);
                            z28 = true;
                            z18 = false;
                        } catch (Throwable th10) {
                            th = th10;
                            sb5 = sb7;
                            str4 = str7;
                            str2 = str6;
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        sb5 = sb7;
                        str4 = str7;
                        str2 = str6;
                        z28 = false;
                        z18 = false;
                        boolean F22 = F(gVar, th, z18);
                        String message22 = th.getMessage();
                        gVar.f313007e = message22;
                        k(gVar, cVar, z28, F22);
                        sb6 = sb5;
                        sb6.append(", sdcardWritable:");
                        sb6.append(FileUtils.hasSDCardAndWritable());
                        sb6.append(", sdcard available size: ");
                        sb6.append(FileUtils.getAvailableExternalMemorySize() / 1048576.0f);
                        sb6.append("\ndownload failed: ");
                        sb6.append(message22);
                        VasLogReporter.getDownload().report("error download[" + downloadInfo.urlOriginal + "] " + message22);
                        VasCommonReporter.getDownLoader().setValue1(downloadInfo.urlOriginal).setValue2(message22).report(z18);
                        TrafficStats.clearThreadStatsTag();
                        QLog.i(str4, 1, sb6.toString() + str2 + (System.currentTimeMillis() - currentTimeMillis));
                        y(gVar, context, cVar.f312719a, file, downloadInfo);
                        StringBuilder sb822 = new StringBuilder();
                        sb822.append(downloadInfo.isHttps ? "11" : "10");
                        sb822.append(downloadInfo.isIPUrl ? str3 : "0");
                        cVar.f312731m = sb822.toString();
                        cVar.f312722d++;
                        j(cVar.f312729k, cVar.f312730l, cVar.f312728j, cVar.f312732n);
                        if (cVar.f312719a == 0) {
                        }
                        z26 = !cVar.f312721c;
                        if (cVar.f312722d < gVar.f313008f) {
                        }
                        if (D(z19, z26, z18, gVar.j())) {
                        }
                    }
                } catch (Throwable th12) {
                    th = th12;
                    sb5 = sb7;
                    str2 = str6;
                    str3 = str5;
                    str4 = str7;
                }
            } catch (Throwable th13) {
                th = th13;
                sb5 = sb7;
                str2 = str6;
                str3 = str5;
                str4 = str7;
                z18 = false;
            }
            z19 = cVar.f312719a == 0 ? true : z18;
            z26 = !cVar.f312721c;
            if (cVar.f312722d < gVar.f313008f) {
                z18 = true;
            }
            if (D(z19, z26, z18, gVar.j())) {
                return z28;
            }
            str6 = str2;
            str7 = str4;
            httpParams2 = httpParams;
            str5 = str3;
        }
    }

    public static void K(DownloadInfo downloadInfo) {
        if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.urlOriginal)) {
            String hostFromUrl = InnerDns.getHostFromUrl(downloadInfo.urlOriginal);
            if (f312717m.containsKey(hostFromUrl) && downloadInfo.urlOriginal.startsWith("http")) {
                String reqDns = InnerDns.getInstance().reqDns(hostFromUrl, f312717m.get(hostFromUrl).intValue());
                if (!TextUtils.isEmpty(reqDns)) {
                    String L = L(downloadInfo.urlOriginal, reqDns);
                    if (!TextUtils.isEmpty(L)) {
                        downloadInfo.reqUrl = L;
                        downloadInfo.host = hostFromUrl;
                        downloadInfo.f204570ip = reqDns;
                        downloadInfo.isIPUrl = true;
                        return;
                    }
                    downloadInfo.reqUrl = downloadInfo.urlOriginal;
                    return;
                }
                return;
            }
            au.a(downloadInfo);
            if (QLog.isColorLevel()) {
                QLog.d("DownloaderFactory", 2, "use new httpDNS. url: " + downloadInfo.urlOriginal);
            }
        }
    }

    private static String L(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            String str4 = "http://" + str2 + "/";
            if (str.startsWith("https")) {
                str4 = "https://" + str2 + "/";
                str3 = "https://[^/\\s]*/";
            } else {
                str3 = "http://[^/\\s]*/";
            }
            return str.replaceFirst(str3, str4);
        }
        return null;
    }

    private static void M(g gVar, String str, Context context, int i3, boolean z16, boolean z17, long j3, int i16, long j16, long j17, HashMap<String, String> hashMap, String str2, String str3) {
        HashMap<String, String> hashMap2;
        boolean z18;
        if (hashMap == null) {
            hashMap2 = new HashMap<>();
        } else {
            hashMap2 = hashMap;
        }
        hashMap2.put("param_Url", str2);
        hashMap2.put("param_FailCode", String.valueOf(gVar.f313006d));
        hashMap2.put("param_HttpCode", String.valueOf(gVar.O));
        hashMap2.put("param_TryCount", String.valueOf(i16));
        hashMap2.put("param_ContentLen", String.valueOf(j16));
        hashMap2.put("param_TaskDownSize", String.valueOf(gVar.f313009g.size()));
        hashMap2.put("param_BusinessCode", gVar.S);
        hashMap2.put("param_Executed", Boolean.toString(z16));
        hashMap2.put("param_UrlType", str3);
        if (!TextUtils.isEmpty(gVar.f313007e)) {
            hashMap2.put("param_ErrMsg", gVar.f313007e);
        }
        if (i3 == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        boolean z19 = z18;
        long currentTimeMillis = System.currentTimeMillis() - j3;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                String str4 = "VipDownload700";
                if (!TextUtils.isEmpty(gVar.S) && gVar.S.contains("apollo")) {
                    str4 = "CMShowDownload";
                    hashMap2.put("param_https", String.valueOf(gVar.X));
                    hashMap2.put("param_AddRandom", String.valueOf(gVar.W));
                }
                StatisticCollector.getInstance(context).collectPerformance(str, str4, z19, currentTimeMillis, j17, hashMap2, "", false);
            } catch (Throwable unused) {
            }
        }
    }

    private static void N(g gVar, HttpGet httpGet, String str, StringBuilder sb5, Map<String, String> map) {
        if (map != null) {
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                httpGet.addHeader(str2, str3);
                sb5.append(", ");
                sb5.append(str2);
                sb5.append(ProgressTracer.SEPARATOR);
                sb5.append(str3);
            }
        }
        if (gVar.L && com.tencent.qqsharpP.a.f363551a && com.tencent.qqsharpP.a.c()) {
            httpGet.addHeader("Accept", ImageConsts.IMAGE_TYPE_SHARPP);
            QLog.d("DownloaderFactory", 2, "isSharpPSupport: addHeader");
        }
        if (gVar.M) {
            String featureValueWithoutAccountManager = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.AcceptType.name());
            if (!TextUtils.isEmpty(featureValueWithoutAccountManager) && (Integer.parseInt(featureValueWithoutAccountManager) & 1) == 1) {
                httpGet.addHeader("Accept", "image/webp,*/*;q=0.8");
                int[] iArr = f312716i;
                httpGet.addHeader("User-Agent", "QQ/" + AppSetting.f99551k + " " + String.format(" WebP/%d.%d.%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr[2])));
                if (QLog.isColorLevel()) {
                    QLog.d("DownloaderFactory", 2, "doTask | support webp, add header for " + str);
                    return;
                }
                return;
            }
            QLog.w("DownloaderFactory", 2, "DPC config forbidden accept WebP!");
        }
    }

    private static String O(g gVar, String str, String str2) {
        if (gVar.W && !str2.contains("randomKey=")) {
            int nextInt = new Random(com.tencent.mobileqq.qcall.g.e(str) | System.currentTimeMillis()).nextInt();
            if (A(str2)) {
                return str2 + "&randomKey=" + nextInt;
            }
            return str2 + "?randomKey=" + nextInt;
        }
        return str2;
    }

    private static void P(g gVar, HttpGet httpGet, File file, StringBuilder sb5) {
        if (!gVar.N && gVar.K && file != null && file.exists()) {
            long j3 = gVar.P;
            if (j3 <= 0) {
                j3 = file.lastModified();
            }
            if (j3 > 0) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM y HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                String format = simpleDateFormat.format(new Date(j3));
                if (!TextUtils.isEmpty(format)) {
                    httpGet.addHeader("If-Modified-Since", format);
                    sb5.append(", If-Modified-Since:");
                    sb5.append(format);
                }
            }
        }
    }

    private static void Q(HttpGet httpGet, File file, StringBuilder sb5) {
        if (file != null && file.exists()) {
            long length = file.length();
            httpGet.addHeader("Range", "bytes=" + length + "-");
            StringBuilder sb6 = new StringBuilder();
            sb6.append(", add HttpMsg.RANGE:");
            sb6.append(length);
            sb5.append(sb6.toString());
        }
    }

    private static void R(g gVar, HttpGet httpGet, DownloadInfo downloadInfo, StringBuilder sb5) throws URISyntaxException {
        if (f312714f && gVar.f313025w && gVar.f313024v && !downloadInfo.isHttps) {
            K(downloadInfo);
            if (downloadInfo.isIPUrl) {
                httpGet.setURI(new URI(downloadInfo.reqUrl));
                httpGet.addHeader("Host", downloadInfo.host);
                sb5.append(", Domain2IP[");
                sb5.append(downloadInfo.host);
                sb5.append(":");
                sb5.append(downloadInfo.f204570ip);
                sb5.append("]");
            }
        }
    }

    private static void S(g gVar, String str) {
        if (gVar.g() == null) {
            gVar.u(new a());
        }
        if (str != null) {
            g.a aVar = gVar.Z;
            if (aVar.f313030b < 0) {
                try {
                    aVar.f313030b = Long.parseLong(str);
                } catch (NumberFormatException e16) {
                    QLog.e("DownloaderFactory", 1, "setTaskListener | NumberFormatException,uin= " + str + " e : " + e16.getMessage());
                }
            }
        }
    }

    private static void T(g gVar, c cVar, Object obj, HashMap<String, String> hashMap, String str, HttpResponse httpResponse) throws Exception {
        Header firstHeader;
        if (f312715h == null) {
            f312715h = new ConcurrentHashMap<>();
        }
        if (cVar.f312719a != 0 && !gVar.j()) {
            if (cVar.f312722d < gVar.f313008f) {
                synchronized (obj) {
                    try {
                        obj.wait(cVar.f312723e);
                    } catch (InterruptedException unused) {
                        QLog.e("DownloaderFactory", 1, "doTask | InterruptedException,downloadUrl=" + str);
                    }
                }
            } else {
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (gVar.f313023u) {
                    f312715h.put(gVar.f313004c, Integer.valueOf(currentTimeMillis));
                }
                cVar.f312721c = true;
                throw new Exception("doTask | download fail | try over downloadUrl=" + str + ",change task.useIp=" + gVar.f313025w + " task.forceIp=" + gVar.f313024v);
            }
        } else {
            f312715h.remove(gVar.f313004c);
        }
        if (gVar.f313006d == 302 && (firstHeader = httpResponse.getFirstHeader("Location")) != null) {
            hashMap.put("param_Location", firstHeader.getValue());
        }
    }

    private static boolean U(g gVar, c cVar) {
        cVar.f312719a = -1;
        if (!gVar.t()) {
            gVar.f313006d = AVDecodeError.VIDEO_DECODE_A_ERR;
            gVar.n();
            if (QLog.isColorLevel()) {
                QLog.d("DownloaderFactory", 2, "doTask |  download start return false stop task:" + gVar);
                return true;
            }
            return true;
        }
        return false;
    }

    private static void V(StringBuilder sb5, long j3, int i3, byte[] bArr) {
        String h16;
        if (QLog.isColorLevel() && 0 == j3) {
            byte[] bArr2 = {-119, 80, 78, 71, 13, 10, 26, 10};
            if (i3 > 4 && -1 == bArr[0] && -40 == bArr[1]) {
                h16 = "JPEG";
            } else if (i3 > 8 && Arrays.equals(bArr2, Arrays.copyOfRange(bArr, 0, 7))) {
                h16 = "PNG";
            } else {
                h16 = h(i3, bArr, null);
            }
            if (h16 != null) {
                sb5.append(", img type: ");
                sb5.append(h16);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
    
        if (r8 == 0) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void W(File file, File file2) {
        InputStreamReader inputStreamReader;
        Exception e16;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            long length = file.length();
            String encodeFileHexStr = MD5Utils.encodeFileHexStr(file.getAbsolutePath());
            long j3 = 400;
            ?? r56 = (length > 400L ? 1 : (length == 400L ? 0 : -1));
            if (r56 <= 0) {
                j3 = length;
            }
            char[] cArr = new char[(int) j3];
            InputStream inputStream = null;
            try {
                try {
                    r56 = new FileInputStream((File) file);
                } catch (Exception e17) {
                    r56 = 0;
                    e16 = e17;
                    file = 0;
                } catch (Throwable th5) {
                    th = th5;
                    inputStreamReader = null;
                    if (inputStream != null) {
                    }
                    if (inputStreamReader == null) {
                    }
                }
                try {
                    file = new InputStreamReader((InputStream) r56, "UTF-8");
                } catch (Exception e18) {
                    e16 = e18;
                    file = 0;
                } catch (Throwable th6) {
                    th = th6;
                    file = 0;
                    inputStream = r56;
                    inputStreamReader = file;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (inputStreamReader == null) {
                        try {
                            inputStreamReader.close();
                            throw th;
                        } catch (Exception unused2) {
                            throw th;
                        }
                    }
                    throw th;
                }
                try {
                    file.read(cArr);
                    try {
                        r56.close();
                    } catch (Exception unused3) {
                    }
                } catch (Exception e19) {
                    e16 = e19;
                    e16.printStackTrace();
                    if (r56 != 0) {
                        try {
                            r56.close();
                        } catch (Exception unused4) {
                        }
                    }
                }
                try {
                    file.close();
                } catch (Exception unused5) {
                    QLog.d("DownloaderFactory", 2, "unzipResource|unzip resource fail targetDir=" + file2.getAbsolutePath() + " len: " + length + " md5: " + encodeFileHexStr + " content: " + String.valueOf(cArr));
                }
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    public static synchronized boolean X(File file, File file2, boolean z16) {
        synchronized (DownloaderFactory.class) {
            boolean z17 = false;
            if (file != null) {
                if (file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        if (file2.exists()) {
                            File[] listFiles = file2.listFiles();
                            for (int i3 = 0; i3 < listFiles.length; i3++) {
                                File file3 = listFiles[i3];
                                if (file3.isDirectory()) {
                                    File[] listFiles2 = file3.listFiles();
                                    if (listFiles2 != null) {
                                        for (File file4 : listFiles2) {
                                            file4.delete();
                                        }
                                        file3.delete();
                                    }
                                } else {
                                    listFiles[i3].delete();
                                }
                            }
                        } else {
                            file2.mkdirs();
                        }
                        ZipUtils.unZipFile(file, file2.getAbsolutePath() + File.separatorChar);
                        Y(file, file2, z16);
                        z17 = true;
                    } catch (Exception e16) {
                        QLog.d("DownloaderFactory", 2, "unzipResource|unzip resource fail targetDir=" + file2.getAbsolutePath() + e16.getMessage());
                        W(file, file2);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("DownloaderFactory", 2, "unzipResource|use time " + (System.currentTimeMillis() - currentTimeMillis) + " targetDir=" + file2.getAbsolutePath());
                    }
                    return z17;
                }
            }
            return false;
        }
    }

    private static void Y(File file, File file2, boolean z16) {
        if (z16) {
            file.delete();
        }
        if (QLog.isColorLevel()) {
            QLog.d("DownloaderFactory", 2, "unzipResource|unzip resource succ targetDir=" + file2.getAbsolutePath());
        }
    }

    private static void a(g gVar, File file, HttpResponse httpResponse) {
        if (gVar.K && httpResponse.containsHeader("last-modified")) {
            String value = httpResponse.getFirstHeader("last-modified").getValue();
            if (!TextUtils.isEmpty(value)) {
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E,d MMM y HH:mm:ss 'GMT'", Locale.US);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                    long time = simpleDateFormat.parse(value).getTime();
                    file.setLastModified(time);
                    gVar.P = time;
                    if (QLog.isColorLevel()) {
                        QLog.d("DownloaderFactory", 2, "doTask |set lastModifyTime=" + time + ",fileName=" + file.getName() + ",lastModify=" + file.lastModified());
                    }
                } catch (Exception e16) {
                    QLog.e("DownloaderFactory", 1, "doTask | set lastModify=" + value + ",exception msg=" + e16.getMessage());
                }
            }
        }
    }

    private static void b(String str, HttpGet httpGet) {
        if (!TextUtils.isEmpty(str) && str.startsWith("https://qgame.gamecenter.qq.com")) {
            StringBuilder sb5 = new StringBuilder();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                String account = peekAppRuntime.getAccount();
                sb5.append("uin=");
                sb5.append('o');
                sb5.append(account);
                httpGet.setHeader("Cookie", sb5.toString());
            }
        }
    }

    private static void c(g gVar, c cVar, HttpParams httpParams, StringBuilder sb5, NetworkInfo networkInfo) {
        String apnType = PkgTools.getApnType(NetworkMonitor.netGetExInfo(networkInfo));
        if (!apnType.equals(gVar.f313026x)) {
            gVar.f313027y = false;
            gVar.f313026x = apnType;
        }
        if (NetworkUtil.isMobileNetworkInfo(networkInfo)) {
            if (!gVar.f313027y) {
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost != null && defaultPort > 0) {
                    httpParams.setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(defaultHost, defaultPort));
                    cVar.f312726h = true;
                    sb5.append(", useProxy: ");
                    sb5.append(cVar.f312726h);
                    sb5.append(", host: ");
                    sb5.append(defaultHost);
                    sb5.append(", port: ");
                    sb5.append(defaultPort);
                    return;
                }
                return;
            }
            return;
        }
        cVar.f312727i = 4096;
        cVar.f312726h = false;
    }

    private static String d(g gVar, c cVar, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("DownloaderFactory", 2, "downloadUrl: " + str);
        }
        if (gVar.O == 302 && cVar.f312722d == 0 && gVar.X && str.startsWith("http://")) {
            gVar.f313025w = false;
            cVar.f312721c = true;
            return str.replaceFirst("http", "https");
        }
        return str;
    }

    public static boolean e(g gVar) {
        List<String> list;
        if (gVar == null || (list = gVar.f313009g) == null || gVar.f313010h == null || list.size() < 1 || gVar.f313010h.size() < 1 || TextUtils.isEmpty(gVar.f313004c)) {
            return false;
        }
        for (String str : gVar.f313009g) {
            if (TextUtils.isEmpty(str) || !URLUtil.isNetworkUrl(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean f(g gVar) {
        List<String> list = gVar.f313009g;
        if (list != null && list.size() > 0) {
            return false;
        }
        gVar.f313006d = -107;
        gVar.n();
        if (QLog.isColorLevel()) {
            QLog.d("DownloaderFactory", 2, "doTask |  download error task urlList is empty, task:" + gVar);
            return true;
        }
        return true;
    }

    private static void g(g gVar, c cVar, File file, long j3) throws Exception {
        if (0 != j3 && j3 >= cVar.f312724f) {
            file.delete();
            gVar.f313006d = -117;
            cVar.f312719a = -117;
            throw new Exception("SC_PARTIAL_CONTENT error");
        }
    }

    private static String h(int i3, byte[] bArr, String str) {
        if (i3 > 12 && 82 == bArr[0] && 73 == bArr[1] && 70 == bArr[2] && 70 == bArr[3] && 87 == bArr[8] && 69 == bArr[9] && 66 == bArr[10] && 80 == bArr[11]) {
            return "WebP";
        }
        return str;
    }

    private static void i(g gVar, HttpParams httpParams) {
        if (!gVar.U && NetworkUtil.isWifiConnected(BaseApplication.getContext())) {
            HttpClientParams.setRedirecting(httpParams, false);
        }
    }

    private static void j(HttpEntity httpEntity, InputStream inputStream, BufferedOutputStream bufferedOutputStream, String str) {
        if (httpEntity != null) {
            try {
                httpEntity.consumeContent();
            } catch (Exception e16) {
                QLog.e("DownloaderFactory", 1, "doTask closeStream | download close io stream exception=" + e16.getMessage() + ", downloadUrl=" + str);
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e17) {
                QLog.e("DownloaderFactory", 1, "doTask closeStream | download is close io stream exception=" + e17.getMessage() + ", downloadUrl=" + str);
            }
        }
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.close();
            } catch (Exception e18) {
                QLog.e("DownloaderFactory", 1, "doTask closeStream | download buffFileOS close io stream exception=" + e18.getMessage() + ", downloadUrl=" + str);
            }
        }
    }

    private static void k(g gVar, c cVar, boolean z16, boolean z17) {
        if (!z16 && z17) {
            gVar.f313027y = cVar.f312726h;
        }
    }

    private static void l(g gVar, c cVar, File file, StringBuilder sb5) throws Exception {
        if (file != null) {
            boolean isDirectory = file.isDirectory();
            boolean exists = file.exists();
            sb5.append(", fileParent isDirectory: ");
            sb5.append(isDirectory);
            sb5.append(", fileParent isExist: ");
            sb5.append(exists);
            if (!exists || !isDirectory) {
                if (!isDirectory) {
                    boolean delete = file.delete();
                    sb5.append(", fileParent delete Result: ");
                    sb5.append(delete);
                }
                if (file.mkdirs()) {
                    return;
                }
                cVar.f312721c = true;
                gVar.f313006d = -103;
                cVar.f312719a = -103;
                sb5.append(", mkdir fail path: ");
                sb5.append(file.getAbsolutePath());
                sb5.append(", file canRead: ");
                sb5.append(file.canRead());
                sb5.append(", file canWrite: ");
                sb5.append(file.canWrite());
                sb5.append(", sdCard exist: ");
                sb5.append(Utils.B());
                sb5.append(", remain size: ");
                sb5.append(Utils.z());
                throw new Exception("mkdir error");
            }
            return;
        }
        throw new Exception("mkdir error fileParent is null");
    }

    private static void m(g gVar, c cVar, File file, File file2, StringBuilder sb5, HttpResponse httpResponse, long j3) throws Exception {
        long j16 = cVar.f312724f;
        if (j3 != j16 && ((j16 >= 1 || !gVar.C || j3 <= 0) && (httpResponse.getFirstHeader("Content-Encoding") == null || !"gzip".equals(httpResponse.getFirstHeader("Content-Encoding").getValue()) || j3 < cVar.f312724f))) {
            if (gVar.j()) {
                cVar.f312721c = true;
                gVar.f313006d = -106;
                cVar.f312719a = -106;
                sb5.append(", cancel by user");
                return;
            }
            gVar.f313006d = -105;
            cVar.f312719a = -105;
            file2.delete();
            throw new Exception("error file len");
        }
        gVar.f313006d = 0;
        cVar.f312719a = 0;
        if (file.exists()) {
            file.delete();
        }
        boolean renameTo = file2.renameTo(file);
        if (!renameTo) {
            renameTo = FileUtils.moveFile(file2.getAbsolutePath(), file.getAbsolutePath(), true);
        }
        if (!renameTo) {
            VasCommonReporter.getDownLoader().setValue1("renameTo_fail").setValue2(file.getAbsolutePath()).setValue3(file2.getAbsolutePath()).report();
        }
        sb5.append(", rename: ");
        sb5.append(renameTo);
        a(gVar, file, httpResponse);
    }

    public static int n(g gVar, String str, Context context) {
        String str2;
        boolean z16;
        c cVar = new c();
        cVar.f312719a = -2;
        S(gVar, str);
        try {
        } catch (Throwable th5) {
            QLog.e("DownloaderFactory", 1, th5.getMessage());
        }
        if (U(gVar, cVar)) {
            return cVar.f312719a;
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        basicHttpParams.setParameter("http.connection.timeout", 10000);
        basicHttpParams.setParameter("http.socket.timeout", Integer.valueOf(gVar.B));
        if (gVar.Q) {
            str2 = "gzip";
        } else {
            str2 = "identity";
        }
        basicHttpParams.setParameter("Accept-Encoding", str2);
        if (f(gVar)) {
            return cVar.f312719a;
        }
        int size = gVar.f313009g.size();
        if (1 == MobileQQ.sProcessId) {
            z16 = true;
        } else {
            z16 = false;
        }
        s(gVar, cVar, w(gVar, str, context, cVar, basicHttpParams, size, false, z16));
        z(gVar, cVar.f312719a);
        if (QLog.isColorLevel()) {
            QLog.d("DownloaderFactory", 2, "doTask | end download task result=" + cVar.f312719a);
        }
        return cVar.f312719a;
    }

    public static int o(g gVar, AppRuntime appRuntime) {
        if (gVar == null) {
            return -1;
        }
        if (appRuntime != null) {
            if (gVar.L && !com.tencent.qqsharpP.a.b(appRuntime.getApplication())) {
                QLog.e("AIOAudioPanel", 1, "sharpp load error");
            }
            return n(gVar, appRuntime.getAccount(), appRuntime.getApplication());
        }
        return n(gVar, null, null);
    }

    private static String p(g gVar, c cVar, String str, File file, HttpResponse httpResponse, int i3) {
        if (404 == i3) {
            cVar.f312721c = true;
            gVar.f313006d = i3;
            cVar.f312719a = i3;
            return str;
        }
        if ((302 == i3 || 301 == i3) && !gVar.U) {
            return q(gVar, cVar, httpResponse, i3);
        }
        if (304 == i3) {
            gVar.f313006d = 0;
            cVar.f312719a = 0;
            return str;
        }
        if (416 == i3) {
            if (file.exists()) {
                file.delete();
            }
            gVar.f313006d = i3;
            cVar.f312719a = i3;
            return str;
        }
        gVar.f313006d = i3;
        cVar.f312719a = i3;
        return str;
    }

    private static String q(g gVar, c cVar, HttpResponse httpResponse, int i3) {
        boolean z16;
        if (gVar.X && ((i3 == 302 || i3 == 301) && cVar.f312722d == -1)) {
            z16 = false;
        } else {
            z16 = true;
        }
        cVar.f312721c = z16;
        gVar.f313006d = i3;
        cVar.f312719a = i3;
        return httpResponse.getFirstHeader("Location").getValue();
    }

    private static void r(g gVar, c cVar, int i3, File file, File file2, StringBuilder sb5, HttpResponse httpResponse) throws Exception {
        boolean z16;
        HttpEntity entity = httpResponse.getEntity();
        cVar.f312729k = entity;
        cVar.f312724f = entity.getContentLength();
        sb5.append(", entity ContentLength: ");
        sb5.append(cVar.f312724f);
        long t16 = t(gVar, cVar, file2, sb5, httpResponse);
        com.tencent.qqperf.reporter.flow.a.b("DownloaderFactory", cVar.f312732n, cVar.f312724f);
        g(gVar, cVar, file2, t16);
        if (t16 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        cVar.f312728j = new BufferedOutputStream(new FileOutputStream(file2, z16));
        if (httpResponse.getFirstHeader("Content-Encoding") != null && "gzip".equals(httpResponse.getFirstHeader("Content-Encoding").getValue())) {
            cVar.f312730l = new GZIPInputStream(cVar.f312729k.getContent());
            sb5.append(", recv gzip stream");
        } else {
            cVar.f312730l = cVar.f312729k.getContent();
        }
        byte[] buf = ByteArrayPool.getGenericInstance().getBuf(cVar.f312727i);
        H(gVar, cVar, cVar.f312730l, cVar.f312728j, i3, sb5, t16, buf, 0);
        cVar.f312728j.flush();
        ByteArrayPool.getGenericInstance().returnBuf(buf);
        sb5.append(", tempFile length: ");
        sb5.append(file2.length());
        m(gVar, cVar, file, file2, sb5, httpResponse, file2.length());
    }

    private static void s(g gVar, c cVar, int i3) {
        if (i3 > 0 && gVar.f313009g.size() > 1) {
            if (QLog.isColorLevel()) {
                QLog.w("DownloaderFactory", 2, "doTask | download not complete,fail size=" + i3 + ",task size=" + gVar.f313009g.size());
            }
            gVar.f313006d = AVDecodeError.VIDEO_DECODE_V_ERR;
            cVar.f312719a = -1;
        }
    }

    private static long t(g gVar, c cVar, File file, StringBuilder sb5, HttpResponse httpResponse) throws Exception {
        Header firstHeader = httpResponse.getFirstHeader("Content-Range");
        Header firstHeader2 = httpResponse.getFirstHeader("Content-Length");
        if (firstHeader != null) {
            cVar.f312724f = Integer.parseInt(firstHeader.getValue().split("/")[1]);
        } else if (firstHeader2 != null) {
            cVar.f312724f = Integer.parseInt(firstHeader2.getValue());
        }
        long length = file.length();
        sb5.append(", fixed contentLength: ");
        sb5.append(cVar.f312724f);
        sb5.append(", tmp fileLen: ");
        sb5.append(length);
        if (gVar.C || cVar.f312724f >= 1) {
            long j3 = gVar.E;
            if (j3 <= 0 || cVar.f312724f <= j3) {
                return length;
            }
        }
        cVar.f312721c = true;
        gVar.f313006d = CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE;
        cVar.f312719a = CNYTwistArrowLayer.LEFT_ARROW_CLIP_START_ANGLE;
        sb5.append(", limitSize: ");
        sb5.append(gVar.E);
        throw new Exception("server file len error");
    }

    @NotNull
    private static NetworkInfo v(g gVar, c cVar, StringBuilder sb5) throws Exception {
        if (f312712d == null) {
            f312712d = (ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity");
        }
        NetworkInfo recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
        if (recentNetworkInfo != null) {
            return recentNetworkInfo;
        }
        gVar.f313006d = -104;
        cVar.f312719a = -104;
        sb5.append(", activeNetworkInfo is null");
        throw new Exception("NONE network");
    }

    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r13v5 */
    private static int w(g gVar, String str, Context context, c cVar, HttpParams httpParams, int i3, boolean z16, boolean z17) {
        int i16;
        boolean z18;
        boolean J;
        g gVar2;
        g gVar3 = gVar;
        c cVar2 = cVar;
        ?? r132 = 0;
        int i17 = i3;
        boolean z19 = z16;
        int i18 = 0;
        while (i18 < gVar3.f313009g.size()) {
            cVar2.f312719a = -1;
            cVar2.f312720b = System.currentTimeMillis();
            cVar2.f312721c = r132;
            cVar2.f312722d = -1;
            cVar2.f312723e = 2000;
            cVar2.f312724f = 0L;
            cVar2.f312725g = 0L;
            cVar2.f312726h = r132;
            cVar2.f312731m = "";
            Object obj = new Object();
            HashMap hashMap = new HashMap();
            String str2 = gVar3.f313009g.get(i18);
            gVar3.f313011i = str2;
            cVar2.f312732n = str2;
            File file = gVar3.f313010h.get(str2);
            if (file == null) {
                gVar3.f313006d = -110;
                QLog.w("DownloaderFactory", 2, "doTask | download task error task file param is null");
                J = z19;
                i16 = i18;
                z18 = r132;
            } else {
                File parentFile = file.getParentFile();
                File x16 = x(gVar3, file, parentFile);
                String B = B(gVar3, str2, cVar2.f312732n);
                cVar2.f312732n = B;
                i16 = i18;
                z18 = r132;
                J = J(gVar, str, context, cVar, httpParams, z19, z17, i18, obj, hashMap, file, parentFile, x16, new DownloadInfo(B, null, r132));
            }
            gVar.o();
            M(gVar, str, context, cVar2.f312719a, J, z17, cVar2.f312720b, cVar2.f312722d, cVar2.f312724f, cVar2.f312725g, hashMap, cVar2.f312732n, cVar2.f312731m);
            if (cVar.f312719a == 0) {
                i17--;
                gVar2 = gVar;
            } else {
                gVar2 = gVar;
                if (gVar2.T) {
                    break;
                }
            }
            i18 = i16 + 1;
            cVar2 = cVar;
            gVar3 = gVar2;
            r132 = z18;
            z19 = J;
        }
        return i17;
    }

    @NotNull
    private static File x(g gVar, File file, File file2) {
        if (VasToggle.BUG_107543533.isEnable(false)) {
            file2 = new File(VasConstant.DOWNLOADER_FACTORY_TMP_DIR);
            if (!file2.exists()) {
                file2.mkdir();
            }
        }
        if (gVar.D) {
            return new File(file2, file.getName() + "_" + System.nanoTime());
        }
        return new File(file2, file.getName() + FileDataSink.TEMP_FILE);
    }

    private static void y(g gVar, Context context, int i3, File file, DownloadInfo downloadInfo) {
        if (i3 != 0 && !gVar.j() && gVar.f313025w) {
            if (downloadInfo.isIPUrl) {
                if (!TextUtils.isEmpty(downloadInfo.f204570ip)) {
                    InnerDns innerDns = InnerDns.getInstance();
                    String str = downloadInfo.host;
                    innerDns.reportBadIp(str, downloadInfo.f204570ip, f312717m.get(str).intValue());
                } else {
                    FMTSrvAddrProvider fMTSrvAddrProvider = FMTSrvAddrProvider.getInstance();
                    if (fMTSrvAddrProvider != null) {
                        fMTSrvAddrProvider.onFailed(downloadInfo.domainType, downloadInfo.reqUrl);
                    }
                }
                C(downloadInfo.reqUrl, file.getName(), -1, context);
                gVar.f313024v = false;
                return;
            }
            gVar.f313024v = true;
        }
    }

    private static void z(g gVar, int i3) {
        int i16;
        if (gVar.j() && !gVar.J) {
            if (QLog.isColorLevel()) {
                QLog.d("DownloaderFactory", 2, "no need to call onDone");
                return;
            }
            return;
        }
        if (gVar.j()) {
            if (QLog.isColorLevel()) {
                QLog.d("DownloaderFactory", 2, "canceled");
            }
            gVar.y(2);
            gVar.m();
        } else {
            if (i3 == 0) {
                i16 = 3;
            } else {
                i16 = -1;
            }
            gVar.y(i16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("DownloaderFactory", 2, "onDoned");
        }
        gVar.n();
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DownloaderFactory", 2, "onDestroy...");
        }
        synchronized (f312715h) {
            f312715h.clear();
        }
        synchronized (f312713e) {
            Iterator<Map.Entry<Integer, h>> it = f312713e.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().onDestroy();
            }
            f312713e.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h u(int i3) {
        h hVar;
        QueueDownloader queueDownloader;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        ConcurrentHashMap<Integer, h> concurrentHashMap = f312713e;
        h hVar2 = null;
        if (concurrentHashMap != null) {
            synchronized (concurrentHashMap) {
                switch (i3) {
                    case 1:
                    case 2:
                    case 5:
                    case 7:
                        if (f312713e.containsKey(Integer.valueOf(i3))) {
                            hVar = f312713e.get(Integer.valueOf(i3));
                            hVar2 = hVar;
                            break;
                        } else {
                            QueueDownloader queueDownloader2 = new QueueDownloader(BaseApplicationImpl.getApplication().getRuntime(), new b(false));
                            f312713e.put(Integer.valueOf(i3), queueDownloader2);
                            queueDownloader = queueDownloader2;
                            hVar2 = queueDownloader;
                            break;
                        }
                    case 3:
                    case 4:
                        if (f312713e.containsKey(Integer.valueOf(i3))) {
                            hVar = f312713e.get(Integer.valueOf(i3));
                            hVar2 = hVar;
                            break;
                        } else {
                            b bVar = new b(false);
                            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                            IApolloQueueDownloader iApolloQueueDownloader = (IApolloQueueDownloader) QRoute.api(IApolloQueueDownloader.class);
                            iApolloQueueDownloader.init(runtime, bVar);
                            f312713e.put(Integer.valueOf(i3), iApolloQueueDownloader);
                            queueDownloader = iApolloQueueDownloader;
                            hVar2 = queueDownloader;
                            break;
                        }
                    case 6:
                        if (f312713e.containsKey(Integer.valueOf(i3))) {
                            hVar = f312713e.get(Integer.valueOf(i3));
                            hVar2 = hVar;
                            break;
                        } else {
                            Object soPriorityDownloader = ((ISoLoadTempApi) QRoute.api(ISoLoadTempApi.class)).getSoPriorityDownloader();
                            if (soPriorityDownloader instanceof h) {
                                hVar2 = (h) soPriorityDownloader;
                            } else {
                                hVar2 = new QueueDownloader(BaseApplicationImpl.getApplication().getRuntime(), new b(false));
                            }
                            f312713e.put(Integer.valueOf(i3), hVar2);
                            break;
                        }
                }
            }
        }
        return hVar2;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f312718a;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f312718a = false;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f312718a = z16;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
        }
    }
}

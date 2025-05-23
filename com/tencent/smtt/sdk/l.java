package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.tav.core.ExportErrorStatus;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.SSLHandshakeException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes23.dex */
public class l {

    /* renamed from: d, reason: collision with root package name */
    private static int f369391d = 5;

    /* renamed from: e, reason: collision with root package name */
    private static int f369392e = 1;

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f369393f = {"tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone"};
    private boolean A;

    /* renamed from: g, reason: collision with root package name */
    private Context f369397g;

    /* renamed from: h, reason: collision with root package name */
    private String f369398h;

    /* renamed from: i, reason: collision with root package name */
    private String f369399i;

    /* renamed from: j, reason: collision with root package name */
    private String f369400j;

    /* renamed from: k, reason: collision with root package name */
    private File f369401k;

    /* renamed from: l, reason: collision with root package name */
    private long f369402l;

    /* renamed from: o, reason: collision with root package name */
    private boolean f369405o;

    /* renamed from: p, reason: collision with root package name */
    private int f369406p;

    /* renamed from: q, reason: collision with root package name */
    private int f369407q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f369408r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f369409s;

    /* renamed from: t, reason: collision with root package name */
    private HttpURLConnection f369410t;

    /* renamed from: u, reason: collision with root package name */
    private String f369411u;

    /* renamed from: v, reason: collision with root package name */
    private final TbsLogReport.TbsLogInfo f369412v;

    /* renamed from: w, reason: collision with root package name */
    private String f369413w;

    /* renamed from: x, reason: collision with root package name */
    private int f369414x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f369415y;

    /* renamed from: c, reason: collision with root package name */
    private boolean f369396c = false;

    /* renamed from: m, reason: collision with root package name */
    private int f369403m = 30000;

    /* renamed from: n, reason: collision with root package name */
    private int f369404n = 20000;

    /* renamed from: z, reason: collision with root package name */
    private int f369416z = f369391d;

    /* renamed from: a, reason: collision with root package name */
    String[] f369394a = null;

    /* renamed from: b, reason: collision with root package name */
    int f369395b = 0;

    public l(Context context) throws NullPointerException {
        Context applicationContext = context.getApplicationContext();
        this.f369397g = applicationContext;
        this.f369412v = TbsLogReport.getInstance(applicationContext).tbsLogInfo();
        this.f369411u = "tbs_downloading_" + this.f369397g.getPackageName();
        File o16 = n.o(this.f369397g);
        this.f369401k = o16;
        if (o16 != null) {
            f();
            this.f369413w = null;
            this.f369414x = -1;
            return;
        }
        throw new NullPointerException("TbsCorePrivateDir is null!");
    }

    private void a(String str) throws Exception {
        URL url = new URL(str);
        HttpURLConnection httpURLConnection = this.f369410t;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th5) {
                TbsLog.e(TbsDownloader.LOGTAG, "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + th5.toString());
            }
        }
        HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
        this.f369410t = httpURLConnection2;
        httpURLConnection2.setRequestProperty("User-Agent", TbsDownloader.b(this.f369397g));
        this.f369410t.setRequestProperty("Accept-Encoding", "identity");
        this.f369410t.setRequestMethod("GET");
        this.f369410t.setInstanceFollowRedirects(false);
        this.f369410t.setConnectTimeout(this.f369404n);
        this.f369410t.setReadTimeout(this.f369403m);
    }

    private void c(boolean z16) {
        TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(this.f369397g);
        Map<String, Object> map = tbsDownloadConfig.mSyncMap;
        Boolean bool = Boolean.FALSE;
        map.put(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, bool);
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, bool);
        tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(ExportErrorStatus.END_WRITE_VIDEO_SAMPLE));
        tbsDownloadConfig.commit();
        this.f369412v.f369131a = 100;
        int i3 = tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
        TbsDownloader.a(this.f369397g);
        if (i3 == 5 || i3 == 3) {
            Bundle a16 = a(i3);
            if (a16 == null) {
                TbsLog.i(TbsDownloader.LOGTAG, "downloadSuccess RESPONSECODE_TPATCH bundle is null ");
                a(this.f369397g);
                return;
            } else {
                TbsLog.i(TbsDownloader.LOGTAG, "downloadSuccess RESPONSECODE_TPATCH bundle is " + a16);
                n.a().b(this.f369397g, a16);
            }
        } else if (i3 > 10000) {
            b();
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
            tbsDownloadConfig.commit();
        } else {
            n.a().a(this.f369397g, new File(this.f369401k, "x5.tbs").getAbsolutePath(), tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
        }
        a(this.f369397g);
    }

    private boolean d(boolean z16) {
        File file;
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.deleteFile] isApk=" + z16);
        if (z16) {
            file = new File(this.f369401k, "x5.tbs");
        } else {
            file = new File(this.f369401k, "x5.tbs.temp");
        }
        if (!file.exists()) {
            return true;
        }
        FileUtil.b(file);
        return true;
    }

    private void f() {
        this.f369406p = 0;
        this.f369407q = 0;
        this.f369402l = -1L;
        this.f369400j = null;
        this.f369405o = false;
        this.f369408r = false;
        this.f369409s = false;
        this.f369415y = false;
    }

    private void g() {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.closeHttpRequest]");
        HttpURLConnection httpURLConnection = this.f369410t;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th5) {
                TbsLog.e(TbsDownloader.LOGTAG, "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + th5.toString());
            }
            this.f369410t = null;
        }
        int i3 = this.f369412v.f369131a;
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.closeHttpRequest] download finish code: " + i3);
        if (!this.f369408r && this.f369415y) {
            h();
        } else if (!this.f369396c) {
            TbsDownloader.f369089a = false;
        }
        TbsDownloadConfig.getInstance(this.f369397g).saveDownloadInterruptCode();
        QbSdk.f369006p.onDownloadFinish(i3);
    }

    private void h() {
        this.f369412v.setEventTime(System.currentTimeMillis());
        String apnInfo = Apn.getApnInfo(this.f369397g);
        if (apnInfo == null) {
            apnInfo = "";
        }
        int apnType = Apn.getApnType(this.f369397g);
        this.f369412v.setApn(apnInfo);
        this.f369412v.setNetworkType(apnType);
        if (apnType != this.f369414x || !apnInfo.equals(this.f369413w)) {
            this.f369412v.setNetworkChange(0);
        }
        TbsLogReport.TbsLogInfo tbsLogInfo = this.f369412v;
        int i3 = tbsLogInfo.f369131a;
        if ((i3 == 0 || i3 == 107) && tbsLogInfo.getDownFinalFlag() == 0) {
            if (!Apn.isNetworkAvailable(this.f369397g)) {
                a(101, null, true);
            } else if (!l()) {
                a(101, null, true);
            }
        }
        TbsLogReport.getInstance(this.f369397g).eventReport(TbsLogReport.EventType.TYPE_CDN_DOWNLOAD_STAT, this.f369412v);
        this.f369412v.resetArgs();
    }

    private void i() {
        int apnType = Apn.getApnType(this.f369397g);
        String apnInfo = Apn.getApnInfo(this.f369397g);
        String str = this.f369413w;
        if (str == null && this.f369414x == -1) {
            this.f369413w = apnInfo;
            this.f369414x = apnType;
        } else if (apnType != this.f369414x || !apnInfo.equals(str)) {
            this.f369412v.setNetworkChange(0);
            this.f369413w = apnInfo;
            this.f369414x = apnType;
        }
    }

    private boolean j() {
        if (new File(this.f369401k, "x5.tbs.temp").exists()) {
            return true;
        }
        return false;
    }

    private long k() {
        File file = new File(this.f369401k, "x5.tbs.temp");
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }

    private boolean l() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th5;
        InputStream inputStream;
        boolean z16 = false;
        try {
            inputStream = RuntimeMonitor.exec(Runtime.getRuntime(), "ping www.qq.com").getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    int i3 = 0;
                    do {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (!readLine.contains("TTL") && !readLine.contains(RemoteMessageConst.TTL)) {
                                i3++;
                            } else {
                                z16 = true;
                                break;
                            }
                        } catch (Throwable th6) {
                            th5 = th6;
                            try {
                                th5.printStackTrace();
                                return z16;
                            } finally {
                                a(inputStream);
                                a(inputStreamReader);
                                a(bufferedReader);
                            }
                        }
                    } while (i3 < 5);
                } catch (Throwable th7) {
                    bufferedReader = null;
                    th5 = th7;
                }
            } catch (Throwable th8) {
                bufferedReader = null;
                th5 = th8;
                inputStreamReader = null;
            }
        } catch (Throwable th9) {
            inputStreamReader = null;
            bufferedReader = null;
            th5 = th9;
            inputStream = null;
        }
        return z16;
    }

    private long m() {
        int i3 = this.f369406p;
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3 && i3 != 4) {
                return 200000L;
            }
            return JsonGrayBusiId.UI_RESERVE_100000_110000;
        }
        return i3 * 20000;
    }

    private boolean n() {
        boolean z16;
        HttpURLConnection httpURLConnection;
        Throwable th5;
        boolean z17 = true;
        if (Apn.getApnType(this.f369397g) == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] isWifi=" + z16);
        if (!z16) {
            return false;
        }
        try {
            httpURLConnection = (HttpURLConnection) new URL("https://pms.mb.qq.com/rsp204").openConnection();
        } catch (Throwable th6) {
            httpURLConnection = null;
            th5 = th6;
        }
        try {
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.getInputStream();
            int responseCode = httpURLConnection.getResponseCode();
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] responseCode=" + responseCode);
            if (responseCode != 204) {
                z17 = false;
            }
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused) {
            }
            return z17;
        } catch (Throwable th7) {
            th5 = th7;
            try {
                th5.printStackTrace();
                if (httpURLConnection == null) {
                    return false;
                }
                try {
                    httpURLConnection.disconnect();
                    return false;
                } catch (Exception unused2) {
                    return false;
                }
            } catch (Throwable th8) {
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused3) {
                    }
                }
                throw th8;
            }
        }
    }

    public boolean b(boolean z16) {
        String[] strArr;
        int i3;
        if ((z16 && !n() && (!QbSdk.canDownloadWithoutWifi() || !Apn.isNetworkAvailable(this.f369397g))) || (strArr = this.f369394a) == null || (i3 = this.f369395b) < 0 || i3 >= strArr.length) {
            return false;
        }
        this.f369395b = i3 + 1;
        this.f369400j = strArr[i3];
        this.f369406p = 0;
        this.f369407q = 0;
        this.f369402l = -1L;
        this.f369405o = false;
        this.f369408r = false;
        this.f369409s = false;
        this.f369415y = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        TbsLog.i(TbsDownloader.LOGTAG, "resumeDownload,isPause=" + this.f369396c + "isDownloading=" + TbsDownloader.isDownloading());
        if (this.f369396c && TbsDownloader.isDownloading()) {
            this.f369396c = false;
            a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        TbsLog.i(TbsDownloader.LOGTAG, "pauseDownload,isPause=" + this.f369396c + "isDownloading=" + TbsDownloader.isDownloading());
        if (this.f369396c || !TbsDownloader.isDownloading()) {
            return;
        }
        a();
        this.f369396c = true;
        this.f369415y = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x008d, code lost:
    
        if (r10 != r8) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(boolean z16, boolean z17) {
        int i3;
        boolean z18;
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z16);
        File file = new File(this.f369401k, !z16 ? "x5.tbs" : "x5.tbs.temp");
        boolean z19 = false;
        if (!file.exists()) {
            return false;
        }
        Exception exc = null;
        String string = TbsDownloadConfig.getInstance(this.f369397g).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPK_MD5, null);
        String a16 = com.tencent.smtt.utils.a.a(file);
        if (string != null && string.equals(a16)) {
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] md5(" + a16 + ") successful!");
            long j3 = 0;
            if (z16) {
                long j16 = TbsDownloadConfig.getInstance(this.f369397g).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0L);
                if (file.exists()) {
                    if (j16 > 0) {
                        j3 = file.length();
                    }
                }
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z16 + " filelength failed");
                this.f369412v.setCheckErrorDetail("fileLength:" + j3 + ",contentLength:" + j16);
                return false;
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] length(" + j3 + ") successful!");
            if (!z17 || z16) {
                i3 = -1;
            } else {
                i3 = com.tencent.smtt.utils.a.a(this.f369397g, file);
                int i16 = TbsDownloadConfig.getInstance(this.f369397g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                if (i16 != i3) {
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z16 + " versionCode failed");
                    if (z16) {
                        this.f369412v.setCheckErrorDetail("fileVersion:" + i3 + ",configVersion:" + i16);
                    }
                    return false;
                }
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i3 + ") successful!");
            if (z17 && !z16) {
                String signatureFromApk = AppUtil.getSignatureFromApk(this.f369397g, false, file);
                if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(signatureFromApk)) {
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z16 + " signature failed");
                    if (z16) {
                        TbsLogReport.TbsLogInfo tbsLogInfo = this.f369412v;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("signature:");
                        sb5.append(signatureFromApk == null ? "null" : Integer.valueOf(signatureFromApk.length()));
                        tbsLogInfo.setCheckErrorDetail(sb5.toString());
                    }
                    return false;
                }
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] signature successful!");
            if (z16) {
                try {
                    z18 = file.renameTo(new File(this.f369401k, "x5.tbs"));
                } catch (Exception e16) {
                    exc = e16;
                    z18 = false;
                }
                if (!z18) {
                    a(109, a(exc), true);
                    return false;
                }
                z19 = z18;
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] rename(" + z19 + ") successful!");
            return true;
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z16 + " md5 failed");
        if (z16) {
            this.f369412v.setCheckErrorDetail("fileMd5 not match");
        }
        return false;
    }

    public void a(boolean z16) {
        a(z16, false);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:84|(5:89|(2:146|(3:148|149|(5:151|152|154|(1:156)|157)(4:189|190|191|(1:193)(0)))(3:194|195|(2:245|246)(4:199|(0)(2:202|(1:(2:229|(1:1)(3:235|(2:237|99)|100))(2:221|(3:225|226|(1:228)(0))(2:(2:224|99)|100)))(2:206|(3:210|211|(1:213)(0))(2:(2:209|99)|100)))|101|102)))(3:93|94|(5:96|(2:98|99)|100|101|102)(3:106|107|(1:109)(0)))|103|104|105)|248|249|250|251|252|(3:481|482|(4:484|485|(1:1)(2:498|(1:1)(6:(1:503)|101|102|103|104|105))|(1:496)(0)))|254|255|256|(16:258|259|(3:460|461|(13:463|265|266|267|268|269|270|272|273|(2:274|(1:435)(4:276|277|278|(1:410)(7:280|(2:282|(1:389)(3:284|285|(2:386|387)(1:287)))(1:409)|288|289|290|(5:292|(3:294|295|296)(1:374)|(1:332)(3:300|(2:302|(1:326)(2:306|307))(1:331)|327)|328|329)(2:375|376)|330)))|388|308|(8:310|311|313|(1:315)(1:317)|316|103|104|105)(2:320|321)))|(1:459)(1:264)|265|266|267|268|269|270|272|273|(3:274|(0)(0)|330)|388|308|(0)(0))(2:474|475)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:(2:258|259)|(3:460|461|(13:463|265|266|267|268|269|270|272|273|(2:274|(1:435)(4:276|277|278|(1:410)(7:280|(2:282|(1:389)(3:284|285|(2:386|387)(1:287)))(1:409)|288|289|290|(5:292|(3:294|295|296)(1:374)|(1:332)(3:300|(2:302|(1:326)(2:306|307))(1:331)|327)|328|329)(2:375|376)|330)))|388|308|(8:310|311|313|(1:315)(1:317)|316|103|104|105)(2:320|321)))|(1:459)(1:264)|265|266|267|268|269|270|272|273|(3:274|(0)(0)|330)|388|308|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:258|259|(3:460|461|(13:463|265|266|267|268|269|270|272|273|(2:274|(1:435)(4:276|277|278|(1:410)(7:280|(2:282|(1:389)(3:284|285|(2:386|387)(1:287)))(1:409)|288|289|290|(5:292|(3:294|295|296)(1:374)|(1:332)(3:300|(2:302|(1:326)(2:306|307))(1:331)|327)|328|329)(2:375|376)|330)))|388|308|(8:310|311|313|(1:315)(1:317)|316|103|104|105)(2:320|321)))|(1:459)(1:264)|265|266|267|268|269|270|272|273|(3:274|(0)(0)|330)|388|308|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01fb, code lost:
    
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f369397g).mSyncMap.put(r13, java.lang.Long.valueOf(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0a8b, code lost:
    
        com.tencent.smtt.utils.TbsLog.e(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "[startdownload]url:" + r39.f369400j + " download exception\uff1a" + r3.toString());
        r7 = null;
        a(125, null, true);
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0bb5, code lost:
    
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f369397g).setDownloadInterruptCode(-316);
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0bc0, code lost:
    
        if (r40 == false) goto L485;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0bc2, code lost:
    
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f369397g).mSyncMap.put(r14, java.lang.Long.valueOf(r5));
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f369397g).commit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0bda, code lost:
    
        r10 = r7;
        r7 = true;
        r13 = r14;
        r3 = r26;
        r8 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0ad2, code lost:
    
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f369397g).setDownloadInterruptCode(-309);
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0add, code lost:
    
        if (r40 == false) goto L388;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0972, code lost:
    
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f369397g).mSyncMap.put(r14, java.lang.Long.valueOf(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x048c, code lost:
    
        if (r40 == false) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0526, code lost:
    
        if (r40 != false) goto L447;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0484, code lost:
    
        if (r40 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0958, code lost:
    
        a(r9);
        a(r3);
        a(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x0963, code lost:
    
        if (r39.f369409s != false) goto L387;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x0965, code lost:
    
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f369397g).setDownloadInterruptCode(-319);
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x0970, code lost:
    
        if (r40 != false) goto L447;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x09a2, code lost:
    
        if (r40 == false) goto L399;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x09ac, code lost:
    
        a(105, "freespace=" + com.tencent.smtt.utils.r.a() + ",and minFreeSpace=" + com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f369397g).getDownloadMinFreeSpace(), true);
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f369397g).setDownloadInterruptCode(-308);
        com.tencent.smtt.sdk.QbSdk.f369006p.onDownloadFinish(105);
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x09eb, code lost:
    
        a(r9);
        a(r3);
        a(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x09f4, code lost:
    
        if (r40 == false) goto L388;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x09fa, code lost:
    
        a(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x0a01, code lost:
    
        if (j() != false) goto L409;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x0a03, code lost:
    
        a(106, a(r7), false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x0a18, code lost:
    
        a(r9);
        a(r3);
        a(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x0a21, code lost:
    
        if (r40 != false) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x0a5b, code lost:
    
        r13 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x0a43, code lost:
    
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f369397g).mSyncMap.put(r14, java.lang.Long.valueOf(r5));
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f369397g).commit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x0a6a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x0a0e, code lost:
    
        a(104, a(r7), false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x0a41, code lost:
    
        if (r40 != false) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x0740, code lost:
    
        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, r7, true);
        r6 = new java.lang.StringBuilder();
        r6.append("downloadFlow=");
        r6.append(r8);
        r6.append(" downloadMaxflow=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x0757, code lost:
    
        r12 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x0759, code lost:
    
        r6.append(r12);
        a(112, r6.toString(), true);
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f369397g).setDownloadInterruptCode(com.qq.wx.voice.util.ErrorCode.WX_VOICE_RECORD_ERROR_TIME_OUT);
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x0771, code lost:
    
        r22 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x0779, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x077a, code lost:
    
        r7 = r0;
        r22 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x07e1, code lost:
    
        r14 = r32;
        r9 = r5;
        r5 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0774, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x0775, code lost:
    
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x07d6, code lost:
    
        r9 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x07df, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x07e0, code lost:
    
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x07d4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x07d5, code lost:
    
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x06e9, code lost:
    
        if (r39.f369394a == null) goto L275;
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x06f0, code lost:
    
        if (b(true, r4) != false) goto L275;
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x06f2, code lost:
    
        if (r40 != false) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x06f8, code lost:
    
        if (b(false) == false) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x06fa, code lost:
    
        r10 = r9;
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x06fe, code lost:
    
        r39.f369409s = true;
        r10 = r9;
        r6 = false;
        r16 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x0707, code lost:
    
        r39.f369409s = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x070c, code lost:
    
        if (r39.f369394a == null) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x070e, code lost:
    
        r16 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x0710, code lost:
    
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f369397g).setDownloadInterruptCode(-311);
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x071b, code lost:
    
        r10 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x06b8, code lost:
    
        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...Canceled!", true);
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f369397g).setDownloadInterruptCode(-309);
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x06ca, code lost:
    
        r32 = r10;
        r6 = false;
        r10 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:444:0x091a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:445:0x091b, code lost:
    
        r14 = r10;
        r10 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:446:0x0911, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:447:0x0912, code lost:
    
        r10 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:448:0x092a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:449:0x092b, code lost:
    
        r14 = r10;
        r10 = r9;
        r7 = r0;
        r5 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:451:0x0923, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:452:0x0924, code lost:
    
        r10 = r9;
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:455:0x0938, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:456:0x0939, code lost:
    
        r14 = r10;
        r10 = r9;
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:457:0x0931, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:458:0x0932, code lost:
    
        r10 = r9;
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:477:0x098d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:478:0x098e, code lost:
    
        r14 = r10;
        r7 = r0;
        r3 = null;
        r9 = null;
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:479:0x0983, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:480:0x0984, code lost:
    
        r7 = r0;
        r3 = null;
        r9 = null;
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:505:0x05d5, code lost:
    
        a(113, "tbsApkFileSize=" + r8 + "  but contentLength=" + r39.f369402l, true);
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r39.f369397g).setDownloadInterruptCode(-310);
     */
    /* JADX WARN: Code restructure failed: missing block: B:511:0x0a6c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:512:0x0a6d, code lost:
    
        r14 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:545:0x0235, code lost:
    
        if (r40 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:550:0x01f9, code lost:
    
        if (r40 == false) goto L55;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0a7e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0bb2  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0ad2 A[EDGE_INSN: B:178:0x0ad2->B:179:0x0ad2 BREAK  A[LOOP:0: B:35:0x014c->B:105:0x014c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x06dc  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0895 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:320:0x08ce A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:339:0x099c A[Catch: all -> 0x0a5e, TryCatch #36 {all -> 0x0a5e, blocks: (B:337:0x0995, B:339:0x099c, B:342:0x09a4, B:345:0x09ac, B:350:0x09fa, B:352:0x0a03, B:360:0x0a0e, B:364:0x0a27), top: B:336:0x0995 }] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0a03 A[Catch: all -> 0x0a5e, TryCatch #36 {all -> 0x0a5e, blocks: (B:337:0x0995, B:339:0x099c, B:342:0x09a4, B:345:0x09ac, B:350:0x09fa, B:352:0x0a03, B:360:0x0a0e, B:364:0x0a27), top: B:336:0x0995 }] */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0a0e A[Catch: all -> 0x0a5e, TRY_LEAVE, TryCatch #36 {all -> 0x0a5e, blocks: (B:337:0x0995, B:339:0x099c, B:342:0x09a4, B:345:0x09ac, B:350:0x09fa, B:352:0x0a03, B:360:0x0a0e, B:364:0x0a27), top: B:336:0x0995 }] */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0a24 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:435:0x06b8 A[EDGE_INSN: B:435:0x06b8->B:436:0x06b8 BREAK  A[LOOP:1: B:274:0x06b4->B:330:0x08f5], EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r39v0, types: [com.tencent.smtt.sdk.l] */
    /* JADX WARN: Type inference failed for: r3v10, types: [com.tencent.smtt.sdk.TbsLogReport$TbsLogInfo] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z16, boolean z17) {
        int i3;
        ?? r26;
        String str;
        long j3;
        String str2;
        Throwable th5;
        String str3;
        String str4;
        long j16;
        long j17;
        int responseCode;
        String str5;
        Throwable th6;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        InputStream inputStream2;
        IOException iOException;
        FileOutputStream fileOutputStream2;
        String contentEncoding;
        byte[] bArr;
        long j18;
        long j19;
        String str6;
        boolean z18;
        String str7;
        String str8;
        byte[] bArr2;
        long j26;
        String str9;
        String str10;
        String str11;
        long j27;
        String str12 = TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME;
        if (n.a().c(this.f369397g) && !z16) {
            TbsDownloader.f369089a = false;
            TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(-322);
            QbSdk.f369006p.onDownloadFinish(-322);
            return;
        }
        int i16 = TbsDownloadConfig.getInstance(this.f369397g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
        boolean z19 = true;
        boolean z26 = i16 == 1 || i16 == 2 || i16 == 4;
        this.A = z16;
        String str13 = null;
        this.f369398h = TbsDownloadConfig.getInstance(this.f369397g).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, null);
        String string = TbsDownloadConfig.getInstance(this.f369397g).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADURL_LIST, null);
        TbsLog.i(TbsDownloader.LOGTAG, "backupUrlStrings:" + string, true);
        this.f369394a = null;
        this.f369395b = 0;
        if (!z16 && string != null && !"".equals(string.trim())) {
            this.f369394a = string.trim().split(";");
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] mDownloadUrl=" + this.f369398h + " backupUrlStrings=" + string + " mLocation=" + this.f369400j + " mCanceled=" + this.f369408r + " mHttpRequest=" + this.f369410t);
        if (this.f369398h == null && this.f369400j == null) {
            TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(-302);
            QbSdk.f369006p.onDownloadFinish(132);
            return;
        }
        if (this.f369410t != null && !this.f369408r) {
            TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(-303);
            QbSdk.f369006p.onDownloadFinish(133);
            return;
        }
        f();
        TbsLog.i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...", true);
        long downloadMaxflow = TbsDownloadConfig.getInstance(this.f369397g).getDownloadMaxflow();
        SharedPreferences sharedPreferences = TbsDownloadConfig.getInstance(this.f369397g).mPreferences;
        String str14 = TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW;
        long j28 = sharedPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0L);
        this.f369416z = z16 ? f369392e : f369391d;
        boolean z27 = false;
        long j29 = j28;
        while (true) {
            if (this.f369406p > this.f369416z) {
                TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(-305);
                break;
            }
            if (this.f369407q > 8) {
                a(123, str13, z19);
                TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(-306);
                break;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (z16) {
                j3 = downloadMaxflow;
            } else {
                try {
                    j3 = downloadMaxflow;
                } catch (Throwable th7) {
                    th = th7;
                    str = str12;
                    j3 = downloadMaxflow;
                }
                try {
                    if (currentTimeMillis - TbsDownloadConfig.getInstance(this.f369397g).mPreferences.getLong(str12, 0L) > 86400000) {
                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] OVER DOWNLOAD_PERIOD");
                        TbsDownloadConfig.getInstance(this.f369397g).mSyncMap.put(str12, Long.valueOf(currentTimeMillis));
                        TbsDownloadConfig.getInstance(this.f369397g).mSyncMap.put(str14, 0L);
                        TbsDownloadConfig.getInstance(this.f369397g).commit();
                        j29 = 0;
                    } else {
                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] downloadFlow=" + j29);
                        if (j29 >= j3) {
                            TbsLog.i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...failed because you exceeded max flow!", true);
                            a(112, null, true);
                            TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(ErrorCode.WX_VOICE_RECORD_ERROR_TIME_OUT);
                        }
                    }
                    if (FileUtil.b(this.f369397g)) {
                        z19 = true;
                    } else {
                        TbsLog.w(TbsDownloader.LOGTAG, "DownloadBegin FreeSpace too small", true);
                        a(105, null, true);
                        TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(-308);
                    }
                } catch (Throwable th8) {
                    th = th8;
                    str = str12;
                    str2 = str14;
                    th5 = th;
                    try {
                        if (th5 instanceof SSLHandshakeException) {
                        }
                        String str15 = null;
                        th5.printStackTrace();
                        long j36 = 0;
                        a(0L);
                        a(107, a(th5), false);
                        if (this.f369408r) {
                        }
                    } finally {
                    }
                }
            }
            try {
                this.f369415y = z19;
                String str16 = this.f369400j;
                if (str16 == null) {
                    str16 = this.f369398h;
                }
                TbsLog.i(TbsDownloader.LOGTAG, "try url:" + str16 + ",mRetryTimes:" + this.f369406p, true);
                if (!str16.equals(this.f369399i)) {
                    this.f369412v.setDownloadUrl(str16);
                }
                this.f369399i = str16;
                a(str16);
                if (this.f369405o) {
                    str = str12;
                    str3 = "/";
                    str4 = "STEP 1/2 begin downloading...failed because you exceeded max flow!";
                    j16 = currentTimeMillis;
                    j17 = 0;
                } else {
                    j16 = currentTimeMillis;
                    try {
                        j17 = k();
                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] range=" + j17);
                        str4 = "STEP 1/2 begin downloading...failed because you exceeded max flow!";
                        if (this.f369402l <= 0) {
                            StringBuilder sb5 = new StringBuilder();
                            str = str12;
                            try {
                                sb5.append("STEP 1/2 begin downloading...current");
                                sb5.append(j17);
                                TbsLog.i(TbsDownloader.LOGTAG, sb5.toString(), true);
                                this.f369410t.setRequestProperty("Range", "bytes=" + j17 + "-");
                                str3 = "/";
                            } catch (Throwable th9) {
                                th = th9;
                                th5 = th;
                                str2 = str14;
                                if (th5 instanceof SSLHandshakeException) {
                                }
                                String str152 = null;
                                th5.printStackTrace();
                                long j362 = 0;
                                a(0L);
                                a(107, a(th5), false);
                                if (this.f369408r) {
                                }
                            }
                        } else {
                            str = str12;
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("#1 STEP 1/2 begin downloading...current/total=");
                            sb6.append(j17);
                            sb6.append("/");
                            str3 = "/";
                            sb6.append(this.f369402l);
                            TbsLog.i(TbsDownloader.LOGTAG, sb6.toString(), true);
                            this.f369410t.setRequestProperty("Range", "bytes=" + j17 + "-" + this.f369402l);
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        str = str12;
                    }
                }
            } catch (Throwable th11) {
                th = th11;
                str = str12;
            }
            try {
                this.f369412v.setDownloadCancel(j17 == 0 ? 0 : 1);
                i();
                if (this.f369406p >= 1) {
                    this.f369410t.addRequestProperty("Referer", this.f369398h);
                }
                responseCode = this.f369410t.getResponseCode();
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] responseCode=" + responseCode);
                this.f369412v.setHttpCode(responseCode);
                if (!z16 && !TbsDownloader.getOverSea(this.f369397g) && Apn.getApnType(this.f369397g) != 3 && !QbSdk.canDownloadWithoutWifi()) {
                    a();
                    a(111, null, true);
                    TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(-324);
                    TbsListener tbsListener = QbSdk.f369006p;
                    if (tbsListener != null) {
                        tbsListener.onDownloadFinish(111);
                    }
                    TbsLog.w(TbsDownloader.LOGTAG, "Download is canceled due to NOT_WIFI error!", false);
                }
            } catch (Throwable th12) {
                th = th12;
                str2 = str14;
                th5 = th;
                if (th5 instanceof SSLHandshakeException) {
                }
                String str1522 = null;
                th5.printStackTrace();
                long j3622 = 0;
                a(0L);
                a(107, a(th5), false);
                if (this.f369408r) {
                }
            }
            if (this.f369408r) {
                TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(-309);
                if (!z16) {
                }
            } else {
                if (responseCode != 200 && responseCode != 206) {
                    if (responseCode >= 300 && responseCode <= 307) {
                        String headerField = this.f369410t.getHeaderField("Location");
                        if (!TextUtils.isEmpty(headerField)) {
                            this.f369400j = headerField;
                            this.f369407q++;
                            if (!z16) {
                                TbsDownloadConfig.getInstance(this.f369397g).mSyncMap.put(str14, Long.valueOf(j29));
                                TbsDownloadConfig.getInstance(this.f369397g).commit();
                            }
                            str5 = str14;
                            str14 = str5;
                            downloadMaxflow = j3;
                            str12 = str;
                        } else {
                            a(124, null, true);
                            TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(-312);
                            if (!z16) {
                            }
                        }
                    } else {
                        a(102, String.valueOf(responseCode), false);
                        if (responseCode == 416) {
                            if (b(true, z26)) {
                                try {
                                    TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(-323);
                                    if (!z16) {
                                        TbsDownloadConfig.getInstance(this.f369397g).mSyncMap.put(str14, Long.valueOf(j29));
                                        TbsDownloadConfig.getInstance(this.f369397g).commit();
                                    }
                                    z27 = true;
                                } catch (Throwable th13) {
                                    th5 = th13;
                                    str2 = str14;
                                    z27 = true;
                                    if (th5 instanceof SSLHandshakeException) {
                                    }
                                    String str15222 = null;
                                    th5.printStackTrace();
                                    long j36222 = 0;
                                    a(0L);
                                    a(107, a(th5), false);
                                    if (this.f369408r) {
                                    }
                                }
                            } else {
                                d(false);
                                TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(-313);
                                if (!z16) {
                                }
                            }
                        } else if ((responseCode == 403 || responseCode == 406) && this.f369402l == -1) {
                            TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(-314);
                        } else {
                            if (responseCode != 202) {
                                int i17 = this.f369406p;
                                int i18 = this.f369416z;
                                if (i17 < i18 && responseCode == 503) {
                                    a(Long.parseLong(this.f369410t.getHeaderField("Retry-After")));
                                    if (this.f369408r) {
                                        TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(-309);
                                        if (!z16) {
                                        }
                                    } else {
                                        if (!z16) {
                                            TbsDownloadConfig.getInstance(this.f369397g).mSyncMap.put(str14, Long.valueOf(j29));
                                            TbsDownloadConfig.getInstance(this.f369397g).commit();
                                        }
                                        str5 = str14;
                                    }
                                } else if (i17 < i18 && (responseCode == 408 || responseCode == 504 || responseCode == 502)) {
                                    a(0L);
                                    if (this.f369408r) {
                                        TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(-309);
                                        if (!z16) {
                                        }
                                    } else {
                                        if (!z16) {
                                            TbsDownloadConfig.getInstance(this.f369397g).mSyncMap.put(str14, Long.valueOf(j29));
                                            TbsDownloadConfig.getInstance(this.f369397g).commit();
                                        }
                                        str5 = str14;
                                    }
                                } else {
                                    if (k() > 0 || this.f369405o || responseCode == 410) {
                                        break;
                                    }
                                    this.f369405o = true;
                                    if (!z16) {
                                        TbsDownloadConfig.getInstance(this.f369397g).mSyncMap.put(str14, Long.valueOf(j29));
                                        TbsDownloadConfig.getInstance(this.f369397g).commit();
                                    }
                                    str5 = str14;
                                }
                            }
                            str14 = str5;
                            downloadMaxflow = j3;
                            str12 = str;
                        }
                    }
                    z19 = true;
                    str13 = null;
                }
                this.f369402l = this.f369410t.getContentLength() + j17;
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] mContentLength=" + this.f369402l);
                this.f369412v.setPkgSize(this.f369402l);
                str5 = str14;
                long j37 = TbsDownloadConfig.getInstance(this.f369397g).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0L);
                if (j37 != 0) {
                    try {
                    } catch (Throwable th14) {
                        th5 = th14;
                        str2 = str5;
                        if (th5 instanceof SSLHandshakeException) {
                        }
                        String str152222 = null;
                        th5.printStackTrace();
                        long j362222 = 0;
                        a(0L);
                        a(107, a(th5), false);
                        if (this.f369408r) {
                        }
                    }
                    if (this.f369402l != j37) {
                        TbsLog.i(TbsDownloader.LOGTAG, "DownloadBegin tbsApkFileSize=" + j37 + "  but contentLength=" + this.f369402l, true);
                        if (z16 || !(n() || (QbSdk.canDownloadWithoutWifi() && Apn.isNetworkAvailable(this.f369397g)))) {
                            break;
                        }
                        if (this.f369394a == null || !b(false)) {
                            break;
                        }
                        if (!z16) {
                            TbsDownloadConfig.getInstance(this.f369397g).mSyncMap.put(str5, Long.valueOf(j29));
                            TbsDownloadConfig.getInstance(this.f369397g).commit();
                        }
                        str14 = str5;
                        downloadMaxflow = j3;
                        str12 = str;
                        z19 = true;
                        str13 = null;
                        if (!z16) {
                            TbsDownloadConfig.getInstance(this.f369397g).mSyncMap.put(str5, Long.valueOf(j29));
                        }
                    }
                }
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] begin readResponse");
                InputStream inputStream3 = this.f369410t.getInputStream();
                if (inputStream3 == null) {
                    str2 = str5;
                    inputStream2 = inputStream3;
                    inputStream = null;
                    fileOutputStream2 = null;
                    break;
                }
                try {
                    contentEncoding = this.f369410t.getContentEncoding();
                } catch (IOException e16) {
                    str2 = str5;
                    inputStream2 = inputStream3;
                    iOException = e16;
                    inputStream = null;
                } catch (Throwable th15) {
                    inputStream2 = inputStream3;
                    th6 = th15;
                    inputStream = null;
                }
                if (contentEncoding != null) {
                    try {
                    } catch (IOException e17) {
                        iOException = e17;
                        str2 = str5;
                        inputStream = null;
                        inputStream2 = inputStream3;
                        fileOutputStream = null;
                        try {
                            iOException.printStackTrace();
                            if (!(iOException instanceof SocketTimeoutException)) {
                            }
                            this.f369403m = 100000;
                            a(0L);
                            a(103, a(iOException), false);
                            a(fileOutputStream);
                            a(inputStream);
                            a(inputStream2);
                        } catch (Throwable th16) {
                            th6 = th16;
                            a(fileOutputStream);
                            a(inputStream);
                            a(inputStream2);
                            throw th6;
                        }
                    } catch (Throwable th17) {
                        th6 = th17;
                        inputStream = null;
                        inputStream2 = inputStream3;
                        fileOutputStream = null;
                        a(fileOutputStream);
                        a(inputStream);
                        a(inputStream2);
                        throw th6;
                    }
                    if (contentEncoding.contains("gzip")) {
                        inputStream = new GZIPInputStream(inputStream3);
                        bArr = new byte[8192];
                        long j38 = j29;
                        File file = new File(this.f369401k, "x5.tbs.temp");
                        TbsLog.i(TbsDownloader.LOGTAG, "fileDownloadApk is " + file.getAbsolutePath(), true);
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file, true);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        long j39 = j17;
                        j18 = j16;
                        j19 = j39;
                        while (true) {
                            if (this.f369408r) {
                                str6 = str5;
                                try {
                                    int read = inputStream.read(bArr, 0, 8192);
                                    if (read > 0) {
                                        fileOutputStream3.write(bArr, 0, read);
                                        fileOutputStream3.flush();
                                        if (z16) {
                                            str8 = str4;
                                            bArr2 = bArr;
                                            inputStream2 = inputStream3;
                                        } else {
                                            bArr2 = bArr;
                                            inputStream2 = inputStream3;
                                            j27 = j38 + read;
                                            if (j27 >= j3) {
                                                break;
                                            }
                                            str8 = str4;
                                            if (!FileUtil.b(this.f369397g)) {
                                                TbsLog.i(TbsDownloader.LOGTAG, "DownloadEnd FreeSpace too small ", true);
                                                a(105, "freespace=" + com.tencent.smtt.utils.r.a() + ",and minFreeSpace=" + TbsDownloadConfig.getInstance(this.f369397g).getDownloadMinFreeSpace(), true);
                                                TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(-308);
                                                break;
                                            }
                                            j38 = j27;
                                        }
                                        long j46 = read;
                                        try {
                                            long a16 = a(j18, j46);
                                            long currentTimeMillis3 = System.currentTimeMillis();
                                            long j47 = j19 + j46;
                                            if (currentTimeMillis3 - currentTimeMillis2 > 1000) {
                                                StringBuilder sb7 = new StringBuilder();
                                                sb7.append("#2 STEP 1/2 begin downloading...current/total=");
                                                sb7.append(j47);
                                                String str17 = str3;
                                                sb7.append(str17);
                                                sb7.append(this.f369402l);
                                                TbsLog.i(TbsDownloader.LOGTAG, sb7.toString(), true);
                                                TbsListener tbsListener2 = QbSdk.f369006p;
                                                if (tbsListener2 != null) {
                                                    str11 = str17;
                                                    j26 = a16;
                                                    try {
                                                        tbsListener2.onDownloadProgress((int) ((j47 / this.f369402l) * 100.0d));
                                                    } catch (IOException e18) {
                                                        iOException = e18;
                                                        fileOutputStream = fileOutputStream3;
                                                        j29 = j38;
                                                        str2 = str6;
                                                        iOException.printStackTrace();
                                                        if (!(iOException instanceof SocketTimeoutException)) {
                                                        }
                                                        this.f369403m = 100000;
                                                        a(0L);
                                                        a(103, a(iOException), false);
                                                        a(fileOutputStream);
                                                        a(inputStream);
                                                        a(inputStream2);
                                                    } catch (Throwable th18) {
                                                        th6 = th18;
                                                        fileOutputStream = fileOutputStream3;
                                                        a(fileOutputStream);
                                                        a(inputStream);
                                                        a(inputStream2);
                                                        throw th6;
                                                    }
                                                } else {
                                                    str11 = str17;
                                                    j26 = a16;
                                                }
                                                if (z16 || j47 - j39 <= 1048576) {
                                                    str10 = str6;
                                                } else {
                                                    if (!TbsDownloader.getOverSea(this.f369397g)) {
                                                        if (Apn.getApnType(this.f369397g) != 3 && !QbSdk.canDownloadWithoutWifi()) {
                                                            a();
                                                            TbsLog.i(TbsDownloader.LOGTAG, "Download is paused due to NOT_WIFI error!", false);
                                                            a(111, null, true);
                                                            TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(-304);
                                                            break;
                                                        }
                                                        str10 = str6;
                                                    } else {
                                                        str10 = str6;
                                                    }
                                                    j39 = j47;
                                                }
                                                currentTimeMillis2 = currentTimeMillis3;
                                                str9 = str11;
                                            } else {
                                                j26 = a16;
                                                str9 = str3;
                                                str10 = str6;
                                            }
                                            j19 = j47;
                                            inputStream3 = inputStream2;
                                            str5 = str10;
                                            str3 = str9;
                                            bArr = bArr2;
                                            str4 = str8;
                                            j18 = j26;
                                        } catch (IOException e19) {
                                            e = e19;
                                            str2 = str6;
                                            iOException = e;
                                            fileOutputStream = fileOutputStream3;
                                            j29 = j38;
                                            iOException.printStackTrace();
                                            if (!(iOException instanceof SocketTimeoutException)) {
                                            }
                                            this.f369403m = 100000;
                                            a(0L);
                                            a(103, a(iOException), false);
                                            a(fileOutputStream);
                                            a(inputStream);
                                            a(inputStream2);
                                        } catch (Throwable th19) {
                                            th = th19;
                                            th6 = th;
                                            fileOutputStream = fileOutputStream3;
                                            a(fileOutputStream);
                                            a(inputStream);
                                            a(inputStream2);
                                            throw th6;
                                        }
                                    } else {
                                        try {
                                            break;
                                        } catch (IOException e26) {
                                            iOException = e26;
                                            inputStream2 = inputStream3;
                                            str2 = str6;
                                            fileOutputStream = fileOutputStream3;
                                            j29 = j38;
                                            iOException.printStackTrace();
                                            if (!(iOException instanceof SocketTimeoutException)) {
                                            }
                                            this.f369403m = 100000;
                                            a(0L);
                                            a(103, a(iOException), false);
                                            a(fileOutputStream);
                                            a(inputStream);
                                            a(inputStream2);
                                        } catch (Throwable th20) {
                                            th6 = th20;
                                            inputStream2 = inputStream3;
                                            fileOutputStream = fileOutputStream3;
                                            a(fileOutputStream);
                                            a(inputStream);
                                            a(inputStream2);
                                            throw th6;
                                        }
                                    }
                                } catch (IOException e27) {
                                    e = e27;
                                    inputStream2 = inputStream3;
                                } catch (Throwable th21) {
                                    th = th21;
                                    inputStream2 = inputStream3;
                                }
                            } else {
                                try {
                                    break;
                                } catch (IOException e28) {
                                    iOException = e28;
                                    str2 = str5;
                                    inputStream2 = inputStream3;
                                    fileOutputStream = fileOutputStream3;
                                    j29 = j38;
                                    iOException.printStackTrace();
                                    if (!(iOException instanceof SocketTimeoutException)) {
                                    }
                                    this.f369403m = 100000;
                                    a(0L);
                                    a(103, a(iOException), false);
                                    a(fileOutputStream);
                                    a(inputStream);
                                    a(inputStream2);
                                } catch (Throwable th22) {
                                    th6 = th22;
                                    inputStream2 = inputStream3;
                                    fileOutputStream = fileOutputStream3;
                                    a(fileOutputStream);
                                    a(inputStream);
                                    a(inputStream2);
                                    throw th6;
                                }
                            }
                        }
                        j38 = j27;
                        z18 = false;
                        if (z18) {
                            str2 = str6;
                            fileOutputStream2 = fileOutputStream3;
                            j29 = j38;
                            break;
                        }
                        try {
                            a(fileOutputStream3);
                            a(inputStream);
                            a(inputStream2);
                            if (z16) {
                                str7 = str6;
                            } else {
                                str7 = str6;
                                TbsDownloadConfig.getInstance(this.f369397g).mSyncMap.put(str7, Long.valueOf(j38));
                                TbsDownloadConfig.getInstance(this.f369397g).commit();
                            }
                            str14 = str7;
                            downloadMaxflow = j3;
                            str12 = str;
                            j29 = j38;
                            z19 = true;
                            str13 = null;
                        } catch (Throwable th23) {
                            str2 = str6;
                            th5 = th23;
                            j29 = j38;
                            if (th5 instanceof SSLHandshakeException) {
                            }
                            String str1522222 = null;
                            th5.printStackTrace();
                            long j3622222 = 0;
                            a(0L);
                            a(107, a(th5), false);
                            if (this.f369408r) {
                            }
                        }
                    }
                }
                inputStream = (contentEncoding == null || !contentEncoding.contains("deflate")) ? inputStream3 : new InflaterInputStream(inputStream3, new Inflater(true));
                bArr = new byte[8192];
                long j382 = j29;
                File file2 = new File(this.f369401k, "x5.tbs.temp");
                TbsLog.i(TbsDownloader.LOGTAG, "fileDownloadApk is " + file2.getAbsolutePath(), true);
                FileOutputStream fileOutputStream32 = new FileOutputStream(file2, true);
                long currentTimeMillis22 = System.currentTimeMillis();
                long j392 = j17;
                j18 = j16;
                j19 = j392;
                while (true) {
                    if (this.f369408r) {
                    }
                    j19 = j47;
                    inputStream3 = inputStream2;
                    str5 = str10;
                    str3 = str9;
                    bArr = bArr2;
                    str4 = str8;
                    j18 = j26;
                }
                j382 = j27;
                z18 = false;
                if (z18) {
                }
            }
            TbsDownloadConfig.getInstance(this.f369397g).commit();
        }
        if (!this.f369408r) {
            if (this.f369409s) {
                if (this.f369394a == null && !z27) {
                    z27 = b(true, z26);
                }
                boolean z28 = z27;
                this.f369412v.setUnpkgFlag(z28 ? 1 : 0);
                if (!z26) {
                    this.f369412v.setPatchUpdateFlag(z28 ? 1 : 2);
                } else {
                    this.f369412v.setPatchUpdateFlag(0);
                }
                TbsLog.i(TbsDownloader.LOGTAG, "downloadSuccess is " + z28);
                if (z28) {
                    c(true);
                    TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(-317);
                    a(100, "success", true);
                    i3 = 0;
                    r26 = z28;
                } else {
                    TbsDownloadConfig.getInstance(this.f369397g).setDownloadInterruptCode(-318);
                    i3 = 0;
                    d(false);
                    r26 = z28;
                }
            } else {
                i3 = 0;
                r26 = z27;
            }
            TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(this.f369397g);
            if (r26 != 0) {
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, Integer.valueOf(tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, i3) + 1));
            } else {
                int i19 = tbsDownloadConfig.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, i3) + 1;
                tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, Integer.valueOf(i19));
                if (i19 == tbsDownloadConfig.getDownloadFailedMaxRetrytimes()) {
                    this.f369412v.setDownloadCancel(2);
                }
            }
            tbsDownloadConfig.commit();
            this.f369412v.setDownFinalFlag(r26);
        } else if (this.f369396c) {
            a(134, "pauseDownload()", true);
        } else {
            a(131, "stopDownload()", true);
        }
        g();
    }

    public boolean c() {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.A);
        return this.A;
    }

    public void b() {
        a();
        d(false);
        d(true);
    }

    public void b(int i3) {
        if (n.a().p(this.f369397g)) {
            n.a().c();
            try {
                File file = new File(this.f369401k, "x5.tbs");
                int a16 = com.tencent.smtt.utils.a.a(this.f369397g, file);
                if (-1 == a16 || (i3 > 0 && i3 == a16)) {
                    FileUtil.b(file);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void b(Context context) {
        try {
            n.a();
            File o16 = n.o(context);
            new File(o16, "x5.tbs").delete();
            new File(o16, "x5.tbs.temp").delete();
        } catch (Exception unused) {
        }
    }

    private long a(long j3, long j16) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f369412v.setDownConsumeTime(currentTimeMillis - j3);
        this.f369412v.setDownloadSize(j16);
        return currentTimeMillis;
    }

    private void a(int i3, String str, boolean z16) {
        if (z16 || this.f369406p > this.f369416z) {
            this.f369412v.setErrorCode(i3);
            this.f369412v.setFailDetail(str);
        }
    }

    private String a(Throwable th5) {
        String stackTraceString = Log.getStackTraceString(th5);
        return stackTraceString.length() > 1024 ? stackTraceString.substring(0, 1024) : stackTraceString;
    }

    public static void a(Context context) {
        try {
            TbsLog.i(TbsDownloader.LOGTAG, "clearDecoupleDirOld #00");
            File a16 = n.a().a(context, context.getDir("tbs_64", 0));
            FileUtil.b(a16);
            if (a16 != null) {
                TbsLog.i(TbsDownloader.LOGTAG, "clearDecoupleDirOld dir is " + a16.getAbsolutePath());
            }
            File a17 = n.a().a(context, context.getDir("tbs", 0));
            FileUtil.b(a17);
            if (a17 != null) {
                TbsLog.i(TbsDownloader.LOGTAG, "clearDecoupleDirOld dir is " + a17.getAbsolutePath());
            }
        } catch (Throwable th5) {
            TbsLog.i(TbsDownloader.LOGTAG, "clearDecoupleDirOld stack is " + Log.getStackTraceString(th5));
        }
    }

    public Bundle a(int i3) {
        File n3 = n.a().n(this.f369397g);
        int g16 = n.a().g(this.f369397g);
        File file = new File(this.f369401k, "x5.tbs");
        String absolutePath = file.exists() ? file.getAbsolutePath() : null;
        if (absolutePath == null) {
            TbsLog.i(TbsDownloader.LOGTAG, "getTpatchBundle tbsApkFile is " + file.getAbsolutePath());
            return null;
        }
        int i16 = TbsDownloadConfig.getInstance(this.f369397g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        File b16 = n.a().b(this.f369397g, 5);
        Bundle bundle = new Bundle();
        bundle.putInt(QCircleDaTongConstant.ElementParamValue.OPERATION, i3);
        bundle.putInt("old_core_ver", g16);
        bundle.putInt("new_core_ver", i16);
        bundle.putString("old_apk_location", n3.getAbsolutePath());
        bundle.putString("new_apk_location", b16.getAbsolutePath());
        bundle.putString("diff_file_location", absolutePath);
        bundle.putString("core_type_tpatch", "not_stable");
        bundle.putInt("for_self_core", 1);
        return bundle;
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private void a(long j3) {
        this.f369406p++;
        if (j3 <= 0) {
            try {
                j3 = m();
            } catch (Exception unused) {
                return;
            }
        }
        LockMethodProxy.sleep(j3);
    }

    public void a() {
        this.f369408r = true;
        if (TbsShareManager.isThirdPartyApp(this.f369397g)) {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(this.f369397g).tbsLogInfo();
            tbsLogInfo.setErrorCode(-309);
            tbsLogInfo.setFailDetail(new Exception());
            TbsLogReport.getInstance(this.f369397g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
        }
    }
}

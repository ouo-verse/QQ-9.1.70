package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.exception.BusinessLimitException;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.channels.FileLock;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class X5Downloader implements ProgressListener {
    private int A;
    private String B;
    private final TbsListener C;

    /* renamed from: a, reason: collision with root package name */
    private final Context f369246a;

    /* renamed from: b, reason: collision with root package name */
    private final QbSdk.PrivateCDNMode f369247b;

    /* renamed from: c, reason: collision with root package name */
    private String f369248c;

    /* renamed from: d, reason: collision with root package name */
    private String f369249d;

    /* renamed from: e, reason: collision with root package name */
    private File f369250e;

    /* renamed from: f, reason: collision with root package name */
    private File f369251f;

    /* renamed from: g, reason: collision with root package name */
    private long f369252g;

    /* renamed from: h, reason: collision with root package name */
    private String f369253h;

    /* renamed from: i, reason: collision with root package name */
    private int f369254i;

    /* renamed from: j, reason: collision with root package name */
    private int f369255j;

    /* renamed from: k, reason: collision with root package name */
    private int f369256k;

    /* renamed from: l, reason: collision with root package name */
    private DownloadDelegate f369257l;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f369258m;

    /* renamed from: n, reason: collision with root package name */
    private FileLock f369259n;

    /* renamed from: o, reason: collision with root package name */
    private FileOutputStream f369260o;

    /* renamed from: p, reason: collision with root package name */
    private int f369261p;

    /* renamed from: q, reason: collision with root package name */
    private int f369262q;

    /* renamed from: r, reason: collision with root package name */
    private int f369263r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f369264s;

    /* renamed from: t, reason: collision with root package name */
    private HttpURLConnection f369265t;

    /* renamed from: u, reason: collision with root package name */
    private long f369266u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f369267v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f369268w;

    /* renamed from: x, reason: collision with root package name */
    private final StringBuilder f369269x;

    /* renamed from: y, reason: collision with root package name */
    private Handler f369270y;

    /* renamed from: z, reason: collision with root package name */
    private HandlerThread f369271z;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface DownloadDelegate {
        void download(X5Downloader x5Downloader, String str, File file);
    }

    public X5Downloader(Context context) {
        this(context, QbSdk.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        SharedPreferences sharedPreferences = TbsDownloadConfig.getInstance(this.f369246a).mPreferences;
        boolean z16 = false;
        if (sharedPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWLOAD_FLOWCTR, 0) == 1) {
            z16 = true;
        }
        if (z16) {
            this.f369248c = "";
            b(-20, "meet flow control.");
            return;
        }
        String string = sharedPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, "");
        this.f369248c = string;
        if ("".equals(string)) {
            b(-20, "meet flow control.");
        } else {
            TbsLog.i("X5Downloader", "start delegate download progress...");
            this.f369257l.download(this, this.f369248c, this.f369251f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f369268w = false;
        this.f369258m = false;
        this.f369267v = false;
        this.f369261p = 0;
        this.f369262q = 0;
        this.f369263r = 30000;
        this.f369264s = false;
        this.f369265t = null;
        this.f369266u = -1L;
    }

    private void g() {
        TbsDownloadConfig.getInstance(this.f369246a).mPreferences.edit().putString(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOADURL, "").apply();
    }

    private void h() {
        f();
        TbsLog.i("X5Downloader", "download and verify x5 finished, prepare to install");
        boolean z16 = true;
        if (this.f369251f.exists()) {
            n.a().a(true);
            n.a().b(this.f369246a, this.f369251f.getAbsolutePath(), this.f369254i);
        }
        n a16 = n.a();
        Context context = this.f369246a;
        if (g.f369355a != 0) {
            z16 = false;
        }
        a16.b(context, z16);
        TbsLog.i("X5Downloader", "download and install finished.");
        TbsLog.writeLogToDisk();
        onFinished();
    }

    private String i() {
        return "x5.tbs.temp" + this.f369254i;
    }

    private String j() {
        if (this.f369247b == QbSdk.PrivateCDNMode.SELF_IMPL) {
            return "x5.tbs";
        }
        return "x5." + this.f369254i + ".tbs";
    }

    public final void destroy() {
        HandlerThread handlerThread = this.f369271z;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        this.f369271z = null;
        this.f369270y = null;
    }

    public final void installX5(File file) {
        installX5(file, true);
    }

    public final void notifyDownloadFinished() {
        a(QbSdk.PrivateCDNMode.SELF_IMPL);
        if (!a(this.f369251f)) {
            b(this.A, this.B);
        } else {
            h();
        }
    }

    public final void resetDownloadCache() {
        a(QbSdk.PrivateCDNMode.STANDARD_IMPL);
        if (!c()) {
            TbsLog.i("X5Downloader", "Downloading, cannot reset cache.");
            return;
        }
        FileUtil.b(this.f369251f);
        FileUtil.b(this.f369250e);
        this.f369250e = new File(FileUtil.c(this.f369246a), i());
        this.f369251f = new File(FileUtil.c(this.f369246a), j());
        TbsLog.i("X5Downloader", "resetDownloadCache");
        d();
    }

    public final boolean resumeDownload() {
        a(QbSdk.PrivateCDNMode.STANDARD_IMPL);
        TbsLog.i("X5Downloader", "Call ResumeDownload, isDownloading: " + this.f369268w);
        if (this.f369268w) {
            return false;
        }
        this.f369270y.obtainMessage().sendToTarget();
        return true;
    }

    public final X5Downloader setConnectTimesOut(int i3) {
        if (i3 > 0) {
            this.f369256k = i3;
            return this;
        }
        throw new IllegalArgumentException("can not set ConnectTimesOut <= 0, input is: " + i3);
    }

    public final X5Downloader setDownloadDelegate(DownloadDelegate downloadDelegate) {
        a(QbSdk.PrivateCDNMode.SELF_IMPL);
        this.f369257l = downloadDelegate;
        return this;
    }

    public final X5Downloader setDownloadUrl(String str) {
        if (str.contains("imtt.qq.com") && this.f369247b != QbSdk.PrivateCDNMode.STANDARD_IMPL) {
            throw new IllegalArgumentException("you can't set TBS official domain");
        }
        this.f369248c = str;
        return this;
    }

    public final X5Downloader setMaxRetryTimes(int i3) {
        if (i3 > 0) {
            this.f369255j = i3;
            return this;
        }
        throw new IllegalArgumentException("can not set MaxRetryTimes <= 0, input is: " + i3);
    }

    public final X5Downloader setTargetMD5(String str) {
        a(QbSdk.PrivateCDNMode.STANDARD_IMPL);
        this.f369253h = str;
        return this;
    }

    public final X5Downloader setTargetSize(long j3) {
        a(QbSdk.PrivateCDNMode.STANDARD_IMPL);
        this.f369252g = j3;
        return this;
    }

    public final X5Downloader setTargetX5Version(int i3) {
        a(QbSdk.PrivateCDNMode.STANDARD_IMPL);
        this.f369254i = i3;
        return this;
    }

    public final void startDownload() {
        boolean z16;
        if (this.f369247b == QbSdk.PrivateCDNMode.SELF_IMPL && this.f369257l == null) {
            throw new IllegalStateException("is SELF_IMPL mode, but delegate is null. Please set setDownloadDelegate()");
        }
        String str = this.f369248c;
        if (str != null && !str.equals("")) {
            if (this.f369254i == 0) {
                b(-19, "No config version, if STANDARD_IMPL please call X5Downloader.setTargetX5Version");
                return;
            }
            n a16 = n.a();
            Context context = this.f369246a;
            if (g.f369355a == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            a16.b(context, z16);
            if (QbSdk.getTbsVersion(this.f369246a) != this.f369254i && !a(this.f369251f)) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("x5download-" + this.f369254i);
                this.f369271z = baseHandlerThread;
                baseHandlerThread.start();
                Handler handler = new Handler(this.f369271z.getLooper()) { // from class: com.tencent.smtt.sdk.X5Downloader.2
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        super.handleMessage(message);
                        if (X5Downloader.this.f369247b == QbSdk.PrivateCDNMode.SELF_IMPL) {
                            X5Downloader.this.e();
                        } else {
                            TbsLog.i("X5Downloader", "Delegate is null, try to start default download.");
                            X5Downloader.this.a();
                        }
                    }
                };
                this.f369270y = handler;
                handler.obtainMessage().sendToTarget();
                return;
            }
            h();
            TbsLog.i("X5Downloader", "local version match, no need to download: " + this.f369254i);
            return;
        }
        b(-18, "url is empty, [STANDARD_IMPL|OFFICIAL_IMPL] plz setDownloadUrl. [SELF_IMPL] Maybe flow control. Current is " + this.f369247b);
    }

    public final boolean stopDownload() {
        a(QbSdk.PrivateCDNMode.STANDARD_IMPL);
        TbsLog.i("X5Downloader", "Call StopDownload");
        if (!this.f369268w) {
            return false;
        }
        this.f369258m = true;
        return true;
    }

    public X5Downloader(Context context, QbSdk.PrivateCDNMode privateCDNMode) {
        this.f369255j = 4;
        this.f369256k = 10000;
        this.f369258m = false;
        this.f369261p = 0;
        this.f369262q = 0;
        this.f369263r = 30000;
        this.f369264s = false;
        this.f369266u = -1L;
        this.f369267v = false;
        this.f369268w = false;
        this.f369269x = new StringBuilder();
        this.A = 0;
        this.B = "";
        this.C = new TbsListener() { // from class: com.tencent.smtt.sdk.X5Downloader.1
            @Override // com.tencent.smtt.sdk.TbsListener
            public void onInstallFinish(int i3) {
                if (i3 == 200) {
                    X5Downloader.this.f();
                    TbsLog.i("X5Downloader", "X5Downloader installX5 finished.");
                    TbsLog.writeLogToDisk();
                    X5Downloader.this.onFinished();
                    return;
                }
                X5Downloader.this.b(i3, "install core failed.");
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadFinish(int i3) {
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadProgress(int i3) {
            }
        };
        throw new BusinessLimitException();
    }

    private long b() {
        File file = this.f369250e;
        if (file == null || !file.exists()) {
            return 0L;
        }
        return this.f369250e.length();
    }

    private boolean c() {
        FileOutputStream b16 = FileUtil.b(this.f369246a, true, "x5dl.lock");
        this.f369260o = b16;
        if (b16 != null) {
            FileLock a16 = FileUtil.a(this.f369246a, b16);
            this.f369259n = a16;
            if (a16 != null) {
                return true;
            }
            b(-2, "Other Process Downloading");
            return false;
        }
        b(-1, "lock fos is null");
        return false;
    }

    private void d() {
        FileUtil.a(this.f369259n, this.f369260o);
    }

    public final void installX5(File file, boolean z16) {
        a(QbSdk.PrivateCDNMode.STANDARD_IMPL);
        if (QbSdk.getTbsVersion(this.f369246a) == this.f369254i) {
            h();
            return;
        }
        if (!a(file)) {
            b(this.A, this.B);
            return;
        }
        QbSdk.setTbsListener(this.C);
        TbsLog.i("X5Downloader", "install localX5: " + file.getAbsolutePath() + "; deleteOriginFile: " + z16);
        n.a().b(z16);
        n.a().a(true);
        n.a().a(this.f369246a, file.getAbsolutePath(), this.f369254i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:50:0x03da A[Catch: all -> 0x0431, TRY_LEAVE, TryCatch #2 {, blocks: (B:5:0x0004, B:10:0x000e, B:48:0x03d3, B:50:0x03da, B:53:0x03e6, B:55:0x03ea, B:12:0x0015, B:216:0x001b, B:14:0x0044, B:214:0x004a, B:16:0x006f, B:19:0x0076, B:210:0x041d, B:212:0x0074, B:22:0x0090, B:24:0x0097, B:26:0x00b9, B:27:0x018a, B:29:0x018e, B:30:0x0198, B:41:0x01ce, B:43:0x01dd, B:47:0x01e6, B:98:0x0203, B:100:0x020b, B:101:0x021a, B:70:0x0251, B:79:0x027b, B:81:0x0283, B:85:0x028b, B:88:0x028f, B:91:0x02a7, B:93:0x0226, B:96:0x022e, B:102:0x02b7, B:107:0x02cb, B:142:0x0301, B:131:0x0307, B:170:0x0371, B:126:0x0377, B:130:0x03cb, B:125:0x03f7, B:138:0x0409, B:134:0x0412, B:135:0x041b, B:198:0x00fb, B:200:0x0103, B:201:0x0112, B:206:0x011c, B:207:0x0140), top: B:4:0x0004, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x03e6 A[Catch: all -> 0x0431, TRY_ENTER, TryCatch #2 {, blocks: (B:5:0x0004, B:10:0x000e, B:48:0x03d3, B:50:0x03da, B:53:0x03e6, B:55:0x03ea, B:12:0x0015, B:216:0x001b, B:14:0x0044, B:214:0x004a, B:16:0x006f, B:19:0x0076, B:210:0x041d, B:212:0x0074, B:22:0x0090, B:24:0x0097, B:26:0x00b9, B:27:0x018a, B:29:0x018e, B:30:0x0198, B:41:0x01ce, B:43:0x01dd, B:47:0x01e6, B:98:0x0203, B:100:0x020b, B:101:0x021a, B:70:0x0251, B:79:0x027b, B:81:0x0283, B:85:0x028b, B:88:0x028f, B:91:0x02a7, B:93:0x0226, B:96:0x022e, B:102:0x02b7, B:107:0x02cb, B:142:0x0301, B:131:0x0307, B:170:0x0371, B:126:0x0377, B:130:0x03cb, B:125:0x03f7, B:138:0x0409, B:134:0x0412, B:135:0x041b, B:198:0x00fb, B:200:0x0103, B:201:0x0112, B:206:0x011c, B:207:0x0140), top: B:4:0x0004, inners: #7 }] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a() {
        long j3;
        int responseCode;
        InputStream inputStream;
        InputStream inputStream2;
        byte[] bArr;
        File file;
        ?? r26 = 1;
        this.f369268w = true;
        if (c()) {
            while (true) {
                int i3 = 0;
                if (!this.f369258m) {
                    if (this.f369261p > this.f369255j) {
                        b(-3, "out of max retry, times:" + this.f369261p + "; record: " + this.f369269x.toString());
                        break;
                    }
                    if (this.f369262q > 8) {
                        b(-4, "302 redirect to much, times:" + this.f369262q + "; current location: " + this.f369249d);
                        break;
                    }
                    String str = this.f369249d;
                    if (str == null) {
                        str = this.f369248c;
                    }
                    TbsLog.i("X5Downloader", "url: " + str);
                    try {
                        a(str);
                        if (this.f369264s) {
                            j3 = 0;
                        } else {
                            j3 = b();
                            TbsLog.i("X5Downloader", "[TbsApkDownloader.startDownload] range=" + j3);
                            long j16 = this.f369266u;
                            if (j16 <= 0) {
                                TbsLog.i("X5Downloader", "STEP 1/2 begin downloading...current" + j3);
                                this.f369265t.setRequestProperty("Range", "bytes=" + j3 + "-");
                            } else if (j3 <= 0 || j3 != j16) {
                                if (j3 > 0 && j3 > j16) {
                                    b(-21, "file length" + j3 + " larger than server contentLength " + this.f369266u);
                                    break;
                                }
                                TbsLog.i("X5Downloader", "#1 STEP 1/2 begin downloading...current/total=" + j3 + "/" + this.f369266u);
                                this.f369265t.setRequestProperty("Range", "bytes=" + j3 + "-" + this.f369266u);
                            } else if (!a(this.f369250e)) {
                                d();
                                resetDownloadCache();
                                b(this.A, this.B);
                            } else {
                                this.f369267v = r26;
                            }
                        }
                        if (this.f369261p >= r26) {
                            this.f369265t.addRequestProperty("Referer", this.f369248c);
                        }
                        responseCode = this.f369265t.getResponseCode();
                        TbsLog.i("X5Downloader", "responseCode=" + responseCode);
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                        this.f369269x.append(th5.getMessage());
                        a(0L);
                    }
                    if (!this.f369258m) {
                        if (responseCode != 200 && responseCode != 206) {
                            if (responseCode >= 300 && responseCode <= 307) {
                                String headerField = this.f369265t.getHeaderField("Location");
                                if (!TextUtils.isEmpty(headerField)) {
                                    this.f369249d = headerField;
                                    this.f369262q += r26;
                                    r26 = 1;
                                } else {
                                    b(-10, "http redirect location null, responseCode: " + responseCode);
                                    break;
                                }
                            } else if (responseCode == 416) {
                                if (!a(this.f369250e)) {
                                    d();
                                    resetDownloadCache();
                                    b(this.A, this.B);
                                } else {
                                    this.f369267v = r26;
                                }
                            } else {
                                if ((responseCode == 403 || responseCode == 406) && this.f369266u == -1) {
                                    b(-16, "apk forbidden. responseCode: " + responseCode);
                                    break;
                                }
                                if (responseCode != 202) {
                                    if (responseCode == 503) {
                                        long parseLong = Long.parseLong(this.f369265t.getHeaderField("Retry-After"));
                                        StringBuilder sb5 = this.f369269x;
                                        sb5.append("httpCode:");
                                        sb5.append(responseCode);
                                        a(parseLong);
                                    } else {
                                        if (responseCode != 408 && responseCode != 504 && responseCode != 502) {
                                            if (b() > 0 || this.f369264s || responseCode == 410) {
                                                break;
                                            } else {
                                                this.f369264s = r26;
                                            }
                                        }
                                        StringBuilder sb6 = this.f369269x;
                                        sb6.append("httpCode:");
                                        sb6.append(responseCode);
                                        a(0L);
                                    }
                                }
                                r26 = 1;
                            }
                        }
                        long contentLength = this.f369265t.getContentLength() + j3;
                        this.f369266u = contentLength;
                        long j17 = this.f369252g;
                        if (j17 != 0 && contentLength != j17) {
                            b(-7, "connection ok, but file length not match.Expected: " + this.f369252g + "; real: " + this.f369266u);
                            break;
                        }
                        Closeable closeable = null;
                        try {
                            inputStream = this.f369265t.getInputStream();
                        } catch (IOException e16) {
                            e = e16;
                            inputStream = null;
                            inputStream2 = null;
                        } catch (Throwable th6) {
                            th = th6;
                            inputStream = null;
                            inputStream2 = null;
                        }
                        if (inputStream == null) {
                            b(-8, "response input stream null.");
                            a((Closeable) null);
                            a((Closeable) null);
                            break;
                        }
                        try {
                            bArr = new byte[8192];
                            file = this.f369250e;
                            String contentEncoding = this.f369265t.getContentEncoding();
                            if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                inputStream2 = new GZIPInputStream(inputStream);
                            } else {
                                inputStream2 = (contentEncoding == null || !contentEncoding.contains("deflate")) ? inputStream : new InflaterInputStream(inputStream, new Inflater(r26));
                            }
                        } catch (IOException e17) {
                            e = e17;
                            inputStream2 = null;
                        } catch (Throwable th7) {
                            th = th7;
                            inputStream2 = null;
                        }
                        try {
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(file, (boolean) r26);
                                try {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    while (true) {
                                        if (this.f369258m) {
                                            break;
                                        }
                                        int read = inputStream2.read(bArr, i3, 8192);
                                        if (read <= 0) {
                                            this.f369269x.append("stream is 0, code: -9");
                                            break;
                                        }
                                        fileOutputStream.write(bArr, i3, read);
                                        fileOutputStream.flush();
                                        if (!FileUtil.b(this.f369246a)) {
                                            b(-5, "no disk space left");
                                            break;
                                        }
                                        long currentTimeMillis2 = System.currentTimeMillis();
                                        j3 += read;
                                        if (currentTimeMillis2 - currentTimeMillis >= 500) {
                                            onProgress((int) ((j3 / this.f369266u) * 100.0d));
                                            currentTimeMillis = currentTimeMillis2;
                                        }
                                        i3 = 0;
                                    }
                                    a(fileOutputStream);
                                    a(inputStream2);
                                } catch (IOException e18) {
                                    e = e18;
                                    closeable = fileOutputStream;
                                    if (!(e instanceof SocketTimeoutException) && !(e instanceof SocketException)) {
                                        if (!FileUtil.b(this.f369246a)) {
                                            b(-5, "no disk space left");
                                            a(closeable);
                                            a(inputStream2);
                                            a(inputStream);
                                            d();
                                            if (!this.f369258m) {
                                            }
                                        } else {
                                            a(0L);
                                            a(closeable);
                                            a(inputStream2);
                                            a(inputStream);
                                            r26 = 1;
                                        }
                                    }
                                    this.f369263r = 100000;
                                    a(0L);
                                    a(closeable);
                                    a(inputStream2);
                                    a(inputStream);
                                    r26 = 1;
                                } catch (Throwable th8) {
                                    th = th8;
                                    closeable = fileOutputStream;
                                    a(closeable);
                                    a(inputStream2);
                                    a(inputStream);
                                    throw th;
                                }
                            } catch (IOException e19) {
                                e = e19;
                            }
                            a(inputStream);
                            r26 = 1;
                        } catch (Throwable th9) {
                            th = th9;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            a(inputStream);
            d();
            if (!this.f369258m) {
                this.f369258m = false;
                b(-6, "app call stop download");
            } else {
                if (this.f369267v) {
                    this.f369268w = false;
                    h();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i3, String str) {
        f();
        TbsLog.i("X5Downloader", "innerOnFailed, code: " + i3 + ", msg: " + str);
        TbsLog.writeLogToDisk();
        onFailed(i3, str);
    }

    @Override // com.tencent.smtt.sdk.ProgressListener
    public void onProgress(int i3) {
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private void a(String str) throws Exception {
        URL url = new URL(str);
        HttpURLConnection httpURLConnection = this.f369265t;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th5) {
                TbsLog.e("X5Downloader", "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + th5.toString());
            }
        }
        HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
        this.f369265t = httpURLConnection2;
        httpURLConnection2.setRequestProperty("User-Agent", TbsDownloader.b(this.f369246a));
        this.f369265t.setRequestProperty("Accept-Encoding", "identity");
        this.f369265t.setRequestMethod("GET");
        this.f369265t.setInstanceFollowRedirects(false);
        this.f369265t.setConnectTimeout(this.f369256k);
        this.f369265t.setReadTimeout(this.f369263r);
    }

    private void a(long j3) {
        int i3 = this.f369261p + 1;
        this.f369261p = i3;
        if (j3 <= 0) {
            j3 = (i3 == 1 || i3 == 2) ? i3 * 5000 : (i3 == 3 || i3 == 4) ? com.tencent.mobileqq.msf.core.s.G : 50000L;
        }
        try {
            LockMethodProxy.sleep(j3);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private boolean a(File file) {
        Exception exc;
        boolean z16;
        if (file != null && file.exists()) {
            boolean equals = file.getAbsolutePath().equals(this.f369250e.getAbsolutePath());
            if (this.f369247b != QbSdk.PrivateCDNMode.STANDARD_IMPL) {
                String a16 = com.tencent.smtt.utils.a.a(file);
                String str = this.f369253h;
                if (str != null && str.equals(a16)) {
                    long j3 = this.f369252g;
                    if (j3 == 0 || j3 != file.length()) {
                        a(-12, "size not match. current: " + file.length());
                        return false;
                    }
                } else {
                    a(-11, "md5 not match");
                    return false;
                }
            } else {
                String a17 = com.tencent.smtt.utils.a.a(file);
                String str2 = this.f369253h;
                if (str2 != null && !str2.equals(a17)) {
                    a(-11, "md5 not match");
                    return false;
                }
                long j16 = this.f369252g;
                if (j16 != 0 && j16 != file.length()) {
                    a(-12, "size not match. current: " + file.length());
                    return false;
                }
            }
            int i3 = this.f369254i;
            if (i3 != 0 && i3 == com.tencent.smtt.utils.a.a(this.f369246a, file)) {
                if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(AppUtil.getSignatureFromApk(this.f369246a, false, file))) {
                    a(-13, "core sig invalid.");
                    return false;
                }
                if (equals) {
                    try {
                        z16 = this.f369250e.renameTo(this.f369251f);
                        exc = null;
                    } catch (Exception e16) {
                        exc = e16;
                        z16 = false;
                    }
                    if (!z16) {
                        a(-17, "reason: " + exc);
                        return false;
                    }
                }
                g();
                return true;
            }
            a(-15, "core version not match");
            return false;
        }
        a(-14, "target file not exist.");
        return false;
    }

    private void a(int i3, String str) {
        this.A = i3;
        this.B = str;
    }

    private void a(QbSdk.PrivateCDNMode privateCDNMode) {
        QbSdk.PrivateCDNMode privateCDNMode2 = this.f369247b;
        if (privateCDNMode2 == privateCDNMode) {
            if (privateCDNMode2 == QbSdk.PrivateCDNMode.SELF_IMPL && !com.tencent.smtt.utils.b.a(this.f369246a)) {
                throw new UnsupportedOperationException("SELF_IMPL no longer supported.");
            }
        } else {
            throw new UnsupportedOperationException("you are expected use " + privateCDNMode.name() + ".Current mode is " + privateCDNMode.name() + ". Plz check QbSdk.usePrivateCDN(PrivateCDNMode)");
        }
    }
}

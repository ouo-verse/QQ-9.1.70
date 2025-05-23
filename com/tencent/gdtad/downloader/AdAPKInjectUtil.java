package com.tencent.gdtad.downloader;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.util.AdSafeUtil;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileLock;

/* loaded from: classes6.dex */
final class AdAPKInjectUtil {

    /* renamed from: a, reason: collision with root package name */
    private static volatile AdAPKInjectUtil f109162a;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface InjectMoment {
        public static final int INJECT_AFTER_DOWNLOADED = 324;
        public static final int INJECT_BEFORE_INSTALL = 325;
    }

    AdAPKInjectUtil() {
        AdSafeUtil.safeRun(new Runnable() { // from class: com.tencent.gdtad.downloader.b
            @Override // java.lang.Runnable
            public final void run() {
                AdAPKInjectUtil.h();
            }
        }, "AdAPKInjectUtil", "[AdAPKInjectUtil] init");
    }

    public static AdAPKInjectUtil d() {
        if (f109162a == null) {
            synchronized (AdAPKInjectUtil.class) {
                if (f109162a == null) {
                    f109162a = new AdAPKInjectUtil();
                }
            }
        }
        return f109162a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void g(String str, DownloadInfo downloadInfo) {
        Throwable th5;
        HttpURLConnection httpURLConnection;
        long j3;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setRequestMethod("GET");
                j3 = Long.parseLong(httpURLConnection.getHeaderField("X-Cos-Meta-Edgepack-Offset"));
                httpURLConnection.disconnect();
            } catch (Throwable th6) {
                th5 = th6;
                try {
                    QLog.e("AdAPKInjectUtil", 1, "[fetchOffsetAndCache] openConnection error :", th5);
                    j3 = Long.MIN_VALUE;
                    QLog.i("AdAPKInjectUtil", 1, "[fetchOffsetAndCache] offset:" + j3);
                    if (j3 == Long.MIN_VALUE) {
                    }
                } finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        } catch (Throwable th7) {
            th5 = th7;
            httpURLConnection = null;
        }
        QLog.i("AdAPKInjectUtil", 1, "[fetchOffsetAndCache] offset:" + j3);
        if (j3 == Long.MIN_VALUE) {
            downloadInfo.f341204t0 = j3;
            j.f109185f.w(downloadInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h() {
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(BaseApplication.getContext(), new InitGdtContextParams());
    }

    private static void i(int i3, long j3, DownloadInfo downloadInfo, int i16, int i17) {
        if (downloadInfo == null) {
            QLog.e("AdAPKInjectUtil", 1, "[linkReport] info error");
            return;
        }
        link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
        reportBiz.aid = String.valueOf(downloadInfo.f341194k0);
        reportBiz.pid = downloadInfo.f341195l0;
        reportBiz.traceid = downloadInfo.f341193j0;
        reportBiz.cost_time = (int) j3;
        reportBiz.enum_code = i16;
        reportBiz.act_code = i17;
        AdReporterForLinkEvent.getInstance().reportAsync(BaseApplication.getContext(), i3, null, reportBiz, null);
    }

    private String j(File file, long j3, int i3) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        if (file == null || !file.exists() || j3 < 0 || i3 < 0) {
            return null;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().tryLock();
            } catch (Throwable th5) {
                th = th5;
                fileLock = null;
            }
        } catch (Throwable th6) {
            th = th6;
            fileLock = null;
            randomAccessFile = null;
        }
        try {
            randomAccessFile.seek(j3 - 10264);
            byte[] bArr = new byte[i3];
            randomAccessFile.read(bArr, 0, i3);
            String str = new String(bArr);
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (Throwable th7) {
                    QLog.e("AdAPKInjectUtil", 1, "[realInject]lock release :" + th7);
                }
            }
            try {
                randomAccessFile.close();
            } catch (Throwable th8) {
                QLog.e("AdAPKInjectUtil", 1, "[realInject]close failed :" + th8);
            }
            return str;
        } catch (Throwable th9) {
            th = th9;
            try {
                QLog.e("AdAPKInjectUtil", 1, "[readIdFromFile] failed : " + th);
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (Throwable th10) {
                        QLog.e("AdAPKInjectUtil", 1, "[realInject]lock release :" + th10);
                    }
                }
                if (randomAccessFile == null) {
                    return null;
                }
                try {
                    randomAccessFile.close();
                    return null;
                } catch (Throwable th11) {
                    QLog.e("AdAPKInjectUtil", 1, "[realInject]close failed :" + th11);
                    return null;
                }
            } finally {
            }
        }
    }

    private int k(File file, int i3, String str, long j3) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        QLog.i("AdAPKInjectUtil", 1, "[realInject] start trace id:" + str + "start EdgePackOffset:" + j3);
        if (!TextUtils.isEmpty(str) && str.getBytes() != null) {
            byte[] bytes = str.getBytes();
            if (bytes.length > 10240) {
                QLog.e("AdAPKInjectUtil", 1, "[realInject] failed : trace id too long");
                return 322;
            }
            long j16 = j3 - 10264;
            if (j16 < 0) {
                QLog.e("AdAPKInjectUtil", 1, "[realInject] failed : invalid offset");
                return 304;
            }
            if (j16 > file.length()) {
                QLog.e("AdAPKInjectUtil", 1, "[realInject] failed : offset too long");
                return 323;
            }
            RandomAccessFile randomAccessFile2 = null;
            FileLock fileLock2 = null;
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (Throwable th5) {
                th = th5;
                fileLock = null;
            }
            try {
                fileLock2 = randomAccessFile.getChannel().tryLock();
                byte[] bArr = new byte[10240];
                System.arraycopy(bytes, 0, bArr, 0, bytes.length);
                randomAccessFile.seek(j16);
                QLog.i("AdAPKInjectUtil", 1, "[realInject] begin write file");
                randomAccessFile.write(bArr, 0, 10240);
                if (fileLock2 != null) {
                    try {
                        fileLock2.release();
                    } catch (Throwable th6) {
                        QLog.e("AdAPKInjectUtil", 1, "[realInject]lock release :" + th6);
                    }
                }
                try {
                    randomAccessFile.close();
                    return i3;
                } catch (Throwable th7) {
                    QLog.e("AdAPKInjectUtil", 1, "[realInject]close failed :" + th7);
                    return i3;
                }
            } catch (Throwable th8) {
                th = th8;
                fileLock = fileLock2;
                randomAccessFile2 = randomAccessFile;
                try {
                    QLog.e("AdAPKInjectUtil", 1, "[realInject] failed : " + th);
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Throwable th9) {
                            QLog.e("AdAPKInjectUtil", 1, "[realInject]lock release :" + th9);
                        }
                    }
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (Throwable th10) {
                            QLog.e("AdAPKInjectUtil", 1, "[realInject]close failed :" + th10);
                        }
                    }
                    return 307;
                } finally {
                }
            }
        } else {
            QLog.e("AdAPKInjectUtil", 1, "[realInject] failed : no trace id");
            return 206;
        }
    }

    public void c(final DownloadInfo downloadInfo) {
        final String str;
        if (!f()) {
            QLog.i("AdAPKInjectUtil", 1, "[fetchOffsetAndCache] not enable");
            return;
        }
        if (downloadInfo != null) {
            str = downloadInfo.f341186f;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("AdAPKInjectUtil", 1, "[fetchOffsetAndCache] url error ");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.downloader.a
                @Override // java.lang.Runnable
                public final void run() {
                    AdAPKInjectUtil.g(str, downloadInfo);
                }
            }, 128, null, false);
        }
    }

    public boolean e(DownloadInfo downloadInfo, File file, int i3) {
        File file2;
        int i16;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            QLog.e("AdAPKInjectUtil", 1, "[injectTraceId] not allow process in main thread");
            return false;
        }
        if (file == null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.f341186f)) {
            file2 = new File(downloadInfo.f341186f);
        } else {
            file2 = file;
        }
        if (downloadInfo != null && file2 != null && file2.exists()) {
            if (downloadInfo.f341204t0 == 0) {
                QLog.e("AdAPKInjectUtil", 1, "AdAPKInjectUtil", "[injectTraceId] not init injectTraceIdOffset");
                return false;
            }
            if (!f()) {
                QLog.e("AdAPKInjectUtil", 1, "AdAPKInjectUtil", "[injectTraceId] not allow");
                return false;
            }
            String str = downloadInfo.f341193j0;
            long j3 = downloadInfo.f341204t0;
            if (str != null && str.getBytes() != null) {
                i16 = str.getBytes().length;
            } else {
                i16 = Integer.MIN_VALUE;
            }
            String j16 = j(file2, j3, i16);
            QLog.i("AdAPKInjectUtil", 1, "[injectTraceIdSyn] lastTraceId :" + j16);
            if (!TextUtils.isEmpty(j16) && TextUtils.equals(j16, str)) {
                QLog.i("AdAPKInjectUtil", 1, "[injectTraceIdSyn] failed : same traceId id exists");
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            i(sdk_event_log.SdkEventDimension.EVENT_INJECT_TRACE_ID_START, 0L, downloadInfo, i3, 0);
            int k3 = k(file2, 0, str, j3);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            QLog.i("AdAPKInjectUtil", 1, "[injectTraceIdSyn] cost time : " + currentTimeMillis2 + ", error code :" + k3);
            if (k3 == 0) {
                i(sdk_event_log.SdkEventDimension.EVENT_INJECT_TRACE_ID_SUCCESS, currentTimeMillis2, downloadInfo, i3, k3);
                return true;
            }
            i(sdk_event_log.SdkEventDimension.EVENT_INJECT_TRACE_ID_FAILED, currentTimeMillis2, downloadInfo, i3, k3);
            return false;
        }
        QLog.e("AdAPKInjectUtil", 1, "AdAPKInjectUtil", "[injectTraceId] info is null or filePath error");
        return false;
    }

    public boolean f() {
        return wm0.b.m().o();
    }
}

package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.utils.httputils.SniSSLSocketFactory;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import mqq.os.MqqHandler;
import org.apache.http.ConnectionClosedException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class FaceDownloader {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_CHECK_INTERVAL = 30000;
    private static int DPC_WAP_DIRECT_CONNECT = 0;
    public static final int MSG_DOWNLOAD_FINISH = 100;
    private static final String TAG = "Q.qqhead.FaceDownloader";
    private static boolean forceDirect;
    private static String lastApn;
    protected AtomicInteger currThreadCount;
    private int emptyCheckMax;
    protected MqqHandler handler;
    protected AtomicInteger idleThreadCount;
    private FaceDownloadRunnable[] mDownRunnables;
    private Thread[] mDownThreads;
    LinkedList<FaceDownloadListener> mDownloadListener;
    protected HashSet<String> mDownloadingUrlSet;
    protected ArrayList<FaceInfo> mRequestQueue;
    private FaceDownloadThreadInfo mThreadInfo;
    public int maxThreadCount;
    private int priorDownloadQQheadThreshold;
    public ArrayList<PendingTask> sPendingResultList;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface FaceDownloadListener {
        void onFaceDownloadFinished(boolean z16, FaceInfo faceInfo, Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class FaceDownloadRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        private int index;
        private boolean isRunning;

        public FaceDownloadRunnable(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FaceDownloader.this, i3);
            } else {
                this.isRunning = true;
                this.index = i3;
            }
        }

        public void close() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.isRunning = false;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            FaceInfo remove;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            Thread.currentThread().setName("FaceDownloadThread" + this.index);
            if (FaceDownloader.this.mThreadInfo.priority != Integer.MIN_VALUE) {
                Process.setThreadPriority(FaceDownloader.this.mThreadInfo.priority);
            }
            int i3 = 0;
            while (true) {
                FaceInfo faceInfo = null;
                if ((i3 < FaceDownloader.this.emptyCheckMax || FaceDownloader.this.mRequestQueue.size() > 0) && this.isRunning) {
                    synchronized (FaceDownloader.this.mRequestQueue) {
                        int size = FaceDownloader.this.mRequestQueue.size();
                        if (size == 0) {
                            FaceDownloader.this.idleThreadCount.incrementAndGet();
                            try {
                                FaceDownloader.this.mRequestQueue.wait(30000L);
                            } catch (InterruptedException unused) {
                            }
                            FaceDownloader.this.idleThreadCount.decrementAndGet();
                            i3++;
                        } else {
                            if (size > FaceDownloader.this.priorDownloadQQheadThreshold) {
                                remove = FaceDownloader.this.mRequestQueue.remove(size - 1);
                            } else {
                                remove = FaceDownloader.this.mRequestQueue.remove(0);
                            }
                            faceInfo = remove;
                            i3 = 0;
                        }
                    }
                    if (faceInfo != null) {
                        FaceDownloader.this.doDownloadFace(faceInfo);
                        synchronized (FaceDownloader.this.mDownloadingUrlSet) {
                            FaceDownloader.this.mDownloadingUrlSet.remove(faceInfo.getFaceUrlUniq());
                        }
                        Thread.yield();
                    }
                }
            }
            synchronized (FaceDownloader.this.mDownThreads) {
                if (FaceDownloader.this.mDownThreads != null && this.index < FaceDownloader.this.mDownThreads.length) {
                    FaceDownloader.this.mDownThreads[this.index] = null;
                    FaceDownloader.this.mDownRunnables[this.index] = null;
                }
            }
            FaceDownloader.this.currThreadCount.decrementAndGet();
            if (QLog.isColorLevel()) {
                QLog.d(FaceDownloader.TAG, 2, "FaceDownloadThread thread exit. isRunning=" + this.isRunning + ", id=" + this.index);
            }
        }

        public void setIndex(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                this.index = i3;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class FaceDownloadThreadInfo {
        static IPatchRedirector $redirector_ = null;
        public static final int DEFATUL_VAL = Integer.MIN_VALUE;
        int maxThreadCount;
        int priority;

        public FaceDownloadThreadInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FaceDownloader.this);
            } else {
                this.maxThreadCount = Integer.MIN_VALUE;
                this.priority = Integer.MIN_VALUE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class PendingTask {
        static IPatchRedirector $redirector_;
        Bitmap bitmap;
        FaceInfo faceInfo;

        PendingTask() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FaceDownloader.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18673);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        DPC_WAP_DIRECT_CONNECT = 1;
        lastApn = null;
        forceDirect = false;
    }

    public FaceDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.maxThreadCount = 6;
        this.idleThreadCount = new AtomicInteger(0);
        this.currThreadCount = new AtomicInteger(0);
        this.mDownThreads = null;
        this.mDownRunnables = null;
        this.emptyCheckMax = 2;
        this.priorDownloadQQheadThreshold = 10;
        this.mDownloadListener = new LinkedList<>();
        this.sPendingResultList = new ArrayList<>(100);
        initFaceDownloadThreadInfo();
        initDPCFlag();
        int i3 = this.mThreadInfo.maxThreadCount;
        if (i3 != Integer.MIN_VALUE) {
            this.maxThreadCount = i3;
        }
        String str = BaseApplication.processName;
        if (!TextUtils.isEmpty(str) && str.equals(MobileQQ.PACKAGE_NAME)) {
            this.maxThreadCount = 4;
        }
        this.mRequestQueue = new ArrayList<>();
        this.mDownloadingUrlSet = new HashSet<>();
        this.currThreadCount.set(this.maxThreadCount);
        int i16 = this.maxThreadCount;
        this.mDownThreads = new Thread[i16];
        this.mDownRunnables = new FaceDownloadRunnable[i16];
        for (int i17 = 0; i17 < this.mDownThreads.length; i17++) {
            this.mDownRunnables[i17] = new FaceDownloadRunnable(i17);
            this.mDownThreads[i17] = ThreadManagerV2.newFreeThread(this.mDownRunnables[i17], "FaceDownloadThread", 5);
            if (com.tencent.qqperf.opt.threadpriority.a.c().e()) {
                this.mDownThreads[i17].setPriority(1);
            }
            try {
                this.mDownThreads[i17].start();
            } catch (OutOfMemoryError e16) {
                QLog.e(TAG, 1, "FaceDownloader() error, ", e16);
            }
        }
        this.handler = new MqqHandler(Looper.getMainLooper()) { // from class: com.tencent.mobileqq.app.face.FaceDownloader.1
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FaceDownloader.this, (Object) r5);
                }
            }

            @Override // mqq.os.MqqHandler
            public void handleMessage(Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
                    return;
                }
                if (message != null && message.what == 100) {
                    int i18 = 0;
                    while (i18 < FaceDownloader.this.sPendingResultList.size()) {
                        PendingTask pendingTask = FaceDownloader.this.sPendingResultList.get(i18);
                        if (pendingTask != null) {
                            if (QLog.isColorLevel()) {
                                QLog.i(FaceDownloader.TAG, 2, "handle download finish task.faceInfo=" + pendingTask.faceInfo + ",bitmap=" + pendingTask.bitmap);
                            }
                            if (pendingTask.faceInfo != null && pendingTask.bitmap != null && FaceDownloader.this.mDownloadListener.size() > 0) {
                                for (int i19 = 0; i19 < FaceDownloader.this.mDownloadListener.size(); i19++) {
                                    FaceDownloader.this.mDownloadListener.get(i19).onFaceDownloadFinished(true, pendingTask.faceInfo, pendingTask.bitmap);
                                }
                            }
                            FaceDownloader.this.sPendingResultList.remove(i18);
                            i18--;
                        }
                        i18++;
                    }
                }
            }
        };
    }

    private void cacheFile(FaceInfo faceInfo, boolean z16, long j3, int i3) {
        byte b16;
        if (z16) {
            PendingTask pendingTask = new PendingTask();
            pendingTask.faceInfo = faceInfo;
            if (i3 != 0) {
                faceInfo.markTime(FaceInfo.TIME_END_DOWNLOAD);
                pendingTask.bitmap = null;
                this.sPendingResultList.add(pendingTask);
                this.handler.obtainMessage(100, pendingTask).sendToTarget();
                return;
            }
            if (j3 >= 20480) {
                faceInfo.markTime(FaceInfo.TIME_BEGIN_DECODE);
                j.a aVar = new j.a();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = FaceConstant.HeadConfig.FACE_BITMAP_CONFIG;
                IQQAvatarManagerService iQQAvatarManagerService = (IQQAvatarManagerService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQAvatarManagerService.class, ProcessConstant.NEARBY);
                int i16 = 0;
                int i17 = 0;
                do {
                    com.tencent.mobileqq.util.j.e(iQQAvatarManagerService.getFacePath(faceInfo), options, aVar);
                    if (aVar.f306779b == 1) {
                        ImageCacheHelper.f98636a.e();
                    }
                    i17++;
                    if (i17 >= 2) {
                        break;
                    }
                } while (aVar.f306779b == 1);
                if (aVar.f306778a != null) {
                    QQHeadInfo qQHeadInfo = faceInfo.mHeadInfo;
                    if (qQHeadInfo != null) {
                        b16 = qQHeadInfo.cHeadType;
                    } else {
                        b16 = 0;
                    }
                    if (com.tencent.mobileqq.avatar.utils.c.q() && faceInfo.isUserHeadType()) {
                        i16 = faceInfo.sizeType;
                    }
                    aVar.f306778a = com.tencent.mobileqq.avatar.utils.c.b((byte) faceInfo.shape, aVar.f306778a, faceInfo.uin, b16, i16);
                    iQQAvatarManagerService.putFaceToCache(faceInfo.getFaceBmpCacheKey(), aVar.f306778a, com.tencent.mobileqq.avatar.utils.b.d(faceInfo.headType));
                }
                faceInfo.markTime(FaceInfo.TIME_END_DECODE);
                pendingTask.bitmap = aVar.f306778a;
                this.sPendingResultList.add(pendingTask);
                this.handler.obtainMessage(100, pendingTask).sendToTarget();
            }
        }
    }

    private void closeConn(OutputStream outputStream, HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private int dealDownloadExp(FaceInfo faceInfo, URL url, File file, IOException iOException) {
        int i3;
        long c16;
        String str;
        QLog.i(TAG, 1, "Download fail 1. url=" + url + ",faceInfo=" + faceInfo, iOException);
        if (iOException instanceof UnknownHostException) {
            return 10;
        }
        if (!(iOException instanceof ConnectTimeoutException) && !(iOException instanceof SocketTimeoutException)) {
            if (iOException instanceof SocketException) {
                return 11;
            }
            if (iOException instanceof ConnectionClosedException) {
                return 8;
            }
            if (iOException instanceof ConnectException) {
                return 17;
            }
            if (iOException instanceof HttpRetryException) {
                return 18;
            }
            if (iOException instanceof EOFException) {
                return 19;
            }
            String message = iOException.getMessage();
            if (!message.contains("EACCES") && !message.contains("ENOSPC") && !message.contains("Read-only")) {
                i3 = 4;
            } else {
                i3 = 33;
            }
            boolean e16 = cu.e();
            if (e16) {
                c16 = cu.b();
            } else {
                c16 = cu.c();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Download fail 1. tmpFilePath=");
            String str2 = "notExit";
            if (!file.exists()) {
                str = "notExit";
            } else {
                str = file.getAbsolutePath();
            }
            sb5.append(str);
            sb5.append("tmpParentFilePath=");
            if (file.getParentFile() != null && file.getParentFile().exists()) {
                str2 = file.getParentFile().getAbsolutePath();
            }
            sb5.append(str2);
            sb5.append(", result=");
            sb5.append(i3);
            sb5.append(",isExistSDCard=");
            sb5.append(e16);
            sb5.append(",availableSize=");
            sb5.append(c16);
            QLog.i(TAG, 1, sb5.toString());
            return i3;
        }
        return 2;
    }

    private void deleteTmpFile(int i3, File file) {
        if (i3 != 0 && file != null) {
            try {
                getParentFile(file);
                if (file.exists()) {
                    QLog.i(TAG, 1, "delete file in finally: " + file.delete());
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private void downloadFailedWaitAndTryAgain(String str, FaceInfo faceInfo, int i3, Object obj, int i16, boolean z16, String str2, int i17, int i18, String str3) {
        if (i3 != 0) {
            QLog.i(TAG, 1, "Download. result=" + i3 + ", urlString=" + str + ", tryCount=" + i16 + ",faceInfo=" + faceInfo + ",useProxy=" + z16 + ",defaultHost=" + str2 + ",defaultPort=" + i17 + ",forceDirect=" + forceDirect + ",type=" + i18 + ",apnType=" + str3 + ",dpcwap=" + DPC_WAP_DIRECT_CONNECT);
        }
        if (i3 != 0 && i16 < 2) {
            synchronized (obj) {
                try {
                    obj.wait(500L);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    private static void enableSNI(HttpsURLConnection httpsURLConnection, URL url, boolean z16) {
        HostnameVerifier hostnameVerifier = new HostnameVerifier(z16, url) { // from class: com.tencent.mobileqq.app.face.FaceDownloader.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean val$isIp;
            final /* synthetic */ URL val$urlObj;

            {
                this.val$isIp = z16;
                this.val$urlObj = url;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), url);
                }
            }

            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) sSLSession)).booleanValue();
                }
                if (!this.val$isIp && !HttpsURLConnection.getDefaultHostnameVerifier().verify(this.val$urlObj.getHost(), sSLSession)) {
                    return false;
                }
                return true;
            }
        };
        httpsURLConnection.setRequestProperty("host", url.getHost());
        httpsURLConnection.setSSLSocketFactory(new SniSSLSocketFactory(url.getHost(), hostnameVerifier));
        httpsURLConnection.setHostnameVerifier(hostnameVerifier);
    }

    public static String get640QQHeandDownLoadUrl(String str, byte b16) {
        int i3;
        String reqDns = InnerDns.getInstance().reqDns("q.qlogo.cn", 1003);
        if (QLog.isColorLevel()) {
            QLog.i(InnerDns.TAG, 2, "get640QQHeandDownLoadUrl.choosedIp=" + reqDns);
        }
        StringBuilder sb5 = new StringBuilder("https://");
        if (!TextUtils.isEmpty(reqDns)) {
            sb5.append(reqDns);
        } else {
            sb5.append("q.qlogo.cn");
        }
        int indexOf = str.indexOf("/", 8);
        if (indexOf > 8) {
            sb5.append(str.substring(indexOf));
            str = sb5.toString();
        }
        if ((b16 & RegisterType.UNINIT_REF) != 0) {
            i3 = 640;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            return str + i3;
        }
        return "";
    }

    private Bitmap getBitmapByShape(FaceInfo faceInfo, Bitmap bitmap) {
        byte b16;
        if (bitmap != null) {
            QQHeadInfo qQHeadInfo = faceInfo.mHeadInfo;
            int i3 = 0;
            if (qQHeadInfo != null) {
                b16 = qQHeadInfo.cHeadType;
            } else {
                b16 = 0;
            }
            if (com.tencent.mobileqq.avatar.utils.c.q() && faceInfo.isUserHeadType()) {
                i3 = faceInfo.sizeType;
            }
            Bitmap b17 = com.tencent.mobileqq.avatar.utils.c.b((byte) faceInfo.shape, bitmap, faceInfo.uin, b16, i3);
            ((IQQAvatarManagerService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQAvatarManagerService.class, ProcessConstant.NEARBY)).putFaceToCache(faceInfo.getFaceBmpCacheKey(), b17, com.tencent.mobileqq.avatar.utils.b.d(faceInfo.headType));
            faceInfo.markTime(FaceInfo.TIME_END_DECODE);
            return b17;
        }
        return bitmap;
    }

    private String getDomain(String str, FaceInfo faceInfo, int i3, QQHeadInfo qQHeadInfo) {
        int i16;
        byte b16 = qQHeadInfo.dstUsrType;
        String str2 = "p.qlogo.cn";
        if (b16 != 32 ? !(b16 != 16 && (b16 == 4 || b16 == 8)) : !((i16 = qQHeadInfo.originUsrType) != 1 && i16 == 32)) {
            str2 = "q.qlogo.cn";
        }
        StringBuilder sb5 = new StringBuilder("https://");
        sb5.append(str2);
        int indexOf = str.indexOf("/", 8);
        if (indexOf > 8) {
            sb5.append(str.substring(indexOf));
            str = sb5.toString();
        }
        QLog.d(TAG, 1, "downloadData retry tryCount =" + i3 + ",urlString=" + str + ",faceInfo=" + faceInfo);
        return str;
    }

    private void getParentFile(File file) {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
    }

    private void initDPCFlag() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.app.face.FaceDownloader.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FaceDownloader.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String featureValueWithoutAccountManager = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.aio_config.name(), IDPCApiConstant.AIO_CMWAP_QQHEAD);
                if (QLog.isColorLevel()) {
                    QLog.i(FaceDownloader.TAG, 2, "initDPCFlag headWapConn:" + featureValueWithoutAccountManager);
                }
                String[] split = featureValueWithoutAccountManager.split("\\|");
                if (split.length > 7) {
                    try {
                        int unused = FaceDownloader.DPC_WAP_DIRECT_CONNECT = Integer.parseInt(split[7]);
                        if (QLog.isColorLevel()) {
                            QLog.i(FaceDownloader.TAG, 2, "initDPCFlag DPC_WAP_DIRECT_CONNECT=" + FaceDownloader.DPC_WAP_DIRECT_CONNECT);
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(FaceDownloader.TAG, 2, "initDPCFlag error :", e16);
                        }
                    }
                }
            }
        }, 5, null, true);
    }

    private void initFaceDownloadThreadInfo() {
        if (TextUtils.isEmpty(BaseApplication.processName)) {
            return;
        }
        if (BaseApplication.processName.equals(MobileQQ.PACKAGE_NAME + ":tool")) {
            this.mThreadInfo = getNearbyFaceDownloadThreadInfo();
        } else {
            this.mThreadInfo = new FaceDownloadThreadInfo();
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "initFaceDownloadThreadInfo, maxThreadCount=" + this.mThreadInfo.maxThreadCount + ",priority=" + this.mThreadInfo.priority);
        }
    }

    private boolean isVerifyError(FaceInfo faceInfo, int i3, DownloadInfo downloadInfo, HttpURLConnection httpURLConnection, String str) {
        String str2;
        boolean z16 = false;
        if (!TextUtils.isEmpty(str)) {
            QLog.i(TAG, 1, "Download has X-ErrNo\uff0cX-ErrNo=" + str);
            printHeaderInfo(httpURLConnection, faceInfo);
        } else {
            if (downloadInfo.respVerifyString == null) {
                i3 = downloadInfo.httpRespCode;
                if (i3 == 200) {
                    i3 = 30;
                }
                z16 = true;
            }
            if (!TextUtils.isEmpty(faceInfo.mHeadInfo.headVerify) && (str2 = downloadInfo.respVerifyString) != null && !str2.equals(faceInfo.mHeadInfo.headVerify)) {
                i3 = 31;
                z16 = true;
            }
            if (z16) {
                printHeaderInfo(httpURLConnection, faceInfo);
            }
        }
        if (z16) {
            QLog.e(TAG, 1, "isVerifyError result: " + i3 + ", faceInfo: " + faceInfo);
        }
        return z16;
    }

    private boolean needVerify(int i3) {
        if (i3 != 116) {
            return true;
        }
        return false;
    }

    private void printHeaderInfo(HttpURLConnection httpURLConnection, FaceInfo faceInfo) {
        if (httpURLConnection != null && faceInfo != null && faceInfo.mHeadInfo != null) {
            try {
                QLog.i(TAG, 2, "headInfo=" + httpURLConnection.getResponseCode() + "," + httpURLConnection.getContentType() + "," + httpURLConnection.getContentLength() + "," + httpURLConnection.getHeaderField("Server") + "," + httpURLConnection.getHeaderField("X-ErrNo") + "," + httpURLConnection.getHeaderField(HttpMsg.XRetryFlag) + "," + httpURLConnection.getHeaderField("X-BCheck") + "," + httpURLConnection.getHeaderField("X-BCheck") + "," + faceInfo);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:25|26|28|29|(4:31|32|33|(2:35|(1:1)(1:39)))(1:239)|43|44|45|46|(21:50|51|52|53|54|55|56|(2:207|208)|58|(1:62)|63|64|65|66|(5:193|194|195|(2:196|(1:198)(1:199))|200)(8:70|71|72|(2:73|(1:75)(1:76))|77|(7:79|(3:166|167|(8:173|174|175|176|82|83|(7:85|86|87|88|89|90|91)(1:159)|92))|81|82|83|(0)(0)|92)(1:188)|93|94)|95|96|97|98|(2:101|102)|100)(1:48)|49|(2:37|40)(1:42)) */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0474, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0475, code lost:
    
        r15 = r36;
        r14 = r26;
        r26 = r5;
        r9 = r3;
        r8 = r4;
        r5 = 0;
        r7 = r19;
        r10 = r44;
        r11 = r24;
        r27 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x045e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x045f, code lost:
    
        r15 = r36;
        r14 = r26;
        r26 = r5;
        r9 = r3;
        r8 = r4;
        r5 = 0;
        r7 = r19;
        r10 = r44;
     */
    /* JADX WARN: Removed duplicated region for block: B:130:0x035e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x038c A[Catch: all -> 0x0390, IOException -> 0x03a5, TRY_ENTER, TryCatch #31 {IOException -> 0x03a5, all -> 0x0390, blocks: (B:102:0x02f2, B:140:0x038c, B:141:0x038f), top: B:101:0x02f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x05f2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0603 A[ADDED_TO_REGION, EDGE_INSN: B:42:0x0603->B:41:0x0603 BREAK  A[LOOP:0: B:2:0x001e->B:39:0x05f7], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0240 A[Catch: all -> 0x0295, FileNotFoundException -> 0x0299, TRY_LEAVE, TryCatch #42 {FileNotFoundException -> 0x0299, all -> 0x0295, blocks: (B:83:0x0236, B:85:0x0240), top: B:82:0x0236 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int realDownloadData(String str, File file, FaceInfo faceInfo, boolean z16, NetworkInfo networkInfo, URL url, int i3, Object obj, int i16, OutputStream outputStream, DownloadInfo downloadInfo, File file2, int i17, HttpURLConnection httpURLConnection) {
        String str2;
        String str3;
        int i18;
        int i19;
        OutputStream outputStream2;
        String str4;
        URL url2;
        int i26;
        String str5;
        String str6;
        String str7;
        String str8;
        File file3;
        HttpURLConnection httpURLConnection2;
        boolean z17;
        OutputStream outputStream3;
        int i27;
        DownloadInfo downloadInfo2;
        OutputStream outputStream4;
        String str9;
        Object[] httpConnAndUseProxy;
        int i28;
        boolean booleanValue;
        HttpURLConnection httpURLConnection3;
        HttpURLConnection httpURLConnection4;
        HttpURLConnection httpURLConnection5;
        boolean z18;
        String str10;
        URL url3;
        long j3;
        String str11;
        String str12;
        OutputStream outputStream5;
        HttpURLConnection httpURLConnection6;
        int i29;
        OutputStream outputStream6;
        String str13;
        URL url4;
        URL url5 = url;
        DownloadInfo downloadInfo3 = downloadInfo;
        File file4 = file2;
        String str14 = ",faceInfo=";
        String str15 = TAG;
        OutputStream outputStream7 = outputStream;
        int i36 = i17;
        HttpURLConnection httpURLConnection7 = httpURLConnection;
        long j16 = 0;
        String str16 = str;
        int i37 = i3;
        while (true) {
            if (i36 != -1) {
                QQHeadInfo qQHeadInfo = faceInfo.mHeadInfo;
                if (qQHeadInfo == null) {
                    downloadInfo2 = downloadInfo3;
                    break;
                }
                str16 = getDomain(str16, faceInfo, i36, qQHeadInfo);
            }
            String str17 = str16;
            QLog.d("PERF_LOG", 2, "NF.FaceDownloader downloadUrl=" + str17 + "\t retryCount=" + i36);
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            InputStream inputStream = null;
            String netGetExInfo = networkInfo != null ? NetworkMonitor.netGetExInfo(networkInfo) : null;
            int type = networkInfo != null ? NetworkMonitor.getType(networkInfo) : -1;
            String apnType = PkgTools.getApnType(netGetExInfo);
            try {
                setForceDirect(defaultHost, type, apnType);
                str3 = apnType;
                i18 = type;
                i19 = i36;
                try {
                    httpConnAndUseProxy = setHttpConnAndUseProxy(defaultHost, defaultPort, str3, false, i36, str17);
                    i28 = 0;
                    booleanValue = ((Boolean) httpConnAndUseProxy[0]).booleanValue();
                } catch (IOException e16) {
                    e = e16;
                    str2 = str17;
                    url2 = url;
                    outputStream4 = outputStream7;
                    str9 = str15;
                    i26 = defaultPort;
                    str5 = defaultHost;
                    file3 = file2;
                    str8 = str14;
                    httpURLConnection2 = httpURLConnection7;
                    z17 = false;
                } catch (Throwable th5) {
                    th = th5;
                    str2 = str17;
                    url2 = url;
                    outputStream2 = outputStream7;
                    str4 = str15;
                    str6 = str14;
                    i26 = defaultPort;
                    str5 = defaultHost;
                    httpURLConnection2 = httpURLConnection7;
                    z17 = false;
                    outputStream3 = outputStream2;
                    i27 = 5;
                    try {
                        String str18 = str4;
                        QLog.i(str18, 1, "Download fail 2. url=" + url2 + str6 + faceInfo, th);
                        closeConn(outputStream3, httpURLConnection2);
                        str8 = str6;
                        file3 = file2;
                        deleteTmpFile(5, file3);
                        int i38 = i19 + 1;
                        str7 = str18;
                        httpURLConnection7 = httpURLConnection2;
                        downloadFailedWaitAndTryAgain(str2, faceInfo, 5, obj, i38, z17, str5, i26, i18, str3);
                        i36 = i38;
                        outputStream7 = outputStream3;
                        i37 = 5;
                        if (i37 != 0) {
                        }
                        downloadInfo2 = downloadInfo;
                        downloadInfo2.resultCode = i37;
                        cacheFile(faceInfo, z16, j16, i37);
                        return i37;
                    } catch (Throwable th6) {
                        th = th6;
                        file3 = file2;
                        int i39 = i27;
                        closeConn(outputStream3, httpURLConnection2);
                        deleteTmpFile(i39, file3);
                        downloadFailedWaitAndTryAgain(str2, faceInfo, i39, obj, i19 + 1, z17, str5, i26, i18, str3);
                        throw th;
                    }
                }
            } catch (IOException e17) {
                e = e17;
                str2 = str17;
                str3 = apnType;
                i18 = type;
                i19 = i36;
                OutputStream outputStream8 = outputStream7;
                str7 = str15;
                str8 = str14;
                url2 = url5;
                i26 = defaultPort;
                str5 = defaultHost;
                file3 = file4;
                httpURLConnection2 = httpURLConnection7;
                z17 = false;
                outputStream3 = outputStream8;
                i27 = 5;
            } catch (Throwable th7) {
                th = th7;
                str2 = str17;
                str3 = apnType;
                i18 = type;
                i19 = i36;
                outputStream2 = outputStream7;
                str4 = str15;
                url2 = url5;
                i26 = defaultPort;
                str5 = defaultHost;
                str6 = str14;
            }
            try {
                httpURLConnection3 = (HttpURLConnection) httpConnAndUseProxy[1];
            } catch (IOException e18) {
                e = e18;
                str2 = str17;
                url2 = url;
                outputStream4 = outputStream7;
                str9 = str15;
                i26 = defaultPort;
                str5 = defaultHost;
                file3 = file2;
                z17 = booleanValue;
                str8 = str14;
                httpURLConnection2 = httpURLConnection7;
                outputStream3 = outputStream4;
                str7 = str9;
                i27 = 5;
                try {
                    int dealDownloadExp = dealDownloadExp(faceInfo, url2, file3, e);
                    closeConn(outputStream3, httpURLConnection2);
                    deleteTmpFile(dealDownloadExp, file3);
                    int i46 = i19 + 1;
                    downloadFailedWaitAndTryAgain(str2, faceInfo, dealDownloadExp, obj, i46, z17, str5, i26, i18, str3);
                    i37 = dealDownloadExp;
                    i36 = i46;
                    httpURLConnection7 = httpURLConnection2;
                    outputStream7 = outputStream3;
                    if (i37 != 0) {
                    }
                    downloadInfo2 = downloadInfo;
                    downloadInfo2.resultCode = i37;
                    cacheFile(faceInfo, z16, j16, i37);
                    return i37;
                } catch (Throwable th8) {
                    th = th8;
                    int i392 = i27;
                    closeConn(outputStream3, httpURLConnection2);
                    deleteTmpFile(i392, file3);
                    downloadFailedWaitAndTryAgain(str2, faceInfo, i392, obj, i19 + 1, z17, str5, i26, i18, str3);
                    throw th;
                }
            } catch (Throwable th9) {
                th = th9;
                str2 = str17;
                url2 = url;
                outputStream2 = outputStream7;
                str4 = str15;
                str6 = str14;
                i26 = defaultPort;
                str5 = defaultHost;
                z17 = booleanValue;
                httpURLConnection2 = httpURLConnection7;
            }
            try {
                httpURLConnection3.connect();
                downloadInfo3.httpRespCode = httpURLConnection3.getResponseCode();
                downloadInfo3.respContentLength = httpURLConnection3.getContentLength();
                downloadInfo3.respContentType = httpURLConnection3.getContentType();
                downloadInfo3.respContentEncoding = httpURLConnection3.getContentEncoding();
                downloadInfo3.respVerifyString = httpURLConnection3.getHeaderField("X-BCheck");
                String headerField = httpURLConnection3.getHeaderField("X-ErrNo");
                try {
                } catch (IOException e19) {
                    e = e19;
                    str2 = str17;
                    url2 = url;
                    OutputStream outputStream9 = outputStream7;
                    file3 = file2;
                    str5 = defaultHost;
                    str7 = str15;
                    z17 = booleanValue;
                    outputStream3 = outputStream9;
                    i27 = 5;
                    i26 = defaultPort;
                    str8 = str14;
                    httpURLConnection2 = httpURLConnection3;
                } catch (Throwable th10) {
                    th = th10;
                    str2 = str17;
                    url2 = url;
                    httpURLConnection4 = httpURLConnection3;
                    outputStream2 = outputStream7;
                    str4 = str15;
                    str6 = str14;
                    i26 = defaultPort;
                    str5 = defaultHost;
                    z17 = booleanValue;
                    httpURLConnection2 = httpURLConnection4;
                    outputStream3 = outputStream2;
                    i27 = 5;
                    String str182 = str4;
                    QLog.i(str182, 1, "Download fail 2. url=" + url2 + str6 + faceInfo, th);
                    closeConn(outputStream3, httpURLConnection2);
                    str8 = str6;
                    file3 = file2;
                    deleteTmpFile(5, file3);
                    int i382 = i19 + 1;
                    str7 = str182;
                    httpURLConnection7 = httpURLConnection2;
                    downloadFailedWaitAndTryAgain(str2, faceInfo, 5, obj, i382, z17, str5, i26, i18, str3);
                    i36 = i382;
                    outputStream7 = outputStream3;
                    i37 = 5;
                    if (i37 != 0) {
                    }
                    downloadInfo2 = downloadInfo;
                    downloadInfo2.resultCode = i37;
                    cacheFile(faceInfo, z16, j16, i37);
                    return i37;
                }
                if (needVerify(faceInfo.headType)) {
                    httpURLConnection5 = httpURLConnection3;
                    z18 = booleanValue;
                    try {
                    } catch (IOException e26) {
                        e = e26;
                        OutputStream outputStream10 = outputStream7;
                        str2 = str17;
                        url2 = url;
                        str5 = defaultHost;
                        i27 = 5;
                        str7 = str15;
                        str8 = str14;
                        file3 = file4;
                        z17 = z18;
                        outputStream3 = outputStream10;
                        i26 = defaultPort;
                        httpURLConnection2 = httpURLConnection5;
                        int dealDownloadExp2 = dealDownloadExp(faceInfo, url2, file3, e);
                        closeConn(outputStream3, httpURLConnection2);
                        deleteTmpFile(dealDownloadExp2, file3);
                        int i462 = i19 + 1;
                        downloadFailedWaitAndTryAgain(str2, faceInfo, dealDownloadExp2, obj, i462, z17, str5, i26, i18, str3);
                        i37 = dealDownloadExp2;
                        i36 = i462;
                        httpURLConnection7 = httpURLConnection2;
                        outputStream7 = outputStream3;
                        if (i37 != 0) {
                        }
                        downloadInfo2 = downloadInfo;
                        downloadInfo2.resultCode = i37;
                        cacheFile(faceInfo, z16, j16, i37);
                        return i37;
                    } catch (Throwable th11) {
                        th = th11;
                        OutputStream outputStream11 = outputStream7;
                        str2 = str17;
                        url2 = url;
                        str5 = defaultHost;
                        i27 = 5;
                        str4 = str15;
                        str6 = str14;
                        z17 = z18;
                        outputStream3 = outputStream11;
                        i26 = defaultPort;
                        httpURLConnection2 = httpURLConnection5;
                        String str1822 = str4;
                        QLog.i(str1822, 1, "Download fail 2. url=" + url2 + str6 + faceInfo, th);
                        closeConn(outputStream3, httpURLConnection2);
                        str8 = str6;
                        file3 = file2;
                        deleteTmpFile(5, file3);
                        int i3822 = i19 + 1;
                        str7 = str1822;
                        httpURLConnection7 = httpURLConnection2;
                        downloadFailedWaitAndTryAgain(str2, faceInfo, 5, obj, i3822, z17, str5, i26, i18, str3);
                        i36 = i3822;
                        outputStream7 = outputStream3;
                        i37 = 5;
                        if (i37 != 0) {
                        }
                        downloadInfo2 = downloadInfo;
                        downloadInfo2.resultCode = i37;
                        cacheFile(faceInfo, z16, j16, i37);
                        return i37;
                    }
                    if (isVerifyError(faceInfo, 5, downloadInfo, httpURLConnection3, headerField)) {
                        closeConn(outputStream7, httpURLConnection5);
                        deleteTmpFile(5, file4);
                        int i47 = i19 + 1;
                        file3 = file4;
                        downloadFailedWaitAndTryAgain(str17, faceInfo, 5, obj, i47, z18, defaultHost, defaultPort, i18, str3);
                        url2 = url;
                        httpURLConnection7 = httpURLConnection5;
                        i36 = i47;
                        outputStream7 = outputStream7;
                        str7 = str15;
                        str8 = str14;
                        i37 = 5;
                        str2 = str17;
                        if (i37 != 0 || i36 >= i16) {
                            break;
                        }
                        file4 = file3;
                        url5 = url2;
                        str14 = str8;
                        str16 = str2;
                        str15 = str7;
                        downloadInfo3 = downloadInfo;
                    }
                } else {
                    httpURLConnection5 = httpURLConnection3;
                    z18 = booleanValue;
                }
                OutputStream outputStream12 = outputStream7;
                str4 = str15;
                String str19 = str14;
                file3 = file4;
                int i48 = downloadInfo3.httpRespCode;
                if (200 == i48) {
                    try {
                        long j17 = downloadInfo3.respContentLength;
                        str10 = str17;
                        try {
                            com.tencent.qqperf.reporter.flow.a.b("FaceDownloader", str10, j17);
                            try {
                                if (file2.exists()) {
                                    try {
                                        file2.delete();
                                    } catch (FileNotFoundException unused) {
                                        url3 = url;
                                        j3 = j17;
                                        outputStream5 = outputStream12;
                                        str11 = str4;
                                        str12 = str19;
                                        try {
                                            QLog.i(str11, 1, "FileNotFoundException file exist=" + file2.exists() + ", dir exist=" + file2.getParentFile().exists());
                                            if (inputStream != null) {
                                            }
                                            i28 = 4;
                                            httpURLConnection6 = httpURLConnection5;
                                            i29 = i28;
                                            outputStream6 = outputStream5;
                                            j16 = j3;
                                            str13 = str12;
                                            closeConn(outputStream6, httpURLConnection6);
                                            deleteTmpFile(i29, file3);
                                            int i49 = i19 + 1;
                                            OutputStream outputStream13 = outputStream6;
                                            String str20 = str13;
                                            url2 = url3;
                                            str2 = str10;
                                            downloadFailedWaitAndTryAgain(str10, faceInfo, i29, obj, i49, z18, defaultHost, defaultPort, i18, str3);
                                            i37 = i29;
                                            i36 = i49;
                                            httpURLConnection7 = httpURLConnection6;
                                            outputStream7 = outputStream13;
                                            str7 = str11;
                                            str8 = str20;
                                            file3 = file2;
                                            if (i37 != 0) {
                                            }
                                            downloadInfo2 = downloadInfo;
                                            downloadInfo2.resultCode = i37;
                                            cacheFile(faceInfo, z16, j16, i37);
                                            return i37;
                                        } catch (Throwable th12) {
                                            th = th12;
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            throw th;
                                            break;
                                        }
                                    } catch (Throwable th13) {
                                        th = th13;
                                        url3 = url;
                                        j3 = j17;
                                        outputStream5 = outputStream12;
                                        str11 = str4;
                                        str12 = str19;
                                        if (inputStream != null) {
                                        }
                                        throw th;
                                        break;
                                        break;
                                    }
                                }
                                File parentFile = file2.getParentFile();
                                if (parentFile != null && !parentFile.exists()) {
                                    parentFile.mkdirs();
                                }
                                file2.createNewFile();
                                outputStream5 = new BufferedOutputStream(new FileOutputStream(file3));
                                try {
                                    InputStream inputStream2 = httpURLConnection5.getInputStream();
                                    if (z16 && j17 < 20480) {
                                        try {
                                            byte[] bArr = new byte[40960];
                                            int i56 = 0;
                                            int i57 = 0;
                                            while (true) {
                                                int read = inputStream2.read(bArr, i56, 1024);
                                                if (read == -1) {
                                                    break;
                                                }
                                                i56 += read;
                                                i57 += read;
                                            }
                                            faceInfo.markTime(FaceInfo.TIME_END_DOWNLOAD);
                                            if (i57 == j17) {
                                                faceInfo.markTime(FaceInfo.TIME_BEGIN_DECODE);
                                                Bitmap b16 = com.tencent.mobileqq.util.j.b(bArr, 0, i57);
                                                try {
                                                    if (faceInfo.isUserHeadType()) {
                                                        try {
                                                            if (faceInfo.isEnableZplanOutbound() && faceInfo.isSupportStaticZplanAvatarInfo() && faceInfo.shape != 8) {
                                                                str11 = str4;
                                                                try {
                                                                    QLog.e(str11, 1, "realDownloadData faceInfo shape error: " + faceInfo);
                                                                    Bitmap bitmapByShape = getBitmapByShape(faceInfo, b16);
                                                                    if (!QLog.isDevelopLevel()) {
                                                                        StringBuilder sb5 = new StringBuilder();
                                                                        sb5.append("Download.decode from mem bmp=");
                                                                        sb5.append(bitmapByShape);
                                                                        sb5.append(", url=");
                                                                        url4 = url;
                                                                        j3 = j17;
                                                                        try {
                                                                            sb5.append(url4);
                                                                            str12 = str19;
                                                                        } catch (FileNotFoundException unused2) {
                                                                            str12 = str19;
                                                                            inputStream = inputStream2;
                                                                            url3 = url4;
                                                                            QLog.i(str11, 1, "FileNotFoundException file exist=" + file2.exists() + ", dir exist=" + file2.getParentFile().exists());
                                                                            if (inputStream != null) {
                                                                            }
                                                                            i28 = 4;
                                                                            httpURLConnection6 = httpURLConnection5;
                                                                            i29 = i28;
                                                                            outputStream6 = outputStream5;
                                                                            j16 = j3;
                                                                            str13 = str12;
                                                                            closeConn(outputStream6, httpURLConnection6);
                                                                            deleteTmpFile(i29, file3);
                                                                            int i492 = i19 + 1;
                                                                            OutputStream outputStream132 = outputStream6;
                                                                            String str202 = str13;
                                                                            url2 = url3;
                                                                            str2 = str10;
                                                                            downloadFailedWaitAndTryAgain(str10, faceInfo, i29, obj, i492, z18, defaultHost, defaultPort, i18, str3);
                                                                            i37 = i29;
                                                                            i36 = i492;
                                                                            httpURLConnection7 = httpURLConnection6;
                                                                            outputStream7 = outputStream132;
                                                                            str7 = str11;
                                                                            str8 = str202;
                                                                            file3 = file2;
                                                                            if (i37 != 0) {
                                                                            }
                                                                            downloadInfo2 = downloadInfo;
                                                                            downloadInfo2.resultCode = i37;
                                                                            cacheFile(faceInfo, z16, j16, i37);
                                                                            return i37;
                                                                        } catch (Throwable th14) {
                                                                            th = th14;
                                                                            str12 = str19;
                                                                            inputStream = inputStream2;
                                                                            url3 = url4;
                                                                            if (inputStream != null) {
                                                                            }
                                                                            throw th;
                                                                            break;
                                                                            break;
                                                                        }
                                                                        try {
                                                                            sb5.append(str12);
                                                                            sb5.append(faceInfo);
                                                                            QLog.i(str11, 4, sb5.toString());
                                                                        } catch (FileNotFoundException unused3) {
                                                                            inputStream = inputStream2;
                                                                            url3 = url4;
                                                                            QLog.i(str11, 1, "FileNotFoundException file exist=" + file2.exists() + ", dir exist=" + file2.getParentFile().exists());
                                                                            if (inputStream != null) {
                                                                                try {
                                                                                    inputStream.close();
                                                                                } catch (IOException e27) {
                                                                                    e = e27;
                                                                                    i26 = defaultPort;
                                                                                    str8 = str12;
                                                                                    url2 = url3;
                                                                                    str2 = str10;
                                                                                    z17 = z18;
                                                                                    j16 = j3;
                                                                                    i27 = 4;
                                                                                    httpURLConnection2 = httpURLConnection5;
                                                                                    str7 = str11;
                                                                                    outputStream3 = outputStream5;
                                                                                    str5 = defaultHost;
                                                                                    int dealDownloadExp22 = dealDownloadExp(faceInfo, url2, file3, e);
                                                                                    closeConn(outputStream3, httpURLConnection2);
                                                                                    deleteTmpFile(dealDownloadExp22, file3);
                                                                                    int i4622 = i19 + 1;
                                                                                    downloadFailedWaitAndTryAgain(str2, faceInfo, dealDownloadExp22, obj, i4622, z17, str5, i26, i18, str3);
                                                                                    i37 = dealDownloadExp22;
                                                                                    i36 = i4622;
                                                                                    httpURLConnection7 = httpURLConnection2;
                                                                                    outputStream7 = outputStream3;
                                                                                    if (i37 != 0) {
                                                                                    }
                                                                                    downloadInfo2 = downloadInfo;
                                                                                    downloadInfo2.resultCode = i37;
                                                                                    cacheFile(faceInfo, z16, j16, i37);
                                                                                    return i37;
                                                                                } catch (Throwable th15) {
                                                                                    th = th15;
                                                                                    i26 = defaultPort;
                                                                                    str4 = str11;
                                                                                    str6 = str12;
                                                                                    url2 = url3;
                                                                                    str2 = str10;
                                                                                    z17 = z18;
                                                                                    j16 = j3;
                                                                                    i27 = 4;
                                                                                    httpURLConnection2 = httpURLConnection5;
                                                                                    outputStream3 = outputStream5;
                                                                                    str5 = defaultHost;
                                                                                    String str18222 = str4;
                                                                                    QLog.i(str18222, 1, "Download fail 2. url=" + url2 + str6 + faceInfo, th);
                                                                                    closeConn(outputStream3, httpURLConnection2);
                                                                                    str8 = str6;
                                                                                    file3 = file2;
                                                                                    deleteTmpFile(5, file3);
                                                                                    int i38222 = i19 + 1;
                                                                                    str7 = str18222;
                                                                                    httpURLConnection7 = httpURLConnection2;
                                                                                    downloadFailedWaitAndTryAgain(str2, faceInfo, 5, obj, i38222, z17, str5, i26, i18, str3);
                                                                                    i36 = i38222;
                                                                                    outputStream7 = outputStream3;
                                                                                    i37 = 5;
                                                                                    if (i37 != 0) {
                                                                                    }
                                                                                    downloadInfo2 = downloadInfo;
                                                                                    downloadInfo2.resultCode = i37;
                                                                                    cacheFile(faceInfo, z16, j16, i37);
                                                                                    return i37;
                                                                                }
                                                                            }
                                                                            i28 = 4;
                                                                            httpURLConnection6 = httpURLConnection5;
                                                                            i29 = i28;
                                                                            outputStream6 = outputStream5;
                                                                            j16 = j3;
                                                                            str13 = str12;
                                                                            closeConn(outputStream6, httpURLConnection6);
                                                                            deleteTmpFile(i29, file3);
                                                                            int i4922 = i19 + 1;
                                                                            OutputStream outputStream1322 = outputStream6;
                                                                            String str2022 = str13;
                                                                            url2 = url3;
                                                                            str2 = str10;
                                                                            downloadFailedWaitAndTryAgain(str10, faceInfo, i29, obj, i4922, z18, defaultHost, defaultPort, i18, str3);
                                                                            i37 = i29;
                                                                            i36 = i4922;
                                                                            httpURLConnection7 = httpURLConnection6;
                                                                            outputStream7 = outputStream1322;
                                                                            str7 = str11;
                                                                            str8 = str2022;
                                                                            file3 = file2;
                                                                            if (i37 != 0) {
                                                                            }
                                                                            downloadInfo2 = downloadInfo;
                                                                            downloadInfo2.resultCode = i37;
                                                                            cacheFile(faceInfo, z16, j16, i37);
                                                                            return i37;
                                                                        } catch (Throwable th16) {
                                                                            th = th16;
                                                                            inputStream = inputStream2;
                                                                            url3 = url4;
                                                                            if (inputStream != null) {
                                                                            }
                                                                            throw th;
                                                                            break;
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        url4 = url;
                                                                        j3 = j17;
                                                                        str12 = str19;
                                                                    }
                                                                    PendingTask pendingTask = new PendingTask();
                                                                    pendingTask.faceInfo = faceInfo;
                                                                    pendingTask.bitmap = bitmapByShape;
                                                                    this.sPendingResultList.add(pendingTask);
                                                                    this.handler.obtainMessage(100, pendingTask).sendToTarget();
                                                                } catch (FileNotFoundException unused4) {
                                                                    url3 = url;
                                                                    j3 = j17;
                                                                    inputStream = inputStream2;
                                                                    str12 = str19;
                                                                    QLog.i(str11, 1, "FileNotFoundException file exist=" + file2.exists() + ", dir exist=" + file2.getParentFile().exists());
                                                                    if (inputStream != null) {
                                                                    }
                                                                    i28 = 4;
                                                                    httpURLConnection6 = httpURLConnection5;
                                                                    i29 = i28;
                                                                    outputStream6 = outputStream5;
                                                                    j16 = j3;
                                                                    str13 = str12;
                                                                    closeConn(outputStream6, httpURLConnection6);
                                                                    deleteTmpFile(i29, file3);
                                                                    int i49222 = i19 + 1;
                                                                    OutputStream outputStream13222 = outputStream6;
                                                                    String str20222 = str13;
                                                                    url2 = url3;
                                                                    str2 = str10;
                                                                    downloadFailedWaitAndTryAgain(str10, faceInfo, i29, obj, i49222, z18, defaultHost, defaultPort, i18, str3);
                                                                    i37 = i29;
                                                                    i36 = i49222;
                                                                    httpURLConnection7 = httpURLConnection6;
                                                                    outputStream7 = outputStream13222;
                                                                    str7 = str11;
                                                                    str8 = str20222;
                                                                    file3 = file2;
                                                                    if (i37 != 0) {
                                                                    }
                                                                    downloadInfo2 = downloadInfo;
                                                                    downloadInfo2.resultCode = i37;
                                                                    cacheFile(faceInfo, z16, j16, i37);
                                                                    return i37;
                                                                } catch (Throwable th17) {
                                                                    th = th17;
                                                                    url3 = url;
                                                                    j3 = j17;
                                                                    inputStream = inputStream2;
                                                                    str12 = str19;
                                                                    if (inputStream != null) {
                                                                    }
                                                                    throw th;
                                                                    break;
                                                                    break;
                                                                }
                                                            }
                                                        } catch (FileNotFoundException unused5) {
                                                            str11 = str4;
                                                        } catch (Throwable th18) {
                                                            th = th18;
                                                            str11 = str4;
                                                        }
                                                    }
                                                    Bitmap bitmapByShape2 = getBitmapByShape(faceInfo, b16);
                                                    if (!QLog.isDevelopLevel()) {
                                                    }
                                                    PendingTask pendingTask2 = new PendingTask();
                                                    pendingTask2.faceInfo = faceInfo;
                                                    pendingTask2.bitmap = bitmapByShape2;
                                                    this.sPendingResultList.add(pendingTask2);
                                                    this.handler.obtainMessage(100, pendingTask2).sendToTarget();
                                                } catch (FileNotFoundException unused6) {
                                                    j3 = j17;
                                                    str12 = str19;
                                                    url3 = url;
                                                    inputStream = inputStream2;
                                                    QLog.i(str11, 1, "FileNotFoundException file exist=" + file2.exists() + ", dir exist=" + file2.getParentFile().exists());
                                                    if (inputStream != null) {
                                                    }
                                                    i28 = 4;
                                                    httpURLConnection6 = httpURLConnection5;
                                                    i29 = i28;
                                                    outputStream6 = outputStream5;
                                                    j16 = j3;
                                                    str13 = str12;
                                                    closeConn(outputStream6, httpURLConnection6);
                                                    deleteTmpFile(i29, file3);
                                                    int i492222 = i19 + 1;
                                                    OutputStream outputStream132222 = outputStream6;
                                                    String str202222 = str13;
                                                    url2 = url3;
                                                    str2 = str10;
                                                    downloadFailedWaitAndTryAgain(str10, faceInfo, i29, obj, i492222, z18, defaultHost, defaultPort, i18, str3);
                                                    i37 = i29;
                                                    i36 = i492222;
                                                    httpURLConnection7 = httpURLConnection6;
                                                    outputStream7 = outputStream132222;
                                                    str7 = str11;
                                                    str8 = str202222;
                                                    file3 = file2;
                                                    if (i37 != 0) {
                                                    }
                                                    downloadInfo2 = downloadInfo;
                                                    downloadInfo2.resultCode = i37;
                                                    cacheFile(faceInfo, z16, j16, i37);
                                                    return i37;
                                                } catch (Throwable th19) {
                                                    th = th19;
                                                    j3 = j17;
                                                    str12 = str19;
                                                    url3 = url;
                                                    inputStream = inputStream2;
                                                    if (inputStream != null) {
                                                    }
                                                    throw th;
                                                    break;
                                                    break;
                                                }
                                                str11 = str4;
                                            } else {
                                                url4 = url;
                                                j3 = j17;
                                                str11 = str4;
                                                str12 = str19;
                                            }
                                            outputStream5.write(bArr, 0, i57);
                                            url3 = url4;
                                        } catch (FileNotFoundException unused7) {
                                            j3 = j17;
                                            str11 = str4;
                                        } catch (Throwable th20) {
                                            th = th20;
                                            j3 = j17;
                                            str11 = str4;
                                        }
                                    } else {
                                        url3 = url;
                                        j3 = j17;
                                        str11 = str4;
                                        str12 = str19;
                                        try {
                                            byte[] bArr2 = new byte[1024];
                                            while (true) {
                                                int read2 = inputStream2.read(bArr2);
                                                if (read2 == -1) {
                                                    break;
                                                }
                                                outputStream5.write(bArr2, 0, read2);
                                            }
                                            faceInfo.markTime(FaceInfo.TIME_END_DOWNLOAD);
                                        } catch (FileNotFoundException unused8) {
                                            inputStream = inputStream2;
                                            QLog.i(str11, 1, "FileNotFoundException file exist=" + file2.exists() + ", dir exist=" + file2.getParentFile().exists());
                                            if (inputStream != null) {
                                            }
                                            i28 = 4;
                                            httpURLConnection6 = httpURLConnection5;
                                            i29 = i28;
                                            outputStream6 = outputStream5;
                                            j16 = j3;
                                            str13 = str12;
                                            closeConn(outputStream6, httpURLConnection6);
                                            deleteTmpFile(i29, file3);
                                            int i4922222 = i19 + 1;
                                            OutputStream outputStream1322222 = outputStream6;
                                            String str2022222 = str13;
                                            url2 = url3;
                                            str2 = str10;
                                            downloadFailedWaitAndTryAgain(str10, faceInfo, i29, obj, i4922222, z18, defaultHost, defaultPort, i18, str3);
                                            i37 = i29;
                                            i36 = i4922222;
                                            httpURLConnection7 = httpURLConnection6;
                                            outputStream7 = outputStream1322222;
                                            str7 = str11;
                                            str8 = str2022222;
                                            file3 = file2;
                                            if (i37 != 0) {
                                            }
                                            downloadInfo2 = downloadInfo;
                                            downloadInfo2.resultCode = i37;
                                            cacheFile(faceInfo, z16, j16, i37);
                                            return i37;
                                        } catch (Throwable th21) {
                                            th = th21;
                                            inputStream = inputStream2;
                                            if (inputStream != null) {
                                            }
                                            throw th;
                                            break;
                                            break;
                                        }
                                    }
                                    outputStream5.flush();
                                    try {
                                        renameFile(file, file3);
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (IOException e28) {
                                                e = e28;
                                                i26 = defaultPort;
                                                str8 = str12;
                                                i27 = 0;
                                                url2 = url3;
                                                str2 = str10;
                                                z17 = z18;
                                                j16 = j3;
                                                httpURLConnection2 = httpURLConnection5;
                                                str7 = str11;
                                                outputStream3 = outputStream5;
                                                str5 = defaultHost;
                                                int dealDownloadExp222 = dealDownloadExp(faceInfo, url2, file3, e);
                                                closeConn(outputStream3, httpURLConnection2);
                                                deleteTmpFile(dealDownloadExp222, file3);
                                                int i46222 = i19 + 1;
                                                downloadFailedWaitAndTryAgain(str2, faceInfo, dealDownloadExp222, obj, i46222, z17, str5, i26, i18, str3);
                                                i37 = dealDownloadExp222;
                                                i36 = i46222;
                                                httpURLConnection7 = httpURLConnection2;
                                                outputStream7 = outputStream3;
                                                if (i37 != 0) {
                                                }
                                                downloadInfo2 = downloadInfo;
                                                downloadInfo2.resultCode = i37;
                                                cacheFile(faceInfo, z16, j16, i37);
                                                return i37;
                                            } catch (Throwable th22) {
                                                th = th22;
                                                i26 = defaultPort;
                                                str4 = str11;
                                                str6 = str12;
                                                i27 = 0;
                                                url2 = url3;
                                                str2 = str10;
                                                z17 = z18;
                                                j16 = j3;
                                                httpURLConnection2 = httpURLConnection5;
                                                outputStream3 = outputStream5;
                                                str5 = defaultHost;
                                                String str182222 = str4;
                                                QLog.i(str182222, 1, "Download fail 2. url=" + url2 + str6 + faceInfo, th);
                                                closeConn(outputStream3, httpURLConnection2);
                                                str8 = str6;
                                                file3 = file2;
                                                deleteTmpFile(5, file3);
                                                int i382222 = i19 + 1;
                                                str7 = str182222;
                                                httpURLConnection7 = httpURLConnection2;
                                                downloadFailedWaitAndTryAgain(str2, faceInfo, 5, obj, i382222, z17, str5, i26, i18, str3);
                                                i36 = i382222;
                                                outputStream7 = outputStream3;
                                                i37 = 5;
                                                if (i37 != 0) {
                                                }
                                                downloadInfo2 = downloadInfo;
                                                downloadInfo2.resultCode = i37;
                                                cacheFile(faceInfo, z16, j16, i37);
                                                return i37;
                                            }
                                        }
                                    } catch (FileNotFoundException unused9) {
                                        inputStream = inputStream2;
                                        QLog.i(str11, 1, "FileNotFoundException file exist=" + file2.exists() + ", dir exist=" + file2.getParentFile().exists());
                                        if (inputStream != null) {
                                        }
                                        i28 = 4;
                                        httpURLConnection6 = httpURLConnection5;
                                        i29 = i28;
                                        outputStream6 = outputStream5;
                                        j16 = j3;
                                        str13 = str12;
                                        closeConn(outputStream6, httpURLConnection6);
                                        deleteTmpFile(i29, file3);
                                        int i49222222 = i19 + 1;
                                        OutputStream outputStream13222222 = outputStream6;
                                        String str20222222 = str13;
                                        url2 = url3;
                                        str2 = str10;
                                        downloadFailedWaitAndTryAgain(str10, faceInfo, i29, obj, i49222222, z18, defaultHost, defaultPort, i18, str3);
                                        i37 = i29;
                                        i36 = i49222222;
                                        httpURLConnection7 = httpURLConnection6;
                                        outputStream7 = outputStream13222222;
                                        str7 = str11;
                                        str8 = str20222222;
                                        file3 = file2;
                                        if (i37 != 0) {
                                        }
                                        downloadInfo2 = downloadInfo;
                                        downloadInfo2.resultCode = i37;
                                        cacheFile(faceInfo, z16, j16, i37);
                                        return i37;
                                    } catch (Throwable th23) {
                                        th = th23;
                                        inputStream = inputStream2;
                                        if (inputStream != null) {
                                        }
                                        throw th;
                                        break;
                                        break;
                                    }
                                } catch (FileNotFoundException unused10) {
                                    url3 = url;
                                    j3 = j17;
                                    str11 = str4;
                                    str12 = str19;
                                    QLog.i(str11, 1, "FileNotFoundException file exist=" + file2.exists() + ", dir exist=" + file2.getParentFile().exists());
                                    if (inputStream != null) {
                                    }
                                    i28 = 4;
                                    httpURLConnection6 = httpURLConnection5;
                                    i29 = i28;
                                    outputStream6 = outputStream5;
                                    j16 = j3;
                                    str13 = str12;
                                    closeConn(outputStream6, httpURLConnection6);
                                    deleteTmpFile(i29, file3);
                                    int i492222222 = i19 + 1;
                                    OutputStream outputStream132222222 = outputStream6;
                                    String str202222222 = str13;
                                    url2 = url3;
                                    str2 = str10;
                                    downloadFailedWaitAndTryAgain(str10, faceInfo, i29, obj, i492222222, z18, defaultHost, defaultPort, i18, str3);
                                    i37 = i29;
                                    i36 = i492222222;
                                    httpURLConnection7 = httpURLConnection6;
                                    outputStream7 = outputStream132222222;
                                    str7 = str11;
                                    str8 = str202222222;
                                    file3 = file2;
                                    if (i37 != 0) {
                                    }
                                    downloadInfo2 = downloadInfo;
                                    downloadInfo2.resultCode = i37;
                                    cacheFile(faceInfo, z16, j16, i37);
                                    return i37;
                                } catch (Throwable th24) {
                                    th = th24;
                                    url3 = url;
                                    j3 = j17;
                                    str11 = str4;
                                    str12 = str19;
                                    if (inputStream != null) {
                                    }
                                    throw th;
                                    break;
                                    break;
                                }
                            } catch (FileNotFoundException unused11) {
                                url3 = url;
                                j3 = j17;
                                str11 = str4;
                                str12 = str19;
                                outputStream5 = outputStream12;
                            } catch (Throwable th25) {
                                th = th25;
                                url3 = url;
                                j3 = j17;
                                str11 = str4;
                                str12 = str19;
                                outputStream5 = outputStream12;
                            }
                            httpURLConnection6 = httpURLConnection5;
                            i29 = i28;
                            outputStream6 = outputStream5;
                            j16 = j3;
                            str13 = str12;
                        } catch (IOException e29) {
                            e = e29;
                            url2 = url;
                            i26 = defaultPort;
                            str5 = defaultHost;
                            httpURLConnection2 = httpURLConnection5;
                            i27 = 0;
                            z17 = z18;
                            str7 = str4;
                            str8 = str19;
                            str2 = str10;
                            outputStream3 = outputStream12;
                        } catch (Throwable th26) {
                            th = th26;
                            url2 = url;
                            i26 = defaultPort;
                            str5 = defaultHost;
                            httpURLConnection2 = httpURLConnection5;
                            i27 = 0;
                            z17 = z18;
                            str6 = str19;
                            str2 = str10;
                            outputStream3 = outputStream12;
                            String str1822222 = str4;
                            QLog.i(str1822222, 1, "Download fail 2. url=" + url2 + str6 + faceInfo, th);
                            closeConn(outputStream3, httpURLConnection2);
                            str8 = str6;
                            file3 = file2;
                            deleteTmpFile(5, file3);
                            int i3822222 = i19 + 1;
                            str7 = str1822222;
                            httpURLConnection7 = httpURLConnection2;
                            downloadFailedWaitAndTryAgain(str2, faceInfo, 5, obj, i3822222, z17, str5, i26, i18, str3);
                            i36 = i3822222;
                            outputStream7 = outputStream3;
                            i37 = 5;
                            if (i37 != 0) {
                            }
                            downloadInfo2 = downloadInfo;
                            downloadInfo2.resultCode = i37;
                            cacheFile(faceInfo, z16, j16, i37);
                            return i37;
                        }
                    } catch (IOException e36) {
                        e = e36;
                        url2 = url;
                        i26 = defaultPort;
                        str5 = defaultHost;
                        httpURLConnection2 = httpURLConnection5;
                        i27 = 0;
                        z17 = z18;
                        outputStream3 = outputStream12;
                        str7 = str4;
                        str8 = str19;
                        str2 = str17;
                    } catch (Throwable th27) {
                        th = th27;
                        url2 = url;
                        i26 = defaultPort;
                        str5 = defaultHost;
                        httpURLConnection2 = httpURLConnection5;
                        i27 = 0;
                        z17 = z18;
                        outputStream3 = outputStream12;
                        str6 = str19;
                        str2 = str17;
                    }
                } else {
                    str10 = str17;
                    url3 = url;
                    str11 = str4;
                    str13 = str19;
                    httpURLConnection6 = httpURLConnection5;
                    i29 = i48;
                    outputStream6 = outputStream12;
                }
                closeConn(outputStream6, httpURLConnection6);
                deleteTmpFile(i29, file3);
                int i4922222222 = i19 + 1;
                OutputStream outputStream1322222222 = outputStream6;
                String str2022222222 = str13;
                url2 = url3;
                str2 = str10;
                downloadFailedWaitAndTryAgain(str10, faceInfo, i29, obj, i4922222222, z18, defaultHost, defaultPort, i18, str3);
                i37 = i29;
                i36 = i4922222222;
                httpURLConnection7 = httpURLConnection6;
                outputStream7 = outputStream1322222222;
                str7 = str11;
                str8 = str2022222222;
                file3 = file2;
                if (i37 != 0) {
                    break;
                }
                break;
            } catch (Throwable th28) {
                str2 = str17;
                url2 = url;
                httpURLConnection4 = httpURLConnection3;
                outputStream2 = outputStream7;
                str4 = str15;
                str6 = str14;
                i26 = defaultPort;
                str5 = defaultHost;
                try {
                    setForceDirectByUseProxy(booleanValue, str5, i26);
                    throw th28;
                    break;
                } catch (IOException e37) {
                    e = e37;
                    z17 = booleanValue;
                    httpURLConnection2 = httpURLConnection4;
                    outputStream3 = outputStream2;
                    str7 = str4;
                    i27 = 5;
                    str8 = str6;
                    file3 = file2;
                    int dealDownloadExp2222 = dealDownloadExp(faceInfo, url2, file3, e);
                    closeConn(outputStream3, httpURLConnection2);
                    deleteTmpFile(dealDownloadExp2222, file3);
                    int i462222 = i19 + 1;
                    downloadFailedWaitAndTryAgain(str2, faceInfo, dealDownloadExp2222, obj, i462222, z17, str5, i26, i18, str3);
                    i37 = dealDownloadExp2222;
                    i36 = i462222;
                    httpURLConnection7 = httpURLConnection2;
                    outputStream7 = outputStream3;
                    if (i37 != 0) {
                    }
                    downloadInfo2 = downloadInfo;
                    downloadInfo2.resultCode = i37;
                    cacheFile(faceInfo, z16, j16, i37);
                    return i37;
                } catch (Throwable th29) {
                    th = th29;
                    z17 = booleanValue;
                    httpURLConnection2 = httpURLConnection4;
                    outputStream3 = outputStream2;
                    i27 = 5;
                    String str18222222 = str4;
                    QLog.i(str18222222, 1, "Download fail 2. url=" + url2 + str6 + faceInfo, th);
                    closeConn(outputStream3, httpURLConnection2);
                    str8 = str6;
                    file3 = file2;
                    deleteTmpFile(5, file3);
                    int i38222222 = i19 + 1;
                    str7 = str18222222;
                    httpURLConnection7 = httpURLConnection2;
                    downloadFailedWaitAndTryAgain(str2, faceInfo, 5, obj, i38222222, z17, str5, i26, i18, str3);
                    i36 = i38222222;
                    outputStream7 = outputStream3;
                    i37 = 5;
                    if (i37 != 0) {
                    }
                    downloadInfo2 = downloadInfo;
                    downloadInfo2.resultCode = i37;
                    cacheFile(faceInfo, z16, j16, i37);
                    return i37;
                }
            }
        }
        downloadInfo2 = downloadInfo;
        downloadInfo2.resultCode = i37;
        cacheFile(faceInfo, z16, j16, i37);
        return i37;
    }

    private void renameFile(File file, File file2) {
        if (file.exists()) {
            file.delete();
        }
        file2.renameTo(file);
        file.setLastModified(System.currentTimeMillis());
    }

    private void setForceDirect(String str, int i3, String str2) {
        if (!str2.equals(lastApn)) {
            if (i3 != 1 && !str2.equals(PkgTools.APN_TYPE_CMWAP)) {
                forceDirect = true;
            } else {
                forceDirect = false;
            }
            lastApn = str2;
        }
        if (i3 == 1) {
            if ("10.0.0.172".equals(str) || "10.0.0.200".equals(str)) {
                forceDirect = true;
            }
        }
    }

    private void setForceDirectByUseProxy(boolean z16, String str, int i3) {
        if (z16) {
            forceDirect = true;
        } else if (str != null && i3 > 0) {
            forceDirect = false;
        }
    }

    public void addDownloadRequest(FaceInfo faceInfo) {
        String faceUrlUniq;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) faceInfo);
            return;
        }
        smartSetThreadCount(this.maxThreadCount);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "addDownloadRequest, info=" + faceInfo);
        }
        synchronized (this.mDownloadingUrlSet) {
            if (faceInfo != null) {
                faceUrlUniq = faceInfo.getFaceUrlUniq();
            } else {
                faceUrlUniq = "";
            }
            if (!TextUtils.isEmpty(faceUrlUniq) && !this.mDownloadingUrlSet.contains(faceUrlUniq)) {
                this.mDownloadingUrlSet.add(faceUrlUniq);
                synchronized (this.mRequestQueue) {
                    this.mRequestQueue.add(faceInfo);
                    this.mRequestQueue.notify();
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "addDownloadRequest url repeat, info=" + faceInfo + ",urlUniq=" + faceUrlUniq);
            }
        }
    }

    public synchronized void addFaceDownloadListener(FaceDownloadListener faceDownloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) faceDownloadListener);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "addFaceDownloadListener l=" + faceDownloadListener);
        }
        this.mDownloadListener.add(faceDownloadListener);
    }

    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        HashSet<String> hashSet = this.mDownloadingUrlSet;
        if (hashSet != null) {
            hashSet.clear();
        }
        int i3 = 0;
        while (true) {
            FaceDownloadRunnable[] faceDownloadRunnableArr = this.mDownRunnables;
            if (i3 >= faceDownloadRunnableArr.length) {
                break;
            }
            FaceDownloadRunnable faceDownloadRunnable = faceDownloadRunnableArr[i3];
            if (faceDownloadRunnable != null) {
                faceDownloadRunnable.close();
            }
            i3++;
        }
        ArrayList<FaceInfo> arrayList = this.mRequestQueue;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mRequestQueue.clear();
                this.mRequestQueue.notifyAll();
            }
        }
    }

    protected abstract void doDownloadFace(FaceInfo faceInfo);

    public int downloadData(String str, File file, FaceInfo faceInfo, boolean z16) {
        String str2 = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, str2, file, faceInfo, Boolean.valueOf(z16))).intValue();
        }
        NetworkInfo recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
        if (recentNetworkInfo == null) {
            QLog.i(TAG, 1, "downloadData failed-----------activeNetworkInfo is null");
            return 1;
        }
        try {
            URL url = new URL(str2);
            System.currentTimeMillis();
            Object obj = new Object();
            try {
                getParentFile(file);
                DownloadInfo downloadInfo = new DownloadInfo(str2, null, 0);
                try {
                    try {
                        new HttpGet(str2);
                    } catch (IllegalArgumentException unused) {
                        QLog.d(TAG, 1, "downloadData. result=DOWNLOAD_URL_STRING_ILLEGAL as new HttpGet exception.");
                        downloadInfo.resultCode = 13;
                        return 13;
                    }
                } catch (IllegalArgumentException unused2) {
                    str2 = HttpDownloadUtil.getEscapeSequence(str);
                }
                String str3 = str2;
                File file2 = new File(file.getPath() + ".tmp");
                if (file2.exists()) {
                    file2.delete();
                }
                return realDownloadData(str3, file, faceInfo, z16, recentNetworkInfo, url, 5, obj, 2, null, downloadInfo, file2, -1, null);
            } catch (Exception unused3) {
                QLog.d(TAG, 1, "downloadData. result=DOWNLOAD_SAVE_FILE_FAIL as file exception.");
                return 4;
            }
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return 13;
        }
    }

    public abstract String getChoosedIP();

    public abstract String getChoosedStrangerGroupIp();

    public FaceDownloadThreadInfo getNearbyFaceDownloadThreadInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (FaceDownloadThreadInfo) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        FaceDownloadThreadInfo faceDownloadThreadInfo = new FaceDownloadThreadInfo();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "processor count:" + availableProcessors);
        }
        if (availableProcessors < 4) {
            faceDownloadThreadInfo.maxThreadCount = availableProcessors + 1;
            if (availableProcessors <= 2) {
                faceDownloadThreadInfo.priority = 10;
            }
        }
        return faceDownloadThreadInfo;
    }

    public String getQQHeadDownloadUrl(FaceInfo faceInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, this, faceInfo, Boolean.valueOf(z16));
        }
        if (faceInfo.headType == 116) {
            return getQQHeadDownloadUrlApollo(faceInfo);
        }
        QQHeadInfo qQHeadInfo = faceInfo.mHeadInfo;
        if (qQHeadInfo != null) {
            qQHeadInfo.enableZplanOutbound = faceInfo.isEnableZplanOutbound();
            qQHeadInfo.sizeType = faceInfo.sizeType;
        }
        return MsfSdkUtils.insertMtype("QQHeadIcon", AvatarDownloadUtil.getQQAvatarDownLoadUrl(qQHeadInfo, z16)) + "&t=" + System.currentTimeMillis();
    }

    public String getQQHeadDownloadUrlApollo(FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) faceInfo);
        }
        return faceInfo.mHeadInfo.downLoadUrl + com.tencent.mobileqq.avatar.utils.a.f(faceInfo.sizeType) + "?t=" + faceInfo.mHeadInfo.dwTimestamp;
    }

    protected boolean isIpv6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (!com.tencent.mobileqq.utils.m.a()) {
            return false;
        }
        int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(true);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "isIpv6, getActiveNetIpFamily = " + activeNetIpFamily);
        }
        if (activeNetIpFamily != 2 && activeNetIpFamily != 3) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "iisIpv6, true");
        }
        return true;
    }

    public synchronized void removeFaceDownloadListener(FaceDownloadListener faceDownloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) faceDownloadListener);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "removeFaceDownloadListener l=" + faceDownloadListener);
        }
        this.mDownloadListener.remove(faceDownloadListener);
    }

    public Object[] setHttpConnAndUseProxy(String str, int i3, String str2, boolean z16, int i16, String str3) throws IOException {
        HttpURLConnection httpURLConnection;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Object[]) iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), str2, Boolean.valueOf(z16), Integer.valueOf(i16), str3);
        }
        if (str != null && i3 > 0 && !forceDirect) {
            if (!str2.equals(PkgTools.APN_TYPE_CMWAP) && !str2.equals(PkgTools.APN_TYPE_UNIWAP) && !str2.equals(PkgTools.APN_TYPE_3GWAP)) {
                httpURLConnection = PkgTools.getConnectionWithDefaultProxy(str3, str, i3);
                z16 = true;
            } else {
                if (Math.abs(i16 % 2) == 1 && DPC_WAP_DIRECT_CONNECT == 1) {
                    httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
                    z16 = false;
                } else {
                    httpURLConnection = PkgTools.getConnectionWithXOnlineHost(str3, str, i3);
                    z16 = true;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i(TAG, 4, "downloadData, wapconn, DPC_WAP_DIRECT_CONNECT=" + DPC_WAP_DIRECT_CONNECT + ", tryCount=" + i16);
                }
            }
        } else {
            httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
        }
        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setInstanceFollowRedirects(true);
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            URL url = new URL(str3);
            if (i16 == -1) {
                z17 = true;
            } else {
                z17 = false;
            }
            enableSNI(httpsURLConnection, url, z17);
        }
        return new Object[]{Boolean.valueOf(z16), httpURLConnection};
    }

    public void smartSetThreadCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        int size = this.mRequestQueue.size();
        if (i3 == this.maxThreadCount && this.currThreadCount.get() < this.maxThreadCount && this.mRequestQueue.size() >= this.idleThreadCount.get()) {
            int size2 = ((this.currThreadCount.get() + this.mRequestQueue.size()) - this.idleThreadCount.get()) + 1;
            if (size2 <= 0) {
                size2 = 1;
            }
            int i16 = this.maxThreadCount;
            if (size2 >= i16) {
                size2 = i16;
            }
            try {
                synchronized (this.mDownThreads) {
                    for (int i17 = 0; i17 < size2; i17++) {
                        if (this.mDownThreads[i17] == null) {
                            this.mDownRunnables[i17] = new FaceDownloadRunnable(i17);
                            this.mDownThreads[i17] = ThreadManagerV2.newFreeThread(this.mDownRunnables[i17], "FaceDownloadThread", 5);
                            this.mDownThreads[i17].start();
                            this.currThreadCount.incrementAndGet();
                        }
                    }
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "smartSetThreadCount", th5);
                return;
            }
        }
        FaceDownloadRunnable[] faceDownloadRunnableArr = this.mDownRunnables;
        if (faceDownloadRunnableArr == null || faceDownloadRunnableArr.length <= 0 || faceDownloadRunnableArr[0] == null) {
            QLog.e(TAG, 2, "smartSetThreadCount fail, MAX_THREAD_COUNT=" + this.maxThreadCount + ",newThreadCount=" + i3 + ",currThreadCount=" + this.currThreadCount + ",idleThreadCount=" + this.idleThreadCount + ",queueSize=" + size);
        }
    }
}

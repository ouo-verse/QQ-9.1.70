package com.tencent.mobileqq.transfile;

import android.os.Build;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.StructPicLimitConfigProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.impl.BaseNtHttpAdapter;
import com.tencent.mobileqq.util.cu;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import com.tencent.qqnt.http.api.j;
import com.tencent.qqnt.http.api.m;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import org.apache.http.Header;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes19.dex */
public class HttpDownloader extends AbsDownloader {
    static IPatchRedirector $redirector_ = null;
    private static final int BUFFER_SIZE = 4096;
    public static final int STRUCT_ITEM_COVER = 1001;
    public static final int STRUCT_PIC_LIMIT_ERROR_CODE = 17174;
    public static final String TAG = "HttpDownloader";
    protected AtomicBoolean isCancelled;
    protected boolean mSupportInnerIp;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class StructPicLimitConfigCache {
        static IPatchRedirector $redirector_;
        static final boolean openSwitch;
        static final long picMaxLen;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75986);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                openSwitch = StructPicLimitConfigProcessor.a().f202600a;
                picMaxLen = StructPicLimitConfigProcessor.a().f202601b;
            }
        }

        StructPicLimitConfigCache() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public HttpDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mSupportInnerIp = false;
            this.isCancelled = new AtomicBoolean(false);
        }
    }

    private static int adjustFailCodeByExceptionType(int i3, Exception exc, boolean z16) {
        String message = exc.getMessage();
        if (exc instanceof SocketException) {
            if (exc instanceof ConnectException) {
                return i3 + 10;
            }
            if (exc instanceof NoRouteToHostException) {
                return i3 + 11;
            }
            if (exc instanceof PortUnreachableException) {
                return i3 + 12;
            }
            return i3 + 13;
        }
        if (exc instanceof InterruptedIOException) {
            if (exc instanceof SocketTimeoutException) {
                if (z16) {
                    return i3 + 100;
                }
                return i3 + 101;
            }
            return i3 + 102;
        }
        if (exc instanceof IOException) {
            if (exc instanceof MalformedURLException) {
                return i3 + 200;
            }
            if (exc instanceof UnknownHostException) {
                return i3 + 201;
            }
            if (exc instanceof EOFException) {
                return i3 + 202;
            }
            if (message != null) {
                if (message.contains("unreachable)")) {
                    return i3 + 300;
                }
                if (message.contains("Connection refused")) {
                    return i3 + 301;
                }
                if (message.contains("No route to host")) {
                    if (message.contains("SocketException")) {
                        return i3 + 302;
                    }
                    return i3 + 303;
                }
                if (message.contains("unexpected end of stream")) {
                    return i3 + 304;
                }
                if (message.contains("Connection timed out")) {
                    return i3 + 305;
                }
                if (message.contains("unaccpet content type")) {
                    return i3 + 306;
                }
            }
            return i3 + 307;
        }
        return i3 + 400;
    }

    protected static boolean checkDownloadFileSize(IHttpEngineService iHttpEngineService, URLDrawableHandler uRLDrawableHandler, NetReq netReq, long j3, long j16) {
        boolean z16 = StructPicLimitConfigCache.openSwitch;
        long j17 = StructPicLimitConfigCache.picMaxLen;
        if (!z16 || (j16 <= j17 && j3 <= j17)) {
            return true;
        }
        iHttpEngineService.cancelReq(netReq);
        if (uRLDrawableHandler != null) {
            uRLDrawableHandler.onFileDownloadFailed(STRUCT_PIC_LIMIT_ERROR_CODE);
        }
        QLog.i(TAG, 1, String.format("download file too big, curOffset is %d, totalLen is %d, totalLen is %d", Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17)));
        return false;
    }

    public static void downloadImageByHttpEngine(String str, HttpDownloaderParams httpDownloaderParams, URLDrawableHandler uRLDrawableHandler, int i3) {
        if (MobileQQ.sProcessId == 1) {
            String filePath = AbsDownloader.getFilePath(str);
            if (new File(filePath).exists()) {
                return;
            }
            IHttpEngineService iHttpEngineService = (IHttpEngineService) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IHttpEngineService.class, "all");
            HttpNetReq httpNetReq = new HttpNetReq();
            httpNetReq.mNeedIpConnect = true;
            httpNetReq.mNeedNotReferer = true;
            httpNetReq.mSupportBreakResume = true;
            httpNetReq.mCallback = new INetEngineListener(uRLDrawableHandler, str, httpDownloaderParams) { // from class: com.tencent.mobileqq.transfile.HttpDownloader.1
                static IPatchRedirector $redirector_;
                long fileSize;
                final /* synthetic */ URLDrawableHandler val$handler;
                final /* synthetic */ HttpDownloaderParams val$param;
                final /* synthetic */ String val$url;

                {
                    this.val$handler = uRLDrawableHandler;
                    this.val$url = str;
                    this.val$param = httpDownloaderParams;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, IHttpEngineService.this, uRLDrawableHandler, str, httpDownloaderParams);
                    } else {
                        this.fileSize = 0L;
                    }
                }

                @Override // com.tencent.mobileqq.transfile.INetEngineListener
                public void onResp(NetResp netResp) {
                    boolean z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) netResp);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(HttpDownloader.TAG, 2, " structMsgCover download onResp result fileSize = " + this.fileSize + " file.path = " + netResp.mReq.mOutPath + " resp.result = " + netResp.mResult);
                    }
                    int i16 = netResp.mResult;
                    if (i16 == 3) {
                        return;
                    }
                    if (i16 == 0) {
                        URLDrawableHandler uRLDrawableHandler2 = this.val$handler;
                        if (uRLDrawableHandler2 != null) {
                            uRLDrawableHandler2.onFileDownloadSucceed(this.fileSize);
                        }
                        z16 = true;
                    } else {
                        URLDrawableHandler uRLDrawableHandler3 = this.val$handler;
                        if (uRLDrawableHandler3 != null) {
                            uRLDrawableHandler3.onFileDownloadFailed(i16);
                        }
                        z16 = false;
                    }
                    try {
                        HttpDownloader.reportForStructPicDown(z16, new URL(this.val$url), true, netResp.mHttpCode, netResp.mRedirectCount, null, this.val$param);
                    } catch (Exception unused) {
                    }
                }

                @Override // com.tencent.mobileqq.transfile.INetEngineListener
                public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(HttpDownloader.TAG, 2, " StructPicLimit onUpdateProgeress totalLen = " + j16 + " ,curOffset = " + j3);
                    }
                    this.fileSize = j16;
                    if (!HttpDownloader.checkDownloadFileSize(IHttpEngineService.this, this.val$handler, netReq, j3, j16)) {
                        QLog.i(HttpDownloader.TAG, 2, " StructPicLimit file too big to download, cancel the download req");
                    }
                }
            };
            httpNetReq.mReqUrl = str;
            httpNetReq.mHttpMethod = 0;
            httpNetReq.mOutPath = filePath;
            httpNetReq.mPrioty = 2;
            httpNetReq.mIsPreStructPic = httpDownloaderParams.isPreDownload;
            iHttpEngineService.sendReq(httpNetReq);
        }
    }

    private boolean enableHttp2(DownloadParams downloadParams) {
        Object obj = downloadParams.mExtraInfo;
        if (obj instanceof Bundle) {
            return ((Bundle) obj).getBoolean("enableHttp2");
        }
        return false;
    }

    private void report(DownloadParams downloadParams, boolean z16, URL url, boolean z17, int i3, int i16, IOException iOException) {
        int i17;
        Object obj = downloadParams.mHttpDownloaderParams;
        if (obj != null && (obj instanceof HttpDownloaderParams)) {
            i17 = ((HttpDownloaderParams) obj).businessType;
        } else {
            i17 = 0;
        }
        QLog.d(TAG, 1, "f.businessType =  " + i17 + " success = " + z16 + "config.mHttpDownloaderParams =" + downloadParams.mHttpDownloaderParams);
        if (i17 == 1001) {
            reportForStructPicDown(z16, url, z17, i3, i16, iOException, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void reportForStructPicDown(boolean z16, URL url, boolean z17, int i3, int i16, IOException iOException, HttpDownloaderParams httpDownloaderParams) {
        String str;
        String str2;
        int i17;
        int i18;
        String str3;
        int i19;
        int i26;
        int i27;
        InetAddress byName;
        String url2 = url.toString();
        String host = url.getHost();
        int i28 = 0;
        if (httpDownloaderParams != null) {
            i17 = httpDownloaderParams.param1;
            i18 = httpDownloaderParams.param2;
            str = httpDownloaderParams.param3;
            if (httpDownloaderParams.isPreDownload) {
                str2 = "pre";
            } else {
                str2 = null;
            }
        } else {
            str = "0";
            str2 = null;
            i17 = 0;
            i18 = 0;
        }
        if (!z16) {
            try {
                byName = InetAddress.getByName(host);
            } catch (UnknownHostException unused) {
            }
            if (byName != null) {
                str3 = byName.getHostAddress();
                i19 = i3 * 10000;
                if (i3 == 200) {
                    i26 = 1;
                    if (!cu.e()) {
                        i28 = 1;
                    } else if (cu.b() < 8) {
                        i26 = 2;
                        i28 = 1;
                    }
                    if (iOException != null) {
                        str2 = iOException.getMessage();
                        if (i28 == 0) {
                            i26 = adjustFailCodeByExceptionType(i26, iOException, z17);
                        }
                    }
                    if (i19 >= 0) {
                        i27 = i19 + i26;
                    } else {
                        i27 = i19 - i26;
                    }
                    i28 = i27;
                }
                i26 = 0;
                if (iOException != null) {
                }
                if (i19 >= 0) {
                }
                i28 = i27;
            }
            str3 = null;
            i19 = i3 * 10000;
            if (i3 == 200) {
            }
            i26 = 0;
            if (iOException != null) {
            }
            if (i19 >= 0) {
            }
            i28 = i27;
        } else {
            str3 = null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", String.valueOf(i28));
        hashMap.put("param_Url", url2);
        hashMap.put("serviceId", String.valueOf(i17));
        hashMap.put("templateId", String.valueOf(i18));
        hashMap.put("param_RetryCount", String.valueOf(i16));
        hashMap.put("param_Host", host);
        hashMap.put("param_Address", str3);
        hashMap.put("param_First_Direct_Host", null);
        hashMap.put("param_First_Direct_Address", null);
        hashMap.put("param_Last_Direct_Host", null);
        hashMap.put("param_Last_Direct_Address", null);
        hashMap.put("param_DirectList", "");
        hashMap.put("param_LastDirectUrl", "");
        hashMap.put("param_ErrDesc", str2);
        hashMap.put("uintype", str);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "f =  " + hashMap.toString());
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StructMsgPicDown", z16, 0L, 0L, hashMap, null);
    }

    public static void reportHttpsResult(String str, int i3, int i16, int i17, Exception exc, boolean z16) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        if (exc != null) {
            if (i16 == -1) {
                i16 = adjustFailCodeByExceptionType(20000, exc, z16);
            } else {
                i16 += 10000;
            }
            hashMap.put("ERROR_MSG", exc.getMessage());
        }
        hashMap.put("param_FailCode", String.valueOf(i16));
        hashMap.put("url", "" + str);
        hashMap.put("API_LEVEL", "" + Build.VERSION.SDK_INT);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.HTTPS_DOWNLOAD_FAILED, false, (long) i3, (long) i17, hashMap, "");
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "[reportHttpsResult] url=" + str + " port=" + i3 + " responseCode=" + i16 + " " + i17);
        }
    }

    public static void reportHttpsSniMethod(int i3, String str, int i16, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        hashMap.put("param_FailCode", String.valueOf(i3));
        hashMap.put("host", "" + str);
        hashMap.put("port", "" + i16);
        hashMap.put("businessType", str2);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.HTTPS_SNI_SUPPORT, false, 0L, 0L, hashMap, "");
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "[reportHttpsSniMethod] reflectOrNot=" + i3 + " host=" + str + " " + i16);
        }
    }

    private void writeToFile(InputStream inputStream, long j3, OutputStream outputStream, URLDrawableHandler uRLDrawableHandler) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 4096);
        try {
            byte[] bArr = new byte[4096];
            long j16 = 0;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                j16 += read;
                if (AnimationUtils.currentAnimationTimeMillis() - 0 > 100) {
                    uRLDrawableHandler.publishProgress((int) ((((float) j16) / ((float) j3)) * 9500.0f));
                }
            }
            bufferedInputStream.close();
            if (!this.isCancelled.get()) {
            } else {
                throw new IOException("cancelled");
            }
        } catch (Throwable th5) {
            bufferedInputStream.close();
            throw th5;
        }
    }

    public void cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.isCancelled.set(true);
        }
    }

    protected void copyRespInfo(com.tencent.qqnt.http.api.b bVar, m mVar, URLDrawableHandler uRLDrawableHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, bVar, mVar, uRLDrawableHandler);
        }
    }

    public boolean downByHttpEngine(DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) downloadParams, (Object) uRLDrawableHandler)).booleanValue();
        }
        Object obj = downloadParams.mHttpDownloaderParams;
        if (obj != null && (obj instanceof HttpDownloaderParams)) {
            HttpDownloaderParams httpDownloaderParams = (HttpDownloaderParams) obj;
            if (httpDownloaderParams.businessType == 1001) {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, " structMsgCover download downloadImageByHttpEngine url = " + downloadParams.url.toString());
                    }
                } catch (Exception unused) {
                }
                downloadImageByHttpEngine(downloadParams.url.toString(), httpDownloaderParams, uRLDrawableHandler, 0);
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? downloadImage(outputStream, downloadParams, uRLDrawableHandler, 0, null) : (File) iPatchRedirector.redirect((short) 4, this, outputStream, downloadParams, uRLDrawableHandler);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public File getDownloadFile(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler, int i3, boolean z16, int i16, InputStream inputStream, long j3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (File) iPatchRedirector.redirect((short) 9, this, outputStream, downloadParams, uRLDrawableHandler, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), inputStream, Long.valueOf(j3));
        }
        writeToFile(inputStream, j3, outputStream, uRLDrawableHandler);
        report(downloadParams, true, downloadParams.url, z16, i16, i3, null);
        if ("https".equals(downloadParams.url.getProtocol())) {
            reportHttpsResult(downloadParams.url.getHost(), downloadParams.url.getPort(), i16, i3, null, z16);
        }
        uRLDrawableHandler.onFileDownloadSucceed(j3);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportIOException(DownloadParams downloadParams, int i3, boolean z16, int i16, IOException iOException) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, downloadParams, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), iOException);
            return;
        }
        report(downloadParams, false, downloadParams.url, z16, i16, i3, iOException);
        if ("https".equals(downloadParams.url.getProtocol())) {
            reportHttpsResult(downloadParams.url.getHost(), downloadParams.url.getPort(), i16, i3, iOException, z16);
        }
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return true;
    }

    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler, int i3, URL url) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (File) iPatchRedirector.redirect((short) 6, this, outputStream, downloadParams, uRLDrawableHandler, Integer.valueOf(i3), url);
        }
        boolean z16 = downloadParams.needCheckNetType;
        boolean isMobileNet = URLDrawableHelper.isMobileNet();
        boolean isAutoDownAt2G3GAbled = URLDrawableHelper.isAutoDownAt2G3GAbled(BaseApplication.getContext());
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, " downloadImage url = " + downloadParams.url.toString() + " needCheckNetType:" + z16 + " isMobileNet:" + isMobileNet + "isAutoDownloadAbled:" + isAutoDownAt2G3GAbled);
        }
        if ((downloadParams.needCheckNetType && isMobileNet && !isAutoDownAt2G3GAbled) || downByHttpEngine(downloadParams, uRLDrawableHandler)) {
            return null;
        }
        uRLDrawableHandler.onFileDownloadStarted();
        String replaceIpWithDomain = BaseNtHttpAdapter.INSTANCE.replaceIpWithDomain(TAG, downloadParams.url.toString(), downloadParams.hostForHttpsVerify);
        b.a aVar = new b.a(TAG, replaceIpWithDomain);
        aVar.N(downloadParams.retryCount).h(enableHttp2(downloadParams)).J(outputStream);
        Header[] headerArr = downloadParams.headers;
        if (headerArr != null && headerArr.length > 0) {
            HashMap hashMap = new HashMap();
            for (Header header : downloadParams.headers) {
                hashMap.put(header.getName(), header.getValue());
            }
            aVar.a(hashMap);
        }
        aVar.K(new j(uRLDrawableHandler) { // from class: com.tencent.mobileqq.transfile.HttpDownloader.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ URLDrawableHandler val$handler;

            {
                this.val$handler = uRLDrawableHandler;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HttpDownloader.this, (Object) uRLDrawableHandler);
                }
            }

            @Override // com.tencent.qqnt.http.api.j
            public void onProgress(@NonNull com.tencent.qqnt.http.api.b bVar, long j3, long j16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, bVar, Long.valueOf(j3), Long.valueOf(j16));
                } else if (j3 > 0 && j16 > 0) {
                    this.val$handler.publishProgress((int) ((((float) j3) / ((float) j16)) * 9500.0f));
                }
            }
        });
        com.tencent.qqnt.http.api.b c16 = aVar.c();
        m syncExecute = ((IHttpService) QRoute.api(IHttpService.class)).syncExecute(c16);
        copyRespInfo(c16, syncExecute, uRLDrawableHandler);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" resp.mResult = ");
        sb5.append(syncExecute);
        sb5.append(" file exists: ");
        DiskCache diskCache = AbsDownloader.sDiskCache;
        sb5.append((diskCache == null || diskCache.getDirectory() == null) ? "null" : Boolean.valueOf(new File(AbsDownloader.sDiskCache.getDirectory(), AbsDownloader.getFileName(replaceIpWithDomain) + ".tmp").exists()));
        QLog.i(TAG, 1, sb5.toString());
        if (syncExecute.e()) {
            uRLDrawableHandler.onFileDownloadSucceed(c16.s().d());
            return null;
        }
        uRLDrawableHandler.onFileDownloadFailed(syncExecute.c().intValue());
        throw new IOException(String.valueOf(syncExecute.a()));
    }

    public HttpDownloader(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
            return;
        }
        this.mSupportInnerIp = false;
        this.isCancelled = new AtomicBoolean(false);
        this.mSupportInnerIp = z16;
    }
}

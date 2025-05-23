package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.JobQueue;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.HeadDpcCfg;
import com.tencent.mobileqq.config.ah;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.emoticonview.LooperGifImage;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/* compiled from: P */
/* loaded from: classes19.dex */
public class NearbyImgDownloader extends AbsDownloader {
    static IPatchRedirector $redirector_ = null;
    private static final int BUFFER_SIZE = 32768;
    public static final int DOWNLOAD_MAX_RETRY_TIME = 2;
    public static final String GIF_TYPE = "gif_type";
    public static final String ONESHOT_GIF = "1";
    public static final String TAG = "NearbyImgDownloader";
    public static final int WRITE_MAX_RETRY_TIME = 3;
    private JobQueue mQueue;

    public NearbyImgDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mQueue = new JobQueue(4);
        }
    }

    public static URL convertURL(String str) throws MalformedURLException {
        URL url = new URL(str);
        return new URL(ProtocolDownloaderConstants.PROTOCOL_NEARBY_IMAGE, url.getAuthority(), url.getFile());
    }

    public static List<String> getHostIps(String str) throws MalformedURLException {
        boolean z16;
        int i3;
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean isPreferIpv6 = HeadDpcCfg.get().isPreferIpv6();
            int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(true);
            int i16 = 28;
            if (activeNetIpFamily == 3) {
                InnerDns innerDns = InnerDns.getInstance();
                if (isPreferIpv6) {
                    i3 = 28;
                } else {
                    i3 = 1;
                }
                ArrayList<String> reqDnsForIpList = innerDns.reqDnsForIpList(str, 1001, true, i3);
                if (reqDnsForIpList != null && reqDnsForIpList.size() > 0) {
                    arrayList.add(reqDnsForIpList.get(0));
                }
                InnerDns innerDns2 = InnerDns.getInstance();
                if (isPreferIpv6) {
                    i16 = 1;
                }
                ArrayList<String> reqDnsForIpList2 = innerDns2.reqDnsForIpList(str, 1001, true, i16);
                if (reqDnsForIpList2 != null && reqDnsForIpList2.size() > 0) {
                    arrayList.add(reqDnsForIpList2.get(0));
                }
            } else {
                if (activeNetIpFamily == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                InnerDns innerDns3 = InnerDns.getInstance();
                if (!z16) {
                    i16 = 1;
                }
                ArrayList<String> reqDnsForIpList3 = innerDns3.reqDnsForIpList(str, 1001, true, i16);
                if (reqDnsForIpList3 != null && reqDnsForIpList3.size() > 0) {
                    arrayList.add(reqDnsForIpList3.get(0));
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "convertURL: " + str + " ip_zhitongche cost: " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ipType=" + activeNetIpFamily + " bPrefIpv6=" + isPreferIpv6 + " ips=" + Arrays.toString(arrayList.toArray()));
            }
            if (arrayList.size() == 0 && activeNetIpFamily != 2) {
                String tmp = getTmp(str);
                if (!TextUtils.isEmpty(tmp)) {
                    arrayList.add(tmp);
                }
            }
            if (arrayList.size() < 2) {
                arrayList.add(str);
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "convertURL urlStr end: ips=" + Arrays.toString(arrayList.toArray()));
            }
        }
        return arrayList;
    }

    private static String getTmp(String str) {
        String config = QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_DOWNLOAD_DIRECT_IP);
        if ("p.qpic.cn".equals(str)) {
            return ah.b(2);
        }
        if ("p.qlogo.cn".equals(str)) {
            return ah.b(1);
        }
        if ("ugc.qpic.cn".equals(str)) {
            return ah.d(8, config);
        }
        if (isQQHeadHost(str)) {
            return ah.b(0);
        }
        if ("i.gtimg.cn".equals(str)) {
            return ah.a(FMTSrvAddrProvider.getInstance().getAllIpList(14));
        }
        if ("imgcache.qq.com".equals(str)) {
            return ah.c(FMTSrvAddrProvider.getInstance().getAllIpList(12));
        }
        if (isAQpicCn(str)) {
            return ah.d(9, config);
        }
        if (isQzsQqCom(str)) {
            return ah.d(11, config);
        }
        if (isQzoneStyleGtimgCn(str)) {
            return ah.d(10, config);
        }
        if ("pgdt.gtimg.cn".equals(str)) {
            return ah.b(3);
        }
        if ("sqimg.qq.com".equals(str)) {
            return ah.b(4);
        }
        if ("download.wegame.qq.com".equals(str)) {
            return ah.b(5);
        }
        if ("wfqqreader.3g.qq.com".equals(str)) {
            return ah.b(6);
        }
        if ("buluo.qq.com".equals(str)) {
            return ah.b(7);
        }
        return null;
    }

    public static boolean isAQpicCn(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("a[0-9].qpic.cn").matcher(str).find();
    }

    public static boolean isQQHeadHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^q\\d?.qlogo.cn$").matcher(str).find();
    }

    public static boolean isQzoneStyleGtimgCn(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile(".*qzonestyle.gtimg.cn").matcher(str).find();
    }

    public static boolean isQzsQqCom(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile(".*qzs.qq.com").matcher(str).find();
    }

    private void logDownloadEnd(String str, boolean z16, long j3) {
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "download img end url: " + str + " " + z16 + " " + j3);
                return;
            }
            return;
        }
        QLog.w(TAG, 1, "download img end url: " + str + " " + z16 + " " + j3);
    }

    private void logDownloadStart(String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "download img start url: " + str + " time: " + SystemClock.elapsedRealtime());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean writeToFile(InputStream inputStream, long j3, DiskCache.Editor editor, URLDrawableHandler uRLDrawableHandler) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 32768);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                byte[] bArr = new byte[32768];
                FileOutputStream fileOutputStream2 = new FileOutputStream(editor.dirtyFile, false);
                long j16 = 0;
                while (true) {
                    try {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                        j16 += read;
                        int i3 = (int) ((((float) j16) / ((float) j3)) * 9500.0f);
                        uRLDrawableHandler.publishProgress(i3);
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "NearbyImgDownloader publishProgress: " + i3 + " read len: " + read);
                        }
                    } catch (IOException e16) {
                        e = e16;
                        fileOutputStream = fileOutputStream2;
                        if (QLog.isColorLevel()) {
                            QLog.w(TAG, 2, e.toString());
                        }
                        try {
                            bufferedInputStream.close();
                            fileOutputStream.close();
                            return false;
                        } catch (Exception e17) {
                            if (!QLog.isColorLevel()) {
                                return false;
                            }
                            QLog.w(TAG, 2, e17.toString());
                            return false;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        try {
                            bufferedInputStream.close();
                            fileOutputStream.close();
                        } catch (Exception e18) {
                            if (QLog.isColorLevel()) {
                                QLog.w(TAG, 2, e18.toString());
                            }
                        }
                        throw th;
                    }
                }
                fileOutputStream2.flush();
                try {
                    bufferedInputStream.close();
                    fileOutputStream2.close();
                } catch (Exception e19) {
                    if (QLog.isColorLevel()) {
                        QLog.w(TAG, 2, e19.toString());
                    }
                }
                return true;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e26) {
            e = e26;
        }
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, this, file, downloadParams, uRLDrawableHandler);
        }
        Header header = downloadParams.getHeader(GIF_TYPE);
        if (header != null) {
            String value = header.getValue();
            float f16 = downloadParams.mGifRoundCorner;
            if (!TextUtils.isEmpty(value) && value.equals("1")) {
                return new LooperGifImage(file, true, f16, 1);
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return null;
        }
        return (File) iPatchRedirector.redirect((short) 4, this, outputStream, downloadParams, uRLDrawableHandler);
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public JobQueue getQueue(URL url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JobQueue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
        }
        return this.mQueue;
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader, com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public File loadImageFile(DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloadParams, (Object) uRLDrawableHandler);
        }
        String str = downloadParams.urlStr;
        File file = AbsDownloader.getFile(str);
        if (file != null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "loadImageFile file exist: " + file.getAbsolutePath());
            }
            return file;
        }
        DiskCache.Editor edit = AbsDownloader.sDiskCache.edit(AbsDownloader.getFileName(str));
        try {
            downloadImage(edit, downloadParams, uRLDrawableHandler);
            File file2 = AbsDownloader.getFile(str);
            if (file2 != null) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "loadImageFile f exist:" + file2.getAbsolutePath());
                }
                edit.dirtyFile.delete();
                return file2;
            }
            return edit.commit();
        } catch (Exception e16) {
            if (edit != null) {
                edit.abort(false);
            }
            throw e16;
        }
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c6, code lost:
    
        r29.onFileDownloadFailed(4);
        logDownloadEnd(r28.urlStr, false, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ce, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public File downloadImage(DiskCache.Editor editor, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) {
        URL url;
        long j3;
        BufferedInputStream bufferedInputStream;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (File) iPatchRedirector.redirect((short) 6, this, editor, downloadParams, uRLDrawableHandler);
        }
        logDownloadStart(downloadParams.urlStr);
        uRLDrawableHandler.onFileDownloadStarted();
        boolean z16 = true;
        if (downloadParams.urlStr.startsWith(ProtocolDownloaderConstants.PROTOCOL_NEARBY_LOCAL_IMAGE)) {
            downloadParams.urlStr = downloadParams.urlStr.replaceFirst(ProtocolDownloaderConstants.PROTOCOL_NEARBY_LOCAL_IMAGE, "file");
            File file = new File(downloadParams.url.getFile());
            long j16 = 4;
            if (file.exists() && file.isFile()) {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    i3 = 0;
                } catch (FileNotFoundException e16) {
                    e = e16;
                    j3 = j16;
                }
                while (true) {
                    BufferedInputStream bufferedInputStream2 = bufferedInputStream;
                    int i16 = i3;
                    try {
                    } catch (FileNotFoundException e17) {
                        e = e17;
                        j3 = 4;
                    }
                    if (writeToFile(bufferedInputStream, file.length(), editor, uRLDrawableHandler)) {
                        uRLDrawableHandler.onFileDownloadSucceed(file.length());
                        logDownloadEnd(downloadParams.urlStr, true, file.length());
                        return null;
                    }
                    if (i16 == 3) {
                        uRLDrawableHandler.onFileDownloadFailed(4);
                        j3 = 4;
                        logDownloadEnd(downloadParams.urlStr, false, 4L);
                        return null;
                    }
                    j3 = 4;
                    try {
                        try {
                            LockMethodProxy.sleep(1000L);
                        } catch (InterruptedException unused) {
                        }
                        i3 = i16 + 1;
                        if (i3 > 3) {
                            break;
                        }
                        j16 = 4;
                        bufferedInputStream = bufferedInputStream2;
                    } catch (FileNotFoundException e18) {
                        e = e18;
                    }
                    e = e18;
                    if (QLog.isColorLevel()) {
                        QLog.w(TAG, 2, e.toString());
                    }
                }
            } else {
                uRLDrawableHandler.onFileDownloadFailed(4);
                logDownloadEnd(downloadParams.urlStr, false, 4L);
                return null;
            }
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            try {
                URL url2 = new URL(downloadParams.urlStr);
                String host = url2.getHost();
                arrayList2.add(new BasicHeader("Host", host));
                arrayList.addAll(getHostIps(host));
                long uptimeMillis = SystemClock.uptimeMillis();
                int i17 = 0;
                while (true) {
                    int i18 = i17 + 1;
                    try {
                        url = new URL("http", (String) arrayList.get(arrayList.size() >= i18 ? i18 - 1 : arrayList.size() - (z16 ? 1 : 0)), url2.getFile());
                    } catch (MalformedURLException e19) {
                        QLog.d(TAG, z16 ? 1 : 0, e19.getMessage(), e19);
                        url = null;
                    }
                    if (url != null) {
                        downloadParams.urlStr = url.toString();
                        DownloadInfo queryDownloadInfo = HttpDownloadUtil.queryDownloadInfo(downloadParams.urlStr, new DownloadListener(this, editor, uRLDrawableHandler, downloadParams), arrayList2, 1, false, 10000, 20000);
                        if (queryDownloadInfo.resultCode == 0) {
                            uRLDrawableHandler.onFileDownloadSucceed(queryDownloadInfo.respContentLength);
                            logDownloadEnd(downloadParams.urlStr, z16, queryDownloadInfo.respContentLength);
                            return null;
                        }
                        if (SystemClock.uptimeMillis() - uptimeMillis >= 30000) {
                            QLog.i(TAG, z16 ? 1 : 0, "DownloadFailed, time out, cost=" + (SystemClock.uptimeMillis() - uptimeMillis));
                            uRLDrawableHandler.onFileDownloadFailed(queryDownloadInfo.resultCode);
                            logDownloadEnd(downloadParams.urlStr, false, (long) queryDownloadInfo.resultCode);
                            return null;
                        }
                        if (i18 == 2) {
                            uRLDrawableHandler.onFileDownloadFailed(queryDownloadInfo.resultCode);
                            logDownloadEnd(downloadParams.urlStr, false, queryDownloadInfo.resultCode);
                            return null;
                        }
                        z16 = true;
                        z16 = true;
                        if (i18 == 1) {
                            InnerDns.getInstance().reportBadIp(host, url2.getHost(), 1001);
                        }
                    }
                    if (i18 > 2) {
                        logDownloadEnd(downloadParams.urlStr, false, -1L);
                        return null;
                    }
                    i17 = i18;
                }
            } catch (MalformedURLException e26) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "downloadImage malformedURLException: " + e26.getMessage());
                }
                uRLDrawableHandler.onFileDownloadFailed(13);
                logDownloadEnd(downloadParams.urlStr, false, 13L);
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class DownloadListener implements HttpDownloadUtil.a {
        static IPatchRedirector $redirector_;
        private DownloadParams mDownloadConfig;
        private DiskCache.Editor mEditor;
        private URLDrawableHandler mHandelr;

        public DownloadListener(DiskCache.Editor editor, URLDrawableHandler uRLDrawableHandler) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NearbyImgDownloader.this, editor, uRLDrawableHandler);
            } else {
                this.mEditor = editor;
                this.mHandelr = uRLDrawableHandler;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.tencent.mobileqq.utils.HttpDownloadUtil.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onRespDownloadInfo(DownloadInfo downloadInfo) {
            PicInfo picInfo;
            HttpURLConnection httpURLConnection;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloadInfo)).booleanValue();
            }
            if (downloadInfo.resultCode == 0) {
                DownloadParams downloadParams = this.mDownloadConfig;
                InputStream inputStream = null;
                if (downloadParams != null) {
                    Object obj = downloadParams.mExtraInfo;
                    if (obj instanceof PicInfo) {
                        picInfo = (PicInfo) obj;
                        if (picInfo == null && "type_history_head_pic".equals(picInfo.D) && ((!TextUtils.isEmpty(downloadInfo.respXErrNo) && !downloadInfo.respXErrNo.trim().equals("0")) || (!TextUtils.isEmpty(downloadInfo.respXFailNo) && !downloadInfo.respXFailNo.trim().equals("0")))) {
                            if (QLog.isColorLevel()) {
                                QLog.i(NearbyImgDownloader.TAG, 2, "historhead download fail, url : " + downloadInfo.reqUrl + " respXFailNo: " + downloadInfo.respXFailNo + " respXErrNo: " + downloadInfo.respXErrNo);
                            }
                            downloadInfo.resultCode = 32;
                            return false;
                        }
                        httpURLConnection = downloadInfo.conn;
                        if (httpURLConnection == null) {
                            try {
                                inputStream = httpURLConnection.getInputStream();
                            } catch (IOException e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.w(NearbyImgDownloader.TAG, 2, e16.toString());
                                }
                            }
                            InputStream inputStream2 = inputStream;
                            if (inputStream2 != null) {
                                return NearbyImgDownloader.this.writeToFile(inputStream2, downloadInfo.respContentLength, this.mEditor, this.mHandelr);
                            }
                            downloadInfo.resultCode = 11;
                            return false;
                        }
                        downloadInfo.resultCode = 11;
                    }
                }
                picInfo = null;
                if (picInfo == null) {
                }
                httpURLConnection = downloadInfo.conn;
                if (httpURLConnection == null) {
                }
            }
            return false;
        }

        public DownloadListener(NearbyImgDownloader nearbyImgDownloader, DiskCache.Editor editor, URLDrawableHandler uRLDrawableHandler, DownloadParams downloadParams) {
            this(editor, uRLDrawableHandler);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.mDownloadConfig = downloadParams;
            } else {
                iPatchRedirector.redirect((short) 2, this, nearbyImgDownloader, editor, uRLDrawableHandler, downloadParams);
            }
        }
    }
}

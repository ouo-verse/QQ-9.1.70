package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.downloader.impl.strategy.ExGZIPInputStream;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.cache.file.FileCacheService;
import com.tencent.component.network.module.statistics.SpeedStatistics;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.BytesBufferPool;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.http.HttpUtil;
import com.tencent.component.network.utils.http.PoolingClientConnectionManager;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.SocketException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class DownloadTask implements ThreadPool.Job<DownloadResult>, NetworkManager.NetStatusListener {
    private static final int BYTESBUFFER_POOL_SIZE = 4;
    private static final int BYTESBUFFER_SIZE = 8192;
    private static final String TAG = "DownloadTask";
    protected long mContentLength;
    protected final Context mContext;
    private String mDomain;
    protected DownloadTaskHandler mDownloadTaskHandler;
    private ReportHandler mExternalReportHandler;
    protected Map<String, String> mHttpParams;
    protected boolean mIsHttp2;
    private boolean mNeedMd5;
    private Downloader.NetworkFlowStatistics mNetworkFlowStatistics;
    protected boolean mOriginalIsHttp2;
    private PriorityThreadPool.Priority mPriority;
    private ReportHandler mReportHandler;
    private FileCacheService mTempFileCache;
    private final String mUrl;
    private final String mUrlKey;
    protected IPStrategy pBackupIPConfigStrategy;
    protected IPStrategy pDirectIPConfigStrategy;
    protected QZoneHttpClient pHttpClient;
    protected PortConfigStrategy pPortConfigStrategy;
    protected ResumeTransfer pResumeTransfer;
    protected OkHttpClient pokHttpClient;
    private static final BytesBufferPool sBytesBufferPool = new BytesBufferPool(4, 8192);
    protected static ConcurrentHashMap<String, Integer> map404Urls = new ConcurrentHashMap<>();
    protected static final ThreadLocal<HttpUtil.RequestOptions> sRequestOptions = new ThreadLocal<HttpUtil.RequestOptions>() { // from class: com.tencent.component.network.downloader.impl.DownloadTask.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public HttpUtil.RequestOptions initialValue() {
            return new HttpUtil.RequestOptions();
        }
    };
    private static final Object ConnectionCleanLock = new Object();
    private static volatile long mConnectionCleanTimestamp = System.currentTimeMillis();
    private static volatile int mTotalTaskCount = 0;
    protected final long mTaskStartTimeStamp = System.currentTimeMillis();
    protected int mAttemptTotalCount = 1;
    protected int mAttemptCurrCount = 0;
    protected long mRealFileLength = -1;
    protected DownloadGlobalStrategy.StrategyLib pDownloadStrategyLib = null;
    protected DownloadGlobalStrategy.StrategyInfo pOldStrategyInfo = null;
    protected DownloadGlobalStrategy.StrategyInfo pCurrStrategyInfo = null;
    protected boolean mShouldReport = true;
    private List<ReportHandler.DownloadReportObject> reportList = new ArrayList();
    protected HttpGet request = null;
    protected Request.Builder okRequestBuilder = null;
    protected Call okRequestCall = null;
    protected DownloadRequest downloadRequest = null;
    private float mLastCallbackProgress = 0.0f;
    private float mProgressCallbackStep = 0.0f;
    protected ExtendParam pExtendParam = new ExtendParam();
    protected long t_recv_data = 0;
    protected int mStandardPort = 80;
    protected int attemptStrategyCount = 0;
    protected boolean disableHttps = false;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface DownloadTaskHandler {
        String findCacheEntryPath(String str);

        String generateStorageFileName(String str);

        Proxy getCustomProxy();

        int getHttp2TaskConcurrentCount();

        int getHttpTaskConcurrentCount();

        boolean handleContentType(DownloadResult downloadResult, HttpResponse httpResponse, Response response);

        void handleDownloadProgress(String str, long j3, float f16);

        void handleKeepAliveStrategy(String str, String str2, HttpRequest httpRequest, Request.Builder builder, HttpUtil.RequestOptions requestOptions);

        void handlePrepareRequest(String str, String str2, HttpRequest httpRequest, Request.Builder builder, int i3);

        void handleRequestHeader(String str, int i3, Map<String, List<String>> map);

        void handleStreamDownloadProgress(String str, String str2);

        String prepareRequestUrl(String str);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class ExtendParam {
        public DownloadRequest.OnResponseDataListener onResponseDataListener;

        public ExtendParam() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class TaskHelper {
        private static final Random sRandom = new Random();

        TaskHelper() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x003e, code lost:
        
            if (r4.createNewFile() != false) goto L27;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static synchronized boolean ensureFile(File file, boolean z16) throws IOException {
            synchronized (TaskHelper.class) {
                boolean z17 = false;
                if (file == null) {
                    return false;
                }
                File parentFile = file.getParentFile();
                if (parentFile.exists() && parentFile.isFile()) {
                    FileUtils.delete(parentFile);
                }
                if (!parentFile.exists() && !parentFile.mkdirs()) {
                    return false;
                }
                if (z16 && file.exists()) {
                    FileUtils.delete(file);
                }
                if (!file.exists()) {
                }
                z17 = true;
                return z17;
            }
        }

        public static int generateRandomId(Object... objArr) {
            int i3 = 17;
            if (objArr != null) {
                for (Object obj : objArr) {
                    if (obj != null) {
                        i3 = (i3 * 31) + obj.hashCode();
                    }
                }
            }
            return (i3 * 31) + sRandom.nextInt();
        }
    }

    public DownloadTask(Context context, OkHttpClient okHttpClient, QZoneHttpClient qZoneHttpClient, String str, String str2, boolean z16, boolean z17) {
        PriorityThreadPool.Priority priority;
        AssertUtil.assertTrue(Utils.checkUrl(str));
        this.mContext = context;
        this.mUrl = str;
        this.mUrlKey = TextUtils.isEmpty(str2) ? str : str2;
        this.pokHttpClient = okHttpClient;
        this.pHttpClient = qZoneHttpClient;
        if (z16) {
            priority = PriorityThreadPool.Priority.HIGH;
        } else {
            priority = PriorityThreadPool.Priority.NORMAL;
        }
        setPriority(priority);
        this.mIsHttp2 = z17;
        this.mOriginalIsHttp2 = z17;
    }

    private void flushDownloadReport(ThreadPool.JobContext jobContext) {
        ReportHandler reportHandler;
        if (this.mReportHandler != null && this.reportList.size() > 0) {
            ReportHandler.DownloadReportObject downloadReportObject = this.reportList.get(r0.size() - 1);
            if (downloadReportObject != null) {
                if (((this.mShouldReport && !jobContext.isCancelled()) || downloadReportObject.retCode == 0) && (reportHandler = this.mReportHandler) != null) {
                    reportHandler.uploadReport(downloadReportObject);
                }
            }
        }
    }

    public static int getCurrTotalTaskCount() {
        return mTotalTaskCount;
    }

    private boolean handleContentType(DownloadResult downloadResult, HttpResponse httpResponse, Response response) {
        DownloadTaskHandler downloadTaskHandler = this.mDownloadTaskHandler;
        if (downloadTaskHandler == null) {
            return true;
        }
        return downloadTaskHandler.handleContentType(downloadResult, httpResponse, response);
    }

    private boolean isXiaoMi() {
        String str = Build.BRAND;
        String model = DeviceInfoMonitor.getModel();
        QDLog.i(QDLog.TAG_DOWNLOAD, "brand:" + str + " model:" + model);
        if (model != null && model.startsWith("MI")) {
            return true;
        }
        return false;
    }

    private void notifyStreamDownloadProgress(String str, String str2) {
        DownloadTaskHandler downloadTaskHandler = this.mDownloadTaskHandler;
        if (downloadTaskHandler == null) {
            return;
        }
        downloadTaskHandler.handleStreamDownloadProgress(str, str2);
    }

    private void processReport(ThreadPool.JobContext jobContext, DownloadResult downloadResult) {
        if (downloadResult.getStatus().isFailed()) {
            if (downloadResult.getStatus().getFailException() != null) {
                String stackTraceString = Log.getStackTraceString(downloadResult.getStatus().getFailException());
                if (stackTraceString != null && stackTraceString.contains("refused")) {
                    return;
                }
            } else if (downloadResult.getStatus().getFailException() != null && (downloadResult.getStatus().getFailException() instanceof SocketException)) {
                String stackTraceString2 = Log.getStackTraceString(downloadResult.getStatus().getFailException());
                if (stackTraceString2 != null && stackTraceString2.contains("Permission denied") && isXiaoMi()) {
                    return;
                }
            } else if (404 == downloadResult.getStatus().httpStatus) {
                Integer num = map404Urls.get(this.mUrl);
                if (num == null) {
                    map404Urls.put(this.mUrl, 1);
                    QDLog.i(QDLog.TAG_DOWNLOAD, "save 404 url at first time.");
                } else {
                    map404Urls.put(this.mUrl, Integer.valueOf(num.intValue() + 1));
                    QDLog.i(QDLog.TAG_DOWNLOAD, "save 404 url " + (num.intValue() + 1));
                    return;
                }
            }
        }
        flushDownloadReport(jobContext);
    }

    private void setPriority(PriorityThreadPool.Priority priority) {
        this.mPriority = priority;
    }

    public void abort() {
        if (QDLog.isInfoEnable()) {
            QDLog.i(QDLog.TAG_DOWNLOAD, "downloader abort:" + this.mUrl);
        }
        this.mShouldReport = false;
        HttpGet httpGet = this.request;
        if (httpGet != null) {
            try {
                httpGet.abort();
                return;
            } catch (Exception e16) {
                QDLog.w(QDLog.TAG_DOWNLOAD, "downloader abort Exception", e16);
                return;
            }
        }
        Call call = this.okRequestCall;
        if (call != null) {
            try {
                call.cancel();
            } catch (Exception e17) {
                QDLog.w(QDLog.TAG_DOWNLOAD, "downloader abort Exception", e17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyKeepAliveStrategy(String str, String str2, HttpRequest httpRequest, Request.Builder builder, HttpUtil.RequestOptions requestOptions) {
        DownloadTaskHandler downloadTaskHandler = this.mDownloadTaskHandler;
        if (downloadTaskHandler == null) {
            return;
        }
        downloadTaskHandler.handleKeepAliveStrategy(str, str2, httpRequest, builder, requestOptions);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean canAttempt() {
        int i3 = this.mAttemptCurrCount + 1;
        this.mAttemptCurrCount = i3;
        if (i3 < this.mAttemptTotalCount) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cleanExpireConnection() {
        String str;
        String str2;
        if (this.pHttpClient == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - mConnectionCleanTimestamp;
        if (currentTimeMillis >= 0 && currentTimeMillis < 30000) {
            return;
        }
        synchronized (ConnectionCleanLock) {
            long currentTimeMillis2 = System.currentTimeMillis() - mConnectionCleanTimestamp;
            if (currentTimeMillis2 >= 0 && currentTimeMillis2 < 30000) {
                return;
            }
            ClientConnectionManager connectionManager = this.pHttpClient.getConnectionManager();
            if (connectionManager != null && (connectionManager instanceof PoolingClientConnectionManager)) {
                try {
                    try {
                        ((PoolingClientConnectionManager) connectionManager).closeExpiredConnections();
                        mConnectionCleanTimestamp = System.currentTimeMillis();
                    } catch (Exception unused) {
                        mConnectionCleanTimestamp = System.currentTimeMillis();
                        if (QDLog.isDebugEnable()) {
                            str = QDLog.TAG_DOWNLOAD;
                            str2 = "download cleanExpireConnection.";
                        }
                    }
                    if (QDLog.isDebugEnable()) {
                        str = QDLog.TAG_DOWNLOAD;
                        str2 = "download cleanExpireConnection.";
                        QDLog.d(str, str2);
                    }
                } catch (Throwable th5) {
                    mConnectionCleanTimestamp = System.currentTimeMillis();
                    if (QDLog.isDebugEnable()) {
                        QDLog.d(QDLog.TAG_DOWNLOAD, "download cleanExpireConnection.");
                    }
                    throw th5;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean enableIpv6Debug() {
        try {
            if (new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent", "ipv6_debug.config").exists()) {
                return true;
            }
            return false;
        } catch (Throwable th5) {
            QDLog.w(QDLog.TAG_DOWNLOAD, "enableIpv6Debug exception", th5);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ensureStorageSpace(String str, long j3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!TaskHelper.ensureFile(file, true)) {
                return false;
            }
            this.mTempFileCache.putFile(file.getName());
            if (j3 <= 0) {
                return true;
            }
            while (!file.exists()) {
                file = file.getParentFile();
            }
            StatFs statFs = new StatFs(file.getAbsolutePath());
            if (statFs.getAvailableBlocks() * statFs.getBlockSize() <= j3) {
                return false;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public abstract void execute(ThreadPool.JobContext jobContext, DownloadResult downloadResult);

    /* JADX INFO: Access modifiers changed from: protected */
    public String generateStorageName() {
        String str;
        DownloadTaskHandler downloadTaskHandler = this.mDownloadTaskHandler;
        if (downloadTaskHandler != null) {
            str = downloadTaskHandler.generateStorageFileName(this.mUrl);
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.mUrl)) {
                return UUID.randomUUID().toString();
            }
            return String.valueOf(this.mUrl.hashCode());
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String generateStoragePath(String str) {
        return this.mTempFileCache.getPath(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getContentLength() {
        return this.mContentLength;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getCurrAttemptCount() {
        return this.mAttemptCurrCount;
    }

    public String getDomain() {
        if (this.mDomain == null) {
            this.mDomain = Utils.getDomin(this.mUrl);
        }
        return this.mDomain;
    }

    public DownloadRequest getDownloadRequest() {
        return this.downloadRequest;
    }

    public Map<String, String> getHttpParams() {
        if (this.mHttpParams == null) {
            this.mHttpParams = new HashMap();
        }
        if (!this.mHttpParams.containsKey("refer") && !this.mHttpParams.containsKey("Referer")) {
            this.mHttpParams.put("Referer", Config.getDefaultRefer());
        }
        return this.mHttpParams;
    }

    public PriorityThreadPool.Priority getPriority() {
        return this.mPriority;
    }

    protected long getRealFileLength() {
        return this.mRealFileLength;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRetcode(HttpResponse httpResponse, Response response) {
        List<String> headers;
        long parseLong;
        int i3 = 0;
        if (httpResponse == null && response == null) {
            return 0;
        }
        try {
            if (httpResponse != null) {
                parseLong = Long.parseLong(httpResponse.getFirstHeader("Retcode").getValue());
            } else {
                if (response == null || (headers = response.headers("Retcode")) == null || headers.size() <= 0) {
                    return 0;
                }
                parseLong = Long.parseLong(headers.get(0));
            }
            i3 = (int) parseLong;
            return i3;
        } catch (Exception unused) {
            return i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRetryFlag(HttpResponse httpResponse, Response response) {
        if (httpResponse == null) {
            return -1;
        }
        try {
            return (int) Long.parseLong(httpResponse.getFirstHeader(HttpMsg.XRetryFlag).getValue());
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getSavePath(long j3) {
        String generateStorageName = generateStorageName();
        String generateStoragePath = generateStoragePath(generateStorageName);
        String generateStoragePath2 = generateStoragePath(generateStorageName, false);
        if (ensureStorageSpace(generateStoragePath, j3)) {
            return generateStoragePath;
        }
        if (!TextUtils.equals(generateStoragePath, generateStoragePath2) && ensureStorageSpace(generateStoragePath2, j3)) {
            return generateStoragePath2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getTaskConcurrentCount() {
        DownloadTaskHandler downloadTaskHandler = this.mDownloadTaskHandler;
        if (downloadTaskHandler != null) {
            if (this.mOriginalIsHttp2) {
                return downloadTaskHandler.getHttp2TaskConcurrentCount();
            }
            return downloadTaskHandler.getHttpTaskConcurrentCount();
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getTotalAttemptCount() {
        return this.mAttemptTotalCount;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getUrlKey() {
        return this.mUrlKey;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getXErrorCode(HttpResponse httpResponse, Response response) {
        List<String> headers;
        long parseLong;
        int i3 = 0;
        if (httpResponse == null && response == null) {
            return 0;
        }
        try {
            if (httpResponse != null) {
                parseLong = Long.parseLong(httpResponse.getFirstHeader("X-ErrNo").getValue());
            } else {
                if (response == null || (headers = response.headers("X-ErrNo")) == null || headers.size() <= 0) {
                    return 0;
                }
                parseLong = Long.parseLong(headers.get(0));
            }
            i3 = (int) parseLong;
            return i3;
        } catch (Exception unused) {
            return i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleDownloadReportForTask(ThreadPool.JobContext jobContext, DownloadResult downloadResult, DownloadReport downloadReport) {
        int i3;
        if (this.mExternalReportHandler != null) {
            if (jobContext.isCancelled()) {
                downloadResult.getStatus().state = 4;
            }
            this.mExternalReportHandler.handleReport(downloadResult, downloadReport);
        }
        if (jobContext.isCancelled()) {
            return;
        }
        ReportHandler reportHandler = this.mReportHandler;
        if (reportHandler != null) {
            this.reportList.add(reportHandler.obtainReportObj(downloadResult, downloadReport));
        }
        if (!downloadReport.isSucceed && downloadReport.exception != null && downloadResult != null) {
            if (downloadReport.isFromQzoneAlbum) {
                if (this.mOriginalIsHttp2) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
            } else {
                String str = downloadReport.url;
                if (str != null && str.startsWith("https://")) {
                    i3 = 3;
                } else {
                    i3 = 0;
                }
            }
            Config.reportToLp(i3, downloadReport.isHttp2, downloadReport.url, downloadResult.getStatus().exception2Code, Log.getStackTraceString(downloadReport.exception));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0074 A[Catch: all -> 0x0023, TryCatch #1 {all -> 0x0023, blocks: (B:13:0x001e, B:14:0x002f, B:16:0x003b, B:18:0x0041, B:19:0x0047, B:21:0x004d, B:24:0x0074, B:26:0x007c, B:137:0x0056, B:139:0x005c, B:141:0x0066, B:144:0x0028), top: B:11:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #1 {all -> 0x0023, blocks: (B:13:0x001e, B:14:0x002f, B:16:0x003b, B:18:0x0041, B:19:0x0047, B:21:0x004d, B:24:0x0074, B:26:0x007c, B:137:0x0056, B:139:0x005c, B:141:0x0066, B:144:0x0028), top: B:11:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0167 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean handleHeader(HttpResponse httpResponse, Response response, DownloadResult downloadResult, ThreadPool.JobContext jobContext) {
        HttpEntity httpEntity;
        ResponseBody responseBody;
        long j3;
        String str;
        MediaType mediaType;
        String mediaType2;
        List<String> headers;
        if (httpResponse != null) {
            headerCallback(httpResponse);
        }
        if (response != null) {
            headerCallback(response);
        }
        String str2 = null;
        if (httpResponse != null) {
            httpEntity = httpResponse.getEntity();
        } else {
            httpEntity = null;
        }
        if (response != null) {
            responseBody = response.body();
        } else {
            responseBody = null;
        }
        try {
            if (httpEntity != null) {
                j3 = httpEntity.getContentLength();
            } else if (responseBody != null) {
                j3 = responseBody.getContentLength();
            } else {
                j3 = 0;
            }
            this.mContentLength = j3;
            downloadResult.getContent().length = this.mContentLength;
            if (httpEntity != null) {
                Header contentType = httpEntity.getContentType();
                if (contentType != null) {
                    mediaType2 = contentType.getValue();
                } else {
                    mediaType2 = null;
                }
                Header contentEncoding = httpEntity.getContentEncoding();
                if (contentEncoding != null) {
                    str2 = contentEncoding.getValue();
                }
            } else if (responseBody != null && (mediaType = responseBody.get$contentType()) != null) {
                mediaType2 = mediaType.getMediaType();
                Charset charset = mediaType.charset();
                if (charset != null) {
                    downloadResult.getContent().encoding = charset.name();
                }
            } else {
                str = null;
                if (str2 != null) {
                    downloadResult.getContent().type = str2;
                }
                if (str != null) {
                    downloadResult.getContent().encoding = str;
                }
                if (httpResponse == null) {
                    Header[] allHeaders = httpResponse.getAllHeaders();
                    if (allHeaders != null) {
                        int length = allHeaders.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                break;
                            }
                            if ("Client-Ip".equalsIgnoreCase(allHeaders[i3].getName())) {
                                downloadResult.getContent().clientip = allHeaders[i3].getValue();
                                break;
                            }
                            i3++;
                        }
                    }
                    if (httpResponse.getFirstHeader("Size") != null) {
                        try {
                            this.mRealFileLength = Integer.parseInt(r0.getValue());
                            downloadResult.getContent().realsize = this.mRealFileLength;
                        } catch (Throwable unused) {
                        }
                    } else {
                        this.mRealFileLength = -1L;
                        downloadResult.getContent().realsize = -1L;
                    }
                    Header firstHeader = httpResponse.getFirstHeader("Last-Modified");
                    if (firstHeader != null) {
                        try {
                            downloadResult.getContent().lastModified = firstHeader.getValue();
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                } else if (response != null) {
                    Headers headers2 = response.headers();
                    if (headers2 != null) {
                        int size = headers2.size();
                        int i16 = 0;
                        while (true) {
                            if (i16 >= size) {
                                break;
                            }
                            if ("Client-Ip".equalsIgnoreCase(headers2.name(i16))) {
                                downloadResult.getContent().clientip = headers2.value(i16);
                                break;
                            }
                            i16++;
                        }
                    }
                    if (!TextUtils.isEmpty(response.header("Size"))) {
                        try {
                            this.mRealFileLength = Integer.parseInt(r0);
                            downloadResult.getContent().realsize = this.mRealFileLength;
                        } catch (Throwable unused2) {
                        }
                    } else {
                        this.mRealFileLength = -1L;
                        downloadResult.getContent().realsize = -1L;
                    }
                    List<String> headers3 = response.headers("Last-Modified");
                    if (headers3 != null) {
                        try {
                            if (headers3.size() > 0 && !TextUtils.isEmpty(headers3.get(0))) {
                                downloadResult.getContent().lastModified = headers3.get(0);
                            }
                        } catch (Exception e17) {
                            e17.printStackTrace();
                        }
                    }
                }
                if (!jobContext.isCancelled()) {
                    return false;
                }
                downloadResult.getContent().noCache = false;
                if (httpResponse != null) {
                    HeaderIterator headerIterator = httpResponse.headerIterator("Cache-Control");
                    if (headerIterator != null) {
                        while (true) {
                            if (!headerIterator.hasNext()) {
                                break;
                            }
                            Header nextHeader = headerIterator.nextHeader();
                            if (nextHeader != null && "no-cache".equalsIgnoreCase(nextHeader.getValue())) {
                                downloadResult.getContent().noCache = true;
                                break;
                            }
                        }
                    }
                } else if (response != null && (headers = response.headers("Cache-Control")) != null) {
                    Iterator<String> it = headers.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String next = it.next();
                        if (TextUtils.isEmpty(next) && "no-cache".equalsIgnoreCase(next)) {
                            downloadResult.getContent().noCache = true;
                            break;
                        }
                    }
                }
                if (jobContext.isCancelled()) {
                    return false;
                }
                if (!handleContentType(downloadResult, httpResponse, response)) {
                    downloadResult.getStatus().setFailed(5);
                    return false;
                }
                ResumeTransfer resumeTransfer = this.pResumeTransfer;
                if (resumeTransfer == null || resumeTransfer.handleResponse(this.mUrl, this.mDomain, httpResponse, response)) {
                    return true;
                }
                QDLog.w(QDLog.TAG_DOWNLOAD, "download \u65ad\u7ebf\u7eed\u4f20 response not valid.");
                this.pResumeTransfer.onDownloadResult(this.mUrl, true);
                return false;
            }
            str = str2;
            str2 = mediaType2;
            if (str2 != null) {
            }
            if (str != null) {
            }
            if (httpResponse == null) {
            }
            if (!jobContext.isCancelled()) {
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(42:32|(2:33|34)|(3:273|274|(38:278|37|38|39|40|41|(3:250|251|(2:253|(30:265|248|52|53|54|55|56|(6:226|227|228|229|230|(1:232))(1:58)|59|(14:60|61|62|63|64|(9:66|(9:122|123|124|125|126|(2:139|140)|128|(4:130|131|132|133)(1:138)|134)(1:68)|69|70|71|72|(8:74|75|76|(2:107|108)(1:78)|79|80|81|82)(1:118)|83|84)(1:150)|88|89|(2:102|103)|(2:97|98)|92|(1:94)|95|96)|151|(1:218)(8:154|155|156|157|158|(4:160|161|162|163)(1:211)|164|(1:166)(1:207))|167|(1:169)|171|172|173|174|175|176|177|178|179|180|181|182|(1:184)|(4:186|(2:189|187)|190|191)|192|193)(33:259|260|261|51|52|53|54|55|56|(0)(0)|59|(15:60|61|62|63|64|(0)(0)|88|89|(0)|(0)|92|(0)|95|96|84)|151|(0)|218|167|(0)|171|172|173|174|175|176|177|178|179|180|181|182|(0)|(0)|192|193)))|(1:249)(2:46|(1:247)(31:50|51|52|53|54|55|56|(0)(0)|59|(15:60|61|62|63|64|(0)(0)|88|89|(0)|(0)|92|(0)|95|96|84)|151|(0)|218|167|(0)|171|172|173|174|175|176|177|178|179|180|181|182|(0)|(0)|192|193))|248|52|53|54|55|56|(0)(0)|59|(15:60|61|62|63|64|(0)(0)|88|89|(0)|(0)|92|(0)|95|96|84)|151|(0)|218|167|(0)|171|172|173|174|175|176|177|178|179|180|181|182|(0)|(0)|192|193))|36|37|38|39|40|41|(0)|(1:44)|249|248|52|53|54|55|56|(0)(0)|59|(15:60|61|62|63|64|(0)(0)|88|89|(0)|(0)|92|(0)|95|96|84)|151|(0)|218|167|(0)|171|172|173|174|175|176|177|178|179|180|181|182|(0)|(0)|192|193) */
    /* JADX WARN: Can't wrap try/catch for region: R(43:32|33|34|(3:273|274|(38:278|37|38|39|40|41|(3:250|251|(2:253|(30:265|248|52|53|54|55|56|(6:226|227|228|229|230|(1:232))(1:58)|59|(14:60|61|62|63|64|(9:66|(9:122|123|124|125|126|(2:139|140)|128|(4:130|131|132|133)(1:138)|134)(1:68)|69|70|71|72|(8:74|75|76|(2:107|108)(1:78)|79|80|81|82)(1:118)|83|84)(1:150)|88|89|(2:102|103)|(2:97|98)|92|(1:94)|95|96)|151|(1:218)(8:154|155|156|157|158|(4:160|161|162|163)(1:211)|164|(1:166)(1:207))|167|(1:169)|171|172|173|174|175|176|177|178|179|180|181|182|(1:184)|(4:186|(2:189|187)|190|191)|192|193)(33:259|260|261|51|52|53|54|55|56|(0)(0)|59|(15:60|61|62|63|64|(0)(0)|88|89|(0)|(0)|92|(0)|95|96|84)|151|(0)|218|167|(0)|171|172|173|174|175|176|177|178|179|180|181|182|(0)|(0)|192|193)))|(1:249)(2:46|(1:247)(31:50|51|52|53|54|55|56|(0)(0)|59|(15:60|61|62|63|64|(0)(0)|88|89|(0)|(0)|92|(0)|95|96|84)|151|(0)|218|167|(0)|171|172|173|174|175|176|177|178|179|180|181|182|(0)|(0)|192|193))|248|52|53|54|55|56|(0)(0)|59|(15:60|61|62|63|64|(0)(0)|88|89|(0)|(0)|92|(0)|95|96|84)|151|(0)|218|167|(0)|171|172|173|174|175|176|177|178|179|180|181|182|(0)|(0)|192|193))|36|37|38|39|40|41|(0)|(1:44)|249|248|52|53|54|55|56|(0)(0)|59|(15:60|61|62|63|64|(0)(0)|88|89|(0)|(0)|92|(0)|95|96|84)|151|(0)|218|167|(0)|171|172|173|174|175|176|177|178|179|180|181|182|(0)|(0)|192|193) */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0430, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0431, code lost:
    
        com.tencent.component.network.module.base.QDLog.w(r6, r3, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0423, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0424, code lost:
    
        r6 = r48;
        r3 = r39;
        com.tencent.component.network.module.base.QDLog.w(r6, r3, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x049e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x04a3, code lost:
    
        r6 = r48;
        r5 = "finish write, contentLength:";
        r8 = ", isGzip:";
        r7 = ", writeFileSize:";
        r3 = r39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x04a0, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x04a1, code lost:
    
        r14 = r44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x04d1, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x04d2, code lost:
    
        r3 = "";
        r35 = r12;
        r5 = "finish write, contentLength:";
        r8 = ", isGzip:";
        r7 = ", writeFileSize:";
        r14 = 0;
        r6 = r48;
        r4 = r6;
        r20 = r2;
        r12 = r23;
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x04e9, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x04ea, code lost:
    
        r6 = r48;
        r5 = "finish write, contentLength:";
        r3 = "";
        r35 = r12;
        r8 = ", isGzip:";
        r14 = 0;
        r4 = null;
        r12 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x04fd, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x04fe, code lost:
    
        r6 = r48;
        r5 = "finish write, contentLength:";
        r3 = "";
        r35 = r12;
        r8 = ", isGzip:";
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0526, code lost:
    
        r2 = r0;
        r4 = null;
        r12 = r23;
        r11 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x053a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x038d A[EDGE_INSN: B:150:0x038d->B:151:0x038d BREAK  A[LOOP:0: B:60:0x0293->B:84:0x0364], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0395 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03ed A[Catch: all -> 0x03f7, TRY_LEAVE, TryCatch #12 {all -> 0x03f7, blocks: (B:163:0x03b4, B:164:0x03c9, B:166:0x03cd, B:169:0x03ed), top: B:162:0x03b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0255 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0190 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0545 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleResponse(HttpResponse httpResponse, Response response, DownloadResult downloadResult, ThreadPool.JobContext jobContext, int i3) throws Exception {
        String str;
        String str2;
        String str3;
        long j3;
        long j16;
        String str4;
        String str5;
        Throwable th5;
        FileOutputStream fileOutputStream;
        long j17;
        boolean z16;
        long j18;
        Downloader.NetworkFlowStatistics networkFlowStatistics;
        File file;
        String str6;
        MessageDigest messageDigest;
        InputStream content;
        FileOutputStream fileOutputStream2;
        long j19;
        int i16;
        long j26;
        String str7;
        int read;
        MessageDigest messageDigest2;
        FileOutputStream fileOutputStream3;
        MessageDigest messageDigest3;
        long j27;
        Downloader.NetworkFlowStatistics networkFlowStatistics2;
        InputStream inputStream;
        FileOutputStream fileOutputStream4;
        File file2;
        MessageDigest messageDigest4;
        long j28;
        long realReadLen;
        long j29;
        String str8 = ", writeFileSize:";
        String str9 = "";
        if (!handleHeader(httpResponse, response, downloadResult, jobContext)) {
            return false;
        }
        long defaultMaxDownloadSize = Config.getDefaultMaxDownloadSize();
        if (Config.isEnableMaxDownloadSizeLimit() && defaultMaxDownloadSize > 0 && this.mContentLength > defaultMaxDownloadSize) {
            QDLog.i(TAG, "total size too large, cancel download task, url: " + downloadResult.getUrl() + ", contentLength: " + this.mContentLength + ", maxSizeLimit: " + defaultMaxDownloadSize);
            downloadResult.getStatus().setFailed(8);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z17 = true;
        if (i3 == 206) {
            ResumeTransfer resumeTransfer = this.pResumeTransfer;
            if (resumeTransfer != null && !TextUtils.isEmpty(resumeTransfer.getResumeTmpFile(this.mUrl))) {
                downloadResult.setPath(this.pResumeTransfer.getResumeTmpFile(this.mUrl));
                str = QDLog.TAG_DOWNLOAD;
            } else {
                QDLog.w(QDLog.TAG_DOWNLOAD, "download response 206 but tmp file not exist.");
                return false;
            }
        } else {
            ResumeTransfer resumeTransfer2 = this.pResumeTransfer;
            if (resumeTransfer2 != null && !TextUtils.isEmpty(resumeTransfer2.getResumeTmpFile(this.mUrl)) && i3 == 200) {
                this.pResumeTransfer.onDownloadResult(this.mUrl, true);
            }
            String generateStorageName = generateStorageName();
            String generateStoragePath = generateStoragePath(generateStorageName);
            String generateStoragePath2 = generateStoragePath(generateStorageName, false);
            str = QDLog.TAG_DOWNLOAD;
            if (ensureStorageSpace(generateStoragePath, this.mContentLength)) {
                downloadResult.setPath(generateStoragePath);
            } else if (!TextUtils.equals(generateStoragePath, generateStoragePath2) && ensureStorageSpace(generateStoragePath2, this.mContentLength)) {
                downloadResult.setPath(generateStoragePath2);
            } else {
                downloadResult.getStatus().setFailed(2);
                return false;
            }
            z17 = false;
        }
        BytesBufferPool bytesBufferPool = sBytesBufferPool;
        BytesBufferPool.BytesBuffer bytesBuffer = bytesBufferPool.get();
        boolean z18 = z17;
        long j36 = this.mContentLength;
        long currentTimeMillis2 = System.currentTimeMillis();
        InputStream inputStream2 = null;
        try {
            str6 = str;
            try {
                file = new File(downloadResult.getPath());
                TaskHelper.ensureFile(file, false);
            } catch (Throwable th6) {
                th = th6;
                str2 = "finish write, contentLength:";
                str3 = "";
                j3 = currentTimeMillis;
                j16 = 0;
                str4 = ", isGzip:";
                str5 = str6;
            }
        } catch (Throwable th7) {
            th = th7;
            str2 = "finish write, contentLength:";
            str3 = "";
            j3 = currentTimeMillis;
            j16 = 0;
            str4 = ", isGzip:";
            str5 = str;
        }
        if (jobContext.isCancelled()) {
            this.t_recv_data = System.currentTimeMillis() - currentTimeMillis;
            bytesBufferPool.recycle(bytesBuffer);
            Downloader.NetworkFlowStatistics networkFlowStatistics3 = this.mNetworkFlowStatistics;
            if (networkFlowStatistics3 != null) {
                networkFlowStatistics3.onDownloadFlow(NetworkManager.getApnValue(), 0L, System.currentTimeMillis() - currentTimeMillis2);
            }
            QDLog.i(str6, "finish write, contentLength:" + this.mContentLength + ", writeFileSize:0, isGzip:false");
            return false;
        }
        try {
        } catch (Throwable th8) {
            th = th8;
            str2 = "finish write, contentLength:";
            str3 = "";
            j3 = currentTimeMillis;
            j16 = 0;
            str4 = ", isGzip:";
            str5 = str6;
        }
        if (this.mNeedMd5) {
            try {
            } catch (Throwable th9) {
                th5 = th9;
                str2 = "finish write, contentLength:";
                str3 = "";
                j3 = currentTimeMillis;
                j17 = currentTimeMillis2;
                z16 = false;
                j16 = 0;
                str4 = ", isGzip:";
                j18 = 0;
                str5 = str6;
                fileOutputStream = null;
            }
            if (httpResponse.getFirstHeader("Content-Range") == null || response.headers("Content-Range") == null) {
                messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                downloadResult.getContent().isGzip = false;
                if (httpResponse != null) {
                    try {
                    } catch (Throwable th10) {
                        th5 = th10;
                        str5 = str6;
                        str2 = "finish write, contentLength:";
                        str3 = "";
                        j3 = currentTimeMillis;
                        fileOutputStream = null;
                        j17 = currentTimeMillis2;
                        str4 = ", isGzip:";
                        z16 = false;
                        j16 = 0;
                        j18 = 0;
                        String str10 = str4;
                        this.t_recv_data = System.currentTimeMillis() - j3;
                        if (inputStream2 != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        sBytesBufferPool.recycle(bytesBuffer);
                        networkFlowStatistics = this.mNetworkFlowStatistics;
                        if (networkFlowStatistics != null) {
                        }
                        QDLog.i(str5, str2 + this.mContentLength + str8 + j16 + str10 + z16);
                        throw th5;
                    }
                    if (httpResponse.getEntity() != null) {
                        if (httpResponse.getEntity().getContentEncoding() != null && httpResponse.getEntity().getContentEncoding().getValue() != null && httpResponse.getEntity().getContentEncoding().getValue().toLowerCase().indexOf("gzip") > -1) {
                            content = new ExGZIPInputStream(httpResponse.getEntity().getContent());
                            try {
                                downloadResult.getContent().isGzip = true;
                                z16 = true;
                                fileOutputStream2 = new FileOutputStream(file, z18);
                                long length = file.length();
                                if (downloadResult.getContent() != null) {
                                }
                                j19 = 0;
                                i16 = 0;
                                j26 = 0;
                            } catch (Throwable th11) {
                                th = th11;
                                str5 = str6;
                                str2 = "finish write, contentLength:";
                                str3 = "";
                                j3 = currentTimeMillis;
                                fileOutputStream = null;
                                j17 = currentTimeMillis2;
                                str4 = ", isGzip:";
                                z16 = true;
                                j16 = 0;
                                inputStream2 = content;
                                j18 = 0;
                                th5 = th;
                                String str102 = str4;
                                this.t_recv_data = System.currentTimeMillis() - j3;
                                if (inputStream2 != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                sBytesBufferPool.recycle(bytesBuffer);
                                networkFlowStatistics = this.mNetworkFlowStatistics;
                                if (networkFlowStatistics != null) {
                                }
                                QDLog.i(str5, str2 + this.mContentLength + str8 + j16 + str102 + z16);
                                throw th5;
                            }
                            while (true) {
                                str7 = str9;
                                read = content.read(bytesBuffer.data, i16, 8192 - i16);
                                if (read <= 0) {
                                }
                                th5 = th;
                                String str1022 = str4;
                                this.t_recv_data = System.currentTimeMillis() - j3;
                                if (inputStream2 != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                sBytesBufferPool.recycle(bytesBuffer);
                                networkFlowStatistics = this.mNetworkFlowStatistics;
                                if (networkFlowStatistics != null) {
                                }
                                QDLog.i(str5, str2 + this.mContentLength + str8 + j16 + str1022 + z16);
                                throw th5;
                                fileOutputStream2 = fileOutputStream4;
                                messageDigest = messageDigest4;
                                j26 = j28;
                                str9 = str7;
                                file = file2;
                            }
                            File file3 = file;
                            messageDigest2 = messageDigest;
                            fileOutputStream3 = fileOutputStream2;
                            if (read > 0) {
                            }
                            fileOutputStream = fileOutputStream3;
                            messageDigest3 = messageDigest2;
                            j27 = j19;
                            if (j36 <= 0) {
                            }
                            j19 = j27;
                            downloadResult.getContent().size = j19;
                            this.t_recv_data = System.currentTimeMillis() - j3;
                            content.close();
                            String str11 = str6;
                            String str12 = str7;
                            fileOutputStream.close();
                            sBytesBufferPool.recycle(bytesBuffer);
                            networkFlowStatistics2 = this.mNetworkFlowStatistics;
                            if (networkFlowStatistics2 != null) {
                            }
                            if (messageDigest3 != null) {
                            }
                            QDLog.i(str11, "finish write, contentLength:" + this.mContentLength + ", writeFileSize:" + j26 + ", isGzip:" + z16);
                            return true;
                        }
                        content = httpResponse.getEntity().getContent();
                        z16 = false;
                        fileOutputStream2 = new FileOutputStream(file, z18);
                        long length2 = file.length();
                        if (downloadResult.getContent() != null) {
                            try {
                                j3 = currentTimeMillis;
                            } catch (Throwable th12) {
                                th = th12;
                                j3 = currentTimeMillis;
                            }
                            try {
                                if (downloadResult.getContent().realsize <= 0) {
                                    downloadResult.getContent().realsize = j36 + length2;
                                }
                            } catch (Throwable th13) {
                                th = th13;
                                inputStream2 = content;
                                str3 = "";
                                str2 = "finish write, contentLength:";
                                j17 = currentTimeMillis2;
                                str4 = ", isGzip:";
                                str8 = ", writeFileSize:";
                                j16 = 0;
                                th5 = th;
                                j18 = 0;
                                str5 = str6;
                                fileOutputStream = fileOutputStream2;
                                String str10222 = str4;
                                this.t_recv_data = System.currentTimeMillis() - j3;
                                if (inputStream2 != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                sBytesBufferPool.recycle(bytesBuffer);
                                networkFlowStatistics = this.mNetworkFlowStatistics;
                                if (networkFlowStatistics != null) {
                                }
                                QDLog.i(str5, str2 + this.mContentLength + str8 + j16 + str10222 + z16);
                                throw th5;
                            }
                        } else {
                            j3 = currentTimeMillis;
                        }
                        j19 = 0;
                        i16 = 0;
                        j26 = 0;
                        while (true) {
                            try {
                                str7 = str9;
                            } catch (Throwable th14) {
                                th = th14;
                                fileOutputStream = fileOutputStream2;
                                str3 = str9;
                                str2 = "finish write, contentLength:";
                                str4 = ", isGzip:";
                                str8 = ", writeFileSize:";
                            }
                            try {
                                read = content.read(bytesBuffer.data, i16, 8192 - i16);
                                if (read <= 0) {
                                    break;
                                }
                                i16 += read;
                                if (i16 == 8192) {
                                    try {
                                        inputStream = content;
                                    } catch (Throwable th15) {
                                        th = th15;
                                        inputStream = content;
                                    }
                                    try {
                                        fileOutputStream2.write(bytesBuffer.data, 0, i16);
                                        notifyStreamDownloadProgress(this.mUrlKey, file.getPath());
                                        if (messageDigest != null) {
                                            try {
                                                messageDigest.update(bytesBuffer.data, 0, i16);
                                            } catch (Throwable th16) {
                                                inputStream2 = inputStream;
                                                th5 = th16;
                                                fileOutputStream = fileOutputStream2;
                                                str2 = "finish write, contentLength:";
                                                str4 = ", isGzip:";
                                                str8 = ", writeFileSize:";
                                                str3 = str7;
                                                str5 = str6;
                                                long j37 = j26;
                                                j17 = currentTimeMillis2;
                                                j18 = j19;
                                                j16 = j37;
                                                String str102222 = str4;
                                                this.t_recv_data = System.currentTimeMillis() - j3;
                                                if (inputStream2 != null) {
                                                }
                                                if (fileOutputStream != null) {
                                                }
                                                sBytesBufferPool.recycle(bytesBuffer);
                                                networkFlowStatistics = this.mNetworkFlowStatistics;
                                                if (networkFlowStatistics != null) {
                                                }
                                                QDLog.i(str5, str2 + this.mContentLength + str8 + j16 + str102222 + z16);
                                                throw th5;
                                            }
                                        }
                                        DownloadRequest.OnResponseDataListener onResponseDataListener = this.pExtendParam.onResponseDataListener;
                                        if (onResponseDataListener != null) {
                                            messageDigest4 = messageDigest;
                                            fileOutputStream4 = fileOutputStream2;
                                            try {
                                                file2 = file;
                                                onResponseDataListener.onRecvData(bytesBuffer.data, 0, i16, this.mContentLength, (int) length2, z16);
                                            } catch (Throwable th17) {
                                                th = th17;
                                                inputStream2 = inputStream;
                                                fileOutputStream = fileOutputStream4;
                                                str5 = str6;
                                                th5 = th;
                                                str2 = "finish write, contentLength:";
                                                str4 = ", isGzip:";
                                                str8 = ", writeFileSize:";
                                                str3 = str7;
                                                long j372 = j26;
                                                j17 = currentTimeMillis2;
                                                j18 = j19;
                                                j16 = j372;
                                                String str1022222 = str4;
                                                this.t_recv_data = System.currentTimeMillis() - j3;
                                                if (inputStream2 != null) {
                                                }
                                                if (fileOutputStream != null) {
                                                }
                                                sBytesBufferPool.recycle(bytesBuffer);
                                                networkFlowStatistics = this.mNetworkFlowStatistics;
                                                if (networkFlowStatistics != null) {
                                                }
                                                QDLog.i(str5, str2 + this.mContentLength + str8 + j16 + str1022222 + z16);
                                                throw th5;
                                            }
                                        } else {
                                            file2 = file;
                                            messageDigest4 = messageDigest;
                                            fileOutputStream4 = fileOutputStream2;
                                        }
                                        j26 += i16;
                                        i16 = 0;
                                    } catch (Throwable th18) {
                                        th = th18;
                                        fileOutputStream4 = fileOutputStream2;
                                        inputStream2 = inputStream;
                                        fileOutputStream = fileOutputStream4;
                                        str5 = str6;
                                        th5 = th;
                                        str2 = "finish write, contentLength:";
                                        str4 = ", isGzip:";
                                        str8 = ", writeFileSize:";
                                        str3 = str7;
                                        long j3722 = j26;
                                        j17 = currentTimeMillis2;
                                        j18 = j19;
                                        j16 = j3722;
                                        String str10222222 = str4;
                                        this.t_recv_data = System.currentTimeMillis() - j3;
                                        if (inputStream2 != null) {
                                        }
                                        if (fileOutputStream != null) {
                                        }
                                        sBytesBufferPool.recycle(bytesBuffer);
                                        networkFlowStatistics = this.mNetworkFlowStatistics;
                                        if (networkFlowStatistics != null) {
                                        }
                                        QDLog.i(str5, str2 + this.mContentLength + str8 + j16 + str10222222 + z16);
                                        throw th5;
                                    }
                                } else {
                                    inputStream = content;
                                    file2 = file;
                                    messageDigest4 = messageDigest;
                                    fileOutputStream4 = fileOutputStream2;
                                }
                                j19 += read;
                                try {
                                    downloadResult.getContent().size = j19;
                                    if (j36 > 0) {
                                        content = inputStream;
                                        try {
                                            if (content instanceof ExGZIPInputStream) {
                                                try {
                                                    realReadLen = ((ExGZIPInputStream) content).getRealReadLen();
                                                } catch (Throwable th19) {
                                                    th = th19;
                                                    fileOutputStream = fileOutputStream4;
                                                    str5 = str6;
                                                    inputStream2 = content;
                                                    str2 = "finish write, contentLength:";
                                                    str4 = ", isGzip:";
                                                    str8 = ", writeFileSize:";
                                                    str3 = str7;
                                                    th5 = th;
                                                    long j37222 = j26;
                                                    j17 = currentTimeMillis2;
                                                    j18 = j19;
                                                    j16 = j37222;
                                                    String str102222222 = str4;
                                                    this.t_recv_data = System.currentTimeMillis() - j3;
                                                    if (inputStream2 != null) {
                                                    }
                                                    if (fileOutputStream != null) {
                                                    }
                                                    sBytesBufferPool.recycle(bytesBuffer);
                                                    networkFlowStatistics = this.mNetworkFlowStatistics;
                                                    if (networkFlowStatistics != null) {
                                                    }
                                                    QDLog.i(str5, str2 + this.mContentLength + str8 + j16 + str102222222 + z16);
                                                    throw th5;
                                                }
                                            } else {
                                                realReadLen = j19;
                                            }
                                            j28 = j26;
                                            j29 = j36 + length2;
                                        } catch (Throwable th20) {
                                            th = th20;
                                            j28 = j26;
                                            fileOutputStream = fileOutputStream4;
                                            str5 = str6;
                                            str2 = "finish write, contentLength:";
                                            j17 = currentTimeMillis2;
                                            str4 = ", isGzip:";
                                            str8 = ", writeFileSize:";
                                            str3 = str7;
                                            j18 = j19;
                                            j16 = j28;
                                            inputStream2 = content;
                                            th5 = th;
                                            String str1022222222 = str4;
                                            this.t_recv_data = System.currentTimeMillis() - j3;
                                            if (inputStream2 != null) {
                                            }
                                            if (fileOutputStream != null) {
                                            }
                                            sBytesBufferPool.recycle(bytesBuffer);
                                            networkFlowStatistics = this.mNetworkFlowStatistics;
                                            if (networkFlowStatistics != null) {
                                            }
                                            QDLog.i(str5, str2 + this.mContentLength + str8 + j16 + str1022222222 + z16);
                                            throw th5;
                                        }
                                        try {
                                            notifyDownloadProgress(this.mUrlKey, j29, ((float) (realReadLen + length2)) / ((float) j29));
                                        } catch (Throwable th21) {
                                            th = th21;
                                            fileOutputStream = fileOutputStream4;
                                            str5 = str6;
                                            str2 = "finish write, contentLength:";
                                            j17 = currentTimeMillis2;
                                            str4 = ", isGzip:";
                                            str8 = ", writeFileSize:";
                                            str3 = str7;
                                            j18 = j19;
                                            j16 = j28;
                                            inputStream2 = content;
                                            th5 = th;
                                            String str10222222222 = str4;
                                            this.t_recv_data = System.currentTimeMillis() - j3;
                                            if (inputStream2 != null) {
                                            }
                                            if (fileOutputStream != null) {
                                            }
                                            sBytesBufferPool.recycle(bytesBuffer);
                                            networkFlowStatistics = this.mNetworkFlowStatistics;
                                            if (networkFlowStatistics != null) {
                                            }
                                            QDLog.i(str5, str2 + this.mContentLength + str8 + j16 + str10222222222 + z16);
                                            throw th5;
                                        }
                                    } else {
                                        content = inputStream;
                                        j28 = j26;
                                    }
                                    currentTimeMillis2 = System.currentTimeMillis();
                                    fileOutputStream2 = fileOutputStream4;
                                    messageDigest = messageDigest4;
                                    j26 = j28;
                                    str9 = str7;
                                    file = file2;
                                } catch (Throwable th22) {
                                    th = th22;
                                    content = inputStream;
                                }
                            } catch (Throwable th23) {
                                th = th23;
                                fileOutputStream = fileOutputStream2;
                                str2 = "finish write, contentLength:";
                                str4 = ", isGzip:";
                                str8 = ", writeFileSize:";
                                str3 = str7;
                                str5 = str6;
                                inputStream2 = content;
                                th5 = th;
                                long j372222 = j26;
                                j17 = currentTimeMillis2;
                                j18 = j19;
                                j16 = j372222;
                                String str102222222222 = str4;
                                this.t_recv_data = System.currentTimeMillis() - j3;
                                if (inputStream2 != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                sBytesBufferPool.recycle(bytesBuffer);
                                networkFlowStatistics = this.mNetworkFlowStatistics;
                                if (networkFlowStatistics != null) {
                                }
                                QDLog.i(str5, str2 + this.mContentLength + str8 + j16 + str102222222222 + z16);
                                throw th5;
                            }
                            th5 = th;
                            String str1022222222222 = str4;
                            this.t_recv_data = System.currentTimeMillis() - j3;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Throwable th24) {
                                    QDLog.w(str5, str3, th24);
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th25) {
                                    QDLog.w(str5, str3, th25);
                                }
                            }
                            sBytesBufferPool.recycle(bytesBuffer);
                            networkFlowStatistics = this.mNetworkFlowStatistics;
                            if (networkFlowStatistics != null) {
                                networkFlowStatistics.onDownloadFlow(NetworkManager.getApnValue(), j18, System.currentTimeMillis() - j17);
                            }
                            QDLog.i(str5, str2 + this.mContentLength + str8 + j16 + str1022222222222 + z16);
                            throw th5;
                        }
                        File file32 = file;
                        messageDigest2 = messageDigest;
                        fileOutputStream3 = fileOutputStream2;
                        if (read > 0 && i16 > 0) {
                            try {
                                fileOutputStream = fileOutputStream3;
                            } catch (Throwable th26) {
                                th = th26;
                                fileOutputStream = fileOutputStream3;
                            }
                            try {
                                fileOutputStream.write(bytesBuffer.data, 0, i16);
                                notifyStreamDownloadProgress(this.mUrlKey, file32.getPath());
                                DownloadRequest.OnResponseDataListener onResponseDataListener2 = this.pExtendParam.onResponseDataListener;
                                if (onResponseDataListener2 != null) {
                                    j27 = j19;
                                    try {
                                        onResponseDataListener2.onRecvData(bytesBuffer.data, 0, i16, this.mContentLength, (int) length2, z16);
                                    } catch (Throwable th27) {
                                        th = th27;
                                        str5 = str6;
                                        inputStream2 = content;
                                        j16 = j26;
                                        str2 = "finish write, contentLength:";
                                        j17 = currentTimeMillis2;
                                        str4 = ", isGzip:";
                                        str8 = ", writeFileSize:";
                                        str3 = str7;
                                        j18 = j27;
                                        th5 = th;
                                        String str10222222222222 = str4;
                                        this.t_recv_data = System.currentTimeMillis() - j3;
                                        if (inputStream2 != null) {
                                        }
                                        if (fileOutputStream != null) {
                                        }
                                        sBytesBufferPool.recycle(bytesBuffer);
                                        networkFlowStatistics = this.mNetworkFlowStatistics;
                                        if (networkFlowStatistics != null) {
                                        }
                                        QDLog.i(str5, str2 + this.mContentLength + str8 + j16 + str10222222222222 + z16);
                                        throw th5;
                                    }
                                } else {
                                    j27 = j19;
                                }
                                j26 += i16;
                                if (messageDigest2 != null) {
                                    messageDigest3 = messageDigest2;
                                    messageDigest3.update(bytesBuffer.data, 0, i16);
                                } else {
                                    messageDigest3 = messageDigest2;
                                }
                            } catch (Throwable th28) {
                                th = th28;
                                j27 = j19;
                                str5 = str6;
                                inputStream2 = content;
                                j16 = j26;
                                str2 = "finish write, contentLength:";
                                j17 = currentTimeMillis2;
                                str4 = ", isGzip:";
                                str8 = ", writeFileSize:";
                                str3 = str7;
                                j18 = j27;
                                th5 = th;
                                String str102222222222222 = str4;
                                this.t_recv_data = System.currentTimeMillis() - j3;
                                if (inputStream2 != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                sBytesBufferPool.recycle(bytesBuffer);
                                networkFlowStatistics = this.mNetworkFlowStatistics;
                                if (networkFlowStatistics != null) {
                                }
                                QDLog.i(str5, str2 + this.mContentLength + str8 + j16 + str102222222222222 + z16);
                                throw th5;
                            }
                        } else {
                            fileOutputStream = fileOutputStream3;
                            messageDigest3 = messageDigest2;
                            j27 = j19;
                        }
                        if (j36 <= 0) {
                            notifyDownloadProgress(this.mUrlKey, j36 + length2, 1.0f);
                        }
                        j19 = j27;
                        downloadResult.getContent().size = j19;
                        this.t_recv_data = System.currentTimeMillis() - j3;
                        content.close();
                        String str112 = str6;
                        String str122 = str7;
                        fileOutputStream.close();
                        sBytesBufferPool.recycle(bytesBuffer);
                        networkFlowStatistics2 = this.mNetworkFlowStatistics;
                        if (networkFlowStatistics2 != null) {
                            networkFlowStatistics2.onDownloadFlow(NetworkManager.getApnValue(), j19, System.currentTimeMillis() - currentTimeMillis2);
                        }
                        if (messageDigest3 != null) {
                            byte[] digest = messageDigest3.digest();
                            StringBuilder sb5 = new StringBuilder();
                            for (byte b16 : digest) {
                                sb5.append(Integer.toHexString(b16 & 255));
                            }
                            downloadResult.getContent().md5 = sb5.toString();
                        }
                        QDLog.i(str112, "finish write, contentLength:" + this.mContentLength + ", writeFileSize:" + j26 + ", isGzip:" + z16);
                        return true;
                    }
                }
                if (response == null && response.body() != null) {
                    String header = response.header("Content-Encoding");
                    if (!TextUtils.isEmpty(header) && header.toLowerCase().indexOf("gzip") > -1) {
                        content = new ExGZIPInputStream(response.body().byteStream());
                        z16 = true;
                        fileOutputStream2 = new FileOutputStream(file, z18);
                        long length22 = file.length();
                        if (downloadResult.getContent() != null) {
                        }
                        j19 = 0;
                        i16 = 0;
                        j26 = 0;
                        while (true) {
                            str7 = str9;
                            read = content.read(bytesBuffer.data, i16, 8192 - i16);
                            if (read <= 0) {
                            }
                            th5 = th;
                            String str1022222222222222 = str4;
                            this.t_recv_data = System.currentTimeMillis() - j3;
                            if (inputStream2 != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            sBytesBufferPool.recycle(bytesBuffer);
                            networkFlowStatistics = this.mNetworkFlowStatistics;
                            if (networkFlowStatistics != null) {
                            }
                            QDLog.i(str5, str2 + this.mContentLength + str8 + j16 + str1022222222222222 + z16);
                            throw th5;
                            fileOutputStream2 = fileOutputStream4;
                            messageDigest = messageDigest4;
                            j26 = j28;
                            str9 = str7;
                            file = file2;
                        }
                        File file322 = file;
                        messageDigest2 = messageDigest;
                        fileOutputStream3 = fileOutputStream2;
                        if (read > 0) {
                        }
                        fileOutputStream = fileOutputStream3;
                        messageDigest3 = messageDigest2;
                        j27 = j19;
                        if (j36 <= 0) {
                        }
                        j19 = j27;
                        downloadResult.getContent().size = j19;
                        this.t_recv_data = System.currentTimeMillis() - j3;
                        content.close();
                        String str1122 = str6;
                        String str1222 = str7;
                        fileOutputStream.close();
                        sBytesBufferPool.recycle(bytesBuffer);
                        networkFlowStatistics2 = this.mNetworkFlowStatistics;
                        if (networkFlowStatistics2 != null) {
                        }
                        if (messageDigest3 != null) {
                        }
                        QDLog.i(str1122, "finish write, contentLength:" + this.mContentLength + ", writeFileSize:" + j26 + ", isGzip:" + z16);
                        return true;
                    }
                    content = response.body().byteStream();
                } else {
                    content = null;
                }
                z16 = false;
                fileOutputStream2 = new FileOutputStream(file, z18);
                long length222 = file.length();
                if (downloadResult.getContent() != null) {
                }
                j19 = 0;
                i16 = 0;
                j26 = 0;
                while (true) {
                    str7 = str9;
                    read = content.read(bytesBuffer.data, i16, 8192 - i16);
                    if (read <= 0) {
                    }
                    th5 = th;
                    String str10222222222222222 = str4;
                    this.t_recv_data = System.currentTimeMillis() - j3;
                    if (inputStream2 != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    sBytesBufferPool.recycle(bytesBuffer);
                    networkFlowStatistics = this.mNetworkFlowStatistics;
                    if (networkFlowStatistics != null) {
                    }
                    QDLog.i(str5, str2 + this.mContentLength + str8 + j16 + str10222222222222222 + z16);
                    throw th5;
                    fileOutputStream2 = fileOutputStream4;
                    messageDigest = messageDigest4;
                    j26 = j28;
                    str9 = str7;
                    file = file2;
                }
                File file3222 = file;
                messageDigest2 = messageDigest;
                fileOutputStream3 = fileOutputStream2;
                if (read > 0) {
                }
                fileOutputStream = fileOutputStream3;
                messageDigest3 = messageDigest2;
                j27 = j19;
                if (j36 <= 0) {
                }
                j19 = j27;
                downloadResult.getContent().size = j19;
                this.t_recv_data = System.currentTimeMillis() - j3;
                content.close();
                String str11222 = str6;
                String str12222 = str7;
                fileOutputStream.close();
                sBytesBufferPool.recycle(bytesBuffer);
                networkFlowStatistics2 = this.mNetworkFlowStatistics;
                if (networkFlowStatistics2 != null) {
                }
                if (messageDigest3 != null) {
                }
                QDLog.i(str11222, "finish write, contentLength:" + this.mContentLength + ", writeFileSize:" + j26 + ", isGzip:" + z16);
                return true;
            }
        }
        messageDigest = null;
        downloadResult.getContent().isGzip = false;
        if (httpResponse != null) {
        }
        if (response == null) {
        }
        content = null;
        z16 = false;
        fileOutputStream2 = new FileOutputStream(file, z18);
        long length2222 = file.length();
        if (downloadResult.getContent() != null) {
        }
        j19 = 0;
        i16 = 0;
        j26 = 0;
        while (true) {
            str7 = str9;
            read = content.read(bytesBuffer.data, i16, 8192 - i16);
            if (read <= 0) {
            }
            th5 = th;
            String str102222222222222222 = str4;
            this.t_recv_data = System.currentTimeMillis() - j3;
            if (inputStream2 != null) {
            }
            if (fileOutputStream != null) {
            }
            sBytesBufferPool.recycle(bytesBuffer);
            networkFlowStatistics = this.mNetworkFlowStatistics;
            if (networkFlowStatistics != null) {
            }
            QDLog.i(str5, str2 + this.mContentLength + str8 + j16 + str102222222222222222 + z16);
            throw th5;
            fileOutputStream2 = fileOutputStream4;
            messageDigest = messageDigest4;
            j26 = j28;
            str9 = str7;
            file = file2;
        }
        File file32222 = file;
        messageDigest2 = messageDigest;
        fileOutputStream3 = fileOutputStream2;
        if (read > 0) {
        }
        fileOutputStream = fileOutputStream3;
        messageDigest3 = messageDigest2;
        j27 = j19;
        if (j36 <= 0) {
        }
        j19 = j27;
        downloadResult.getContent().size = j19;
        this.t_recv_data = System.currentTimeMillis() - j3;
        content.close();
        String str112222 = str6;
        String str122222 = str7;
        fileOutputStream.close();
        sBytesBufferPool.recycle(bytesBuffer);
        networkFlowStatistics2 = this.mNetworkFlowStatistics;
        if (networkFlowStatistics2 != null) {
        }
        if (messageDigest3 != null) {
        }
        QDLog.i(str112222, "finish write, contentLength:" + this.mContentLength + ", writeFileSize:" + j26 + ", isGzip:" + z16);
        return true;
    }

    protected void headerCallback(HttpResponse httpResponse) {
        if (httpResponse == null || httpResponse.headerIterator() == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        HeaderIterator headerIterator = httpResponse.headerIterator();
        while (headerIterator.hasNext()) {
            Header nextHeader = headerIterator.nextHeader();
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(nextHeader.getValue());
            hashMap.put(nextHeader.getName(), arrayList);
        }
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        DownloadTaskHandler downloadTaskHandler = this.mDownloadTaskHandler;
        if (downloadTaskHandler != null) {
            downloadTaskHandler.handleRequestHeader(this.mUrlKey, statusCode, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initTask() {
        if (this.mDomain == null) {
            this.mDomain = Utils.getDomin(this.mUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDownloadProgress(String str, long j3, float f16) {
        DownloadTaskHandler downloadTaskHandler = this.mDownloadTaskHandler;
        if (downloadTaskHandler != null && f16 - this.mLastCallbackProgress >= this.mProgressCallbackStep) {
            this.mLastCallbackProgress = f16;
            downloadTaskHandler.handleDownloadProgress(str, j3, f16);
        }
    }

    @Override // com.tencent.component.network.NetworkManager.NetStatusListener
    public void onNetworkChanged(String str, String str2) {
        this.mShouldReport = false;
    }

    public void onTaskDequeue() {
        mTotalTaskCount--;
    }

    public void onTaskEnqueue() {
        mTotalTaskCount++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String parserHttpHeaderInfo(HttpRequest httpRequest, HttpResponse httpResponse, Response response) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<-----Response Headers----->");
        int i3 = 0;
        if (httpResponse != null) {
            stringBuffer.append(httpResponse.getStatusLine());
            stringBuffer.append(";");
            Header[] allHeaders = httpResponse.getAllHeaders();
            if (allHeaders != null) {
                while (i3 < allHeaders.length) {
                    stringBuffer.append(allHeaders[i3].getName());
                    stringBuffer.append(MsgSummary.STR_COLON);
                    stringBuffer.append(allHeaders[i3].getValue());
                    stringBuffer.append(";");
                    i3++;
                }
            }
        } else if (response != null) {
            stringBuffer.append(response.code());
            stringBuffer.append(";");
            Headers headers = response.headers();
            if (headers != null) {
                while (i3 < headers.size()) {
                    stringBuffer.append(headers.name(i3));
                    stringBuffer.append(MsgSummary.STR_COLON);
                    stringBuffer.append(headers.value(i3));
                    stringBuffer.append(";");
                    i3++;
                }
            }
        }
        stringBuffer.append("/*********/");
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void prepareRequest(String str, String str2, HttpRequest httpRequest, Request.Builder builder) {
        if (this.mDownloadTaskHandler == null) {
            return;
        }
        if (getHttpParams() != null && (builder != null || httpRequest != null)) {
            for (Map.Entry<String, String> entry : getHttpParams().entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    if (builder != null) {
                        builder.header(key, value);
                    } else if (httpRequest != null) {
                        httpRequest.addHeader(key, value);
                    }
                }
            }
        }
        this.mDownloadTaskHandler.handlePrepareRequest(str, str2, httpRequest, builder, getCurrAttemptCount());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String prepareUrl(String str) {
        boolean isIpV6Stack = Config.isIpV6Stack();
        if (str != null && !str.startsWith("https:") && this.mIsHttp2 && !isIpV6Stack) {
            str = str.replace("http:", "https:");
        }
        if (str != null && str.startsWith("https:") && this.disableHttps) {
            str = str.replace("https:", "http:");
        }
        DownloadTaskHandler downloadTaskHandler = this.mDownloadTaskHandler;
        if (downloadTaskHandler == null) {
            return str;
        }
        String prepareRequestUrl = downloadTaskHandler.prepareRequestUrl(str);
        if (!TextUtils.isEmpty(prepareRequestUrl)) {
            return prepareRequestUrl;
        }
        return str;
    }

    public void removeHttpParam(String str) {
        if (getHttpParams() != null) {
            getHttpParams().remove(str);
        }
    }

    public void setAttemptCount(int i3) {
        if (i3 < 1) {
            i3 = 1;
        }
        this.mAttemptTotalCount = i3;
    }

    public void setDownloadRequest(DownloadRequest downloadRequest) {
        this.downloadRequest = downloadRequest;
    }

    public void setHandler(DownloadTaskHandler downloadTaskHandler, IPStrategy iPStrategy, IPStrategy iPStrategy2, PortConfigStrategy portConfigStrategy, ResumeTransfer resumeTransfer, ReportHandler reportHandler, ReportHandler reportHandler2, Downloader.NetworkFlowStatistics networkFlowStatistics, FileCacheService fileCacheService) {
        this.mDownloadTaskHandler = downloadTaskHandler;
        this.pResumeTransfer = resumeTransfer;
        this.mReportHandler = reportHandler;
        this.mExternalReportHandler = reportHandler2;
        this.mTempFileCache = fileCacheService;
        this.mNetworkFlowStatistics = networkFlowStatistics;
        this.pDirectIPConfigStrategy = iPStrategy;
        this.pBackupIPConfigStrategy = iPStrategy2;
        this.pPortConfigStrategy = portConfigStrategy;
    }

    public void setHttpParams(Map<String, String> map) {
        this.mHttpParams = map;
    }

    public void setNeedMd5() {
        this.mNeedMd5 = true;
    }

    public void setProgressCallbackStep(float f16) {
        this.mProgressCallbackStep = f16;
    }

    public void setResponseDataListener(DownloadRequest.OnResponseDataListener onResponseDataListener) {
        this.pExtendParam.onResponseDataListener = onResponseDataListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String generateStoragePath(String str, boolean z16) {
        return this.mTempFileCache.getPath(str, z16);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.component.network.utils.thread.ThreadPool.Job
    public final DownloadResult run(ThreadPool.JobContext jobContext) {
        DownloadResult downloadResult = new DownloadResult(this.mUrl);
        if (jobContext.isCancelled()) {
            handleDownloadReportForTask(jobContext, downloadResult, null);
            return downloadResult;
        }
        DownloadTaskHandler downloadTaskHandler = this.mDownloadTaskHandler;
        String findCacheEntryPath = downloadTaskHandler != null ? downloadTaskHandler.findCacheEntryPath(this.mUrl) : null;
        if (!TextUtils.isEmpty(findCacheEntryPath)) {
            if (QDLog.isInfoEnable()) {
                QDLog.i(QDLog.TAG_DOWNLOAD, "find cache entry:" + findCacheEntryPath + " url:" + this.mUrl);
            }
            downloadResult.setPath(findCacheEntryPath);
            downloadResult.getStatus().setSucceed();
            return downloadResult;
        }
        jobContext.setMode(2);
        try {
            initTask();
            NetworkManager.registNetStatusListener(this);
            execute(jobContext, downloadResult);
            if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
                this.mShouldReport = false;
                downloadResult.getStatus().setFailed(6);
            }
            processReport(jobContext, downloadResult);
            onTaskDequeue();
            if (this.pCurrStrategyInfo != null && downloadResult.getStatus().isSucceed()) {
                this.pCurrStrategyInfo.result = downloadResult;
                DownloadGlobalStrategy.getInstance(this.mContext).report(this.mContext, this.mUrl, this.mDomain, this.pCurrStrategyInfo, downloadResult.getStatus().isSucceed());
            } else {
                DownloadGlobalStrategy.StrategyLib strategyLib = this.pDownloadStrategyLib;
                if (strategyLib != null && strategyLib.getBestStrategy() != null) {
                    this.pDownloadStrategyLib.getBestStrategy().result = downloadResult;
                    DownloadGlobalStrategy.getInstance(this.mContext).report(this.mContext, this.mUrl, this.mDomain, this.pDownloadStrategyLib.getBestStrategy(), downloadResult.getStatus().isSucceed());
                }
            }
            if (downloadResult.getStatus().isSucceed()) {
                SpeedStatistics.getInstance().report(downloadResult.getContent().size, downloadResult.getProcess().startTime, downloadResult.getProcess().endTime);
            }
        } finally {
            try {
                return downloadResult;
            } finally {
            }
        }
        return downloadResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void headerCallback(Response response) {
        if (response == null) {
            return;
        }
        int code = response.code();
        Map<String, List<String>> multimap = response.headers().toMultimap();
        DownloadTaskHandler downloadTaskHandler = this.mDownloadTaskHandler;
        if (downloadTaskHandler != null) {
            downloadTaskHandler.handleRequestHeader(this.mUrlKey, code, multimap);
        }
    }
}

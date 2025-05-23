package com.tencent.component.network.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.handler.ContentHandler;
import com.tencent.component.network.downloader.handler.FileHandler;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.downloader.impl.strategy.QzoneResumeTransfer;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.KeepAliveStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.cache.CacheManager;
import com.tencent.component.network.module.cache.file.FileCacheService;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class Downloader {
    protected Context mContext;
    protected IPStrategy pBackupIPConfig;
    protected ContentHandler pContentHandler;
    protected IPStrategy pDirectIPConfig;
    protected ReportHandler pExternalReportHandler;
    protected PriorityThreadPool pExternalThreadPool;
    protected FileHandler pFileHandler;
    protected KeepAliveStrategy pKeepAliveStrategy;
    protected Proxy pMobileProxy;
    protected String pName;
    protected NetworkFlowStatistics pNetworkFlowStatistics;
    protected PortConfigStrategy pPortConfigStrategy;
    protected DownloadPreprocessStrategy pProcessStrategy;
    protected ReportHandler pReportHandler;
    protected ResumeTransfer pResumeTransfer;
    protected FileCacheService pTmpFileCache;
    protected UrlKeyGenerator pUrlKeyGenerator;
    protected DownloadMode pDownloadMode = DownloadMode.FastMode;
    protected int pMaxConnectionPerRoute = 0;
    protected int pMaxConnection = 0;
    protected boolean pHttpsIpDirectEnable = false;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface DownloadListener {
        void onDownloadCanceled(String str);

        void onDownloadFailed(String str, DownloadResult downloadResult);

        void onDownloadProgress(String str, long j3, float f16);

        void onDownloadSucceed(String str, DownloadResult downloadResult);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public enum DownloadMode {
        FastMode,
        StrictMode,
        RangeMode,
        OkHttpMode
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface MiniDownloadListener extends DownloadListener {
        void onDownloadHeadersReceived(String str, int i3, Map<String, List<String>> map);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface NetworkFlowStatistics {
        void onDownloadFlow(String str, long j3, long j16);

        void onUploadFlow(String str, long j3, long j16);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface StreamDownloadListener extends DownloadListener {
        void onStreamDownloadProgress(String str, String str2);
    }

    public Downloader(Context context, String str) {
        this.mContext = null;
        this.mContext = context;
        this.pName = str;
        this.pTmpFileCache = CacheManager.getTmpFileCacheService(context);
    }

    public abstract void abort(String str, DownloadListener downloadListener);

    public abstract void cancel(String str, DownloadListener downloadListener);

    public abstract void cancelAll();

    public abstract void cleanCache();

    public abstract void cleanCache(String str);

    public abstract boolean download(DownloadRequest downloadRequest, boolean z16);

    public final boolean download(String str, String str2, DownloadListener downloadListener) {
        return download(str, str2, true, downloadListener);
    }

    public void enableResumeTransfer() {
        enableResumeTransfer(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String generateStorageName(String str) {
        String generateUrlKey = generateUrlKey(str);
        if (TextUtils.isEmpty(generateUrlKey)) {
            return UUID.randomUUID().toString();
        }
        return String.valueOf(generateUrlKey.hashCode());
    }

    public String generateUrlKey(String str) {
        String doGenerate;
        UrlKeyGenerator urlKeyGenerator = this.pUrlKeyGenerator;
        if (urlKeyGenerator == null) {
            doGenerate = str;
        } else {
            doGenerate = urlKeyGenerator.doGenerate(str);
        }
        if (!TextUtils.isEmpty(doGenerate)) {
            return doGenerate;
        }
        return str;
    }

    public KeepAliveStrategy getKeepAliveStrategy() {
        return this.pKeepAliveStrategy;
    }

    public Proxy getMobileProxy() {
        return this.pMobileProxy;
    }

    public DownloadPreprocessStrategy getPreprocessStrategy() {
        return this.pProcessStrategy;
    }

    public abstract void preConnectHost(ArrayList<String> arrayList, String str);

    public void setBackupIPConfigStrategy(IPStrategy iPStrategy) {
        this.pBackupIPConfig = iPStrategy;
        DownloaderFactory.getInstance(this.mContext).setBackupIPConfigStrategy(iPStrategy);
    }

    public void setContentHandler(ContentHandler contentHandler) {
        this.pContentHandler = contentHandler;
    }

    public void setDirectIPConfigStrategy(IPStrategy iPStrategy) {
        this.pDirectIPConfig = iPStrategy;
        DownloaderFactory.getInstance(this.mContext).setDirectIPConfigStrategy(iPStrategy);
    }

    public void setDownloadMode(DownloadMode downloadMode) {
        this.pDownloadMode = downloadMode;
    }

    public void setExecutor(Executor executor) {
        if (executor == null) {
            this.pExternalThreadPool = null;
        } else {
            this.pExternalThreadPool = new PriorityThreadPool(executor);
        }
    }

    public void setExternalReportHandler(ReportHandler reportHandler) {
        this.pExternalReportHandler = reportHandler;
    }

    public void setFileHandler(FileHandler fileHandler) {
        this.pFileHandler = fileHandler;
    }

    public void setHttpConnectionParam(int i3, int i16) {
        this.pMaxConnectionPerRoute = i3;
        this.pMaxConnection = i16;
    }

    public void setHttpsIpDirectEnable(boolean z16) {
        this.pHttpsIpDirectEnable = z16;
    }

    public void setKeepAliveStrategy(KeepAliveStrategy keepAliveStrategy) {
        this.pKeepAliveStrategy = keepAliveStrategy;
    }

    public void setMobileProxy(Proxy proxy) {
        this.pMobileProxy = proxy;
    }

    public void setNetworkFlowStatistics(NetworkFlowStatistics networkFlowStatistics) {
        this.pNetworkFlowStatistics = networkFlowStatistics;
    }

    public void setPortConfigStrategy(PortConfigStrategy portConfigStrategy) {
        this.pPortConfigStrategy = portConfigStrategy;
        DownloaderFactory.getInstance(this.mContext).setPortStrategy(this.pPortConfigStrategy);
    }

    public void setPreprocessStrategy(DownloadPreprocessStrategy downloadPreprocessStrategy) {
        this.pProcessStrategy = downloadPreprocessStrategy;
    }

    @Deprecated
    public void setReportHandler(ReportHandler reportHandler) {
        this.pReportHandler = reportHandler;
    }

    public void setUrlKeyGenerator(UrlKeyGenerator urlKeyGenerator) {
        this.pUrlKeyGenerator = urlKeyGenerator;
        ResumeTransfer resumeTransfer = this.pResumeTransfer;
        if (resumeTransfer != null) {
            resumeTransfer.setUrlKeyGenerator(urlKeyGenerator);
        }
    }

    public final boolean download(String str, String str2, boolean z16, DownloadListener downloadListener) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return download(str, str2, z16, downloadListener, this.pDownloadMode);
    }

    public void enableResumeTransfer(boolean z16) {
        enableResumeTransfer(z16, null, false);
    }

    public void enableResumeTransfer(boolean z16, String[] strArr, boolean z17) {
        QzoneResumeTransfer qzoneResumeTransfer = new QzoneResumeTransfer(this.mContext, "tmp_" + Utils.getCurrentProcessName(this.mContext) + "_" + this.pName, this.pTmpFileCache, true);
        qzoneResumeTransfer.mForceEnable = z16;
        qzoneResumeTransfer.setUrlKeyGenerator(this.pUrlKeyGenerator);
        if (strArr != null && strArr.length > 0) {
            qzoneResumeTransfer.setSupportDomains(strArr, z17);
        }
        this.pResumeTransfer = qzoneResumeTransfer;
    }

    public final boolean download(String str, String str2, boolean z16, DownloadListener downloadListener, DownloadMode downloadMode) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return download(str, new String[]{str2}, z16, downloadListener, downloadMode);
    }

    public final boolean download(String str, String[] strArr, boolean z16, DownloadListener downloadListener) {
        return download(str, strArr, false, z16, downloadListener, this.pDownloadMode);
    }

    public final boolean download(String str, String[] strArr, boolean z16, DownloadListener downloadListener, DownloadMode downloadMode) {
        return download(str, strArr, false, z16, downloadListener, downloadMode);
    }

    public final boolean download(String str, String[] strArr, boolean z16, boolean z17, DownloadListener downloadListener, DownloadMode downloadMode) {
        return download(str, strArr, z16, z17, downloadListener, downloadMode, null);
    }

    public final boolean download(String str, String[] strArr, boolean z16, boolean z17, DownloadListener downloadListener, DownloadMode downloadMode, DownloadRequest.OnResponseDataListener onResponseDataListener) {
        if (!Utils.checkUrl(str) || strArr == null) {
            return false;
        }
        DownloadRequest downloadRequest = new DownloadRequest(str, strArr, z16, downloadListener);
        downloadRequest.mode = downloadMode;
        downloadRequest.onResponseDataListener = onResponseDataListener;
        return download(downloadRequest, z17);
    }
}

package com.tencent.component.network;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.UrlKeyGenerator;
import com.tencent.component.network.downloader.handler.ContentHandler;
import com.tencent.component.network.downloader.handler.FileHandler;
import com.tencent.component.network.downloader.impl.DownloaderImpl;
import com.tencent.component.network.downloader.impl.ImageDownloaderInitializer;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.base.inter.IDownloadConfig;
import com.tencent.component.network.module.base.inter.Log;
import com.tencent.component.network.module.common.DnsService;
import com.tencent.component.network.utils.StringUtil;
import java.util.concurrent.Executor;
import okhttp3.Response;
import org.apache.http.HttpResponse;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DownloaderFactory {
    private static final byte[] INSTANCE_LOCK = new byte[0];
    private static volatile DownloaderFactory mInstance;
    private Downloader mCommonDownloader;
    private Downloader mImageDownloader;
    private FileHandler mImageFileHandler = new FileHandler() { // from class: com.tencent.component.network.DownloaderFactory.1
        @Override // com.tencent.component.network.downloader.handler.FileHandler
        public boolean handleFile(String str, String str2) {
            return false;
        }
    };
    private PortConfigStrategy mPortConfig;
    protected IPStrategy pBackupIPConfig;
    protected IPStrategy pDirectIPConfig;

    DownloaderFactory(Context context) {
        Global.init(context.getApplicationContext());
    }

    public static Downloader createDownloader(String str) {
        return createDownloader(str, null, null);
    }

    public static Downloader createImageDownloader(String str) {
        return createImageDownloader(str, null, null);
    }

    public static DownloaderFactory getInstance(Context context) {
        if (mInstance == null) {
            synchronized (INSTANCE_LOCK) {
                if (mInstance == null) {
                    mInstance = new DownloaderFactory(context);
                }
            }
        }
        return mInstance;
    }

    public static void init(IDownloadConfig iDownloadConfig, Log log, ISharedPreferencesProvider iSharedPreferencesProvider) {
        Config.setConfig(iDownloadConfig);
        QDLog.setLog(log);
        Global.setSharedPreferencesProvider(iSharedPreferencesProvider);
    }

    public IPStrategy getBackupIpStrategy() {
        return this.pBackupIPConfig;
    }

    public Downloader getCommonDownloader() {
        Downloader downloader = this.mCommonDownloader;
        if (downloader != null) {
            return downloader;
        }
        synchronized (this) {
            Downloader downloader2 = this.mCommonDownloader;
            if (downloader2 != null) {
                return downloader2;
            }
            DownloaderImpl downloaderImpl = new DownloaderImpl(Global.getContext(), "common", 2);
            downloaderImpl.setUrlKeyGenerator(UrlKeyGenerator.GENERATOR_DESPITE_HASH);
            downloaderImpl.enableResumeTransfer();
            this.mCommonDownloader = downloaderImpl;
            return downloaderImpl;
        }
    }

    public IPStrategy getDirectIpStrategy() {
        return this.pDirectIPConfig;
    }

    public Downloader getImageDownloader() {
        Downloader downloader = this.mImageDownloader;
        if (downloader != null) {
            return downloader;
        }
        synchronized (this) {
            Downloader downloader2 = this.mImageDownloader;
            if (downloader2 != null) {
                return downloader2;
            }
            DownloaderImpl downloaderImpl = new DownloaderImpl(Global.getContext(), "image", 1);
            downloaderImpl.setUrlKeyGenerator(UrlKeyGenerator.GENERATOR_DESPITE_HASH);
            downloaderImpl.setFileHandler(this.mImageFileHandler);
            downloaderImpl.enableResumeTransfer();
            downloaderImpl.setContentHandler(new ContentHandler() { // from class: com.tencent.component.network.DownloaderFactory.2
                @Override // com.tencent.component.network.downloader.handler.ContentHandler
                public boolean handleContentType(DownloadResult downloadResult, HttpResponse httpResponse, Response response) {
                    String str = downloadResult.getContent().type;
                    if (TextUtils.isEmpty(str) || !StringUtil.startsWithIgnoreCase(str, "image")) {
                        return false;
                    }
                    return true;
                }
            });
            this.mImageDownloader = downloaderImpl;
            return downloaderImpl;
        }
    }

    public PortConfigStrategy getPortStrategy() {
        return this.mPortConfig;
    }

    public void setBackupIPConfigStrategy(IPStrategy iPStrategy) {
        this.pBackupIPConfig = iPStrategy;
    }

    public void setDirectIPConfigStrategy(IPStrategy iPStrategy) {
        this.pDirectIPConfig = iPStrategy;
    }

    public void setPortStrategy(PortConfigStrategy portConfigStrategy) {
        this.mPortConfig = portConfigStrategy;
    }

    public static Downloader createDownloader(String str, Executor executor, Executor executor2) {
        if (Global.getContext() == null || TextUtils.isEmpty(str)) {
            return null;
        }
        DnsService.getInstance().setThreadPoolExecutor(executor2);
        DownloaderImpl downloaderImpl = new DownloaderImpl(Global.getContext(), str, 2);
        downloaderImpl.setExecutor(executor);
        return downloaderImpl;
    }

    public static Downloader createImageDownloader(String str, Executor executor, Executor executor2) {
        if (Global.getContext() == null || TextUtils.isEmpty(str)) {
            return null;
        }
        DnsService.getInstance().setThreadPoolExecutor(executor2);
        DownloaderImpl downloaderImpl = new DownloaderImpl(Global.getContext(), str, 1);
        downloaderImpl.setExecutor(executor);
        ImageDownloaderInitializer.initImageDownloader(downloaderImpl);
        return downloaderImpl;
    }
}

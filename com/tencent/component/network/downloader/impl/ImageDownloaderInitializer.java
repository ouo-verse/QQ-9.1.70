package com.tencent.component.network.downloader.impl;

import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.handler.ContentHandler;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy;
import com.tencent.component.network.downloader.strategy.KeepAliveStrategy;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.utils.StringUtil;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageDownloaderInitializer {
    private static final char CHAR_EQUALS = '=';
    private static final int IMAGE_URL_KP_ALLOWED = 1;
    public static final int IMAGE_URL_PT_QZONE_ALBUM = 0;

    public static void initImageDownloader(final Downloader downloader) {
        if (downloader == null) {
            return;
        }
        downloader.setPreprocessStrategy(new DownloadPreprocessStrategy() { // from class: com.tencent.component.network.downloader.impl.ImageDownloaderInitializer.1
            @Override // com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy
            public DownloadPreprocessStrategy.DownloadPool downloadPool(String str, String str2) {
                if (Config.shouldUseHttp2(str2)) {
                    return DownloadPreprocessStrategy.DownloadPool.HTTP2;
                }
                if (ImageDownloaderInitializer.isMADomain(str2)) {
                    return DownloadPreprocessStrategy.DownloadPool.SPECIFIC1;
                }
                KeepAliveStrategy keepAliveStrategy = Downloader.this.getKeepAliveStrategy();
                if (keepAliveStrategy != null && keepAliveStrategy.supportKeepAlive(str2)) {
                    return DownloadPreprocessStrategy.DownloadPool.SPECIFIC;
                }
                return DownloadPreprocessStrategy.DownloadPool.COMMON;
            }

            @Override // com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy
            public void prepareRequest(String str, String str2, HttpRequest httpRequest, Request.Builder builder, int i3) {
                if (httpRequest != null && str2 != null && ImageDownloaderInitializer.needCookie(str2)) {
                    httpRequest.addHeader("Cookie", "uin=o" + Config.getCurrentUin() + ";");
                }
            }

            @Override // com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy
            public String prepareUrl(String str) {
                return str;
            }
        });
        downloader.setContentHandler(new ContentHandler() { // from class: com.tencent.component.network.downloader.impl.ImageDownloaderInitializer.2
            @Override // com.tencent.component.network.downloader.handler.ContentHandler
            public boolean handleContentType(DownloadResult downloadResult, HttpResponse httpResponse, Response response) {
                String str = downloadResult.getContent().type;
                if (TextUtils.isEmpty(str) || !StringUtil.startsWithIgnoreCase(str, "image")) {
                    return false;
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isMADomain(String str) {
        try {
            if (!"m.qpic.cn".equalsIgnoreCase(str) && !"a1.qpic.cn".equalsIgnoreCase(str) && !"a2.qpic.cn".equalsIgnoreCase(str) && !"a3.qpic.cn".equalsIgnoreCase(str)) {
                if (!"a4.qpic.cn".equalsIgnoreCase(str)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean needCookie(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.endsWith("photo.store.qq.com") && !str.endsWith("qpic.cn")) {
            return false;
        }
        return true;
    }
}

package com.tencent.component.network.downloader.handler;

import com.tencent.component.network.downloader.DownloadResult;
import okhttp3.Response;
import org.apache.http.HttpResponse;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface ContentHandler {
    boolean handleContentType(DownloadResult downloadResult, HttpResponse httpResponse, Response response);
}

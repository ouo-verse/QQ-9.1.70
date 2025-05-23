package com.tencent.component.network.downloader.strategy;

import com.tencent.component.network.downloader.UrlKeyGenerator;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface ResumeTransfer {
    void addCacheTmpFile(String str, String str2, HttpResponse httpResponse, Response response);

    void cleanCache();

    void cleanCache(String str);

    String getResumeTmpFile(String str);

    boolean handleResponse(String str, String str2, HttpResponse httpResponse, Response response);

    void onDownloadResult(String str, boolean z16);

    void prepareRequest(HttpGet httpGet, Request.Builder builder, String str, String str2);

    void setSupportDomains(String[] strArr, boolean z16);

    void setUrlKeyGenerator(UrlKeyGenerator urlKeyGenerator);
}

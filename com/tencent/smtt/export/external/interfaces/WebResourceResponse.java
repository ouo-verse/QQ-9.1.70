package com.tencent.smtt.export.external.interfaces;

import java.io.InputStream;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WebResourceResponse {
    private String mEncoding;
    private InputStream mInputStream;
    private String mMimeType;
    private String mReasonPhrase;
    private Map<String, String> mResponseHeaders;
    private int mStatusCode;

    public WebResourceResponse() {
    }

    public InputStream getData() {
        return this.mInputStream;
    }

    public String getEncoding() {
        return this.mEncoding;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public String getReasonPhrase() {
        return this.mReasonPhrase;
    }

    public Map<String, String> getResponseHeaders() {
        return this.mResponseHeaders;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public void setData(InputStream inputStream) {
        this.mInputStream = inputStream;
    }

    public void setEncoding(String str) {
        this.mEncoding = str;
    }

    public void setMimeType(String str) {
        this.mMimeType = str;
    }

    public void setResponseHeaders(Map<String, String> map) {
        this.mResponseHeaders = map;
    }

    public void setStatusCodeAndReasonPhrase(int i3, String str) {
        this.mStatusCode = i3;
        this.mReasonPhrase = str;
    }

    public WebResourceResponse(String str, String str2, InputStream inputStream) {
        this.mMimeType = str;
        this.mEncoding = str2;
        setData(inputStream);
    }

    public WebResourceResponse(String str, String str2, int i3, String str3, Map<String, String> map, InputStream inputStream) {
        this(str, str2, inputStream);
        setStatusCodeAndReasonPhrase(i3, str3);
        setResponseHeaders(map);
    }
}

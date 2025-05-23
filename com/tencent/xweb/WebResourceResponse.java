package com.tencent.xweb;

import java.io.InputStream;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebResourceResponse {

    /* renamed from: a, reason: collision with root package name */
    public String f384986a;

    /* renamed from: b, reason: collision with root package name */
    public String f384987b;

    /* renamed from: c, reason: collision with root package name */
    public int f384988c;

    /* renamed from: d, reason: collision with root package name */
    public String f384989d;

    /* renamed from: e, reason: collision with root package name */
    public Map f384990e;

    /* renamed from: f, reason: collision with root package name */
    public InputStream f384991f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f384992g;

    public WebResourceResponse(String str, String str2, InputStream inputStream) {
        this.f384988c = 200;
        this.f384992g = false;
        this.f384986a = str;
        this.f384987b = str2;
        setData(inputStream);
        this.f384992g = false;
    }

    public InputStream getData() {
        return this.f384991f;
    }

    public String getEncoding() {
        return this.f384987b;
    }

    public String getMimeType() {
        return this.f384986a;
    }

    public String getReasonPhrase() {
        return this.f384989d;
    }

    public Map<String, String> getResponseHeaders() {
        return this.f384990e;
    }

    public int getStatusCode() {
        return this.f384988c;
    }

    public boolean isCreateFromComplexConstruct() {
        return this.f384992g;
    }

    public void setData(InputStream inputStream) {
        this.f384991f = inputStream;
    }

    public void setEncoding(String str) {
        this.f384987b = str;
    }

    public void setMimeType(String str) {
        this.f384986a = str;
    }

    public void setResponseHeaders(Map<String, String> map) {
        this.f384990e = map;
    }

    public void setStatusCodeAndReasonPhrase(int i3, String str) {
        this.f384988c = i3;
        this.f384989d = str;
    }

    public WebResourceResponse(String str, String str2, int i3, String str3, Map<String, String> map, InputStream inputStream) {
        this(str, str2, inputStream);
        setStatusCodeAndReasonPhrase(i3, str3);
        setResponseHeaders(map);
        this.f384992g = true;
    }
}

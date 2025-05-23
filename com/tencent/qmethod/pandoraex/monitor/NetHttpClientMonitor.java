package com.tencent.qmethod.pandoraex.monitor;

import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.Header;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.RequestLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* compiled from: P */
/* loaded from: classes22.dex */
public class NetHttpClientMonitor {
    private static final String TAG = "NetHttpClientMonitor";

    public static HttpResponse execute(Object obj, HttpUriRequest httpUriRequest) throws IOException {
        if (!(obj instanceof HttpClient)) {
            return (HttpResponse) com.tencent.qmethod.pandoraex.core.t.b(obj, "execute", new Class[]{HttpUriRequest.class}, httpUriRequest);
        }
        HttpClient httpClient = (HttpClient) obj;
        try {
            if (com.tencent.qmethod.pandoraex.core.ext.netcap.k.k(httpUriRequest.getURI().getHost(), 1)) {
                com.tencent.qmethod.pandoraex.core.ext.netcap.d dVar = new com.tencent.qmethod.pandoraex.core.ext.netcap.d();
                HttpResponse execute = httpClient.execute(handleRequest(httpUriRequest, dVar));
                handleResponse(execute, dVar);
                return execute;
            }
        } catch (Throwable th5) {
            com.tencent.qmethod.pandoraex.core.o.b(TAG, "", th5);
        }
        return httpClient.execute(httpUriRequest);
    }

    private static HttpUriRequest handleRequest(HttpUriRequest httpUriRequest, com.tencent.qmethod.pandoraex.core.ext.netcap.d dVar) {
        dVar.b(httpUriRequest.getURI().toString());
        dVar.f344084b = httpUriRequest.getMethod();
        for (Header header : httpUriRequest.getAllHeaders()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(header.getValue());
            dVar.f344086d.put(header.getName(), arrayList);
        }
        if (httpUriRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntityEnclosingRequest httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpUriRequest;
            if (httpEntityEnclosingRequest.getEntity() != null) {
                httpEntityEnclosingRequest.setEntity(new com.tencent.qmethod.pandoraex.core.ext.netcap.e(httpEntityEnclosingRequest.getEntity(), dVar));
            }
            return (HttpUriRequest) httpEntityEnclosingRequest;
        }
        dVar.a();
        return httpUriRequest;
    }

    private static HttpResponse handleResponse(HttpResponse httpResponse, com.tencent.qmethod.pandoraex.core.ext.netcap.d dVar) {
        Header[] headers = httpResponse.getHeaders("Content-Length");
        if (headers != null && headers.length > 0) {
            try {
                Long.parseLong(headers[0].getValue());
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        } else if (httpResponse.getEntity() != null) {
            httpResponse.setEntity(new com.tencent.qmethod.pandoraex.core.ext.netcap.f(httpResponse.getEntity(), dVar));
        }
        return httpResponse;
    }

    public static HttpResponse execute(Object obj, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        if (!(obj instanceof HttpClient)) {
            return (HttpResponse) com.tencent.qmethod.pandoraex.core.t.b(obj, "execute", new Class[]{HttpHost.class, HttpRequest.class, HttpContext.class}, httpHost, httpRequest, httpContext);
        }
        HttpClient httpClient = (HttpClient) obj;
        try {
            if (com.tencent.qmethod.pandoraex.core.ext.netcap.k.k(httpHost.getHostName(), 1)) {
                com.tencent.qmethod.pandoraex.core.ext.netcap.d dVar = new com.tencent.qmethod.pandoraex.core.ext.netcap.d();
                HttpResponse execute = httpClient.execute(httpHost, handleRequest(httpHost, httpRequest, dVar), httpContext);
                handleResponse(execute, dVar);
                return execute;
            }
        } catch (Throwable th5) {
            com.tencent.qmethod.pandoraex.core.o.b(TAG, "", th5);
        }
        return httpClient.execute(httpHost, httpRequest);
    }

    private static HttpRequest handleRequest(HttpHost httpHost, HttpRequest httpRequest, com.tencent.qmethod.pandoraex.core.ext.netcap.d dVar) {
        RequestLine requestLine = httpRequest.getRequestLine();
        String str = "";
        if (requestLine != null) {
            String uri = requestLine.getUri();
            boolean z16 = uri != null && uri.length() >= 10 && uri.substring(0, 10).indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER) >= 0;
            if (!z16 && uri != null && httpHost != null) {
                String str2 = httpHost.toURI().toString();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str2);
                if (!str2.endsWith("/") && !uri.startsWith("/")) {
                    str = "/";
                }
                sb5.append(str);
                sb5.append(uri);
                str = sb5.toString();
            } else if (z16) {
                str = uri;
            }
        }
        dVar.b(str);
        dVar.f344084b = httpRequest.getRequestLine().getMethod();
        for (Header header : httpRequest.getAllHeaders()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(header.getValue());
            dVar.f344086d.put(header.getName(), arrayList);
        }
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntityEnclosingRequest httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpRequest;
            if (httpEntityEnclosingRequest.getEntity() != null) {
                httpEntityEnclosingRequest.setEntity(new com.tencent.qmethod.pandoraex.core.ext.netcap.e(httpEntityEnclosingRequest.getEntity(), dVar));
            }
            return httpEntityEnclosingRequest;
        }
        dVar.a();
        return httpRequest;
    }

    public static <T> T execute(Object obj, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        if (!(obj instanceof HttpClient)) {
            return (T) com.tencent.qmethod.pandoraex.core.t.b(obj, "execute", new Class[]{HttpHost.class, HttpRequest.class, ResponseHandler.class, HttpContext.class}, httpHost, httpRequest, responseHandler, httpContext);
        }
        HttpClient httpClient = (HttpClient) obj;
        try {
            if (com.tencent.qmethod.pandoraex.core.ext.netcap.k.k(httpHost.getHostName(), 1)) {
                com.tencent.qmethod.pandoraex.core.ext.netcap.d dVar = new com.tencent.qmethod.pandoraex.core.ext.netcap.d();
                return (T) httpClient.execute(httpHost, handleRequest(httpHost, httpRequest, dVar), com.tencent.qmethod.pandoraex.core.ext.netcap.g.a(responseHandler, dVar), httpContext);
            }
        } catch (Throwable th5) {
            com.tencent.qmethod.pandoraex.core.o.b(TAG, "", th5);
        }
        return (T) httpClient.execute(httpHost, httpRequest, responseHandler, httpContext);
    }

    public static <T> T execute(Object obj, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        if (!(obj instanceof HttpClient)) {
            return (T) com.tencent.qmethod.pandoraex.core.t.b(obj, "execute", new Class[]{HttpHost.class, HttpRequest.class, ResponseHandler.class}, httpHost, httpRequest, responseHandler);
        }
        HttpClient httpClient = (HttpClient) obj;
        try {
            if (com.tencent.qmethod.pandoraex.core.ext.netcap.k.k(httpHost.getHostName(), 1)) {
                com.tencent.qmethod.pandoraex.core.ext.netcap.d dVar = new com.tencent.qmethod.pandoraex.core.ext.netcap.d();
                return (T) httpClient.execute(httpHost, handleRequest(httpHost, httpRequest, dVar), com.tencent.qmethod.pandoraex.core.ext.netcap.g.a(responseHandler, dVar));
            }
        } catch (Throwable th5) {
            com.tencent.qmethod.pandoraex.core.o.b(TAG, "", th5);
        }
        return (T) httpClient.execute(httpHost, httpRequest, responseHandler);
    }

    public static HttpResponse execute(Object obj, HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        if (!(obj instanceof HttpClient)) {
            return (HttpResponse) com.tencent.qmethod.pandoraex.core.t.b(obj, "execute", new Class[]{HttpHost.class, HttpRequest.class}, httpHost, httpRequest);
        }
        HttpClient httpClient = (HttpClient) obj;
        try {
            if (com.tencent.qmethod.pandoraex.core.ext.netcap.k.k(httpHost.getHostName(), 1)) {
                return httpClient.execute(httpHost, handleRequest(httpHost, httpRequest, new com.tencent.qmethod.pandoraex.core.ext.netcap.d()));
            }
        } catch (Throwable th5) {
            com.tencent.qmethod.pandoraex.core.o.b(TAG, "", th5);
        }
        return httpClient.execute(httpHost, httpRequest);
    }

    public static HttpResponse execute(Object obj, HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        if (!(obj instanceof HttpClient)) {
            return (HttpResponse) com.tencent.qmethod.pandoraex.core.t.b(obj, "execute", new Class[]{HttpUriRequest.class, HttpContext.class}, httpUriRequest, httpContext);
        }
        HttpClient httpClient = (HttpClient) obj;
        try {
            if (com.tencent.qmethod.pandoraex.core.ext.netcap.k.k(httpUriRequest.getURI().getHost(), 1)) {
                return httpClient.execute(handleRequest(httpUriRequest, new com.tencent.qmethod.pandoraex.core.ext.netcap.d()), httpContext);
            }
        } catch (Throwable th5) {
            com.tencent.qmethod.pandoraex.core.o.b(TAG, "", th5);
        }
        return httpClient.execute(httpUriRequest, httpContext);
    }

    public static <T> T execute(Object obj, HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        if (!(obj instanceof HttpClient)) {
            return (T) com.tencent.qmethod.pandoraex.core.t.b(obj, "execute", new Class[]{HttpUriRequest.class, ResponseHandler.class, HttpContext.class}, httpUriRequest, responseHandler, httpContext);
        }
        HttpClient httpClient = (HttpClient) obj;
        try {
            if (com.tencent.qmethod.pandoraex.core.ext.netcap.k.k(httpUriRequest.getURI().getHost(), 1)) {
                com.tencent.qmethod.pandoraex.core.ext.netcap.d dVar = new com.tencent.qmethod.pandoraex.core.ext.netcap.d();
                return (T) httpClient.execute(handleRequest(httpUriRequest, dVar), com.tencent.qmethod.pandoraex.core.ext.netcap.g.a(responseHandler, dVar), httpContext);
            }
        } catch (Throwable th5) {
            com.tencent.qmethod.pandoraex.core.o.b(TAG, "", th5);
        }
        return (T) httpClient.execute(httpUriRequest, responseHandler, httpContext);
    }

    public static <T> T execute(Object obj, HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        if (!(obj instanceof HttpClient)) {
            return (T) com.tencent.qmethod.pandoraex.core.t.b(obj, "execute", new Class[]{HttpUriRequest.class, ResponseHandler.class}, httpUriRequest, responseHandler);
        }
        HttpClient httpClient = (HttpClient) obj;
        try {
            if (com.tencent.qmethod.pandoraex.core.ext.netcap.k.k(httpUriRequest.getURI().getHost(), 1)) {
                com.tencent.qmethod.pandoraex.core.ext.netcap.d dVar = new com.tencent.qmethod.pandoraex.core.ext.netcap.d();
                return (T) httpClient.execute(handleRequest(httpUriRequest, dVar), com.tencent.qmethod.pandoraex.core.ext.netcap.g.a(responseHandler, dVar));
            }
        } catch (Throwable th5) {
            com.tencent.qmethod.pandoraex.core.o.b(TAG, "", th5);
        }
        return (T) httpClient.execute(httpUriRequest, responseHandler);
    }
}

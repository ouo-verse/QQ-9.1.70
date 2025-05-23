package org.apache.httpcore.protocol;

import java.io.IOException;
import org.apache.httpcore.HttpClientConnection;
import org.apache.httpcore.HttpEntityEnclosingRequest;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.HttpVersion;
import org.apache.httpcore.ProtocolException;
import org.apache.httpcore.ProtocolVersion;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.util.Args;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class HttpRequestExecutor {
    public static final int DEFAULT_WAIT_FOR_CONTINUE = 3000;
    private final int waitForContinue;

    public HttpRequestExecutor(int i3) {
        this.waitForContinue = Args.positive(i3, "Wait for continue time");
    }

    private static void closeConnection(HttpClientConnection httpClientConnection) {
        try {
            httpClientConnection.close();
        } catch (IOException unused) {
        }
    }

    protected boolean canResponseHaveBody(HttpRequest httpRequest, HttpResponse httpResponse) {
        int statusCode;
        if ("HEAD".equalsIgnoreCase(httpRequest.getRequestLine().getMethod()) || (statusCode = httpResponse.getStatusLine().getStatusCode()) < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) {
            return false;
        }
        return true;
    }

    protected HttpResponse doReceiveResponse(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpClientConnection, "Client connection");
        Args.notNull(httpContext, "HTTP context");
        HttpResponse httpResponse = null;
        int i3 = 0;
        while (true) {
            if (httpResponse != null && i3 >= 200) {
                return httpResponse;
            }
            httpResponse = httpClientConnection.receiveResponseHeader();
            i3 = httpResponse.getStatusLine().getStatusCode();
            if (i3 >= 100) {
                if (canResponseHaveBody(httpRequest, httpResponse)) {
                    httpClientConnection.receiveResponseEntity(httpResponse);
                }
            } else {
                throw new ProtocolException("Invalid response: " + httpResponse.getStatusLine());
            }
        }
    }

    protected HttpResponse doSendRequest(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) throws IOException, HttpException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpClientConnection, "Client connection");
        Args.notNull(httpContext, "HTTP context");
        httpContext.setAttribute("http.connection", httpClientConnection);
        httpContext.setAttribute("http.request_sent", Boolean.FALSE);
        httpClientConnection.sendRequestHeader(httpRequest);
        HttpResponse httpResponse = null;
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            ProtocolVersion protocolVersion = httpRequest.getRequestLine().getProtocolVersion();
            HttpEntityEnclosingRequest httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpRequest;
            boolean z16 = true;
            if (httpEntityEnclosingRequest.expectContinue() && !protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                httpClientConnection.flush();
                if (httpClientConnection.isResponseAvailable(this.waitForContinue)) {
                    HttpResponse receiveResponseHeader = httpClientConnection.receiveResponseHeader();
                    if (canResponseHaveBody(httpRequest, receiveResponseHeader)) {
                        httpClientConnection.receiveResponseEntity(receiveResponseHeader);
                    }
                    int statusCode = receiveResponseHeader.getStatusLine().getStatusCode();
                    if (statusCode < 200) {
                        if (statusCode != 100) {
                            throw new ProtocolException("Unexpected response: " + receiveResponseHeader.getStatusLine());
                        }
                    } else {
                        z16 = false;
                        httpResponse = receiveResponseHeader;
                    }
                }
            }
            if (z16) {
                httpClientConnection.sendRequestEntity(httpEntityEnclosingRequest);
            }
        }
        httpClientConnection.flush();
        httpContext.setAttribute("http.request_sent", Boolean.TRUE);
        return httpResponse;
    }

    public HttpResponse execute(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) throws IOException, HttpException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpClientConnection, "Client connection");
        Args.notNull(httpContext, "HTTP context");
        try {
            HttpResponse doSendRequest = doSendRequest(httpRequest, httpClientConnection, httpContext);
            if (doSendRequest == null) {
                return doReceiveResponse(httpRequest, httpClientConnection, httpContext);
            }
            return doSendRequest;
        } catch (IOException e16) {
            closeConnection(httpClientConnection);
            throw e16;
        } catch (RuntimeException e17) {
            closeConnection(httpClientConnection);
            throw e17;
        } catch (HttpException e18) {
            closeConnection(httpClientConnection);
            throw e18;
        }
    }

    public void postProcess(HttpResponse httpResponse, HttpProcessor httpProcessor, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        Args.notNull(httpProcessor, "HTTP processor");
        Args.notNull(httpContext, "HTTP context");
        httpContext.setAttribute("http.response", httpResponse);
        httpProcessor.process(httpResponse, httpContext);
    }

    public void preProcess(HttpRequest httpRequest, HttpProcessor httpProcessor, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpProcessor, "HTTP processor");
        Args.notNull(httpContext, "HTTP context");
        httpContext.setAttribute("http.request", httpRequest);
        httpProcessor.process(httpRequest, httpContext);
    }

    public HttpRequestExecutor() {
        this(3000);
    }
}

package org.apache.httpcore.protocol;

import java.io.IOException;
import org.apache.httpcore.ConnectionReuseStrategy;
import org.apache.httpcore.HttpEntityEnclosingRequest;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.HttpResponseFactory;
import org.apache.httpcore.HttpServerConnection;
import org.apache.httpcore.HttpVersion;
import org.apache.httpcore.MethodNotSupportedException;
import org.apache.httpcore.ProtocolException;
import org.apache.httpcore.UnsupportedHttpVersionException;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.entity.ByteArrayEntity;
import org.apache.httpcore.impl.DefaultConnectionReuseStrategy;
import org.apache.httpcore.impl.DefaultHttpResponseFactory;
import org.apache.httpcore.params.HttpParams;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.EncodingUtils;
import org.apache.httpcore.util.EntityUtils;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes29.dex */
public class HttpService {
    private volatile ConnectionReuseStrategy connStrategy;
    private volatile HttpExpectationVerifier expectationVerifier;
    private volatile HttpRequestHandlerMapper handlerMapper;
    private volatile HttpParams params;
    private volatile HttpProcessor processor;
    private volatile HttpResponseFactory responseFactory;

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes29.dex */
    private static class HttpRequestHandlerResolverAdapter implements HttpRequestHandlerMapper {
        private final HttpRequestHandlerResolver resolver;

        public HttpRequestHandlerResolverAdapter(HttpRequestHandlerResolver httpRequestHandlerResolver) {
            this.resolver = httpRequestHandlerResolver;
        }

        @Override // org.apache.httpcore.protocol.HttpRequestHandlerMapper
        public HttpRequestHandler lookup(HttpRequest httpRequest) {
            return this.resolver.lookup(httpRequest.getRequestLine().getUri());
        }
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpExpectationVerifier httpExpectationVerifier, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver), httpExpectationVerifier);
        this.params = httpParams;
    }

    private boolean canResponseHaveBody(HttpRequest httpRequest, HttpResponse httpResponse) {
        int statusCode;
        if ((httpRequest != null && "HEAD".equalsIgnoreCase(httpRequest.getRequestLine().getMethod())) || (statusCode = httpResponse.getStatusLine().getStatusCode()) < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) {
            return false;
        }
        return true;
    }

    protected void doService(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        HttpRequestHandler httpRequestHandler;
        if (this.handlerMapper != null) {
            httpRequestHandler = this.handlerMapper.lookup(httpRequest);
        } else {
            httpRequestHandler = null;
        }
        if (httpRequestHandler != null) {
            httpRequestHandler.handle(httpRequest, httpResponse, httpContext);
        } else {
            httpResponse.setStatusCode(501);
        }
    }

    @Deprecated
    public HttpParams getParams() {
        return this.params;
    }

    protected void handleException(HttpException httpException, HttpResponse httpResponse) {
        if (httpException instanceof MethodNotSupportedException) {
            httpResponse.setStatusCode(501);
        } else if (httpException instanceof UnsupportedHttpVersionException) {
            httpResponse.setStatusCode(505);
        } else if (httpException instanceof ProtocolException) {
            httpResponse.setStatusCode(400);
        } else {
            httpResponse.setStatusCode(500);
        }
        String message = httpException.getMessage();
        if (message == null) {
            message = httpException.toString();
        }
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(EncodingUtils.getAsciiBytes(message));
        byteArrayEntity.setContentType("text/plain; charset=US-ASCII");
        httpResponse.setEntity(byteArrayEntity);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleRequest(HttpServerConnection httpServerConnection, HttpContext httpContext) throws IOException, HttpException {
        HttpRequest httpRequest;
        HttpException e16;
        httpContext.setAttribute("http.connection", httpServerConnection);
        HttpResponse httpResponse = null;
        try {
            httpRequest = httpServerConnection.receiveRequestHeader();
        } catch (HttpException e17) {
            httpRequest = null;
            e16 = e17;
        }
        try {
            if (httpRequest instanceof HttpEntityEnclosingRequest) {
                if (((HttpEntityEnclosingRequest) httpRequest).expectContinue()) {
                    HttpResponse newHttpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 100, httpContext);
                    if (this.expectationVerifier != null) {
                        try {
                            this.expectationVerifier.verify(httpRequest, newHttpResponse, httpContext);
                        } catch (HttpException e18) {
                            HttpResponse newHttpResponse2 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, httpContext);
                            handleException(e18, newHttpResponse2);
                            newHttpResponse = newHttpResponse2;
                        }
                    }
                    if (newHttpResponse.getStatusLine().getStatusCode() < 200) {
                        httpServerConnection.sendResponseHeader(newHttpResponse);
                        httpServerConnection.flush();
                        httpServerConnection.receiveRequestEntity((HttpEntityEnclosingRequest) httpRequest);
                    } else {
                        httpResponse = newHttpResponse;
                    }
                } else {
                    httpServerConnection.receiveRequestEntity((HttpEntityEnclosingRequest) httpRequest);
                }
            }
            httpContext.setAttribute("http.request", httpRequest);
            if (httpResponse == null) {
                httpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 200, httpContext);
                this.processor.process(httpRequest, httpContext);
                doService(httpRequest, httpResponse, httpContext);
            }
            if (httpRequest instanceof HttpEntityEnclosingRequest) {
                EntityUtils.consume(((HttpEntityEnclosingRequest) httpRequest).getEntity());
            }
        } catch (HttpException e19) {
            e16 = e19;
            HttpResponse newHttpResponse3 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, httpContext);
            handleException(e16, newHttpResponse3);
            httpResponse = newHttpResponse3;
            httpContext.setAttribute("http.response", httpResponse);
            this.processor.process(httpResponse, httpContext);
            httpServerConnection.sendResponseHeader(httpResponse);
            if (canResponseHaveBody(httpRequest, httpResponse)) {
            }
            httpServerConnection.flush();
            if (this.connStrategy.keepAlive(httpResponse, httpContext)) {
            }
        }
        httpContext.setAttribute("http.response", httpResponse);
        this.processor.process(httpResponse, httpContext);
        httpServerConnection.sendResponseHeader(httpResponse);
        if (canResponseHaveBody(httpRequest, httpResponse)) {
            httpServerConnection.sendResponseEntity(httpResponse);
        }
        httpServerConnection.flush();
        if (this.connStrategy.keepAlive(httpResponse, httpContext)) {
            httpServerConnection.close();
        }
    }

    @Deprecated
    public void setConnReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        this.connStrategy = connectionReuseStrategy;
    }

    @Deprecated
    public void setExpectationVerifier(HttpExpectationVerifier httpExpectationVerifier) {
        this.expectationVerifier = httpExpectationVerifier;
    }

    @Deprecated
    public void setHandlerResolver(HttpRequestHandlerResolver httpRequestHandlerResolver) {
        this.handlerMapper = new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver);
    }

    @Deprecated
    public void setHttpProcessor(HttpProcessor httpProcessor) {
        Args.notNull(httpProcessor, "HTTP processor");
        this.processor = httpProcessor;
    }

    @Deprecated
    public void setParams(HttpParams httpParams) {
        this.params = httpParams;
    }

    @Deprecated
    public void setResponseFactory(HttpResponseFactory httpResponseFactory) {
        Args.notNull(httpResponseFactory, "Response factory");
        this.responseFactory = httpResponseFactory;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver), (HttpExpectationVerifier) null);
        this.params = httpParams;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        setHttpProcessor(httpProcessor);
        setConnReuseStrategy(connectionReuseStrategy);
        setResponseFactory(httpResponseFactory);
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerMapper httpRequestHandlerMapper, HttpExpectationVerifier httpExpectationVerifier) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        this.processor = (HttpProcessor) Args.notNull(httpProcessor, "HTTP processor");
        this.connStrategy = connectionReuseStrategy == null ? DefaultConnectionReuseStrategy.INSTANCE : connectionReuseStrategy;
        this.responseFactory = httpResponseFactory == null ? DefaultHttpResponseFactory.INSTANCE : httpResponseFactory;
        this.handlerMapper = httpRequestHandlerMapper;
        this.expectationVerifier = httpExpectationVerifier;
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, httpRequestHandlerMapper, (HttpExpectationVerifier) null);
    }

    public HttpService(HttpProcessor httpProcessor, HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this(httpProcessor, (ConnectionReuseStrategy) null, (HttpResponseFactory) null, httpRequestHandlerMapper, (HttpExpectationVerifier) null);
    }
}

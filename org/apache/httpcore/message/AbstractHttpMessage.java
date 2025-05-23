package org.apache.httpcore.message;

import org.apache.httpcore.Header;
import org.apache.httpcore.HeaderIterator;
import org.apache.httpcore.HttpMessage;
import org.apache.httpcore.params.BasicHttpParams;
import org.apache.httpcore.params.HttpParams;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class AbstractHttpMessage implements HttpMessage {
    protected HeaderGroup headergroup;

    @Deprecated
    protected HttpParams params;

    @Deprecated
    protected AbstractHttpMessage(HttpParams httpParams) {
        this.headergroup = new HeaderGroup();
        this.params = httpParams;
    }

    @Override // org.apache.httpcore.HttpMessage
    public void addHeader(Header header) {
        this.headergroup.addHeader(header);
    }

    @Override // org.apache.httpcore.HttpMessage
    public boolean containsHeader(String str) {
        return this.headergroup.containsHeader(str);
    }

    @Override // org.apache.httpcore.HttpMessage
    public Header[] getAllHeaders() {
        return this.headergroup.getAllHeaders();
    }

    @Override // org.apache.httpcore.HttpMessage
    public Header getFirstHeader(String str) {
        return this.headergroup.getFirstHeader(str);
    }

    @Override // org.apache.httpcore.HttpMessage
    public Header[] getHeaders(String str) {
        return this.headergroup.getHeaders(str);
    }

    @Override // org.apache.httpcore.HttpMessage
    public Header getLastHeader(String str) {
        return this.headergroup.getLastHeader(str);
    }

    @Override // org.apache.httpcore.HttpMessage
    @Deprecated
    public HttpParams getParams() {
        if (this.params == null) {
            this.params = new BasicHttpParams();
        }
        return this.params;
    }

    @Override // org.apache.httpcore.HttpMessage
    public HeaderIterator headerIterator() {
        return this.headergroup.iterator();
    }

    @Override // org.apache.httpcore.HttpMessage
    public void removeHeader(Header header) {
        this.headergroup.removeHeader(header);
    }

    @Override // org.apache.httpcore.HttpMessage
    public void removeHeaders(String str) {
        if (str == null) {
            return;
        }
        HeaderIterator it = this.headergroup.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.nextHeader().getName())) {
                it.remove();
            }
        }
    }

    @Override // org.apache.httpcore.HttpMessage
    public void setHeader(Header header) {
        this.headergroup.updateHeader(header);
    }

    @Override // org.apache.httpcore.HttpMessage
    public void setHeaders(Header[] headerArr) {
        this.headergroup.setHeaders(headerArr);
    }

    @Override // org.apache.httpcore.HttpMessage
    @Deprecated
    public void setParams(HttpParams httpParams) {
        this.params = (HttpParams) Args.notNull(httpParams, "HTTP parameters");
    }

    @Override // org.apache.httpcore.HttpMessage
    public void addHeader(String str, String str2) {
        Args.notNull(str, "Header name");
        this.headergroup.addHeader(new BasicHeader(str, str2));
    }

    @Override // org.apache.httpcore.HttpMessage
    public HeaderIterator headerIterator(String str) {
        return this.headergroup.iterator(str);
    }

    @Override // org.apache.httpcore.HttpMessage
    public void setHeader(String str, String str2) {
        Args.notNull(str, "Header name");
        this.headergroup.updateHeader(new BasicHeader(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractHttpMessage() {
        this(null);
    }
}

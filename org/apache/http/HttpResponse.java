package org.apache.http;

import java.util.Locale;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HttpResponse extends HttpMessage {
    HttpEntity getEntity();

    Locale getLocale();

    StatusLine getStatusLine();

    void setEntity(HttpEntity httpEntity);

    void setLocale(Locale locale);

    void setReasonPhrase(String str) throws IllegalStateException;

    void setStatusCode(int i3) throws IllegalStateException;

    void setStatusLine(ProtocolVersion protocolVersion, int i3);

    void setStatusLine(ProtocolVersion protocolVersion, int i3, String str);

    void setStatusLine(StatusLine statusLine);
}

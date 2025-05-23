package org.apache.http;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HttpEntityEnclosingRequest extends HttpRequest {
    boolean expectContinue();

    HttpEntity getEntity();

    void setEntity(HttpEntity httpEntity);
}

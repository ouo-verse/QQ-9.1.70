package com.tencent.mobileqq.utils.httputils;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface IHttpCommunicatorListener {
    void decode(HttpMsg httpMsg, HttpMsg httpMsg2);

    void handleError(HttpMsg httpMsg, HttpMsg httpMsg2);

    void handleRedirect(String str);

    boolean statusChanged(HttpMsg httpMsg, HttpMsg httpMsg2, int i3);
}

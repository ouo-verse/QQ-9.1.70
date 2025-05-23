package com.tencent.qqnt.http.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface e {
    public static final IPatchRedirector $redirector_ = null;

    void onBodyCompleted(b bVar);

    void onDnsEnd(b bVar);

    void onDnsStart(b bVar);

    void onGetHeader(b bVar, f fVar);

    void onResponseURL(URL url);

    void onStart(b bVar);
}

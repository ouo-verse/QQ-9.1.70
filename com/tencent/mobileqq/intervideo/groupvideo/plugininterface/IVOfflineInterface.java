package com.tencent.mobileqq.intervideo.groupvideo.plugininterface;

import android.webkit.WebResourceResponse;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface IVOfflineInterface {
    void asyncLoadUrl(String str);

    boolean isOfflineUrl(String str);

    WebResourceResponse shouldInterceptRequest(String str);
}

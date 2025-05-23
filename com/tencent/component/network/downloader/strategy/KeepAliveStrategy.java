package com.tencent.component.network.downloader.strategy;

import com.tencent.component.network.utils.http.HttpUtil;
import org.apache.http.HttpRequest;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface KeepAliveStrategy {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public enum KeepAlive {
        ENABLE,
        DISABLE,
        IGNORE
    }

    KeepAlive keepAlive(String str, HttpRequest httpRequest, HttpUtil.RequestOptions requestOptions);

    boolean supportKeepAlive(String str);
}

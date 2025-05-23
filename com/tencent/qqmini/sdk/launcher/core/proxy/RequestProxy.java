package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes23.dex */
public abstract class RequestProxy {
    private static AtomicInteger sRequestId = new AtomicInteger();

    /* loaded from: classes23.dex */
    public interface RequestListener {
        void onRequestFailed(int i3, String str);

        void onRequestHeadersReceived(int i3, Map<String, List<String>> map);

        void onRequestSucceed(int i3, byte[] bArr, Map<String, List<String>> map);
    }

    public static int getRequestSocketId() {
        return sRequestId.getAndIncrement();
    }

    public abstract void abort(String str);

    public abstract boolean request(String str, byte[] bArr, Map<String, String> map, String str2, int i3, RequestListener requestListener);
}

package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.List;
import java.util.Map;

/* loaded from: classes23.dex */
public abstract class UploaderProxy {

    /* loaded from: classes23.dex */
    public interface UploadListener {
        void onUploadFailed(int i3, String str);

        void onUploadHeadersReceived(int i3, Map<String, List<String>> map);

        void onUploadProgress(float f16, long j3, long j16);

        void onUploadSucceed(int i3, byte[] bArr, Map<String, List<String>> map);
    }

    public abstract void abort(String str);

    public abstract boolean upload(String str, Map<String, String> map, String str2, String str3, String str4, Map<String, String> map2, int i3, UploadListener uploadListener);
}

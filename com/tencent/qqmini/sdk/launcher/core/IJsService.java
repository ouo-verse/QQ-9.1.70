package com.tencent.qqmini.sdk.launcher.core;

import android.webkit.ValueCallback;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IJsService {
    int createNativeBuffer(byte[] bArr, long j3, long j16);

    void evaluateCallbackJs(int i3, String str);

    void evaluateJs(String str, ValueCallback valueCallback);

    void evaluateSubscribeJS(String str, String str2, int i3);

    byte[] getNativeBuffer(int i3);
}

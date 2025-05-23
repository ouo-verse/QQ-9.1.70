package com.tencent.qqmini.miniapp.util;

import com.tencent.smtt.sdk.ValueCallback;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AppBrandUtil {
    public static ValueCallback convertValueCallback(final android.webkit.ValueCallback valueCallback) {
        if (valueCallback != null) {
            return new ValueCallback() { // from class: com.tencent.qqmini.miniapp.util.AppBrandUtil.1
                @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                public void onReceiveValue(Object obj) {
                    valueCallback.onReceiveValue(obj);
                }
            };
        }
        return null;
    }
}

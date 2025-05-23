package com.tencent.imsdk.common;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMValueCallback;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class IMCallback<T> {
    protected V2TIMCallback callback;
    protected V2TIMValueCallback<T> valueCallback;

    /* JADX INFO: Access modifiers changed from: protected */
    public IMCallback(V2TIMCallback v2TIMCallback) {
        this.callback = v2TIMCallback;
    }

    public void fail(final int i3, final String str) {
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.common.IMCallback.2
            @Override // java.lang.Runnable
            public void run() {
                IMCallback iMCallback = IMCallback.this;
                V2TIMCallback v2TIMCallback = iMCallback.callback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i3, str);
                    return;
                }
                V2TIMValueCallback<T> v2TIMValueCallback = iMCallback.valueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i3, str);
                }
            }
        });
    }

    public void success(final T t16) {
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.common.IMCallback.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                IMCallback iMCallback = IMCallback.this;
                V2TIMCallback v2TIMCallback = iMCallback.callback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                    return;
                }
                V2TIMValueCallback<T> v2TIMValueCallback = iMCallback.valueCallback;
                if (v2TIMValueCallback != 0) {
                    v2TIMValueCallback.onSuccess(t16);
                }
            }
        });
    }

    public void fail(final int i3, final String str, T t16) {
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.common.IMCallback.3
            @Override // java.lang.Runnable
            public void run() {
                IMCallback iMCallback = IMCallback.this;
                V2TIMCallback v2TIMCallback = iMCallback.callback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i3, str);
                    return;
                }
                V2TIMValueCallback<T> v2TIMValueCallback = iMCallback.valueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i3, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMCallback(V2TIMValueCallback<T> v2TIMValueCallback) {
        this.valueCallback = v2TIMValueCallback;
    }
}

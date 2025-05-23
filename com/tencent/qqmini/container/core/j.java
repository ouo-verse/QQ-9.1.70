package com.tencent.qqmini.container.core;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.qqmini.miniapp.core.service.ServiceEventListener;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class j implements IJsService {

    /* renamed from: d, reason: collision with root package name */
    protected IMiniAppContext f346121d;

    public j(IMiniAppContext iMiniAppContext) {
        this.f346121d = iMiniAppContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(ValueCallback valueCallback, Object obj) {
        if (valueCallback != null) {
            valueCallback.onReceiveValue(obj);
        }
    }

    public abstract void b();

    protected abstract void c(String str, String str2, ValueCallback valueCallback);

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public int createNativeBuffer(byte[] bArr, long j3, long j16) {
        return 0;
    }

    public void d(String str, String str2) {
        e(str, str2, null);
    }

    public void e(String str, String str2, final ValueCallback valueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (valueCallback != null) {
                valueCallback.onReceiveValue("");
                return;
            }
            return;
        }
        c(str, str2, new ValueCallback() { // from class: com.tencent.qqmini.container.core.i
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                j.g(valueCallback, obj);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public final void evaluateCallbackJs(int i3, String str) {
        d(eu3.c.c(i3, str), null);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public final void evaluateJs(String str, ValueCallback valueCallback) {
        e(str, null, valueCallback);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public final void evaluateSubscribeJS(String str, String str2, int i3) {
        d(eu3.c.e(str, str2, i3), null);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public byte[] getNativeBuffer(int i3) {
        return new byte[0];
    }

    public abstract void h(ServiceEventListener serviceEventListener);

    public void f() {
    }
}

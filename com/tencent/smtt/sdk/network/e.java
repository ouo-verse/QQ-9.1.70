package com.tencent.smtt.sdk.network;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
class e extends IOException {
    public e(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (InterceptConfig.getPrintInterceptExceptionStackTrace()) {
            super.printStackTrace();
        }
    }
}

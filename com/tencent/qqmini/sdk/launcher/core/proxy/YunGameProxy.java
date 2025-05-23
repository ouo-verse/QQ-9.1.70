package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

/* loaded from: classes23.dex */
public abstract class YunGameProxy {
    public Boolean canUsePag() {
        return Boolean.TRUE;
    }

    public abstract void init();

    public abstract void unInit();

    public void getYunGameAuthInfo(AsyncResult asyncResult) {
    }

    public void fastLogin(MiniAppInfo miniAppInfo, AsyncResult asyncResult) {
    }

    public void getDynamicPath(Context context, AsyncResult asyncResult) {
    }

    public void loadYunGameSoPath(Context context, AsyncResult asyncResult) {
    }
}

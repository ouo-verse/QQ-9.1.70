package com.tencent.liteav.videoproducer2.capture;

import android.content.Context;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.rtmp.video.BaseBridge;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a implements BaseBridge.BaseBridgeCallback {
    @Override // com.tencent.rtmp.video.BaseBridge.BaseBridgeCallback
    public final Context getAppContext() {
        return ContextUtils.getApplicationContext();
    }

    @Override // com.tencent.rtmp.video.BaseBridge.BaseBridgeCallback
    public final int getSystemOSVersion() {
        return LiteavSystemInfo.getSystemOSVersionInt();
    }

    @Override // com.tencent.rtmp.video.BaseBridge.BaseBridgeCallback
    public final void printLog(String str, String str2) {
        LiteavLog.i(str, str2);
    }
}

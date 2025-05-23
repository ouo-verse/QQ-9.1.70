package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import com.tencent.mm.opensdk.utils.Log;

/* loaded from: classes9.dex */
public class WXAPIFactory {
    private static final String TAG = "MicroMsg.PaySdk.WXFactory";

    WXAPIFactory() {
        throw new RuntimeException(WXAPIFactory.class.getSimpleName() + " should not be instantiated");
    }

    public static IWXAPI createWXAPI(Context context, String str) {
        return createWXAPI(context, str, true);
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z16) {
        Log.d(TAG, "createWXAPI, appId = " + str + ", checkSignature = " + z16);
        return createWXAPI(context, str, z16, 2);
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z16, int i3) {
        Log.d(TAG, "createWXAPI, appId = " + str + ", checkSignature = " + z16 + ", launchMode = " + i3);
        return new WXApiImplV10(context, str, z16, i3);
    }
}

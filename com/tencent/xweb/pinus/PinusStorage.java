package com.tencent.xweb.pinus;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.tq.b;
import com.tencent.xweb.internal.ConstValue;
import java.util.Map;

/* loaded from: classes27.dex */
public class PinusStorage implements b {
    public static final String TAG = "PinusStorage";

    @Override // com.tencent.luggage.wxa.tq.b
    public void deleteOrigin(String str) {
        x0.d(TAG, "delete origin(" + str + ") result is " + PinusStandAloneChannel.getInstance().invokeRuntimeChannel(ConstValue.INVOKE_RUNTIME_ID_DELETE_ORIGIN, new Object[]{str}));
    }

    public void deleteAllData() {
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
    }

    public void setQuotaForOrigin(String str, long j3) {
    }
}

package com.tenpay.api;

import android.content.Context;
import android.os.ResultReceiver;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IApiFinger extends IApiBase {
    public static final String LOGIC = "com.tenpay.impl.ApiFingerImpl";

    void closeFingerPay(Context context, String str);

    void initFingerASK(Context context, HashMap<String, String> hashMap, ResultReceiver resultReceiver);
}

package com.tenpay.api;

import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IApiInterface extends IApiBase {
    public static final String LOGIC = "com.tenpay.impl.ApiInterfaceImpl";

    void closeTenpay(Context context);

    void freshQrcode(Context context, Map<String, String> map, boolean z16, ResultReceiver resultReceiver);

    void getTenpayInfo(Context context, String str, ResultReceiver resultReceiver);

    void gotoPay(Context context, Bundle bundle, ResultReceiver resultReceiver);

    void gotoView(Context context, String str, String str2, String str3, Bundle bundle, ResultReceiver resultReceiver);

    void gotoView(Context context, String str, String str2, String str3, Bundle bundle, ResultReceiver resultReceiver, Service service);

    void preConnect(Context context, String str);

    void preNetLink(Context context, JSONObject jSONObject, ResultReceiver resultReceiver);

    void pregetQrcode(Context context, Map<String, String> map, ResultReceiver resultReceiver);

    void requestData(Context context, String str, String str2, Map<String, String> map, ResultReceiver resultReceiver);
}

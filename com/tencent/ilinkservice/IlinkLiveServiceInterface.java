package com.tencent.ilinkservice;

import android.content.Intent;
import com.tencent.luggage.wxa.t0.a;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IlinkLiveServiceInterface {
    void autoLogin();

    boolean canAutoLogin();

    void initLive(String str);

    void loadLiveWebView(WebView webView, String str);

    void onReceiveActivityResult(int i3, int i16, Intent intent);

    void onReceiveRequestPermissionsResult(int i3, String[] strArr, int[] iArr);

    void setCallback(a aVar);

    void thirdAppLogin(byte[] bArr);

    void uninitLive();
}

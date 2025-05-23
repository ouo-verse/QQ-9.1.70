package com.tencent.midas.jsbridge;

import android.app.Activity;
import com.tencent.midas.api.request.APMidasBaseRequest;

/* loaded from: classes9.dex */
public interface IAPWebPage {
    void initHead(Activity activity, String str, String str2);

    void initUI(Activity activity);

    void loadUrl(String str);

    void toPureH5Pay(Activity activity, APMidasBaseRequest aPMidasBaseRequest);

    void updateWebViewSize(String str);
}

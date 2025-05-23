package com.tencent.gdtad.inject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface IGdtWebView {
    void init(Context context, Activity activity, Intent intent, AppInterface appInterface, IGdtWebViewListener iGdtWebViewListener);

    void onConstruct(Bundle bundle, AppInterface appInterface, Intent intent);

    void onCreate(Bundle bundle);

    void onDestroy();

    void onPause();

    void onResume();

    void setWebView(WebView webView);
}

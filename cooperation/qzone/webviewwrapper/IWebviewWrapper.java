package cooperation.qzone.webviewwrapper;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface IWebviewWrapper {
    void callJs(String str);

    WebView getWebview();

    void onDestroy();

    void onDetach();

    void onInit(Activity activity, Intent intent, String str, IWebviewListener iWebviewListener);

    void onPause();

    void onResume();

    void onWebViewReady(Intent intent, boolean z16);

    void preInit();

    void setOnWebviewTouchListener(View.OnTouchListener onTouchListener);
}

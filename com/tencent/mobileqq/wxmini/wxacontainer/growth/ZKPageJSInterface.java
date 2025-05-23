package com.tencent.mobileqq.wxmini.wxacontainer.growth;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import com.tencent.mobileqq.wxmini.wxacontainer.growth.ZKPageJSInterface;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes35.dex */
public class ZKPageJSInterface {
    private static final String TAG = "ZKPageJSInterface";
    private final Activity activity;

    public ZKPageJSInterface(Activity activity) {
        this.activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closePageRes$0() {
        if (this.activity.isFinishing()) {
            return;
        }
        this.activity.finish();
    }

    @JavascriptInterface
    public void closePageRes(boolean z16) {
        QLog.i(TAG, 1, "closePageRes");
        Activity activity = this.activity;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: lb3.j
                @Override // java.lang.Runnable
                public final void run() {
                    ZKPageJSInterface.this.lambda$closePageRes$0();
                }
            });
        }
    }
}

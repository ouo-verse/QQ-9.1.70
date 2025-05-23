package com.tencent.mobileqq.flashtransfer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes12.dex */
public class FlashTransferWebNavigationItem implements com.tencent.mobileqq.webview.swift.d {
    static IPatchRedirector $redirector_;

    public FlashTransferWebNavigationItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        String path = parse.getPath();
        if (host == null) {
            return false;
        }
        if ((!host.equals("qfile.qq.com") && !host.equals("test.qfile.qq.com")) || path == null || path.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.d
    public boolean navigateToAnotherActivity(Intent intent, Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, intent, activity, str)).booleanValue();
        }
        if (!a(str)) {
            return false;
        }
        String stringExtra = intent.getStringExtra(QQWinkConstants.KEY_PREVIOUS_ACTIVITY);
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = intent.getStringExtra("SourceActivityName");
        }
        Intent intent2 = new Intent("com.tencent.mqq.filetransfer.jumpaction");
        intent2.putExtra("url", str);
        intent2.putExtra("source", stringExtra);
        intent2.setPackage(BaseApplication.getContext().getPackageName());
        activity.sendBroadcast(intent2);
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.d
    public boolean needSwitchFragment(Intent intent, Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, intent, activity, str)).booleanValue();
        }
        return false;
    }
}

package com.tencent.mobileqq.webview.js;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static int a(int i3, QQVasUpdateBusiness<?> qQVasUpdateBusiness, IDownLoadListener iDownLoadListener) {
        if (!qQVasUpdateBusiness.isFileExists(i3)) {
            if (iDownLoadListener != null) {
                qQVasUpdateBusiness.addDownLoadListener(i3, iDownLoadListener);
            }
            qQVasUpdateBusiness.startDownload(i3);
            return 2;
        }
        return 3;
    }
}

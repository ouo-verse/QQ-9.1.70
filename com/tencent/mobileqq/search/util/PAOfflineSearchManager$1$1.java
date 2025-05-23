package com.tencent.mobileqq.search.util;

import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes18.dex */
class PAOfflineSearchManager$1$1 implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        String z16 = HtmlOffline.z(HippyQQConstants.HIPPY_BID);
        if (z16 != null && !TextUtils.equals(z16, "")) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("callback get current ver:");
                sb5.append(z16);
                sb5.append(", local ver:");
                throw null;
            }
            throw null;
        }
    }
}

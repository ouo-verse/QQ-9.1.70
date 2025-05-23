package com.tencent.mobileqq.wxmini.servlet;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes35.dex */
public class WxMiniAppObserver implements BusinessObserver {
    @Override // mqq.observer.BusinessObserver
    public void onReceive(final int i3, final boolean z16, final Bundle bundle) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wxmini.servlet.WxMiniAppObserver.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WxMiniAppObserver.this.a(i3, z16, bundle);
                } catch (Throwable th5) {
                    QLog.e("WxAppObserver", 1, "MiniAppObserver onReceive exception!", th5);
                }
            }
        }, 16, null, false);
    }

    public void a(int i3, boolean z16, Bundle bundle) {
        if (bundle == null) {
            if (QLog.isColorLevel()) {
                QLog.d("WxAppObserver", 2, "onReceive data is null");
                return;
            }
            return;
        }
        int i16 = bundle.getInt(MiniAppCmdUtil.KEY_INDEX, -1);
        bundle.getString("key_appid");
        QLog.e("WxAppObserver", 2, "onReceive data is id " + i3);
        if (i3 == 1093) {
            c(i16, z16, bundle);
        }
    }

    public static String b(int i3) {
        if (1093 == i3) {
            return "MINI_APP_GET_TEENAGER_CONFIG";
        }
        return "default cmd";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i3, boolean z16, Bundle bundle) {
    }
}

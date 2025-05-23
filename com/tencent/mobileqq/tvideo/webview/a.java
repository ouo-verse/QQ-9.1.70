package com.tencent.mobileqq.tvideo.webview;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ProcessUtil;
import eipc.EIPCResult;
import java.io.Serializable;
import java.util.List;
import jy2.g;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a implements t43.a {
    private List<String> b() {
        Bundle bundle;
        if (g.B()) {
            QLog.d("TVideoBrowserCookieInjector", 4, "collectAuthPayCookies from main process");
            return g.b();
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("is_auth_pay_cookie", "1");
        EIPCResult b16 = yx2.a.b(bundle2);
        if (b16 != null && b16.code == 0 && (bundle = b16.data) != null) {
            Serializable serializable = bundle.getSerializable("collect_cookie");
            if (serializable instanceof List) {
                return (List) serializable;
            }
            return null;
        }
        return null;
    }

    private List<String> c(String str) {
        Bundle bundle;
        if (str.contains("film")) {
            return b();
        }
        if (g.B()) {
            QLog.d("TVideoBrowserCookieInjector", 4, "collectCookies from main process");
            return g.c();
        }
        EIPCResult b16 = yx2.a.b(null);
        if (b16 != null && b16.code == 0 && (bundle = b16.data) != null) {
            Serializable serializable = bundle.getSerializable("collect_cookie");
            if (serializable instanceof List) {
                QLog.d("TVideoBrowserCookieInjector", 4, "collectCookies by ipc");
                return (List) serializable;
            }
        }
        return null;
    }

    @Override // t43.a
    public List<String> a(String str) {
        QLog.d("TVideoBrowserCookieInjector", 4, "collectBusinessCookie:" + str + " \uff0cin process " + ProcessUtil.getCurrentProcessNameByApplication());
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.endsWith("fuli.v.qq.com/") && !str.endsWith("film.qq.com/") && !str.endsWith("film.video.qq.com/") && !str.endsWith("m.film.qq.com/")) {
            return null;
        }
        return c(str);
    }
}

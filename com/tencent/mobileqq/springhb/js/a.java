package com.tencent.mobileqq.springhb.js;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static InputStream f289322a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75333);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f289322a = null;
        }
    }

    public static void a() {
        InputStream inputStream = f289322a;
        if (inputStream != null) {
            try {
                inputStream.close();
                f289322a = null;
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    private static String b(String str) {
        if (StringUtil.isEmpty(str)) {
            return "";
        }
        if (str.lastIndexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) != -1) {
            return str.split("\\?")[0];
        }
        return str;
    }

    public static WebResourceResponse c(String str) {
        String n3 = com.tencent.mobileqq.qwallet.preload.a.n(b(str));
        if (QLog.isColorLevel()) {
            QLog.d("springHb_SpringHbUrlInterceptor", 2, "getWebResponse resPath: " + n3);
        }
        if (StringUtil.isEmpty(n3)) {
            return null;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(n3));
            f289322a = bufferedInputStream;
            return new WebResourceResponse("video/mp4", "UTF-8", bufferedInputStream);
        } catch (IOException e16) {
            QLog.e("springHb_SpringHbUrlInterceptor", 1, e16, new Object[0]);
            a();
            return null;
        }
    }
}

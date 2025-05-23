package com.tencent.mobileqq.debug;

import android.os.Environment;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.debug.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.Iterator;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
class CIOSubmitUtils$2 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f203467d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f203468e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f203469f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ String f203470h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ int f203471i;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ int f203472m;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            String str = Environment.getExternalStorageDirectory() + "/cio_mobile_qq";
            a.m(str);
            String str2 = "";
            if (MobileQQ.sProcessId == 1) {
                str2 = a.k();
            }
            a.i(str, this.f203467d, this.f203468e, this.f203469f, str2, this.f203470h, this.f203471i, this.f203472m);
            String str3 = a.n(str, MobileQQ.PACKAGE_NAME).second;
            JSONObject g16 = a.g(str2, str3, AppSetting.f99551k);
            StringBuffer stringBuffer = new StringBuffer(1024);
            Iterator keys = g16.keys();
            String str4 = (String) keys.next();
            String string = g16.getString(str4);
            stringBuffer.append(str4);
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(URLEncoder.encode(string, "UTF-8"));
            while (keys.hasNext()) {
                String str5 = (String) keys.next();
                String string2 = g16.getString(str5);
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                stringBuffer.append(str5);
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                stringBuffer.append(URLEncoder.encode(string2, "UTF-8"));
            }
            stringBuffer.append("&a=1");
            String str6 = "https://sngapm.qq.com/entrance/1/uploadFile/?" + stringBuffer.toString();
            if (QLog.isColorLevel()) {
                QLog.i("CIOSubmitUtils", 2, "[qcloud_report_cio] file url: " + str6);
            }
            a.C7483a c7483a = new a.C7483a(BaseApplication.getContext());
            c7483a.a(str3);
            c7483a.c(str6);
            c7483a.d(g16);
            String e16 = c7483a.e();
            if (QLog.isColorLevel()) {
                QLog.d("CIOSubmitUtils", 2, "submitCIOReportAsyncV2 result:" + e16);
            }
            a.d();
        } catch (Throwable th5) {
            QLog.e("CIOSubmitUtils", 1, "submitCIOReportAsyncV2 ERR", th5);
        }
    }
}

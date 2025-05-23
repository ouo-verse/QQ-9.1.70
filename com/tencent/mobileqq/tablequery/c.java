package com.tencent.mobileqq.tablequery;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.text.NumberFormat;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    TableQueryController f291387d;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a(a aVar) {
        String str;
        if (aVar == null || aVar.f291376b == null || (str = aVar.f291375a) == null) {
            return false;
        }
        if (str.equals("") && aVar.f291376b.equals("")) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01ff  */
    @Override // mqq.observer.BusinessObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        long j3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        try {
            j3 = bundle.getLong("ret");
        } catch (Exception e16) {
            QLog.d("TableQueryObserver", 1, "cast:0", e16);
            j3 = 0L;
        }
        bundle.getByteArray("msg");
        String string = bundle.getString("reqReportId");
        String string2 = bundle.getString("reportId");
        long j16 = bundle.getLong("pv");
        String string3 = bundle.getString("pv_day_earlier");
        String string4 = bundle.getString("pv_month_earlier");
        long j17 = bundle.getLong("uv");
        String string5 = bundle.getString("uv_day_earlier");
        String string6 = bundle.getString("uv_month_earlier");
        long j18 = j3;
        String string7 = bundle.getString("time");
        String string8 = bundle.getString("param");
        String str2 = "";
        try {
            String string9 = bundle.getString("description");
            if (string9 != null) {
                str = string7;
                try {
                    str2 = new String(string9.getBytes(), "UTF-8");
                } catch (Exception e17) {
                    e = e17;
                    QLog.e("TableQueryObserver", 1, "description decode failed" + e);
                    String str3 = str2;
                    if (this.f291387d == null) {
                    }
                    a aVar = new a();
                    aVar.f291376b = string2 + "\n" + string + "\n";
                    aVar.f291375a = string;
                    aVar.f291385k = str3;
                    aVar.f291384j = string8;
                    aVar.f291377c = NumberFormat.getNumberInstance().format(j16) + "\n\u540c\u6bd4:" + string3 + "\n\u73af\u6bd4:" + string4 + "\n";
                    aVar.f291378d = string3;
                    aVar.f291379e = string4;
                    aVar.f291380f = NumberFormat.getNumberInstance().format(j17) + "\n\u540c\u6bd4:" + string5 + "\n\u73af\u6bd4:" + string6 + "\n";
                    aVar.f291381g = string5;
                    aVar.f291382h = string6;
                    String str4 = str;
                    aVar.f291383i = str4;
                    QLog.d("TableQueryObserver", 1, "\u7f16\u7801All data: \n ret: " + j18 + "\n msg: \n reqReportId" + string + "\n reportId: " + string2 + "\n pv: " + j16 + "\n pv_day: " + string3 + "\n pv_month: " + string4 + "\n uv: " + j17 + "\n uv_day" + string5 + "\n uv_month: " + string6 + "\n time: " + str4 + "\n param: " + string8 + "\n description: " + str3 + "\n");
                    if (TableQueryController.f291348h) {
                    }
                }
            } else {
                str = string7;
            }
        } catch (Exception e18) {
            e = e18;
            str = string7;
        }
        String str32 = str2;
        if (this.f291387d == null) {
            this.f291387d = TableQueryController.g();
        }
        a aVar2 = new a();
        aVar2.f291376b = string2 + "\n" + string + "\n";
        aVar2.f291375a = string;
        aVar2.f291385k = str32;
        aVar2.f291384j = string8;
        aVar2.f291377c = NumberFormat.getNumberInstance().format(j16) + "\n\u540c\u6bd4:" + string3 + "\n\u73af\u6bd4:" + string4 + "\n";
        aVar2.f291378d = string3;
        aVar2.f291379e = string4;
        aVar2.f291380f = NumberFormat.getNumberInstance().format(j17) + "\n\u540c\u6bd4:" + string5 + "\n\u73af\u6bd4:" + string6 + "\n";
        aVar2.f291381g = string5;
        aVar2.f291382h = string6;
        String str42 = str;
        aVar2.f291383i = str42;
        QLog.d("TableQueryObserver", 1, "\u7f16\u7801All data: \n ret: " + j18 + "\n msg: \n reqReportId" + string + "\n reportId: " + string2 + "\n pv: " + j16 + "\n pv_day: " + string3 + "\n pv_month: " + string4 + "\n uv: " + j17 + "\n uv_day" + string5 + "\n uv_month: " + string6 + "\n time: " + str42 + "\n param: " + string8 + "\n description: " + str32 + "\n");
        if (TableQueryController.f291348h) {
            if (a(aVar2)) {
                this.f291387d.j(aVar2);
            }
        } else if (a(aVar2)) {
            this.f291387d.f(aVar2);
        }
    }
}
